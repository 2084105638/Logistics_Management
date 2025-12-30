package com.ruoyi.waybill.controller;

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
import com.ruoyi.waybill.domain.LtWaybill;
import com.ruoyi.waybill.service.ILtWaybillService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运单Controller
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@RestController
@RequestMapping("/LT/waybill")
public class LtWaybillController extends BaseController
{
    @Autowired
    private ILtWaybillService ltWaybillService;

    /**
     * 查询运单列表
     */
    @PreAuthorize("@ss.hasPermi('LT:waybill:list')")
    @GetMapping("/list")
    public TableDataInfo list(LtWaybill ltWaybill)
    {
        startPage();
        List<LtWaybill> list = ltWaybillService.selectLtWaybillList(ltWaybill);
        return getDataTable(list);
    }

    /**
     * 导出运单列表
     */
    @PreAuthorize("@ss.hasPermi('LT:waybill:export')")
    @Log(title = "运单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LtWaybill ltWaybill)
    {
        List<LtWaybill> list = ltWaybillService.selectLtWaybillList(ltWaybill);
        ExcelUtil<LtWaybill> util = new ExcelUtil<LtWaybill>(LtWaybill.class);
        util.exportExcel(response, list, "运单数据");
    }

    /**
     * 获取运单详细信息
     */
    @PreAuthorize("@ss.hasPermi('LT:waybill:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ltWaybillService.selectLtWaybillById(id));
    }

    /**
     * 新增运单
     */
    @PreAuthorize("@ss.hasPermi('LT:waybill:add')")
    @Log(title = "运单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LtWaybill ltWaybill)
    {
        return toAjax(ltWaybillService.insertLtWaybill(ltWaybill));
    }

    /**
     * 修改运单
     */
    @PreAuthorize("@ss.hasPermi('LT:waybill:edit')")
    @Log(title = "运单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LtWaybill ltWaybill)
    {
        return toAjax(ltWaybillService.updateLtWaybill(ltWaybill));
    }

    /**
     * 删除运单
     */
    @PreAuthorize("@ss.hasPermi('LT:waybill:remove')")
    @Log(title = "运单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ltWaybillService.deleteLtWaybillByIds(ids));
    }
}
