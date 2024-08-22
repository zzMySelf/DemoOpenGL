package com.baidu.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.TipDialogModel;

public class TipDialogBinding extends BaseBinding<TipDialogModel> {
    public final TextView a;
    public final Button b;
    public final TextView c;

    public TipDialogBinding(View view) {
        super(view);
        this.a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.b = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
        this.c = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
    }

    public void executeBindings() {
        T t = this.viewModel;
        if (((TipDialogModel) t).btnTextId != 0) {
            this.b.setText(((TipDialogModel) t).btnTextId);
        } else if (!TextUtils.isEmpty(((TipDialogModel) t).btnText)) {
            this.b.setText(((TipDialogModel) this.viewModel).btnText);
        }
        T t2 = this.viewModel;
        if (((TipDialogModel) t2).titleId != 0) {
            this.a.setText(((TipDialogModel) t2).titleId);
        } else if (!TextUtils.isEmpty(((TipDialogModel) t2).titleText)) {
            this.a.setText(((TipDialogModel) this.viewModel).titleText);
        }
        TextPaint paint = this.b.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        this.b.setOnClickListener(((TipDialogModel) this.viewModel).defaultClickListener);
        T t3 = this.viewModel;
        if (((TipDialogModel) t3).messageId != 0) {
            this.c.setText(((TipDialogModel) t3).messageId);
        } else if (!TextUtils.isEmpty(((TipDialogModel) t3).message)) {
            this.c.setText(((TipDialogModel) this.viewModel).message);
        }
    }
}
