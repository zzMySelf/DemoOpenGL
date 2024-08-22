package com.baidu.searchbox.download.center.ui.doc.transcode;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "freeNum", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TranscodeFreeNumManager.kt */
final class TranscodeFreeNumManager$reducePdfToWordFreeNumAsync$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Function1<Integer, Unit> $freeNumCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TranscodeFreeNumManager$reducePdfToWordFreeNumAsync$1(Function1<? super Integer, Unit> function1) {
        super(1);
        this.$freeNumCallback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Number) p1).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int freeNum) {
        TranscodeFreeNumManager transcodeFreeNumManager = TranscodeFreeNumManager.INSTANCE;
        TranscodeFreeNumManager.pdfToWordFreeNum = freeNum;
        this.$freeNumCallback.invoke(Integer.valueOf(TranscodeFreeNumManager.INSTANCE.getPdfToWordFreeNum()));
    }
}
