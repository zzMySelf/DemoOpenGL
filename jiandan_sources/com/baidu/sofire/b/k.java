package com.baidu.sofire.b;

import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.sofire.a.a;

public class k {
    public String a;
    public String b;
    public String c;
    public IntentFilter d;

    public k(String str, IntentFilter intentFilter, String str2, String str3) {
        this.a = str;
        this.d = intentFilter;
        this.b = str2;
        this.c = str3;
    }

    public boolean a(k kVar) {
        IntentFilter intentFilter;
        if (kVar != null) {
            try {
                if (!TextUtils.isEmpty(kVar.a) && !TextUtils.isEmpty(kVar.b)) {
                    if (!TextUtils.isEmpty(kVar.c)) {
                        if (kVar.a.equals(this.a) && kVar.b.equals(this.b)) {
                            if (kVar.c.equals(this.c)) {
                                IntentFilter intentFilter2 = kVar.d;
                                if (intentFilter2 == null || (intentFilter = this.d) == null || intentFilter == intentFilter2) {
                                    return true;
                                }
                                return false;
                            }
                        }
                        return false;
                    }
                }
            } catch (Throwable unused) {
                int i2 = a.a;
            }
        }
        return false;
    }

    public String toString() {
        try {
            return "PluginloaderIntentFilter:" + this.a + "-" + this.b + "-" + this.c + "-" + this.d;
        } catch (Throwable unused) {
            return "";
        }
    }
}
