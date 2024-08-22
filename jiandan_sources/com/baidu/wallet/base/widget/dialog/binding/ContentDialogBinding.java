package com.baidu.wallet.base.widget.dialog.binding;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.ContentDialogModel;

public class ContentDialogBinding extends BaseDialogBinding {
    public final TextView a;

    public ContentDialogBinding(View view) {
        super(view);
        this.a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
    }

    public void executeBindings() {
        super.executeBindings();
        ContentDialogModel contentDialogModel = (ContentDialogModel) getViewModel();
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        this.a.setMaxLines(4);
        if (contentDialogModel.hideMessage) {
            this.a.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.titleText.getLayoutParams();
            layoutParams.bottomMargin += ((LinearLayout.LayoutParams) this.a.getLayoutParams()).bottomMargin;
            this.titleText.setLayoutParams(layoutParams);
            return;
        }
        int i2 = contentDialogModel.messageId;
        if (i2 != 0) {
            this.a.setText(i2);
        } else if (!TextUtils.isEmpty(contentDialogModel.message)) {
            this.a.setText(contentDialogModel.message);
        }
        int i3 = contentDialogModel.messageColor;
        if (i3 != 0) {
            this.a.setTextColor(i3);
        }
        int i4 = contentDialogModel.backgroundColor;
        if (i4 != 0) {
            this.a.setBackgroundColor(i4);
        }
        int i5 = contentDialogModel.messageSize;
        if (i5 != 0) {
            this.a.setTextSize((float) i5);
        }
    }
}
