package com.dxmpay.wallet.base.widget.dialog.binding;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.ContentDialogModel;

public class ContentDialogBinding extends BaseDialogBinding {
    public final TextView qw;

    public ContentDialogBinding(View view) {
        super(view);
        this.qw = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
    }

    public void executeBindings() {
        super.executeBindings();
        ContentDialogModel contentDialogModel = (ContentDialogModel) getViewModel();
        if (contentDialogModel.hideMessage) {
            this.qw.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.titleText.getLayoutParams();
            layoutParams.bottomMargin += ((LinearLayout.LayoutParams) this.qw.getLayoutParams()).bottomMargin;
            this.titleText.setLayoutParams(layoutParams);
            return;
        }
        int i2 = contentDialogModel.messageId;
        if (i2 != 0) {
            this.qw.setText(i2);
        } else if (!TextUtils.isEmpty(contentDialogModel.message)) {
            this.qw.setText(contentDialogModel.message);
            this.qw.setHighlightColor(this.context.getResources().getColor(17170445));
        }
        this.qw.setMovementMethod(LinkMovementMethod.getInstance());
        int i3 = contentDialogModel.messageColor;
        if (i3 != 0) {
            this.qw.setTextColor(i3);
        }
        int i4 = contentDialogModel.backgroundColor;
        if (i4 != 0) {
            this.qw.setBackgroundColor(i4);
        }
        int i5 = contentDialogModel.messageSize;
        if (i5 != 0) {
            this.qw.setTextSize((float) i5);
        }
    }
}
