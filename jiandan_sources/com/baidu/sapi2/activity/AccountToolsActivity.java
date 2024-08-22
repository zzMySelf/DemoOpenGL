package com.baidu.sapi2.activity;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.AccountToolsCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.AccountToolsResult;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiEnv;
import java.util.HashMap;

public class AccountToolsActivity extends Activity {
    public static final String EXTRA_ACCOUNT_TOOLS_TYPE = "ACCOUNT_TOOLS_TYPE";
    public static final String EXTRA_SWEEP_LIGHT_LOADING = "sweepLightLoading";
    public AccountToolsResult a = new AccountToolsResult();
    public AccountToolsCallback b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra(EXTRA_ACCOUNT_TOOLS_TYPE, -1);
        this.b = CoreViewRouter.getInstance().getAccountToolsCallback();
        AccountCenterDTO accountCenterDTO = new AccountCenterDTO();
        accountCenterDTO.accountToolsUrl = a(intExtra);
        accountCenterDTO.isFromAccountTools = true;
        accountCenterDTO.sweepLightLoading = getIntent().getBooleanExtra(EXTRA_SWEEP_LIGHT_LOADING, false);
        CoreViewRouter.getInstance().loadAccountCenter(new AccountCenterCallback() {
            public void onFinish(AccountCenterResult accountCenterResult) {
                AccountToolsActivity.this.a.setResultCode(accountCenterResult.getResultCode());
                AccountToolsActivity.this.a.setResultMsg(accountCenterResult.getResultMsg());
                AccountToolsActivity.this.a();
            }

            public void onSocialBind(String str) {
            }
        }, accountCenterDTO);
    }

    /* access modifiers changed from: private */
    public void a() {
        AccountToolsCallback accountToolsCallback = this.b;
        if (accountToolsCallback != null) {
            accountToolsCallback.onFinish(this.a);
        }
        finish();
    }

    private String a(int i2) {
        String str;
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        HashMap hashMap = new HashMap();
        switch (i2) {
            case 1:
                str = "/v6/accountfreezeapply";
                break;
            case 2:
                str = "/wp/v3/ucenter/findaccback";
                break;
            case 3:
                str = "/wp/v3/ucenter/accountcancelpage";
                break;
            case 4:
                str = "/v4/appeal/";
                break;
            case 5:
                str = "/v6/setPassword";
                break;
            case 6:
                str = SapiEnv.LOGIN_PROJECT;
                break;
            case 7:
                str = "/v6/loginTypeManage";
                break;
            case 8:
                str = "/v6/securitySettings/deviceManage";
                break;
            case 9:
                str = "/v6/appAuthority";
                break;
            case 10:
                str = "/v6/linkAccount";
                break;
            case 11:
                str = "/v6/appeal_query/input_account";
                break;
            default:
                throw new RuntimeException("account tools type is not support");
        }
        String str2 = sapiConfiguration.environment.getWap() + str + "?" + ParamsUtil.buildH5CommonParams(sapiConfiguration);
        hashMap.put("throughPage", "1");
        hashMap.put(SlideActiviy.EXTRA_PARAMS_SLIDE_PAGE, "1");
        if (sapiConfiguration.supportFaceLogin) {
            hashMap.put("supFaceLogin", "1");
        }
        if (sapiConfiguration.supportPhoto) {
            hashMap.put("support_photo", "1");
        }
        return !hashMap.isEmpty() ? ParamsUtil.addExtras(str2, hashMap) : str2;
    }
}
