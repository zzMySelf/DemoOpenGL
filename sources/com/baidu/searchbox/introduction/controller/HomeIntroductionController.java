package com.baidu.searchbox.introduction.controller;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.ActivityEmbeddingManager;
import com.baidu.searchbox.config.FontSizeConfig;
import com.baidu.searchbox.config.dialog.HomeFontToastManager;
import com.baidu.searchbox.config.impl.FontSizeRuntime;
import com.baidu.searchbox.home.container.lifecycle.IHomeEventListener;
import com.baidu.searchbox.homepage.extend.IHomeFun;
import com.baidu.searchbox.introduction.account.AccountDialogManager;
import com.baidu.searchbox.introduction.data.TaskGuideData;
import com.baidu.searchbox.introduction.font.HomeFontDialogManager;
import com.baidu.searchbox.introduction.location.HomeLocationManager;
import com.baidu.searchbox.introduction.model.TaskGuideShowUtil;
import com.baidu.searchbox.newhome.INewHomeEventListener;
import com.baidu.searchbox.newhome.extend.INewHomeApi;
import com.baidu.searchbox.push.notification.LeadSettingManager;
import com.baidu.searchbox.taskmanager.IdleLaunchTaskManager;
import com.baidu.searchbox.youthhome.IYouthHomeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/introduction/controller/HomeIntroductionController;", "Lcom/baidu/searchbox/home/container/lifecycle/IHomeEventListener;", "Lcom/baidu/searchbox/newhome/INewHomeEventListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onContentSelectedChange", "", "isRecommendTab", "", "onDestroy", "onFontSizeChanged", "onHomeHeaderVisible", "visible", "onHomePageVisible", "onHomeStateChanged", "oldState", "", "newState", "byTouch", "onLazyUiReady", "onNightModeChanged", "isNight", "showDialogIfNeed", "lib-home-introduction_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeIntroductionController.kt */
public final class HomeIntroductionController implements IHomeEventListener, INewHomeEventListener {
    private final Context context;

    public HomeIntroductionController(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public View getView() {
        return IHomeEventListener.DefaultImpls.getView(this);
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
        if (visible) {
            if (this.context instanceof FragmentActivity) {
                if (FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
                    HomeFontToastManager.INSTANCE.setHomePageVisible(true);
                }
                ActivityEmbeddingManager.INSTANCE.initialize((Activity) this.context);
                AccountDialogManager.INSTANCE.showFastLoginDialog((FragmentActivity) this.context);
                if (FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
                    if (FontSizeConfig.isNeedToast()) {
                        HomeFontToastManager.showFontSetToast(this.context);
                    }
                    HomeFontDialogManager.INSTANCE.showFontSetDialog((FragmentActivity) this.context);
                }
                HomeLocationManager.INSTANCE.showLocationDialogIfNeed((Activity) this.context);
                LeadSettingManager.checkShowLeadSettingDialog((Activity) this.context);
                TaskGuideShowUtil.tryPreloadGuideAndShow$default(TaskGuideShowUtil.INSTANCE, (TaskGuideData) null, 0, 1, (Object) null);
            }
        } else if (FontSizeRuntime.getFontSizeBizFun().isSupportFontSize()) {
            HomeFontToastManager.INSTANCE.setHomePageVisible(false);
        }
    }

    public void onHomeHeaderVisible(boolean visible) {
        if (visible) {
            showDialogIfNeed();
        }
    }

    public void onDestroy() {
        HomeLocationManager.INSTANCE.onDestroy();
    }

    public void onHomeStateChanged(int oldState, int newState, boolean byTouch) {
    }

    public void onLazyUiReady() {
    }

    public void onFontSizeChanged() {
    }

    public void onNightModeChanged(boolean isNight) {
    }

    public void onContentSelectedChange(boolean isRecommendTab) {
        IHomeFun homeApi;
        if (isRecommendTab) {
            IYouthHomeApi youthHomeApi = IYouthHomeApi.Companion.getYouthHomeApi();
            if (youthHomeApi != null && youthHomeApi.isYouthHome()) {
                homeApi = IYouthHomeApi.Companion.getYouthHomeApi();
            } else {
                homeApi = (IHomeFun) ServiceManager.getService(INewHomeApi.Companion.getSERVICE_REFERENCE());
            }
            if (homeApi != null && homeApi.isHeaderVisible()) {
                showDialogIfNeed();
            }
            if (homeApi != null && homeApi.isHomePageVisible()) {
                TaskGuideShowUtil.tryPreloadGuideAndShow$default(TaskGuideShowUtil.INSTANCE, (TaskGuideData) null, 0, 1, (Object) null);
            }
        }
    }

    private final void showDialogIfNeed() {
        IdleLaunchTaskManager.registerIdleTask(new HomeIntroductionController$showDialogIfNeed$1());
    }
}
