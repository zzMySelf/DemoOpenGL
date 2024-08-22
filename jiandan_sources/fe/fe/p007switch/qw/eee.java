package fe.fe.p007switch.qw;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import fe.fe.p007switch.qw.mmm.qw;

/* renamed from: fe.fe.switch.qw.eee  reason: invalid package */
public final class eee {
    public static boolean ad(Class<?> cls, String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String methodName = stackTraceElement.getMethodName();
            if (!TextUtils.isEmpty(methodName) && cls != null && methodName.equals(str)) {
                Class<?> cls2 = null;
                try {
                    cls2 = Class.forName(stackTraceElement.getClassName());
                } catch (Throwable unused) {
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String qw(Context context) {
        String str;
        try {
            str = CommonParam.getCUID(context);
        } catch (Throwable unused) {
            str = "";
        }
        return TextUtils.isEmpty(str) ? qw.qw(context) : str;
    }
}
