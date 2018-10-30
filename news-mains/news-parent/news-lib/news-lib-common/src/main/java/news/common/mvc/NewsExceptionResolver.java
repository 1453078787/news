package news.common.mvc;

import news.common.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import tdh.thunder.common.utils.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class NewsExceptionResolver extends SimpleMappingExceptionResolver {

    private static final Logger LOG = LoggerFactory.getLogger(NewsExceptionResolver.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object handler, Exception ex) {

        LOG.error(ex.getMessage(), ex);

        // Expose ModelAndView for chosen error view.
        String viewName = determineViewName(ex, request);

        if (viewName != null) {// JSP格式返回
            if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
                    .getHeader("X-Requested-With")!= null && request
                    .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
                // 如果不是异步请求
                // Apply HTTP status code for error views, if specified.
                // Only apply it if we're processing a top-level request.
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                return getModelAndView(viewName, ex, request);
            } else {// JSON格式返回
                try {

                    BaseResponse res = new BaseResponse();

                    res.setSuccess(false);
                    res.setCode("500");
                    res.setMessage(ex.getMessage());

                    PrintWriter writer = response.getWriter();

                    writer.write(JSONUtil.toJSON(res));

                    writer.flush();
                } catch (IOException e) {
                    LOG.error(e.getMessage(), e);
                }

                return null;
            }
        } else {
            return null;
        }
    }
}
