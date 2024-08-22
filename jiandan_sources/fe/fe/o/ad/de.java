package fe.fe.o.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.idl.statistics.Statistics;
import com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate;
import fe.fe.o.rg.de.rg;
import fe.fe.o.th.fe;
import fe.fe.o.th.ggg;
import fe.fe.o.th.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class de {
    public static qw ad(String str) {
        qw qwVar = new qw();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                qwVar.qw = jSONObject.optString("cfg_ver");
                qwVar.f2456ad = Integer.parseInt(jSONObject.optString("cfg_enable", "1"));
                qwVar.f2457de = Long.parseLong(jSONObject.optString("cfg_min_time"));
                qwVar.f2458fe = Long.parseLong(jSONObject.optString("cfg_min_size"));
                qwVar.f2459rg = Math.min(86400, Long.parseLong(jSONObject.optString("cfg_min_interval")));
            } else {
                qwVar.qw = "";
                qwVar.f2456ad = 1;
                qwVar.f2457de = 5;
                qwVar.f2458fe = 102400;
                qwVar.f2459rg = 7200;
            }
            return qwVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String de(Context context, th thVar, qw qwVar) {
        th thVar2 = thVar;
        qw qwVar2 = qwVar;
        JSONObject jSONObject = new JSONObject();
        if (thVar2 != null && !ggg.th(thVar.ad())) {
            int i2 = thVar2.f2463fe;
            if (i2 == 1004 || i2 == 1006) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = 0;
                for (int i3 = 0; i3 < thVar.ad().size(); i3++) {
                    yj yjVar = (yj) thVar.ad().get(i3);
                    j += (yjVar.f2475yj + yjVar.f69switch) - yjVar.f2473th;
                }
                if (Math.abs(currentTimeMillis - thVar2.f2464rg) < qwVar2.f2457de * 1000 || j < qwVar2.f2458fe) {
                    return null;
                }
            }
            try {
                jSONObject.put("cfg_ver", qwVar2.qw);
                jSONObject.put("from", Statistics.AS_FILE_NAME);
                jSONObject.put("sdk_ver", "3.1");
                jSONObject.put("uid", i.qw(context).fe());
                jSONObject.put("ver", Statistics.AS_FILE_NAME);
                jSONObject.put("network", ggg.qw(context));
                jSONObject.put("apn", ggg.yj(context));
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    jSONObject.put("ver", packageInfo.versionCode + "");
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
                jSONObject.put("type", "0");
                jSONObject.put("docid", thVar2.f2461ad);
                jSONObject.put(DxmPassManagerDelegate.DXM_KEY_DID, thVar2.f2462de + "");
                jSONObject.put("status", thVar2.f2463fe + "");
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < thVar.ad().size(); i4++) {
                    yj yjVar2 = (yj) thVar.ad().get(i4);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("cqid", yjVar2.qw);
                    jSONObject2.put("url", yjVar2.f2466ad);
                    if (!TextUtils.isEmpty(yjVar2.f2467de)) {
                        jSONObject2.put("ip", yjVar2.f2467de);
                        jSONObject2.put("dt", yjVar2.f2468fe + "");
                    }
                    jSONObject2.put("drs", yjVar2.f2472rg);
                    long j2 = yjVar2.f68if - yjVar2.f2470o;
                    if (j2 > 0) {
                        if (yjVar2.f68if > 0) {
                            long j3 = (((yjVar2.f2475yj + yjVar2.f69switch) - yjVar2.f2473th) * 1000) / j2;
                            jSONObject2.put("dspt", j3 + "");
                            jSONObject2.put("dstart", yjVar2.f2473th + "");
                            jSONObject2.put("dend", (yjVar2.f2475yj + yjVar2.f69switch) + "");
                            jSONObject2.put("dsize", yjVar2.f2474uk + "");
                            jSONObject2.put("drnum", yjVar2.f2469i + "");
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject2.put("dspt", "0");
                    jSONObject2.put("dstart", yjVar2.f2473th + "");
                    jSONObject2.put("dend", (yjVar2.f2475yj + yjVar2.f69switch) + "");
                    jSONObject2.put("dsize", yjVar2.f2474uk + "");
                    jSONObject2.put("drnum", yjVar2.f2469i + "");
                    jSONArray.put(jSONObject2);
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                jSONObject.put("dl_info", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static boolean fe(Context context, rg rgVar) {
        return rgVar.f2644fe && rgVar.f2645rg.f2456ad != 1 && Math.abs(System.currentTimeMillis() - fe.ad(context, fe.f2671rg, 0)) > rgVar.f2645rg.f2459rg * 1000;
    }

    public static qw qw(Context context, String str) {
        qw ad2;
        if (TextUtils.isEmpty(str) || (ad2 = ad(str)) == null) {
            return ad(fe.de(context, fe.f2670fe, ""));
        }
        fe.rg(context, fe.f2670fe, str);
        return ad2;
    }

    public static String rg(Context context, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cfg_ver", str);
            jSONObject.put("from", Statistics.AS_FILE_NAME);
            jSONObject.put("sdk_ver", "3.1");
            jSONObject.put("uid", i.qw(context).fe());
            jSONObject.put("ver", Statistics.AS_FILE_NAME);
            jSONObject.put("network", ggg.qw(context));
            jSONObject.put("apn", ggg.yj(context));
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                jSONObject.put("ver", packageInfo.versionCode + "");
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            jSONObject.put("type", "1");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
