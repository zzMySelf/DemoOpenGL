package com.baidu.wallet.paysdk.presenter;

import android.os.Bundle;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.contract.PwdPayContract;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Map;

public class PwdPayPresenterForAuthsign extends PwdPayContract.Presenter {
    public PwdPayPresenterForAuthsign(PwdPayActivity pwdPayActivity) {
        super(pwdPayActivity);
    }

    public boolean directQuit() {
        return true;
    }

    public void handleFailure(int i2, int i3, String str) {
        super.handleFailure(i2, i3, str);
    }

    public void handleResponse(int i2, Object obj, String str) {
        if (i2 == 257) {
            BaiduPay.getInstance().bindCardAuth(this.mActivity, false);
            StatHelper.statServiceEvent(StatServiceEvent.EVENT_AuthorizePay_ClickNext, (Map<String, Object>) null, StatServiceEvent.VALUE_AuthorizePay_ClickNext_NewCard);
            this.mActivity.finishWithoutAnim();
            return;
        }
        super.handleResponse(i2, obj, str);
    }

    public void onCreate(Bundle bundle) {
        this.mPayRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        PwdPayActivity pwdPayActivity = this.mActivity;
        pwdPayActivity.setTitleText(ResUtils.getString(pwdPayActivity, "ebpay_please_input_pwd2"));
    }

    public void onDestroy() {
    }

    public void onFPCheckCancel() {
    }

    public void onFPCheckOK(String str) {
    }

    public void onPause() {
    }

    public void onPwdChanged(String str) {
        doCheckPwd(str);
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void pwdAndFpTypeChange() {
    }
}
