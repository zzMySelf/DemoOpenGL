package com.baidu.wallet.paysdk.presenter;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.AuthorizeSignActivity;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.utils.StringUtils;

public class b extends a {
    public b(AuthorizeSignActivity authorizeSignActivity) {
        super(authorizeSignActivity);
    }

    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.b = 1;
        } else {
            this.b = 2;
        }
    }

    public void b() {
        PayRequest payRequest;
        super.b();
        AuthorizeSignActivity authorizeSignActivity = this.a;
        if (authorizeSignActivity != null && (payRequest = authorizeSignActivity.getPayRequest()) != null) {
            String needToPayAmount = payRequest.getNeedToPayAmount();
            String orderPrice = payRequest.getOrderPrice();
            String discountAmount = payRequest.getDiscountAmount();
            String randomDiscountMsg = payRequest.getRandomDiscountMsg();
            boolean z = !TextUtils.isEmpty(StringUtils.fen2Yuan(discountAmount)) && !StringUtils.fen2Yuan(discountAmount).equals("0.00");
            SpannableString spannableString = new SpannableString(ResUtils.getString(this.a.getApplicationContext(), "dxm_wallet_base_unit") + StringUtils.fen2Yuan(orderPrice));
            if (z) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
            String str = "-" + ResUtils.getString(this.a.getApplicationContext(), "dxm_wallet_base_unit") + StringUtils.fen2Yuan(discountAmount);
            if (z) {
                this.a.updateDiscountTxt(h(), payRequest.getGoodsName(), spannableString, payRequest.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount), new View.OnClickListener() {
                    public void onClick(View view) {
                        PayController.getInstance().gotoDiscountPage(b.this.a);
                    }
                });
            } else if (!TextUtils.isEmpty(randomDiscountMsg)) {
                this.a.updateDiscountTxt(true, payRequest.getGoodsName(), (CharSequence) null, randomDiscountMsg, (CharSequence) null, StringUtils.fen2Yuan(needToPayAmount), (View.OnClickListener) null);
            } else {
                this.a.updateDiscountTxt(h(), payRequest.getGoodsName(), (CharSequence) null, payRequest.getDiscountMsg(), str, StringUtils.fen2Yuan(needToPayAmount), new View.OnClickListener() {
                    public void onClick(View view) {
                        PayController.getInstance().gotoDiscountPage(b.this.a);
                    }
                });
            }
            this.a.updateDiscountTitle(payRequest.title_url);
        }
    }

    public boolean e() {
        return true;
    }

    public boolean h() {
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        return payRequest != null && payRequest.showCouponListEntry();
    }

    public void onClick(View view) {
        super.onClick(view);
        view.getId();
        ResUtils.id(this.a.getApplicationContext(), "sign_next_btn");
    }
}
