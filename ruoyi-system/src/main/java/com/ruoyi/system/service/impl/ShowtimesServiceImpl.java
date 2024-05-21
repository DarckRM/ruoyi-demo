package com.ruoyi.system.service.impl;

import java.util.List;
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
