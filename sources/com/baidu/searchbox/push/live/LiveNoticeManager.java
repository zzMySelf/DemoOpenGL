package com.baidu.searchbox.push.live;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.live.interfaces.callback.LiveStatusDataCallback;
import com.baidu.searchbox.live.nps.LiveNPSPluginManager;
import com.baidu.searchbox.provider.PushDebugConfigProvider;
import com.baidu.searchbox.push.PushMsgManager;
import com.baidu.searchbox.push.PushNotificationManager;
import com.baidu.searchbox.push.notification.NoticeInAppManager;

public class LiveNoticeManager {
    private static final String LIVE_STATUS_CLOSE_WITH_PLAYBACK = "3";
    private static final String LIVE_STATUS_NOT_STARTED = "-1";
    private static final String LIVE_STATUS_PLAYING_BACK_ING = "1";
    private static final String LIVE_STATUS_STARTED = "0";
    private static final String LIVE_STATUS_TURN_OFF_NO_PLAYBACK = "2";
    private static volatile LiveNoticeManager sInstance;

    public static LiveNoticeManager getInstance() {
        if (sInstance == null) {
            synchronized (LiveNoticeManager.class) {
                if (sInstance == null) {
                    sInstance = new LiveNoticeManager();
                }
            }
        }
        return sInstance;
    }

    public void asyncGetLiveRoomStatus(final Context context, final PushNotificationManager.NotificationInfo info) {
        if (MessageRuntime.GLOBAL_DEBUG && PushDebugConfigProvider.isNeedIgnoreLiveStateInDebug) {
            NoticeInAppManager.getInstance().showLiveNotificationInApp(info);
        } else if (info != null && info.getNotificationExtInfo() != null && !TextUtils.isEmpty(info.getNotificationExtInfo().getRoomId())) {
            LiveNPSPluginManager.getInstance().getLiveRoomStatus(info.getNotificationExtInfo().getRoomId(), new LiveStatusDataCallback<String>() {
                /* JADX WARNING: Can't fix incorrect switch cases order */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onResult(java.lang.String r3) {
                    /*
                        r2 = this;
                        int r0 = r3.hashCode()
                        switch(r0) {
                            case 48: goto L_0x0030;
                            case 49: goto L_0x0026;
                            case 50: goto L_0x001c;
                            case 51: goto L_0x0012;
                            case 1444: goto L_0x0008;
                            default: goto L_0x0007;
                        }
                    L_0x0007:
                        goto L_0x003a
                    L_0x0008:
                        java.lang.String r0 = "-1"
                        boolean r0 = r3.equals(r0)
                        if (r0 == 0) goto L_0x0007
                        r0 = 0
                        goto L_0x003b
                    L_0x0012:
                        java.lang.String r0 = "3"
                        boolean r0 = r3.equals(r0)
                        if (r0 == 0) goto L_0x0007
                        r0 = 3
                        goto L_0x003b
                    L_0x001c:
                        java.lang.String r0 = "2"
                        boolean r0 = r3.equals(r0)
                        if (r0 == 0) goto L_0x0007
                        r0 = 2
                        goto L_0x003b
                    L_0x0026:
                        java.lang.String r0 = "1"
                        boolean r0 = r3.equals(r0)
                        if (r0 == 0) goto L_0x0007
                        r0 = 1
                        goto L_0x003b
                    L_0x0030:
                        java.lang.String r0 = "0"
                        boolean r0 = r3.equals(r0)
                        if (r0 == 0) goto L_0x0007
                        r0 = 4
                        goto L_0x003b
                    L_0x003a:
                        r0 = -1
                    L_0x003b:
                        switch(r0) {
                            case 0: goto L_0x004a;
                            case 1: goto L_0x004a;
                            case 2: goto L_0x004a;
                            case 3: goto L_0x004a;
                            case 4: goto L_0x003f;
                            default: goto L_0x003e;
                        }
                    L_0x003e:
                        goto L_0x0052
                    L_0x003f:
                        com.baidu.searchbox.push.live.LiveNoticeManager$1$1 r0 = new com.baidu.searchbox.push.live.LiveNoticeManager$1$1
                        r0.<init>()
                        java.lang.String r1 = "do_live_in_app_push_action"
                        com.baidu.searchbox.elasticthread.ExecutorUtilsExt.postOnSerial(r0, r1)
                        goto L_0x0052
                    L_0x004a:
                        com.baidu.searchbox.push.PushNotificationManager$NotificationInfo r0 = r5
                        r1 = 32
                        com.baidu.searchbox.push.live.PushMsgAckManager.sendPushMsgAck((com.baidu.searchbox.push.PushNotificationManager.NotificationInfo) r0, (int) r1)
                    L_0x0052:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.push.live.LiveNoticeManager.AnonymousClass1.onResult(java.lang.String):void");
                }

                public void onError(Throwable throwable) {
                    PushMsgAckManager.sendPushMsgAck(info, 31);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void asyncGetIsEnterLive(Context context, final PushNotificationManager.NotificationInfo info, String roomID) {
        LiveNPSPluginManager.getInstance().isInHistory(roomID, new LiveStatusDataCallback<Boolean>() {
            public void onResult(Boolean hasEnter) {
                if (hasEnter.booleanValue()) {
                    PushMsgAckManager.sendPushMsgAck(info, 32);
                } else {
                    ExecutorUtilsExt.postOnSerial(new Runnable() {
                        public void run() {
                            LiveNoticeManager.this.doLiveInAppPushAction(info);
                        }
                    }, "get_is_enter_live");
                }
            }

            public void onError(Throwable throwable) {
                switch (info.getPriority()) {
                    case 2:
                        PushMsgAckManager.sendPushMsgAck(info, 31);
                        return;
                    case 3:
                        PushMsgAckManager.sendPushMsgAck(info, 33);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void doLiveInAppPushAction(PushNotificationManager.NotificationInfo info) {
        if (info != null) {
            if (PushMsgManager.getInstance(MessageRuntime.getAppContext()).checkDuplicateMsg(info.getMsgType(), info.getMsgId(), 604800000)) {
                PushMsgAckManager.sendPushMsgAck(info, 34);
                return;
            }
            try {
                NoticeInAppManager.getInstance().showLiveNotificationInApp(info);
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
