package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.cinema.Showtimes;

/**
 * 放映Service接口
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public interface IShowtimesService 
{
    /**
     * 查询放映
     * 
     * @param showtimeId 放映主键
     * @return 放映
     */
    public Showtimes selectShowtimesByShowtimeId(Long showtimeId);

    /**
     * 查询放映列表
     * 
     * @param showtimes 放映
     * @return 放映集合
     */
    public List<Showtimes> selectShowtimesList(Showtimes showtimes);

    /**
     * 新增放映
     * 
     * @param showtimes 放映
     * @return 结果
     */
    public int insertShowtimes(Showtimes showtimes);

    /**
     * 修改放映
     * 
     * @param showtimes 放映
     * @return 结果
     */
    public int updateShowtimes(Showtimes showtimes);

    /**
     * 批量删除放映
     * 
     * @param showtimeIds 需要删除的放映主键集合
     * @return 结果
     */
    public int deleteShowtimesByShowtimeIds(Long[] showtimeIds);

    /**
     * 删除放映信息
     * 
     * @param showtimeId 放映主键
     * @return 结果
     */
    public int deleteShowtimesByShowtimeId(Long showtimeId);
}
