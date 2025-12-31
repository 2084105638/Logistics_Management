package com.ruoyi.operation.controller;

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
import com.ruoyi.operation.domain.LtOperationLog;
import com.ruoyi.operation.service.ILtOperationLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 操作日志Controller
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@RestController
@RequestMapping("/LT/operation")
public class LtOperationLogController extends BaseController
{
    @Autowired
    private ILtOperationLogService ltOperationLogService;

    /**
     * 查询操作日志列表
     */
    @PreAuthorize("@ss.hasPermi('LT:operation:list')")
    @GetMapping("/list")
    public TableDataInfo list(LtOperationLog ltOperationLog)
    {
        startPage();
        List<LtOperationLog> list = ltOperationLogService.selectLtOperationLogList(ltOperationLog);
        return getDataTable(list);
    }

    /**
     * 导出操作日志列表
     */
    @PreAuthorize("@ss.hasPermi('LT:operation:export')")
    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LtOperationLog ltOperationLog)
    {
        List<LtOperationLog> list = ltOperationLogService.selectLtOperationLogList(ltOperationLog);
        ExcelUtil<LtOperationLog> util = new ExcelUtil<LtOperationLog>(LtOperationLog.class);
        util.exportExcel(response, list, "操作日志数据");
    }

    /**
     * 获取操作日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('LT:operation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ltOperationLogService.selectLtOperationLogById(id));
    }

    /**
     * 新增操作日志
     */
    @PreAuthorize("@ss.hasPermi('LT:operation:add')")
    @Log(title = "操作日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LtOperationLog ltOperationLog)
    {
        return toAjax(ltOperationLogService.insertLtOperationLog(ltOperationLog));
    }

    /**
     * 修改操作日志
     */
    @PreAuthorize("@ss.hasPermi('LT:operation:edit')")
    @Log(title = "操作日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LtOperationLog ltOperationLog)
    {
        return toAjax(ltOperationLogService.updateLtOperationLog(ltOperationLog));
    }

    /**
     * 删除操作日志
     */
    @PreAuthorize("@ss.hasPermi('LT:operation:remove')")
    @Log(title = "操作日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ltOperationLogService.deleteLtOperationLogByIds(ids));
    }
}
