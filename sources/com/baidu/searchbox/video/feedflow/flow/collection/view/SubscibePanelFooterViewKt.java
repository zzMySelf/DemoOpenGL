package com.baidu.searchbox.video.feedflow.flow.collection.view;

import com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionCommonModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0003\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"COLLECTION_SUBSCRIBE_FOOTER_VIEW", "", "createSubscribeFooterModel", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/CollectionCommonModel;", "data", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/PaymentPanelFooterModel;", "getSubscribeFooterModel", "isSubscribeFooter", "", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubscibePanelFooterView.kt */
public final class SubscibePanelFooterViewKt {
    private static final String COLLECTION_SUBSCRIBE_FOOTER_VIEW = "collection_subscribe_footer_view";

    public static final boolean isSubscribeFooter(CollectionCommonModel $this$isSubscribeFooter) {
        Intrinsics.checkNotNullParameter($this$isSubscribeFooter, "<this>");
        return Intrinsics.areEqual((Object) $this$isSubscribeFooter.getType(), (Object) COLLECTION_SUBSCRIBE_FOOTER_VIEW);
    }

    public static final PaymentPanelFooterModel getSubscribeFooterModel(CollectionCommonModel $this$getSubscribeFooterModel) {
        Intrinsics.checkNotNullParameter($this$getSubscribeFooterModel, "<this>");
        Object extra = $this$getSubscribeFooterModel.getExtData().getExtra(COLLECTION_SUBSCRIBE_FOOTER_VIEW);
        if (!(extra instanceof PaymentPanelFooterModel)) {
            extra = null;
        }
        return (PaymentPanelFooterModel) extra;
    }

    public static final CollectionCommonModel createSubscribeFooterModel(PaymentPanelFooterModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        CollectionCommonModel $this$createSubscribeFooterModel_u24lambda_u2d0 = new CollectionCommonModel(COLLECTION_SUBSCRIBE_FOOTER_VIEW);
        $this$createSubscribeFooterModel_u24lambda_u2d0.getExtData().putExtra(COLLECTION_SUBSCRIBE_FOOTER_VIEW, data);
        return $this$createSubscribeFooterModel_u24lambda_u2d0;
    }
}
