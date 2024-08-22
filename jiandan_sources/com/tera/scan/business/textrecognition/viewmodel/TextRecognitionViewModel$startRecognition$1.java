package com.tera.scan.business.textrecognition.viewmodel;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionViewModel$startRecognition$1 extends Lambda implements Function1<List<? extends String>, Unit> {
    public final /* synthetic */ TextRecognitionViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionViewModel$startRecognition$1(TextRecognitionViewModel textRecognitionViewModel) {
        super(1);
        this.this$0 = textRecognitionViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<String>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        this.this$0.qw.removeCallbacksAndMessages((Object) null);
        this.this$0.getOrcResultLiveData().postValue(list);
    }
}
