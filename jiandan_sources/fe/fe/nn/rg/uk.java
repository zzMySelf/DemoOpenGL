package fe.fe.nn.rg;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sso.SSOManager;
import com.baidu.sso.c.b;
import com.baidu.sso.j.d;
import fe.fe.nn.o.qw;
import fe.fe.nn.pf.fe;
import fe.fe.nn.ppp.Cif;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class uk {

    /* renamed from: yj  reason: collision with root package name */
    public static volatile uk f2357yj;

    /* renamed from: ad  reason: collision with root package name */
    public final ArrayList<SSOManager.ISSOLoginListener> f2358ad = new ArrayList<>();

    /* renamed from: de  reason: collision with root package name */
    public d f2359de;

    /* renamed from: fe  reason: collision with root package name */
    public Context f2360fe;
    public final Map<Integer, fe> qw = new HashMap();

    /* renamed from: rg  reason: collision with root package name */
    public boolean f2361rg;

    /* renamed from: th  reason: collision with root package name */
    public int f2362th = -1;

    public class ad implements SSOManager.ISSOLoginListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f2363ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ int f2364de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ long f2365fe;
        public final /* synthetic */ fe qw;

        /* renamed from: rg  reason: collision with root package name */
        public final /* synthetic */ SSOManager.ISSOLoginListener f2366rg;

        public ad(uk ukVar, fe feVar, Context context, int i2, long j, SSOManager.ISSOLoginListener iSSOLoginListener) {
            this.qw = feVar;
            this.f2363ad = context;
            this.f2364de = i2;
            this.f2365fe = j;
            this.f2366rg = iSSOLoginListener;
        }

        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.qw.o(this.f2363ad, this.f2364de, this.f2365fe);
                    return;
                }
                SSOManager.ISSOLoginListener iSSOLoginListener = this.f2366rg;
                if (iSSOLoginListener != null) {
                    iSSOLoginListener.onFinish(str);
                }
                fe.fe.nn.de.qw.de().fe(false);
            } catch (Throwable unused) {
                SSOManager.ISSOLoginListener iSSOLoginListener2 = this.f2366rg;
                if (iSSOLoginListener2 != null) {
                    iSSOLoginListener2.onFinish(str);
                }
                fe.fe.nn.de.qw.de().fe(false);
            }
        }
    }

    public class de implements SSOManager.ISSOLoginListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f2367ad;

        /* renamed from: de  reason: collision with root package name */
        public final /* synthetic */ int f2368de;

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ long f2369fe;
        public final /* synthetic */ fe qw;

        /* renamed from: rg  reason: collision with root package name */
        public final /* synthetic */ SSOManager.ISSOLoginListener f2370rg;

        public de(uk ukVar, fe feVar, Context context, int i2, long j, SSOManager.ISSOLoginListener iSSOLoginListener) {
            this.qw = feVar;
            this.f2367ad = context;
            this.f2368de = i2;
            this.f2369fe = j;
            this.f2370rg = iSSOLoginListener;
        }

        public void onFinish(String str) {
            try {
                if (new JSONObject(str).optInt("0", -1) == 0) {
                    this.qw.ggg(this.f2367ad, this.f2368de, this.f2369fe);
                    return;
                }
                SSOManager.ISSOLoginListener iSSOLoginListener = this.f2370rg;
                if (iSSOLoginListener != null) {
                    iSSOLoginListener.onFinish(str);
                }
                fe.fe.nn.de.qw.de().when(false);
            } catch (Throwable unused) {
                SSOManager.ISSOLoginListener iSSOLoginListener2 = this.f2370rg;
                if (iSSOLoginListener2 != null) {
                    iSSOLoginListener2.onFinish(str);
                }
                fe.fe.nn.de.qw.de().when(false);
            }
        }
    }

    public class qw implements b {
        public qw() {
        }

        public boolean a() {
            return fe.fe.nn.qw.qw.uk(uk.this.f2360fe).ad();
        }

        public void a(String str) {
            fe.fe.nn.qw.qw.uk(uk.this.f2360fe).a(System.currentTimeMillis());
        }
    }

    public static uk pf() {
        if (f2357yj == null) {
            synchronized (uk.class) {
                if (f2357yj == null) {
                    f2357yj = new uk();
                }
            }
        }
        return f2357yj;
    }

    public final int ad(int i2, int i3) {
        if (this.qw.size() != 1) {
            return (this.qw.size() != 2 || i3 >= 4 || i3 <= 0) ? i2 : i3;
        }
        return Integer.valueOf(this.qw.get(this.qw.keySet().iterator().next()).f2314de).intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void fe(int r7, int r8, int r9, int r10, java.lang.String r11, fe.fe.nn.rg.yj r12, boolean r13) {
        /*
            r6 = this;
            monitor-enter(r6)
            if (r12 != 0) goto L_0x0005
            monitor-exit(r6)
            return
        L_0x0005:
            fe.fe.nn.de.qw r0 = fe.fe.nn.de.qw.de()     // Catch:{ all -> 0x00a0 }
            android.util.Pair r0 = r0.ad(r7)     // Catch:{ all -> 0x00a0 }
            java.lang.Object r1 = r0.first     // Catch:{ all -> 0x00a0 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x00a0 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00a0 }
            if (r1 != 0) goto L_0x0019
            monitor-exit(r6)
            return
        L_0x0019:
            fe.fe.nn.rg.o r1 = fe.fe.nn.rg.o.qw()     // Catch:{ all -> 0x00a0 }
            r1.ad(r7)     // Catch:{ all -> 0x00a0 }
            java.lang.Object r7 = r0.second     // Catch:{ all -> 0x00a0 }
            com.baidu.sso.SSOManager$ISSOLoginListener r7 = (com.baidu.sso.SSOManager.ISSOLoginListener) r7     // Catch:{ all -> 0x00a0 }
            fe.fe.nn.rg.de r0 = new fe.fe.nn.rg.de     // Catch:{ all -> 0x00a0 }
            r0.<init>(r8, r9, r10, r11)     // Catch:{ all -> 0x00a0 }
            int r1 = r12.qw     // Catch:{ all -> 0x00a0 }
            r6.i(r7, r0, r1, r13)     // Catch:{ all -> 0x00a0 }
            r7 = 1
            if (r8 != r7) goto L_0x0033
            r12.f2371ad = r7     // Catch:{ all -> 0x00a0 }
        L_0x0033:
            if (r13 == 0) goto L_0x009e
            int r13 = r12.qw     // Catch:{ all -> 0x00a0 }
            if (r13 != r7) goto L_0x0041
            android.content.Context r7 = r6.f2360fe     // Catch:{ all -> 0x00a0 }
            int r8 = r12.f2371ad     // Catch:{ all -> 0x00a0 }
            fe.fe.nn.pf.fe.ad(r7, r10, r8, r9, r11)     // Catch:{ all -> 0x00a0 }
            goto L_0x009e
        L_0x0041:
            r7 = 3
            if (r13 != r7) goto L_0x004c
            android.content.Context r7 = r6.f2360fe     // Catch:{ all -> 0x00a0 }
            int r8 = r12.f2371ad     // Catch:{ all -> 0x00a0 }
            fe.fe.nn.pf.fe.th(r7, r10, r8, r9, r11)     // Catch:{ all -> 0x00a0 }
            goto L_0x009e
        L_0x004c:
            r11 = 2
            r0 = 2019(0x7e3, float:2.829E-42)
            if (r13 != r11) goto L_0x0078
            if (r8 != r7) goto L_0x006b
            if (r9 != r0) goto L_0x006b
            android.content.Context r7 = r6.f2360fe     // Catch:{ all -> 0x00a0 }
            fe.fe.nn.qw.qw r7 = fe.fe.nn.qw.qw.uk(r7)     // Catch:{ all -> 0x00a0 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a0 }
            r7.g(r0)     // Catch:{ all -> 0x00a0 }
            android.content.Context r7 = r6.f2360fe     // Catch:{ all -> 0x00a0 }
            fe.fe.nn.qw.qw r7 = fe.fe.nn.qw.qw.uk(r7)     // Catch:{ all -> 0x00a0 }
            r7.pf(r9)     // Catch:{ all -> 0x00a0 }
        L_0x006b:
            android.content.Context r0 = r6.f2360fe     // Catch:{ all -> 0x00a0 }
            int r4 = r12.f2372de     // Catch:{ all -> 0x00a0 }
            java.lang.String r5 = r12.f2373fe     // Catch:{ all -> 0x00a0 }
            r1 = r10
            r2 = r8
            r3 = r9
            fe.fe.nn.pf.fe.qw(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a0 }
            goto L_0x009e
        L_0x0078:
            if (r8 != r7) goto L_0x0092
            if (r9 != r0) goto L_0x0092
            android.content.Context r7 = r6.f2360fe     // Catch:{ all -> 0x00a0 }
            fe.fe.nn.qw.qw r7 = fe.fe.nn.qw.qw.uk(r7)     // Catch:{ all -> 0x00a0 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a0 }
            r7.r(r0)     // Catch:{ all -> 0x00a0 }
            android.content.Context r7 = r6.f2360fe     // Catch:{ all -> 0x00a0 }
            fe.fe.nn.qw.qw r7 = fe.fe.nn.qw.qw.uk(r7)     // Catch:{ all -> 0x00a0 }
            r7.vvv(r9)     // Catch:{ all -> 0x00a0 }
        L_0x0092:
            android.content.Context r0 = r6.f2360fe     // Catch:{ all -> 0x00a0 }
            int r4 = r12.f2372de     // Catch:{ all -> 0x00a0 }
            java.lang.String r5 = r12.f2373fe     // Catch:{ all -> 0x00a0 }
            r1 = r10
            r2 = r8
            r3 = r9
            fe.fe.nn.pf.fe.rg(r0, r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00a0 }
        L_0x009e:
            monitor-exit(r6)
            return
        L_0x00a0:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.rg.uk.fe(int, int, int, int, java.lang.String, fe.fe.nn.rg.yj, boolean):void");
    }

    public final synchronized void i(SSOManager.ISSOLoginListener iSSOLoginListener, de deVar, int i2, boolean z) {
        if (i2 == 1) {
            this.f2358ad.clear();
            th.ad(iSSOLoginListener, deVar, i2, (ArrayList) this.f2358ad.clone(), z);
        } else {
            th.ad(iSSOLoginListener, deVar, i2, (ArrayList<SSOManager.ISSOLoginListener>) null, z);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m157if(Context context, int i2, Pair<Integer, Integer> pair, long j, SSOManager.ISSOLoginListener iSSOLoginListener) {
        int qw2 = fe.fe.nn.de.qw.de().qw(iSSOLoginListener);
        try {
            Message message = new Message();
            message.what = qw2;
            message.arg1 = -1;
            message.arg2 = 3;
            this.f2362th = -1;
            o.qw().de(message, j);
            if (pair == null) {
                pair = Cif.de(context);
            }
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            int intValue3 = ((Integer) pair.second).intValue();
            if (o(qw2, intValue2, intValue, 3)) {
                int ad2 = ad(intValue2, i2);
                this.f2362th = ad2;
                if (!fe.fe.nn.de.qw.de().m147switch(false, true)) {
                    yj yjVar = new yj();
                    yjVar.qw = 3;
                    fe(qw2, 3, 998, ad2, "is doing auth prelogin.", yjVar, false);
                } else if (ad2 == 1 || ad2 == 2 || ad2 == 3) {
                    fe feVar = this.qw.get(Integer.valueOf(ad2));
                    if (feVar == null) {
                        yj yjVar2 = new yj();
                        yjVar2.qw = 3;
                        fe(qw2, 3, 2002, ad2, "not support current operator", yjVar2, true);
                        return;
                    }
                    feVar.m154switch(intValue3);
                    feVar.uk(context, qw2);
                    fe.fe(context, intValue3, 3, fe.xxx);
                } else {
                    yj yjVar3 = new yj();
                    yjVar3.qw = 3;
                    fe(qw2, 3, BaseActivity.EXTRA_PARAM_FROM_CHOICE_SHARE, ad2, "has no op.", yjVar3, true);
                }
            }
        } catch (Throwable unused) {
            yj yjVar4 = new yj();
            yjVar4.qw = 3;
            fe(qw2, 3, 2009, -1, "auth login unknown error.", yjVar4, true);
        }
    }

    public final boolean o(int i2, int i3, int i4, int i5) {
        yj yjVar = new yj();
        yjVar.qw = i5;
        if (!this.f2361rg) {
            fe(i2, 3, 2001, i3, "has no init.", yjVar, false);
            return false;
        } else if (TextUtils.isEmpty(SSOManager.f1098ad) && TextUtils.isEmpty(SSOManager.f1099de)) {
            fe(i2, 3, 2007, i3, "has no key.", yjVar, false);
            return false;
        } else if (this.qw.isEmpty()) {
            fe(i2, 3, 2002, i3, "has no sdk.", yjVar, false);
            return false;
        } else if (i4 != 0) {
            return true;
        } else {
            fe(i2, 3, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_CENTER, i3, "has no net.", yjVar, false);
            return false;
        }
    }

    public int qw() {
        return this.f2362th;
    }

    public synchronized void rg(Context context) {
        try {
            if (!this.f2361rg) {
                this.f2360fe = context.getApplicationContext();
                if (!qw.C0111qw.fe()) {
                    fe.fe.nn.ggg.qw.ad().qw(this.f2360fe, (com.baidu.sso.p.b) null);
                }
                boolean z = false;
                if (!fe.fe.nn.qw.de.qw(this.f2360fe).rg(true) && fe.fe.nn.ppp.de.uk(this.f2360fe) == 0) {
                    z = true;
                }
                uk(this.f2360fe, z);
                fe.fe.nn.ppp.de.o(this.f2360fe);
                fe.fe.nn.fe.qw.qw().de(new qw());
                this.qw.put(1, new qw(this.f2360fe));
                this.qw.put(3, new fe.fe.nn.th.qw(this.f2360fe));
                this.qw.put(2, new fe.fe.nn.yj.qw(this.f2360fe));
                this.f2361rg = true;
            }
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m158switch(Context context, long j, SSOManager.ISSOLoginListener iSSOLoginListener) {
        Context context2 = context;
        long j2 = j;
        int qw2 = fe.fe.nn.de.qw.de().qw(iSSOLoginListener);
        Pair<Integer, Integer> de2 = Cif.de(context);
        int intValue = ((Integer) de2.first).intValue();
        int intValue2 = ((Integer) de2.second).intValue();
        if (o(qw2, intValue2, intValue, 4)) {
            if (intValue2 == 1 || intValue2 == 2 || intValue2 == 3) {
                fe feVar = this.qw.get(Integer.valueOf(intValue2));
                if (feVar == null) {
                    yj yjVar = new yj();
                    yjVar.qw = 4;
                    fe(qw2, 3, 2002, intValue2, "not support current operator", yjVar, true);
                } else if (!fe.fe.nn.de.qw.de().ppp(false, true)) {
                    yj yjVar2 = new yj();
                    yjVar2.qw = 4;
                    fe(qw2, 3, 998, intValue2, "is doing auth verify.", yjVar2, false);
                } else {
                    fe.fe(context2, intValue2, 4, fe.xxx);
                    if (!feVar.vvv()) {
                        feVar.ggg(context2, qw2, j2);
                    } else if (fe.fe.nn.de.qw.de().pf()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (fe.fe.nn.de.qw.de().pf()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 <= 0 || currentTimeMillis2 >= j2) {
                                yj yjVar3 = new yj();
                                yjVar3.qw = 4;
                                fe(qw2, 3, 2019, intValue2, "auth out time", yjVar3, true);
                                return;
                            }
                            try {
                                Thread.sleep(100);
                                if (!feVar.vvv()) {
                                    feVar.ggg(context2, qw2, j2);
                                    return;
                                }
                            } catch (Throwable th2) {
                                fe.fe.nn.ppp.de.fe(th2);
                                yj yjVar4 = new yj();
                                yjVar4.qw = 4;
                                fe(qw2, 3, 2019, intValue2, "auth out time", yjVar4, true);
                                return;
                            }
                        }
                    } else {
                        m157if(context, 0, de2, j, new de(this, feVar, context, qw2, j, iSSOLoginListener));
                    }
                }
            } else {
                yj yjVar5 = new yj();
                yjVar5.qw = 4;
                fe(qw2, 3, BaseActivity.EXTRA_PARAM_FROM_CHOICE_SHARE, intValue2, "has no op.", yjVar5, true);
            }
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00bc */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void th(android.content.Context r13, int r14, android.util.Pair<java.lang.Integer, java.lang.Integer> r15, long r16, com.baidu.sso.SSOManager.ISSOLoginListener r18) {
        /*
            r12 = this;
            r9 = r12
            r0 = r13
            r1 = r18
            monitor-enter(r12)
            r2 = -1
            r10 = 1
            fe.fe.nn.de.qw r3 = fe.fe.nn.de.qw.de()     // Catch:{ all -> 0x00bc }
            boolean r3 = r3.yj()     // Catch:{ all -> 0x00bc }
            if (r3 == 0) goto L_0x0018
            java.util.ArrayList<com.baidu.sso.SSOManager$ISSOLoginListener> r0 = r9.f2358ad     // Catch:{ all -> 0x00bc }
            r0.add(r1)     // Catch:{ all -> 0x00bc }
            monitor-exit(r12)
            return
        L_0x0018:
            java.util.ArrayList<com.baidu.sso.SSOManager$ISSOLoginListener> r3 = r9.f2358ad     // Catch:{ all -> 0x00bc }
            r3.clear()     // Catch:{ all -> 0x00bc }
            fe.fe.nn.de.qw r3 = fe.fe.nn.de.qw.de()     // Catch:{ all -> 0x00bc }
            int r11 = r3.qw(r1)     // Catch:{ all -> 0x00bc }
            android.os.Message r1 = new android.os.Message     // Catch:{ all -> 0x00bb }
            r1.<init>()     // Catch:{ all -> 0x00bb }
            r1.what = r11     // Catch:{ all -> 0x00bb }
            r1.arg1 = r2     // Catch:{ all -> 0x00bb }
            r1.arg2 = r10     // Catch:{ all -> 0x00bb }
            r9.f2362th = r2     // Catch:{ all -> 0x00bb }
            fe.fe.nn.rg.o r2 = fe.fe.nn.rg.o.qw()     // Catch:{ all -> 0x00bb }
            r3 = r16
            r2.de(r1, r3)     // Catch:{ all -> 0x00bb }
            if (r15 != 0) goto L_0x0042
            android.util.Pair r1 = fe.fe.nn.ppp.Cif.de(r13)     // Catch:{ all -> 0x00bb }
            goto L_0x0043
        L_0x0042:
            r1 = r15
        L_0x0043:
            java.lang.Object r2 = r1.first     // Catch:{ all -> 0x00bb }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x00bb }
            int r2 = r2.intValue()     // Catch:{ all -> 0x00bb }
            java.lang.Object r3 = r1.second     // Catch:{ all -> 0x00bb }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x00bb }
            int r3 = r3.intValue()     // Catch:{ all -> 0x00bb }
            java.lang.Object r1 = r1.second     // Catch:{ all -> 0x00bb }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00bb }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00bb }
            boolean r4 = r12.o(r11, r3, r2, r10)     // Catch:{ all -> 0x00bb }
            if (r4 != 0) goto L_0x0063
            monitor-exit(r12)
            return
        L_0x0063:
            r4 = r14
            int r5 = r12.ad(r3, r14)     // Catch:{ all -> 0x00bb }
            r9.f2362th = r5     // Catch:{ all -> 0x00bb }
            fe.fe.nn.de.qw r3 = fe.fe.nn.de.qw.de()     // Catch:{ all -> 0x00bb }
            r4 = 0
            r3.i(r4, r10)     // Catch:{ all -> 0x00bb }
            if (r5 == r10) goto L_0x008e
            r3 = 2
            if (r5 == r3) goto L_0x008e
            r3 = 3
            if (r5 == r3) goto L_0x008e
            fe.fe.nn.rg.yj r7 = new fe.fe.nn.rg.yj     // Catch:{ all -> 0x00bb }
            r7.<init>()     // Catch:{ all -> 0x00bb }
            r7.qw = r10     // Catch:{ all -> 0x00bb }
            r3 = 3
            r4 = 2004(0x7d4, float:2.808E-42)
            java.lang.String r6 = "has no op."
            r8 = 1
            r1 = r12
            r2 = r11
            r1.fe(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00bb }
            monitor-exit(r12)
            return
        L_0x008e:
            java.util.Map<java.lang.Integer, fe.fe.nn.rg.fe> r3 = r9.qw     // Catch:{ all -> 0x00bb }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00bb }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x00bb }
            fe.fe.nn.rg.fe r3 = (fe.fe.nn.rg.fe) r3     // Catch:{ all -> 0x00bb }
            if (r3 != 0) goto L_0x00af
            fe.fe.nn.rg.yj r7 = new fe.fe.nn.rg.yj     // Catch:{ all -> 0x00bb }
            r7.<init>()     // Catch:{ all -> 0x00bb }
            r7.qw = r10     // Catch:{ all -> 0x00bb }
            r3 = 3
            r4 = 2002(0x7d2, float:2.805E-42)
            java.lang.String r6 = "not support current operator"
            r8 = 1
            r1 = r12
            r2 = r11
            r1.fe(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00bb }
            goto L_0x00ce
        L_0x00af:
            r3.m154switch(r1)     // Catch:{ all -> 0x00bb }
            r3.i(r13, r2, r11)     // Catch:{ all -> 0x00bb }
            java.lang.String r2 = fe.fe.nn.rg.fe.vvv     // Catch:{ all -> 0x00bb }
            fe.fe.nn.pf.fe.fe(r13, r1, r10, r2)     // Catch:{ all -> 0x00bb }
            goto L_0x00ce
        L_0x00bb:
            r2 = r11
        L_0x00bc:
            fe.fe.nn.rg.yj r7 = new fe.fe.nn.rg.yj     // Catch:{ all -> 0x00d0 }
            r7.<init>()     // Catch:{ all -> 0x00d0 }
            r7.qw = r10     // Catch:{ all -> 0x00d0 }
            r3 = 3
            r4 = 2009(0x7d9, float:2.815E-42)
            r5 = -1
            java.lang.String r6 = "auth login unknown error."
            r8 = 1
            r1 = r12
            r1.fe(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00d0 }
        L_0x00ce:
            monitor-exit(r12)
            return
        L_0x00d0:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.nn.rg.uk.th(android.content.Context, int, android.util.Pair, long, com.baidu.sso.SSOManager$ISSOLoginListener):void");
    }

    public synchronized void uk(Context context, boolean z) {
        try {
            when(context);
            this.f2359de = new d();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("sso_action_t_m");
            if (z) {
                intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
            }
            context.registerReceiver(this.f2359de, intentFilter);
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
        return;
    }

    public final void when(Context context) {
        try {
            d dVar = this.f2359de;
            if (dVar != null) {
                context.unregisterReceiver(dVar);
            }
            this.f2359de = null;
        } catch (Throwable th2) {
            fe.fe.nn.ppp.de.fe(th2);
        }
    }

    public void yj(Context context, long j, SSOManager.ISSOLoginListener iSSOLoginListener) {
        Context context2 = context;
        long j2 = j;
        int qw2 = fe.fe.nn.de.qw.de().qw(iSSOLoginListener);
        Pair<Integer, Integer> de2 = Cif.de(context);
        int intValue = ((Integer) de2.first).intValue();
        int intValue2 = ((Integer) de2.second).intValue();
        if (o(qw2, intValue2, intValue, 2)) {
            if (intValue2 == 1 || intValue2 == 2 || intValue2 == 3) {
                fe feVar = this.qw.get(Integer.valueOf(intValue2));
                if (feVar == null) {
                    yj yjVar = new yj();
                    yjVar.qw = 2;
                    fe(qw2, 3, 2002, intValue2, "not support current operator", yjVar, true);
                } else if (!fe.fe.nn.de.qw.de().rg(false, true)) {
                    yj yjVar2 = new yj();
                    yjVar2.qw = 2;
                    fe(qw2, 3, 998, intValue2, "is doing auth login.", yjVar2, false);
                } else {
                    fe.fe(context2, intValue2, 2, fe.vvv);
                    if (!feVar.m153if()) {
                        feVar.o(context2, qw2, j2);
                    } else if (fe.fe.nn.de.qw.de().yj()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        while (fe.fe.nn.de.qw.de().yj()) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            if (currentTimeMillis2 <= 0 || currentTimeMillis2 >= j2) {
                                yj yjVar3 = new yj();
                                yjVar3.qw = 2;
                                fe(qw2, 3, 2019, intValue2, "auth out time", yjVar3, true);
                                return;
                            }
                            try {
                                Thread.sleep(100);
                                if (!feVar.m153if()) {
                                    feVar.o(context2, qw2, j2);
                                    return;
                                }
                            } catch (Throwable th2) {
                                fe.fe.nn.ppp.de.fe(th2);
                                yj yjVar4 = new yj();
                                yjVar4.qw = 2;
                                fe(qw2, 3, 2019, intValue2, "auth out time", yjVar4, true);
                                return;
                            }
                        }
                    } else {
                        th(context, 0, de2, j, new ad(this, feVar, context, qw2, j, iSSOLoginListener));
                    }
                }
            } else {
                yj yjVar5 = new yj();
                yjVar5.qw = 2;
                fe(qw2, 3, BaseActivity.EXTRA_PARAM_FROM_CHOICE_SHARE, intValue2, "has no op.", yjVar5, true);
            }
        }
    }
}
