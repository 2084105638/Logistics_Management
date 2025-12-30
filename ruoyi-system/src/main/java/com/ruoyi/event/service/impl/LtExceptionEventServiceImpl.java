package com.ruoyi.event.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.event.mapper.LtExceptionEventMapper;
import com.ruoyi.event.domain.LtExceptionEvent;
import com.ruoyi.event.service.ILtExceptionEventService;

/**
 * 运输异常Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@Service
public class LtExceptionEventServiceImpl implements ILtExceptionEventService 
{
    @Autowired
    private LtExceptionEventMapper ltExceptionEventMapper;

    /**
     * 查询运输异常
     * 
     * @param id 运输异常主键
     * @return 运输异常
     */
    @Override
    public LtExceptionEvent selectLtExceptionEventById(Long id)
    {
        return ltExceptionEventMapper.selectLtExceptionEventById(id);
    }

    /**
     * 查询运输异常列表
     * 
     * @param ltExceptionEvent 运输异常
     * @return 运输异常
     */
    @Override
    public List<LtExceptionEvent> selectLtExceptionEventList(LtExceptionEvent ltExceptionEvent)
    {
        return ltExceptionEventMapper.selectLtExceptionEventList(ltExceptionEvent);
    }

    /**
     * 新增运输异常
     * 
     * @param ltExceptionEvent 运输异常
     * @return 结果
     */
    @Override
    public int insertLtExceptionEvent(LtExceptionEvent ltExceptionEvent)
    {
        return ltExceptionEventMapper.insertLtExceptionEvent(ltExceptionEvent);
    }

    /**
     * 修改运输异常
     * 
     * @param ltExceptionEvent 运输异常
     * @return 结果
     */
    @Override
    public int updateLtExceptionEvent(LtExceptionEvent ltExceptionEvent)
    {
        return ltExceptionEventMapper.updateLtExceptionEvent(ltExceptionEvent);
    }

    /**
     * 批量删除运输异常
     * 
     * @param ids 需要删除的运输异常主键
     * @return 结果
     */
    @Override
    public int deleteLtExceptionEventByIds(Long[] ids)
    {
        return ltExceptionEventMapper.deleteLtExceptionEventByIds(ids);
    }

    /**
     * 删除运输异常信息
     * 
     * @param id 运输异常主键
     * @return 结果
     */
    @Override
    public int deleteLtExceptionEventById(Long id)
    {
        return ltExceptionEventMapper.deleteLtExceptionEventById(id);
    }
}
