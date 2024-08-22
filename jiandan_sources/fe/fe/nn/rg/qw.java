package fe.fe.nn.rg;

import android.content.Context;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class qw extends fe {
    public boolean aaa = false;
    public AuthnHelper ddd;
    public long mmm = 0;
    public long nn = 0;

    public class ad implements TokenListener {
        public final /* synthetic */ int qw;

        public ad(int i2) {
            this.qw = i2;
        }

        public void onGetTokenComplete(JSONObject jSONObject) {
            qw.this.g(jSONObject, this.qw);
        }
    }

    public class de extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ JSONObject f2331th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2333yj;

        public de(JSONObject jSONObject, int i2) {
            this.f2331th = jSONObject;
            this.f2333yj = i2;
        }

        public void ad() {
            try {
                int optInt = this.f2331th.optInt("resultCode", -1);
                String optString = this.f2331th.optString("authTypeDes", "");
                if (optInt == 103000) {
                    long unused = qw.this.mmm = System.currentTimeMillis();
                    qw.this.f2320uk = this.f2331th.optString("token", "");
                    qw qwVar = qw.this;
                    qwVar.rg(this.f2333yj, 0, 0, qwVar.f2314de, "preVerify success", 3);
                    return;
                }
                if (optInt == 105312) {
                    qw qwVar2 = qw.this;
                    if (qwVar2.f2314de != qwVar2.f2315fe) {
                        qw qwVar3 = qw.this;
                        qwVar3.rg(this.f2333yj, 3, 2002, qwVar3.f2314de, "pre verify" + " error, wrong sim operator", 3);
                        return;
                    }
                }
                qw qwVar4 = qw.this;
                qwVar4.rg(this.f2333yj, 2, optInt, qwVar4.f2314de, "pre verify" + " error." + optString, 3);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
                qw qwVar5 = qw.this;
                qwVar5.rg(this.f2333yj, 3, 2009, qwVar5.f2314de, "cm on handle " + "pre verify" + " unknown error.", 3);
            }
        }
    }

    public class fe extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ JSONObject f2334th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2336yj;

        public fe(JSONObject jSONObject, int i2) {
            this.f2334th = jSONObject;
            this.f2336yj = i2;
        }

        public void ad() {
            try {
                int optInt = this.f2334th.optInt("resultCode", -1);
                String optString = this.f2334th.optString("desc", "");
                if (optInt == 103000) {
                    long unused = qw.this.nn = System.currentTimeMillis();
                    qw.this.f2321yj = this.f2334th.optString("securityphone", "");
                    JSONObject jSONObject = new JSONObject();
                    qw qwVar = qw.this;
                    jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, qwVar.qw(qwVar.f2321yj));
                    qw qwVar2 = qw.this;
                    qwVar2.rg(this.f2336yj, 0, 0, qwVar2.f2314de, jSONObject.toString(), 1);
                    return;
                }
                if (optInt == 105312) {
                    qw qwVar3 = qw.this;
                    if (qwVar3.f2314de != qwVar3.f2315fe) {
                        qw qwVar4 = qw.this;
                        qwVar4.rg(this.f2336yj, 3, 2002, qwVar4.f2314de, "pre login" + " error, wrong sim operator", 1);
                        return;
                    }
                }
                qw qwVar5 = qw.this;
                qwVar5.rg(this.f2336yj, 2, optInt, qwVar5.f2314de, "pre login" + " error." + optString, 1);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
                qw qwVar6 = qw.this;
                qwVar6.rg(this.f2336yj, 3, 2009, qwVar6.f2314de, "cm on handle " + "pre login" + " unknown error.", 1);
            }
        }
    }

    /* renamed from: fe.fe.nn.rg.qw$qw  reason: collision with other inner class name */
    public class C0114qw extends ad {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f2337ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ int f2338de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ int f2339fe;

        public C0114qw(long j, int i2, int i3, int i4) {
            this.f2337ad = i2;
            this.f2338de = i3;
            this.f2339fe = i4;
        }

        public void onGetTokenComplete(JSONObject jSONObject) {
            int i2;
            long currentTimeMillis = System.currentTimeMillis() - qw();
            int optInt = jSONObject.optInt("resultCode", -1);
            if (!qw.this.d(optInt, this.f2337ad) || (i2 = this.f2338de) != 0) {
                qw.this.c(jSONObject, this.f2337ad);
            } else {
                qw.this.aaa(this.f2337ad, this.f2339fe, i2 + 1);
            }
            i.de().o();
            qw qwVar = qw.this;
            fe.fe.nn.pf.fe.de(qwVar.qw, qwVar.f2314de, optInt, currentTimeMillis, this.f2339fe, "");
        }
    }

    public class rg extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ JSONObject f2341th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2343yj;

        public rg(JSONObject jSONObject, int i2) {
            this.f2341th = jSONObject;
            this.f2343yj = i2;
        }

        public void ad() {
            try {
                int optInt = this.f2341th.has("resultCode") ? this.f2341th.optInt("resultCode", -1) : -1;
                if (optInt == 103000) {
                    qw.this.f2318rg = this.f2341th.optString("token");
                    qw.this.ad(this.f2343yj);
                    return;
                }
                String optString = this.f2341th.optString("resultDesc", "");
                qw qwVar = qw.this;
                int i2 = this.f2343yj;
                int i3 = qwVar.f2314de;
                qwVar.fe(i2, 2, optInt, i3, "error:" + optString);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
                qw qwVar2 = qw.this;
                qwVar2.fe(this.f2343yj, 3, 2009, qwVar2.f2314de, "cm on handle login unknown error.");
            }
        }
    }

    public class th extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f2344th;

        public th(int i2) {
            this.f2344th = i2;
        }

        public void ad() {
            try {
                qw qwVar = qw.this;
                qwVar.yj(this.f2344th, qwVar.f2314de, qwVar.f2320uk);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
                qw qwVar2 = qw.this;
                qwVar2.when(this.f2344th, 3, 2009, qwVar2.f2314de, "cm on handle verify unknown error.");
            }
        }
    }

    public class yj implements TokenListener {
        public final /* synthetic */ int qw;

        public yj(int i2) {
            this.qw = i2;
        }

        public void onGetTokenComplete(JSONObject jSONObject) {
            qw.this.rrr(jSONObject, this.qw);
        }
    }

    public qw(Context context) {
        super(context);
        this.f2314de = 1;
    }

    public final void aaa(int i2, int i3, int i4) {
        this.ddd.getPhoneInfo(fe.f2312pf, fe.f66if, new C0114qw(System.currentTimeMillis(), i2, i4, i3));
    }

    public final void c(JSONObject jSONObject, int i2) {
        fe.fe.nn.when.fe.de().ad(new fe(jSONObject, i2));
    }

    public final boolean d(int i2, int i3) {
        return fe.fe.nn.qw.qw.uk(this.qw).de() && fe.fe.nn.qw.qw.uk(this.qw).eee("k_retry_code_cm", i2) && fe.fe.nn.de.qw.de().uk(i3);
    }

    public void ddd() {
        this.f2318rg = null;
    }

    public final void e(int i2) {
        fe.fe.nn.when.fe.de().ad(new th(i2));
    }

    public final void g(JSONObject jSONObject, int i2) {
        fe.fe.nn.when.fe.de().ad(new de(jSONObject, i2));
    }

    public void ggg(Context context, int i2, long j) {
        super.ggg(context, i2, j);
        de(i2, 4);
        e(i2);
    }

    public void i(Context context, int i2, int i3) {
        super.i(context, i2, i3);
        if (!fe.fe.nn.qw.qw.uk(this.qw).fe()) {
            rg(i3, 3, 997, this.f2314de, "pre login error. sdk stop run.", 1);
        } else if (!xxx()) {
            rg(i3, 3, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_THIRD_VERIFICATION, this.f2314de, "pre login error. cm has not valid config.", 1);
        } else if (fe.fe.nn.qw.qw.uk(this.qw).S()) {
            if (!this.aaa) {
                System.currentTimeMillis();
                AuthnHelper instance = AuthnHelper.getInstance(this.qw);
                this.ddd = instance;
                instance.setOverTime(8000);
                AuthnHelper.setDebugMode(fe.fe.nn.ad.de());
                this.aaa = true;
            }
            aaa(i3, i2, 0);
        } else {
            rg(i3, 3, 994, this.f2314de, "pre login error. cm sdk stop run.", 1);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public boolean m155if() {
        if (this.nn != 0 && System.currentTimeMillis() - this.nn < TimeUnit.HOURS.toMillis(1)) {
            return false;
        }
        return true;
    }

    public void nn() {
        this.f2320uk = null;
        this.mmm = 0;
    }

    public void o(Context context, int i2, long j) {
        super.o(context, i2, j);
        de(i2, 2);
        this.ddd.loginAuth(fe.f2312pf, fe.f66if, new yj(i2));
    }

    public final void rrr(JSONObject jSONObject, int i2) {
        fe.fe.nn.when.fe.de().ad(new rg(jSONObject, i2));
    }

    public void uk(Context context, int i2) {
        super.uk(context, i2);
        if (!fe.fe.nn.qw.qw.uk(this.qw).fe()) {
            rg(i2, 3, 997, this.f2314de, "pre verify error. sdk stop run.", 3);
        } else if (!xxx()) {
            rg(i2, 3, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_THIRD_VERIFICATION, this.f2314de, "pre verify error. cm has not valid config.", 3);
        } else if (fe.fe.nn.qw.qw.uk(this.qw).S()) {
            if (!this.aaa) {
                AuthnHelper instance = AuthnHelper.getInstance(this.qw);
                this.ddd = instance;
                instance.setOverTime(8000);
                this.aaa = true;
            }
            this.ddd.mobileAuth(fe.f2312pf, fe.f66if, new ad(i2));
        } else {
            rg(i2, 3, 994, this.f2314de, "pre verify error. cm sdk stop run.", 3);
        }
    }

    public boolean vvv() {
        return System.currentTimeMillis() - this.mmm > 115000;
    }
}
