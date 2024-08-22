package fe.fe.ddd.rrr;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;
import com.baidu.searchbox.widget.OnTranslucentListener;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ad {
    public static void ad(Activity activity, OnTranslucentListener onTranslucentListener) {
        try {
            Class cls = null;
            for (Class cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[]{null});
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(true);
            }
        } catch (Throwable unused) {
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
            }
        }
    }

    public static void de(Activity activity, OnTranslucentListener onTranslucentListener) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, new Object[0]);
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
            }
        } catch (Throwable th2) {
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(true);
            }
            th2.printStackTrace();
        }
    }

    public static void fe(Activity activity, OnTranslucentListener onTranslucentListener) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                qw(activity, onTranslucentListener);
            } else {
                ad(activity, onTranslucentListener);
            }
        } catch (Throwable unused) {
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
            }
        }
    }

    public static void qw(Activity activity, OnTranslucentListener onTranslucentListener) {
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class cls = null;
            for (Class cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Object newProxyInstance = Proxy.newProxyInstance(Activity.class.getClassLoader(), new Class[]{cls}, new de(onTranslucentListener));
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, new Object[]{newProxyInstance, invoke});
        } catch (Throwable unused) {
            if (onTranslucentListener != null) {
                onTranslucentListener.onTranslucent(false);
            }
        }
    }
}
