package com.ruoyi.greatzc.service;

import java.util.List;

import com.ruoyi.greatzc.domain.Category;
import com.ruoyi.greatzc.vo.CategoryVO;

/**
 * 产品分类Service接口
 * 
 * @author akarin
 * @date 2024-07-14
 */
public interface ICategoryService 
{
    /**
     * 查询产品分类
     * 
     * @param id 产品分类主键
     * @return 产品分类
     */
    public Category selectCategoryById(Long id);

    /**
     * 查询产品分类列表
     * 
     * @param category 产品分类
     * @return 产品分类集合
     */
    public List<Category> selectCategoryList(Category category);

    /**
     * 新增产品分类
     * 
     * @param category 产品分类
     * @return 结果
     */
    public int insertCategory(Category category);

    /**
     * 修改产品分类
     * 
     * @param category 产品分类
     * @return 结果
     */
    public int updateCategory(Category category);

    /**
     * 批量删除产品分类
     * 
     * @param ids 需要删除的产品分类主键集合
     * @return 结果
     */
    public int deleteCategoryByIds(Long[] ids);

    /**
     * 删除产品分类信息
     * 
     * @param id 产品分类主键
     * @return 结果
     */
    public int deleteCategoryById(Long id);

    /**
     * @author akarin
     * @description 获取筛选用产品类别列表
     * @date 2024/8/14 0:45
     * @return java.util.List<com.ruoyi.greatzc.vo.CategoryVO>
     **/
    public List<CategoryVO> getCategoryOptions();
}
