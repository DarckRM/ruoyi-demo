package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.cinema.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.cinema.FilmMapper;
import com.ruoyi.system.service.IFilmsService;

/**
 * 影片Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
@Service
public class FilmsServiceImpl implements IFilmsService 
{
    @Autowired
    private FilmMapper filmMapper;

    /**
     * 查询影片
     * 
     * @param filmId 影片主键
     * @return 影片
     */
    @Override
    public Film selectFilmsByFilmId(Long filmId)
    {
        return filmMapper.selectFilmsByFilmId(filmId);
    }

    /**
     * 查询影片列表
     * 
     * @param film 影片
     * @return 影片
     */
    @Override
    public List<Film> selectFilmsList(Film film)
    {
        return filmMapper.selectFilmsList(film);
    }

    /**
     * 新增影片
     * 
     * @param film 影片
     * @return 结果
     */
    @Override
    public int insertFilms(Film film)
    {
        return filmMapper.insertFilms(film);
    }

    /**
     * 修改影片
     * 
     * @param film 影片
     * @return 结果
     */
    @Override
    public int updateFilms(Film film)
    {
        return filmMapper.updateFilms(film);
    }

    /**
     * 批量删除影片
     * 
     * @param filmIds 需要删除的影片主键
     * @return 结果
     */
    @Override
    public int deleteFilmsByFilmIds(Long[] filmIds)
    {
        return filmMapper.deleteFilmsByFilmIds(filmIds);
    }

    /**
     * 删除影片信息
     * 
     * @param filmId 影片主键
     * @return 结果
     */
    @Override
    public int deleteFilmsByFilmId(Long filmId)
    {
        return filmMapper.deleteFilmsByFilmId(filmId);
    }
}
