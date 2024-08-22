package com.baidu.wallet.paysdk.sms.controller;

import android.app.Dialog;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.ui.widget.IdentifyCodeGetFailDialog;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.utils.StringUtils;

public class e extends c {
    public Dialog doOnCreateDialog(int i2) {
        if (i2 == 23) {
            return new IdentifyCodeGetFailDialog(this.a, IdentifyCodeGetFailDialog.VerifyCodeType.VOICE);
        }
        return super.doOnCreateDialog(i2);
    }

    public void initSmsActivityView() {
        String string = ResUtils.getString(this.a, "ebpay_submit_pay");
        PayRequest payRequest = this.d;
        if (payRequest != null) {
            if (payRequest.mMktSolution != null) {
                string = String.format(ResUtils.getString(this.a, "wallet_base_confirm_pay"), new Object[]{StringUtils.fen2Yuan(this.d.mMktSolution.easypay_amount)});
            } else {
                string = String.format(ResUtils.getString(this.a, "wallet_base_confirm_pay"), new Object[]{StringUtils.fen2Yuan(this.d.getFinalPayAmount())});
            }
        }
        this.b.initSMSActivityView("ebpay_sms_top_tip_voice_verify", "", string, SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.e)), true);
    }

    public boolean isSendSmsOnCreate() {
        return false;
    }
}
