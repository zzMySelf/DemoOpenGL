package com.dxmpay.apollon.heartbeat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.dxmpay.apollon.NoProguard;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.restnet.a;
import com.dxmpay.apollon.restnet.converter.StringHttpMessageConverter;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.NetworkUtils;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"HandlerLeak"})
public final class HeartBeatManager implements NoProguard {
    public static final String EVENT_KEY = "activity_state_oberserver";

    /* renamed from: if  reason: not valid java name */
    public static HeartBeatManager f155if = null;

    /* renamed from: pf  reason: collision with root package name */
    public static final String f3980pf = "HeartBeatManager";

    /* renamed from: ad  reason: collision with root package name */
    public Context f3981ad = null;

    /* renamed from: i  reason: collision with root package name */
    public long f3982i = 0;

    /* renamed from: o  reason: collision with root package name */
    public a.C0182a f3983o = new qw();

    /* renamed from: th  reason: collision with root package name */
    public RestHeartBeat f3984th = new RestHeartBeat(this, (qw) null);

    /* renamed from: uk  reason: collision with root package name */
    public fe.i.qw.de.ad f3985uk = new fe.i.qw.de.ad();

    /* renamed from: yj  reason: collision with root package name */
    public Timer f3986yj = null;

    public class ad extends TimerTask {
        public ad() {
        }

        public void run() {
            HeartBeatManager.this.yj();
        }
    }

    public class qw implements a.C0182a {
        public qw() {
        }

        public boolean a(String str) {
            return TextUtils.equals(fe.i.qw.de.qw.i().fe() + HeartBeatManager.this.f3984th.mHeartbeatUrl, str);
        }

        public void a(String str, String str2) {
            if (TextUtils.equals(str2, str)) {
                return;
            }
            if (!a(str)) {
                HeartBeatManager.this.f3984th.reset();
                long access$300 = HeartBeatManager.this.f3984th.getSplitTimeMs();
                HeartBeatManager.this.fe(access$300, access$300);
                String ad2 = HeartBeatManager.f3980pf;
                LogUtil.i(ad2, HeartBeatManager.f3980pf + " business request success.");
                return;
            }
            String ad3 = HeartBeatManager.f3980pf;
            StringBuilder sb = new StringBuilder();
            sb.append(HeartBeatManager.f3980pf);
            sb.append(" heartbeat ");
            sb.append(HeartBeatManager.this.f3982i > 0 ? "background " : "");
            sb.append("request success.");
            LogUtil.i(ad3, sb.toString());
        }
    }

    public static synchronized HeartBeatManager getInstance() {
        HeartBeatManager heartBeatManager;
        synchronized (HeartBeatManager.class) {
            if (f155if == null) {
                f155if = new HeartBeatManager();
            }
            heartBeatManager = f155if;
        }
        return heartBeatManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void applyBeating() {
        /*
            r3 = this;
            monitor-enter(r3)
            fe.i.qw.de.qw r0 = fe.i.qw.de.qw.i()     // Catch:{ all -> 0x0060 }
            android.content.Context r1 = r3.f3981ad     // Catch:{ all -> 0x0060 }
            com.dxmpay.apollon.heartbeat.HeartBeatCfgEntity r0 = r0.ad(r1)     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0040
            boolean r1 = r0.isUsed()     // Catch:{ all -> 0x0060 }
            if (r1 != 0) goto L_0x0014
            goto L_0x0040
        L_0x0014:
            boolean r1 = r0.validate()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0026
            com.dxmpay.apollon.heartbeat.HeartBeatManager$RestHeartBeat r1 = r3.f3984th     // Catch:{ all -> 0x0060 }
            r1.updateCfg(r0)     // Catch:{ all -> 0x0060 }
            fe.i.qw.de.ad r0 = r3.f3985uk     // Catch:{ all -> 0x0060 }
            r1 = 1
            r0.ad(r1)     // Catch:{ all -> 0x0060 }
            goto L_0x003e
        L_0x0026:
            java.lang.String r0 = f3980pf     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = f3980pf     // Catch:{ all -> 0x0060 }
            r1.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = " start resp isn't validate."
            r1.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0060 }
            com.dxmpay.apollon.utils.LogUtil.w(r0, r1)     // Catch:{ all -> 0x0060 }
        L_0x003e:
            monitor-exit(r3)
            return
        L_0x0040:
            java.lang.String r0 = f3980pf     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = f3980pf     // Catch:{ all -> 0x0060 }
            r1.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = " start resp is null or isn't used."
            r1.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0060 }
            com.dxmpay.apollon.utils.LogUtil.w(r0, r1)     // Catch:{ all -> 0x0060 }
            fe.i.qw.de.ad r0 = r3.f3985uk     // Catch:{ all -> 0x0060 }
            r1 = 2
            r0.ad(r1)     // Catch:{ all -> 0x0060 }
            monitor-exit(r3)
            return
        L_0x0060:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.heartbeat.HeartBeatManager.applyBeating():void");
    }

    public void de(long j) {
        this.f3982i = j;
    }

    public void executeInForeground(boolean z) {
        String str = f3980pf;
        LogUtil.i(str, f3980pf + " onStateChanged isForeground:" + z);
        if (z) {
            if (this.f3984th.isValid()) {
                this.f3985uk.ad(1);
                this.f3985uk.ad(4);
            }
            fe.i.qw.de.qw.i().o(this.f3981ad);
            return;
        }
        this.f3985uk.ad(3);
    }

    public final void fe(long j, long j2) {
        try {
            if (this.f3986yj != null) {
                this.f3986yj.cancel();
            }
            Timer timer = new Timer();
            this.f3986yj = timer;
            timer.schedule(new ad(), j, j2);
        } catch (RuntimeException e) {
            LogUtil.e(f3980pf, e.getMessage(), e);
        }
    }

    public void init(Context context, String str) {
        if (context != null) {
            this.f3981ad = context.getApplicationContext();
            fe.i.qw.de.qw.i().m283if(str);
            return;
        }
        throw new IllegalArgumentException("context param is null exception.");
    }

    public void startHeartBeat() {
        a.ad(this.f3983o);
        fe(0, this.f3984th.getSplitTimeMs());
        String str = f3980pf;
        LogUtil.i(str, f3980pf + " HeartBeat start.");
    }

    public void stopHeartBeat() {
        Timer timer = this.f3986yj;
        if (timer != null) {
            timer.cancel();
            this.f3986yj = null;
        }
        this.f3984th.reset();
        de(0);
        a.ad((a.C0182a) null);
        String str = f3980pf;
        LogUtil.i(str, f3980pf + " HeartBeat end.");
    }

    public final void yj() {
        if (this.f3984th.beating()) {
            this.f3985uk.ad(2);
            String str = f3980pf;
            LogUtil.i(str, f3980pf + " heartbeat beat enough mKeepAliveMax:" + this.f3984th.mKeepAliveMax + ", costTime:" + this.f3984th.mCostTime);
        } else if (this.f3982i > 0 && Calendar.getInstance().getTimeInMillis() / 1000 > this.f3982i + 180) {
            this.f3985uk.ad(2);
        } else if (!NetworkUtils.isNetworkAvailable(this.f3981ad)) {
            String str2 = f3980pf;
            LogUtil.i(str2, f3980pf + " schedule the network isn't available.");
        } else {
            RestTemplate restTemplate = new RestTemplate(this.f3981ad);
            restTemplate.setMessageConverter(new StringHttpMessageConverter());
            try {
                String str3 = f3980pf;
                LogUtil.i(str3, f3980pf + " send heartbeat request.");
                restTemplate.getForObject(fe.i.qw.de.qw.i().fe() + this.f3984th.mHeartbeatUrl, (List<RestNameValuePair>) null, com.baidu.apollon.heartbeat.a.h, String.class);
            } catch (RestRuntimeException e) {
                LogUtil.e(f3980pf, e.getMessage(), e);
            }
        }
    }

    public final class RestHeartBeat implements NoProguard, Serializable {
        public static final long serialVersionUID = 1;
        public long mCostTime;
        public String mHeartbeatUrl;
        public int mKeepAliveMax;
        public int mSplitTime;

        public RestHeartBeat() {
            this.mHeartbeatUrl = "/heartbeat";
            this.mCostTime = 0;
        }

        /* access modifiers changed from: private */
        public long getSplitTimeMs() {
            return (long) (this.mSplitTime * 1000);
        }

        public boolean beating() {
            long j = this.mCostTime + ((long) this.mSplitTime);
            this.mCostTime = j;
            return j > ((long) this.mKeepAliveMax);
        }

        public boolean isValid() {
            return this.mSplitTime > 0 && this.mKeepAliveMax > 0;
        }

        public void reset() {
            this.mCostTime = 0;
        }

        public String toString() {
            return " costTime:" + this.mCostTime + ",splitTime:" + this.mSplitTime;
        }

        public void updateCfg(HeartBeatCfgEntity heartBeatCfgEntity) {
            if (!TextUtils.isEmpty(heartBeatCfgEntity.KA_INIT)) {
                this.mSplitTime = Integer.valueOf(heartBeatCfgEntity.KA_INIT).intValue();
            }
            if (!TextUtils.isEmpty(heartBeatCfgEntity.KA_MAX)) {
                this.mKeepAliveMax = Integer.valueOf(heartBeatCfgEntity.KA_MAX).intValue();
            }
            String ad2 = HeartBeatManager.f3980pf;
            LogUtil.i(ad2, HeartBeatManager.f3980pf + " cfg:" + heartBeatCfgEntity);
        }

        public /* synthetic */ RestHeartBeat(HeartBeatManager heartBeatManager, qw qwVar) {
            this();
        }
    }
}
