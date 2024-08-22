package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.request.params.SendMsgParam;
import com.baidu.android.imsdk.media.SessionManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import org.json.JSONException;
import org.json.JSONObject;

public class IMReportMsg extends Message {
    private static final String TAG = "IMReportMsg";
    public static final int USER_ACTION_ENTER_CENTER_CHAT_PAGE = 3;
    public static final int USER_ACTION_ENTER_CENTER_MSG = 2;
    public static final int USER_ACTION_FIRST_ENTER_AI_PAGE = 4;
    public static final int USER_ACTION_FIRST_SEND_MSG = 1;
    private Context mContext;
    private final SendMsgParam mSendMsgParam;
    private int userAction = 1;

    public IMReportMsg(Context context, SendMsgParam sendMsgParam, int userAction2) {
        this.mContext = context;
        this.mSendMsgParam = sendMsgParam;
        this.userAction = userAction2;
        initCommonParameter(context);
        setType(247);
    }

    public static IMReportMsg newInstance(Context context, Intent intent) {
        if (intent.hasExtra("param")) {
            return new IMReportMsg(context, (SendMsgParam) intent.getSerializableExtra("param"), intent.getIntExtra("user_action", 1));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void buildBody() {
        JSONObject objMsg = new JSONObject();
        try {
            objMsg.put("method", 247);
            objMsg.put("appid", this.mAppid);
            int i2 = 0;
            objMsg.put("user_type", AccountManagerImpl.getInstance(this.mContext).getMediaRole() ? 1 : 0);
            objMsg.put("uk", this.mUk);
            objMsg.put("pa_uid", SessionManager.getInstance(this.mContext).getMeidaPaid());
            objMsg.put("bd_uid", AccountManagerImpl.getInstance(this.mContext).getBduid());
            int bussType = 0;
            SendMsgParam sendMsgParam = this.mSendMsgParam;
            if (sendMsgParam != null) {
                objMsg.put("contacter_uk", sendMsgParam.getContacterUk());
                objMsg.put("contacter_pa_uid", this.mSendMsgParam.getContacterPaUid());
                objMsg.put("contacter_bd_uid", this.mSendMsgParam.getContacterBduid());
                if (this.mSendMsgParam.getChatMsg() != null) {
                    i2 = this.mSendMsgParam.getChatMsg().getBusinessType();
                }
                bussType = i2;
                int i3 = 2;
                if (bussType != 2) {
                    i3 = this.mSendMsgParam.getContacterUserType();
                }
                objMsg.put("contacter_user_type", i3);
                if (bussType == 1 && AccountManager.getMediaRole(this.mContext)) {
                    bussType = 3;
                }
            }
            objMsg.put("business_type", bussType);
            objMsg.put("user_action", this.userAction);
            this.mBody = objMsg.toString();
            LogUtils.d(TAG, "buildBody " + this.mBody);
        } catch (JSONException e2) {
            LogUtils.e(TAG, "Exception ", e2);
        }
    }

    public void handleMessageResult(Context context, JSONObject obj, int errorCode, String errMsg) {
        SendMsgParam sendMsgParam;
        LogUtils.d(TAG, "handleMessageResult errcode = " + errorCode + ", obj :" + obj);
        if (errorCode == 0 && (sendMsgParam = this.mSendMsgParam) != null && this.userAction == 1) {
            Utility.setFirstSendMsg(context, sendMsgParam.getToUser(), 1);
        }
        super.handleMessageResult(context, obj, errorCode, errMsg);
    }
}
