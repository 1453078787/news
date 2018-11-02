package news.web.controller;

import net.sf.json.JSONObject;
import news.common.dto.NewsDto;
import news.common.dto.criteria.NewCriteria;
import news.common.response.ResponseDataTable;
import news.service.NewsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class NewsManageController {

    @Autowired
    private NewsManageService newsManageService;

    @RequestMapping("/to-list")
    public String toList(){
        return "news/manage-list";
    }

    @RequestMapping("/list-type")
    @ResponseBody
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
