package com.ruoyi.greatzc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.greatzc.domain.Product;
import com.ruoyi.greatzc.domain.Type;
import com.ruoyi.greatzc.domain.relation.NewsType;
import com.ruoyi.greatzc.domain.relation.ProductCategory;
import com.ruoyi.greatzc.mapper.relation.NewsTypeMapper;
import com.ruoyi.greatzc.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.greatzc.mapper.NewsMapper;
import com.ruoyi.greatzc.domain.News;
import com.ruoyi.greatzc.service.INewsService;

/**
 * 新闻列表Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-14
 */
@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private NewsTypeMapper newsTypeMapper;

    /**
     * 查询新闻列表
     *
     * @param id 新闻列表主键
     * @return 新闻列表
     */
    @Override
    public News selectNewsById(Long id) {
        News news = newsMapper.selectNewsById(id);

        // 拼装分类信息
        ArrayList<News> newsList = new ArrayList<>();
        newsList.add(news);
        return injectTypes(newsList).get(0);
    }

    /**
     * 查询新闻列表列表
     *
     * @param news 新闻列表
     * @return 新闻列表
     */
    @Override
    public List<News> selectNewsList(News news) {
        List<News> newsList = newsMapper.selectNewsList(news);
        if (newsList.isEmpty())
            return newsList;

        return injectTypes(newsList);
    }

    /**
     * 新增新闻列表
     *
     * @param news 新闻列表
     * @return 结果
     */
    @Override
    public int insertNews(News news) {
        news.setId((int) (IdUtil.getSnowflakeNextId() / 100));
        news.setCreateTime(DateUtils.getNowDate());
        int row = newsMapper.insertNews(news);

        updateType(news);
        return row;
    }

    /**
     * 修改新闻列表
     *
     * @param news 新闻列表
     * @return 结果
     */
    @Override
    public int updateNews(News news) {
        news.setUpdateTime(DateUtils.getNowDate());
        newsMapper.updateNews(news);
        return updateType(news);
    }

    /**
     * 批量删除新闻列表
     *
     * @param ids 需要删除的新闻列表主键
     * @return 结果
     */
    @Override
    public int deleteNewsByIds(Long[] ids) {
        int row = newsMapper.deleteNewsByIds(ids);
        newsTypeMapper.delete(new QueryWrapper<NewsType>().in("news_id", ids));
        return row;
    }

    /**
     * 删除新闻列表信息
     *
     * @param id 新闻列表主键
     * @return 结果
     */
    @Override
    public int deleteNewsById(Long id) {
        return newsMapper.deleteNewsById(id);
    }

    private List<News> injectTypes(List<News> newsList) {
        List<Integer> newsIds = newsList.stream()
                .map(News::getId)
                .distinct()
                .collect(Collectors.toList());

        HashMap<Integer, List<TypeVO>> typeMap = new HashMap<>();
        newsIds.forEach(e -> {
            List<TypeVO> typeVOS = newsTypeMapper.selectEnhanceList(e);
            typeMap.put(e, typeVOS);
        });

        newsList.forEach(e -> {
            List<TypeVO> vos = typeMap.getOrDefault(e.getId(), new ArrayList<>());
            e.setTypes(vos);
            e.setTypeIndex(vos.stream().map(TypeVO::getTypeId).collect(Collectors.toList()));
        });
        return newsList;
    }


    private int updateType(News news) {
        newsTypeMapper.delete(new QueryWrapper<NewsType>().eq("news_id", news.getId()));
        List<NewsType> types = news.getTypeIndex().stream()
                .map(item -> new NewsType(0, news.getId(), item))
                .collect(Collectors.toList());
        if (types.isEmpty())
            return 1;
        return newsTypeMapper.insert(types).size();
    }
}
