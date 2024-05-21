package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SeatsMapper;
import com.ruoyi.system.domain.Seats;
import com.ruoyi.system.service.ISeatsService;

/**
 * 座位Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
@Service
public class SeatsServiceImpl implements ISeatsService 
{
    @Autowired
    private SeatsMapper seatsMapper;

    /**
     * 查询座位
     * 
     * @param seatId 座位主键
     * @return 座位
     */
    @Override
    public Seats selectSeatsBySeatId(Long seatId)
    {
        return seatsMapper.selectSeatsBySeatId(seatId);
    }

    /**
     * 查询座位列表
     * 
     * @param seats 座位
     * @return 座位
     */
    @Override
    public List<Seats> selectSeatsList(Seats seats)
    {
        return seatsMapper.selectSeatsList(seats);
    }

    /**
     * 新增座位
     * 
     * @param seats 座位
     * @return 结果
     */
    @Override
    public int insertSeats(Seats seats)
    {
        return seatsMapper.insertSeats(seats);
    }

    /**
     * 修改座位
     * 
     * @param seats 座位
     * @return 结果
     */
    @Override
    public int updateSeats(Seats seats)
    {
        return seatsMapper.updateSeats(seats);
    }

    /**
     * 批量删除座位
     * 
     * @param seatIds 需要删除的座位主键
     * @return 结果
     */
    @Override
    public int deleteSeatsBySeatIds(Long[] seatIds)
    {
        return seatsMapper.deleteSeatsBySeatIds(seatIds);
    }

    /**
     * 删除座位信息
     * 
     * @param seatId 座位主键
     * @return 结果
     */
    @Override
    public int deleteSeatsBySeatId(Long seatId)
    {
        return seatsMapper.deleteSeatsBySeatId(seatId);
    }
}
