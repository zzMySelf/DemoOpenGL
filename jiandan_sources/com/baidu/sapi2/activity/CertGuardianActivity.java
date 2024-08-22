package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.CertGuardianCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.result.CertGuardianResult;
import com.baidu.sapi2.result.SapiResult;
import java.util.ArrayList;

public class CertGuardianActivity extends BaseActivity {
    public static final String EXTRA_SCENE = "EXTRA_SCENE";
    public String w;
    public CertGuardianCallback x;
    public CertGuardianResult y;

    private void c() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || !sapiWebView.canGoBack()) {
            onClose();
        } else {
            this.sapiWebView.back();
        }
    }

    private void d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("sence", this.w));
        this.sapiWebView.loadCertGuardianUrl(arrayList);
    }

    private void finishActivity() {
        CertGuardianCallback certGuardianCallback = this.x;
        if (certGuardianCallback != null) {
            certGuardianCallback.onFinish(this.y);
        }
        finish();
    }

    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getRealNameDTO();
    }

    public void init() {
        super.init();
        this.w = getIntent().getStringExtra("EXTRA_SCENE");
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        c();
    }

    public void onClose() {
        super.onClose();
        if (this.y == null) {
            this.y = new CertGuardianResult();
        }
        if (this.y.getResultCode() == 110000) {
            this.y.setResultCode(0);
            this.y.setResultMsg("成功");
        } else {
            this.y.setResultCode(-301);
            this.y.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        }
        finishActivity();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.x = CoreViewRouter.getInstance().getCertGuardianCallback();
            CoreViewRouter.getInstance().releaseCertGuardianCallback();
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            if (this.y == null) {
                this.y = new CertGuardianResult();
            }
            this.y.setResultCode(-202);
            this.y.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            finishActivity();
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
        setTitleText((int) R.string.sapi_sdk_title_cert_guardian);
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() {
            public boolean onBack() {
                SapiWebView sapiWebView = CertGuardianActivity.this.sapiWebView;
                if (sapiWebView == null || !sapiWebView.canGoBack()) {
                    CertGuardianActivity.this.onClose();
                    return false;
                }
                CertGuardianActivity.this.sapiWebView.goBack();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                CertGuardianActivity.this.onClose();
            }
        });
        this.sapiWebView.setCertGuardianRusultCallback(new SapiJsCallBacks.CertGuardianRusultCallback() {
            public void onFinish(CertGuardianResult certGuardianResult) {
                CertGuardianResult unused = CertGuardianActivity.this.y = certGuardianResult;
                CertGuardianActivity.this.onClose();
            }
        });
        d();
    }
}
