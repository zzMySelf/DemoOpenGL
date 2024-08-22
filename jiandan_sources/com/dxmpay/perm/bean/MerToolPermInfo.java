package com.dxmpay.perm.bean;

import java.io.Serializable;

public class MerToolPermInfo implements Serializable {
    public String aimDesc;
    public String aimTitle;
    public boolean isGotoSettingPage;
    public boolean isShowAimGuide;
    public boolean isShowRejectGuide;
    public String permission;
    public String rejectDesc;
    public String rejectTitle;
    public int requestCode;

    public static class Builder implements Serializable {
        public String aimDesc;
        public String aimTitle;
        public boolean isGotoSettingPage = true;
        public boolean isShowAimGuide = true;
        public boolean isShowRejectGuide = true;
        public String permission;
        public String rejectDesc;
        public String rejectTitle;
        public int requestCode;

        public Builder(String str, int i2) {
            this.permission = str;
            this.requestCode = i2;
        }

        public Builder aimDesc(String str) {
            this.aimDesc = str;
            return this;
        }

        public Builder aimTitle(String str) {
            this.aimTitle = str;
            return this;
        }

        public MerToolPermInfo build() {
            return new MerToolPermInfo(this);
        }

        public Builder isGotoSettingPage(boolean z) {
            this.isGotoSettingPage = z;
            return this;
        }

        public Builder isShowAimGuide(boolean z) {
            this.isShowAimGuide = z;
            return this;
        }

        public Builder isShowRejectGuide(boolean z) {
            this.isShowRejectGuide = z;
            return this;
        }

        public Builder rejectDesc(String str) {
            this.rejectDesc = str;
            return this;
        }

        public Builder rejectTitle(String str) {
            this.rejectTitle = str;
            return this;
        }
    }

    public String getAimDesc() {
        return this.aimDesc;
    }

    public String getAimTitle() {
        return this.aimTitle;
    }

    public String getPermission() {
        return this.permission;
    }

    public String getRejectDesc() {
        return this.rejectDesc;
    }

    public String getRejectTitle() {
        return this.rejectTitle;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    public boolean isGotoSettingPage() {
        return this.isGotoSettingPage;
    }

    public boolean isShowAimGuide() {
        return this.isShowAimGuide;
    }

    public boolean isShowRejectGuide() {
        return this.isShowRejectGuide;
    }

    public MerToolPermInfo(Builder builder) {
        this.permission = builder.permission;
        this.requestCode = builder.requestCode;
        this.isShowAimGuide = builder.isShowAimGuide;
        this.aimTitle = builder.aimTitle;
        this.aimDesc = builder.aimDesc;
        this.isShowRejectGuide = builder.isShowRejectGuide;
        this.rejectTitle = builder.rejectTitle;
        this.rejectDesc = builder.rejectDesc;
        this.isGotoSettingPage = builder.isGotoSettingPage;
    }
}
