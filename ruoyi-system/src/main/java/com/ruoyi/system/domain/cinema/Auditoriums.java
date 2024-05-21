package com.ruoyi.system.domain.cinema;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 影厅对象 auditoriums
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public class Auditoriums extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 影厅 id */
    private Long auditoriumId;

    /** 影厅名称 */
    @Excel(name = "影厅名称")
    private String name;

    /** 影厅容量 */
    @Excel(name = "影厅容量")
    private Long capacity;

    public void setAuditoriumId(Long auditoriumId) 
    {
        this.auditoriumId = auditoriumId;
    }

    public Long getAuditoriumId() 
    {
        return auditoriumId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCapacity(Long capacity) 
    {
        this.capacity = capacity;
    }

    public Long getCapacity() 
    {
        return capacity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("auditoriumId", getAuditoriumId())
            .append("name", getName())
            .append("capacity", getCapacity())
            .toString();
    }
}
