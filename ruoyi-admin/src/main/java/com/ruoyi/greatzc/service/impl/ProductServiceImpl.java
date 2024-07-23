package com.ruoyi.greatzc.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
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

    /**
     * 查询产品信息
     *
     * @param id 产品信息主键
     * @return 产品信息
     */
    @Override
    public Product selectProductById(Long id) {
        return productMapper.selectProductById(id);
    }

    /**
     * 查询产品信息列表
     *
     * @param product 产品信息
     * @return 产品信息
     */
    @Override
    public List<Product> selectProductList(Product product) {
        return productMapper.selectProductList(product);
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
        return productMapper.insertProduct(product);
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
        if (productMapper.exists(wrapper))
            return productMapper.updateProduct(product);

        product.setCreateTime(product.getUpdateTime());
        return productMapper.insertProduct(product);
    }

    /**
     * 批量删除产品信息
     *
     * @param ids 需要删除的产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductByIds(Long[] ids) {
        return productMapper.deleteProductByIds(ids);
    }

    /**
     * 删除产品信息信息
     *
     * @param id 产品信息主键
     * @return 结果
     */
    @Override
    public int deleteProductById(Long id) {
        return productMapper.deleteProductById(id);
    }
}
