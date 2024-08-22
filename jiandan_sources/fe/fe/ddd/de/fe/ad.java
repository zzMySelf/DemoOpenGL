package fe.fe.ddd.de.fe;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.UBCManager;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import fe.fe.ddd.mmm.qw.uk;
import fe.fe.ddd.nn.de;
import fe.fe.ddd.o.qw;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ad implements IANRRegister {

    /* renamed from: ad  reason: collision with root package name */
    public static String f1390ad = "key_anr_active_upload";

    /* renamed from: de  reason: collision with root package name */
    public static boolean f1391de = qw.qw().getBoolean(f1390ad, false);
    public String qw = "\r\n";

    public boolean ad() {
        return f1391de;
    }

    public void qw(Context context, fe.fe.ddd.de.ad.ad adVar) {
        if (ad()) {
            AppConfig.rg();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", adVar.i());
                jSONObject.put("logid", adVar.de());
                String o2 = CommonUtils.o();
                if (o2 != null) {
                    jSONObject.put(UrlOcrConfig.IdCardKey.OS_VERSION, o2);
                }
                String qw2 = CommonUtils.qw();
                if (qw2 != null) {
                    jSONObject.put("appversion", qw2);
                }
                jSONObject.put("cpu", CommonUtils.ad());
                jSONObject.put("root", CommonUtils.ppp());
                jSONObject.put("emulator", CommonUtils.de());
                jSONObject.put("inStorage", CommonUtils.th());
                jSONObject.put("exStorage", CommonUtils.fe());
                jSONObject.put("isLowMemory", CommonUtils.nn());
                jSONObject.put("heap", CommonUtils.rg());
                jSONObject.put("sysMem", CommonUtils.vvv());
                jSONObject.put("VSSRSS", CommonUtils.xxx());
                jSONObject.put("PSS", CommonUtils.pf());
                jSONObject.put("procBit", CommonUtils.m36switch());
                jSONObject.put("ROM", CommonUtils.when());
                jSONObject.put("memory", String.valueOf(CommonUtils.uk()));
                if (de.qw() >= 0) {
                    jSONObject.put("linemapping", de.qw());
                }
                String ggg = CommonUtils.ggg("ruka_config");
                if (ggg != null) {
                    jSONObject.put("sdkversion", ggg);
                }
                String i2 = CommonUtils.i();
                if (i2 != null) {
                    jSONObject.put("network", i2);
                }
                String str = CommonUtils.m35if();
                if (str != null) {
                    jSONObject.put("packagename", str);
                }
                jSONObject.put(UBCManager.CONTENT_KEY_PAGE, adVar.ad());
                jSONObject.put("fileid", adVar.de());
                jSONObject.put("anrTimeStamp", adVar.th());
                jSONObject.put("launchTime", String.valueOf(de.ad()));
                String rg2 = adVar.rg();
                if (AppConfig.rg()) {
                    "stack format before: " + rg2;
                }
                String str2 = "ANR" + this.qw + this.qw + rg2;
                jSONObject.put("stacktrace", str2);
                if (AppConfig.rg()) {
                    "stack format after: " + str2;
                }
                LinkedList<uk> uk2 = adVar.uk();
                if (uk2 != null && uk2.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    int i3 = 1;
                    int size = uk2.size() - 1;
                    while (true) {
                        uk ukVar = uk2.get(size);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("time", ukVar.yj());
                        jSONObject2.put(UBCManager.CONTENT_KEY_PAGE, fe.fe.ddd.nn.fe.qw.qw(ukVar));
                        jSONObject2.put(NotificationCompat.CATEGORY_EVENT, ukVar.de());
                        jSONArray.put(jSONObject2);
                        int i4 = i3 + 1;
                        if (i3 >= 20) {
                            break;
                        }
                        int i5 = size - 1;
                        if (size <= 0) {
                            break;
                        }
                        size = i5;
                        i3 = i4;
                    }
                    jSONObject.put("pageTrace", jSONArray);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(UBCManager.CONTENT_KEY_EXT, jSONObject);
                if (AppConfig.rg()) {
                    jSONObject3.toString();
                }
                UBCManager uBCManager = (UBCManager) fe.fe.vvv.ad.ad.ad.qw(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent("1794", jSONObject3);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
