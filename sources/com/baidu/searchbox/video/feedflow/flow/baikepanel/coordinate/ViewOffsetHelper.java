package com.baidu.searchbox.video.feedflow.flow.baikepanel.coordinate;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006J\b\u0010\u0016\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/baikepanel/coordinate/ViewOffsetHelper;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "layoutLeft", "", "layoutTop", "offsetLeft", "offsetTop", "getView", "()Landroid/view/View;", "getLayoutLeft", "getLayoutTop", "getLeftAndRightOffset", "getTopAndBottomOffset", "onViewLayout", "", "setLeftAndRightOffset", "", "offset", "setTopAndBottomOffset", "updateOffsets", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewOffsetHelper.kt */
public final class ViewOffsetHelper {
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;

    /* renamed from: view  reason: collision with root package name */
    private final View f2922view;

    public ViewOffsetHelper(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.f2922view = view2;
    }

    public final View getView() {
        return this.f2922view;
    }

    public final void onViewLayout() {
        this.layoutTop = this.f2922view.getTop();
        this.layoutLeft = this.f2922view.getLeft();
        updateOffsets();
    }

    private final void updateOffsets() {
        View view2 = this.f2922view;
        ViewCompat.offsetTopAndBottom(view2, this.offsetTop - (view2.getTop() - this.layoutTop));
        View view3 = this.f2922view;
        ViewCompat.offsetLeftAndRight(view3, this.offsetLeft - (view3.getLeft() - this.layoutLeft));
    }

    public final boolean setTopAndBottomOffset(int offset) {
        if (this.offsetTop == offset) {
            return false;
        }
        this.offsetTop = offset;
        updateOffsets();
        return true;
    }

    public final boolean setLeftAndRightOffset(int offset) {
        if (this.offsetLeft == offset) {
            return false;
        }
        this.offsetLeft = offset;
        updateOffsets();
        return true;
    }

    public final int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public final int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public final int getLayoutTop() {
        return this.layoutTop;
    }

    public final int getLayoutLeft() {
        return this.layoutLeft;
    }
}
