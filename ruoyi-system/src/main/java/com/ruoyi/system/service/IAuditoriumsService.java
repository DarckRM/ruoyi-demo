package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.cinema.Auditoriums;

/**
 * 影厅Service接口
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public interface IAuditoriumsService 
{
    /**
     * 查询影厅
     * 
     * @param auditoriumId 影厅主键
     * @return 影厅
     */
    public Auditoriums selectAuditoriumsByAuditoriumId(Long auditoriumId);

    /**
     * 查询影厅列表
     * 
     * @param auditoriums 影厅
     * @return 影厅集合
     */
    public List<Auditoriums> selectAuditoriumsList(Auditoriums auditoriums);

    /**
     * 新增影厅
     * 
     * @param auditoriums 影厅
     * @return 结果
     */
    public int insertAuditoriums(Auditoriums auditoriums);

    /**
     * 修改影厅
     * 
     * @param auditoriums 影厅
     * @return 结果
     */
    public int updateAuditoriums(Auditoriums auditoriums);

    /**
     * 批量删除影厅
     * 
     * @param auditoriumIds 需要删除的影厅主键集合
     * @return 结果
     */
    public int deleteAuditoriumsByAuditoriumIds(Long[] auditoriumIds);

    /**
     * 删除影厅信息
     * 
     * @param auditoriumId 影厅主键
     * @return 结果
     */
    public int deleteAuditoriumsByAuditoriumId(Long auditoriumId);
}
