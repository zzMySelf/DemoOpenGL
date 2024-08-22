package com.tera.scan.business.textrecognition;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivity$onAiTranslateClick$1 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ String $content;
    public final /* synthetic */ TextRecognitionResultActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultActivity$onAiTranslateClick$1(TextRecognitionResultActivity textRecognitionResultActivity, String str) {
        super(1);
        this.this$0 = textRecognitionResultActivity;
        this.$content = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            this.this$0.startAiTranslate(this.$content);
        }
        TextRecognitionResultActivityFlavor.ppp(this.this$0);
    }
}
