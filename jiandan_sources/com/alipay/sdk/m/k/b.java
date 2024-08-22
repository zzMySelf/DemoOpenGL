package com.alipay.sdk.m.k;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.k.a;
import com.alipay.sdk.m.u.c;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.wallet.paysdk.datamodel.Bank;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

public class b {
    public static final String A = "SSLDenied";
    public static final String A0 = "out_trade_no";
    public static final String B = "H5PayDataAnalysisError";
    public static final String B0 = "trade_no";
    public static final String C = "H5AuthDataAnalysisError";
    public static final String C0 = "biz_content";
    public static final String D = "PublicKeyUnmatch";
    public static final String D0 = "app_id";
    public static final String E = "ClientBindFailed";
    public static final String F = "TriDesEncryptError";
    public static final String G = "TriDesDecryptError";
    public static final String H = "ClientBindException";
    public static final String I = "SaveTradeTokenError";
    public static final String J = "ClientBindServiceFailed";
    public static final String K = "TryStartServiceEx";
    public static final String L = "BindWaitTimeoutEx";
    public static final String M = "CheckClientExistEx";
    public static final String N = "CheckClientSignEx";
    public static final String O = "GetInstalledAppEx";
    public static final String P = "ParserTidClientKeyEx";
    public static final String Q = "PgApiInvoke";
    public static final String R = "PgBindStarting";
    public static final String S = "PgBinded";
    public static final String T = "PgBindEnd";
    public static final String U = "PgBindPay";
    public static final String V = "PgReturn";
    public static final String W = "PgReturnV";
    public static final String X = "PgWltVer";
    public static final String Y = "PgOpenStarting";
    public static final String Z = "ErrIntentEx";
    public static final String a0 = "ErrActNull";
    public static final String b0 = "ErrActEx";
    public static final String c0 = "ErrActNull2";
    public static final String d0 = "ErrActEx2";
    public static final String e0 = "ErrActNotCreated";
    public static final String f0 = "GetInstalledAppEx";
    public static final String g0 = "StartLaunchAppTransEx";
    public static final String h0 = "CheckLaunchAppExistEx";
    public static final String i0 = "LogBindCalledH5";
    public static final String j0 = "LogCalledH5";
    public static final String k = "net";
    public static final String k0 = "LogHkLoginByIntent";
    public static final String l = "biz";
    public static final String l0 = "SchemePayWrongHashEx";
    public static final String m = "cp";
    public static final String m0 = "LogAppFetchConfigTimeout";
    public static final String n = "auth";
    public static final String n0 = "H5CbUrlEmpty";

    /* renamed from: o  reason: collision with root package name */
    public static final String f661o = "third";
    public static final String o0 = "H5CbEx";
    public static final String p = "wlt";
    public static final String p0 = "StartActivityEx";
    public static final String q = "FormatResultEx";
    public static final String q0 = "JSONEx";
    public static final String r = "GetApdidEx";
    public static final String r0 = "ParseBundleSerializableError";
    public static final String s = "GetApdidNull";
    public static final String s0 = "ParseSchemeQueryError";
    public static final String t = "GetApdidTimeout";
    public static final String t0 = "TbChk";
    public static final String u = "GetUtdidEx";
    public static final String u0 = "TbStart";
    public static final String v = "GetPackageInfoEx";
    public static final String v0 = "TbCancel";
    public static final String w = "NotIncludeSignatures";
    public static final String w0 = "TbUnknown";
    public static final String x = "GetPublicKeyFromSignEx";
    public static final String x0 = "TbOk";
    public static final String y = "webError";
    public static final String y0 = "TbActFail";
    public static final String z = "SSLError";
    public static final String z0 = "partner";
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f662i = "";
    public String j;

    public b(Context context, boolean z2) {
        long j2;
        context = context != null ? context.getApplicationContext() : context;
        this.a = b();
        this.c = a(context);
        if (z2) {
            j2 = 0;
        } else {
            j2 = a.e.a(context);
        }
        this.d = a(j2);
        this.e = a();
        this.f = b(context);
        this.g = "-";
        this.j = "-";
    }

    private synchronized void c(String str, String str2, String str3) {
        e.d(com.alipay.sdk.m.l.a.A, String.format("event %s %s %s", new Object[]{str, str2, str3}));
        String str4 = "";
        if (!TextUtils.isEmpty(this.h)) {
            str4 = str4 + PayTypeItemView.PayTypeItemViewData.MASK_FLAG;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = TextUtils.isEmpty(str) ? "-" : c(str);
        objArr[1] = c(str2);
        objArr[2] = c(str3);
        objArr[3] = c(c());
        sb.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", objArr));
        this.h += sb.toString();
    }

    private boolean d() {
        return TextUtils.isEmpty(this.f662i);
    }

    public static String e() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return "12345678uuid";
        }
    }

    public void a(String str, String str2, Throwable th2) {
        d(str, str2, a(th2));
    }

    public void b(String str, String str2, String str3) {
        d(str, str2, str3);
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String b() {
        return String.format("%s,%s", new Object[]{e(), new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date())});
    }

    private synchronized void d(String str, String str2, String str3) {
        e.c(com.alipay.sdk.m.l.a.A, String.format("err %s %s %s", new Object[]{str, str2, str3}));
        String str4 = "";
        if (!TextUtils.isEmpty(this.f662i)) {
            str4 = str4 + PayTypeItemView.PayTypeItemViewData.MASK_FLAG;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = TextUtils.isEmpty(str3) ? "-" : c(str3);
        objArr[3] = c(c());
        sb.append(String.format("%s,%s,%s,%s", objArr));
        this.f662i += sb.toString();
    }

    public void a(String str, String str2, Throwable th2, String str3) {
        String a2 = a(th2);
        d(str, str2, str3 + ": " + a2);
    }

    public static String b(String str) {
        String str2;
        String str3;
        if (str == null) {
            str = "";
        }
        String[] split = str.split(com.alipay.sdk.m.s.a.n);
        String str4 = null;
        if (split != null) {
            str3 = null;
            str2 = null;
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                if (split3 != null && split3.length == 2) {
                    if (split3[0].equalsIgnoreCase(z0)) {
                        str4 = split3[1].replace("\"", "");
                    } else if (split3[0].equalsIgnoreCase(A0)) {
                        str3 = split3[1].replace("\"", "");
                    } else if (split3[0].equalsIgnoreCase(B0)) {
                        str2 = split3[1].replace("\"", "");
                    } else if (split3[0].equalsIgnoreCase(C0)) {
                        try {
                            JSONObject jSONObject = new JSONObject(n.e(com.alipay.sdk.m.s.a.h(), split3[1]));
                            if (TextUtils.isEmpty(str3)) {
                                str3 = jSONObject.getString(A0);
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (split3[0].equalsIgnoreCase(D0)) {
                        if (TextUtils.isEmpty(str4)) {
                            str4 = split3[1];
                        }
                    }
                }
            }
        } else {
            str3 = null;
            str2 = null;
        }
        return String.format("%s,%s,-,%s,-,-,-", new Object[]{c(str2), c(str3), c(str4)});
    }

    public void a(String str, String str2, String str3) {
        c("", str, str2 + "|" + str3);
    }

    public void a(String str, String str2) {
        c("", str, str2);
    }

    public static String a(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th2.getClass().getName());
            stringBuffer.append(":");
            stringBuffer.append(th2.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th2.getStackTrace();
            if (stackTrace != null) {
                int i2 = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append(" 》 ");
                    i2++;
                    if (i2 > 5) {
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    public static String d(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    public static String c() {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace(PayTypeItemView.PayTypeItemViewData.MASK_FLAG, "~").replace(Bank.HOT_BANK_LETTER, "＃");
    }

    public String a(String str) {
        String b2 = b(str);
        this.b = b2;
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", new Object[]{this.a, b2, this.c, this.d, this.e, this.f, this.g, d(this.h), d(this.f662i), this.j});
    }

    public static String a(Context context) {
        String str;
        String str2 = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                str = applicationContext.getPackageName();
                try {
                    PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(str, 64);
                    str2 = packageInfo.versionName + "|" + a(packageInfo);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            return String.format("%s,%s,-,-,-", new Object[]{c(str), c(str2)});
        }
        str = str2;
        return String.format("%s,%s,-,-,-", new Object[]{c(str), c(str2)});
    }

    public static String a(PackageInfo packageInfo) {
        Signature[] signatureArr;
        String str;
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
            return "0";
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.signatures.length);
            Signature[] signatureArr2 = packageInfo.signatures;
            int length = signatureArr2.length;
            int i2 = 0;
            while (i2 < length) {
                try {
                    String a2 = n.a((com.alipay.sdk.m.s.a) null, signatureArr2[i2].toByteArray());
                    if (TextUtils.isEmpty(a2)) {
                        str = "?";
                        sb.append("-");
                        sb.append(str);
                        i2++;
                    } else {
                        str = n.g(a2).substring(0, 8);
                        sb.append("-");
                        sb.append(str);
                        i2++;
                    }
                } catch (Throwable unused) {
                }
            }
            return sb.toString();
        } catch (Throwable unused2) {
            return "?";
        }
    }

    public static String b(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", new Object[]{c(c.c(context)), SapiDeviceInfo.OS_TYPE, c(Build.VERSION.RELEASE), c(Build.MODEL), "-", "0", c(c.d(context).b()), "gw", c(com.alipay.sdk.m.w.b.b((com.alipay.sdk.m.s.a) null, context))});
    }

    public static String a(long j2) {
        String c2 = c("15.8.16");
        String c3 = c("h.a.3.8.16");
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", new Object[]{c2, c3, "~" + j2});
    }

    public static String a() {
        return String.format("%s,%s,-,-,-", new Object[]{c(com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b()).d()), c(com.alipay.sdk.m.s.b.d().c())});
    }
}
