package com.baidu.android.imsdk.chatmessage.request.params;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONObject;

public class RecallMsgParam extends BaseRequestParam {
    private static final String TAG = "RecallMsgParam";
    public long bduid;
    public long businessType;
    public long category;
    private long clickRecallTime;
    public long contacterBduid;
    public long contacterPauid;
    public long contacterUk;
    public long contacterUserType;
    public long groupId;
    public int groupType;
    public long msgId;
    private String operatorBduid;
    private int originMsgType;
    public long pauid;
    public long recallMode;
    private BIMValueCallBack<JSONObject> recallMsgRequestCallback;
    private ChatMsg recalledMsg;
    private long recalledMsgid;
    public long sendMsgBduid;
    public long userType;

    private RecallMsgParam() {
    }

    public static RecallMsgParam newInstance(Context context, int category2, long businessType2, long contacterUk2, long contacterBduid2, long contacterPaUid, long groupId2, int groupType2, long msgId2, long recallMode2, long sendMsgBduid2, long paId, ChatMsg msg, BIMValueCallBack<JSONObject> recallMsgCallback) {
        long j2 = contacterUk2;
        long j3 = contacterPaUid;
        if (context == null) {
            int i2 = category2;
            long j4 = businessType2;
            long j5 = contacterBduid2;
            long j6 = groupId2;
            int i3 = groupType2;
            long j7 = paId;
            ChatMsg chatMsg = msg;
            BIMValueCallBack<JSONObject> bIMValueCallBack = recallMsgCallback;
        } else if (j2 == 0 && j3 == 0) {
            int i4 = category2;
            long j8 = businessType2;
            long j9 = contacterBduid2;
            long j10 = groupId2;
            int i5 = groupType2;
            long j11 = paId;
            ChatMsg chatMsg2 = msg;
            BIMValueCallBack<JSONObject> bIMValueCallBack2 = recallMsgCallback;
        } else {
            boolean isContacterMedia = j3 > 0;
            RecallMsgParam recallMsgParam = new RecallMsgParam();
            recallMsgParam.category = (long) category2;
            recallMsgParam.userType = (long) RequestParamManager.getUserType(AccountManager.getMediaRole(context));
            recallMsgParam.bduid = Long.parseLong(AccountManager.getUid(context));
            recallMsgParam.pauid = paId;
            recallMsgParam.businessType = businessType2;
            recallMsgParam.contacterUk = j2;
            recallMsgParam.contacterUserType = (long) RequestParamManager.getUserType(isContacterMedia);
            recallMsgParam.contacterBduid = contacterBduid2;
            recallMsgParam.contacterPauid = j3;
            recallMsgParam.groupId = groupId2;
            recallMsgParam.groupType = groupType2;
            recallMsgParam.msgId = msgId2;
            recallMsgParam.recallMode = recallMode2;
            recallMsgParam.sendMsgBduid = sendMsgBduid2;
            recallMsgParam.setRequestCallBack(recallMsgCallback);
            recallMsgParam.recalledMsg = msg;
            return recallMsgParam;
        }
        LogUtils.d(TAG, "get RecallMsgParam failed, param invalid");
        return null;
    }

    public BIMValueCallBack<JSONObject> getRequestCallBack() {
        return this.recallMsgRequestCallback;
    }

    public void setRequestCallBack(BIMValueCallBack<JSONObject> fetchMsgRequestCallback) {
        this.recallMsgRequestCallback = fetchMsgRequestCallback;
    }

    public void onRequestResult(int responseCode, String responseContent, JSONObject response) {
        if (getRequestCallBack() != null) {
            getRequestCallBack().onResult(responseCode, responseContent, response);
        }
    }

    public long getContacterUk() {
        return this.contacterUk;
    }

    public long getUserType() {
        return this.userType;
    }

    public long getBduid() {
        return this.bduid;
    }

    public long getPauid() {
        return this.pauid;
    }

    public long getBusinessType() {
        return this.businessType;
    }

    public long getCategory() {
        return this.category;
    }

    public long getContacterUserType() {
        return this.contacterUserType;
    }

    public long getContacterBduid() {
        return this.contacterBduid;
    }

    public long getContacterPauid() {
        return this.contacterPauid;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public long getRecallMode() {
        return this.recallMode;
    }

    public long getSendMsgBduid() {
        return this.sendMsgBduid;
    }

    public ChatMsg getRecalledMsg() {
        return this.recalledMsg;
    }

    public int getOriginMsgType() {
        return this.originMsgType;
    }

    public long getClickRecallTime() {
        return this.clickRecallTime;
    }

    public String getOperatorBduid() {
        return this.operatorBduid;
    }

    public long getRecalledMsgid() {
        return this.recalledMsgid;
    }

    public void setOriginMsgType(int originMsgType2) {
        this.originMsgType = originMsgType2;
    }

    public void setClickRecallTime(long clickRecallTime2) {
        this.clickRecallTime = clickRecallTime2;
    }

    public void setOperatorBduid(String operatorBduid2) {
        this.operatorBduid = operatorBduid2;
    }

    public void setRecalledMsgid(long recalledMsgid2) {
        this.recalledMsgid = recalledMsgid2;
    }
}
