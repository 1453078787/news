package news.service.impl;

import news.common.NewException;
import news.common.dto.NewTypeDto;
import news.dal.dao.NewTypeMapper;
import news.dal.model.NewType;
import news.dal.model.NewTypeExample;
import news.service.NewTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewTypeServiceImpl implements NewTypeService{
    private static final Logger LOG = LoggerFactory.getLogger(NewTypeServiceImpl.class);


    @Autowired
    private NewTypeMapper newTypeMapper;

    @Override
    public void addNewType(NewTypeDto newTypeDto) throws NewException {
        NewType newType = new NewType();
        newTypeDto.setCreatedBy(1);
        newTypeDto.setCreatedByName("liu");
        newTypeDto.setCreatedTime(new Date());
        newTypeDto.setUpdatedBy(1);
        newTypeDto.setUpdatedByName("liu");
        newTypeDto.setUpdatedTime(new Date());
        BeanUtils.copyProperties(newTypeDto,newType);

        NewTypeExample example = new NewTypeExample();
        NewTypeExample.Criteria criteria = example.createCriteria();
        criteria.andNewTypeNameEqualTo(newTypeDto.getNewTypeName());
        criteria.andDeletedEqualTo(0);
        long count = newTypeMapper.countByExample(example);
        if(count == 1){
            throw new NewException("分类名称已存在");
        }
        try {
            newTypeMapper.insertSelective(newType);
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            throw new NewException("新增失败");
        }

    }

    @Override
    public List<NewTypeDto> listNewType() {
        NewTypeExample example = new NewTypeExample();
        NewTypeExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(0);
        List<NewType> newTypes = newTypeMapper.selectByExample(example);
        List<NewTypeDto> list = new ArrayList<>();
        for(NewType newType : newTypes){
            NewTypeDto dto = new NewTypeDto();
            BeanUtils.copyProperties(newType , dto);
            list.add(dto);
        }
        return list;
    }
}
