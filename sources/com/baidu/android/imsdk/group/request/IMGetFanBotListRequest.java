package com.baidu.android.imsdk.group.request;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.IMListener;
import com.baidu.android.imsdk.group.BIMValueCallBack;
import com.baidu.android.imsdk.group.GroupMember;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IMGetFanBotListRequest extends FansGroupBaseHttpRequest {
    private static final String TAG = "IMGetFanBotListRequest";
    private String mGroupId;
    private String mKey;

    public IMGetFanBotListRequest(Context context, String groupId, String key) {
        this.mContext = context;
        this.mGroupId = groupId;
        this.mKey = key;
    }

    public byte[] getRequestParameter() {
        StringBuilder builder = new StringBuilder();
        builder.append("method=get_invite_robot");
        builder.append("&group_id=").append(this.mGroupId);
        builder.append("&group_type=").append(3);
        try {
            builder.append(getCommonParams());
        } catch (NoSuchAlgorithmException e2) {
            LogUtils.e(TAG, "getRequestParameter :", e2);
        }
        return builder.toString().getBytes();
    }

    public void onSuccess(int errorCode, byte[] resultContent) {
        int responseCode;
        String result = new String(resultContent);
        LogUtils.d(TAG, "onSuccess result = " + result);
        ArrayList<GroupMember> gmembers = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(result);
            responseCode = object.optInt("error_code");
            if (responseCode == 0 && object.has("response_params")) {
                JSONObject params = object.getJSONObject("response_params");
                JSONArray sucmembers = params.getJSONArray("members");
                int i2 = 0;
                while (i2 < sucmembers.length()) {
                    JSONObject jm = sucmembers.getJSONObject(i2);
                    long bdUid = jm.optLong("bd_uid");
                    String avatar = jm.optString("avatar", "");
                    String displayName = jm.optString("display_name", "");
                    int status = jm.optInt("group_status", 0);
                    JSONObject params2 = params;
                    GroupMember m = new GroupMember(String.valueOf(this.mGroupId), 0, displayName, bdUid, 3, System.currentTimeMillis());
                    m.setAvatarExt(avatar);
                    m.setAddStatus(status);
                    gmembers.add(m);
                    i2++;
                    params = params2;
                }
            }
        } catch (JSONException e2) {
            LogUtils.e(TAG, "onSuccess JSONException", e2);
            responseCode = 1010;
        }
        IMListener listener = ListenerManager.getInstance().removeListener(this.mKey);
        if (listener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) listener).onResult(responseCode, "", gmembers);
        }
    }

    public void onFailure(int errorCode, byte[] resultContent, Throwable arg3) {
        Pair<Integer, String> tips = transErrorCode(errorCode, resultContent, arg3);
        LogUtils.d(TAG, "onFailure result = " + new String(resultContent));
        IMListener listener = ListenerManager.getInstance().removeListener(this.mKey);
        if (listener instanceof BIMValueCallBack) {
            ((BIMValueCallBack) listener).onResult(((Integer) tips.first).intValue(), (String) tips.second, null);
        }
    }

    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    public boolean shouldAbort() {
        return false;
    }
}
