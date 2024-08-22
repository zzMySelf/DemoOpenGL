package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.baidu.aiscan.R;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import java.util.Arrays;
import java.util.HashMap;

public class FacebookSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String t = FacebookSSOLoginActivity.class.getSimpleName();
    public CallbackManager r;
    public LoginManager s;

    public class a implements FacebookCallback<LoginResult> {
        public a() {
        }

        /* renamed from: a */
        public void onSuccess(LoginResult loginResult) {
            Log.d(FacebookSSOLoginActivity.t, "facebook LoginManager login success");
            String token = loginResult.getAccessToken().getToken();
            String userId = loginResult.getAccessToken().getUserId();
            String applicationId = loginResult.getAccessToken().getApplicationId();
            String d = FacebookSSOLoginActivity.t;
            Log.d(d, "token = " + token);
            String d2 = FacebookSSOLoginActivity.t;
            Log.d(d2, "userId = " + userId);
            String d3 = FacebookSSOLoginActivity.t;
            Log.d(d3, "applicationId = " + applicationId);
            String urlBind = ParamsUtil.getUrlBind(FacebookSSOLoginActivity.this.configuration, SocialType.FACEBOOK, token, userId, applicationId);
            HashMap hashMap = new HashMap();
            hashMap.put("supportGuestAccount", "1");
            String addExtras = ParamsUtil.addExtras(urlBind, hashMap);
            FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
            facebookSSOLoginActivity.a(addExtras, facebookSSOLoginActivity.getString(R.string.sapi_sdk_facebook_logging));
        }

        public void onCancel() {
            Log.d(FacebookSSOLoginActivity.t, "facebook LoginManager login cancel");
            FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
            facebookSSOLoginActivity.a(facebookSSOLoginActivity.g);
        }

        public void onError(FacebookException facebookException) {
            Log.d(FacebookSSOLoginActivity.t, "facebook LoginManager login error");
            FacebookSSOLoginActivity facebookSSOLoginActivity = FacebookSSOLoginActivity.this;
            facebookSSOLoginActivity.a(facebookSSOLoginActivity.g);
        }
    }

    private void e() {
        this.r = CallbackManager.Factory.create();
        LoginManager instance = LoginManager.getInstance();
        this.s = instance;
        instance.setDefaultAudience(DefaultAudience.FRIENDS);
        this.s.setLoginBehavior(LoginBehavior.NATIVE_WITH_FALLBACK);
        this.s.setAuthType("rerequest");
        this.s.logInWithReadPermissions(this, Arrays.asList(new String[]{"public_profile"}));
        LoginManager.getInstance().registerCallback(this.r, new a());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        this.r.onActivityResult(i2, i3, intent);
        super.onActivityResult(i2, i3, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            e();
            setupViews();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_facebook);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }
}
