package com.ruoyi.greatzc.api;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.greatzc.domain.Message;
import com.ruoyi.greatzc.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author akarin
 * @version 1.0
 * @description TODO))
 * @date 2024/8/14 2:12
 */
@RestController
@RequestMapping("/api/message")
public class MessageApi extends BaseController {

    @Autowired
    IMessageService messageService;

    @PostMapping
    public AjaxResult add(@RequestBody Message message)
    {
        if (ObjectUtils.isEmpty(message))
            return AjaxResult.error("Please input correct query content");

        if (ObjectUtils.isEmpty(message.getContent()))
            return AjaxResult.error("Please input content");

        return toAjax(messageService.insertMessage(message));
    }



}
