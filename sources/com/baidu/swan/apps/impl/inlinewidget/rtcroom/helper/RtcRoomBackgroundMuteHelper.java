package com.baidu.swan.apps.impl.inlinewidget.rtcroom.helper;

import android.util.LongSparseArray;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.inlinewidget.rtcroom.SwanInlineRtcRoomWidget;

public class RtcRoomBackgroundMuteHelper {
    private static final String TAG = "RtcBackgroundMuteHelper";
    private volatile LongSparseArray<Boolean> mAudioStatus = new LongSparseArray<>(20);
    private boolean mBackgroundMute;
    private SwanInlineRtcRoomWidget mInlineWidget;
    private boolean mNeedResume = false;

    public RtcRoomBackgroundMuteHelper(SwanInlineRtcRoomWidget inlineWidget) {
        this.mInlineWidget = inlineWidget;
    }

    public void setBackgroundMute(boolean backgroundMute) {
        this.mBackgroundMute = backgroundMute;
    }

    public synchronized void setRemoteAudioPlayState(long userId, boolean status, boolean isBackground) {
        SwanAppLog.i(TAG, "setRemoteAudioPlayState userId=" + userId + ";status=" + status + ";isBackground=" + isBackground);
        this.mAudioStatus.put(userId, Boolean.valueOf(status));
        if (!this.mBackgroundMute || !status || !isBackground) {
            this.mInlineWidget.setAudioStatus(userId, status);
        } else {
            this.mNeedResume = true;
        }
    }

    public void onPageBackground() {
        if (this.mBackgroundMute) {
            this.mNeedResume = true;
            pauseAudio();
        }
    }

    public void onPageForeground() {
        if (this.mNeedResume) {
            this.mNeedResume = false;
            resumeAudio();
        }
    }

    public synchronized void onUserJoinRoom(long userId, boolean isBackground) {
        SwanAppLog.i(TAG, "onUserJoinRoom userId=" + userId + ";isBackground=" + isBackground);
        if (this.mBackgroundMute && this.mAudioStatus.get(userId, true).booleanValue() && isBackground) {
            this.mNeedResume = true;
            this.mInlineWidget.setAudioStatus(userId, false);
        }
    }

    public synchronized void resetStatus() {
        SwanAppLog.i(TAG, "resetStatus");
        this.mAudioStatus.clear();
        this.mNeedResume = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void pauseAudio() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "RtcBackgroundMuteHelper"
            java.lang.String r1 = "pauseAudio"
            com.baidu.swan.apps.console.SwanAppLog.i(r0, r1)     // Catch:{ all -> 0x0035 }
            com.baidu.swan.apps.impl.inlinewidget.rtcroom.SwanInlineRtcRoomWidget r0 = r7.mInlineWidget     // Catch:{ all -> 0x0035 }
            java.util.ArrayList r0 = r0.getRemoteUserList()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0033
            int r1 = r0.size()     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x0018
            goto L_0x0033
        L_0x0018:
            java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x0035 }
        L_0x001c:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0031
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0035 }
            com.baidu.swan.apps.inlinewidget.rtcroom.model.RtcRoomUserInfo r2 = (com.baidu.swan.apps.inlinewidget.rtcroom.model.RtcRoomUserInfo) r2     // Catch:{ all -> 0x0035 }
            com.baidu.swan.apps.impl.inlinewidget.rtcroom.SwanInlineRtcRoomWidget r3 = r7.mInlineWidget     // Catch:{ all -> 0x0035 }
            long r4 = r2.userId     // Catch:{ all -> 0x0035 }
            r6 = 0
            r3.setAudioStatus(r4, r6)     // Catch:{ all -> 0x0035 }
            goto L_0x001c
        L_0x0031:
            monitor-exit(r7)
            return
        L_0x0033:
            monitor-exit(r7)
            return
        L_0x0035:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.inlinewidget.rtcroom.helper.RtcRoomBackgroundMuteHelper.pauseAudio():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void resumeAudio() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = "RtcBackgroundMuteHelper"
            java.lang.String r1 = "resumeAudio"
            com.baidu.swan.apps.console.SwanAppLog.i(r0, r1)     // Catch:{ all -> 0x0049 }
            com.baidu.swan.apps.impl.inlinewidget.rtcroom.SwanInlineRtcRoomWidget r0 = r8.mInlineWidget     // Catch:{ all -> 0x0049 }
            java.util.ArrayList r0 = r0.getRemoteUserList()     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0047
            int r1 = r0.size()     // Catch:{ all -> 0x0049 }
            if (r1 != 0) goto L_0x0018
            goto L_0x0047
        L_0x0018:
            java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x0049 }
        L_0x001c:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0045
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0049 }
            com.baidu.swan.apps.inlinewidget.rtcroom.model.RtcRoomUserInfo r2 = (com.baidu.swan.apps.inlinewidget.rtcroom.model.RtcRoomUserInfo) r2     // Catch:{ all -> 0x0049 }
            android.util.LongSparseArray<java.lang.Boolean> r3 = r8.mAudioStatus     // Catch:{ all -> 0x0049 }
            long r4 = r2.userId     // Catch:{ all -> 0x0049 }
            r6 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0049 }
            java.lang.Object r3 = r3.get(r4, r7)     // Catch:{ all -> 0x0049 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0049 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0044
            com.baidu.swan.apps.impl.inlinewidget.rtcroom.SwanInlineRtcRoomWidget r3 = r8.mInlineWidget     // Catch:{ all -> 0x0049 }
            long r4 = r2.userId     // Catch:{ all -> 0x0049 }
            r3.setAudioStatus(r4, r6)     // Catch:{ all -> 0x0049 }
        L_0x0044:
            goto L_0x001c
        L_0x0045:
            monitor-exit(r8)
            return
        L_0x0047:
            monitor-exit(r8)
            return
        L_0x0049:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.impl.inlinewidget.rtcroom.helper.RtcRoomBackgroundMuteHelper.resumeAudio():void");
    }
}
