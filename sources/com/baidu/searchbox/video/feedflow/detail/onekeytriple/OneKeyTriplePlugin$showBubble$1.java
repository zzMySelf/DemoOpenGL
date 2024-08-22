package com.baidu.searchbox.video.feedflow.detail.onekeytriple;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.flow.guidemanager.GuideShown;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/onekeytriple/OneKeyTriplePlugin$showBubble$1", "Lcom/baidu/searchbox/ui/bubble/BubbleManager$OnBubbleEventListener;", "onBubbleClick", "", "onBubbleDismiss", "onBubbleShow", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OneKeyTriplePlugin.kt */
public final class OneKeyTriplePlugin$showBubble$1 implements BubbleManager.OnBubbleEventListener {
    final /* synthetic */ OneKeyTriplePlugin this$0;

    OneKeyTriplePlugin$showBubble$1(OneKeyTriplePlugin $receiver) {
        this.this$0 = $receiver;
    }

    public void onBubbleShow() {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new OneKeyTripleBubbleShownAction(true));
        }
    }

    public void onBubbleClick() {
    }

    public void onBubbleDismiss() {
        this.this$0.bubbleManager = null;
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            StoreExtKt.post(access$getStore, new GuideShown(35));
        }
        Store access$getStore2 = this.this$0.getStore();
        if (access$getStore2 != null) {
            access$getStore2.dispatch(new OneKeyTripleBubbleShownAction(false));
        }
    }
}
