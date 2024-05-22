package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Seats;
import com.ruoyi.system.domain.cinema.vo.IdleSeats;

/**
 * 座位Service接口
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public interface ISeatsService 
{
    public List<IdleSeats> getIdleSeates(Long showtimeId);
    /**
     * 查询座位
     * 
     * @param seatId 座位主键
     * @return 座位
     */
    public Seats selectSeatsBySeatId(Long seatId);

    /**
     * 查询座位列表
     * 
     * @param seats 座位
     * @return 座位集合
     */
    public List<Seats> selectSeatsList(Seats seats);

    /**
     * 新增座位
     * 
     * @param seats 座位
     * @return 结果
     */
    public int insertSeats(Seats seats);

    /**
     * 修改座位
     * 
     * @param seats 座位
     * @return 结果
     */
    public int updateSeats(Seats seats);

    /**
     * 批量删除座位
     * 
     * @param seatIds 需要删除的座位主键集合
     * @return 结果
     */
    public int deleteSeatsBySeatIds(Long[] seatIds);

    /**
     * 删除座位信息
     * 
     * @param seatId 座位主键
     * @return 结果
     */
    public int deleteSeatsBySeatId(Long seatId);
}
