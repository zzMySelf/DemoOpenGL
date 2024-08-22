package com.baidu.android.imsdk.chatmessage.request;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.IShowSendMsgPVListener;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;

public class IMShowSendMsgPVRequest extends BaseHttpRequest {
    private static final String TAG = "IMShowSendMsgPVRequest";
    private final long mBeginTime;
    private final long mEndTime;
    private final IShowSendMsgPVListener mListener;

    public IMShowSendMsgPVRequest(Context context, long beginTime, long endTime, IShowSendMsgPVListener listener) {
        this.mContext = context;
        this.mBeginTime = beginTime;
        this.mEndTime = endTime;
        this.mListener = listener;
    }

    public void onSuccess(int errorCode, byte[] resultContent) {
        int pv = 0;
        try {
            JSONObject jsonString = new JSONObject(new String(resultContent));
            LogUtils.d(TAG, "errorCode：" + errorCode + ", resultContent: " + jsonString);
            if (errorCode == 200) {
                pv = jsonString.optInt("msg_count");
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "onSuccess errorCode：" + errorCode + ", exception : " + e2.toString());
        }
        IShowSendMsgPVListener iShowSendMsgPVListener = this.mListener;
        if (iShowSendMsgPVListener != null) {
            iShowSendMsgPVListener.onResult(pv);
        }
    }

    public void onFailure(int errorCode, byte[] resultContent, Throwable arg3) {
        LogUtils.e(TAG, "onFailure errorCode：" + errorCode + ", msg : " + new String(resultContent));
        IShowSendMsgPVListener iShowSendMsgPVListener = this.mListener;
        if (iShowSendMsgPVListener != null) {
            iShowSendMsgPVListener.onResult(0);
        }
    }

    public byte[] getRequestParameter() throws NoSuchAlgorithmException {
        JSONObject postJson = new JSONObject();
        try {
            postJson.put("appid", Utility.readAppId(this.mContext));
            postJson.put("app_version", Utility.getAppVersionName(this.mContext));
            postJson.put("device_id", Utility.getDeviceId(this.mContext));
            postJson.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            postJson.put("account_type", AccountManagerImpl.getInstance(this.mContext).getLoginType());
            postJson.put("time_begin_ms", this.mBeginTime);
            postJson.put("time_end_ms", this.mEndTime);
            postJson.put("timestamp", System.currentTimeMillis() / 1000);
            postJson.put("sign", generateSign(postJson));
        } catch (JSONException e2) {
            LogUtils.d(TAG, "getRequestParameter error：" + e2.toString());
        }
        LogUtils.d(TAG, "getRequestParameter:" + postJson);
        return postJson.toString().getBytes();
    }

    /* access modifiers changed from: protected */
    public String generateSign(JSONObject param) throws NoSuchAlgorithmException {
        if (param == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Set<String> set = new TreeSet<>();
        Iterator<String> it = param.keys();
        while (it.hasNext()) {
            set.add(it.next());
        }
        for (String key : set) {
            builder.append(key);
            builder.append("=");
            builder.append(param.opt(key));
        }
        LogUtils.d(TAG, "sign string:" + builder);
        return getMd5(builder.toString());
    }

    public Map<String, String> getHeaders() {
        Map<String, String> map = new HashMap<>();
        map.put("Cookie", "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
        return map;
    }

    public boolean shouldAbort() {
        return false;
    }

    public String getMethod() {
        return "POST";
    }

    public String getHost() {
        return getHostUrl(this.mContext) + "rest/3.0/im/get_user_msg_count";
    }

    public String getContentType() {
        return "application/json";
    }
}
