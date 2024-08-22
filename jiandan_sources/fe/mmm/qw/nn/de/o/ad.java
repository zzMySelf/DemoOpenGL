package fe.mmm.qw.nn.de.o;

import android.net.Uri;
import com.alipay.sdk.m.s.a;
import java.util.HashMap;
import java.util.Map;

public class ad implements Cloneable {

    /* renamed from: ad  reason: collision with root package name */
    public String f8099ad;

    /* renamed from: th  reason: collision with root package name */
    public final Map<String, String> f8100th = new HashMap();

    public void ad(String str, String str2) {
        String encode = Uri.encode(str2);
        if (this.f8099ad == null) {
            this.f8099ad = str + "=" + encode;
            return;
        }
        this.f8099ad += a.n + str + "=" + encode;
    }

    public ad de(String str, String str2) {
        if (!(str == null || str2 == null)) {
            this.f8100th.put(str, str2);
        }
        return this;
    }

    /* renamed from: fe */
    public ad clone() {
        try {
            return (ad) super.clone();
        } catch (CloneNotSupportedException unused) {
            ad adVar = new ad();
            adVar.f8099ad = this.f8099ad;
            return adVar;
        }
    }

    public boolean rg(String str) {
        String str2 = this.f8099ad;
        if (str2 != null) {
            if (str2.contains(str + "=")) {
                return true;
            }
        }
        return false;
    }

    public Map<String, String> th() {
        return this.f8100th;
    }

    public String toString() {
        return this.f8099ad;
    }
}
