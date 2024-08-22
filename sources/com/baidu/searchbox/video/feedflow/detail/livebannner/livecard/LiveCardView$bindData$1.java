package com.baidu.searchbox.video.feedflow.detail.livebannner.livecard;

import com.baidu.searchbox.video.feedflow.detail.livebannner.livecard.adapter.ILiveCardViewHolderCallBack;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/livebannner/livecard/LiveCardView$bindData$1", "Lcom/baidu/searchbox/video/feedflow/detail/livebannner/livecard/adapter/ILiveCardViewHolderCallBack;", "onCallBack", "", "type", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveCardView.kt */
public final class LiveCardView$bindData$1 implements ILiveCardViewHolderCallBack {
    final /* synthetic */ LiveCardView this$0;

    LiveCardView$bindData$1(LiveCardView $receiver) {
        this.this$0 = $receiver;
    }

    public void onCallBack(int type) {
        switch (type) {
            case 0:
                ILiveCardCallback cardViewCallback = this.this$0.getCardViewCallback();
                if (cardViewCallback != null) {
                    cardViewCallback.onCardViewClicked();
                    return;
                }
                return;
            case 1:
                ILiveCardCallback cardViewCallback2 = this.this$0.getCardViewCallback();
                if (cardViewCallback2 != null) {
                    cardViewCallback2.onCloseBtnClicked();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
