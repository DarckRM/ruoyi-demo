package com.ruoyi.greatzc.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.greatzc.domain.Category;
import com.ruoyi.greatzc.domain.relation.ProductCategory;
import com.ruoyi.greatzc.mapper.CategoryMapper;
import com.ruoyi.greatzc.mapper.relation.ProductCategoryMapper;
import com.ruoyi.greatzc.vo.CategoryVO;
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
    private CategoryMapper categoryMapper;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

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

    @Override
    public List<Product> apiSelectProducts(Product product) {
        List<Product> products = productMapper.apiSelectProducts(product);
        if (products.isEmpty())
            return products;

        // 拼装分类信息
        return injectCategories(products);
    }

    private List<Product> injectCategories(List<Product> products) {
        List<Long> productIds = products.stream()
                .map(Product::getId)
                .distinct().collect(Collectors.toList());

        //
        HashMap<Long, List<CategoryVO>> categoryMap = new HashMap<>();
        productIds.forEach(e -> {
            List<CategoryVO> categoryVOS = productCategoryMapper.selectEnhanceList(e);
            categoryMap.put(e, categoryVOS);
        });

        products.forEach(e -> {
            List<CategoryVO> vos = categoryMap.getOrDefault(e.getId(), new ArrayList<>());
            e.setCategories(vos);
            e.setCategoryIndex(vos.stream().map(CategoryVO::getCategoryId).collect(Collectors.toList()));
        });
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
        product.setId(IdUtil.getSnowflakeNextId() / 1000);
        product.setProductId(IdUtils.fastSimpleUUID());
        product.setCreateTime(DateUtils.getNowDate());

        // 默认排序为 0
        if (ObjectUtils.isEmpty(product.getOrderNo()))
            product.setOrderNo(0);

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

        product.setCreateTime(product.getUpdateTime());
        product.setId(null);
        product.setCreateTime(DateUtils.getNowDate());
        productMapper.insertProduct(product);
        return updateCategory(product);
    }

    private int updateCategory(Product product) {
        productCategoryMapper.delete(new QueryWrapper<ProductCategory>().eq("product_id", product.getId()));
        List<ProductCategory> categories = product.getCategoryIndex().stream()
                .map(item -> new ProductCategory(0, product.getId(), item))
                .collect(Collectors.toList());
        if (categories.isEmpty())
            return 1;
        return productCategoryMapper.insert(categories).size();
    }

    /**
     * 批量删除产品信息
     *
     * @param ids 需要删除的产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductByIds(Long[] ids) {
        int rowProduct = productMapper.deleteProductByIds(ids);
        productCategoryMapper.delete(new QueryWrapper<ProductCategory>().in("product_id", ids));
        return rowProduct;
    }

    /**
     * 删除产品信息信息
     *
     * @param id 产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductById(Long id) {
        int row = productMapper.deleteProductById(id);
        productCategoryMapper.delete(new QueryWrapper<ProductCategory>().eq("product_id", id));
        return row;
    }
}
