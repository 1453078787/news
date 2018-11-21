package news.service;

import news.common.NewException;
import news.common.dto.NewsDto;
import news.common.dto.criteria.NewCriteria;

import java.util.List;

public interface NewsManageService {
    /**
     * criteria 查询
     * @param criteria
     * @return
     */
    List<NewsDto> listNews(NewCriteria criteria);

    /**
     * 上传 保存 new
     * @param newsDto
     * @throws NewException
     */
    void putNews(NewsDto newsDto) throws NewException;

    /**
     * 新闻详情
     * @param newId
     * @return
     */
    NewsDto newDetail(int newId);
}
