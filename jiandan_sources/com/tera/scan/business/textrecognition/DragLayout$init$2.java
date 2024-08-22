package com.tera.scan.business.textrecognition;

import android.view.View;
import androidx.annotation.Px;
import androidx.customview.widget.ViewDragHelper;
import com.tera.scan.business.textrecognition.DragLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0003H\u0016J \u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¨\u0006\u0015"}, d2 = {"com/tera/scan/business/textrecognition/DragLayout$init$2", "Landroidx/customview/widget/ViewDragHelper$Callback;", "clampViewPositionVertical", "", "child", "Landroid/view/View;", "top", "dy", "onViewPositionChanged", "", "changedView", "left", "dx", "onViewReleased", "releasedChild", "xvel", "", "yvel", "tryCaptureView", "", "pointerId", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DragLayout$init$2 extends ViewDragHelper.Callback {
    public final /* synthetic */ DragLayout qw;

    public DragLayout$init$2(DragLayout dragLayout) {
        this.qw = dragLayout;
    }

    public int clampViewPositionVertical(@NotNull View view, int i2, int i3) {
        Intrinsics.checkNotNullParameter(view, "child");
        if (!this.qw.isDragging) {
            return 0;
        }
        if (this.qw.isExpanded) {
            return Math.min(i2, this.qw.getHeight() - this.qw.partialVisibleHeight);
        }
        return Math.max(i2, -this.qw.partialVisibleHeight);
    }

    public void onViewPositionChanged(@NotNull View view, int i2, int i3, @Px int i4, @Px int i5) {
        Intrinsics.checkNotNullParameter(view, "changedView");
        DragLayout.DragListener access$getDragListener$p = this.qw.dragListener;
        if (access$getDragListener$p != null) {
            access$getDragListener$p.qw(((float) i3) / ((float) this.qw.dragRange));
        }
    }

    public void onViewReleased(@NotNull View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "releasedChild");
        if (Intrinsics.areEqual((Object) view, (Object) this.qw.dragView) || Intrinsics.areEqual((Object) view, (Object) this.qw.dragContent)) {
            int i2 = 0;
            this.qw.isDragging = false;
            float access$getOpenRatio$p = this.qw.openRatio * ((float) this.qw.dragRange);
            float access$getCloseRatio$p = this.qw.closeRatio * ((float) this.qw.dragRange);
            if (this.qw.isExpanded) {
                if (!this.qw.fastClose(f2)) {
                    View access$getDragContent$p = this.qw.dragContent;
                    if (access$getDragContent$p != null) {
                        i2 = access$getDragContent$p.getTop();
                    }
                    if (((float) i2) <= access$getCloseRatio$p) {
                        if (this.qw.shouldExpand(access$getOpenRatio$p)) {
                            this.qw.expand();
                            return;
                        } else {
                            this.qw.close();
                            return;
                        }
                    }
                }
                this.qw.close();
            } else if (this.qw.fastExpand(f2) || this.qw.shouldExpand(access$getOpenRatio$p)) {
                this.qw.expand();
            } else {
                this.qw.close();
            }
        }
    }

    public boolean tryCaptureView(@NotNull View view, int i2) {
        Intrinsics.checkNotNullParameter(view, "child");
        DragLayout dragLayout = this.qw;
        boolean z = true;
        if (!(dragLayout.contentDragTouchMode || view == this.qw.dragView || view == this.qw.dragContent)) {
            z = false;
        }
        dragLayout.isDragging = z;
        return this.qw.isDragging;
    }
}
