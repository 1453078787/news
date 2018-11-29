package news.service.impl;

import news.common.NewException;
import news.common.dto.NewsDto;
import news.common.dto.criteria.NewCriteria;
import news.dal.dao.NewMapper;
import news.dal.dao.NewTypeMapper;
import news.dal.model.New;
import news.dal.model.NewType;
import news.service.NewsManageService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdh.thunder.common.PaginatedList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Service
public class NewsManageServiceImpl implements NewsManageService{
    private static final Logger LOG = LoggerFactory.getLogger(NewsManageServiceImpl.class);

    @Autowired
    private NewMapper newMapper;

    @Autowired
    private NewTypeMapper newTypeMapper;

    @Override
    public PaginatedList<NewsDto> listNews(NewCriteria criteria) {
        PaginatedList<NewsDto> paginatedList = new PaginatedList<>();
        List<NewsDto> list = newMapper.list(criteria);
        if(!criteria.getIsAllList()){
            List<NewsDto> dtoList = new ArrayList<>();
            for(int i=0; i<10; i++){
                if(CollectionUtils.isEmpty(list)){
                    paginatedList.setResult(dtoList);
                    return paginatedList;
                }
                int intBounded = 0 + ((int) (new Random().nextFloat() * (list.size() - 0)));
                dtoList.add(list.get(intBounded));
                list.remove(intBounded);
            }
            paginatedList.setResult(dtoList);
            return paginatedList;
        } else {
            if (0 != criteria.getPagesize()) {
                int total = newMapper.countNews(criteria);
                criteria.setTotal(total);
            }
            if (0 == criteria.getPagesize()) {
                criteria.setTotal(list.size());
            }
            paginatedList.setResult(list);
            paginatedList.setPagination(criteria);
            return paginatedList;
        }
    }

    @Override
    public void putNews(NewsDto newsDto) throws NewException {
        New news = new New();

        newsDto.setUpdatedBy(1);
        newsDto.setUpdatedByName("liu");
        newsDto.setUpdatedTime(new Date());

        BeanUtils.copyProperties(newsDto, news);
        try {
            if (news.getNewId() == null) {
                news.setCreatedBy(1);
                news.setCreatedByName("liu");
                news.setCreatedTime(new Date());
                news.setViewNumber(0);
                newMapper.insertSelective(news);
            } else {
                newMapper.updateByPrimaryKeySelective(news);
            }
        } catch (Exception e) {
            LOG.error(e.getMessage(),e);
            throw new NewException("编辑新闻失败");
        }
    }

    @Override
    public NewsDto newDetail(int newId) {
        New aNew = newMapper.selectByPrimaryKey(newId);
        NewType newType = newTypeMapper.selectByPrimaryKey(aNew.getNewTypeId());
        NewsDto newsDto = new NewsDto();
        BeanUtils.copyProperties(aNew, newsDto);
        newsDto.setNewTypeName(newType.getNewTypeName());
        return newsDto;
    }
}
