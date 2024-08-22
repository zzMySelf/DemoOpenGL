package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class IMSubscriptionBaseRequest extends BaseHttpRequest {
    private static final String TAG = "IMSubscriptionBaseRequest";
    protected boolean ignoreUk;
    protected String mKey;
    protected List<String> mMiNiAppTopicList;
    protected long mPaid;
    protected String mSource;
    protected List<Long> mTopicList;

    public abstract String getHostUrlParam();

    protected IMSubscriptionBaseRequest(Context context, long paid, List<Long> topics, List<String> miNiAppTopicList, String key, String source) {
        if (topics != null && topics.size() > 0) {
            this.mTopicList = new ArrayList(topics);
        }
        if (miNiAppTopicList != null && miNiAppTopicList.size() > 0) {
            this.mMiNiAppTopicList = new ArrayList(miNiAppTopicList);
        }
        this.mContext = context;
        this.mPaid = paid;
        this.mKey = key;
        this.mSource = source;
        this.ignoreUk = false;
    }

    public void setIgnoreUk(boolean ignore) {
        this.ignoreUk = ignore;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> map = new HashMap<>();
        map.put("Cookie", "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
        map.put("Content-Type", "application/json");
        return map;
    }

    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/subscription?method=" + getHostUrlParam();
    }

    private String getHostUrl() {
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                return "https://pim.baidu.com/";
            case 1:
                return Constants.URL_HTTP_RD_8111;
            case 2:
                return Constants.URL_HTTP_QA;
            case 3:
                return Constants.URL_HTTP_BOX;
            default:
                return null;
        }
    }

    public byte[] getRequestParameter() {
        try {
            long appId = AccountManager.getAppid(this.mContext);
            long timeStamp = System.currentTimeMillis() / 1000;
            long uk = AccountManager.getUK(this.mContext);
            JSONObject obj = new JSONObject();
            obj.put("appid", appId);
            obj.put("timestamp", timeStamp);
            obj.put("cuid", Utility.getDeviceId(this.mContext));
            obj.put(HttpConstants.DEVICE_TYPE, 2);
            obj.put("app_version", Utility.getAppVersionName(this.mContext));
            obj.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            if (!this.ignoreUk) {
                obj.put("uk", uk);
            }
            List<Long> list = this.mTopicList;
            if (list != null && list.size() > 0) {
                JSONArray topicArray = new JSONArray();
                for (Long longValue : this.mTopicList) {
                    topicArray.put(longValue.longValue());
                }
                obj.put("topic_id", topicArray);
            }
            List<String> list2 = this.mMiNiAppTopicList;
            if (list2 != null && list2.size() > 0) {
                JSONArray mTopicArray = new JSONArray();
                for (String topic : this.mMiNiAppTopicList) {
                    mTopicArray.put(topic);
                }
                obj.put("fminapp_topic", mTopicArray);
            }
            obj.put("pa_uid", this.mPaid);
            obj.put("source", this.mSource);
            if (this.ignoreUk) {
                obj.put("sign", getMd5(String.valueOf(appId) + timeStamp));
            } else {
                obj.put("sign", getMd5(String.valueOf(appId) + uk + timeStamp));
            }
            obj.put("account_type", AccountManager.isCuidLogin(this.mContext) ? 1 : 0);
            LogUtils.d(TAG, "IMSubscriptionBaseRequest msg :" + obj.toString());
            return obj.toString().getBytes();
        } catch (Exception e2) {
            LogUtils.e(TAG, "IMSubscriptionBaseRequest getRequestParameter exception", e2);
            return null;
        }
    }

    public boolean shouldAbort() {
        return false;
    }

    public String getMethod() {
        return "POST";
    }

    public String getContentType() {
        return "application/json";
    }
}
