package fe.fe.ddd.th.ad;

import android.text.TextUtils;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.cloudcommand.processor.ICloudCommandObserver;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.th.qw.ad;
import fe.fe.ddd.yj.ad.de;
import fe.fe.ddd.yj.ad.fe;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qw implements ICloudControlProcessor {
    public ListHolder<ICloudCommandObserver> qw;

    public qw() {
        rg();
    }

    public static SharedPrefsWrapper th() {
        return new SharedPrefsWrapper("com.baidu.searchbox_cloud_command");
    }

    public de ad(String str, boolean z, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() == 0) {
            return null;
        }
        String string = th().getString("command_cloudconfig_version", "0");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("step", string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new de(ActionJsonData.TAG_COMMAND, (Object) null, (HashMap<String, String>) null, "", jSONObject2);
    }

    public final ICloudCommandObserver de(String str) {
        ListHolder<ICloudCommandObserver> listHolder = this.qw;
        if (listHolder == null || listHolder.qw() == null || this.qw.qw().size() <= 0) {
            return null;
        }
        for (ICloudCommandObserver next : this.qw.qw()) {
            if (TextUtils.equals(str, next.ad())) {
                return next;
            }
        }
        return null;
    }

    public final void fe(JSONArray jSONArray, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        ICloudControlUBCCallBack iCloudControlUBCCallBack2 = iCloudControlUBCCallBack;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i5);
            JSONObject jSONObject2 = new JSONObject();
            if (optJSONObject != null) {
                i2++;
                String optString = optJSONObject.optString("type");
                String optString2 = optJSONObject.optString("msgid");
                String optString3 = optJSONObject.optString("version");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                jSONObject2.put("product", optString);
                jSONObject2.put("version", optString2);
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                    jSONObject2.put("valid", "0");
                    jSONArray2.put(jSONObject2);
                } else {
                    if (ad.ad().de(optString2, 1).size() <= 0) {
                        ICloudCommandObserver de2 = de(optString);
                        if (de2 != null) {
                            de2.qw(optJSONObject2);
                            ad.ad().qw(optString, optString2, 1, optString3, System.currentTimeMillis());
                            i3++;
                            jSONObject2.put("valid", "1");
                        } else {
                            jSONObject2.put("valid", "0");
                        }
                    } else {
                        i4++;
                        jSONObject2.put("valid", "2");
                    }
                    jSONArray2.put(jSONObject2);
                }
            }
        }
        jSONObject.put("count", String.format("%s,%s,%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}));
        jSONObject.put("items", jSONArray2);
        if (iCloudControlUBCCallBack2 != null) {
            iCloudControlUBCCallBack2.qw(jSONObject);
        }
    }

    public void qw(fe feVar, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        JSONObject ad2 = feVar.ad();
        if (ad2 != null) {
            String optString = ad2.optString("step");
            if (!TextUtils.isEmpty(optString)) {
                th().putString("command_cloudconfig_version", optString);
            }
            JSONArray optJSONArray = ad2.optJSONArray("list");
            if (optJSONArray != null) {
                fe(optJSONArray, iCloudControlUBCCallBack);
                if (AppConfig.rg()) {
                    "service data " + ad2;
                }
            }
        }
    }

    public void rg() {
        fe.fe.vvv.qw.qw.ad de2 = fe.fe.vvv.qw.qw.ad.de();
        this.qw = de2;
        de2.ad(new ad());
    }
}
