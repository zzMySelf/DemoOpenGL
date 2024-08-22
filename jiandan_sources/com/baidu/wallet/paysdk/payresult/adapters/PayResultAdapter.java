package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import android.os.CountDownTimer;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.core.BaseActivity;
import java.lang.ref.WeakReference;

public class PayResultAdapter extends BasePayResultAdapter {
    public CountDownTimer d;

    public PayResultAdapter(BaseActivity baseActivity) {
        super(baseActivity);
        this.a = new WeakReference<>(baseActivity);
    }

    public void handleOKBtnOnclick() {
        PayResultContent payResultContent = this.c;
        if (payResultContent == null) {
            PayCallBackManager.callBackClientPaying(((BaseActivity) this.a.get()).getActivity());
        } else if (payResultContent.isPaySuccess) {
            PayRequest payRequest = this.b;
            if (payRequest == null || !DxmPayBeanConstants.PAY_FROM_B_SAO_C.equals(payRequest.mPayFrom)) {
                PayCallBackManager.callBackClientSuccess(((BaseActivity) this.a.get()).getActivity(), this.c.notify);
                return;
            }
            GlobalUtils.hideKeyboard(((BaseActivity) this.a.get()).getActivity());
            a(DxmPayBeanConstants.EV_SCANCODE_EXIT, this.c.notify);
        } else {
            PayCallBackManager.callBackClientPaying(((BaseActivity) this.a.get()).getActivity());
        }
    }

    public boolean onCreateCheckInvalide(Bundle bundle) {
        PayRequest payRequest;
        super.onCreateCheckInvalide(bundle);
        if (this.c == null || (payRequest = this.b) == null) {
            return false;
        }
        if (!DxmPayBeanConstants.PAY_FROM_B_SAO_C.equals(payRequest.mPayFrom) || BaiduPay.getInstance().getScanCallback() == null) {
            return true;
        }
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.d = null;
        }
        AnonymousClass1 r0 = new CountDownTimer(3000, 1000) {
            public void onFinish() {
                GlobalUtils.hideKeyboard(((BaseActivity) PayResultAdapter.this.a.get()).getActivity());
                PayResultAdapter payResultAdapter = PayResultAdapter.this;
                payResultAdapter.a(DxmPayBeanConstants.EV_SCANCODE_EXIT, payResultAdapter.c.notify);
            }

            public void onTick(long j) {
            }
        };
        this.d = r0;
        r0.start();
        return true;
    }
}
