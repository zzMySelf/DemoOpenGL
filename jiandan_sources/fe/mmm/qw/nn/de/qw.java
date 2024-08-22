package fe.mmm.qw.nn.de;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.browser.trusted.sharing.ShareTarget;
import com.tera.scan.network.network.interceptor.IFallbackInterceptor;
import fe.mmm.qw.nn.de.o.de;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;

public abstract class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final String f8112ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f8113de;

    /* renamed from: fe  reason: collision with root package name */
    public IFallbackInterceptor f8114fe;
    public String qw;

    public class ad implements IFallbackInterceptor.Builder<de> {
        public final /* synthetic */ fe.mmm.qw.nn.de.o.ad qw;

        public ad(fe.mmm.qw.nn.de.o.ad adVar) {
            this.qw = adVar;
        }

        @NonNull
        /* renamed from: de */
        public de ad(@NonNull String str) throws JSONException {
            qw qwVar = qw.this;
            fe.mmm.qw.nn.de.o.ad adVar = this.qw;
            return qwVar.fe(str, adVar == null ? null : adVar.clone());
        }

        @NonNull
        /* renamed from: fe */
        public de[] qw(int i2) {
            return new de[i2];
        }
    }

    /* renamed from: fe.mmm.qw.nn.de.qw$qw  reason: collision with other inner class name */
    public class C0288qw implements IFallbackInterceptor.Builder<de> {
        public final /* synthetic */ fe.mmm.qw.nn.de.o.ad qw;

        public C0288qw(fe.mmm.qw.nn.de.o.ad adVar) {
            this.qw = adVar;
        }

        @NonNull
        /* renamed from: de */
        public de ad(@NonNull String str) throws JSONException {
            qw qwVar = qw.this;
            fe.mmm.qw.nn.de.o.ad adVar = this.qw;
            return qwVar.rg(str, adVar == null ? null : adVar.clone());
        }

        @NonNull
        /* renamed from: fe */
        public de[] qw(int i2) {
            return new de[i2];
        }
    }

    public qw(String str, String str2, IFallbackInterceptor iFallbackInterceptor) {
        this.f8112ad = str;
        this.f8113de = str2;
        this.f8114fe = iFallbackInterceptor;
    }

    public de[] ad(String str, fe.mmm.qw.nn.de.o.ad adVar) throws JSONException {
        return (de[]) this.f8114fe.ad(str, new ad(adVar));
    }

    public final de[] de(String str, fe.mmm.qw.nn.de.o.ad adVar) throws UnsupportedEncodingException, JSONException {
        return (de[]) this.f8114fe.ad(str, new C0288qw(adVar));
    }

    public final de fe(String str, fe.mmm.qw.nn.de.o.ad adVar) throws JSONException {
        de deVar = new de(str);
        uk(deVar);
        deVar.ggg(th(adVar));
        deVar.ppp(ShareTarget.METHOD_GET);
        if (!TextUtils.isEmpty(this.f8112ad) && !TextUtils.isEmpty(this.f8113de)) {
            deVar.m990switch(this.f8112ad, this.f8113de);
        }
        deVar.when(this.qw);
        return deVar;
    }

    public de rg(String str, fe.mmm.qw.nn.de.o.ad adVar) throws JSONException {
        fe.mmm.qw.nn.de.o.ad th2 = th(adVar);
        de deVar = new de(str);
        uk(deVar);
        deVar.ppp("POST");
        if (!TextUtils.isEmpty(this.f8112ad) && !TextUtils.isEmpty(this.f8113de)) {
            deVar.m990switch(this.f8112ad, this.f8113de);
        }
        if (!TextUtils.isEmpty(this.qw)) {
            deVar.when(this.qw);
        }
        if (th2 == null) {
            return deVar;
        }
        deVar.ggg(th2);
        return deVar;
    }

    public abstract fe.mmm.qw.nn.de.o.ad th(fe.mmm.qw.nn.de.o.ad adVar);

    public abstract void uk(de deVar);

    public void yj(String str) {
        this.qw = str;
    }
}
