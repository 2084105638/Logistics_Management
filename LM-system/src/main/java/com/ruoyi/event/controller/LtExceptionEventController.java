package com.ruoyi.event.controller;

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
import com.ruoyi.event.domain.LtExceptionEvent;
import com.ruoyi.event.service.ILtExceptionEventService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运输异常Controller
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@RestController
@RequestMapping("/LT/event")
public class LtExceptionEventController extends BaseController
{
    @Autowired
    private ILtExceptionEventService ltExceptionEventService;

    /**
     * 查询运输异常列表
     */
    @PreAuthorize("@ss.hasPermi('LT:event:list')")
    @GetMapping("/list")
    public TableDataInfo list(LtExceptionEvent ltExceptionEvent)
    {
        startPage();
        List<LtExceptionEvent> list = ltExceptionEventService.selectLtExceptionEventList(ltExceptionEvent);
        return getDataTable(list);
    }

    /**
     * 导出运输异常列表
     */
    @PreAuthorize("@ss.hasPermi('LT:event:export')")
    @Log(title = "运输异常", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LtExceptionEvent ltExceptionEvent)
    {
        List<LtExceptionEvent> list = ltExceptionEventService.selectLtExceptionEventList(ltExceptionEvent);
        ExcelUtil<LtExceptionEvent> util = new ExcelUtil<LtExceptionEvent>(LtExceptionEvent.class);
        util.exportExcel(response, list, "运输异常数据");
    }

    /**
     * 获取运输异常详细信息
     */
    @PreAuthorize("@ss.hasPermi('LT:event:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ltExceptionEventService.selectLtExceptionEventById(id));
    }

    /**
     * 新增运输异常
     */
    @PreAuthorize("@ss.hasPermi('LT:event:add')")
    @Log(title = "运输异常", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LtExceptionEvent ltExceptionEvent)
    {
        return toAjax(ltExceptionEventService.insertLtExceptionEvent(ltExceptionEvent));
    }

    /**
     * 修改运输异常
     */
    @PreAuthorize("@ss.hasPermi('LT:event:edit')")
    @Log(title = "运输异常", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LtExceptionEvent ltExceptionEvent)
    {
        return toAjax(ltExceptionEventService.updateLtExceptionEvent(ltExceptionEvent));
    }

    /**
     * 删除运输异常
     */
    @PreAuthorize("@ss.hasPermi('LT:event:remove')")
    @Log(title = "运输异常", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ltExceptionEventService.deleteLtExceptionEventByIds(ids));
    }
}
