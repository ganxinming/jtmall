package com.jtmall.cartPojo;

import java.io.Serializable;

public class JtbOrderItem implements Serializable {
    private Integer orderItemId;

    private Integer orderId;

    private Integer itemId;

    private String itemName;

    private String itemImgurl;

    private Float itemPrice;

    private Integer itemCount;

    private String createTime;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemImgurl() {
        return itemImgurl;
    }

    public void setItemImgurl(String itemImgurl) {
        this.itemImgurl = itemImgurl == null ? null : itemImgurl.trim();
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}