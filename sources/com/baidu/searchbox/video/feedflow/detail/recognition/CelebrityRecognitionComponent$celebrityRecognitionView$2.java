package com.baidu.searchbox.video.feedflow.detail.recognition;

import android.util.AttributeSet;
import com.baidu.searchbox.video.feedflow.detail.recognition.CelebrityRecognitionComponent;
import com.baidu.searchbox.video.feedflow.detail.recognition.view.CelebrityRecognitionView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/recognition/view/CelebrityRecognitionView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CelebrityRecognitionComponent.kt */
final class CelebrityRecognitionComponent$celebrityRecognitionView$2 extends Lambda implements Function0<CelebrityRecognitionView> {
    final /* synthetic */ CelebrityRecognitionComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CelebrityRecognitionComponent$celebrityRecognitionView$2(CelebrityRecognitionComponent celebrityRecognitionComponent) {
        super(0);
        this.this$0 = celebrityRecognitionComponent;
    }

    public final CelebrityRecognitionView invoke() {
        CelebrityRecognitionView $this$invoke_u24lambda_u2d0 = new CelebrityRecognitionView(this.this$0.getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$invoke_u24lambda_u2d0.setCelebrityRecognitionViewListener(new CelebrityRecognitionComponent.CelebrityRecognitionClickListener());
        return $this$invoke_u24lambda_u2d0;
    }
}
