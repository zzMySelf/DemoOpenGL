package com.baidu.searchbox.feed.payment.column.facets;

import android.view.View;
import androidx.lifecycle.LifecycleObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&R\u0016\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/feed/payment/column/facets/SpFacet;", "FContext", "Landroidx/lifecycle/LifecycleObserver;", "facetsContext", "(Ljava/lang/Object;)V", "getFacetsContext", "()Ljava/lang/Object;", "Ljava/lang/Object;", "createView", "Landroid/view/View;", "onModelReceived", "", "updateUi", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpFacet.kt */
public abstract class SpFacet<FContext> implements LifecycleObserver {
    private final FContext facetsContext;

    public abstract View createView();

    public abstract void onModelReceived();

    public abstract void updateUi();

    public SpFacet(FContext facetsContext2) {
        this.facetsContext = facetsContext2;
    }

    /* access modifiers changed from: protected */
    public final FContext getFacetsContext() {
        return this.facetsContext;
    }
}
