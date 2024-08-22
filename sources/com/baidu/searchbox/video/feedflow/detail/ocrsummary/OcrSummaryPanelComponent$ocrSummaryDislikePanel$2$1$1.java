package com.baidu.searchbox.video.feedflow.detail.ocrsummary;

import com.baidu.searchbox.player.widget.VideoDislikeReasonPanel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/ocrsummary/OcrSummaryPanelComponent$ocrSummaryDislikePanel$2$1$1", "Lcom/baidu/searchbox/player/widget/VideoDislikeReasonPanel$OnDislikePanelClickListener;", "onItemClick", "", "reason", "", "position", "", "onPanelDismiss", "type", "Lcom/baidu/searchbox/player/widget/VideoDislikeReasonPanel$DismissType;", "onPanelShow", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OcrSummaryPanelComponent.kt */
public final class OcrSummaryPanelComponent$ocrSummaryDislikePanel$2$1$1 implements VideoDislikeReasonPanel.OnDislikePanelClickListener {
    final /* synthetic */ OcrSummaryPanelComponent this$0;

    OcrSummaryPanelComponent$ocrSummaryDislikePanel$2$1$1(OcrSummaryPanelComponent $receiver) {
        this.this$0 = $receiver;
    }

    public void onItemClick(String reason, int position) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.this$0.onDislikeReasonClick(reason, position);
    }

    public void onPanelShow() {
        this.this$0.onDislikePanelShow();
    }

    public void onPanelDismiss(VideoDislikeReasonPanel.DismissType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.this$0.onDislikePanelHide(type);
    }
}
