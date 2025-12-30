package com.ruoyi.vehicle.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.vehicle.mapper.LtVehicleMapper;
import com.ruoyi.vehicle.domain.LtVehicle;
import com.ruoyi.vehicle.service.ILtVehicleService;

/**
 * 车辆Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@Service
public class LtVehicleServiceImpl implements ILtVehicleService 
{
    @Autowired
    private LtVehicleMapper ltVehicleMapper;

    /**
     * 查询车辆
     * 
     * @param id 车辆主键
     * @return 车辆
     */
    @Override
    public LtVehicle selectLtVehicleById(Long id)
    {
        return ltVehicleMapper.selectLtVehicleById(id);
    }

    /**
     * 查询车辆列表
     * 
     * @param ltVehicle 车辆
     * @return 车辆
     */
    @Override
    public List<LtVehicle> selectLtVehicleList(LtVehicle ltVehicle)
    {
        return ltVehicleMapper.selectLtVehicleList(ltVehicle);
    }

    /**
     * 新增车辆
     * 
     * @param ltVehicle 车辆
     * @return 结果
     */
    @Override
    public int insertLtVehicle(LtVehicle ltVehicle)
    {
        ltVehicle.setCreateTime(DateUtils.getNowDate());
        return ltVehicleMapper.insertLtVehicle(ltVehicle);
    }

    /**
     * 修改车辆
     * 
     * @param ltVehicle 车辆
     * @return 结果
     */
    @Override
    public int updateLtVehicle(LtVehicle ltVehicle)
    {
        ltVehicle.setUpdateTime(DateUtils.getNowDate());
        return ltVehicleMapper.updateLtVehicle(ltVehicle);
    }

    /**
     * 批量删除车辆
     * 
     * @param ids 需要删除的车辆主键
     * @return 结果
     */
    @Override
    public int deleteLtVehicleByIds(Long[] ids)
    {
        return ltVehicleMapper.deleteLtVehicleByIds(ids);
    }

    /**
     * 删除车辆信息
     * 
     * @param id 车辆主键
     * @return 结果
     */
    @Override
    public int deleteLtVehicleById(Long id)
    {
        return ltVehicleMapper.deleteLtVehicleById(id);
    }
}
