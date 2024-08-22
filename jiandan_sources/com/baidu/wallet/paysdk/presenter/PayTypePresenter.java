package com.baidu.wallet.paysdk.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.contract.PayTypeContract;
import com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.PayTypeActivity;
import com.baidu.wallet.paysdk.ui.widget.PayTypeItemView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.wallet.core.beans.sm.SMManagerDelegate;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.StatHelper;

public class PayTypePresenter extends PayTypeContract.Presenter {
    public static final String TAG = "PayTypePresenter";

    public PayTypePresenter(PayTypeActivity payTypeActivity) {
        super(payTypeActivity);
    }

    public void afterCalculatePayamountGotoNext() {
        this.mActivity.gotoOrderConfim();
    }

    public void modifyPayType(PayTypeItemView.PayTypeItemViewData payTypeItemViewData) {
        PayRequest payRequest;
        PayData.DirectPayPay directPayPay;
        PayData.EasyPay easyPay;
        super.modifyPayType(payTypeItemViewData);
        if (payTypeItemViewData != null) {
            if (payTypeItemViewData.isChecked) {
                this.mActivity.gotoOrderConfim();
            } else if (payTypeItemViewData.type == PayTypeItemView.ItemViewType.ADD_NEWCARD) {
                StatHelper.cachePayType(0);
                StatHelper.cachePayWay(4);
                PayRequest payRequest2 = this.mPayRequest;
                if (payRequest2 != null) {
                    payRequest2.setPayWay(3);
                }
                DirectPayContentResponse payResponse = PayDataCache.getInstance().getPayResponse();
                boolean z = !TextUtils.isEmpty(new SMManagerDelegate().getUserKeyId(this.mActivity));
                if (payResponse == null || (directPayPay = payResponse.pay) == null || (easyPay = directPayPay.easypay) == null || easyPay.need_cfca != 1 || z) {
                    this.mActivity.gotoPwdPay(true);
                } else {
                    WalletGlobalUtils.safeShowDialog(this.mActivity, 64, "");
                }
            } else if (PayDataCache.getInstance().needCalcPayment() || (payRequest = this.mPayRequest) == null) {
                calculatePayAmount(payTypeItemViewData);
            } else {
                payRequest.calcPayPriceByLocal(payTypeItemViewData);
                this.mActivity.gotoOrderConfim();
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 1) {
            reOrderPay();
        }
    }

    public void onBackPressed() {
        EventBus instance = EventBus.getInstance();
        EventBus instance2 = EventBus.getInstance();
        instance2.getClass();
        instance.postStickyEvent(new EventBus.Event("order_confirm_event_bus_key", (Object) null));
    }

    public void onCreate(Bundle bundle) {
        this.mActivity.reFreshUI(getNormalPayTypeListData());
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
    }

    public void reOrderPay() {
        BaiduPayDelegate.getInstance().reOrderPay(this.mActivity);
    }
}
