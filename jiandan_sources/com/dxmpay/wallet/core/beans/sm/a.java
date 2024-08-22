package com.dxmpay.wallet.core.beans.sm;

import android.content.Context;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;

public interface a {
    void certificateManage(Context context, String str, RouterCallback routerCallback);

    void closeSMCipher();

    int deletePersonalSm(Context context);

    int deleteUserKeyId(Context context);

    String getUserKeyId(Context context);

    void initSM(Context context);

    boolean isOpenSMCipher(String str);

    boolean isSMSDKInitSuccess();

    void reqeustParamsInterceptor(Context context, RestUrlConnectionRequest restUrlConnectionRequest);

    String responseBodyConvert(String str);

    int sm2Decrypt(String str, String str2, String str3, String str4, String str5, String[] strArr, boolean z);

    int sm2Encrypt(Context context, String str, String[] strArr, boolean z);

    String sm4LocalDecrypt(String str);

    String sm4LocalEncrypt(String str);
}
