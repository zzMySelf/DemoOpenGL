package fe.mmm.qw.m.xxx;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class qw {
    @TargetApi(23)
    public static void ad(Window window, boolean z) {
        if (rg()) {
            pf(window, z);
        } else if (th()) {
            m983if(window, z);
        }
        de(window, z);
    }

    @RequiresApi(23)
    public static void de(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            window.getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        }
    }

    public static int fe(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", ResUtils.f719i, SapiDeviceInfo.OS_TYPE));
    }

    public static void i(@NonNull Activity activity) {
        ad(((Activity) new WeakReference(activity).get()).getWindow(), true);
    }

    /* renamed from: if  reason: not valid java name */
    public static void m983if(Window window, boolean z) {
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", new Class[]{Integer.TYPE, Integer.TYPE});
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i2 : 0);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window, objArr);
        } catch (Exception unused) {
        }
    }

    public static void o(@NonNull Activity activity) {
        ad(((Activity) new WeakReference(activity).get()).getWindow(), false);
    }

    public static void pf(Window window, boolean z) {
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt((Object) null);
            int i3 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i3 | i2 : (~i2) & i3);
            window.setAttributes(attributes);
        } catch (Exception unused) {
        }
    }

    public static int qw(@ColorInt int i2, int i3) {
        if (i3 == 0) {
            return i2;
        }
        float f = 1.0f - (((float) i3) / 255.0f);
        return ((int) (((double) (((float) (i2 & 255)) * f)) + 0.5d)) | (((int) (((double) (((float) ((i2 >> 16) & 255)) * f)) + 0.5d)) << 16) | -16777216 | (((int) (((double) (((float) ((i2 >> 8) & 255)) * f)) + 0.5d)) << 8);
    }

    public static boolean rg() {
        return Build.FINGERPRINT.contains("Flyme_OS_4") || Build.VERSION.INCREMENTAL.contains("Flyme_OS_4") || Pattern.compile("Flyme OS [4|5]", 2).matcher(Build.DISPLAY).find();
    }

    /* renamed from: switch  reason: not valid java name */
    public static void m984switch(Activity activity, boolean z) {
        ViewGroup viewGroup = (ViewGroup) ((Activity) new WeakReference(activity).get()).findViewById(16908290);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(z);
                ((ViewGroup) childAt).setClipToPadding(z);
            }
        }
    }

    public static boolean th() {
        try {
            if (Integer.parseInt(((String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{"ro.miui.ui.version.name"})).replaceAll("[vV]", "")) >= 6) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void uk(@NonNull Activity activity, @ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        WeakReference weakReference = new WeakReference(activity);
        Window window = ((Activity) weakReference.get()).getWindow();
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(qw(i2, i3));
        } else if (i4 >= 19) {
            window.addFlags(67108864);
            when((ViewGroup) window.getDecorView(), i2, i3);
            m984switch((Activity) weakReference.get(), true);
        }
    }

    public static void when(ViewGroup viewGroup, @ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            int qw = qw(i2, i3);
            View findViewById = viewGroup.findViewById(16908331);
            if (findViewById == null && qw != 0) {
                findViewById = new View(viewGroup.getContext());
                findViewById.setId(16908331);
                viewGroup.addView(findViewById, new ViewGroup.LayoutParams(-1, fe(viewGroup.getContext())));
            }
            if (findViewById != null) {
                findViewById.setBackgroundColor(qw);
            }
        }
    }

    public static void yj(@NonNull Activity activity, @ColorInt int i2) {
        uk((Activity) new WeakReference(activity).get(), i2, 0);
    }
}
