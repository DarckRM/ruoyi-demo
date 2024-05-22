package com.ruoyi.system.service.impl;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.system.domain.cinema.Auditoriums;
import com.ruoyi.system.domain.cinema.vo.IdleSeats;
import com.ruoyi.system.mapper.AuditoriumsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.cinema.SeatsMapper;
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

    @Autowired
    private AuditoriumsMapper auditoriumsMapper;

    @Override
    public List<IdleSeats> getIdleSeates(Long showtimeId) {
        return seatsMapper.selectIdleSeats(showtimeId);
    }

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
        Auditoriums auditorium = auditoriumsMapper.selectAuditoriumsByAuditoriumId(seats.getAuditoriumId());
        if (auditorium == null) {
            throw new ServiceException("不存在的影厅");
        }
        int capacity = seatsMapper.countSeatsByAuditorium(seats.getAuditoriumId());
        if (capacity >= auditorium.getCapacity()) {
            throw new ServiceException("该影厅座位容量已满");
        }
        try {
            return seatsMapper.insertSeats(seats);
        } catch (DuplicateKeyException e) {
            throw new ServiceException("该影厅中存在重复座位");
        }
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
