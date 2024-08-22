package com.baidu.searchbox.youthhome.ioc;

import android.view.KeyEvent;
import android.view.View;
import com.baidu.searchbox.newhome.HomeV1TabViewRefreshType;
import com.baidu.searchbox.youthhome.IYouthHomeEventExt;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/baidu/searchbox/youthhome/ioc/YouthHomeRuntime$getYouthHomeChildContainer$defaultEvent$1", "Lcom/baidu/searchbox/youthhome/IYouthHomeEventExt;", "youth-home-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: YouthHomeRuntime.kt */
public final class YouthHomeRuntime$getYouthHomeChildContainer$defaultEvent$1 implements IYouthHomeEventExt {
    YouthHomeRuntime$getYouthHomeChildContainer$defaultEvent$1() {
    }

    public void adjustPosition(int height) {
        IYouthHomeEventExt.DefaultImpls.adjustPosition(this, height);
    }

    public View getView() {
        return IYouthHomeEventExt.DefaultImpls.getView(this);
    }

    public boolean isReceiveAllContentEvent() {
        return IYouthHomeEventExt.DefaultImpls.isReceiveAllContentEvent(this);
    }

    public void onContentRefresh(String pageId, HomeV1TabViewRefreshType refreshType, String ext) {
        IYouthHomeEventExt.DefaultImpls.onContentRefresh(this, pageId, refreshType, ext);
    }

    public void onContentSelectedChange(int from, int to, boolean isRecommendTab) {
        IYouthHomeEventExt.DefaultImpls.onContentSelectedChange(this, from, to, isRecommendTab);
    }

    public void onDestroy() {
        IYouthHomeEventExt.DefaultImpls.onDestroy(this);
    }

    public void onFontSizeChanged() {
        IYouthHomeEventExt.DefaultImpls.onFontSizeChanged(this);
    }

    public boolean onFragmentKeyDown(int keyCode, KeyEvent event) {
        return IYouthHomeEventExt.DefaultImpls.onFragmentKeyDown(this, keyCode, event);
    }

    public boolean onFragmentKeyUp(int keyCode, KeyEvent event) {
        return IYouthHomeEventExt.DefaultImpls.onFragmentKeyUp(this, keyCode, event);
    }

    public void onGoToDefault() {
        IYouthHomeEventExt.DefaultImpls.onGoToDefault(this);
    }

    @Deprecated(message = "首页头部可见变化回调，年轻化首页不应使用此状态")
    public void onHomeHeaderVisible(boolean visible) {
        IYouthHomeEventExt.DefaultImpls.onHomeHeaderVisible(this, visible);
    }

    public void onHomeMainDragY(int dy, int currentY, int scrollAbleY, int dragY) {
        IYouthHomeEventExt.DefaultImpls.onHomeMainDragY(this, dy, currentY, scrollAbleY, dragY);
    }

    public void onHomeMainScrolled(int dy, int currentY, int scrollAbleY) {
        IYouthHomeEventExt.DefaultImpls.onHomeMainScrolled(this, dy, currentY, scrollAbleY);
    }

    public void onHomePageVisible(boolean isVisible) {
        IYouthHomeEventExt.DefaultImpls.onHomePageVisible(this, isVisible);
    }

    @Deprecated(message = "吸顶状态变化回调，年轻化不应使用此状态")
    public void onHomeStateChanged(int oldState, int newState, boolean byTouch) {
        IYouthHomeEventExt.DefaultImpls.onHomeStateChanged(this, oldState, newState, byTouch);
    }

    public void onHomeTouchDown() {
        IYouthHomeEventExt.DefaultImpls.onHomeTouchDown(this);
    }

    public void onLazyUiReady() {
        IYouthHomeEventExt.DefaultImpls.onLazyUiReady(this);
    }

    public void onNightModeChanged(boolean isNight) {
        IYouthHomeEventExt.DefaultImpls.onNightModeChanged(this, isNight);
    }

    public void onPause() {
        IYouthHomeEventExt.DefaultImpls.onPause(this);
    }

    public void onResume() {
        IYouthHomeEventExt.DefaultImpls.onResume(this);
    }

    public void onTabSelected(int fromIndex, int toIndex, int selectedType) {
        IYouthHomeEventExt.DefaultImpls.onTabSelected(this, fromIndex, toIndex, selectedType);
    }

    public void setScrollState(int state) {
        IYouthHomeEventExt.DefaultImpls.setScrollState(this, state);
    }
}
