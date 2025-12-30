package com.ruoyi.waybill.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.waybill.mapper.LtWaybillMapper;
import com.ruoyi.waybill.domain.LtWaybill;
import com.ruoyi.waybill.service.ILtWaybillService;

/**
 * 运单Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@Service
public class LtWaybillServiceImpl implements ILtWaybillService 
{
    @Autowired
    private LtWaybillMapper ltWaybillMapper;

    /**
     * 查询运单
     * 
     * @param id 运单主键
     * @return 运单
     */
    @Override
    public LtWaybill selectLtWaybillById(Long id)
    {
        return ltWaybillMapper.selectLtWaybillById(id);
    }

    /**
     * 查询运单列表
     * 
     * @param ltWaybill 运单
     * @return 运单
     */
    @Override
    public List<LtWaybill> selectLtWaybillList(LtWaybill ltWaybill)
    {
        return ltWaybillMapper.selectLtWaybillList(ltWaybill);
    }

    /**
     * 新增运单
     * 
     * @param ltWaybill 运单
     * @return 结果
     */
    @Override
    public int insertLtWaybill(LtWaybill ltWaybill)
    {
        ltWaybill.setCreateTime(DateUtils.getNowDate());
        return ltWaybillMapper.insertLtWaybill(ltWaybill);
    }

    /**
     * 修改运单
     * 
     * @param ltWaybill 运单
     * @return 结果
     */
    @Override
    public int updateLtWaybill(LtWaybill ltWaybill)
    {
        ltWaybill.setUpdateTime(DateUtils.getNowDate());
        return ltWaybillMapper.updateLtWaybill(ltWaybill);
    }

    /**
     * 批量删除运单
     * 
     * @param ids 需要删除的运单主键
     * @return 结果
     */
    @Override
    public int deleteLtWaybillByIds(Long[] ids)
    {
        return ltWaybillMapper.deleteLtWaybillByIds(ids);
    }

    /**
     * 删除运单信息
     * 
     * @param id 运单主键
     * @return 结果
     */
    @Override
    public int deleteLtWaybillById(Long id)
    {
        return ltWaybillMapper.deleteLtWaybillById(id);
    }
}
