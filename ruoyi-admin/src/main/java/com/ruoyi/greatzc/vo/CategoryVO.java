package com.ruoyi.greatzc.vo;

import com.ruoyi.greatzc.domain.relation.ProductCategory;
import lombok.Data;

@Data
public class CategoryVO extends ProductCategory {
   private String name;
   private String text;
   private Integer value;
   private Integer count;
}
