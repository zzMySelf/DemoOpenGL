package fe.fe.nn.rg;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import fe.fe.nn.de.qw;
import fe.fe.nn.qw.de;
import java.util.UUID;
import org.json.JSONObject;

public class fe {
    public static String ggg = "";

    /* renamed from: if  reason: not valid java name */
    public static String f66if = "";

    /* renamed from: pf  reason: collision with root package name */
    public static String f2312pf = "";
    public static String ppp = "";

    /* renamed from: switch  reason: not valid java name */
    public static String f67switch = "";
    public static String vvv = null;
    public static String when = "";
    public static String xxx;

    /* renamed from: ad  reason: collision with root package name */
    public String f2313ad;

    /* renamed from: de  reason: collision with root package name */
    public int f2314de;

    /* renamed from: fe  reason: collision with root package name */
    public int f2315fe;

    /* renamed from: i  reason: collision with root package name */
    public long f2316i;

    /* renamed from: o  reason: collision with root package name */
    public long f2317o = 8000;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public String f2318rg;

    /* renamed from: th  reason: collision with root package name */
    public long f2319th;

    /* renamed from: uk  reason: collision with root package name */
    public String f2320uk;

    /* renamed from: yj  reason: collision with root package name */
    public String f2321yj;

    public fe(Context context) {
        this.qw = context;
    }

    public static void pf(String str, String str2, String str3) {
        if (TextUtils.equals(str, "cm")) {
            f2312pf = str2;
            f66if = str3;
        } else if (TextUtils.equals(str, "ct")) {
            f67switch = str2;
            when = str3;
        } else if (TextUtils.equals(str, "cu")) {
            ppp = str2;
            ggg = str3;
        }
    }

    public void ad(int i2) {
        String str;
        try {
            if (qw.de().m146if(i2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f2314de);
                jSONObject.put("1", this.f2318rg);
                jSONObject.put("3", this.f2313ad);
                jSONObject.put("4", fe.fe.nn.ppp.fe.ad(this.qw));
                if (!TextUtils.isEmpty(this.f2321yj)) {
                    jSONObject.put(BannerBaseItemInfo.TYPE_LOGIN, Base64.encodeToString(this.f2321yj.getBytes(), 0));
                }
                jSONObject.put(BannerBaseItemInfo.TYPE_SCHEME, vvv);
                String ad2 = de.qw(this.qw).ad(jSONObject, this.f2317o);
                if (qw.de().m146if(i2)) {
                    if (!TextUtils.isEmpty(ad2)) {
                        ddd();
                        JSONObject jSONObject2 = new JSONObject(ad2);
                        int optInt = jSONObject2.optInt("0", -1);
                        fe.fe.nn.qw.qw.uk(this.qw).g(System.currentTimeMillis());
                        if (optInt == 0) {
                            fe.fe.nn.qw.qw.uk(this.qw).pf(0);
                            JSONObject optJSONObject = new JSONObject(jSONObject2.optString("1")).optJSONObject("data");
                            if (optJSONObject != null) {
                                str = optJSONObject.optString("uk");
                                th(i2, 0, 0, this.f2314de, jSONObject2.optString("1"), optInt, str);
                                return;
                            }
                            str = "";
                            th(i2, 0, 0, this.f2314de, jSONObject2.optString("1"), optInt, str);
                            return;
                        }
                        fe.fe.nn.qw.qw.uk(this.qw).pf(4);
                        th(i2, 4, th.qw(optInt), this.f2314de, jSONObject2.optString("1"), optInt, "");
                        return;
                    }
                    th(i2, 4, 2005, this.f2314de, "server req empty.", -1, "");
                }
            }
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
            fe(i2, 3, 2009, this.f2314de, "post token unknown error.");
        }
    }

    public void ddd() {
        this.f2318rg = null;
        this.f2319th = 0;
        this.f2321yj = null;
    }

    public void de(int i2, int i3) {
        Message message = new Message();
        message.what = i2;
        message.arg1 = this.f2314de;
        message.arg2 = i3;
        o.qw().de(message, this.f2317o);
    }

    public void fe(int i2, int i3, int i4, int i5, String str) {
        th(i2, i3, i4, i5, str, -1, "");
    }

    public void ggg(Context context, int i2, long j) {
        de.qw(context).rg(false);
    }

    public void i(Context context, int i2, int i3) {
        vvv = UUID.randomUUID().toString();
        i.de().o();
        de.qw(context).rg(false);
        ddd();
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m153if() {
        return false;
    }

    public void nn() {
        this.f2320uk = null;
        this.f2316i = 0;
    }

    public void o(Context context, int i2, long j) {
        this.f2317o = j;
    }

    public void ppp(int i2, int i3, int i4, int i5, String str, int i6, String str2) {
        yj yjVar = new yj();
        yjVar.qw = 4;
        yjVar.f2372de = i6;
        yjVar.f2373fe = str2;
        uk.pf().fe(i2, i3, i4, i5, str, yjVar, true);
    }

    public String qw(String str) {
        try {
            if (TextUtils.isEmpty(str) || str.length() != 11 || !str.contains("*")) {
                return str;
            }
            if (str.charAt(3) != '*') {
                return str;
            }
            int K = fe.fe.nn.qw.qw.uk(this.qw).K();
            if (K <= 11 - str.replace("*", "").trim().length()) {
                return str;
            }
            char[] charArray = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            int i2 = K + 3;
            for (int i3 = 0; i3 < charArray.length; i3++) {
                if (i3 < 3) {
                    sb.append(charArray[i3]);
                } else if (i3 < i2) {
                    sb.append("*");
                } else {
                    sb.append(charArray[i3]);
                }
            }
            return sb.toString();
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
            return str;
        }
    }

    public synchronized void rg(int i2, int i3, int i4, int i5, String str, int i6) {
        yj yjVar = new yj();
        yjVar.qw = i6;
        uk.pf().fe(i2, i3, i4, i5, str, yjVar, true);
    }

    /* renamed from: switch  reason: not valid java name */
    public void m154switch(int i2) {
        this.f2315fe = i2;
    }

    public synchronized void th(int i2, int i3, int i4, int i5, String str, int i6, String str2) {
        yj yjVar = new yj();
        yjVar.qw = 2;
        yjVar.f2372de = i6;
        yjVar.f2373fe = str2;
        uk.pf().fe(i2, i3, i4, i5, str, yjVar, true);
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void uk(Context context, int i2) {
        xxx = UUID.randomUUID().toString();
        de.qw(context).rg(false);
        nn();
    }

    public boolean vvv() {
        return false;
    }

    public void when(int i2, int i3, int i4, int i5, String str) {
        ppp(i2, i3, i4, i5, str, -1, "");
    }

    public boolean xxx() {
        int i2 = this.f2314de;
        if (i2 == 1) {
            if (TextUtils.isEmpty(f2312pf) || TextUtils.isEmpty(f66if)) {
                return false;
            }
            return true;
        } else if (i2 == 3) {
            if (TextUtils.isEmpty(f67switch) || TextUtils.isEmpty(when)) {
                return false;
            }
            return true;
        } else if (i2 != 2 || TextUtils.isEmpty(ppp) || TextUtils.isEmpty(ggg)) {
            return false;
        } else {
            return true;
        }
    }

    public void yj(int i2, int i3, String str) {
        if (qw.de().m146if(i2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", i3);
                jSONObject.put("1", str);
                String th2 = de.qw(this.qw).th(jSONObject, this.f2317o);
                if (qw.de().m146if(i2)) {
                    if (TextUtils.isEmpty(th2)) {
                        when(i2, 4, 2005, this.f2314de, "server req empty.");
                        return;
                    }
                    nn();
                    JSONObject jSONObject2 = new JSONObject(th2);
                    int optInt = jSONObject2.optInt("0", -1);
                    String optString = jSONObject2.optString("1");
                    fe.fe.nn.qw.qw.uk(this.qw).r(System.currentTimeMillis());
                    if (optInt == 0) {
                        fe.fe.nn.qw.qw.uk(this.qw).vvv(0);
                        ppp(i2, 0, 0, this.f2314de, optString, optInt, "");
                        return;
                    }
                    int qw2 = th.qw(optInt);
                    fe.fe.nn.qw.qw.uk(this.qw).vvv(4);
                    ppp(i2, 4, qw2, this.f2314de, optString, optInt, "");
                }
            } catch (Throwable th3) {
                fe.fe.nn.ppp.de.fe(th3);
                when(i2, 3, 2009, this.f2314de, "post token unknown error.");
            }
        }
    }
}
