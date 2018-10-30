package news.web.interceptor;

import news.common.cache.DictCache;
import news.common.util.FreemarkerUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tdh.thunder.common.utils.ConfigProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultInteceptor extends HandlerInterceptorAdapter {

    private static String APP_VERSION;

//	private static final String SYSTEM_FILE_SERVER = ConfigProperties.getInstance("fmc")
//			.getPropertyAsString("system.file.server");

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        String uri = request.getRequestURI().replace(request.getContextPath(), "");
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String[] uris = request.getRequestURI().replace(request.getContextPath(), "").split("/");
        if (uris.length > 1) {
            request.setAttribute("module1", uris[1]);
        }
        if (uris.length > 2) {
            request.setAttribute("nav1", uris[2]);
        }

        String ctx = request.getContextPath();
        String res = ctx;
        request.setAttribute("ctx", ctx);

        //PlatformSubject subject = SecurityHelper.getSubject();

//		if (subject != null
//				&& subject.getSubjectMobile().equals(
//						request.getSession().getAttribute("initp" + subject.getSubjectMobile()))) {
//			request.setAttribute("pwdInitial", true);
//		} else {
//			request.setAttribute("pwdInitial", false);
//		}
        request.setAttribute("pwdInitial", false);
        request.setAttribute("res", res);
        request.setAttribute("js", res + "/js");
        request.setAttribute("css", res + "/css");
        request.setAttribute("images", res + "/images");
        request.setAttribute("Dict", FreemarkerUtils.getStaticTemplateModel(DictCache.class));
        request.setAttribute("appver", DefaultInteceptor.getAppVersion());
//		request.setAttribute("systemFileServer" , SYSTEM_FILE_SERVER);


        response.setHeader("Pragma", "No-cache");
        request.setAttribute("remoteIp", getRemoteIP(request));
        return true;
    }

    public static String getRemoteIP(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
                String ipLeval = ip.substring(ip.indexOf(",") + 1, ip.length());
                while ("unknown".equals(ip)) {
                    if (ip.indexOf(",") > 0) {
                        ip = ipLeval.substring(0, ipLeval.indexOf(","));
                    } else {
                        ip = ipLeval;
                        break;
                    }
                }
            }
        }
        return ip;
    }

    private static String getAppVersion() {

        if (null == APP_VERSION) {
            APP_VERSION = ConfigProperties.getInstance("hris").getPropertyAsString("hris.app.version",
                    String.valueOf(System.currentTimeMillis()));

            APP_VERSION = APP_VERSION.replaceAll("-SNAPSHOT", "");
        }

        return APP_VERSION;
    }

}
