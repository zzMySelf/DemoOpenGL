package com.baidu.mms.voicesearch.voice.view.guide;

import com.baidu.mms.voicesearch.voice.view.guide.AssistantGuideItemView;
import com.baidu.voicesearch.component.utils.NormalTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/mms/voicesearch/voice/view/guide/AssistantGuideItemView$realChangeAssistant$1", "Lcom/baidu/voicesearch/component/utils/NormalTask;", "doTask", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssistantGuideItemView.kt */
public final class AssistantGuideItemView$realChangeAssistant$1 extends NormalTask {
    final /* synthetic */ AssistantGuideItemView this$0;

    AssistantGuideItemView$realChangeAssistant$1(AssistantGuideItemView $receiver) {
        this.this$0 = $receiver;
    }

    public boolean doTask() {
        AssistantGuideItemView.AssistantCheckedCallBack access$getItemCheckedCallBack$p = this.this$0.itemCheckedCallBack;
        if (access$getItemCheckedCallBack$p != null) {
            access$getItemCheckedCallBack$p.onItemDownloadSuccess(this.this$0.dataBean);
        }
        return super.doTask();
    }
}
