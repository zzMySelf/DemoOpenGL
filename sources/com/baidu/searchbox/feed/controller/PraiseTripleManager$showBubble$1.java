package com.baidu.searchbox.feed.controller;

import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.lightbrowser.ioc.ICommonCallback;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/controller/PraiseTripleManager$showBubble$1", "Lcom/baidu/searchbox/ui/bubble/BubbleManager$OnBubbleEventListener;", "onBubbleClick", "", "onBubbleDismiss", "onBubbleShow", "lib-feed-news_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseTripleManager.kt */
public final class PraiseTripleManager$showBubble$1 implements BubbleManager.OnBubbleEventListener {
    final /* synthetic */ ICommonCallback<Boolean> $callback;
    final /* synthetic */ PraiseTripleManager this$0;

    PraiseTripleManager$showBubble$1(PraiseTripleManager $receiver, ICommonCallback<Boolean> $callback2) {
        this.this$0 = $receiver;
        this.$callback = $callback2;
    }

    public void onBubbleShow() {
        DefaultSharedPrefsWrapper.getInstance().putInt("dt_bubble_guidance_show_time", this.this$0.mBubbleShowTimes + 1);
        DefaultSharedPrefsWrapper.getInstance().putLong("dt_last_show_bubble_time", System.currentTimeMillis());
        ICommonCallback<Boolean> iCommonCallback = this.$callback;
        if (iCommonCallback != null) {
            iCommonCallback.onResult(true);
        }
    }

    public void onBubbleClick() {
    }

    public void onBubbleDismiss() {
        ICommonCallback<Boolean> iCommonCallback = this.$callback;
        if (iCommonCallback != null) {
            iCommonCallback.onResult(false);
        }
    }
}
