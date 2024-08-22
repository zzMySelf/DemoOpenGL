package com.baidu.wallet.paysdk.ui;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.SixNumberPwdView;
import com.dxmpay.wallet.core.utils.NFCUtil;

public abstract class PwdBaseActivity extends PayBaseActivity implements SixNumberPwdView.OnPwdChangedListener {
    public SixNumberPwdView a;
    public String extraFromH5;
    public boolean isOpenHalfScreenPwdVerify = false;
    public TextView mErrorTip;
    public View mForgetPasswd;
    public ImageView mLeftImageGoback;
    public PwdRequest mPwdRequest;
    public RelativeLayout mRootView;
    public SafeKeyBoardEditText mSafeEditText;
    public SafeScrollView mScrollView;
    public TextView mSubTip;
    public LinearLayout mSubTipWrap;
    public TextView mTip;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x001c
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0012 }
            r0.<init>(r3)     // Catch:{ JSONException -> 0x0012 }
            java.lang.String r3 = "half_screen_pwd_verify"
            java.lang.String r3 = r0.optString(r3)     // Catch:{ JSONException -> 0x0012 }
            goto L_0x001e
        L_0x0012:
            r3 = move-exception
            java.lang.String r0 = r3.getMessage()
            java.lang.String r1 = "PwdBaseActivity"
            com.dxmpay.wallet.core.utils.LogUtil.e(r1, r0, r3)
        L_0x001c:
            java.lang.String r3 = "false"
        L_0x001e:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x002e
            java.lang.String r0 = "true"
            boolean r3 = android.text.TextUtils.equals(r3, r0)
            if (r3 == 0) goto L_0x002e
            r3 = 1
            return r3
        L_0x002e:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.ui.PwdBaseActivity.a(java.lang.String):boolean");
    }

    public int getMobilePwdBeanId() {
        PwdRequest pwdRequest = this.mPwdRequest;
        if (pwdRequest != null && pwdRequest.mRequestType == 2) {
            return 257;
        }
        PwdRequest pwdRequest2 = this.mPwdRequest;
        return (pwdRequest2 == null || pwdRequest2.mRequestType != 3) ? PayBeanFactory.BEAN_ID_CHECK_MOBILE_PWD : PayBeanFactory.BEAN_ID_MODIFY_MOBILE_PWD;
    }

    public String getPwd() {
        return this.a.getPwd();
    }

    public void handleFailure(int i2, int i3, String str) {
        super.handleFailure(i2, i3, str);
    }

    public void handleResponse(int i2, Object obj, String str) {
    }

    public void hideErrorMsg() {
        this.mErrorTip.setVisibility(4);
    }

    public boolean isWindowNightMode() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        if (bundle != null) {
            this.mPwdRequest = (PwdRequest) bundle.getSerializable("mPwdRequest");
        } else {
            this.mPwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
        }
        if (this.mPwdRequest != null) {
            PayRequestCache.getInstance().addBeanRequestToCache(this.mPwdRequest.getRequestId(), this.mPwdRequest);
        }
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("half_screen_pwd_verify");
            this.extraFromH5 = stringExtra;
            this.isOpenHalfScreenPwdVerify = a(stringExtra);
        }
        if (this.isOpenHalfScreenPwdVerify) {
            setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_set_half_screen_pwd_activity"));
            this.mLeftImageGoback = (ImageView) findViewById(ResUtils.id(getActivity(), "pwd_left_img_goback"));
            this.mSubTipWrap = (LinearLayout) findViewById(ResUtils.id(getActivity(), "pwd_sub_tip_wrap"));
        } else {
            setContentView(ResUtils.layout(getActivity(), "wallet_cashdesk_set_pwd_activity"));
        }
        this.mTip = (TextView) findViewById(ResUtils.id(getActivity(), "pwd_tip"));
        this.mSubTip = (TextView) findViewById(ResUtils.id(getActivity(), "pwd_sub_tip"));
        this.a = (SixNumberPwdView) findViewById(ResUtils.id(getActivity(), "pwd_input_box"));
        this.mErrorTip = (TextView) findViewById(ResUtils.id(getActivity(), "error_tip"));
        this.mForgetPasswd = findViewById(ResUtils.id(getActivity(), "forget_pwd"));
        hideErrorMsg();
        this.mRootView = (RelativeLayout) findViewById(ResUtils.id(getActivity(), "root_view"));
        this.mScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
        SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.a.findViewById(ResUtils.id(getActivity(), "pwd_input"));
        this.mSafeEditText = safeKeyBoardEditText;
        safeKeyBoardEditText.initSafeKeyBoardParams(this.mRootView, this.mScrollView, safeKeyBoardEditText, false);
        this.mSafeEditText.setGap(20);
        this.mSafeEditText.setDisablePast(true);
        this.a.addSixNumberPwdChangedListenter(this);
        setSafeScrollView(this.mScrollView);
        this.mSafeEditText.requestFocus();
    }

    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("mPwdRequest", this.mPwdRequest);
    }

    public void resetPwd() {
        this.a.resetPwd();
    }

    public void showErrorMsg(String str) {
        this.mErrorTip.setVisibility(0);
        this.mErrorTip.setText(str);
    }
}
