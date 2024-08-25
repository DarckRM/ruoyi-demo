package com.ruoyi.greatzc.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.greatzc.domain.Product;

/**
 * 产品信息Service接口
 * 
 * @author akarin
 * @date 2024-07-14
 */
public interface IProductService
{
    /**
     * 查询产品信息
     * 
     * @param id 产品信息主键
     * @return 产品信息
     */
    public Product selectProductById(Long id);

    /**
     * 查询产品信息列表
     * 
     * @param product 产品信息
     * @return 产品信息集合
     */
    public List<Product> selectProductList(Product product);

    /**
     * @author akarin
     * @description 首页使用的产品查询接口
     * @date 2024/8/25 23:16
     * @param product TODO))
     * @return java.util.List<com.ruoyi.greatzc.domain.Product>
     **/
    public List<Product> apiSelectProducts(Product product);

    /**
     * 新增产品信息
     * 
     * @param product 产品信息
     * @return 结果
     */
    public int insertProduct(Product product);

    /**
     * 修改产品信息
     * 
     * @param product 产品信息
     * @return 结果
     */
    public int updateProduct(Product product);

    /**
     * 批量删除产品信息
     * 
     * @param ids 需要删除的产品信息主键集合
     * @return 结果
     */
    public int deleteProductByIds(Long[] ids);

    /**
     * 删除产品信息信息
     * 
     * @param id 产品信息主键
     * @return 结果
     */
    public int deleteProductById(Long id);
}
