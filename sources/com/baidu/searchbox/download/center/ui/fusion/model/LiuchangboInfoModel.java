package com.baidu.searchbox.download.center.ui.fusion.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/fusion/model/LiuchangboInfoModel;", "", "()V", "addNum", "", "getAddNum", "()Ljava/lang/String;", "setAddNum", "(Ljava/lang/String;)V", "icon", "getIcon", "setIcon", "isRedPoint", "", "()Z", "setRedPoint", "(Z)V", "label", "getLabel", "setLabel", "scheme", "getScheme", "setScheme", "status", "getStatus", "setStatus", "tips", "getTips", "setTips", "getStatNum", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiuchangboInfoModel.kt */
public final class LiuchangboInfoModel {
    private String addNum;
    private String icon;
    private boolean isRedPoint;
    private String label;
    private String scheme;
    private String status = "";
    private String tips;

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final boolean isRedPoint() {
        return this.isRedPoint;
    }

    public final void setRedPoint(boolean z) {
        this.isRedPoint = z;
    }

    public final String getTips() {
        return this.tips;
    }

    public final void setTips(String str) {
        this.tips = str;
    }

    public final String getAddNum() {
        return this.addNum;
    }

    public final void setAddNum(String str) {
        this.addNum = str;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final void setScheme(String str) {
        this.scheme = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.status = str;
    }

    public final String getStatNum() {
        String str;
        if (!this.isRedPoint || (str = this.addNum) == null) {
            return "0";
        }
        return str;
    }
}
