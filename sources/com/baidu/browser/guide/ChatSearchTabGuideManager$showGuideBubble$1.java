package com.baidu.browser.guide;

import com.baidu.android.ext.manage.MutexPopManager;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/browser/guide/ChatSearchTabGuideManager$showGuideBubble$1", "Lcom/baidu/searchbox/ui/bubble/BubbleManager$OnBubbleEventListener;", "onBubbleClick", "", "onBubbleDismiss", "onBubbleShow", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchTabGuideManager.kt */
public final class ChatSearchTabGuideManager$showGuideBubble$1 implements BubbleManager.OnBubbleEventListener {
    ChatSearchTabGuideManager$showGuideBubble$1() {
    }

    public void onBubbleShow() {
        ChatSearchTabGuideManager.INSTANCE.saveHasShowBubbleGuide();
    }

    public void onBubbleClick() {
    }

    public void onBubbleDismiss() {
        MutexPopManager.doNextTask();
    }
}
