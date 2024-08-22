package fe.fe.pf.th.qw;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import java.util.HashMap;

public class ppp implements pf {

    public static class ad {

        /* renamed from: de  reason: collision with root package name */
        public static ad f2925de = new ad();

        /* renamed from: ad  reason: collision with root package name */
        public DisplayMetrics f2926ad;
        public String qw;

        public static String fe(Context context) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "0.8";
            }
        }

        public static ad qw() {
            return f2925de;
        }

        public String ad(Context context) {
            synchronized (ad.class) {
                if (TextUtils.isEmpty(this.qw)) {
                    this.qw = de(context);
                }
            }
            return this.qw;
        }

        public final String de(Context context) {
            int rg2 = rg(context.getApplicationContext());
            int th2 = th(context.getApplicationContext());
            int yj2 = yj(context.getApplicationContext());
            String fe2 = fe(context.getApplicationContext());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(rg2);
            stringBuffer.append("_");
            stringBuffer.append(th2);
            stringBuffer.append("_");
            stringBuffer.append(SapiDeviceInfo.OS_TYPE);
            stringBuffer.append("_");
            stringBuffer.append(fe2);
            stringBuffer.append("_");
            stringBuffer.append(yj2);
            return stringBuffer.toString();
        }

        public final int rg(Context context) {
            uk(context);
            DisplayMetrics displayMetrics = this.f2926ad;
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }

        public final int th(Context context) {
            uk(context);
            DisplayMetrics displayMetrics = this.f2926ad;
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }

        public final void uk(Context context) {
            if (context != null && this.f2926ad == null) {
                this.f2926ad = context.getResources().getDisplayMetrics();
            }
        }

        public final int yj(Context context) {
            uk(context);
            DisplayMetrics displayMetrics = this.f2926ad;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }
    }

    public static class de {

        /* renamed from: rg  reason: collision with root package name */
        public static de f2927rg = new de();

        /* renamed from: ad  reason: collision with root package name */
        public String f2928ad;

        /* renamed from: de  reason: collision with root package name */
        public String f2929de;

        /* renamed from: fe  reason: collision with root package name */
        public String f2930fe;
        public String qw;

        public de() {
            de();
        }

        public static de qw() {
            return f2927rg;
        }

        public String ad() {
            return this.f2930fe;
        }

        public final void de() {
            String str = Build.MODEL;
            this.qw = str;
            if (TextUtils.isEmpty(str)) {
                this.qw = "NUL";
            } else {
                this.qw = this.qw.replace("_", "-");
            }
            String str2 = Build.MANUFACTURER;
            this.f2928ad = str2;
            if (TextUtils.isEmpty(str2)) {
                this.f2928ad = "NUL";
            } else {
                this.f2928ad = this.f2928ad.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            this.f2929de = str3;
            this.f2929de = TextUtils.isEmpty(str3) ? "0.0" : this.f2929de.replace("_", "-");
            this.f2930fe = fe();
        }

        public final String fe() {
            String str = this.qw;
            String str2 = this.f2929de;
            int i2 = Build.VERSION.SDK_INT;
            String str3 = this.f2928ad;
            return str + "_" + str2 + "_" + i2 + "_" + str3;
        }
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public static qw f2931ad = new qw();
        public static HashMap<String, Integer> qw;

        /* renamed from: fe.fe.pf.th.qw.ppp$qw$qw  reason: collision with other inner class name */
        public static class C0141qw {

            /* renamed from: ad  reason: collision with root package name */
            public String f2932ad;

            /* renamed from: de  reason: collision with root package name */
            public String f2933de;

            /* renamed from: fe  reason: collision with root package name */
            public int f2934fe;
            public String qw;

            public C0141qw(Context context) {
                ad(context);
            }

            @SuppressLint({"MissingPermission"})
            public final void ad(Context context) {
                NetworkInfo networkInfo;
                try {
                    networkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Exception unused) {
                    networkInfo = null;
                }
                if (networkInfo != null) {
                    if ("wifi".equals(networkInfo.getTypeName().toLowerCase())) {
                        this.f2933de = "wifi";
                    } else {
                        qw(context, networkInfo);
                        this.f2933de = this.qw;
                    }
                    this.f2934fe = networkInfo.getSubtype();
                    networkInfo.getSubtypeName();
                }
            }

            public int de() {
                return this.f2934fe;
            }

            public String fe() {
                return this.f2933de;
            }

            public final void qw(Context context, NetworkInfo networkInfo) {
                String lowerCase;
                if (!(networkInfo.getExtraInfo() == null || (lowerCase = networkInfo.getExtraInfo().toLowerCase()) == null)) {
                    if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                        this.qw = lowerCase;
                        this.f2932ad = "10.0.0.172";
                        return;
                    } else if (lowerCase.startsWith("ctwap")) {
                        this.qw = lowerCase;
                        this.f2932ad = "10.0.0.200";
                        return;
                    } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                        this.qw = lowerCase;
                        return;
                    }
                }
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost != null && defaultHost.length() > 0) {
                    this.f2932ad = defaultHost;
                    if (!"10.0.0.172".equals(defaultHost.trim()) && !"10.0.0.200".equals(this.f2932ad.trim())) {
                        Integer.toString(defaultPort);
                    }
                }
            }
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>();
            qw = hashMap;
            hashMap.put("WIFI", 1);
            qw.put("3GNET", 21);
            qw.put("3GWAP", 22);
            qw.put("CMNET", 31);
            qw.put("UNINET", 32);
            qw.put("CTNET", 33);
            qw.put("CMWAP", 41);
            qw.put("UNIWAP", 42);
            qw.put("CTWAP", 43);
        }

        public static qw qw() {
            return f2931ad;
        }

        public String ad(Context context) {
            StringBuilder sb;
            C0141qw qwVar = new C0141qw(context);
            String fe2 = qwVar.fe();
            int de2 = qwVar.de();
            int i2 = 5;
            if (!TextUtils.isEmpty(fe2)) {
                Integer num = qw.get(fe2.toUpperCase());
                if (num != null) {
                    i2 = num;
                }
                sb = new StringBuilder();
            } else {
                sb = new StringBuilder();
            }
            sb.append(i2);
            sb.append("_");
            sb.append(de2);
            return sb.toString();
        }
    }

    public String a() {
        return de.qw().ad();
    }

    public String a(Context context) {
        return ad.qw().ad(context);
    }

    public long b() {
        return System.currentTimeMillis();
    }

    public String b(Context context) {
        return (context == null || context.getApplicationContext() == null) ? "" : context.getApplicationContext().getPackageName();
    }

    public String c(Context context) {
        return fe.fe.pf.ad.th(context).uk();
    }

    public String d(Context context) {
        return qw.qw().ad(context);
    }
}
