package com.baidu.searchbox.flowvideo.dynamic.api;

import com.baidu.searchbox.NoProGuard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/flowvideo/dynamic/api/ImgShowTimeBean;", "Lcom/baidu/searchbox/NoProGuard;", "showTime", "", "animTime", "(II)V", "getAnimTime", "()I", "getShowTime", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicDetailBean.kt */
public final class ImgShowTimeBean implements NoProGuard {
    private final int animTime;
    @SerializedName("show_time")
    private final int showTime;

    public ImgShowTimeBean() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public ImgShowTimeBean(int showTime2, int animTime2) {
        this.showTime = showTime2;
        this.animTime = animTime2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImgShowTimeBean(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0 : i3);
    }

    public final int getShowTime() {
        return this.showTime;
    }

    public final int getAnimTime() {
        return this.animTime;
    }
}
