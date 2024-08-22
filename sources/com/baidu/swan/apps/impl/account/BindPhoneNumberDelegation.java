package com.baidu.swan.apps.impl.account;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.dto.WebBindWidgetDTO;
import com.baidu.sapi2.result.WebBindWidgetResult;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.ipc.delegate.SwanActivityDelegation;
import com.baidu.swan.apps.util.typedbox.TypedCallback;

public class BindPhoneNumberDelegation extends SwanActivityDelegation {
    private static final String TAG = "BindPhoneNumberDelegation";

    /* access modifiers changed from: protected */
    public boolean onExec() {
        startBindWidgetActivityDirectly(isLegal() ? getAgent() : AppRuntime.getAppContext(), new TypedCallback<Bundle>() {
            public void onCallback(Bundle msg) {
                BindPhoneNumberDelegation.this.finish();
            }
        });
        return false;
    }

    public static void startBindWidgetActivityDirectly(Context context, final TypedCallback<Bundle> callback) {
        String bduss;
        SwanAppLog.i(TAG, "bindPhoneNumber start");
        if (callback == null) {
            SwanAppLog.i(TAG, "callback is null");
            return;
        }
        if (AccountUtils.isGuestLoginAnyProcess(SwanAppRuntime.getAppContext())) {
            bduss = "";
        } else {
            bduss = AccountUtils.getBdussAnyProcess(SwanAppRuntime.getAppContext());
        }
        if (TextUtils.isEmpty(bduss)) {
            SwanAppLog.i(TAG, "bduss is null");
            callback.onCallback(new Bundle());
            return;
        }
        WebBindWidgetDTO bindWidget = new WebBindWidgetDTO();
        bindWidget.bindWidgetAction = BindWidgetAction.BIND_MOBILE;
        bindWidget.bduss = bduss;
        bindWidget.context = context != null ? context : AppRuntime.getAppContext();
        PassportSDK.getInstance().loadBindWidget(new WebBindWidgetCallback() {
            public void onFinish(WebBindWidgetResult webBindWidgetResult) {
                SwanAppLog.i(BindPhoneNumberDelegation.TAG, "loadBindWidget onFinish");
                TypedCallback.this.onCallback(new Bundle());
            }
        }, bindWidget);
    }
}
