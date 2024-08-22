package com.baidu.searchbox.sport.page.olympic.schedule.comp;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.nacomp.extension.widget.ptr.BilateralRecyclerView;
import com.baidu.searchbox.sport.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"com/baidu/searchbox/sport/page/olympic/schedule/comp/OlympicScheduleComp$reOpenHeadRefreshOnDragging$2", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "startY", "", "getStartY", "()F", "setStartY", "(F)V", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "disallowIntercept", "onTouchEvent", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OlympicScheduleComp.kt */
public final class OlympicScheduleComp$reOpenHeadRefreshOnDragging$2 implements RecyclerView.OnItemTouchListener {
    private float startY;
    final /* synthetic */ OlympicScheduleComp this$0;

    OlympicScheduleComp$reOpenHeadRefreshOnDragging$2(OlympicScheduleComp $receiver) {
        this.this$0 = $receiver;
    }

    public final float getStartY() {
        return this.startY;
    }

    public final void setStartY(float f2) {
        this.startY = f2;
    }

    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e2) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e2, "e");
        if (!((OlympicScheduleViewModel) this.this$0.getViewModel()).getNeedReOpenLoadHeader()) {
            return false;
        }
        if (e2.getAction() == 0) {
            this.startY = e2.getY();
        } else if (e2.getAction() == 2 && e2.getY() > this.startY && this.this$0.isDragging) {
            ((BilateralRecyclerView) this.this$0.getView().findViewById(R.id.rcyMatchList)).setHasMoreAfterHeadRefresh(true);
            ((OlympicScheduleViewModel) this.this$0.getViewModel()).setNeedReOpenLoadHeader(false);
        }
        return false;
    }

    public void onTouchEvent(RecyclerView rv, MotionEvent e2) {
        Intrinsics.checkNotNullParameter(rv, "rv");
        Intrinsics.checkNotNullParameter(e2, "e");
    }

    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}
