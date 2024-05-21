package com.ruoyi.system.domain.cinema;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 影片对象 films
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public class Film extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 影片 id */
    private Long filmId;

    /** 影片名 */
    @Excel(name = "影片名")
    private String title;

    /** 影片类型 */
    @Excel(name = "影片类型")
    private String genre;

    /** 影片时长 */
    @Excel(name = "影片时长")
    private Long duration;

    /** 首映时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "首映时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date releaseDate;

    public void setFilmId(Long filmId) 
    {
        this.filmId = filmId;
    }

    public Long getFilmId() 
    {
        return filmId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setGenre(String genre) 
    {
        this.genre = genre;
    }

    public String getGenre() 
    {
        return genre;
    }
    public void setDuration(Long duration) 
    {
        this.duration = duration;
    }

    public Long getDuration() 
    {
        return duration;
    }
    public void setReleaseDate(Date releaseDate) 
    {
        this.releaseDate = releaseDate;
    }

    public Date getReleaseDate() 
    {
        return releaseDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("filmId", getFilmId())
            .append("title", getTitle())
            .append("genre", getGenre())
            .append("duration", getDuration())
            .append("releaseDate", getReleaseDate())
            .toString();
    }
}
