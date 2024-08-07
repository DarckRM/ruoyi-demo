package com.ruoyi.greatzc.api;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.EnvUtil;
import com.ruoyi.greatzc.domain.About;
import com.ruoyi.greatzc.mapper.AboutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/8 0:35
 */
@RestController
@RequestMapping("/api/baseInfo")
public class BaseInfoApi extends BaseController {

    @Autowired
    AboutMapper aboutMapper;

    @GetMapping("/about/{id}")
    public AjaxResult getAbout(@PathVariable("id") Integer id) {
        About about = aboutMapper.selectById(id);
        about.setContent(about.getContent().replace("/dev-api/", EnvUtil.BASE_URL));
        return success(about);
    }
}
