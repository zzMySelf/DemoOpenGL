package fe.fe.nn.pf;

import android.content.Context;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.apollon.heartbeat.a;
import com.baidu.sapi2.activity.LoginActivity;
import fe.fe.nn.ppp.rg;
import fe.fe.nn.ppp.th;
import fe.fe.nn.ppp.uk;
import fe.fe.nn.uk.fe;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ad extends fe.fe.nn.uk.qw {

    /* renamed from: yj  reason: collision with root package name */
    public static volatile ad f2252yj;

    /* renamed from: de  reason: collision with root package name */
    public fe f2253de;

    /* renamed from: fe  reason: collision with root package name */
    public de f2254fe;

    /* renamed from: rg  reason: collision with root package name */
    public Context f2255rg;

    /* renamed from: th  reason: collision with root package name */
    public int f2256th = 0;

    /* renamed from: fe.fe.nn.pf.ad$ad  reason: collision with other inner class name */
    public class C0112ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ long f2257ad;

        public C0112ad(long j) {
            this.f2257ad = j;
        }

        public void run() {
            try {
                if (ad.this.i(false)) {
                    fe.fe.nn.qw.qw.uk(ad.this.f2255rg).m(this.f2257ad);
                }
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public class de implements Runnable {
        public de() {
        }

        public void run() {
            try {
                boolean unused = ad.de(ad.this.f2255rg).i(true);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public class qw implements Runnable {
        public qw() {
        }

        public void run() {
            try {
                boolean unused = ad.this.i(true);
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        }
    }

    public ad(Context context, Handler handler) {
        super(context, handler);
        this.f2255rg = context;
        this.f2253de = fe.qw(context);
        this.f2254fe = new de();
    }

    public static ad de(Context context) {
        if (f2252yj == null) {
            synchronized (ad.class) {
                if (f2252yj == null) {
                    f2252yj = new ad(context, (Handler) null);
                }
            }
        }
        return f2252yj;
    }

    public final JSONArray fe(JSONArray jSONArray, String str) {
        try {
            jSONArray.put(new JSONObject(str));
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
        return jSONArray;
    }

    public final boolean i(boolean z) {
        boolean z2;
        ArrayList<fe.fe.nn.p006switch.qw> arrayList;
        try {
            int uk2 = fe.fe.nn.ppp.de.uk(this.f2255rg);
            if (uk2 == 2) {
                z2 = false;
            } else {
                if (uk2 == 1) {
                    z2 = true;
                }
                return false;
            }
            String valueOf = z ? String.valueOf(1) : "1,2";
            if (z2) {
                arrayList = fe.fe.nn.p005if.qw.qw(this.f2255rg).rg(valueOf);
                String E = fe.fe.nn.qw.qw.uk(this.f2255rg).E();
                String qw2 = fe.fe.nn.ppp.de.qw();
                if (!TextUtils.isEmpty(qw2) && !qw2.equals(E)) {
                    fe.fe.nn.qw.qw.uk(this.f2255rg).b(qw2);
                    fe.fe.nn.qw.qw.uk(this.f2255rg).z(0);
                }
            } else {
                arrayList = fe.fe.nn.p005if.qw.qw(this.f2255rg).ad(valueOf);
            }
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    long Q = fe.fe.nn.qw.qw.uk(this.f2255rg).Q();
                    int size = arrayList.size();
                    long L = ((long) fe.fe.nn.qw.qw.uk(this.f2255rg).L()) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                    JSONArray jSONArray = new JSONArray();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        }
                        fe.fe.nn.p006switch.qw qwVar = arrayList.get(i2);
                        if (qwVar != null) {
                            String fe2 = qwVar.fe();
                            if (z2) {
                                if (((long) fe2.length()) + Q > L) {
                                    break;
                                }
                                Q += (long) fe2.length();
                            }
                            fe(jSONArray, fe2);
                            arrayList2.add(qwVar);
                        }
                        i2++;
                    }
                    if (jSONArray.length() == 0) {
                        return false;
                    }
                    boolean uk3 = uk(jSONArray.toString());
                    if (uk3) {
                        fe.fe.nn.p005if.qw.qw(this.f2255rg).fe(arrayList2);
                        if (z2) {
                            fe.fe.nn.qw.qw.uk(this.f2255rg).z(fe.fe.nn.qw.qw.uk(this.f2255rg).Q() + ((long) jSONArray.toString().length()));
                        }
                    }
                    return uk3;
                }
            }
            return false;
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
            return false;
        }
    }

    public void o() {
        if (fe.fe.nn.qw.qw.uk(this.f2255rg).rg() && fe.fe.nn.ppp.de.when(this.f2255rg)) {
            qw.ad().post(new de());
        }
    }

    public void rg() {
        long F = fe.fe.nn.qw.qw.uk(this.f2255rg).F();
        long N = ((long) fe.fe.nn.qw.qw.uk(this.f2255rg).N()) * fe.fe.nn.ppp.de.f2300ad;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - F >= N && fe.fe.nn.ppp.de.uk(this.f2255rg) != 0 && fe.fe.nn.qw.qw.uk(this.f2255rg).rg() && fe.fe.nn.ppp.de.when(this.f2255rg)) {
            qw.ad().post(new C0112ad(currentTimeMillis));
        }
    }

    public synchronized void th(String str, String str2, int i2) {
        try {
            fe.fe.nn.p006switch.qw qw2 = this.f2254fe.qw(this.f2255rg, str, str2, i2, 1);
            if (qw2 != null) {
                this.f2256th++;
                fe.fe.nn.p005if.qw.qw(this.f2255rg).th(qw2);
                if (this.f2256th >= 2 && fe.fe.nn.qw.qw.uk(this.f2255rg).rg() && fe.fe.nn.ppp.de.when(this.f2255rg)) {
                    this.f2256th = 0;
                    qw.ad().post(new qw());
                }
            } else {
                return;
            }
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
        return;
    }

    public final boolean uk(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            fe.fe.nn.i.qw de2 = fe.fe.nn.i.ad.de(fe.fe.nn.i.ad.qw(), th.ad(str.getBytes(a.h)));
            if (de2 == null) {
                return false;
            }
            String ad2 = this.f2253de.ad("p/1/r", URLEncoder.encode(Base64.encodeToString(rg.ad(de2.qw(), uk.ad(fe.fe.nn.ppp.fe.qw(this.f2255rg)).getBytes()), 0), a.h));
            if (de2.ad() == null) {
                return false;
            }
            String qw2 = qw(ad2, de2.ad());
            if (TextUtils.isEmpty(qw2)) {
                return false;
            }
            try {
                if (new JSONObject(qw2).getInt(LoginActivity.EXTRA_PARAM_THIRD_VERIFY_RESPONSE) == 1) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                fe.fe.nn.ppp.de.fe(th2);
            }
        } catch (Throwable th3) {
            fe.fe.nn.ppp.de.fe(th3);
            return false;
        }
    }
}
