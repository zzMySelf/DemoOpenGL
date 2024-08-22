package com.baidu.growthsystem.wealth.video.component.widget.asset;

import android.text.SpannableString;
import android.text.TextUtils;
import com.baidu.growthsystem.business.wealthtask.R;
import com.baidu.growthsystem.wealth.video.component.widget.base.IWealthVideoWidget;
import com.baidu.growthsystem.wealth.video.component.widget.base.IWealthWidgetManagerContainer;
import com.baidu.growthsystem.wealth.video.component.widget.data.ProgressType;
import com.baidu.growthsystem.wealth.video.component.widget.data.WealthVideoWidgetRewardModel;
import com.baidu.growthsystem.wealth.video.component.widget.data.WealthWidgetBottomTipModel;
import com.baidu.growthsystem.wealth.video.component.widget.data.WealthWidgetProgressModel;
import com.baidu.growthsystem.wealth.video.component.widget.listener.IWealthAnimListener;
import com.baidu.growthsystem.wealth.video.data.WealthVideoExtraData;
import com.baidu.growthsystem.wealth.video.data.WealthVideoMultiInfo;
import com.baidu.growthsystem.wealth.video.data.WealthVideoSideTips;
import com.baidu.growthsystem.wealth.video.data.WealthVideoTaskData;
import com.baidu.growthsystem.wealth.video.servicce.WealthVideoServiceManager;
import com.baidu.growthsystem.wealth.video.service.WealthVideoStatus;
import com.baidu.growthsystem.wealth.video.utils.WealthVideoTipToastUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/growthsystem/wealth/video/component/widget/asset/WealthWidgetAssetManager;", "", "widgetView", "Lcom/baidu/growthsystem/wealth/video/component/widget/base/IWealthVideoWidget;", "container", "Lcom/baidu/growthsystem/wealth/video/component/widget/base/IWealthWidgetManagerContainer;", "(Lcom/baidu/growthsystem/wealth/video/component/widget/base/IWealthVideoWidget;Lcom/baidu/growthsystem/wealth/video/component/widget/base/IWealthWidgetManagerContainer;)V", "getWealthWidgetBottomTipModel", "Lcom/baidu/growthsystem/wealth/video/component/widget/data/WealthWidgetBottomTipModel;", "tip", "", "showArrow", "", "multiInfo", "Lcom/baidu/growthsystem/wealth/video/data/WealthVideoMultiInfo;", "isNoAsset", "data", "Lcom/baidu/growthsystem/wealth/video/data/WealthVideoTaskData;", "showCoinFloatWidget", "", "animListener", "Lcom/baidu/growthsystem/wealth/video/component/widget/listener/IWealthAnimListener;", "showEmptyAssetFloatWidget", "showMoneyFloatWidget", "status", "Lcom/baidu/growthsystem/wealth/video/service/WealthVideoStatus;", "showTextFloatWidget", "updateWidgetCoinAsset", "updateWidgetMoneyAsset", "updateWidgetMoneyAssetInside", "isNeedBottom", "updateWidgetNoAsset", "Companion", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WealthWidgetAssetManager.kt */
public final class WealthWidgetAssetManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String sideWidgetCoinTitle;
    private static final String sideWidgetCoinValue;
    private static final String sideWidgetMoneyTitle;
    private static final String sideWidgetMoneyValue;
    private final IWealthWidgetManagerContainer container;
    private final IWealthVideoWidget widgetView;

    public WealthWidgetAssetManager(IWealthVideoWidget widgetView2, IWealthWidgetManagerContainer container2) {
        Intrinsics.checkNotNullParameter(widgetView2, "widgetView");
        Intrinsics.checkNotNullParameter(container2, "container");
        this.widgetView = widgetView2;
        this.container = container2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/growthsystem/wealth/video/component/widget/asset/WealthWidgetAssetManager$Companion;", "", "()V", "sideWidgetCoinTitle", "", "sideWidgetCoinValue", "sideWidgetMoneyTitle", "sideWidgetMoneyValue", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WealthWidgetAssetManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String string = AppRuntime.getAppContext().getResources().getString(R.string.wealth_video_widget_reward_default);
        Intrinsics.checkNotNullExpressionValue(string, "getAppContext().resource…eo_widget_reward_default)");
        sideWidgetMoneyValue = string;
        String string2 = AppRuntime.getAppContext().getResources().getString(R.string.wealth_video_widget_my_cash);
        Intrinsics.checkNotNullExpressionValue(string2, "getAppContext().resource…lth_video_widget_my_cash)");
        sideWidgetMoneyTitle = string2;
        String string3 = AppRuntime.getAppContext().getResources().getString(R.string.wealth_video_widget_reward_coin_default);
        Intrinsics.checkNotNullExpressionValue(string3, "getAppContext().resource…dget_reward_coin_default)");
        sideWidgetCoinValue = string3;
        String string4 = AppRuntime.getAppContext().getResources().getString(R.string.wealth_video_widget_my_coin);
        Intrinsics.checkNotNullExpressionValue(string4, "getAppContext().resource…lth_video_widget_my_coin)");
        sideWidgetCoinTitle = string4;
    }

    public final void updateWidgetCoinAsset(WealthVideoTaskData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String bottomTip = data.getWidgetExtraConfig().getWidgetBottomCoinTypeTip();
        IWealthVideoWidget iWealthVideoWidget = this.widgetView;
        WealthWidgetProgressModel wealthWidgetProgressModel = new WealthWidgetProgressModel();
        WealthWidgetProgressModel $this$updateWidgetCoinAsset_u24lambda_u2d0 = wealthWidgetProgressModel;
        $this$updateWidgetCoinAsset_u24lambda_u2d0.setType(ProgressType.TYPE_COIN);
        $this$updateWidgetCoinAsset_u24lambda_u2d0.setCoinCount(data.getAsset());
        $this$updateWidgetCoinAsset_u24lambda_u2d0.setProgress(this.container.getCurViewProcess());
        $this$updateWidgetCoinAsset_u24lambda_u2d0.setShowArrow(false);
        iWealthVideoWidget.updateWidgetInfo(wealthWidgetProgressModel, true, getWealthWidgetBottomTipModel(bottomTip, true, data.getMultiInfo()));
    }

    public final void updateWidgetMoneyAsset(WealthVideoTaskData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        WealthVideoExtraData configData = data.getWidgetExtraConfig();
        IWealthVideoWidget iWealthVideoWidget = this.widgetView;
        WealthWidgetProgressModel wealthWidgetProgressModel = new WealthWidgetProgressModel();
        WealthWidgetProgressModel $this$updateWidgetMoneyAsset_u24lambda_u2d1 = wealthWidgetProgressModel;
        $this$updateWidgetMoneyAsset_u24lambda_u2d1.setType(ProgressType.TYPE_MONEY);
        $this$updateWidgetMoneyAsset_u24lambda_u2d1.setText(configData.getWidgetRibbonWithdrawTip());
        $this$updateWidgetMoneyAsset_u24lambda_u2d1.setProgress(this.container.getCurViewProcess());
        $this$updateWidgetMoneyAsset_u24lambda_u2d1.setShowArrow(true);
        IWealthVideoWidget.DefaultImpls.updateWidgetInfo$default(iWealthVideoWidget, wealthWidgetProgressModel, false, (WealthWidgetBottomTipModel) null, 4, (Object) null);
    }

    public final void updateWidgetMoneyAssetInside(WealthVideoTaskData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        updateWidgetMoneyAssetInside(data, true);
    }

    public final void updateWidgetMoneyAssetInside(WealthVideoTaskData data, boolean isNeedBottom) {
        Intrinsics.checkNotNullParameter(data, "data");
        String bottomTip = data.getWidgetExtraConfig().getWidgetRibbonWithdrawTip();
        IWealthVideoWidget iWealthVideoWidget = this.widgetView;
        WealthWidgetProgressModel wealthWidgetProgressModel = new WealthWidgetProgressModel();
        WealthWidgetProgressModel $this$updateWidgetMoneyAssetInside_u24lambda_u2d2 = wealthWidgetProgressModel;
        $this$updateWidgetMoneyAssetInside_u24lambda_u2d2.setType(ProgressType.TYPE_MONEY);
        $this$updateWidgetMoneyAssetInside_u24lambda_u2d2.setText(data.getAsset());
        String string = AppRuntime.getAppContext().getString(R.string.wealth_video_widget_reward_unit);
        Intrinsics.checkNotNullExpressionValue(string, "getAppContext().getStrin…video_widget_reward_unit)");
        $this$updateWidgetMoneyAssetInside_u24lambda_u2d2.setCurrency(string);
        $this$updateWidgetMoneyAssetInside_u24lambda_u2d2.setProgress(this.container.getCurViewProcess());
        $this$updateWidgetMoneyAssetInside_u24lambda_u2d2.setShowArrow(false);
        iWealthVideoWidget.updateWidgetInfo(wealthWidgetProgressModel, isNeedBottom, getWealthWidgetBottomTipModel(bottomTip, true, data.getMultiInfo()));
    }

    public final void updateWidgetNoAsset(WealthVideoTaskData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        WealthVideoExtraData configData = data.getWidgetExtraConfig();
        IWealthVideoWidget iWealthVideoWidget = this.widgetView;
        WealthWidgetProgressModel wealthWidgetProgressModel = new WealthWidgetProgressModel();
        WealthWidgetProgressModel $this$updateWidgetNoAsset_u24lambda_u2d3 = wealthWidgetProgressModel;
        $this$updateWidgetNoAsset_u24lambda_u2d3.setType(ProgressType.TYPE_MONEY);
        $this$updateWidgetNoAsset_u24lambda_u2d3.setText(configData.getWidgetRibbonWithdrawTip());
        $this$updateWidgetNoAsset_u24lambda_u2d3.setProgress(1.0f);
        $this$updateWidgetNoAsset_u24lambda_u2d3.setShowArrow(true);
        IWealthVideoWidget.DefaultImpls.updateWidgetInfo$default(iWealthVideoWidget, wealthWidgetProgressModel, false, (WealthWidgetBottomTipModel) null, 4, (Object) null);
    }

    public final boolean isNoAsset(WealthVideoTaskData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return WealthAssetManagerHelper.INSTANCE.isNoAsset(data);
    }

    private final WealthWidgetBottomTipModel getWealthWidgetBottomTipModel(String tip, boolean showArrow, WealthVideoMultiInfo multiInfo) {
        boolean z = true;
        if (multiInfo == null || !multiInfo.isDoubleTime()) {
            z = false;
        }
        if (z) {
            WealthWidgetBottomTipModel wealthWidgetBottomTipModel = new WealthWidgetBottomTipModel();
            WealthWidgetBottomTipModel $this$getWealthWidgetBottomTipModel_u24lambda_u2d4 = wealthWidgetBottomTipModel;
            $this$getWealthWidgetBottomTipModel_u24lambda_u2d4.setTip(multiInfo.getBottom());
            $this$getWealthWidgetBottomTipModel_u24lambda_u2d4.setShowArrow(false);
            return wealthWidgetBottomTipModel;
        }
        WealthWidgetBottomTipModel wealthWidgetBottomTipModel2 = new WealthWidgetBottomTipModel();
        WealthWidgetBottomTipModel $this$getWealthWidgetBottomTipModel_u24lambda_u2d5 = wealthWidgetBottomTipModel2;
        $this$getWealthWidgetBottomTipModel_u24lambda_u2d5.setTip(tip);
        $this$getWealthWidgetBottomTipModel_u24lambda_u2d5.setShowArrow(showArrow);
        return wealthWidgetBottomTipModel2;
    }

    public final void showMoneyFloatWidget(WealthVideoStatus status, WealthVideoTaskData data, IWealthAnimListener animListener) {
        String curTitle;
        WealthVideoExtraData widgetExtraConfig;
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(data, "data");
        if (status == WealthVideoStatus.NOT_LOGIN) {
            WealthVideoTaskData data2 = WealthVideoServiceManager.INSTANCE.getDataRepo().getData();
            if (data2 == null || (widgetExtraConfig = data2.getWidgetExtraConfig()) == null || (curTitle = widgetExtraConfig.getFloatUnLoginAssetTip()) == null) {
                curTitle = sideWidgetMoneyTitle;
            }
        } else {
            curTitle = sideWidgetMoneyTitle;
        }
        if (this.widgetView.isRewardMoneyZero()) {
            String defaultMoney = sideWidgetMoneyValue;
            if (!TextUtils.isEmpty(data.getTotalMoney())) {
                defaultMoney = data.getTotalMoney();
            }
            this.widgetView.updateRewardInfo(WealthVideoWidgetRewardModel.Companion.createSideMoneyTypeData(curTitle, defaultMoney));
        } else {
            if (!TextUtils.equals(curTitle, this.widgetView.getFloatWidgetTitleText())) {
                this.widgetView.updateRewardInfo(WealthVideoWidgetRewardModel.Companion.createSideMoneyTypeData(sideWidgetMoneyTitle, (String) null));
            }
            this.widgetView.changeFloatWidgetToLastMoneyType();
        }
        this.widgetView.collapseReward(true, true, animListener);
    }

    public final void showCoinFloatWidget(WealthVideoTaskData data, IWealthAnimListener animListener) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.widgetView.isRewardCoinZero()) {
            String defaultMoney = sideWidgetCoinValue;
            if (!TextUtils.isEmpty(data.getTotalCoin())) {
                defaultMoney = data.getTotalCoin();
            }
            this.widgetView.updateRewardInfo(WealthVideoWidgetRewardModel.Companion.createSideCoinTypeData(sideWidgetCoinTitle, defaultMoney));
        } else {
            this.widgetView.changeFloatWidgetToLastCoinType();
        }
        this.widgetView.collapseReward(true, true, animListener);
    }

    public final void showEmptyAssetFloatWidget(WealthVideoTaskData data, IWealthAnimListener animListener) {
        Intrinsics.checkNotNullParameter(data, "data");
        WealthVideoExtraData configData = data.getWidgetExtraConfig();
        this.widgetView.updateRewardInfo(WealthVideoWidgetRewardModel.Companion.createSideTextTipTypeData(configData.getFloatDefaultTitle(), configData.getFloatDefaultSubTitle(), true));
        this.widgetView.collapseReward(true, true, animListener);
    }

    public final void showTextFloatWidget(WealthVideoTaskData data, IWealthAnimListener animListener) {
        String curRewardSideTitle;
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(data, "data");
        WealthVideoSideTips curRewardSideTips = data.getSidetWidgetTips();
        if (curRewardSideTips == null || (curRewardSideTitle = curRewardSideTips.getTitle()) == null) {
            curRewardSideTitle = "";
        }
        SpannableString toastTipText = WealthVideoTipToastUtils.INSTANCE.getToastTipText(curRewardSideTips, true);
        if (toastTipText != null) {
            charSequence = toastTipText;
        } else {
            charSequence = "";
        }
        CharSequence curRewardSideSubTitle = charSequence;
        if (!TextUtils.isEmpty(curRewardSideSubTitle) && !TextUtils.isEmpty(curRewardSideTitle)) {
            this.widgetView.updateRewardInfo(WealthVideoWidgetRewardModel.Companion.createSideTextTipTypeData$default(WealthVideoWidgetRewardModel.Companion, curRewardSideTitle, curRewardSideSubTitle, false, 4, (Object) null));
            this.widgetView.collapseReward(true, true, animListener);
        } else if (animListener != null) {
            animListener.onAnimationEnd(false);
        }
    }
}
