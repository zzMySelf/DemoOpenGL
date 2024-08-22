package com.baidu.searchbox.video.feedflow.detail.ocrsummary;

import android.util.AttributeSet;
import com.baidu.searchbox.video.feedflow.component.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/OcrSummaryView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OcrSummaryComponent.kt */
final class OcrSummaryComponent$ocrSummaryView$2 extends Lambda implements Function0<OcrSummaryView> {
    final /* synthetic */ OcrSummaryComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OcrSummaryComponent$ocrSummaryView$2(OcrSummaryComponent ocrSummaryComponent) {
        super(0);
        this.this$0 = ocrSummaryComponent;
    }

    public final OcrSummaryView invoke() {
        OcrSummaryView ocrSummaryView = new OcrSummaryView(this.this$0.getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        OcrSummaryComponent ocrSummaryComponent = this.this$0;
        OcrSummaryView $this$invoke_u24lambda_u2d0 = ocrSummaryView;
        $this$invoke_u24lambda_u2d0.setPadding(0, $this$invoke_u24lambda_u2d0.getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_13dp), 0, 0);
        $this$invoke_u24lambda_u2d0.setOcrSummaryClickListener(new OcrSummaryComponent$ocrSummaryView$2$1$1(ocrSummaryComponent, $this$invoke_u24lambda_u2d0));
        $this$invoke_u24lambda_u2d0.setFoldWidthListener(new OcrSummaryComponent$ocrSummaryView$2$1$2(ocrSummaryComponent));
        $this$invoke_u24lambda_u2d0.setVisibility(8);
        return ocrSummaryView;
    }
}
