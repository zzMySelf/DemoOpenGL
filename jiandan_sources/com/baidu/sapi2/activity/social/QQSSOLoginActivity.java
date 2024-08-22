package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.widget.RelativeLayout;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.SocialType;

public class QQSSOLoginActivity extends QQOauthLoginActivity {
    public static final String v = "QQSSOLoginActivity";

    public void a() {
        if (this.e) {
            b(4001);
            finish();
            return;
        }
        a(this.g);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (this.e && i2 == 11101 && i3 == 0) {
            b(4001);
            finish();
        }
    }

    public void setupViews() {
        super.setupViews();
        setTitleText("QQ账号登录");
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }

    public void a(String str, String str2, String str3) {
        if (this.e) {
            Intent intent = new Intent();
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, str);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID, str2);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_UNION_ID, str3);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.QQ_SSO.getType()));
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, ThirdPartyUtil.TYPE_QQ);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().qqAppID);
            a(4001, intent);
            finish();
            return;
        }
        a(ParamsUtil.getUrlQQBind(this.configuration, str, str2, str3), "授权QQ账号登录中");
    }
}
