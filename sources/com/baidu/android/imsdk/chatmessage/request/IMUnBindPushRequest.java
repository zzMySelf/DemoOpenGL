package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.BindStateManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class IMUnBindPushRequest extends BaseHttpRequest {
    private Long mAppid;
    private String mBduss;
    private String mDeviceId;
    private Long mUk;

    public IMUnBindPushRequest(Context context, long appid, String bduss, String deviceId, Long uk) {
        this.mContext = context;
        this.mAppid = Long.valueOf(appid);
        this.mBduss = bduss;
        this.mDeviceId = deviceId;
        this.mUk = uk;
    }

    public void onSuccess(int errorCode, byte[] resultContent) {
        int resultCode;
        String jsonString = new String(resultContent);
        LogUtils.d("IMUnBindPushRequest", jsonString);
        String resultMsg = Constants.ERROR_MSG_SUCCESS;
        long requestid = 0;
        try {
            JSONObject origin = new JSONObject(jsonString);
            requestid = origin.optLong("requestid");
            resultCode = origin.optInt("error_code", 0);
            if (resultCode != 0) {
                resultMsg = origin.optString("error_msg");
            }
            if (resultCode == 0) {
                BindStateManager.clearUnBindInfo(this.mContext);
            }
        } catch (JSONException e2) {
            LogUtils.e("IMUnBindPushRequest", e2.getMessage(), e2);
            resultCode = 1010;
            resultMsg = Constants.ERROR_MSG_JSON_PARSE_EXCEPTION;
        }
        LogUtils.d("IMUnBindPushRequest", "requestid : " + requestid + " , resultCode: " + resultCode + " , resultMsg : " + resultMsg);
    }

    public void onFailure(int errorCode, byte[] resultContent, Throwable tr) {
        LogUtils.d("IMUnBindPushRequest", "  errorCode: " + transErrorCode(errorCode, resultContent, tr).first);
    }

    public String getHost() {
        return getHostUrl(this.mContext) + "rest/2.0/im/bind_push?method=unbind";
    }

    public String getMethod() {
        return "POST";
    }

    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        long timeStamp = System.currentTimeMillis() / 1000;
        StringBuilder builder = new StringBuilder("method=unbind");
        builder.append("&appid=").append(this.mAppid);
        builder.append("&device_id=").append(this.mDeviceId);
        builder.append("&uk=").append(this.mUk);
        builder.append("&timestamp=").append(timeStamp);
        builder.append("&sdk_version=").append(IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        builder.append("&sign=").append(getMd5("" + timeStamp + this.mBduss + this.mAppid));
        return builder.toString().getBytes();
    }

    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }

    public Map<String, String> getHeaders() {
        Map<String, String> map = new HashMap<>();
        map.put("Cookie", "BDUSS=" + this.mBduss);
        return map;
    }

    public boolean shouldAbort() {
        return false;
    }
}
