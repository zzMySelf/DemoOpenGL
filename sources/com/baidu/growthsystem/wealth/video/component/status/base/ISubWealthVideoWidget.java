package com.baidu.growthsystem.wealth.video.component.status.base;

import com.baidu.growthsystem.wealth.video.component.ClickType;
import com.baidu.growthsystem.wealth.video.data.WealthVideoTaskFloatTipAsset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000eH&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, d2 = {"Lcom/baidu/growthsystem/wealth/video/component/status/base/ISubWealthVideoWidget;", "", "autoNext", "", "hideLiveTplNoTimingToast", "hidePreventCheatTipToast", "onClick", "type", "Lcom/baidu/growthsystem/wealth/video/component/ClickType;", "onContainerPause", "onContainerResume", "onTaskRegistered", "showFloatWidgetAssetInfo", "assetInfo", "Lcom/baidu/growthsystem/wealth/video/data/WealthVideoTaskFloatTipAsset;", "showLiveTplNoTimingToast", "showPreventCheatTipToast", "updateWidgetAssetInfo", "addAsset", "updateWidgetMultiInfoView", "beforeIsDoubleTime", "", "source", "", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ISubWealthVideoWidget.kt */
public interface ISubWealthVideoWidget {
    void autoNext();

    void hideLiveTplNoTimingToast();

    void hidePreventCheatTipToast();

    void onClick(ClickType clickType);

    void onContainerPause();

    void onContainerResume();

    void onTaskRegistered();

    void showFloatWidgetAssetInfo(WealthVideoTaskFloatTipAsset wealthVideoTaskFloatTipAsset);

    void showLiveTplNoTimingToast();

    void showPreventCheatTipToast();

    void updateWidgetAssetInfo();

    void updateWidgetAssetInfo(WealthVideoTaskFloatTipAsset wealthVideoTaskFloatTipAsset);

    void updateWidgetMultiInfoView(boolean z, String str);
}
