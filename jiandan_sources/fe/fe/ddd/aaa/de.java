package fe.fe.ddd.aaa;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ubcprocessor.UBCCloudConfigObserver;
import com.baidu.ubc.IUBCStatisticCallback;
import com.baidu.ubc.UBCManager;
import fe.fe.ddd.yj.ad.fe;
import fe.fe.mmm.nn;
import fe.fe.vvv.ad.ad.ad;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class de implements ICloudControlProcessor {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f1312ad = false;
    public static final boolean qw = AppConfig.rg();

    public class qw implements IUBCStatisticCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f1313ad;
        public final /* synthetic */ ICloudControlUBCCallBack qw;

        public qw(ICloudControlUBCCallBack iCloudControlUBCCallBack, String str) {
            this.qw = iCloudControlUBCCallBack;
            this.f1313ad = str;
        }

        public void qw(JSONObject jSONObject) {
            ICloudControlUBCCallBack iCloudControlUBCCallBack;
            if (jSONObject != null && (iCloudControlUBCCallBack = this.qw) != null) {
                iCloudControlUBCCallBack.qw(jSONObject);
                if (de.this.th(jSONObject) && !TextUtils.isEmpty(this.f1313ad)) {
                    de.uk().putString("ubc_cloudconfig_version", this.f1313ad);
                }
            }
        }
    }

    public de() {
        rg();
    }

    public static SharedPrefsWrapper uk() {
        return new SharedPrefsWrapper(KVStorageFactory.getSharedPreferences("com.baidu.searchbox_ubc"));
    }

    public fe.fe.ddd.yj.ad.de ad(String str, boolean z, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() != 0) {
            return new fe.fe.ddd.yj.ad.de("ubc", uk().getString("ubc_cloudconfig_version", "0"), (HashMap<String, String>) null, "");
        }
        return null;
    }

    public void qw(fe feVar, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        String str;
        JSONObject qw2 = feVar.qw();
        JSONObject ad2 = feVar.ad();
        if (TextUtils.equals(feVar.de(), "ubc") && ad2 != null) {
            if (qw2 != null) {
                str = qw2.optString("version_asc");
            } else {
                str = "0";
            }
            boolean z = !"0".equals(str);
            nn nnVar = new nn("", ad2);
            if (nnVar.m130if()) {
                ((UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE)).registerConfig(nnVar, z, new qw(iCloudControlUBCCallBack, nnVar.uk()));
            } else if (iCloudControlUBCCallBack != null) {
                iCloudControlUBCCallBack.qw(yj());
            }
            List<UBCCloudConfigObserver> qw3 = new ad().qw.qw();
            if (qw3 != null && !qw3.isEmpty()) {
                String jSONObject = ad2.toString();
                for (UBCCloudConfigObserver qw4 : qw3) {
                    try {
                        qw4.qw(jSONObject, qw2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public final void rg() {
        if (!f1312ad) {
            String str = "";
            Context qw2 = fe.fe.ddd.i.qw.qw.qw();
            if (qw2 != null) {
                boolean z = false;
                try {
                    PackageInfo packageInfo = qw2.getPackageManager().getPackageInfo(qw2.getPackageName(), 0);
                    if (packageInfo != null) {
                        str = packageInfo.versionName;
                        String string = uk().getString("ubc_app_version", "0");
                        if (qw) {
                            "current version: " + str + ", oldVersion: " + string;
                        }
                        z = !TextUtils.equals(str, string);
                        if (z) {
                            uk().putString("ubc_cloudconfig_version", "0");
                            uk().putString("ubc_app_version", str);
                            if (qw) {
                                "reset step: 0, save app version: " + str;
                            }
                        }
                        f1312ad = true;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    if (qw) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public final boolean th(JSONObject jSONObject) {
        String[] split;
        if (!(jSONObject == null || jSONObject.length() == 0)) {
            String optString = jSONObject.optString("count");
            if (!TextUtils.isEmpty(optString) && (split = optString.split(",")) != null && split.length == 3) {
                try {
                    if (Integer.parseInt(split[0]) == Integer.parseInt(split[1]) + Integer.parseInt(split[2])) {
                        return true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    public final JSONObject yj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("items", new JSONArray());
            jSONObject.put("count", "0,0,0");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
