package com.ruoyi.driver.mapper;

import java.util.List;
import com.ruoyi.driver.domain.LtDriver;

/**
 * 司机信息Mapper接口
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
public interface LtDriverMapper 
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
     * 删除司机信息
     * 
     * @param id 司机信息主键
     * @return 结果
     */
    public int deleteLtDriverById(Long id);

    /**
     * 批量删除司机信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLtDriverByIds(Long[] ids);
}
