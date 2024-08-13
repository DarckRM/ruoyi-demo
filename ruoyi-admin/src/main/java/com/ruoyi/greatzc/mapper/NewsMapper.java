package com.ruoyi.greatzc.mapper;

import java.util.List;
import com.ruoyi.greatzc.domain.News;

/**
 * 新闻列表Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-14
 */
public interface NewsMapper 
{
    /**
     * 查询新闻列表
     * 
     * @param id 新闻列表主键
     * @return 新闻列表
     */
    public News selectNewsById(Long id);

    /**
     * 查询新闻列表列表
     * 
     * @param news 新闻列表
     * @return 新闻列表集合
     */
    public List<News> selectNewsList(News news);

    /**
     * 新增新闻列表
     * 
     * @param news 新闻列表
     * @return 结果
     */
    public int insertNews(News news);

    /**
     * 修改新闻列表
     * 
     * @param news 新闻列表
     * @return 结果
     */
    public int updateNews(News news);

    /**
     * 删除新闻列表
     * 
     * @param id 新闻列表主键
     * @return 结果
     */
    public int deleteNewsById(Long id);

    /**
     * 批量删除新闻列表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNewsByIds(Long[] ids);
}
