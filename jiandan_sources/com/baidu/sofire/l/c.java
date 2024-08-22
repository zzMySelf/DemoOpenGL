package com.baidu.sofire.l;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ProviderInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.apollon.restnet.rest.g;
import com.baidu.sofire.MyProvider;
import com.baidu.sofire.MyReceiver;
import com.baidu.sofire.MyService;
import com.baidu.sofire.a.a;
import com.baidu.sofire.ac.F;
import com.baidu.sofire.b.j;
import com.baidu.sofire.core.ApkInfo;
import com.baidu.sofire.i.b;
import com.baidu.sofire.rp.Report;
import com.baidu.sofire.rp.receiver.Receiver;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.paysdk.datamodel.Bank;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.cmic.sso.sdk.e.i;
import com.dlife.ctaccountapi.t;
import com.dlife.ctaccountapi.v;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    public static File a = null;
    public static boolean b = false;
    public static String c = null;
    public static String d = null;
    public static int e = 0;
    public static int f = -1;
    public static MyReceiver g = null;
    public static String h = "";

    /* renamed from: i  reason: collision with root package name */
    public static String f1091i = "";
    public static String j = "";
    public static String k = "";
    public static int l = -1;
    public static int m = -1;
    public static int n = -1;

    /* renamed from: o  reason: collision with root package name */
    public static HashMap<Integer, ApkInfo> f1092o;

    public static void a(Throwable th2) {
        int i2 = a.a;
    }

    public static boolean b(int i2) {
        try {
            j jVar = j.g;
            if (jVar == null || jVar.a(i2) == null) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            int i3 = a.a;
            return false;
        }
    }

    public static String[] c(Context context) {
        if (TextUtils.isEmpty(c) || TextUtils.isEmpty(d)) {
            String string = com.baidu.sofire.j.a.a(context).a.getString("svi_n", "");
            if (TextUtils.isEmpty(string)) {
                return new String[0];
            }
            String[] split = string.split("-");
            if (split == null || split.length != 2) {
                return new String[0];
            }
            c = split[0];
            d = split[1];
            return split;
        }
        return new String[]{c, d};
    }

    public static int d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED)) {
                if (activeNetworkInfo.getType() == 1) {
                    return 4;
                }
                if (activeNetworkInfo.getType() != 0) {
                    return -2;
                }
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                    case 4:
                        return 1;
                    case 5:
                    case 6:
                        return 2;
                    case 7:
                        return 1;
                    case 8:
                    case 9:
                    case 10:
                        return 2;
                    case 11:
                        return 1;
                    case 12:
                        return 2;
                    case 13:
                        return 3;
                    case 14:
                    case 15:
                        return 2;
                    default:
                        return 5;
                }
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
        return -1;
    }

    public static String e(Context context) {
        int length;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(e.a(context));
            sb.append(":");
            String hexString = Long.toHexString(System.currentTimeMillis() / 1000);
            if (!TextUtils.isEmpty(hexString)) {
                int length2 = 8 - hexString.length();
                if (length2 > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    while (length2 > 0) {
                        sb2.append("0");
                        length2--;
                    }
                    hexString = sb2.toString() + hexString;
                }
            }
            String hexString2 = Long.toHexString(Long.valueOf(p(context)[0]).longValue());
            if (!TextUtils.isEmpty(hexString2) && (length = 16 - hexString2.length()) > 0) {
                StringBuilder sb3 = new StringBuilder();
                for (length = 16 - hexString2.length(); length > 0; length--) {
                    sb3.append("0");
                }
                hexString2 = sb3.toString() + hexString2;
            }
            sb.append(hexString);
            sb.append(hexString2);
            return sb.toString();
        } catch (Throwable unused) {
            int i2 = a.a;
            return "";
        }
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }

    public static boolean g(String str) {
        try {
            if (TextUtils.isEmpty(f1091i)) {
                f1091i = a(Process.myPid());
            }
            return !str.equals(f1091i);
        } catch (Throwable unused) {
            int i2 = a.a;
            return false;
        }
    }

    public static String h(Context context) {
        try {
            if (TextUtils.isEmpty(h)) {
                if (m != 1) {
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(context.getPackageName() + IStringUtil.CURRENT_PATH + "sofire" + ".ac.provider", 0);
                    if (!(resolveContentProvider == null || resolveContentProvider.multiprocess)) {
                        h = resolveContentProvider.processName;
                    }
                    m = 1;
                    return h;
                }
            }
            return h;
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public static boolean i(Context context) {
        try {
            if (context.getApplicationInfo().targetSdkVersion < 31 || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            int i2 = a.a;
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|(2:11|(1:13)(1:14))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0032 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038 A[Catch:{ all -> 0x004c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean j(android.content.Context r4) {
        /*
            r0 = 0
            int r1 = n     // Catch:{ all -> 0x004c }
            r2 = 1
            if (r1 >= 0) goto L_0x0047
            if (r4 == 0) goto L_0x0047
            java.lang.String r1 = r4.getPackageName()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r3.<init>()     // Catch:{ all -> 0x0032 }
            r3.append(r1)     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = ".BuildConfig"
            r3.append(r1)     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0032 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "DEBUG"
            java.lang.reflect.Field r1 = r1.getField(r3)     // Catch:{ all -> 0x0032 }
            r1.setAccessible(r2)     // Catch:{ all -> 0x0032 }
            r3 = 0
            boolean r1 = r1.getBoolean(r3)     // Catch:{ all -> 0x0032 }
            n = r1     // Catch:{ all -> 0x0032 }
            goto L_0x0047
        L_0x0032:
            android.content.pm.ApplicationInfo r1 = r4.getApplicationInfo()     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0047
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo()     // Catch:{ all -> 0x004c }
            int r4 = r4.flags     // Catch:{ all -> 0x004c }
            r4 = r4 & 2
            if (r4 == 0) goto L_0x0045
            n = r2     // Catch:{ all -> 0x004c }
            goto L_0x0047
        L_0x0045:
            n = r0     // Catch:{ all -> 0x004c }
        L_0x0047:
            int r4 = n     // Catch:{ all -> 0x004c }
            if (r4 != r2) goto L_0x004e
            return r2
        L_0x004c:
            int r4 = com.baidu.sofire.a.a.a
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.j(android.content.Context):boolean");
    }

    public static int k(Context context) {
        try {
            if (MyProvider.a) {
                return 1;
            }
            if (f == -1) {
                int b2 = b(context);
                if (b2 == 1) {
                    f = 1;
                } else if (b2 == 2) {
                    f = 0;
                } else {
                    f = MyProvider.a ? 1 : 0;
                }
            }
            return f;
        } catch (Throwable unused) {
            int i2 = a.a;
            return -1;
        }
    }

    public static boolean l(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Throwable unused) {
            int i2 = a.a;
            return false;
        }
    }

    public static boolean m(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && 1 == activeNetworkInfo.getType()) {
            return true;
        }
        return false;
    }

    public static void n(Context context) {
        try {
            MyReceiver myReceiver = new MyReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.baidu.action.SOFIRE.VIEW");
            intentFilter.addCategory("com.baidu.category.SOFIRE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            String str = context.getPackageName() + ".permission." + "sofire" + ".RECEIVE";
            if (Build.VERSION.SDK_INT >= 33) {
                context.getApplicationContext().registerReceiver(myReceiver, intentFilter, str, (Handler) null, 4);
            } else {
                context.getApplicationContext().registerReceiver(myReceiver, intentFilter, str, (Handler) null);
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r8 = com.baidu.sofire.a.a.a;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r7 = com.baidu.sofire.a.a.a;
        r7 = "";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0057 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0088 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject o(android.content.Context r14) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "1"
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x010c }
            r3.<init>()     // Catch:{ all -> 0x010c }
            java.lang.String r4 = b()     // Catch:{ all -> 0x010c }
            r3.append(r4)     // Catch:{ all -> 0x010c }
            java.lang.String r4 = "p/5/aio"
            r3.append(r4)     // Catch:{ all -> 0x010c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x010c }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x010c }
            r4.<init>()     // Catch:{ all -> 0x010c }
            org.json.JSONArray r5 = a((android.content.Context) r14)     // Catch:{ all -> 0x010c }
            if (r5 == 0) goto L_0x002a
            java.lang.String r6 = "0"
            r4.put(r6, r5)     // Catch:{ all -> 0x010c }
        L_0x002a:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x010c }
            r5.<init>()     // Catch:{ all -> 0x010c }
            java.lang.String r6 = com.baidu.sofire.l.e.a(r14)     // Catch:{ all -> 0x010c }
            r5.put(r1, r6)     // Catch:{ all -> 0x010c }
            java.lang.String r6 = "3"
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x010c }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x010c }
            r5.put(r6, r7)     // Catch:{ all -> 0x010c }
            java.lang.String r6 = "4"
            java.lang.String r7 = "3.6.7.0"
            r5.put(r6, r7)     // Catch:{ all -> 0x010c }
            java.lang.String r6 = r14.getPackageName()     // Catch:{ all -> 0x010c }
            android.content.pm.PackageManager r7 = r14.getPackageManager()     // Catch:{ all -> 0x010c }
            r8 = 64
            android.content.pm.PackageInfo r8 = r7.getPackageInfo(r6, r8)     // Catch:{ all -> 0x0057 }
            goto L_0x005a
        L_0x0057:
            int r8 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x010c }
            r8 = r2
        L_0x005a:
            if (r8 == 0) goto L_0x0108
            android.content.pm.ApplicationInfo r9 = r8.applicationInfo     // Catch:{ all -> 0x010c }
            java.lang.CharSequence r7 = r9.loadLabel(r7)     // Catch:{ all -> 0x010c }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x010c }
            r9 = 0
            int r10 = r7.length()     // Catch:{ all -> 0x0088 }
            r11 = 0
        L_0x006c:
            if (r11 >= r10) goto L_0x0081
            char r12 = r7.charAt(r11)     // Catch:{ all -> 0x0088 }
            r13 = 32
            if (r12 <= r13) goto L_0x007e
            char r12 = r7.charAt(r11)     // Catch:{ all -> 0x0088 }
            r13 = 160(0xa0, float:2.24E-43)
            if (r12 != r13) goto L_0x0081
        L_0x007e:
            int r11 = r11 + 1
            goto L_0x006c
        L_0x0081:
            if (r11 <= 0) goto L_0x008b
            java.lang.String r7 = r7.substring(r11)     // Catch:{ all -> 0x0088 }
            goto L_0x008b
        L_0x0088:
            int r7 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x010c }
            r7 = r0
        L_0x008b:
            java.lang.String r10 = "5"
            r5.put(r10, r7)     // Catch:{ all -> 0x010c }
            java.lang.String r7 = "6"
            r5.put(r7, r6)     // Catch:{ all -> 0x010c }
            android.content.pm.ApplicationInfo r6 = r8.applicationInfo     // Catch:{ all -> 0x010c }
            java.lang.String r6 = r6.sourceDir     // Catch:{ all -> 0x010c }
            java.lang.String r6 = a((android.content.pm.PackageInfo) r8, (java.lang.String) r6)     // Catch:{ all -> 0x010c }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x010c }
            java.lang.String r10 = "7"
            if (r7 == 0) goto L_0x00a9
            r5.put(r10, r0)     // Catch:{ all -> 0x010c }
            goto L_0x00ac
        L_0x00a9:
            r5.put(r10, r6)     // Catch:{ all -> 0x010c }
        L_0x00ac:
            java.lang.String r0 = "8"
            java.lang.String r6 = r8.versionName     // Catch:{ all -> 0x010c }
            r5.put(r0, r6)     // Catch:{ all -> 0x010c }
            com.baidu.sofire.j.a r0 = com.baidu.sofire.j.a.a((android.content.Context) r14)     // Catch:{ all -> 0x010c }
            java.lang.String r6 = "9"
            android.content.SharedPreferences r0 = r0.a     // Catch:{ all -> 0x010c }
            java.lang.String r7 = "opi"
            int r0 = r0.getInt(r7, r9)     // Catch:{ all -> 0x010c }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x010c }
            r5.put(r6, r0)     // Catch:{ all -> 0x010c }
            java.lang.String r0 = "16"
            java.lang.String r6 = com.baidu.sofire.l.a.a(r14)     // Catch:{ all -> 0x010c }
            r5.put(r0, r6)     // Catch:{ all -> 0x010c }
            r4.put(r1, r5)     // Catch:{ all -> 0x010c }
            java.lang.String r0 = com.baidu.sofire.b.d.a     // Catch:{ all -> 0x010c }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x010c }
            r1 = 1
            java.lang.String r0 = com.baidu.sofire.b.l.a((android.content.Context) r14, (java.lang.String) r3, (java.lang.String) r0, (boolean) r1, (boolean) r1)     // Catch:{ all -> 0x010c }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x010c }
            if (r1 != 0) goto L_0x0107
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x010c }
            r1.<init>(r0)     // Catch:{ all -> 0x010c }
            a((android.content.Context) r14, (org.json.JSONObject) r1)     // Catch:{ all -> 0x010c }
            com.baidu.sofire.b.l.a((android.content.Context) r14, (org.json.JSONObject) r1)     // Catch:{ all -> 0x010c }
            c(r14, r1)     // Catch:{ all -> 0x010c }
            boolean r14 = com.baidu.sofire.k.b.b()     // Catch:{ all -> 0x010c }
            if (r14 == 0) goto L_0x0106
            org.json.JSONObject r14 = r1.optJSONObject(r10)     // Catch:{ all -> 0x010c }
            if (r14 == 0) goto L_0x0106
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x010c }
            com.baidu.sofire.k.b.a((java.lang.String) r14)     // Catch:{ all -> 0x010c }
        L_0x0106:
            return r1
        L_0x0107:
            return r2
        L_0x0108:
            r14 = 6
            e = r14     // Catch:{ all -> 0x010c }
            return r2
        L_0x010c:
            int r14 = com.baidu.sofire.a.a.a
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.o(android.content.Context):org.json.JSONObject");
    }

    public static String[] p(Context context) {
        String[] split;
        String[] split2;
        String str = c;
        String str2 = d;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                String string = com.baidu.sofire.j.a.a(context).a.getString("svi_n", "");
                if (!TextUtils.isEmpty(string) && (split2 = string.split("-")) != null && split2.length == 2) {
                    return split2;
                }
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                String string2 = com.baidu.sofire.j.a.a(context).a.getString("svi", "");
                if (!TextUtils.isEmpty(string2) && (split = string2.split("-")) != null && split.length == 2) {
                    return split;
                }
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                str = "3";
                str2 = "925fc15df8a49bed0b3eca8d2b44cb7b";
            }
            return new String[]{str, str2};
        }
        return new String[]{str, str2};
    }

    public static void q(Context context) {
        try {
            Report instance = Report.getInstance(context);
            JSONObject jSONObject = new JSONObject();
            com.baidu.sofire.c.a a2 = com.baidu.sofire.c.a.a(context);
            HashMap hashMap = (HashMap) a2.c();
            jSONObject.put("0", hashMap.keySet());
            jSONObject.put("1", hashMap.values());
            JSONArray a3 = com.baidu.sofire.k.c.a();
            if (a3 != null) {
                jSONObject.put("2", a3);
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("1003003", jSONObject);
            jSONObject2.put("0", jSONObject3);
            Map<Integer, String> d2 = a2.d();
            JSONArray jSONArray = new JSONArray();
            for (String put : ((HashMap) d2).values()) {
                jSONArray.put(put);
            }
            jSONArray.put("com.baidu.sofire");
            jSONObject2.put("2", jSONArray);
            instance.w(jSONObject2.toString());
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|10|11|12|13|14|(3:19|20|(1:22)(3:23|(2:24|(3:26|(2:28|78)(2:29|(2:31|79)(2:32|(1:76)(2:34|(2:77|36)(1:(2:38|80)(3:39|(4:42|(2:43|(2:45|(1:50)(2:82|49))(2:83|51))|(1:74)(2:53|(2:75|55)(1:56))|40)|81)))))|72)(3:73|59|(1:63)))|58))(1:65)|66|(2:71|86)(1:87)) */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x009e, code lost:
        r2.close();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0028 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034 A[SYNTHETIC, Splitter:B:19:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.pm.PackageInfo r9, java.lang.String r10) {
        /*
            r0 = 0
            r1 = 0
            if (r9 == 0) goto L_0x0031
            android.content.pm.Signature[] r9 = r9.signatures
            if (r9 == 0) goto L_0x0031
            int r2 = r9.length
            if (r2 <= 0) goto L_0x0031
            r2 = r9[r1]
            if (r2 == 0) goto L_0x0031
            r9 = r9[r1]     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "X.509"
            java.security.cert.CertificateFactory r2 = java.security.cert.CertificateFactory.getInstance(r2)     // Catch:{ all -> 0x002f }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x002f }
            byte[] r9 = r9.toByteArray()     // Catch:{ all -> 0x002f }
            r3.<init>(r9)     // Catch:{ all -> 0x002f }
            java.security.cert.Certificate r9 = r2.generateCertificate(r3)     // Catch:{ all -> 0x002f }
            r3.close()     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x002f }
        L_0x002a:
            java.security.PublicKey r9 = r9.getPublicKey()     // Catch:{ all -> 0x002f }
            goto L_0x0032
        L_0x002f:
            int r9 = com.baidu.sofire.a.a.a
        L_0x0031:
            r9 = r0
        L_0x0032:
            if (r9 != 0) goto L_0x00b7
            boolean r9 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x00b5 }
            if (r9 == 0) goto L_0x003c
            goto L_0x00b8
        L_0x003c:
            r9 = 8192(0x2000, float:1.14794E-41)
            byte[] r9 = new byte[r9]     // Catch:{ all -> 0x00b5 }
            java.util.jar.JarFile r2 = new java.util.jar.JarFile     // Catch:{ all -> 0x00b5 }
            r2.<init>(r10)     // Catch:{ all -> 0x00b5 }
            java.util.Enumeration r10 = r2.entries()     // Catch:{ all -> 0x00b5 }
            r3 = r0
        L_0x004a:
            boolean r4 = r10.hasMoreElements()     // Catch:{ all -> 0x00b5 }
            if (r4 == 0) goto L_0x00a6
            java.lang.Object r4 = r10.nextElement()     // Catch:{ all -> 0x00b5 }
            java.util.jar.JarEntry r4 = (java.util.jar.JarEntry) r4     // Catch:{ all -> 0x00b5 }
            boolean r5 = r4.isDirectory()     // Catch:{ all -> 0x00b5 }
            if (r5 == 0) goto L_0x005d
            goto L_0x004a
        L_0x005d:
            java.lang.String r5 = r4.getName()     // Catch:{ all -> 0x00b5 }
            java.lang.String r6 = "META-INF/"
            boolean r5 = r5.startsWith(r6)     // Catch:{ all -> 0x00b5 }
            if (r5 == 0) goto L_0x006a
            goto L_0x004a
        L_0x006a:
            java.security.cert.Certificate[] r4 = com.baidu.sofire.b.l.a((java.util.jar.JarFile) r2, (java.util.jar.JarEntry) r4, (byte[]) r9)     // Catch:{ all -> 0x00b5 }
            if (r4 == 0) goto L_0x00a2
            int r5 = r4.length     // Catch:{ all -> 0x00b5 }
            if (r5 > 0) goto L_0x0074
            goto L_0x00a2
        L_0x0074:
            if (r3 != 0) goto L_0x0078
            r3 = r4
            goto L_0x004a
        L_0x0078:
            r5 = 0
        L_0x0079:
            int r6 = r3.length     // Catch:{ all -> 0x00b5 }
            if (r5 >= r6) goto L_0x004a
            r6 = 0
        L_0x007d:
            int r7 = r4.length     // Catch:{ all -> 0x00b5 }
            if (r6 >= r7) goto L_0x0093
            r7 = r3[r5]     // Catch:{ all -> 0x00b5 }
            if (r7 == 0) goto L_0x0090
            r7 = r3[r5]     // Catch:{ all -> 0x00b5 }
            r8 = r4[r6]     // Catch:{ all -> 0x00b5 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x00b5 }
            if (r7 == 0) goto L_0x0090
            r6 = 1
            goto L_0x0094
        L_0x0090:
            int r6 = r6 + 1
            goto L_0x007d
        L_0x0093:
            r6 = 0
        L_0x0094:
            if (r6 == 0) goto L_0x009e
            int r6 = r3.length     // Catch:{ all -> 0x00b5 }
            int r7 = r4.length     // Catch:{ all -> 0x00b5 }
            if (r6 == r7) goto L_0x009b
            goto L_0x009e
        L_0x009b:
            int r5 = r5 + 1
            goto L_0x0079
        L_0x009e:
            r2.close()     // Catch:{ all -> 0x00b5 }
            goto L_0x00b8
        L_0x00a2:
            r2.close()     // Catch:{ all -> 0x00b5 }
            goto L_0x00b8
        L_0x00a6:
            r2.close()     // Catch:{ all -> 0x00b5 }
            if (r3 == 0) goto L_0x00b8
            int r9 = r3.length     // Catch:{ all -> 0x00b5 }
            if (r9 <= 0) goto L_0x00b8
            r9 = r3[r1]     // Catch:{ all -> 0x00b5 }
            java.security.PublicKey r0 = r9.getPublicKey()     // Catch:{ all -> 0x00b5 }
            goto L_0x00b8
        L_0x00b5:
            goto L_0x00b8
        L_0x00b7:
            r0 = r9
        L_0x00b8:
            java.lang.String r9 = ""
            if (r0 != 0) goto L_0x00bd
            return r9
        L_0x00bd:
            byte[] r10 = r0.getEncoded()
            if (r10 == 0) goto L_0x00d7
            java.lang.String r10 = android.util.Base64.encodeToString(r10, r1)
            java.lang.String r0 = "\n"
            java.lang.String r10 = r10.replace(r0, r9)
            java.lang.String r0 = "\r"
            java.lang.String r9 = r10.replace(r0, r9)
            java.lang.String r9 = com.baidu.sofire.l.k.a((java.lang.String) r9)
        L_0x00d7:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.a(android.content.pm.PackageInfo, java.lang.String):java.lang.String");
    }

    public static File f(Context context) {
        if (a == null) {
            a = context.getFilesDir();
        }
        return a;
    }

    public static int b(Context context) {
        try {
            String h2 = h(context);
            if (TextUtils.isEmpty(f1091i)) {
                f1091i = a(Process.myPid());
            }
            if (TextUtils.isEmpty(f1091i)) {
                return 0;
            }
            return !TextUtils.isEmpty(h2) ? h2.equals(f1091i) ? 1 : 2 : context.getPackageName().equals(f1091i) ? 3 : 4;
        } catch (Throwable unused) {
            int i2 = a.a;
            return 0;
        }
    }

    public static int g(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
            int i2 = a.a;
            networkInfo = null;
        }
        if (networkInfo == null) {
            return 0;
        }
        if (1 == networkInfo.getType()) {
            return 2;
        }
        int type = networkInfo.getType();
        return 1;
    }

    public static String d(String str) {
        try {
            String str2 = new String(g.a(e.a, Base64.decode(str, 10), true), "UTF-8");
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            return "";
        } catch (Throwable unused) {
            int i2 = a.a;
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        r10 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r10 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0143 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0195 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x01ae */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(android.content.Context r10, org.json.JSONObject r11) {
        /*
            java.lang.String r0 = "UTF-8"
            java.lang.String r1 = "0"
            com.baidu.sofire.j.a r2 = com.baidu.sofire.j.a.a((android.content.Context) r10)     // Catch:{ all -> 0x01b1 }
            r3 = 10
            r4 = 1
            java.lang.String r5 = r11.optString(r1)     // Catch:{ all -> 0x0035 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0035 }
            if (r6 != 0) goto L_0x0037
            java.lang.String r6 = new java.lang.String     // Catch:{ all -> 0x0035 }
            byte[] r7 = com.baidu.sofire.l.e.a     // Catch:{ all -> 0x0035 }
            byte[] r5 = r5.getBytes(r0)     // Catch:{ all -> 0x0035 }
            byte[] r5 = com.baidu.sofire.l.g.b(r7, r5, r4)     // Catch:{ all -> 0x0035 }
            byte[] r5 = android.util.Base64.encode(r5, r3)     // Catch:{ all -> 0x0035 }
            r6.<init>(r5, r0)     // Catch:{ all -> 0x0035 }
            android.content.SharedPreferences$Editor r0 = r2.d     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = "gli"
            r0.putString(r5, r6)     // Catch:{ all -> 0x0035 }
            android.content.SharedPreferences$Editor r0 = r2.d     // Catch:{ all -> 0x0035 }
            r0.commit()     // Catch:{ all -> 0x0035 }
            goto L_0x0037
        L_0x0035:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x01b1 }
        L_0x0037:
            java.lang.String r0 = "4"
            org.json.JSONObject r11 = r11.optJSONObject(r0)     // Catch:{ all -> 0x01b1 }
            if (r11 != 0) goto L_0x0040
            return
        L_0x0040:
            java.lang.String r0 = "app"
            int r0 = r11.optInt(r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r5 = r2.b     // Catch:{ all -> 0x01b1 }
            java.lang.String r6 = "appinv_t"
            r5.putInt(r6, r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r0 = r2.b     // Catch:{ all -> 0x01b1 }
            r0.commit()     // Catch:{ all -> 0x01b1 }
            java.lang.String r0 = "js"
            int r0 = r11.optInt(r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r5 = r2.b     // Catch:{ all -> 0x01b1 }
            java.lang.String r6 = "appinv_js"
            r5.putInt(r6, r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r0 = r2.b     // Catch:{ all -> 0x01b1 }
            r0.commit()     // Catch:{ all -> 0x01b1 }
            java.lang.String r0 = "a"
            int r0 = r11.optInt(r0, r4)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r5 = r2.b     // Catch:{ all -> 0x01b1 }
            java.lang.String r6 = "appinv_ky"
            r5.putInt(r6, r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r0 = r2.b     // Catch:{ all -> 0x01b1 }
            r0.commit()     // Catch:{ all -> 0x01b1 }
            java.lang.String r0 = "pi"
            r5 = 360(0x168, float:5.04E-43)
            int r0 = r11.optInt(r0, r5)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r5 = r2.b     // Catch:{ all -> 0x01b1 }
            java.lang.String r6 = "appplg_te"
            r5.putInt(r6, r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r0 = r2.b     // Catch:{ all -> 0x01b1 }
            r0.commit()     // Catch:{ all -> 0x01b1 }
            java.lang.String r0 = "ti"
            int r0 = r11.optInt(r0, r4)     // Catch:{ all -> 0x01b1 }
            r5 = 24
            if (r0 <= 0) goto L_0x00b6
            double r6 = (double) r0     // Catch:{ all -> 0x01b1 }
            r8 = 4627448617123184640(0x4038000000000000, double:24.0)
            double r8 = r8 / r6
            long r6 = java.lang.Math.round(r8)     // Catch:{ all -> 0x01b1 }
            int r0 = (int) r6
            java.lang.String r6 = "appal_te"
            if (r0 <= 0) goto L_0x00ac
            android.content.SharedPreferences$Editor r7 = r2.b     // Catch:{ all -> 0x01b1 }
            r7.putInt(r6, r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r0 = r2.b     // Catch:{ all -> 0x01b1 }
            r0.commit()     // Catch:{ all -> 0x01b1 }
            goto L_0x00b6
        L_0x00ac:
            android.content.SharedPreferences$Editor r0 = r2.b     // Catch:{ all -> 0x01b1 }
            r0.putInt(r6, r5)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r0 = r2.b     // Catch:{ all -> 0x01b1 }
            r0.commit()     // Catch:{ all -> 0x01b1 }
        L_0x00b6:
            java.lang.String r0 = "alm"
            int r0 = r11.optInt(r0, r5)     // Catch:{ all -> 0x01b1 }
            java.lang.String r6 = "appal_daa"
            if (r0 <= 0) goto L_0x00cb
            android.content.SharedPreferences$Editor r5 = r2.b     // Catch:{ all -> 0x01b1 }
            r5.putInt(r6, r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r0 = r2.b     // Catch:{ all -> 0x01b1 }
            r0.commit()     // Catch:{ all -> 0x01b1 }
            goto L_0x00d5
        L_0x00cb:
            android.content.SharedPreferences$Editor r0 = r2.b     // Catch:{ all -> 0x01b1 }
            r0.putInt(r6, r5)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r0 = r2.b     // Catch:{ all -> 0x01b1 }
            r0.commit()     // Catch:{ all -> 0x01b1 }
        L_0x00d5:
            r0 = 0
            int r1 = r11.optInt(r1, r0)     // Catch:{ all -> 0x01b1 }
            java.lang.String r5 = "a_a_c_b"
            if (r1 <= 0) goto L_0x00e9
            android.content.SharedPreferences$Editor r1 = r2.b     // Catch:{ all -> 0x01b1 }
            r1.putBoolean(r5, r4)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r1 = r2.b     // Catch:{ all -> 0x01b1 }
            r1.commit()     // Catch:{ all -> 0x01b1 }
            goto L_0x00f3
        L_0x00e9:
            android.content.SharedPreferences$Editor r1 = r2.b     // Catch:{ all -> 0x01b1 }
            r1.putBoolean(r5, r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r1 = r2.b     // Catch:{ all -> 0x01b1 }
            r1.commit()     // Catch:{ all -> 0x01b1 }
        L_0x00f3:
            java.lang.String r1 = "1"
            r5 = -1
            int r1 = r11.optInt(r1, r5)     // Catch:{ all -> 0x01b1 }
            java.lang.String r5 = "se_fg_s"
            if (r1 != r4) goto L_0x010e
            android.content.SharedPreferences r1 = r2.a     // Catch:{ all -> 0x01b1 }
            r1.getBoolean(r5, r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r1 = r2.b     // Catch:{ all -> 0x01b1 }
            r1.putBoolean(r5, r4)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r1 = r2.b     // Catch:{ all -> 0x01b1 }
            r1.commit()     // Catch:{ all -> 0x01b1 }
            goto L_0x0118
        L_0x010e:
            android.content.SharedPreferences$Editor r1 = r2.b     // Catch:{ all -> 0x01b1 }
            r1.putBoolean(r5, r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r1 = r2.b     // Catch:{ all -> 0x01b1 }
            r1.commit()     // Catch:{ all -> 0x01b1 }
        L_0x0118:
            java.lang.String r1 = "mp"
            int r1 = r11.optInt(r1, r0)     // Catch:{ all -> 0x01b1 }
            java.lang.String r5 = "ampf"
            a((android.content.Context) r10, (java.lang.String) r5, (int) r1)     // Catch:{ all -> 0x01b1 }
            java.lang.String r1 = "pc"
            org.json.JSONObject r1 = r11.optJSONObject(r1)     // Catch:{ all -> 0x01b1 }
            if (r1 == 0) goto L_0x0145
            com.baidu.sofire.j.a r5 = com.baidu.sofire.j.a.a((android.content.Context) r10)     // Catch:{ all -> 0x0143 }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x0143 }
            android.content.SharedPreferences$Editor r7 = r5.b     // Catch:{ all -> 0x0143 }
            java.lang.String r8 = "p_s_p_c"
            r7.putString(r8, r6)     // Catch:{ all -> 0x0143 }
            android.content.SharedPreferences$Editor r5 = r5.b     // Catch:{ all -> 0x0143 }
            r5.commit()     // Catch:{ all -> 0x0143 }
            com.baidu.sofire.l.r.a((org.json.JSONObject) r1)     // Catch:{ all -> 0x0143 }
            goto L_0x0145
        L_0x0143:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x01b1 }
        L_0x0145:
            java.lang.String r1 = "pr"
            org.json.JSONObject r1 = r11.optJSONObject(r1)     // Catch:{ all -> 0x01b1 }
            if (r1 == 0) goto L_0x0150
            com.baidu.sofire.b.l.b(r10, r1)     // Catch:{ all -> 0x01b1 }
        L_0x0150:
            java.lang.String r1 = "pp"
            org.json.JSONArray r1 = r11.optJSONArray(r1)     // Catch:{ all -> 0x01b1 }
            if (r1 == 0) goto L_0x015b
            a((android.content.Context) r10, (org.json.JSONArray) r1)     // Catch:{ all -> 0x01b1 }
        L_0x015b:
            java.lang.String r10 = "mc"
            int r10 = r11.optInt(r10, r4)     // Catch:{ all -> 0x01b1 }
            java.lang.String r1 = "s_n_m_c_s"
            if (r10 <= 0) goto L_0x0172
            com.baidu.sofire.l.l.a = r4     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r10 = r2.b     // Catch:{ all -> 0x01b1 }
            r10.putBoolean(r1, r4)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r10 = r2.b     // Catch:{ all -> 0x01b1 }
            r10.commit()     // Catch:{ all -> 0x01b1 }
            goto L_0x017e
        L_0x0172:
            com.baidu.sofire.l.l.a = r0     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r10 = r2.b     // Catch:{ all -> 0x01b1 }
            r10.putBoolean(r1, r0)     // Catch:{ all -> 0x01b1 }
            android.content.SharedPreferences$Editor r10 = r2.b     // Catch:{ all -> 0x01b1 }
            r10.commit()     // Catch:{ all -> 0x01b1 }
        L_0x017e:
            java.lang.String r10 = "dlp"
            int r10 = r11.getInt(r10)     // Catch:{ all -> 0x0195 }
            if (r10 < 0) goto L_0x0197
            if (r10 > r3) goto L_0x0197
            android.content.SharedPreferences$Editor r1 = r2.b     // Catch:{ all -> 0x0195 }
            java.lang.String r3 = "g_r_d_r_r"
            r1.putInt(r3, r10)     // Catch:{ all -> 0x0195 }
            android.content.SharedPreferences$Editor r10 = r2.b     // Catch:{ all -> 0x0195 }
            r10.commit()     // Catch:{ all -> 0x0195 }
            goto L_0x0197
        L_0x0195:
            int r10 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x01b1 }
        L_0x0197:
            java.lang.String r10 = "cf"
            int r10 = r11.getInt(r10)     // Catch:{ all -> 0x01ae }
            if (r10 == 0) goto L_0x01a0
            goto L_0x01a1
        L_0x01a0:
            r4 = 0
        L_0x01a1:
            android.content.SharedPreferences$Editor r10 = r2.b     // Catch:{ all -> 0x01ae }
            java.lang.String r11 = "s_u_l_c_f"
            r10.putBoolean(r11, r4)     // Catch:{ all -> 0x01ae }
            android.content.SharedPreferences$Editor r10 = r2.b     // Catch:{ all -> 0x01ae }
            r10.commit()     // Catch:{ all -> 0x01ae }
            goto L_0x01b3
        L_0x01ae:
            int r10 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x01b1 }
            goto L_0x01b3
        L_0x01b1:
            int r10 = com.baidu.sofire.a.a.a
        L_0x01b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.c(android.content.Context, org.json.JSONObject):void");
    }

    public static String b() {
        try {
            return new String(F.getInstance().ad(Base64.decode("2s3neoRGrtMfJHEASAvJDkdImW3sImg0pRReW5cWEQQB2HfrzauSCia/ssvfdE6q", 0), e.a));
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r6 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        if (r1 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003d, code lost:
        if (r1 != null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0034 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String h(java.lang.String r6) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x0033 }
            r1.<init>(r6)     // Catch:{ all -> 0x0033 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x0034 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0034 }
            r6.<init>(r2)     // Catch:{ all -> 0x0034 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r2.<init>()     // Catch:{ all -> 0x0034 }
            r3 = 1
        L_0x0018:
            java.lang.String r4 = r6.readLine()     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x002b
            if (r3 != 0) goto L_0x0026
            r5 = 10
            r2.append(r5)     // Catch:{ all -> 0x0034 }
            goto L_0x0027
        L_0x0026:
            r3 = 0
        L_0x0027:
            r2.append(r4)     // Catch:{ all -> 0x0034 }
            goto L_0x0018
        L_0x002b:
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x0034 }
            r1.close()     // Catch:{ all -> 0x0032 }
        L_0x0032:
            return r6
        L_0x0033:
            r1 = r0
        L_0x0034:
            int r6 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x003b
            r1.close()     // Catch:{ all -> 0x003b }
        L_0x003b:
            return r0
        L_0x003c:
            r6 = move-exception
            if (r1 == 0) goto L_0x0042
            r1.close()     // Catch:{ all -> 0x0042 }
        L_0x0042:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.h(java.lang.String):java.lang.String");
    }

    public static boolean d() {
        try {
            return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
        } catch (Throwable unused) {
            int i2 = a.a;
            return false;
        }
    }

    public static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return !str.equals(str2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:42|43|44|45) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r5 = com.baidu.sofire.a.a.a;
        r5 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        r0 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x007c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x00fe */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x0101 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e0 A[SYNTHETIC, Splitter:B:32:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e4 A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f9 A[SYNTHETIC, Splitter:B:40:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0107 A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0119 A[Catch:{ all -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0135 A[SYNTHETIC, Splitter:B:56:0x0135] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0139 A[Catch:{ all -> 0x0146 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject b(android.content.Context r19, org.json.JSONObject r20) {
        /*
            r0 = r20
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r4 = "Common_section"
            org.json.JSONObject r4 = r0.getJSONObject(r4)     // Catch:{ all -> 0x0012 }
            goto L_0x0015
        L_0x0012:
            int r4 = com.baidu.sofire.a.a.a
            r4 = 0
        L_0x0015:
            java.lang.String r5 = "11"
            java.lang.String r6 = "9"
            java.lang.String r7 = "8"
            java.lang.String r8 = "3"
            java.lang.String r9 = "1"
            java.lang.String r10 = "10"
            java.lang.String r11 = ""
            if (r4 == 0) goto L_0x0046
            java.lang.String r2 = r4.optString(r10)
            java.lang.String r3 = "0"
            long r12 = r4.optLong(r3)
            java.lang.String r3 = r4.optString(r9)
            java.lang.String r14 = r4.optString(r8)
            java.lang.String r15 = r4.optString(r7)
            java.lang.String r16 = r4.optString(r6)
            java.lang.String r4 = r4.optString(r5)
            r0 = r16
            goto L_0x004d
        L_0x0046:
            r12 = r2
            r0 = r11
            r2 = r0
            r3 = r2
            r4 = r3
            r14 = r4
            r15 = r14
        L_0x004d:
            boolean r16 = android.text.TextUtils.isEmpty(r14)
            r17 = r14
            r14 = 2
            if (r16 == 0) goto L_0x0065
            r16 = r4
            java.lang.String[] r4 = p(r19)
            r18 = r5
            int r5 = r4.length
            if (r5 != r14) goto L_0x0069
            r5 = 0
            r4 = r4[r5]
            goto L_0x006b
        L_0x0065:
            r16 = r4
            r18 = r5
        L_0x0069:
            r4 = r17
        L_0x006b:
            android.content.pm.ApplicationInfo r5 = r19.getApplicationInfo()     // Catch:{ all -> 0x007c }
            android.content.pm.PackageManager r14 = r19.getPackageManager()     // Catch:{ all -> 0x007c }
            java.lang.CharSequence r5 = r5.loadLabel(r14)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x007c }
            goto L_0x007f
        L_0x007c:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0146 }
            r5 = r11
        L_0x007f:
            r1.put(r9, r5)     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = "2"
            java.lang.String r9 = r19.getPackageName()     // Catch:{ all -> 0x0146 }
            r1.put(r5, r9)     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = com.baidu.sofire.l.y.a(r19)     // Catch:{ all -> 0x0146 }
            r1.put(r8, r5)     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = "4"
            java.lang.String r8 = com.baidu.sofire.l.e.a(r19)     // Catch:{ all -> 0x0146 }
            r1.put(r5, r8)     // Catch:{ all -> 0x0146 }
            java.lang.String r5 = "5"
            r1.put(r5, r2)     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = "6"
            r1.put(r2, r12)     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = "7"
            r1.put(r2, r3)     // Catch:{ all -> 0x0146 }
            r1.put(r7, r4)     // Catch:{ all -> 0x0146 }
            r1.put(r6, r15)     // Catch:{ all -> 0x0146 }
            r1.put(r10, r0)     // Catch:{ all -> 0x0146 }
            com.baidu.sofire.j.a r0 = com.baidu.sofire.j.a.a((android.content.Context) r19)     // Catch:{ all -> 0x0146 }
            android.content.SharedPreferences r2 = r0.e     // Catch:{ all -> 0x0146 }
            java.lang.String r3 = "re_a_cv"
            java.lang.String r2 = r2.getString(r3, r11)     // Catch:{ all -> 0x0146 }
            r3 = r18
            r1.put(r3, r2)     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = "12"
            android.content.SharedPreferences r0 = r0.e     // Catch:{ all -> 0x0146 }
            java.lang.String r3 = "re_a_lc"
            java.lang.String r0 = r0.getString(r3, r11)     // Catch:{ all -> 0x0146 }
            r1.put(r2, r0)     // Catch:{ all -> 0x0146 }
            java.lang.String r0 = "13"
            r2 = 1
            r1.put(r0, r2)     // Catch:{ all -> 0x0146 }
            int r0 = d((android.content.Context) r19)     // Catch:{ all -> 0x0146 }
            r3 = 4
            java.lang.String r4 = "14"
            if (r0 != r3) goto L_0x00e4
            r1.put(r4, r2)     // Catch:{ all -> 0x0146 }
            goto L_0x00e8
        L_0x00e4:
            r0 = 2
            r1.put(r4, r0)     // Catch:{ all -> 0x0146 }
        L_0x00e8:
            java.lang.String r0 = "28"
            java.lang.String r2 = com.baidu.sofire.l.m.a((android.content.Context) r19)     // Catch:{ all -> 0x0146 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0146 }
            boolean r0 = com.baidu.sofire.l.f.b(r19)     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = "23"
            if (r0 == 0) goto L_0x0107
            java.lang.String r11 = com.baidu.android.common.util.DeviceId.getCUID(r19)     // Catch:{ all -> 0x00fe }
            goto L_0x0103
        L_0x00fe:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0101 }
            goto L_0x0103
        L_0x0101:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0146 }
        L_0x0103:
            r1.put(r2, r11)     // Catch:{ all -> 0x0146 }
            goto L_0x010a
        L_0x0107:
            r1.put(r2, r11)     // Catch:{ all -> 0x0146 }
        L_0x010a:
            java.lang.String r0 = "31"
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0146 }
            r1.put(r0, r2)     // Catch:{ all -> 0x0146 }
            java.lang.String r0 = com.baidu.sofire.b.d.a     // Catch:{ all -> 0x0146 }
            boolean r0 = android.text.TextUtils.isEmpty(r16)     // Catch:{ all -> 0x0146 }
            if (r0 != 0) goto L_0x0120
            java.lang.String r0 = "37"
            r4 = r16
            r1.put(r0, r4)     // Catch:{ all -> 0x0146 }
        L_0x0120:
            java.lang.String r0 = "38"
            java.lang.String r2 = "3.6.7.0"
            r1.put(r0, r2)     // Catch:{ all -> 0x0146 }
            java.lang.String r0 = "Module_section"
            r2 = r20
            java.lang.Object r0 = r2.get(r0)     // Catch:{ all -> 0x0146 }
            boolean r2 = r0 instanceof org.json.JSONArray     // Catch:{ all -> 0x0146 }
            java.lang.String r3 = "module_section"
            if (r2 == 0) goto L_0x0139
            r1.put(r3, r0)     // Catch:{ all -> 0x0146 }
            goto L_0x0148
        L_0x0139:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ all -> 0x0146 }
            r2.<init>()     // Catch:{ all -> 0x0146 }
            org.json.JSONArray r0 = r2.put(r0)     // Catch:{ all -> 0x0146 }
            r1.put(r3, r0)     // Catch:{ all -> 0x0146 }
            goto L_0x0148
        L_0x0146:
            int r0 = com.baidu.sofire.a.a.a
        L_0x0148:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.b(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    public static void e(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2.isDirectory()) {
                                e(file2.getAbsolutePath());
                            } else {
                                file2.delete();
                            }
                        }
                    }
                    file.delete();
                }
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
    }

    public static String a(Class<?> cls) {
        try {
            if (cls.getCanonicalName().equals(Integer.TYPE.getCanonicalName())) {
                return Integer.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Boolean.TYPE.getCanonicalName())) {
                return Boolean.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Character.TYPE.getCanonicalName())) {
                return Character.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Byte.TYPE.getCanonicalName())) {
                return Byte.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Short.TYPE.getCanonicalName())) {
                return Short.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Long.TYPE.getCanonicalName())) {
                return Long.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Float.TYPE.getCanonicalName())) {
                return Float.class.getCanonicalName();
            }
            if (cls.getCanonicalName().equals(Double.TYPE.getCanonicalName())) {
                return Double.class.getCanonicalName();
            }
            return null;
        } catch (Throwable unused) {
            int i2 = a.a;
            return null;
        }
    }

    public static Class<?> a(String str) {
        try {
            if (str.contains(Integer.class.getCanonicalName())) {
                return Integer.TYPE;
            }
            if (str.contains(Boolean.class.getCanonicalName())) {
                return Boolean.TYPE;
            }
            if (str.contains(Character.class.getCanonicalName())) {
                return Character.TYPE;
            }
            if (str.contains(Byte.class.getCanonicalName())) {
                return Byte.TYPE;
            }
            if (str.contains(Short.class.getCanonicalName())) {
                return Short.TYPE;
            }
            if (str.contains(Long.class.getCanonicalName())) {
                return Long.TYPE;
            }
            if (str.contains(Float.class.getCanonicalName())) {
                return Float.TYPE;
            }
            if (str.contains(Double.class.getCanonicalName())) {
                return Double.TYPE;
            }
            return null;
        } catch (Throwable unused) {
            int i2 = a.a;
            return null;
        }
    }

    public static String a(byte[] bArr, int i2) {
        try {
            byte[] bytes = Long.toString(System.currentTimeMillis() / 1000).getBytes();
            int length = bArr.length + bytes.length + 4;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bytes, 0, bArr2, bArr.length, bytes.length);
            int i3 = length - 4;
            int[] iArr = new int[i3];
            iArr[0] = i2;
            for (int i4 = 1; i4 < i3; i4++) {
                iArr[i4] = ((iArr[i4 - 1] * 3) + 1) % 128;
            }
            for (int i5 = 0; i5 < i3; i5++) {
                bArr2[i5] = (byte) (bArr2[i5] ^ ((byte) iArr[i5]));
            }
            byte[] bArr3 = new byte[4];
            bArr3[3] = (byte) (i2 & 255);
            bArr3[2] = (byte) ((i2 >> 8) & 255);
            bArr3[1] = (byte) ((i2 >> 16) & 255);
            bArr3[0] = (byte) (i2 >>> 24);
            System.arraycopy(bArr3, 0, bArr2, i3, 4);
            return Base64.encodeToString(bArr2, 9).replace(StringUtils.LF, "");
        } catch (Throwable unused) {
            int i6 = a.a;
            return "";
        }
    }

    public static com.baidu.sofire.h.a b(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("Common_section");
            long optLong = optJSONObject.optLong("0");
            String optString = optJSONObject.optString("10");
            int optInt = optJSONObject.optInt(BannerBaseItemInfo.TYPE_LOGIN);
            int optInt2 = optJSONObject.optInt(BannerBaseItemInfo.TYPE_SCHEME);
            int optInt3 = optJSONObject.optInt("7");
            int optInt4 = optJSONObject.optInt(BindFastRequest.BIND_FROM_INITIATIVE);
            if (optInt2 == 0) {
                optInt2 = 1;
            }
            com.baidu.sofire.h.a aVar = new com.baidu.sofire.h.a();
            aVar.e = str;
            aVar.c = optString;
            aVar.h = optInt;
            aVar.d = 3;
            aVar.f = optLong;
            aVar.g = optInt2;
            aVar.f1088i = optInt3;
            aVar.j = optInt4;
            aVar.k = "";
            return aVar;
        } catch (Throwable unused) {
            int i2 = a.a;
            return null;
        }
    }

    public static String a(Context context, int i2) {
        int length;
        try {
            String hexString = Integer.toHexString(i2);
            if (!TextUtils.isEmpty(hexString) && (length = 4 - hexString.length()) > 0) {
                StringBuilder sb = new StringBuilder();
                for (length = 4 - hexString.length(); length > 0; length--) {
                    sb.append("0");
                }
                hexString = sb.toString() + hexString;
            }
            byte[] b2 = g.b(e.a, (e(context) + hexString).toString().getBytes(), false);
            com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
            int i3 = a2.a.getInt("tk_sa_pu_cl", 0) + 1;
            a2.b.putInt("tk_sa_pu_cl", i3);
            a2.b.commit();
            String a3 = a(b2, i3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a3);
            sb2.insert(sb2.length() - 2, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
            return sb2.toString().replace(StringUtils.LF, "");
        } catch (Throwable unused) {
            int i4 = a.a;
            return "";
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:13|14|15|(3:16|17|(1:19)(5:27|28|36|37|48))|49|21|22|23|24|25|26) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:40|41|42|43) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:27|28|36|37|48) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:30|29|31|32|(4:34|35|36|37)|48) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0056 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x005e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0066 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0070 */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0062 A[SYNTHETIC, Splitter:B:34:0x0062] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:42:0x0070=Splitter:B:42:0x0070, B:24:0x0056=Splitter:B:24:0x0056, B:36:0x0066=Splitter:B:36:0x0066} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 22
            if (r0 <= r1) goto L_0x000b
            boolean r0 = android.os.Process.is64Bit()
            return r0
        L_0x000b:
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r1.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "/proc/"
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            int r2 = android.os.Process.myPid()     // Catch:{ all -> 0x0074 }
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "/maps"
            r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "/system/lib64/libc.so"
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0074 }
            r3.<init>(r1)     // Catch:{ all -> 0x0074 }
            boolean r1 = r3.exists()     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x0073
            boolean r1 = r3.isDirectory()     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x003a
            goto L_0x0073
        L_0x003a:
            r1 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x005e }
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ all -> 0x005e }
            r5.<init>(r3)     // Catch:{ all -> 0x005e }
            r4.<init>(r5)     // Catch:{ all -> 0x005e }
        L_0x0045:
            java.lang.String r1 = r4.readLine()     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0059
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x0045
            r1 = 1
            r4.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x0058
        L_0x0056:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0074 }
        L_0x0058:
            return r1
        L_0x0059:
            r4.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x0076
        L_0x005d:
            r1 = r4
        L_0x005e:
            int r2 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0076
            r1.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x0076
        L_0x0066:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0074 }
            goto L_0x0076
        L_0x0069:
            r2 = move-exception
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0072
        L_0x0070:
            int r1 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0074 }
        L_0x0072:
            throw r2     // Catch:{ all -> 0x0074 }
        L_0x0073:
            return r0
        L_0x0074:
            int r1 = com.baidu.sofire.a.a.a
        L_0x0076:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.c():boolean");
    }

    public static void b(Context context, String str) {
        String str2 = "";
        com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("0");
                if (optJSONObject != null) {
                    String str3 = str2;
                    while (optJSONObject.keys().hasNext()) {
                        str3 = String.valueOf(optJSONObject.keys().next());
                        if (!TextUtils.isEmpty(str3)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        String optString = optJSONObject.optString(str3);
                        SharedPreferences.Editor editor = a2.f;
                        editor.putString("al_da" + str3, optString);
                        a2.f.commit();
                    }
                }
            } catch (Throwable unused) {
                int i2 = a.a;
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("1");
                if (optJSONObject2 != null) {
                    while (optJSONObject2.keys().hasNext()) {
                        str2 = String.valueOf(optJSONObject2.keys().next());
                        if (!TextUtils.isEmpty(str2)) {
                            break;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String optString2 = optJSONObject2.optString(str2);
                        SharedPreferences.Editor editor2 = a2.f;
                        editor2.putString("in_da" + str2, optString2);
                        a2.f.commit();
                    }
                }
            } catch (Throwable unused2) {
                int i3 = a.a;
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("2");
                if (optJSONArray != null) {
                    a2.f.putString("li_pk_s", optJSONArray.toString());
                    a2.f.commit();
                }
            } catch (Throwable unused3) {
                int i4 = a.a;
            }
        } catch (Throwable unused4) {
            int i5 = a.a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r5 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0032, code lost:
        return false;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean a(android.content.Context r5, boolean r6) {
        /*
            java.lang.Class<com.baidu.sofire.l.c> r0 = com.baidu.sofire.l.c.class
            monitor-enter(r0)
            r1 = 0
            int r2 = l     // Catch:{ all -> 0x002f }
            r3 = -1
            r4 = 1
            if (r2 == r3) goto L_0x000f
            if (r2 != r4) goto L_0x000d
            r1 = 1
        L_0x000d:
            monitor-exit(r0)
            return r1
        L_0x000f:
            java.lang.String r2 = h((android.content.Context) r5)     // Catch:{ all -> 0x002f }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x0022
            java.lang.String r2 = r5.getPackageName()     // Catch:{ all -> 0x002f }
            boolean r5 = a((android.content.Context) r5, (java.lang.String) r2, (boolean) r4, (boolean) r6)     // Catch:{ all -> 0x002f }
            goto L_0x0026
        L_0x0022:
            boolean r5 = a((android.content.Context) r5, (java.lang.String) r2, (boolean) r1, (boolean) r6)     // Catch:{ all -> 0x002f }
        L_0x0026:
            if (r5 == 0) goto L_0x002b
            l = r4     // Catch:{ all -> 0x002f }
            goto L_0x002d
        L_0x002b:
            l = r1     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r0)
            return r5
        L_0x002f:
            int r5 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0033 }
            monitor-exit(r0)
            return r1
        L_0x0033:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.a(android.content.Context, boolean):boolean");
    }

    public static String c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(Bank.HOT_BANK_LETTER);
                if (split.length >= 4 && split[1].startsWith("c")) {
                    return split[1].substring(1);
                }
            }
        } catch (Throwable unused) {
            int i2 = a.a;
        }
        return "com.baidu.sofire.engine.EngineImpl";
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f A[Catch:{ all -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0079 A[Catch:{ all -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084 A[Catch:{ all -> 0x008f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r6, java.lang.String r7, boolean r8, boolean r9) {
        /*
            r0 = 0
            r1 = 1
            android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x0033 }
            r2.<init>()     // Catch:{ all -> 0x0033 }
            android.content.ComponentName r3 = new android.content.ComponentName     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = r6.getPackageName()     // Catch:{ all -> 0x0033 }
            java.lang.Class<com.baidu.sofire.MyService> r5 = com.baidu.sofire.MyService.class
            java.lang.String r5 = r5.getCanonicalName()     // Catch:{ all -> 0x0033 }
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0033 }
            r2.setComponent(r3)     // Catch:{ all -> 0x0033 }
            android.content.pm.PackageManager r3 = r6.getPackageManager()     // Catch:{ all -> 0x0033 }
            android.content.pm.ResolveInfo r2 = r3.resolveService(r2, r0)     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x0036
            android.content.pm.ServiceInfo r3 = r2.serviceInfo     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0036
            java.lang.String r3 = r3.processName     // Catch:{ all -> 0x0034 }
            j = r3     // Catch:{ all -> 0x0034 }
            boolean r3 = r7.equals(r3)     // Catch:{ all -> 0x0034 }
            if (r3 == 0) goto L_0x0036
            r0 = 1
            goto L_0x0036
        L_0x0033:
            r2 = 0
        L_0x0034:
            int r3 = com.baidu.sofire.a.a.a
        L_0x0036:
            if (r2 != 0) goto L_0x0047
            java.lang.String r2 = "service"
            java.lang.String r2 = a((android.content.Context) r6, (java.lang.String) r7, (java.lang.String) r2)     // Catch:{ all -> 0x008f }
            k = r2     // Catch:{ all -> 0x008f }
            boolean r2 = r7.equals(r2)     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0047
            r0 = 1
        L_0x0047:
            java.lang.String r2 = f1091i     // Catch:{ all -> 0x008f }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0059
            int r2 = android.os.Process.myPid()     // Catch:{ all -> 0x008f }
            java.lang.String r2 = a((int) r2)     // Catch:{ all -> 0x008f }
            f1091i = r2     // Catch:{ all -> 0x008f }
        L_0x0059:
            if (r9 == 0) goto L_0x0091
            java.lang.String r9 = f1091i     // Catch:{ all -> 0x008f }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x008f }
            if (r7 == 0) goto L_0x0091
            if (r0 == 0) goto L_0x0067
            if (r8 == 0) goto L_0x0091
        L_0x0067:
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x008f }
            r7.<init>()     // Catch:{ all -> 0x008f }
            java.lang.String r9 = "0"
            if (r0 != 0) goto L_0x0079
            r2 = 2
            java.lang.String r2 = java.lang.Integer.toString(r2)     // Catch:{ all -> 0x008f }
            r7.put(r9, r2)     // Catch:{ all -> 0x008f }
            goto L_0x0082
        L_0x0079:
            if (r0 != 0) goto L_0x0082
            java.lang.String r2 = java.lang.Integer.toString(r1)     // Catch:{ all -> 0x008f }
            r7.put(r9, r2)     // Catch:{ all -> 0x008f }
        L_0x0082:
            if (r8 == 0) goto L_0x0089
            java.lang.String r8 = "1"
            r7.put(r8, r9)     // Catch:{ all -> 0x008f }
        L_0x0089:
            java.lang.String r8 = "1003140"
            a((android.content.Context) r6, (java.lang.String) r8, (java.util.Map<java.lang.String, java.lang.Object>) r7, (boolean) r1)     // Catch:{ all -> 0x008f }
            goto L_0x0091
        L_0x008f:
            int r6 = com.baidu.sofire.a.a.a
        L_0x0091:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.a(android.content.Context, java.lang.String, boolean, boolean):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:114|115|156) */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r3 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:?, code lost:
        r3 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01d6, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r3 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:114:0x018e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:132:0x01d2 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:96:0x014b */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041 A[Catch:{ all -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043 A[Catch:{ all -> 0x01d7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "provider"
            r1 = 0
            java.lang.String r2 = r13.getPackageName()     // Catch:{ all -> 0x01d7 }
            r3 = 3
            android.content.Context r2 = r13.createPackageContext(r2, r3)     // Catch:{ all -> 0x01d7 }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ all -> 0x01d7 }
            java.lang.String r3 = "AndroidManifest.xml"
            android.content.res.XmlResourceParser r2 = r2.openXmlResourceParser(r3)     // Catch:{ all -> 0x01d7 }
            if (r2 == 0) goto L_0x01d9
        L_0x0018:
            int r3 = r2.next()     // Catch:{ all -> 0x01d7 }
            r4 = 2
            r5 = 1
            if (r3 == r4) goto L_0x0023
            if (r3 == r5) goto L_0x0023
            goto L_0x0018
        L_0x0023:
            if (r3 == r4) goto L_0x0026
            return r1
        L_0x0026:
            java.lang.String r3 = r2.getName()     // Catch:{ all -> 0x01d7 }
            java.lang.String r6 = "manifest"
            boolean r3 = r3.equals(r6)     // Catch:{ all -> 0x01d7 }
            if (r3 != 0) goto L_0x0033
            return r1
        L_0x0033:
            java.lang.String r3 = "package"
            java.lang.String r3 = r2.getAttributeValue(r1, r3)     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x01d6
            int r6 = r3.length()     // Catch:{ all -> 0x01d7 }
            if (r6 != 0) goto L_0x0043
            goto L_0x01d6
        L_0x0043:
            int r6 = r3.length()     // Catch:{ all -> 0x01d7 }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 1
        L_0x004b:
            if (r8 >= r6) goto L_0x0092
            char r11 = r3.charAt(r8)     // Catch:{ all -> 0x01d7 }
            r12 = 97
            if (r11 < r12) goto L_0x0059
            r12 = 122(0x7a, float:1.71E-43)
            if (r11 <= r12) goto L_0x0061
        L_0x0059:
            r12 = 65
            if (r11 < r12) goto L_0x0063
            r12 = 90
            if (r11 > r12) goto L_0x0063
        L_0x0061:
            r10 = 0
            goto L_0x0078
        L_0x0063:
            if (r10 != 0) goto L_0x0072
            r12 = 48
            if (r11 < r12) goto L_0x006d
            r12 = 57
            if (r11 <= r12) goto L_0x0078
        L_0x006d:
            r12 = 95
            if (r11 != r12) goto L_0x0072
            goto L_0x0078
        L_0x0072:
            r9 = 46
            if (r11 != r9) goto L_0x007b
            r9 = 1
            r10 = 1
        L_0x0078:
            int r8 = r8 + 1
            goto L_0x004b
        L_0x007b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d7 }
            r6.<init>()     // Catch:{ all -> 0x01d7 }
            java.lang.String r7 = "bad character '"
            r6.append(r7)     // Catch:{ all -> 0x01d7 }
            r6.append(r11)     // Catch:{ all -> 0x01d7 }
            java.lang.String r7 = "'"
            r6.append(r7)     // Catch:{ all -> 0x01d7 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x01d7 }
            goto L_0x0098
        L_0x0092:
            if (r9 != 0) goto L_0x0097
            java.lang.String r6 = "must have at least one '.' separator"
            goto L_0x0098
        L_0x0097:
            r6 = r1
        L_0x0098:
            if (r6 == 0) goto L_0x00a3
            java.lang.String r6 = "android"
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x01d7 }
            if (r3 != 0) goto L_0x00a3
            return r1
        L_0x00a3:
            boolean r3 = r15.equals(r0)     // Catch:{ all -> 0x01d7 }
            java.lang.String r6 = "receiver"
            java.lang.String r7 = "service"
            if (r3 == 0) goto L_0x00b4
            java.lang.Class<com.baidu.sofire.MyProvider> r15 = com.baidu.sofire.MyProvider.class
            java.lang.String r15 = r15.getCanonicalName()     // Catch:{ all -> 0x01d7 }
            goto L_0x00cf
        L_0x00b4:
            boolean r3 = r15.equals(r7)     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x00c1
            java.lang.Class<com.baidu.sofire.MyService> r15 = com.baidu.sofire.MyService.class
            java.lang.String r15 = r15.getCanonicalName()     // Catch:{ all -> 0x01d7 }
            goto L_0x00cf
        L_0x00c1:
            boolean r15 = r15.equals(r6)     // Catch:{ all -> 0x01d7 }
            if (r15 == 0) goto L_0x00ce
            java.lang.Class<com.baidu.sofire.MyReceiver> r15 = com.baidu.sofire.MyReceiver.class
            java.lang.String r15 = r15.getCanonicalName()     // Catch:{ all -> 0x01d7 }
            goto L_0x00cf
        L_0x00ce:
            r15 = r1
        L_0x00cf:
            int r3 = r2.next()     // Catch:{ all -> 0x01d7 }
            if (r3 == r5) goto L_0x01d9
            if (r3 == r4) goto L_0x00d8
            goto L_0x00cf
        L_0x00d8:
            java.lang.String r3 = r2.getName()     // Catch:{ all -> 0x01d7 }
            boolean r8 = r0.equals(r3)     // Catch:{ all -> 0x01d7 }
            java.lang.String r9 = ":"
            java.lang.String r10 = "process"
            java.lang.String r11 = "name"
            java.lang.String r12 = "http://schemas.android.com/apk/res/android"
            if (r8 == 0) goto L_0x014e
            java.lang.String r3 = r2.getAttributeValue(r12, r11)     // Catch:{ all -> 0x014b }
            boolean r3 = r3.equals(r15)     // Catch:{ all -> 0x014b }
            if (r3 == 0) goto L_0x00cf
            java.lang.String r3 = "multiprocess"
            java.lang.String r3 = r2.getAttributeValue(r12, r3)     // Catch:{ all -> 0x014b }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x014b }
            if (r8 != 0) goto L_0x010d
            java.lang.String r8 = "true"
            java.lang.String r3 = r3.toLowerCase()     // Catch:{ all -> 0x014b }
            boolean r3 = r8.equals(r3)     // Catch:{ all -> 0x014b }
            if (r3 == 0) goto L_0x010d
            return r1
        L_0x010d:
            java.lang.String r3 = "authorities"
            java.lang.String r3 = r2.getAttributeValue(r12, r3)     // Catch:{ all -> 0x014b }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x014b }
            if (r8 != 0) goto L_0x014a
            boolean r3 = r14.equals(r3)     // Catch:{ all -> 0x014b }
            if (r3 != 0) goto L_0x0120
            return r1
        L_0x0120:
            java.lang.String r3 = r2.getAttributeValue(r12, r10)     // Catch:{ all -> 0x014b }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x014b }
            if (r8 != 0) goto L_0x0145
            boolean r8 = r3.startsWith(r9)     // Catch:{ all -> 0x014b }
            if (r8 == 0) goto L_0x0144
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x014b }
            r8.<init>()     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r13.getPackageName()     // Catch:{ all -> 0x014b }
            r8.append(r9)     // Catch:{ all -> 0x014b }
            r8.append(r3)     // Catch:{ all -> 0x014b }
            java.lang.String r13 = r8.toString()     // Catch:{ all -> 0x014b }
            return r13
        L_0x0144:
            return r3
        L_0x0145:
            java.lang.String r13 = r13.getPackageName()     // Catch:{ all -> 0x014b }
            return r13
        L_0x014a:
            return r1
        L_0x014b:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x01d7 }
            goto L_0x00cf
        L_0x014e:
            boolean r8 = r7.equals(r3)     // Catch:{ all -> 0x01d7 }
            if (r8 == 0) goto L_0x0192
            java.lang.String r3 = r2.getAttributeValue(r12, r11)     // Catch:{ all -> 0x018e }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x018e }
            if (r8 != 0) goto L_0x00cf
            boolean r3 = r3.equals(r15)     // Catch:{ all -> 0x018e }
            if (r3 == 0) goto L_0x00cf
            java.lang.String r3 = r2.getAttributeValue(r12, r10)     // Catch:{ all -> 0x018e }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x018e }
            if (r8 != 0) goto L_0x0189
            boolean r8 = r3.startsWith(r9)     // Catch:{ all -> 0x018e }
            if (r8 == 0) goto L_0x0188
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            r8.<init>()     // Catch:{ all -> 0x018e }
            java.lang.String r9 = r13.getPackageName()     // Catch:{ all -> 0x018e }
            r8.append(r9)     // Catch:{ all -> 0x018e }
            r8.append(r3)     // Catch:{ all -> 0x018e }
            java.lang.String r13 = r8.toString()     // Catch:{ all -> 0x018e }
            return r13
        L_0x0188:
            return r3
        L_0x0189:
            java.lang.String r13 = r13.getPackageName()     // Catch:{ all -> 0x018e }
            return r13
        L_0x018e:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x01d7 }
            goto L_0x00cf
        L_0x0192:
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x00cf
            java.lang.String r3 = r2.getAttributeValue(r12, r11)     // Catch:{ all -> 0x01d2 }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x01d2 }
            if (r8 != 0) goto L_0x00cf
            boolean r3 = r3.equals(r15)     // Catch:{ all -> 0x01d2 }
            if (r3 == 0) goto L_0x00cf
            java.lang.String r3 = r2.getAttributeValue(r12, r10)     // Catch:{ all -> 0x01d2 }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x01d2 }
            if (r8 != 0) goto L_0x01cd
            boolean r8 = r3.startsWith(r9)     // Catch:{ all -> 0x01d2 }
            if (r8 == 0) goto L_0x01cc
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d2 }
            r8.<init>()     // Catch:{ all -> 0x01d2 }
            java.lang.String r9 = r13.getPackageName()     // Catch:{ all -> 0x01d2 }
            r8.append(r9)     // Catch:{ all -> 0x01d2 }
            r8.append(r3)     // Catch:{ all -> 0x01d2 }
            java.lang.String r13 = r8.toString()     // Catch:{ all -> 0x01d2 }
            return r13
        L_0x01cc:
            return r3
        L_0x01cd:
            java.lang.String r13 = r13.getPackageName()     // Catch:{ all -> 0x01d2 }
            return r13
        L_0x01d2:
            int r3 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x01d7 }
            goto L_0x00cf
        L_0x01d6:
            return r1
        L_0x01d7:
            int r13 = com.baidu.sofire.a.a.a
        L_0x01d9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean a(File file) {
        return file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0078 A[LOOP:0: B:10:0x0025->B:46:0x0078, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(java.lang.Object r10, java.lang.String r11, java.lang.Class<?>[] r12, java.lang.Object... r13) throws java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        /*
            if (r10 == 0) goto L_0x0099
            boolean r0 = android.text.TextUtils.isEmpty(r11)
            if (r0 != 0) goto L_0x0099
            if (r12 == 0) goto L_0x0019
            if (r13 == 0) goto L_0x0019
            int r0 = r12.length
            int r1 = r13.length
            if (r0 != r1) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.lang.NoSuchMethodException r10 = new java.lang.NoSuchMethodException
            java.lang.String r11 = "paramTypes or args fail"
            r10.<init>(r11)
            throw r10
        L_0x0019:
            java.lang.Class r0 = r10.getClass()
            java.lang.reflect.Method[] r0 = r0.getDeclaredMethods()
            r1 = 0
            int r2 = r0.length
            r3 = 0
            r4 = 0
        L_0x0025:
            if (r4 >= r2) goto L_0x007b
            r5 = r0[r4]
            java.lang.String r6 = r5.getName()
            boolean r6 = r11.equals(r6)
            if (r6 != 0) goto L_0x0034
            goto L_0x0071
        L_0x0034:
            java.lang.Class[] r6 = r5.getParameterTypes()
            if (r6 == 0) goto L_0x003d
            int r7 = r6.length
            if (r7 != 0) goto L_0x0043
        L_0x003d:
            if (r12 == 0) goto L_0x0073
            int r7 = r12.length
            if (r7 != 0) goto L_0x0043
            goto L_0x0073
        L_0x0043:
            if (r12 == 0) goto L_0x0048
            int r7 = r12.length
            if (r7 != 0) goto L_0x004e
        L_0x0048:
            if (r6 == 0) goto L_0x004e
            int r7 = r6.length
            if (r7 <= 0) goto L_0x004e
            goto L_0x0071
        L_0x004e:
            if (r6 == 0) goto L_0x0053
            int r7 = r6.length
            if (r7 != 0) goto L_0x0059
        L_0x0053:
            if (r12 == 0) goto L_0x0059
            int r7 = r12.length
            if (r7 <= 0) goto L_0x0059
            goto L_0x0071
        L_0x0059:
            if (r6 == 0) goto L_0x0071
            if (r12 != 0) goto L_0x005e
            goto L_0x0071
        L_0x005e:
            int r7 = r6.length
            int r8 = r12.length
            if (r7 == r8) goto L_0x0063
            goto L_0x0071
        L_0x0063:
            r7 = 0
        L_0x0064:
            int r8 = r6.length
            if (r7 >= r8) goto L_0x0073
            r8 = r6[r7]
            r9 = r12[r7]
            if (r8 == r9) goto L_0x006e
            goto L_0x0071
        L_0x006e:
            int r7 = r7 + 1
            goto L_0x0064
        L_0x0071:
            r6 = 0
            goto L_0x0074
        L_0x0073:
            r6 = 1
        L_0x0074:
            if (r6 == 0) goto L_0x0078
            r1 = r5
            goto L_0x007b
        L_0x0078:
            int r4 = r4 + 1
            goto L_0x0025
        L_0x007b:
            if (r1 == 0) goto L_0x0082
            java.lang.Object r10 = r1.invoke(r10, r13)
            return r10
        L_0x0082:
            java.lang.NoSuchMethodException r10 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "cannot find method in target methodName="
            r12.append(r13)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.<init>(r11)
            throw r10
        L_0x0099:
            java.lang.NoSuchMethodException r12 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r0 = "object="
            r13.append(r0)
            r13.append(r10)
            java.lang.String r10 = ", methodName="
            r13.append(r10)
            r13.append(r11)
            java.lang.String r10 = r13.toString()
            r12.<init>(r10)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.a(java.lang.Object, java.lang.String, java.lang.Class[], java.lang.Object[]):java.lang.Object");
    }

    public static void a(String str, boolean z) {
        a("771", str);
        if (z) {
            a("771", new File(str).getParentFile().getAbsolutePath());
        }
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.length() != 3 || !new File(str2).exists()) {
            return false;
        }
        try {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("chmod " + str + " " + str2 + StringUtils.LF).waitFor();
            return true;
        } catch (Throwable unused) {
            int i2 = a.a;
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0078 A[SYNTHETIC, Splitter:B:19:0x0078] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.Object> r10, boolean r11) {
        /*
            java.lang.String r0 = ""
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 != 0) goto L_0x009d
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x009b }
            r1.<init>()     // Catch:{ all -> 0x009b }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x009b }
            r2.<init>()     // Catch:{ all -> 0x009b }
            java.lang.String r3 = "0"
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009b }
            r2.put(r3, r4)     // Catch:{ all -> 0x009b }
            java.lang.String r3 = "1"
            r2.put(r3, r0)     // Catch:{ all -> 0x009b }
            java.lang.String r3 = "2"
            r2.put(r3, r0)     // Catch:{ all -> 0x009b }
            java.lang.String[] r0 = p(r8)     // Catch:{ all -> 0x009b }
            int r3 = r0.length     // Catch:{ all -> 0x009b }
            r4 = 2
            r5 = 1
            java.lang.String r6 = "3"
            r7 = 0
            if (r3 != r4) goto L_0x0044
            r3 = r0[r7]     // Catch:{ all -> 0x009b }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x009b }
            if (r3 != 0) goto L_0x0044
            r3 = r0[r5]     // Catch:{ all -> 0x009b }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x009b }
            if (r3 != 0) goto L_0x0044
            r0 = r0[r7]     // Catch:{ all -> 0x009b }
            goto L_0x0045
        L_0x0044:
            r0 = r6
        L_0x0045:
            r2.put(r6, r0)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = "4"
            r2.put(r0, r7)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = "5"
            r2.put(r0, r7)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = "6"
            r2.put(r0, r5)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = "7"
            r2.put(r0, r7)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = "8"
            java.lang.String r3 = "sofire"
            r2.put(r0, r3)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = "9"
            java.lang.String r3 = "3.6.7.0"
            r2.put(r0, r3)     // Catch:{ all -> 0x009b }
            java.lang.String r0 = "10"
            r2.put(r0, r9)     // Catch:{ all -> 0x009b }
            java.lang.String r9 = "Common_section"
            r1.put(r9, r2)     // Catch:{ all -> 0x009b }
            java.lang.String r9 = "Module_section"
            if (r10 == 0) goto L_0x0087
            int r0 = r10.size()     // Catch:{ all -> 0x009b }
            if (r0 <= 0) goto L_0x0087
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x009b }
            r0.<init>(r10)     // Catch:{ all -> 0x009b }
            r1.put(r9, r0)     // Catch:{ all -> 0x009b }
            goto L_0x008f
        L_0x0087:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x009b }
            r10.<init>()     // Catch:{ all -> 0x009b }
            r1.put(r9, r10)     // Catch:{ all -> 0x009b }
        L_0x008f:
            com.baidu.sofire.rp.Report r8 = com.baidu.sofire.rp.Report.getInstance(r8)     // Catch:{ all -> 0x009b }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x009b }
            r8.s(r9, r11)     // Catch:{ all -> 0x009b }
            goto L_0x009d
        L_0x009b:
            int r8 = com.baidu.sofire.a.a.a
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.a(android.content.Context, java.lang.String, java.util.Map, boolean):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r9 = com.baidu.sofire.a.a.a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x007b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(android.content.Context r8, com.baidu.sofire.f.a r9, java.lang.String r10, boolean r11) {
        /*
            java.lang.String r0 = "0"
            java.lang.String r1 = r9.a
            java.lang.String r2 = r9.c
            if (r11 == 0) goto L_0x000b
            java.lang.String r11 = r9.d
            goto L_0x000d
        L_0x000b:
            java.lang.String r11 = r9.e
        L_0x000d:
            java.lang.String r3 = r9.b
            java.lang.String r9 = r9.f
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0088 }
            r5.<init>()     // Catch:{ all -> 0x0088 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0088 }
            r5.put(r0, r6)     // Catch:{ all -> 0x0088 }
            java.lang.String r6 = "1"
            r5.put(r6, r9)     // Catch:{ all -> 0x0088 }
            java.lang.String r9 = "2"
            r5.put(r9, r0)     // Catch:{ all -> 0x0088 }
            java.lang.String[] r8 = p(r8)     // Catch:{ all -> 0x0088 }
            int r9 = r8.length     // Catch:{ all -> 0x0088 }
            r0 = 2
            java.lang.String r6 = "3"
            r7 = 0
            if (r9 != r0) goto L_0x003d
            r8 = r8[r7]     // Catch:{ all -> 0x0088 }
            r5.put(r6, r8)     // Catch:{ all -> 0x0088 }
            goto L_0x0040
        L_0x003d:
            r5.put(r6, r6)     // Catch:{ all -> 0x0088 }
        L_0x0040:
            java.lang.String r8 = "4"
            r5.put(r8, r7)     // Catch:{ all -> 0x0088 }
            java.lang.String r8 = "5"
            r5.put(r8, r7)     // Catch:{ all -> 0x0088 }
            java.lang.String r8 = "6"
            r9 = 1
            r5.put(r8, r9)     // Catch:{ all -> 0x0088 }
            java.lang.String r8 = "7"
            r5.put(r8, r7)     // Catch:{ all -> 0x0088 }
            java.lang.String r8 = "8"
            r5.put(r8, r1)     // Catch:{ all -> 0x0088 }
            java.lang.String r8 = "9"
            r5.put(r8, r2)     // Catch:{ all -> 0x0088 }
            java.lang.String r8 = "10"
            r5.put(r8, r11)     // Catch:{ all -> 0x0088 }
            java.lang.String r8 = "11"
            r5.put(r8, r3)     // Catch:{ all -> 0x0088 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x0088 }
            r8.<init>()     // Catch:{ all -> 0x0088 }
            boolean r9 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0088 }
            if (r9 != 0) goto L_0x007d
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ all -> 0x007b }
            r9.<init>(r10)     // Catch:{ all -> 0x007b }
            r8 = r9
            goto L_0x007d
        L_0x007b:
            int r9 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x0088 }
        L_0x007d:
            java.lang.String r9 = "Common_section"
            r4.put(r9, r5)     // Catch:{ all -> 0x0088 }
            java.lang.String r9 = "Module_section"
            r4.put(r9, r8)     // Catch:{ all -> 0x0088 }
            goto L_0x008a
        L_0x0088:
            int r8 = com.baidu.sofire.a.a.a
        L_0x008a:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.a(android.content.Context, com.baidu.sofire.f.a, java.lang.String, boolean):org.json.JSONObject");
    }

    public static String a(int i2) {
        String str;
        String str2 = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                str = Application.getProcessName();
                try {
                    if (!TextUtils.isEmpty(str)) {
                        return str.trim();
                    }
                } catch (Throwable unused) {
                    str2 = str;
                    int i3 = a.a;
                    return str2;
                }
            } else {
                str = null;
            }
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            if (invoke instanceof String) {
                str = (String) invoke;
            }
            if (!TextUtils.isEmpty(str)) {
                return str.trim();
            }
            str2 = str;
            str2 = h(String.format("/proc/%d/cmdline", new Object[]{Integer.valueOf(i2)}));
            if (!TextUtils.isEmpty(str2)) {
                return str2.trim();
            }
            return str2;
        } catch (Throwable unused2) {
            int i32 = a.a;
            return str2;
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, boolean z) {
        com.baidu.sofire.f.a aVar;
        com.baidu.sofire.f.a aVar2 = new com.baidu.sofire.f.a();
        aVar2.a = str;
        aVar2.b = str2;
        aVar2.c = str3;
        aVar2.d = str4;
        aVar2.e = str5;
        Map<String, String> map = com.baidu.sofire.b.a.y;
        if (!(map == null || map.get(str2) == null)) {
            aVar2.f = com.baidu.sofire.b.a.y.get(str2);
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
            List<com.baidu.sofire.f.a> c2 = a2.c();
            if (c2 == null || !c2.contains(aVar2)) {
                String string = a2.e.getString("re_con", "");
                SharedPreferences.Editor editor = a2.f;
                editor.putString("re_con", string + "||" + com.baidu.sofire.f.a.a(aVar2));
                a2.f.commit();
                String str6 = aVar2.e;
                SharedPreferences sharedPreferences = a2.e;
                if (!sharedPreferences.getBoolean("re_net_ins_" + str6, false)) {
                    d a3 = d.a(context);
                    b bVar = a3.b;
                    com.baidu.sofire.j.a aVar3 = bVar.b;
                    String str7 = aVar2.e;
                    SharedPreferences sharedPreferences2 = aVar3.e;
                    String string2 = sharedPreferences2.getString("al_da" + str7, "");
                    String str8 = aVar2.e;
                    long currentTimeMillis = System.currentTimeMillis();
                    String jSONObject = a(bVar.c, aVar2, string2, false).toString();
                    com.baidu.sofire.g.a a4 = com.baidu.sofire.g.a.a(bVar.c);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("b", str8);
                    contentValues.put("c", 1);
                    contentValues.put("d", Long.valueOf(currentTimeMillis));
                    contentValues.put("e", 0);
                    contentValues.put(g.a, 1);
                    contentValues.put("f", 0);
                    contentValues.put(i.a, 0);
                    contentValues.put(com.baidu.wallet.paysdk.b.j.q, (String) null);
                    try {
                        jSONObject = Base64.encodeToString(F.getInstance().ae(jSONObject.getBytes(), "xVOTuxgN3lkRN2v4".getBytes(com.baidu.apollon.heartbeat.a.h)), 0);
                    } catch (Exception unused) {
                        int i2 = a.a;
                    }
                    contentValues.put("h", jSONObject);
                    try {
                        a4.b.insert("r", (String) null, contentValues);
                    } catch (Throwable unused2) {
                        int i3 = a.a;
                    }
                    com.baidu.sofire.j.a aVar4 = bVar.b;
                    String str9 = aVar2.e;
                    SharedPreferences.Editor editor2 = aVar4.f;
                    editor2.putBoolean("re_net_ins_" + str9, true);
                    aVar4.f.commit();
                    a3.b.a(aVar2);
                }
                d.a(context).a(true);
                if (z) {
                    d.a(context).a();
                    return;
                }
                return;
            }
            int indexOf = c2.indexOf(aVar2);
            if (!(indexOf == -1 || (aVar = c2.get(indexOf)) == null)) {
                if (TextUtils.isEmpty(aVar2.f) && !TextUtils.isEmpty(aVar.f)) {
                    aVar2.f = aVar.f;
                }
                a2.f.putString("re_con", a2.e.getString("re_con", "").replace(com.baidu.sofire.f.a.a(aVar), com.baidu.sofire.f.a.a(aVar2)));
                a2.f.commit();
            }
            if (z) {
                d.a(context).a();
            }
        } else if (z) {
            d.a(context).a();
        }
    }

    @SuppressLint({"WrongConstant"})
    public static void a(Context context, long j2) {
        PendingIntent pendingIntent;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
        intent.setClassName(context, MyService.class.getCanonicalName());
        intent.setPackage(context.getPackageName());
        intent.addCategory("com.baidu.category.SOFIRE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("from_plugin_package", context.getPackageName());
        intent.putExtra("target_class", Receiver.class.getCanonicalName());
        intent.putExtra("target_method", "handleDailyWork");
        if (i(context)) {
            pendingIntent = PendingIntent.getService(context, 101, intent, 201326592);
        } else {
            pendingIntent = PendingIntent.getService(context, 101, intent, 134217728);
        }
        try {
            alarmManager.cancel(pendingIntent);
        } catch (Throwable unused) {
            int i2 = a.a;
        }
        try {
            alarmManager.set(1, System.currentTimeMillis() + j2, pendingIntent);
        } catch (Throwable unused2) {
            int i3 = a.a;
        }
    }

    public static boolean a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            String str = context.getPackageName() + ".permission." + "sofire" + ".RECEIVE";
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(broadcastReceiver, intentFilter, str, (Handler) null, 4);
                return true;
            }
            context.registerReceiver(broadcastReceiver, intentFilter, str, (Handler) null);
            return true;
        } catch (Throwable unused) {
            int i2 = a.a;
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[Catch:{ all -> 0x0055 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035 A[Catch:{ all -> 0x0055 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r5, org.json.JSONObject r6) {
        /*
            com.baidu.sofire.j.a r0 = com.baidu.sofire.j.a.a((android.content.Context) r5)     // Catch:{ all -> 0x0055 }
            java.lang.String[] r1 = c((android.content.Context) r5)     // Catch:{ all -> 0x0055 }
            android.content.SharedPreferences r0 = r0.a     // Catch:{ all -> 0x0055 }
            java.lang.String r2 = "appinv_ky"
            r3 = 1
            int r0 = r0.getInt(r2, r3)     // Catch:{ all -> 0x0055 }
            r2 = 0
            if (r0 != r3) goto L_0x0029
            int r0 = r1.length     // Catch:{ all -> 0x0055 }
            r4 = 2
            if (r0 != r4) goto L_0x002a
            r0 = r1[r2]     // Catch:{ all -> 0x0055 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x002a
            r0 = r1[r3]     // Catch:{ all -> 0x0055 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            if (r3 == 0) goto L_0x0057
            java.lang.String r0 = "2"
            org.json.JSONObject r6 = r6.optJSONObject(r0)     // Catch:{ all -> 0x0055 }
            if (r6 != 0) goto L_0x0035
            return
        L_0x0035:
            java.lang.String r0 = "0"
            java.lang.String r0 = r6.optString(r0)     // Catch:{ all -> 0x0055 }
            java.lang.String r1 = "1"
            java.lang.String r6 = r6.optString(r1)     // Catch:{ all -> 0x0055 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0057
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0057
            com.baidu.sofire.b.c r5 = com.baidu.sofire.b.c.a((android.content.Context) r5)     // Catch:{ all -> 0x0055 }
            r5.b(r0, r6)     // Catch:{ all -> 0x0055 }
            goto L_0x0057
        L_0x0055:
            int r5 = com.baidu.sofire.a.a.a
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.a(android.content.Context, org.json.JSONObject):void");
    }

    public static void a(Context context, JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    int optInt = optJSONObject.optInt(t.a);
                    String optString = optJSONObject.optString("p");
                    String optString2 = optJSONObject.optString("k");
                    String optString3 = optJSONObject.optString(v.d);
                    if (optInt > 0 && !TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        a2.getClass();
                        if (optInt > 0) {
                            try {
                                if (!TextUtils.isEmpty(optString)) {
                                    if (!TextUtils.isEmpty(optString2)) {
                                        SharedPreferences.Editor edit = a2.a(optString).edit();
                                        if (optInt == 1) {
                                            edit.putString(optString2, optString3).commit();
                                        } else if (optInt == 2) {
                                            edit.putInt(optString2, Integer.valueOf(optString3).intValue()).commit();
                                        } else if (optInt != 3) {
                                            if (optInt == 4) {
                                                edit.putFloat(optString2, Float.valueOf(optString3).floatValue()).commit();
                                            } else if (optInt == 5) {
                                                edit.putLong(optString2, Long.valueOf(optString3).longValue()).commit();
                                            }
                                        } else if (t.a.equalsIgnoreCase(optString3)) {
                                            edit.putBoolean(optString2, true).commit();
                                        } else if ("f".equalsIgnoreCase(optString3)) {
                                            edit.putBoolean(optString2, false).commit();
                                        }
                                    }
                                }
                            } catch (Throwable unused) {
                                int i3 = a.a;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(Context context, String str, int i2) {
        if (i2 >= 0) {
            try {
                File file = new File(new File(f(context), "sofire_tmp"), ".tmp");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, str);
                if (i2 > 0) {
                    if (file2.exists()) {
                        file2.delete();
                    }
                } else if (i2 == 0 && !file2.exists()) {
                    file2.createNewFile();
                }
            } catch (Throwable unused) {
                int i3 = a.a;
            }
        }
    }

    public static boolean a(Context context, String str) {
        try {
            File file = new File(new File(f(context), "sofire_tmp"), ".tmp");
            if (!file.exists()) {
                file.mkdirs();
            }
            return !new File(file, str).exists();
        } catch (Throwable unused) {
            int i2 = a.a;
            return false;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:13|(0)|19|20|27|28|29|(0)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r7 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0030, code lost:
        if (r7 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0116, code lost:
        if (r6.length > r2.length) goto L_0x0118;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:135:0x01d7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b A[SYNTHETIC, Splitter:B:17:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x003e A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0040 A[SYNTHETIC, Splitter:B:34:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011d A[SYNTHETIC, Splitter:B:84:0x011d] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0138 A[Catch:{ all -> 0x01d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x013c A[Catch:{ all -> 0x01d7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized org.json.JSONArray a(android.content.Context r18) {
        /*
            java.lang.Class<com.baidu.sofire.l.c> r1 = com.baidu.sofire.l.c.class
            monitor-enter(r1)
            r2 = 0
            com.baidu.sofire.j.a r3 = com.baidu.sofire.j.a.a((android.content.Context) r18)     // Catch:{ all -> 0x01d7 }
            java.lang.String r0 = "sofire_local.cfg"
            java.lang.String r4 = "local"
            java.lang.String r5 = ""
            java.util.Properties r6 = new java.util.Properties     // Catch:{ all -> 0x0036 }
            r6.<init>()     // Catch:{ all -> 0x0036 }
            android.content.res.AssetManager r7 = r18.getAssets()     // Catch:{ IOException -> 0x002f, all -> 0x0027 }
            java.io.InputStream r7 = r7.open(r0)     // Catch:{ IOException -> 0x002f, all -> 0x0027 }
            r6.load(r7)     // Catch:{ IOException -> 0x0030, all -> 0x0025 }
            java.lang.String r5 = r6.getProperty(r4)     // Catch:{ IOException -> 0x0030, all -> 0x0025 }
            if (r7 == 0) goto L_0x0038
            goto L_0x0032
        L_0x0025:
            r0 = move-exception
            goto L_0x0029
        L_0x0027:
            r0 = move-exception
            r7 = r2
        L_0x0029:
            if (r7 == 0) goto L_0x002e
            r7.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            throw r0     // Catch:{ all -> 0x0036 }
        L_0x002f:
            r7 = r2
        L_0x0030:
            if (r7 == 0) goto L_0x0038
        L_0x0032:
            r7.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x0038
        L_0x0036:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x01d7 }
        L_0x0038:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x01d7 }
            if (r0 == 0) goto L_0x0040
            monitor-exit(r1)
            return r2
        L_0x0040:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x01d7 }
            r0.<init>(r5)     // Catch:{ all -> 0x01d7 }
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r4 = f1092o     // Catch:{ all -> 0x01d7 }
            if (r4 != 0) goto L_0x0051
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x01d7 }
            r4.<init>()     // Catch:{ all -> 0x01d7 }
            f1092o = r4     // Catch:{ all -> 0x01d7 }
            goto L_0x0054
        L_0x0051:
            r4.clear()     // Catch:{ all -> 0x01d7 }
        L_0x0054:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x01d7 }
            r4.<init>()     // Catch:{ all -> 0x01d7 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x01d7 }
            r5.<init>()     // Catch:{ all -> 0x01d7 }
            r7 = 0
        L_0x005f:
            int r8 = r0.length()     // Catch:{ all -> 0x01d7 }
            if (r7 >= r8) goto L_0x014a
            org.json.JSONObject r8 = r0.optJSONObject(r7)     // Catch:{ all -> 0x01d7 }
            java.lang.String r9 = "pkgname"
            java.lang.String r9 = r8.optString(r9)     // Catch:{ all -> 0x01d7 }
            java.lang.String r10 = "version"
            java.lang.String r10 = r8.optString(r10)     // Catch:{ all -> 0x01d7 }
            java.lang.String r11 = "id"
            int r11 = r8.optInt(r11)     // Catch:{ all -> 0x01d7 }
            if (r11 <= 0) goto L_0x0084
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x01d7 }
            r5.add(r12)     // Catch:{ all -> 0x01d7 }
        L_0x0084:
            java.lang.String r12 = "md5"
            java.lang.String r8 = r8.optString(r12)     // Catch:{ all -> 0x01d7 }
            boolean r12 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x01d7 }
            if (r12 != 0) goto L_0x0145
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x01d7 }
            if (r12 != 0) goto L_0x0145
            boolean r12 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x01d7 }
            if (r12 != 0) goto L_0x0145
            if (r11 > 0) goto L_0x00a0
            goto L_0x0145
        L_0x00a0:
            android.content.SharedPreferences r12 = r3.a     // Catch:{ all -> 0x01d7 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d7 }
            r13.<init>()     // Catch:{ all -> 0x01d7 }
            java.lang.String r14 = "g_l_l_p_v_"
            r13.append(r14)     // Catch:{ all -> 0x01d7 }
            r13.append(r11)     // Catch:{ all -> 0x01d7 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x01d7 }
            java.lang.String r14 = ""
            java.lang.String r12 = r12.getString(r13, r14)     // Catch:{ all -> 0x01d7 }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x01d7 }
            if (r13 != 0) goto L_0x00c7
            boolean r12 = b((java.lang.String) r10, (java.lang.String) r12)     // Catch:{ all -> 0x01d7 }
            if (r12 != 0) goto L_0x00c7
            r12 = 1
            goto L_0x00c8
        L_0x00c7:
            r12 = 0
        L_0x00c8:
            if (r12 != 0) goto L_0x0124
            com.baidu.sofire.c.a r13 = com.baidu.sofire.c.a.a((android.content.Context) r18)     // Catch:{ all -> 0x01d7 }
            com.baidu.sofire.core.ApkInfo r13 = r13.b((int) r11)     // Catch:{ all -> 0x01d7 }
            if (r13 == 0) goto L_0x0124
            java.lang.String r15 = r13.versionName     // Catch:{ all -> 0x01d7 }
            boolean r16 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x01d7 }
            if (r16 != 0) goto L_0x011a
            boolean r16 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x01d7 }
            if (r16 == 0) goto L_0x00e3
            goto L_0x011a
        L_0x00e3:
            java.lang.String r6 = "\\."
            java.lang.String[] r6 = r10.split(r6)     // Catch:{ all -> 0x011a }
            java.lang.String r2 = "\\."
            java.lang.String[] r2 = r15.split(r2)     // Catch:{ all -> 0x011a }
            r15 = 0
        L_0x00f0:
            int r14 = r6.length     // Catch:{ all -> 0x011a }
            if (r15 >= r14) goto L_0x0114
            int r14 = r2.length     // Catch:{ all -> 0x011a }
            if (r15 >= r14) goto L_0x0114
            r14 = r6[r15]     // Catch:{ all -> 0x011a }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ all -> 0x011a }
            int r14 = r14.intValue()     // Catch:{ all -> 0x011a }
            r17 = r2[r15]     // Catch:{ all -> 0x011a }
            java.lang.Integer r17 = java.lang.Integer.valueOf(r17)     // Catch:{ all -> 0x011a }
            int r17 = r17.intValue()     // Catch:{ all -> 0x011a }
            int r14 = r14 - r17
            if (r14 == 0) goto L_0x0111
            if (r14 <= 0) goto L_0x011a
            goto L_0x0118
        L_0x0111:
            int r15 = r15 + 1
            goto L_0x00f0
        L_0x0114:
            int r6 = r6.length     // Catch:{ all -> 0x011a }
            int r2 = r2.length     // Catch:{ all -> 0x011a }
            if (r6 <= r2) goto L_0x011a
        L_0x0118:
            r2 = 1
            goto L_0x011b
        L_0x011a:
            r2 = 0
        L_0x011b:
            if (r2 != 0) goto L_0x0124
            int r2 = r13.initStatus     // Catch:{ all -> 0x01d7 }
            r6 = 1
            if (r2 != r6) goto L_0x0124
            r14 = 1
            goto L_0x0125
        L_0x0124:
            r14 = r12
        L_0x0125:
            java.lang.String r2 = r8.toLowerCase()     // Catch:{ all -> 0x01d7 }
            com.baidu.sofire.core.ApkInfo r6 = new com.baidu.sofire.core.ApkInfo     // Catch:{ all -> 0x01d7 }
            r6.<init>()     // Catch:{ all -> 0x01d7 }
            r6.packageName = r9     // Catch:{ all -> 0x01d7 }
            r6.versionName = r10     // Catch:{ all -> 0x01d7 }
            r6.key = r11     // Catch:{ all -> 0x01d7 }
            r6.apkMD5 = r2     // Catch:{ all -> 0x01d7 }
            if (r14 == 0) goto L_0x013c
            r4.add(r6)     // Catch:{ all -> 0x01d7 }
            goto L_0x0145
        L_0x013c:
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r2 = f1092o     // Catch:{ all -> 0x01d7 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x01d7 }
            r2.put(r8, r6)     // Catch:{ all -> 0x01d7 }
        L_0x0145:
            int r7 = r7 + 1
            r2 = 0
            goto L_0x005f
        L_0x014a:
            r3.a((java.util.List<java.lang.Integer>) r5)     // Catch:{ all -> 0x01d7 }
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r0 = f1092o     // Catch:{ all -> 0x01d7 }
            int r0 = r0.size()     // Catch:{ all -> 0x01d7 }
            if (r0 > 0) goto L_0x015e
            int r0 = r4.size()     // Catch:{ all -> 0x01d7 }
            if (r0 > 0) goto L_0x015e
            monitor-exit(r1)
        L_0x015c:
            r1 = 0
            return r1
        L_0x015e:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x01d7 }
            r0.<init>()     // Catch:{ all -> 0x01d7 }
            java.util.HashMap<java.lang.Integer, com.baidu.sofire.core.ApkInfo> r2 = f1092o     // Catch:{ all -> 0x01d7 }
            java.util.Collection r2 = r2.values()     // Catch:{ all -> 0x01d7 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x01d7 }
        L_0x016d:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x019e
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x01d7 }
            com.baidu.sofire.core.ApkInfo r3 = (com.baidu.sofire.core.ApkInfo) r3     // Catch:{ all -> 0x01d7 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x01d7 }
            r5.<init>()     // Catch:{ all -> 0x01d7 }
            java.lang.String r6 = "pk"
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x01d7 }
            r5.put(r6, r7)     // Catch:{ all -> 0x01d7 }
            java.lang.String r6 = "m"
            java.lang.String r7 = r3.apkMD5     // Catch:{ all -> 0x01d7 }
            r5.put(r6, r7)     // Catch:{ all -> 0x01d7 }
            java.lang.String r6 = "l"
            int r7 = r3.key     // Catch:{ all -> 0x01d7 }
            r5.put(r6, r7)     // Catch:{ all -> 0x01d7 }
            java.lang.String r6 = "v"
            java.lang.String r3 = r3.versionName     // Catch:{ all -> 0x01d7 }
            r5.put(r6, r3)     // Catch:{ all -> 0x01d7 }
            r0.put(r5)     // Catch:{ all -> 0x01d7 }
            goto L_0x016d
        L_0x019e:
            java.util.Iterator r2 = r4.iterator()     // Catch:{ all -> 0x01d7 }
        L_0x01a2:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x01d7 }
            if (r3 == 0) goto L_0x01d3
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x01d7 }
            com.baidu.sofire.core.ApkInfo r3 = (com.baidu.sofire.core.ApkInfo) r3     // Catch:{ all -> 0x01d7 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x01d7 }
            r4.<init>()     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = "pk"
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x01d7 }
            r4.put(r5, r6)     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = "m"
            java.lang.String r6 = r3.apkMD5     // Catch:{ all -> 0x01d7 }
            r4.put(r5, r6)     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = "l"
            int r6 = r3.key     // Catch:{ all -> 0x01d7 }
            r4.put(r5, r6)     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = "v"
            java.lang.String r3 = r3.versionName     // Catch:{ all -> 0x01d7 }
            r4.put(r5, r3)     // Catch:{ all -> 0x01d7 }
            r0.put(r4)     // Catch:{ all -> 0x01d7 }
            goto L_0x01a2
        L_0x01d3:
            monitor-exit(r1)
            return r0
        L_0x01d5:
            r0 = move-exception
            goto L_0x01db
        L_0x01d7:
            int r0 = com.baidu.sofire.a.a.a     // Catch:{ all -> 0x01d5 }
            monitor-exit(r1)
            goto L_0x015c
        L_0x01db:
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.l.c.a(android.content.Context):org.json.JSONArray");
    }

    public static String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", l);
            jSONObject.put("2", h);
            jSONObject.put("3", f1091i);
            jSONObject.put("4", j);
            jSONObject.put(BannerBaseItemInfo.TYPE_LOGIN, k);
            return jSONObject.toString();
        } catch (Throwable unused) {
            int i2 = a.a;
            return "";
        }
    }
}
