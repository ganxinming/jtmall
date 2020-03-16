package com.jtmall.entity;

import java.io.Serializable;

public class JtbItemcontent implements Serializable {
    private Integer id;

    private String simpleContent;

    private String image;

    private String created;

    private String updated;

    private String editorValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSimpleContent() {
        return simpleContent;
    }

    public void setSimpleContent(String simpleContent) {
        this.simpleContent = simpleContent == null ? null : simpleContent.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created == null ? null : created.trim();
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated == null ? null : updated.trim();
    }

    public String getEditorValue() {
        return editorValue;
    }

    public void setEditorValue(String editorValue) {
        this.editorValue = editorValue == null ? null : editorValue.trim();
    }
}