package fe.fe.ddd.eee;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.bdutil.cuid.sdk.AppCuidManager;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.searchbox.util.IBaiduIdentityContext;
import com.baidu.util.Base64Encoder;
import fe.fe.pf.ad;
import fe.fe.yj.de.fe;
import fe.fe.yj.de.th;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class qw {
    public static final Set<String> ppp;

    /* renamed from: switch  reason: not valid java name */
    public static final boolean f24switch = rg.qw;
    public static qw when;

    /* renamed from: ad  reason: collision with root package name */
    public String f1396ad;

    /* renamed from: de  reason: collision with root package name */
    public String f1397de;

    /* renamed from: fe  reason: collision with root package name */
    public String f1398fe;

    /* renamed from: i  reason: collision with root package name */
    public Context f1399i;

    /* renamed from: if  reason: not valid java name */
    public HashMap<String, String> f25if = new HashMap<>(2);

    /* renamed from: o  reason: collision with root package name */
    public IBaiduIdentityContext f1400o;

    /* renamed from: pf  reason: collision with root package name */
    public volatile String f1401pf = null;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public fe f1402rg;

    /* renamed from: th  reason: collision with root package name */
    public fe f1403th;

    /* renamed from: uk  reason: collision with root package name */
    public String f1404uk;

    /* renamed from: yj  reason: collision with root package name */
    public SharedPreferences f1405yj;

    static {
        HashSet hashSet = new HashSet();
        ppp = hashSet;
        hashSet.add("uid");
        ppp.add("from");
        ppp.add("ua");
        ppp.add("ut");
        ppp.add("osname");
        ppp.add("osbranch");
        ppp.add("pkgname");
        ppp.add("network");
        ppp.add("cfrom");
        ppp.add("ctv");
        ppp.add("cen");
        ppp.add("apinfo");
        ppp.add("pu");
    }

    public qw(Context context) {
        m63if(context);
    }

    public static synchronized qw fe() {
        qw qwVar;
        synchronized (qw.class) {
            if (when == null) {
                when = new qw(fe.fe.ddd.i.qw.qw.qw());
            }
            qwVar = when;
        }
        return qwVar;
    }

    public final String ad(Context context) {
        String qw2 = this.f1400o.qw(context);
        if (f24switch) {
            Log.d("BaiduIdentityManager", "load tn from R.raw.tnconfig, tn = " + qw2);
        }
        return TextUtils.isEmpty(qw2) ? "757b" : qw2;
    }

    public String de() {
        if (this.f1399i != null && TextUtils.isEmpty(this.f1401pf)) {
            this.f1401pf = de.qw().getString("cthreekey", "");
            if (TextUtils.isEmpty(this.f1401pf)) {
                this.f1401pf = ad.th(this.f1399i.getApplicationContext()).de();
                if (!TextUtils.isEmpty(this.f1401pf)) {
                    de.qw().putString("cthreekey", this.f1401pf);
                }
            }
        }
        return this.f1401pf;
    }

    public final String i(Context context) {
        int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
        int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(context);
        int densityDpi = DeviceUtil.ScreenInfo.getDensityDpi(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(displayWidth);
        stringBuffer.append("_");
        stringBuffer.append(displayHeight);
        stringBuffer.append("_");
        stringBuffer.append(SapiDeviceInfo.OS_TYPE);
        stringBuffer.append("_");
        stringBuffer.append(this.f1404uk);
        stringBuffer.append("_");
        stringBuffer.append(densityDpi);
        String stringBuffer2 = stringBuffer.toString();
        if (f24switch) {
            Log.d("BaiduIdentityManager", "ua = " + stringBuffer2);
        }
        return stringBuffer2;
    }

    /* renamed from: if  reason: not valid java name */
    public final void m63if(Context context) {
        this.f1399i = context;
        this.f1405yj = context.getSharedPreferences("identity", 0);
        this.f1404uk = o(context);
        this.f1402rg = new fe();
        m64switch();
        this.f1403th = new fe();
        new th();
        this.f1400o = ad.qw();
        if (f24switch) {
            Log.d("BaiduIdentityManager", toString());
            if (this.f1400o == null) {
                throw new RuntimeException("BaiduIdentityContext obtain Failed !!");
            }
        }
    }

    public final String o(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "0.8";
        }
    }

    public String pf() {
        return this.f1400o.getZid();
    }

    public final void qw(String str) {
        String string = this.f1405yj.getString("tntrace", "");
        if (!TextUtils.isEmpty(string)) {
            str = string + "_" + str;
        }
        SharedPreferences.Editor edit = this.f1405yj.edit();
        edit.putString("tntrace", str);
        edit.commit();
    }

    public String rg() {
        if (this.f1398fe == null) {
            this.f1398fe = th(this.f1399i);
        }
        return this.f1398fe;
    }

    /* renamed from: switch  reason: not valid java name */
    public synchronized void m64switch() {
        this.qw = i(this.f1399i);
        this.f1396ad = new String(Base64Encoder.qw(this.qw.getBytes()));
    }

    public final String th(Context context) {
        String string = this.f1405yj.getString("lasttn", "");
        String ad2 = ad(context);
        if ((!TextUtils.equals(string, ad2)) || TextUtils.isEmpty(string)) {
            SharedPreferences.Editor edit = this.f1405yj.edit();
            edit.putString("lasttn", ad2);
            edit.commit();
            qw(ad2);
            if (f24switch) {
                Log.d("BaiduIdentityManager", "load tn from apk, lastTn = " + ad2);
            }
            return ad2;
        } else if (!f24switch) {
            return string;
        } else {
            Log.d("BaiduIdentityManager", "load tn from local, lastTn = " + string);
            return string;
        }
    }

    public String toString() {
        return "BaiduIdentityManager [mUid=" + AppCuidManager.getInstance().getCuid() + ", mEnUid=" + AppCuidManager.getInstance().getEnCuid() + ", mUa=" + this.qw + ", mEnUa=" + this.f1396ad + ", mTn=" + yj() + ", mLastTn=" + rg() + ", mModel=" + this.f1402rg.fe() + ", mManufacturer=" + this.f1402rg.de() + ", mOSVersion=" + this.f1402rg.rg() + ", mDeviceInfo=" + this.f1402rg.qw() + ", mEnDeviceInfo=" + this.f1402rg.ad() + ", mSettings=" + this.f1405yj + ", mVersionName=" + this.f1404uk + ", mCtv=" + this.f1403th.qw() + ", mProcessedUa=" + this.f25if + "]";
    }

    public final String uk(Context context) {
        String string = this.f1405yj.getString("tnconfig", "");
        if (TextUtils.isEmpty(string)) {
            String ad2 = this.f1400o.ad(context);
            if (TextUtils.isEmpty(ad2)) {
                ad2 = rg();
            }
            string = ad2;
            SharedPreferences.Editor edit = this.f1405yj.edit();
            edit.putString("tnconfig", string);
            edit.commit();
        } else if (f24switch) {
            Log.d("BaiduIdentityManager", "load tn from local, tn = " + string);
        }
        return TextUtils.isEmpty(string) ? "757b" : string;
    }

    public String yj() {
        if (this.f1397de == null) {
            this.f1397de = uk(this.f1399i);
        }
        return this.f1397de;
    }
}
