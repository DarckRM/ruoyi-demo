package com.ruoyi.greatzc.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.greatzc.domain.I18n;
import com.ruoyi.greatzc.service.II18nService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 国际化Controller
 * 
 * @author ruoyi
 * @date 2024-07-14
 */
@RestController
@RequestMapping("/i18n/i18n")
public class I18nController extends BaseController
{
    @Autowired
    private II18nService i18nService;

    /**
     * 查询国际化列表
     */
    @PreAuthorize("@ss.hasPermi('i18n:i18n:list')")
    @GetMapping("/list")
    public TableDataInfo list(I18n i18n)
    {
        startPage();
        List<I18n> list = i18nService.selectI18nList(i18n);
        return getDataTable(list);
    }

    /**
     * 导出国际化列表
     */
    @PreAuthorize("@ss.hasPermi('i18n:i18n:export')")
    @Log(title = "国际化", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, I18n i18n)
    {
        List<I18n> list = i18nService.selectI18nList(i18n);
        ExcelUtil<I18n> util = new ExcelUtil<I18n>(I18n.class);
        util.exportExcel(response, list, "国际化数据");
    }

    /**
     * 获取国际化详细信息
     */
    @PreAuthorize("@ss.hasPermi('i18n:i18n:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(i18nService.selectI18nById(id));
    }

    /**
     * 新增国际化
     */
    @PreAuthorize("@ss.hasPermi('i18n:i18n:add')")
    @Log(title = "国际化", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody I18n i18n)
    {
        return toAjax(i18nService.insertI18n(i18n));
    }

    /**
     * 修改国际化
     */
    @PreAuthorize("@ss.hasPermi('i18n:i18n:edit')")
    @Log(title = "国际化", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody I18n i18n)
    {
        return toAjax(i18nService.updateI18n(i18n));
    }

    /**
     * 删除国际化
     */
    @PreAuthorize("@ss.hasPermi('i18n:i18n:remove')")
    @Log(title = "国际化", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(i18nService.deleteI18nByIds(ids));
    }
}
