package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.sapi2.SapiAccount;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.controllers.PasswordController;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.UserInfoBean;
import com.baidu.wallet.paysdk.beans.i;
import com.baidu.wallet.paysdk.beans.w;
import com.baidu.wallet.paysdk.datamodel.CheckPwdErrorContent;
import com.baidu.wallet.paysdk.datamodel.PwdRequest;
import com.baidu.wallet.paysdk.datamodel.UserInfoContentResponse;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.NetworkUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.PassUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Map;

public class PwdCheckActivity extends PwdBaseActivity implements View.OnClickListener {
    public static final int DIALOG_WHAT_IS_PAY_PASSWORD = 56;
    public w a;
    public String b;
    public boolean c = false;
    public boolean d = false;

    /* access modifiers changed from: private */
    public void d() {
        WalletGlobalUtils.safeShowDialog(this, 0, "");
        UserInfoBean userInfoBean = (UserInfoBean) PayBeanFactory.getInstance().getBean((Context) getActivity(), 6, "PwdCheckActivity");
        userInfoBean.setResponseCallback(this);
        userInfoBean.execBean();
    }

    public void forgetPasswd(String str) {
        String findPayPwdUrl = SdkInitResponse.getInstance().getFindPayPwdUrl(getActivity());
        if (TextUtils.isEmpty(findPayPwdUrl)) {
            findPayPwdUrl = DxmPayBeanConstants.API_FIND_PAY_PWD_URL;
        }
        BaiduWalletDelegate.getInstance().openH5Module(getActivity(), findPayPwdUrl, false);
        this.d = true;
    }

    public void handleFailure(int i2, int i3, String str) {
        if (i2 == this.a.getBeanId()) {
            resetPwd();
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (i3 == 100018) {
                this.mDialogMsg = str;
                hideErrorMsg();
                this.mPayErrorCode = i3;
                this.mBeanId = i2;
                WalletGlobalUtils.safeShowDialog(this, 17, "");
            } else if (!TextUtils.isEmpty(str)) {
                showErrorMsg(str);
            }
        } else if (i2 == 6) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (i3 == 100035 || i3 == 100036) {
                int i4 = 1;
                if (i3 == 100036) {
                    i4 = 2;
                }
                PassUtil.passNormalized(getActivity(), str, i4, new PassUtil.PassNormalize() {
                    public boolean onNormalize(Context context, int i2, Map<String, String> map) {
                        if (super.onNormalize(context, i2, map)) {
                            PwdCheckActivity.this.d();
                            return false;
                        }
                        PwdCheckActivity.this.finish();
                        return false;
                    }
                });
                return;
            }
            super.handleFailure(i2, i3, str);
        } else if (i2 == 529) {
            resetPwd();
            WalletGlobalUtils.safeDismissDialog(this, 0);
            if (i3 == 100015) {
                showErrorMsg(str);
            } else if (i3 == 100018) {
                if (TextUtils.isEmpty(str)) {
                    str = ResUtils.getString(getActivity(), "ebpay_pass_locked_tip");
                }
                this.mDialogMsg = str;
                showErrorMsg(str);
            } else {
                GlobalUtils.toast(getActivity(), str);
            }
        } else {
            super.handleFailure(i2, i3, str);
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == this.a.getBeanId()) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            PwdRequest pwdRequest = this.mPwdRequest;
            if (pwdRequest.mFrom == 2) {
                pwdRequest.mSessionKey = str;
                pwdRequest.mRequestType = 3;
                startActivity(new Intent(getActivity(), PwdSetAndConfirmActivity.class));
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        PwdCheckActivity.this.finishWithoutAnim();
                    }
                }, 500);
                return;
            }
            finishWithoutAnim();
            BaiduWalletUtils.startActivityAnim(this);
            if (DxmPayBeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5.equals(this.b)) {
                PasswordController.getPassWordInstance().checkPwdSucceed(str);
            } else {
                PasswordController.getPassWordInstance().checkPwdSucceed(getPwd());
            }
        } else if (i2 == 6) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            UserInfoContentResponse userInfoContentResponse = (UserInfoContentResponse) obj;
            userInfoContentResponse.user_info.decrypt();
            userInfoContentResponse.decrypt();
            forgetPasswd(this.b);
        } else if (i2 == 529) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            PasswordController.getPassWordInstance().checkPwdSucceed(getPwd());
            GlobalUtils.toast(this, str);
            finishWithoutAnim();
        } else {
            super.handleResponse(i2, obj, str);
        }
    }

    public void onBackPressed() {
        int i2 = this.mPwdRequest.mFrom;
        if (i2 == 1) {
            if (DxmPayBeanConstants.FROM_CHECK_FOR_SP.equals(this.b)) {
                StatisticManager.onEvent("Intermediarypay_cancel");
            }
            PasswordController.getPassWordInstance().checkPwdFail(2, "");
        } else if (i2 == 2) {
            PasswordController.getPassWordInstance().editPwdFail(-1, "");
        }
        super.onBackPressed();
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        if (i2 == 529) {
            resetPwd();
            WalletGlobalUtils.safeDismissDialog(this, 0);
            CheckPwdErrorContent checkPwdErrorContent = null;
            if (obj != null && (obj instanceof CheckPwdErrorContent)) {
                checkPwdErrorContent = (CheckPwdErrorContent) obj;
            }
            if (checkPwdErrorContent == null || !"1".equalsIgnoreCase(checkPwdErrorContent.need_close_page)) {
                super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
                return;
            }
            PasswordController.getPassWordInstance().checkPwdFail(i3, str);
            GlobalUtils.toast(this, str);
            finishWithoutAnim();
            return;
        }
        resetPwd();
        super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
    }

    public void onClick(View view) {
        if (view == this.mForgetPasswd) {
            StatisticManager.onEvent(StatServiceEvent.EVENT_CLICK_FORGET_PWD_IN_CASHDESK);
            c();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            super.onCreate(r9)
            android.view.Window r0 = r8.getWindow()
            r1 = 2
            r0.setSoftInputMode(r1)
            if (r9 != 0) goto L_0x001a
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r0 = "check_pwd_from_type_key"
            java.lang.String r9 = r9.getStringExtra(r0)
            r8.b = r9
            goto L_0x0022
        L_0x001a:
            java.lang.String r0 = "fromType"
            java.lang.String r9 = r9.getString(r0)
            r8.b = r9
        L_0x0022:
            com.baidu.wallet.paysdk.beans.PayBeanFactory r9 = com.baidu.wallet.paysdk.beans.PayBeanFactory.getInstance()
            int r0 = r8.getMobilePwdBeanId()
            java.lang.String r2 = "PwdCheckActivity"
            com.dxmpay.wallet.core.beans.BaseBean r9 = r9.getBean((android.content.Context) r8, (int) r0, (java.lang.String) r2)
            com.baidu.wallet.paysdk.beans.w r9 = (com.baidu.wallet.paysdk.beans.w) r9
            r8.a = r9
            com.baidu.wallet.paysdk.datamodel.PwdRequest r9 = r8.mPwdRequest
            if (r9 != 0) goto L_0x003c
            r8.finish()
            return
        L_0x003c:
            android.app.Activity r9 = r8.getActivity()
            java.lang.String r0 = "ebpay_pwd_check_title"
            java.lang.String r9 = com.dxmpay.apollon.utils.ResUtils.getString(r9, r0)
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r2 = "ebpay_pwd_check_sub_tip_for_verify"
            java.lang.String r0 = com.dxmpay.apollon.utils.ResUtils.getString(r0, r2)
            com.baidu.wallet.paysdk.datamodel.PwdRequest r2 = r8.mPwdRequest
            int r2 = r2.mFrom
            java.lang.String r3 = "ebpay_check_pwd_close_hce"
            java.lang.String r4 = "ebpay_check_pwd_close_showcode"
            java.lang.String r5 = ""
            java.lang.String r6 = "ebpay_check_pwd"
            if (r2 != r1) goto L_0x006d
            android.app.Activity r9 = r8.getActivity()
            java.lang.String r0 = "ebpay_pwd_check_tip_modify_pwd"
            java.lang.String r9 = com.dxmpay.apollon.utils.ResUtils.getString(r9, r0)
            java.lang.String r3 = "ebpay_check_pwd_modify_pwd"
        L_0x006a:
            r0 = r5
            goto L_0x016e
        L_0x006d:
            java.lang.String r1 = r8.b
            java.lang.String r2 = "from_passfree_save"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0085
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r1 = "ebpay_pwd_check_sub_tip_for_save"
            java.lang.String r0 = com.dxmpay.apollon.utils.ResUtils.getString(r0, r1)
            java.lang.String r3 = "ebpay_check_pwd_save"
            goto L_0x016e
        L_0x0085:
            java.lang.String r1 = r8.b
            java.lang.String r2 = "from_unbind"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x009c
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r1 = "ebpay_pwd_check_sub_tip_for_unbind_card"
            java.lang.String r0 = com.dxmpay.apollon.utils.ResUtils.getString(r0, r1)
        L_0x0099:
            r3 = r6
            goto L_0x016e
        L_0x009c:
            java.lang.String r1 = r8.b
            java.lang.String r2 = "from_bind_pay"
            boolean r1 = r2.equals(r1)
            java.lang.String r2 = "ebpay_pwd_check_sub_tip_for_bind_or_complete_card"
            if (r1 == 0) goto L_0x00b1
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r0 = com.dxmpay.apollon.utils.ResUtils.getString(r0, r2)
            goto L_0x0099
        L_0x00b1:
            java.lang.String r1 = r8.b
            java.lang.String r7 = "from_complete_pay"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x00c6
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r1 = "ebpay_pwd_check_sub_tip_for_complete_pay"
            java.lang.String r0 = com.dxmpay.apollon.utils.ResUtils.getString(r0, r1)
            goto L_0x0099
        L_0x00c6:
            java.lang.String r1 = r8.b
            java.lang.String r7 = "from_bind"
            boolean r1 = r7.equals(r1)
            if (r1 != 0) goto L_0x0164
            java.lang.String r1 = r8.b
            java.lang.String r7 = "from_complete"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x00dc
            goto L_0x0164
        L_0x00dc:
            java.lang.String r1 = r8.b
            java.lang.String r2 = "from_close_showcode"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x00f3
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r1 = "ebpay_pwd_check_sub_tip_for_close_showcode"
            java.lang.String r0 = com.dxmpay.apollon.utils.ResUtils.getString(r0, r1)
        L_0x00f0:
            r3 = r4
            goto L_0x016e
        L_0x00f3:
            java.lang.String r1 = r8.b
            java.lang.String r2 = "from_fingerprint"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0108
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r1 = "ebpay_pwd_check_tip_save"
            java.lang.String r0 = com.dxmpay.apollon.utils.ResUtils.getString(r0, r1)
            goto L_0x00f0
        L_0x0108:
            java.lang.String r1 = r8.b
            java.lang.String r2 = "from_check_for_sp"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0120
            android.app.Activity r9 = r8.getActivity()
            java.lang.String r0 = "ebpay_intermediarypay_pwdcheck_tip"
            java.lang.String r9 = com.dxmpay.apollon.utils.ResUtils.getString(r9, r0)
            java.lang.String r3 = "ebpay_intermediarypay_pwdcheck"
            goto L_0x006a
        L_0x0120:
            java.lang.String r1 = r8.b
            java.lang.String r2 = "from_close_hce_pay"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0135
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r1 = "ebpay_pwd_check_sub_tip_for_close_hce"
            java.lang.String r0 = com.dxmpay.apollon.utils.ResUtils.getString(r0, r1)
            goto L_0x016e
        L_0x0135:
            java.lang.String r1 = r8.b
            java.lang.String r2 = "from_open_hce_pay"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x014a
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r1 = "ebpay_pwd_check_sub_tip_for_open_hce"
            java.lang.String r0 = com.dxmpay.apollon.utils.ResUtils.getString(r0, r1)
            goto L_0x016e
        L_0x014a:
            java.lang.String r1 = r8.b
            java.lang.String r2 = "from_common_checkpwd_from_h5"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0099
            boolean r1 = r8.isOpenHalfScreenPwdVerify
            if (r1 == 0) goto L_0x0099
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r1 = "ebpay_pwd_use_explain"
            java.lang.String r0 = com.dxmpay.apollon.utils.ResUtils.getString(r0, r1)
            goto L_0x0099
        L_0x0164:
            android.app.Activity r0 = r8.getActivity()
            java.lang.String r0 = com.dxmpay.apollon.utils.ResUtils.getString(r0, r2)
            goto L_0x0099
        L_0x016e:
            android.widget.TextView r1 = r8.mTip
            r1.setText(r9)
            boolean r9 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r9 != 0) goto L_0x0185
            android.widget.TextView r9 = r8.mSubTip
            r9.setText(r0)
            android.widget.TextView r9 = r8.mSubTip
            r9.setVisibility(r1)
            goto L_0x018c
        L_0x0185:
            android.widget.TextView r9 = r8.mSubTip
            r0 = 8
            r9.setVisibility(r0)
        L_0x018c:
            r8.initActionBar(r3)
            android.view.View r9 = r8.mForgetPasswd
            r9.setOnClickListener(r8)
            com.dxmpay.wallet.base.widget.SafeKeyBoardEditText r9 = r8.mSafeEditText
            com.baidu.wallet.paysdk.ui.PwdCheckActivity$1 r0 = new com.baidu.wallet.paysdk.ui.PwdCheckActivity$1
            r0.<init>()
            r9.addTextChangedListener(r0)
            com.dxmpay.apollon.eventbus.EventBus r9 = com.dxmpay.apollon.eventbus.EventBus.getInstance()
            com.dxmpay.apollon.eventbus.EventBus$ThreadMode r0 = com.dxmpay.apollon.eventbus.EventBus.ThreadMode.MainThread
            java.lang.String r2 = "walletpay_forgot_password"
            r9.register((java.lang.Object) r8, (java.lang.String) r2, (int) r1, (com.dxmpay.apollon.eventbus.EventBus.ThreadMode) r0)
            boolean r9 = r8.isOpenHalfScreenPwdVerify
            if (r9 == 0) goto L_0x01b3
            r8.a()
            r8.b()
        L_0x01b3:
            java.lang.String r9 = "enter_pwd_check_activity"
            com.dxmpay.wallet.utils.StatHelper.statServiceEvent(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.ui.PwdCheckActivity.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        super.onDestroy();
        BeanManager.getInstance().removeAllBeans("PwdCheckActivity");
        if (this.d) {
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
                        if (this.mPwdRequest != null) {
                            PayRequestCache.getInstance().addBeanRequestToCache(this.mPwdRequest.getRequestId(), this.mPwdRequest);
                        }
                        int i2 = 0;
                        try {
                            i2 = jSONObject.getInt("is_bind_card");
                        } catch (Exception e) {
                            LogUtil.e("PwdCheckActivity", e.getMessage(), e);
                        }
                        if (1 == i2 && PayRequestCache.getInstance().isPaying()) {
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    BaseActivity.clearTasksWithActivityName(OrderConfirmActivity.class);
                                    BaiduPayDelegate.getInstance().reOrderPay(PwdCheckActivity.this.getActivity());
                                }
                            }, 1000);
                        }
                        hideErrorMsg();
                        this.c = true;
                    }
                } catch (Exception e2) {
                    LogUtil.e("PwdCheckActivity", e2.getMessage(), e2);
                }
            }
        } else if ("ev_bean_execut_err_content".equals(event.mEventKey)) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
            }
        }
    }

    public void onPause() {
        super.onPause();
        EventBus.getInstance().unregister((Object) this, "ev_bean_execut_err_content");
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 17) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage((CharSequence) this.mDialogMsg);
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_find_password"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PwdCheckActivity pwdCheckActivity = PwdCheckActivity.this;
                    pwdCheckActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdCheckActivity.getActivity(), "ebpay_find_password"));
                    WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this, 17);
                    PwdCheckActivity.this.c();
                }
            });
            promptDialog.setNegativeBtn(ResUtils.getString(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PwdCheckActivity pwdCheckActivity = PwdCheckActivity.this;
                    pwdCheckActivity.addDoPayorCheckCardStatistics(ResUtils.getString(pwdCheckActivity.getActivity(), "dxm_ebpay_know"));
                    WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this, 17);
                }
            });
        } else if (i2 == 55) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage((CharSequence) WalletGlobalUtils.showStr);
            promptDialog2.hideTitle();
            promptDialog2.hideNegativeButton();
            promptDialog2.setPositiveBtn(ResUtils.string(this.mAct, "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this.mAct, 55);
                }
            });
        } else if (i2 != 56) {
            super.onPrepareDialog(i2, dialog);
        } else {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage(ResUtils.string(this, "ebpay_pwd_check_msg_for_halfscreen_pwd_verify"));
            promptDialog3.setTitleText(ResUtils.getString(this, "ebpay_pwd_use_explain") + "？");
            promptDialog3.setCanceledOnTouchOutside(false);
            promptDialog3.setPositiveBtn(ResUtils.getString(getActivity(), "ebpay_title_find_pwd"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PwdCheckActivity pwdCheckActivity = PwdCheckActivity.this;
                    pwdCheckActivity.a(ResUtils.getString(pwdCheckActivity.getActivity(), "ebpay_find_password"));
                    WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this, 56);
                    if (TextUtils.isEmpty(PwdCheckActivity.this.b) || !DxmPayBeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5.equals(PwdCheckActivity.this.b)) {
                        PwdCheckActivity pwdCheckActivity2 = PwdCheckActivity.this;
                        pwdCheckActivity2.forgetPasswd(pwdCheckActivity2.b);
                        return;
                    }
                    boolean unused = PwdCheckActivity.this.c = false;
                    PwdCheckActivity.this.d();
                }
            });
            promptDialog3.setNegativeBtn(ResUtils.getString(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PwdCheckActivity pwdCheckActivity = PwdCheckActivity.this;
                    pwdCheckActivity.a(ResUtils.getString(pwdCheckActivity.getActivity(), "dxm_ebpay_know"));
                    WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this, 56);
                }
            });
        }
    }

    public void onPwdChanged(int i2) {
        if (i2 == 6) {
            StatHelper.statServiceEvent(StatServiceEvent.EVENT_FINISH_INPUTPWD_IN_CASHDESK);
            if (!NetworkUtils.isNetworkAvailable(getActivity())) {
                GlobalUtils.toast(getActivity(), ResUtils.getString(getActivity(), "dxm_ebpay_no_network"));
                resetPwd();
                return;
            }
            this.mPwdRequest.mPayPass = getPwd();
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            if (DxmPayBeanConstants.FROM_CHECK_FOR_SP.equals(this.b)) {
                i iVar = (i) PayBeanFactory.getInstance().getBean((Context) this, (int) PayBeanFactory.BEAN_ID_CHECK_PWD, "PwdCheckActivity");
                iVar.setResponseCallback(this);
                iVar.execBean();
                return;
            }
            this.a.setResponseCallback(this);
            if (this.isOpenHalfScreenPwdVerify) {
                this.a.a(this.extraFromH5);
                this.a.a(this.isOpenHalfScreenPwdVerify);
            }
            this.a.execBean();
            return;
        }
        this.mErrorTip.setVisibility(4);
    }

    public void onResume() {
        super.onResume();
        EventBus.getInstance().registerSticky(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SapiAccount.SAPI_ACCOUNT_FROMTYPE, this.b);
    }

    public void onWindowFocusChanged(boolean z) {
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.onWindowFocusChanged(z);
        if (z && (safeKeyBoardEditText = this.mSafeEditText) != null) {
            safeKeyBoardEditText.requestFocus();
        }
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    private void b() {
        if (this.mSubTipWrap != null) {
            StatisticManager.onEvent("clickWhatIsPayPassword");
            this.mSubTipWrap.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                        ViewHelper.setAlpha(PwdCheckActivity.this.mSubTipWrap, 0.5f);
                        return false;
                    }
                    ViewHelper.setAlpha(PwdCheckActivity.this.mSubTipWrap, 1.0f);
                    return false;
                }
            });
            this.mSubTipWrap.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PwdCheckActivity.this, 0);
                    WalletGlobalUtils.safeShowDialog(PwdCheckActivity.this, 56, "");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        if ((TextUtils.isEmpty(this.b) || (!DxmPayBeanConstants.FROM_B_SAO_C_TYPE.equalsIgnoreCase(this.b) && !DxmPayBeanConstants.FROM_PASSFREE_SAVE.equalsIgnoreCase(this.b))) && !DxmPayBeanConstants.FROM_CLOSE_SHOWCODE.equals(this.b) && !DxmPayBeanConstants.FROM_VOICEPRINT_PAY.equals(this.b) && !DxmPayBeanConstants.FROM_FINGERPRINT_PAY.equals(this.b) && !DxmPayBeanConstants.FROM_CLOSE_HCE.equals(this.b) && !DxmPayBeanConstants.FROM_OPEN_HCE_PAY.equals(this.b) && !DxmPayBeanConstants.FROM_CHECK_FOR_SP.equals(this.b) && !DxmPayBeanConstants.FROM_COMMON_CHECK_PWD.equals(this.b) && !DxmPayBeanConstants.FROM_COMMON_CHECK_PWD_FROM_H5.equals(this.b) && !this.c) {
            forgetPasswd(this.b);
            return;
        }
        this.c = false;
        d();
    }

    private void a() {
        if (this.mLeftImageGoback != null) {
            StatisticManager.onEvent("clickCloseHalfScreenPwdVerify");
            this.mLeftImageGoback.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                        ViewHelper.setAlpha(PwdCheckActivity.this.mLeftImageGoback, 0.5f);
                        return false;
                    }
                    ViewHelper.setAlpha(PwdCheckActivity.this.mLeftImageGoback, 1.0f);
                    return false;
                }
            });
            this.mLeftImageGoback.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GlobalUtils.hideKeyboard(PwdCheckActivity.this.getActivity());
                    PwdCheckActivity.this.onBackPressed();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (!TextUtils.isEmpty(DxmPayBeanConstants.API_VERIFY_MOBILE_PWD_NEW)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(DxmPayBeanConstants.API_VERIFY_MOBILE_PWD_NEW);
            arrayList.add(str);
            StatisticManager.onEventWithValues("halfScreenPwdVerifyAlertAction", arrayList);
        }
    }
}
