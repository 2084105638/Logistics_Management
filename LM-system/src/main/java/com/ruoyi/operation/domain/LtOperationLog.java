package com.ruoyi.operation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 操作日志对象 LT_operation_log
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
public class LtOperationLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 日志ID */
    private Long id;

    /** 操作人ID */
    @Excel(name = "操作人ID")
    private Long userId;

    /** 操作内容 */
    @Excel(name = "操作内容")
    private String operation;

    /** 方法名 */
    @Excel(name = "方法名")
    private String method;

    /** IP地址 */
    @Excel(name = "IP地址")
    private String ip;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setOperation(String operation) 
    {
        this.operation = operation;
    }

    public String getOperation() 
    {
        return operation;
    }

    public void setMethod(String method) 
    {
        this.method = method;
    }

    public String getMethod() 
    {
        return method;
    }

    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("operation", getOperation())
            .append("method", getMethod())
            .append("ip", getIp())
            .append("createTime", getCreateTime())
            .toString();
    }
}
