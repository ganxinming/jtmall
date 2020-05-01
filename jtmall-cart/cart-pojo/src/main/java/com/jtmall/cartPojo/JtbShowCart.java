package com.jtmall.cartPojo;

import java.io.Serializable;

/**
 * @Author Badribbit
 * @create 2020/4/20 19:42
 * @Define
 * @Tutorials
 * @Opinion
 */
public class JtbShowCart implements Serializable {
    private String goodsName;
    private String imageUrl;
    private int cartItemId;
    private int goodsCount;
    private Float price;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
