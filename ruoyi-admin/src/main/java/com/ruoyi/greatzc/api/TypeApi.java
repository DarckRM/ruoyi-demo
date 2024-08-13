package com.ruoyi.greatzc.api;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.greatzc.domain.Category;
import com.ruoyi.greatzc.domain.Type;
import com.ruoyi.greatzc.service.ITypeService;
import com.ruoyi.greatzc.vo.CategoryVO;
import com.ruoyi.greatzc.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/14 5:01
 */
@RestController
@RequestMapping("/api/type")
public class TypeApi extends BaseController {
    @Autowired
    private ITypeService typeService;

    @GetMapping("/list")
    public TableDataInfo list(Type type) {
        startPage();
        List<TypeVO> list = typeService.getTypeOptions();
        return getDataTable(list);
    }
}
