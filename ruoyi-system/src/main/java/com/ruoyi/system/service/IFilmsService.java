package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.cinema.Film;

/**
 * 影片Service接口
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public interface IFilmsService 
{
    /**
     * 查询影片
     * 
     * @param filmId 影片主键
     * @return 影片
     */
    public Film selectFilmsByFilmId(Long filmId);

    /**
     * 查询影片列表
     * 
     * @param film 影片
     * @return 影片集合
     */
    public List<Film> selectFilmsList(Film film);

    /**
     * 新增影片
     * 
     * @param film 影片
     * @return 结果
     */
    public int insertFilms(Film film);

    /**
     * 修改影片
     * 
     * @param film 影片
     * @return 结果
     */
    public int updateFilms(Film film);

    /**
     * 批量删除影片
     * 
     * @param filmIds 需要删除的影片主键集合
     * @return 结果
     */
    public int deleteFilmsByFilmIds(Long[] filmIds);

    /**
     * 删除影片信息
     * 
     * @param filmId 影片主键
     * @return 结果
     */
    public int deleteFilmsByFilmId(Long filmId);
}
