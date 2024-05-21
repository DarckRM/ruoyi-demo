package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单对象 ticket_orders
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public class TicketOrders extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单 ID */
    private Long orderId;

    /** 会员 ID */
    @Excel(name = "会员 ID")
    private Long memberId;

    /** 放映 ID */
    @Excel(name = "放映 ID")
    private Long showtimeId;

    /** 座位 ID */
    @Excel(name = "座位 ID")
    private Long seatId;

    /** 预约时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预约时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bookingTime;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }
    public void setShowtimeId(Long showtimeId) 
    {
        this.showtimeId = showtimeId;
    }

    public Long getShowtimeId() 
    {
        return showtimeId;
    }
    public void setSeatId(Long seatId) 
    {
        this.seatId = seatId;
    }

    public Long getSeatId() 
    {
        return seatId;
    }
    public void setBookingTime(Date bookingTime) 
    {
        this.bookingTime = bookingTime;
    }

    public Date getBookingTime() 
    {
        return bookingTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("memberId", getMemberId())
            .append("showtimeId", getShowtimeId())
            .append("seatId", getSeatId())
            .append("bookingTime", getBookingTime())
            .toString();
    }
}
