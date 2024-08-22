package com.baidu.searchbox.video.feedflow.detail.payment.more;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.flowvideo.detail.repos.PaymentModel;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.more.MoreStateConfig;
import com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction;
import com.baidu.searchbox.video.feedflow.flow.more.MoreFlowReducerAdapterMiddleware;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\"\u0010\b\u001a\u00020\u00042\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J*\u0010\u000b\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0014¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/payment/more/PaymentMoreFlowReducerAdapterMiddleware;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowReducerAdapterMiddleware;", "()V", "bindData", "", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "onSuccess", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "updateMoreStateConfigInternal", "config", "", "Lcom/baidu/searchbox/video/feedflow/detail/more/MoreStateConfig;", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMoreFlowReducerAdapterMiddleware.kt */
public final class PaymentMoreFlowReducerAdapterMiddleware extends MoreFlowReducerAdapterMiddleware {
    /* access modifiers changed from: protected */
    public void onSuccess(NetAction.Success<?> action, Store<CommonState> store) {
        PaymentModel paymentModel;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(store, "store");
        super.onSuccess(action, store);
        if (store.getState().isActive()) {
            Object data = action.getData();
            FlowDetailModel bean = data instanceof FlowDetailModel ? (FlowDetailModel) data : null;
            if (bean != null && (paymentModel = bean.getPaymentModel()) != null) {
                if (paymentModel.isPaid()) {
                    StoreExtKt.post(store, new MoreFlowAction.HideAirPlay(false));
                } else {
                    StoreExtKt.post(store, new MoreFlowAction.HideAirPlay(true));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateMoreStateConfigInternal(Store<CommonState> store, Map<MoreStateConfig, Object> config) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(config, "config");
        super.updateMoreStateConfigInternal(store, config);
        if (UBCManifestKt.isPageSourceFromCollection(store)) {
            config.put(MoreStateConfig.CLEAR_SCREEN_VISIBLE, false);
        }
    }

    public void bindData(Store<CommonState> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        super.bindData(store);
        StoreExtKt.post(store, new MoreFlowAction.HideFloating(true));
    }
}
