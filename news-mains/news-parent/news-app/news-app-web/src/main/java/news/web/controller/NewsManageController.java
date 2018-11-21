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
            response.setSuccess(true).setMessage("新增成功");
        } catch (NewException e) {
            response.setMessage(e.getMessage());
            LOG.error(e.getMessage(), e);
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("/list-type")
    public String listByType(Integer typeId) {
        if(typeId == null){
            return null;
        }
        NewCriteria criteria = new NewCriteria();
        criteria.setNewTypeId(typeId);
        criteria.setIsAllList(true);
        List<NewsDto> dtoList = newsManageService.listNews(criteria);
        ResponseDataTable data = new ResponseDataTable();
        data.setData(dtoList);
        JSONObject jsonObject = JSONObject.fromObject(data);
        String result = jsonObject.toString();
        return result;
    }


}
