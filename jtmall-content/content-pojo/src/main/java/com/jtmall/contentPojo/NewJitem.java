package com.jtmall.contentPojo;

import java.io.Serializable;

/**
 * @Author Badribbit
 * @create 2020/3/25 21:33
 * @Define
 * @Tutorials
 * @Opinion
 */
public class NewJitem implements Serializable {
    private Integer id;

    private String title;

    private Float price;

    private String image;

    private String simpleContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSimpleContent() {
        return simpleContent;
    }

    public void setSimpleContent(String simpleContent) {
        this.simpleContent = simpleContent;
    }
}
