package com.baidu.searchbox.player.barrage;

import com.baidu.searchbox.danmakulib.model.BaseDanmakuModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J&\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/player/barrage/VulcanBarrageViewController$sendBarrage$1$1", "Lcom/baidu/searchbox/danmakulib/model/BaseDanmakuModel$IBarrageSendCallBack;", "onFail", "", "content", "", "msg", "onLoginReturn", "onLoginSend", "onSuccess", "topicId", "replyId", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanBarrageViewController.kt */
public final class VulcanBarrageViewController$sendBarrage$1$1 implements BaseDanmakuModel.IBarrageSendCallBack {
    final /* synthetic */ VulcanBarrageViewController this$0;

    VulcanBarrageViewController$sendBarrage$1$1(VulcanBarrageViewController $receiver) {
        this.this$0 = $receiver;
    }

    public void onLoginReturn() {
        VulcanBarrageViewController.barrageEventInvoke$default(this.this$0, -2, (Object) null, 2, (Object) null);
    }

    public void onLoginSend() {
    }

    public void onSuccess(String content, String topicId, String replyId) {
        Boolean unused = this.this$0.barrageEventInvoke(-3, topicId);
    }

    public void onFail(String content, String msg) {
    }
}
