package com.baidu.sapi2.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.common.PassSdkModel;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.StatService;
import java.util.HashMap;

public class ShareActivity extends Activity {
    public static String TAG = "sapi_new_share_activity";
    public String callType;
    public String fromTpl;

    private void checkAuthAccountValid() {
        ShareLoginModel.getInstance().checkAuthAccountValid(getCommonStatParams(), new BdussStatusCallback() {
            public void onBdussInvalidate(String str) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString(ShareLoginModel.AUTH_PASS_SDK_VERSION, "9.10.7.3");
                bundle.putString(ShareLoginModel.AUTH_APP_PKG_NAME, ShareActivity.this.getPackageName());
                bundle.putString(ShareLoginModel.INVALIDATE_BDUSS, str);
                intent.putExtras(bundle);
                ShareActivity.this.setResult(-1, intent);
                ShareActivity.this.finish();
            }

            public void onResultAccount(SapiAccount sapiAccount) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                if (sapiAccount != null) {
                    bundle.putParcelable(ShareLoginModel.SHARE_ACCOUNT_INFO, sapiAccount);
                }
                bundle.putString(ShareLoginModel.AUTH_PASS_SDK_VERSION, "9.10.7.3");
                bundle.putString(ShareLoginModel.AUTH_APP_PKG_NAME, ShareActivity.this.getPackageName());
                if (SapiContext.getInstance().shareLivingunameEnable()) {
                    intent.putExtra(ShareLoginModel.FACE_LOGIN_UIDS, SapiContext.getInstance().getV2FaceLivingUnames());
                }
                intent.putExtras(bundle);
                ShareActivity.this.setResult(-1, intent);
                ShareActivity.this.finish();
            }
        });
    }

    private boolean checkSdkInited() {
        ISAccountManager isAccountManager;
        SapiConfiguration confignation;
        ServiceManager instance = ServiceManager.getInstance();
        if (instance == null || (isAccountManager = instance.getIsAccountManager()) == null || (confignation = isAccountManager.getConfignation()) == null || confignation.context == null) {
            return false;
        }
        return true;
    }

    private HashMap<String, String> getCommonStatParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("from_tpl", this.fromTpl);
        hashMap.put(ShareCallPacking.StatModel.KEY_CALL_TYPE, this.callType);
        return hashMap;
    }

    private void handleInvalid() {
        setResult(-1, new Intent());
        finish();
    }

    public void onBackPressed() {
        StatService.onEventAutoStat(ShareStatKey.AUTH_APP_BACK_PRESSED, getCommonStatParams());
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = 1;
        attributes.height = 1;
        attributes.type = 2002;
        attributes.flags = 32;
        window.setAttributes(attributes);
        try {
            this.fromTpl = getIntent().getStringExtra(ShareLoginModel.SHARE_LOGIN_FROM_TPL);
            this.callType = getIntent().getStringExtra(ShareLoginModel.SHARE_LOGIN_CALL_TYPE);
            if (!PassSdkModel.getInstance().checkPassSdkInit()) {
                String str = TAG;
                Log.e(str, getPackageName() + " pass sdk没有初始化");
                handleInvalid();
                return;
            }
            StatService.onEventAutoStat(ShareStatKey.SHARE_AUTH_APP_INVOKED, getCommonStatParams());
            String callingPackage = getCallingPackage();
            if (!PassSdkModel.getInstance().checkPkgSign(this, callingPackage)) {
                HashMap hashMap = new HashMap();
                hashMap.put("from_tpl", this.fromTpl);
                hashMap.put("from_pkg", callingPackage);
                hashMap.put("tpl", SapiAccountManager.getInstance().getTpl());
                StatService.onEventAutoStat(ShareStatKey.SHARE_APP_PERM_ERROR_WARN, hashMap);
                String str2 = TAG;
                Log.d(str2, callingPackage + "不是已经授权的百度系app");
                handleInvalid();
                return;
            }
            checkAuthAccountValid();
        } catch (Exception unused) {
            String str3 = TAG;
            Log.e(str3, getPackageName() + "参数不合法，拒绝调起");
            handleInvalid();
        }
    }
}
