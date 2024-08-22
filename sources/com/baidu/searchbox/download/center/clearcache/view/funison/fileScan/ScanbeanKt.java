package com.baidu.searchbox.download.center.clearcache.view.funison.fileScan;

import java.text.SimpleDateFormat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"dateFormat", "Ljava/text/SimpleDateFormat;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "dateFormat$delegate", "Lkotlin/Lazy;", "lib-clearcache-business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scanbean.kt */
public final class ScanbeanKt {
    private static final Lazy dateFormat$delegate = LazyKt.lazy(ScanbeanKt$dateFormat$2.INSTANCE);

    /* access modifiers changed from: private */
    public static final SimpleDateFormat getDateFormat() {
        return (SimpleDateFormat) dateFormat$delegate.getValue();
    }
}
