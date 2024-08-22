package com.baidu.wallet.newbindcard.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.b;
import com.baidu.wallet.paysdk.datamodel.BindCardResponse;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.HalfProtocolScreenBaseActivity;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.SixNumberPwdView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.HashMap;

public class NewSetPwdActivity extends HalfProtocolScreenBaseActivity implements View.OnClickListener, SixNumberPwdView.OnPwdChangedListener {
    public SixNumberPwdView a;
    public TextView b;
    public LinearLayout c;
    public RelativeLayout d;
    public SafeScrollView e;
    public SafeKeyBoardEditText f;
    public final int g = 1;
    public int h = 0;

    public void addContentView() {
        ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_new_set_pwd_activity"), (ViewGroup) null);
        this.mContentView = viewGroup;
        this.mHalfScreenContainer.addView(viewGroup);
    }

    public void onBackPressed() {
        a(PayStatServiceEvent.NEW_SET_PWD_RESULT, "设置密码的结果", a.a(), a.b(), StatHelper.SENSOR_ERR_2, "NewSetPwdActivity onBackPressed");
        finishWithoutAnim();
    }

    public void onBeanExecFailure(int i2, int i3, final String str) {
        WalletGlobalUtils.safeDismissDialog(this, 0);
        if (513 == i2) {
            a(PayStatServiceEvent.NEW_SET_PWD_RESULT, "设置密码的结果", a.a(), a.b(), i3 + "", str);
            if (i3 == -8) {
                if (TextUtils.isEmpty(str)) {
                    str = getString(ResUtils.string(getActivity(), "dxm_ebpay_no_network"));
                }
                runOnUiThread(new Runnable() {
                    public void run() {
                        GlobalUtils.toast(NewSetPwdActivity.this, str);
                    }
                });
                return;
            }
            a(str, false);
        }
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        WalletGlobalUtils.safeDismissDialog(this, 0);
        if (513 == i2) {
            a(PayStatServiceEvent.NEW_SET_PWD_RESULT, "设置密码的结果", a.a(), a.b(), "0", NewBindCardEntry.BING_CARD_SUCCESS_MSG);
            BindCardResponse bindCardResponse = (BindCardResponse) obj;
            final String str2 = bindCardResponse != null ? bindCardResponse.card_no : "";
            runOnUiThread(new Runnable() {
                public void run() {
                    NewBindCardEntry.getInstance().newBindCardCallback("0", str2, false);
                }
            });
        }
    }

    public void onClick(View view) {
        if (view == this.mLeftImg) {
            onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFlagActiveBindCard();
        a();
    }

    public Dialog onCreateDialog(int i2) {
        if (i2 == 1) {
            return new PromptDialog(getActivity());
        }
        return super.onCreateDialog(i2);
    }

    public void onDestroy() {
        super.onDestroy();
        HashMap hashMap = new HashMap();
        hashMap.put("count", Integer.valueOf(this.h));
        this.h = 0;
        a.a(PayStatServiceEvent.NEW_SET_PWD_COUNT, hashMap, "设置密码页面", "initiativeBindCardSetPwdPage", "设置密码的次数", a.a(), a.b());
        BeanManager.getInstance().removeAllBeans("NewSetPwdActivity");
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 1) {
            final PromptDialog promptDialog = (PromptDialog) dialog;
            a(PayStatServiceEvent.NEW_SHOW_WHAT_PWD_DIALOG, "点击什么是支付密码展示的弹窗", a.a(), a.b(), "0");
            promptDialog.setMessage((CharSequence) ResUtils.getString(this.mAct, "ebpay_pwd_promotion_message"));
            promptDialog.setTitleText(ResUtils.getString(this.mAct, "ebpay_pwd_explain"));
            promptDialog.hideNegativeButton();
            promptDialog.setPositiveBtn(ResUtils.getString(this.mAct, "ebpay_pwd_close_promotion_dialog"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    NewSetPwdActivity.this.a(PayStatServiceEvent.NEW_CLICK_WHAT_PWD_DIALOG, "什么是支付密码展示的弹窗，点击我知道了", a.a(), a.b(), "0");
                    promptDialog.dismiss();
                }
            });
            return;
        }
        super.onPrepareDialog(i2, dialog);
    }

    public void onPwdChanged(int i2) {
        if (i2 == 6) {
            this.h++;
            a(PayStatServiceEvent.NEW_SET_PWD, "输完密码", a.a(), a.b());
            b();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.f.requestFocus();
        }
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    private void b() {
        WalletGlobalUtils.safeShowDialog(this.mAct, 0, "");
        PwdRequest pwdRequest = (PwdRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PWD);
        if (pwdRequest != null) {
            pwdRequest.mPayPass = this.a.getPwd();
            pwdRequest.mConfirmPayPass = this.a.getPwd();
        }
        b bVar = (b) PayBeanFactory.getInstance().getBean((Context) this, 513, "NewSetPwdActivity");
        bVar.a(NewBindCardEntry.getInstance().getBindReq());
        bVar.setResponseCallback(this);
        bVar.execBean();
    }

    private void a() {
        this.mActionBar.setVisibility(0);
        this.d = (RelativeLayout) findViewById(R.id.new_bind_card_set_pwd_layout);
        this.a = (SixNumberPwdView) findViewById(R.id.new_pwd_input_box);
        TextView textView = (TextView) findViewById(R.id.new_error_tip);
        this.b = textView;
        AccessibilityUtils.changeRoleDescription(textView, ResUtils.getString(this, "wallet_access_button"));
        this.e = (SafeScrollView) findViewById(R.id.new_set_pwd_scrollview);
        this.c = (LinearLayout) findViewById(R.id.lin_set_pwd_tip);
        SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.a.findViewById(ResUtils.id(getActivity(), "pwd_input"));
        this.f = safeKeyBoardEditText;
        safeKeyBoardEditText.initSafeKeyBoardParams(this.d, this.e, safeKeyBoardEditText, false);
        this.f.setGap(20);
        this.f.setDisablePast(true);
        this.a.addSixNumberPwdChangedListenter(this);
        setSafeScrollView(this.e);
        this.f.requestFocus();
        this.mLeftImg.setOnClickListener(this);
        a(ResUtils.getString(this, "wallet_base_new_bind_card_check_pwd_tip"), true);
        a(PayStatServiceEvent.NEW_ENTER_SET_PWD_PAGE, "进入", a.a(), a.b());
        this.e.setKeyBoardStatusChangeListener(new SafeScrollView.onKeyBoardStatusChangeListener() {
            public void onKeyBoardStatusChange(boolean z, int i2) {
                DisplayMetrics displayMetrics = NewSetPwdActivity.this.getResources().getDisplayMetrics();
                if (displayMetrics != null) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) NewSetPwdActivity.this.c.getLayoutParams();
                    layoutParams.setMargins(0, ((((displayMetrics.heightPixels - i2) - NewSetPwdActivity.this.mHalfScreenContainer.getTop()) - NewSetPwdActivity.this.b.getTop()) - NewSetPwdActivity.this.mActionBar.getHeight()) - NewSetPwdActivity.this.c.getHeight(), 0, 0);
                    NewSetPwdActivity.this.c.setLayoutParams(layoutParams);
                }
            }
        });
    }

    private void a(final String str, final boolean z) {
        runOnUiThread(new Runnable() {
            public void run() {
                NewSetPwdActivity.this.a.resetPwd();
                NewSetPwdActivity.this.b.setText(str);
                if (z) {
                    NewSetPwdActivity.this.b.setTextColor(ResUtils.getColor(NewSetPwdActivity.this, "wallet_cashdesk_new_bind_card_7BE6"));
                } else {
                    NewSetPwdActivity.this.b.setTextColor(ResUtils.getColor(NewSetPwdActivity.this, "dxm_wallet_fp_promtion_text"));
                }
                NewSetPwdActivity.this.b.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AnonymousClass4 r3 = AnonymousClass4.this;
                        if (z) {
                            WalletGlobalUtils.safeShowDialog(NewSetPwdActivity.this.mAct, 1, "");
                        }
                    }
                });
                if (ResUtils.getString(NewSetPwdActivity.this, "wallet_access_what_is_password").equals(str)) {
                    NewSetPwdActivity.this.b.setContentDescription(ResUtils.getString(NewSetPwdActivity.this, "wallet_access_password_des"));
                    return;
                }
                NewSetPwdActivity.this.b.setContentDescription(str);
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String... strArr) {
        a.a(str, "设置密码页面", "initiativeBindCardSetPwdPage", str2, strArr);
    }
}
