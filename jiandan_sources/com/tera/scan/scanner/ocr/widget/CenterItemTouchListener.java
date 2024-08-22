package com.tera.scan.scanner.ocr.widget;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tera/scan/scanner/ocr/widget/CenterItemTouchListener;", "Landroid/view/View$OnTouchListener;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "selectCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "selectPos", "", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function1;)V", "downX", "", "moveClickItemToCenter", "clickX", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CenterItemTouchListener implements View.OnTouchListener {
    public float downX;
    @NotNull
    public final RecyclerView recyclerView;
    @NotNull
    public final Function1<Integer, Unit> selectCallback;

    public CenterItemTouchListener(@NotNull RecyclerView recyclerView2, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        Intrinsics.checkNotNullParameter(function1, "selectCallback");
        this.recyclerView = recyclerView2;
        this.selectCallback = function1;
    }

    private final void moveClickItemToCenter(float f) {
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition() - findFirstVisibleItemPosition;
            for (int i2 = 0; i2 < findLastVisibleItemPosition; i2++) {
                View childAt = this.recyclerView.getChildAt(i2);
                if (childAt != null && f > childAt.getX() && f < childAt.getX() + ((float) childAt.getMeasuredWidth())) {
                    this.selectCallback.invoke(Integer.valueOf(findFirstVisibleItemPosition + i2));
                }
            }
        }
    }

    public boolean onTouch(@Nullable View view, @Nullable MotionEvent motionEvent) {
        if (motionEvent == null) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downX = motionEvent.getRawX();
        } else if (action == 1) {
            if (this.downX == motionEvent.getRawX()) {
                moveClickItemToCenter(motionEvent.getRawX());
            }
        }
        return true;
    }
}
