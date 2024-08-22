package com.dxmpay.wallet.base.widget.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.ImageDialogModel;
import com.dxmpay.wallet.base.widget.dialog.view.ImageDialogAdapter;

public class PromptImageDialog extends WalletDialog {
    public ImageDialogModel a = new ImageDialogModel();
    public View.OnClickListener b = new qw();

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            PromptImageDialog.this.dismiss();
        }
    }

    public PromptImageDialog(Context context) {
        super(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
        a();
    }

    private void a() {
        ImageDialogModel imageDialogModel = this.a;
        imageDialogModel.defaultClickListener = this.b;
        setAdapter(new ImageDialogAdapter(imageDialogModel));
    }

    public void setButtonText(String str) {
        this.a.buttonText = str;
    }

    public void setImage(int i2) {
        this.a.imageId = i2;
    }

    public void setMessage(int i2) {
        this.a.messageId = i2;
    }

    public void setMessageTemp(String str) {
        this.a.messageTemp = str;
    }

    public void setTitleMessage(int i2) {
        this.a.titleTextId = i2;
    }

    public void setButtonText(int i2) {
        this.a.buttonTextId = i2;
    }

    public void setImage(Drawable drawable) {
        this.a.imageDrawable = drawable;
    }

    public void setMessage(String str) {
        this.a.message = str;
    }

    public void setMessageTemp(int i2) {
        this.a.messageTempId = i2;
    }

    public void setTitleMessage(String str) {
        this.a.titleText = str;
    }

    public PromptImageDialog(Context context, int i2) {
        super(context, i2);
        a();
    }
}
