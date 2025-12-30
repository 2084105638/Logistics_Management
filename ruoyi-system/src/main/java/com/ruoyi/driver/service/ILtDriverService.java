package com.ruoyi.driver.service;

import java.util.List;
import com.ruoyi.driver.domain.LtDriver;

/**
 * 司机信息Service接口
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
public interface ILtDriverService 
{
    /**
     * 查询司机信息
     * 
     * @param id 司机信息主键
     * @return 司机信息
     */
    public LtDriver selectLtDriverById(Long id);

    /**
     * 查询司机信息列表
     * 
     * @param ltDriver 司机信息
     * @return 司机信息集合
     */
    public List<LtDriver> selectLtDriverList(LtDriver ltDriver);

    /**
     * 新增司机信息
     * 
     * @param ltDriver 司机信息
     * @return 结果
     */
    public int insertLtDriver(LtDriver ltDriver);

    /**
     * 修改司机信息
     * 
     * @param ltDriver 司机信息
     * @return 结果
     */
    public int updateLtDriver(LtDriver ltDriver);

    /**
     * 批量删除司机信息
     * 
     * @param ids 需要删除的司机信息主键集合
     * @return 结果
     */
    public int deleteLtDriverByIds(Long[] ids);

    /**
     * 删除司机信息信息
     * 
     * @param id 司机信息主键
     * @return 结果
     */
    public int deleteLtDriverById(Long id);
}
