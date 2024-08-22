package com.baidu.searchbox.search.tab.helper;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.search.tab.implement.tplview.SlidableView;
import com.baidu.searchbox.search.tab.implement.tplview.VideoBaseRelativeLayout;
import com.baidu.searchbox.video.util.RecyclerViewHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002\u001a\u001a\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"GESTURE_LEFT", "", "GESTURE_RIGHT", "mEndX", "", "mStartX", "checkSlidable", "toRight", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "isSlidAble", "ev", "Landroid/view/MotionEvent;", "mRecyclerView", "search_video_business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HandleHorizontalScrollHelper.kt */
public final class HandleHorizontalScrollHelperKt {
    private static final int GESTURE_LEFT = 1;
    private static final int GESTURE_RIGHT = 2;
    private static float mEndX;
    private static float mStartX;

    public static final int isSlidAble(MotionEvent ev, RecyclerView mRecyclerView) {
        if (ev == null || mRecyclerView == null) {
            return -1;
        }
        float eventY = ev.getRawY();
        switch (ev.getAction()) {
            case 0:
                mStartX = ev.getX();
                break;
            case 1:
            case 2:
            case 3:
                mEndX = ev.getX();
                break;
        }
        boolean toRight = mEndX - mStartX > 0.0f;
        ArrayList visibleViewList = RecyclerViewHelper.getCurrentVisibleViewList(mRecyclerView);
        Intrinsics.checkNotNullExpressionValue(visibleViewList, "getCurrentVisibleViewList(mRecyclerView)");
        if (visibleViewList.size() > 0) {
            Iterator<View> it = visibleViewList.iterator();
            while (it.hasNext()) {
                View view2 = it.next();
                if (view2 instanceof VideoBaseRelativeLayout) {
                    if (((VideoBaseRelativeLayout) view2).isSlidable()) {
                        RecyclerView recyclerView = ((VideoBaseRelativeLayout) view2).getSlidView();
                        Rect summaryRect = new Rect();
                        if (recyclerView != null) {
                            recyclerView.getGlobalVisibleRect(summaryRect);
                        }
                        if (eventY >= ((float) summaryRect.top) && eventY <= ((float) summaryRect.bottom)) {
                            return checkSlidable(toRight, recyclerView);
                        }
                    } else {
                        continue;
                    }
                } else if (view2 instanceof SlidableView) {
                    HorizontalScrollView scrollView = ((SlidableView) view2).getSlidView();
                    if (((SlidableView) view2).isSlidable() && scrollView != null) {
                        Rect summaryRect2 = new Rect();
                        scrollView.getGlobalVisibleRect(summaryRect2);
                        if (eventY >= ((float) summaryRect2.top) && eventY <= ((float) summaryRect2.bottom)) {
                            return ((SlidableView) view2).checkSlidable(toRight);
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return -1;
    }

    private static final int checkSlidable(boolean toRight, RecyclerView recyclerView) {
        if (recyclerView == null) {
            return -1;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager layoutManager2 = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        int lastVisibleItemPosition = 0;
        int firstVisibleItemPosition = layoutManager2 != null ? layoutManager2.findFirstVisibleItemPosition() : 0;
        if (layoutManager2 != null) {
            lastVisibleItemPosition = layoutManager2.findLastVisibleItemPosition();
        }
        if (!toRight) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (lastVisibleItemPosition < (adapter != null ? adapter.getItemCount() : -1) - 1) {
                return 1;
            }
            if (recyclerView.canScrollHorizontally(1)) {
                return 1;
            }
            return -1;
        } else if (firstVisibleItemPosition > 0) {
            return 2;
        } else {
            if (recyclerView.canScrollHorizontally(-1)) {
                return 2;
            }
            return -1;
        }
    }
}
