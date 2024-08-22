package com.baidu.android.util.io;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class ActionJsonData {
    public static final int STATUS_DEFAULT = -1;
    public static final int STATUS_OK = 0;
    private static final String TAG = "ActionJsonData";
    public static final String TAG_COMMAND = "command";
    public static final String TAG_DATASET = "dataset";
    public static final String TAG_LINK = "link";
    public static final String TAG_NOTIFICATION = "notification";
    public static final String TAG_SIGN_IN = "sign_in";
    public static final String TAG_STATUS = "status";
    public static final String TAG_TEXT = "text";
    public static final String TAG_VERSION = "version";
    private List<JSONObject> mDataset;
    private Link mLink;
    private int mSignInStatus;
    private int mStatus = -1;
    private int mVersion = 0;

    public static final class Link {
        public Notification mNotification;
        public SignIn mSignIn;
    }

    public static final class Notification {
        public String mCommand;
        public String mText;
    }

    public static final class SignIn {
        public String mCommand;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int status) {
        this.mStatus = status;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setVersion(int version) {
        this.mVersion = version;
    }

    public List<JSONObject> getDataset() {
        return this.mDataset;
    }

    public void setDataset(List<JSONObject> dataset) {
        this.mDataset = dataset;
    }

    public Link getLink() {
        return this.mLink;
    }

    public void setLink(Link link) {
        this.mLink = link;
    }

    public int getSignInStatus() {
        return this.mSignInStatus;
    }

    public void setSignIn(int status) {
        this.mSignInStatus = status;
    }

    public static ActionJsonData fromJson(JSONObject jsonObj) {
        if (jsonObj == null) {
            return null;
        }
        ActionJsonData jsonData = new ActionJsonData();
        jsonData.setStatus(jsonObj.optInt("status", -1));
        jsonData.setVersion(jsonObj.optInt("version"));
        jsonData.setSignIn(jsonObj.optInt("sign_in"));
        try {
            JSONObject linkJsonObj = new JSONObject(jsonObj.optString("link"));
            String notificationJsonStr = linkJsonObj.optString("notification");
            if (notificationJsonStr != null) {
                JSONObject notificationJsonObj = new JSONObject(notificationJsonStr);
                Notification notification = new Notification();
                notification.mText = notificationJsonObj.optString("text");
                notification.mCommand = notificationJsonObj.optString("command");
                SignIn signIn = new SignIn();
                signIn.mCommand = new JSONObject(linkJsonObj.optString("sign_in")).optString("command");
                Link link = new Link();
                link.mNotification = notification;
                link.mSignIn = signIn;
                jsonData.setLink(link);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        JSONObject datasetObj = jsonObj.optJSONObject("dataset");
        JSONArray datasetArray = jsonObj.optJSONArray("dataset");
        List<JSONObject> dataset = null;
        if (datasetArray != null) {
            dataset = new ArrayList<>();
            int size = datasetArray.length();
            for (int i2 = 0; i2 < size; i2++) {
                JSONObject data = datasetArray.optJSONObject(i2);
                if (data != null) {
                    dataset.add(data);
                }
            }
        } else if (datasetObj != null) {
            dataset = new ArrayList<>(1);
            dataset.add(datasetObj);
        }
        jsonData.setDataset(dataset);
        return jsonData;
    }

    public static ActionJsonData fromJson(String json) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }
        try {
            return fromJson(new JSONObject(json));
        } catch (JSONException e2) {
            Log.i(TAG, e2.toString());
            return null;
        }
    }
}
