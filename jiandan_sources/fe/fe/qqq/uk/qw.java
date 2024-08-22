package fe.fe.qqq.uk;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.dlife.ctaccountapi.v;
import fe.fe.qqq.i.de;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class qw {

    /* renamed from: fe  reason: collision with root package name */
    public static final boolean f4432fe = AppConfig.rg();

    /* renamed from: rg  reason: collision with root package name */
    public static final String f4433rg = (fe.fe.ddd.i.qw.qw.qw().getApplicationInfo().dataDir + File.separator + "yalog/");

    /* renamed from: ad  reason: collision with root package name */
    public JSONObject f4434ad;

    /* renamed from: de  reason: collision with root package name */
    public JSONObject f4435de;
    public fe.fe.qqq.i.qw qw;

    public static class ad {
        public static final qw qw = new qw();
    }

    public static qw qw() {
        return ad.qw;
    }

    public final void ad() {
        if (this.qw == null) {
            this.qw = new fe.fe.qqq.i.qw();
        }
        de();
        fe();
    }

    public final void de() {
        if (!new File(f4433rg).exists()) {
            boolean z = f4432fe;
            return;
        }
        File file = new File(f4433rg, "yalog_cloud.txt");
        if (!file.exists()) {
            boolean z2 = f4432fe;
            this.qw.rg();
            return;
        }
        String qw2 = fe.fe.qqq.p012if.qw.qw(file);
        if (f4432fe) {
            "read from local: " + qw2;
        }
        if (TextUtils.isEmpty(qw2)) {
            this.qw.rg();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(qw2);
            this.f4434ad = jSONObject;
            this.qw.i(jSONObject.optString("sw"));
            this.qw.th(this.f4434ad.optString("cl"));
            this.qw.ggg((float) this.f4434ad.optDouble("tosize"));
            this.qw.m279if((float) this.f4434ad.optDouble("sisize"));
            this.qw.when((float) this.f4434ad.optDouble("spsize"));
            this.qw.ppp((float) this.f4434ad.optDouble("sptime"));
            this.qw.pf((float) this.f4434ad.optDouble("idsize"));
            if (this.f4434ad.has("spdelist")) {
                List asList = Arrays.asList(new String[]{this.f4434ad.optString("spdelist")});
                if (asList.size() > 0) {
                    this.qw.uk(asList);
                }
            }
            if (this.f4434ad.has("splist")) {
                JSONObject optJSONObject = this.f4434ad.optJSONObject("splist");
                ArrayList arrayList = new ArrayList();
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                        if (optJSONObject2 != null) {
                            arrayList.add(new de(next, !TextUtils.equals("0", optJSONObject2.optString("sw")), (float) optJSONObject2.optDouble("size"), (float) optJSONObject2.optDouble("time")));
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    this.qw.m280switch(arrayList);
                }
            }
        } catch (JSONException e) {
            if (f4432fe) {
                e.printStackTrace();
            }
        }
    }

    public final void fe() {
        JSONObject optJSONObject;
        if (!new File(f4433rg).exists()) {
            boolean z = f4432fe;
            return;
        }
        File file = new File(f4433rg, "yalog_id_cloud.txt");
        if (!file.exists()) {
            boolean z2 = f4432fe;
            return;
        }
        String qw2 = fe.fe.qqq.p012if.qw.qw(file);
        if (f4432fe) {
            "read from local: " + qw2;
        }
        if (!TextUtils.isEmpty(qw2)) {
            try {
                JSONObject jSONObject = new JSONObject(qw2);
                this.f4435de = jSONObject;
                if (jSONObject.has("iddemap") && (optJSONObject = this.f4435de.optJSONObject("iddemap")) != null && optJSONObject.length() > 0) {
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject.optString(next));
                    }
                    if (hashMap.size() > 0) {
                        this.qw.yj(hashMap);
                    }
                }
                if (this.f4435de.has("idlist")) {
                    JSONObject optJSONObject2 = this.f4435de.optJSONObject("idlist");
                    HashMap hashMap2 = new HashMap();
                    if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                        Iterator<String> keys2 = optJSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject(next2);
                            if (optJSONObject3 != null) {
                                hashMap2.put(next2, new fe.fe.qqq.i.ad(next2, optJSONObject3.optLong(v.d), !TextUtils.equals("0", optJSONObject3.optString("sw")), (float) optJSONObject3.optDouble("size")));
                            }
                        }
                    }
                    if (hashMap2.size() > 0) {
                        this.qw.o(hashMap2);
                    }
                }
            } catch (JSONException e) {
                if (f4432fe) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void rg(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                File file = new File(f4433rg);
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(f4433rg, str);
                File file3 = new File(f4433rg, "pre_" + str);
                file3.createNewFile();
                fe.fe.qqq.p012if.qw.ad(str2, file3);
                if (file2.exists()) {
                    file2.delete();
                }
                file3.renameTo(file2);
                if (f4432fe) {
                    "save to local: " + str2;
                }
            } catch (IOException e) {
                if (f4432fe) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void th(JSONObject jSONObject, boolean z) {
        if (jSONObject != null && jSONObject.length() != 0) {
            if (f4432fe) {
                "update Config: " + jSONObject.toString();
            }
            if (this.qw == null) {
                this.qw = new fe.fe.qqq.i.qw();
            }
            this.qw.fe(jSONObject, z);
            yj(this.qw);
        }
    }

    public final void yj(fe.fe.qqq.i.qw qwVar) {
        if (qwVar != null) {
            if (this.f4435de == null) {
                this.f4435de = new JSONObject();
            }
            try {
                Map<String, String> qw2 = qwVar.qw();
                if (qw2 != null && qw2.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (String next : qw2.keySet()) {
                        jSONObject.put(next, qw2.get(next));
                    }
                    this.f4435de.put("iddemap", jSONObject);
                }
                Map<String, fe.fe.qqq.i.ad> ad2 = qwVar.ad();
                if (ad2 != null && ad2.size() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (String next2 : ad2.keySet()) {
                        fe.fe.qqq.i.ad adVar = ad2.get(next2);
                        if (adVar != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("sw", adVar.ad() ? "1" : "0");
                            jSONObject3.put("size", (double) adVar.qw());
                            jSONObject3.put(v.d, adVar.de());
                            jSONObject2.put(next2, jSONObject3);
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        this.f4435de.put("idlist", jSONObject2);
                    }
                }
                rg("yalog_id_cloud.txt", this.f4435de.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public qw() {
        ad();
    }
}
