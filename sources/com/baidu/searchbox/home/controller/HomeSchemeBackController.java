package com.baidu.searchbox.home.controller;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.searchbox.HomeViewManager;
import com.baidu.searchbox.home.AbsHomeView;
import com.baidu.searchbox.home.container.lifecycle.IHomeEventListener;
import com.baidu.searchbox.newhome.INewHomeEventListener;
import com.baidu.searchbox.schemeback.SchemeBackManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/home/controller/HomeSchemeBackController;", "Lcom/baidu/searchbox/home/container/lifecycle/IHomeEventListener;", "Lcom/baidu/searchbox/newhome/INewHomeEventListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onDestroy", "", "onFontSizeChanged", "onHomeHeaderVisible", "visible", "", "onHomePageVisible", "onHomeStateChanged", "oldState", "", "newState", "byTouch", "onLazyUiReady", "onNightModeChanged", "isNight", "lib-home-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeSchemeBackController.kt */
public final class HomeSchemeBackController implements IHomeEventListener, INewHomeEventListener {
    private final Context context;

    public HomeSchemeBackController(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public View getView() {
        return IHomeEventListener.DefaultImpls.getView(this);
    }

    public void onContentSelectedChange(boolean isRecommendTab) {
        INewHomeEventListener.DefaultImpls.onContentSelectedChange(this, isRecommendTab);
    }

    public boolean onFragmentKeyDown(int keyCode, KeyEvent event) {
        return INewHomeEventListener.DefaultImpls.onFragmentKeyDown(this, keyCode, event);
    }

    public boolean onFragmentKeyUp(int keyCode, KeyEvent event) {
        return INewHomeEventListener.DefaultImpls.onFragmentKeyUp(this, keyCode, event);
    }

    public void onHomeScrollChange(int curX, int curY, int oldX, int oldY, float scrollYPct, float scrollYPctFromLogoTop, float scrollYPctFromSearchBoxTop) {
        IHomeEventListener.DefaultImpls.onHomeScrollChange(this, curX, curY, oldX, oldY, scrollYPct, scrollYPctFromLogoTop, scrollYPctFromSearchBoxTop);
    }

    public void onHomeScrollStateChange(int oldState, int newState) {
        IHomeEventListener.DefaultImpls.onHomeScrollStateChange(this, oldState, newState);
    }

    public void onHomePageVisible(boolean visible) {
        AbsHomeView homeView = HomeViewManager.getInstance();
        if (homeView != null && (this.context instanceof Activity)) {
            if (visible) {
                SchemeBackManager.getInstance().addSchemeBackView((Activity) this.context, homeView);
            } else {
                SchemeBackManager.getInstance().removeSchemeBackView(homeView);
            }
        }
    }

    public void onHomeHeaderVisible(boolean visible) {
    }

    public void onHomeStateChanged(int oldState, int newState, boolean byTouch) {
    }

    public void onLazyUiReady() {
    }

    public void onDestroy() {
    }

    public void onFontSizeChanged() {
    }

    public void onNightModeChanged(boolean isNight) {
    }
}
