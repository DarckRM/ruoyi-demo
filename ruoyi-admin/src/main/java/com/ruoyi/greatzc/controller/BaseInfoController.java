package com.ruoyi.greatzc.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.greatzc.domain.About;
import com.ruoyi.greatzc.mapper.AboutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/7 22:34
 */
@RestController
@RequestMapping("/greatzc/baseInfo")
public class BaseInfoController extends BaseController {

    @Autowired
    AboutMapper aboutMapper;

    @GetMapping("/about/{id}")
    public AjaxResult getAbout(@PathVariable("id") Integer id) {
        return success(aboutMapper.selectById(id));
    }

    @Log(title = "企业关于", businessType = BusinessType.UPDATE)
    @PreAuthorize("@ss.hasPermi('greatzc:baseInfo:about:edit')")
    @PutMapping("/about")
    public AjaxResult editAbout(@RequestBody About about) {
        return toAjax(aboutMapper.updateById(about));
    }
}
