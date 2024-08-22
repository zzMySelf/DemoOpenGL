package com.duxiaoman.dxmpay.statistics.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.apollon.statistics.Config;
import com.baidu.wallet.core.beans.CometHttpRequestInterceptor;
import com.duxiaoman.dxmpay.statistics.StatApi;
import com.duxiaoman.dxmpay.statistics.StrategyProcess;
import fe.th.qw.qw.qw.fe;
import fe.th.qw.qw.qw.yj;
import java.util.HashMap;

public class LogSender {

    /* renamed from: ad  reason: collision with root package name */
    public Handler f3795ad;
    public HandlerThread qw;

    public class ad extends Handler {
        public ad(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (StatApi.getAppContext() != null) {
                int i2 = message.what;
                if (10000 == i2) {
                    LogSender.this.fe((String) message.obj);
                    LogSender.this.th();
                } else if (10001 == i2) {
                    LogSender.this.fe("normal_log");
                    LogSender.this.th();
                } else if (10002 == i2) {
                    StrategyProcess.getInstance().loadCachedStrategy(StatApi.getAppContext());
                }
            }
        }
    }

    public static class qw {
        public static LogSender qw = new LogSender((ad) null);
    }

    public /* synthetic */ LogSender(ad adVar) {
        this();
    }

    public static LogSender getInstance() {
        return qw.qw;
    }

    public final synchronized boolean de(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String ad2 = fe.th.qw.qw.qw.ad.qw().ad(context);
        if (TextUtils.isEmpty(ad2)) {
            return false;
        }
        return ad2.equals(fe.th.qw.qw.qw.qw.rg(str.getBytes(), false));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean fe(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            fe.th.qw.qw.qw.fe r0 = fe.th.qw.qw.qw.fe.qw()     // Catch:{ all -> 0x006c }
            boolean r0 = r0.yj()     // Catch:{ all -> 0x006c }
            r1 = 0
            if (r0 == 0) goto L_0x000e
            monitor-exit(r5)
            return r1
        L_0x000e:
            android.content.Context r0 = com.duxiaoman.dxmpay.statistics.StatApi.getAppContext()     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x0016
            monitor-exit(r5)
            return r1
        L_0x0016:
            boolean r2 = fe.th.qw.qw.qw.qw.uk(r0)     // Catch:{ all -> 0x006c }
            if (r2 != 0) goto L_0x001e
            monitor-exit(r5)
            return r1
        L_0x001e:
            fe.th.qw.qw.qw.fe r2 = fe.th.qw.qw.qw.fe.qw()     // Catch:{ all -> 0x006c }
            fe.th.qw.qw.qw.fe$ad r2 = r2.th(r6)     // Catch:{ all -> 0x006c }
            int r3 = r2.qw     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x006a
            java.lang.String r3 = r2.f5584ad     // Catch:{ all -> 0x006c }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x0033
            goto L_0x006a
        L_0x0033:
            java.lang.String r3 = r2.f5584ad     // Catch:{ all -> 0x006c }
            r4 = 0
            boolean r3 = r5.rg(r3, r4)     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x0068
            java.lang.String r3 = "normal_log"
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x0055
            java.lang.String r3 = r2.f5584ad     // Catch:{ all -> 0x006c }
            byte[] r3 = r3.getBytes()     // Catch:{ all -> 0x006c }
            java.lang.String r1 = fe.th.qw.qw.qw.qw.rg(r3, r1)     // Catch:{ all -> 0x006c }
            fe.th.qw.qw.qw.ad r3 = fe.th.qw.qw.qw.ad.qw()     // Catch:{ all -> 0x006c }
            r3.fe(r0, r1)     // Catch:{ all -> 0x006c }
        L_0x0055:
            fe.th.qw.qw.qw.fe r0 = fe.th.qw.qw.qw.fe.qw()     // Catch:{ all -> 0x006c }
            int r1 = r2.qw     // Catch:{ all -> 0x006c }
            r0.ad(r1, r6)     // Catch:{ all -> 0x006c }
            fe.th.qw.qw.qw.fe r0 = fe.th.qw.qw.qw.fe.qw()     // Catch:{ all -> 0x006c }
            r0.fe(r6)     // Catch:{ all -> 0x006c }
            r6 = 1
            monitor-exit(r5)
            return r6
        L_0x0068:
            monitor-exit(r5)
            return r1
        L_0x006a:
            monitor-exit(r5)
            return r1
        L_0x006c:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duxiaoman.dxmpay.statistics.internal.LogSender.fe(java.lang.String):boolean");
    }

    public void qw() {
        Context appContext = StatApi.getAppContext();
        if (appContext != null) {
            yj.ad(fe.th.qw.qw.qw.ad.qw().rg(appContext));
            this.f3795ad.sendEmptyMessage(10002);
        }
    }

    public final boolean rg(String str, String str2) {
        ISyncHttpImpl httpImpl;
        String str3 = str.toString();
        Context appContext = StatApi.getAppContext();
        if (appContext == null || !yj(appContext, str)) {
            return false;
        }
        try {
            IStatConfig settings = StatApi.getInstance().getSettings();
            if (settings == null || (httpImpl = StatApi.getInstance().getHttpImpl()) == null) {
                return false;
            }
            String uploadUrl = settings.getUploadUrl();
            String encodeToString = Base64.encodeToString(f.ad(str3, settings.getCommonEvent(), settings.getDistinctId(), settings.getDistinctIdKey(), settings.isLogin(), settings.getProductName(), settings.getSDKVersion(), settings.getChannelId(), settings.getAppVersionName(), settings.getAppVersionCode()).getBytes(), 2);
            HashMap hashMap = new HashMap();
            hashMap.put("sign", fe.th.qw.qw.qw.qw.rg((encodeToString + "(null)").getBytes("GBK"), false));
            hashMap.put("data", encodeToString);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(Config.f713i, str2);
            }
            boolean send = httpImpl.send(appContext, 1, uploadUrl, hashMap);
            return !send ? httpImpl.send(appContext, 1, settings.getBackUploadUrl(), hashMap) : send;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void th() {
        Context appContext = StatApi.getAppContext();
        if (appContext != null) {
            this.f3795ad.removeMessages(10001);
            int i2 = StrategyProcess.getInstance().get3GSendingInterval();
            if (fe.th.qw.qw.qw.qw.pf(appContext)) {
                i2 = StrategyProcess.getInstance().getWifiSendingInterval();
            }
            this.f3795ad.sendEmptyMessageDelayed(10001, (long) (i2 * CometHttpRequestInterceptor.a));
        }
    }

    public void triggerSending(String str) {
        this.f3795ad.obtainMessage(10000, str).sendToTarget();
    }

    public final boolean yj(Context context, String str) {
        if (fe.qw().yj() || !de(context, str)) {
            return true;
        }
        fe.qw().fe("normal_log");
        return false;
    }

    public LogSender() {
        HandlerThread handlerThread = new HandlerThread("SensorLogSenderThread");
        this.qw = handlerThread;
        handlerThread.start();
        this.f3795ad = new ad(this.qw.getLooper());
    }
}
