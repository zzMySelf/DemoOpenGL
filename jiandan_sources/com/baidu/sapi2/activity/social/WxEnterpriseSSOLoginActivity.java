package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import com.baidu.aiscan.R;
import com.baidu.sapi2.ThirdPartyService;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.utils.Log;
import com.tencent.wework.api.IWWAPI;

public class WxEnterpriseSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String t = "WxEnterpriseSSOLoginActivity";
    public IWWAPI r;
    public ThirdLoginCallback s;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(t, "onCreate==========>");
        setupViews();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_wx_enterprise);
        this.s = ThirdPartyService.getThirdLoginCallback();
    }
}
