package com.baidu.searchbox.bigimage.model;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/bigimage/model/ImageCallerInfo;", "", "ua", "", "imageTab", "", "viewInfo", "Lcom/baidu/searchbox/bigimage/model/ImageCallerViewInfo;", "interceptInfo", "Lcom/baidu/searchbox/bigimage/model/ImageInterceptInfo;", "(Ljava/lang/String;ZLcom/baidu/searchbox/bigimage/model/ImageCallerViewInfo;Lcom/baidu/searchbox/bigimage/model/ImageInterceptInfo;)V", "getImageTab", "()Z", "getInterceptInfo", "()Lcom/baidu/searchbox/bigimage/model/ImageInterceptInfo;", "getUa", "()Ljava/lang/String;", "getViewInfo", "()Lcom/baidu/searchbox/bigimage/model/ImageCallerViewInfo;", "lib-bigimage-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageCallerInfo.kt */
public final class ImageCallerInfo {
    private final boolean imageTab;
    private final ImageInterceptInfo interceptInfo;
    private final String ua;
    private final ImageCallerViewInfo viewInfo;

    public ImageCallerInfo(String ua2, boolean imageTab2, ImageCallerViewInfo viewInfo2, ImageInterceptInfo interceptInfo2) {
        Intrinsics.checkNotNullParameter(viewInfo2, "viewInfo");
        Intrinsics.checkNotNullParameter(interceptInfo2, "interceptInfo");
        this.ua = ua2;
        this.imageTab = imageTab2;
        this.viewInfo = viewInfo2;
        this.interceptInfo = interceptInfo2;
    }

    public final String getUa() {
        return this.ua;
    }

    public final boolean getImageTab() {
        return this.imageTab;
    }

    public final ImageCallerViewInfo getViewInfo() {
        return this.viewInfo;
    }

    public final ImageInterceptInfo getInterceptInfo() {
        return this.interceptInfo;
    }
}
