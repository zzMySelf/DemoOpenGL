package com.baidu.searchbox.weather.container;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.browser.utils.SearchPinchUtilsKt;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.browserenhanceengine.container.animation.ContainerAnimationInterceptor;
import com.baidu.searchbox.browserenhanceengine.utils.BeeRenderMonitor;
import com.baidu.searchbox.browserenhanceengine.utils.ImmersionUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.nacomp.beecompat.container.SimpleCompatContainer;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.pinchsummary.model.PinchSummaryEntity;
import com.baidu.searchbox.pinchsummary.model.PinchSummaryPageInfo;
import com.baidu.searchbox.pinchsummary.model.PinchSummarySceneType;
import com.baidu.searchbox.pinchsummary.model.PinchSummarySourceType;
import com.baidu.searchbox.weather.R;
import com.baidu.searchbox.weather.comps.page.WeatherRootComp;
import com.baidu.searchbox.weather.events.CloseContainerEvent;
import com.baidu.searchbox.weather.ioc.IWeatherRenderStat;
import com.baidu.searchbox.weather.statistic.WeatherStats;

public class WeatherLandingContainer extends SimpleCompatContainer<WeatherContainerModel> {
    private static final String LANDING_PAGE_TYPE = "NaWeatherPage";
    /* access modifiers changed from: private */
    public boolean isBackExit = false;
    private final View mContentView;
    private WeatherRootComp mPageComp;
    /* access modifiers changed from: private */
    public final UniqueId mToken;

    public WeatherLandingContainer(Context context, WeatherContainerModel containerModel) {
        super(context, containerModel);
        UniqueId gen = UniqueId.gen("WeatherLandingContainer");
        this.mToken = gen;
        this.page = "weather";
        this.mContentView = LayoutInflater.from(context).inflate(R.layout.page_weather_landing_root, (ViewGroup) null);
        if (containerModel.getModel() != null) {
            this.mPageComp = new WeatherRootComp(this, contentView(), gen, containerModel.getModel());
        }
        registerCloseContainerEvent();
    }

    public View contentView() {
        return this.mContentView;
    }

    public boolean isSupportImmersion() {
        return true;
    }

    public void applyImmersion() {
        super.applyImmersion();
        if (this.mContext != null) {
            ImmersionUtils.setSystemUIVisibility(this.mContext, true);
            ImmersionUtils.enableWhiteTranslucentStatus(this.mContext, true);
        }
    }

    public void onResume(Intent intent) {
        super.onResume(intent);
        applyImmersion();
    }

    private void registerCloseContainerEvent() {
        BdEventBus.Companion.getDefault().register(this, CloseContainerEvent.class, new Action<CloseContainerEvent>() {
            public void call(CloseContainerEvent event) {
                if (WeatherLandingContainer.this.mToken.equals(event.getToken()) && WeatherLandingContainer.this.getContainerManager() != null) {
                    boolean unused = WeatherLandingContainer.this.isBackExit = true;
                    WeatherLandingContainer.this.closeSelf(true);
                }
            }
        });
    }

    public boolean isSlidable(MotionEvent ev) {
        WeatherRootComp weatherRootComp = this.mPageComp;
        return weatherRootComp != null && weatherRootComp.isSlidable(ev);
    }

    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);
        WeatherRootComp weatherRootComp = this.mPageComp;
        if (weatherRootComp != null) {
            weatherRootComp.onConfigurationChanged();
        }
    }

    public void onNightModeChanged(boolean nightMode) {
        super.onNightModeChanged(nightMode);
        WeatherRootComp weatherRootComp = this.mPageComp;
        if (weatherRootComp != null) {
            weatherRootComp.onNightModeChange(nightMode);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4 && event != null && event.getAction() == 0) {
            this.isBackExit = true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onPause() {
        stat1013ExtInfo();
        super.onPause();
    }

    private void stat1013ExtInfo() {
        IWeatherRenderStat renderStat = IWeatherRenderStat.Companion.getImpl();
        renderStat.updateStatistic(this.page, "waitTime", String.valueOf(BeeRenderMonitor.getTime() - renderStat.getStartTime(this.page)));
        boolean z = this.isBackExit;
        String isBackExit2 = z ? "1" : "0";
        if (!z) {
            if (WeatherStats.of(this.mToken).isRequestingPermission()) {
                renderStat.changeStatus(this.page, "101");
            } else {
                renderStat.changeStatus(this.page, "102");
            }
        }
        renderStat.updateStatistic(this.page, "isBackExit", isBackExit2);
    }

    public void onDestroy() {
        super.onDestroy();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public ContainerAnimationInterceptor getContainerAnimation() {
        return null;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        WeatherRootComp weatherRootComp = this.mPageComp;
        if (weatherRootComp != null) {
            weatherRootComp.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        WeatherRootComp weatherRootComp = this.mPageComp;
        if (weatherRootComp != null) {
            weatherRootComp.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public String getLandingPageType() {
        return LANDING_PAGE_TYPE;
    }

    public PinchSummaryEntity canSupportPinchSummary() {
        PinchSummaryEntity entity = new PinchSummaryEntity();
        entity.setPinchGestureEnable(true);
        entity.setPinchSummaryEnable(false);
        PinchSummaryPageInfo pageInfo = new PinchSummaryPageInfo();
        pageInfo.setSceneType(PinchSummarySceneType.SEARCH_NA_LANDING_WEATHER);
        pageInfo.setSourceType(PinchSummarySourceType.SEARCH);
        WeatherRootComp weatherRootComp = this.mPageComp;
        if (weatherRootComp != null) {
            entity.setPinchSummaryPageInfo(weatherRootComp.getPinchPageInfo());
            if (AppConfig.isDebug()) {
                Log.d(SearchPinchUtilsKt.PINCH_TAG, "天气落地页打点数据：" + this.mPageComp.getPinchPageInfo().toString());
            }
        }
        return entity;
    }
}
