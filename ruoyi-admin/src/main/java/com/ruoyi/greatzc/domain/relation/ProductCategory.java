package com.ruoyi.greatzc.domain.relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 产品类别关系实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    private Integer id;
    private Long productId;
    private Integer categoryId;
}
