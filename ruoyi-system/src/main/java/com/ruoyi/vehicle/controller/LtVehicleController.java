package com.ruoyi.vehicle.controller;

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
import com.ruoyi.vehicle.domain.LtVehicle;
import com.ruoyi.vehicle.service.ILtVehicleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆Controller
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@RestController
@RequestMapping("/LT/vehicle")
public class LtVehicleController extends BaseController
{
    @Autowired
    private ILtVehicleService ltVehicleService;

    /**
     * 查询车辆列表
     */
    @PreAuthorize("@ss.hasPermi('LT:vehicle:list')")
    @GetMapping("/list")
    public TableDataInfo list(LtVehicle ltVehicle)
    {
        startPage();
        List<LtVehicle> list = ltVehicleService.selectLtVehicleList(ltVehicle);
        return getDataTable(list);
    }

    /**
     * 导出车辆列表
     */
    @PreAuthorize("@ss.hasPermi('LT:vehicle:export')")
    @Log(title = "车辆", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LtVehicle ltVehicle)
    {
        List<LtVehicle> list = ltVehicleService.selectLtVehicleList(ltVehicle);
        ExcelUtil<LtVehicle> util = new ExcelUtil<LtVehicle>(LtVehicle.class);
        util.exportExcel(response, list, "车辆数据");
    }

    /**
     * 获取车辆详细信息
     */
    @PreAuthorize("@ss.hasPermi('LT:vehicle:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(ltVehicleService.selectLtVehicleById(id));
    }

    /**
     * 新增车辆
     */
    @PreAuthorize("@ss.hasPermi('LT:vehicle:add')")
    @Log(title = "车辆", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LtVehicle ltVehicle)
    {
        return toAjax(ltVehicleService.insertLtVehicle(ltVehicle));
    }

    /**
     * 修改车辆
     */
    @PreAuthorize("@ss.hasPermi('LT:vehicle:edit')")
    @Log(title = "车辆", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LtVehicle ltVehicle)
    {
        return toAjax(ltVehicleService.updateLtVehicle(ltVehicle));
    }

    /**
     * 删除车辆
     */
    @PreAuthorize("@ss.hasPermi('LT:vehicle:remove')")
    @Log(title = "车辆", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(ltVehicleService.deleteLtVehicleByIds(ids));
    }
}
