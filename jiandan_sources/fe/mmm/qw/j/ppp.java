package fe.mmm.qw.j;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.multidex.MultiDexExtractor;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

public final class ppp {
    public static final boolean ad(Activity activity) {
        Object obj = null;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(activity, new Object[0]);
            Class[] declaredClasses = Activity.class.getDeclaredClasses();
            Intrinsics.checkNotNullExpressionValue(declaredClasses, MultiDexExtractor.DEX_PREFIX);
            Class cls = null;
            for (Class cls2 : declaredClasses) {
                String simpleName = cls2.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "clazz.simpleName");
                if (StringsKt__StringsKt.contains$default((CharSequence) simpleName, (CharSequence) "TranslucentConversionListener", false, 2, (Object) null)) {
                    cls = cls2;
                }
            }
            if (cls != null) {
                Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
                declaredMethod2.setAccessible(true);
                obj = declaredMethod2.invoke(activity, new Object[]{null, invoke});
            }
            return obj != null;
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
            return false;
        }
    }

    public static final boolean de(Activity activity) {
        Object obj = null;
        try {
            Class[] declaredClasses = Activity.class.getDeclaredClasses();
            Intrinsics.checkNotNullExpressionValue(declaredClasses, MultiDexExtractor.DEX_PREFIX);
            Class cls = null;
            for (Class cls2 : declaredClasses) {
                String simpleName = cls2.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "clazz.simpleName");
                if (StringsKt__StringsKt.contains$default((CharSequence) simpleName, (CharSequence) "TranslucentConversionListener", false, 2, (Object) null)) {
                    cls = cls2;
                }
            }
            if (cls != null) {
                Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
                declaredMethod.setAccessible(true);
                obj = declaredMethod.invoke(activity, new Object[]{null});
            }
            return obj != null;
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
            return false;
        }
    }

    public static final boolean qw(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (Build.VERSION.SDK_INT >= 21) {
            return ad(activity);
        }
        return de(activity);
    }
}
