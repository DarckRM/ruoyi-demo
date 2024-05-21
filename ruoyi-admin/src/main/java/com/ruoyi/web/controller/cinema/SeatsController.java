package com.ruoyi.web.controller.cinema;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.Seats;
import com.ruoyi.system.service.ISeatsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 座位Controller
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
@RestController
@RequestMapping("/cinema/seats")
public class SeatsController extends BaseController
{
    @Autowired
    private ISeatsService seatsService;

    /**
     * 查询座位列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:seats:list')")
    @GetMapping("/list")
    public TableDataInfo list(Seats seats)
    {
        startPage();
        List<Seats> list = seatsService.selectSeatsList(seats);
        return getDataTable(list);
    }

    /**
     * 导出座位列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:seats:export')")
    @Log(title = "座位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Seats seats)
    {
        List<Seats> list = seatsService.selectSeatsList(seats);
        ExcelUtil<Seats> util = new ExcelUtil<Seats>(Seats.class);
        util.exportExcel(response, list, "座位数据");
    }

    /**
     * 获取座位详细信息
     */
    @PreAuthorize("@ss.hasPermi('cinema:seats:query')")
    @GetMapping(value = "/{seatId}")
    public AjaxResult getInfo(@PathVariable("seatId") Long seatId)
    {
        return success(seatsService.selectSeatsBySeatId(seatId));
    }

    /**
     * 新增座位
     */
    @PreAuthorize("@ss.hasPermi('cinema:seats:add')")
    @Log(title = "座位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Seats seats)
    {
        return toAjax(seatsService.insertSeats(seats));
    }

    /**
     * 修改座位
     */
    @PreAuthorize("@ss.hasPermi('cinema:seats:edit')")
    @Log(title = "座位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Seats seats)
    {
        return toAjax(seatsService.updateSeats(seats));
    }

    /**
     * 删除座位
     */
    @PreAuthorize("@ss.hasPermi('cinema:seats:remove')")
    @Log(title = "座位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{seatIds}")
    public AjaxResult remove(@PathVariable Long[] seatIds)
    {
        return toAjax(seatsService.deleteSeatsBySeatIds(seatIds));
    }
}
