package com.baidu.searchbox.flowvideo.dynamic.api;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/flowvideo/dynamic/api/DynamicMenuConfigBean;", "Lcom/baidu/searchbox/NoProGuard;", "showUninterest", "", "showReport", "(II)V", "getShowReport", "()I", "getShowUninterest", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicDetailBean.kt */
public final class DynamicMenuConfigBean implements NoProGuard {
    private final int showReport;
    private final int showUninterest;

    public DynamicMenuConfigBean() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public DynamicMenuConfigBean(int showUninterest2, int showReport2) {
        this.showUninterest = showUninterest2;
        this.showReport = showReport2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DynamicMenuConfigBean(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0 : i3);
    }

    public final int getShowUninterest() {
        return this.showUninterest;
    }

    public final int getShowReport() {
        return this.showReport;
    }
}
