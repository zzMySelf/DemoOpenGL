package com.baidu.wallet.paysdk.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.sms.controller.ISmsController;
import com.baidu.wallet.paysdk.sms.controller.e;
import com.baidu.wallet.paysdk.sms.controller.f;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.utils.BdWalletUtils;

public class VoiceVerifyActivity extends WalletSmsActivity {
    public ISmsController getController(int i2) {
        if (i2 == 0) {
            return new e();
        }
        return new f();
    }

    public void onClick(View view) {
        super.onClick(view);
        Button button = this.mSendSms;
        if (view == button) {
            button.setContentDescription(ResUtils.getString(getActivity(), "wallet_access_retrieve_voice_verify_code"));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ErrorContentResponse.Verify verify = (ErrorContentResponse.Verify) getIntent().getSerializableExtra(DxmPayBeanConstants.EXTRA_VERIFY_VOICE_DATA);
        String voiceMsg = verify != null ? verify.getVoiceMsg() : "";
        if (TextUtils.isEmpty(voiceMsg)) {
            voiceMsg = String.format(ResUtils.getString(this, "ebpay_sms_title_tip_voice_verify"), new Object[]{BdWalletUtils.getKefuPhoneNum(this)});
        }
        this.mTopPhoneTip.setText(voiceMsg);
        this.mHelp.setText(ResUtils.getString(this, "ebpay_get_voice_code_error"));
        this.mHelp.setContentDescription(ResUtils.getString(getActivity(), "wallet_access_view_solutions_for_not_received_call"));
        this.mSendSms.setTextSize(1, 12.0f);
        this.mSendSms.setText(ResUtils.getString(getActivity(), "ebpay_get_voice_code"));
        this.mSendSms.setContentDescription(ResUtils.getString(getActivity(), "ebpay_get_voice_code"));
    }

    public void startCountDown() {
        this.mHasVerifyCodeSend = true;
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mTimer = null;
        }
        AnonymousClass1 r1 = new CountDownTimer(60000, 1000) {
            public void onFinish() {
                VoiceVerifyActivity voiceVerifyActivity = VoiceVerifyActivity.this;
                voiceVerifyActivity.mSendSms.setText(ResUtils.getString(voiceVerifyActivity.getActivity(), "ebpay_recall"));
                VoiceVerifyActivity.this.mSendSms.setTextSize(1, 16.0f);
                VoiceVerifyActivity.this.mSendSms.setEnabled(true);
            }

            public void onTick(long j) {
                VoiceVerifyActivity.this.mSendSms.setEnabled(false);
                VoiceVerifyActivity.this.mSendSms.setTextSize(1, 12.0f);
                VoiceVerifyActivity voiceVerifyActivity = VoiceVerifyActivity.this;
                voiceVerifyActivity.mSendSms.setText(String.format(ResUtils.getString(voiceVerifyActivity.getActivity(), "ebpay_recall_timer"), new Object[]{Integer.valueOf((int) (j / 1000))}));
            }
        };
        this.mTimer = r1;
        r1.start();
        this.mSendSms.setEnabled(false);
    }
}
