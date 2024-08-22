package fe.fe.o.rg.de;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.net.MailTo;
import com.alipay.sdk.m.s.a;
import com.baidu.down.loopj.android.b.b;
import com.baidu.idl.statistics.Statistics;
import com.baidu.util.Base64Encoder;
import fe.fe.o.ad.de;
import fe.fe.o.ad.th;
import fe.fe.o.fe.qw.ad.qw;
import fe.fe.o.th.ad;
import fe.fe.o.th.fe;
import fe.fe.o.th.ggg;
import fe.fe.o.th.i;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class o {
    public static qw qw;

    public static void ad(Context context, String str, String str2, String str3, String str4, boolean z, String str5, String str6, b bVar) {
        StringBuilder sb;
        String str7;
        byte[] qw2;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("type", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("f", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("tj", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject.put("download_inner", str4);
            }
            jSONObject.put("dyneed", z ? "1" : "0");
            if (!TextUtils.isEmpty(str6)) {
                jSONObject.put("size", str6);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("from", Statistics.AS_FILE_NAME);
            jSONObject2.put("sdk_ver", "3.1");
            try {
                jSONObject2.put("domain", new URL(str4).getHost());
            } catch (Exception e) {
                e.printStackTrace();
                jSONObject2.put("domain", "gdown.baidu.com");
            }
            jSONObject.put("dyreq", jSONObject2);
            jSONObject.put("cut", ad.rg());
            jSONObject.put(MailTo.CC, ad.ad(context) + "");
            jSONObject.put("cf", ad.fe(context) + "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(jSONObject.toString()) && (qw2 = Base64Encoder.qw(ggg.uk(jSONObject.toString()).getBytes())) != null) {
            arrayList.add(new BasicNameValuePair("data", new String(qw2)));
        }
        String de2 = i.qw(context).de(fe.de(context, "pref_download_info_host", "https://appc.baidu.com/appsrv?action=downflow&native_api=1"));
        if (!TextUtils.isEmpty(str5)) {
            de2 = de2 + a.n + str5;
        }
        String uk2 = ggg.uk(ggg.yj(context));
        if (!TextUtils.isEmpty(uk2)) {
            byte[] qw3 = Base64Encoder.qw(uk2.getBytes());
            de2 = de2 + "&apn=" + new String(qw3);
        }
        if (ggg.qw(context).equals("WF")) {
            de2 = de2 + "&wfl=" + ggg.m176if(context);
        }
        if (i.ad((Context) null).qw().nn().pf()) {
            sb = new StringBuilder();
            sb.append(de2);
            str7 = "&wap=1";
        } else {
            sb = new StringBuilder();
            sb.append(de2);
            str7 = "&wap=0";
        }
        sb.append(str7);
        qw qwVar = new qw(context, true, sb.toString(), arrayList, bVar);
        qw = qwVar;
        qwVar.ad("POST");
        qw.qw();
    }

    public static void de(Context context, th thVar, fe.fe.o.ad.qw qwVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        String rg2 = z ? de.rg(context, qwVar.qw) : de.de(context, thVar, qwVar);
        if (!TextUtils.isEmpty(rg2)) {
            byte[] qw2 = Base64Encoder.qw(ggg.uk(rg2).getBytes());
            if (qw2 != null) {
                arrayList.add(new BasicNameValuePair("data", new String(qw2)));
            }
            qw qwVar2 = new qw(context, false, "http://appc.baidu.com/globalflow/v1/baseflow?action=statistics", arrayList, new ppp(context), 1);
            qw = qwVar2;
            qwVar2.ad("POST");
            qw.qw();
        }
    }

    public static void qw(Context context, String str, String str2, b bVar) {
        ad(context, str2, (String) null, (String) null, str, true, (String) null, (String) null, bVar);
    }
}
