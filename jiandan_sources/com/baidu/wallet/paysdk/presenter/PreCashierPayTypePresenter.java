package com.baidu.wallet.paysdk.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.contract.PayTypeContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StringUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class PreCashierPayTypePresenter extends PayTypeContract.Presenter {
    public static final String BALANCE = "balance";
    public static final String DEFAULT_PAY_DATA = "default_pay_data";
    public static final String EASYPAY = "easypay";
    public static final String TAG = "PreCashierPayTypePresenter";
    public PrecashierModifyPayTypeManager.TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> mTupleDatasForPrecashier;

    public PreCashierPayTypePresenter(PayTypeActivity payTypeActivity) {
        super(payTypeActivity);
    }

    private ArrayList<PayTypeItemView.PayTypeItemViewData> getData() {
        if (!isFromClickChangePayType()) {
            return getNormalPayTypeListData();
        }
        PrecashierModifyPayTypeManager.TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier = this.mTupleDatasForPrecashier;
        return twoTupleForPrecashier == null ? new ArrayList<>() : getPrecashierData((PrecashierModifyPayTypeDefaultData) twoTupleForPrecashier.datas);
    }

    private boolean isFromClickChangePayType() {
        PrecashierModifyPayTypeManager.TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier = this.mTupleDatasForPrecashier;
        return twoTupleForPrecashier != null && twoTupleForPrecashier.isFromChange().booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
        r5 = r5.pay;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void noticePayTypeChanged(com.baidu.wallet.paysdk.ui.widget.PayTypeItemView.PayTypeItemViewData r5) {
        /*
            r4 = this;
            com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$ItemViewType r0 = r5.type
            com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$ItemViewType r1 = com.baidu.wallet.paysdk.ui.widget.PayTypeItemView.ItemViewType.ADD_NEWCARD
            if (r0 != r1) goto L_0x002e
            com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager r5 = com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager.getInstance()
            java.lang.String r5 = r5.getSpNo()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = com.dxmpay.wallet.utils.StatHelper.getProcesssId()
            r0.add(r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "sp_no"
            r1.put(r2, r5)
            java.lang.String r2 = "pre_initiative_bind_card"
            com.dxmpay.wallet.statistics.api.StatisticManager.onEventEndWithValues((java.lang.String) r2, (java.util.Collection<java.lang.String>) r0, (java.util.Map<java.lang.String, java.lang.Object>) r1)
            r4.doBindCard(r5)
            goto L_0x00a4
        L_0x002e:
            com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$ItemViewType r1 = com.baidu.wallet.paysdk.ui.widget.PayTypeItemView.ItemViewType.BALANCE
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 == 0) goto L_0x005b
            com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse r5 = com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse.getInstance()
            if (r5 == 0) goto L_0x0044
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r5 = r5.pay
            if (r5 == 0) goto L_0x0044
            com.baidu.wallet.base.datamodel.PayData$DirectPayBalance r5 = r5.balance
            goto L_0x0045
        L_0x0044:
            r5 = r1
        L_0x0045:
            com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData r0 = new com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData
            r0.<init>()
            if (r5 == 0) goto L_0x0053
            java.lang.String r5 = r5.balance_amount
            java.lang.String r2 = "balance"
            r0.setDatas(r2, r5, r1)
        L_0x0053:
            com.baidu.wallet.base.controllers.PayController r5 = com.baidu.wallet.base.controllers.PayController.getInstance()
            r5.onPreModifiedPayType(r0)
            goto L_0x009f
        L_0x005b:
            com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$ItemViewType r0 = r5.type
            com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$ItemViewType r2 = com.baidu.wallet.paysdk.ui.widget.PayTypeItemView.ItemViewType.BANKCARD
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x009f
            com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData r0 = new com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData
            r0.<init>()
            com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData$Card r2 = new com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData$Card
            r2.<init>()
            com.baidu.wallet.base.datamodel.CardData$BondCard r5 = r5.card
            if (r5 == 0) goto L_0x0093
            java.lang.String r3 = r5.account_no
            r2.account_no = r3
            java.lang.String r3 = r5.bank_name
            r2.bank_name = r3
            java.lang.String r3 = r5.single_quota
            r2.single_quota = r3
            java.lang.String r3 = r5.bank_url
            r2.bank_url = r3
            com.baidu.wallet.base.datamodel.CardData$BondCard$ChannelQuota r5 = r5.channel_quota
            if (r5 == 0) goto L_0x0093
            java.lang.String r3 = r5.single_limit
            r2.single_limit = r3
            java.lang.String r3 = r5.day_limit
            r2.day_limit = r3
            java.lang.String r5 = r5.month_limit
            r2.month_limit = r5
        L_0x0093:
            java.lang.String r5 = "easypay"
            r0.setDatas(r5, r1, r2)
            com.baidu.wallet.base.controllers.PayController r5 = com.baidu.wallet.base.controllers.PayController.getInstance()
            r5.onPreModifiedPayType(r0)
        L_0x009f:
            com.baidu.wallet.paysdk.ui.PayTypeActivity r5 = r4.mActivity
            r5.finish()
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.presenter.PreCashierPayTypePresenter.noticePayTypeChanged(com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$PayTypeItemViewData):void");
    }

    private void toCalculatePayAmount(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        PayRequest payRequest;
        if (payTypeItemViewData != null) {
            if (payTypeItemViewData.isChecked) {
                this.mActivity.gotoPwdPay(false);
            } else if (payTypeItemViewData.type == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                PayRequest payRequest2 = this.mPayRequest;
                if (payRequest2 != null) {
                    payRequest2.setPayWay(3);
                }
                this.mActivity.gotoPwdPay(true);
            } else if (PayDataCache.getInstance().needCalcPayment() || (payRequest = this.mPayRequest) == null) {
                calculatePayAmount(payTypeItemViewData);
            } else {
                payRequest.calcPayPriceByLocal(payTypeItemViewData);
                this.mActivity.gotoPwdPay(false);
            }
        }
    }

    public void afterCalculatePayamountGotoNext() {
        this.mActivity.gotoPwdPay(false);
    }

    public void doBindCard(String str) {
        String str2;
        AnonymousClass1 r2 = new BaiduPay.IBindCardCallback() {
            public void onChangeFailed(String str) {
                if (PreCashierPayTypePresenter.this.mActivity != null) {
                    GlobalUtils.toast(PreCashierPayTypePresenter.this.mActivity.getApplicationContext(), str);
                }
            }

            public void onChangeSucceed(String str) {
                PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData = new PrecashierModifyPayTypeDefaultData();
                precashierModifyPayTypeDefaultData.updated = 1;
                PrecashierModifyPayTypeDefaultData.Card card = new PrecashierModifyPayTypeDefaultData.Card();
                card.account_no = str;
                precashierModifyPayTypeDefaultData.card = card;
                PayController.getInstance().onPreModifiedPayType(precashierModifyPayTypeDefaultData);
                if (PreCashierPayTypePresenter.this.mActivity != null) {
                    PreCashierPayTypePresenter.this.mActivity.finish();
                }
            }
        };
        PrecashierModifyPayTypeResponse instance = PrecashierModifyPayTypeResponse.getInstance();
        if (instance == null || TextUtils.isEmpty(instance.getHdSessionId())) {
            str2 = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("hd_session_id");
            stringBuffer.append("=");
            stringBuffer.append(instance.getHdSessionId());
            str2 = StringUtil.urlParam2JsonStr(stringBuffer.toString());
        }
        BaiduPay.getInstance().bindCard(this.mActivity, r2, PayRequestCache.BindCategory.Initiative, 1, "2000", str, (Bundle) null, str2, true, DxmPayBeanConstants.FROM_BIND);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0047, code lost:
        r5 = r2.pay;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.baidu.wallet.paysdk.ui.widget.PayTypeItemView.PayTypeItemViewData> getPrecashierData(com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData r12) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$PayTypeItemViewData r1 = new com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$PayTypeItemViewData
            r1.<init>()
            com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$ItemViewType r2 = com.baidu.wallet.paysdk.ui.widget.PayTypeItemView.ItemViewType.BALANCE
            r1.type = r2
            com.baidu.wallet.paysdk.ui.PayTypeActivity r2 = r11.mActivity
            java.lang.String r3 = "ebpay_pwdpay_balance_txt"
            java.lang.String r2 = com.dxmpay.apollon.utils.ResUtils.getString(r2, r3)
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            com.baidu.wallet.paysdk.storage.PayDataCache r5 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()
            java.lang.String r5 = r5.getCanAmount()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            java.lang.String r6 = ""
            if (r5 != 0) goto L_0x0032
            com.baidu.wallet.paysdk.storage.PayDataCache r5 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()
            java.lang.String r5 = r5.getCanAmount()
            goto L_0x0033
        L_0x0032:
            r5 = r6
        L_0x0033:
            java.lang.String r5 = com.dxmpay.wallet.core.utils.StringUtils.fen2Yuan(r5)
            r7 = 0
            r4[r7] = r5
            java.lang.String r2 = java.lang.String.format(r2, r4)
            r1.name = r2
            com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse r2 = com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse.getInstance()
            r4 = 0
            if (r2 == 0) goto L_0x004e
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r5 = r2.pay
            if (r5 == 0) goto L_0x004e
            com.baidu.wallet.base.datamodel.PayData$DirectPayBalance r5 = r5.balance
            goto L_0x004f
        L_0x004e:
            r5 = r4
        L_0x004f:
            if (r2 == 0) goto L_0x009a
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r8 = r2.user
            if (r8 == 0) goto L_0x009a
            boolean r8 = r8.isSupportBalance()
            if (r8 == 0) goto L_0x009a
            if (r5 == 0) goto L_0x008d
            int r8 = r5.status
            if (r3 != r8) goto L_0x008d
            r1.isAvaible = r3
            java.lang.String r8 = r5.disabled_msg
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0074
            java.lang.String r8 = r5.disabled_msg
            r1.tips = r8
            java.lang.String r8 = r5.balance_jump_url
            r1.jump_url = r8
            goto L_0x00a6
        L_0x0074:
            com.baidu.wallet.paysdk.ui.PayTypeActivity r8 = r11.mActivity
            java.lang.String r9 = "ebpay_pwdpay_balance_tips"
            java.lang.String r8 = com.dxmpay.apollon.utils.ResUtils.getString(r8, r9)
            java.lang.Object[] r9 = new java.lang.Object[r3]
            java.lang.String r10 = r5.balance_amount
            java.lang.String r10 = com.dxmpay.wallet.core.utils.StringUtils.fen2Yuan(r10)
            r9[r7] = r10
            java.lang.String r8 = java.lang.String.format(r8, r9)
            r1.tips = r8
            goto L_0x00a6
        L_0x008d:
            r1.isAvaible = r7
            if (r5 == 0) goto L_0x00a6
            java.lang.String r8 = r5.disabled_msg
            r1.tips = r8
            java.lang.String r8 = r5.balance_jump_url
            r1.jump_url = r8
            goto L_0x00a6
        L_0x009a:
            r1.isAvaible = r7
            com.baidu.wallet.paysdk.storage.PayDataCache r8 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()
            java.lang.String r8 = r8.getBalanceUnSupportReason()
            r1.tips = r8
        L_0x00a6:
            java.lang.String r8 = "balance"
            if (r5 == 0) goto L_0x00c7
            java.lang.String r5 = r5.balance_amount
            boolean r5 = com.dxmpay.wallet.core.utils.StringUtils.isAmountMoreThanZero(r5)
            if (r5 == 0) goto L_0x00c4
            boolean r5 = r1.isAvaible
            if (r5 == 0) goto L_0x00c4
            if (r12 == 0) goto L_0x00c4
            java.lang.String r5 = r12.getDefaultType()
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x00c4
            r5 = 1
            goto L_0x00c5
        L_0x00c4:
            r5 = 0
        L_0x00c5:
            r1.isChecked = r5
        L_0x00c7:
            r0.add(r1)
            if (r2 != 0) goto L_0x00cd
            goto L_0x00d1
        L_0x00cd:
            com.baidu.wallet.base.datamodel.CardData$BondCard[] r4 = r2.getBondCards()
        L_0x00d1:
            if (r4 == 0) goto L_0x0185
            int r1 = r4.length
            if (r1 <= 0) goto L_0x0185
            r1 = 0
        L_0x00d7:
            int r2 = r4.length
            if (r1 >= r2) goto L_0x0185
            com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$PayTypeItemViewData r2 = new com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$PayTypeItemViewData
            r2.<init>()
            com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$ItemViewType r5 = com.baidu.wallet.paysdk.ui.widget.PayTypeItemView.ItemViewType.BANKCARD
            r2.type = r5
            r5 = r4[r1]
            java.lang.String r5 = r5.card_hint_msg
            r2.hintMsg = r5
            r5 = r4[r1]
            java.lang.String r5 = r5.card_hint_url
            r2.hintUrl = r5
            r5 = r4[r1]
            java.lang.String r5 = r5.card_state
            java.lang.String r9 = "1"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x011f
            r2.isAvaible = r3
            r5 = r4[r1]
            java.lang.String r5 = r5.bank_card_msg
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x010c
            r5 = r4[r1]
            java.lang.String r5 = r5.bank_card_msg
            goto L_0x011c
        L_0x010c:
            r5 = r4[r1]
            java.lang.String r5 = r5.quota_show_msg
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x011b
            r5 = r4[r1]
            java.lang.String r5 = r5.quota_show_msg
            goto L_0x011c
        L_0x011b:
            r5 = r6
        L_0x011c:
            r2.tips = r5
            goto L_0x0127
        L_0x011f:
            r2.isAvaible = r7
            r5 = r4[r1]
            java.lang.String r5 = r5.bank_card_msg
            r2.tips = r5
        L_0x0127:
            r5 = r4[r1]
            java.lang.String r5 = r5.bank_card_msg
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0137
            r5 = r4[r1]
            java.lang.String r5 = r5.bank_card_msg
            r2.tips = r5
        L_0x0137:
            r5 = r4[r1]
            android.content.Context r9 = r11.mContext
            java.lang.String r5 = r5.getCardDesc(r9, r3)
            r2.name = r5
            r5 = r4[r1]
            r2.card = r5
            if (r12 == 0) goto L_0x0176
            java.lang.String r5 = r12.getDefaultType()
            boolean r5 = r8.equals(r5)
            if (r5 != 0) goto L_0x0176
            com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData$Card r5 = r12.getCard()
            if (r5 == 0) goto L_0x0178
            com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData$Card r5 = r12.getCard()
            java.lang.String r9 = r5.account_no
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0178
            r9 = r4[r1]
            if (r9 == 0) goto L_0x0178
            java.lang.String r5 = r5.account_no
            r9 = r4[r1]
            java.lang.String r9 = r9.account_no
            boolean r5 = r5.equals(r9)
            if (r5 == 0) goto L_0x0178
            r2.isChecked = r3
            goto L_0x0178
        L_0x0176:
            r2.isChecked = r7
        L_0x0178:
            r5 = r4[r1]
            java.lang.String r5 = r5.bank_url
            r2.logoUrl = r5
            r0.add(r2)
            int r1 = r1 + 1
            goto L_0x00d7
        L_0x0185:
            com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$PayTypeItemViewData r12 = new com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$PayTypeItemViewData
            r12.<init>()
            com.baidu.wallet.paysdk.storage.PayDataCache r1 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()
            boolean r1 = r1.enableAddBondCards()
            r12.isAvaible = r1
            com.baidu.wallet.paysdk.ui.widget.PayTypeItemView$ItemViewType r1 = com.baidu.wallet.paysdk.ui.widget.PayTypeItemView.ItemViewType.ADD_NEWCARD
            r12.type = r1
            com.baidu.wallet.paysdk.ui.PayTypeActivity r1 = r11.mActivity
            java.lang.String r2 = "ebpay_use_new_card"
            java.lang.String r1 = com.dxmpay.apollon.utils.ResUtils.getString(r1, r2)
            r12.name = r1
            boolean r1 = r12.isAvaible
            if (r1 != 0) goto L_0x01b0
            com.baidu.wallet.paysdk.ui.PayTypeActivity r1 = r11.mActivity
            java.lang.String r2 = "ebpay_bankcard_fullof"
            java.lang.String r1 = com.dxmpay.apollon.utils.ResUtils.getString(r1, r2)
            r12.tips = r1
        L_0x01b0:
            r0.add(r12)
            r11.sortData(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.presenter.PreCashierPayTypePresenter.getPrecashierData(com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeDefaultData):java.util.ArrayList");
    }

    public void handleResponse(int i2, Object obj, String str) {
        super.handleResponse(i2, obj, str);
        if (i2 == 16) {
            this.mActivity.reFreshUI(getData());
        }
    }

    public void modifyPayType(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        if (payTypeItemViewData != null) {
            if (isFromClickChangePayType()) {
                noticePayTypeChanged(payTypeItemViewData);
            } else {
                toCalculatePayAmount(payTypeItemViewData);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 1) {
            return;
        }
        if (isFromClickChangePayType()) {
            PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData = new PrecashierModifyPayTypeDefaultData();
            precashierModifyPayTypeDefaultData.updated = 1;
            PayController.getInstance().onPreModifiedPayType(precashierModifyPayTypeDefaultData);
            PayBaseBeanActivity.exitEbpay();
            this.mActivity.finish();
            return;
        }
        reOrderPay();
    }

    public void onBackPressed() {
        LinkedList<BaseActivity> linkedList;
        if (PayDataCache.getInstance().isFromPreCashier()) {
            if (PayController.getInstance().getModifyPayTypeCallback() != null) {
                PayController.getInstance().getModifyPayTypeCallback().onPayTypeModifiedFailed(-1, "");
            }
            PayController.getInstance().clearPreModifiedCallBack();
            PrecashierModifyPayTypeManager.TwoTupleForPrecashier<Boolean, PrecashierModifyPayTypeDefaultData> twoTupleForPrecashier = this.mTupleDatasForPrecashier;
            if ((twoTupleForPrecashier != null && !twoTupleForPrecashier.isFromChange().booleanValue()) || (PayRequestCache.getInstance().isPaying() && (linkedList = BaseActivity.mActivityStack) != null && linkedList.size() == 1)) {
                PayCallBackManager.callBackClientCancel(this.mActivity, "PreCashierPayTypePresenteronBackPressed().1");
            }
        }
    }

    public void onCreate(Bundle bundle) {
        if (bundle == null) {
            this.mTupleDatasForPrecashier = (PrecashierModifyPayTypeManager.TwoTupleForPrecashier) this.mActivity.getIntent().getSerializableExtra(DEFAULT_PAY_DATA);
        } else {
            Serializable serializable = bundle.getSerializable("tuple_datas_for_precashier");
            if (serializable != null && (serializable instanceof PrecashierModifyPayTypeManager.TwoTupleForPrecashier)) {
                this.mTupleDatasForPrecashier = (PrecashierModifyPayTypeManager.TwoTupleForPrecashier) serializable;
            }
        }
        this.mActivity.reFreshUI(getData());
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getInstance().unregister(this);
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("tuple_datas_for_precashier", this.mTupleDatasForPrecashier);
    }

    public void reOrderPay() {
        PayRequestCache.getInstance().clearPaySdkRequestCache();
        PayBaseBeanActivity.exitEbpay();
        StatisticManager.onEvent("doPreCashierReorder");
        PrecashierModifyPayTypeDefaultData precashierModifyPayTypeDefaultData = new PrecashierModifyPayTypeDefaultData();
        precashierModifyPayTypeDefaultData.updated = 1;
        PayController.getInstance().onPreModifiedPayType(precashierModifyPayTypeDefaultData);
        this.mActivity.finish();
    }
}
