package com.baidu.wallet.paysdk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.b.c;
import com.baidu.wallet.paysdk.b.g;
import com.baidu.wallet.paysdk.b.j;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.h;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.base.widget.BdActionBar;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptImageDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import com.dxmpay.wallet.core.beans.BeanErrorContent;
import com.dxmpay.wallet.core.utils.NFCUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.Serializable;

public abstract class BindCardBaseActivity extends PayBaseActivity implements View.OnClickListener, View.OnFocusChangeListener, SafeKeyBoardEditText.OnMyFocusChangeListener {
    public static final String BEAN_TAG = "BindCardBaseActivity";
    public final int DIALOG_ABANDON_AUTHORIZE = 629130;
    public final int DIALOG_CAN_AMOUNT_NO_PWD = 629128;
    public PayRequestCache.BindCategory a;
    public LayoutInflater b;
    public BdActionBar bdActionBar;
    public final int c = 629129;
    public h checkCardInfoBean;
    public boolean d = false;
    public int e = 0;
    public int f = 0;
    public boolean isAutoFillPhone;
    public boolean isFromRestore = false;
    public j mBindCardController;
    public int mBindReason = 0;
    public BindFastRequest mBindReq = null;
    public ErrorContentResponse mCardInfoUpdateContent;
    public ViewGroup mContentLayout;
    public PayRequest mPayReq = null;
    public ViewGroup mRootView;
    public SafeScrollView mScrollView;
    public int mUpdateItemCount = 0;

    private void a() {
        this.bdActionBar.measure(0, View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewHelper.setAlpha(this.bdActionBar, 0.0f);
    }

    private void b() {
        GlobalUtils.hideKeyboard(getActivity());
        PayCallBackManager.callBackClientCancel(this, "BindCardBaseActivitycallBackClientCancel().1");
    }

    public void addContentView(int i2) {
        if (this.b == null) {
            this.b = LayoutInflater.from(getActivity());
        }
        a(this.b.inflate(i2, (ViewGroup) null));
    }

    public void cancleRequest() {
        j jVar = this.mBindCardController;
        if (jVar != null) {
            jVar.f();
        }
        super.cancleRequest();
    }

    public void changeCurrentStepInfo(String str, int i2) {
        initActionBarWithActualTitleValue(str);
        this.e = i2;
    }

    public String formatCardNo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + 4;
            if (i3 < str.length()) {
                sb.append(str.substring(i2, i3));
                sb.append(" ");
            } else {
                sb.append(str.substring(i2, str.length()));
            }
            i2 = i3;
        }
        return sb.toString();
    }

    public int getBindCardCause() {
        return this.mBindReason;
    }

    public PayRequestCache.BindCategory getCategory() {
        return this.a;
    }

    public int getCurrentStep() {
        return this.e;
    }

    public void handleFailure(int i2, int i3, String str) {
        PayRequest payRequest = this.mPayReq;
        if (payRequest != null) {
            payRequest.clearMktSolution();
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        super.handleResponse(i2, obj, str);
    }

    public void initSafeKeyBoard() {
    }

    public boolean isBindInvalid() {
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest == null) {
            b();
            return true;
        } else if (!bindFastRequest.isRealPay() || this.mPayReq != null) {
            return false;
        } else {
            b();
            return true;
        }
    }

    public boolean isShowWithHalfScreeen() {
        int i2 = this.mUpdateItemCount;
        return 1 == i2 || 2 == i2;
    }

    public boolean isWindowNightMode() {
        return false;
    }

    public void loadCvv2() {
        WalletGlobalUtils.safeDismissDialog(this, 34);
        this.mBindCardController.r();
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        if (i3 == 80320 || i3 == 80321 || i3 == 80326 || i3 == 80327) {
            WalletGlobalUtils.safeDismissDialog(this, 0);
            WalletGlobalUtils.safeDismissDialog(this, -2);
            if (obj instanceof ErrorContentResponse) {
                this.mCardInfoUpdateContent = (ErrorContentResponse) obj;
                PayDataCache.getInstance().cleanDetainmentDesc();
                if (!TextUtils.isEmpty(str)) {
                    this.mDialogMsg = str;
                    this.mPayErrorCode = i3;
                    this.mBeanId = i2;
                    if (this.mBindCardController instanceof g) {
                        WalletGlobalUtils.safeShowDialog(this, 629129, "");
                    } else {
                        WalletGlobalUtils.safeShowDialog(this, 35, "");
                    }
                }
            }
        } else if (obj instanceof ErrorContentResponse) {
            if (this.mBindReq.getmBindFrom() == 2 || this.mBindReq.getmBindFrom() == 9) {
                ErrorContentResponse errorContentResponse = (ErrorContentResponse) obj;
                if (errorContentResponse.card_item_required != null) {
                    this.mCardInfoUpdateContent = errorContentResponse;
                    this.mDialogMsg = str;
                    WalletGlobalUtils.safeDismissDialog(this, 0);
                    WalletGlobalUtils.safeDismissDialog(this, -2);
                    WalletGlobalUtils.safeShowDialog(this, 40, "");
                    return;
                }
            }
            if (i3 == 15500 && (this.mBindReq.getmBindFrom() == 2 || this.mBindReq.getmBindFrom() == 7 || this.mBindReq.getmBindFrom() == 9)) {
                this.d = i2 == 13;
                this.mCardInfoUpdateContent = (ErrorContentResponse) obj;
                this.mDialogMsg = str;
                this.mPayErrorCode = i3;
                this.mBeanId = i2;
                WalletGlobalUtils.safeDismissDialog(this, 0);
                WalletGlobalUtils.safeDismissDialog(this, -2);
                WalletGlobalUtils.safeShowDialog(this, 34, "");
            } else if (this.mBindReq.getmBindFrom() == 0) {
                ErrorContentResponse errorContentResponse2 = (ErrorContentResponse) obj;
                this.mCardInfoUpdateContent = errorContentResponse2;
                if (errorContentResponse2 == null || TextUtils.isEmpty(errorContentResponse2.nine_elements_error) || TextUtils.isEmpty(this.mCardInfoUpdateContent.nine_elements_error_msg)) {
                    super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
                    return;
                }
                WalletGlobalUtils.safeDismissDialog(this, 0);
                WalletGlobalUtils.safeDismissDialog(this, -2);
                ErrorContentResponse errorContentResponse3 = this.mCardInfoUpdateContent;
                showCardNineElementsError(errorContentResponse3.nine_elements_error, errorContentResponse3.nine_elements_error_msg);
            } else {
                super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
            }
        } else {
            super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == ResUtils.id(getActivity(), "date_tip_img")) {
            this.f = 1;
            this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_date_tip");
            StatisticManager.onEvent("clickHelpDate");
            WalletGlobalUtils.safeShowDialog(this, 2, "");
        } else if (id == ResUtils.id(getActivity(), "cvv_tip_img")) {
            this.f = 0;
            this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_cvv2_tip");
            StatisticManager.onEvent("clickHelpCVV");
            WalletGlobalUtils.safeShowDialog(this, 2, "");
        } else if (id == ResUtils.id(getActivity(), "phone_tip_img")) {
            this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_mobile_tip");
            StatisticManager.onEvent("clickHelpPhone");
            WalletGlobalUtils.safeShowDialog(this, 13, "");
        } else if (id == ResUtils.id(getActivity(), "name_tip_img") || id == ResUtils.id(getActivity(), "card_name_tip_img")) {
            this.mDialogMsg = ResUtils.getString(getActivity(), "ebpay_name_tip");
            StatisticManager.onEvent("clickHelpName");
            WalletGlobalUtils.safeShowDialog(this, 14, "");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setFlagPaySdk();
        setIsShowMultiWindowTips(true);
        if (bundle == null) {
            this.mPayReq = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            this.a = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
            this.mBindReq = (BindFastRequest) PayRequestCache.getInstance().getRequest(this.a);
            PayDataCache.getInstance().setCurrentPayRequest(this.a);
            a(getIntent());
            this.isFromRestore = false;
        } else {
            this.isFromRestore = true;
            a(bundle);
        }
        if (this.mBindReq == null) {
            BindFastRequest bindFastRequest = new BindFastRequest();
            this.mBindReq = bindFastRequest;
            bindFastRequest.mBindFrom = 0;
            PayRequestCache.getInstance().addBeanRequestToCache(this.mBindReq.getRequestId(), this.mBindReq);
        }
        j a2 = c.a(this.mBindReq.mBindFrom);
        this.mBindCardController = a2;
        a2.a(this);
        this.mBindCardController.a(this.mBindReq);
        a(isShowWithHalfScreeen());
    }

    public Dialog onCreateDialog(int i2) {
        if (i2 == 2) {
            return new PromptImageDialog(getActivity());
        }
        if (i2 == 14) {
            return new PromptTipDialog(getActivity());
        }
        if (i2 == 40) {
            return new PromptDialog(getActivity());
        }
        if (i2 == 629129) {
            return new PromptDialog(getActivity());
        }
        if (i2 == 34) {
            return new PromptDialog(getActivity());
        }
        if (i2 != 35) {
            return super.onCreateDialog(i2);
        }
        PromptMultiBtnDialog promptMultiBtnDialog = new PromptMultiBtnDialog(getActivity());
        promptMultiBtnDialog.setNewDialogStyle(false);
        return promptMultiBtnDialog;
    }

    public void onFocusChange(View view, boolean z) {
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && "ev_bean_execut_err_content".equals(event.mEventKey)) {
            Object obj = event.mEventObj;
            if (obj instanceof BeanErrorContent) {
                BeanErrorContent beanErrorContent = (BeanErrorContent) obj;
                onBeanExecFailureWithErrContent(beanErrorContent.getBeanId(), beanErrorContent.getRet(), beanErrorContent.getMsg(), beanErrorContent.getErrContent());
                EventBus.getInstance().removeStickyEvent("ev_bean_execut_err_content");
            }
        }
    }

    public void onMyFocusChange(View view, boolean z) {
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.a = PayRequestCache.getInstance().getBindCategoryByIntent(getIntent());
        this.mBindReq = (BindFastRequest) PayRequestCache.getInstance().getRequest(this.a);
        PayDataCache.getInstance().setCurrentPayRequest(this.a);
        if (this.mBindReq == null) {
            BindFastRequest bindFastRequest = new BindFastRequest();
            this.mBindReq = bindFastRequest;
            bindFastRequest.mBindFrom = 0;
            PayRequestCache.getInstance().addBeanRequestToCache(this.mBindReq.getRequestId(), this.mBindReq);
        }
        j a2 = c.a(this.mBindReq.mBindFrom);
        this.mBindCardController = a2;
        a2.a(this);
        this.mBindCardController.a(this.mBindReq);
        boolean z = this.mRootView instanceof LinearLayout;
        a(intent);
        if (z != isShowWithHalfScreeen()) {
            a(isShowWithHalfScreeen());
        }
    }

    public void onPause() {
        super.onPause();
        EventBus.getInstance().unregister((Object) this, "ev_bean_execut_err_content");
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().disableForegroundDispatch(getActivity(), false);
        }
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 2) {
            PromptImageDialog promptImageDialog = (PromptImageDialog) dialog;
            promptImageDialog.setMessage(this.mDialogMsg);
            if (this.f == 0) {
                promptImageDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_cvv2_tip_title"));
                promptImageDialog.setImage(ResUtils.drawable(getActivity(), "wallet_base_help_cvv"));
                return;
            }
            promptImageDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_date_tip_title"));
            promptImageDialog.setImage(ResUtils.drawable(getActivity(), "wallet_base_help_date"));
        } else if (i2 == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage((CharSequence) this.mDialogMsg);
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.hideNegativeButton();
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_confirm"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 3);
                }
            });
        } else if (i2 == 13) {
            PromptTipDialog promptTipDialog = (PromptTipDialog) dialog;
            promptTipDialog.setMessage(ResUtils.getString(getActivity(), "ebpay_mobile_tip"));
            promptTipDialog.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_bank_phone"));
        } else if (i2 == 14) {
            PromptTipDialog promptTipDialog2 = (PromptTipDialog) dialog;
            promptTipDialog2.setMessage(this.mDialogMsg);
            promptTipDialog2.setTitleMessage(ResUtils.getString(getActivity(), "ebpay_name_title"));
        } else if (i2 == 34) {
            StatisticManager.onEvent("showCardOverDue");
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage((CharSequence) this.mDialogMsg);
            promptDialog2.showCloseBtn(false);
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.setNegativeBtn(ResUtils.getString(getActivity(), "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "dxm_ebpay_cancel"));
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 34);
                }
            });
            if (this.d) {
                promptDialog2.hideNegativeButton();
            }
            promptDialog2.setPositiveBtn(ResUtils.string(this, "ebpay_wallet_continue_pay"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "ebpay_wallet_continue_pay"));
                    StatisticManager.onEvent("continueFromCardOverdue");
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 34);
                    PayController instance = PayController.getInstance();
                    BindCardBaseActivity bindCardBaseActivity2 = BindCardBaseActivity.this;
                    instance.updateCardInfoPay(bindCardBaseActivity2, bindCardBaseActivity2.mCardInfoUpdateContent);
                }
            });
        } else if (i2 == 35) {
            StatisticManager.onEvent("showOrigPriceAlert");
            PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
            promptMultiBtnDialog.setMessage((CharSequence) this.mDialogMsg);
            promptMultiBtnDialog.setFirstBtn(ResUtils.getString(this, "bd_wallet_pay_by_order_price"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEvent("origPriceFromAlert");
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "bd_wallet_pay_by_order_price"));
                    ErrorContentResponse errorContentResponse = BindCardBaseActivity.this.mCardInfoUpdateContent;
                    if (errorContentResponse != null && errorContentResponse.mkt_solution != null) {
                        ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY)).setMktSolution(BindCardBaseActivity.this.mCardInfoUpdateContent.mkt_solution);
                        if (BindCardBaseActivity.this.mBindReq.getmBindFrom() == 9) {
                            BindCardBaseActivity.this.mBindCardController.c(new String[0]);
                        } else {
                            BindCardBaseActivity bindCardBaseActivity2 = BindCardBaseActivity.this;
                            if (bindCardBaseActivity2.checkCardInfoBean == null) {
                                bindCardBaseActivity2.checkCardInfoBean = (h) PayBeanFactory.getInstance().getBean((Context) BindCardBaseActivity.this.getActivity(), 5, BindCardBaseActivity.BEAN_TAG);
                            }
                            BindCardBaseActivity bindCardBaseActivity3 = BindCardBaseActivity.this;
                            bindCardBaseActivity3.checkCardInfoBean.a(bindCardBaseActivity3.mBindReq);
                            BindCardBaseActivity bindCardBaseActivity4 = BindCardBaseActivity.this;
                            bindCardBaseActivity4.checkCardInfoBean.setResponseCallback(bindCardBaseActivity4);
                            BindCardBaseActivity.this.checkCardInfoBean.execBean();
                        }
                        WalletGlobalUtils.safeShowDialog(BindCardBaseActivity.this, -2, "");
                        WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 35);
                    }
                }
            });
            promptMultiBtnDialog.setSecondBtn(ResUtils.getString(this, "bd_wallet_modify_card_no"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "bd_wallet_modify_card_no"));
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 35);
                    BindCardBaseActivity.this.updateChangeCard();
                }
            });
            promptMultiBtnDialog.setThirdBtn(ResUtils.getString(this, "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "dxm_ebpay_cancel"));
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 35);
                }
            });
        } else if (i2 == 40) {
            final PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage((CharSequence) this.mDialogMsg);
            promptDialog3.hideNegativeButton();
            promptDialog3.setPositiveBtn(ResUtils.string(this, "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    PayController instance = PayController.getInstance();
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    instance.updateCardInfoPay(bindCardBaseActivity, bindCardBaseActivity.mCardInfoUpdateContent);
                    promptDialog3.dismiss();
                }
            });
        } else if (i2 != 629129) {
            super.onPrepareDialog(i2, dialog);
        } else {
            StatisticManager.onEvent("showOrigPriceAlert");
            PromptDialog promptDialog4 = (PromptDialog) dialog;
            promptDialog4.setMessage((CharSequence) this.mDialogMsg);
            promptDialog4.showCloseBtn(false);
            promptDialog4.setCanceledOnTouchOutside(false);
            promptDialog4.setNegativeBtn(ResUtils.getString(getActivity(), "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "dxm_ebpay_cancel"));
                    WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 629129);
                }
            });
            promptDialog4.setPositiveBtn(ResUtils.string(this, "bd_wallet_pay_by_order_price"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEvent("origPriceFromAlert");
                    BindCardBaseActivity bindCardBaseActivity = BindCardBaseActivity.this;
                    bindCardBaseActivity.addDoPayorCheckCardStatistics(ResUtils.getString(bindCardBaseActivity.getActivity(), "bd_wallet_pay_by_order_price"));
                    ErrorContentResponse errorContentResponse = BindCardBaseActivity.this.mCardInfoUpdateContent;
                    if (errorContentResponse != null && errorContentResponse.mkt_solution != null) {
                        ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY)).setMktSolution(BindCardBaseActivity.this.mCardInfoUpdateContent.mkt_solution);
                        if (BindCardBaseActivity.this.mBindReq.getmBindFrom() == 9) {
                            BindCardBaseActivity.this.mBindCardController.c(new String[0]);
                        } else {
                            BindCardBaseActivity bindCardBaseActivity2 = BindCardBaseActivity.this;
                            if (bindCardBaseActivity2.checkCardInfoBean == null) {
                                bindCardBaseActivity2.checkCardInfoBean = (h) PayBeanFactory.getInstance().getBean((Context) BindCardBaseActivity.this.getActivity(), 5, BindCardBaseActivity.BEAN_TAG);
                            }
                            BindCardBaseActivity bindCardBaseActivity3 = BindCardBaseActivity.this;
                            bindCardBaseActivity3.checkCardInfoBean.a(bindCardBaseActivity3.mBindReq);
                            BindCardBaseActivity bindCardBaseActivity4 = BindCardBaseActivity.this;
                            bindCardBaseActivity4.checkCardInfoBean.setResponseCallback(bindCardBaseActivity4);
                            BindCardBaseActivity.this.checkCardInfoBean.execBean();
                        }
                        WalletGlobalUtils.safeShowDialog(BindCardBaseActivity.this, -2, "");
                        WalletGlobalUtils.safeDismissDialog(BindCardBaseActivity.this, 629129);
                    }
                }
            });
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        a(bundle);
        super.onRestoreInstanceState(bundle);
    }

    public void onResume() {
        super.onResume();
        EventBus.getInstance().register((Object) this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
        if (Build.VERSION.SDK_INT >= 10) {
            NFCUtil.getInstance().enableForegroundDispatch(getActivity(), false);
        }
        if (this.isFromRestore) {
            this.isFromRestore = false;
            WalletGlobalUtils.safeDismissDialog(this.mAct, 14);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 13);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 3);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 2);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 34);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 35);
            WalletGlobalUtils.safeDismissDialog(this.mAct, 629129);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (!TextUtils.isEmpty(this.mDialogMsg)) {
            bundle.putString("dialogMsg", this.mDialogMsg);
        }
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest != null) {
            bundle.putSerializable("deliver_bind_request", bindFastRequest);
        }
        PayRequest payRequest = this.mPayReq;
        if (payRequest != null) {
            bundle.putSerializable("deliver_pay_request", payRequest);
        }
        ErrorContentResponse errorContentResponse = this.mCardInfoUpdateContent;
        if (errorContentResponse != null) {
            bundle.putSerializable("mCardInfoUpdateContent", errorContentResponse);
        }
        bundle.putSerializable("PayResponse", PayDataCache.getInstance().getPayResponse());
        bundle.putBoolean("isautofillphone", this.isAutoFillPhone);
        bundle.putInt("currentStep", this.e);
        bundle.putInt("halfScreen", this.mUpdateItemCount);
        bundle.putInt("reasonForChangeCardItem", this.mBindReason);
        super.onSaveInstanceState(bundle);
    }

    public abstract void showCardNineElementsError(String str, String str2);

    public void startActivityForBind(Class<?> cls) {
        startActivity(new Intent(getActivity(), cls));
    }

    public void stastics(String str) {
        BindFastRequest bindFastRequest = this.mBindReq;
        if (bindFastRequest != null) {
            int i2 = bindFastRequest.getmBindFrom();
            if (i2 == 0) {
                StatisticManager.onEventWithValue(str, QueryResponse.Options.PAY);
            } else if (i2 == 1) {
                StatisticManager.onEventWithValue(str, "bind");
            } else if (i2 == 2) {
                StatisticManager.onEventWithValue(str, "completion");
            } else if (i2 == 3) {
                StatisticManager.onEventWithValue(str, "foggetPwd");
            } else if (i2 != 5) {
                b();
            } else {
                StatisticManager.onEventWithValue(str, "only_completion");
            }
        }
    }

    public abstract void updateBankCouponDesc(CharSequence charSequence);

    public abstract void updateBankTitleInfo(GetCardInfoResponse.CardInfo cardInfo, boolean z);

    public abstract void updateBindCardProtocolFields(GetCardInfoResponse.ProtocolPlatformInfo protocolPlatformInfo);

    public abstract void updateCardElement(boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    public abstract void updateChangeCard();

    public abstract void updateCompliance(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6);

    public abstract void updateCvv2Info(boolean z, boolean z2, boolean z3);

    public void updateDiscountTitle(String str) {
    }

    public abstract void updateDiscountTxt(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5);

    public abstract void updateProtocolFields(GetCardInfoResponse.ProtocolInfo protocolInfo);

    private void a(Bundle bundle) {
        Serializable serializable;
        Serializable serializable2;
        if (bundle != null) {
            this.mDialogMsg = bundle.getString("dialogMsg");
            if (this.mPayReq == null && (serializable2 = bundle.getSerializable("deliver_pay_request")) != null && (serializable2 instanceof PayRequest)) {
                this.mPayReq = (PayRequest) serializable2;
                PayRequestCache.getInstance().addBeanRequestToCache(this.mPayReq.getRequestId(), this.mPayReq);
            }
            if (this.mBindReq == null && (serializable = bundle.getSerializable("deliver_bind_request")) != null && (serializable instanceof BindFastRequest)) {
                this.mBindReq = (BindFastRequest) serializable;
                PayRequestCache.getInstance().addBeanRequestToCache(this.mBindReq.getRequestId(), this.mBindReq);
            }
            Serializable serializable3 = bundle.getSerializable("PayResponse");
            if (serializable3 != null && (serializable3 instanceof DirectPayContentResponse)) {
                ((DirectPayContentResponse) serializable3).storeResponse(getActivity());
            }
            Serializable serializable4 = bundle.getSerializable("mCardInfoUpdateContent");
            if (serializable4 != null && (serializable4 instanceof ErrorContentResponse)) {
                this.mCardInfoUpdateContent = (ErrorContentResponse) serializable4;
            }
            this.isAutoFillPhone = bundle.getBoolean("isautofillphone");
            this.e = bundle.getInt("currentStep");
            this.mUpdateItemCount = bundle.getInt("halfScreen", 0);
            this.mBindReason = bundle.getInt("reasonForChangeCardItem", 0);
        }
    }

    public void a(Bundle bundle, Class<?> cls, boolean z) {
        if (bundle == null && getIntent().getExtras() != null) {
            bundle = getIntent().getExtras();
        } else if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(getActivity(), cls);
        intent.putExtras(bundle);
        if (z) {
            startActivity(intent);
        } else {
            startActivityWithoutAnim(intent);
        }
    }

    private void a(View view) {
        this.mContentLayout.setVisibility(0);
        if (this.mContentLayout.getChildCount() > 0) {
            this.mContentLayout.removeAllViews();
        }
        this.mContentLayout.addView(view);
    }

    private void a(Intent intent) {
        if (intent == null) {
            this.mUpdateItemCount = 0;
            this.mBindReason = 0;
            return;
        }
        this.mUpdateItemCount = intent.getIntExtra("halfScreen", 0);
        this.mBindReason = intent.getIntExtra("reasonForChangeCardItem", 0);
    }

    private void a(boolean z) {
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            ((ViewGroup) viewGroup.getParent()).removeView(this.mRootView);
        }
        setContentView(ResUtils.layout(getActivity(), z ? "wallet_cashdesk_bind_base_half_screen" : "wallet_cashdesk_bind_base_activity"));
        this.mRootView = (ViewGroup) findViewById(ResUtils.id(getActivity(), "root_view"));
        this.mScrollView = (SafeScrollView) findViewById(ResUtils.id(getActivity(), "scrollview"));
        this.bdActionBar = (BdActionBar) findViewById(ResUtils.id(getActivity(), "bdactionbar"));
        this.mContentLayout = (ViewGroup) findViewById(ResUtils.id(getActivity(), "content_layout"));
        if (2 == this.mUpdateItemCount) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mScrollView.getLayoutParams();
            layoutParams.height += DisplayUtils.dip2px(this.mAct, 68.0f);
            this.mScrollView.setLayoutParams(layoutParams);
        }
        if (isShowWithHalfScreeen()) {
            TextView textView = (TextView) findViewById(ResUtils.id(getActivity(), "ebpay_halfscreen_action_bar")).findViewById(ResUtils.id(getActivity(), "bd_wallet_bind_card_title"));
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
            int dimension = (int) ResUtils.getDimension(this.mAct, "bd_wallet_bindcard_margin");
            layoutParams2.rightMargin = dimension;
            layoutParams2.leftMargin = dimension;
            textView.setLayoutParams(layoutParams2);
            textView.setText(ResUtils.getString(getActivity(), "ebpay_title_complete_info"));
        }
        if (!this.mBindCardController.C()) {
            a();
        } else if (!isShowWithHalfScreeen()) {
            ((RelativeLayout.LayoutParams) this.mScrollView.getLayoutParams()).addRule(3, this.bdActionBar.getId());
            this.mScrollView.requestLayout();
        }
    }
}
