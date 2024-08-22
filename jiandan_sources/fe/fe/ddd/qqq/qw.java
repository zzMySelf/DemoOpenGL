package fe.fe.ddd.qqq;

import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.v2.IUpdatePostDataFilter;
import fe.fe.ddd.ggg.qw.ad.ad;
import fe.fe.ddd.yj.ad.de;
import fe.fe.ddd.yj.ad.fe;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class qw implements ICloudControlProcessor {

    /* renamed from: fe.fe.ddd.qqq.qw$qw  reason: collision with other inner class name */
    public class C0085qw implements IUpdatePostDataFilter {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ JSONObject f1568ad;
        public final /* synthetic */ List qw;

        public C0085qw(qw qwVar, List list, JSONObject jSONObject) {
            this.qw = list;
            this.f1568ad = jSONObject;
        }

        public boolean qw(String str, String str2) {
            List list = this.qw;
            if (list != null) {
                if (list.contains(String.format("%s/%s", new Object[]{str, str2}))) {
                    return true;
                }
            }
            return fe.fe.ddd.yj.qw.ad().yj(this.f1568ad, str, str2);
        }
    }

    public de ad(String str, boolean z, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject2.put("version", jSONObject3);
            jSONObject2.put("data", jSONObject4);
            jSONObject2.put("pubdata", jSONObject5);
            C0085qw qwVar = new C0085qw(this, ad.qw().qw(), jSONObject);
            new fe.fe.ddd.ggg.qw.de.de().qw(fe.fe.ddd.i.qw.qw.qw(), new fe.fe.ddd.ggg.qw.qw(jSONObject3, jSONObject4, jSONObject5), qwVar);
            return new de("config", jSONObject3, (HashMap<String, String>) null, (Object) null);
        } catch (Exception e) {
            if (AppConfig.rg()) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void qw(fe feVar, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        String de2 = feVar.de();
        JSONObject ad2 = feVar.ad();
        JSONObject qw = feVar.qw();
        if ("config".equals(de2) && ad2 != null) {
            try {
                fe.fe.ddd.ggg.qw.de.fe feVar2 = new fe.fe.ddd.ggg.qw.de.fe(new fe.fe.ddd.ggg.qw.de.de());
                feVar2.i(new StringReader(ad2.toString()), 16, qw);
                JSONObject rg2 = feVar2.rg();
                if (rg2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray optJSONArray = rg2.optJSONArray("detail");
                    String optString = rg2.optString("totalCount");
                    String optString2 = rg2.optString("successCount");
                    String optString3 = rg2.optString("versionFilterCount");
                    jSONObject.put("items", optJSONArray);
                    jSONObject.put("count", String.format("%s,%s,%s", new Object[]{optString, optString2, optString3}));
                    iCloudControlUBCCallBack.qw(jSONObject);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
