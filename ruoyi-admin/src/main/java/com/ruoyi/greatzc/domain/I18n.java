package com.ruoyi.greatzc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 国际化对象 i18n
 * 
 * @author ruoyi
 * @date 2024-07-14
 */
public class I18n extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String id;

    /** 语种 */
    @Excel(name = "语种")
    private String lang;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setLang(String lang) 
    {
        this.lang = lang;
    }

    public String getLang() 
    {
        return lang;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("lang", getLang())
            .append("content", getContent())
            .toString();
    }
}
