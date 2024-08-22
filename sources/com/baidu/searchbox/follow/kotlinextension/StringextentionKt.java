package com.baidu.searchbox.follow.kotlinextension;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"convertStringToIntSafe", "", "", "string", "defInt", "lib-follow-interface_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stringextention.kt */
public final class StringextentionKt {
    public static final int convertStringToIntSafe(String $this$convertStringToIntSafe, String string, int defInt) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (TextUtils.isEmpty(string)) {
            return defInt;
        }
        int ret = defInt;
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return ret;
        }
    }
}
