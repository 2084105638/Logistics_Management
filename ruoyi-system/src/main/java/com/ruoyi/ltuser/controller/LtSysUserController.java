package com.ruoyi.ltuser.controller;

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
import com.ruoyi.ltuser.domain.LtSysUser;
import com.ruoyi.ltuser.service.ILtSysUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统用户Controller
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@RestController
@RequestMapping("/LT/ltuser")
public class LtSysUserController extends BaseController
{
    @Autowired
    private ILtSysUserService ltSysUserService;

    /**
     * 查询系统用户列表
     */
    @PreAuthorize("@ss.hasPermi('LT:ltuser:list')")
    @GetMapping("/list")
    public TableDataInfo list(LtSysUser ltSysUser)
    {
        startPage();
        List<LtSysUser> list = ltSysUserService.selectLtSysUserList(ltSysUser);
        return getDataTable(list);
    }

    /**
     * 导出系统用户列表
     */
    @PreAuthorize("@ss.hasPermi('LT:ltuser:export')")
    @Log(title = "系统用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LtSysUser ltSysUser)
    {
        List<LtSysUser> list = ltSysUserService.selectLtSysUserList(ltSysUser);
        ExcelUtil<LtSysUser> util = new ExcelUtil<LtSysUser>(LtSysUser.class);
        util.exportExcel(response, list, "系统用户数据");
    }

    /**
     * 获取系统用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('LT:ltuser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ltSysUserService.selectLtSysUserById(id));
    }

    /**
     * 新增系统用户
     */
    @PreAuthorize("@ss.hasPermi('LT:ltuser:add')")
    @Log(title = "系统用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LtSysUser ltSysUser)
    {
        return toAjax(ltSysUserService.insertLtSysUser(ltSysUser));
    }

    /**
     * 修改系统用户
     */
    @PreAuthorize("@ss.hasPermi('LT:ltuser:edit')")
    @Log(title = "系统用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LtSysUser ltSysUser)
    {
        return toAjax(ltSysUserService.updateLtSysUser(ltSysUser));
    }

    /**
     * 删除系统用户
     */
    @PreAuthorize("@ss.hasPermi('LT:ltuser:remove')")
    @Log(title = "系统用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ltSysUserService.deleteLtSysUserByIds(ids));
    }
}
