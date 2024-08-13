package com.ruoyi.greatzc.mapper;

import java.util.List;

import com.ruoyi.greatzc.domain.Category;
import com.ruoyi.greatzc.vo.CategoryVO;

/**
 * 产品分类Mapper接口
 * 
 * @author akarin
 * @date 2024-07-14
 */
public interface CategoryMapper 
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
     * 删除产品分类
     * 
     * @param id 产品分类主键
     * @return 结果
     */
    public int deleteCategoryById(Long id);

    /**
     * 批量删除产品分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCategoryByIds(Long[] ids);

    /**
     * @author akarin
     * @description 获取用于前端筛选器的产品列表
     * @date 2024/8/14 0:35
     * @return java.util.List<com.ruoyi.greatzc.domain.CategoryVO>
     **/
    public List<CategoryVO> getCategoryOptions();
}
