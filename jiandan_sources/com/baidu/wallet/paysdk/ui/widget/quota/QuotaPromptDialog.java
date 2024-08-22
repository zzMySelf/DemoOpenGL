package com.baidu.wallet.paysdk.ui.widget.quota;

import android.content.Context;
import android.view.View;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.WalletDialog;

public class QuotaPromptDialog extends WalletDialog {
    public c a = new c();
    public View.OnClickListener b = new View.OnClickListener() {
        public void onClick(View view) {
            QuotaPromptDialog.this.dismiss();
        }
    };

    public QuotaPromptDialog(Context context) {
        super(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
        a();
    }

    private void a() {
        c cVar = this.a;
        cVar.j = this.b;
        setAdapter(new a(cVar));
    }

    public void setAnswerMsg(String str) {
        this.a.g = str;
    }

    public void setDialogBtnOnClickListener(View.OnClickListener onClickListener) {
        this.a.k = onClickListener;
    }

    public void setHideOneTip(boolean z) {
        this.a.f3641i = z;
    }

    public void setHideTwoTip(boolean z) {
        this.a.h = z;
    }

    public void setLeftMoney(String str) {
        this.a.d = str;
    }

    public void setLeftTipTitle(String str) {
        this.a.b = str;
    }

    public void setQuestionMsg(String str) {
        this.a.f = str;
    }

    public void setRightMoney(String str) {
        this.a.e = str;
    }

    public void setRightTipTitle(String str) {
        this.a.c = str;
    }

    public void setTitleText(String str) {
        this.a.a = str;
    }

    public QuotaPromptDialog(Context context, int i2) {
        super(context, i2);
        a();
    }
}
