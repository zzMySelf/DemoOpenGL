package fe.fe.o.th;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import java.util.HashMap;

public class ppp {

    /* renamed from: ad  reason: collision with root package name */
    public HashMap f2679ad = new HashMap();

    /* renamed from: de  reason: collision with root package name */
    public boolean f2680de = false;

    /* renamed from: fe  reason: collision with root package name */
    public String f2681fe = null;
    public String qw = "";

    /* renamed from: rg  reason: collision with root package name */
    public HashMap f2682rg = new HashMap();

    public ppp(String str) {
        this.qw = str;
        fe();
    }

    public final String ad(String str) {
        String str2 = (String) this.f2682rg.get(str);
        if (str2 != null) {
            return str2;
        }
        String uk2 = ggg.uk(str);
        this.f2682rg.put(str, uk2);
        return uk2;
    }

    public void de(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f2679ad.put(str, str2);
            this.f2680de = true;
        }
    }

    public final void fe() {
        if (!TextUtils.isEmpty(this.qw)) {
            String[] split = this.qw.split(a.n);
            for (int i2 = 0; i2 < split.length; i2++) {
                int indexOf = split[i2].indexOf("=");
                if (indexOf >= 0) {
                    this.f2679ad.put(when.qw(split[i2].substring(0, indexOf)), when.qw(split[i2].substring(indexOf + 1)));
                } else {
                    this.f2679ad.put(when.qw(split[i2]), "");
                }
            }
            this.f2680de = true;
        }
    }

    public String qw() {
        if (!this.f2680de) {
            return this.f2681fe;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.f2679ad.keySet()) {
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(ad((String) this.f2679ad.get(str)));
            stringBuffer.append(a.n);
        }
        String stringBuffer2 = stringBuffer.toString();
        this.f2680de = false;
        this.f2681fe = stringBuffer2;
        return stringBuffer2;
    }
}
