package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.Authorize;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.datamodel.Withholding;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.wallet.base.datamodel.UserData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class DirectPayContentResponse implements IBeanResponse, Serializable {
    public static final String HIDDEN_ADD_BANKCARD_BTN = "0";
    public static final String SHOW_ADD_BANKCARD_BTN = "1";
    public static final int STATUS_1 = 1;
    public static final long serialVersionUID = 1472548766280536579L;
    public ApplyCardEntrance[] apply_card_entrance;
    public Authorize authorize;
    public Withholding authorize_common_cashdesk;
    public String bank_card_detect_enabled;
    public String can_bind_card_flag = "1";
    public Map<String, String> cashdesk;
    public UserData.Misc misc;
    public PayData.DirectPayPay pay;
    public GetCardInfoResponse.ProtocolPlatformInfo protocol_platform_info;
    public UserData.SP sp;
    public UserData.UserModel user;

    public boolean canUsePcPwdVerify() {
        UserData.UserModel userModel = this.user;
        return userModel != null && "1".equals(userModel.can_use_pcpwd_verify);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        r2 = (r2 = r5.pay).easypay;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0060, code lost:
        if (r0.isResonseValide() != false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0088, code lost:
        if (r0.post_info != null) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean checkResponseValidity() {
        /*
            r5 = this;
            com.baidu.wallet.paysdk.storage.PayRequestCache r0 = com.baidu.wallet.paysdk.storage.PayRequestCache.getInstance()
            java.lang.String r1 = "key_pay_request"
            com.dxmpay.wallet.core.beans.BeanRequestBase r0 = r0.getBeanRequestFromCache(r1)
            com.baidu.wallet.paysdk.datamodel.PayRequest r0 = (com.baidu.wallet.paysdk.datamodel.PayRequest) r0
            r1 = 1
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            java.lang.String r2 = r0.getPayFrom()
            java.lang.String r3 = "pay_from_bind_card"
            boolean r2 = r3.equals(r2)
            r3 = 0
            if (r2 == 0) goto L_0x0024
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r5.user
            if (r0 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            return r1
        L_0x0024:
            com.dxmpay.wallet.base.datamodel.UserData$SP r2 = r5.sp
            if (r2 != 0) goto L_0x0037
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r5.user
            if (r0 == 0) goto L_0x0035
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r5.pay
            if (r0 == 0) goto L_0x0035
            com.baidu.wallet.base.datamodel.PayData$EasyPay r0 = r0.easypay
            if (r0 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r1 = 0
        L_0x0036:
            return r1
        L_0x0037:
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r2 = r5.user
            if (r2 == 0) goto L_0x0049
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r2 = r5.pay
            if (r2 == 0) goto L_0x0049
            com.baidu.wallet.base.datamodel.PayData$EasyPay r2 = r2.easypay
            if (r2 == 0) goto L_0x0049
            java.util.Map<java.lang.String, java.lang.String> r2 = r2.post_info
            if (r2 == 0) goto L_0x0049
            r2 = 1
            goto L_0x004a
        L_0x0049:
            r2 = 0
        L_0x004a:
            java.lang.String r0 = r0.getPayFrom()
            java.lang.String r4 = "pay_from_authorize"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0066
            if (r2 == 0) goto L_0x0063
            com.baidu.wallet.base.datamodel.Authorize r0 = r5.authorize
            if (r0 == 0) goto L_0x0063
            boolean r0 = r0.isResonseValide()
            if (r0 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r1 = 0
        L_0x0064:
            r2 = r1
            goto L_0x008b
        L_0x0066:
            com.baidu.wallet.paysdk.storage.PayDataCache r0 = com.baidu.wallet.paysdk.storage.PayDataCache.getInstance()
            boolean r0 = r0.isFromPreCashier()
            if (r0 == 0) goto L_0x008b
            com.baidu.wallet.paysdk.c.a r0 = com.baidu.wallet.paysdk.c.a.a()
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x008b
            com.dxmpay.wallet.base.datamodel.UserData$UserModel r0 = r5.user
            if (r0 == 0) goto L_0x0063
            com.baidu.wallet.base.datamodel.PayData$DirectPayPay r0 = r5.pay
            if (r0 == 0) goto L_0x0063
            com.baidu.wallet.base.datamodel.PayData$DirectPayBalance r0 = r0.licaibalance
            if (r0 == 0) goto L_0x0063
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.post_info
            if (r0 == 0) goto L_0x0063
            goto L_0x0064
        L_0x008b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse.checkResponseValidity():boolean");
    }

    public CardData.BondCard[] getBondCards() {
        PayData.EasyPay easyPay;
        PayData.DirectPayPay directPayPay = this.pay;
        if (directPayPay == null || (easyPay = directPayPay.easypay) == null) {
            return null;
        }
        return easyPay.bind_card_arr;
    }

    public CardData.BondCard[] getBondDebitCards() {
        PayData.EasyPay easyPay;
        PayData.DirectPayPay directPayPay = this.pay;
        if (directPayPay == null || (easyPay = directPayPay.easypay) == null || easyPay.bind_card_arr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CardData.BondCard bondCard : this.pay.easypay.bind_card_arr) {
            if (bondCard != null && bondCard.card_type == 2) {
                arrayList.add(bondCard);
            }
        }
        return (CardData.BondCard[]) arrayList.toArray(new CardData.BondCard[arrayList.size()]);
    }

    public String getDisplayName() {
        UserData.UserModel userModel = this.user;
        return (userModel == null || TextUtils.isEmpty(userModel.display_name)) ? "" : this.user.display_name;
    }

    public CardData.BondCard[] getEnableBondCards() {
        PayData.EasyPay easyPay;
        PayData.DirectPayPay directPayPay = this.pay;
        if (directPayPay == null || (easyPay = directPayPay.easypay) == null || easyPay.bind_card_arr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CardData.BondCard bondCard : this.pay.easypay.bind_card_arr) {
            if (bondCard != null && bondCard.isCompled() && "1".equals(bondCard.card_state)) {
                arrayList.add(bondCard);
            }
        }
        return (CardData.BondCard[]) arrayList.toArray(new CardData.BondCard[arrayList.size()]);
    }

    public CardData.BondCard[] getEnableCardsForFindPWD() {
        PayData.EasyPay easyPay;
        PayData.DirectPayPay directPayPay = this.pay;
        if (directPayPay == null || (easyPay = directPayPay.easypay) == null || easyPay.bind_card_arr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CardData.BondCard bondCard : this.pay.easypay.bind_card_arr) {
            if (bondCard != null && bondCard.getCanFindPWDBySms()) {
                arrayList.add(bondCard);
            }
        }
        return (CardData.BondCard[]) arrayList.toArray(new CardData.BondCard[arrayList.size()]);
    }

    public String getSpGoodsName() {
        UserData.SP sp2 = this.sp;
        return (sp2 == null || TextUtils.isEmpty(sp2.goods_name)) ? "" : this.sp.goods_name;
    }

    public String getSpName() {
        UserData.SP sp2 = this.sp;
        return (sp2 == null || TextUtils.isEmpty(sp2.sp_company)) ? "" : this.sp.sp_company;
    }

    public boolean hasBindCards() {
        PayData.EasyPay easyPay;
        CardData.BondCard[] bondCardArr;
        PayData.DirectPayPay directPayPay = this.pay;
        if (directPayPay == null || (easyPay = directPayPay.easypay) == null || (bondCardArr = easyPay.bind_card_arr) == null || bondCardArr.length <= 0) {
            return false;
        }
        return true;
    }

    public boolean hasBindDebits() {
        CardData.BondCard[] bondCardArr = this.pay.easypay.bind_card_arr;
        if (bondCardArr != null) {
            for (CardData.BondCard bondCard : bondCardArr) {
                if (bondCard != null && bondCard.card_type == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasEnableCards() {
        CardData.BondCard[] bondCardArr = this.pay.easypay.bind_card_arr;
        if (bondCardArr != null) {
            for (CardData.BondCard bondCard : bondCardArr) {
                if (bondCard != null && bondCard.isCompled() && "1".equals(bondCard.card_state)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasEnableDebits() {
        CardData.BondCard[] bondCardArr = this.pay.easypay.bind_card_arr;
        if (bondCardArr != null) {
            for (CardData.BondCard bondCard : bondCardArr) {
                if (bondCard != null && bondCard.card_type == 2 && bondCard.isCompled() && "1".equals(bondCard.card_state)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPwd() {
        return this.user.hasMobilePwd();
    }

    public boolean hasSupportCards() {
        CardData.BondCard[] bondCardArr = this.pay.easypay.bind_card_arr;
        if (bondCardArr != null) {
            for (CardData.BondCard bondCard : bondCardArr) {
                if (bondCard != null && "1".equals(bondCard.card_state)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWithHoldingValidity() {
        Withholding withholding = this.authorize_common_cashdesk;
        return withholding != null && "1".equals(withholding.status);
    }

    public void setHasPwd() {
        this.user.setHasMobilePwd();
    }

    public void storeResponse(Context context) {
        PayDataCache.getInstance().setPayResponse(this);
    }
}
