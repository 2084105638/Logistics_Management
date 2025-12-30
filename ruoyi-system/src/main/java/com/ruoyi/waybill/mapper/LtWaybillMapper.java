package com.ruoyi.waybill.mapper;

import java.util.List;
import com.ruoyi.waybill.domain.LtWaybill;

/**
 * 运单Mapper接口
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
public interface LtWaybillMapper 
{
    /**
     * 查询运单
     * 
     * @param id 运单主键
     * @return 运单
     */
    public LtWaybill selectLtWaybillById(Long id);

    /**
     * 查询运单列表
     * 
     * @param ltWaybill 运单
     * @return 运单集合
     */
    public List<LtWaybill> selectLtWaybillList(LtWaybill ltWaybill);

    /**
     * 新增运单
     * 
     * @param ltWaybill 运单
     * @return 结果
     */
    public int insertLtWaybill(LtWaybill ltWaybill);

    /**
     * 修改运单
     * 
     * @param ltWaybill 运单
     * @return 结果
     */
    public int updateLtWaybill(LtWaybill ltWaybill);

    /**
     * 删除运单
     * 
     * @param id 运单主键
     * @return 结果
     */
    public int deleteLtWaybillById(Long id);

    /**
     * 批量删除运单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLtWaybillByIds(Long[] ids);
}
