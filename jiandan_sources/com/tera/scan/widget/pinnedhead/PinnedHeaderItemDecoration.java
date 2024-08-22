package com.tera.scan.widget.pinnedhead;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cH\u0002J \u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\t@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/tera/scan/widget/pinnedhead/PinnedHeaderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Lcom/tera/scan/widget/pinnedhead/IPinnedHeaderDecoration;", "()V", "<set-?>", "", "pinnedHeaderPosition", "getPinnedHeaderPosition", "()I", "Landroid/graphics/Rect;", "pinnedHeaderRect", "getPinnedHeaderRect", "()Landroid/graphics/Rect;", "ensurePinnedHeaderViewLayout", "", "pinView", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getItemOffsets", "outRect", "view", "parent", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getPinnedHeaderViewPosition", "adapterFirstVisible", "adapter", "Lcom/tera/scan/widget/pinnedhead/PinnedHeaderAdapter;", "onDrawOver", "c", "Landroid/graphics/Canvas;", "x-widgets_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PinnedHeaderItemDecoration extends RecyclerView.ItemDecoration implements IPinnedHeaderDecoration {

    /* renamed from: ad  reason: collision with root package name */
    public int f7529ad = -1;
    @Nullable
    public Rect qw;

    public final int ad(int i2, PinnedHeaderAdapter<?> pinnedHeaderAdapter) {
        while (-1 < i2) {
            boolean z = true;
            if (pinnedHeaderAdapter == null || !pinnedHeaderAdapter.isPinnedPosition(i2)) {
                z = false;
            }
            if (z) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, WXLoginActivity.w);
    }

    public int getPinnedHeaderPosition() {
        return this.f7529ad;
    }

    @Nullable
    public Rect getPinnedHeaderRect() {
        return this.qw;
    }

    public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, WXLoginActivity.w);
        super.onDrawOver(canvas, recyclerView, state);
        if ((recyclerView.getAdapter() instanceof PinnedHeaderAdapter) && recyclerView.getChildCount() > 0) {
            PinnedHeaderAdapter pinnedHeaderAdapter = (PinnedHeaderAdapter) recyclerView.getAdapter();
            int ad2 = ad(recyclerView.getChildAdapterPosition(recyclerView.getChildAt(0)), pinnedHeaderAdapter);
            this.f7529ad = ad2;
            ViewGroup.LayoutParams layoutParams = null;
            if (ad2 != -1) {
                RecyclerView.ViewHolder onCreateViewHolder = pinnedHeaderAdapter != null ? pinnedHeaderAdapter.onCreateViewHolder(recyclerView, pinnedHeaderAdapter.getItemViewType(ad2)) : null;
                if (onCreateViewHolder != null) {
                    pinnedHeaderAdapter.onBindViewHolder(onCreateViewHolder, ad2);
                }
                View view = onCreateViewHolder != null ? onCreateViewHolder.itemView : null;
                if (view != null) {
                    qw(view, recyclerView);
                }
                int childCount = recyclerView.getChildCount();
                int i2 = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    boolean z = true;
                    if (pinnedHeaderAdapter == null || !pinnedHeaderAdapter.isPinnedPosition(recyclerView.getChildAdapterPosition(recyclerView.getChildAt(i3)))) {
                        z = false;
                    }
                    if (z) {
                        int top = recyclerView.getChildAt(i3).getTop();
                        Integer valueOf = view != null ? Integer.valueOf(view.getHeight()) : null;
                        Intrinsics.checkNotNull(valueOf);
                        if (top < valueOf.intValue() && top > 0) {
                            i2 = top - valueOf.intValue();
                        }
                    }
                }
                int save = canvas.save();
                if (view != null) {
                    layoutParams = view.getLayoutParams();
                }
                if (layoutParams != null) {
                    canvas.translate((float) ((RecyclerView.LayoutParams) layoutParams).leftMargin, (float) i2);
                    canvas.clipRect(0, 0, recyclerView.getWidth(), view.getMeasuredHeight());
                    view.draw(canvas);
                    canvas.restoreToCount(save);
                    if (getPinnedHeaderRect() == null) {
                        this.qw = new Rect();
                    }
                    Rect pinnedHeaderRect = getPinnedHeaderRect();
                    Intrinsics.checkNotNull(pinnedHeaderRect);
                    pinnedHeaderRect.set(0, 0, recyclerView.getWidth(), view.getMeasuredHeight() + i2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
            this.qw = null;
        }
    }

    public final void qw(View view, RecyclerView recyclerView) {
        int i2;
        if (view.isLayoutRequested()) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((recyclerView.getMeasuredWidth() - layoutParams2.leftMargin) - layoutParams2.rightMargin, 1073741824);
                int i3 = layoutParams2.height;
                if (i3 > 0) {
                    i2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                } else {
                    i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                }
                view.measure(makeMeasureSpec, i2);
                view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        }
    }
}
