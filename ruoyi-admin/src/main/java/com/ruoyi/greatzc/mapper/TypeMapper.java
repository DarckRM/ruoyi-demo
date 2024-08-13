package com.ruoyi.greatzc.mapper;

import java.util.List;
import com.ruoyi.greatzc.domain.Type;

/**
 * 新闻分类Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-14
 */
public interface TypeMapper 
{
    /**
     * 查询新闻分类
     * 
     * @param id 新闻分类主键
     * @return 新闻分类
     */
    public Type selectTypeById(Long id);

    /**
     * 查询新闻分类列表
     * 
     * @param type 新闻分类
     * @return 新闻分类集合
     */
    public List<Type> selectTypeList(Type type);

    /**
     * 新增新闻分类
     * 
     * @param type 新闻分类
     * @return 结果
     */
    public int insertType(Type type);

    /**
     * 修改新闻分类
     * 
     * @param type 新闻分类
     * @return 结果
     */
    public int updateType(Type type);

    /**
     * 删除新闻分类
     * 
     * @param id 新闻分类主键
     * @return 结果
     */
    public int deleteTypeById(Long id);

    /**
     * 批量删除新闻分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTypeByIds(Long[] ids);
}
