package com.ruoyi.system.domain.cinema;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 放映对象 showtimes
 *
 * @author ruoyi
 * @date 2024-05-21
 */
public class Showtimes extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 放映 ID
     */
    private Long showtimeId;

    /**
     * 影片 ID
     */
    @Excel(name = "影片 ID")
    private Long filmId;

    /**
     * 影厅 ID
     */
    @Excel(name = "影厅 ID")
    private Long auditoriumId;

    /**
     * 放映时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Excel(name = "放映时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm")
    private Date startTime;

    /**
     * 退场时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @Excel(name = "退场时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm")
    private Date endTime;

    @Excel(name = "播放时长")
    private Integer duration;

    public Showtimes(Long filmId, Long auditoriumId, Date startTime, Date endTime) {
        this.filmId = filmId;
        this.auditoriumId = auditoriumId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = (int) ((endTime.getTime() - startTime.getTime()) / 1000 / 60);
    }

    public Showtimes() {

    }

    public void setShowtimeId(Long showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Long getShowtimeId() {
        return showtimeId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setAuditoriumId(Long auditoriumId) {
        this.auditoriumId = auditoriumId;
    }

    public Long getAuditoriumId() {
        return auditoriumId;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("showtimeId", getShowtimeId())
                .append("filmId", getFilmId())
                .append("auditoriumId", getAuditoriumId())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("duration", getDuration())
                .toString();
    }
}
