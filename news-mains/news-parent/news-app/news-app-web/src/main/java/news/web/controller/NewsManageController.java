package news.web.controller;

import net.sf.json.JSONObject;
import news.common.NewException;
import news.common.dto.NewsDto;
import news.common.dto.criteria.NewCriteria;
import news.common.response.BaseResponse;
import news.common.response.ResponseDataTable;
import news.common.util.ValidationResult;
import news.common.util.ValidatorUtil;
import news.service.NewsManageService;
import news.service.impl.NewsManageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tdh.thunder.common.PaginatedList;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class NewsManageController {
    private static final Logger LOG = LoggerFactory.getLogger(NewsManageController.class);

    @Autowired
    private NewsManageService newsManageService;

    @RequestMapping("/to-list")
    public String toList(){
        return "news/manage-list";
    }

    @RequestMapping("/to-add")
    public String toAdd(){
        return "news/add";
    }

    @RequestMapping("/to-detail")
    public String toDetail(Integer newId, Model model) {
        if(newId != null) {
            NewsDto newsDto = newsManageService.newDetail(newId);
            model.addAttribute("newsDto", newsDto);
        }
        return "news/detail";
    }

    @ResponseBody
    @RequestMapping("/put")
    public BaseResponse add(@RequestBody NewsDto newsDto){
        BaseResponse response = new BaseResponse();
        if("PUT".equals(newsDto.getNewSatus())) {
            ValidationResult validateEntity = ValidatorUtil.validateEntity(newsDto);
            if (validateEntity.hasErrors()) {
                response.setSuccess(false).setMessage(validateEntity.toString());
                return response;
            }
        }
        try {
            newsManageService.putNews(newsDto);
            response.setSuccess(true).setMessage("编辑新闻成功");
        } catch (NewException e) {
            response.setMessage(e.getMessage());
            LOG.error(e.getMessage(), e);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("/list-type")
    public BaseResponse<PaginatedList<NewsDto>> listByType(NewCriteria criteria) {
        if(criteria.getNewTypeId() == null){
            return null;
        }
        BaseResponse<PaginatedList<NewsDto>> response = new BaseResponse<>();
        criteria.setIsAllList(true);
        PaginatedList<NewsDto> dtoList = newsManageService.listNews(criteria);
        response.setBody(dtoList).setSuccess(true);
        return response;
    }

    @ResponseBody
    @RequestMapping("/detail")
    public BaseResponse<NewsDto> toDetail(Integer newId) {
        BaseResponse<NewsDto> response = new BaseResponse<>();
        response.setMessage("查询失败");
        if(newId != null) {
            NewsDto newsDto = newsManageService.newDetail(newId);
            response.setSuccess(true).setBody(newsDto).setMessage("查询成功");
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public BaseResponse delete(Integer newId) {
        BaseResponse response = new BaseResponse();
        if(newId == null) {
            response.setMessage("id不能为空");
        }
        NewsDto newsDto = new NewsDto();
        newsDto.setNewId(newId);
        newsDto.setDeleted(1);
        try {
            newsManageService.putNews(newsDto);
            response.setMessage("删除成功").setSuccess(true);
        } catch (NewException e) {
            response.setMessage("删除失败");
        }
        return response;
    }

}
