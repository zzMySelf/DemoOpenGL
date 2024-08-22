package com.dxmpay.wallet.dxmpass;

import android.content.Context;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.wallet.router.RouterCallback;

public class DxmPassManagerDelegate implements IDxmPassManager {
    public static final String DXM_KEY_AVATAR = "avatar";
    public static final String DXM_KEY_AVATAR_HIGH = "avatar_high";
    public static final String DXM_KEY_DID = "did";
    public static final String DXM_KEY_DISPLAY_NAME = "displayName";
    public static final String DXM_KEY_DISPLAY_PHONE = "display_phone";
    public static final String DXM_KEY_EXT_DATA = "extData";
    public static final String DXM_KEY_OPENBDUSS = "openbduss";
    public static final String DXM_KEY_RESULT_CODE = "resultCode";
    public static final String DXM_KEY_RESULT_MSG = "resultMsg";
    public static final String DXM_KEY_TPL_STOKE_MAP = "tplStokenMap";
    public static final String DXM_KEY_UNIONID = "unionid";
    public static final String DXM_KEY_WEB_AUTH_RESULT = "webAuthResult";
    public static final String DXM_MER_TOOL_TPL = "bp";
    public static final String DXM_PASS_PRODUCT_CODE = "10005";
    public static final int GETLOGIN_BEFORE_SUCCESS = -3;
    public static final int GET_OPENBDUSS_FINISH = -2;
    public static final int GET_OPENBDUSS_START = -1;
    public static final int LOGIN_TYPE_IS_DXM_PASS = 2;
    public static final String TAG = "DxmPassManagerDelegate";
    public static final int WEB2_LOGIN_BDUSS_ON_BDUSS_EMPTY = -4;
    public static final int WEB2_LOGIN_BDUSS_ON_BDUSS_EXPIRED = -5;
    public Class<?> mDxmAccountManagerClass;
    public Class<?> mDxmPassManagerClass;
    public IDxmPassManager mManager;

    public static class ad {
        public static DxmPassManagerDelegate qw = new DxmPassManagerDelegate();
    }

    public static DxmPassManagerDelegate getInstance() {
        return ad.qw;
    }

    public int dxmGetLoginType() {
        IDxmPassManager iDxmPassManager = this.mManager;
        if (iDxmPassManager != null) {
            return iDxmPassManager.dxmGetLoginType();
        }
        return 1;
    }

    public void dxmInitSdk(Context context, SapiConfiguration sapiConfiguration) {
        IDxmPassManager iDxmPassManager = this.mManager;
        if (iDxmPassManager != null) {
            iDxmPassManager.dxmInitSdk(context, sapiConfiguration);
        }
    }

    public boolean dxmIsLogin() {
        IDxmPassManager iDxmPassManager = this.mManager;
        if (iDxmPassManager != null) {
            return iDxmPassManager.dxmIsLogin();
        }
        return false;
    }

    public void dxmLogout() {
        IDxmPassManager iDxmPassManager = this.mManager;
        if (iDxmPassManager != null) {
            iDxmPassManager.dxmLogout();
        }
    }

    public void dxmStartLogin(Context context, WebLoginDTO webLoginDTO, String str, RouterCallback routerCallback) {
        IDxmPassManager iDxmPassManager = this.mManager;
        if (iDxmPassManager != null) {
            iDxmPassManager.dxmStartLogin(context, webLoginDTO, str, routerCallback);
        }
    }

    public int getBdussState() {
        IDxmPassManager iDxmPassManager = this.mManager;
        if (iDxmPassManager != null) {
            return iDxmPassManager.getBdussState();
        }
        return 0;
    }

    public String getDxmDid() {
        IDxmPassManager iDxmPassManager = this.mManager;
        if (iDxmPassManager != null) {
            return iDxmPassManager.getDxmDid();
        }
        return null;
    }

    public void getOpenBduss(RouterCallback routerCallback) {
        IDxmPassManager iDxmPassManager = this.mManager;
        if (iDxmPassManager != null) {
            iDxmPassManager.getOpenBduss(routerCallback);
        }
    }

    public boolean hasDxmPass() {
        return this.mManager != null;
    }

    public void web2NativeLogin(RouterCallback routerCallback) {
        IDxmPassManager iDxmPassManager = this.mManager;
        if (iDxmPassManager != null) {
            iDxmPassManager.web2NativeLogin(routerCallback);
        }
    }

    public DxmPassManagerDelegate() {
        this.mManager = null;
    }
}
