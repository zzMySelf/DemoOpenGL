package com.tera.scan.business.textrecognition.viewmodel;

import fe.mmm.qw.th.qw.th.p031switch.ad;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "success", "", "freeCount", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TextRecognitionResultViewModel$consumeOncePrivilege$1 extends Lambda implements Function2<Boolean, Integer, Unit> {
    public final /* synthetic */ Function1<Boolean, Unit> $onResult;
    public final /* synthetic */ TextRecognitionResultViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextRecognitionResultViewModel$consumeOncePrivilege$1(Function1<? super Boolean, Unit> function1, TextRecognitionResultViewModel textRecognitionResultViewModel) {
        super(2);
        this.$onResult = function1;
        this.this$0 = textRecognitionResultViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, int i2) {
        Function1<Boolean, Unit> function1 = this.$onResult;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        if (z) {
            ad.de(this.this$0.f6826de, Integer.valueOf(RangesKt___RangesKt.coerceAtLeast(0, i2)));
        }
    }
}
