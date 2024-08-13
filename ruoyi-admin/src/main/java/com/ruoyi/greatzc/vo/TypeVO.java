package com.ruoyi.greatzc.vo;

import com.ruoyi.greatzc.domain.relation.NewsType;
import lombok.Data;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/14 5:44
 */
@Data
public class TypeVO extends NewsType {
    private String name;
    private String text;
    private Integer value;
    private Integer count;
}
