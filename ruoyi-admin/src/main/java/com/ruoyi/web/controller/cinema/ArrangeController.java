package com.ruoyi.web.controller.cinema;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.cinema.Showtimes;
import com.ruoyi.system.domain.cinema.vo.ArrangeSetting;
import com.ruoyi.system.domain.cinema.vo.FilmRule;
import com.ruoyi.system.service.IShowtimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cinema/arrange")
public class ArrangeController {

    @Autowired
    private IShowtimesService showtimesService;

    @PostMapping("/auto")
    public AjaxResult autoArrange(@RequestBody ArrangeSetting setting) {

        List<Long> aPool = new ArrayList<>();
        aPool.add(1L);
        aPool.add(2L);
        List<FilmRule> fPoll = new ArrayList<>();
        fPoll.add(new FilmRule(1L, 120, 0, 0));
        fPoll.add(new FilmRule(2L, 90, 0, 0));
        fPoll.add(new FilmRule(3L, 160, 0, 0));
        fPoll.add(new FilmRule(4L, 220, 0, 0));
        setting.setAuditoriumPool(aPool);
        setting.setFilmPool(fPoll);
        setting.setCloseTime("20:00");
        setting.setOpenTime("07:00");
        setting.setPeriodStart(DateUtils.addHours(DateUtils.getNowDate(), -50));
        setting.setPeriodEnd(DateUtils.getNowDate());
        setting.setPrepareTime(5);
        setting.setLeaveTime(5);

        arrange(setting);
        return null;
    }

    public List<Showtimes> arrange(ArrangeSetting setting) {
        // 格式化时间
        String prefix = "YYYY-MM-dd ";
        List<Showtimes> allShows = new ArrayList<>();
        // 周期内天数
        int days = (int) ((setting.getPeriodEnd().getTime() - setting.getPeriodStart().getTime()) / 24 / 60 / 60 / 1000) + 1;
        int offset = 0;
        while (days != 0) {
            // 声明两个移标用于判断移标间是否足够容纳排片计划
            String thatDay = DateUtils.parseDateToStr(prefix, DateUtils.addDays(setting.getPeriodStart(), offset));
            Date begin = DateUtils.parseDate(thatDay + setting.getOpenTime());
            Date end = DateUtils.parseDate(thatDay + setting.getCloseTime());

            // 查询该天内存在的排片计划
            Showtimes show = new Showtimes();
            show.setStartTime(begin);
            show.setEndTime(end);
            List<Showtimes> shows = new ArrayList<>(showtimesService.selectShowtimesList(show));

            arrangeByDay(shows, setting, begin, end);

            allShows.addAll(shows);
            days -= 1;
            offset += 1;
        }

        return allShows;
    }

    private List<Showtimes> arrangeByDay(List<Showtimes> shows, ArrangeSetting setting, Date begin, Date end) {
        // 格式化时间
        String prefix = "YYYY-MM-dd ";
        // 按照放映时间排序
        Date todayBegin = begin;
        Date todayEnd = end;

        if (shows.size() != 0) {
            shows = shows.stream().sorted(Comparator.comparing(Showtimes::getStartTime)).collect(Collectors.toList());
            // 更新一次排片特殊规则
            for (Showtimes show : shows)
                updateRule(setting, show.getFilmId());
        }

        for (Long room : setting.getAuditoriumPool()) {
            int duration = 1;
            int index = 0;
            begin = todayBegin;

            // 对于存在已有拍片计划的情况，移标的首次末尾是拍片计划最早的放映时间
            end = shows.get(0).getStartTime();

            while (duration >= 0) {
                // 以分钟为单位
                duration = (int) ((end.getTime() - begin.getTime()) / 1000 / 60);
                for (FilmRule rule : setting.getFilmPool()) {
                    if (rule.getDuration() > duration)
                        continue;

                    // 加上入场散场时间
                    long showDuration = (setting.getPrepareTime() + rule.getDuration() + setting.getLeaveTime());
                    Date next = new Date(begin.getTime() + showDuration * 60 * 1000);

                    // 生成一个新的放映计划
                    Showtimes show = new Showtimes(rule.getFilmId(), room, begin, next);
                    shows.add(index, show);

                    // 下一轮排片修正起始时间
                    begin = show.getEndTime();
                    index += 1;
                }
                // 如果当前排片游标大于影院关门时间，说明还有余位
                if (shows.get(index - 1).getEndTime().getTime() < todayEnd.getTime()) {
                    // 处理存在其它排片计划的情况
                    if (shows.size() - 1 > index) {
                        begin = end;
                        Showtimes show = shows.get(index + 1);
                        end = show.getStartTime();
                    } else {
                        end = todayEnd;
                    }
                }
            }
        }
        return shows;
    }

    private ArrangeSetting updateRule(ArrangeSetting setting, Long filmId) {
        for (FilmRule rule : setting.getFilmPool()) {
            if (!Objects.equals(rule.getFilmId(), filmId))
                continue;
            rule.setMin(rule.getMin() - 1);
            rule.setMax(rule.getMax() - 1);
        }
        return setting;
    }
}
