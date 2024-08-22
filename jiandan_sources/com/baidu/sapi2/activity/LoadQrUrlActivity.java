package com.baidu.sapi2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.apollon.heartbeat.a;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.LoadQrUrlResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ToastUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class LoadQrUrlActivity extends BaseActivity {
    public static final String EXTRA_EXTERNAL_TITLE = "extra_external_title";
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    public static final String TAG = "LoadQrUrlActivity";
    public static final int z = 2001;
    public String w;
    public WebAuthResult webAuthResult = new WebAuthResult() {
        public void finishActivity() {
            super.finishActivity();
            LoadQrUrlActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }

        public void finishActivity(boolean z) {
            super.finishActivity();
            LoadQrUrlActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }
    };
    public String x;
    public OneKeyLoginCallback y;

    /* access modifiers changed from: private */
    public void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            if (CoreViewRouter.getInstance().getLoadQrUrlCallback() != null) {
                CoreViewRouter.getInstance().getLoadQrUrlCallback().onFinish();
            }
            finish();
            return;
        }
        this.sapiWebView.goBack();
    }

    public void init() {
        super.init();
        this.w = getIntent().getStringExtra("extra_external_title");
        String stringExtra = getIntent().getStringExtra("extra_external_url");
        this.x = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            setResult(0);
            finish();
        }
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        c();
    }

    public void onClose() {
        super.onClose();
        if (CoreViewRouter.getInstance().getLoadQrUrlCallback() != null) {
            CoreViewRouter.getInstance().getLoadQrUrlCallback().onFinish();
        }
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_activity_load_qr_url_page);
            this.y = CoreViewRouter.getInstance().getOneKeyLoginCallback();
            CoreViewRouter.getInstance().releaseOneKeyLoginCallback();
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            c();
        }
    }

    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() {
            public boolean onBack() {
                LoadQrUrlActivity.this.c();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                LoadQrUrlActivity.this.onClose();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() {
            public void onLeftBtnVisible(int i2) {
                if (i2 == 0) {
                    LoadQrUrlActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    LoadQrUrlActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() {
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                Intent intent = new Intent(LoadQrUrlActivity.this, LoginActivity.class);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, BaseActivity.EXTRA_PARAM_FROM_ACCOUNT_CENTER);
                int i2 = result.switchAccountType;
                if (i2 == 1) {
                    intent.putExtra("username", result.userName);
                } else if (i2 == 2) {
                    if (result.loginType == 0) {
                        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME);
                    } else {
                        intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                    }
                    intent.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, true);
                    if (!TextUtils.isEmpty(result.displayName)) {
                        intent.putExtra("username", result.displayName);
                    }
                    intent.putExtra(LoginActivity.EXTRA_PARAM_ENCRYPTED_UID, result.encryptedUid);
                }
                LoadQrUrlActivity.this.startActivityForResult(intent, 2001);
            }
        });
        this.sapiWebView.setWebviewPageFinishCallback(new SapiJsCallBacks.WebviewPageFinishCallback() {
            public void onFinish(String str) {
                if (CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback() != null) {
                    ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            extendSysWebViewMethodResult.params.put(next, jSONObject.get(next));
                        }
                    } catch (JSONException e) {
                        "onFinish: err:" + e.getMessage() + ", jsonStr=" + str;
                    }
                    CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback().onFinish(extendSysWebViewMethodResult);
                    CoreViewRouter.getInstance().clearExtendSysWebViewMethodCallback();
                }
                LoadQrUrlActivity.this.finish();
            }
        });
        this.sapiWebView.setJumpToUriCallBack(new SapiJsCallBacks.JumpToUriCallBack() {
            public void onJumpTo(String str) {
                if (CoreViewRouter.getInstance().getLoadQrUrlCallback() != null) {
                    CoreViewRouter.getInstance().getLoadQrUrlCallback().onJumpTo(str);
                }
            }
        });
        this.sapiWebView.setAccountDestoryCallback(new SapiWebView.AccountDestoryCallback() {
            public void onAccountDestory(SapiWebView.AccountDestoryCallback.AccountDestoryResult accountDestoryResult) {
                LoadQrUrlResult loadQrUrlResult = new LoadQrUrlResult();
                loadQrUrlResult.setResultCode(0);
                loadQrUrlResult.setResultMsg("成功");
                loadQrUrlResult.isAccountDestory = true;
                if (CoreViewRouter.getInstance().getLoadQrUrlCallback() != null) {
                    CoreViewRouter.getInstance().getLoadQrUrlCallback().onCancelAccount(loadQrUrlResult);
                }
                LoadQrUrlActivity.this.onClose();
            }
        });
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", webLoginDTO.statExtra));
        }
        Uri parse = Uri.parse(this.x);
        if (parse == null) {
            ToastUtil.show("二维码内容有误");
            setResult(0);
            finish();
            return;
        }
        if (parse.getPath().equals("/wp/v3/ucenter/accountcancelpage")) {
            try {
                this.x = a(parse, "lstr", URLDecoder.decode(parse.getQueryParameter("lstr"), a.h)).toString();
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        this.sapiWebView.loadExternalUrl(this.x, arrayList);
        this.mTitle.setText(this.w);
    }

    private Uri a(Uri uri, String str, String str2) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Uri.Builder buildUpon = uri.buildUpon();
        try {
            if (queryParameterNames.contains(str)) {
                buildUpon.clearQuery();
                for (String next : queryParameterNames) {
                    if (!TextUtils.isEmpty(next)) {
                        buildUpon.appendQueryParameter(next, next.equals(str) ? str2 : uri.getQueryParameter(next));
                    }
                }
            } else {
                buildUpon.appendQueryParameter(str, str2);
            }
        } catch (Exception e) {
            Log.e(e.getMessage(), new Object[0]);
        }
        return buildUpon.build();
    }
}
