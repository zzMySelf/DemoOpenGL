package com.baidu.searchbox.feed.news;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.feed.config.NewsConstant;
import com.baidu.searchbox.feed.h5.page.IPageLifecycle;
import com.baidu.searchbox.feed.h5.page.monitor.IMonitorContext;
import com.baidu.searchbox.feed.news.tpl.ITplHybrid;
import com.baidu.searchbox.feed.news.tpl.TplHybridContainer;
import com.baidu.searchbox.lightbrowser.container.base.AbsContainer;
import com.baidu.searchbox.lightbrowser.ioc.ILightBrowserSuspensionBall;
import com.baidu.searchbox.lightbrowser.timelogger.LightBrowserSpeedLoggerHelper;
import com.baidu.searchbox.widget.SlideInterceptor;

public class HybridActivity extends BaseActivity implements SlideInterceptor, ITplHybrid, ITplHybrid.IPerformanceCallback {
    protected static final boolean DEBUG = AppConfig.isDebug();
    /* access modifiers changed from: private */
    public TplHybridContainer mContainer;
    protected String mErrorPageUrl = NewsConstant.ERROR_PAGE_URL;
    private IPageLifecycle pageLifecycle = new IPageLifecycle.DefaultPageLifecycleImpl() {
        public void onPageStart() {
            HybridActivity.this.startLoadHybrid();
        }

        public void onLoadServerError() {
            if (HybridActivity.this.mContainer != null) {
                HybridActivity.this.mContainer.loadH5OrErrorPage();
            }
        }

        public void onLoadUrl(String url) {
            HybridActivity.this.endLoadHybrid();
        }

        public void onLoadData(String baseUrl) {
            HybridActivity.this.endLoadHybrid();
        }

        public IMonitorContext getPageMonitorContext() {
            return null;
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        startCreate();
        requestWindowFeature(1);
        getWindow().setSoftInputMode(32);
        if (ILightBrowserSuspensionBall.Impl.get().isSuspensionBallPage(getIntent())) {
            setPendingTransition(0, 0, 0, 0);
            forceActivityTransparent(true);
        } else {
            setPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        }
        if (Build.VERSION.SDK_INT == 26) {
            setEnableSliding(false);
            setCurrentActivityNoTransparent();
        } else {
            setEnableSliding(true, this);
        }
        super.onCreate(savedInstanceState);
        TplHybridContainer tplHybridContainer = new TplHybridContainer(this, this, this.pageLifecycle);
        this.mContainer = tplHybridContainer;
        tplHybridContainer.onCreate();
        loadLocalTpl();
        endCreate();
    }

    /* access modifiers changed from: protected */
    public void loadLocalTpl() {
        this.mContainer.loadLocalTpl();
    }

    /* access modifiers changed from: protected */
    public void refresh() {
        this.mContainer.refresh();
    }

    /* access modifiers changed from: protected */
    public TplHybridContainer getContainer() {
        return this.mContainer;
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        this.mContainer.onPostCreate(savedInstanceState);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContainer.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.mContainer.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mContainer.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.mContainer.onPause();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.mContainer.onStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.mContainer.onDestroy();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mContainer.onNewIntent(intent);
    }

    public void onLowMemory() {
        this.mContainer.onLowMemory();
    }

    public void finish() {
        this.mContainer.finish(new AbsContainer.ISuperFinish() {
            public void callSuperFinish() {
                HybridActivity.super.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.mContainer.onActivityResult(requestCode, resultCode, data);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 101 || requestCode == 2006) {
            this.mContainer.onRequestPermissionsResult(requestCode, permissions, grantResults);
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.mContainer.onKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (this.mContainer.onKeyUp(keyCode, event)) {
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mContainer.onConfigurationChanged(newConfig);
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        this.mContainer.onNightModeChanged(isNightMode);
    }

    public boolean isSlidable(MotionEvent ev) {
        TplHybridContainer tplHybridContainer = this.mContainer;
        if (tplHybridContainer != null) {
            return tplHybridContainer.canSlide(ev);
        }
        return false;
    }

    public String getContextJsonString() {
        return "";
    }

    public String getTemplateModuleName() {
        return "";
    }

    public String getTemplateId() {
        return "";
    }

    public String getErrorPageUrl() {
        return this.mErrorPageUrl;
    }

    public void startCreate() {
        TplHybridContainer tplHybridContainer = this.mContainer;
        if (tplHybridContainer != null) {
            tplHybridContainer.addSpeedLogOnCreateBegin(getIntent());
        }
    }

    public void endWebViewInit() {
    }

    public void endCreate() {
        TplHybridContainer tplHybridContainer = this.mContainer;
        if (tplHybridContainer != null) {
            tplHybridContainer.addSpeedLogOnCreateEnd();
        }
    }

    public void startLoadHybrid() {
        LightBrowserSpeedLoggerHelper.getInstance().recordTime(4);
    }

    public void endLoadHybrid() {
        LightBrowserSpeedLoggerHelper.getInstance().recordTime(5);
    }

    public Activity getActivity() {
        return this;
    }

    public void doFinish() {
        finish();
    }

    public boolean handleSetContentView() {
        return false;
    }
}
