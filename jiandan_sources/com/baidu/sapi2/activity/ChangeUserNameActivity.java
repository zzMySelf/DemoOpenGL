package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.ChangeUsernameCallback;
import com.baidu.sapi2.callback.LoadDuVipPayCallBack;
import com.baidu.sapi2.dto.ChangeUserNameDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.ChangeUsernameResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ChangeUserNameActivity extends BaseActivity {
    public ChangeUsernameCallback w;
    public ChangeUserNameDTO x;
    public ChangeUsernameResult y;

    private void d() {
        HashMap<String, String> hashMap;
        JSONObject jSONObject = new JSONObject();
        ChangeUserNameDTO changeUserNameDTO = this.x;
        if (!(changeUserNameDTO == null || (hashMap = changeUserNameDTO.extraParams) == null)) {
            for (Map.Entry next : hashMap.entrySet()) {
                try {
                    jSONObject.put((String) next.getKey(), next.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("loadChangeUsernameUrl params is error", new Object[0]);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("clientParamsObj", jSONObject.toString()));
        this.sapiWebView.loadChangeUsernameUrl(arrayList);
    }

    public void init() {
        super.init();
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        c();
    }

    public void onClose() {
        super.onClose();
        if (this.y == null) {
            ChangeUsernameResult changeUsernameResult = new ChangeUsernameResult();
            this.y = changeUsernameResult;
            changeUsernameResult.setResultCode(-301);
            this.y.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        }
        ChangeUsernameCallback changeUsernameCallback = this.w;
        if (changeUsernameCallback != null) {
            changeUsernameCallback.onFinish(this.y);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.w = CoreViewRouter.getInstance().getChangeUsernameCallback();
            this.x = CoreViewRouter.getInstance().getChangeUserNameDTO();
            CoreViewRouter.getInstance().releaseChangeUsernameCallback();
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            ChangeUsernameResult changeUsernameResult = new ChangeUsernameResult();
            this.y = changeUsernameResult;
            changeUsernameResult.setResultCode(-202);
            this.y.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            ChangeUsernameCallback changeUsernameCallback = this.w;
            if (changeUsernameCallback != null) {
                changeUsernameCallback.onFinish(this.y);
            }
            finish();
            CoreViewRouter.getInstance().release();
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            c();
        }
    }

    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() {
            public void onBack() {
                ChangeUserNameActivity.this.c();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                ChangeUserNameActivity.this.onClose();
            }
        });
        this.sapiWebView.setSyncAccountCallback(new SapiJsCallBacks.SyncAccountCallBack() {
            public void onSyncAccount(SapiAccount sapiAccount) {
                ChangeUsernameResult unused = ChangeUserNameActivity.this.y = new ChangeUsernameResult();
                ChangeUserNameActivity.this.y.setResultCode(110000);
                ChangeUserNameActivity.this.y.setResultMsg("成功");
            }
        });
        this.sapiWebView.setLoadExternalWebViewCallback(new SapiWebView.LoadExternalWebViewCallback() {
            public void loadExternalWebview(SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult) {
                Intent intent = new Intent(ChangeUserNameActivity.this, LoadExternalWebViewActivity.class);
                intent.putExtra("extra_external_title", loadExternalWebViewResult.defaultTitle);
                intent.putExtra("extra_external_url", loadExternalWebViewResult.externalUrl);
                ChangeUserNameActivity.this.startActivity(intent);
            }
        });
        this.sapiWebView.setOpenDuVipPayCallback(new SapiJsCallBacks.OpenDuVipPayCallback() {
            public void onOpenDuVipPay(LoadDuVipPayCallBack loadDuVipPayCallBack) {
                if (ChangeUserNameActivity.this.w != null) {
                    ChangeUserNameActivity.this.w.onOpenDuVipPay(loadDuVipPayCallBack);
                }
            }
        });
        d();
    }

    /* access modifiers changed from: private */
    public void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
        } else {
            this.sapiWebView.goBack();
        }
    }
}
