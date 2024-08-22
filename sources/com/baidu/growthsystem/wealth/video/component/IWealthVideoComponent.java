package com.baidu.growthsystem.wealth.video.component;

import android.view.View;
import com.baidu.growthsystem.framework.component.ICommonGrowthComponent;
import com.baidu.growthsystem.wealth.video.interceptor.IWealthTaskCompSideTipInterceptor;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Deprecated;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\bH'J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000eH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000eH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000eH&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&¨\u0006\u001e"}, d2 = {"Lcom/baidu/growthsystem/wealth/video/component/IWealthVideoComponent;", "Lcom/baidu/growthsystem/framework/component/ICommonGrowthComponent;", "clearTimerViewBadgeIcon", "", "getComponentView", "Landroid/view/View;", "getContentView", "getContentViewPreMeasureHeight", "", "getContentViewWithTopRewardPreMeasureHeight", "getRootViewViewPreMeasureHeight", "getTimerView", "getTimerViewPreMeasureHeight", "isAttached", "", "isVisible", "onClick", "type", "Lcom/baidu/growthsystem/wealth/video/component/ClickType;", "setClickAble", "clickAble", "setSideOrientation", "isRight", "setSideTipInterceptor", "interceptor", "Lcom/baidu/growthsystem/wealth/video/interceptor/IWealthTaskCompSideTipInterceptor;", "setVisibility", "isVisibility", "updateView", "updateWidgetAssetInfo", "wealth-task-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IWealthVideoComponent.kt */
public interface IWealthVideoComponent extends ICommonGrowthComponent {
    void clearTimerViewBadgeIcon();

    View getComponentView();

    View getContentView();

    int getContentViewPreMeasureHeight();

    int getContentViewWithTopRewardPreMeasureHeight();

    int getRootViewViewPreMeasureHeight();

    View getTimerView();

    @Deprecated(message = "replaced by getRootViewViewPreMeasureHeight")
    int getTimerViewPreMeasureHeight();

    boolean isAttached();

    boolean isVisible();

    void onClick(ClickType clickType);

    void setClickAble(boolean z);

    void setSideOrientation(boolean z);

    void setSideTipInterceptor(IWealthTaskCompSideTipInterceptor iWealthTaskCompSideTipInterceptor);

    void setVisibility(boolean z);

    void updateView();

    void updateWidgetAssetInfo();
}
