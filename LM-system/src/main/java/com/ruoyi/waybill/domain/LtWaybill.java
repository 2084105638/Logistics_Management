package com.ruoyi.waybill.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 运单对象 LT_waybill
 * 
 * @author ruoyi
 * @date 2025-12-30
 */
public class LtWaybill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 运单ID */
    private Long id;

    /** 运单编号 */
    @Excel(name = "运单编号")
    private String waybillNo;

    /** 货主ID */
    @Excel(name = "货主ID")
    private Long shipperId;

    /** 调度员ID */
    @Excel(name = "调度员ID")
    private Long dispatcherId;

    /** 司机ID */
    @Excel(name = "司机ID")
    private Long driverId;

    /** 车辆ID */
    @Excel(name = "车辆ID")
    private Long vehicleId;

    /** 货物描述 */
    @Excel(name = "货物描述")
    private String cargoInfo;

    /** 重量（kg） */
    @Excel(name = "重量", readConverterExp = "k=g")
    private BigDecimal weight;

    /** 体积（m³） */
    @Excel(name = "体积", readConverterExp = "m=³")
    private BigDecimal volume;

    /** 发货人 */
    @Excel(name = "发货人")
    private String senderName;

    /** 发货人电话 */
    @Excel(name = "发货人电话")
    private String senderPhone;

    /** 发货地址 */
    @Excel(name = "发货地址")
    private String senderAddress;

    /** 收货人 */
    @Excel(name = "收货人")
    private String receiverName;

    /** 收货人电话 */
    @Excel(name = "收货人电话")
    private String receiverPhone;

    /** 收货地址 */
    @Excel(name = "收货地址")
    private String receiverAddress;

    /** 期望到达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "期望到达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectedTime;

    /** 开始运输时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始运输时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pickupTime;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishTime;

    /** 状态：0待派车 1运输中 2已完成 */
    @Excel(name = "状态：0待派车 1运输中 2已完成")
    private Long status;

    /** 运费 */
    @Excel(name = "运费")
    private BigDecimal fee;

    /** 是否支付：0否 1是 */
    @Excel(name = "是否支付：0否 1是")
    private Long paid;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /** 电子回单路径 */
    @Excel(name = "电子回单路径")
    private String receiptPath;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setWaybillNo(String waybillNo) 
    {
        this.waybillNo = waybillNo;
    }

    public String getWaybillNo() 
    {
        return waybillNo;
    }

    public void setShipperId(Long shipperId) 
    {
        this.shipperId = shipperId;
    }

    public Long getShipperId() 
    {
        return shipperId;
    }

    public void setDispatcherId(Long dispatcherId) 
    {
        this.dispatcherId = dispatcherId;
    }

    public Long getDispatcherId() 
    {
        return dispatcherId;
    }

    public void setDriverId(Long driverId) 
    {
        this.driverId = driverId;
    }

    public Long getDriverId() 
    {
        return driverId;
    }

    public void setVehicleId(Long vehicleId) 
    {
        this.vehicleId = vehicleId;
    }

    public Long getVehicleId() 
    {
        return vehicleId;
    }

    public void setCargoInfo(String cargoInfo) 
    {
        this.cargoInfo = cargoInfo;
    }

    public String getCargoInfo() 
    {
        return cargoInfo;
    }

    public void setWeight(BigDecimal weight) 
    {
        this.weight = weight;
    }

    public BigDecimal getWeight() 
    {
        return weight;
    }

    public void setVolume(BigDecimal volume) 
    {
        this.volume = volume;
    }

    public BigDecimal getVolume() 
    {
        return volume;
    }

    public void setSenderName(String senderName) 
    {
        this.senderName = senderName;
    }

    public String getSenderName() 
    {
        return senderName;
    }

    public void setSenderPhone(String senderPhone) 
    {
        this.senderPhone = senderPhone;
    }

    public String getSenderPhone() 
    {
        return senderPhone;
    }

    public void setSenderAddress(String senderAddress) 
    {
        this.senderAddress = senderAddress;
    }

    public String getSenderAddress() 
    {
        return senderAddress;
    }

    public void setReceiverName(String receiverName) 
    {
        this.receiverName = receiverName;
    }

    public String getReceiverName() 
    {
        return receiverName;
    }

    public void setReceiverPhone(String receiverPhone) 
    {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPhone() 
    {
        return receiverPhone;
    }

    public void setReceiverAddress(String receiverAddress) 
    {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverAddress() 
    {
        return receiverAddress;
    }

    public void setExpectedTime(Date expectedTime) 
    {
        this.expectedTime = expectedTime;
    }

    public Date getExpectedTime() 
    {
        return expectedTime;
    }

    public void setPickupTime(Date pickupTime) 
    {
        this.pickupTime = pickupTime;
    }

    public Date getPickupTime() 
    {
        return pickupTime;
    }

    public void setFinishTime(Date finishTime) 
    {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() 
    {
        return finishTime;
    }

    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    public void setFee(BigDecimal fee) 
    {
        this.fee = fee;
    }

    public BigDecimal getFee() 
    {
        return fee;
    }

    public void setPaid(Long paid) 
    {
        this.paid = paid;
    }

    public Long getPaid() 
    {
        return paid;
    }

    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
    }

    public void setReceiptPath(String receiptPath) 
    {
        this.receiptPath = receiptPath;
    }

    public String getReceiptPath() 
    {
        return receiptPath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("waybillNo", getWaybillNo())
            .append("shipperId", getShipperId())
            .append("dispatcherId", getDispatcherId())
            .append("driverId", getDriverId())
            .append("vehicleId", getVehicleId())
            .append("cargoInfo", getCargoInfo())
            .append("weight", getWeight())
            .append("volume", getVolume())
            .append("senderName", getSenderName())
            .append("senderPhone", getSenderPhone())
            .append("senderAddress", getSenderAddress())
            .append("receiverName", getReceiverName())
            .append("receiverPhone", getReceiverPhone())
            .append("receiverAddress", getReceiverAddress())
            .append("expectedTime", getExpectedTime())
            .append("pickupTime", getPickupTime())
            .append("finishTime", getFinishTime())
            .append("status", getStatus())
            .append("fee", getFee())
            .append("paid", getPaid())
            .append("payTime", getPayTime())
            .append("receiptPath", getReceiptPath())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
