package com.baidu.wallet.newbindcard.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.x;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.SixNumberPwdView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;

public class NewCheckPwdActivity extends HalfProtocolScreenBaseActivity implements View.OnClickListener, SixNumberPwdView.OnPwdChangedListener {
    public static final String BIND_CARD_CHECK_PWD_HASH_ID = "paySDKInitiativeBindCardCheckPwdPage";
    public static final String BIND_CARD_CHECK_PWD_HASH_NAME = "验证密码/指纹/人脸页面";
    public static final String CHECK_FINGERPRINGT_STATUS = "checkFingerprintStatus";
    public SixNumberPwdView a;
    public TextView b;
    public TextView c;
    public View d;
    public boolean e = false;
    public RelativeLayout f;
    public SafeScrollView g;
    public SafeKeyBoardEditText h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3584i = 1;
    public final int j = 2;
    public String k;
    public int l = 0;

    private void d() {
        Intent intent = new Intent(this, NewBindCardMainActivity.class);
        intent.putExtra(NewBindCardMainActivity.BIND_CARD_NUMBER, this.k);
        startActivity(intent);
    }

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_new_check_pwd_activity"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void onBackPressed() {
        a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, "验密或指纹或人脸结果", a.a(), a.b(), "0", StatHelper.SENSOR_ERR_2, "NewCheckPwdActivity onBackPressed");
        finishWithoutAnim();
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
        WalletGlobalUtils.safeDismissDialog(this, 0);
        if (606 == i2) {
            a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, "验密或指纹或人脸结果", a.a(), a.b(), "0", i3 + "", str);
            c();
            if (i3 == 100015) {
                a(str, false);
            } else if (i3 == 100018) {
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(getActivity(), "ebpay_pass_locked_tip");
                }
                this.mDialogMsg = str;
                runOnUiThread(new Runnable() {
                    public void run() {
                        WalletGlobalUtils.safeShowDialog(NewCheckPwdActivity.this.mAct, 2, "");
                    }
                });
            } else {
                a(str);
            }
        }
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        WalletGlobalUtils.safeDismissDialog(this, 0);
        if (606 == i2) {
            a(PayStatServiceEvent.NEW_CHECK_PWD_RESULT, "验密或指纹或人脸结果", a.a(), a.b(), "0", "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            d();
            finishWithoutAnim();
        }
    }

    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.d) {
            a();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFlagActiveBindCard();
        EventBus.getInstance().register((Object) this, DxmPayBeanConstants.EVT_PAY_PWD_CHANGE, 0, EventBus.ThreadMode.MainThread);
        this.k = getIntent().getStringExtra(NewBindCardMainActivity.BIND_CARD_NUMBER);
        b(getIntent().getIntExtra(CHECK_FINGERPRINGT_STATUS, -1));
        a.c("0");
        a(PayStatServiceEvent.NEW_ENTER_CHECK_PWD_PAGE, "进入", a.a(), a.b(), "0");
    }

    public Dialog onCreateDialog(int i2) {
        if (i2 == 1 || i2 == 2) {
            return new PromptDialog(getActivity());
        }
        return super.onCreateDialog(i2);
    }

    public void onDestroy() {
        super.onDestroy();
        HashMap hashMap = new HashMap();
        hashMap.put("count", Integer.valueOf(this.l));
        this.l = 0;
        a.a(PayStatServiceEvent.NEW_CHECK_PWD_COUNT, hashMap, BIND_CARD_CHECK_PWD_HASH_NAME, BIND_CARD_CHECK_PWD_HASH_ID, "验密码或指纹或人脸的次数", a.a(), a.b(), "0");
        BeanManager.getInstance().removeAllBeans("NewCheckPwdActivity");
        if (this.e) {
            PasswordController.getPassWordInstance().clearForgetPasswdCallback();
        }
        EventBus.getInstance().unregister(this);
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event == null) {
            return;
        }
        if (DxmPayBeanConstants.EVT_PAY_PWD_CHANGE.equals(event.mEventKey)) {
            if (event.mEventObj != null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                    if (jSONObject.has("is_succeed") && 1 == jSONObject.getInt("is_succeed")) {
                        a(PayStatServiceEvent.NEW_CHECK_PWD_FIND_PWD_RESULT, "点击忘记密码，找回密码结果", a.a(), a.b(), "0", "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                        this.b.setVisibility(4);
                    }
                } catch (Exception e2) {
                    LogUtil.e("NewCheckPwdActivity", e2.getMessage(), e2);
                }
            }
        } else if ("ev_bean_execut_err_content".equals(event.mEventKey)) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                if (beanErrorContent != null) {
                    a(PayStatServiceEvent.NEW_CHECK_PWD_FIND_PWD_RESULT, "点击忘记密码，找回密码结果", a.a(), a.b(), "0", beanErrorContent.getRet() + "", beanErrorContent.getMsg());
                    onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                }
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
            }
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.hideTitle();
            promptDialog.hideNegativeButton();
            promptDialog.setMessage((CharSequence) this.mDialogMsg);
            promptDialog.setPositiveBtn(ResUtils.string(this.mAct, "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(NewCheckPwdActivity.this.mAct, 3);
                }
            });
        } else if (i2 == 1) {
            final PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage((CharSequence) ResUtils.getString(this.mAct, "ebpay_pwd_check_msg_for_halfscreen_pwd_verify"));
            promptDialog2.setTitleText(ResUtils.getString(this.mAct, "wallet_base_new_bind_card_check_pwd_tip"));
            promptDialog2.hideNegativeButton();
            a(PayStatServiceEvent.NEW_SHOW_WHAT_PWD_DIALOG, "点击什么是支付密码展示的弹窗", a.a(), a.b(), "0");
            promptDialog2.setPositiveBtn(ResUtils.getString(this.mAct, "ebpay_pwd_close_promotion_dialog"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    NewCheckPwdActivity.this.a(PayStatServiceEvent.NEW_CLICK_WHAT_PWD_DIALOG, "什么是支付密码展示的弹窗，点击我知道了", a.a(), a.b(), "0");
                    promptDialog2.dismiss();
                }
            });
        } else if (i2 == 2) {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage((CharSequence) this.mDialogMsg);
            promptDialog3.setCanceledOnTouchOutside(false);
            promptDialog3.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_find_password"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    NewCheckPwdActivity.this.a();
                    WalletGlobalUtils.safeDismissDialog(NewCheckPwdActivity.this, 2);
                }
            });
            promptDialog3.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(NewCheckPwdActivity.this, 2);
                }
            });
        } else {
            super.onPrepareDialog(i2, dialog);
        }
    }

    public void onPwdChanged(int i2) {
        if (i2 == 6) {
            this.l++;
            a(PayStatServiceEvent.NEW_CHECK_PWD, "输完密码或指纹验证或人脸验证", a.a(), a.b(), "0");
            b();
        } else if (i2 == 1) {
            a(ResUtils.getString(this, "wallet_base_new_bind_card_check_pwd_tip"), true);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.h.requestFocus();
        }
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    private void b(int i2) {
        this.mActionBar.setVisibility(0);
        this.f = (RelativeLayout) findViewById(R.id.new_bind_card_check_pwd_layout);
        this.a = (SixNumberPwdView) findViewById(R.id.new_pwd_input_box);
        TextView textView = (TextView) findViewById(R.id.new_error_tip);
        this.b = textView;
        AccessibilityUtils.changeRoleDescription(textView, ResUtils.getString(this, "wallet_access_button"));
        this.c = (TextView) findViewById(R.id.tv_check_pwd_tip);
        this.d = findViewById(R.id.new_forget_pwd);
        this.g = (SafeScrollView) findViewById(R.id.new_check_pwd_scrollview);
        SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.a.findViewById(ResUtils.id(getActivity(), "pwd_input"));
        this.h = safeKeyBoardEditText;
        safeKeyBoardEditText.initSafeKeyBoardParams(this.f, this.g, safeKeyBoardEditText, false);
        this.h.setGap(20);
        this.h.setDisablePast(true);
        this.a.addSixNumberPwdChangedListenter(this);
        setSafeScrollView(this.g);
        this.h.requestFocus();
        this.mLeftImg.setOnClickListener(this);
        a(ResUtils.getString(this, "wallet_base_new_bind_card_check_pwd_tip"), true);
        this.d.setOnClickListener(this);
    }

    private void c() {
        runOnUiThread(new Runnable() {
            public void run() {
                NewCheckPwdActivity.this.a.resetPwd();
            }
        });
    }

    /* access modifiers changed from: private */
    public void a() {
        String findPayPwdUrl = SdkInitResponse.getInstance().getFindPayPwdUrl(getActivity());
        if (TextUtils.isEmpty(findPayPwdUrl)) {
            findPayPwdUrl = DxmPayBeanConstants.API_FIND_PAY_PWD_URL;
        }
        a(PayStatServiceEvent.NEW_CHECK_PWD_FORGET_PWD, "点击忘记密码", a.a(), a.b(), "0");
        BaiduWalletDelegate.getInstance().openH5Module(getActivity(), findPayPwdUrl, false);
        this.e = true;
    }

    private void a(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                GlobalUtils.toast(NewCheckPwdActivity.this, str);
            }
        });
    }

    private void a(final String str, final boolean z) {
        runOnUiThread(new Runnable() {
            public void run() {
                NewCheckPwdActivity.this.b.setVisibility(0);
                NewCheckPwdActivity.this.b.setText(str);
                if (z) {
                    NewCheckPwdActivity.this.b.setTextColor(ResUtils.getColor(NewCheckPwdActivity.this, "wallet_cashdesk_new_bind_card_7BE6"));
                    NewCheckPwdActivity.this.b.setContentDescription(str);
                } else {
                    NewCheckPwdActivity.this.b.setTextColor(ResUtils.getColor(NewCheckPwdActivity.this, "dxm_wallet_fp_promtion_text"));
                    NewCheckPwdActivity.this.b.setContentDescription(ResUtils.getString(NewCheckPwdActivity.this, "wallet_access_password_des"));
                }
                NewCheckPwdActivity.this.b.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AnonymousClass4 r3 = AnonymousClass4.this;
                        if (z) {
                            WalletGlobalUtils.safeShowDialog(NewCheckPwdActivity.this.mAct, 1, "");
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String... strArr) {
        a.a(str, BIND_CARD_CHECK_PWD_HASH_NAME, BIND_CARD_CHECK_PWD_HASH_ID, str2, strArr);
    }

    private void b() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        x xVar = (x) PayBeanFactory.getInstance().getBean((Context) this, (int) PayBeanFactory.BEAN_ID_NEW_CHECK_PASSWORD, "NewCheckPwdActivity");
        xVar.a(true);
        xVar.b("");
        xVar.a(this.a.getPwd());
        xVar.setResponseCallback(this);
        xVar.execBean();
    }
}
