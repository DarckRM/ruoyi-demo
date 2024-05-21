package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 座位对象 seats
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public class Seats extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 座位 ID */
    private Long seatId;

    /** 影厅 ID */
    @Excel(name = "影厅 ID")
    private Long auditoriumId;

    /** 排数 */
    @Excel(name = "排数")
    private Long rowNumber;

    /** 座位号 */
    @Excel(name = "座位号")
    private Long seatNumber;

    public void setSeatId(Long seatId) 
    {
        this.seatId = seatId;
    }

    public Long getSeatId() 
    {
        return seatId;
    }
    public void setAuditoriumId(Long auditoriumId) 
    {
        this.auditoriumId = auditoriumId;
    }

    public Long getAuditoriumId() 
    {
        return auditoriumId;
    }
    public void setRowNumber(Long rowNumber) 
    {
        this.rowNumber = rowNumber;
    }

    public Long getRowNumber() 
    {
        return rowNumber;
    }
    public void setSeatNumber(Long seatNumber) 
    {
        this.seatNumber = seatNumber;
    }

    public Long getSeatNumber() 
    {
        return seatNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("seatId", getSeatId())
            .append("auditoriumId", getAuditoriumId())
            .append("rowNumber", getRowNumber())
            .append("seatNumber", getSeatNumber())
            .toString();
    }
}
