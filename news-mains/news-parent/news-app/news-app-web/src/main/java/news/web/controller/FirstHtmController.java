package news.web.controller;

import news.common.dto.NewsDto;
import news.common.dto.criteria.NewCriteria;
import news.common.response.BaseResponse;
import news.service.NewsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tdh.thunder.common.PaginatedList;

import java.util.List;

@Controller
@RequestMapping("/first")
public class FirstHtmController {

    @Autowired
    private NewsManageService newsManageService;

    @RequestMapping("/to")
    public String first(){
        return "first";
    }

    @RequestMapping("/to-detail")
    public String detail(Integer newId, Model model) {
        if(newId != null) {
            NewsDto newsDto = newsManageService.newDetail(newId);
            model.addAttribute("newsDto", newsDto);
        }
        return "/detail";
    }

    @ResponseBody
    @RequestMapping("/list")
    public BaseResponse<List<NewsDto>> list(){
        BaseResponse<List<NewsDto>> response =new BaseResponse<>();
        NewCriteria criteria =new NewCriteria();
        criteria.setIsAllList(false);
        PaginatedList<NewsDto> paginatedList = newsManageService.listNews(criteria);
        response.setBody(paginatedList.getResult()).setSuccess(true);
        return response;
    }
}
