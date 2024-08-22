package com.baidu.apollon.heartbeat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.RestTemplate;
import com.baidu.apollon.restnet.c;
import com.baidu.apollon.restnet.converter.b;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.NetworkUtils;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"HandlerLeak"})
public final class HeartBeatManager implements NoProguard {
    public static final String EVENT_KEY = "activity_state_oberserver";
    public static final String a = "HeartBeatManager";
    public static final int b = 180;
    public static HeartBeatManager c;
    public Context d = null;
    public RestHeartBeat e = new RestHeartBeat();
    public Timer f = null;
    public b g = new b();
    public long h = 0;

    /* renamed from: i  reason: collision with root package name */
    public c.a f698i = new c.a() {
        public boolean a(String str) {
            return TextUtils.equals(a.c().a() + HeartBeatManager.this.e.mHeartbeatUrl, str);
        }

        public void a(String str, String str2) {
            if (TextUtils.equals(str2, str)) {
                return;
            }
            if (!a(str)) {
                HeartBeatManager.this.e.reset();
                long access$300 = HeartBeatManager.this.e.getSplitTimeMs();
                HeartBeatManager.this.a(access$300, access$300);
                String a2 = HeartBeatManager.a;
                LogUtil.i(a2, HeartBeatManager.a + " business request success.");
                return;
            }
            String a3 = HeartBeatManager.a;
            StringBuilder sb = new StringBuilder();
            sb.append(HeartBeatManager.a);
            sb.append(" heartbeat ");
            sb.append(HeartBeatManager.this.h > 0 ? "background " : "");
            sb.append("request success.");
            LogUtil.i(a3, sb.toString());
        }
    };

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
            String a = HeartBeatManager.a;
            LogUtil.i(a, HeartBeatManager.a + " cfg:" + heartBeatCfgEntity);
        }
    }

    public static synchronized HeartBeatManager getInstance() {
        HeartBeatManager heartBeatManager;
        synchronized (HeartBeatManager.class) {
            if (c == null) {
                c = new HeartBeatManager();
            }
            heartBeatManager = c;
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
            com.baidu.apollon.heartbeat.a r0 = com.baidu.apollon.heartbeat.a.c()     // Catch:{ all -> 0x0060 }
            android.content.Context r1 = r3.d     // Catch:{ all -> 0x0060 }
            com.baidu.apollon.heartbeat.HeartBeatCfgEntity r0 = r0.a((android.content.Context) r1)     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0040
            boolean r1 = r0.isUsed()     // Catch:{ all -> 0x0060 }
            if (r1 != 0) goto L_0x0014
            goto L_0x0040
        L_0x0014:
            boolean r1 = r0.validate()     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x0026
            com.baidu.apollon.heartbeat.HeartBeatManager$RestHeartBeat r1 = r3.e     // Catch:{ all -> 0x0060 }
            r1.updateCfg(r0)     // Catch:{ all -> 0x0060 }
            com.baidu.apollon.heartbeat.b r0 = r3.g     // Catch:{ all -> 0x0060 }
            r1 = 1
            r0.a(r1)     // Catch:{ all -> 0x0060 }
            goto L_0x003e
        L_0x0026:
            java.lang.String r0 = a     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = a     // Catch:{ all -> 0x0060 }
            r1.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = " start resp isn't validate."
            r1.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0060 }
            com.baidu.apollon.utils.LogUtil.w(r0, r1)     // Catch:{ all -> 0x0060 }
        L_0x003e:
            monitor-exit(r3)
            return
        L_0x0040:
            java.lang.String r0 = a     // Catch:{ all -> 0x0060 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = a     // Catch:{ all -> 0x0060 }
            r1.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = " start resp is null or isn't used."
            r1.append(r2)     // Catch:{ all -> 0x0060 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0060 }
            com.baidu.apollon.utils.LogUtil.w(r0, r1)     // Catch:{ all -> 0x0060 }
            com.baidu.apollon.heartbeat.b r0 = r3.g     // Catch:{ all -> 0x0060 }
            r1 = 2
            r0.a(r1)     // Catch:{ all -> 0x0060 }
            monitor-exit(r3)
            return
        L_0x0060:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.heartbeat.HeartBeatManager.applyBeating():void");
    }

    public void executeInForeground(boolean z) {
        String str = a;
        LogUtil.i(str, a + " onStateChanged isForeground:" + z);
        if (z) {
            if (this.e.isValid()) {
                this.g.a(1);
                this.g.a(4);
            }
            a.c().b(this.d);
            return;
        }
        this.g.a(3);
    }

    public void init(Context context, String str) {
        if (context != null) {
            this.d = DxmApplicationContextImpl.getApplicationContext(context);
            a.c().c(str);
            return;
        }
        throw new IllegalArgumentException("context param is null exception.");
    }

    public void startHeartBeat() {
        c.a(this.f698i);
        a(0, this.e.getSplitTimeMs());
        String str = a;
        LogUtil.i(str, a + " HeartBeat start.");
    }

    public void stopHeartBeat() {
        Timer timer = this.f;
        if (timer != null) {
            timer.cancel();
            this.f = null;
        }
        this.e.reset();
        a(0);
        c.a((c.a) null);
        String str = a;
        LogUtil.i(str, a + " HeartBeat end.");
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.e.beating()) {
            this.g.a(2);
            String str = a;
            LogUtil.i(str, a + " heartbeat beat enough mKeepAliveMax:" + this.e.mKeepAliveMax + ", costTime:" + this.e.mCostTime);
        } else if (this.h > 0 && Calendar.getInstance().getTimeInMillis() / 1000 > this.h + 180) {
            this.g.a(2);
        } else if (!NetworkUtils.isNetworkAvailable(this.d)) {
            String str2 = a;
            LogUtil.i(str2, a + " schedule the network isn't available.");
        } else {
            RestTemplate restTemplate = new RestTemplate(this.d);
            restTemplate.setMessageConverter(new b());
            try {
                String str3 = a;
                LogUtil.i(str3, a + " send heartbeat request.");
                restTemplate.a(a.c().a() + this.e.mHeartbeatUrl, (List<RestNameValuePair>) null, a.h, String.class);
            } catch (RestRuntimeException e2) {
                String str4 = a;
                LogUtil.errord(str4, a + " Heart Beat exception:" + e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    public void a(long j) {
        this.h = j;
    }

    /* access modifiers changed from: private */
    public void a(long j, long j2) {
        try {
            if (this.f != null) {
                this.f.cancel();
            }
            Timer timer = new Timer();
            this.f = timer;
            timer.schedule(new TimerTask() {
                public void run() {
                    HeartBeatManager.this.b();
                }
            }, j, j2);
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        }
    }
}
