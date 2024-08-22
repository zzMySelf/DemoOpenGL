package com.baidu.android.imsdk.shield;

import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.android.imsdk.shield.model.GetSubscriptionResult;

public class IMServiceNotifyMenuMergeListener implements IGetSubscriptionListener, IGetShieldAndTopListener {
    private int mCategory;
    private IGetServiceNotifyMenuListener mListener;
    private GetShieldAndTopResult mShieldResult = null;
    private GetSubscriptionResult mSubscriptionResult = null;

    public IMServiceNotifyMenuMergeListener(int category, IGetServiceNotifyMenuListener listener) {
        this.mListener = listener;
        this.mCategory = category;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onResult(com.baidu.android.imsdk.shield.model.GetShieldAndTopResult r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.baidu.android.imsdk.shield.IGetServiceNotifyMenuListener r0 = r2.mListener     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r2.mShieldResult = r3     // Catch:{ all -> 0x001b }
            int r1 = r2.mCategory     // Catch:{ all -> 0x001b }
            if (r1 != 0) goto L_0x0012
            r1 = 0
            r0.onResult(r3, r1)     // Catch:{ all -> 0x001b }
            goto L_0x0019
        L_0x0012:
            com.baidu.android.imsdk.shield.model.GetSubscriptionResult r1 = r2.mSubscriptionResult     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x0019
            r0.onResult(r3, r1)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r2)
            return
        L_0x001b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.shield.IMServiceNotifyMenuMergeListener.onResult(com.baidu.android.imsdk.shield.model.GetShieldAndTopResult):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onResult(com.baidu.android.imsdk.shield.model.GetSubscriptionResult r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.baidu.android.imsdk.shield.IGetServiceNotifyMenuListener r0 = r3.mListener     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            r3.mSubscriptionResult = r4     // Catch:{ all -> 0x001c }
            int r1 = r3.mCategory     // Catch:{ all -> 0x001c }
            r2 = 1
            if (r1 != r2) goto L_0x0013
            r1 = 0
            r0.onResult(r1, r4)     // Catch:{ all -> 0x001c }
            goto L_0x001a
        L_0x0013:
            com.baidu.android.imsdk.shield.model.GetShieldAndTopResult r1 = r3.mShieldResult     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x001a
            r0.onResult(r1, r4)     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r3)
            return
        L_0x001c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.imsdk.shield.IMServiceNotifyMenuMergeListener.onResult(com.baidu.android.imsdk.shield.model.GetSubscriptionResult):void");
    }
}
