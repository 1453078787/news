package news.web.controller;

import news.common.response.BaseResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstHtmController {

    @RequestMapping("/first")
    public String first(){
        return "first";
    }

    @RequestMapping("/list")
    public void list(){

    }
}
