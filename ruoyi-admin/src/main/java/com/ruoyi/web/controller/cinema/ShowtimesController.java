package com.ruoyi.web.controller.cinema;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.cinema.Showtimes;
import com.ruoyi.system.service.IShowtimesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 放映Controller
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
@RestController
@RequestMapping("/cinema/showtimes")
public class ShowtimesController extends BaseController
{
    @Autowired
    private IShowtimesService showtimesService;

    /**
     * 查询放映列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:showtimes:list')")
    @GetMapping("/list")
    public TableDataInfo list(Showtimes showtimes)
    {
        startPage();
        List<Showtimes> list = showtimesService.selectShowtimesList(showtimes);
        return getDataTable(list);
    }

    /**
     * 导出放映列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:showtimes:export')")
    @Log(title = "放映", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Showtimes showtimes)
    {
        List<Showtimes> list = showtimesService.selectShowtimesList(showtimes);
        ExcelUtil<Showtimes> util = new ExcelUtil<Showtimes>(Showtimes.class);
        util.exportExcel(response, list, "放映数据");
    }

    /**
     * 获取放映详细信息
     */
    @PreAuthorize("@ss.hasPermi('cinema:showtimes:query')")
    @GetMapping(value = "/{showtimeId}")
    public AjaxResult getInfo(@PathVariable("showtimeId") Long showtimeId)
    {
        return success(showtimesService.selectShowtimesByShowtimeId(showtimeId));
    }

    /**
     * 新增放映
     */
    @PreAuthorize("@ss.hasPermi('cinema:showtimes:add')")
    @Log(title = "放映", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Showtimes showtimes)
    {
        if (!showtimes.getEndTime().after(showtimes.getStartTime()))
            return error("放映结束时间不能早于开始时间");
        return toAjax(showtimesService.insertShowtimes(showtimes));
    }

    /**
     * 修改放映
     */
    @PreAuthorize("@ss.hasPermi('cinema:showtimes:edit')")
    @Log(title = "放映", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Showtimes showtimes)
    {
        if (!showtimes.getEndTime().after(showtimes.getStartTime()))
            return error("放映结束时间不能早于开始时间");
        return toAjax(showtimesService.updateShowtimes(showtimes));
    }

    /**
     * 删除放映
     */
    @PreAuthorize("@ss.hasPermi('cinema:showtimes:remove')")
    @Log(title = "放映", businessType = BusinessType.DELETE)
	@DeleteMapping("/{showtimeIds}")
    public AjaxResult remove(@PathVariable Long[] showtimeIds)
    {
        return toAjax(showtimesService.deleteShowtimesByShowtimeIds(showtimeIds));
    }
}
