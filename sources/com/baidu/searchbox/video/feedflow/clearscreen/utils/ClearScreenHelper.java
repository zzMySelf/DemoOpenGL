package com.baidu.searchbox.video.feedflow.clearscreen.utils;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.detail.utils.ViewUtilsKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.flow.layout.VideoItemLayoutCoordinateHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J2\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/clearscreen/utils/ClearScreenHelper;", "", "()V", "initCenterContainer", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "onClickListener", "Lkotlin/Function0;", "", "updateCenterContainerPosition", "manager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "videoItemLayoutCoordinateHelper", "Lcom/baidu/searchbox/video/feedflow/flow/layout/VideoItemLayoutCoordinateHelper;", "playerContainer", "Landroid/view/ViewGroup;", "centerContainer", "notchHeight", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearScreenHelper.kt */
public final class ClearScreenHelper {
    public static final ClearScreenHelper INSTANCE = new ClearScreenHelper();

    private ClearScreenHelper() {
    }

    public final LinearLayout initCenterContainer(Context context, Function0<Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        ClearScreenHelper$initCenterContainer$1 clearScreenHelper$initCenterContainer$1 = new ClearScreenHelper$initCenterContainer$1(context);
        ClearScreenHelper$initCenterContainer$1 $this$initCenterContainer_u24lambda_u2d3 = clearScreenHelper$initCenterContainer$1;
        $this$initCenterContainer_u24lambda_u2d3.setId(R.id.video_flow_cmp_center_container);
        $this$initCenterContainer_u24lambda_u2d3.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams $this$initCenterContainer_u24lambda_u2d3_u24lambda_u2d0 = layoutParams;
        $this$initCenterContainer_u24lambda_u2d3_u24lambda_u2d0.addRule(3, R.id.video_flow_cmp_player_holder);
        $this$initCenterContainer_u24lambda_u2d3_u24lambda_u2d0.addRule(14);
        $this$initCenterContainer_u24lambda_u2d3_u24lambda_u2d0.topMargin = context.getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_13dp);
        $this$initCenterContainer_u24lambda_u2d3_u24lambda_u2d0.bottomMargin = context.getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_13dp);
        $this$initCenterContainer_u24lambda_u2d3.setLayoutParams(layoutParams);
        $this$initCenterContainer_u24lambda_u2d3.setOnClickListener(new ClearScreenHelper$$ExternalSyntheticLambda0(onClickListener));
        $this$initCenterContainer_u24lambda_u2d3.setOnTouchListener(new ClearScreenHelper$$ExternalSyntheticLambda1($this$initCenterContainer_u24lambda_u2d3));
        return clearScreenHelper$initCenterContainer$1;
    }

    /* access modifiers changed from: private */
    /* renamed from: initCenterContainer$lambda-3$lambda-1  reason: not valid java name */
    public static final void m5828initCenterContainer$lambda3$lambda1(Function0 $onClickListener, View it) {
        Intrinsics.checkNotNullParameter($onClickListener, "$onClickListener");
        $onClickListener.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: initCenterContainer$lambda-3$lambda-2  reason: not valid java name */
    public static final boolean m5829initCenterContainer$lambda3$lambda2(ClearScreenHelper$initCenterContainer$1 $this_apply, View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        switch (event.getAction()) {
            case 0:
                $this_apply.setAlpha(0.3f);
                return false;
            case 1:
            case 3:
                $this_apply.setAlpha(1.0f);
                return false;
            default:
                return false;
        }
    }

    public final void updateCenterContainerPosition(ComponentArchManager manager, VideoItemLayoutCoordinateHelper videoItemLayoutCoordinateHelper, ViewGroup playerContainer, ViewGroup centerContainer, float notchHeight) {
        ComponentArchManager componentArchManager = manager;
        VideoItemLayoutCoordinateHelper videoItemLayoutCoordinateHelper2 = videoItemLayoutCoordinateHelper;
        ViewGroup viewGroup = playerContainer;
        ViewGroup viewGroup2 = centerContainer;
        Intrinsics.checkNotNullParameter(componentArchManager, FeedStatisticConstants.UBC_TYPE_PLUS);
        Intrinsics.checkNotNullParameter(videoItemLayoutCoordinateHelper2, "videoItemLayoutCoordinateHelper");
        videoItemLayoutCoordinateHelper2.switchCalculator(componentArchManager);
        videoItemLayoutCoordinateHelper2.updateCenterContainerLayoutParams(viewGroup2);
        Integer num = null;
        FrameLayout playerHolder = viewGroup != null ? (FrameLayout) viewGroup.findViewById(R.id.video_flow_cmp_player_holder) : null;
        ViewGroup.LayoutParams layoutParams = viewGroup2 != null ? centerContainer.getLayoutParams() : null;
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams centerContainerParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int extraScaledScape = BdPlayerUtils.orZero(playerHolder != null ? Integer.valueOf(ViewUtilsKt.getExtraScaledSpace(playerHolder)) : null);
            int playerHolderTop = BdPlayerUtils.orZero(playerHolder != null ? Integer.valueOf(playerHolder.getTop()) : null) - extraScaledScape;
            if (playerHolder != null) {
                num = Integer.valueOf(playerHolder.getBottom());
            }
            int playerHolderBottom = BdPlayerUtils.orZero(num) + extraScaledScape;
            float translationYBase = (float) (((Integer.MAX_VALUE - centerContainer.getMeasuredHeight()) - centerContainerParams.topMargin) - centerContainerParams.bottomMargin);
            int i2 = playerHolderBottom;
            int i3 = playerHolderTop;
            float translationY = videoItemLayoutCoordinateHelper.getCenterContainerTranslationY(manager, playerHolder, centerContainer, ((float) playerHolderBottom) - translationYBase, ((float) playerHolderTop) - notchHeight, translationYBase, extraScaledScape, false);
            if (translationY >= 0.0f) {
                viewGroup2.setTranslationY(translationY);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                viewGroup2.setTranslationZ((float) (viewGroup != null ? playerContainer.getChildCount() : 1));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
