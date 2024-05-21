package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AuditoriumsMapper;
import com.ruoyi.system.domain.cinema.Auditoriums;
import com.ruoyi.system.service.IAuditoriumsService;

/**
 * 影厅Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
@Service
public class AuditoriumsServiceImpl implements IAuditoriumsService 
{
    @Autowired
    private AuditoriumsMapper auditoriumsMapper;

    /**
     * 查询影厅
     * 
     * @param auditoriumId 影厅主键
     * @return 影厅
     */
    @Override
    public Auditoriums selectAuditoriumsByAuditoriumId(Long auditoriumId)
    {
        return auditoriumsMapper.selectAuditoriumsByAuditoriumId(auditoriumId);
    }

    /**
     * 查询影厅列表
     * 
     * @param auditoriums 影厅
     * @return 影厅
     */
    @Override
    public List<Auditoriums> selectAuditoriumsList(Auditoriums auditoriums)
    {
        return auditoriumsMapper.selectAuditoriumsList(auditoriums);
    }

    /**
     * 新增影厅
     * 
     * @param auditoriums 影厅
     * @return 结果
     */
    @Override
    public int insertAuditoriums(Auditoriums auditoriums)
    {
        return auditoriumsMapper.insertAuditoriums(auditoriums);
    }

    /**
     * 修改影厅
     * 
     * @param auditoriums 影厅
     * @return 结果
     */
    @Override
    public int updateAuditoriums(Auditoriums auditoriums)
    {
        return auditoriumsMapper.updateAuditoriums(auditoriums);
    }

    /**
     * 批量删除影厅
     * 
     * @param auditoriumIds 需要删除的影厅主键
     * @return 结果
     */
    @Override
    public int deleteAuditoriumsByAuditoriumIds(Long[] auditoriumIds)
    {
        return auditoriumsMapper.deleteAuditoriumsByAuditoriumIds(auditoriumIds);
    }

    /**
     * 删除影厅信息
     * 
     * @param auditoriumId 影厅主键
     * @return 结果
     */
    @Override
    public int deleteAuditoriumsByAuditoriumId(Long auditoriumId)
    {
        return auditoriumsMapper.deleteAuditoriumsByAuditoriumId(auditoriumId);
    }
}
