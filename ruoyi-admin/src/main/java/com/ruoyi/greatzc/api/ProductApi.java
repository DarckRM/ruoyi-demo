package com.ruoyi.greatzc.api;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.EnvUtil;
import com.ruoyi.greatzc.domain.Product;
import com.ruoyi.greatzc.service.IProductService;
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
 * @date 2024/8/8 1:08
 */
@RestController
@RequestMapping("/api/product")
public class ProductApi extends BaseController {

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public TableDataInfo list(Product product) {
        startPage();
        List<Product> list = productService.apiSelectProducts(product);
        return getDataTable(list);
    }


    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        logger.info(EnvUtil.BASE_URL);
        Product product = productService.selectProductById(id);
        // 替换正文中的图片 URL
        product.setContent(product.getContent().replace("/dev-api/", EnvUtil.BASE_URL));
        return success(product);
    }

}
