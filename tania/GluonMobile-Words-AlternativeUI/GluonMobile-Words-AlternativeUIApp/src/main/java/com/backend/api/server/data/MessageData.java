package com.backend.api.server.data;

import java.io.Serializable;

public class MessageData implements Serializable {

    private static final long serialVersionUID = 7L;
    private boolean categoryRequest;
    private boolean categoryVersionRequest;
    private String categoryName;
    private String name;
    private int detailsIndex = -1;

    public boolean isCategoryVersionRequest() {
        return categoryVersionRequest;
    }

    public void setCategoryVersionRequest(boolean categoryVersionRequest) {
        this.categoryVersionRequest = categoryVersionRequest;
    }

    public boolean isCategoryRequest() {
        return categoryRequest;
    }

    public void setCategoryRequest(boolean categoryRequest) {
        this.categoryRequest = categoryRequest;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDetailsIndex() {
        return detailsIndex;
    }

    public void setDetailsIndex(int detailsIndex) {
        this.detailsIndex = detailsIndex;
    }
}
