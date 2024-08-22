package com.baidu.searchbox.video.feedflow.flow.swan;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.flow.list.VideoViewCoveredChanged;
import com.baidu.searchbox.video.feedflow.flow.list.VideoViewCoveredDetail;
import com.baidu.searchbox.video.feedflow.flow.swan.HalfScreenViewSwanAction;
import com.baidu.swan.api.interfaces.ISwanHalfScreenViewApp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/flow/swan/HalfScreenViewSwanPlugin$createLifecycleCallback$1", "Lcom/baidu/swan/api/interfaces/ISwanHalfScreenViewApp$LifecycleCallback;", "onFullScreen", "", "onHalfScreen", "onScreenClosed", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HalfScreenViewSwanPlugin.kt */
public final class HalfScreenViewSwanPlugin$createLifecycleCallback$1 implements ISwanHalfScreenViewApp.LifecycleCallback {
    final /* synthetic */ HalfScreenViewSwanPlugin this$0;

    HalfScreenViewSwanPlugin$createLifecycleCallback$1(HalfScreenViewSwanPlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onHalfScreen() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, HalfScreenViewSwanAction.OnHalfScreen.INSTANCE);
        }
        Store access$getStore2 = this.this$0.getStore();
        if (access$getStore2 != null) {
            StoreExtKt.post(access$getStore2, new VideoViewCoveredChanged(false, this.this$0.needUploadUbc, false, 4, (DefaultConstructorMarker) null));
        }
        Store access$getStore3 = this.this$0.getStore();
        if (access$getStore3 != null) {
            StoreExtKt.post(access$getStore3, new VideoViewCoveredDetail(3));
        }
        this.this$0.needUploadUbc = false;
    }

    public void onFullScreen() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, HalfScreenViewSwanAction.OnFullScreen.INSTANCE);
        }
        Store access$getStore2 = this.this$0.getStore();
        if (access$getStore2 != null) {
            StoreExtKt.post(access$getStore2, new VideoViewCoveredChanged(true, false, false, 6, (DefaultConstructorMarker) null));
        }
        Store access$getStore3 = this.this$0.getStore();
        if (access$getStore3 != null) {
            StoreExtKt.post(access$getStore3, new VideoViewCoveredDetail(2));
        }
        this.this$0.needUploadUbc = true;
    }

    public void onScreenClosed() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, HalfScreenViewSwanAction.OnScreenClose.INSTANCE);
        }
        Store access$getStore2 = this.this$0.getStore();
        if (access$getStore2 != null) {
            StoreExtKt.post(access$getStore2, new VideoViewCoveredChanged(false, this.this$0.needUploadUbc, false, 4, (DefaultConstructorMarker) null));
        }
        Store access$getStore3 = this.this$0.getStore();
        if (access$getStore3 != null) {
            StoreExtKt.post(access$getStore3, new VideoViewCoveredDetail(0));
        }
        this.this$0.needUploadUbc = false;
        this.this$0.release();
    }
}
