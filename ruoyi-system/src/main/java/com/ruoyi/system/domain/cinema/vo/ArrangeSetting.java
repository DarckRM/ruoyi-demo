package com.ruoyi.system.domain.cinema.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class ArrangeSetting {
    // 影院工作时间
    private String openTime;
    private String closeTime;
    // 排片周期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date periodStart;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date periodEnd;

    // 入场散场时间
    private int prepareTime;
    private int leaveTime;

    // 影厅池
    private List<Long> auditoriumPool;
    // 影片池
    private List<FilmRule> filmPool;

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(Date periodEnd) {
        this.periodEnd = periodEnd;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public int getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(int prepareTime) {
        this.prepareTime = prepareTime;
    }

    public int getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(int leaveTime) {
        this.leaveTime = leaveTime;
    }

    public List<Long> getAuditoriumPool() {
        return auditoriumPool;
    }

    public void setAuditoriumPool(List<Long> auditoriumPool) {
        this.auditoriumPool = auditoriumPool;
    }

    public List<FilmRule> getFilmPool() {
        return filmPool;
    }

    public void setFilmPool(List<FilmRule> filmPool) {
        this.filmPool = filmPool;
    }

    @Override
    public String toString() {
        return "ArrangeSetting{" +
                "openTime='" + openTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                ", prepareTime=" + prepareTime +
                ", leaveTime=" + leaveTime +
                ", auditoriumPool=" + auditoriumPool +
                ", filmPool=" + filmPool +
                '}';
    }
}
