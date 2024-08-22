package com.baidu.wallet.paysdk.presenter;

import android.content.Context;
import android.os.Bundle;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.d;
import com.baidu.wallet.paysdk.contract.CouponListContract;
import com.baidu.wallet.paysdk.datamodel.CalcPaymentResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.CouponListActivity;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import java.util.ArrayList;

public class CouponListPresenter extends CouponListContract.Presenter {
    public static final String TAG = "CouponListPresenter";
    public boolean isFromActivityJump;
    public CouponListActivity mActivity;
    public PayRequest mPayRequest = ((PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY));

    public static class a {
        public String a;
        public int b;
        public int c;
        public String d;
        public String e;
        public String f;
        public boolean g;
        public boolean h;
    }

    public CouponListPresenter(CouponListActivity couponListActivity) {
        super(couponListActivity);
        this.mActivity = couponListActivity;
        couponListActivity.setPresenter((CouponListContract.Presenter) this);
    }

    public void calcPayamount(a aVar) {
        if (aVar == null || aVar.b != -1) {
            this.mActivity.setPageClickable(false);
        } else {
            this.mActivity.showLoading(0);
        }
        d dVar = (d) PayBeanFactory.getInstance().getBean((Context) this.mActivity, 16, TAG);
        if (aVar != null) {
            this.isFromActivityJump = false;
            dVar.a(aVar.c, aVar.b, !aVar.h ? "4" : "0");
        } else {
            this.isFromActivityJump = true;
        }
        dVar.setResponseCallback(this);
        dVar.execBean();
    }

    public void handleFailure(int i2, int i3, String str) {
        WalletGlobalUtils.safeDismissDialog(this.mActivity, 0);
        GlobalUtils.toast(this.mActivity, str);
        this.mActivity.setPageClickable(true);
        if (this.isFromActivityJump) {
            this.mActivity.returnToPreviousPage();
        } else {
            this.mActivity.revertItemView();
        }
        this.isFromActivityJump = false;
    }

    public void handleResponse(int i2, Object obj, String str) {
        CouponListActivity couponListActivity = this.mActivity;
        if (couponListActivity != null) {
            int i3 = 0;
            couponListActivity.dismissLoading(0);
            this.isFromActivityJump = false;
            if (i2 == 16) {
                CalcPaymentResponse calcPaymentResponse = null;
                if (obj instanceof CalcPaymentResponse) {
                    calcPaymentResponse = (CalcPaymentResponse) obj;
                }
                if (calcPaymentResponse != null) {
                    PayRequest payRequest = this.mPayRequest;
                    if (payRequest != null) {
                        payRequest.setCalcPayment(calcPaymentResponse);
                        this.mPayRequest.calcPayPriceByRemote(calcPaymentResponse);
                    }
                    ArrayList arrayList = new ArrayList();
                    if (calcPaymentResponse.coupon_list != null) {
                        for (int i4 = 0; i4 < calcPaymentResponse.coupon_list.length; i4++) {
                            a aVar = new a();
                            PayData.Coupon[] couponArr = calcPaymentResponse.coupon_list;
                            aVar.a = couponArr[i4].icon_url;
                            aVar.b = i4;
                            aVar.c = 2;
                            aVar.d = couponArr[i4].description;
                            aVar.e = couponArr[i4].discount_msg;
                            aVar.f = couponArr[i4].select_state_desc;
                            aVar.g = couponArr[i4].getEnable();
                            aVar.h = calcPaymentResponse.coupon_list[i4].getSelected();
                            arrayList.add(aVar);
                        }
                    }
                    if (calcPaymentResponse.activity_list != null) {
                        while (true) {
                            PayData.Discount[] discountArr = calcPaymentResponse.activity_list;
                            if (i3 >= discountArr.length) {
                                break;
                            }
                            if (discountArr[i3].isCommonDiscount()) {
                                a aVar2 = new a();
                                PayData.Discount[] discountArr2 = calcPaymentResponse.activity_list;
                                aVar2.a = discountArr2[i3].icon_url;
                                aVar2.b = i3;
                                aVar2.c = 1;
                                aVar2.d = discountArr2[i3].description;
                                aVar2.e = discountArr2[i3].discount_msg;
                                aVar2.f = discountArr2[i3].select_state_desc;
                                aVar2.g = discountArr2[i3].getEnable();
                                aVar2.h = calcPaymentResponse.activity_list[i3].getSelected();
                                arrayList.add(aVar2);
                            }
                            i3++;
                        }
                    }
                    this.mActivity.reFreshUI((ArrayList<a>) arrayList);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.isFromActivityJump = bundle.getBoolean("isFromActivityJump", false);
        }
    }

    public void onDestroy() {
        BeanManager.getInstance().removeAllBeans(TAG);
        this.mActivity = null;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.putSerializable("isFromActivityJump", Boolean.valueOf(this.isFromActivityJump));
        }
    }
}
