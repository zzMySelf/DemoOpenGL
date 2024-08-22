package com.baidu.searchbox.download.center.ui.fusion.template;

import com.baidu.searchbox.ui.bubble.BubbleManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/download/center/ui/fusion/template/ClassificationTemplate$showUnzipBubbleIfNeed$2$1$1", "Lcom/baidu/searchbox/ui/bubble/BubbleManager$OnBubbleEventListener;", "onBubbleClick", "", "onBubbleDismiss", "onBubbleShow", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassificationTemplate.kt */
public final class ClassificationTemplate$showUnzipBubbleIfNeed$2$1$1 implements BubbleManager.OnBubbleEventListener {
    final /* synthetic */ ClassificationTemplate this$0;

    ClassificationTemplate$showUnzipBubbleIfNeed$2$1$1(ClassificationTemplate $receiver) {
        this.this$0 = $receiver;
    }

    public void onBubbleDismiss() {
    }

    public void onBubbleShow() {
    }

    public void onBubbleClick() {
        this.this$0.hideBubble();
    }
}
