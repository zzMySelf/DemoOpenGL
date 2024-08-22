package com.dxmpay.wallet.base.widget.dialog;

import android.content.Context;
import android.view.View;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.MultiBtnDialogModel;
import com.dxmpay.wallet.base.widget.dialog.view.MultiBtnDialogAdapter;

public class PromptMultiBtnDialog extends WalletDialog {
    public MultiBtnDialogModel a = new MultiBtnDialogModel();
    public View.OnClickListener b = new qw();

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            PromptMultiBtnDialog.this.dismiss();
        }
    }

    public PromptMultiBtnDialog(Context context) {
        super(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
        a();
    }

    private void a() {
        MultiBtnDialogModel multiBtnDialogModel = this.a;
        multiBtnDialogModel.defaultClickListener = this.b;
        setAdapter(new MultiBtnDialogAdapter(multiBtnDialogModel));
    }

    public void setDialogIconOnClickListener(View.OnClickListener onClickListener) {
        this.a.dialogIconClickListener = onClickListener;
    }

    public void setFirstBtn(int i2, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.a;
        multiBtnDialogModel.firstBtnTextId = i2;
        multiBtnDialogModel.firstBtnClickListener = onClickListener;
    }

    public void setFirstBtnResId(int i2) {
        this.a.firstBtnResid = i2;
    }

    public void setFirstBtnTextBold() {
        this.a.firstBtnTextBold = true;
    }

    public void setFirstBtnTip(String str) {
        this.a.firstBtnTip = str;
    }

    public void setHideDialogIcon(boolean z) {
        this.a.hideDialogIcon = z;
    }

    public void setHideSecondBtn(boolean z) {
        this.a.hideSecondBtn = z;
    }

    public void setHideThirdBtn(boolean z) {
        this.a.hideThirdBtn = z;
    }

    public void setMessage(int i2) {
        this.a.messageId = i2;
    }

    public void setNewDialogStyle(boolean z) {
        this.a.newDialogStyle = z;
    }

    public void setSecondBtn(int i2, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.a;
        multiBtnDialogModel.secondBtnTextId = i2;
        multiBtnDialogModel.secondBtnClickListener = onClickListener;
    }

    public void setSecondBtnTextBold() {
        this.a.secondBtnTextBold = true;
    }

    public void setSecondBtnTip(String str) {
        this.a.secondBtnTip = str;
    }

    public void setThirdBtn(int i2, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.a;
        multiBtnDialogModel.thirdBtnTextId = i2;
        multiBtnDialogModel.thirdBtnClickListener = onClickListener;
    }

    public void setThirdBtnTextBold() {
        this.a.thirdBtnTextBold = true;
    }

    public void setThirdBtnTip(String str) {
        this.a.thirdBtnTip = str;
    }

    public void setTitleMessage(int i2) {
        this.a.titleId = i2;
    }

    public void setMessage(CharSequence charSequence) {
        this.a.message = charSequence;
    }

    public void setTitleMessage(String str) {
        this.a.titleText = str;
    }

    public void setFirstBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.a;
        multiBtnDialogModel.firstBtnText = str;
        multiBtnDialogModel.firstBtnClickListener = onClickListener;
    }

    public void setSecondBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.a;
        multiBtnDialogModel.secondBtnText = str;
        multiBtnDialogModel.secondBtnClickListener = onClickListener;
    }

    public void setThirdBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.a;
        multiBtnDialogModel.thirdBtnText = str;
        multiBtnDialogModel.thirdBtnClickListener = onClickListener;
    }

    public PromptMultiBtnDialog(Context context, int i2) {
        super(context, i2);
        a();
    }
}
