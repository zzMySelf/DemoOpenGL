package fe.mmm.qw.nn.qw.qw;

import com.tera.scan.network.network.interceptor.IRequestInterceptor;
import fe.mmm.qw.nn.ad.qw.qw;
import fe.mmm.qw.nn.de.o.de;
import org.json.JSONException;

public class rg implements IRequestInterceptor {
    public de ad(de deVar, boolean z) throws JSONException {
        try {
            return qw.qw.qw(deVar, z);
        } catch (SecurityException unused) {
            throw new JSONException("SecurityException");
        }
    }

    public de qw(de deVar) throws JSONException {
        return ad(deVar, false);
    }
}
