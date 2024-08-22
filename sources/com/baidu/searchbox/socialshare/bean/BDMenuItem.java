package com.baidu.searchbox.socialshare.bean;

import android.text.TextUtils;
import com.baidu.share.widget.MenuItemWrapper;

public class BDMenuItem {
    private String iconUrl;
    private String identifier;
    private int position = -1;
    private int resId = -1;
    public boolean showFunctionTips;
    private String text;
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type2) {
        this.type = type2;
    }

    public int getResId() {
        return this.resId;
    }

    public void setResId(int resId2) {
        this.resId = resId2;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text2) {
        this.text = text2;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position2) {
        this.position = position2;
    }

    public static BDMenuItem getInstance(MenuItemWrapper wrapper) {
        if (wrapper == null) {
            return null;
        }
        BDMenuItem bdMenuItem = new BDMenuItem();
        if (wrapper.type != null) {
            bdMenuItem.type = wrapper.type.getName();
        }
        bdMenuItem.text = wrapper.text;
        bdMenuItem.resId = wrapper.resId;
        bdMenuItem.iconUrl = wrapper.iconUrl;
        return bdMenuItem;
    }

    public boolean isShowFunctionTips() {
        return this.showFunctionTips;
    }

    public void setShowFunctionTips(boolean showFunctionTips2) {
        this.showFunctionTips = showFunctionTips2;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier2) {
        this.identifier = identifier2;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl2) {
        this.iconUrl = iconUrl2;
    }

    public boolean isValid() {
        return (this.resId != -1 || !TextUtils.isEmpty(this.iconUrl)) && !TextUtils.isEmpty(this.text) && this.position >= 0;
    }
}
