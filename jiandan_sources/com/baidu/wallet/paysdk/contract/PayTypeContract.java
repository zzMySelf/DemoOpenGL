package com.baidu.wallet.paysdk.contract;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.d;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.presenter.NetWorkPresenter;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public interface PayTypeContract {

    public static abstract class Presenter extends NetWorkPresenter {
        public String TAG = toString();
        public PayTypeActivity mActivity;
        public PayRequest mPayRequest;

        public Presenter(PayTypeActivity payTypeActivity) {
            super(payTypeActivity);
            this.mActivity = payTypeActivity;
            payTypeActivity.setPresenter(this);
            this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        }

        private void _loadOriginalStrategy() {
            if (PayDataCache.getInstance().isPassFree()) {
                StatHelper.cachePayWay(2);
                this.mPayRequest.setPayWay(1);
            } else if (this.mPayRequest.supportFingerprintPay) {
                StatHelper.cachePayWay(1);
                this.mPayRequest.setPayWay(2);
            } else {
                StatHelper.cachePayWay(0);
                this.mPayRequest.setPayWay(3);
            }
        }

        public abstract void afterCalculatePayamountGotoNext();

        public void calculatePayAmount(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
            this.mActivity.showLoading(0);
            this.mActivity.setPageClickable(false);
            d dVar = (d) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 16, this.TAG);
            dVar.a(payTypeItemViewData);
            dVar.setResponseCallback(this);
            dVar.execBean();
        }

        public ArrayList<PayTypeItemView.PayTypeItemViewData> getNormalPayTypeListData() {
            PayData.DirectPayPay directPayPay;
            PayData.CreditPay creditPay;
            boolean z;
            ArrayList<PayTypeItemView.PayTypeItemViewData> arrayList = new ArrayList<>();
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            CardData.BondCard[] bondCards = PayDataCache.getInstance().getBondCards();
            PayRequest.PayPrice payPrice = payRequest != null ? payRequest.getPayPrice() : null;
            if (payPrice == null || payRequest == null) {
                return null;
            }
            if (bondCards != null && bondCards.length > 0) {
                for (int i2 = 0; i2 < bondCards.length; i2++) {
                    PayTypeItemView.PayTypeItemViewData payTypeItemViewData = new PayTypeItemView.PayTypeItemViewData();
                    payTypeItemViewData.type = PayTypeItemView.ItemViewType.BANKCARD;
                    payTypeItemViewData.hintMsg = bondCards[i2].card_hint_msg;
                    payTypeItemViewData.hintUrl = bondCards[i2].card_hint_url;
                    if (!"1".equals(bondCards[i2].card_state)) {
                        payTypeItemViewData.isAvaible = false;
                        payTypeItemViewData.tips = bondCards[i2].bank_card_msg;
                    } else if (!payPrice.easypayIsEnable) {
                        payTypeItemViewData.isAvaible = false;
                        payTypeItemViewData.tips = payPrice.easyTipFromCalc;
                    } else {
                        payTypeItemViewData.isAvaible = true;
                        payTypeItemViewData.tips = !TextUtils.isEmpty(bondCards[i2].bank_card_msg) ? bondCards[i2].bank_card_msg : payPrice.easyTipFromCalc;
                    }
                    payTypeItemViewData.name = bondCards[i2].getCardDesc(this.mContext, true);
                    payTypeItemViewData.card = bondCards[i2];
                    CardData.BondCard bondCard = payRequest.mBondCard;
                    if (bondCard == null || bondCard != bondCards[i2]) {
                        payTypeItemViewData.isChecked = false;
                    } else {
                        payTypeItemViewData.isChecked = true;
                    }
                    payTypeItemViewData.logoUrl = bondCards[i2].bank_url;
                    payTypeItemViewData.isRecommended = "1".equals(bondCards[i2].is_recommended);
                    arrayList.add(payTypeItemViewData);
                }
            }
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData2 = new PayTypeItemView.PayTypeItemViewData();
            payTypeItemViewData2.type = PayTypeItemView.ItemViewType.BALANCE;
            payTypeItemViewData2.name = String.format(ResUtils.getString(this.mActivity, "ebpay_pwdpay_balance_txt"), new Object[]{StringUtils.fen2Yuan(payPrice.balanceTotalAmount)});
            if (!PayDataCache.getInstance().isBalanceSupport()) {
                payTypeItemViewData2.isAvaible = false;
                payTypeItemViewData2.tips = PayDataCache.getInstance().getBalanceUnSupportReason();
            } else if (payPrice.balanceIsEnable) {
                payTypeItemViewData2.isAvaible = true;
                payTypeItemViewData2.tips = String.format(ResUtils.getString(this.mActivity, "ebpay_pwdpay_balance_tips"), new Object[]{StringUtils.fen2Yuan(payPrice.balanceTransAmount)});
                PayData.DirectPayBalance balance = PayDataCache.getInstance().getBalance();
                if (balance == null) {
                    z = false;
                } else {
                    z = "1".equals(balance.is_recommended);
                }
                payTypeItemViewData2.isRecommended = z;
            } else {
                payTypeItemViewData2.isAvaible = false;
                payTypeItemViewData2.tips = payPrice.balanceTip;
                payTypeItemViewData2.jump_url = payPrice.balanceJumpUrl;
            }
            payTypeItemViewData2.isChecked = StringUtils.isAmountMoreThanZero(payPrice.balancePayAmount);
            arrayList.add(payTypeItemViewData2);
            if (PayDataCache.getInstance().isShowCreditPay()) {
                PayTypeItemView.PayTypeItemViewData payTypeItemViewData3 = new PayTypeItemView.PayTypeItemViewData();
                payTypeItemViewData3.type = PayTypeItemView.ItemViewType.CREDIT;
                payTypeItemViewData3.isAvaible = payPrice.creditIsEnable;
                payTypeItemViewData3.name = PayDataCache.getInstance().getPayResponse().pay.credit_pay.display_name;
                if (payPrice.creditIsEnable) {
                    payTypeItemViewData3.isAvaible = true;
                    payTypeItemViewData3.tips = String.format(ResUtils.getString(this.mActivity, "ebpay_pwdpay_credit_tips"), new Object[]{StringUtils.fen2Yuan(payPrice.availableCredit)});
                } else {
                    payTypeItemViewData3.isAvaible = false;
                    if (!TextUtils.isEmpty(payPrice.creditTip)) {
                        payTypeItemViewData3.tips = payPrice.creditTip;
                    } else {
                        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                        if (!(payResponse == null || (directPayPay = payResponse.pay) == null || (creditPay = directPayPay.credit_pay) == null)) {
                            payTypeItemViewData3.tips = creditPay.disable_msg;
                        }
                    }
                }
                payTypeItemViewData3.isChecked = StringUtils.isAmountMoreThanZero(payPrice.creditPayAmount);
                arrayList.add(payTypeItemViewData3);
            }
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData4 = new PayTypeItemView.PayTypeItemViewData();
            payTypeItemViewData4.isAvaible = PayDataCache.getInstance().enableAddBondCards();
            payTypeItemViewData4.type = PayTypeItemView.ItemViewType.ADD_NEWCARD;
            payTypeItemViewData4.name = ResUtils.getString(this.mActivity, "ebpay_use_new_card");
            if (!payTypeItemViewData4.isAvaible) {
                payTypeItemViewData4.tips = ResUtils.getString(this.mActivity, "ebpay_bankcard_fullof");
            }
            arrayList.add(payTypeItemViewData4);
            sortData(arrayList);
            return arrayList;
        }

        public PayRequest getPayRequest() {
            return this.mPayRequest;
        }

        public void handleFailure(int i2, int i3, String str) {
            this.mActivity.dismissLoading(0);
            GlobalUtils.toast(this.mActivity, str);
            this.mActivity.setPageClickable(true);
        }

        public void handleResponse(int i2, Object obj, String str) {
            PayTypeItemView.PayTypeItemViewData payTypeItemViewData;
            this.mActivity.dismissLoading(0);
            this.mActivity.setPageClickable(true);
            if (i2 == 16) {
                CalcPaymentResponse calcPaymentResponse = null;
                if (obj instanceof CalcPaymentResponse) {
                    calcPaymentResponse = (CalcPaymentResponse) obj;
                }
                PayTypeItemView payTypeItemView = this.mActivity.mClickedItemView;
                if (!(payTypeItemView == null || (payTypeItemViewData = payTypeItemView.mData) == null)) {
                    this.mPayRequest.mBondCard = payTypeItemViewData.card;
                }
                this.mPayRequest.setCalcPayment(calcPaymentResponse);
                if (calcPaymentResponse != null) {
                    this.mPayRequest.calcPayPriceByRemote(calcPaymentResponse);
                }
                afterCalculatePayamountGotoNext();
            }
        }

        public void modifyPayType(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
            PayTypeItemView.ItemViewType itemViewType;
            if (payTypeItemViewData != null && (itemViewType = payTypeItemViewData.type) != PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                if (itemViewType == PayTypeItemView.ItemViewType.BANKCARD) {
                    CardData.BondCard bondCard = payTypeItemViewData.card;
                    if (bondCard == null || bondCard.isCompled()) {
                        _loadOriginalStrategy();
                        return;
                    }
                    this.mPayRequest.setPayWay(3);
                    StatHelper.cachePayWay(0);
                    return;
                }
                _loadOriginalStrategy();
            }
        }

        public abstract void onActivityResult(int i2, int i3, Intent intent);

        public abstract void onBackPressed();

        public void onDestroy() {
            BeanManager.getInstance().removeAllBeans(this.TAG);
            this.mActivity = null;
        }

        public abstract void reOrderPay();

        public void sortData(ArrayList<PayTypeItemView.PayTypeItemViewData> arrayList) {
            Collections.sort(arrayList, new Comparator<Object>() {
                public int compare(Object obj, Object obj2) {
                    PayTypeItemView.PayTypeItemViewData payTypeItemViewData;
                    int i2;
                    PayTypeItemView.PayTypeItemViewData payTypeItemViewData2 = null;
                    if (!(obj instanceof PayTypeItemView.PayTypeItemViewData) || !(obj2 instanceof PayTypeItemView.PayTypeItemViewData)) {
                        payTypeItemViewData = null;
                    } else {
                        payTypeItemViewData2 = (PayTypeItemView.PayTypeItemViewData) obj;
                        payTypeItemViewData = (PayTypeItemView.PayTypeItemViewData) obj2;
                    }
                    if (payTypeItemViewData2 == null || payTypeItemViewData == null) {
                        return -1;
                    }
                    int i3 = 2000;
                    int i4 = 1000;
                    if (payTypeItemViewData2.type == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                        i2 = 1000;
                    } else {
                        i2 = payTypeItemViewData2.isAvaible ? 2000 : 0;
                    }
                    if (payTypeItemViewData.type != PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                        if (!payTypeItemViewData.isAvaible) {
                            i3 = 0;
                        }
                        i4 = i3;
                    }
                    PayTypeItemView.ItemViewType itemViewType = payTypeItemViewData2.type;
                    if (itemViewType == PayTypeItemView.ItemViewType.BALANCE) {
                        i2 += 3;
                    } else if (itemViewType == PayTypeItemView.ItemViewType.CREDIT) {
                        i2 += 2;
                    } else if (itemViewType == PayTypeItemView.ItemViewType.BANKCARD) {
                        i2++;
                    }
                    PayTypeItemView.ItemViewType itemViewType2 = payTypeItemViewData.type;
                    if (itemViewType2 == PayTypeItemView.ItemViewType.BALANCE) {
                        i4 += 3;
                    } else if (itemViewType2 == PayTypeItemView.ItemViewType.CREDIT) {
                        i4 += 2;
                    } else if (itemViewType2 == PayTypeItemView.ItemViewType.BANKCARD) {
                        i4++;
                    }
                    return -(i2 - i4);
                }
            });
        }
    }
}
