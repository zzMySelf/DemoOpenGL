package com.baidu.swan.apps.impl.network;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.adaptation.interfaces.ISwanRealNameVerify;
import com.baidu.swan.apps.api.module.network.RequestApiUtils;
import com.baidu.swan.apps.impl.account.AccountUtils;
import com.baidu.swan.apps.impl.account.actions.FaceVerifyAction;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanApp;
import com.baidu.swan.apps.util.SwanAppJSONUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import org.json.JSONException;
import org.json.JSONObject;

public class SwanRealNameVerifyImpl implements ISwanRealNameVerify {
    public void checkRealNameResult(Context context, final TypedCallback<String> callBack) {
        FaceVerifyAction.checkRealName(RequestApiUtils.buildRequestCancelTag(Swan.get().getApp().id), new TypedCallback<String>() {
            public void onCallback(String msg) {
                callBack.onCallback(msg);
            }
        });
    }

    public void faceVerify(String verifyMsg, final TypedCallback<String> callBack) {
        FaceVerifyAction.launchFaceVerify(verifyMsg, Swan.get().getApp(), new TypedCallback<String>() {
            public void onCallback(String msg) {
                try {
                    callBack.onCallback(new JSONObject(msg).optString("status"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void requestRealNameAuth(final TypedCallback<JSONObject> callBack) {
        SwanApp swanApp = Swan.get().getApp();
        Activity activity = Swan.get().getActivity();
        String appId = swanApp.getAppId();
        TypedCallback<Bundle> realNameCallback = new TypedCallback<Bundle>() {
            public void onCallback(Bundle result) {
                if (result == null) {
                    callBack.onCallback(null);
                    return;
                }
                boolean juniorRealNameSuc = result.getBoolean("juniorRealNameSuc");
                int errCode = result.getInt("subErrCode", -100000);
                String errMsg = result.getString("subErrMsg", "未触发任何实名操作返回或实名时放弃返回");
                JSONObject joResult = new JSONObject();
                SwanAppJSONUtils.setValue(joResult, "juniorRealNameSuc", Boolean.valueOf(juniorRealNameSuc));
                SwanAppJSONUtils.setValue(joResult, "subErrCode", Integer.valueOf(errCode));
                SwanAppJSONUtils.setValue(joResult, "subErrMsg", errMsg);
                callBack.onCallback(joResult);
            }
        };
        if (ProcessUtils.isMainProcess()) {
            AccountUtils.launchJuniorLevelRealName(activity, appId, realNameCallback);
        } else {
            AccountUtils.launchMultiAuthorizeFaceVerifyWithDelegation(activity, appId, realNameCallback);
        }
    }

    public void isGuestLogin(Context context, TypedCallback<Boolean> callBack) {
        callBack.onCallback(Boolean.valueOf(AccountUtils.isGuestLoginWithDelegation(context)));
    }

    public void requestBindPhone(final TypedCallback<Integer> callBack) {
        AccountUtils.bindPhone(new ILoginResultListener() {
            public void onResult(int resultCode) {
                callBack.onCallback(Integer.valueOf(resultCode));
            }
        });
    }
}
