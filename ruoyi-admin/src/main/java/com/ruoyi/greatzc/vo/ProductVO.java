package com.ruoyi.greatzc.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.greatzc.domain.Category;
import com.ruoyi.greatzc.domain.Product;
import lombok.Data;

@Data
public class ProductVO extends Product {
    private String categoryName;
    private Integer categoryId;
    private Integer majorCate;
}
