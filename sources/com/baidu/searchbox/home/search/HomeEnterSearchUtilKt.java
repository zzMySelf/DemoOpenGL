package com.baidu.searchbox.home.search;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.home.search.callback.HomeEnterAnimationCallBack;
import com.baidu.searchbox.search.pyramid.SearchBrowserInterface;
import com.baidu.searchbox.ui.SearchBoxView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"MIN_DURATION", "", "TRANSLATE_DURATION", "startEnterAnimation", "", "searchBoxView", "Landroid/view/View;", "logoView", "cameraView", "callBack", "Lcom/baidu/searchbox/home/search/callback/HomeEnterAnimationCallBack;", "lib-home-search_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeEnterSearchUtil.kt */
public final class HomeEnterSearchUtilKt {
    private static final long MIN_DURATION = 16;
    private static final long TRANSLATE_DURATION = 350;

    public static final void startEnterAnimation(View searchBoxView, View logoView, View cameraView, HomeEnterAnimationCallBack callBack) {
        View view2 = searchBoxView;
        View view3 = logoView;
        View view4 = cameraView;
        HomeEnterAnimationCallBack homeEnterAnimationCallBack = callBack;
        Intrinsics.checkNotNullParameter(view2, "searchBoxView");
        Intrinsics.checkNotNullParameter(view4, "cameraView");
        int[] location = new int[2];
        SearchBoxView searchBoxView2 = HomeSearchBoxManager.getInstance().getSearchBoxView();
        View view5 = searchBoxView2 != null ? searchBoxView2.getChildAt(0) : null;
        if (view5 != null) {
            view5.getLocationInWindow(location);
        }
        if (location[1] > 0) {
            SearchBrowserInterface searchBrowserInterface = (SearchBrowserInterface) ServiceManager.getService(SearchBrowserInterface.SERVICE_REFERENCE);
            if (searchBrowserInterface != null) {
                searchBrowserInterface.setHomeEnterAnimating(true);
            }
            if (homeEnterAnimationCallBack != null) {
                callBack.onAnimationStart();
            }
            float searchBoxOffset = ((float) (location[1] - DeviceUtil.ScreenInfo.getStatusBarHeight())) - ((float) DeviceUtil.ScreenInfo.dp2px(searchBoxView.getContext(), 7.0f));
            float cameraOffset = (float) DeviceUtil.ScreenInfo.dp2px(cameraView.getContext(), 2.0f);
            view2.setTranslationY(searchBoxOffset);
            view2.setScaleY(1.1f);
            view2.setVisibility(8);
            view4.setTranslationX(-cameraOffset);
            if (view3 != null) {
                ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(16).start();
            }
            ObjectAnimator scaleAnimator = ObjectAnimator.ofFloat(view2, View.SCALE_Y, new float[]{1.1f, 1.0f});
            scaleAnimator.addListener(new HomeEnterSearchUtilKt$startEnterAnimation$1(view2, homeEnterAnimationCallBack));
            ObjectAnimator translateAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, new float[]{searchBoxOffset, 0.0f});
            ObjectAnimator cameraViewTrans = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-cameraOffset, 0.0f});
            AnimatorSet animator = new AnimatorSet();
            int[] iArr = location;
            animator.setStartDelay(16);
            animator.setDuration(350);
            animator.playTogether(new Animator[]{scaleAnimator, translateAnimator, cameraViewTrans});
            animator.start();
        }
    }
}
