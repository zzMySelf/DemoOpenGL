package com.tera.scan.business.textrecognition.dialog;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NoTextDetectDialog$show$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function0<Unit> $onConfirmChange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoTextDetectDialog$show$2(Function0<Unit> function0) {
        super(0);
        this.$onConfirmChange = function0;
    }

    public final void invoke() {
        Function0<Unit> function0 = this.$onConfirmChange;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
