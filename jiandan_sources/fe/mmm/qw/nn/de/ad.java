package fe.mmm.qw.nn.de;

import android.text.TextUtils;
import com.tera.scan.network.network.interceptor.IFallbackInterceptor;
import fe.mmm.qw.j.vvv.de;

public abstract class ad extends qw {

    /* renamed from: rg  reason: collision with root package name */
    public final String f8092rg;

    /* renamed from: th  reason: collision with root package name */
    public final String f8093th;

    public ad(String str, String str2, IFallbackInterceptor iFallbackInterceptor) {
        super(str, str2, iFallbackInterceptor);
        this.f8092rg = str;
        this.f8093th = TextUtils.isEmpty(str) ? null : de.fe(this.f8092rg, false);
    }

    public fe.mmm.qw.nn.de.o.ad th(fe.mmm.qw.nn.de.o.ad adVar) {
        if (adVar == null) {
            adVar = new fe.mmm.qw.nn.de.o.ad();
        }
        if (!TextUtils.isEmpty(this.f8093th) && !adVar.rg("bdstoken")) {
            adVar.ad("bdstoken", this.f8093th);
        }
        return adVar;
    }

    public void uk(fe.mmm.qw.nn.de.o.de deVar) {
        deVar.m989if(true);
    }
}
