package com.baidu.sofire.f;

import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import org.json.JSONObject;

public class a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", aVar.a);
            jSONObject.put("1", aVar.c);
            jSONObject.put("2", aVar.d);
            jSONObject.put("3", aVar.e);
            jSONObject.put("4", aVar.b);
            jSONObject.put(BannerBaseItemInfo.TYPE_LOGIN, aVar.f);
        } catch (Throwable unused) {
            int i2 = com.baidu.sofire.a.a.a;
        }
        return jSONObject.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.d;
        if (str == null) {
            if (aVar.d != null) {
                return false;
            }
        } else if (!str.equals(aVar.d)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null) {
            if (aVar.e != null) {
                return false;
            }
        } else if (!str2.equals(aVar.e)) {
            return false;
        }
        String str3 = this.b;
        if (str3 == null) {
            if (aVar.b != null) {
                return false;
            }
        } else if (!str3.equals(aVar.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.d;
        int i2 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.b;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }
}
