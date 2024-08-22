package fe.fe.ddd.mmm.qw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.sapi2.SapiAccountService;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.OnFragmentTraceListener;
import fe.fe.ddd.rg.ad;
import fe.fe.ddd.rg.qw;
import java.util.Iterator;

public class yj {

    /* renamed from: fe  reason: collision with root package name */
    public static volatile yj f1506fe;

    /* renamed from: ad  reason: collision with root package name */
    public OnFragmentTraceListener f1507ad;

    /* renamed from: de  reason: collision with root package name */
    public de f1508de;
    public volatile boolean qw = false;

    public static boolean qw(Activity activity) {
        return activity.getClass().getName().startsWith("com.baidu.megapp.proxy.activity");
    }

    public static yj rg() {
        if (f1506fe == null) {
            synchronized (yj.class) {
                if (f1506fe == null) {
                    f1506fe = new yj();
                }
            }
        }
        return f1506fe;
    }

    public final uk ad(@NonNull Activity activity, @Nullable String str, @Nullable Object obj, @NonNull String str2) {
        return de(activity, str, obj, (String) null, (String) null, SapiAccountService.DISPLAY_TYPE_NATIVE, str2);
    }

    public final uk de(@NonNull Activity activity, @Nullable String str, @Nullable Object obj, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NonNull String str5) {
        String str6;
        StringBuilder sb;
        String simpleName;
        Intent intent;
        Object obj2 = obj;
        String str7 = null;
        if (activity == null || TextUtils.isEmpty(str5)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String name = activity.getClass().getName();
        StringBuilder sb2 = new StringBuilder("@" + Integer.toHexString(hashCode()));
        String fe2 = fe(activity);
        if (!TextUtils.isEmpty(fe2)) {
            sb2.append("[token:");
            sb2.append(fe2);
            sb2.append("]");
            sb2.toString();
        }
        if (AppConfig.fe() && (simpleName = activity.getClass().getSimpleName()) != null && simpleName.equals("BdBoxSchemeDispatchActivity") && (intent = activity.getIntent()) != null) {
            sb2.append("[intent:");
            sb2.append(intent.toString());
            sb2.append("]");
        }
        if (!TextUtils.isEmpty(str)) {
            sb2.append("[");
            sb2.append(str);
            sb2.append("]");
        }
        if (obj2 != null) {
            String name2 = obj.getClass().getName();
            StringBuilder sb3 = new StringBuilder("@" + Integer.toHexString(obj.hashCode()));
            OnFragmentTraceListener onFragmentTraceListener = this.f1507ad;
            if (onFragmentTraceListener != null) {
                String qw2 = onFragmentTraceListener.qw(obj2);
                if (!TextUtils.isEmpty(qw2)) {
                    sb3.append(",extra=");
                    sb3.append(qw2);
                }
            }
            sb = sb3;
            str6 = name2;
        } else {
            sb = null;
            str6 = null;
        }
        String sb4 = sb2.toString();
        if (sb != null) {
            str7 = sb.toString();
        }
        return new uk(name, sb4, str6, str7, str2, str3, str4, currentTimeMillis, str5);
    }

    public String fe(Activity activity) {
        WindowManager.LayoutParams attributes;
        IBinder iBinder;
        if (activity == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT <= 26) {
            try {
                Object invoke = Activity.class.getDeclaredMethod("getActivityToken", new Class[0]).invoke(activity, new Object[0]);
                if (invoke != null) {
                    return invoke.toString();
                }
            } catch (Throwable th2) {
                if (AppConfig.rg()) {
                    th2.printStackTrace();
                }
            }
        }
        Window window = activity.getWindow();
        if (window == null || (attributes = window.getAttributes()) == null || (iBinder = attributes.token) == null) {
            return null;
        }
        return iBinder.toString();
    }

    public void i(@NonNull Activity activity, boolean z) {
        if (this.qw) {
            uk ad2 = ad(activity, (String) null, (Object) null, z ? "To foreground" : "To background");
            if (ad2 != null) {
                Track.fe().qw(ad2);
                Iterator it = Track.fe().th().iterator();
                while (it.hasNext()) {
                    ((Track.OnTrackUIListener) it.next()).qw(ad2);
                }
            }
        }
    }

    public boolean th() {
        return this.qw;
    }

    public void uk(Activity activity, String str, Object obj, String str2) {
        uk ad2;
        if (this.qw && (ad2 = ad(activity, str, obj, str2)) != null) {
            Track.fe().qw(ad2);
            Iterator it = Track.fe().th().iterator();
            while (it.hasNext()) {
                ((Track.OnTrackUIListener) it.next()).qw(ad2);
            }
        }
    }

    public void yj(Context context) {
        if (!this.qw && context != null) {
            if (qw.qw() == null) {
                qw.rg(ad.th());
            }
            de deVar = new de();
            this.f1508de = deVar;
            qw.fe(deVar);
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (!activity.isFinishing()) {
                    this.qw = true;
                    de deVar2 = this.f1508de;
                    if (deVar2 != null) {
                        deVar2.qw(activity);
                    }
                    uk(activity, (String) null, (Object) null, "register");
                    return;
                }
                return;
            }
            this.qw = true;
        }
    }
}
