package com.baidu.wallet.paysdk.fingerprint.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.newbindcard.ui.NewCheckPwdActivity;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.x;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.fingerprint.b;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import java.util.HashMap;

public class DxmCheckFingerprintActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public ImageView a;
    public TextView b;
    public int c;
    public int d = 0;
    public String e = "";

    public static /* synthetic */ int a(DxmCheckFingerprintActivity dxmCheckFingerprintActivity) {
        int i2 = dxmCheckFingerprintActivity.d;
        dxmCheckFingerprintActivity.d = i2 + 1;
        return i2;
    }

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_new_check_fingerprint_activity"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void onBackPressed() {
        a(-203, "");
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
        WalletGlobalUtils.safeDismissDialog(this, 0);
        if (i2 == 606) {
            a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, "验密或指纹或人脸结果", a.a(), a.b(), "1", i3 + "", str);
            a(3001, str);
        }
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        WalletGlobalUtils.safeDismissDialog(this, 0);
        if (i2 == 606) {
            a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, "验密或指纹或人脸结果", a.a(), a.b(), "1", "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            com.baidu.wallet.paysdk.fingerprint.a.a.a().a(0, obj != null ? obj.toString() : "");
            finishWithoutAnim();
        }
    }

    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.a) {
            a();
        } else if (view == this.mRightTxt) {
            a(PayStatServiceEvent.NEW_SWITCH_PWD, "验证指纹/Face ID页面点击右上角“支付密码验证”", a.a(), a.b(), "1");
            a((int) AuthApiStatusCodes.AUTH_API_CLIENT_ERROR, "");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.c("1");
        int intExtra = getIntent().getIntExtra("showSwitchPwd", 0);
        int intExtra2 = getIntent().getIntExtra("checkTimes", 3);
        this.c = intExtra2;
        if (intExtra2 < 1) {
            this.c = 3;
        }
        this.e = getIntent().getStringExtra("session_id");
        b(intExtra);
        a(PayStatServiceEvent.NEW_ENTER_CHECK_PWD_PAGE, "进入", a.a(), a.b(), "1");
    }

    public void onDestroy() {
        super.onDestroy();
        HashMap hashMap = new HashMap();
        hashMap.put("count", Integer.valueOf(this.d));
        a.a(PayStatServiceEvent.NEW_CHECK_PWD_COUNT, hashMap, NewCheckPwdActivity.BIND_CARD_CHECK_PWD_HASH_NAME, NewCheckPwdActivity.BIND_CARD_CHECK_PWD_HASH_ID, "验密码或指纹或人脸的次数", a.a(), a.b(), "1");
        this.d = 0;
        BeanManager.getInstance().removeAllBeans("NewCheckFingerprintActivity");
    }

    public void onPause() {
        super.onPause();
        WalletFingerprint.getInstance(this).cancleListening();
    }

    public void onResume() {
        super.onResume();
        a();
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    private void b(int i2) {
        showLikeLoadingPage(false);
        this.mHalfScreenContainer.setBackgroundResource(R.drawable.wallet_base_half_screen_container_round_bg);
        this.mRightTxt.setText("支付密码验证");
        this.mRightTxt.setTextSize(2, 15.0f);
        this.mRightTxt.setTextColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_7BE6"));
        this.a = (ImageView) findViewById(R.id.iv_fingerprint_icon);
        TextView textView = (TextView) findViewById(R.id.tv_fingerprint_error_tip);
        this.b = textView;
        textView.setVisibility(8);
        if (i2 == 0) {
            this.mRightTxt.setVisibility(8);
        } else {
            this.mRightTxt.setVisibility(0);
        }
        this.mLeftImg.setImageResource(R.drawable.wallet_base_halfscreen_new_bind_card_actionbar_close);
        this.mLeftImg.setOnClickListener(this);
        this.mRightTxt.setTypeface(Typeface.defaultFromStyle(1));
        this.a.setOnClickListener(this);
        this.mRightTxt.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void a() {
        WalletFingerprint.getInstance(this).startListening(new b() {
            public void a(int i2, String str) {
                DxmCheckFingerprintActivity.this.a(PayStatServiceEvent.NEW_CHECK_PWD, "输完密码或指纹验证或人脸验证", a.a(), a.b(), "0");
                DxmCheckFingerprintActivity.a(DxmCheckFingerprintActivity.this);
                if (i2 == 0) {
                    DxmCheckFingerprintActivity.this.a(str);
                } else if (i2 == -8) {
                    WalletFingerprint.getInstance(DxmCheckFingerprintActivity.this).cancleListening();
                } else {
                    DxmCheckFingerprintActivity dxmCheckFingerprintActivity = DxmCheckFingerprintActivity.this;
                    dxmCheckFingerprintActivity.a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, "验密或指纹或人脸结果", a.a(), a.b(), "1", i2 + "", str);
                    DxmCheckFingerprintActivity.this.a(i2, "");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        x xVar = (x) PayBeanFactory.getInstance().getBean((Context) this, (int) PayBeanFactory.BEAN_ID_NEW_CHECK_PASSWORD, "NewCheckFingerprintActivity");
        xVar.a(false);
        xVar.b(str);
        xVar.a("");
        xVar.c(this.e);
        xVar.setResponseCallback(this);
        xVar.execBean();
    }

    /* access modifiers changed from: private */
    public void a(final int i2, final String str) {
        if (i2 == 0 || i2 == 3002 || i2 == -203 || i2 == -1 || i2 == -6 || i2 == -2 || i2 == -7) {
            if (i2 == -1) {
                i2 = 3007;
            } else if (i2 == -6) {
                i2 = 3008;
            } else if (i2 == -2 || i2 == -7) {
                i2 = 3009;
            }
            this.b.setVisibility(8);
            com.baidu.wallet.paysdk.fingerprint.a.a.a().a(i2, str);
            finishWithoutAnim();
            return;
        }
        runOnUiThread(new Runnable() {
            public void run() {
                String str = str;
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(DxmCheckFingerprintActivity.this, "wallet_fp_error_fp");
                }
                DxmCheckFingerprintActivity.this.b.setVisibility(0);
                DxmCheckFingerprintActivity.this.b.setText(str);
                TranslateAnimation translateAnimation = new TranslateAnimation(-50.0f, 50.0f, 0.0f, 0.0f);
                translateAnimation.setDuration(50);
                translateAnimation.setRepeatCount(1);
                translateAnimation.setRepeatMode(2);
                DxmCheckFingerprintActivity.this.b.startAnimation(translateAnimation);
                if (DxmCheckFingerprintActivity.this.d >= DxmCheckFingerprintActivity.this.c) {
                    int i2 = i2;
                    if (i2 == -5) {
                        i2 = AuthApiStatusCodes.AUTH_URL_RESOLUTION;
                    } else if (i2 == -3) {
                        i2 = AuthApiStatusCodes.AUTH_APP_CERT_ERROR;
                    } else if (i2 == -4) {
                        i2 = 3008;
                    }
                    com.baidu.wallet.paysdk.fingerprint.a.a.a().a(i2, str);
                    DxmCheckFingerprintActivity.this.finishWithoutAnim();
                } else if (i2 == 3001) {
                    DxmCheckFingerprintActivity.this.a();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String... strArr) {
        a.a(str, NewCheckPwdActivity.BIND_CARD_CHECK_PWD_HASH_NAME, NewCheckPwdActivity.BIND_CARD_CHECK_PWD_HASH_ID, str2, strArr);
    }
}
