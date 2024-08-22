package fe.fe.ddd.nn.rg;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.aperf.param.dye.IDyeConfig;
import com.baidu.searchbox.aperf.param.launch.ILaunchType;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.devicescore.IDeviceScore;
import com.baidu.ubc.UBCManager;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import fe.fe.ddd.mmm.qw.uk;
import fe.fe.ddd.nn.de;
import fe.fe.ddd.o.qw;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ad extends fe.fe.ddd.ppp.ad.ad {

    /* renamed from: ad  reason: collision with root package name */
    public static String f1513ad = "key_block_active_upload";

    /* renamed from: de  reason: collision with root package name */
    public static boolean f1514de = qw.qw().getBoolean(f1513ad, false);
    public String qw = "\r\n";

    public void ad(Context context, fe.fe.ddd.ppp.qw.qw qwVar) {
        if (!f1514de) {
            boolean rg2 = AppConfig.rg();
            return;
        }
        boolean rg3 = AppConfig.rg();
        JSONObject jSONObject = new JSONObject();
        try {
            String o2 = CommonUtils.o();
            if (o2 != null) {
                jSONObject.put(UrlOcrConfig.IdCardKey.OS_VERSION, o2);
            }
            jSONObject.put("memory", CommonUtils.uk());
            String qw2 = CommonUtils.qw();
            if (qw2 != null) {
                jSONObject.put("appversion", qw2);
            }
            String ggg = CommonUtils.ggg("ruka_config");
            if (ggg != null) {
                jSONObject.put("sdkversion", ggg);
            }
            String ad2 = CommonUtils.ad();
            if (ad2 != null) {
                jSONObject.put("cpu", ad2);
            }
            jSONObject.put("root", CommonUtils.ppp());
            jSONObject.put("emulator", CommonUtils.de());
            jSONObject.put("inStorage", CommonUtils.th());
            jSONObject.put("exStorage", CommonUtils.fe());
            jSONObject.put("heap", CommonUtils.rg());
            jSONObject.put("sysMem", CommonUtils.vvv());
            jSONObject.put("isLowMemory", CommonUtils.nn());
            jSONObject.put("VSSRSS", CommonUtils.xxx());
            jSONObject.put("PSS", CommonUtils.pf());
            jSONObject.put("procBit", CommonUtils.m36switch());
            jSONObject.put("ROM", CommonUtils.when());
            if (de.qw() >= 0) {
                jSONObject.put("linemapping", de.qw());
            }
            IDeviceScore iDeviceScore = (IDeviceScore) fe.fe.vvv.ad.ad.ad.qw(IDeviceScore.qw);
            if (iDeviceScore != null) {
                jSONObject.put("devicescore", String.valueOf(iDeviceScore.qw(context)));
            }
            String i2 = CommonUtils.i();
            if (i2 != null) {
                jSONObject.put("network", i2);
            }
            String str = CommonUtils.m35if();
            if (str != null) {
                jSONObject.put("packagename", str);
            }
            IDyeConfig qw3 = fe.fe.ddd.fe.ad.de.ad.qw();
            if (qw3 != null && !TextUtils.isEmpty(qw3.qw())) {
                jSONObject.put("configid", qw3.qw());
            }
            ILaunchType qw4 = fe.fe.ddd.fe.ad.fe.ad.qw();
            if (qw4 != null) {
                jSONObject.put("launchtype", qw4.qw());
            }
            jSONObject.put("launchTime", String.valueOf(de.ad()));
            jSONObject.put("logid", qwVar.rg());
            jSONObject.put(UBCManager.CONTENT_KEY_PAGE, qwVar.ad());
            jSONObject.put("cpuusage", qwVar.qw());
            jSONObject.put("duration", qwVar.de());
            jSONObject.put("type", qwVar.i());
            jSONObject.put("startlagtime", qwVar.yj());
            jSONObject.put("endlagtime", qwVar.fe());
            String sb = qwVar.th().toString();
            if (AppConfig.rg()) {
                "stack format before: " + sb;
            }
            String[] split = sb.split(this.qw + this.qw);
            if (split.length > 0) {
                String str2 = split[0];
                if (str2.length() > 0 && str2.contains("stack = ")) {
                    sb = "Looper" + qwVar.th().toString().replace(str2, "");
                }
            }
            jSONObject.put("stacktrace", sb);
            if (AppConfig.rg()) {
                "stack format after: " + sb;
            }
            LinkedList<uk> uk2 = qwVar.uk();
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
            UBCManager uBCManager = (UBCManager) fe.fe.vvv.ad.ad.ad.qw(UBCManager.SERVICE_REFERENCE);
            if (uBCManager != null) {
                uBCManager.onEvent("1157", jSONObject3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean qw() {
        return f1514de;
    }
}
