package news.dal.dao;

import java.util.List;

import news.common.dto.NewsDto;
import news.common.dto.criteria.NewCriteria;
import news.dal.model.New;
import news.dal.model.NewExample;
import org.apache.ibatis.annotations.Param;

public interface NewMapper {
    long countByExample(NewExample example);

    int deleteByExample(NewExample example);

    int deleteByPrimaryKey(Integer newId);

    int insert(New record);

    int insertSelective(New record);

    List<New> selectByExampleWithBLOBs(NewExample example);

    List<New> selectByExample(NewExample example);

    New selectByPrimaryKey(Integer newId);

    int updateByExampleSelective(@Param("record") New record, @Param("example") NewExample example);

    int updateByExampleWithBLOBs(@Param("record") New record, @Param("example") NewExample example);

    int updateByExample(@Param("record") New record, @Param("example") NewExample example);

    int updateByPrimaryKeySelective(New record);

    int updateByPrimaryKeyWithBLOBs(New record);

    int updateByPrimaryKey(New record);

    /**
     * criteria列出新闻
     */
    List<NewsDto> list(NewCriteria criteria);

    int countNews(NewCriteria criteria);
}