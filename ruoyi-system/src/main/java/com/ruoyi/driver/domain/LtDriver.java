package com.ruoyi.driver.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 司机信息对象 LT_driver
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
public class LtDriver extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 司机ID */
    private Long id;

    /** 关联用户ID */
    @Excel(name = "关联用户ID")
    private Long userId;

    /** 司机工号 */
    @Excel(name = "司机工号")
    private String jobNumber;

    /** 驾驶证号 */
    @Excel(name = "驾驶证号")
    private String licenseNo;

    /** 驾驶证类型 */
    @Excel(name = "驾驶证类型")
    private String licenseType;

    /** 领证日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "领证日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date licenseDate;

    /** 状态：1在职 0休息 */
    @Excel(name = "状态：1在职 0休息")
    private Long state;

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

    public void setJobNumber(String jobNumber) 
    {
        this.jobNumber = jobNumber;
    }

    public String getJobNumber() 
    {
        return jobNumber;
    }

    public void setLicenseNo(String licenseNo) 
    {
        this.licenseNo = licenseNo;
    }

    public String getLicenseNo() 
    {
        return licenseNo;
    }

    public void setLicenseType(String licenseType) 
    {
        this.licenseType = licenseType;
    }

    public String getLicenseType() 
    {
        return licenseType;
    }

    public void setLicenseDate(Date licenseDate) 
    {
        this.licenseDate = licenseDate;
    }

    public Date getLicenseDate() 
    {
        return licenseDate;
    }

    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("jobNumber", getJobNumber())
            .append("licenseNo", getLicenseNo())
            .append("licenseType", getLicenseType())
            .append("licenseDate", getLicenseDate())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
