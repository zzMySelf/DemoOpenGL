package fe.fe.ddd.uk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.client.bean.BLCPResponse;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.p000if.fe;
import fe.fe.ddd.yj.ad.de;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {

    /* renamed from: th  reason: collision with root package name */
    public static qw f1668th;

    /* renamed from: ad  reason: collision with root package name */
    public boolean f1669ad;

    /* renamed from: de  reason: collision with root package name */
    public byte[] f1670de;

    /* renamed from: fe  reason: collision with root package name */
    public BLCPResponse f1671fe = new C0089qw();
    public String qw = "CloudControlBlCPManager";

    /* renamed from: rg  reason: collision with root package name */
    public BroadcastReceiver f1672rg = new ad();

    public class ad extends BroadcastReceiver {

        /* renamed from: fe.fe.ddd.uk.qw$ad$qw  reason: collision with other inner class name */
        public class C0088qw implements Runnable {
            public C0088qw() {
            }

            public void run() {
                qw.this.rg();
            }
        }

        public ad() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.baidu.lcp.sdk.broadcast".equals(intent.getAction())) {
                boolean z = intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1) == 0;
                if (AppConfig.rg()) {
                    String unused = qw.this.qw;
                    "长连接是否已连接 ：" + intent.getIntExtra("com.baidu.lcp.sdk.connect.state", -1);
                }
                if (qw.this.f1669ad && z) {
                    fe.de(new C0088qw(), "lcp_login_cloud", 2);
                }
            }
        }
    }

    /* renamed from: fe.fe.ddd.uk.qw$qw  reason: collision with other inner class name */
    public class C0089qw implements BLCPResponse {
        public C0089qw() {
        }

        public void qw(int i2, String str, long j, long j2, long j3, byte[] bArr) {
            if (AppConfig.rg()) {
                String unused = qw.this.qw;
                "收到数据 response :errorCode:" + i2 + "errorMsg:" + str + "data:" + new String(bArr);
            }
            if (i2 == 0) {
                int i3 = (j2 > 1 ? 1 : (j2 == 1 ? 0 : -1));
                if (i3 == 0 || j2 == 2) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr));
                        if (AppConfig.rg()) {
                            String unused2 = qw.this.qw;
                            "response is " + jSONObject.toString();
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject("msgdata");
                        if (optJSONObject != null) {
                            String str2 = i3 == 0 ? "lcslogin" : "lcs";
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("version_asc", "1");
                            fe.fe.ddd.yj.qw.ad().qw(optJSONObject, jSONObject2, str2);
                        }
                    } catch (JSONException unused3) {
                    }
                }
            }
        }
    }

    public static qw de() {
        synchronized (qw.class) {
            if (f1668th == null) {
                f1668th = new qw();
            }
        }
        return f1668th;
    }

    public final byte[] fe() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        Uri parse = Uri.parse(fe.fe.ddd.yj.th.ad.qw(""));
        for (String next : parse.getQueryParameterNames()) {
            jSONObject2.put(next, parse.getQueryParameter(next));
        }
        jSONObject.put("params", jSONObject2);
        ArrayList<de> de2 = fe.fe.ddd.yj.qw.ad().de("0");
        for (int i2 = 0; i2 < de2.size(); i2++) {
            de deVar = de2.get(i2);
            jSONObject3.put(deVar.th(), deVar.de());
        }
        jSONObject.put("filter", jSONObject3);
        if (AppConfig.rg()) {
            "login json " + jSONObject.toString();
        }
        return jSONObject.toString().getBytes();
    }

    public void rg() {
        BLCPRequest bLCPRequest = new BLCPRequest();
        bLCPRequest.qw = 4;
        bLCPRequest.f866ad = 1;
        bLCPRequest.f868fe = System.currentTimeMillis();
        try {
            if (this.f1670de == null) {
                this.f1670de = fe();
            }
            bLCPRequest.f867de = this.f1670de;
        } catch (JSONException unused) {
        }
        if (bLCPRequest.f867de.length > 0) {
            fe.fe.p004if.qw.ad.qw.de(bLCPRequest, this.f1671fe);
            fe.fe.p004if.qw.ad.fe.qw qwVar = new fe.fe.p004if.qw.ad.fe.qw();
            qwVar.qw = 4;
            qwVar.f866ad = 2;
            fe.fe.p004if.qw.ad.qw.de(qwVar, this.f1671fe);
        }
    }

    public void th(Context context) {
        this.f1669ad = fe.fe.p004if.qw.ad.qw.fe(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.lcp.sdk.broadcast");
        LocalBroadcastManager.getInstance(context).registerReceiver(this.f1672rg, intentFilter);
        if (fe.fe.p004if.qw.ad.qw.ad() == 0) {
            rg();
        }
    }
}
