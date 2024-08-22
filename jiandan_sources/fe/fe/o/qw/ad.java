package fe.fe.o.qw;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.down.a.e;
import com.baidu.down.utils.CryptUtil;
import fe.fe.o.rg.de.o;
import fe.fe.o.rg.de.th;
import fe.fe.o.th.fe;
import fe.fe.o.th.ggg;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONObject;

public class ad {

    /* renamed from: ad  reason: collision with root package name */
    public Timer f2578ad;
    public long qw;

    public void fe(Context context, String str, e eVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        de deVar = new de(this, eVar, elapsedRealtime);
        Timer timer = new Timer();
        this.f2578ad = timer;
        timer.schedule(deVar, fe.fe(context, "pref_config_downinfo_url_timeout", 15) * 1000);
        o.qw(context, str, "retry", new fe(this, elapsedRealtime, eVar, context));
    }

    public final void rg(Context context, JSONObject jSONObject, th thVar) {
        if (jSONObject != null && jSONObject != null) {
            try {
                String string = jSONObject.getString("data");
                if (!TextUtils.isEmpty(string)) {
                    String qw2 = CryptUtil.qw(context, string);
                    if (!TextUtils.isEmpty(qw2)) {
                        JSONObject jSONObject2 = new JSONObject(qw2);
                        int optInt = jSONObject.optInt("status");
                        if (optInt == 0) {
                            JSONArray optJSONArray = jSONObject2.optJSONArray("vips");
                            thVar.f2648fe = jSONObject2.optString("xcode");
                            thVar.f2655yj = jSONObject2.optString("host");
                            thVar.f2652rg = jSONObject2.optInt("live_time");
                            thVar.f2654uk = ggg.qw(context);
                            if (optJSONArray != null && !TextUtils.isEmpty(thVar.f2655yj)) {
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    if (ggg.rg(optJSONArray.getString(i2))) {
                                        thVar.qw.add(optJSONArray.getString(i2));
                                    }
                                }
                            }
                        } else if (optInt == 1) {
                            thVar.f2652rg = 600;
                            thVar.f2654uk = ggg.qw(context);
                            thVar.f2649i = SystemClock.elapsedRealtime();
                        }
                        thVar.f2650o = optInt;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
