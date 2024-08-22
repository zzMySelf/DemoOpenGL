package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class IMAddFanGroupBotRequest extends FansGroupBaseHttpRequest {
    private static final String TAG = IMAddFanGroupBotRequest.class.getSimpleName();
    private long mGroupId;
    private boolean mIsBot = false;
    private String mKey;
    private String mMember;

    public IMAddFanGroupBotRequest(Context context, long groupid, String member, boolean isBot, String key) {
        this.mContext = context;
        this.mMember = member;
        this.mGroupId = groupid;
        this.mIsBot = isBot;
        this.mKey = key;
    }

    public byte[] getRequestParameter() {
        StringBuilder builder = new StringBuilder();
        builder.append("method=add_member");
        builder.append("&group_id=").append(this.mGroupId);
        builder.append("&member=").append(BIMManager.getBdUKFromBdUid(this.mMember));
        try {
            builder.append(getCommonParams());
        } catch (NoSuchAlgorithmException e2) {
            LogUtils.e(TAG, "getRequestParameter :", e2);
        }
        builder.append("&is_passive=").append(0);
        builder.append("&is_bot=").append(this.mIsBot ? 1 : 0);
        return builder.toString().getBytes();
    }

    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    public boolean shouldAbort() {
        return false;
    }

    public void onSuccess(int errorCode, byte[] resultContent) {
        int resultCode;
        LogUtils.d(TAG, "json is " + new String(resultContent));
        String resultMsg = "";
        try {
            JSONObject origin = new JSONObject(new String(resultContent));
            resultCode = origin.getInt("error_code");
            resultMsg = origin.optString("error_msg", "");
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "IMAddFanGroupBotRequest JSONException", e2);
            resultCode = 1010;
        }
        IMListener listener = ListenerManager.getInstance().removeListener(this.mKey);
        if (listener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) listener).onResult(resultCode, resultMsg, 0);
        }
        if (resultCode == 0) {
            ArrayList<String> buids = new ArrayList<>();
            buids.add(this.mMember);
            IMQueryFansMemberRequest request = new IMQueryFansMemberRequest(this.mContext, (String) null, "" + this.mGroupId, buids);
            HttpHelper.executor(this.mContext, request, request);
        }
    }

    public void onFailure(int errorCode, byte[] resultContent, Throwable tr) {
        Pair<Integer, String> tips = transErrorCode(errorCode, resultContent, tr);
        IMListener listener = ListenerManager.getInstance().removeListener(this.mKey);
        if (listener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) listener).onResult(((Integer) tips.first).intValue(), (String) tips.second, 0);
        }
    }
}
