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
import com.ruoyi.system.domain.cinema.Film;
import com.ruoyi.system.service.IFilmsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 影片Controller
 *
 * @author ruoyi
 * @date 2024-05-21
 */
@RestController
@RequestMapping("/cinema/films")
public class FilmsController extends BaseController {
    @Autowired
    private IFilmsService filmsService;

    /**
     * 查询影片列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:films:list')")
    @GetMapping("/list")
    public TableDataInfo list(Film films) {
        startPage();
        List<Film> list = filmsService.selectFilmsList(films);
        return getDataTable(list);
    }

    /**
     * 导出影片列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:films:export')")
    @Log(title = "影片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Film films) {
        List<Film> list = filmsService.selectFilmsList(films);
        ExcelUtil<Film> util = new ExcelUtil<Film>(Film.class);
        util.exportExcel(response, list, "影片数据");
    }

    /**
     * 获取影片详细信息
     */
    @PreAuthorize("@ss.hasPermi('cinema:films:query')")
    @GetMapping(value = "/{filmId}")
    public AjaxResult getInfo(@PathVariable("filmId") Long filmId) {
        return success(filmsService.selectFilmsByFilmId(filmId));
    }

    /**
     * 新增影片
     */
    @PreAuthorize("@ss.hasPermi('cinema:films:add')")
    @Log(title = "影片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Film films) {
        return toAjax(filmsService.insertFilms(films));
    }

    /**
     * 修改影片
     */
    @PreAuthorize("@ss.hasPermi('cinema:films:edit')")
    @Log(title = "影片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Film films) {
        return toAjax(filmsService.updateFilms(films));
    }

    /**
     * 删除影片
     */
    @PreAuthorize("@ss.hasPermi('cinema:films:remove')")
    @Log(title = "影片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{filmIds}")
    public AjaxResult remove(@PathVariable Long[] filmIds) {
        return toAjax(filmsService.deleteFilmsByFilmIds(filmIds));
    }
}
