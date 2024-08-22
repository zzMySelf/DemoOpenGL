package com.baidu.searchbox.newpersonalcenter.pulltorefrsh;

import android.view.View;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/newpersonalcenter/pulltorefrsh/CustomSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "()V", "mHorizontalHelper", "Landroidx/recyclerview/widget/OrientationHelper;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "offset", "", "getOffset", "()I", "offset$delegate", "Lkotlin/Lazy;", "refreshEnable", "", "getRefreshEnable", "()Z", "setRefreshEnable", "(Z)V", "attachToRecyclerView", "", "recyclerView", "calculateDistanceToFinalSnap", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "targetView", "Landroid/view/View;", "distanceToEnd", "helper", "findLastView", "findSnapView", "getHorizontalHelper", "getRecyclerView", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomSnapHelper.kt */
public final class CustomSnapHelper extends LinearSnapHelper {
    private OrientationHelper mHorizontalHelper;
    private RecyclerView mRecyclerView;
    private final Lazy offset$delegate = LazyKt.lazy(CustomSnapHelper$offset$2.INSTANCE);
    private boolean refreshEnable;

    public final boolean getRefreshEnable() {
        return this.refreshEnable;
    }

    public final void setRefreshEnable(boolean z) {
        this.refreshEnable = z;
    }

    public final RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    private final int getOffset() {
        return ((Number) this.offset$delegate.getValue()).intValue();
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        super.attachToRecyclerView(recyclerView);
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View targetView) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        int[] out = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            out[0] = distanceToEnd(targetView, getHorizontalHelper(layoutManager));
        } else {
            out[0] = 0;
        }
        return out;
    }

    private final int distanceToEnd(View targetView, OrientationHelper helper) {
        return (helper.getDecoratedStart(targetView) - helper.getEnd()) + getOffset();
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager != null && this.refreshEnable && layoutManager.canScrollHorizontally()) {
            return findLastView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getAdapter();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.View findLastView(androidx.recyclerview.widget.RecyclerView.LayoutManager r7, androidx.recyclerview.widget.OrientationHelper r8) {
        /*
            r6 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r6.mRecyclerView
            r1 = -1
            if (r0 == 0) goto L_0x0010
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.getAdapter()
            if (r0 == 0) goto L_0x0010
            int r0 = r0.getItemCount()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            boolean r2 = r7 instanceof androidx.recyclerview.widget.LinearLayoutManager
            r3 = 0
            if (r2 == 0) goto L_0x001a
            r2 = r7
            androidx.recyclerview.widget.LinearLayoutManager r2 = (androidx.recyclerview.widget.LinearLayoutManager) r2
            goto L_0x001b
        L_0x001a:
            r2 = r3
        L_0x001b:
            if (r2 == 0) goto L_0x0022
            int r2 = r2.findLastVisibleItemPosition()
            goto L_0x0023
        L_0x0022:
            r2 = r1
        L_0x0023:
            if (r1 == r0) goto L_0x0045
            if (r1 == r2) goto L_0x0045
            int r1 = r0 + -1
            if (r2 != r1) goto L_0x0045
            android.view.View r1 = r7.findViewByPosition(r2)
            int r4 = r8.getEnd()
            int r5 = r8.getDecoratedStart(r1)
            int r4 = r4 - r5
            int r5 = r6.getOffset()
            if (r4 >= r5) goto L_0x0043
            r5 = r3
            android.view.View r5 = (android.view.View) r5
            goto L_0x0044
        L_0x0043:
            r3 = r1
        L_0x0044:
            return r3
        L_0x0045:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.newpersonalcenter.pulltorefrsh.CustomSnapHelper.findLastView(androidx.recyclerview.widget.RecyclerView$LayoutManager, androidx.recyclerview.widget.OrientationHelper):android.view.View");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0 != null ? r0.getLayoutManager() : null, (java.lang.Object) r2) == false) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.recyclerview.widget.OrientationHelper getHorizontalHelper(androidx.recyclerview.widget.RecyclerView.LayoutManager r2) {
        /*
            r1 = this;
            androidx.recyclerview.widget.OrientationHelper r0 = r1.mHorizontalHelper
            if (r0 == 0) goto L_0x0012
            if (r0 == 0) goto L_0x000b
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 != 0) goto L_0x0018
        L_0x0012:
            androidx.recyclerview.widget.OrientationHelper r0 = androidx.recyclerview.widget.OrientationHelper.createHorizontalHelper(r2)
            r1.mHorizontalHelper = r0
        L_0x0018:
            androidx.recyclerview.widget.OrientationHelper r0 = r1.mHorizontalHelper
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.newpersonalcenter.pulltorefrsh.CustomSnapHelper.getHorizontalHelper(androidx.recyclerview.widget.RecyclerView$LayoutManager):androidx.recyclerview.widget.OrientationHelper");
    }
}
