package fe.fe.o.rg.de;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.down.loopj.android.b.b;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import fe.fe.o.ad.de;
import fe.fe.o.ad.qw;
import fe.fe.o.th.fe;
import org.json.JSONException;
import org.json.JSONObject;

public final class ppp implements b {
    public final /* synthetic */ Context qw;

    public ppp(Context context) {
        this.qw = context;
    }

    public void a() {
    }

    public void a(String str) {
        qw qw2;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(WXLoginActivity.y) == 0) {
                    if (!TextUtils.isEmpty(jSONObject.optString("data", "")) && (qw2 = de.qw(this.qw, jSONObject.optString("data", ""))) != null) {
                        i.ad((Context) null).qw().ddd().f2645rg = qw2;
                    }
                    fe.th(this.qw, fe.f2671rg, System.currentTimeMillis());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
