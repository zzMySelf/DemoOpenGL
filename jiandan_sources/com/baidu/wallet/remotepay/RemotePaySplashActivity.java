package com.baidu.wallet.remotepay;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.SapiAccount;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.WelcomeActivity;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;

public class RemotePaySplashActivity extends PayBaseBeanActivity {
    public int a;
    public PrecashierCreateOrderResponse b;

    public void getInstentDatas() {
        Intent intent = getIntent();
        if (intent == null) {
            StatisticManager.onEvent("remoteSplashActivityExFinish");
            PayCallBackManager.callBackClientCancel(this.mAct, "RemotePaySplashActivity.getIntent() is null");
            finish();
            return;
        }
        this.a = intent.getIntExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, 0);
        this.b = (PrecashierCreateOrderResponse) intent.getSerializableExtra(BaiduPay.PRECASHIER_PAY_RESPONSE);
    }

    public void handleResponse(int i2, Object obj, String str) {
    }

    public void initView() {
        setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_activity_for_remote_splash"));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatisticManager.onEvent("remoteEnterSplashActivity");
        setFlagPaySdk();
        initView();
        getInstentDatas();
        startWelcomeActivity();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        StatisticManager.onEvent("remoteEnterSplashActivity");
        getInstentDatas();
        startWelcomeActivity();
    }

    public void startWelcomeActivity() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra(SapiAccount.SAPI_ACCOUNT_FROMTYPE, this.a);
        PrecashierCreateOrderResponse precashierCreateOrderResponse = this.b;
        if (precashierCreateOrderResponse != null) {
            intent.putExtra(BaiduPay.PRECASHIER_PAY_RESPONSE, precashierCreateOrderResponse);
        }
        startActivity(intent);
    }
}
