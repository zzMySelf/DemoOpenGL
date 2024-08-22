package com.baidu.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.ImageDialogModel;

public class ImageDialogBinding extends BaseBinding<ImageDialogModel> {
    public final TextView a;
    public final ImageView b;
    public final TextView c;
    public final Button d;
    public final TextView e;

    public ImageDialogBinding(View view) {
        super(view);
        TextView textView = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip_1"));
        this.e = textView;
        textView.setVisibility(8);
        this.a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip"));
        this.b = (ImageView) view.findViewById(ResUtils.id(this.context, "dialog_image"));
        this.c = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.d = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
    }

    public void executeBindings() {
        T t = this.viewModel;
        if (((ImageDialogModel) t).messageId != 0) {
            this.a.setText(((ImageDialogModel) t).messageId);
        } else if (!TextUtils.isEmpty(((ImageDialogModel) t).message)) {
            this.a.setText(((ImageDialogModel) this.viewModel).message);
        }
        T t2 = this.viewModel;
        if (((ImageDialogModel) t2).messageTempId != 0) {
            this.e.setVisibility(0);
            this.e.setText(((ImageDialogModel) this.viewModel).messageTempId);
        } else if (((ImageDialogModel) t2).messageTemp != null) {
            this.e.setVisibility(0);
            this.e.setText(((ImageDialogModel) this.viewModel).messageTemp);
        }
        T t3 = this.viewModel;
        if (((ImageDialogModel) t3).buttonTextId != 0) {
            this.d.setText(((ImageDialogModel) t3).buttonTextId);
        } else if (((ImageDialogModel) t3).buttonText != null) {
            this.d.setText(((ImageDialogModel) t3).buttonText);
        }
        T t4 = this.viewModel;
        if (((ImageDialogModel) t4).imageId != 0) {
            this.b.setImageResource(((ImageDialogModel) t4).imageId);
        } else if (((ImageDialogModel) t4).imageDrawable != null) {
            this.b.setImageDrawable(((ImageDialogModel) t4).imageDrawable);
        }
        T t5 = this.viewModel;
        if (((ImageDialogModel) t5).titleTextId != 0) {
            this.c.setText(((ImageDialogModel) t5).titleTextId);
        } else if (!TextUtils.isEmpty(((ImageDialogModel) t5).titleText)) {
            this.c.setText(((ImageDialogModel) this.viewModel).titleText);
        }
        TextPaint paint = this.d.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        this.d.setOnClickListener(((ImageDialogModel) this.viewModel).defaultClickListener);
    }
}
