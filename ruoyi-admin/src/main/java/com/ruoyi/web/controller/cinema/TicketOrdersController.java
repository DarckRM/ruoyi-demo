package com.ruoyi.web.controller.cinema;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.Seats;
import com.ruoyi.system.domain.cinema.Showtimes;
import com.ruoyi.system.service.ISeatsService;
import com.ruoyi.system.service.IShowtimesService;
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
import com.ruoyi.system.domain.TicketOrders;
import com.ruoyi.system.service.ITicketOrdersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
@RestController
@RequestMapping("/cinema/orders")
public class TicketOrdersController extends BaseController
{
    @Autowired
    private ITicketOrdersService ticketOrdersService;

    @Autowired
    private ISeatsService seatsService;

    @Autowired
    private IShowtimesService showtimesService;

    /**
     * 查询订单列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:orders:list')")
    @GetMapping("/list")
    public TableDataInfo list(TicketOrders ticketOrders)
    {
        startPage();
        List<TicketOrders> list = ticketOrdersService.selectTicketOrdersList(ticketOrders);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:orders:export')")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TicketOrders ticketOrders)
    {
        List<TicketOrders> list = ticketOrdersService.selectTicketOrdersList(ticketOrders);
        ExcelUtil<TicketOrders> util = new ExcelUtil<TicketOrders>(TicketOrders.class);
        util.exportExcel(response, list, "订单数据");
    }

    /**
     * 获取订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('cinema:orders:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return success(ticketOrdersService.selectTicketOrdersByOrderId(orderId));
    }

    /**
     * 新增订单
     */
    @PreAuthorize("@ss.hasPermi('cinema:orders:add')")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TicketOrders ticketOrders)
    {
        return toAjax(ticketOrdersService.insertTicketOrders(ticketOrders));
    }

    /**
     * 修改订单
     */
    @PreAuthorize("@ss.hasPermi('cinema:orders:edit')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TicketOrders ticketOrders)
    {
        return toAjax(ticketOrdersService.updateTicketOrders(ticketOrders));
    }

    /**
     * 删除订单
     */
    @PreAuthorize("@ss.hasPermi('cinema:orders:remove')")
    @Log(title = "订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(ticketOrdersService.deleteTicketOrdersByOrderIds(orderIds));
    }

    @GetMapping("/show")
    public AjaxResult getAvailableShows() {
        Date now = DateUtils.getNowDate();
        Showtimes show = new Showtimes();
        show.setStartTime(now);
        return success(showtimesService.getAvailableShows(show));
    }

    @GetMapping("/seats/{showtimeId}")
    public AjaxResult getSeatsByShowtimeId(@PathVariable Long showtimeId) {
        Showtimes show = showtimesService.selectShowtimesByShowtimeId(showtimeId);
        if (show == null) {
            return error("不存在的放映计划");
        }
        Seats seat = new Seats();
        seat.setAuditoriumId(show.getAuditoriumId());
        return success(seatsService.getIdleSeates(showtimeId));
    }
}
