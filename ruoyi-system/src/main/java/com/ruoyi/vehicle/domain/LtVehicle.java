package com.ruoyi.vehicle.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 车辆对象 LT_vehicle
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
public class LtVehicle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车辆ID */
    private Long id;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String licensePlate;

    /** 车辆型号 */
    @Excel(name = "车辆型号")
    private String model;

    /** 载重（吨） */
    @Excel(name = "载重", readConverterExp = "吨=")
    private BigDecimal capacity;

    /** 容积（立方米） */
    @Excel(name = "容积", readConverterExp = "立=方米")
    private BigDecimal volume;

    /** 状态：1可用 0维修中 */
    @Excel(name = "状态：1可用 0维修中")
    private Long state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setLicensePlate(String licensePlate) 
    {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() 
    {
        return licensePlate;
    }

    public void setModel(String model) 
    {
        this.model = model;
    }

    public String getModel() 
    {
        return model;
    }

    public void setCapacity(BigDecimal capacity) 
    {
        this.capacity = capacity;
    }

    public BigDecimal getCapacity() 
    {
        return capacity;
    }

    public void setVolume(BigDecimal volume) 
    {
        this.volume = volume;
    }

    public BigDecimal getVolume() 
    {
        return volume;
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
            .append("licensePlate", getLicensePlate())
            .append("model", getModel())
            .append("capacity", getCapacity())
            .append("volume", getVolume())
            .append("state", getState())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
