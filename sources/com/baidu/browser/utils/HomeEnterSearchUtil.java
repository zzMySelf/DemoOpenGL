package com.baidu.browser.utils;

import android.view.View;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.home.search.callback.HomeEnterAnimationCallBack;
import com.baidu.searchbox.home.search.event.SearchViewAnimationEvent;
import com.baidu.searchbox.homepage.extend.IHomeFun;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0004J@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/baidu/browser/utils/HomeEnterSearchUtil;", "", "()V", "isAnimating", "", "()Z", "setAnimating", "(Z)V", "isStateHome", "startEnterAnimation", "", "rootView", "Landroid/view/View;", "contentView", "searchBoxView", "logoView", "cameraView", "callBack", "Lcom/baidu/searchbox/home/search/callback/HomeEnterAnimationCallBack;", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeEnterSearchUtil.kt */
public final class HomeEnterSearchUtil {
    public static final HomeEnterSearchUtil INSTANCE = new HomeEnterSearchUtil();
    private static boolean isAnimating;

    private HomeEnterSearchUtil() {
    }

    public final boolean isAnimating() {
        return isAnimating;
    }

    public final void setAnimating(boolean z) {
        isAnimating = z;
    }

    public final boolean isStateHome() {
        IHomeFun iHomeFun = (IHomeFun) ServiceManager.getService(IHomeFun.SERVICE_REFERENCE);
        if (iHomeFun != null && iHomeFun.getHomeState() == 0) {
            return true;
        }
        return false;
    }

    public final void startEnterAnimation(View rootView, View contentView, View searchBoxView, View logoView, View cameraView, HomeEnterAnimationCallBack callBack) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (cameraView != null && contentView != null && searchBoxView != null) {
            BdEventBus.Companion.getDefault().post(new SearchViewAnimationEvent(searchBoxView, logoView, cameraView, callBack));
        }
    }
}
