package com.ruoyi.greatzc.api;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.greatzc.domain.Category;
import com.ruoyi.greatzc.domain.Product;
import com.ruoyi.greatzc.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/10 15:11
 */
@RestController
@RequestMapping("/api/category")
public class CategoryApi extends BaseController {
    @Autowired
    private ICategoryService categoryService;


    @GetMapping("/list")
    public TableDataInfo list(Category category) {
        startPage();
        List<Category> list = categoryService.selectCategoryList(category);
        return getDataTable(list);
    }
}
