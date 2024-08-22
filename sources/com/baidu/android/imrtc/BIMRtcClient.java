package com.baidu.android.imrtc;

import android.content.Context;
import com.baidu.android.imrtc.msg.BIMRtcListener;
import com.baidu.android.imrtc.request.BIMRtcAnswerAbilityListener;
import com.baidu.android.imrtc.request.BIMRtcTokenListener;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCancelRtcInfo;
import com.baidu.android.imrtc.send.BIMClientReportInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.send.BIMKickRequestRtcInfo;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imrtc.utils.RtcUtility;

public class BIMRtcClient {
    public static void createRoom(Context context, String source, BIMRtcTokenListener listener) {
        BIMRtcManager.getInstance(context).createRoom(source, listener);
    }

    public static void createRoom(Context context, String source, String resourceId, BIMRtcTokenListener listener) {
        BIMRtcManager.getInstance(context).createRoom(source, resourceId, listener);
    }

    public static void createRoom(Context context, String source, String resourceId, int rtcType, BIMRtcTokenListener listener) {
        BIMRtcManager.getInstance(context).createRoom(source, resourceId, rtcType, listener);
    }

    public static void generateToken(Context context, String source, String roomId, long userId, BIMRtcTokenListener listener) {
        BIMRtcManager.getInstance(context).generateToken(source, roomId, userId, listener);
    }

    public static void checkAnswerAbility(Context context, String source, String roomId, BIMRtcAnswerAbilityListener listener) {
        BIMRtcManager.getInstance(context).checkAnswerAbility(source, roomId, listener);
    }

    public static void join(Context context, String roomId, IStatusListener listener) {
        BIMRtcManager.getInstance(context).join(roomId, listener);
    }

    public static void cancelCall(Context context, BIMCancelRtcInfo info, IStatusListener listener) {
        BIMRtcManager.getInstance(context).cancelCall(info, listener);
    }

    public static void invite(Context context, BIMInviteRtcInfo info, IStatusListener listener) {
        BIMRtcManager.getInstance(context).invite(info, listener);
    }

    public static void answer(Context context, BIMAnswerRtcInfo info, IStatusListener listener) {
        BIMRtcManager.getInstance(context).answer(info, listener);
    }

    public static void hangout(Context context, String roomId, IStatusListener listener) {
        BIMRtcManager.getInstance(context).hangout(roomId, listener);
    }

    public static void hangout(Context context, BIMRtcInfo info, IStatusListener listener) {
        BIMRtcManager.getInstance(context).hangout(info, listener);
    }

    public static void closeRoom(Context context, BIMCloseRoomRtcInfo info, IStatusListener listener) {
        BIMRtcManager.getInstance(context).closeRoom(info, listener);
    }

    public static void kickoff(Context context, BIMKickRequestRtcInfo info, IStatusListener listener) {
        BIMRtcManager.getInstance(context).kickoff(info, listener);
    }

    public static void registerRtcListener(Context context, BIMRtcListener listener) {
        BIMRtcManager.getInstance(context).registerRtcListener(listener);
    }

    public static void unRegisterRtcListener(Context context, BIMRtcListener listener) {
        BIMRtcManager.getInstance(context).unRegisterRtcListener(listener);
    }

    public static void setRtcDebugAndLogEnable(Context context, boolean isDebug, boolean logEnable) {
        BIMRtcManager.getInstance(context).setRtcDebugEnv(context, isDebug);
        RtcConstants.logDebug = logEnable;
    }

    public static String report(Context context) {
        return BIMRtcManager.getInstance(context).report();
    }

    public static void clientReport(Context context, BIMClientReportInfo info, IStatusListener listener) {
        BIMRtcManager.getInstance(context).clientReport(info, listener);
    }

    public static void setAppStatus(boolean isForeground) {
        RtcUtility.setAppState(isForeground);
    }
}
