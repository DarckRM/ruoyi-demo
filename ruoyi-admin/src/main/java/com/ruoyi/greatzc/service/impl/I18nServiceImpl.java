package com.ruoyi.greatzc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.greatzc.mapper.I18nMapper;
import com.ruoyi.greatzc.domain.I18n;
import com.ruoyi.greatzc.service.II18nService;

/**
 * 国际化Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-07-14
 */
@Service
public class I18nServiceImpl implements II18nService 
{
    @Autowired
    private I18nMapper i18nMapper;

    /**
     * 查询国际化
     * 
     * @param id 国际化主键
     * @return 国际化
     */
    @Override
    public I18n selectI18nById(String id)
    {
        return i18nMapper.selectI18nById(id);
    }

    /**
     * 查询国际化列表
     * 
     * @param i18n 国际化
     * @return 国际化
     */
    @Override
    public List<I18n> selectI18nList(I18n i18n)
    {
        return i18nMapper.selectI18nList(i18n);
    }

    /**
     * 新增国际化
     * 
     * @param i18n 国际化
     * @return 结果
     */
    @Override
    public int insertI18n(I18n i18n)
    {
        return i18nMapper.insertI18n(i18n);
    }

    /**
     * 修改国际化
     * 
     * @param i18n 国际化
     * @return 结果
     */
    @Override
    public int updateI18n(I18n i18n)
    {
        return i18nMapper.updateI18n(i18n);
    }

    /**
     * 批量删除国际化
     * 
     * @param ids 需要删除的国际化主键
     * @return 结果
     */
    @Override
    public int deleteI18nByIds(String[] ids)
    {
        return i18nMapper.deleteI18nByIds(ids);
    }

    /**
     * 删除国际化信息
     * 
     * @param id 国际化主键
     * @return 结果
     */
    @Override
    public int deleteI18nById(String id)
    {
        return i18nMapper.deleteI18nById(id);
    }
}
