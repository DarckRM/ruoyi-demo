package com.ruoyi.greatzc.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ruoyi.greatzc.vo.TypeVO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻列表对象 news
 *
 * @author ruoyi
 * @date 2024-08-14
 */
@Data
public class News extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 封面
     */
    @Excel(name = "封面")
    private String banner;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 标签
     */
    @Excel(name = "标签")
    private String tags;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 是否启用
     */
    @Excel(name = "是否启用")
    private String status;

    /**
     * 作者
     */
    @Excel(name = "作者")
    private String author;

    /**
     * 是否首页展示
     */
    @Excel(name = "是否首页展示")
    private String show;

    @Getter
    @Setter
    @Excel(name = "关键词")
    private String keywords;

    @TableField(exist = false)
    private List<Integer> typeIndex = new ArrayList<>();

    @TableField(exist = false)
    private List<TypeVO> types = new ArrayList<>();

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getBanner() {
        return banner;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return tags;
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
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
                .append("title", getTitle())
                .append("tags", getTags())
                .append("content", getContent())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("status", getStatus())
                .append("author", getAuthor())
                .append("show", getShow())
                .toString();
    }
}
