package com.alipay.sdk.m.u;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.m.h.d;
import com.alipay.sdk.m.h.f;
import com.alipay.sdk.m.m.a;
import com.baidu.android.util.devices.RomUtils;
import com.google.common.base.Ascii;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

public class n {
    public static final String a = "com.alipay.android.app";
    public static final String b = "com.eg.android.AlipayGphone";
    public static final String c = "hk.alipay.wallet";
    public static final String d = "hk.alipay.walletRC";
    public static final String e = "com.eg.android.AlipayGphoneRC";
    public static final int f = 99;
    public static final String[] g = {"10.1.5.1013151", "10.1.5.1013148"};
    public static final int h = 125;

    /* renamed from: i  reason: collision with root package name */
    public static final int f685i = 460;
    public static final char[] j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};

    public static class a implements Runnable {
        public final /* synthetic */ Activity a;

        public a(Activity activity) {
            this.a = activity;
        }

        public void run() {
            this.a.finish();
        }
    }

    public static class b implements Runnable {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ ConditionVariable b;

        public b(Runnable runnable, ConditionVariable conditionVariable) {
            this.a = runnable;
            this.b = conditionVariable;
        }

        public void run() {
            try {
                this.a.run();
            } finally {
                this.b.open();
            }
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            int indexOf = str3.indexOf(str) + str.length();
            if (indexOf <= str.length()) {
                return "";
            }
            int i2 = 0;
            if (!TextUtils.isEmpty(str2)) {
                i2 = str3.indexOf(str2, indexOf);
            }
            if (i2 < 1) {
                return str3.substring(indexOf);
            }
            return str3.substring(indexOf, i2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b() {
        if (EnvUtils.isSandBox()) {
            return TextUtils.equals("hk.alipay.wallet", com.alipay.sdk.m.j.a.d.get(0).a) ? d : e;
        }
        try {
            return com.alipay.sdk.m.j.a.d.get(0).a;
        } catch (Throwable unused) {
            return b;
        }
    }

    public static String b(Context context) {
        return "-1;-1";
    }

    public static String c(String str) {
        return (!EnvUtils.isSandBox() || !TextUtils.equals(str, e)) ? "com.eg.android.AlipayGphone.IAlixPay" : "com.eg.android.AlipayGphoneRC.IAlixPay";
    }

    public static int d(String str) {
        for (int i2 = 0; i2 < 64; i2++) {
            if (str.equals(String.valueOf(j[i2]))) {
                return i2;
            }
        }
        return 0;
    }

    public static String e(com.alipay.sdk.m.s.a aVar, String str) {
        try {
            return URLDecoder.decode(str, com.baidu.apollon.heartbeat.a.h);
        } catch (UnsupportedEncodingException e2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.B, (Throwable) e2);
            return "";
        }
    }

    public static String f() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static String g(Context context) {
        String f2 = f();
        String e2 = e();
        String c2 = c(context);
        String f3 = f(context);
        return " (" + f2 + i.b + e2 + i.b + c2 + i.b + i.b + f3 + ")" + "(sdk android)";
    }

    public static JSONObject h(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static String i(String str) {
        try {
            Uri parse = Uri.parse(str);
            return String.format("%s%s", new Object[]{parse.getAuthority(), parse.getPath()});
        } catch (Throwable th2) {
            e.a(th2);
            return "-";
        }
    }

    public static String f(Context context) {
        DisplayMetrics d2 = d(context);
        return d2.widthPixels + "*" + d2.heightPixels;
    }

    public static String c(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String d() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
            if (!matcher.matches() || matcher.groupCount() < 4) {
                return "Unavailable";
            }
            return matcher.group(1) + StringUtils.LF + matcher.group(2) + " " + matcher.group(3) + StringUtils.LF + matcher.group(4);
        } catch (IOException unused) {
            return "Unavailable";
        } catch (Throwable th2) {
            bufferedReader.close();
            throw th2;
        }
    }

    public static String e() {
        String d2 = d();
        int indexOf = d2.indexOf("-");
        if (indexOf != -1) {
            d2 = d2.substring(0, indexOf);
        }
        int indexOf2 = d2.indexOf(StringUtils.LF);
        if (indexOf2 != -1) {
            d2 = d2.substring(0, indexOf2);
        }
        return "Linux " + d2;
    }

    public static boolean h(Context context) {
        try {
            if (context.getPackageManager().getPackageInfo(a, 128) == null) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static Map<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(com.alipay.sdk.m.s.a.n)) {
            int indexOf = str2.indexOf("=", 1);
            if (-1 != indexOf) {
                hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
            }
        }
        return hashMap;
    }

    public static boolean h() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static final class c {
        public final PackageInfo a;
        public final int b;
        public final String c;

        public c(PackageInfo packageInfo, int i2, String str) {
            this.a = packageInfo;
            this.b = i2;
            this.c = str;
        }

        public boolean a(com.alipay.sdk.m.s.a aVar) {
            Signature[] signatureArr = this.a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            int length = signatureArr.length;
            int i2 = 0;
            while (i2 < length) {
                String a2 = n.a(aVar, signatureArr[i2].toByteArray());
                if (a2 == null || TextUtils.equals(a2, this.c)) {
                    i2++;
                } else {
                    com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.D, String.format("Got %s, expected %s", new Object[]{a2, this.c}));
                    return true;
                }
            }
            return false;
        }

        public boolean a() {
            return this.a.versionCode < this.b;
        }
    }

    public static String a(com.alipay.sdk.m.s.a aVar, byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.n, com.alipay.sdk.m.k.b.x, (Throwable) e2);
            return null;
        }
    }

    public static String c(com.alipay.sdk.m.s.a aVar, String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        } catch (Exception e2) {
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "rflex", e2.getClass().getSimpleName());
            return null;
        }
    }

    public static boolean f(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static String e(Context context) {
        String b2 = m.b(context);
        return b2.substring(0, b2.indexOf("://"));
    }

    public static String g(String str) {
        return a(str, true);
    }

    public static int g() {
        try {
            return Process.myUid();
        } catch (Throwable th2) {
            e.a(th2);
            return -200;
        }
    }

    public static Map<String, String> b(com.alipay.sdk.m.s.a aVar, String str) {
        HashMap hashMap = new HashMap(4);
        int indexOf = str.indexOf(63);
        if (indexOf != -1 && indexOf < str.length() - 1) {
            for (String str2 : str.substring(indexOf + 1).split(com.alipay.sdk.m.s.a.n)) {
                int indexOf2 = str2.indexOf(61, 1);
                if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                    hashMap.put(str2.substring(0, indexOf2), e(aVar, str2.substring(indexOf2 + 1)));
                }
            }
        }
        return hashMap;
    }

    public static int c() {
        try {
            String lowerCase = Build.BRAND.toLowerCase();
            String lowerCase2 = Build.MANUFACTURER.toLowerCase();
            if (a((Object) RomUtils.MANUFACTURER_HUAWEI, lowerCase, lowerCase2)) {
                return 1;
            }
            if (a((Object) RomUtils.MANUFACTURER_OPPO, lowerCase, lowerCase2)) {
                return 2;
            }
            if (a((Object) RomUtils.MANUFACTURER_VIVO, lowerCase, lowerCase2)) {
                return 4;
            }
            if (a((Object) "lenovo", lowerCase, lowerCase2)) {
                return 8;
            }
            if (a((Object) RomUtils.MANUFACTURER_XIAOMI, lowerCase, lowerCase2)) {
                return 16;
            }
            return a((Object) "oneplus", lowerCase, lowerCase2) ? 32 : 0;
        } catch (Exception unused) {
            return 61440;
        }
    }

    public static int e(String str) {
        try {
            String h2 = com.alipay.sdk.m.m.a.z().h();
            int i2 = 0;
            if (TextUtils.isEmpty(h2)) {
                return 0;
            }
            if (b(h2, "").contains(str)) {
                i2 = 2;
            }
            return i2 | 1;
        } catch (Throwable unused) {
            return 61440;
        }
    }

    public static DisplayMetrics d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static c a(com.alipay.sdk.m.s.a aVar, Context context, List<a.b> list) {
        c a2;
        if (list == null) {
            return null;
        }
        for (a.b next : list) {
            if (next != null && (a2 = a(aVar, context, next.a, next.b, next.c)) != null && !a2.a(aVar) && !a2.a()) {
                return a2;
            }
        }
        return null;
    }

    public static boolean d(com.alipay.sdk.m.s.a aVar, String str) {
        try {
            int e2 = e(str);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "bindExt", "" + e2);
            if (!com.alipay.sdk.m.m.a.z().m() || (e2 & 2) != 2) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static c a(com.alipay.sdk.m.s.a aVar, Context context, String str, int i2, String str2) {
        PackageInfo packageInfo;
        if (EnvUtils.isSandBox()) {
            if (b.equals(str)) {
                str = e;
            } else if ("hk.alipay.wallet".equals(str)) {
                str = d;
            }
        }
        try {
            packageInfo = a(context, str);
        } catch (Throwable th2) {
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.n, com.alipay.sdk.m.k.b.v, th2.getMessage());
            packageInfo = null;
        }
        if (!a(aVar, packageInfo)) {
            return null;
        }
        return a(packageInfo, i2, str2);
    }

    public static String b(com.alipay.sdk.m.s.a aVar, Context context) {
        return a(aVar, context, context.getPackageName());
    }

    public static int b(int i2) {
        return i2 / 100000;
    }

    public static String b(String str, String str2) {
        String string = Settings.Secure.getString(((Application) com.alipay.sdk.m.s.b.d().b()).getContentResolver(), str);
        return string != null ? string : str2;
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, PackageInfo packageInfo) {
        String str = "";
        boolean z = false;
        if (packageInfo == null) {
            str = str + "info == null";
        } else {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = str + "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = str + "info.signatures.length <= 0";
            } else {
                z = true;
            }
        }
        if (!z) {
            com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.n, com.alipay.sdk.m.k.b.w, str);
        }
        return z;
    }

    public static boolean b(com.alipay.sdk.m.s.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.g)) {
            return false;
        }
        return aVar.g.toLowerCase().contains(com.alipay.sdk.m.k.b.n);
    }

    public static PackageInfo a(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    public static c a(PackageInfo packageInfo, int i2, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new c(packageInfo, i2, str);
    }

    public static long a(String str) {
        return a(str, 6);
    }

    public static long a(String str, int i2) {
        int pow = (int) Math.pow(2.0d, (double) i2);
        int length = str.length();
        long j2 = 0;
        int i3 = 0;
        int i4 = length;
        while (i3 < length) {
            int i5 = i3 + 1;
            j2 += ((long) Integer.parseInt(String.valueOf(d(str.substring(i3, i5))))) * ((long) Math.pow((double) pow, (double) (i4 - 1)));
            i4--;
            i3 = i5;
        }
        return j2;
    }

    public static int a() {
        String c2 = com.alipay.sdk.m.s.b.d().c();
        if (TextUtils.isEmpty(c2)) {
            return -1;
        }
        String replaceAll = c2.replaceAll("=", "");
        if (replaceAll.length() >= 5) {
            replaceAll = replaceAll.substring(0, 5);
        }
        int a2 = (int) (a(replaceAll) % 10000);
        return a2 < 0 ? a2 * -1 : a2;
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, Context context, List<a.b> list, boolean z) {
        try {
            for (a.b next : list) {
                if (next != null) {
                    String str = next.a;
                    if (EnvUtils.isSandBox()) {
                        if (b.equals(str)) {
                            str = e;
                        } else if ("hk.alipay.wallet".equals(str)) {
                            str = d;
                        }
                    }
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                        if (packageInfo == null) {
                            continue;
                        } else if (!z) {
                            return true;
                        } else {
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.X, packageInfo.packageName + "|" + packageInfo.versionName);
                            return true;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.h0, th2);
            return false;
        }
    }

    public static boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            if (TextUtils.equals(str, g[0]) || TextUtils.equals(str, g[1])) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(int i2) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                sb.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 65.0d))));
            } else if (nextInt == 1) {
                sb.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 97.0d))));
            } else if (nextInt == 2) {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb.toString();
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, String str, Activity activity) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (str.toLowerCase().startsWith(com.alipay.sdk.m.l.a.n.toLowerCase()) || str.toLowerCase().startsWith(com.alipay.sdk.m.l.a.f664o.toLowerCase())) {
            try {
                c a2 = a(aVar, (Context) activity, com.alipay.sdk.m.j.a.d);
                if (a2 != null && !a2.a()) {
                    if (!a2.a(aVar)) {
                        if (str.startsWith("intent://platformapi/startapp")) {
                            str = str.replaceFirst("intent://platformapi/startapp\\?", com.alipay.sdk.m.l.a.n);
                        }
                        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                }
            } catch (Throwable unused) {
            }
            return true;
        } else if (TextUtils.equals(str, com.alipay.sdk.m.l.a.q) || TextUtils.equals(str, a("http", com.alipay.sdk.m.l.a.s))) {
            com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a());
            activity.finish();
            return true;
        } else if (!str.startsWith(com.alipay.sdk.m.l.a.p)) {
            return false;
        } else {
            try {
                String substring = str.substring(str.indexOf(com.alipay.sdk.m.l.a.p) + 24);
                int parseInt = Integer.parseInt(substring.substring(substring.lastIndexOf(com.alipay.sdk.m.l.a.t) + 10));
                if (parseInt != com.alipay.sdk.m.j.c.SUCCEEDED.b()) {
                    if (parseInt != com.alipay.sdk.m.j.c.PAY_WAITTING.b()) {
                        com.alipay.sdk.m.j.c b2 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
                        com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(b2.b(), b2.a(), ""));
                        activity.runOnUiThread(new a(activity));
                        return true;
                    }
                }
                if (com.alipay.sdk.m.l.a.x) {
                    StringBuilder sb = new StringBuilder();
                    String decode = URLDecoder.decode(str);
                    String decode2 = URLDecoder.decode(decode);
                    String str3 = decode2.substring(decode2.indexOf(com.alipay.sdk.m.l.a.p) + 24, decode2.lastIndexOf(com.alipay.sdk.m.l.a.t)).split(com.alipay.sdk.m.l.a.v)[0];
                    int indexOf = decode.indexOf(com.alipay.sdk.m.l.a.v) + 12;
                    sb.append(str3);
                    sb.append(com.alipay.sdk.m.l.a.v);
                    sb.append(decode.substring(indexOf, decode.indexOf(com.alipay.sdk.m.s.a.n, indexOf)));
                    sb.append(decode.substring(decode.indexOf(com.alipay.sdk.m.s.a.n, indexOf)));
                    str2 = sb.toString();
                } else {
                    String decode3 = URLDecoder.decode(str);
                    str2 = decode3.substring(decode3.indexOf(com.alipay.sdk.m.l.a.p) + 24, decode3.lastIndexOf(com.alipay.sdk.m.l.a.t));
                }
                com.alipay.sdk.m.j.c b3 = com.alipay.sdk.m.j.c.b(parseInt);
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.a(b3.b(), b3.a(), str2));
            } catch (Exception unused2) {
                com.alipay.sdk.m.j.b.a(com.alipay.sdk.m.j.b.e());
            }
            activity.runOnUiThread(new a(activity));
            return true;
        }
    }

    public static String a(com.alipay.sdk.m.s.a aVar, Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (Throwable th2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.v, th2);
            return "";
        }
    }

    public static String a(String str, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            if (!z || digest.length <= 16) {
                return a(digest);
            }
            byte[] bArr = new byte[16];
            System.arraycopy(digest, 0, bArr, 0, 16);
            return a(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(Character.forDigit((b2 & 240) >> 4, 16));
            sb.append(Character.forDigit(b2 & Ascii.SI, 16));
        }
        return sb.toString();
    }

    public static ActivityInfo a(Context context) {
        try {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                    if (TextUtils.equals(activityInfo.name, activity.getClass().getName())) {
                        return activityInfo;
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            e.a(th2);
            return null;
        }
    }

    public static String a(com.alipay.sdk.m.s.a aVar) {
        return c(aVar, RomUtils.PROP_RO_BUILD_FINGERPRINT);
    }

    public static <T> T a(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, String str) {
        try {
            String host = new URL(str).getHost();
            if (host.endsWith(com.alipay.sdk.m.l.a.B) || host.endsWith(com.alipay.sdk.m.l.a.C)) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ckUrlErr", th2);
            return false;
        }
    }

    public static JSONObject a(Intent intent) {
        Bundle extras;
        JSONObject jSONObject = new JSONObject();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            for (String str : extras.keySet()) {
                try {
                    jSONObject.put(str, String.valueOf(extras.get(str)));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, jSONObject.optString(next));
            } catch (Throwable th2) {
                e.a(th2);
            }
        }
        return hashMap;
    }

    public static boolean a(Object obj, Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            for (Object obj2 : objArr) {
                if ((obj == null && obj2 == null) || (obj != null && obj.equals(obj2))) {
                    return true;
                }
            }
            return false;
        } else if (obj == null) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean a(long j2, Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        ConditionVariable conditionVariable = new ConditionVariable();
        Thread thread = new Thread(new b(runnable, conditionVariable));
        if (!TextUtils.isEmpty(str)) {
            thread.setName(str);
        }
        thread.start();
        if (j2 > 0) {
            return conditionVariable.block(j2);
        }
        try {
            conditionVariable.block();
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static String a(String str, String str2) {
        return str + str2;
    }

    public static String a(com.alipay.sdk.m.s.a aVar, Context context) {
        try {
            String a2 = j.a(aVar, context, "alipay_cashier_ap_fi", "");
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
            try {
                j.b(aVar, context, "alipay_cashier_ap_fi", com.alipay.sdk.m.h.a.a("FU", System.currentTimeMillis(), new d(), 0, new f()).a());
                String a3 = j.a(aVar, context, "alipay_cashier_ap_fi", "");
                if (!TextUtils.isEmpty(a3)) {
                    return a3;
                }
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "e_regen_empty", "");
                return "";
            } catch (Exception e2) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "e_gen", e2.getClass().getSimpleName());
                return "";
            }
        } catch (Exception e3) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "e_gen_err", (Throwable) e3);
            return "";
        }
    }

    public static void a(String str, String str2, Context context, com.alipay.sdk.m.s.a aVar) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !b(aVar) && com.alipay.sdk.m.m.a.z().s()) {
            try {
                Intent intent = new Intent(com.alipay.sdk.m.l.b.l);
                intent.putExtra("bizType", str);
                intent.putExtra("exName", str2);
                intent.setPackage(context.getPackageName());
                context.sendBroadcast(intent);
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "AppNotify", str + "|" + str2);
            } catch (Exception unused) {
            }
        }
    }
}
