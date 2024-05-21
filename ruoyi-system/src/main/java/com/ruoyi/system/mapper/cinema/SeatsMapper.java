package com.ruoyi.system.mapper.cinema;

import java.util.List;
import com.ruoyi.system.domain.Seats;

/**
 * 座位Mapper接口
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public interface SeatsMapper 
{
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
     * 删除座位
     * 
     * @param seatId 座位主键
     * @return 结果
     */
    public int deleteSeatsBySeatId(Long seatId);

    /**
     * 批量删除座位
     * 
     * @param seatIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSeatsBySeatIds(Long[] seatIds);

    /**
     * 根据 auditoriumId 统计座位数
     * @param auditoriumId 影厅 Id
     * @return int
     */
    public int countSeatsByAuditorium(Long auditoriumId);
}
