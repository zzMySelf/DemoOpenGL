package com.baidu.searchbox.video.feedflow.detail.ocrsummary;

import com.baidu.searchbox.video.feedflow.detail.ocrsummary.view.OcrSummaryPlayControlListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/ocrsummary/OcrSummaryPanelView$initPlayControlView$1$2", "Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/view/OcrSummaryPlayControlListener;", "getPlaySpeed", "", "isAdvanceAgeMode", "", "isMute", "isPlaying", "onMuteButtonClick", "", "curStatus", "onPlayButtonClick", "onSpeedButtonClick", "speed", "onVisibleChange", "visible", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OcrSummaryPanelView.kt */
public final class OcrSummaryPanelView$initPlayControlView$1$2 implements OcrSummaryPlayControlListener {
    final /* synthetic */ OcrSummaryPanelView this$0;

    OcrSummaryPanelView$initPlayControlView$1$2(OcrSummaryPanelView $receiver) {
        this.this$0 = $receiver;
    }

    public boolean isPlaying() {
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            return ocrSummaryListener.isPlaying();
        }
        return false;
    }

    public void onPlayButtonClick() {
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.onPlayButtonClick();
        }
    }

    public void onSpeedButtonClick(float speed) {
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.onSpeedButtonClick(speed);
        }
    }

    public float getPlaySpeed() {
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            return ocrSummaryListener.getPlaySpeed();
        }
        return 1.0f;
    }

    public boolean isAdvanceAgeMode() {
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        return ocrSummaryListener != null && ocrSummaryListener.isAdvanceAgeMode();
    }

    public boolean isMute() {
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        return ocrSummaryListener != null && ocrSummaryListener.isMute();
    }

    public void onMuteButtonClick(boolean curStatus) {
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.onMuteButtonClick(curStatus);
        }
    }

    public void onVisibleChange(boolean visible) {
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.onVisibleChange(visible);
        }
    }
}
