package com.baidu.growthsystem.wealth.video.component.widget.sidetoast.data.asset;

import com.baidu.growthsystem.wealth.video.component.WealthCompViewData;
import com.baidu.growthsystem.wealth.video.component.widget.base.IWealthWidgetManagerContainer;
import com.baidu.growthsystem.wealth.video.component.widget.sidetoast.data.base.BaseWidgetSideToastTask;
import com.baidu.growthsystem.wealth.video.data.WealthVideoTaskDataKt;
import com.baidu.growthsystem.wealth.video.service.WealthVideoStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J$\u0010\f\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/baidu/growthsystem/wealth/video/component/widget/sidetoast/data/asset/NormalCoinAssetSideToastTask;", "Lcom/baidu/growthsystem/wealth/video/component/widget/sidetoast/data/base/BaseWidgetSideToastTask;", "Lcom/baidu/growthsystem/wealth/video/component/widget/sidetoast/data/asset/NormalCoinAssetSideToastData;", "container", "Lcom/baidu/growthsystem/wealth/video/component/widget/base/IWealthWidgetManagerContainer;", "data", "(Lcom/baidu/growthsystem/wealth/video/component/widget/base/IWealthWidgetManagerContainer;Lcom/baidu/growthsystem/wealth/video/component/widget/sidetoast/data/asset/NormalCoinAssetSideToastData;)V", "onShow", "", "next", "Lkotlin/Function0;", "removeCurTask", "onSurvivalTimeout", "showAble", "", "wealth-task-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NormalCoinAssetSideToastData.kt */
public final class NormalCoinAssetSideToastTask extends BaseWidgetSideToastTask<NormalCoinAssetSideToastData> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NormalCoinAssetSideToastTask(IWealthWidgetManagerContainer container, NormalCoinAssetSideToastData data) {
        super(container, data);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public boolean showAble() {
        WealthCompViewData statusData = getContainer().getStatusData();
        WealthVideoStatus status = statusData != null ? statusData.getStatus() : null;
        if ((status == WealthVideoStatus.RUNNING || status == WealthVideoStatus.NOT_LOGIN) && WealthVideoTaskDataKt.isCoinType(getAssetData())) {
            return super.showAble();
        }
        return false;
    }

    public void onShow(Function0<Unit> next, Function0<Unit> removeCurTask) {
        Intrinsics.checkNotNullParameter(next, "next");
        Intrinsics.checkNotNullParameter(removeCurTask, "removeCurTask");
        getWidgetAssetManager().showCoinFloatWidget(getAssetData(), new NormalCoinAssetSideToastTask$onShow$1(next, this));
    }

    public void onSurvivalTimeout(Function0<Unit> next, Function0<Unit> removeCurTask) {
        Intrinsics.checkNotNullParameter(next, "next");
        Intrinsics.checkNotNullParameter(removeCurTask, "removeCurTask");
        getWidgetSideToastManager().dismiss(new NormalCoinAssetSideToastTask$onSurvivalTimeout$1(next, removeCurTask, this));
    }
}
