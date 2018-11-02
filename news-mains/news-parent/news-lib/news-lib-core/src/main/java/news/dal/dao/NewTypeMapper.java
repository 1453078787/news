package news.dal.dao;

import java.util.List;
import news.dal.model.NewType;
import news.dal.model.NewTypeExample;
import org.apache.ibatis.annotations.Param;

public interface NewTypeMapper {
    long countByExample(NewTypeExample example);

    int deleteByExample(NewTypeExample example);

    int deleteByPrimaryKey(Integer newTypeId);

    int insert(NewType record);

    int insertSelective(NewType record);

    List<NewType> selectByExample(NewTypeExample example);

    NewType selectByPrimaryKey(Integer newTypeId);

    int updateByExampleSelective(@Param("record") NewType record, @Param("example") NewTypeExample example);

    int updateByExample(@Param("record") NewType record, @Param("example") NewTypeExample example);

    int updateByPrimaryKeySelective(NewType record);

    int updateByPrimaryKey(NewType record);
}