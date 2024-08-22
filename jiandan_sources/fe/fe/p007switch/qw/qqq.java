package fe.fe.p007switch.qw;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobstat.dxmpay.h;
import com.baidu.mobstat.dxmpay.q;
import com.baidu.sofire.xclient.privacycontrol.lib.WifiInfoHelper;
import com.google.android.material.timepicker.ChipTextInputComboView;
import fe.fe.p007switch.qw.mmm.qw;
import fe.fe.p007switch.qw.xxx;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* renamed from: fe.fe.switch.qw.qqq  reason: invalid package */
public class qqq {

    /* renamed from: ad  reason: collision with root package name */
    public static String f3047ad;

    /* renamed from: de  reason: collision with root package name */
    public static String f3048de;

    /* renamed from: fe  reason: collision with root package name */
    public static final Pattern f3049fe = Pattern.compile("\\s*|\t|\r|\n");
    public static String qw;

    public static String a(Context context) {
        return context != null ? context.getPackageName() : "";
    }

    public static String aaa(int i2, Context context) {
        String eee = eee(i2, context);
        String de2 = !TextUtils.isEmpty(eee) ? Cswitch.de(i2, eee.getBytes()) : null;
        return TextUtils.isEmpty(de2) ? "" : de2;
    }

    public static String ad(byte b) {
        String str = ChipTextInputComboView.TextFormatter.DEFAULT_TEXT + Integer.toHexString(b) + ":";
        return str.substring(str.length() - 3);
    }

    public static String b(int i2, Context context) {
        return "";
    }

    public static String c(Context context) {
        String str = f3047ad;
        if (str == null) {
            String g = g(context);
            String o2 = o(context, g);
            if (TextUtils.isEmpty(o2)) {
                o2 = m212switch(context, g);
            }
            str = o2 == null ? "" : o2;
            f3047ad = str;
        }
        return str;
    }

    public static String d(int i2, Context context) {
        String a = a(context);
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        try {
            return Cswitch.de(i2, a.getBytes());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String ddd(int i2, Context context) {
        return Cswitch.de(i2, qw.rg(context).getBytes());
    }

    public static String de(int i2, Context context) {
        return Cswitch.de(i2, qw.fe(context).getBytes());
    }

    public static String e(Context context) {
        ServiceInfo[] serviceInfoArr;
        String str;
        String g = g(context);
        if (g == null) {
            return "";
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
        } catch (Exception unused) {
        }
        if (packageInfo == null || (serviceInfoArr = packageInfo.services) == null) {
            return "";
        }
        int length = serviceInfoArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str = "";
                break;
            }
            ServiceInfo serviceInfo = serviceInfoArr[i2];
            if (g.equals(serviceInfo.processName)) {
                str = serviceInfo.name;
                break;
            }
            i2++;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String eee(int i2, Context context) {
        String qw2 = qw();
        if (TextUtils.isEmpty(qw2)) {
            qw2 = tt(i2, context);
        }
        return TextUtils.isEmpty(qw2) ? "" : qw2;
    }

    public static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        } catch (Exception unused) {
            return false;
        }
    }

    public static String fe(Context context) {
        return f3049fe.matcher(eee.qw(context)).replaceAll("");
    }

    public static String g(Context context) {
        String str = qw;
        if (str == null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getRunningAppProcesses();
                int i2 = 0;
                while (true) {
                    if (runningAppProcesses == null || i2 >= runningAppProcesses.size()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == Process.myPid()) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                    i2++;
                }
            } catch (Exception unused) {
            }
            if (str == null) {
                str = "";
            }
            qw = str;
        }
        return str;
    }

    public static DisplayMetrics ggg(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String i(Context context) {
        return xxx.qw.qw(fe(context).getBytes()).toUpperCase(Locale.US);
    }

    /* renamed from: if  reason: not valid java name */
    public static String m211if(int i2, Context context) {
        return Cswitch.de(i2, qw.de(context).getBytes());
    }

    public static String mmm(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String nn(int i2, Context context) {
        return "";
    }

    public static String o(Context context, String str) {
        int lastIndexOf;
        int i2;
        if (str != null && (lastIndexOf = str.lastIndexOf(58)) > 0 && (i2 = lastIndexOf + 1) < str.length()) {
            return str.substring(i2);
        }
        return null;
    }

    public static int pf(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = ggg(context);
        } catch (Exception unused) {
        }
        return displayMetrics.widthPixels;
    }

    public static String ppp(int i2, Context context) {
        return Cswitch.de(i2, qw.ad(context).getBytes());
    }

    public static boolean qqq(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo == null || !networkInfo.isAvailable() || !networkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058 A[SYNTHETIC, Splitter:B:27:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f A[SYNTHETIC, Splitter:B:34:0x005f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String qw() {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 20
            r2 = 0
            char[] r3 = new char[r1]     // Catch:{ Exception -> 0x005c, all -> 0x0055 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x005c, all -> 0x0055 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005c, all -> 0x0055 }
            java.lang.String r6 = "/sys/class/net/eth0/address"
            r5.<init>(r6)     // Catch:{ Exception -> 0x005c, all -> 0x0055 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x005c, all -> 0x0055 }
        L_0x0016:
            int r5 = r4.read(r3)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r6 = -1
            if (r5 == r6) goto L_0x003c
            r6 = 13
            if (r5 != r1) goto L_0x002d
            r7 = 19
            char r7 = r3[r7]     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            if (r7 == r6) goto L_0x002d
            java.io.PrintStream r5 = java.lang.System.out     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r5.print(r3)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            goto L_0x0016
        L_0x002d:
            r7 = 0
        L_0x002e:
            if (r7 >= r5) goto L_0x0016
            char r8 = r3[r7]     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            if (r8 == r6) goto L_0x0039
            char r8 = r3[r7]     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r0.append(r8)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
        L_0x0039:
            int r7 = r7 + 1
            goto L_0x002e
        L_0x003c:
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            java.lang.String r1 = ":"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.replaceAll(r1, r3)     // Catch:{ Exception -> 0x0053, all -> 0x0050 }
            r4.close()     // Catch:{ Exception -> 0x004f }
        L_0x004f:
            return r0
        L_0x0050:
            r0 = move-exception
            r2 = r4
            goto L_0x0056
        L_0x0053:
            goto L_0x005d
        L_0x0055:
            r0 = move-exception
        L_0x0056:
            if (r2 == 0) goto L_0x005b
            r2.close()     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            throw r0
        L_0x005c:
            r4 = r2
        L_0x005d:
            if (r4 == 0) goto L_0x0062
            r4.close()     // Catch:{ Exception -> 0x0062 }
        L_0x0062:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p007switch.qw.qqq.qw():java.lang.String");
    }

    public static String rg(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return "";
            }
            Object obj = null;
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                obj = bundle.get(str);
            }
            if (obj != null) {
                return obj.toString();
            }
            h o2 = h.o();
            o2.de("can't find information in AndroidManifest.xml for key " + str);
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String rrr(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            String typeName = activeNetworkInfo.getTypeName();
            return (typeName.equals("WIFI") || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public static String m212switch(Context context, String str) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        String str2 = applicationInfo.processName;
        if (str2 == null || str2.equals(str)) {
            return null;
        }
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0033, code lost:
        if (r5 == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        r5.destroy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005e, code lost:
        if (r5 == null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0061, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a A[SYNTHETIC, Splitter:B:21:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0059 A[SYNTHETIC, Splitter:B:30:0x0059] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String th(java.lang.String r5) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0055, all -> 0x0044 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0055, all -> 0x0044 }
            r2.<init>()     // Catch:{ Exception -> 0x0055, all -> 0x0044 }
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch:{ Exception -> 0x0055, all -> 0x0044 }
            r2.append(r5)     // Catch:{ Exception -> 0x0055, all -> 0x0044 }
            java.lang.String r5 = r2.toString()     // Catch:{ Exception -> 0x0055, all -> 0x0044 }
            java.lang.Process r5 = r1.exec(r5)     // Catch:{ Exception -> 0x0055, all -> 0x0044 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            java.io.InputStream r3 = r5.getInputStream()     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            r3 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0042, all -> 0x003d }
            java.lang.String r0 = r1.readLine()     // Catch:{ Exception -> 0x003b, all -> 0x0039 }
            r1.close()     // Catch:{ Exception -> 0x0032 }
            goto L_0x0033
        L_0x0032:
        L_0x0033:
            if (r5 == 0) goto L_0x0061
        L_0x0035:
            r5.destroy()
            goto L_0x0061
        L_0x0039:
            r0 = move-exception
            goto L_0x0048
        L_0x003b:
            goto L_0x0057
        L_0x003d:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0048
        L_0x0042:
            r1 = r0
            goto L_0x0057
        L_0x0044:
            r5 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
        L_0x0048:
            if (r1 == 0) goto L_0x004f
            r1.close()     // Catch:{ Exception -> 0x004e }
            goto L_0x004f
        L_0x004e:
        L_0x004f:
            if (r5 == 0) goto L_0x0054
            r5.destroy()
        L_0x0054:
            throw r0
        L_0x0055:
            r5 = r0
            r1 = r5
        L_0x0057:
            if (r1 == 0) goto L_0x005e
            r1.close()     // Catch:{ Exception -> 0x005d }
            goto L_0x005e
        L_0x005d:
        L_0x005e:
            if (r5 == 0) goto L_0x0061
            goto L_0x0035
        L_0x0061:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p007switch.qw.qqq.th(java.lang.String):java.lang.String");
    }

    @SuppressLint({"NewApi"})
    public static String tt(int i2, Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (!nextElement2.isAnyLocalAddress() && (nextElement2 instanceof Inet4Address)) {
                        if (!nextElement2.isLoopbackAddress()) {
                            if (nextElement2.isSiteLocalAddress()) {
                                bArr = WifiInfoHelper.getMac(nextElement);
                            } else if (!nextElement2.isLinkLocalAddress()) {
                                bArr = WifiInfoHelper.getMac(nextElement);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (bArr != null) {
            for (byte ad2 : bArr) {
                stringBuffer.append(ad(ad2));
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1).replaceAll(":", "");
        }
        String nn = nn(i2, context);
        return nn != null ? nn.replaceAll(":", "") : nn;
    }

    public static String uk(int i2, Context context) {
        return Cswitch.de(i2, q.i().e(context).getBytes());
    }

    public static String vvv(int i2, Context context) {
        return Cswitch.de(i2, qw.qw(context).getBytes());
    }

    public static int when(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            displayMetrics = ggg(context);
        } catch (Exception unused) {
        }
        return displayMetrics.heightPixels;
    }

    public static int xxx(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 1;
        }
    }

    public static String yj() {
        String str;
        String str2 = f3048de;
        if (str2 != null) {
            return str2;
        }
        if (!TextUtils.isEmpty(th("ro.miui.ui.version.name"))) {
            str = "miui";
        } else if (!TextUtils.isEmpty(th(RomUtils.KEY_VERSION_OPPO))) {
            str = "coloros";
        } else if (!TextUtils.isEmpty(th("ro.build.version.emui"))) {
            str = "emui";
        } else if (!TextUtils.isEmpty(th(RomUtils.KEY_VERSION_VIVO))) {
            str = "funtouch";
        } else {
            str = !TextUtils.isEmpty(th(RomUtils.KEY_VERSION_SMARTISAN)) ? RomUtils.MANUFACTURER_SMARTISAN : "";
        }
        if (TextUtils.isEmpty(str)) {
            String th2 = th("ro.build.display.id");
            if (!TextUtils.isEmpty(th2) && th2.contains("Flyme")) {
                str = "flyme";
            }
        }
        f3048de = str;
        return str;
    }
}
