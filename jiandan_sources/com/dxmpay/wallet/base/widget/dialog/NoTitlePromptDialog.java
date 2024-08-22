package com.dxmpay.wallet.base.widget.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.ContentDialogModel;
import com.dxmpay.wallet.base.widget.dialog.view.NoTitleContentDialogAdapter;

public class NoTitlePromptDialog extends WalletDialog {
    public View.OnClickListener a;
    public final ContentDialogModel b;

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            NoTitlePromptDialog.this.dismiss();
        }
    }

    public NoTitlePromptDialog(Context context) {
        this(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
    }

    private void a() {
        ContentDialogModel contentDialogModel = this.b;
        contentDialogModel.defaultListener = this.a;
        setAdapter(new NoTitleContentDialogAdapter(contentDialogModel));
    }

    public void hideButtons() {
        this.b.hideButtons = true;
    }

    public void hideNegativeButton() {
        this.b.hideNegativeBtn = true;
    }

    public void hidePositiveButton() {
        this.b.hidePositiveBtn = true;
    }

    public void setDialogBackgroundColor(int i2) {
        this.b.dialogBackgound = i2;
    }

    public void setMessage(int i2) {
        this.b.messageId = i2;
    }

    public void setMessageBackgroundColor(int i2) {
        this.b.backgroundColor = i2;
    }

    public void setMessageTextSize(int i2) {
        this.b.messageSize = i2;
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        this.b.negativeBtnClickListener = onClickListener;
    }

    public void setNegativeBtnTextColor(int i2) {
        this.b.negativeBtnTextColor = i2;
    }

    public void setNegativeBtnTextSize(int i2) {
        this.b.negativeBtnTextSize = i2;
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        this.b.positiveBtnClickListener = onClickListener;
    }

    public void setPositiveBtnTextColor(int i2) {
        this.b.positiveBtnTextColor = i2;
    }

    public void setPositiveBtnTextSize(int i2) {
        this.b.positiveBtnTextSize = i2;
    }

    public NoTitlePromptDialog(Context context, int i2) {
        super(context, i2);
        this.a = new qw();
        this.b = new ContentDialogModel();
        a();
    }

    public void setMessage(CharSequence charSequence) {
        this.b.message = charSequence;
    }

    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnTextId = i2;
    }

    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnTextId = i2;
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = str;
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnText = spannableString;
    }

    public void setNegativeBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = spannableString;
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.b;
        contentDialogModel.positiveBtnText = str;
        contentDialogModel.positiveBtnClickListener = onClickListener;
    }
}
