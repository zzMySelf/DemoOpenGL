package com.baidu.mms.voicesearch.voice.view.guideresource;

import com.baidu.voicesearch.component.utils.NormalTask;
import com.baidu.voicesearch.component.utils.TaskDispatcher;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/mms/voicesearch/voice/view/guideresource/GuideResourceView$updateHistoryData$1", "Lcom/baidu/voicesearch/component/utils/NormalTask;", "doTask", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GuideResourceView.kt */
public final class GuideResourceView$updateHistoryData$1 extends NormalTask {
    final /* synthetic */ GuideResourceView this$0;

    GuideResourceView$updateHistoryData$1(GuideResourceView $receiver) {
        this.this$0 = $receiver;
    }

    public boolean doTask() {
        try {
            GuideResourceView guideResourceView = this.this$0;
            guideResourceView.canShowHis = guideResourceView.canShowHistory();
            int size = this.this$0.guideResourceList.size();
            for (int i2 = 0; i2 < size; i2++) {
                GuideResourceDataBean guideResourceDataBean = (GuideResourceDataBean) this.this$0.guideResourceList.get(i2);
                if ((guideResourceDataBean != null ? guideResourceDataBean.getHistoryItem() : null) != null) {
                    GuideResourceDataBean guideResourceDataBean2 = (GuideResourceDataBean) this.this$0.guideResourceList.get(i2);
                    if (guideResourceDataBean2 != null) {
                        guideResourceDataBean2.setCanDisplay(this.this$0.canShowHis);
                    }
                }
            }
        } catch (Exception e2) {
        }
        TaskDispatcher.getSharedInstance().addToMainLooper(new GuideResourceView$updateHistoryData$1$doTask$1(this.this$0));
        return super.doTask();
    }
}
