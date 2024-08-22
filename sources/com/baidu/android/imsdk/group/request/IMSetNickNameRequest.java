package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

public class IMSetNickNameRequest extends FansGroupBaseHttpRequest {
    /* access modifiers changed from: private */
    public static final String TAG = IMSetNickNameRequest.class.getSimpleName();
    private long mAppid;
    /* access modifiers changed from: private */
    public long mBuid;
    /* access modifiers changed from: private */
    public String mGroupId;
    private boolean mIsFansGroup;
    /* access modifiers changed from: private */
    public String mKey;
    /* access modifiers changed from: private */
    public String mNickName;

    class Mytask extends TaskManager.Task {
        public Mytask(String key, String json) {
            super(key, json);
        }

        public void run() {
            String resultMsg;
            int resultCode;
            try {
                JSONObject origin = new JSONObject(this.mJson);
                resultCode = origin.getInt("error_code");
                String tips = "";
                if (origin.has("tips")) {
                    tips = origin.optString("tips");
                    LogUtils.d(IMSetNickNameRequest.TAG, "tips:" + tips);
                }
                if (!TextUtils.isEmpty(tips)) {
                    resultMsg = tips;
                } else {
                    resultMsg = origin.optString("error_msg", "");
                    LogUtils.d(IMSetNickNameRequest.TAG, "resultMsg:" + resultMsg);
                }
                if (resultCode == 0) {
                    int ret = GroupInfoDAOImpl.updateMemberNickName(IMSetNickNameRequest.this.mContext, IMSetNickNameRequest.this.mGroupId, String.valueOf(IMSetNickNameRequest.this.mBuid), IMSetNickNameRequest.this.mNickName);
                    if (ret < 0) {
                        LogUtils.d(IMSetNickNameRequest.TAG, "updateMemberNickName error " + ret);
                        resultCode = ret;
                        resultMsg = "update local db error";
                    } else {
                        LogUtils.d(IMSetNickNameRequest.TAG, "updateMemberNickName successful " + ret);
                    }
                }
            } catch (JSONException e2) {
                LogUtils.e(LogUtils.TAG, "IMSetNickNameRequest JSONException", e2);
                resultCode = 1010;
                resultMsg = "";
            }
            IMListener listener = ListenerManager.getInstance().removeListener(IMSetNickNameRequest.this.mKey);
            if (listener instanceof BIMValueCallBack) {
                ((BIMValueCallBack) listener).onResult(resultCode, resultMsg, IMSetNickNameRequest.this.mGroupId);
            }
        }
    }

    public IMSetNickNameRequest(Context context, String key, long appid, boolean isFansGroup, String groupid, String nickname, long buid) {
        this.mContext = context;
        this.mIsFansGroup = isFansGroup;
        this.mAppid = appid;
        this.mKey = key;
        this.mBuid = buid;
        this.mGroupId = groupid;
        this.mNickName = nickname;
    }

    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        if (this.mIsFansGroup) {
            return getFansGroupRequestParam().getBytes();
        }
        return getNormalGroupRequestParam().getBytes();
    }

    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    public boolean shouldAbort() {
        return false;
    }

    public void onSuccess(int errorCode, byte[] resultContent) {
        String jsonString = new String(resultContent);
        LogUtils.d(TAG, "json is groupid " + this.mGroupId + jsonString);
        TaskManager.getInstance(this.mContext).submitForNetWork(new Mytask(this.mKey, jsonString));
    }

    public void onFailure(int errorCode, byte[] resultContent, Throwable tr) {
        Pair<Integer, String> tips = transErrorCode(errorCode, resultContent, tr);
        IMListener listener = ListenerManager.getInstance().removeListener(this.mKey);
        if (listener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) listener).onResult(((Integer) tips.first).intValue(), (String) tips.second, this.mGroupId);
        }
    }

    private String getNormalGroupRequestParam() throws NoSuchAlgorithmException {
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        long timeStamp = System.currentTimeMillis() / 1000;
        StringBuilder builder = new StringBuilder();
        builder.append("method=set_member_name");
        builder.append("&appid=").append(this.mAppid);
        builder.append("&group_id=").append(this.mGroupId);
        builder.append("&member_id=").append(this.mBuid);
        builder.append("&name=").append(this.mNickName);
        builder.append("&timestamp=").append(timeStamp);
        builder.append("&sign=").append(getMd5("" + timeStamp + bduss + this.mAppid));
        return builder.toString();
    }

    private String getFansGroupRequestParam() throws NoSuchAlgorithmException {
        StringBuilder builder = new StringBuilder();
        builder.append("method=set_member_name");
        builder.append("&group_id=").append(this.mGroupId);
        builder.append("&member_name=").append(this.mNickName);
        builder.append(getCommonParams());
        return builder.toString();
    }

    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        if (this.mIsFansGroup) {
            return getHostUrl() + "rest/2.0/im/groupchatv1";
        }
        return getHostUrl() + "rest/2.0/im/groupchat";
    }
}
