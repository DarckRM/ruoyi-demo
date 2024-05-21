package com.ruoyi.system.domain.cinema;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员对象 members
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
public class Members extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会员 id */
    private Long memberId;

    /** 会员姓名 */
    @Excel(name = "会员姓名")
    private String name;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 电话 */
    @Excel(name = "电话")
    private String phone;

    /** 注册日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date membershipDate;

    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setMembershipDate(Date membershipDate) 
    {
        this.membershipDate = membershipDate;
    }

    public Date getMembershipDate() 
    {
        return membershipDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("memberId", getMemberId())
            .append("name", getName())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("membershipDate", getMembershipDate())
            .toString();
    }
}
