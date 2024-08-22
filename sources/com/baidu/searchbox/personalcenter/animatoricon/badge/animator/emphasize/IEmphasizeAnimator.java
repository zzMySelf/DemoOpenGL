package com.baidu.searchbox.personalcenter.animatoricon.badge.animator.emphasize;

import android.view.View;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.AnimatorEmphasize;
import com.baidu.searchbox.personalcenter.animatoricon.badge.animator.emphasize.IEmphasizeAnimatorSwing;
import com.baidu.searchbox.personalcenter.animatoricon.badge.animator.emphasize.IEmphasizeAnimatorZoom;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H&J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/emphasize/IEmphasizeAnimator;", "Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/emphasize/IEmphasizeAnimatorSwing;", "Lcom/baidu/searchbox/personalcenter/animatoricon/badge/animator/emphasize/IEmphasizeAnimatorZoom;", "checkIsShimmer", "", "animatorType", "Lcom/baidu/searchbox/kmm/personalcenter/entities/constants/AnimatorEmphasize;", "fetchEmphasizeAnimatorDuration", "", "fetchEmphasizeAnimatorType", "updateEmphasizeAnimatorProgress", "", "view", "Landroid/view/View;", "progress", "", "lib-personal-center-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IEmphasizeAnimator.kt */
public interface IEmphasizeAnimator extends IEmphasizeAnimatorSwing, IEmphasizeAnimatorZoom {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IEmphasizeAnimator.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnimatorEmphasize.values().length];
            iArr[AnimatorEmphasize.SWING.ordinal()] = 1;
            iArr[AnimatorEmphasize.ZOOM.ordinal()] = 2;
            iArr[AnimatorEmphasize.SHIMMER_SINGLE.ordinal()] = 3;
            iArr[AnimatorEmphasize.SHIMMER_DOUBLE.ordinal()] = 4;
            iArr[AnimatorEmphasize.SHIMMER_THREE.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    boolean checkIsShimmer(AnimatorEmphasize animatorEmphasize);

    long fetchEmphasizeAnimatorDuration(AnimatorEmphasize animatorEmphasize);

    AnimatorEmphasize fetchEmphasizeAnimatorType();

    void updateEmphasizeAnimatorProgress(View view2, float f2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IEmphasizeAnimator.kt */
    public static final class DefaultImpls {
        public static void onUpdateEmphasizeSwingProgress(IEmphasizeAnimator iEmphasizeAnimator, View view2, float progress) {
            Intrinsics.checkNotNullParameter(view2, "view");
            IEmphasizeAnimatorSwing.DefaultImpls.onUpdateEmphasizeSwingProgress(iEmphasizeAnimator, view2, progress);
        }

        public static void onUpdateEmphasizeZoomProgress(IEmphasizeAnimator iEmphasizeAnimator, View view2, float progress) {
            Intrinsics.checkNotNullParameter(view2, "view");
            IEmphasizeAnimatorZoom.DefaultImpls.onUpdateEmphasizeZoomProgress(iEmphasizeAnimator, view2, progress);
        }

        public static void updateEmphasizeAnimatorProgress(IEmphasizeAnimator iEmphasizeAnimator, View view2, float progress) {
            if (view2 != null) {
                AnimatorEmphasize animatorType = iEmphasizeAnimator.fetchEmphasizeAnimatorType();
                if (AnimatorEmphasize.SWING == animatorType) {
                    iEmphasizeAnimator.onUpdateEmphasizeSwingProgress(view2, progress);
                } else if (AnimatorEmphasize.ZOOM == animatorType) {
                    if (view2 instanceof IZoomCallback) {
                        ((IZoomCallback) view2).updateZoomProgress(progress);
                    }
                } else if (iEmphasizeAnimator.checkIsShimmer(animatorType) && (view2 instanceof IShimmerCallback)) {
                    ((IShimmerCallback) view2).updateShimmerProgress(progress, iEmphasizeAnimator.fetchEmphasizeAnimatorDuration(animatorType));
                }
            }
        }

        public static long fetchEmphasizeAnimatorDuration(IEmphasizeAnimator iEmphasizeAnimator, AnimatorEmphasize animatorType) {
            Intrinsics.checkNotNullParameter(animatorType, "animatorType");
            switch (WhenMappings.$EnumSwitchMapping$0[animatorType.ordinal()]) {
                case 1:
                    return 500;
                case 2:
                    return 330;
                case 3:
                    return 670;
                case 4:
                    return 750;
                case 5:
                    return 830;
                default:
                    return 1;
            }
        }

        public static boolean checkIsShimmer(IEmphasizeAnimator iEmphasizeAnimator, AnimatorEmphasize animatorType) {
            Intrinsics.checkNotNullParameter(animatorType, "animatorType");
            boolean shimmerSingle = AnimatorEmphasize.SHIMMER_SINGLE == animatorType;
            boolean shimmerDouble = AnimatorEmphasize.SHIMMER_DOUBLE == animatorType;
            boolean shimmerThree = AnimatorEmphasize.SHIMMER_THREE == animatorType;
            if (shimmerSingle || shimmerDouble || shimmerThree) {
                return true;
            }
            return false;
        }
    }
}
