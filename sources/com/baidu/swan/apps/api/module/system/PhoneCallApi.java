package com.baidu.swan.apps.api.module.system;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.impl.feedback.IFeedbackConstants;
import com.baidu.swan.apps.util.SwanAppActivityUtils;
import org.json.JSONObject;

public class PhoneCallApi extends AbsSystemApi {
    public static final String KEY_PHONE_NUMBER = "phoneNumber";
    private static final String MAKE_PHONE_CALL = "makePhoneCall";
    private static final String TAG = "PhoneCallApi";
    private static final String WHITELIST_NAME = "swanAPI/makePhoneCall";

    public PhoneCallApi(ISwanApiContext swanApiContext) {
        super(swanApiContext);
    }

    public String getLogTag() {
        return TAG;
    }

    public SwanApiResult makePhoneCall(String params) {
        logInfo("#makePhoneCall", false);
        if (isAppInvisible()) {
            SwanAppLog.e(TAG, "PhoneCallApi does not supported when app is invisible.");
            return new SwanApiResult(1001, "PhoneCallApi does not supported when app is invisible.");
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        Pair<SwanApiResult, JSONObject> pairResult = parseJson(params);
        SwanApiResult parseResult = (SwanApiResult) pairResult.first;
        if (!parseResult.isSuccess()) {
            return parseResult;
        }
        JSONObject joParams = (JSONObject) pairResult.second;
        if (joParams != null) {
            String optString = joParams.optString(KEY_PHONE_NUMBER);
            String phone = optString;
            if (!TextUtils.isEmpty(optString)) {
                intent.setData(Uri.fromParts(IFeedbackConstants.KEY_USER_TELEPHONE, phone, (String) null));
            }
        }
        if (SwanAppActivityUtils.startActivitySafely(getContext(), intent)) {
            return SwanApiResult.ok();
        }
        return new SwanApiResult(1001);
    }
}
