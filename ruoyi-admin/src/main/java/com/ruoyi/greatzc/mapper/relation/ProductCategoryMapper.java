package com.ruoyi.greatzc.mapper.relation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.greatzc.domain.Category;
import com.ruoyi.greatzc.domain.relation.ProductCategory;
import com.ruoyi.greatzc.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
    List<CategoryVO> selectEnhanceList(@Param("id") Long id);
}
