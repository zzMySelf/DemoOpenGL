package com.baidu.searchbox.feed.payment.widget;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/feed/payment/widget/RemoteDrawableConfig;", "", "view", "Landroid/view/View;", "key", "", "defaultDrawableId", "", "(Landroid/view/View;Ljava/lang/String;I)V", "getDefaultDrawableId", "()I", "getKey", "()Ljava/lang/String;", "getView", "()Landroid/view/View;", "lib-feedpay-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RemoteDrawableFacade.kt */
public final class RemoteDrawableConfig {
    private final int defaultDrawableId;
    private final String key;

    /* renamed from: view  reason: collision with root package name */
    private final View f18655view;

    public RemoteDrawableConfig(View view2, String key2, int defaultDrawableId2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(key2, "key");
        this.f18655view = view2;
        this.key = key2;
        this.defaultDrawableId = defaultDrawableId2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RemoteDrawableConfig(View view2, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2, str, (i3 & 4) != 0 ? -1 : i2);
    }

    public final View getView() {
        return this.f18655view;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getDefaultDrawableId() {
        return this.defaultDrawableId;
    }
}
