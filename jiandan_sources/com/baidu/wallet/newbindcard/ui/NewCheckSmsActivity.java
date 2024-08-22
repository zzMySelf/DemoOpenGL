package com.baidu.wallet.newbindcard.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ag;
import com.baidu.wallet.paysdk.beans.b;
import com.baidu.wallet.paysdk.beans.h;
import com.baidu.wallet.paysdk.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.CheckCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.widget.NumberSmsView;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardUtil;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;

public class NewCheckSmsActivity extends HalfProtocolScreenBaseActivity implements View.OnClickListener, NumberSmsView.OnSmsChangedListener {
    public int a = 6;
    public RelativeLayout b;
    public SafeScrollView c;
    public SafeKeyBoardEditText d;
    public NumberSmsView e;
    public TextView f;
    public TextView g;
    public TextView h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f3585i;
    public TextView j;
    public TextView k;
    public BindFastRequest l;
    public CountDownTimer m;
    public boolean n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3586o = false;
    public int p = 0;
    public TextView q;
    public RelativeLayout r;

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_new_check_sms_activity"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void onBackPressed() {
        a(PayStatServiceEvent.NEW_CHECK_SMS_RESULT, "验短结果", a.a(), a.b(), a.c(), a.d(), StatHelper.SENSOR_ERR_2, "NewCheckSmsActivity onBackPressed");
        finishWithoutAnim();
    }

    public void onBeanExecFailure(int i2, int i3, final String str) {
        WalletGlobalUtils.safeDismissDialog(this, 0);
        if (5 == i2 || 11 == i2 || 513 == i2) {
            a(PayStatServiceEvent.NEW_CHECK_SMS_RESULT, "验短结果", a.a(), a.b(), a.c(), a.d(), i3 + "", str);
            if (i3 == -8) {
                if (TextUtils.isEmpty(str)) {
                    str = getString(ResUtils.string(getActivity(), "dxm_ebpay_no_network"));
                }
                runOnUiThread(new Runnable() {
                    public void run() {
                        GlobalUtils.toast(NewCheckSmsActivity.this, str);
                    }
                });
                return;
            }
            if (i3 == 5003) {
                AccountManager.getInstance(this.mAct).logout();
                WalletLoginHelper.getInstance().logout(false);
            }
            a(str);
        }
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        int i3 = 0;
        WalletGlobalUtils.safeDismissDialog(this, 0);
        if (5 == i2) {
            final CheckCardInfoResponse checkCardInfoResponse = (CheckCardInfoResponse) obj;
            if (checkCardInfoResponse != null && checkCardInfoResponse.checkResponseValidity()) {
                a(PayStatServiceEvent.NEW_CHECK_SMS_RESULT, "验短结果", a.a(), a.b(), a.c(), a.d(), "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
                if (this.l != null) {
                    if (1 == checkCardInfoResponse.send_sms_by_bfb || "1".equals(checkCardInfoResponse.need_verify_sms)) {
                        i3 = 1;
                    }
                    this.l.setmNeedSms(i3);
                    this.l.setSmsLength(checkCardInfoResponse.sms_length);
                    this.l.setSmsType(checkCardInfoResponse.sms_type);
                    if (!TextUtils.isEmpty(checkCardInfoResponse.channel_no)) {
                        this.l.setChannelNo(checkCardInfoResponse.channel_no);
                    }
                    this.l.setSendSmsTips(checkCardInfoResponse.send_sms_tips);
                }
                runOnUiThread(new Runnable() {
                    public void run() {
                        if (TextUtils.isEmpty(checkCardInfoResponse.send_sms_tips)) {
                            NewCheckSmsActivity.this.q.setVisibility(8);
                            NewCheckSmsActivity.this.q.setText((CharSequence) null);
                        } else {
                            NewCheckSmsActivity.this.q.setVisibility(0);
                            NewCheckSmsActivity.this.q.setText(checkCardInfoResponse.send_sms_tips);
                        }
                        boolean unused = NewCheckSmsActivity.this.n = false;
                        boolean unused2 = NewCheckSmsActivity.this.f3586o = false;
                        NewCheckSmsActivity.this.a();
                    }
                });
            }
        } else if (513 == i2) {
            BindCardResponse bindCardResponse = (BindCardResponse) obj;
            a(PayStatServiceEvent.NEW_CHECK_SMS_RESULT, "验短结果", a.a(), a.b(), a.c(), a.d(), "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            final String str2 = bindCardResponse != null ? bindCardResponse.card_no : "";
            runOnUiThread(new Runnable() {
                public void run() {
                    NewBindCardEntry.getInstance().newBindCardCallback("0", str2, false);
                }
            });
        } else if (11 == i2) {
            a(PayStatServiceEvent.NEW_CHECK_SMS_RESULT, "验短结果", a.a(), a.b(), a.c(), a.d(), "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            e();
        }
    }

    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        } else if (view == this.k) {
            a(PayStatServiceEvent.NEW_CLICK_RESEND_SMS, "点击重新发送");
            this.e.resetSms();
            c();
            b();
            d();
        } else if (view == this.j) {
            a(PayStatServiceEvent.NEW_NOT_RECEIVE_SMS, "点击收不到验证码");
            WalletGlobalUtils.safeShowDialog(this, 23, "");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFlagActiveBindCard();
        a();
        a(PayStatServiceEvent.NEW_ENTER_SMS_PAGE, "进入");
    }

    public void onDestroy() {
        SafeScrollView safeScrollView = this.c;
        if (safeScrollView != null && safeScrollView.isPopupWindowShowing()) {
            this.c.dismissKeyBoard(this.d);
        }
        BeanManager.getInstance().removeAllBeans("NewCheckSmsActivity");
        CountDownTimer countDownTimer = this.m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.m = null;
        }
        super.onDestroy();
    }

    public void onSmsChanged(int i2) {
        this.h.setVisibility(8);
        if (i2 == this.a) {
            this.e.setEnabled(false);
            BindFastRequest bindFastRequest = this.l;
            if (bindFastRequest != null) {
                bindFastRequest.mSmsVCode = this.e.getSms();
            }
            a(PayStatServiceEvent.NEW_CHECK_SMS, "输完验证码，点击确认");
            if (CardAddResponse.getInstance() == null || CardAddResponse.getInstance().user == null || CardAddResponse.getInstance().user.has_mobile_password != 1) {
                g();
            } else {
                f();
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            this.e.requestFocus();
        }
        super.onWindowFocusChanged(z);
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    private void c() {
        this.e.smsNomal();
        this.h.setVisibility(8);
        this.e.requestFocus();
    }

    private void d() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        h hVar = (h) PayBeanFactory.getInstance().getBean((Context) this, 5, "NewCheckSmsActivity");
        hVar.a(this.l);
        hVar.setResponseCallback(this);
        hVar.execBean();
    }

    private void e() {
        Intent intent = new Intent(this, NewSetPwdActivity.class);
        PayRequestCache.getInstance().addBeanRequestToCache(DxmPayBeanConstants.REQUEST_ID_PWD, new PwdRequest());
        startActivityWithoutAnim(intent);
        finishWithoutAnim();
    }

    private void f() {
        WalletGlobalUtils.safeShowDialog(this.mAct, 0, "");
        b bVar = (b) PayBeanFactory.getInstance().getBean((Context) this, 513, "NewCheckSmsActivity");
        bVar.a(this.l);
        bVar.setResponseCallback(this);
        bVar.execBean();
    }

    private void g() {
        WalletGlobalUtils.safeShowDialog(this.mAct, 0, "");
        ag agVar = (ag) PayBeanFactory.getInstance().getBean((Context) this, 11, "NewCheckSmsActivity");
        agVar.a(this.l);
        agVar.setResponseCallback(this);
        agVar.execBean();
    }

    /* access modifiers changed from: private */
    public void h() {
        BindFastRequest bindFastRequest = this.l;
        if (bindFastRequest != null && !TextUtils.isEmpty(bindFastRequest.getSendSmsTips())) {
            final View contentView = this.c.getSafeKeyBoardUtil().mPopupWindow.getContentView();
            if (!this.n) {
                this.n = true;
                contentView.post(new Runnable() {
                    public void run() {
                        int[] iArr = new int[2];
                        int[] iArr2 = new int[2];
                        contentView.getLocationOnScreen(iArr);
                        NewCheckSmsActivity.this.r.getLocationOnScreen(iArr2);
                        int dip2px = DisplayUtils.dip2px(NewCheckSmsActivity.this, 28.0f);
                        int dip2px2 = DisplayUtils.dip2px(NewCheckSmsActivity.this, 15.0f);
                        int height = iArr2[1] + NewCheckSmsActivity.this.r.getHeight();
                        if (iArr[1] - height >= NewCheckSmsActivity.this.q.getHeight() + dip2px + dip2px2) {
                            boolean unused = NewCheckSmsActivity.this.f3586o = true;
                            int unused2 = NewCheckSmsActivity.this.p = (contentView.getHeight() - DisplayUtils.dip2px(NewCheckSmsActivity.this, 55.0f)) + dip2px2;
                            NewCheckSmsActivity.this.q.setTranslationY(0.0f);
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) NewCheckSmsActivity.this.q.getLayoutParams();
                            marginLayoutParams.topMargin = ((iArr[1] - height) - NewCheckSmsActivity.this.q.getHeight()) - dip2px2;
                            NewCheckSmsActivity.this.q.setLayoutParams(marginLayoutParams);
                            return;
                        }
                        boolean unused3 = NewCheckSmsActivity.this.f3586o = false;
                        int unused4 = NewCheckSmsActivity.this.p = 0;
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) NewCheckSmsActivity.this.q.getLayoutParams();
                        marginLayoutParams2.topMargin = dip2px;
                        NewCheckSmsActivity.this.q.setLayoutParams(marginLayoutParams2);
                    }
                });
            }
            if (this.f3586o) {
                this.q.animate().translationY(0.0f).setDuration(120);
            }
        }
    }

    private void b() {
        CountDownTimer countDownTimer = this.m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.m = null;
        }
        AnonymousClass2 r1 = new CountDownTimer(60000, 1000) {
            public void onFinish() {
                NewCheckSmsActivity.this.k.setEnabled(true);
                NewCheckSmsActivity.this.k.setVisibility(0);
                NewCheckSmsActivity.this.f3585i.setVisibility(8);
            }

            public void onTick(long j) {
                NewCheckSmsActivity.this.f3585i.setVisibility(0);
                NewCheckSmsActivity.this.k.setVisibility(8);
                NewCheckSmsActivity.this.k.setEnabled(false);
                NewCheckSmsActivity.this.f3585i.setText(String.format(ResUtils.getString(NewCheckSmsActivity.this.getActivity(), "new_bind_card_check_sms_resend"), new Object[]{Integer.valueOf((int) (j / 1000))}));
            }
        };
        this.m = r1;
        r1.start();
        this.k.setEnabled(false);
    }

    /* access modifiers changed from: private */
    public void a() {
        this.b = (RelativeLayout) findViewById(R.id.relative_check_sms);
        this.c = (SafeScrollView) findViewById(R.id.scrollview);
        this.e = (NumberSmsView) findViewById(R.id.new_check_sms_input_box);
        this.f = (TextView) findViewById(R.id.tv_new_check_sms_main_title);
        this.g = (TextView) findViewById(R.id.tv_new_check_sms_subtitle);
        this.h = (TextView) findViewById(R.id.tv_new_check_sms_error);
        TextView textView = (TextView) findViewById(R.id.tv_new_check_resend_sms_time);
        this.k = textView;
        AccessibilityUtils.changeRoleDescription(textView, ResUtils.getString(this, "wallet_access_button"));
        this.f3585i = (TextView) findViewById(R.id.tv_new_check_sms_time);
        TextView textView2 = (TextView) findViewById(R.id.tv_new_check_sms_tip);
        this.j = textView2;
        AccessibilityUtils.changeRoleDescription(textView2, ResUtils.getString(this, "wallet_access_button"));
        this.mLeftImg.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.e.addNumberSmsChangedListenter(this);
        this.e.setShowInputMethod(true);
        SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) findViewById(R.id.sms_input);
        this.d = safeKeyBoardEditText;
        safeKeyBoardEditText.initSafeKeyBoardParams(this.b, this.c, this.e, false);
        this.d.setDisablePast(false);
        this.d.setGap(20);
        this.r = (RelativeLayout) findViewById(R.id.rl_try_resend);
        BindFastRequest bindReq = NewBindCardEntry.getInstance().getBindReq();
        this.l = bindReq;
        if (bindReq == null) {
            NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewCheckSmsActivity bindFastRequest is null", false);
            finishWithoutAnim();
            return;
        }
        this.q = (TextView) findViewById(R.id.tv_send_sms_tips);
        String sendSmsTips = this.l.getSendSmsTips();
        if (!TextUtils.isEmpty(sendSmsTips)) {
            this.q.setVisibility(0);
            this.q.setText(sendSmsTips);
        }
        String sendSmsphone = this.l.getSendSmsphone();
        if (!TextUtils.isEmpty(sendSmsphone)) {
            if (sendSmsphone.length() > 4) {
                TextView textView3 = this.f;
                textView3.setText("输入尾号" + sendSmsphone.substring(sendSmsphone.length() - 4, sendSmsphone.length()) + "的短信验证码");
            }
            TextView textView4 = this.g;
            textView4.setText("验证码已发送至您的手机号" + StringUtils.maskingPhoneNumber(sendSmsphone));
        }
        if (!TextUtils.isEmpty(this.l.getSmsLength())) {
            this.a = Integer.parseInt(this.l.getSmsLength());
        }
        if (this.a < 1) {
            this.a = 6;
        }
        this.e.initView(this.a);
        b();
        c();
        this.c.getSafeKeyBoardUtil().setOnPopupWindowStateChangeListener(new SafeKeyBoardUtil.OnPopupWindowStateChangeListener() {
            public void onPopupWindowDismiss() {
                if (NewCheckSmsActivity.this.f3586o) {
                    NewCheckSmsActivity.this.q.animate().translationY((float) NewCheckSmsActivity.this.p).setDuration(120);
                }
            }

            public void onPopupWindowShow() {
                NewCheckSmsActivity.this.h();
            }
        });
        if (((float) DisplayUtils.getDisplayHeight(this)) / getResources().getDisplayMetrics().density <= 640.0f) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            marginLayoutParams.topMargin = DisplayUtils.dip2px(this, 48.0f);
            this.e.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mHalfScreenContainer.getLayoutParams();
            marginLayoutParams2.topMargin = DisplayUtils.dip2px(this, 100.0f);
            this.mHalfScreenContainer.setLayoutParams(marginLayoutParams2);
        }
    }

    private void a(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                NewCheckSmsActivity.this.e.setEnabled(true);
                NewCheckSmsActivity.this.e.resetSms();
                NewCheckSmsActivity.this.e.requestFocus();
                NewCheckSmsActivity.this.e.smsError();
                NewCheckSmsActivity.this.h.setVisibility(0);
                NewCheckSmsActivity.this.h.setText(str);
            }
        });
    }

    private void a(String str, String str2) {
        a(str, str2, a.a(), a.b(), a.c(), a.d());
    }

    private void a(String str, String str2, String... strArr) {
        a.a(str, WalletSmsActivity.PAY_SMS_HASH_NAME, "paySDKInitiativeBindCardCheckSmsPage", str2, strArr);
    }
}
