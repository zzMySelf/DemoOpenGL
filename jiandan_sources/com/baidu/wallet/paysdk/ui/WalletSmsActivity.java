package com.baidu.wallet.paysdk.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.sms.controller.ISmsController;
import com.baidu.wallet.paysdk.sms.controller.SmsVerifyHandler;
import com.baidu.wallet.paysdk.sms.controller.c;
import com.baidu.wallet.paysdk.sms.controller.e;
import com.baidu.wallet.paysdk.sms.controller.f;
import com.baidu.wallet.paysdk.sms.controller.g;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.IdentifyCodeGetFailDialog;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.LoadingDialog;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.dialog.listener.DelegateOnDismissListener;
import com.dxmpay.wallet.base.widget.textfilter.BlankCharEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.NumberEditTextPasteFilter;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.SDKBaseActivity;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WalletSmsActivity extends PayBaseActivity implements View.OnClickListener, SmsVerifyHandler {
    public static final String PAY_SMS_HASH_ID = "paySDKSmsPayPage";
    public static final String PAY_SMS_HASH_NAME = "验证短信页面";
    public int A = 0;
    public boolean B = false;
    public boolean C = false;
    public String D;
    public Context a;
    public int b = -1;
    public SafeKeyBoardEditText c;
    public SafeScrollView d;
    public ViewGroup e;
    public Button f;
    public TextView g;
    public TextView h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f3623i;
    public View j;
    public TextView k;
    public Animation l;
    public Animation m;
    public ISmsController mController;
    public boolean mHasVerifyCodeSend = false;
    public TextView mHelp;
    public Button mSendSms;
    public CountDownTimer mTimer;
    public TextView mTopPhoneTip;
    public int n;

    /* renamed from: o  reason: collision with root package name */
    public int f3624o;
    public TextView p;
    public TextView q;
    public boolean r = false;
    public String s;
    public Bundle t;
    public View u;
    public LinearLayout v;
    public int w = 4;
    public boolean x = true;
    public String y;
    public String z;

    public void clearSmsEditText() {
        this.c.setText("");
        this.c.requestFocus();
        this.f3623i.setVisibility(8);
    }

    public void doStartCountDown() {
        startCountDown();
    }

    public void doStopCountDown() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        this.mSendSms.setText(ResUtils.getString(getActivity(), "ebpay_get_sms_code"));
        this.mSendSms.setTextSize(1, 11.0f);
        this.mSendSms.setEnabled(true);
    }

    public void finish() {
        d();
        super.finish();
        BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
    }

    public void finishWithoutAnim() {
        LinearLayout linearLayout = this.v;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        d();
        super.finishWithoutAnim();
        BaiduWalletUtils.overridePendingTransitionNoAnim(getActivity());
    }

    public SDKBaseActivity.BottomBarType getBottomBarType() {
        return SDKBaseActivity.BottomBarType.NONE;
    }

    public ISmsController getController(int i2) {
        return g.a(i2);
    }

    public void handleFailure(int i2, int i3, String str) {
        WalletGlobalUtils.safeDismissDialog(this, 0);
        ISmsController iSmsController = this.mController;
        if (iSmsController == null || !iSmsController.handleFailure(i2, i3, str)) {
            super.handleFailure(i2, i3, str);
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        ISmsController iSmsController = this.mController;
        if (iSmsController == null || !iSmsController.handleResponse(i2, obj, str)) {
            super.handleResponse(i2, obj, str);
        }
    }

    public void initSMSActivityView(String str, String str2, String str3, String str4, boolean z2) {
        this.v.setVisibility(0);
        this.k.setText(ResUtils.string(this.a, str));
        setPhoneNum(str4);
        if (TextUtils.isEmpty(str2)) {
            this.h.setVisibility(8);
        } else {
            this.h.setText(str2);
            this.h.setVisibility(0);
        }
        this.D = str3;
        updateButtonTip(str3);
        if (!this.x) {
            this.v.setVisibility(8);
        }
    }

    public boolean isBindPay() {
        ISmsController iSmsController = this.mController;
        if (iSmsController == null || !(iSmsController instanceof c)) {
            return super.isBindPay();
        }
        return ((c) iSmsController).a();
    }

    public void onBackPressed() {
        if (this.b == 8) {
            WalletGlobalUtils.safeShowDialog(this, 18, "");
            return;
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (payRequest != null) {
            payRequest.clearMktSolution();
        }
        e();
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        ErrorContentResponse.Guidance guidance;
        WalletGlobalUtils.safeDismissDialog(this, 0);
        ErrorContentResponse errorContentResponse = (obj == null || !(obj instanceof ErrorContentResponse)) ? null : (ErrorContentResponse) obj;
        ISmsController iSmsController = this.mController;
        if (iSmsController != null && iSmsController.doOnBeanExecFailureWithErrContent(i2, i3, str, obj)) {
            return;
        }
        if (i3 != 51000 || errorContentResponse == null || (guidance = errorContentResponse.guidance) == null) {
            super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
            return;
        }
        this.mGuidance = guidance;
        this.mPayErrorCode = i3;
        this.mBeanId = i2;
        if (guidance != null) {
            WalletGlobalUtils.safeShowDialog(this, 53, "");
        } else {
            super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
        }
    }

    public void onClick(View view) {
        if (view == this.f3623i) {
            clearSmsEditText();
        } else if (view == this.mSendSms) {
            StatHelper.statPayAllServiceEvent("getSmsCode", PAY_SMS_HASH_NAME, PAY_SMS_HASH_ID, "点击重新发送短信", new String[0]);
            b(false);
        } else if (view == this.f) {
            if (!CheckUtils.isFastDoubleClick()) {
                if (!this.mHasVerifyCodeSend) {
                    a((CharSequence) ResUtils.getString(getActivity(), "ebpay_sms_tips_get_code_first"));
                } else if (!a(this.c.getText().toString())) {
                    GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "ebpay_error_cer"));
                    this.c.requestFocus();
                } else {
                    ISmsController iSmsController = this.mController;
                    if (iSmsController != null) {
                        iSmsController.onNextBtnClick(this.c.getText().toString());
                    }
                }
            }
        } else if (view == this.mHelp) {
            StatHelper.statServiceEvent("clickVcodeTip");
            WalletGlobalUtils.safeShowDialog(this, 23, "");
        } else if (view == this.j) {
            e();
        }
    }

    @SuppressLint({"UseCheckPermission"})
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setIsShowMultiWindowTips(true);
        this.a = getActivity();
        this.t = bundle;
        if (bundle == null) {
            this.b = getIntent().getIntExtra(DxmPayBeanConstants.SMS_ACTIVITY_FROM_KEY, -1);
            this.A = getIntent().getIntExtra("reasonForChangeCardItem", -1);
            str = getIntent().getStringExtra(DxmPayBeanConstants.UPDATE_COMPLIANCE_TIP);
            this.z = getIntent().getStringExtra(DxmPayBeanConstants.UNABLE_RECEIVE_SMSTIP);
        } else {
            this.b = bundle.getInt("SMS_FROM");
            this.A = bundle.getInt("reasonForChangeCardItem");
            String string = bundle.getString(DxmPayBeanConstants.UPDATE_COMPLIANCE_TIP, (String) null);
            this.z = bundle.getString(DxmPayBeanConstants.UNABLE_RECEIVE_SMSTIP, (String) null);
            str = string;
        }
        setContentView(ResUtils.layout(this.a, "wallet_base_sms"));
        b();
        a();
        a(this.b, getIntent().getBooleanExtra(DxmPayBeanConstants.KEY_SEND_SMS_AUTO, false));
        updateComplianceTipUI(str);
    }

    public Dialog onCreateDialog(int i2) {
        if (i2 == 23) {
            return new IdentifyCodeGetFailDialog(this.a);
        }
        ISmsController iSmsController = this.mController;
        if (iSmsController == null) {
            return super.onCreateDialog(i2);
        }
        Dialog doOnCreateDialog = iSmsController.doOnCreateDialog(i2);
        if (doOnCreateDialog != null) {
            return doOnCreateDialog;
        }
        return super.onCreateDialog(i2);
    }

    public void onDestroy() {
        if (this.b == 1 || b.a()) {
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_SMS_DURATION, (Map<String, Object>) null, new String[0]);
        }
        ISmsController iSmsController = this.mController;
        if (iSmsController != null) {
            iSmsController.doOnDestroy();
        }
        d();
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans(ISmsController.BEAN_TAG);
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        this.mController = null;
    }

    public void onNegativeBtnClick() {
        if (PayDataCache.getInstance().isFromPreCashier()) {
            PayCallBackManager.callBackClientCancel(this, "click notice");
        } else if (BaseActivity.tasksIsExistActivityWithActivityName(OrderConfirmActivity.class)) {
            BaseActivity.clearTasksWithActivityName(OrderConfirmActivity.class);
        } else {
            finishWithoutAnim();
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        a(intent);
        a(this.b, intent.getBooleanExtra(DxmPayBeanConstants.KEY_SEND_SMS_AUTO, false));
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        String str;
        if (i2 == 23) {
            final IdentifyCodeGetFailDialog identifyCodeGetFailDialog = (IdentifyCodeGetFailDialog) dialog;
            identifyCodeGetFailDialog.setModifyMobileDesc(this.y);
            identifyCodeGetFailDialog.setNegativeBtn(ResUtils.getString(this.a, "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.SMS_INFO_CONFIRM);
                    identifyCodeGetFailDialog.dismiss();
                }
            });
            if (!TextUtils.isEmpty(this.z)) {
                str = this.z;
            } else {
                str = ResUtils.getString(this.a, "ebpay_contact_kefu");
            }
            identifyCodeGetFailDialog.setPositiveBtn(str, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(WalletSmsActivity.this.z)) {
                        StatHelper.statPayAllServiceEvent(PayStatServiceEvent.SMS_NOT_RECEIVE, WalletSmsActivity.PAY_SMS_HASH_NAME, WalletSmsActivity.PAY_SMS_HASH_ID, "点击仍然收不到", new String[0]);
                        WalletSmsActivity.this.b(true);
                        identifyCodeGetFailDialog.dismiss();
                        return;
                    }
                    StatHelper.statServiceEvent(PayStatServiceEvent.SMS_INFO_KEFU);
                    try {
                        String kefuPhoneNum = BdWalletUtils.getKefuPhoneNum(WalletSmsActivity.this.a);
                        WalletSmsActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + kefuPhoneNum)));
                    } catch (Exception e) {
                        LogUtil.e(ISmsController.BEAN_TAG, e.getMessage(), e);
                    }
                }
            });
        } else if (this.mController != null) {
            if (!(dialog instanceof LoadingDialog)) {
                try {
                    if (this.l == null) {
                        this.l = AnimationUtils.loadAnimation(this, this.n);
                    }
                    this.d.setAlwaysShowSoftKeyBoard(false);
                    this.d.startAnimation(this.l);
                } catch (Resources.NotFoundException unused) {
                }
                dialog.setOnDismissListener(new DelegateOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        try {
                            if (WalletSmsActivity.this.m == null) {
                                Animation unused = WalletSmsActivity.this.m = AnimationUtils.loadAnimation(WalletSmsActivity.this.getActivity(), WalletSmsActivity.this.f3624o);
                            }
                            WalletSmsActivity.this.d.setAlwaysShowSoftKeyBoard(true);
                            WalletSmsActivity.this.d.startAnimation(WalletSmsActivity.this.m);
                        } catch (Resources.NotFoundException unused2) {
                        }
                    }
                }));
            }
            if (!this.mController.doOnPrepareDialog(i2, dialog)) {
                super.onPrepareDialog(i2, dialog);
            }
        }
    }

    public void onResume() {
        super.onResume();
        SafeKeyBoardEditText safeKeyBoardEditText = this.c;
        if (safeKeyBoardEditText != null) {
            safeKeyBoardEditText.requestFocus();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        ISmsController iSmsController = this.mController;
        if (iSmsController != null) {
            iSmsController.doOnSaveInstanceState(bundle);
        }
        bundle.putInt("SMS_FROM", this.b);
        super.onSaveInstanceState(bundle);
    }

    public void onSmsSendFailure(int i2, CharSequence charSequence) {
        GlobalUtils.toast(this, charSequence);
        a(i2 + "", charSequence.toString());
    }

    public void onSmsSendSuccess() {
        a("0", StatHelper.SENSOR_OK);
    }

    public void onSmsVerifyFailure(int i2, CharSequence charSequence) {
        a(i2 + "", charSequence.toString());
        if (TextUtils.isEmpty(this.s)) {
            this.s = ResUtils.getString(this, "ebpay_verify_fail");
        }
        a(charSequence);
    }

    public void onSmsVerifySuccess() {
        a("0", StatHelper.SENSOR_OK);
    }

    public void setPhoneNum(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.g.setText(StringUtils.maskingPhoneNumber(str));
        } else {
            this.g.setText("");
        }
    }

    public void showPaySuccessPage(boolean z2, PayResultContent payResultContent, int i2) {
        if (z2) {
            PayController.getInstance().paySucess(this, payResultContent, i2);
        } else {
            PayController.getInstance().payPaying(this, payResultContent, i2);
        }
    }

    public void startCountDown() {
        this.mHasVerifyCodeSend = true;
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        AnonymousClass3 r1 = new CountDownTimer(60000, 1000) {
            public void onFinish() {
                WalletSmsActivity walletSmsActivity = WalletSmsActivity.this;
                walletSmsActivity.mSendSms.setText(ResUtils.getString(walletSmsActivity.getActivity(), "ebpay_get_sms_code"));
                WalletSmsActivity.this.mSendSms.setTextSize(1, 11.0f);
                WalletSmsActivity.this.mSendSms.setEnabled(true);
            }

            public void onTick(long j) {
                WalletSmsActivity.this.mSendSms.setEnabled(false);
                WalletSmsActivity.this.mSendSms.setTextSize(1, 11.0f);
                WalletSmsActivity walletSmsActivity = WalletSmsActivity.this;
                walletSmsActivity.mSendSms.setText(String.format(ResUtils.getString(walletSmsActivity.getActivity(), "ebpay_resend"), new Object[]{Integer.valueOf((int) (j / 1000))}));
            }
        };
        this.mTimer = r1;
        r1.start();
        this.mSendSms.setEnabled(false);
    }

    public void unableReceiveSmsTip(String str) {
        this.z = str;
    }

    public void upDateSafeKeyBoradView(String str, String str2) {
        int i2;
        if (this.c != null) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    i2 = Integer.parseInt(str2);
                } catch (Exception unused) {
                    StatisticManager.onEvent("smsStyleNull");
                    i2 = 0;
                }
                StatHelper.statServiceEvent("smsStyle", (Map<String, Object>) null, str2 + "");
            } else {
                i2 = 0;
            }
            int i3 = 10;
            if (!TextUtils.isEmpty(str)) {
                try {
                    i3 = Integer.parseInt(str);
                    this.w = i3;
                } catch (Exception unused2) {
                    StatisticManager.onEvent("smsLengthNull");
                }
                StatHelper.statServiceEvent("smsLength", (Map<String, Object>) null, str + "");
            }
            if (i2 == 0) {
                this.c.setInputType(2);
                getWindow().setSoftInputMode(2);
                this.c.setUseSafeKeyBoard(true);
                this.c.initSafeKeyBoardParams(this.e, this.d, this.mHelp, true);
                this.d.setAlwaysShowSoftKeyBoard(true);
                List<IEditTextPasteFilter> editTextPasteFilters = this.c.getEditTextPasteFilters();
                if (editTextPasteFilters != null) {
                    editTextPasteFilters.clear();
                    editTextPasteFilters.add(new NumberEditTextPasteFilter());
                }
            } else {
                this.c.setInputType(1);
                List<IEditTextPasteFilter> editTextPasteFilters2 = this.c.getEditTextPasteFilters();
                if (editTextPasteFilters2 != null) {
                    editTextPasteFilters2.clear();
                    editTextPasteFilters2.add(new BlankCharEditTextPasteFilter());
                }
                getWindow().setSoftInputMode(4);
                this.c.initSafeKeyBoardParams(this.e, this.d, this.mHelp, true);
            }
            this.c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i3)});
        }
    }

    public void updateButtonTip(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str)) {
            this.D = str;
            if (this.C && (split = str.split("\\d")) != null && split.length > 0 && !TextUtils.isEmpty(split[0]) && split[0].length() > 0) {
                str = str.replaceFirst(str.substring(0, split[0].length()), ResUtils.getString(this.a, "wallet_base_auth_confirm_pay"));
            }
            this.f.setText(str);
        }
    }

    public void updateComplianceTipUI(String str) {
        if (!TextUtils.isEmpty(str) && !this.B) {
            this.C = true;
            updateButtonTip(this.D);
            this.q.setVisibility(0);
            this.q.setText(str);
        }
    }

    public void updateModifyPhoneUI(boolean z2, CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.y = charSequence.toString();
        }
    }

    private void b() {
        this.e = (ViewGroup) findViewById(ResUtils.id(this.a, "root_view"));
        this.d = (SafeScrollView) findViewById(ResUtils.id(this.a, "scrollview"));
        this.g = (TextView) findViewById(ResUtils.id(this.a, "ebpay_sms_moblie"));
        this.mTopPhoneTip = (TextView) findViewById(ResUtils.id(this.a, "ebpay_tip_top"));
        this.c = (SafeKeyBoardEditText) findViewById(ResUtils.id(this.a, "ebpay_message_vcode_id"));
        this.f3623i = (ImageView) findViewById(ResUtils.id(this.a, "wallet_sms_clear"));
        this.mSendSms = (Button) findViewById(ResUtils.id(this.a, "ebpay_sms_sendsms"));
        TextView textView = (TextView) findViewById(ResUtils.id(this.a, "ebpay_tip_bottom_right"));
        this.mHelp = textView;
        AccessibilityUtils.changeRoleDescription(textView, ResUtils.getString(this, "wallet_access_button"));
        this.h = (TextView) findViewById(ResUtils.id(this.a, "ebpay_top_tip"));
        this.f = (Button) findViewById(ResUtils.id(this.a, "ebpay_next_btn"));
        this.v = (LinearLayout) findViewById(ResUtils.id(getActivity(), "lin_sms_dialog"));
        this.q = (TextView) findViewById(ResUtils.id(getActivity(), "ebpay_protocol_text"));
        SafeScrollView safeScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
        this.d = safeScrollView;
        this.c.initSafeKeyBoardParams(this.e, safeScrollView, this.mHelp, false);
        this.c.setUseSafeKeyBoard(true);
        this.f3623i.setOnClickListener(this);
        this.mSendSms.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.mHelp.setOnClickListener(this);
        this.c.addTextChangedListener(new TextWatcher() {
            public boolean b = false;

            public void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(editable.toString())) {
                    WalletSmsActivity.this.f3623i.setVisibility(0);
                } else {
                    WalletSmsActivity.this.f3623i.setVisibility(8);
                }
                WalletSmsActivity.this.f.setEnabled(WalletSmsActivity.this.a(editable.toString()));
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (!this.b) {
                    ISmsController iSmsController = WalletSmsActivity.this.mController;
                    if (iSmsController != null) {
                        iSmsController.doOnEvent();
                    }
                    this.b = true;
                }
                WalletSmsActivity.this.c();
            }
        });
        View findViewById = findViewById(ResUtils.id(this.a, "dialog_close"));
        this.j = findViewById;
        findViewById.setOnClickListener(this);
        this.k = (TextView) findViewById(ResUtils.id(this.a, "dialog_title"));
        this.n = ResUtils.anim(this, "wallet_dialog_slide_to_left");
        this.f3624o = ResUtils.anim(this, "wallet_dialog_slide_to_right");
        this.p = (TextView) findViewById(ResUtils.id(this, "ebpay_error_tip"));
        View findViewById2 = findViewById(ResUtils.id(this, "ebpay_sms_line_info"));
        this.u = findViewById2;
        findViewById2.setBackgroundColor(Color.parseColor("#54576A"));
        setSafeScrollView(this.d);
        a(getIntent());
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.r) {
            this.u.setBackgroundColor(Color.parseColor("#54576A"));
            this.p.setVisibility(4);
            this.r = false;
        }
    }

    private void d() {
        SafeScrollView safeScrollView = this.d;
        if (safeScrollView != null && safeScrollView.isPopupWindowShowing()) {
            this.d.dismissKeyBoard(this.c);
        }
    }

    private void e() {
        LinkedList<BaseActivity> linkedList;
        a(StatHelper.SENSOR_ERR_2, "paySMSCancel");
        StatHelper.statPayAllServiceEvent(StatServiceEvent.EVENT_CLOSE_FROM_SMS_VERIFY, PAY_SMS_HASH_NAME, PAY_SMS_HASH_ID, "点击关闭短信页面", new String[0]);
        if (PayDataCache.getInstance().isFromPreCashier()) {
            StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_DURATION, (Map<String, Object>) null, new String[0]);
            if (PayRequestCache.getInstance().isPaying() && (linkedList = BaseActivity.mActivityStack) != null && linkedList.size() == 1) {
                PayCallBackManager.callBackClientCancel(this.a, "closeWalletSmsActivity");
            }
        }
        finishWithoutAnim();
    }

    private void a() {
        GetCardInfoResponse.ProtocolPlatformItem[] protocolPlatformItemArr;
        int i2;
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        CardData.BondCard selectCard = PayRequestCache.getInstance().getSelectCard();
        if (selectCard == null) {
            return;
        }
        if ((this.b != 0 || (i2 = this.A) == 1 || i2 == 2) && !b.a()) {
            String str = selectCard.bank_code;
            if (payResponse != null && payResponse.protocol_platform_info != null) {
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str) && (protocolPlatformItemArr = payResponse.protocol_platform_info.ext_list) != null && protocolPlatformItemArr.length > 0) {
                    for (GetCardInfoResponse.ProtocolPlatformItem protocolPlatformItem : protocolPlatformItemArr) {
                        if (str.equals(protocolPlatformItem.front_bank_code)) {
                            arrayList.add(protocolPlatformItem);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    a(payResponse.protocol_platform_info, selectCard);
                }
            }
        }
    }

    private void a(final GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo, final CardData.BondCard bondCard) {
        final DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (protocolPlatformInfo == null || TextUtils.isEmpty(protocolPlatformInfo.prefix) || TextUtils.isEmpty(protocolPlatformInfo.main_title)) {
            this.q.setVisibility(8);
            return;
        }
        this.B = true;
        this.q.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int color = ResUtils.getColor(getActivity(), "wallet_base_font_868e9e");
        spannableStringBuilder.append(protocolPlatformInfo.prefix + " ");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, protocolPlatformInfo.prefix.length(), 33);
        spannableStringBuilder.append("《");
        spannableStringBuilder.append(protocolPlatformInfo.main_title);
        spannableStringBuilder.append("》");
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                String str;
                String str2;
                UserData.UserModel userModel;
                String str3;
                UserData.UserModel userModel2;
                String str4;
                UserData.UserModel userModel3;
                String str5;
                if (!CheckUtils.isFastDoubleClick()) {
                    StatHelper.statServiceEvent(StatServiceEvent.SMS_PROTOCOL_CLICK);
                    Intent intent = new Intent(WalletSmsActivity.this.getActivity(), BindCardProtocolActivity.class);
                    intent.putExtra(BindCardProtocolActivity.PROTOCOL_DATA, protocolPlatformInfo);
                    DirectPayContentResponse directPayContentResponse = payResponse;
                    if (!(directPayContentResponse == null || (userModel3 = directPayContentResponse.user) == null || (str5 = userModel3.true_name) == null)) {
                        intent.putExtra("true_name", str5);
                    }
                    DirectPayContentResponse directPayContentResponse2 = payResponse;
                    if (!(directPayContentResponse2 == null || (userModel2 = directPayContentResponse2.user) == null || (str4 = userModel2.certificate_type) == null)) {
                        intent.putExtra(BindCardProtocolActivity.IDENTITY_TYPE, str4);
                    }
                    DirectPayContentResponse directPayContentResponse3 = payResponse;
                    if (!(directPayContentResponse3 == null || (userModel = directPayContentResponse3.user) == null || (str3 = userModel.certificate_code) == null)) {
                        intent.putExtra("identity_code", str3);
                    }
                    intent.putExtra("mobile", WalletSmsActivity.this.g.getText().toString());
                    CardData.BondCard bondCard = bondCard;
                    if (!(bondCard == null || (str2 = bondCard.bank_code) == null)) {
                        intent.putExtra(BindCardProtocolActivity.BANK_CODE, str2);
                    }
                    CardData.BondCard bondCard2 = bondCard;
                    if (!(bondCard2 == null || (str = bondCard2.account_no) == null)) {
                        intent.putExtra("card_no", str);
                    }
                    WalletSmsActivity.this.startActivityWithoutAnim(intent);
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ResUtils.getColor(WalletSmsActivity.this.getActivity(), "dxm_wallet_base_color_clickable"));
            }
        }, protocolPlatformInfo.prefix.length(), spannableStringBuilder.length(), 33);
        this.q.setEnabled(true);
        this.q.setMovementMethod(LinkMovementMethod.getInstance());
        this.q.setHintTextColor(-1);
        this.q.setHighlightColor(getResources().getColor(17170445));
        this.q.setBackgroundColor(-1);
        this.q.setText(spannableStringBuilder);
        String str = (TextUtils.isEmpty(protocolPlatformInfo.main_title) || (!protocolPlatformInfo.main_title.endsWith("协议") && !protocolPlatformInfo.main_title.endsWith("协议》"))) ? "协议详情" : "详情";
        TextView textView = this.q;
        textView.setContentDescription("查看" + protocolPlatformInfo.main_title + str);
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        clearSmsEditText();
        startCountDown();
        a(z2);
        c();
    }

    private void a(int i2, boolean z2) {
        this.x = getIntent().getBooleanExtra("showSMSDialog", true);
        this.mController = getController(i2);
        PayRequestCache.BindCategory bindCategoryByIntent = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
        getBindCardFlagDelegate().a((BindFastRequest) PayRequestCache.getInstance().getRequest(bindCategoryByIntent));
        ISmsController iSmsController = this.mController;
        if (iSmsController == null) {
            finish();
            return;
        }
        if (iSmsController instanceof c) {
            c cVar = (c) iSmsController;
            PayRequestCache.BindCategory bindCategoryByIntent2 = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
            cVar.a(bindCategoryByIntent2);
            cVar.a((BindFastRequest) PayRequestCache.getInstance().getRequest(bindCategoryByIntent2));
        }
        this.mController.setSmsUpdateUIInterface(this);
        this.mController.setSmsVerifyHandler(this);
        this.mController.setActivity(this);
        if (this.mController.onCreateCheckInvalide(this.t)) {
            if (this.mController.isBelongPaySDK()) {
                setFlagPaySdk();
            }
            this.mController.initSmsActivityView();
            ISmsController iSmsController2 = this.mController;
            if (!(iSmsController2 instanceof f) && !(iSmsController2 instanceof e)) {
                clearSmsEditText();
                startCountDown();
            }
            if (this.mController.isSendSmsOnCreate() || z2) {
                stopCountDown();
                a(false);
            }
            if (i2 == 7) {
                setFlagActiveBindCard();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.length() >= this.w;
    }

    private void a(Intent intent) {
        int intExtra = intent.getIntExtra(DxmPayBeanConstants.KEY_THE_REASON_FOR_SENDING, Integer.MIN_VALUE);
        String stringExtra = intent.getStringExtra(DxmPayBeanConstants.KEY_SMS_HINT);
        if (intExtra == 5320 && !TextUtils.isEmpty(stringExtra)) {
            this.mTopPhoneTip.setText(stringExtra);
        }
    }

    private void a(boolean z2) {
        ISmsController iSmsController = this.mController;
        if (iSmsController != null) {
            iSmsController.sendSms(z2);
        }
    }

    private void a(String str, String str2) {
        if (this.b == 1 || b.a()) {
            StatHelper.cacheCodeAndMsg(str, str2);
        }
    }

    private void a(CharSequence charSequence) {
        this.u.setBackgroundColor(Color.parseColor("#FA5050"));
        this.p.setText(charSequence);
        this.p.setVisibility(0);
        this.r = true;
    }
}
