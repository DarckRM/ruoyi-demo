package com.ruoyi.greatzc.service.impl;

import java.util.Collections;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.greatzc.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.greatzc.mapper.TypeMapper;
import com.ruoyi.greatzc.domain.Type;
import com.ruoyi.greatzc.service.ITypeService;

/**
 * 新闻分类Service业务层处理
 *
 * @author ruoyi
 * @date 2024-08-14
 */
@Service
public class TypeServiceImpl implements ITypeService {
    @Autowired
    private TypeMapper typeMapper;

    /**
     * 查询新闻分类
     *
     * @param id 新闻分类主键
     * @return 新闻分类
     */
    @Override
    public Type selectTypeById(Long id) {
        return typeMapper.selectTypeById(id);
    }

    /**
     * 查询新闻分类列表
     *
     * @param type 新闻分类
     * @return 新闻分类
     */
    @Override
    public List<Type> selectTypeList(Type type) {
        return typeMapper.selectTypeList(type);
    }

    /**
     * 新增新闻分类
     *
     * @param type 新闻分类
     * @return 结果
     */
    @Override
    public int insertType(Type type) {
        type.setCreateTime(DateUtils.getNowDate());
        return typeMapper.insertType(type);
    }

    /**
     * 修改新闻分类
     *
     * @param type 新闻分类
     * @return 结果
     */
    @Override
    public int updateType(Type type) {
        type.setUpdateTime(DateUtils.getNowDate());
        return typeMapper.updateType(type);
    }

    /**
     * 批量删除新闻分类
     *
     * @param ids 需要删除的新闻分类主键
     * @return 结果
     */
    @Override
    public int deleteTypeByIds(Long[] ids) {
        return typeMapper.deleteTypeByIds(ids);
    }

    /**
     * 删除新闻分类信息
     *
     * @param id 新闻分类主键
     * @return 结果
     */
    @Override
    public int deleteTypeById(Long id) {
        return typeMapper.deleteTypeById(id);
    }

    @Override
    public List<TypeVO> getTypeOptions() {
        return typeMapper.getTypeOptions();
    }
}
