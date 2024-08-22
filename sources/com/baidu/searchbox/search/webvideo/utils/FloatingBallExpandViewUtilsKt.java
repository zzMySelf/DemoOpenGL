package com.baidu.searchbox.search.webvideo.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.search.videodetail.R;
import com.baidu.searchbox.search.webvideo.cache.H5PlayerCache;
import com.baidu.searchbox.search.webvideo.player.SearchH5ProxyPlayer;
import com.baidu.searchbox.search.webvideo.player.SearchH5VideoPlayer;
import com.baidu.searchbox.search.webvideo.player.layer.SnifferNetDiskToastLayer;
import com.baidu.searchbox.search.webvideo.ui.SearchH5FloatingBallExpandView;
import com.baidu.searchbox.search.webvideo.vip.LcbSendVipManager;
import com.baidu.share.common.util.UIUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u00182\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u001a0\u0010(\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010%\u001a\u00020\u00182\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u001a\u0006\u0010-\u001a\u00020\u0001\u001a\u0006\u0010.\u001a\u00020\u0001\u001a\u0006\u0010/\u001a\u00020$\u001a\u0006\u00100\u001a\u00020$\u001a\u001a\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u00012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u001a$\u00103\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00104\u001a\u00020\u00012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0006\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\" \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\"\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\"\u001a\u0010\u001d\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001c\"\u001b\u0010\u001f\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b \u0010\b¨\u00065"}, d2 = {"GUIDE_TYPE_LOADING", "", "GUIDE_TYPE_PLAYING", "GUIDE_TYPE_SNIFFER", "MSG_WHAT_END_EXPAND", "MSG_WHAT_START_EXPAND", "curGuideType", "getCurGuideType", "()I", "setCurGuideType", "(I)V", "floatingBallExpandView", "Lcom/baidu/searchbox/search/webvideo/ui/SearchH5FloatingBallExpandView;", "getFloatingBallExpandView", "()Lcom/baidu/searchbox/search/webvideo/ui/SearchH5FloatingBallExpandView;", "setFloatingBallExpandView", "(Lcom/baidu/searchbox/search/webvideo/ui/SearchH5FloatingBallExpandView;)V", "floatingBallLocation", "", "getFloatingBallLocation", "()[I", "setFloatingBallLocation", "([I)V", "hasShowGuide", "", "getHasShowGuide", "()Z", "setHasShowGuide", "(Z)V", "isShowingExpandView", "setShowingExpandView", "realWindowWidth", "getRealWindowWidth", "realWindowWidth$delegate", "Lkotlin/Lazy;", "dismissFloatingBallExpandView", "", "ifAnimate", "listener", "Lcom/baidu/searchbox/search/webvideo/utils/ExpandViewAnimatorListener;", "endFloatingBallExpandLayoutAnimation", "rootView", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "getCurrGuideType", "getRealWidth", "releaseFloatingBallExpandView", "releaseHandleMessage", "showFloatingBallExpandView", "guideType", "startFloatingBallExpandLayoutAnimation", "textType", "lib_search_video_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FloatingBallExpandViewUtils.kt */
public final class FloatingBallExpandViewUtilsKt {
    public static final int GUIDE_TYPE_LOADING = 1;
    public static final int GUIDE_TYPE_PLAYING = 2;
    public static final int GUIDE_TYPE_SNIFFER = 0;
    public static final int MSG_WHAT_END_EXPAND = 91204;
    public static final int MSG_WHAT_START_EXPAND = 91203;
    private static int curGuideType = -1;
    private static SearchH5FloatingBallExpandView floatingBallExpandView;
    private static int[] floatingBallLocation = new int[2];
    private static boolean hasShowGuide;
    private static boolean isShowingExpandView;
    private static final Lazy realWindowWidth$delegate = LazyKt.lazy(FloatingBallExpandViewUtilsKt$realWindowWidth$2.INSTANCE);

    /* access modifiers changed from: private */
    public static final int getRealWindowWidth() {
        return ((Number) realWindowWidth$delegate.getValue()).intValue();
    }

    public static final SearchH5FloatingBallExpandView getFloatingBallExpandView() {
        return floatingBallExpandView;
    }

    public static final void setFloatingBallExpandView(SearchH5FloatingBallExpandView searchH5FloatingBallExpandView) {
        floatingBallExpandView = searchH5FloatingBallExpandView;
    }

    public static final int[] getFloatingBallLocation() {
        return floatingBallLocation;
    }

    public static final void setFloatingBallLocation(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        floatingBallLocation = iArr;
    }

    public static final boolean getHasShowGuide() {
        return hasShowGuide;
    }

    public static final void setHasShowGuide(boolean z) {
        hasShowGuide = z;
    }

    public static final boolean isShowingExpandView() {
        return isShowingExpandView;
    }

    public static final void setShowingExpandView(boolean z) {
        isShowingExpandView = z;
    }

    public static final int getCurGuideType() {
        return curGuideType;
    }

    public static final void setCurGuideType(int i2) {
        curGuideType = i2;
    }

    public static /* synthetic */ void showFloatingBallExpandView$default(int i2, ExpandViewAnimatorListener expandViewAnimatorListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            expandViewAnimatorListener = null;
        }
        showFloatingBallExpandView(i2, expandViewAnimatorListener);
    }

    public static final void showFloatingBallExpandView(int guideType, ExpandViewAnimatorListener listener) {
        ViewTreeObserver viewTreeObserver;
        if (!SearchH5SnifferToastUtilsKt.isShowOnlyDownload() && !SearchH5SnifferToastUtilsKt.isOnlyDownloadNotShowNetDisk() && LcbSendVipManager.INSTANCE.isTargetToastSpeedBubble$lib_search_video_release() && !SearchH5DetectUtlsKt.getHadReset() && !isShowingExpandView) {
            curGuideType = guideType;
            View floatingBallLayout = FloatingBallViewUtilsKt.getFloatingBallLayout();
            if (floatingBallLayout != null && (viewTreeObserver = floatingBallLayout.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new FloatingBallExpandViewUtilsKt$showFloatingBallExpandView$1(guideType, listener));
            }
        }
    }

    public static /* synthetic */ void startFloatingBallExpandLayoutAnimation$default(View view2, int i2, ExpandViewAnimatorListener expandViewAnimatorListener, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            expandViewAnimatorListener = null;
        }
        startFloatingBallExpandLayoutAnimation(view2, i2, expandViewAnimatorListener);
    }

    public static final void startFloatingBallExpandLayoutAnimation(View view2, int textType, ExpandViewAnimatorListener listener) {
        float offX;
        long delayMills;
        View floatingBallLayout = FloatingBallViewUtilsKt.getFloatingBallLayout();
        if (floatingBallLayout != null && !floatingBallLayout.isShown()) {
            if (AppConfig.isDebug()) {
                Log.e("gcj", "ExpandView展开动画 悬浮球不存在，不进行引导布局动画");
            }
        } else if (view2 != null) {
            isShowingExpandView = true;
            View needAlphaContent = view2.findViewById(R.id.text_content);
            if (needAlphaContent != null) {
                needAlphaContent.setAlpha(0.0f);
            }
            view2.measure(0, 0);
            if (floatingBallLocation[0] < getRealWindowWidth() / 2) {
                offX = (float) floatingBallLocation[0];
            } else {
                offX = ((float) getRealWindowWidth()) - ((float) view2.getMeasuredWidth());
            }
            if (AppConfig.isDebug()) {
                Log.e("gcj", "动画弹出位置 offx: " + getRealWindowWidth() + AbstractJsonLexerKt.COMMA + view2.getMeasuredWidth());
            }
            switch (textType) {
                case 0:
                    delayMills = ((long) SearchH5SnifferToastUtilsKt.getToastBubbleDetectDismissNum()) * 1000;
                    break;
                case 1:
                    delayMills = ((long) SearchH5SnifferToastUtilsKt.getToastPoornetDismissIntervalNum()) * 1000;
                    break;
                case 2:
                    delayMills = ((long) SearchH5SnifferToastUtilsKt.getToastBubbleAccDismissNum()) * 1000;
                    break;
                default:
                    delayMills = ((long) SearchH5SnifferToastUtilsKt.getToastBubbleDetectDismissNum()) * 1000;
                    break;
            }
            view2.animate().translationX(offX).alpha(1.0f).setDuration(300).setInterpolator(new LinearInterpolator()).withStartAction(new FloatingBallExpandViewUtilsKt$$ExternalSyntheticLambda3(listener)).withEndAction(new FloatingBallExpandViewUtilsKt$$ExternalSyntheticLambda4(listener, delayMills)).start();
            if (needAlphaContent != null) {
                needAlphaContent.animate().alpha(1.0f).setDuration(300).start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startFloatingBallExpandLayoutAnimation$lambda-0  reason: not valid java name */
    public static final void m2953startFloatingBallExpandLayoutAnimation$lambda0(ExpandViewAnimatorListener $listener) {
        if (AppConfig.isDebug()) {
            Log.e("gcj", "ExpandView展开动画 动画开始");
        }
        if ($listener != null) {
            $listener.showExpandViewStartAnimation();
        }
        View floatingBallLayout = FloatingBallViewUtilsKt.getFloatingBallLayout();
        if (floatingBallLayout != null) {
            floatingBallLayout.setVisibility(8);
        }
        SearchH5FloatingBallExpandView searchH5FloatingBallExpandView = floatingBallExpandView;
        View floatingBallExpandLayout = searchH5FloatingBallExpandView != null ? searchH5FloatingBallExpandView.getFloatingBallExpandLayout() : null;
        if (floatingBallExpandLayout != null) {
            floatingBallExpandLayout.setVisibility(0);
        }
        SearchH5VideoUbcUtils.floatingBallBubbleStatistic("show", getCurrGuideType());
    }

    /* access modifiers changed from: private */
    /* renamed from: startFloatingBallExpandLayoutAnimation$lambda-2  reason: not valid java name */
    public static final void m2954startFloatingBallExpandLayoutAnimation$lambda2(ExpandViewAnimatorListener $listener, long $delayMills) {
        if (AppConfig.isDebug()) {
            Log.e("gcj", "ExpandView展开动画 动画结束");
        }
        if ($listener != null) {
            $listener.showExpandViewEndAnimation();
        }
        Handler handler = UiThreadUtils.getMainHandler();
        if (handler.hasMessages(MSG_WHAT_END_EXPAND)) {
            handler.removeMessages(MSG_WHAT_END_EXPAND);
        }
        Message message = Message.obtain(handler, new FloatingBallExpandViewUtilsKt$$ExternalSyntheticLambda2($listener));
        message.what = MSG_WHAT_END_EXPAND;
        handler.sendMessageDelayed(message, $delayMills);
    }

    /* access modifiers changed from: private */
    /* renamed from: startFloatingBallExpandLayoutAnimation$lambda-2$lambda-1  reason: not valid java name */
    public static final void m2955startFloatingBallExpandLayoutAnimation$lambda2$lambda1(ExpandViewAnimatorListener $listener) {
        dismissFloatingBallExpandView$default(false, $listener, 1, (Object) null);
    }

    public static /* synthetic */ void dismissFloatingBallExpandView$default(boolean z, ExpandViewAnimatorListener expandViewAnimatorListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            expandViewAnimatorListener = null;
        }
        dismissFloatingBallExpandView(z, expandViewAnimatorListener);
    }

    public static final void dismissFloatingBallExpandView(boolean ifAnimate, ExpandViewAnimatorListener listener) {
        View floatingBallExpandLayout;
        SearchH5FloatingBallExpandView searchH5FloatingBallExpandView = floatingBallExpandView;
        boolean z = true;
        if (searchH5FloatingBallExpandView == null || (floatingBallExpandLayout = searchH5FloatingBallExpandView.getFloatingBallExpandLayout()) == null || !floatingBallExpandLayout.isShown()) {
            z = false;
        }
        if (z) {
            UiThreadUtils.runOnUiThread(new FloatingBallExpandViewUtilsKt$$ExternalSyntheticLambda5(ifAnimate, listener));
        } else if (AppConfig.isDebug()) {
            Log.e("gcj", "dismiss ExpandView 不存在，return，不做dismiss操作");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dismissFloatingBallExpandView$lambda-4  reason: not valid java name */
    public static final void m2950dismissFloatingBallExpandView$lambda4(boolean $ifAnimate, ExpandViewAnimatorListener $listener) {
        SearchH5FloatingBallExpandView searchH5FloatingBallExpandView = floatingBallExpandView;
        View view2 = null;
        ViewGroup mRootView = searchH5FloatingBallExpandView != null ? searchH5FloatingBallExpandView.getMRootView() : null;
        SearchH5FloatingBallExpandView searchH5FloatingBallExpandView2 = floatingBallExpandView;
        if (searchH5FloatingBallExpandView2 != null) {
            view2 = searchH5FloatingBallExpandView2.getFloatingBallExpandLayout();
        }
        endFloatingBallExpandLayoutAnimation(mRootView, view2, $ifAnimate, $listener);
    }

    public static /* synthetic */ void endFloatingBallExpandLayoutAnimation$default(ViewGroup viewGroup, View view2, boolean z, ExpandViewAnimatorListener expandViewAnimatorListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            expandViewAnimatorListener = null;
        }
        endFloatingBallExpandLayoutAnimation(viewGroup, view2, z, expandViewAnimatorListener);
    }

    public static final void endFloatingBallExpandLayoutAnimation(ViewGroup rootView, View view2, boolean ifAnimate, ExpandViewAnimatorListener listener) {
        float offX;
        if (AppConfig.isDebug()) {
            Log.e("gcj", "ExpandView dismiss 收起动画 开始ifAnimate:" + ifAnimate);
        }
        if (rootView != null && view2 != null) {
            view2.setAlpha(1.0f);
            view2.measure(0, 0);
            if (floatingBallLocation[0] < getRealWindowWidth() / 2) {
                offX = ((float) floatingBallLocation[0]) - UIUtils.dip2px(AppRuntime.getAppContext(), 174.0f);
            } else {
                offX = (float) floatingBallLocation[0];
            }
            if (ifAnimate) {
                view2.animate().translationX(offX).alpha(0.0f).setDuration(300).withEndAction(new FloatingBallExpandViewUtilsKt$$ExternalSyntheticLambda0(rootView, view2, listener)).setInterpolator(new LinearInterpolator()).start();
                return;
            }
            rootView.removeView(view2);
            SearchH5FloatingBallExpandView searchH5FloatingBallExpandView = floatingBallExpandView;
            View floatingBallExpandLayout = searchH5FloatingBallExpandView != null ? searchH5FloatingBallExpandView.getFloatingBallExpandLayout() : null;
            if (floatingBallExpandLayout != null) {
                floatingBallExpandLayout.setVisibility(8);
            }
            isShowingExpandView = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: endFloatingBallExpandLayoutAnimation$lambda-5  reason: not valid java name */
    public static final void m2951endFloatingBallExpandLayoutAnimation$lambda5(ViewGroup $rootView, View $view, ExpandViewAnimatorListener $listener) {
        isShowingExpandView = false;
        if (AppConfig.isDebug()) {
            Log.e("gcj", "ExpandView收起动画 结束");
        }
        $rootView.removeView($view);
        View floatingBallLayout = FloatingBallViewUtilsKt.getFloatingBallLayout();
        if (floatingBallLayout != null) {
            floatingBallLayout.setVisibility(0);
        }
        if ($listener != null) {
            $listener.dismissExpandViewEndAnimation();
        }
    }

    public static final void releaseFloatingBallExpandView() {
        dismissFloatingBallExpandView$default(false, (ExpandViewAnimatorListener) null, 2, (Object) null);
        SearchH5FloatingBallExpandView searchH5FloatingBallExpandView = floatingBallExpandView;
        if (searchH5FloatingBallExpandView != null) {
            searchH5FloatingBallExpandView.setFloatingBallExpandLayout((View) null);
        }
        floatingBallExpandView = null;
        isShowingExpandView = false;
        releaseHandleMessage();
        UiThreadUtils.runOnUiThread(new FloatingBallExpandViewUtilsKt$$ExternalSyntheticLambda1());
    }

    /* access modifiers changed from: private */
    /* renamed from: releaseFloatingBallExpandView$lambda-6  reason: not valid java name */
    public static final void m2952releaseFloatingBallExpandView$lambda6() {
        SearchH5ProxyPlayer player;
        SearchH5VideoPlayer searchH5VideoPlayer;
        SnifferNetDiskToastLayer snifferNetDiskToastLayer;
        H5PlayerCache instance = H5PlayerCache.getInstance();
        if (instance != null && (player = instance.getPlayer()) != null && (searchH5VideoPlayer = player.mPlayer) != null && (snifferNetDiskToastLayer = searchH5VideoPlayer.snifferNetDiskToastLayer) != null) {
            snifferNetDiskToastLayer.recycleCountDownTimer();
        }
    }

    public static final void releaseHandleMessage() {
        Handler handler = UiThreadUtils.getMainHandler();
        if (handler.hasMessages(MSG_WHAT_START_EXPAND)) {
            handler.removeMessages(MSG_WHAT_START_EXPAND);
        }
        if (handler.hasMessages(MSG_WHAT_END_EXPAND)) {
            handler.removeMessages(MSG_WHAT_END_EXPAND);
        }
    }

    public static final int getCurrGuideType() {
        return curGuideType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r0 = (android.view.ViewGroup) r0.findViewById(16908290);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int getRealWidth() {
        /*
            android.app.Activity r0 = com.baidu.searchbox.appframework.BdBoxActivityManager.getRealTopActivity()     // Catch:{ Exception -> 0x001c }
            if (r0 == 0) goto L_0x0017
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r1)     // Catch:{ Exception -> 0x001c }
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ Exception -> 0x001c }
            if (r0 == 0) goto L_0x0017
            int r0 = r0.getWidth()     // Catch:{ Exception -> 0x001c }
            goto L_0x002b
        L_0x0017:
            int r0 = com.baidu.share.common.util.UIUtils.getDisplayWidth()     // Catch:{ Exception -> 0x001c }
            goto L_0x002b
        L_0x001c:
            r0 = move-exception
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r1 == 0) goto L_0x0026
            r0.printStackTrace()
        L_0x0026:
            int r1 = com.baidu.share.common.util.UIUtils.getDisplayWidth()
            r0 = r1
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.webvideo.utils.FloatingBallExpandViewUtilsKt.getRealWidth():int");
    }
}
