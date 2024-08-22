package com.baidu.searchbox.video.feedflow.flow.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState;", "", "()V", "Default", "Empty", "Fail", "Loading", "Success", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState$Empty;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState$Loading;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState$Fail;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState$Success;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState$Default;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionPanelContentState.kt */
public abstract class CollectionPanelContentState {
    public /* synthetic */ CollectionPanelContentState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CollectionPanelContentState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState$Empty;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectionPanelContentState.kt */
    public static final class Empty extends CollectionPanelContentState {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState$Loading;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectionPanelContentState.kt */
    public static final class Loading extends CollectionPanelContentState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState$Fail;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectionPanelContentState.kt */
    public static final class Fail extends CollectionPanelContentState {
        public static final Fail INSTANCE = new Fail();

        private Fail() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState$Success;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectionPanelContentState.kt */
    public static final class Success extends CollectionPanelContentState {
        public static final Success INSTANCE = new Success();

        private Success() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState$Default;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionPanelContentState;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CollectionPanelContentState.kt */
    public static final class Default extends CollectionPanelContentState {
        public static final Default INSTANCE = new Default();

        private Default() {
            super((DefaultConstructorMarker) null);
        }
    }
}
