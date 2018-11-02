package news.service;

import news.common.NewException;
import news.common.dto.NewTypeDto;
import news.dal.model.NewType;

import java.util.List;

public interface NewTypeService {
    void addNewType(NewTypeDto newTypeDto) throws NewException;
    List<NewTypeDto> listNewType();
}
