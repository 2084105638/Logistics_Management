package com.ruoyi.event.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 运输异常对象 LT_exception_event
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
public class LtExceptionEvent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 异常ID */
    private Long id;

    /** 运单ID */
    @Excel(name = "运单ID")
    private Long waybillId;

    /** 司机ID */
    @Excel(name = "司机ID")
    private Long driverId;

    /** 异常类型：堵车/事故/故障 */
    @Excel(name = "异常类型：堵车/事故/故障")
    private String eventType;

    /** 异常说明 */
    @Excel(name = "异常说明")
    private String description;

    /** 处理状态：0未处理 1已处理 */
    @Excel(name = "处理状态：0未处理 1已处理")
    private Long status;

    /** 上报时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上报时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reportTime;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handledTime;

    /** 处理人（调度员） */
    @Excel(name = "处理人", readConverterExp = "调=度员")
    private Long handlerId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setWaybillId(Long waybillId) 
    {
        this.waybillId = waybillId;
    }

    public Long getWaybillId() 
    {
        return waybillId;
    }

    public void setDriverId(Long driverId) 
    {
        this.driverId = driverId;
    }

    public Long getDriverId() 
    {
        return driverId;
    }

    public void setEventType(String eventType) 
    {
        this.eventType = eventType;
    }

    public String getEventType() 
    {
        return eventType;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    public void setReportTime(Date reportTime) 
    {
        this.reportTime = reportTime;
    }

    public Date getReportTime() 
    {
        return reportTime;
    }

    public void setHandledTime(Date handledTime) 
    {
        this.handledTime = handledTime;
    }

    public Date getHandledTime() 
    {
        return handledTime;
    }

    public void setHandlerId(Long handlerId) 
    {
        this.handlerId = handlerId;
    }

    public Long getHandlerId() 
    {
        return handlerId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("waybillId", getWaybillId())
            .append("driverId", getDriverId())
            .append("eventType", getEventType())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("reportTime", getReportTime())
            .append("handledTime", getHandledTime())
            .append("handlerId", getHandlerId())
            .toString();
    }
}
