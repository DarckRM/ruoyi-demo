package com.ruoyi.greatzc.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.greatzc.domain.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品信息Mapper接口
 * 
 * @author akarin
 * @date 2024-07-14
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product>
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
     * 删除产品信息
     * 
     * @param id 产品信息主键
     * @return 结果
     */
    public int deleteProductById(Long id);

    /**
     * 批量删除产品信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductByIds(Long[] ids);

    /**
     * @author akarin
     * @description 提供给首页的产品查询接口
     * @date 2024/8/25 23:12
     * @param product 参数
     * @return java.util.List<com.ruoyi.greatzc.domain.Product>
     **/
    List<Product> apiSelectProducts(Product product);
}
