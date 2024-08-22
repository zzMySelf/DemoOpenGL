package com.baidu.searchbox.net.update.request;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.ConnectManager;
import com.baidu.searchbox.http.NetworkQuality;
import com.baidu.searchbox.preload.business.inner.PreloadConstantsKt;
import java.util.ArrayList;
import java.util.Iterator;

public class UpdateRequestTask {
    public long mDelayRetryDuration = 10;
    private volatile long mFirstRequestTime;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public volatile boolean mHasDelayReq;
    public boolean mIsBackgroundToForeground;
    public volatile boolean mIsCancel;
    public boolean mIsFirstNoNetConn;
    public volatile boolean mIsReqSuccess;
    /* access modifiers changed from: private */
    public BroadcastReceiver mNetworkBroadcastReceiver;
    /* access modifiers changed from: private */
    public NetworkQuality.NetworkQualityListener mNetworkQualityListener;
    public int mReqTimeout = 60;
    public int mRetryCount = 2;
    public int mRetryNum = -1;
    public ArrayList<UpdateRequest> mUpdateRequestList = new ArrayList<>();

    public UpdateRequestTask(boolean isBackgroundToForeground) {
        this.mIsBackgroundToForeground = isBackgroundToForeground;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        com.baidu.searchbox.net.update.statistics.UpdateSpendTimeUBC.INSTANCE.ubcEvent(r7.mIsBackgroundToForeground, "queue", r7.mRetryNum, r8);
        r1 = new com.baidu.searchbox.net.update.request.UpdateRequest(r16, r7.mReqTimeout, r7.mRetryNum, r17, r7.mIsBackgroundToForeground);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        monitor-enter(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r7.mUpdateRequestList.add(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        monitor-exit(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0045, code lost:
        if (r8 != false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        if (r7.mDelayRetryDuration <= 0) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r7.mHandler.postDelayed(new com.baidu.searchbox.net.update.request.UpdateRequestTask.AnonymousClass1(r7), r7.mDelayRetryDuration * 1000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        if (r8 == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        r7.mHasDelayReq = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r1.mRetryNum != 0) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        r7.mFirstRequestTime = android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        r2 = android.os.SystemClock.elapsedRealtime() - r7.mFirstRequestTime;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        r1.run();
        stopDelayRetryRequestTimer();
        r0 = r7.mReqTimeout + "-" + r7.mRetryCount + "-" + r7.mDelayRetryDuration;
        r10 = com.baidu.searchbox.net.update.request.UpdateRequestUBC.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a8, code lost:
        if (r1.mRetryNum <= 0) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00aa, code lost:
        r4 = r7.mUpdateRequestList.get(r1.mRetryNum - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b6, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b7, code lost:
        r10.updateRequestStabilityStat(r1, r4, r0, java.lang.String.valueOf(r2), r7.mIsFirstNoNetConn);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c7, code lost:
        if (r7.mRetryNum >= r7.mRetryCount) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cb, code lost:
        if (r1.mResult == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d5, code lost:
        if (android.text.TextUtils.isEmpty(r1.mResult.errormsg) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e3, code lost:
        if (r1.mResult.errormsg.contains("no network connected") == false) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e7, code lost:
        if (r1.mRetryNum != 0) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e9, code lost:
        r7.mIsFirstNoNetConn = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f3, code lost:
        if (com.baidu.searchbox.http.ConnectManager.isNetworkConnected(com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()) == false) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f5, code lost:
        asyncRequest(false, "updateNoNetRetry");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fc, code lost:
        addUnKnowNetworkStatusChangedListener();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010e, code lost:
        if (r1.mResult.errormsg.contains(java.net.SocketTimeoutException.class.getName()) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0116, code lost:
        if (com.baidu.searchbox.http.NetworkQuality.getWeakNetCheckConfig().enableSdt == false) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0118, code lost:
        addNetworkQualityChangedListener(r1.mReqNetworkQuality);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011e, code lost:
        asyncRequest(false, "updateTimeoutRetry");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void request(boolean r17) {
        /*
            r16 = this;
            r7 = r16
            r8 = r17
            if (r8 == 0) goto L_0x000a
            boolean r0 = r7.mHasDelayReq
            if (r0 != 0) goto L_0x012b
        L_0x000a:
            boolean r0 = r7.mIsCancel
            if (r0 != 0) goto L_0x012b
            boolean r0 = r7.mIsReqSuccess
            if (r0 == 0) goto L_0x0014
            goto L_0x012b
        L_0x0014:
            monitor-enter(r16)
            int r0 = r7.mRetryNum     // Catch:{ all -> 0x0128 }
            int r1 = r7.mRetryCount     // Catch:{ all -> 0x0128 }
            if (r0 < r1) goto L_0x001d
            monitor-exit(r16)     // Catch:{ all -> 0x0128 }
            return
        L_0x001d:
            r9 = 1
            int r0 = r0 + r9
            r7.mRetryNum = r0     // Catch:{ all -> 0x0128 }
            monitor-exit(r16)     // Catch:{ all -> 0x0128 }
            com.baidu.searchbox.net.update.statistics.UpdateSpendTimeUBC r0 = com.baidu.searchbox.net.update.statistics.UpdateSpendTimeUBC.INSTANCE
            boolean r1 = r7.mIsBackgroundToForeground
            java.lang.String r2 = "queue"
            int r3 = r7.mRetryNum
            r0.ubcEvent((boolean) r1, (java.lang.String) r2, (int) r3, (boolean) r8)
            com.baidu.searchbox.net.update.request.UpdateRequest r0 = new com.baidu.searchbox.net.update.request.UpdateRequest
            int r3 = r7.mReqTimeout
            int r4 = r7.mRetryNum
            boolean r6 = r7.mIsBackgroundToForeground
            r1 = r0
            r2 = r16
            r5 = r17
            r1.<init>(r2, r3, r4, r5, r6)
            monitor-enter(r16)
            java.util.ArrayList<com.baidu.searchbox.net.update.request.UpdateRequest> r0 = r7.mUpdateRequestList     // Catch:{ all -> 0x0125 }
            r0.add(r1)     // Catch:{ all -> 0x0125 }
            monitor-exit(r16)     // Catch:{ all -> 0x0125 }
            if (r8 != 0) goto L_0x005e
            long r2 = r7.mDelayRetryDuration
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x005e
            android.os.Handler r0 = r7.mHandler
            com.baidu.searchbox.net.update.request.UpdateRequestTask$1 r2 = new com.baidu.searchbox.net.update.request.UpdateRequestTask$1
            r2.<init>()
            long r3 = r7.mDelayRetryDuration
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
            r0.postDelayed(r2, r3)
        L_0x005e:
            if (r8 == 0) goto L_0x0062
            r7.mHasDelayReq = r9
        L_0x0062:
            r2 = 0
            int r0 = r1.mRetryNum
            if (r0 != 0) goto L_0x006f
            long r4 = android.os.SystemClock.elapsedRealtime()
            r7.mFirstRequestTime = r4
            goto L_0x0077
        L_0x006f:
            long r4 = android.os.SystemClock.elapsedRealtime()
            long r10 = r7.mFirstRequestTime
            long r2 = r4 - r10
        L_0x0077:
            r1.run()
            r16.stopDelayRetryRequestTimer()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r4 = r7.mReqTimeout
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r4 = "-"
            java.lang.StringBuilder r0 = r0.append(r4)
            int r4 = r7.mRetryCount
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r4 = "-"
            java.lang.StringBuilder r0 = r0.append(r4)
            long r4 = r7.mDelayRetryDuration
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.baidu.searchbox.net.update.request.UpdateRequestUBC r10 = com.baidu.searchbox.net.update.request.UpdateRequestUBC.INSTANCE
            int r4 = r1.mRetryNum
            if (r4 <= 0) goto L_0x00b6
            java.util.ArrayList<com.baidu.searchbox.net.update.request.UpdateRequest> r4 = r7.mUpdateRequestList
            int r5 = r1.mRetryNum
            int r5 = r5 - r9
            java.lang.Object r4 = r4.get(r5)
            com.baidu.searchbox.net.update.request.UpdateRequest r4 = (com.baidu.searchbox.net.update.request.UpdateRequest) r4
            goto L_0x00b7
        L_0x00b6:
            r4 = 0
        L_0x00b7:
            r12 = r4
            java.lang.String r14 = java.lang.String.valueOf(r2)
            boolean r15 = r7.mIsFirstNoNetConn
            r11 = r1
            r13 = r0
            r10.updateRequestStabilityStat(r11, r12, r13, r14, r15)
            int r4 = r7.mRetryNum
            int r5 = r7.mRetryCount
            if (r4 >= r5) goto L_0x0124
            com.baidu.searchbox.net.update.request.UpdateRequest$Result r4 = r1.mResult
            if (r4 == 0) goto L_0x0124
            com.baidu.searchbox.net.update.request.UpdateRequest$Result r4 = r1.mResult
            java.lang.String r4 = r4.errormsg
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0124
            com.baidu.searchbox.net.update.request.UpdateRequest$Result r4 = r1.mResult
            java.lang.String r4 = r4.errormsg
            java.lang.String r5 = "no network connected"
            boolean r4 = r4.contains(r5)
            r5 = 0
            if (r4 == 0) goto L_0x0100
            int r4 = r1.mRetryNum
            if (r4 != 0) goto L_0x00eb
            r7.mIsFirstNoNetConn = r9
        L_0x00eb:
            android.content.Context r4 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            boolean r4 = com.baidu.searchbox.http.ConnectManager.isNetworkConnected(r4)
            if (r4 == 0) goto L_0x00fc
            java.lang.String r4 = "updateNoNetRetry"
            r7.asyncRequest(r5, r4)
            goto L_0x0124
        L_0x00fc:
            r16.addUnKnowNetworkStatusChangedListener()
            goto L_0x0124
        L_0x0100:
            com.baidu.searchbox.net.update.request.UpdateRequest$Result r4 = r1.mResult
            java.lang.String r4 = r4.errormsg
            java.lang.Class<java.net.SocketTimeoutException> r6 = java.net.SocketTimeoutException.class
            java.lang.String r6 = r6.getName()
            boolean r4 = r4.contains(r6)
            if (r4 == 0) goto L_0x0124
            com.baidu.searchbox.http.NetworkQuality$WeakNetCheckConfig r4 = com.baidu.searchbox.http.NetworkQuality.getWeakNetCheckConfig()
            boolean r4 = r4.enableSdt
            if (r4 == 0) goto L_0x011e
            int r4 = r1.mReqNetworkQuality
            r7.addNetworkQualityChangedListener(r4)
            goto L_0x0124
        L_0x011e:
            java.lang.String r4 = "updateTimeoutRetry"
            r7.asyncRequest(r5, r4)
        L_0x0124:
            return
        L_0x0125:
            r0 = move-exception
            monitor-exit(r16)     // Catch:{ all -> 0x0125 }
            throw r0
        L_0x0128:
            r0 = move-exception
            monitor-exit(r16)     // Catch:{ all -> 0x0128 }
            throw r0
        L_0x012b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.net.update.request.UpdateRequestTask.request(boolean):void");
    }

    private void addUnKnowNetworkStatusChangedListener() {
        if (this.mNetworkBroadcastReceiver == null) {
            IntentFilter filter = new IntentFilter();
            filter.addAction(PreloadConstantsKt.CONNECTIVITY_ACTION);
            this.mNetworkBroadcastReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (PreloadConstantsKt.CONNECTIVITY_ACTION.equals(intent.getAction()) && ConnectManager.isNetworkConnected(AppRuntime.getAppContext())) {
                        UpdateRequestTask.this.asyncRequest(false, "updateNoNetRetry");
                        try {
                            AppRuntime.getAppContext().unregisterReceiver(UpdateRequestTask.this.mNetworkBroadcastReceiver);
                        } catch (Exception e2) {
                            if (AppConfig.isDebug()) {
                                e2.printStackTrace();
                            }
                        }
                        BroadcastReceiver unused = UpdateRequestTask.this.mNetworkBroadcastReceiver = null;
                    }
                }
            };
            AppRuntime.getAppContext().registerReceiver(this.mNetworkBroadcastReceiver, filter);
        }
    }

    private void addNetworkQualityChangedListener(final int reqNetworkQuality) {
        if (NetworkQuality.getNetworkQuality() > reqNetworkQuality) {
            request(false);
        } else if (this.mNetworkQualityListener == null) {
            AnonymousClass3 r1 = new NetworkQuality.NetworkQualityListener(ExecutorUtilsExt.getImmediateExecutor("NetworkQualityChange")) {
                public void onNetworkQualityChanged(int i2) {
                    if (i2 > reqNetworkQuality) {
                        UpdateRequestTask.this.asyncRequest(false, "updateTimeoutRetry");
                        NetworkQuality.removeNetworkQualityListener(UpdateRequestTask.this.mNetworkQualityListener);
                        NetworkQuality.NetworkQualityListener unused = UpdateRequestTask.this.mNetworkQualityListener = null;
                    }
                }
            };
            this.mNetworkQualityListener = r1;
            NetworkQuality.addNetworkQualityListener(r1);
        }
    }

    /* access modifiers changed from: private */
    public void asyncRequest(final boolean isDelayRetry, final String retryName) {
        new Thread() {
            public void run() {
                setName(retryName);
                UpdateRequestTask.this.request(isDelayRetry);
            }
        }.start();
    }

    public void stopDelayRetryRequestTimer() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }

    public void cancel() {
        this.mIsCancel = true;
        stopDelayRetryRequestTimer();
        NetworkQuality.NetworkQualityListener networkQualityListener = this.mNetworkQualityListener;
        if (networkQualityListener != null) {
            NetworkQuality.removeNetworkQualityListener(networkQualityListener);
        }
        if (this.mNetworkBroadcastReceiver != null) {
            try {
                AppRuntime.getAppContext().unregisterReceiver(this.mNetworkBroadcastReceiver);
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
            this.mNetworkBroadcastReceiver = null;
        }
        synchronized (this) {
            Iterator<UpdateRequest> it = this.mUpdateRequestList.iterator();
            while (it.hasNext()) {
                UpdateRequest updateRequest = it.next();
                if (updateRequest.mRetryNum != 0) {
                    updateRequest.cancel();
                }
            }
        }
    }
}
