package fe.fe.th.th;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.android.common.util.CommonParam;
import com.baidu.clientupdate.appinfo.ClientUpdateInfo;
import com.baidu.clientupdate.appinfo.RuleInfo;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import fe.fe.th.ad.de;
import fe.fe.th.uk.o;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class qw {
    public static String a;
    public static String aaa;
    public static StringBuilder b;
    public static String ddd;
    public static String eee;
    public static String mmm;
    public static String nn;
    public static String qqq;
    public static String rrr;
    public static String tt;
    public static qw vvv;
    public static Context xxx;

    /* renamed from: ad  reason: collision with root package name */
    public String f3131ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f3132de = false;

    /* renamed from: fe  reason: collision with root package name */
    public String f3133fe;
    public de ggg;

    /* renamed from: i  reason: collision with root package name */
    public String f3134i;

    /* renamed from: if  reason: not valid java name */
    public String f98if;

    /* renamed from: o  reason: collision with root package name */
    public ActivityManager f3135o;

    /* renamed from: pf  reason: collision with root package name */
    public String f3136pf;
    public Boolean ppp = Boolean.FALSE;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public Map f3137rg = new HashMap();

    /* renamed from: switch  reason: not valid java name */
    public String f99switch;

    /* renamed from: th  reason: collision with root package name */
    public String f3138th;

    /* renamed from: uk  reason: collision with root package name */
    public String f3139uk;
    public String when;

    /* renamed from: yj  reason: collision with root package name */
    public String f3140yj;

    public qw(Context context) {
        Context applicationContext = context.getApplicationContext();
        xxx = applicationContext;
        this.ggg = de.ad(applicationContext);
        m220if();
    }

    public static boolean pf(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static synchronized qw qw(Context context) {
        qw qwVar;
        synchronized (qw.class) {
            if (vvv == null) {
                vvv = new qw(context);
            }
            qwVar = vvv;
        }
        return qwVar;
    }

    public String ad() {
        if (this.ppp.booleanValue()) {
            fe.fe.aaa.qw.ad("BaiduParamManager", "读取手机根目录cfg文件");
            m221switch();
            String str = this.f98if;
            if (str != null) {
                return str;
            }
        }
        return "https://update.baidu.com";
    }

    public void ddd(String str) {
        rrr = str;
    }

    public void de(String str, String str2) {
        this.f3137rg.put(str, str2);
    }

    public void fe(boolean z) {
        this.ppp = Boolean.valueOf(z);
    }

    public final String ggg() {
        String str;
        if (!TextUtils.isEmpty(mmm)) {
            return mmm;
        }
        try {
            str = CommonParam.getCUID(xxx);
        } catch (Exception e) {
            e.printStackTrace();
            str = System.currentTimeMillis() + "";
        }
        fe.fe.aaa.qw.qw("BaiduParamManager", "new generated uid " + str);
        return str;
    }

    public String i() {
        RuleInfo th2 = fe.fe.th.uk.qw.ad(xxx).th();
        return th2 != null ? th2.mUpgradeid : "-1";
    }

    /* renamed from: if  reason: not valid java name */
    public final void m220if() {
        this.qw = xxx.getPackageName();
        this.f3135o = (ActivityManager) xxx.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        try {
            PackageInfo packageInfo = xxx.getPackageManager().getPackageInfo(this.qw, 64);
            ddd = packageInfo.versionName;
            nn = String.valueOf(packageInfo.versionCode);
            a = new File(packageInfo.applicationInfo.publicSourceDir).length() + "";
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        tt = o.ad(xxx, this.qw);
        mmm = ggg();
        this.f3131ad = when();
        aaa = th(xxx);
    }

    public final String mmm() {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) xxx.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
            return Long.toHexString(memoryInfo.totalMem);
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            fe.fe.aaa.qw.ad("BaiduParamManager", "读取meminfo第一行，系统总内存大小==" + readLine);
            bufferedReader.close();
            if (readLine != null) {
                String[] split = readLine.split("\\s+");
                for (String de2 : split) {
                    fe.fe.aaa.qw.de("BaiduParamManager", de2);
                }
                try {
                    if (pf(split[1])) {
                        return Long.toHexString((long) (Integer.valueOf(split[1]).intValue() * 1024));
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final String nn() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.f3135o.getMemoryInfo(memoryInfo);
        fe.fe.aaa.qw.qw("BaiduParamManager", "Avaialbe memory: " + memoryInfo.availMem);
        return Long.toHexString(memoryInfo.availMem);
    }

    public final String o(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return "";
        }
        if (activeNetworkInfo.getTypeName().toLowerCase().equals("wifi")) {
            return "WF";
        }
        int subtype = activeNetworkInfo.getSubtype();
        return (subtype == 7 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 10 || subtype == 9 || subtype == 3 || subtype == 14 || subtype == 12 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "2G";
    }

    public void ppp(String str) {
        qqq = str;
    }

    public String rg() {
        StringBuilder sb = new StringBuilder();
        b = sb;
        sb.append("{\"cid\":\"" + mmm + "\",");
        StringBuilder sb2 = b;
        sb2.append("\"pl\":\"" + qqq + "\",");
        StringBuilder sb3 = b;
        sb3.append("\"os\":\"" + aaa + "\",");
        StringBuilder sb4 = b;
        sb4.append("\"ot\":\"" + eee + "\",");
        StringBuilder sb5 = b;
        sb5.append("\"cl\":\"" + rrr + "\",");
        StringBuilder sb6 = b;
        sb6.append("\"cvn\":\"" + ddd + "\",");
        StringBuilder sb7 = b;
        sb7.append("\"cvc\":\"" + nn + "\",");
        StringBuilder sb8 = b;
        sb8.append("\"csz\":\"" + a + "\",");
        StringBuilder sb9 = b;
        sb9.append("\"cmd5\":\"" + tt + "\",");
        ClientUpdateInfo qw2 = fe.fe.th.uk.qw.ad(xxx).qw();
        RuleInfo th2 = fe.fe.th.uk.qw.ad(xxx).th();
        if (qw2 == null || th2 == null) {
            b.append("\"ug\":\"\",");
            b.append("\"vn\":\"\",");
            b.append("\"vc\":\"\",");
            b.append("\"sz\":\"\",");
            b.append("\"md5\":\"\",");
        } else {
            StringBuilder sb10 = b;
            sb10.append("\"ug\":\"" + th2.mUpgradeid + "\",");
            StringBuilder sb11 = b;
            sb11.append("\"vn\":\"" + qw2.mVername + "\",");
            StringBuilder sb12 = b;
            sb12.append("\"vc\":\"" + qw2.mVercode + "\",");
            StringBuilder sb13 = b;
            sb13.append("\"sz\":\"" + qw2.mSize + "\",");
            StringBuilder sb14 = b;
            sb14.append("\"md5\":\"" + qw2.mApkMd5 + "\",");
        }
        fe.fe.aaa.qw.ad("BaiduParamManager", b.toString());
        return b.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b A[SYNTHETIC, Splitter:B:21:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066 A[SYNTHETIC, Splitter:B:26:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* renamed from: switch  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m221switch() {
        /*
            r6 = this;
            java.lang.String r0 = "server"
            java.io.File r1 = new java.io.File
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r3 = "clientupdate_server.cfg"
            r1.<init>(r2, r3)
            boolean r2 = r1.exists()
            java.lang.String r3 = "BaiduParamManager"
            if (r2 == 0) goto L_0x006f
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0055 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0055 }
            r2.load(r5)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.lang.String r1 = r2.getProperty(r0)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            if (r1 == 0) goto L_0x0033
            java.lang.String r0 = r2.getProperty(r0)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            r6.f98if = r0     // Catch:{ Exception -> 0x0050, all -> 0x004d }
        L_0x0033:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            r0.<init>()     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.lang.String r1 = "设置server:"
            r0.append(r1)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.lang.String r1 = r6.f98if     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            r0.append(r1)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            fe.fe.aaa.qw.qw(r3, r0)     // Catch:{ Exception -> 0x0050, all -> 0x004d }
            r5.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x004d:
            r0 = move-exception
            r4 = r5
            goto L_0x0064
        L_0x0050:
            r0 = move-exception
            r4 = r5
            goto L_0x0056
        L_0x0053:
            r0 = move-exception
            goto L_0x0064
        L_0x0055:
            r0 = move-exception
        L_0x0056:
            r0.printStackTrace()     // Catch:{ all -> 0x0053 }
            if (r4 == 0) goto L_0x0063
            r4.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0063:
            return
        L_0x0064:
            if (r4 == 0) goto L_0x006e
            r4.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r1 = move-exception
            r1.printStackTrace()
        L_0x006e:
            throw r0
        L_0x006f:
            java.lang.String r0 = "not found config file"
            fe.fe.aaa.qw.qw(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.th.qw.m221switch():void");
    }

    public final String th(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        int i4 = displayMetrics.densityDpi;
        String str = !TextUtils.isEmpty(this.f99switch) ? this.f99switch : SapiDeviceInfo.OS_TYPE;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append("_");
        stringBuffer.append(i3);
        stringBuffer.append("_");
        stringBuffer.append(str);
        stringBuffer.append("_");
        stringBuffer.append(ddd);
        stringBuffer.append("_");
        stringBuffer.append(i4);
        String stringBuffer2 = stringBuffer.toString();
        fe.fe.aaa.qw.qw("BaiduParamManager", "ua = " + stringBuffer2);
        return stringBuffer2;
    }

    public void uk(boolean z) {
        this.f3132de = z;
    }

    public void vvv(String str) {
        eee = str;
    }

    public final String when() {
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        int i2 = Build.VERSION.SDK_INT;
        String str3 = Build.MANUFACTURER;
        String str4 = str.replace("_", "-") + "_" + str2.replace("_", "-") + "_" + i2 + "_" + str3.replace("_", "-");
        fe.fe.aaa.qw.qw("BaiduParamManager", "get ut : " + str4);
        return str4;
    }

    public final String xxx() {
        String mmm2 = mmm();
        if (mmm2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(mmm2);
        sb.append("_");
        sb.append(nn());
        return sb.reverse().toString();
    }

    public String yj(String str) {
        try {
            ad adVar = new ad(ad() + str);
            adVar.qw("versioncode", nn);
            adVar.qw("versionname", ddd);
            adVar.qw("pkgname", this.qw);
            adVar.qw("cuid", mmm);
            adVar.qw("ua", aaa);
            adVar.qw("ut", this.f3131ad);
            adVar.qw("auto", String.valueOf(this.f3132de));
            String o2 = o(xxx);
            this.f3133fe = o2;
            adVar.qw("network", o2);
            String xxx2 = xxx();
            this.f3136pf = xxx2;
            if (xxx2 != null) {
                adVar.qw("utm", xxx2);
            }
            adVar.qw("osname", qqq);
            adVar.qw("typeid", eee);
            adVar.qw("from", rrr);
            adVar.qw("osbranch", this.f3138th);
            adVar.qw("cfrom", this.f3140yj);
            adVar.qw("ignore", this.f3139uk);
            adVar.qw("time", this.f3134i);
            for (Map.Entry entry : this.f3137rg.entrySet()) {
                adVar.ad((String) entry.getKey(), (String) entry.getValue());
            }
            if (!TextUtils.isEmpty(tt)) {
                adVar.qw("usermd5", tt);
            }
            String ad2 = o.ad(xxx, "com.baidu.appsearch");
            this.when = ad2;
            if (!TextUtils.isEmpty(ad2)) {
                adVar.qw("appsearchmd5", this.when);
            }
            de deVar = this.ggg;
            String i2 = i();
            String rg2 = rg();
            deVar.th(i2, "0", rg2, "a2", "0", (System.currentTimeMillis() / 1000) + "", "", "SDKParamManager", "");
            return adVar.toString();
        } catch (Exception e) {
            e.printStackTrace();
            de deVar2 = this.ggg;
            String i3 = i();
            String rg3 = rg();
            deVar2.th(i3, "0", rg3, "a2", "1", (System.currentTimeMillis() / 1000) + "", "", "SDKParamManager", e.toString());
            return "";
        }
    }
}
