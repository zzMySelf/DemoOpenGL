package com.baidu.swan.apps.adaptation.interfaces;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.baidu.swan.apps.api.module.account.LoginApi;
import com.baidu.swan.apps.setting.oauth.request.Accredit;
import com.baidu.swan.apps.setting.oauth.request.Authorize;
import com.baidu.swan.apps.setting.oauth.request.CheckSessionRequest;
import com.baidu.swan.apps.setting.oauth.request.GetOpenIdRequest;
import com.baidu.swan.apps.setting.oauth.request.GetSwanIdRequest;
import com.baidu.swan.apps.setting.oauth.request.LoginRequest;
import com.baidu.swan.apps.setting.oauth.request.MaOpenDataRequest;

public interface IOAuthObjectCreator {
    Accredit createAccredit(Activity activity, boolean z, String str, String str2);

    Authorize createAuthorize(Context context, boolean z, boolean z2, String[] strArr, String str, boolean z3);

    CheckSessionRequest createCheckSessionRequest(Context context, String str);

    GetOpenIdRequest createGetOpenIdRequest(Context context);

    GetSwanIdRequest createGetSwanIdRequest(Context context);

    LoginRequest createLoginRequest(Activity activity, LoginApi.LoginTimeoutConfig loginTimeoutConfig, Bundle bundle);

    MaOpenDataRequest createMaOpenDataRequest(Activity activity, String str, String str2, boolean z, boolean z2);
}
