package com.baidu.searchbox.feed.template.taloslite;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import com.baidu.searchbox.feed.template.tplinterface.ITalosLiteContainerEventEmitter;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/searchbox/feed/template/taloslite/FeedTalosLiteSlotView$globalLayoutListener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTalosLiteSlotView.kt */
public final class FeedTalosLiteSlotView$globalLayoutListener$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ FeedTalosLiteSlotView this$0;

    FeedTalosLiteSlotView$globalLayoutListener$1(FeedTalosLiteSlotView $receiver) {
        this.this$0 = $receiver;
    }

    public void onGlobalLayout() {
        if (this.this$0.getGlobalVisibleRect(new Rect())) {
            ITalosLiteContainerEventEmitter.DefaultImpls.dispatchContainerEvent$default(this.this$0, "appear", (JSONObject) null, 2, (Object) null);
            this.this$0.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
