package com.tera.scan.business.textrecognition;

import fe.mmm.qw.p030switch.th.de.ad.qw;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivity$maxTopMarginOffset$2 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ TextRecognitionResultActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultActivity$maxTopMarginOffset$2(TextRecognitionResultActivity textRecognitionResultActivity) {
        super(0);
        this.this$0 = textRecognitionResultActivity;
    }

    @NotNull
    public final Integer invoke() {
        return Integer.valueOf((qw.fe() / 2) - qw.qw(this.this$0, 200.0f));
    }
}
