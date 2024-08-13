package com.ruoyi.greatzc.domain.relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/14 5:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsType {
    private Integer id;
    private Integer newsId;
    private Integer typeId;
}
