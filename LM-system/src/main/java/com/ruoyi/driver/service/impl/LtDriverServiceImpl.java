package com.ruoyi.driver.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.driver.mapper.LtDriverMapper;
import com.ruoyi.driver.domain.LtDriver;
import com.ruoyi.driver.service.ILtDriverService;

/**
 * 司机信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@Service
public class LtDriverServiceImpl implements ILtDriverService 
{
    @Autowired
    private LtDriverMapper ltDriverMapper;

    /**
     * 查询司机信息
     * 
     * @param id 司机信息主键
     * @return 司机信息
     */
    @Override
    public LtDriver selectLtDriverById(Long id)
    {
        return ltDriverMapper.selectLtDriverById(id);
    }

    /**
     * 查询司机信息列表
     * 
     * @param ltDriver 司机信息
     * @return 司机信息
     */
    @Override
    public List<LtDriver> selectLtDriverList(LtDriver ltDriver)
    {
        return ltDriverMapper.selectLtDriverList(ltDriver);
    }

    /**
     * 新增司机信息
     * 
     * @param ltDriver 司机信息
     * @return 结果
     */
    @Override
    public int insertLtDriver(LtDriver ltDriver)
    {
        ltDriver.setCreateTime(DateUtils.getNowDate());
        return ltDriverMapper.insertLtDriver(ltDriver);
    }

    /**
     * 修改司机信息
     * 
     * @param ltDriver 司机信息
     * @return 结果
     */
    @Override
    public int updateLtDriver(LtDriver ltDriver)
    {
        ltDriver.setUpdateTime(DateUtils.getNowDate());
        return ltDriverMapper.updateLtDriver(ltDriver);
    }

    /**
     * 批量删除司机信息
     * 
     * @param ids 需要删除的司机信息主键
     * @return 结果
     */
    @Override
    public int deleteLtDriverByIds(Long[] ids)
    {
        return ltDriverMapper.deleteLtDriverByIds(ids);
    }

    /**
     * 删除司机信息信息
     * 
     * @param id 司机信息主键
     * @return 结果
     */
    @Override
    public int deleteLtDriverById(Long id)
    {
        return ltDriverMapper.deleteLtDriverById(id);
    }
}
