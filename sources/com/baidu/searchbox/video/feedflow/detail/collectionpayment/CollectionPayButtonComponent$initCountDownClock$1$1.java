package com.baidu.searchbox.video.feedflow.detail.collectionpayment;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.State;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.detail.repos.PaymentModel;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.collectionpayment.CollectionColumnPayAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "curCountDown", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionPayButtonComponent.kt */
final class CollectionPayButtonComponent$initCountDownClock$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ CollectionPayButtonComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectionPayButtonComponent$initCountDownClock$1$1(CollectionPayButtonComponent collectionPayButtonComponent) {
        super(1);
        this.this$0 = collectionPayButtonComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int curCountDown) {
        Store $this$select$iv;
        PaymentModel $this$invoke_u24lambda_u2d0;
        if (curCountDown == this.this$0.showCountDownTime) {
            this.this$0.getCollectionPayButton().showViewWithAnimator(this.this$0.isLandscape());
            Store access$getStore = this.this$0.getStore();
            if (access$getStore != null) {
                StoreExtKt.post(access$getStore, new CollectionColumnPayAction.UploadPaymentButtonShowStatistic(this.this$0.isSubscribeType()));
            }
        } else if (curCountDown == this.this$0.colorChangedCountDownTime && ($this$select$iv = this.this$0.getStore()) != null) {
            State state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(CollectionColumnPayState.class);
            }
            CollectionColumnPayState collectionColumnPayState = (CollectionColumnPayState) obj;
            if (collectionColumnPayState != null && ($this$invoke_u24lambda_u2d0 = collectionColumnPayState.getPaymentModel()) != null) {
                CollectionPayButtonComponent collectionPayButtonComponent = this.this$0;
                if (!$this$invoke_u24lambda_u2d0.isHitPromoteCashier()) {
                    collectionPayButtonComponent.getCollectionPayButton().startColorAnimator(collectionPayButtonComponent.isLandscape());
                }
                collectionPayButtonComponent.stopCountDown();
            }
        }
    }
}
