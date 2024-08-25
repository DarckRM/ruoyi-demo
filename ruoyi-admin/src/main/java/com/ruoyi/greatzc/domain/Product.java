package com.ruoyi.greatzc.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.ruoyi.greatzc.domain.relation.ProductCategory;
import com.ruoyi.greatzc.vo.CategoryVO;
import lombok.Data;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

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
    private Integer orderNo;

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
    @TableField(value = "`show`")
    private String show;

    @Excel(name = "关键词")
    private String keywords;

    /**
     * 产品分类参数
     */
    @TableField(exist = false)
    private List<Integer> categoryIndex = new ArrayList<>();

    @TableField(exist = false)
    private List<CategoryVO> categories = new ArrayList<>();

}
