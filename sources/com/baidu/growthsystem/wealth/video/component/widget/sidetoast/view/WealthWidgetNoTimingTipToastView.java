package com.baidu.growthsystem.wealth.video.component.widget.sidetoast.view;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.growthsystem.business.wealthtask.R;
import com.baidu.growthsystem.wealth.common.fontsize.IWealthTaskFontScalable;
import com.baidu.growthsystem.wealth.common.fontsize.WealthTaskFontScaleConfig;
import com.baidu.growthsystem.wealth.common.fontsize.WealthTaskFontScaleUtilKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0018\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/growthsystem/wealth/video/component/widget/sidetoast/view/WealthWidgetNoTimingTipToastView;", "Lcom/baidu/growthsystem/wealth/video/component/widget/sidetoast/view/BaseWealthWidgetTipToastView;", "Lcom/baidu/growthsystem/wealth/video/component/widget/sidetoast/view/WealthWidgetNoTimingTipToastData;", "Lcom/baidu/growthsystem/wealth/common/fontsize/IWealthTaskFontScalable;", "owner", "Lcom/baidu/growthsystem/wealth/video/component/widget/sidetoast/view/WealthWidgetTipToastOwner;", "(Lcom/baidu/growthsystem/wealth/video/component/widget/sidetoast/view/WealthWidgetTipToastOwner;)V", "enterAnimatorListener", "Landroid/animation/AnimatorListenerAdapter;", "getEnterAnimatorListener", "()Landroid/animation/AnimatorListenerAdapter;", "isRightSideOrientation", "", "getLayoutContainer", "Landroid/view/View;", "context", "Landroid/content/Context;", "getToastViewType", "Lcom/baidu/growthsystem/wealth/video/component/widget/sidetoast/view/WealthWidgetToastTipType;", "onDataBind", "", "data", "setSideOrientation", "isRight", "updateForFontSize", "updateLayoutPivot", "pivotX", "", "pivotY", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthWidgetNoTimingTipToastView.kt */
public final class WealthWidgetNoTimingTipToastView extends BaseWealthWidgetTipToastView<WealthWidgetNoTimingTipToastData> implements IWealthTaskFontScalable {
    private final AnimatorListenerAdapter enterAnimatorListener = new WealthWidgetNoTimingTipToastView$enterAnimatorListener$1(this);
    /* access modifiers changed from: private */
    public boolean isRightSideOrientation = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WealthWidgetNoTimingTipToastView(WealthWidgetTipToastOwner owner) {
        super(owner);
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    /* access modifiers changed from: protected */
    public AnimatorListenerAdapter getEnterAnimatorListener() {
        return this.enterAnimatorListener;
    }

    public void onDataBind(WealthWidgetNoTimingTipToastData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        View layout = getLayout();
        TextView textView = layout != null ? (TextView) layout.findViewById(R.id.wealth_widget_withdraw_tip_text) : null;
        if (textView != null) {
            textView.setText(data.getText());
        }
    }

    public View getLayoutContainer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return LayoutInflater.from(context).inflate(R.layout.wealth_video_live_tpl_no_timing_tip, (ViewGroup) null);
    }

    public WealthWidgetToastTipType getToastViewType() {
        return WealthWidgetToastTipType.LIVE_TPL_NO_TIMING;
    }

    public void setSideOrientation(boolean isRight) {
        this.isRightSideOrientation = isRight;
        View $this$setSideOrientation_u24lambda_u2d0 = getLayout();
        if ($this$setSideOrientation_u24lambda_u2d0 != null) {
            View leftArrow = $this$setSideOrientation_u24lambda_u2d0.findViewById(R.id.wealth_video_live_tpl_no_timing_tip_left_arrow);
            View rightArrow = $this$setSideOrientation_u24lambda_u2d0.findViewById(R.id.wealth_video_live_tpl_no_timing_tip_right_arrow);
            if (isRight) {
                if (leftArrow != null) {
                    leftArrow.setVisibility(8);
                }
                if (rightArrow != null) {
                    rightArrow.setVisibility(0);
                    return;
                }
                return;
            }
            if (leftArrow != null) {
                leftArrow.setVisibility(0);
            }
            if (rightArrow != null) {
                rightArrow.setVisibility(8);
            }
        }
    }

    public void updateForFontSize() {
        TextView $this$updateForFontSize_u24lambda_u2d1;
        View layout = getLayout();
        if (layout != null && ($this$updateForFontSize_u24lambda_u2d1 = (TextView) layout.findViewById(R.id.wealth_widget_withdraw_tip_text)) != null) {
            WealthTaskFontScaleUtilKt.setScaledHeightResForWealth$default($this$updateForFontSize_u24lambda_u2d1, R.dimen.wealth_video_live_tpl_no_timing_tip_height, (WealthTaskFontScaleConfig) null, 2, (Object) null);
            WealthTaskFontScaleUtilKt.setScaledPaddingForWealth$default($this$updateForFontSize_u24lambda_u2d1, $this$updateForFontSize_u24lambda_u2d1.getResources().getDimension(R.dimen.wealth_video_live_tpl_no_timing_tip_text_padding_left), 0.0f, $this$updateForFontSize_u24lambda_u2d1.getResources().getDimension(R.dimen.wealth_video_live_tpl_no_timing_tip_text_padding_right), 0.0f, (WealthTaskFontScaleConfig) null, 26, (Object) null);
            WealthTaskFontScaleUtilKt.setScaledTextSizeResForWealth$default($this$updateForFontSize_u24lambda_u2d1, R.dimen.wealth_video_live_tpl_no_timing_tip_text_size, (WealthTaskFontScaleConfig) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void updateLayoutPivot(float pivotX, float pivotY) {
        View $this$updateLayoutPivot_u24lambda_u2d2 = getLayout();
        if ($this$updateLayoutPivot_u24lambda_u2d2 != null) {
            $this$updateLayoutPivot_u24lambda_u2d2.setPivotX(pivotX);
            $this$updateLayoutPivot_u24lambda_u2d2.setPivotY(pivotY);
            if (WealthWidgetNoTimingTipToastViewKt.DEBUG) {
                Log.d("WealthWidgetNoTimingTipToastView", "Update layout pivot: pivotX = " + pivotX + ", pivotY = " + pivotY);
            }
        }
    }
}
