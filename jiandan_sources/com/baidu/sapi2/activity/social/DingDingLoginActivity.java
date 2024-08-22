package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;

public class DingDingLoginActivity extends BaseSSOLoginActivity {
    public static final String s = "KEY_AUTH_CODE";
    public static final String t = "KEY_STATE";
    public static final String u = "KEY_ERROR";
    public static final String v = "DingDingLoginActivity";
    public ThirdLoginCallback r;

    private void d() {
        try {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra(s);
            intent.getStringExtra(t);
            String stringExtra2 = intent.getStringExtra(u);
            if (StatHelper.SENSOR_ERR_2.equals(stringExtra2)) {
                Log.e(v, "用户取消授权");
                a(-301, SapiResult.ERROR_MSG_PROCESSED_END);
            } else if (!TextUtils.isEmpty(stringExtra)) {
                if (this.r != null) {
                    this.r.onAuthSuccess();
                }
                if (this.sapiWebView != null) {
                    a(ParamsUtil.addExtras(ParamsUtil.getUrlDingdingLogin(this.configuration, stringExtra), new HashMap()), "钉钉授权登录中");
                    Log.e(v, "authCode=" + stringExtra);
                    return;
                }
                a(-202, getString(R.string.sapi_sdk_dingding_login_fail));
            } else {
                Log.d(v, "errMsg==========>授权异常" + stringExtra2);
                a(-204, stringExtra2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            a(-202, e.getMessage());
            finish();
            Log.d(v, "e===========>" + e.toString());
        }
    }

    public void a(int i2, Intent intent) {
        super.a(i2, intent);
        b(i2, intent);
    }

    public void b(int i2) {
        super.b(i2);
        b(i2, (Intent) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(v, "onCreate==========>");
        setupViews();
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_dingding);
        this.r = ThirdPartyService.getThirdLoginCallback();
        d();
    }

    private void a(int i2, String str) {
        if (this.g == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", i2);
            intent.putExtra("result_msg", str);
            setResult(1002, intent);
        } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
            this.f957i.setResultCode(i2);
            this.f957i.setResultMsg(str);
            CoreViewRouter.getInstance().getWebAuthListener().onFailure(this.f957i);
            CoreViewRouter.getInstance().release();
        }
        finish();
    }

    private void b(int i2, Intent intent) {
        if (SocialLoginBase.getDingDingInvokeCallback() != null) {
            SocialLoginBase.getDingDingInvokeCallback().onResult(i2, intent);
        }
    }
}
