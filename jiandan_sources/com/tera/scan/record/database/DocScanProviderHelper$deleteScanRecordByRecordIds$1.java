package com.tera.scan.record.database;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DocScanProviderHelper$deleteScanRecordByRecordIds$1 extends Lambda implements Function1<String, CharSequence> {
    public static final DocScanProviderHelper$deleteScanRecordByRecordIds$1 INSTANCE = new DocScanProviderHelper$deleteScanRecordByRecordIds$1();

    public DocScanProviderHelper$deleteScanRecordByRecordIds$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return ExtendedMessageFormat.QUOTE + str + ExtendedMessageFormat.QUOTE;
    }
}
