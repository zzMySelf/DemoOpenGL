package com.baidu.swan.apps.impl.feedback;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.feedback.FeedbackInfoManager;
import com.baidu.searchbox.plugin.api.PluginInvoker;
import com.baidu.swan.apps.SwanAppLibConfig;
import com.baidu.swan.apps.ipc.delegate.SwanPluginBaseDelegation;
import com.baidu.swan.apps.util.SwanAppFeedbackUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedbackDelegation extends SwanPluginBaseDelegation {
    public static final String BUNDLE_KEY_APP_ID = "aiapps_feedback_app_id";
    private static final boolean DEBUG = SwanAppLibConfig.DEBUG;
    public static final String FEEDBACK_EXTRA_APPID_KEY = "appId";
    public static final String FEEDBACK_EXTRA_EXTRA_INFO_KEY = "extra_info";
    private static final String PACKAGE_NAME = "com.baidu.ufosdk";
    public static final String RESULT_KEY = "feed_back_result";
    public static final String SESSION_DISPLAYNAME = "BoxAccount_displayname";
    public static final String SESSION_UID = "BoxAccount_uid";
    private static final String TAG = "SwanAppFeedbackImpl";
    FeedbackInfoManager.IFeedbackCallback listener = new FeedbackInfoManager.IFeedbackCallback() {
        public void onResult(int status, String data) {
            FeedbackDelegation.this.mResult.putString(FeedbackDelegation.RESULT_KEY, data);
            FeedbackDelegation.this.finish();
        }
    };

    /* access modifiers changed from: protected */
    public boolean onExec() {
        if (!isLegal()) {
            return true;
        }
        if (DEBUG) {
            Log.d(TAG, "FeedbackDelegation onExec()");
        }
        feedbackDirectly(getAgent(), this.mParams, new TypedCallback<Bundle>() {
            public void onCallback(Bundle msg) {
                FeedbackDelegation.this.mResult.putAll(msg);
                FeedbackDelegation.this.finish();
            }
        });
        return false;
    }

    public void onAgentDestroy() {
        PluginInvoker.removeStartContext(getPluginPackageName());
        super.onAgentDestroy();
    }

    public String getPluginPackageName() {
        return PACKAGE_NAME;
    }

    public static void feedbackDirectly(Activity activity, Bundle params, final TypedCallback<Bundle> callback) {
        if (callback != null) {
            String appId = params.getString(BUNDLE_KEY_APP_ID, "");
            JSONObject extraJo = new JSONObject();
            try {
                extraJo.put("appId", appId);
                String feedbackExtInfo = SwanAppFeedbackUtils.readFeedbackExtInfo();
                if (!TextUtils.isEmpty(feedbackExtInfo)) {
                    extraJo.put("extra_info", feedbackExtInfo);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            FeedbackInfoManager.startReportActivityForSwanApp(activity, "6", appId, params.getString("BoxAccount_uid"), params.getString("BoxAccount_displayname"), extraJo, new FeedbackInfoManager.IFeedbackCallback() {
                public void onResult(int status, String data) {
                    Bundle result = new Bundle();
                    result.putString(FeedbackDelegation.RESULT_KEY, data);
                    TypedCallback.this.onCallback(result);
                }
            });
            if (DEBUG) {
                Log.d(TAG, "onExec uid: " + params.getString("BoxAccount_uid") + " onExec userName: " + params.getString("BoxAccount_displayname") + "extra: " + extraJo.toString());
            }
        }
    }
}
