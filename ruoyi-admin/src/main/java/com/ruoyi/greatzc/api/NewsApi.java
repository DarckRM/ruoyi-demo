package com.ruoyi.greatzc.api;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.EnvUtil;
import com.ruoyi.greatzc.domain.News;
import com.ruoyi.greatzc.domain.Product;
import com.ruoyi.greatzc.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/14 4:58
 */
@RestController
@RequestMapping("/api/news")
public class NewsApi extends BaseController {
    @Autowired
    private INewsService newsService;


    @GetMapping("/list")
    public TableDataInfo list(News news) {
        startPage();
        List<News> list = newsService.selectNewsList(news);
        return getDataTable(list);
    }


    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        logger.info(EnvUtil.BASE_URL);
        News news = newsService.selectNewsById(id);
        // 替换正文中的图片 URL
        news.setContent(news.getContent().replace("/dev-api/", EnvUtil.BASE_URL));
        return success(news);
    }
}
