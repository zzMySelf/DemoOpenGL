package fe.fe.mmm.u;

import com.baidu.ubc.constants.EnumConstants$RunTime;
import com.baidu.ubc.inter.IUBCLogIdSpService;
import com.cmic.sso.sdk.e.i;
import fe.fe.mmm.j;
import fe.fe.mmm.k;
import fe.fe.mmm.m;
import fe.fe.mmm.tt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public final Map<String, Long> f2204ad;

    /* renamed from: de  reason: collision with root package name */
    public String f2205de;

    /* renamed from: fe  reason: collision with root package name */
    public IUBCLogIdSpService f2206fe;
    public long qw;

    public static final class ad {
        public static final rg qw = new rg();
    }

    public static rg de() {
        return ad.qw;
    }

    public long ad(String str) {
        return rg(str, i.a);
    }

    public String fe(String str, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a", this.f2205de);
            jSONObject.put("s", this.qw);
            jSONObject.put(i.a, qw(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m.m127if(str, jSONObject.toString(), str2, z, EnumConstants$RunTime.CREATE_LOGID);
        return jSONObject.toString();
    }

    public final void i() {
        for (Map.Entry next : this.f2206fe.getAll().entrySet()) {
            if (next.getValue() instanceof Long) {
                this.f2204ad.put((String) next.getKey(), (Long) next.getValue());
            }
        }
    }

    public long qw(String str) {
        Long l = 1L;
        if (this.f2204ad.containsKey(str)) {
            Long l2 = this.f2204ad.get(str);
            if (l2 == null) {
                return 1;
            }
            Long valueOf = Long.valueOf(l2.longValue() + 1);
            long longValue = valueOf.longValue();
            this.f2204ad.put(str, valueOf);
            this.f2206fe.putLong(str, valueOf.longValue());
            return longValue;
        }
        this.f2204ad.put(str, l);
        this.f2206fe.putLong(str, l.longValue());
        return 1;
    }

    public final long rg(String str, String str2) {
        try {
            return new JSONObject(str).optLong(str2);
        } catch (JSONException unused) {
            return 0;
        }
    }

    public long th(String str) {
        return rg(str, "s");
    }

    public final void uk() {
        this.qw = System.currentTimeMillis() % 1000000;
        k.qw().th("key_app_version_session", this.qw);
    }

    public final boolean yj() {
        long currentTimeMillis = System.currentTimeMillis();
        long de2 = k.qw().de("key_app_version_init_time", 0);
        k.qw().th("key_app_version_init_time", currentTimeMillis);
        return de2 - currentTimeMillis > 7200000;
    }

    public rg() {
        this.f2204ad = new HashMap();
        if (tt.ad() != null) {
            IUBCLogIdSpService iUBCLogIdSpService = tt.m143switch();
            this.f2206fe = iUBCLogIdSpService;
            if (iUBCLogIdSpService != null) {
                this.f2205de = j.qw(tt.ad());
                if (!this.f2205de.equals(k.qw().fe("key_app_version_code", (String) null)) || yj()) {
                    this.f2206fe.clean();
                    uk();
                    k.qw().yj("key_app_version_code", this.f2205de);
                    return;
                }
                long de2 = k.qw().de("key_app_version_session", 0);
                this.qw = de2;
                if (de2 == 0) {
                    uk();
                }
                i();
            }
        }
    }
}
