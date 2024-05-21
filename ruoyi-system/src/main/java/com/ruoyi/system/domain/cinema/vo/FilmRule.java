package com.ruoyi.system.domain.cinema.vo;

public class FilmRule {
    private Long filmId;
    private int duration;
    private int min;
    private int max;

    public FilmRule() {
    }

    public FilmRule(Long filmId, int duration, int min, int max) {
        this.filmId = filmId;
        this.duration = duration;
        this.min = min;
        this.max = max;
    }

    public Long getFilmId() {
        return filmId;
    }

    private void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "FilmRule{" +
                "filmId=" + filmId +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
