package fe.fe.p004if.qw.ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.client.bean.BLCPResponse;
import com.baidu.lcp.sdk.request.GetTokenRequest;
import com.baidu.lcp.sdk.request.HttpExecutor;
import fe.fe.p004if.qw.yj.fe;
import fe.fe.p004if.qw.yj.rg;
import java.util.LinkedHashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: fe.fe.if.qw.ad.de  reason: invalid package */
public class de implements GetTokenRequest.TokenResponseListener, Observer {

    /* renamed from: fe  reason: collision with root package name */
    public static volatile ad f1906fe = new ad();

    /* renamed from: rg  reason: collision with root package name */
    public static volatile de f1907rg;

    /* renamed from: ad  reason: collision with root package name */
    public int f1908ad = -1;

    /* renamed from: de  reason: collision with root package name */
    public ad f1909de;
    public Context qw;

    /* renamed from: fe.fe.if.qw.ad.de$ad */
    public class ad extends BroadcastReceiver {

        /* renamed from: fe.fe.if.qw.ad.de$ad$qw */
        public class qw implements Runnable {
            public qw() {
            }

            public void run() {
                de.this.rg();
            }
        }

        public ad() {
        }

        public void onReceive(Context context, Intent intent) {
            fe.qw("LCPClientManager", "NetStatusReceiver changed");
            if (RequsetNetworkUtils.isNetworkAvailable(context) && rg.m115switch(context)) {
                fe.ad("LCPClientManager", "NetStatusReceiver reconnect");
                fe.fe.p004if.qw.th.qw.qw(context).ad(new qw());
            }
        }
    }

    static {
        new LinkedHashMap();
    }

    public de() {
        new LinkedBlockingQueue();
    }

    public static synchronized de th() {
        de deVar;
        synchronized (de.class) {
            if (f1907rg == null) {
                synchronized (de.class) {
                    if (f1907rg == null) {
                        f1907rg = new de();
                    }
                }
            }
            deVar = f1907rg;
        }
        return deVar;
    }

    public static int yj() {
        return f1906fe.qw;
    }

    public void de(Context context, String str, String str2, int i2) {
        if (f1906fe.qw == -2 || f1906fe.qw == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("SocketConnect state is ");
            sb.append(f1906fe.qw == 0 ? "connected" : "connecting");
            fe.qw("LCPClientManager", sb.toString());
            return;
        }
        fe(context, str, str2, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0139, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x016d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void fe(android.content.Context r10, java.lang.String r11, java.lang.String r12, int r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            if (r10 == 0) goto L_0x016c
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0169 }
            if (r0 != 0) goto L_0x016c
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0169 }
            if (r0 != 0) goto L_0x016c
            boolean r0 = com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils.isConnected(r10)     // Catch:{ all -> 0x0169 }
            if (r0 != 0) goto L_0x0017
            goto L_0x016c
        L_0x0017:
            r9.qw = r10     // Catch:{ all -> 0x0169 }
            java.lang.String r0 = fe.fe.p004if.qw.yj.rg.ad(r10)     // Catch:{ all -> 0x0169 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0169 }
            if (r0 == 0) goto L_0x0026
            fe.fe.p004if.qw.yj.rg.vvv(r10, r11)     // Catch:{ all -> 0x0169 }
        L_0x0026:
            java.lang.String r11 = fe.fe.p004if.qw.yj.rg.rg(r10)     // Catch:{ all -> 0x0169 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0169 }
            if (r11 == 0) goto L_0x0033
            fe.fe.p004if.qw.yj.rg.ddd(r10, r12)     // Catch:{ all -> 0x0169 }
        L_0x0033:
            fe.fe.if.qw.de.fe r11 = fe.fe.p004if.qw.de.fe.v(r10)     // Catch:{ all -> 0x0169 }
            fe.fe.if.qw.ad.de r0 = f1907rg     // Catch:{ all -> 0x0169 }
            r11.addObserver(r0)     // Catch:{ all -> 0x0169 }
            fe.fe.if.qw.ad.ad r11 = f1906fe     // Catch:{ all -> 0x0169 }
            int r11 = r11.qw     // Catch:{ all -> 0x0169 }
            r0 = -2
            if (r11 == r0) goto L_0x0146
            fe.fe.if.qw.ad.ad r11 = f1906fe     // Catch:{ all -> 0x0169 }
            int r11 = r11.qw     // Catch:{ all -> 0x0169 }
            if (r11 != 0) goto L_0x004b
            goto L_0x0146
        L_0x004b:
            fe.fe.if.qw.ad.de$ad r11 = r9.f1909de     // Catch:{ all -> 0x0169 }
            if (r11 != 0) goto L_0x0064
            android.content.IntentFilter r11 = new android.content.IntentFilter     // Catch:{ all -> 0x0169 }
            r11.<init>()     // Catch:{ all -> 0x0169 }
            java.lang.String r0 = "android.net.conn.CONNECTIVITY_CHANGE"
            r11.addAction(r0)     // Catch:{ all -> 0x0169 }
            fe.fe.if.qw.ad.de$ad r0 = new fe.fe.if.qw.ad.de$ad     // Catch:{ all -> 0x0169 }
            r1 = 0
            r0.<init>()     // Catch:{ all -> 0x0169 }
            r9.f1909de = r0     // Catch:{ all -> 0x0169 }
            r10.registerReceiver(r0, r11)     // Catch:{ all -> 0x0169 }
        L_0x0064:
            boolean r11 = fe.fe.p004if.qw.qw.fe.o(r10)     // Catch:{ all -> 0x0169 }
            r0 = 0
            if (r11 == 0) goto L_0x012b
            java.lang.String r11 = "1N"
            r1 = 0
            java.lang.String r3 = "ext"
            r4 = 501110(0x7a576, double:2.47581E-318)
            java.lang.String[] r6 = fe.fe.p004if.qw.qw.fe.rg(r10)     // Catch:{ Exception -> 0x00b5 }
            int r7 = r6.length     // Catch:{ Exception -> 0x00b5 }
            r8 = 3
            if (r7 < r8) goto L_0x008c
            r7 = r6[r0]     // Catch:{ Exception -> 0x00b5 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x00b5 }
            long r1 = r7.longValue()     // Catch:{ Exception -> 0x00b5 }
            r7 = 1
            r11 = r6[r7]     // Catch:{ Exception -> 0x00b5 }
            r7 = 2
            r3 = r6[r7]     // Catch:{ Exception -> 0x00b5 }
        L_0x008c:
            fe.fe.if.qw.qw.qw$fe r6 = new fe.fe.if.qw.qw.qw$fe     // Catch:{ all -> 0x0169 }
            r6.<init>(r10)     // Catch:{ all -> 0x0169 }
            int r7 = fe.fe.p004if.qw.qw.fe.th(r10)     // Catch:{ all -> 0x0169 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0169 }
            r6.rg(r7)     // Catch:{ all -> 0x0169 }
            r6.th(r11)     // Catch:{ all -> 0x0169 }
            long r7 = fe.fe.p004if.qw.qw.fe.fe(r10)     // Catch:{ all -> 0x0169 }
            r6.yj(r7)     // Catch:{ all -> 0x0169 }
            r6.uk(r1)     // Catch:{ all -> 0x0169 }
            r6.fe(r3)     // Catch:{ all -> 0x0169 }
            r6.qw(r4)     // Catch:{ all -> 0x0169 }
        L_0x00af:
            r6.ad()     // Catch:{ all -> 0x0169 }
            goto L_0x00e0
        L_0x00b3:
            r12 = move-exception
            goto L_0x0104
        L_0x00b5:
            java.lang.String r6 = "LCPClientManager"
            java.lang.String r7 = "LcpTrack init request getLoginFlag Exception "
            fe.fe.p004if.qw.yj.fe.ad(r6, r7)     // Catch:{ all -> 0x00b3 }
            fe.fe.if.qw.qw.qw$fe r6 = new fe.fe.if.qw.qw.qw$fe     // Catch:{ all -> 0x0169 }
            r6.<init>(r10)     // Catch:{ all -> 0x0169 }
            int r7 = fe.fe.p004if.qw.qw.fe.th(r10)     // Catch:{ all -> 0x0169 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0169 }
            r6.rg(r7)     // Catch:{ all -> 0x0169 }
            r6.th(r11)     // Catch:{ all -> 0x0169 }
            long r7 = fe.fe.p004if.qw.qw.fe.fe(r10)     // Catch:{ all -> 0x0169 }
            r6.yj(r7)     // Catch:{ all -> 0x0169 }
            r6.uk(r1)     // Catch:{ all -> 0x0169 }
            r6.fe(r3)     // Catch:{ all -> 0x0169 }
            r6.qw(r4)     // Catch:{ all -> 0x0169 }
            goto L_0x00af
        L_0x00e0:
            fe.fe.p004if.qw.qw.ad.pf(r10)     // Catch:{ all -> 0x0169 }
            fe.fe.p004if.qw.qw.fe.aaa(r10)     // Catch:{ all -> 0x0169 }
            java.lang.String r11 = "1Y"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0169 }
            r1.<init>()     // Catch:{ all -> 0x0169 }
            java.lang.String r2 = "context is nonnull, accessToken is null -> "
            r1.append(r2)     // Catch:{ all -> 0x0169 }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0169 }
            r1.append(r12)     // Catch:{ all -> 0x0169 }
            java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x0169 }
            fe.fe.p004if.qw.qw.fe.qqq(r10, r11, r12)     // Catch:{ all -> 0x0169 }
            fe.fe.p004if.qw.qw.fe.eee(r10, r13)     // Catch:{ all -> 0x0169 }
            goto L_0x012b
        L_0x0104:
            fe.fe.if.qw.qw.qw$fe r13 = new fe.fe.if.qw.qw.qw$fe     // Catch:{ all -> 0x0169 }
            r13.<init>(r10)     // Catch:{ all -> 0x0169 }
            int r0 = fe.fe.p004if.qw.qw.fe.th(r10)     // Catch:{ all -> 0x0169 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0169 }
            r13.rg(r0)     // Catch:{ all -> 0x0169 }
            r13.th(r11)     // Catch:{ all -> 0x0169 }
            long r10 = fe.fe.p004if.qw.qw.fe.fe(r10)     // Catch:{ all -> 0x0169 }
            r13.yj(r10)     // Catch:{ all -> 0x0169 }
            r13.uk(r1)     // Catch:{ all -> 0x0169 }
            r13.fe(r3)     // Catch:{ all -> 0x0169 }
            r13.qw(r4)     // Catch:{ all -> 0x0169 }
            r13.ad()     // Catch:{ all -> 0x0169 }
            throw r12     // Catch:{ all -> 0x0169 }
        L_0x012b:
            boolean r10 = fe.fe.p004if.qw.yj.rg.pf(r10)     // Catch:{ all -> 0x0169 }
            if (r10 != 0) goto L_0x013a
            int r10 = r9.f1908ad     // Catch:{ all -> 0x0169 }
            if (r10 >= 0) goto L_0x0138
            r9.pf()     // Catch:{ all -> 0x0169 }
        L_0x0138:
            monitor-exit(r9)
            return
        L_0x013a:
            java.lang.String r10 = "LCPClientManager"
            java.lang.String r11 = "token is not null "
            fe.fe.p004if.qw.yj.fe.ad(r10, r11)     // Catch:{ all -> 0x0169 }
            r9.i(r0)     // Catch:{ all -> 0x0169 }
            monitor-exit(r9)
            return
        L_0x0146:
            java.lang.String r10 = "LCPClientManager"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0169 }
            r11.<init>()     // Catch:{ all -> 0x0169 }
            java.lang.String r12 = "SocketConnect state is "
            r11.append(r12)     // Catch:{ all -> 0x0169 }
            fe.fe.if.qw.ad.ad r12 = f1906fe     // Catch:{ all -> 0x0169 }
            int r12 = r12.qw     // Catch:{ all -> 0x0169 }
            if (r12 != 0) goto L_0x015b
            java.lang.String r12 = "connected"
            goto L_0x015d
        L_0x015b:
            java.lang.String r12 = "connecting"
        L_0x015d:
            r11.append(r12)     // Catch:{ all -> 0x0169 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0169 }
            fe.fe.p004if.qw.yj.fe.qw(r10, r11)     // Catch:{ all -> 0x0169 }
            monitor-exit(r9)
            return
        L_0x0169:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        L_0x016c:
            monitor-exit(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.p004if.qw.ad.de.fe(android.content.Context, java.lang.String, java.lang.String, int):void");
    }

    public final void i(int i2) {
        Context context = this.qw;
        if (context != null && rg.m115switch(context)) {
            if (i2 == 0) {
                fe.qw("LCPClientManager", "socketAction createSocket");
                f1906fe.qw = -2;
                fe.fe.p004if.qw.de.fe.v(this.qw).J();
            } else if (i2 == 1) {
                fe.qw("LCPClientManager", "socketAction closeSocket");
                fe.fe.p004if.qw.de.fe.v(this.qw).K("socketAction closeSocket:", fe.fe.p004if.qw.de.fe.v(this.qw).qqq);
            }
        }
    }

    public final boolean o() {
        Context context = this.qw;
        if (context == null || fe.fe.p004if.qw.de.fe.v(context).u().qw != -1) {
            return true;
        }
        return false;
    }

    public void onFailure(int i2, String str) {
        fe.ad("LCPClientManager", "getToken :" + str);
        pf();
        fe.fe.p004if.qw.qw.fe.qqq(this.qw, "2N_1", "accessToken fail");
        if (this.f1908ad == 2) {
            f1906fe.qw = -1;
            fe.fe.p004if.qw.de.fe.v(this.qw).C();
        }
    }

    public void pf() {
        Object obj;
        Context context = this.qw;
        if (context == null || !RequsetNetworkUtils.isConnected(context)) {
            StringBuilder sb = new StringBuilder();
            sb.append("context = ");
            sb.append(this.qw);
            sb.append(", net :");
            Context context2 = this.qw;
            if (context2 == null) {
                obj = "";
            } else {
                obj = Boolean.valueOf(!RequsetNetworkUtils.isConnected(context2));
            }
            sb.append(obj);
            fe.qw("LCPClientManager", sb.toString());
            return;
        }
        this.f1908ad++;
        fe.qw("LCPClientManager", "no token, so request token, and tryCount = " + this.f1908ad);
        if (this.f1908ad < 3) {
            fe.fe.p004if.qw.qw.fe.qqq(this.qw, "2N", "accessToken is null");
            GetTokenRequest getTokenRequest = new GetTokenRequest(this.qw, this);
            HttpExecutor.rg(getTokenRequest, getTokenRequest);
            return;
        }
        this.f1908ad = -1;
    }

    public void qw(String str) {
        this.f1908ad = -1;
        i(0);
        fe.fe.p004if.qw.qw.fe.qqq(this.qw, "2Y", "accessToken success");
    }

    public final void rg() {
        Context context = this.qw;
        de(context, rg.ad(context), rg.rg(this.qw), fe.fe.p004if.qw.qw.fe.th(this.qw));
    }

    public void uk(@NonNull BLCPRequest bLCPRequest, @Nullable BLCPResponse bLCPResponse) {
        Context context = this.qw;
        if (context == null || !rg.m115switch(context)) {
            if (bLCPResponse != null) {
                bLCPResponse.qw(8010, "unconnected", bLCPRequest.qw, bLCPRequest.f866ad, bLCPRequest.f868fe, new byte[0]);
            }
        } else if (f1906fe.qw != 0) {
            if (!(bLCPRequest instanceof fe.fe.p004if.qw.ad.fe.qw) && bLCPResponse != null) {
                bLCPResponse.qw(8010, "unconnected", bLCPRequest.qw, bLCPRequest.f866ad, bLCPRequest.f868fe, new byte[0]);
            }
            if (f1906fe.qw == -1 || !o()) {
                rg();
            }
        } else {
            fe.fe.p004if.qw.de.fe.v(this.qw).h(bLCPRequest, bLCPResponse);
            if (bLCPRequest.f866ad == 1 && bLCPRequest.qw == 4) {
                fe.qw("LCPClientManager", "云控登录打点");
                Context context2 = this.qw;
                fe.fe.p004if.qw.yj.ad.qw(context2, 1, "invoke", bLCPRequest.f868fe + "");
            }
            if (bLCPRequest.f866ad == 50 && bLCPRequest.qw == 2) {
                Context context3 = this.qw;
                fe.fe.p004if.qw.yj.ad.qw(context3, 50, "invoke", bLCPRequest.f868fe + "");
            }
        }
    }

    public void update(Observable observable, Object obj) {
        if (obj instanceof ad) {
            f1906fe.qw = ((ad) obj).qw;
            fe.qw("LCPClientManager", "Manager update connectState :" + f1906fe.qw);
        }
    }
}
