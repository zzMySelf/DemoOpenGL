package fe.fe.mmm;

import android.text.TextUtils;
import com.baidu.apollon.statistics.Config;
import com.baidu.ubc.UBCManager;
import fe.fe.vvv.ad.ad.ad;
import fe.fe.vvv.ad.qw.qw;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: fe  reason: collision with root package name */
    public static final boolean f1995fe = tt.vvv();

    /* renamed from: rg  reason: collision with root package name */
    public static volatile c f1996rg;

    /* renamed from: ad  reason: collision with root package name */
    public int f1997ad = 0;

    /* renamed from: de  reason: collision with root package name */
    public int f1998de = 0;
    public boolean qw = qw.yj();

    public static c de() {
        if (f1996rg == null) {
            synchronized (c.class) {
                if (f1996rg == null) {
                    f1996rg = new c();
                }
            }
        }
        return f1996rg;
    }

    public void a(String str, String str2) {
        int length = str2.length();
        int mmm = i.vvv().mmm();
        if (length > mmm) {
            ddd(String.valueOf(mmm), String.valueOf(length), str);
            if (f1995fe) {
                "UBC log too large, id=" + str + ", content=" + str2;
                throw new RuntimeException(String.format("UBC log too large(size=%dKB / threshold=%dKB), log id=%s, please deal with. Any question connect UBC owner. content=%s", new Object[]{Integer.valueOf(length / 1024), Integer.valueOf(mmm / 1024), str, str2}));
            }
        }
    }

    public void aaa(String str, String str2) {
        if (this.qw) {
            if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("msg", str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put(Config.k, str2);
                    }
                    o("sendFail", "requestError", jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final boolean ad() {
        int i2 = this.f1997ad;
        this.f1997ad = i2 + 1;
        return i2 > 10;
    }

    public void ddd(String str, String str2, String str3) {
        if (this.qw && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", str);
                jSONObject.put("size", str2);
                jSONObject.put("logId", str3);
                o("logSize", "single", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void eee(int i2) {
        if (this.qw) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errno", i2);
                o("sendFail", "backend", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void fe(String str, int i2, String str2, boolean z, boolean z2) {
        if (this.qw && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && i2 != 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", str);
                jSONObject.put("dbOverNum", i2);
                jSONObject.put("tableName", str2);
                int i3 = 1;
                jSONObject.put("isCold", z ? 1 : 0);
                if (!z2) {
                    i3 = 0;
                }
                jSONObject.put("isLocal", i3);
                o("logDiscard", "database", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void ggg(int i2) {
        if (this.qw) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", "0");
                jSONObject.put("delNum", Integer.toString(i2));
                o("logDiscard", "multiFileDel", jSONObject);
            } catch (JSONException e) {
                if (f1995fe) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void i(int i2, int i3, String str) {
        if (this.qw && !ad()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("rdFiles", i2);
                jSONObject.put("ndFiles", i3);
                o("dbDeleteFail", str, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m117if(String str, int i2, int i3, int i4) {
        if (this.qw && !TextUtils.isEmpty(str) && i2 != 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", str);
                jSONObject.put("fileNum", i2);
                jSONObject.put("deleteFileCount", i3);
                jSONObject.put("deleteDbCount", i4);
                o("logDiscard", "fileNum", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void mmm(String str, String str2, String str3) {
        if (this.qw && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Config.k, str);
                o("sqlError", str2 + str3, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void nn(String str, long j, long j2, long j3) {
        if (this.qw && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", str);
                jSONObject.put("oldTime", j);
                jSONObject.put("newTime", j2);
                jSONObject.put("clockTime", j3);
                o("systemChange", "timeChange", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void o(String str, String str2, JSONObject jSONObject) {
        UBCManager uBCManager = (UBCManager) ad.qw(UBCManager.SERVICE_REFERENCE);
        if (f1995fe) {
            "Quality event: type=" + str + ", value=" + str2 + ",ext=" + (jSONObject != null ? jSONObject.toString() : "");
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject2.put("type", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("value", str2);
            }
            if (jSONObject != null) {
                jSONObject2.put(UBCManager.CONTENT_KEY_EXT, jSONObject);
            }
            uBCManager.onEvent("1876", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void pf(boolean z, int i2, int i3) {
        if (this.qw) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", Integer.toString(i2));
                jSONObject.put("delNum", Integer.toString(i3));
                o("logDiscard", z ? "reallogNotSent" : "eventNotSent", jSONObject);
            } catch (JSONException e) {
                if (f1995fe) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void ppp(String str, int i2, int i3, int i4, boolean z, boolean z2) {
        if (!this.qw || TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 != 0 || i3 != 0 || i4 != 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", str);
                int i5 = 1;
                jSONObject.put("isCold", z ? 1 : 0);
                if (!z2) {
                    i5 = 0;
                }
                jSONObject.put("isLocal", i5);
                if (i2 != 0) {
                    jSONObject.put("flowExpired", i2);
                }
                if (i3 != 0) {
                    jSONObject.put("eventExpired", i3);
                }
                if (i4 != 0) {
                    jSONObject.put("flowInterrupt", i4);
                }
                o("logDiscard", "timeExpired", jSONObject);
            } catch (JSONException e) {
                if (f1995fe) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void qqq(String str) {
        if (this.qw && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Config.k, str);
                o("sendFail", "bodyError", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final boolean qw() {
        int i2 = this.f1998de;
        this.f1998de = i2 + 1;
        return i2 > 10;
    }

    public void rg(String str) {
        if (this.qw && !qw()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dbStacktrace", str);
                o("dbCorrupt", "dbOnCorrupt", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void rrr(String str, String str2, String str3) {
        if (this.qw && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", str2);
                jSONObject.put("size", str3);
                o("logSize", str, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m118switch(int i2, int i3, boolean z, boolean z2) {
        if (this.qw && i3 != 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", Integer.toString(i2));
                jSONObject.put("fileNum", i3);
                int i4 = 1;
                jSONObject.put("isCold", z ? 1 : 0);
                if (!z2) {
                    i4 = 0;
                }
                jSONObject.put("isLocal", i4);
                o("logDiscard", "fileExpired", jSONObject);
            } catch (JSONException e) {
                if (f1995fe) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void th(int i2, String str) {
        if (this.qw) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("repairedTimes", i2);
                jSONObject.put("repairedMsg", str);
                o("dbCorrupt", "dbRepaired", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void tt(boolean z, long j) {
        int i2;
        if (z) {
            i2 = i.vvv().nn();
        } else {
            i2 = i.vvv().ddd();
        }
        String str = z ? "uploadReal" : "uploadNonReal";
        if (j > ((long) i2)) {
            rrr(str, String.valueOf(i2), String.valueOf(j));
        }
    }

    public void uk(int i2, int i3, int i4, int i5, String str) {
        if (this.qw && !ad()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("rdEvents", i2);
                jSONObject.put("rdFlows", i3);
                jSONObject.put("ndEvents", i4);
                jSONObject.put("ndFlows", i5);
                o("dbDeleteFail", str, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void vvv(int i2) {
        if (this.qw) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", Integer.toString(i2));
                o("logDiscard", "multiFileOver", jSONObject);
            } catch (JSONException e) {
                if (f1995fe) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void when() {
        if (this.qw) {
            o("logDiscard", "flowHandleInvalid", (JSONObject) null);
        }
    }

    public void xxx(String str) {
        if (this.qw && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("limit", str);
                o("logDiscard", "realLog", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void yj(int i2, boolean z) {
        if (this.qw) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("repairedTimes", i2);
                o("dbCorrupt", z ? "dbRepairedSuccess" : "dbRepairedFail", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
