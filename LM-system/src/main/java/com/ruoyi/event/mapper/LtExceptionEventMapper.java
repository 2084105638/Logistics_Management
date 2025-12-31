package com.ruoyi.event.mapper;

import java.util.List;
import com.ruoyi.event.domain.LtExceptionEvent;

/**
 * 运输异常Mapper接口
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
public interface LtExceptionEventMapper 
{
    /**
     * 查询运输异常
     * 
     * @param id 运输异常主键
     * @return 运输异常
     */
    public LtExceptionEvent selectLtExceptionEventById(Long id);

    /**
     * 查询运输异常列表
     * 
     * @param ltExceptionEvent 运输异常
     * @return 运输异常集合
     */
    public List<LtExceptionEvent> selectLtExceptionEventList(LtExceptionEvent ltExceptionEvent);

    /**
     * 新增运输异常
     * 
     * @param ltExceptionEvent 运输异常
     * @return 结果
     */
    public int insertLtExceptionEvent(LtExceptionEvent ltExceptionEvent);

    /**
     * 修改运输异常
     * 
     * @param ltExceptionEvent 运输异常
     * @return 结果
     */
    public int updateLtExceptionEvent(LtExceptionEvent ltExceptionEvent);

    /**
     * 删除运输异常
     * 
     * @param id 运输异常主键
     * @return 结果
     */
    public int deleteLtExceptionEventById(Long id);

    /**
     * 批量删除运输异常
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLtExceptionEventByIds(Long[] ids);
}
