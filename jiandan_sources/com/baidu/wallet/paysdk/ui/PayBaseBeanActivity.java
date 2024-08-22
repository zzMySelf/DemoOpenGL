package com.baidu.wallet.paysdk.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.presenter.f;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.IdentifyCodeGetFailDialog;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptTipDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.beans.BeanActivity;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public abstract class PayBaseBeanActivity extends BeanActivity {
    public static final int DIALOG_ABANDON_CONFIM = 18;
    public static final int DIALOG_ACCOUNT_LOCKED = 17;
    public static final int DIALOG_AUTH_INFO_UNUSUAL_FOR_FINANCE = 55;
    public static final int DIALOG_CANNOT_DISCOUNT = 35;
    public static final int DIALOG_CARDBALANCE_NOT_ENOUGH = 37;
    public static final int DIALOG_CARD_INFO_NEED_FILL_IN = 40;
    public static final int DIALOG_CARD_INFO_UPDATE_TIP = 34;
    public static final int DIALOG_CARD_NUMBER_MAYBE_ERROR = 33;
    public static final int DIALOG_CHARGE_SUCCESS_REPAYMENT_FAIL = 65;
    public static final int DIALOG_CHECK_DOCUMENT_ERROR = 66;
    public static final int DIALOG_DATE_PICKER_DIALOG = 39;
    public static final int DIALOG_EXIT_CLIENT = 4;
    public static final int DIALOG_ITP_SMS = 23;
    public static final int DIALOG_LIVING_RETRY = 54;
    public static final int DIALOG_MARKETING_BIND_CARD = 67;
    public static final int DIALOG_NEED_OPEN_CERTIFICATE = 64;
    public static final int DIALOG_PAY_QUOTA = 57;
    public static final int DIALOG_PUBLIC_SECURITY_AUTH_NOT_EXIST = 38;
    public static final int DIALOG_RNAUTH_AGE_BYOND_CERT_ALREADY_BONDED = 41;
    public static final int DIALOG_RNAUTH_NOT_EXIST_LICAI = 49;
    public static final int DIALOG_TIP_CARD_DATE = 56;
    public static final int DIALOG_TIP_CLOSE = 12;
    public static final int DIALOG_TIP_MOBILE = 13;
    public static final int DIALOG_TIP_NAME = 14;
    public static final int DIALOG_USE_OTHER_PAY_METHOND = 36;
    public static final int ERROR_RISK_DIALOG = 53;
    public static final int FLAG_ACTIVE_BIND_CARD = 2;
    public static final int FLAG_AUTH_FLOW = 4;
    public static final int FLAG_PAY_SKD = 1;
    public f a;

    public static String a(LinkedList<BaseActivity> linkedList) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(((Activity) it.next()).getClass().getSimpleName());
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static synchronized void exitActiveBindCard() {
        synchronized (PayBaseBeanActivity.class) {
            try {
                BaseActivity.getTopActivity().getApplicationContext();
                "exitActiveBindCard. stack size = " + BaseActivity.mActivityStack.size();
            } catch (Throwable th2) {
                th2.getClass().getName();
            }
            LogUtil.methodTrace("PayBaseBeanActivity");
            BaseActivity.clearTasksWithFlag(2);
            HalfScreenBaseActivity.resetInstanceCount();
            HalfProtocolScreenBaseActivity.resetInstanceCount();
        }
    }

    public static synchronized void exitAuthFlow() {
        synchronized (PayBaseBeanActivity.class) {
            BaseActivity.clearTasksWithFlag(4);
            HalfScreenBaseActivity.resetInstanceCount();
        }
    }

    public static synchronized void exitEbpay() {
        synchronized (PayBaseBeanActivity.class) {
            try {
                BaseActivity.getTopActivity().getApplicationContext();
                "method->exitEbpay\n mActivityStack size->" + BaseActivity.mActivityStack.size() + "\nname->" + a(BaseActivity.mActivityStack);
            } catch (Throwable th2) {
                th2.getClass().getName();
            }
            LogUtil.methodTrace("PayBaseBeanActivity");
            BaseActivity.clearTasksWithFlag(1);
            HalfScreenBaseActivity.resetInstanceCount();
        }
    }

    public f getBindCardFlagDelegate() {
        if (this.a == null) {
            this.a = new f(this);
        }
        return this.a;
    }

    public ArrayList<String> getCancelPayEventValue(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        arrayList.add(PayDataCache.getInstance().getInsideTransOrder());
        return arrayList;
    }

    public void initActionBarExt(String str) {
        initActionBar(str);
    }

    public void onBeanExecFailureWithErrContent(int i2, int i3, String str, Object obj) {
        PwdPayContract.Presenter presenter;
        if (!(this instanceof PwdPayActivity) || (presenter = ((PwdPayActivity) this).mPresenter) == null) {
            super.onBeanExecFailureWithErrContent(i2, i3, str, obj);
        } else {
            presenter.handleFailure(i2, i3, str);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAct = this;
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("direct_or_userinfo_data");
            if (serializable != null && (serializable instanceof DirectPayContentResponse)) {
                ((DirectPayContentResponse) serializable).storeResponse(this);
            }
            Serializable serializable2 = bundle.getSerializable("payrequest");
            if (serializable2 != null && (serializable2 instanceof PayRequest)) {
                PayRequest payRequest = (PayRequest) serializable2;
                PayRequestCache.getInstance().addBeanRequestToCache(payRequest.getRequestId(), payRequest);
            }
            Serializable serializable3 = bundle.getSerializable("bindfastrequest");
            if (serializable3 != null && (serializable3 instanceof BindFastRequest)) {
                BindFastRequest bindFastRequest = (BindFastRequest) serializable3;
                PayRequestCache.getInstance().addBeanRequestToCache(bindFastRequest.getRequestId(), bindFastRequest);
            }
        }
    }

    public Dialog onCreateDialog(int i2) {
        "onCreateDialog. id = " + i2;
        if (i2 == 13) {
            return new PromptTipDialog(getActivity());
        }
        if (i2 == 23) {
            return new IdentifyCodeGetFailDialog(getActivity());
        }
        if (i2 != 34 && i2 != 35) {
            return super.onCreateDialog(i2);
        }
        PromptMultiBtnDialog promptMultiBtnDialog = new PromptMultiBtnDialog(this);
        promptMultiBtnDialog.setNewDialogStyle(false);
        return promptMultiBtnDialog;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        "onPrepareDialog. id = " + i2;
        if (i2 == 4) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setCanceledOnTouchOutside(false);
            String detainmentDesc = PayDataCache.getInstance().getDetainmentDesc();
            if (TextUtils.isEmpty(detainmentDesc)) {
                detainmentDesc = ResUtils.getString(getActivity(), "ebpay_confirm_abandon_pay");
            }
            promptDialog.setMessage((CharSequence) detainmentDesc);
            StatHelper.statServiceEvent("cancelDoPayAlert", (Map<String, Object>) null, detainmentDesc, PayDataCache.getInstance().getInsideTransOrder());
            promptDialog.setNegativeBtn(ResUtils.string(getActivity(), "dxm_ebpay_cancel"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PayBaseBeanActivity.this, 4);
                }
            });
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "ebpay_abandon_pay"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PayBaseBeanActivity.this, 4);
                    BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getRequest(PayRequestCache.BindCategory.Other);
                    if (bindFastRequest != null && bindFastRequest.mBindFrom == 0) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(StatHelper.HASH_NAME, BindCardImplActivity.PAY_BIND_CARD_HASH_NAME);
                        hashMap.put("hash", BindCardImplActivity.PAY_BIND_CARD_HASH_ID);
                        hashMap.put(StatHelper.EVENT_TAG, "绑卡失败");
                        hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
                        hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
                        hashMap.put(StatHelper.EVENT_PATH, "paySDK_pay_bind_card_failed");
                        hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_BIND_CARD_FAILED, hashMap, StatHelper.SENSOR_ERR_2, "payBindCardCancel");
                        StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "payBindCardCancel");
                        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_BIND_CARD_DURATION, (Map<String, Object>) null, new String[0]);
                    }
                    if (!PayDataCache.getInstance().isFromPreCashier()) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.STD_PAY_CANCEL);
                    }
                    PayCallBackManager.callBackClientCancel(PayBaseBeanActivity.this, "PayBaseBeanActivity.onPrepareDialog().1");
                }
            });
        } else if (i2 != 12) {
            super.onPrepareDialog(i2, dialog);
        } else {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage((CharSequence) this.mDialogMsg);
            promptDialog2.setCanceledOnTouchOutside(false);
            promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(PayBaseBeanActivity.this, 12);
                }
            });
            promptDialog2.hideNegativeButton();
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse != null) {
            bundle.putSerializable("direct_or_userinfo_data", payResponse);
        }
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (payRequest != null) {
            bundle.putSerializable("payrequest", payRequest);
        }
        BindFastRequest bindFastRequest = (BindFastRequest) PayRequestCache.getInstance().getBeanRequestFromCache(PayRequestCache.BindCategory.Other.name());
        if (bindFastRequest != null) {
            bundle.putSerializable("bindfastrequest", bindFastRequest);
        }
        super.onSaveInstanceState(bundle);
    }

    public void setFlagActiveBindCard() {
        this.mFlag |= 2;
    }

    public void setFlagAuthFlow() {
        this.mFlag |= 4;
    }

    public void setFlagPaySdk() {
        this.mFlag |= 1;
    }
}
