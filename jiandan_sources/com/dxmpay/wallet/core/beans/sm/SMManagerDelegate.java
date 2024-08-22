package com.dxmpay.wallet.core.beans.sm;

import android.content.Context;
import com.baidu.wallet.router.RouterCallback;
import com.dxmpay.apollon.restnet.rest.httpurlconnection.RestUrlConnectionRequest;
import com.dxmpay.apollon.utils.LogUtil;

public class SMManagerDelegate implements a {
    public static final String TAG = "SMManagerDelegate";
    public a qw = null;

    public SMManagerDelegate() {
        LogUtil.d(TAG, "init sm encrypt/decrypt manager failure，because of SMMoudle is not exist");
    }

    public void certificateManage(Context context, String str, RouterCallback routerCallback) {
        a aVar = this.qw;
        if (aVar != null) {
            aVar.certificateManage(context, str, routerCallback);
        }
    }

    public void closeSMCipher() {
        a aVar = this.qw;
        if (aVar != null) {
            aVar.closeSMCipher();
        }
    }

    public int deletePersonalSm(Context context) {
        a aVar = this.qw;
        if (aVar != null) {
            return aVar.deletePersonalSm(context);
        }
        return -1;
    }

    public int deleteUserKeyId(Context context) {
        a aVar = this.qw;
        if (aVar != null) {
            return aVar.deleteUserKeyId(context);
        }
        return -1;
    }

    public String getUserKeyId(Context context) {
        a aVar = this.qw;
        if (aVar != null) {
            return aVar.getUserKeyId(context);
        }
        return null;
    }

    public void initSM(Context context) {
        a aVar = this.qw;
        if (aVar != null) {
            aVar.initSM(context);
        }
    }

    public boolean isOpenSMCipher(String str) {
        a aVar = this.qw;
        if (aVar != null) {
            return aVar.isOpenSMCipher(str);
        }
        return false;
    }

    public boolean isSMSDKInitSuccess() {
        a aVar = this.qw;
        if (aVar != null) {
            return aVar.isSMSDKInitSuccess();
        }
        return false;
    }

    public void reqeustParamsInterceptor(Context context, RestUrlConnectionRequest restUrlConnectionRequest) {
        a aVar = this.qw;
        if (aVar != null) {
            aVar.reqeustParamsInterceptor(context, restUrlConnectionRequest);
        }
    }

    public String responseBodyConvert(String str) {
        a aVar = this.qw;
        return aVar != null ? aVar.responseBodyConvert(str) : str;
    }

    public int sm2Decrypt(String str, String str2, String str3, String str4, String str5, String[] strArr, boolean z) {
        a aVar = this.qw;
        if (aVar != null) {
            return aVar.sm2Decrypt(str, str2, str3, str4, str5, strArr, z);
        }
        return -1;
    }

    public int sm2Encrypt(Context context, String str, String[] strArr, boolean z) {
        a aVar = this.qw;
        if (aVar != null) {
            return aVar.sm2Encrypt(context, str, strArr, z);
        }
        return -1;
    }

    public String sm4LocalDecrypt(String str) {
        a aVar = this.qw;
        if (aVar != null) {
            return aVar.sm4LocalDecrypt(str);
        }
        return null;
    }

    public String sm4LocalEncrypt(String str) {
        a aVar = this.qw;
        if (aVar != null) {
            return aVar.sm4LocalEncrypt(str);
        }
        return null;
    }
}
