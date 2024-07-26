package com.ruoyi.greatzc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mchange.v1.util.ListUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.greatzc.domain.relation.ProductCategory;
import com.ruoyi.greatzc.mapper.relation.ProductCategoryMapper;
import com.ruoyi.greatzc.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.greatzc.mapper.ProductMapper;
import com.ruoyi.greatzc.domain.Product;
import com.ruoyi.greatzc.service.IProductService;

/**
 * 产品信息Service业务层处理
 *
 * @author akarin
 * @date 2024-07-14
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductCategoryMapper categoryMapper;

    /**
     * 查询产品信息
     *
     * @param id 产品信息主键
     * @return 产品信息
     */
    @Override
    public Product selectProductById(Long id) {
        Product product = productMapper.selectProductById(id);

        // 拼装分类信息
        ArrayList<Product> products = new ArrayList<>();
        products.add(product);
        return injectCategories(products).get(0);
    }

    /**
     * 查询产品信息列表
     *
     * @param product 产品信息
     * @return 产品信息
     */
    @Override
    public List<Product> selectProductList(Product product) {
        List<Product> products = productMapper.selectProductList(product);
        if (products.isEmpty())
            return products;

        // 拼装分类信息
        return injectCategories(products);
    }

    private List<Product> injectCategories(List<Product> products) {
        List<String> productIds = products.stream().map(Product::getProductId).collect(Collectors.toList());

        productIds.stream()
                .distinct()
                .map(e -> categoryMapper.selectList(new QueryWrapper<ProductCategory>().eq("product_id", e)))
                .collect(e -> new Collector<Map, e, >())


        return products;
    }

    /**
     * 新增产品信息
     *
     * @param product 产品信息
     * @return 结果
     */
    @Override
    public int insertProduct(Product product) {
        product.setProductId(IdUtils.fastSimpleUUID());
        product.setCreateTime(DateUtils.getNowDate());

        productMapper.insertProduct(product);
        return updateCategory(product);
    }

    /**
     * 修改产品信息
     *
     * @param product 产品信息
     * @return 结果
     */
    @Override
    public int updateProduct(Product product) {
        // 构造条件查询是否存在此产品的某种语种的文案
        Wrapper<Product> wrapper = new QueryWrapper<Product>()
                .eq("product_id", product.getProductId())
                .eq("lang", product.getLang());

        product.setUpdateTime(DateUtils.getNowDate());
        if (productMapper.exists(wrapper)) {
            productMapper.updateProduct(product);
            return updateCategory(product);
        }

        List<ProductCategory> categories = product.getCategoryIndex().stream()
                .map(item -> new ProductCategory(null, product.getProductId(), item))
                .collect(Collectors.toList());

        categoryMapper.insert(categories);

        product.setCreateTime(product.getUpdateTime());
        product.setId(null);
        product.setCreateTime(DateUtils.getNowDate());
        productMapper.insertProduct(product);
        return updateCategory(product);
    }

    private int updateCategory(Product product) {
        categoryMapper.deleteByIds(product.getCategoryIndex());
        List<ProductCategory> categories = product.getCategoryIndex().stream()
                .map(item -> new ProductCategory(null, product.getProductId(), item))
                .collect(Collectors.toList());

        return categoryMapper.insert(categories).size();
    }

    /**
     * 批量删除产品信息
     *
     * @param ids 需要删除的产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductByIds(Long[] ids) {
        productMapper.deleteProductByIds(ids);
        return categoryMapper.delete(new QueryWrapper<ProductCategory>().in("product_id", ids));
    }

    /**
     * 删除产品信息信息
     *
     * @param id 产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductById(Long id) {
        productMapper.deleteProductById(id);
        return categoryMapper.delete(new QueryWrapper<ProductCategory>().eq("product_id", id));
    }
}
