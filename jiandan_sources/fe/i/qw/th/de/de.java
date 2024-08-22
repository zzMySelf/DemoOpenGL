package fe.i.qw.th.de;

import android.util.Log;
import com.dxmpay.apollon.restnet.converter.AbstractHttpMessageConverter;
import com.dxmpay.apollon.restnet.http.HttpStatus;
import com.dxmpay.apollon.restnet.rest.e;

public class de<T> {

    /* renamed from: de  reason: collision with root package name */
    public static final String f4491de = "de";

    /* renamed from: ad  reason: collision with root package name */
    public final AbstractHttpMessageConverter<?> f4492ad;
    public final Class<T> qw;

    public de(Class<T> cls, AbstractHttpMessageConverter<?> abstractHttpMessageConverter) {
        if (cls == null) {
            throw new IllegalArgumentException("'responseType' must not be null");
        } else if (abstractHttpMessageConverter != null) {
            this.qw = cls;
            this.f4492ad = abstractHttpMessageConverter;
        } else {
            throw new IllegalArgumentException("'messageConverters' must not be empty");
        }
    }

    public String ad() {
        return this.f4492ad.ad();
    }

    public final boolean de(e eVar) throws Exception {
        HttpStatus d = eVar.d();
        if (d == HttpStatus.NO_CONTENT || d == HttpStatus.NOT_MODIFIED || eVar.c().th() == 0) {
            return false;
        }
        return true;
    }

    public T qw(e eVar) throws Exception {
        if (!de(eVar)) {
            return null;
        }
        if (eVar.c().i() == null) {
            boolean isLoggable = Log.isLoggable(f4491de, 3);
        }
        return this.f4492ad.qw(this.qw, eVar);
    }
}
