package com.baidu.searchbox.video.feedflow.detail.collectionpayment;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "HideCollectionEntrance", "UploadPaymentButtonClickStatistic", "UploadPaymentButtonShowStatistic", "Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayAction$HideCollectionEntrance;", "Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayAction$UploadPaymentButtonShowStatistic;", "Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayAction$UploadPaymentButtonClickStatistic;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionColumnPayActionManifest.kt */
public abstract class CollectionColumnPayAction implements Action {
    public /* synthetic */ CollectionColumnPayAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CollectionColumnPayAction() {
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayAction$HideCollectionEntrance;", "Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayAction;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectionColumnPayActionManifest.kt */
    public static final class HideCollectionEntrance extends CollectionColumnPayAction {
        public static final HideCollectionEntrance INSTANCE = new HideCollectionEntrance();

        private HideCollectionEntrance() {
            super((DefaultConstructorMarker) null);
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayAction$UploadPaymentButtonShowStatistic;", "Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayAction;", "isSubscribeType", "", "(Z)V", "()Z", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectionColumnPayActionManifest.kt */
    public static final class UploadPaymentButtonShowStatistic extends CollectionColumnPayAction {
        private final boolean isSubscribeType;

        public UploadPaymentButtonShowStatistic() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public UploadPaymentButtonShowStatistic(boolean isSubscribeType2) {
            super((DefaultConstructorMarker) null);
            this.isSubscribeType = isSubscribeType2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UploadPaymentButtonShowStatistic(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? false : z);
        }

        public final boolean isSubscribeType() {
            return this.isSubscribeType;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayAction$UploadPaymentButtonClickStatistic;", "Lcom/baidu/searchbox/video/feedflow/detail/collectionpayment/CollectionColumnPayAction;", "isRedColor", "", "isSubscribeType", "(ZZ)V", "()Z", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectionColumnPayActionManifest.kt */
    public static final class UploadPaymentButtonClickStatistic extends CollectionColumnPayAction {
        private final boolean isRedColor;
        private final boolean isSubscribeType;

        public UploadPaymentButtonClickStatistic(boolean isRedColor2, boolean isSubscribeType2) {
            super((DefaultConstructorMarker) null);
            this.isRedColor = isRedColor2;
            this.isSubscribeType = isSubscribeType2;
        }

        public final boolean isRedColor() {
            return this.isRedColor;
        }

        public final boolean isSubscribeType() {
            return this.isSubscribeType;
        }
    }
}
