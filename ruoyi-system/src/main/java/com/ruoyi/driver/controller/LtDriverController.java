package com.ruoyi.driver.controller;

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
import com.ruoyi.driver.domain.LtDriver;
import com.ruoyi.driver.service.ILtDriverService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 司机信息Controller
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@RestController
@RequestMapping("/LT/driver")
public class LtDriverController extends BaseController
{
    @Autowired
    private ILtDriverService ltDriverService;

    /**
     * 查询司机信息列表
     */
    @PreAuthorize("@ss.hasPermi('LT:driver:list')")
    @GetMapping("/list")
    public TableDataInfo list(LtDriver ltDriver)
    {
        startPage();
        List<LtDriver> list = ltDriverService.selectLtDriverList(ltDriver);
        return getDataTable(list);
    }

    /**
     * 导出司机信息列表
     */
    @PreAuthorize("@ss.hasPermi('LT:driver:export')")
    @Log(title = "司机信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LtDriver ltDriver)
    {
        List<LtDriver> list = ltDriverService.selectLtDriverList(ltDriver);
        ExcelUtil<LtDriver> util = new ExcelUtil<LtDriver>(LtDriver.class);
        util.exportExcel(response, list, "司机信息数据");
    }

    /**
     * 获取司机信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('LT:driver:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ltDriverService.selectLtDriverById(id));
    }

    /**
     * 新增司机信息
     */
    @PreAuthorize("@ss.hasPermi('LT:driver:add')")
    @Log(title = "司机信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LtDriver ltDriver)
    {
        return toAjax(ltDriverService.insertLtDriver(ltDriver));
    }

    /**
     * 修改司机信息
     */
    @PreAuthorize("@ss.hasPermi('LT:driver:edit')")
    @Log(title = "司机信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LtDriver ltDriver)
    {
        return toAjax(ltDriverService.updateLtDriver(ltDriver));
    }

    /**
     * 删除司机信息
     */
    @PreAuthorize("@ss.hasPermi('LT:driver:remove')")
    @Log(title = "司机信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ltDriverService.deleteLtDriverByIds(ids));
    }
}
