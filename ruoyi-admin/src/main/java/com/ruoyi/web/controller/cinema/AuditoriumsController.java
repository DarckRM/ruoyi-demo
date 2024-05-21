package com.ruoyi.web.controller.cinema;

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
import com.ruoyi.system.domain.cinema.Auditoriums;
import com.ruoyi.system.service.IAuditoriumsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 影厅Controller
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
@RestController
@RequestMapping("/cinema/auditoriums")
public class AuditoriumsController extends BaseController
{
    @Autowired
    private IAuditoriumsService auditoriumsService;

    /**
     * 查询影厅列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:auditoriums:list')")
    @GetMapping("/list")
    public TableDataInfo list(Auditoriums auditoriums)
    {
        startPage();
        List<Auditoriums> list = auditoriumsService.selectAuditoriumsList(auditoriums);
        return getDataTable(list);
    }

    /**
     * 导出影厅列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:auditoriums:export')")
    @Log(title = "影厅", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Auditoriums auditoriums)
    {
        List<Auditoriums> list = auditoriumsService.selectAuditoriumsList(auditoriums);
        ExcelUtil<Auditoriums> util = new ExcelUtil<Auditoriums>(Auditoriums.class);
        util.exportExcel(response, list, "影厅数据");
    }

    /**
     * 获取影厅详细信息
     */
    @PreAuthorize("@ss.hasPermi('cinema:auditoriums:query')")
    @GetMapping(value = "/{auditoriumId}")
    public AjaxResult getInfo(@PathVariable("auditoriumId") Long auditoriumId)
    {
        return success(auditoriumsService.selectAuditoriumsByAuditoriumId(auditoriumId));
    }

    /**
     * 新增影厅
     */
    @PreAuthorize("@ss.hasPermi('cinema:auditoriums:add')")
    @Log(title = "影厅", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Auditoriums auditoriums)
    {
        return toAjax(auditoriumsService.insertAuditoriums(auditoriums));
    }

    /**
     * 修改影厅
     */
    @PreAuthorize("@ss.hasPermi('cinema:auditoriums:edit')")
    @Log(title = "影厅", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Auditoriums auditoriums)
    {
        return toAjax(auditoriumsService.updateAuditoriums(auditoriums));
    }

    /**
     * 删除影厅
     */
    @PreAuthorize("@ss.hasPermi('cinema:auditoriums:remove')")
    @Log(title = "影厅", businessType = BusinessType.DELETE)
	@DeleteMapping("/{auditoriumIds}")
    public AjaxResult remove(@PathVariable Long[] auditoriumIds)
    {
        return toAjax(auditoriumsService.deleteAuditoriumsByAuditoriumIds(auditoriumIds));
    }
}
