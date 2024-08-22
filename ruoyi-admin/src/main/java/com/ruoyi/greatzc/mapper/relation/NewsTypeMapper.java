package com.ruoyi.greatzc.mapper.relation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.greatzc.domain.relation.NewsType;
import com.ruoyi.greatzc.vo.CategoryVO;
import com.ruoyi.greatzc.vo.TypeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/22 22:04
 */
public interface NewsTypeMapper extends BaseMapper<NewsType> {
    List<TypeVO> selectEnhanceList(@Param("id") Integer id);
}
