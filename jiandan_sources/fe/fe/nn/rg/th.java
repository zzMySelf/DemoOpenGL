package fe.fe.nn.rg;

import com.baidu.sso.SSOManager;
import fe.fe.nn.ppp.de;
import fe.fe.nn.when.ad;
import fe.fe.nn.when.fe;
import java.util.ArrayList;
import org.json.JSONObject;

public class th {

    public class qw implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ SSOManager.ISSOLoginListener f2351ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f2352th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ ArrayList f2353uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2354yj;

        /* renamed from: fe.fe.nn.rg.th$qw$qw  reason: collision with other inner class name */
        public class C0115qw extends ad {

            /* renamed from: th  reason: collision with root package name */
            public final /* synthetic */ SSOManager.ISSOLoginListener f2355th;

            public C0115qw(SSOManager.ISSOLoginListener iSSOLoginListener) {
                this.f2355th = iSSOLoginListener;
            }

            public void ad() {
                this.f2355th.onFinish(qw.this.f2352th);
            }
        }

        public qw(SSOManager.ISSOLoginListener iSSOLoginListener, String str, int i2, ArrayList arrayList) {
            this.f2351ad = iSSOLoginListener;
            this.f2352th = str;
            this.f2354yj = i2;
            this.f2353uk = arrayList;
        }

        public void run() {
            SSOManager.ISSOLoginListener iSSOLoginListener = this.f2351ad;
            if (iSSOLoginListener != null) {
                iSSOLoginListener.onFinish(this.f2352th);
            }
            if (this.f2354yj == 1 && this.f2353uk != null) {
                for (int i2 = 0; i2 < this.f2353uk.size(); i2++) {
                    SSOManager.ISSOLoginListener iSSOLoginListener2 = (SSOManager.ISSOLoginListener) this.f2353uk.get(i2);
                    if (iSSOLoginListener2 != null) {
                        fe.de().ad(new C0115qw(iSSOLoginListener2));
                    }
                }
            }
        }
    }

    public static void ad(SSOManager.ISSOLoginListener iSSOLoginListener, de deVar, int i2, ArrayList<SSOManager.ISSOLoginListener> arrayList, boolean z) {
        if (deVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", deVar.qw);
                jSONObject.put("1", deVar.f2309ad);
                jSONObject.put("2", String.valueOf(deVar.f2310de));
                jSONObject.put("3", deVar.f2311fe);
                String jSONObject2 = jSONObject.toString();
                if (i2 == 1) {
                    if (z) {
                        fe.fe.nn.de.qw.de().th(false);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        fe.fe.nn.de.qw.de().fe(false);
                    }
                } else if (i2 == 3) {
                    if (z) {
                        fe.fe.nn.de.qw.de().o(false);
                    }
                } else if (z) {
                    fe.fe.nn.de.qw.de().when(false);
                }
                new Thread(new qw(iSSOLoginListener, jSONObject2, i2, arrayList)).start();
            } catch (Throwable th2) {
                de.fe(th2);
            }
        }
    }

    public static int qw(int i2) {
        if (i2 == 1) {
            return 2010;
        }
        if (i2 == 2) {
            return 2011;
        }
        if (i2 == 3) {
            return 2012;
        }
        if (i2 == 4) {
            return 2013;
        }
        if (i2 == 5) {
            return 2014;
        }
        return i2 == 6 ? 2015 : 2009;
    }
}
