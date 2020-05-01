package com.jtmall.cartPojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Badribbit
 * @create 2020/4/24 19:57
 * @Define
 * @Tutorials
 * @Opinion
 */
public class JtbOrderDetail implements Serializable {
    private String orderNum;

    private Float totalPrice;

    private Byte payStatus;

    private String payStatusString;

    private Byte payType;

    private String payTypeString;

    private LocalDateTime payTime;

    private Byte orderStatus;

    private String orderStatusString;

    private String userAddress;

    private LocalDateTime createTime;

    private List<JtbOrderItem> jtbOrderItemList;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }


    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayStatusString() {
        return payStatusString;
    }

    public void setPayStatusString(String payStatusString) {
        this.payStatusString = payStatusString;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public String getPayTypeString() {
        return payTypeString;
    }

    public void setPayTypeString(String payTypeString) {
        this.payTypeString = payTypeString;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusString() {
        return orderStatusString;
    }

    public void setOrderStatusString(String orderStatusString) {
        this.orderStatusString = orderStatusString;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<JtbOrderItem> getJtbOrderItemList() {
        return jtbOrderItemList;
    }

    public void setJtbOrderItemList(List<JtbOrderItem> jtbOrderItemList) {
        this.jtbOrderItemList = jtbOrderItemList;
    }
}
