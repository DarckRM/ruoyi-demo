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
import com.ruoyi.system.domain.cinema.Members;
import com.ruoyi.system.service.IMembersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员Controller
 * 
 * @author ruoyi
 * @date 2024-05-21
 */
@RestController
@RequestMapping("/cinema/members")
public class MembersController extends BaseController
{
    @Autowired
    private IMembersService membersService;

    /**
     * 查询会员列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:members:list')")
    @GetMapping("/list")
    public TableDataInfo list(Members members)
    {
        startPage();
        List<Members> list = membersService.selectMembersList(members);
        return getDataTable(list);
    }

    /**
     * 导出会员列表
     */
    @PreAuthorize("@ss.hasPermi('cinema:members:export')")
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Members members)
    {
        List<Members> list = membersService.selectMembersList(members);
        ExcelUtil<Members> util = new ExcelUtil<Members>(Members.class);
        util.exportExcel(response, list, "会员数据");
    }

    /**
     * 获取会员详细信息
     */
    @PreAuthorize("@ss.hasPermi('cinema:members:query')")
    @GetMapping(value = "/{memberId}")
    public AjaxResult getInfo(@PathVariable("memberId") Long memberId)
    {
        return success(membersService.selectMembersByMemberId(memberId));
    }

    /**
     * 新增会员
     */
    @PreAuthorize("@ss.hasPermi('cinema:members:add')")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Members members)
    {
        return toAjax(membersService.insertMembers(members));
    }

    /**
     * 修改会员
     */
    @PreAuthorize("@ss.hasPermi('cinema:members:edit')")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Members members)
    {
        return toAjax(membersService.updateMembers(members));
    }

    /**
     * 删除会员
     */
    @PreAuthorize("@ss.hasPermi('cinema:members:remove')")
    @Log(title = "会员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{memberIds}")
    public AjaxResult remove(@PathVariable Long[] memberIds)
    {
        return toAjax(membersService.deleteMembersByMemberIds(memberIds));
    }
}
