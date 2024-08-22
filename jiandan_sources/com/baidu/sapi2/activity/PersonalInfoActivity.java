package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.PersonalInfoCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.PersonalInfoDTO;
import com.baidu.sapi2.utils.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PersonalInfoActivity extends SlideActiviy {
    public PersonalInfoCallback F;
    public PersonalInfoDTO G;

    /* access modifiers changed from: private */
    public void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
        } else {
            this.sapiWebView.back();
        }
    }

    private void d() {
        HashMap<String, String> hashMap;
        JSONObject jSONObject = new JSONObject();
        PersonalInfoDTO personalInfoDTO = this.G;
        if (!(personalInfoDTO == null || (hashMap = personalInfoDTO.extraParams) == null)) {
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
        this.sapiWebView.loadPersonalInfoUrl(arrayList);
    }

    public void init() {
        super.init();
    }

    public void loadSlideWebview(String str, String str2, String str3) {
        Intent intent = new Intent(this, LoadExternalWebViewActivity.class);
        intent.putExtra("extra_external_title", str);
        intent.putExtra("extra_external_url", str2);
        startActivity(intent);
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        c();
    }

    public void onClose() {
        super.onClose();
        PersonalInfoCallback personalInfoCallback = this.F;
        if (personalInfoCallback != null) {
            personalInfoCallback.onFinish();
        }
        finish();
        CoreViewRouter.getInstance().release();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.F = CoreViewRouter.getInstance().getPersonalInfoCallback();
            this.G = CoreViewRouter.getInstance().getPersonalInfoDTO();
            CoreViewRouter.getInstance().releasePersonalInfoCallback();
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            PersonalInfoCallback personalInfoCallback = this.F;
            if (personalInfoCallback != null) {
                personalInfoCallback.onFinish();
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
                PersonalInfoActivity.this.c();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                PersonalInfoActivity.this.onClose();
            }
        });
        this.sapiWebView.setLoadExternalWebViewCallback(new SapiWebView.LoadExternalWebViewCallback() {
            public void loadExternalWebview(SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult) {
                Intent intent = new Intent(PersonalInfoActivity.this, LoadExternalWebViewActivity.class);
                intent.putExtra("extra_external_title", loadExternalWebViewResult.defaultTitle);
                intent.putExtra("extra_external_url", loadExternalWebViewResult.externalUrl);
                PersonalInfoActivity.this.startActivity(intent);
            }
        });
        d();
    }
}
