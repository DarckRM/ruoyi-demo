package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.cinema.ShowtimesMapper;
import com.ruoyi.system.domain.cinema.Showtimes;
import com.ruoyi.system.service.IShowtimesService;

/**
 * 放映Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
@Service
public class ShowtimesServiceImpl implements IShowtimesService 
{
    @Autowired
    private ShowtimesMapper showtimesMapper;

    /**
     * 查询放映
     * 
     * @param showtimeId 放映主键
     * @return 放映
     */
    @Override
    public Showtimes selectShowtimesByShowtimeId(Long showtimeId)
    {
        return showtimesMapper.selectShowtimesByShowtimeId(showtimeId);
    }

    /**
     * 查询放映列表
     * 
     * @param showtimes 放映
     * @return 放映
     */
    @Override
    public List<Showtimes> selectShowtimesList(Showtimes showtimes)
    {
        return showtimesMapper.selectShowtimesList(showtimes);
    }

    /**
     * 新增放映
     * 
     * @param showtimes 放映
     * @return 结果
     */
    @Override
    public int insertShowtimes(Showtimes showtimes)
    {
        // 校验时间段是否存在影片
        if (showtimesMapper.existShows(showtimes) > 0) {
            throw new ServiceException("该时间段内存在放映计划");
        }
        int duration = (int) (showtimes.getEndTime().getTime() - showtimes.getStartTime().getTime()) / 1000 / 60;
        showtimes.setDuration(duration);
        return showtimesMapper.insertShowtimes(showtimes);
    }

    @Override
    public int forceInsertShowtimes(Showtimes showtimes) {
        int duration = (int) (showtimes.getEndTime().getTime() - showtimes.getStartTime().getTime()) / 1000 / 60;
        showtimes.setDuration(duration);
        return showtimesMapper.insertShowtimes(showtimes);
    }

    /**
     * 修改放映
     * 
     * @param showtimes 放映
     * @return 结果
     */
    @Override
    public int updateShowtimes(Showtimes showtimes)
    {
        // 校验时间段是否存在影片
        if (showtimesMapper.existShows(showtimes) > 0) {
            throw new ServiceException("该时间段内存在放映计划");
        }
        int duration = (int) (showtimes.getEndTime().getTime() - showtimes.getStartTime().getTime()) / 1000 / 60;
        showtimes.setDuration(duration);
        return showtimesMapper.updateShowtimes(showtimes);
    }

    /**
     * 批量删除放映
     * 
     * @param showtimeIds 需要删除的放映主键
     * @return 结果
     */
    @Override
    public int deleteShowtimesByShowtimeIds(Long[] showtimeIds)
    {
        return showtimesMapper.deleteShowtimesByShowtimeIds(showtimeIds);
    }

    /**
     * 删除放映信息
     * 
     * @param showtimeId 放映主键
     * @return 结果
     */
    @Override
    public int deleteShowtimesByShowtimeId(Long showtimeId)
    {
        return showtimesMapper.deleteShowtimesByShowtimeId(showtimeId);
    }

    @Override
    public List<Showtimes> getAvailableShows(Showtimes showtimes) {
        return showtimesMapper.selectShowtimesListAvailable(showtimes);
    }
}
