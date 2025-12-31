package com.ruoyi.operation.service;

import java.util.List;
import com.ruoyi.operation.domain.LtOperationLog;

/**
 * 操作日志Service接口
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
public interface ILtOperationLogService 
{
    /**
     * 查询操作日志
     * 
     * @param id 操作日志主键
     * @return 操作日志
     */
    public LtOperationLog selectLtOperationLogById(Long id);

    /**
     * 查询操作日志列表
     * 
     * @param ltOperationLog 操作日志
     * @return 操作日志集合
     */
    public List<LtOperationLog> selectLtOperationLogList(LtOperationLog ltOperationLog);

    /**
     * 新增操作日志
     * 
     * @param ltOperationLog 操作日志
     * @return 结果
     */
    public int insertLtOperationLog(LtOperationLog ltOperationLog);

    /**
     * 修改操作日志
     * 
     * @param ltOperationLog 操作日志
     * @return 结果
     */
    public int updateLtOperationLog(LtOperationLog ltOperationLog);

    /**
     * 批量删除操作日志
     * 
     * @param ids 需要删除的操作日志主键集合
     * @return 结果
     */
    public int deleteLtOperationLogByIds(Long[] ids);

    /**
     * 删除操作日志信息
     * 
     * @param id 操作日志主键
     * @return 结果
     */
    public int deleteLtOperationLogById(Long id);
}
