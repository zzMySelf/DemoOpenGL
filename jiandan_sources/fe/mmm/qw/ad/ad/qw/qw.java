package fe.mmm.qw.ad.ad.qw;

import android.content.Context;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.alipay.sdk.m.s.a;
import com.tera.scan.security.URLHandler;
import fe.mmm.qw.nn.de.o.ad;
import fe.mmm.qw.nn.de.o.de;
import org.json.JSONException;

public class qw {
    public static de qw(de deVar, boolean z) throws JSONException {
        try {
            Context qw = fe.mmm.qw.ppp.qw.qw.qw();
            String i2 = deVar.i();
            ad adVar = null;
            if (ShareTarget.METHOD_GET.equals(deVar.fe())) {
                adVar = deVar.rg();
            }
            if (adVar == null && !deVar.qw()) {
                return deVar;
            }
            if (adVar == null) {
                adVar = new ad();
            }
            String ad2 = deVar.ad();
            if (deVar.qw()) {
                fe.mmm.qw.rg.qw.de.qw.qw.qw.qw(qw, ad2, i2, adVar);
            }
            if (!i2.contains("?")) {
                i2 = i2 + "?";
            } else if (!i2.endsWith("?")) {
                i2 = i2 + a.n;
            }
            String str = i2 + adVar.toString();
            String uk2 = deVar.uk();
            if (!z && deVar.qw() && !TextUtils.isEmpty(uk2)) {
                if (!TextUtils.isEmpty(ad2)) {
                    deVar.vvv(new URLHandler().handlerURL(qw, str, ad2, uk2));
                    return deVar;
                }
            }
            deVar.vvv(str);
            return deVar;
        } catch (SecurityException unused) {
            throw new JSONException("SecurityException");
        }
    }
}
