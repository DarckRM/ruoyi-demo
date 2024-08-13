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
import com.ruoyi.greatzc.domain.Type;
import com.ruoyi.greatzc.service.ITypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻分类Controller
 * 
 * @author ruoyi
 * @date 2024-08-14
 */
@RestController
@RequestMapping("/greatzc/type")
public class TypeController extends BaseController
{
    @Autowired
    private ITypeService typeService;

    /**
     * 查询新闻分类列表
     */
    @PreAuthorize("@ss.hasPermi('greatzc:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(Type type)
    {
        startPage();
        List<Type> list = typeService.selectTypeList(type);
        return getDataTable(list);
    }

    /**
     * 导出新闻分类列表
     */
    @PreAuthorize("@ss.hasPermi('greatzc:type:export')")
    @Log(title = "新闻分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Type type)
    {
        List<Type> list = typeService.selectTypeList(type);
        ExcelUtil<Type> util = new ExcelUtil<Type>(Type.class);
        util.exportExcel(response, list, "新闻分类数据");
    }

    /**
     * 获取新闻分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('greatzc:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(typeService.selectTypeById(id));
    }

    /**
     * 新增新闻分类
     */
    @PreAuthorize("@ss.hasPermi('greatzc:type:add')")
    @Log(title = "新闻分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Type type)
    {
        return toAjax(typeService.insertType(type));
    }

    /**
     * 修改新闻分类
     */
    @PreAuthorize("@ss.hasPermi('greatzc:type:edit')")
    @Log(title = "新闻分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Type type)
    {
        return toAjax(typeService.updateType(type));
    }

    /**
     * 删除新闻分类
     */
    @PreAuthorize("@ss.hasPermi('greatzc:type:remove')")
    @Log(title = "新闻分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(typeService.deleteTypeByIds(ids));
    }
}
