package com.tera.scan.business.textrecognition;

import com.mars.kotlin.extension.LoggerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultActivityFlavor$copyToClipboard$1$1 extends Lambda implements Function1<Boolean, Unit> {
    public static final TextRecognitionResultActivityFlavor$copyToClipboard$1$1 INSTANCE = new TextRecognitionResultActivityFlavor$copyToClipboard$1$1();

    public TextRecognitionResultActivityFlavor$copyToClipboard$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        LoggerKt.d$default("权益消费 " + z, (Object) null, 1, (Object) null);
    }
}
