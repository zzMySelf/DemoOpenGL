package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.ContentDialogModel;
import com.baidu.wallet.base.widget.dialog.view.ContentDialogAdapter;

public class PromptDialog extends WalletDialog implements BaseDialogInterface {
    public View.OnClickListener a = new View.OnClickListener() {
        public void onClick(View view) {
            PromptDialog.this.dismiss();
        }
    };
    public final ContentDialogModel b = new ContentDialogModel();

    public PromptDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        a();
    }

    private void a() {
        ContentDialogModel contentDialogModel = this.b;
        contentDialogModel.defaultListener = this.a;
        setAdapter(new ContentDialogAdapter(contentDialogModel));
    }

    public void cancelNegativeBtnTextBold() {
        this.b.negativeBtnTextBold = false;
    }

    public void cancelPositiveBtnTextBold() {
        this.b.positiveBtnTextBold = false;
    }

    public void hideButtons() {
        this.b.hideButtons = true;
    }

    public void hideMessage() {
        this.b.hideMessage = true;
    }

    public void hideNegativeButton() {
        this.b.hideNegativeBtn = true;
    }

    public void hidePositiveButton() {
        this.b.hidePositiveBtn = true;
    }

    public void hideTitle() {
        this.b.hideTitle = true;
    }

    public void hideTitleLine() {
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

    public void setMessageColor(int i2) {
        this.b.messageColor = i2;
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

    public void setTitleText(int i2) {
        this.b.titleId = i2;
    }

    @Deprecated
    public void setTitleTextBackgroud(int i2) {
    }

    public void showCloseBtn(boolean z) {
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

    public void setTitleText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getContext().getString(ResUtils.string(getContext(), "ebpay_tip"));
        }
        this.b.title = str;
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

    public PromptDialog(Context context, int i2) {
        super(context, i2);
        a();
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
