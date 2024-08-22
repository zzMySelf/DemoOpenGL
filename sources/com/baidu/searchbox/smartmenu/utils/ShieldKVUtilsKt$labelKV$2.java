package com.baidu.searchbox.smartmenu.utils;

import com.baidu.android.util.UniKV;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/android/util/UniKV;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShieldKVUtils.kt */
final class ShieldKVUtilsKt$labelKV$2 extends Lambda implements Function0<UniKV> {
    public static final ShieldKVUtilsKt$labelKV$2 INSTANCE = new ShieldKVUtilsKt$labelKV$2();

    ShieldKVUtilsKt$labelKV$2() {
        super(0);
    }

    public final UniKV invoke() {
        return new UniKV(ShieldKVUtilsKt.SMART_MENU_SHIELD_LABEL);
    }
}
