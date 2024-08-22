package com.tera.scan.vip.pay.wxapi;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tera.scan.framework.BaseActivity;
import fe.fe.when.qw.qw.de;

public class WXPayEntryActivity extends BaseActivity implements IWXAPIEventHandler {
    public static final String TAG = "WXPayEntryActivity";
    public IWXAPI api;

    public int getLayoutId() {
        return 0;
    }

    public void initView() {
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this, (String) null);
        this.api = createWXAPI;
        createWXAPI.handleIntent(getIntent(), this);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.api.handleIntent(intent, this);
    }

    public void onReq(BaseReq baseReq) {
    }

    public void onResp(BaseResp baseResp) {
        if (baseResp.getType() == 5) {
            new de().ad(this, baseResp);
            finish();
        }
    }
}
