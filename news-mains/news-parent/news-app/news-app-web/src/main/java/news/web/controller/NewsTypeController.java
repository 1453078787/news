package news.web.controller;

import news.common.NewException;
import news.common.dto.NewTypeDto;
import news.common.response.BaseResponse;
import news.common.util.ValidationResult;
import news.common.util.ValidatorUtil;
import news.service.NewTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/type")
public class NewsTypeController {

    @Autowired
    private NewTypeService newTypeService;

    @ResponseBody
    @RequestMapping("/add")
    public BaseResponse add(@RequestBody NewTypeDto newTypeDto){
        BaseResponse response = new BaseResponse();
        ValidationResult validateEntity = ValidatorUtil.validateEntity(newTypeDto);
        if (validateEntity.hasErrors()) {
            response.setSuccess(false).setMessage(validateEntity.toString());
            return response;
        }
        try {
            newTypeService.addNewType(newTypeDto);
            response.setSuccess(true).setMessage("类型新增成功");
        } catch (NewException e) {
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @ResponseBody
    @RequestMapping("/list")
    public BaseResponse<List<NewTypeDto>> list(){
        BaseResponse<List<NewTypeDto>> response = new BaseResponse<>();
        List<NewTypeDto> list = newTypeService.listNewType();
        response.setSuccess(true).setBody(list);
        return response;
    }
}
