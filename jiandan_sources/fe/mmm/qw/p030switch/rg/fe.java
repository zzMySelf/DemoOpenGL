package fe.mmm.qw.p030switch.rg;

import kotlin.text.StringsKt__StringsJVMKt;

/* renamed from: fe.mmm.qw.switch.rg.fe  reason: invalid package */
public final class fe {
    public static final boolean qw() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return StringsKt__StringsJVMKt.equals("Harmony", cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString(), true);
        } catch (Throwable unused) {
            return false;
        }
    }
}
