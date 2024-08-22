package com.baidu.searchbox.kmm.crypto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"toBase64", "", "com.baidu.searchbox.kmm.foundation.crypto"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Base64.kt */
public final class Base64Kt {
    public static final String toBase64(String $this$toBase64) {
        Intrinsics.checkNotNullParameter($this$toBase64, "<this>");
        String base64encode = Base64.base64encode(StringsKt.encodeToByteArray($this$toBase64));
        return base64encode == null ? "" : base64encode;
    }
}
