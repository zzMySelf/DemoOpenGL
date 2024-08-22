package com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.TypeWriterTextView;
import com.baidu.mms.voicesearch.voice.bean.dao.BubbleGuideModel;
import com.baidu.voicesearch.component.utils.NormalTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/mms/voicesearch/mmsvoicesearchv2/controller/controller/BubbleGuideController$runEnterAnimSetTypeWriter$1$onAnimationEnd$1", "Lcom/baidu/voicesearch/component/utils/NormalTask;", "doTask", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BubbleGuideController.kt */
public final class BubbleGuideController$runEnterAnimSetTypeWriter$1$onAnimationEnd$1 extends NormalTask {
    final /* synthetic */ BubbleGuideModel $data;
    final /* synthetic */ BubbleGuideController this$0;

    BubbleGuideController$runEnterAnimSetTypeWriter$1$onAnimationEnd$1(BubbleGuideController $receiver, BubbleGuideModel $data2) {
        this.this$0 = $receiver;
        this.$data = $data2;
    }

    public boolean doTask() {
        TextView access$getMainTextView$p = this.this$0.mainTextView;
        if (access$getMainTextView$p != null) {
            access$getMainTextView$p.setVisibility(0);
        }
        ImageView access$getBtnIcon$p = this.this$0.btnIcon;
        if (access$getBtnIcon$p != null) {
            access$getBtnIcon$p.setVisibility(4);
        }
        TextView access$getBtnTextView$p = this.this$0.btnTextView;
        if (access$getBtnTextView$p != null) {
            access$getBtnTextView$p.setVisibility(4);
        }
        if (this.this$0.mainTextView instanceof TypeWriterTextView) {
            TextView access$getMainTextView$p2 = this.this$0.mainTextView;
            if (access$getMainTextView$p2 != null) {
                TypeWriterTextView.start$default((TypeWriterTextView) access$getMainTextView$p2, this.$data.getMainText(), 0, 2, (Object) null);
                TextView access$getMainTextView$p3 = this.this$0.mainTextView;
                if (access$getMainTextView$p3 != null) {
                    ((TypeWriterTextView) access$getMainTextView$p3).setOnTypeViewListener(new BubbleGuideController$runEnterAnimSetTypeWriter$1$onAnimationEnd$1$doTask$1(this.this$0));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.TypeWriterTextView");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.TypeWriterTextView");
            }
        }
        return super.doTask();
    }
}
