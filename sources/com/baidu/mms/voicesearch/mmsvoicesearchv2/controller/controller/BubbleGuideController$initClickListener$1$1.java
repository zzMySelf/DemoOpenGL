package com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller;

import android.view.View;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.BubbleGuideController;
import com.baidu.mms.voicesearch.voice.bean.dao.BubbleGuideModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/mms/voicesearch/mmsvoicesearchv2/controller/controller/BubbleGuideController$initClickListener$1$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BubbleGuideController.kt */
public final class BubbleGuideController$initClickListener$1$1 implements View.OnClickListener {
    final /* synthetic */ BubbleGuideModel $data;
    final /* synthetic */ BubbleGuideController this$0;

    BubbleGuideController$initClickListener$1$1(BubbleGuideController $receiver, BubbleGuideModel $data2) {
        this.this$0 = $receiver;
        this.$data = $data2;
    }

    public void onClick(View v) {
        BubbleGuideController.BubbleGuideShowCallBack access$getCallBack$p = this.this$0.callBack;
        if (access$getCallBack$p != null) {
            access$getCallBack$p.onBubbleClick(this.$data);
        }
    }
}
