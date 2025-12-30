package com.ruoyi.operation.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.operation.mapper.LtOperationLogMapper;
import com.ruoyi.operation.domain.LtOperationLog;
import com.ruoyi.operation.service.ILtOperationLogService;

/**
 * 操作日志Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
@Service
public class LtOperationLogServiceImpl implements ILtOperationLogService 
{
    @Autowired
    private LtOperationLogMapper ltOperationLogMapper;

    /**
     * 查询操作日志
     * 
     * @param id 操作日志主键
     * @return 操作日志
     */
    @Override
    public LtOperationLog selectLtOperationLogById(Long id)
    {
        return ltOperationLogMapper.selectLtOperationLogById(id);
    }

    /**
     * 查询操作日志列表
     * 
     * @param ltOperationLog 操作日志
     * @return 操作日志
     */
    @Override
    public List<LtOperationLog> selectLtOperationLogList(LtOperationLog ltOperationLog)
    {
        return ltOperationLogMapper.selectLtOperationLogList(ltOperationLog);
    }

    /**
     * 新增操作日志
     * 
     * @param ltOperationLog 操作日志
     * @return 结果
     */
    @Override
    public int insertLtOperationLog(LtOperationLog ltOperationLog)
    {
        ltOperationLog.setCreateTime(DateUtils.getNowDate());
        return ltOperationLogMapper.insertLtOperationLog(ltOperationLog);
    }

    /**
     * 修改操作日志
     * 
     * @param ltOperationLog 操作日志
     * @return 结果
     */
    @Override
    public int updateLtOperationLog(LtOperationLog ltOperationLog)
    {
        return ltOperationLogMapper.updateLtOperationLog(ltOperationLog);
    }

    /**
     * 批量删除操作日志
     * 
     * @param ids 需要删除的操作日志主键
     * @return 结果
     */
    @Override
    public int deleteLtOperationLogByIds(Long[] ids)
    {
        return ltOperationLogMapper.deleteLtOperationLogByIds(ids);
    }

    /**
     * 删除操作日志信息
     * 
     * @param id 操作日志主键
     * @return 结果
     */
    @Override
    public int deleteLtOperationLogById(Long id)
    {
        return ltOperationLogMapper.deleteLtOperationLogById(id);
    }
}
