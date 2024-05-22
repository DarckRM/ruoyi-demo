package com.ruoyi.system.domain.cinema.vo;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class IdleSeats {
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

    private Integer idle;

    public Integer getIdle() {
        return idle;
    }

    public void setIdle(Integer idle) {
        this.idle = idle;
    }

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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("seatId", getSeatId())
                .append("auditoriumId", getAuditoriumId())
                .append("rowNumber", getRowNumber())
                .append("seatNumber", getSeatNumber())
                .append("idle", getIdle())
                .toString();
    }
}
