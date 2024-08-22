package com.baidu.sapi2.activity.social;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;

public class GoogleSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String r = "GoogleSSOLoginActivity";
    public static final int s = 1000;

    private void a(Task<GoogleSignInAccount> task) {
        try {
            b(task.getResult(ApiException.class).getIdToken());
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            String message = e.getMessage();
            Log.d(r, "handleSignInResult exception code=" + statusCode + " msg=" + message);
            a(this.g, statusCode, message);
        }
    }

    private void b(String str) {
        SapiConfiguration sapiConfiguration = this.configuration;
        String urlBind = ParamsUtil.getUrlBind(sapiConfiguration, SocialType.GOOGLE, "", "", sapiConfiguration.googleClientId);
        HashMap hashMap = new HashMap();
        hashMap.put("supportGuestAccount", "1");
        hashMap.put("id_token", str);
        a(ParamsUtil.addExtras(urlBind, hashMap), getString(R.string.sapi_sdk_google_loging));
    }

    private void d() {
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        String idToken = lastSignedInAccount != null ? lastSignedInAccount.getIdToken() : null;
        if (!TextUtils.isEmpty(idToken)) {
            b(idToken);
        } else {
            startActivityForResult(GoogleSignIn.getClient((Activity) this, e()).getSignInIntent(), 1000);
        }
    }

    private GoogleSignInOptions e() {
        return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(this.configuration.googleClientId).build();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1000) {
            a(GoogleSignIn.getSignedInAccountFromIntent(intent));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_google);
        try {
            d();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }
}
