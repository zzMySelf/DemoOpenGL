package com.dxmpay.wallet.base.widget.dialog;

import android.content.Context;
import android.view.View;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.TipDialogModel;
import com.dxmpay.wallet.base.widget.dialog.view.TipDialogAdapter;

public class PromptTipDialog extends WalletDialog {
    public TipDialogModel a = new TipDialogModel();
    public View.OnClickListener b = new qw();

    public class ad implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f4206ad;

        public ad(View.OnClickListener onClickListener) {
            this.f4206ad = onClickListener;
        }

        public void onClick(View view) {
            PromptTipDialog.this.dismiss();
            View.OnClickListener onClickListener = this.f4206ad;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            PromptTipDialog.this.dismiss();
        }
    }

    public PromptTipDialog(Context context) {
        super(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
        a();
    }

    private void a() {
        TipDialogModel tipDialogModel = this.a;
        tipDialogModel.defaultClickListener = this.b;
        setAdapter(new TipDialogAdapter(tipDialogModel));
    }

    public void setButtonMessage(int i2) {
        this.a.btnTextId = i2;
    }

    public void setDefaultBtnListener(View.OnClickListener onClickListener) {
        this.a.defaultClickListener = new ad(onClickListener);
    }

    public void setMessage(int i2) {
        this.a.messageId = i2;
    }

    public void setTitleMessage(int i2) {
        this.a.titleId = i2;
    }

    public void setButtonMessage(String str) {
        this.a.btnText = str;
    }

    public void setMessage(String str) {
        this.a.message = str;
    }

    public void setTitleMessage(String str) {
        this.a.titleText = str;
    }

    public PromptTipDialog(Context context, int i2) {
        super(context, i2);
        a();
    }
}
