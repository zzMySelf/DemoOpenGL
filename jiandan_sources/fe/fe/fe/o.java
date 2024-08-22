package fe.fe.fe;

import android.text.TextUtils;
import com.baidu.apollon.heartbeat.a;
import fe.fe.fe.fe.qw.ad;
import fe.fe.fe.i.de;
import fe.fe.fe.th;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class o {

    /* renamed from: ad  reason: collision with root package name */
    public String f1878ad;

    /* renamed from: de  reason: collision with root package name */
    public int f1879de = 2;

    /* renamed from: fe  reason: collision with root package name */
    public int f1880fe = 0;
    public String qw;

    public static boolean de(int i2) {
        return i2 >= 14;
    }

    public static boolean fe(String str) {
        return TextUtils.isEmpty(str);
    }

    public static String i(String str) {
        return new String(th.ad.ad(str.getBytes()));
    }

    public static String o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] qw2 = fe.fe.fe.fe.qw.th.qw();
            return new String(ad.fe(qw2, qw2, th.ad.ad(str.getBytes())));
        } catch (Exception e) {
            de.de(e);
            return "";
        }
    }

    public static o qw(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        o oVar = new o();
        oVar.qw = str;
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        oVar.f1880fe = length;
        if (length < 14) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            oVar.f1878ad = str2;
        }
        return oVar;
    }

    public static o rg(String str) {
        return yj(o(str));
    }

    /* renamed from: switch  reason: not valid java name */
    public static String m106switch(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] qw2 = fe.fe.fe.fe.qw.th.qw();
            return th.ad.qw(ad.de(qw2, qw2, str.getBytes()), a.h);
        } catch (UnsupportedEncodingException | Exception e) {
            de.de(e);
            return "";
        }
    }

    public static o yj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            String str2 = "0";
            String str3 = str2;
            while (keys.hasNext()) {
                String next = keys.next();
                if (!i("ZGV2aWNlaWQ=").equals(next)) {
                    if (!i("dmVy").equals(next)) {
                        str3 = jSONObject.optString(next, str2);
                    }
                }
            }
            String string = jSONObject.getString(i("ZGV2aWNlaWQ="));
            int i2 = jSONObject.getInt(i("dmVy"));
            int length = TextUtils.isEmpty(str3) ? 0 : str3.length();
            if (!TextUtils.isEmpty(string)) {
                o oVar = new o();
                oVar.qw = string;
                oVar.f1879de = i2;
                oVar.f1880fe = length;
                if (length < 14) {
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    oVar.f1878ad = str2;
                }
                oVar.pf();
                return oVar;
            }
        } catch (JSONException e) {
            de.de(e);
        }
        return null;
    }

    public boolean ad() {
        return fe(this.f1878ad);
    }

    /* renamed from: if  reason: not valid java name */
    public final String m107if() {
        try {
            return new JSONObject().put(i("ZGV2aWNlaWQ="), this.qw).put(i("aW1laQ=="), this.f1878ad).put(i("dmVy"), this.f1879de).toString();
        } catch (JSONException e) {
            de.de(e);
            return null;
        }
    }

    public boolean pf() {
        String str;
        if (th()) {
            str = "O";
        } else if (!ad()) {
            return false;
        } else {
            str = "0";
        }
        this.f1878ad = str;
        return true;
    }

    public boolean th() {
        return de(this.f1880fe);
    }

    public String uk() {
        return m106switch(m107if());
    }
}
