package fe.fe.pf.pf.qw.de;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.apollon.heartbeat.a;
import com.baidu.helios.common.gene.interfaces.HeliosKey;
import fe.fe.pf.yj.fe.de.rg;
import fe.fe.pf.yj.fe.de.th;
import fe.fe.pf.yj.fe.de.yj;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {

    /* renamed from: yj  reason: collision with root package name */
    public static final byte[] f2819yj = {77, 73, 78, 71};

    /* renamed from: ad  reason: collision with root package name */
    public boolean f2820ad;

    /* renamed from: de  reason: collision with root package name */
    public Set<String> f2821de;

    /* renamed from: fe  reason: collision with root package name */
    public String f2822fe;
    public long qw;

    /* renamed from: rg  reason: collision with root package name */
    public Context f2823rg;

    /* renamed from: th  reason: collision with root package name */
    public int f2824th;

    public static String[] ad(Signature[] signatureArr) {
        int length = signatureArr.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = th.de(signatureArr[i2].toByteArray());
        }
        return strArr;
    }

    public static boolean o(String str, Context context, JSONObject jSONObject, Set<String> set) throws JSONException, PackageManager.NameNotFoundException {
        JSONArray jSONArray = jSONObject.getJSONArray("sigs");
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr[i2] = jSONArray.getString(i2);
        }
        String[] ad2 = ad(context.getPackageManager().getPackageInfo(str, 64).signatures);
        if (ad2 != null && ad2.length > 0) {
            Collections.addAll(set, ad2);
        }
        return yj(strArr, ad2);
    }

    public static boolean yj(String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (String add : strArr) {
            hashSet.add(add);
        }
        HashSet hashSet2 = new HashSet();
        for (String add2 : strArr2) {
            hashSet2.add(add2);
        }
        return hashSet.equals(hashSet2);
    }

    public Set<String> de() {
        return this.f2821de;
    }

    public long fe() {
        return this.qw;
    }

    public final boolean i(JSONObject jSONObject) {
        rg rgVar = new rg();
        rgVar.ad(jSONObject.optLong("flags"));
        String optString = jSONObject.optString("package", "");
        long qw2 = rgVar.qw(7);
        if (!optString.equals("") || qw2 == 4) {
            if (qw2 == 0) {
                if (!optString.equals(this.f2822fe)) {
                    this.f2824th |= 32;
                    return false;
                }
            } else if (qw2 == 1) {
                String str = this.f2822fe;
                if (str == null || !str.startsWith(optString)) {
                    this.f2824th |= 32;
                    return false;
                }
            } else if (qw2 == 2) {
                try {
                    if (!Pattern.compile(optString).matcher(this.f2822fe).matches()) {
                        this.f2824th |= 32;
                        return false;
                    }
                } catch (Exception unused) {
                    this.f2824th |= 128;
                    return false;
                }
            } else if (qw2 == 4) {
                return true;
            } else {
                this.f2824th |= 64;
                return false;
            }
            return true;
        }
        this.f2824th |= 64;
        return false;
    }

    public void qw(String str, Context context) {
        this.f2822fe = str;
        this.f2823rg = context;
    }

    public final void rg(Bundle bundle, HeliosKey heliosKey) {
        if (heliosKey == null) {
            try {
                this.f2824th |= 16;
            } catch (Exception e) {
                this.f2824th |= 256;
                Log.getStackTraceString(e);
            }
        } else {
            String string = bundle.getString("helios_data");
            if (TextUtils.isEmpty(string)) {
                this.f2824th |= 1;
                return;
            }
            String string2 = bundle.getString("helios_sf");
            if (TextUtils.isEmpty(string2)) {
                this.f2824th |= 2;
                return;
            }
            byte[] decode = Base64.decode(string.getBytes(a.h), 1);
            for (int i2 = 0; i2 < decode.length; i2++) {
                decode[i2] = (byte) (decode[i2] ^ f2819yj[i2 % f2819yj.length]);
            }
            JSONObject jSONObject = new JSONObject(new String(decode));
            if (i(jSONObject)) {
                HashSet hashSet = new HashSet();
                this.f2821de = hashSet;
                if (!o(this.f2822fe, this.f2823rg, jSONObject, hashSet)) {
                    this.f2824th |= 4;
                } else if (!Arrays.equals(yj.qw(Base64.decode(string2, 0), heliosKey), th.ad(decode))) {
                    this.f2824th |= 8;
                } else {
                    this.qw = jSONObject.getLong("priority");
                    this.f2820ad = true;
                }
            }
        }
    }

    public void th(HeliosKey heliosKey, boolean z) {
        PackageInfo packageInfo;
        ActivityInfo[] activityInfoArr;
        ActivityInfo activityInfo;
        Bundle bundle;
        PackageManager packageManager = this.f2823rg.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(this.f2822fe, 2);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo != null && (activityInfoArr = packageInfo.receivers) != null && activityInfoArr.length > 0) {
            for (ActivityInfo activityInfo2 : activityInfoArr) {
                if ("com.baidu.helios.DummyProvider".equals(activityInfo2.name)) {
                    try {
                        activityInfo = packageManager.getReceiverInfo(new ComponentName(activityInfo2.packageName, activityInfo2.name), 128);
                    } catch (PackageManager.NameNotFoundException unused2) {
                        activityInfo = null;
                    }
                    if (activityInfo != null && (bundle = activityInfo.metaData) != null && bundle.containsKey("helios") && z) {
                        rg(bundle, heliosKey);
                    }
                }
            }
        }
    }

    public boolean uk() {
        return this.f2820ad;
    }
}
