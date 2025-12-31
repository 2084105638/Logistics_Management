package com.ruoyi.vehicle.mapper;

import java.util.List;
import com.ruoyi.vehicle.domain.LtVehicle;

/**
 * 车辆Mapper接口
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
public interface LtVehicleMapper 
{
    /**
     * 查询车辆
     * 
     * @param id 车辆主键
     * @return 车辆
     */
    public LtVehicle selectLtVehicleById(Long id);

    /**
     * 查询车辆列表
     * 
     * @param ltVehicle 车辆
     * @return 车辆集合
     */
    public List<LtVehicle> selectLtVehicleList(LtVehicle ltVehicle);

    /**
     * 新增车辆
     * 
     * @param ltVehicle 车辆
     * @return 结果
     */
    public int insertLtVehicle(LtVehicle ltVehicle);

    /**
     * 修改车辆
     * 
     * @param ltVehicle 车辆
     * @return 结果
     */
    public int updateLtVehicle(LtVehicle ltVehicle);

    /**
     * 删除车辆
     * 
     * @param id 车辆主键
     * @return 结果
     */
    public int deleteLtVehicleById(Long id);

    /**
     * 批量删除车辆
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLtVehicleByIds(Long[] ids);
}
