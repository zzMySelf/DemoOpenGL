package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.Withholding;
import com.baidu.wallet.paysdk.a.b;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.fingerprint.FpConstancts;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.SysFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.dxmpay.apollon.utils.EncodeUtils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.StringUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URLDecoder;

public class PayRequest extends BeanRequestBase implements Serializable {
    public static final String CASHIER_TYPE_ZHUAN_ZHANG = "1";
    public static final int FINGERPRINT_PAY = 2;
    public static final int FP_OPEN = 1;
    public static final int FP_REOPEN = 2;
    public static final int FP_UPGRADE = 3;
    public static final int PASSFREE_PAY = 1;
    public static final int PWD_PAY = 3;
    public static final String TAG = "PayRequest";
    public static final long serialVersionUID = 7746294089503922286L;
    public int FP_Guide_Strategy;
    public boolean isContinuePay = false;
    public boolean isPayByMktSolution = false;
    public String mBankCardNumber;
    public CardData.BondCard mBondCard;
    public CalcPaymentResponse mCalcPayMent;
    public String mCashierType;
    public String mChannelNo = "";
    public String mCvv2;
    public IFingerprintPay mFingerprintPay;
    public int mFlagOpenPassFree = 0;
    public String mGoodName;
    public String mGoodsCategory;
    public String mIdCard;
    public String mLivingKey;
    public String mLivingResultCode;
    public ErrorContentResponse.MktSolution mMktSolution;
    public String mOrderNo;
    public String mOtpReuseCode;
    public String mParams;
    public String mPayFrom = "";
    public String mPayFromFromH5;
    public PayPrice mPayPrice;
    public String mPrice;
    public String mRemotePayHostName;
    public String mRemotePayUserAccountName;
    public String mRemotePayUserId;
    public String mRemotePkg;
    public String mRemoteWhereToBackAct;
    public String mSecurityParams;
    public String mSmsCode;
    public String mSpNO;
    public String mUseVcodeToPay = null;
    public String otp_seed;
    public int payWay = 3;
    public PayData.RandomDiscount randomDiscount;
    public String sp_voice_info = "";
    public boolean supportFingerprintPay;
    public String title_url;
    public String verify_type = "";
    public Withholding withholding;
    public String withholding_auth;

    public static class PayPrice implements Serializable {
        public String availableCredit = "0";
        public boolean balanceIsEnable;
        public String balanceJumpUrl;
        public String balancePayAmount;
        public String balanceTip;
        public String balanceTotalAmount;
        public String balanceTransAmount;
        public boolean creditIsEnable = true;
        public String creditPayAmount;
        public String creditTip;
        public String easyPrice;
        public String easyTipFromCalc;
        public boolean easypayIsEnable;
        public String licaiBalancePrice;
        public PayType payType;

        public enum PayType {
            BANKCARD,
            BALANCE,
            CREIDT,
            LICAIBALANCE
        }

        public PayPrice() {
            reset();
        }

        public void reset() {
            this.payType = PayType.BANKCARD;
            this.balanceIsEnable = false;
            this.balanceTip = "";
            this.balancePayAmount = "0";
            this.balanceJumpUrl = "";
            this.creditIsEnable = true;
            this.creditPayAmount = "0";
            this.creditTip = "";
            this.easypayIsEnable = false;
            this.easyPrice = "0";
            this.easyTipFromCalc = "";
            this.balanceTotalAmount = PayDataCache.getInstance().getTotalBalance();
            this.balanceTransAmount = "";
            this.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
        }

        public String toString() {
            PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
            if (payRequest == null) {
                return "oh, return super.toString = " + super.toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(" ： payType= ");
            sb.append(this.payType);
            sb.append("\r\n && easypayIsEnable=");
            sb.append(this.easypayIsEnable);
            sb.append(" && bondCard=");
            CardData.BondCard bondCard = payRequest.mBondCard;
            sb.append(bondCard != null ? bondCard.account_no : "NULL");
            sb.append(" && easyPrice=");
            sb.append(this.easyPrice);
            sb.append(" && easyTip=");
            sb.append(this.easyTipFromCalc);
            sb.append(" \r\n && balanceIsEnable=");
            sb.append(this.balanceIsEnable);
            sb.append(" && balanceTransAmount=");
            sb.append(this.balanceTransAmount);
            sb.append(" && balancePayAmount=");
            sb.append(this.balancePayAmount);
            sb.append(" && balanceTip=");
            sb.append(this.balanceTip);
            sb.append(" \r\n && creditIsEnable=");
            sb.append(this.creditIsEnable);
            sb.append(" && creditPayAmount=");
            sb.append(this.creditPayAmount);
            sb.append(" && creditTip=");
            sb.append(this.creditTip);
            sb.append(" && availableCredit");
            sb.append(this.availableCredit);
            return sb.toString();
        }
    }

    private void balancePay() {
        PayPrice payPrice = this.mPayPrice;
        payPrice.payType = PayPrice.PayType.BALANCE;
        payPrice.licaiBalancePrice = "0";
        payPrice.balanceIsEnable = true;
        payPrice.balancePayAmount = this.mPrice;
        payPrice.balanceTransAmount = getBalanceTransAmount();
        PayPrice payPrice2 = this.mPayPrice;
        payPrice2.balanceTip = "";
        payPrice2.balanceJumpUrl = "";
        payPrice2.easypayIsEnable = PayDataCache.getInstance().canUseEasypay();
        PayPrice payPrice3 = this.mPayPrice;
        payPrice3.easyPrice = "0";
        payPrice3.easyTipFromCalc = "";
        PayDataCache.b<Boolean, String> canUseCredit = PayDataCache.getInstance().canUseCredit();
        this.mPayPrice.creditIsEnable = ((Boolean) canUseCredit.a).booleanValue();
        PayPrice payPrice4 = this.mPayPrice;
        payPrice4.creditTip = (String) canUseCredit.b;
        payPrice4.creditPayAmount = "0";
        payPrice4.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
    }

    private void creditPay() {
        PayPrice payPrice = this.mPayPrice;
        payPrice.payType = PayPrice.PayType.CREIDT;
        payPrice.licaiBalancePrice = "0";
        payPrice.creditIsEnable = true;
        payPrice.creditPayAmount = this.mPrice;
        payPrice.creditTip = "";
        payPrice.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
        PayDataCache.b<Boolean, String> canUseBalance = PayDataCache.getInstance().canUseBalance();
        this.mPayPrice.balanceIsEnable = ((Boolean) canUseBalance.a).booleanValue();
        PayPrice payPrice2 = this.mPayPrice;
        payPrice2.balanceTip = (String) canUseBalance.b;
        payPrice2.balanceJumpUrl = PayDataCache.getInstance().getBalanceJumpUrl();
        PayPrice payPrice3 = this.mPayPrice;
        payPrice3.balancePayAmount = "0";
        payPrice3.balanceTransAmount = getBalanceTransAmount();
        this.mPayPrice.easypayIsEnable = PayDataCache.getInstance().canUseEasypay();
        PayPrice payPrice4 = this.mPayPrice;
        payPrice4.easyPrice = "0";
        payPrice4.easyTipFromCalc = "";
    }

    private void easypay() {
        PayPrice payPrice = this.mPayPrice;
        payPrice.payType = PayPrice.PayType.BANKCARD;
        payPrice.licaiBalancePrice = "0";
        payPrice.easypayIsEnable = true;
        payPrice.easyPrice = this.mPrice;
        CardData.BondCard selectedCard = getSelectedCard();
        this.mBondCard = selectedCard;
        if (selectedCard == null) {
            this.mBondCard = getDefaultBankCardIdx();
        }
        PayDataCache.b<Boolean, String> canUseBalance = PayDataCache.getInstance().canUseBalance();
        this.mPayPrice.balanceIsEnable = ((Boolean) canUseBalance.a).booleanValue();
        PayPrice payPrice2 = this.mPayPrice;
        payPrice2.balanceTip = (String) canUseBalance.b;
        payPrice2.balanceJumpUrl = PayDataCache.getInstance().getBalanceJumpUrl();
        PayPrice payPrice3 = this.mPayPrice;
        payPrice3.balancePayAmount = "0";
        payPrice3.balanceTransAmount = getBalanceTransAmount();
        PayDataCache.b<Boolean, String> canUseCredit = PayDataCache.getInstance().canUseCredit();
        this.mPayPrice.creditIsEnable = ((Boolean) canUseCredit.a).booleanValue();
        PayPrice payPrice4 = this.mPayPrice;
        payPrice4.creditTip = (String) canUseCredit.b;
        payPrice4.creditPayAmount = "0";
        payPrice4.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
    }

    private String getEffectiveAmount(String str) {
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    private void licaiBalancePay() {
        PayPrice payPrice = this.mPayPrice;
        payPrice.payType = PayPrice.PayType.LICAIBALANCE;
        payPrice.licaiBalancePrice = this.mPrice;
        PayDataCache.b<Boolean, String> canUseBalance = PayDataCache.getInstance().canUseBalance();
        this.mPayPrice.balanceIsEnable = ((Boolean) canUseBalance.a).booleanValue();
        PayPrice payPrice2 = this.mPayPrice;
        payPrice2.balanceTip = (String) canUseBalance.b;
        payPrice2.balancePayAmount = "0";
        payPrice2.balanceTransAmount = getBalanceTransAmount();
        this.mPayPrice.balanceJumpUrl = PayDataCache.getInstance().getBalanceJumpUrl();
        this.mPayPrice.easypayIsEnable = PayDataCache.getInstance().canUseEasypay();
        PayPrice payPrice3 = this.mPayPrice;
        payPrice3.easyPrice = "0";
        payPrice3.easyTipFromCalc = "";
        PayDataCache.b<Boolean, String> canUseCredit = PayDataCache.getInstance().canUseCredit();
        this.mPayPrice.creditIsEnable = ((Boolean) canUseCredit.a).booleanValue();
        PayPrice payPrice4 = this.mPayPrice;
        payPrice4.creditTip = (String) canUseCredit.b;
        payPrice4.creditPayAmount = "0";
        payPrice4.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
    }

    private boolean showRandomDiscount() {
        PayData.RandomDiscount randomDiscount2;
        String[] strArr;
        if (showCouponListEntry()) {
            return false;
        }
        CardData.BondCard bondCard = this.mBondCard;
        if ((bondCard == null || TextUtils.isEmpty(bondCard.channelDiscountDesc)) && (randomDiscount2 = this.randomDiscount) != null && !TextUtils.isEmpty(randomDiscount2.msg) && (strArr = this.randomDiscount.paytype) != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.randomDiscount.paytype;
                if (i2 >= strArr2.length) {
                    break;
                } else if (TextUtils.equals("balance", strArr2[i2]) && this.mPayPrice.payType == PayPrice.PayType.BALANCE) {
                    return true;
                } else {
                    if (TextUtils.equals("easypay", this.randomDiscount.paytype[i2]) && this.mPayPrice.payType == PayPrice.PayType.BANKCARD) {
                        return true;
                    }
                    i2++;
                }
            }
        }
        return false;
    }

    public void applyNoPwd(boolean z) {
        this.mFlagOpenPassFree = z ? 1 : 0;
    }

    public void calcPayPriceByLocal(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        if (payTypeItemViewData != null) {
            PayTypeItemView.ItemViewType itemViewType = payTypeItemViewData.type;
            if (itemViewType == PayTypeItemView.ItemViewType.BANKCARD) {
                this.mPayPrice.payType = PayPrice.PayType.BANKCARD;
                BigDecimal bigDecimal = new BigDecimal(this.mPrice);
                if (StringUtils.isAmountMoreThanZero(getDiscountAmount())) {
                    bigDecimal = bigDecimal.subtract(new BigDecimal(getDiscountAmount()));
                }
                this.mPayPrice.easyPrice = bigDecimal.toString();
                PayPrice payPrice = this.mPayPrice;
                payPrice.balancePayAmount = "0";
                payPrice.creditPayAmount = "0";
                this.mBondCard = payTypeItemViewData.card;
            } else if (itemViewType == PayTypeItemView.ItemViewType.BALANCE) {
                PayPrice payPrice2 = this.mPayPrice;
                payPrice2.payType = PayPrice.PayType.BALANCE;
                payPrice2.balanceIsEnable = true;
                payPrice2.balancePayAmount = this.mPrice;
                this.mBondCard = null;
                payPrice2.easyPrice = "0";
                payPrice2.creditPayAmount = "0";
            } else if (itemViewType == PayTypeItemView.ItemViewType.CREDIT) {
                PayPrice payPrice3 = this.mPayPrice;
                payPrice3.payType = PayPrice.PayType.CREIDT;
                payPrice3.creditIsEnable = true;
                payPrice3.creditPayAmount = this.mPrice;
                this.mBondCard = null;
                payPrice3.easyPrice = "0";
                payPrice3.balancePayAmount = "0";
            }
            "本地计算金额之后的payprice是： " + this.mPayPrice;
        }
    }

    public void calcPayPriceByRemote(CalcPaymentResponse calcPaymentResponse) {
        PayPrice payPrice;
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        if (calcPaymentResponse != null && (payPrice = this.mPayPrice) != null) {
            payPrice.easyPrice = calcPaymentResponse.easypay_amount;
            payPrice.easypayIsEnable = StringUtils.isAmountMoreThanZero(calcPaymentResponse.easypay_trans_amount);
            if (this.mPayPrice.easypayIsEnable && StringUtils.isAmountMoreThanZero(calcPaymentResponse.easypay_amount)) {
                this.mPayPrice.payType = PayPrice.PayType.BANKCARD;
                if (this.mBondCard == null) {
                    this.mBondCard = getDefaultBankCardIdx();
                }
            }
            PayPrice payPrice2 = this.mPayPrice;
            payPrice2.easyTipFromCalc = calcPaymentResponse.easypay_select_desc;
            String str = calcPaymentResponse.balance_amount;
            payPrice2.balancePayAmount = str;
            if (StringUtils.isAmountMoreThanZero(str)) {
                this.mPayPrice.payType = PayPrice.PayType.BALANCE;
            }
            this.mPayPrice.balanceIsEnable = StringUtils.isAmountMoreThanZero(calcPaymentResponse.balance_trans_amount);
            if (!this.mPayPrice.balanceIsEnable) {
                if (!TextUtils.isEmpty(calcPaymentResponse.balance_select_desc)) {
                    PayPrice payPrice3 = this.mPayPrice;
                    payPrice3.balanceTip = calcPaymentResponse.balance_select_desc;
                    payPrice3.balanceJumpUrl = calcPaymentResponse.balance_jump_url;
                } else {
                    DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                    if (!(payResponse == null || (directPayPay = payResponse.pay) == null || (directPayBalance = directPayPay.balance) == null || TextUtils.isEmpty(directPayBalance.disabled_msg))) {
                        PayPrice payPrice4 = this.mPayPrice;
                        PayData.DirectPayBalance directPayBalance2 = payResponse.pay.balance;
                        payPrice4.balanceTip = directPayBalance2.disabled_msg;
                        payPrice4.balanceJumpUrl = directPayBalance2.balance_jump_url;
                    }
                }
            }
            PayPrice payPrice5 = this.mPayPrice;
            payPrice5.balanceTransAmount = calcPaymentResponse.balance_trans_amount;
            String str2 = calcPaymentResponse.credit_amount;
            payPrice5.creditPayAmount = str2;
            if (StringUtils.isAmountMoreThanZero(str2)) {
                this.mPayPrice.payType = PayPrice.PayType.CREIDT;
            }
            this.mPayPrice.creditIsEnable = StringUtils.isAmountMoreThanZero(calcPaymentResponse.credit_trans_amount);
            this.mPayPrice.creditTip = calcPaymentResponse.credit_select_desc;
            "服务器计算金额之后的payprice是： " + this.mPayPrice;
        }
    }

    public boolean checkRequestValidity() {
        if (BaiduPay.PAY_FROM_BIND_CARD.equals(this.mPayFrom)) {
            if (TextUtils.isEmpty(this.mSpNO) || TextUtils.isEmpty(this.mParams)) {
                return false;
            }
            return true;
        } else if (TextUtils.isEmpty(this.mSpNO) || TextUtils.isEmpty(this.mOrderNo) || TextUtils.isEmpty(this.mPrice)) {
            return false;
        } else {
            return true;
        }
    }

    public void clearFingerPrintData() {
    }

    public void clearMktSolution() {
        this.isPayByMktSolution = false;
        this.mMktSolution = null;
    }

    public PayData.Discount[] getActivityDiscount() {
        CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
        if (calcPaymentResponse != null) {
            return calcPaymentResponse.activity_list;
        }
        return null;
    }

    public String getBalancePayAmount() {
        PayPrice payPrice = this.mPayPrice;
        return payPrice != null ? payPrice.balancePayAmount : "";
    }

    public String getBalanceSelectStatus() {
        PayPrice payPrice = this.mPayPrice;
        if (payPrice == null || !StringUtils.isAmountMoreThanZero(payPrice.balancePayAmount)) {
            return "0";
        }
        return "1";
    }

    public String getBalanceTransAmount() {
        PayData.DirectPayPay directPayPay;
        PayData.DirectPayBalance directPayBalance;
        CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
        if (calcPaymentResponse != null) {
            return calcPaymentResponse.balance_trans_amount;
        }
        DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
        if (payResponse == null || (directPayPay = payResponse.pay) == null || (directPayBalance = directPayPay.balance) == null || TextUtils.isEmpty(directPayBalance.balance_trans_amount)) {
            return "0";
        }
        if (new BigDecimal(this.mPrice).compareTo(new BigDecimal(payResponse.pay.balance.balance_trans_amount)) > 0) {
            return payResponse.pay.balance.balance_trans_amount;
        }
        return this.mPrice;
    }

    public CalcPaymentResponse getCalcPayment() {
        return this.mCalcPayMent;
    }

    public CardData.BondCard getCardByCardNo(String str) {
        CardData.BondCard[] bondCards;
        if (TextUtils.isEmpty(str) || (bondCards = PayDataCache.getInstance().getBondCards()) == null || bondCards.length <= 0) {
            return null;
        }
        for (CardData.BondCard bondCard : bondCards) {
            if (bondCard != null && str.equals(bondCard.account_no)) {
                return bondCard;
            }
        }
        return null;
    }

    public String getCreditPaySelectStatus() {
        PayPrice payPrice = this.mPayPrice;
        if (payPrice == null || !StringUtils.isAmountMoreThanZero(payPrice.creditPayAmount)) {
            return "0";
        }
        return "1";
    }

    public String getCreditTotalAmount() {
        PayPrice payPrice = this.mPayPrice;
        return payPrice != null ? payPrice.availableCredit : "0";
    }

    public CardData.BondCard getDefaultBankCardIdx() {
        CardData.BondCard[] bondCards = PayDataCache.getInstance().getBondCards();
        if (!(bondCards == null || bondCards.length == 0)) {
            boolean z = true;
            int i2 = 0;
            for (CardData.BondCard bondCard : bondCards) {
                if ("1".equals(bondCard.card_state)) {
                    if (bondCard.isCompled()) {
                        return bondCard;
                    }
                    z = false;
                }
                i2++;
            }
            if (!z && i2 >= bondCards.length) {
                return bondCards[0];
            }
        }
        return null;
    }

    public String getDiscountAmount() {
        CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
        return calcPaymentResponse != null ? calcPaymentResponse.total_discount_amount : "";
    }

    public String getDiscountMsg() {
        CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
        return calcPaymentResponse != null ? calcPaymentResponse.total_discount_msg : "";
    }

    public String getEasyPayAmount() {
        PayPrice payPrice = this.mPayPrice;
        if (payPrice == null || TextUtils.isEmpty(payPrice.easyPrice)) {
            return this.mPrice;
        }
        return this.mPayPrice.easyPrice;
    }

    public int getFP_Guide_Strategy(Context context) {
        if (((Integer) SharedPreferencesUtils.getParam(context, FpConstancts.SHAREPREFRENCE_FOR_FINGERPRINT, "resultPageShowFpCounts", 3)).intValue() <= 0) {
            return 0;
        }
        return this.FP_Guide_Strategy;
    }

    public String getFinalPayAmount() {
        if (this.mPayPrice == null) {
            return this.mPrice;
        }
        return new BigDecimal(getEffectiveAmount(this.mPayPrice.easyPrice)).add(new BigDecimal(getEffectiveAmount(this.mPayPrice.balancePayAmount))).add(new BigDecimal(getEffectiveAmount(this.mPayPrice.creditPayAmount))).add(new BigDecimal(getEffectiveAmount(this.mPayPrice.licaiBalancePrice))).toString();
    }

    public String getGoodsName() {
        return this.mGoodName;
    }

    public String getNeedToPayAmount() {
        BigDecimal bigDecimal = new BigDecimal(this.mPrice);
        CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
        if (!(calcPaymentResponse == null || calcPaymentResponse.total_discount_amount == null)) {
            bigDecimal = bigDecimal.subtract(new BigDecimal(this.mCalcPayMent.total_discount_amount));
        }
        return bigDecimal.toString();
    }

    public int getOpenPassFreeFlag() {
        return this.mFlagOpenPassFree;
    }

    public String getOrderPrice() {
        return this.mPrice;
    }

    public String getOtpReuseCode() {
        return this.mOtpReuseCode;
    }

    public String getPayFrom() {
        if (this.mPayFrom == null) {
            this.mPayFrom = "";
        }
        return this.mPayFrom;
    }

    public PayPrice getPayPrice() {
        return this.mPayPrice;
    }

    public int getPayWay() {
        return this.payWay;
    }

    public String getRandomDiscountMsg() {
        if (showRandomDiscount()) {
            return this.randomDiscount.msg;
        }
        return null;
    }

    public String getRequestId() {
        setBelongPaySdk();
        return DxmPayBeanConstants.REQUEST_ID_PAY;
    }

    public CardData.BondCard getSelectedCard() {
        CardData.BondCard[] bondCards;
        String selectedCardNo = PayDataCache.getInstance().getSelectedCardNo();
        if (TextUtils.isEmpty(selectedCardNo) || (bondCards = PayDataCache.getInstance().getBondCards()) == null || bondCards.length <= 0) {
            return null;
        }
        for (CardData.BondCard bondCard : bondCards) {
            if (bondCard != null && selectedCardNo.equals(bondCard.account_no)) {
                return bondCard;
            }
        }
        return null;
    }

    public String getmBankCardNumber() {
        return this.mBankCardNumber;
    }

    public String getmCvv2() {
        return this.mCvv2;
    }

    public String getmIdCard() {
        return this.mIdCard;
    }

    public boolean hasCashDeskCode() {
        if (!TextUtils.isEmpty(this.mParams) && this.mParams.contains("cashdesk_code")) {
            return true;
        }
        return false;
    }

    public boolean hasDiscountOrCoupon() {
        PayData.Coupon[] couponArr;
        PayData.Discount[] discountArr;
        CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
        if (calcPaymentResponse != null && (discountArr = calcPaymentResponse.activity_list) != null && discountArr.length > 0) {
            return true;
        }
        CalcPaymentResponse calcPaymentResponse2 = this.mCalcPayMent;
        if (calcPaymentResponse2 == null || (couponArr = calcPaymentResponse2.coupon_list) == null || couponArr.length <= 0) {
            return false;
        }
        return true;
    }

    public void initBalanceChargeOrder(String str) {
        this.mGoodName = "余额充值";
        this.mPrice = str;
        this.mParams = "total_amount=" + this.mPrice;
    }

    public void initBindCardOrder(String str) {
        this.mParams = str;
        if (str.contains("input_charset=1")) {
            String str2 = "";
            try {
                String decode = URLDecoder.decode(str, BeanConstants.ENCODE_GB_18030);
                "gbkParams=" + decode;
                str2 = EncodeUtils.gb180302utf8(decode);
                "转 utf8 tmpParam=" + str2;
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage(), e);
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
        }
        this.mSpNO = getSinalParam(str, "SP_NO");
        this.mOrderNo = getSinalParam(str, "ORDER_NO");
    }

    public void initOrder(String str) {
        this.mParams = str;
        if (str.contains("input_charset=1")) {
            String str2 = "";
            try {
                String decode = URLDecoder.decode(str, BeanConstants.ENCODE_GB_18030);
                "gbkParams=" + decode;
                str2 = EncodeUtils.gb180302utf8(decode);
                "转 utf8 tmpParam=" + str2;
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage(), e);
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str2;
            }
        }
        this.mSpNO = getSinalParam(str, "SP_NO");
        this.mOrderNo = getSinalParam(str, "ORDER_NO");
        this.mPrice = getSinalParam(str, "TOTAL_AMOUNT");
        this.mGoodName = getSinalParam(str, "GOODS_NAME");
        this.mGoodsCategory = getSinalParam(str, "GOODS_CATEGORY");
        if (TextUtils.isEmpty(this.mGoodName)) {
            this.mGoodName = getSinalParam(str, "GOODS_DESC");
        }
        this.mCashierType = getSinalParam(str, "CASHIER_TYPE");
        this.mPayFromFromH5 = getSinalParam(str, "PAY_FROM");
        if (isZhuanZhangCashier()) {
            this.mPayFrom = BaiduPay.PAY_FROM_HUA_ZHUAN_ZHANG;
        } else if (isSignatureCashier()) {
            this.mPayFrom = BaiduPay.PAY_FROM_AUTHORIZE;
        }
        StatHelper.cacheSpNo(this.mSpNO);
        StatHelper.cacheOrderNo(this.mOrderNo);
    }

    public void initPayStrategy(Context context) {
        this.mPayPrice = new PayPrice();
        if (PayDataCache.getInstance().hasMobilePwd()) {
            DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
            boolean z = WalletFingerprint.getInstance(context).getFingerprintPay() instanceof SysFingerprintPay;
            if (!PayDataCache.getInstance().isPassFree() && !b.a()) {
                if ("1".equalsIgnoreCase(payResponse.user.enable_fingerprint)) {
                    if (z && WalletFingerprint.getInstance(context).hasEnrollFingerprint()) {
                        if (WalletFingerprint.getInstance(context).hasOTPToken()) {
                            this.mFingerprintPay = WalletFingerprint.getInstance(context).getFingerprintPay(WalletFingerprint.FpType.SYSTEM_FINGERPRINT);
                            this.supportFingerprintPay = true;
                            setPayWay(2);
                        } else if ("1".equalsIgnoreCase(payResponse.user.guide_to_open_fingerprint)) {
                            this.FP_Guide_Strategy = 2;
                        }
                    }
                } else if (z && !WalletFingerprint.getInstance(context).hasOTPToken() && "1".equalsIgnoreCase(payResponse.user.guide_to_open_fingerprint) && WalletFingerprint.getInstance(context).hasEnrollFingerprint()) {
                    this.FP_Guide_Strategy = 1;
                }
            }
            if ("easypay".equals(PayDataCache.getInstance().getDefaultPayType())) {
                easypay();
            } else if ("balance".equals(PayDataCache.getInstance().getDefaultPayType())) {
                balancePay();
            } else if (PayDataCache.PAY_TYPE_CREDITPAY.equals(PayDataCache.getInstance().getDefaultPayType())) {
                creditPay();
            } else if (PayDataCache.PAY_TYPE_COMPOSITE.equals(PayDataCache.getInstance().getDefaultPayType())) {
                calcPayPriceByRemote(this.mCalcPayMent);
            } else if (PayDataCache.PAY_TYPE_LICAI_BALANCE.equals(PayDataCache.getInstance().getDefaultPayType())) {
                licaiBalancePay();
            } else {
                PayPrice payPrice = this.mPayPrice;
                payPrice.payType = PayPrice.PayType.BANKCARD;
                payPrice.easypayIsEnable = true;
                this.mBondCard = null;
                CalcPaymentResponse calcPaymentResponse = this.mCalcPayMent;
                if (calcPaymentResponse != null) {
                    payPrice.easyPrice = calcPaymentResponse.easypay_amount;
                    payPrice.balanceIsEnable = StringUtils.isAmountMoreThanZero(calcPaymentResponse.balance_trans_amount);
                    PayPrice payPrice2 = this.mPayPrice;
                    CalcPaymentResponse calcPaymentResponse2 = this.mCalcPayMent;
                    payPrice2.balanceTip = calcPaymentResponse2.balance_select_desc;
                    payPrice2.balanceJumpUrl = calcPaymentResponse2.balance_jump_url;
                    payPrice2.balancePayAmount = "0";
                    payPrice2.balanceTransAmount = calcPaymentResponse2.balance_trans_amount;
                    payPrice2.creditIsEnable = StringUtils.isAmountMoreThanZero(calcPaymentResponse2.credit_trans_amount);
                    PayPrice payPrice3 = this.mPayPrice;
                    payPrice3.creditTip = this.mCalcPayMent.credit_select_desc;
                    payPrice3.creditPayAmount = "0";
                    payPrice3.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
                    return;
                }
                payPrice.easyPrice = this.mPrice;
                PayDataCache.b<Boolean, String> canUseBalance = PayDataCache.getInstance().canUseBalance();
                this.mPayPrice.balanceIsEnable = ((Boolean) canUseBalance.a).booleanValue();
                PayPrice payPrice4 = this.mPayPrice;
                payPrice4.balanceTip = (String) canUseBalance.b;
                payPrice4.balanceJumpUrl = PayDataCache.getInstance().getBalanceJumpUrl();
                PayPrice payPrice5 = this.mPayPrice;
                payPrice5.balancePayAmount = "0";
                payPrice5.balanceTransAmount = getBalanceTransAmount();
                PayDataCache.b<Boolean, String> canUseCredit = PayDataCache.getInstance().canUseCredit();
                this.mPayPrice.creditIsEnable = ((Boolean) canUseCredit.a).booleanValue();
                PayPrice payPrice6 = this.mPayPrice;
                payPrice6.creditTip = (String) canUseCredit.b;
                payPrice6.creditPayAmount = "0";
                payPrice6.availableCredit = PayDataCache.getInstance().getAvailableCreditAmount();
            }
        } else {
            CalcPaymentResponse calcPaymentResponse3 = this.mCalcPayMent;
            if (calcPaymentResponse3 != null) {
                calcPayPriceByRemote(calcPaymentResponse3);
            } else {
                easypay();
            }
        }
    }

    public boolean isContinuePay() {
        return this.isContinuePay;
    }

    public boolean isSignatureCashier() {
        if (!TextUtils.isEmpty(this.mPayFromFromH5)) {
            return BaiduPay.PAY_FROM_AUTHORIZE.equals(this.mPayFromFromH5);
        }
        return false;
    }

    public String isTransfer() {
        return BaiduPay.PAY_FROM_HUA_ZHUAN_ZHANG.equals(this.mPayFrom) ? "1" : "0";
    }

    public boolean isWithHoldingValidity() {
        Withholding withholding2 = this.withholding;
        return withholding2 != null && "1".equals(withholding2.status);
    }

    public boolean isZhuanZhangCashier() {
        if (!TextUtils.isEmpty(this.mCashierType)) {
            return "1".equals(this.mCashierType);
        }
        return false;
    }

    public void revert(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        if (payTypeItemViewData.type == PayTypeItemView.ItemViewType.BANKCARD) {
            this.mPayPrice.payType = PayPrice.PayType.BANKCARD;
            BigDecimal bigDecimal = new BigDecimal(this.mPrice);
            if (StringUtils.isAmountMoreThanZero(getDiscountAmount())) {
                bigDecimal = bigDecimal.subtract(new BigDecimal(getDiscountAmount()));
            }
            this.mPayPrice.easyPrice = bigDecimal.toString();
            PayPrice payPrice = this.mPayPrice;
            payPrice.balancePayAmount = "0";
            payPrice.creditPayAmount = "0";
            this.mBondCard = payTypeItemViewData.card;
        }
    }

    public void setCalcPayment(CalcPaymentResponse calcPaymentResponse) {
        this.mCalcPayMent = calcPaymentResponse;
        if (calcPaymentResponse != null && calcPaymentResponse.activity_map != null) {
            int i2 = 0;
            while (true) {
                PayData.ChannelDiscountMap[] channelDiscountMapArr = this.mCalcPayMent.activity_map;
                if (i2 < channelDiscountMapArr.length) {
                    PayData.ChannelDiscountMap channelDiscountMap = channelDiscountMapArr[i2];
                    if ("easypay".equals(channelDiscountMap.pay_type)) {
                        String str = channelDiscountMap.card_no;
                        String str2 = channelDiscountMap.description;
                        CardData.BondCard[] bondCards = PayDataCache.getInstance().getBondCards();
                        if (bondCards != null) {
                            int length = bondCards.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= length) {
                                    break;
                                }
                                CardData.BondCard bondCard = bondCards[i3];
                                if (bondCard.account_no.equals(str)) {
                                    bondCard.channelDiscountDesc = str2;
                                    break;
                                }
                                i3++;
                            }
                        }
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void setContinuePay(boolean z) {
        this.isContinuePay = z;
    }

    public void setMktSolution(ErrorContentResponse.MktSolution mktSolution) {
        if (mktSolution != null) {
            this.isPayByMktSolution = true;
            this.mMktSolution = mktSolution;
        }
    }

    public void setOtpReuseCode(String str) {
        this.mOtpReuseCode = str;
    }

    public void setPayFrom(String str) {
        this.mPayFrom = str;
    }

    public void setPayWay(int i2) {
        this.payWay = i2;
    }

    public void setRandomDiscount(PayData.RandomDiscount randomDiscount2) {
        this.randomDiscount = randomDiscount2;
    }

    public void setmBankCardNumber(String str) {
        this.mBankCardNumber = str;
    }

    public void setmCvv2(String str) {
        this.mCvv2 = str;
    }

    public void setmIdCard(String str) {
        this.mIdCard = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r0 = r0.coupon_list;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean showCouponListEntry() {
        /*
            r6 = this;
            com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse r0 = r6.mCalcPayMent
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001d
            com.baidu.wallet.base.datamodel.PayData$Discount[] r0 = r0.activity_list
            if (r0 == 0) goto L_0x001d
            int r3 = r0.length
            if (r3 <= 0) goto L_0x001d
            int r3 = r0.length
            r4 = 0
        L_0x000f:
            if (r4 >= r3) goto L_0x001d
            r5 = r0[r4]
            boolean r5 = r5.isCommonDiscount()
            if (r5 == 0) goto L_0x001a
            return r2
        L_0x001a:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x001d:
            com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse r0 = r6.mCalcPayMent
            if (r0 == 0) goto L_0x0029
            com.baidu.wallet.base.datamodel.PayData$Coupon[] r0 = r0.coupon_list
            if (r0 == 0) goto L_0x0029
            int r0 = r0.length
            if (r0 <= 0) goto L_0x0029
            return r2
        L_0x0029:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.datamodel.PayRequest.showCouponListEntry():boolean");
    }

    public void storeFingerprintData(String str) {
        IFingerprintPay iFingerprintPay = this.mFingerprintPay;
        if (iFingerprintPay != null && (iFingerprintPay instanceof SysFingerprintPay)) {
            this.otp_seed = str;
        }
    }
}
