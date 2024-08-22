package fe.fe.nn.yj;

import android.content.Context;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import com.sdk.mobile.manager.oauth.cucc.OauthManager;
import org.json.JSONObject;

public class qw extends fe.fe.nn.rg.rg {
    public boolean ddd = false;

    public class ad implements CallBack<Object> {
        public final /* synthetic */ int qw;

        public ad(int i2) {
            this.qw = i2;
        }

        public void onFailed(int i2, int i3, String str, String str2) {
            qw.this.j(i3, str, this.qw);
        }

        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            if (i2 == 0) {
                qw.this.m(obj, this.qw);
            } else {
                qw.this.j(i3, str, this.qw);
            }
        }
    }

    public class de extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Object f2424th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2426yj;

        public de(Object obj, int i2) {
            this.f2424th = obj;
            this.f2426yj = i2;
        }

        public void ad() {
            try {
                JSONObject jSONObject = new JSONObject((String) this.f2424th);
                String unused = qw.this.f2321yj = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                String unused2 = qw.this.f2318rg = jSONObject.optString(YYInnerSSOLoginActivity.s);
                long unused3 = qw.this.f2319th = jSONObject.optLong("exp");
                JSONObject jSONObject2 = new JSONObject();
                qw qwVar = qw.this;
                jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, qwVar.qw(qwVar.f2321yj));
                qw qwVar2 = qw.this;
                qwVar2.rg(this.f2426yj, 0, 0, qwVar2.f2314de, jSONObject2.toString(), 1);
            } catch (Throwable unused4) {
                qw qwVar3 = qw.this;
                qwVar3.rg(this.f2426yj, 3, 2009, qwVar3.f2314de, "cu on handle login unknown error.", 1);
            }
        }
    }

    public class fe extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f2428th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ String f2429uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2430yj;

        public fe(int i2, int i3, String str) {
            this.f2428th = i2;
            this.f2430yj = i3;
            this.f2429uk = str;
        }

        public void ad() {
            try {
                if (qw.this.f2314de == qw.this.f2315fe || this.f2428th != 1101) {
                    qw qwVar = qw.this;
                    int i2 = this.f2430yj;
                    int i3 = this.f2428th;
                    int z = qwVar.f2314de;
                    qwVar.rg(i2, 2, i3, z, "cu pre login error." + this.f2429uk + ", status " + this.f2428th, 1);
                    return;
                }
                qw qwVar2 = qw.this;
                qwVar2.rg(this.f2430yj, 3, 2002, qwVar2.f2314de, "pre login error, wrong sim operator", 1);
            } catch (Throwable unused) {
                qw qwVar3 = qw.this;
                qwVar3.rg(this.f2430yj, 3, 2009, qwVar3.f2314de, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* renamed from: fe.fe.nn.yj.qw$qw  reason: collision with other inner class name */
    public class C0118qw extends ad<Object> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f2431ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ int f2432de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ int f2433fe;

        public C0118qw(long j, int i2, int i3, int i4) {
            this.f2431ad = i2;
            this.f2432de = i3;
            this.f2433fe = i4;
        }

        public void onFailed(int i2, int i3, String str, String str2) {
            int i4;
            long currentTimeMillis = System.currentTimeMillis() - qw();
            if (!qw.this.n(i3, this.f2431ad) || (i4 = this.f2432de) != 0) {
                qw.this.rrr(i3, str, this.f2431ad);
            } else {
                qw.this.eee(this.f2431ad, this.f2433fe, i4 + 1);
            }
            fe.fe.nn.pf.fe.de(qw.this.qw, qw.this.f2314de, i3, currentTimeMillis, this.f2433fe, str2);
        }

        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            int i4;
            long currentTimeMillis = System.currentTimeMillis() - qw();
            if (i2 == 0) {
                qw.this.d(obj, this.f2431ad);
            } else if (!qw.this.n(i3, this.f2431ad) || (i4 = this.f2432de) != 0) {
                qw.this.rrr(i3, str, this.f2431ad);
            } else {
                qw.this.eee(this.f2431ad, this.f2433fe, i4 + 1);
            }
            fe.fe.nn.pf.fe.de(qw.this.qw, qw.this.f2314de, i3, currentTimeMillis, this.f2433fe, str2);
        }
    }

    public class rg extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Object f2435th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2437yj;

        public rg(Object obj, int i2) {
            this.f2435th = obj;
            this.f2437yj = i2;
        }

        public void ad() {
            try {
                JSONObject jSONObject = new JSONObject((String) this.f2435th);
                String unused = qw.this.f2320uk = jSONObject.optString(YYInnerSSOLoginActivity.s);
                long unused2 = qw.this.f2316i = jSONObject.optLong("exp");
                qw qwVar = qw.this;
                qwVar.rg(this.f2437yj, 0, 0, qwVar.f2314de, "preVerify success", 3);
            } catch (Throwable unused3) {
                qw qwVar2 = qw.this;
                qwVar2.rg(this.f2437yj, 3, 2009, qwVar2.f2314de, "cu on handle preVerify unknown error.", 3);
            }
        }
    }

    public class th extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f2439th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ String f2440uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2441yj;

        public th(int i2, int i3, String str) {
            this.f2439th = i2;
            this.f2441yj = i3;
            this.f2440uk = str;
        }

        public void ad() {
            try {
                if (qw.this.f2314de == qw.this.f2315fe || this.f2439th != 1101) {
                    qw qwVar = qw.this;
                    int i2 = this.f2441yj;
                    int i3 = this.f2439th;
                    int K = qwVar.f2314de;
                    qwVar.rg(i2, 2, i3, K, "cu pre verify error." + this.f2440uk + ", status " + this.f2439th, 3);
                    return;
                }
                qw qwVar2 = qw.this;
                qwVar2.rg(this.f2441yj, 3, 2002, qwVar2.f2314de, "pre verify error, wrong sim operator", 3);
            } catch (Throwable unused) {
                qw qwVar3 = qw.this;
                qwVar3.rg(this.f2441yj, 3, 2009, qwVar3.f2314de, "cu on handle verify unknown error.", 3);
            }
        }
    }

    public qw(Context context) {
        super(context);
        this.f2314de = 2;
    }

    public final void d(Object obj, int i2) {
        fe.fe.nn.when.fe.de().ad(new de(obj, i2));
    }

    public final void eee(int i2, int i3, int i4) {
        UiOauthManager.getInstance(this.qw).login(8, new C0118qw(System.currentTimeMillis(), i2, i4, i3));
    }

    public void ggg(Context context, int i2, long j) {
        super.ggg(context, i2, j);
    }

    public void i(Context context, int i2, int i3) {
        super.i(context, i2, i3);
        if (!fe.fe.nn.qw.qw.uk(this.qw).fe()) {
            rg(i3, 3, 997, this.f2314de, "pre login error. sdk stop run", 1);
        } else if (!xxx()) {
            rg(i3, 3, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_THIRD_VERIFICATION, this.f2314de, "pre login error. cu has not valid config.", 1);
        } else if (fe.fe.nn.qw.qw.uk(this.qw).qw()) {
            if (!this.ddd) {
                System.currentTimeMillis();
                SDKManager.init(this.qw, fe.fe.nn.rg.fe.ppp, fe.fe.nn.rg.fe.ggg);
                SDKManager.setUseCache(false);
                SDKManager.securityType(0);
                SDKManager.setDebug(fe.fe.nn.ad.de());
                this.ddd = true;
            }
            eee(i3, i2, 0);
        } else {
            rg(i3, 3, 995, this.f2314de, "pre login error. cu sdk stop run.", 1);
        }
    }

    public void j(int i2, String str, int i3) {
        fe.fe.nn.when.fe.de().ad(new th(i2, i3, str));
    }

    public final void m(Object obj, int i2) {
        fe.fe.nn.when.fe.de().ad(new rg(obj, i2));
    }

    public final boolean n(int i2, int i3) {
        return fe.fe.nn.qw.qw.uk(this.qw).de() && fe.fe.nn.qw.qw.uk(this.qw).eee("k_retry_code_cu", i2) && fe.fe.nn.de.qw.de().uk(i3);
    }

    public final void rrr(int i2, String str, int i3) {
        fe.fe.nn.when.fe.de().ad(new fe(i2, i3, str));
    }

    public void uk(Context context, int i2) {
        super.uk(context, i2);
        if (!fe.fe.nn.qw.qw.uk(this.qw).fe()) {
            rg(i2, 3, 997, this.f2314de, "pre verify error. sdk stop run", 3);
        } else if (!xxx()) {
            rg(i2, 3, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_THIRD_VERIFICATION, this.f2314de, "pre verify error. cu has not valid config.", 3);
        } else if (fe.fe.nn.qw.qw.uk(this.qw).qw()) {
            if (!this.ddd) {
                SDKManager.init(this.qw, fe.fe.nn.rg.fe.ppp, fe.fe.nn.rg.fe.ggg);
                SDKManager.setUseCache(false);
                SDKManager.securityType(0);
                SDKManager.setDebug(fe.fe.nn.ad.de());
                this.ddd = true;
            }
            OauthManager.getInstance(this.qw).getAuthoriseCode(8, new ad(i2));
        } else {
            rg(i2, 3, 995, this.f2314de, "pre verify error. cu sdk stop run.", 3);
        }
    }
}
