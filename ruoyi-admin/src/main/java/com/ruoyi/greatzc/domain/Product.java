package com.ruoyi.greatzc.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 产品信息对象 product
 *
 * @author akarin
 * @date 2024-07-14
 */
@Data
public class Product extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    private String productId;

    /**
     * 封面
     */
    @Excel(name = "封面")
    private String banner;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String name;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long orderNo;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

    /**
     * 首页展示
     */
    @Excel(name = "首页展示")
    private String show;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getBanner() {
        return banner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getShow() {
        return show;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("banner", getBanner())
                .append("name", getName())
                .append("orderNo", getOrderNo())
                .append("title", getTitle())
                .append("content", getContent())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("status", getStatus())
                .append("show", getShow())
                .toString();
    }
}
