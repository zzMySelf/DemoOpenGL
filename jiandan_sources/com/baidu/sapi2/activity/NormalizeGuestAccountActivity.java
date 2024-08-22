package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;

public class NormalizeGuestAccountActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public NormalizeGuestAccountResult w = new NormalizeGuestAccountResult() {
        public void finishActivity() {
            super.finishActivity();
            NormalizeGuestAccountActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }
    };
    public String x;
    public SocialType y;

    /* access modifiers changed from: private */
    public void e() {
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        session.addIsGuestAccount("0");
        SapiAccountManager.getInstance().validate(session);
        if (CoreViewRouter.getInstance().getNormalizeGuestAccountCallback() != null) {
            CoreViewRouter.getInstance().getNormalizeGuestAccountCallback().onSuccess(this.w);
        }
        NormalizeGuestAccountDTO normalizeGuestAccountDTO = CoreViewRouter.getInstance().getNormalizeGuestAccountDTO();
        if (normalizeGuestAccountDTO != null && normalizeGuestAccountDTO.finishActivityAfterSuc) {
            finish();
            CoreViewRouter.getInstance().release();
        }
    }

    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getNormalizeGuestAccountDTO();
    }

    public void init() {
        super.init();
        this.w.activity = this;
    }

    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        c();
    }

    public void onClose() {
        super.onClose();
        this.w.setResultCode(-301);
        this.w.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        d();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            this.x = getIntent().getStringExtra("EXTRA_BDUSS");
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(this.x);
            if (TextUtils.isEmpty(this.x) || accountFromBduss == null) {
                this.w.setResultCode(-204);
                this.w.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                d();
                return;
            }
            this.y = accountFromBduss.getSocialType();
            init();
            setupViews();
        } catch (Throwable th2) {
            reportWebviewError(th2);
            this.w.setResultCode(-202);
            this.w.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            d();
        }
    }

    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            c();
        }
    }

    public void setupViews() {
        String str;
        super.setupViews();
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() {
            public void onBack() {
                NormalizeGuestAccountActivity.this.c();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() {
            public void onFinish() {
                NormalizeGuestAccountActivity.this.onClose();
            }
        });
        ArrayList arrayList = new ArrayList();
        NormalizeGuestAccountDTO normalizeGuestAccountDTO = CoreViewRouter.getInstance().getNormalizeGuestAccountDTO();
        if (normalizeGuestAccountDTO != null) {
            if (WebLoginDTO.statExtraValid(normalizeGuestAccountDTO.statExtra)) {
                arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(normalizeGuestAccountDTO.statExtra)));
            }
            str = normalizeGuestAccountDTO.description;
        } else {
            str = "";
        }
        this.sapiWebView.setNormalizeGuestAccountCallback(new SapiJsCallBacks.NormalizeGuestAccountCallback() {
            public void onFailure(int i2, String str) {
                NormalizeGuestAccountActivity.this.w.setResultCode(i2);
                NormalizeGuestAccountActivity.this.w.setResultMsg(str);
                NormalizeGuestAccountActivity.this.d();
            }

            public void onSuccess(boolean z, String str) {
                try {
                    SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                } catch (Exception unused) {
                    Log.e(Log.TAG, new Object[0]);
                }
                NormalizeGuestAccountActivity.this.w.isAccountMerge = z;
                NormalizeGuestAccountActivity.this.w.setNormalizeWay(str);
                NormalizeGuestAccountActivity.this.w.setResultCode(0);
                NormalizeGuestAccountActivity.this.w.setResultMsg("成功");
                NormalizeGuestAccountActivity.this.e();
                new PtokenStat().onEvent(PtokenStat.NORMAL_GUEST);
            }
        }, str);
        setNewLoginTitleAndSetStyleChangeCallBack();
        this.sapiWebView.loadNormalizeGuestAccount(arrayList, this.x, this.y);
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

    /* access modifiers changed from: private */
    public void d() {
        if (CoreViewRouter.getInstance().getNormalizeGuestAccountCallback() != null) {
            CoreViewRouter.getInstance().getNormalizeGuestAccountCallback().onFailure(this.w);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }
}
