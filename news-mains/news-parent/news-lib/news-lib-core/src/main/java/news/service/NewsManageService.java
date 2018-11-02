package news.service;

import news.common.dto.NewsDto;
import news.common.dto.criteria.NewCriteria;

import java.util.List;

public interface NewsManageService {
    List<NewsDto> listNews(NewCriteria criteria);
}
