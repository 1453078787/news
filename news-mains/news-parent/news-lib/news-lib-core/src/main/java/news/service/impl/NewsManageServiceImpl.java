package news.service.impl;

import news.common.dto.NewsDto;
import news.common.dto.criteria.NewCriteria;
import news.dal.dao.NewMapper;
import news.dal.model.New;
import news.service.NewsManageService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class NewsManageServiceImpl implements NewsManageService{

    @Autowired
    private NewMapper newMapper;

    @Override
    public List<NewsDto> listNews(NewCriteria criteria) {
        List<NewsDto> list = newMapper.list(criteria);
        if(CollectionUtils.isNotEmpty(list) && !criteria.getIsAllList()){
            List<NewsDto> dtoList = new ArrayList<>();
            for(int i=0; i<10; i++){
                int intBounded = 0 + ((int) (new Random().nextFloat() * (list.size() - 0)));
                dtoList.add(list.get(intBounded));
                list.remove(intBounded);
            }
            return dtoList;
        }
       return list;
    }
}
