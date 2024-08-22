package com.xiaomi.push;

import android.app.AppOpsManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.vivo.push.PushClientConstants;
import java.util.Map;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static a f7024a = null;

    public interface a {
        Map<String, String> a(Context context, String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m8540a(Context context, String str);

        boolean b(Context context, String str);
    }

    public enum b {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        

        /* renamed from: a  reason: collision with other field name */
        private final int f410a;

        private b(int i2) {
            this.f410a = i2;
        }

        public int a() {
            return this.f410a;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m8534a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e2) {
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e2) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(PushClientConstants.COM_ANDROID_SYSTEMUI, 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return 0;
            }
            return applicationInfo.metaData.getInt("SupportForPushVersionCode");
        } catch (PackageManager.NameNotFoundException e2) {
            return 0;
        }
    }

    public static b a(Context context, String str, boolean z) {
        ApplicationInfo applicationInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            return b.UNKNOWN;
        }
        try {
            if (str.equals(context.getPackageName())) {
                applicationInfo = context.getApplicationInfo();
            } else {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            }
            b a2 = a(context, applicationInfo);
            if (a2 != b.UNKNOWN) {
                return a2;
            }
            Integer num = (Integer) bj.a((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
            if (num == null) {
                return b.UNKNOWN;
            }
            Integer num2 = (Integer) bj.a((Object) (AppOpsManager) context.getSystemService("appops"), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
            int i2 = (Integer) bj.a((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
            int i3 = (Integer) bj.a((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
            com.xiaomi.channel.commonutils.logger.b.b(String.format("get app mode %s|%s|%s", new Object[]{num2, i2, i3}));
            if (i2 == null) {
                i2 = 0;
            }
            if (i3 == null) {
                i3 = 1;
            }
            if (num2 != null) {
                return z ? !num2.equals(i3) ? b.ALLOWED : b.NOT_ALLOWED : num2.equals(i2) ? b.ALLOWED : b.NOT_ALLOWED;
            }
            return b.UNKNOWN;
        } catch (Throwable th2) {
            com.xiaomi.channel.commonutils.logger.b.a("get app op error " + th2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.xiaomi.push.g.b a(android.content.Context r5, android.content.pm.ApplicationInfo r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r6 == 0) goto L_0x0086
            r1 = 24
            if (r0 >= r1) goto L_0x000a
            goto L_0x0086
        L_0x000a:
            r1 = 0
            java.lang.String r2 = r6.packageName     // Catch:{ Exception -> 0x006c }
            java.lang.String r3 = r5.getPackageName()     // Catch:{ Exception -> 0x006c }
            boolean r2 = r2.equals(r3)     // Catch:{ Exception -> 0x006c }
            java.lang.String r3 = "notification"
            if (r2 == 0) goto L_0x0029
            java.lang.Object r5 = r5.getSystemService(r3)     // Catch:{ Exception -> 0x006c }
            android.app.NotificationManager r5 = (android.app.NotificationManager) r5     // Catch:{ Exception -> 0x006c }
            boolean r5 = r5.areNotificationsEnabled()     // Catch:{ Exception -> 0x006c }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r5)     // Catch:{ Exception -> 0x006c }
            goto L_0x005d
        L_0x0029:
            r2 = 29
            r4 = 0
            if (r0 < r2) goto L_0x003b
            java.lang.Object r5 = r5.getSystemService(r3)     // Catch:{ Exception -> 0x006c }
            java.lang.String r0 = "getService"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x006c }
            java.lang.Object r5 = com.xiaomi.push.bj.a((java.lang.Object) r5, (java.lang.String) r0, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x006c }
            goto L_0x0042
        L_0x003b:
            java.lang.String r0 = "security"
            java.lang.Object r5 = r5.getSystemService(r0)     // Catch:{ Exception -> 0x006c }
        L_0x0042:
            if (r5 == 0) goto L_0x005d
            java.lang.String r0 = "areNotificationsEnabledForPackage"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x006c }
            java.lang.String r2 = r6.packageName     // Catch:{ Exception -> 0x006c }
            r1[r4] = r2     // Catch:{ Exception -> 0x006c }
            r2 = 1
            int r6 = r6.uid     // Catch:{ Exception -> 0x006c }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x006c }
            r1[r2] = r6     // Catch:{ Exception -> 0x006c }
            java.lang.Object r5 = com.xiaomi.push.bj.b((java.lang.Object) r5, (java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x006c }
            r1 = r5
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x006c }
        L_0x005d:
            if (r1 == 0) goto L_0x006b
            boolean r5 = r1.booleanValue()     // Catch:{ Exception -> 0x006c }
            if (r5 == 0) goto L_0x0068
            com.xiaomi.push.g$b r5 = com.xiaomi.push.g.b.ALLOWED     // Catch:{ Exception -> 0x006c }
            goto L_0x006a
        L_0x0068:
            com.xiaomi.push.g$b r5 = com.xiaomi.push.g.b.NOT_ALLOWED     // Catch:{ Exception -> 0x006c }
        L_0x006a:
            return r5
        L_0x006b:
            goto L_0x0083
        L_0x006c:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "are notifications enabled error "
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.String r5 = r5.toString()
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r5)
        L_0x0083:
            com.xiaomi.push.g$b r5 = com.xiaomi.push.g.b.UNKNOWN
            return r5
        L_0x0086:
            com.xiaomi.push.g$b r5 = com.xiaomi.push.g.b.UNKNOWN
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.g.a(android.content.Context, android.content.pm.ApplicationInfo):com.xiaomi.push.g$b");
    }

    public static void a(Context context, ApplicationInfo applicationInfo, boolean z) {
        Object obj;
        int i2 = Build.VERSION.SDK_INT;
        if (b.ALLOWED != a(context, applicationInfo)) {
            if (i2 >= 29) {
                try {
                    obj = bj.a(context.getSystemService("notification"), "getService", new Object[0]);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a("set notifications enabled error " + e2);
                    return;
                }
            } else {
                obj = context.getSystemService("security");
            }
            if (obj != null) {
                bj.b(obj, "setNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid), Boolean.valueOf(z));
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8537a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!j.a()) {
            return context.getPackageName().equals(str);
        }
        a aVar = f7024a;
        if (aVar == null || aVar.a(context, str) == null) {
            return false;
        }
        return true;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m8539b(Context context, String str) {
        a aVar = f7024a;
        return aVar != null && aVar.b(context, str);
    }

    public static boolean c(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m8536a(Context context) {
        String a2 = a();
        if (TextUtils.isEmpty(a2) || context == null) {
            return false;
        }
        return a2.equals(context.getPackageName());
    }

    public static String a() {
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            str = Application.getProcessName();
        } else {
            str = (String) bj.a("android.app.ActivityThread", "currentProcessName", new Object[0]);
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return "";
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m8538b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
                return str;
            }
            return packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException e2) {
            return str;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static ApplicationInfo m8532a(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            com.xiaomi.channel.commonutils.logger.b.a("not found app info " + str);
            return null;
        }
    }

    public static int b(Context context, String str) {
        ApplicationInfo a2 = a(context, str);
        if (a2 == null) {
            return 0;
        }
        int i2 = a2.icon;
        if (i2 == 0) {
            return a2.logo;
        }
        return i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Drawable m8533a(Context context, String str) {
        ApplicationInfo a2 = a(context, str);
        Drawable drawable = null;
        if (a2 != null) {
            try {
                drawable = a2.loadIcon(context.getPackageManager());
                if (drawable == null) {
                    drawable = a2.loadLogo(context.getPackageManager());
                }
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a("get app icon drawable failed, " + e2);
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    public static boolean d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception e2) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static Map<String, String> m8535a(Context context, String str) {
        a aVar = f7024a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(context, str);
    }
}
