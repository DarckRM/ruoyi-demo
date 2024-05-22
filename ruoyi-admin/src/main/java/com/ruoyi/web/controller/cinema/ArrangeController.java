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
        return AjaxResult.success(arrange(setting));
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

            // 查询该天内某影厅存在的排片计划
            for (long room : setting.getAuditoriumPool()) {
                Showtimes show = new Showtimes();
                show.setAuditoriumId(room);
                show.setStartTime(begin);
                show.setEndTime(end);
                List<Showtimes> shows = new ArrayList<>(showtimesService.selectShowtimesList(show));

                shows = arrangeByDay(shows, setting, begin, end, room);
                allShows.addAll(shows);
            }

            days -= 1;
            offset += 1;
        }

        return allShows;
    }

    private List<Showtimes> arrangeByDay(List<Showtimes> showsIn, ArrangeSetting setting, Date begin, Date end, long room) {
        if (setting.getFilmPool().isEmpty())
            return showsIn;

        // 按照放映时间排序
        Date todayBegin = begin;
        Date todayEnd = end;
        // 一些全局控制用的变量
        int minDuration = setting.getFilmPool().stream().min(Comparator.comparing(FilmRule::getDuration)).get().getDuration();
        int allDuration = (int) ((todayEnd.getTime() - todayBegin.getTime()) / 1000 / 60);

        if (!showsIn.isEmpty()) {
            // 在有未知的放映安排下预校验
            for (Showtimes show : showsIn)
                allDuration -= show.getDuration();
            if (allDuration < minDuration)
                return showsIn;

            showsIn = showsIn.stream().sorted(Comparator.comparing(Showtimes::getStartTime)).collect(Collectors.toList());
            // 更新一次排片特殊规则
            for (Showtimes show : showsIn)
                updateRule(setting, show.getFilmId());
        }

        List<Showtimes> shows = new ArrayList<>();
        int duration = 1;
        int index = 0;
        begin = todayBegin;

        // 对于存在已有拍片计划的情况，移标的首次末尾是拍片计划最早的放映时间
        if (!showsIn.isEmpty()) {
            shows.addAll(showsIn);
            end = shows.get(0).getStartTime();
        }

        while (true) {
            // 插入了新的放映计划
            boolean insert = false;
            // 以分钟为单位
            for (FilmRule rule : setting.getFilmPool()) {
                duration = (int) ((end.getTime() - begin.getTime()) / 1000 / 60);
                if (setting.getPrepareTime() + rule.getDuration() + setting.getLeaveTime() > duration)
                    continue;

                // 加上入场散场时间
                long showDuration = (setting.getPrepareTime() + rule.getDuration() + setting.getLeaveTime());
                Date next = new Date(begin.getTime() + showDuration * 60 * 1000);

                // 生成一个新的放映计划
                Showtimes show = new Showtimes(rule.getFilmId(), room, begin, next);
                shows.add(index, show);
                insert = true;

                // 下一轮排片修正游标
                begin = show.getEndTime();
                if (shows.size() - 1 > index) {
                    end = shows.get(index + 1).getStartTime();
                } else {
                    end = todayEnd;
                }
                index += 1;
            }

            if (end != todayEnd) {
                begin = shows.get(index).getEndTime();
                if (shows.size() - 1 > index)
                    end = shows.get(index + 1).getStartTime();
                else
                    end = todayEnd;
            }

            if (end == todayEnd && !insert)
                return shows;
            if (index == shows.size())
                continue;


            if (shows.size() - 1 > index) {
                end = shows.get(index + 1).getStartTime();
                index += 1;
            }
            else {
                Showtimes last = shows.get(index);
                if (last.getEndTime().getTime() - todayEnd.getTime() < 0 && !insert) {
                    if (index == 0) {
                        begin = shows.get(index).getEndTime();
                        end = todayEnd;
                    }
                    else {
                        begin = shows.get(index - 1).getEndTime();
                        end = last.getStartTime();
                    }

                } else {
                    begin = last.getEndTime();
                    end = todayEnd;
                    index += 1;
                }
            }
        }
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
