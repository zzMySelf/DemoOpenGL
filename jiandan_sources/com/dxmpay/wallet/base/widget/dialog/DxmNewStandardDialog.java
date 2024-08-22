package com.dxmpay.wallet.base.widget.dialog;

import android.content.Context;
import android.view.View;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.DxmNewStandardDialogModel;
import com.dxmpay.wallet.base.widget.dialog.view.DxmNewStandardDialogAdapter;

public class DxmNewStandardDialog extends WalletDialog {
    public DxmNewStandardDialogModel a = new DxmNewStandardDialogModel();
    public View.OnClickListener b = new qw();

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            DxmNewStandardDialog.this.dismiss();
        }
    }

    public DxmNewStandardDialog(Context context) {
        super(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
        a();
    }

    private void a() {
        DxmNewStandardDialogModel dxmNewStandardDialogModel = this.a;
        dxmNewStandardDialogModel.defaultClickListener = this.b;
        setAdapter(new DxmNewStandardDialogAdapter(dxmNewStandardDialogModel));
    }

    public void setCloseBtnClickListener(View.OnClickListener onClickListener) {
        this.a.closeBtnClickListener = onClickListener;
    }

    public void setFirstBtn(String str, View.OnClickListener onClickListener) {
        DxmNewStandardDialogModel dxmNewStandardDialogModel = this.a;
        dxmNewStandardDialogModel.firstBtnText = str;
        dxmNewStandardDialogModel.firstBtnClickListener = onClickListener;
    }

    public void setFirstBtnBackgroundResource(String str) {
        this.a.firstBtnBackgroundResource = str;
    }

    public void setHideSecondBtn(boolean z) {
        this.a.hideSecondBtn = z;
    }

    public void setMessage(String str) {
        this.a.message = str;
    }

    public void setSecondBtn(String str, View.OnClickListener onClickListener) {
        DxmNewStandardDialogModel dxmNewStandardDialogModel = this.a;
        dxmNewStandardDialogModel.secondBtnText = str;
        dxmNewStandardDialogModel.secondBtnClickListener = onClickListener;
    }

    public void setTitleMessage(String str) {
        this.a.titleText = str;
    }
}
