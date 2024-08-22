package com.baidu.searchbox.gamecore.person.model;

public abstract class BaseItemData {
    private int mViewType;

    public abstract boolean isValid();

    public void setViewType(int viewType) {
        this.mViewType = viewType;
    }

    public int getViewType() {
        return this.mViewType;
    }
}
