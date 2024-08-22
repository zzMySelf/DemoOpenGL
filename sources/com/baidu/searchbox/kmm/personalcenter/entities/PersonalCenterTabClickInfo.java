package com.baidu.searchbox.kmm.personalcenter.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabClickInfo;", "", "()V", "clickTime", "", "getClickTime", "()Ljava/lang/String;", "setClickTime", "(Ljava/lang/String;)V", "clickTimes", "getClickTimes", "setClickTimes", "dataType", "getDataType", "setDataType", "hideTime", "getHideTime", "setHideTime", "id", "getId", "setId", "mergeCardGroupId", "getMergeCardGroupId", "setMergeCardGroupId", "showTime", "getShowTime", "setShowTime", "ubcFrom", "getUbcFrom", "setUbcFrom", "com.baidu.searchbox.kmm.business.personalcenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCenterTabClickInfo.kt */
public final class PersonalCenterTabClickInfo {
    private String clickTime;
    private String clickTimes = "";
    private String dataType = "";
    private String hideTime;
    private String id;
    private String mergeCardGroupId = "";
    private String showTime;
    private String ubcFrom;

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getClickTime() {
        return this.clickTime;
    }

    public final void setClickTime(String str) {
        this.clickTime = str;
    }

    public final String getShowTime() {
        return this.showTime;
    }

    public final void setShowTime(String str) {
        this.showTime = str;
    }

    public final String getHideTime() {
        return this.hideTime;
    }

    public final void setHideTime(String str) {
        this.hideTime = str;
    }

    public final String getUbcFrom() {
        return this.ubcFrom;
    }

    public final void setUbcFrom(String str) {
        this.ubcFrom = str;
    }

    public final String getClickTimes() {
        return this.clickTimes;
    }

    public final void setClickTimes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clickTimes = str;
    }

    public final String getDataType() {
        return this.dataType;
    }

    public final void setDataType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataType = str;
    }

    public final String getMergeCardGroupId() {
        return this.mergeCardGroupId;
    }

    public final void setMergeCardGroupId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mergeCardGroupId = str;
    }
}
