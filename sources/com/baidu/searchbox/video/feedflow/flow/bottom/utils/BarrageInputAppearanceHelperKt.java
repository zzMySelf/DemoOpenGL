package com.baidu.searchbox.video.feedflow.flow.bottom.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.LayerUtil;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\n\u0010\n\u001a\u00020\b*\u00020\t\u001a\u0014\u0010\u000b\u001a\u00020\b*\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r\u001a\n\u0010\u000e\u001a\u00020\b*\u00020\t\u001a\n\u0010\u000f\u001a\u00020\b*\u00020\t\u001a\n\u0010\u0010\u001a\u00020\b*\u00020\u0011\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"attitudeItemNewBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "autoPlayNewBackgroundDrawable", "barrageInputLandscapeNewBackgroundDrawable", "barrageInputPortraitNewBackgroundDrawable", "collectionBottomBarNewBackgroundDrawable", "rightZonebarrageInputNewBackgroundDrawable", "setAttitudeItemNewBackgroundDrawable", "", "Landroid/view/View;", "setAutoPlayNewBackgroundDrawable", "setBarrageInputNewBackgroundDrawable", "isLandscape", "", "setCollectionBottomBarNewBackgroundDrawable", "setRightZoneBarrageInputNewBackgroundDrawable", "setTextViewNewAppearanceStyle", "Landroid/widget/TextView;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BarrageInputAppearanceHelper.kt */
public final class BarrageInputAppearanceHelperKt {
    private static Drawable attitudeItemNewBackgroundDrawable;
    private static Drawable autoPlayNewBackgroundDrawable;
    private static Drawable barrageInputLandscapeNewBackgroundDrawable;
    private static Drawable barrageInputPortraitNewBackgroundDrawable;
    private static Drawable collectionBottomBarNewBackgroundDrawable;
    private static Drawable rightZonebarrageInputNewBackgroundDrawable;

    public static /* synthetic */ void setBarrageInputNewBackgroundDrawable$default(View view2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        setBarrageInputNewBackgroundDrawable(view2, z);
    }

    public static final void setBarrageInputNewBackgroundDrawable(View $this$setBarrageInputNewBackgroundDrawable, boolean isLandscape) {
        Intrinsics.checkNotNullParameter($this$setBarrageInputNewBackgroundDrawable, "<this>");
        if (!DIFactory.INSTANCE.getConfig().isBarrageInputNewAppearanceSwitch()) {
            return;
        }
        if (isLandscape) {
            if (barrageInputLandscapeNewBackgroundDrawable == null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                GradientDrawable $this$setBarrageInputNewBackgroundDrawable_u24lambda_u2d0 = gradientDrawable;
                $this$setBarrageInputNewBackgroundDrawable_u24lambda_u2d0.setShape(0);
                $this$setBarrageInputNewBackgroundDrawable_u24lambda_u2d0.setCornerRadius((float) $this$setBarrageInputNewBackgroundDrawable.getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_20dp));
                $this$setBarrageInputNewBackgroundDrawable_u24lambda_u2d0.setColor($this$setBarrageInputNewBackgroundDrawable.getContext().getResources().getColor(R.color.video_flow_video_summary_third_background_color));
                barrageInputLandscapeNewBackgroundDrawable = gradientDrawable;
            }
            $this$setBarrageInputNewBackgroundDrawable.setBackground(barrageInputLandscapeNewBackgroundDrawable);
            return;
        }
        if (barrageInputPortraitNewBackgroundDrawable == null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            GradientDrawable $this$setBarrageInputNewBackgroundDrawable_u24lambda_u2d1 = gradientDrawable2;
            $this$setBarrageInputNewBackgroundDrawable_u24lambda_u2d1.setShape(0);
            $this$setBarrageInputNewBackgroundDrawable_u24lambda_u2d1.setCornerRadius((float) $this$setBarrageInputNewBackgroundDrawable.getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_20dp));
            $this$setBarrageInputNewBackgroundDrawable_u24lambda_u2d1.setColor($this$setBarrageInputNewBackgroundDrawable.getContext().getResources().getColor(R.color.video_flow_color_33FFFFFF));
            barrageInputPortraitNewBackgroundDrawable = gradientDrawable2;
        }
        $this$setBarrageInputNewBackgroundDrawable.setBackground(barrageInputPortraitNewBackgroundDrawable);
    }

    public static final void setRightZoneBarrageInputNewBackgroundDrawable(View $this$setRightZoneBarrageInputNewBackgroundDrawable) {
        Intrinsics.checkNotNullParameter($this$setRightZoneBarrageInputNewBackgroundDrawable, "<this>");
        if (DIFactory.INSTANCE.getConfig().isBarrageInputNewAppearanceSwitch()) {
            if (rightZonebarrageInputNewBackgroundDrawable == null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                GradientDrawable $this$setRightZoneBarrageInputNewBackgroundDrawable_u24lambda_u2d2 = gradientDrawable;
                $this$setRightZoneBarrageInputNewBackgroundDrawable_u24lambda_u2d2.setShape(0);
                $this$setRightZoneBarrageInputNewBackgroundDrawable_u24lambda_u2d2.setCornerRadius((float) $this$setRightZoneBarrageInputNewBackgroundDrawable.getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_20dp));
                $this$setRightZoneBarrageInputNewBackgroundDrawable_u24lambda_u2d2.setColor($this$setRightZoneBarrageInputNewBackgroundDrawable.getContext().getResources().getColor(R.color.video_flow_color_33FFFFFF));
                rightZonebarrageInputNewBackgroundDrawable = gradientDrawable;
            }
            $this$setRightZoneBarrageInputNewBackgroundDrawable.setBackground(rightZonebarrageInputNewBackgroundDrawable);
        }
    }

    public static final void setAutoPlayNewBackgroundDrawable(View $this$setAutoPlayNewBackgroundDrawable) {
        Intrinsics.checkNotNullParameter($this$setAutoPlayNewBackgroundDrawable, "<this>");
        if (DIFactory.INSTANCE.getConfig().isBarrageInputNewAppearanceSwitch()) {
            if (autoPlayNewBackgroundDrawable == null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                GradientDrawable $this$setAutoPlayNewBackgroundDrawable_u24lambda_u2d3 = gradientDrawable;
                $this$setAutoPlayNewBackgroundDrawable_u24lambda_u2d3.setShape(0);
                $this$setAutoPlayNewBackgroundDrawable_u24lambda_u2d3.setCornerRadius((float) $this$setAutoPlayNewBackgroundDrawable.getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_20dp));
                $this$setAutoPlayNewBackgroundDrawable_u24lambda_u2d3.setColor($this$setAutoPlayNewBackgroundDrawable.getContext().getResources().getColor(R.color.video_flow_color_33FFFFFF));
                autoPlayNewBackgroundDrawable = gradientDrawable;
            }
            $this$setAutoPlayNewBackgroundDrawable.setBackground(autoPlayNewBackgroundDrawable);
        }
    }

    public static final void setTextViewNewAppearanceStyle(TextView $this$setTextViewNewAppearanceStyle) {
        Intrinsics.checkNotNullParameter($this$setTextViewNewAppearanceStyle, "<this>");
        if (DIFactory.INSTANCE.getConfig().isBarrageInputNewAppearanceSwitch()) {
            $this$setTextViewNewAppearanceStyle.setTextColor($this$setTextViewNewAppearanceStyle.getContext().getResources().getColor(R.color.video_flow_color_99FFFFFF));
            LayerUtil.setFontFakeBold$default($this$setTextViewNewAppearanceStyle, true, 0.0f, 2, (Object) null);
        }
    }

    public static final void setCollectionBottomBarNewBackgroundDrawable(View $this$setCollectionBottomBarNewBackgroundDrawable) {
        Intrinsics.checkNotNullParameter($this$setCollectionBottomBarNewBackgroundDrawable, "<this>");
        if (DIFactory.INSTANCE.getConfig().isBarrageInputNewAppearanceSwitch()) {
            if (collectionBottomBarNewBackgroundDrawable == null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                GradientDrawable $this$setCollectionBottomBarNewBackgroundDrawable_u24lambda_u2d4 = gradientDrawable;
                $this$setCollectionBottomBarNewBackgroundDrawable_u24lambda_u2d4.setShape(0);
                $this$setCollectionBottomBarNewBackgroundDrawable_u24lambda_u2d4.setCornerRadius((float) $this$setCollectionBottomBarNewBackgroundDrawable.getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_25dp));
                $this$setCollectionBottomBarNewBackgroundDrawable_u24lambda_u2d4.setColor($this$setCollectionBottomBarNewBackgroundDrawable.getContext().getResources().getColor(R.color.video_flow_color_33FFFFFF));
                collectionBottomBarNewBackgroundDrawable = gradientDrawable;
            }
            $this$setCollectionBottomBarNewBackgroundDrawable.setBackground(collectionBottomBarNewBackgroundDrawable);
        }
    }

    public static final void setAttitudeItemNewBackgroundDrawable(View $this$setAttitudeItemNewBackgroundDrawable) {
        Intrinsics.checkNotNullParameter($this$setAttitudeItemNewBackgroundDrawable, "<this>");
        if (DIFactory.INSTANCE.getConfig().isBarrageInputNewAppearanceSwitch()) {
            if (attitudeItemNewBackgroundDrawable == null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                GradientDrawable $this$setAttitudeItemNewBackgroundDrawable_u24lambda_u2d5 = gradientDrawable;
                $this$setAttitudeItemNewBackgroundDrawable_u24lambda_u2d5.setShape(0);
                $this$setAttitudeItemNewBackgroundDrawable_u24lambda_u2d5.setCornerRadius((float) $this$setAttitudeItemNewBackgroundDrawable.getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_25dp));
                $this$setAttitudeItemNewBackgroundDrawable_u24lambda_u2d5.setColor($this$setAttitudeItemNewBackgroundDrawable.getContext().getResources().getColor(R.color.video_flow_color_33FFFFFF));
                attitudeItemNewBackgroundDrawable = gradientDrawable;
            }
            $this$setAttitudeItemNewBackgroundDrawable.setBackground(attitudeItemNewBackgroundDrawable);
        }
    }
}
