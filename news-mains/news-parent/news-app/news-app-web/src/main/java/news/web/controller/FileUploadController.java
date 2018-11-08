package news.web.controller;

import news.common.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

    @ResponseBody
    @RequestMapping("/upload")
    public BaseResponse<String> upload(MultipartFile file, HttpSession session){
        BaseResponse<String> response = new BaseResponse();
        String filename=String.valueOf(System.currentTimeMillis())+file.getOriginalFilename();
        String leftpath=session.getServletContext().getRealPath("/upload");
        response.setBody(filename);
        File file1=new File(leftpath,filename);
        try {
            file.transferTo(file1);
            response.setSuccess(true);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        return response;
    }
}
