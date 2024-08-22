package com.baidu.android.imrtc.msg;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imrtc.BIMRtcInfo;
import com.baidu.android.imrtc.BIMRtcManager;
import com.baidu.android.imrtc.send.BIMAnswerRtcInfo;
import com.baidu.android.imrtc.send.BIMCloseRoomRtcInfo;
import com.baidu.android.imrtc.send.BIMFetchSignalRtcInfo;
import com.baidu.android.imrtc.send.BIMFetchStateRtcInfo;
import com.baidu.android.imrtc.send.BIMInviteRtcInfo;
import com.baidu.android.imrtc.upload.BIMRtcTrack;
import com.baidu.android.imrtc.utils.IMJni;
import com.baidu.android.imrtc.utils.LogUtils;
import com.baidu.android.imrtc.utils.RtcConstants;
import com.baidu.android.imrtc.utils.RtcUtility;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.poly.statistics.ActionDescription;
import org.json.JSONException;
import org.json.JSONObject;

public class BIMRtcSendMsg extends Message {
    private static final String TAG = "IMRtcSendMsg";
    private int mAction;
    private Context mContext;
    private long mImUk;
    private String mRoomId;
    private long mRtcAppID;
    private String mRtcInfo;
    private int mSdkVersion;

    public BIMRtcSendMsg(Context context, int action, String roomId, String rtcInfo) {
        this.mContext = context;
        this.mRtcInfo = rtcInfo;
        this.mAction = action;
        this.mRoomId = roomId;
    }

    public BIMRtcSendMsg(Context context, int action, String roomId, String rtcInfo, String listenerKey) {
        this(context, action, roomId, rtcInfo);
        initCommonParameter(context);
        this.mListenerKey = listenerKey;
        setNeedReplay(true);
        setType(230);
        this.mRtcAppID = this.mAppid;
        this.mSdkVersion = IMConfigInternal.getInstance().getSDKVersionValue(this.mContext);
        this.mImUk = Utility.getUK(this.mContext);
    }

    public static BIMRtcSendMsg newInstance(Context context, Intent intent) {
        String msgkey = intent.getStringExtra(Constants.EXTRA_LISTENER_ID);
        String rctInfo = intent.getStringExtra(RtcConstants.EXTRA_RTC_INFO);
        return new BIMRtcSendMsg(context, intent.getIntExtra(RtcConstants.EXTRA_RTC_ACTION_ID, -1), intent.getStringExtra(RtcConstants.EXTRA_RTC_ROOM_ID), rctInfo, msgkey);
    }

    /* access modifiers changed from: protected */
    public void buildBody() {
        this.mBody = generateBody().toString();
    }

    public void handleMessageResult(Context context, JSONObject obj, int errorCode, String strMsg) {
        JSONObject jSONObject = obj;
        int i2 = errorCode;
        LogUtils.w(TAG, "error :" + i2 + ", msg :" + strMsg + ", objStr :" + (jSONObject != null ? obj.toString() : "null"));
        if (this.mAction != 100) {
            new BIMRtcTrack.RequestBuilder(this.mContext).method(ActionDescription.PASS_CHECK_DIALOG_SHOW).requestId("" + this.mAction).requestTime(System.currentTimeMillis()).responseTime(System.nanoTime()).errorCode((long) i2).aliasId(501210).ext(trackRequestExt()).build();
        }
        String msg = null;
        if (i2 == 0 && jSONObject != null) {
            String msg2 = jSONObject.optString("err_msg");
            if (jSONObject.has(RtcConstants.EXTRA_RTC_INFO)) {
                try {
                    JSONObject rtcInfo = new JSONObject(jSONObject.optString(RtcConstants.EXTRA_RTC_INFO));
                    int i3 = this.mAction;
                    if (i3 == 100 || i3 == 92 || i3 == 84) {
                        long hr = rtcInfo.optLong("heartbeat_duration");
                        if (hr > 0) {
                            RtcConstants.RTC_HEART_BEAT_TIME = hr * 1000;
                        }
                        int retryTime = rtcInfo.optInt("heartbeat_retry_times");
                        if (retryTime > 0) {
                            RtcConstants.RTC_HEART_BEAT_RETRY_TIME = retryTime;
                        }
                        RtcConstants.RTC_HEART_BEAT_STATUS = rtcInfo.optInt("user_status", 0);
                        long uploadDuration = rtcInfo.optLong("ftrace_upload_duration");
                        if (uploadDuration > 0) {
                            RtcConstants.RTC_TRACK_UPLOAD_DURATION = 1000 * uploadDuration;
                        }
                    }
                    long sSeqId = rtcInfo.optLong("server_seqid");
                    if (sSeqId > 0) {
                        RtcConstants.IM_RTC_SERVER_SEQ_ID = sSeqId;
                    }
                } catch (Exception e2) {
                    LogUtils.e(TAG, "rtc_info Exception");
                }
            }
            msg = msg2;
        }
        super.handleMessageResult(context, obj, errorCode, strMsg);
        onResult(i2, msg);
    }

    public JSONObject generateBody() {
        JSONObject objMsg = new JSONObject();
        try {
            objMsg.put("method", 230);
            objMsg.put("appid", this.mRtcAppID);
            objMsg.put("msg_key", "");
            objMsg.put("app_version", RtcUtility.getAppVersionName(this.mContext));
            objMsg.put("sdk_version", this.mSdkVersion);
            objMsg.put("signal_sdk_version", RtcConstants.RTC_VERSION);
            objMsg.put("uk", this.mImUk);
            objMsg.put("third_userid", IMJni.transBDUID(Utility.readUid(this.mContext)));
            objMsg.put("action", this.mAction);
            objMsg.put(RtcConstants.EXTRA_RTC_ROOM_ID, this.mRoomId);
            objMsg.put(RtcConstants.EXTRA_RTC_INFO, this.mRtcInfo);
            LogUtils.i(TAG, "IMRtcSendMsg body :" + objMsg.toString());
        } catch (JSONException e2) {
            LogUtils.e(TAG, "IMRtcSendMsg Exception ", e2);
        }
        return objMsg;
    }

    public void onResult(int errorCode, String msg) {
        BIMRtcInfo info;
        switch (this.mAction) {
            case 80:
                info = new BIMInviteRtcInfo(this.mContext);
                break;
            case 84:
                info = new BIMAnswerRtcInfo();
                break;
            case 88:
                info = new BIMCloseRoomRtcInfo();
                break;
            case 90:
                info = new BIMFetchStateRtcInfo(msg);
                break;
            case 91:
                info = new BIMFetchSignalRtcInfo();
                break;
            default:
                info = new BIMRtcInfo();
                break;
        }
        BIMRtcManager instance = BIMRtcManager.getInstance(this.mContext);
        int i2 = this.mAction;
        instance.onRtcRequestResult(i2, info.toRtcInfo(i2, this.mRoomId, this.mRtcInfo), errorCode, msg, this.mListenerKey);
    }

    private String trackRequestExt() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("app_id", RtcUtility.getAppId(this.mContext));
            obj.put(RtcConstants.EXTRA_RTC_ROOM_ID, this.mRoomId);
            obj.put("my_uk", Utility.getUK(this.mContext));
            obj.put("other_uks", "");
            obj.put("cseq_id", RtcConstants.IM_RTC_SDK_SEQ_ID.get());
            obj.put("sseq_id", RtcConstants.IM_RTC_SERVER_SEQ_ID);
            obj.put("step", "c_send_response");
            obj.put("ext", "-1");
            return obj.toString();
        } catch (Exception e2) {
            return "c_send_response trackRequestExt Exception";
        }
    }
}
