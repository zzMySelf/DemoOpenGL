package com.baidu.searchbox.newhome;

import android.view.KeyEvent;
import com.baidu.searchbox.home.util.HomeGuideBanUtilsKt;
import com.baidu.searchbox.newhome.INewHomeEventListener;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/newhome/NewHomeChildContainer$wrapHomeOneOneWidgetGuide$1", "Lcom/baidu/searchbox/newhome/INewHomeEventListener;", "onHomePageVisible", "", "isVisible", "", "lib-home-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHomeChildContainer.kt */
public final class NewHomeChildContainer$wrapHomeOneOneWidgetGuide$1 implements INewHomeEventListener {
    final /* synthetic */ INewHomeEventListener $listener;

    NewHomeChildContainer$wrapHomeOneOneWidgetGuide$1(INewHomeEventListener $listener2) {
        this.$listener = $listener2;
    }

    public void onContentSelectedChange(boolean isRecommendTab) {
        INewHomeEventListener.DefaultImpls.onContentSelectedChange(this, isRecommendTab);
    }

    public void onDestroy() {
        INewHomeEventListener.DefaultImpls.onDestroy(this);
    }

    public void onFontSizeChanged() {
        INewHomeEventListener.DefaultImpls.onFontSizeChanged(this);
    }

    public boolean onFragmentKeyDown(int keyCode, KeyEvent event) {
        return INewHomeEventListener.DefaultImpls.onFragmentKeyDown(this, keyCode, event);
    }

    public boolean onFragmentKeyUp(int keyCode, KeyEvent event) {
        return INewHomeEventListener.DefaultImpls.onFragmentKeyUp(this, keyCode, event);
    }

    @Deprecated(message = "首页头部可见变化回调，新首页不应使用此状态")
    public void onHomeHeaderVisible(boolean visible) {
        INewHomeEventListener.DefaultImpls.onHomeHeaderVisible(this, visible);
    }

    @Deprecated(message = "吸顶状态变化回调，新首页不应使用此状态")
    public void onHomeStateChanged(int oldState, int newState, boolean byTouch) {
        INewHomeEventListener.DefaultImpls.onHomeStateChanged(this, oldState, newState, byTouch);
    }

    public void onLazyUiReady() {
        INewHomeEventListener.DefaultImpls.onLazyUiReady(this);
    }

    public void onNightModeChanged(boolean isNight) {
        INewHomeEventListener.DefaultImpls.onNightModeChanged(this, isNight);
    }

    public void onHomePageVisible(boolean isVisible) {
        HomeGuideBanUtilsKt.checkCanShowGuide(2, true, new NewHomeChildContainer$wrapHomeOneOneWidgetGuide$1$onHomePageVisible$1(this.$listener, isVisible));
    }
}
