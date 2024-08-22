package fe.fe.nn.th;

import android.content.Context;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import cn.com.chinatelecom.gateway.lib.TraceLogger;
import com.baidu.pass.permissions.PermissionsHelperActivity;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import org.json.JSONObject;

public class qw extends fe.fe.nn.rg.rg {
    public boolean ddd = false;

    public class ad implements PreCodeListener {
        public final /* synthetic */ int qw;

        public ad(int i2) {
            this.qw = i2;
        }

        public void onResult(String str) {
            qw.this.c(str, this.qw, 3);
        }
    }

    public class de extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f2379th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ int f2380uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2381yj;

        public de(String str, int i2, int i3) {
            this.f2379th = str;
            this.f2381yj = i2;
            this.f2380uk = i3;
        }

        public void ad() {
            try {
                JSONObject jSONObject = new JSONObject(this.f2379th);
                if (jSONObject.optInt("result", -1) == 0) {
                    qw.this.l(jSONObject, this.f2381yj, this.f2380uk);
                } else {
                    qw.this.d(jSONObject, this.f2381yj, this.f2380uk);
                }
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public class fe extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ JSONObject f2383th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ int f2384uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2385yj;

        public fe(JSONObject jSONObject, int i2, int i3) {
            this.f2383th = jSONObject;
            this.f2385yj = i2;
            this.f2384uk = i3;
        }

        public void ad() {
            String str;
            try {
                JSONObject optJSONObject = this.f2383th.optJSONObject("data");
                if (this.f2385yj == 1) {
                    String unused = qw.this.f2318rg = optJSONObject.optString(YYInnerSSOLoginActivity.s, "");
                    String unused2 = qw.this.f2321yj = optJSONObject.optString("number", "");
                    long unused3 = qw.this.f2319th = System.currentTimeMillis() + (((long) optJSONObject.optInt("expiredTime", 0)) * 1000);
                    JSONObject jSONObject = new JSONObject();
                    qw qwVar = qw.this;
                    jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, qwVar.qw(qwVar.f2321yj));
                    str = jSONObject.toString();
                } else {
                    String unused4 = qw.this.f2320uk = optJSONObject.optString(YYInnerSSOLoginActivity.s, "");
                    long unused5 = qw.this.f2316i = System.currentTimeMillis() + (((long) optJSONObject.optInt("expiredTime", 0)) * 1000);
                    str = "preVerify success";
                }
                String str2 = str;
                qw qwVar2 = qw.this;
                qwVar2.rg(this.f2384uk, 0, 0, qwVar2.f2314de, str2, this.f2385yj);
            } catch (Throwable unused6) {
                qw qwVar3 = qw.this;
                qwVar3.rg(this.f2384uk, 3, 2009, qwVar3.f2314de, "ct on handle pre login or verify unknown error.", this.f2385yj);
            }
        }
    }

    /* renamed from: fe.fe.nn.th.qw$qw  reason: collision with other inner class name */
    public class C0116qw extends ad {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f2386ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ int f2387de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ int f2388fe;

        public C0116qw(int i2, int i3, int i4) {
            this.f2386ad = i2;
            this.f2387de = i3;
            this.f2388fe = i4;
        }

        public void onResult(String str) {
            int i2;
            long currentTimeMillis = System.currentTimeMillis() - qw();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("result", -1);
                String optString = jSONObject.optString("reqId", "");
                if (!qw.this.m(optInt, this.f2386ad) || (i2 = this.f2387de) != 0) {
                    qw.this.c(str, this.f2386ad, 1);
                } else {
                    qw.this.eee(this.f2386ad, this.f2388fe, i2 + 1);
                }
                fe.fe.nn.pf.fe.de(qw.this.qw, qw.this.f2314de, optInt, currentTimeMillis, this.f2388fe, optString);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public class rg extends fe.fe.nn.when.ad {

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ JSONObject f2391th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ int f2392uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2393yj;

        public rg(JSONObject jSONObject, int i2, int i3) {
            this.f2391th = jSONObject;
            this.f2393yj = i2;
            this.f2392uk = i3;
        }

        public void ad() {
            try {
                int optInt = this.f2391th.optInt("result", -1);
                String optString = this.f2391th.optString("msg", "");
                if (qw.this.f2314de == qw.this.f2315fe || !(optInt == -10009 || optInt == -10008)) {
                    qw qwVar = qw.this;
                    int i2 = this.f2393yj;
                    int x = qwVar.f2314de;
                    qwVar.rg(i2, 2, optInt, x, "ct pre login error." + optString + ", status " + optInt, this.f2392uk);
                    return;
                }
                qw qwVar2 = qw.this;
                qwVar2.rg(this.f2393yj, 3, 2002, qwVar2.f2314de, "pre login error, wrong sim operator", this.f2392uk);
            } catch (Throwable unused) {
                qw qwVar3 = qw.this;
                qwVar3.rg(this.f2393yj, 3, 2009, qwVar3.f2314de, "ct on handle pre login or verify unknown error.", this.f2392uk);
            }
        }
    }

    public qw(Context context) {
        super(context);
        this.f2314de = 3;
    }

    public final void c(String str, int i2, int i3) {
        fe.fe.nn.when.fe.de().ad(new de(str, i2, i3));
    }

    public final void d(JSONObject jSONObject, int i2, int i3) {
        fe.fe.nn.when.fe.de().ad(new rg(jSONObject, i2, i3));
    }

    public final void eee(int i2, int i3, int i4) {
        CtAuth.requestPreAuthCode(this.qw, fe.fe.nn.rg.fe.f67switch, fe.fe.nn.rg.fe.when, new C0116qw(i2, i4, i3));
    }

    public void ggg(Context context, int i2, long j) {
        super.ggg(context, i2, j);
    }

    public void i(Context context, int i2, int i3) {
        super.i(context, i2, i3);
        if (!fe.fe.nn.qw.qw.uk(this.qw).fe()) {
            rg(i3, 3, 997, this.f2314de, "pre login error. sdk stop run.", 1);
        } else if (!xxx()) {
            rg(i3, 3, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_THIRD_VERIFICATION, this.f2314de, "pre login error. ct has not valid config.", 1);
        } else if (fe.fe.nn.qw.qw.uk(this.qw).T()) {
            if (!this.ddd) {
                System.currentTimeMillis();
                CtAuth.init(0, 0, PermissionsHelperActivity.e, (TraceLogger) null);
                this.ddd = true;
            }
            eee(i3, i2, 0);
        } else {
            rg(i3, 3, 996, this.f2314de, "pre login error. ct sdk stop run.", 1);
        }
    }

    public final void l(JSONObject jSONObject, int i2, int i3) {
        fe.fe.nn.when.fe.de().ad(new fe(jSONObject, i3, i2));
    }

    public final boolean m(int i2, int i3) {
        return fe.fe.nn.qw.qw.uk(this.qw).de() && fe.fe.nn.qw.qw.uk(this.qw).eee("k_retry_code_ct", i2) && fe.fe.nn.de.qw.de().uk(i3);
    }

    public void uk(Context context, int i2) {
        super.uk(context, i2);
        if (!fe.fe.nn.qw.qw.uk(this.qw).fe()) {
            rg(i2, 3, 997, this.f2314de, "pre verify error. sdk stop run.", 3);
        } else if (!xxx()) {
            rg(i2, 3, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_THIRD_VERIFICATION, this.f2314de, "pre verify error. ct has not valid config.", 3);
        } else if (fe.fe.nn.qw.qw.uk(this.qw).T()) {
            if (!this.ddd) {
                CtAuth.init(0, 0, PermissionsHelperActivity.e, (TraceLogger) null);
                this.ddd = true;
            }
            CtAuth.requestPreAuthCode(context, fe.fe.nn.rg.fe.f67switch, fe.fe.nn.rg.fe.when, new ad(i2));
        } else {
            rg(i2, 3, 996, this.f2314de, "pre verify error. ct sdk stop run.", 3);
        }
    }
}
