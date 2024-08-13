package com.ruoyi.greatzc.service;

import java.util.List;

import com.ruoyi.greatzc.domain.Type;
import com.ruoyi.greatzc.vo.TypeVO;

/**
 * 新闻分类Service接口
 *
 * @author ruoyi
 * @date 2024-08-14
 */
public interface ITypeService {
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
     * 批量删除新闻分类
     *
     * @param ids 需要删除的新闻分类主键集合
     * @return 结果
     */
    public int deleteTypeByIds(Long[] ids);

    /**
     * 删除新闻分类信息
     *
     * @param id 新闻分类主键
     * @return 结果
     */
    public int deleteTypeById(Long id);

    /**
     * @return java.util.List<com.ruoyi.greatzc.vo.TypeVO>
     * @author akarin
     * @description 获取选择器使用的新闻列表
     * @date 2024/8/14 5:48
     **/
    public List<TypeVO> getTypeOptions();
}
