package fe.fe.nn.pf;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import org.json.JSONArray;
import org.json.JSONObject;

public class fe {

    public class ad extends fe.fe.nn.when.ad {

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f2264i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ String f2265o;

        /* renamed from: pf  reason: collision with root package name */
        public final /* synthetic */ Context f2266pf;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f2267th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ int f2268uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ long f2269yj;

        public ad(int i2, long j, int i3, int i4, String str, Context context) {
            this.f2267th = i2;
            this.f2269yj = j;
            this.f2268uk = i3;
            this.f2264i = i4;
            this.f2265o = str;
            this.f2266pf = context;
        }

        public void ad() {
            String str = "";
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f2267th);
                jSONObject.put("1", str);
                jSONObject.put("2", Build.VERSION.SDK_INT);
                jSONObject.put("3", this.f2269yj);
                jSONObject.put("4", this.f2268uk);
                jSONObject.put(BannerBaseItemInfo.TYPE_LOGIN, this.f2264i);
                if (!TextUtils.isEmpty(this.f2265o)) {
                    str = this.f2265o;
                }
                jSONObject.put(BannerBaseItemInfo.TYPE_SCHEME, str);
                jSONArray.put(jSONObject);
                ad.de(this.f2266pf).th(jSONArray.toString(), "1077128", 2);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public class de extends fe.fe.nn.when.ad {

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f2270i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ String f2271o;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f2272th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ int f2273uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Context f2274yj;

        public de(int i2, Context context, int i3, int i4, String str) {
            this.f2272th = i2;
            this.f2274yj = context;
            this.f2273uk = i3;
            this.f2270i = i4;
            this.f2271o = str;
        }

        public void ad() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f2272th);
                jSONObject.put("3", System.currentTimeMillis());
                int C = fe.fe.nn.qw.qw.uk(this.f2274yj).C();
                if (C != -1) {
                    jSONObject.put("4", C);
                }
                jSONObject.put(BannerBaseItemInfo.TYPE_LOGIN, fe.fe.nn.qw.qw.uk(this.f2274yj).D());
                jSONObject.put("7", this.f2273uk);
                int i2 = this.f2270i;
                if (i2 != -1) {
                    jSONObject.put("8", i2);
                }
                jSONObject.put("9", this.f2271o);
                jSONObject.put("10", 1);
                jSONObject.put(BindFastRequest.BIND_FROM_INITIATIVE, fe.fe.nn.rg.fe.vvv);
                jSONObject.put("12", "1");
                new fe.fe.nn.uk.de(this.f2274yj, (Handler) null).uk(jSONObject);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    /* renamed from: fe.fe.nn.pf.fe$fe  reason: collision with other inner class name */
    public class C0113fe extends fe.fe.nn.when.ad {

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f2275i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ String f2276o;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f2277th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ int f2278uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Context f2279yj;

        public C0113fe(int i2, Context context, int i3, int i4, String str) {
            this.f2277th = i2;
            this.f2279yj = context;
            this.f2278uk = i3;
            this.f2275i = i4;
            this.f2276o = str;
        }

        public void ad() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f2277th);
                jSONObject.put("3", System.currentTimeMillis());
                int G = fe.fe.nn.qw.qw.uk(this.f2279yj).G();
                if (G != -1) {
                    jSONObject.put("4", G);
                }
                jSONObject.put(BannerBaseItemInfo.TYPE_LOGIN, fe.fe.nn.qw.qw.uk(this.f2279yj).H());
                jSONObject.put("7", this.f2278uk);
                int i2 = this.f2275i;
                if (i2 != -1) {
                    jSONObject.put("8", i2);
                }
                jSONObject.put("9", this.f2276o);
                jSONObject.put("10", 1);
                jSONObject.put(BindFastRequest.BIND_FROM_INITIATIVE, fe.fe.nn.rg.fe.xxx);
                jSONObject.put("12", "1");
                jSONArray.put(jSONObject);
                ad.de(this.f2279yj).th(jSONArray.toString(), "1077122", 2);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public class qw extends fe.fe.nn.when.ad {

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ Context f2280i;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f2281th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ String f2282uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2283yj;

        public qw(int i2, int i3, String str, Context context) {
            this.f2281th = i2;
            this.f2283yj = i3;
            this.f2282uk = str;
            this.f2280i = context;
        }

        public void ad() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.f2281th);
                jSONObject.put("1", System.currentTimeMillis());
                jSONObject.put("2", this.f2283yj);
                jSONObject.put("3", this.f2282uk);
                jSONObject.put("4", "1");
                jSONArray.put(jSONObject);
                ad.de(this.f2280i).th(jSONArray.toString(), "1077112", 2);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public class rg extends fe.fe.nn.when.ad {

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f2284i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ int f2285o;

        /* renamed from: pf  reason: collision with root package name */
        public final /* synthetic */ Context f2286pf;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f2287th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ String f2288uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2289yj;

        public rg(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f2287th = i2;
            this.f2289yj = i3;
            this.f2288uk = str;
            this.f2284i = i4;
            this.f2285o = i5;
            this.f2286pf = context;
        }

        public void ad() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f2284i);
                jSONObject.put("2", this.f2287th);
                int i2 = this.f2289yj;
                if (i2 != -1) {
                    jSONObject.put("3", i2);
                }
                if (!TextUtils.isEmpty(this.f2288uk)) {
                    jSONObject.put("4", this.f2288uk);
                }
                jSONObject.put(BannerBaseItemInfo.TYPE_LOGIN, 1);
                jSONObject.put(BannerBaseItemInfo.TYPE_SCHEME, fe.fe.nn.rg.fe.vvv);
                jSONObject.put("7", this.f2285o);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                ad.de(this.f2286pf).th(jSONArray.toString(), "1077105", 2);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public class th extends fe.fe.nn.when.ad {

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f2290i;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ int f2291o;

        /* renamed from: pf  reason: collision with root package name */
        public final /* synthetic */ Context f2292pf;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f2293th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ String f2294uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f2295yj;

        public th(int i2, int i3, String str, int i4, int i5, Context context) {
            this.f2293th = i2;
            this.f2295yj = i3;
            this.f2294uk = str;
            this.f2290i = i4;
            this.f2291o = i5;
            this.f2292pf = context;
        }

        public void ad() {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", System.currentTimeMillis());
                jSONObject.put("1", this.f2290i);
                jSONObject.put("2", this.f2293th);
                int i2 = this.f2295yj;
                if (i2 != -1) {
                    jSONObject.put("3", i2);
                }
                if (!TextUtils.isEmpty(this.f2294uk)) {
                    jSONObject.put("4", this.f2294uk);
                }
                jSONObject.put(BannerBaseItemInfo.TYPE_LOGIN, 1);
                jSONObject.put(BannerBaseItemInfo.TYPE_SCHEME, fe.fe.nn.rg.fe.xxx);
                jSONObject.put("7", this.f2291o);
                jSONObject.put("8", "1");
                jSONArray.put(jSONObject);
                ad.de(this.f2292pf).th(jSONArray.toString(), "1077123", 2);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public static void ad(Context context, int i2, int i3, int i4, String str) {
        fe.fe.nn.when.fe.de().ad(new de(i2, context, i4, i3, str));
    }

    public static void de(Context context, int i2, int i3, long j, int i4, String str) {
        fe.fe.nn.when.fe.de().ad(new ad(i2, j, i4, i3, str, context));
    }

    public static void fe(Context context, int i2, int i3, String str) {
        fe.fe.nn.when.fe.de().ad(new qw(i2, i3, str, context));
    }

    public static void qw(Context context, int i2, int i3, int i4, int i5, String str) {
        fe.fe.nn.when.fe.de().ad(new rg(i4, i5, str, i2, i3, context));
    }

    public static void rg(Context context, int i2, int i3, int i4, int i5, String str) {
        fe.fe.nn.when.fe.de().ad(new th(i4, i5, str, i2, i3, context));
    }

    public static void th(Context context, int i2, int i3, int i4, String str) {
        fe.fe.nn.when.fe.de().ad(new C0113fe(i2, context, i4, i3, str));
    }
}
