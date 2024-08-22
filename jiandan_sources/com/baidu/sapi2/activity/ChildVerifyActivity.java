package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.callback.AccountRealNameCallback;
import com.baidu.sapi2.result.AccountRealNameResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class ChildVerifyActivity extends BaseActivity {
    public static final String EXTRA_EXTERNAL_URL = "external_url";
    public static final String x = "ChildVerifyActivity";
    public AccountRealNameCallback w;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.w = CoreViewRouter.getInstance().getAccountRealNameCallback();
            CoreViewRouter.getInstance().releaseAccountRealNameCallback();
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
        }
    }

    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setWebviewPageFinishCallback(new SapiJsCallBacks.WebviewPageFinishCallback() {
            public void onFinish(String str) {
                Log.d(ChildVerifyActivity.x, "WebviewPageFinishCallback onFinish result=" + str);
                if (ChildVerifyActivity.this.w != null) {
                    AccountRealNameResult accountRealNameResult = new AccountRealNameResult();
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = new JSONObject(str);
                    } catch (JSONException e) {
                        Log.e(e);
                    }
                    if (jSONObject != null) {
                        accountRealNameResult.setResultCode(0);
                        accountRealNameResult.setResultMsg("成功");
                        accountRealNameResult.callbackkey = jSONObject.optString("callbackKey");
                    } else {
                        accountRealNameResult.setResultCode(-202);
                        accountRealNameResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                    }
                    ChildVerifyActivity.this.w.onFinish(accountRealNameResult);
                }
                ChildVerifyActivity.this.finish();
            }
        });
        this.sapiWebView.loadUrl(getIntent().getStringExtra("external_url"));
    }
}
