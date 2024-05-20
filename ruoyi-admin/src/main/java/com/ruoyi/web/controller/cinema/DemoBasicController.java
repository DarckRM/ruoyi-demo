package com.ruoyi.web.controller.cinema;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.demo.Record;
import com.ruoyi.system.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基础测试
 */
@RequestMapping("/demo/")
@RestController
public class DemoBasicController {

    @Autowired
    private IDemoService demoService;

    @GetMapping("list")
    public AjaxResult list() {
        List<Record> data = demoService.selectRecords(null);
        return AjaxResult.success(data);
    }

    @PostMapping("add")
    public AjaxResult add(@RequestBody Record record) {
        int row = demoService.insertRecord(record);
        if (row < 1) {
            return AjaxResult.error("新增失敗");
        }
        return AjaxResult.success();
    }

    @DeleteMapping("delete/{id}")
    public AjaxResult delete(@PathVariable("id") Long id) {
        int row = demoService.deleteRecord(id);
        if (row < 1) {
            return AjaxResult.error("刪除失敗");
        }
        return AjaxResult.success();
    }

    @PutMapping("edit")
    public AjaxResult edit() {
        return null;
    }

    @PostMapping("query")
    public AjaxResult query(@RequestBody Record record) {
        List<Record> data = demoService.selectRecords(record);
        return AjaxResult.success(data);
    }

}
