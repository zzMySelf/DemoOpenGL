package com.dxmpay.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.TipDialogModel;

public class TipDialogBinding extends BaseBinding<TipDialogModel> {

    /* renamed from: ad  reason: collision with root package name */
    public final Button f4227ad;

    /* renamed from: de  reason: collision with root package name */
    public final TextView f4228de;
    public final TextView qw;

    public TipDialogBinding(View view) {
        super(view);
        this.qw = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f4227ad = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
        this.f4228de = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
    }

    public void executeBindings() {
        T t = this.viewModel;
        if (((TipDialogModel) t).btnTextId != 0) {
            this.f4227ad.setText(((TipDialogModel) t).btnTextId);
        } else if (!TextUtils.isEmpty(((TipDialogModel) t).btnText)) {
            this.f4227ad.setText(((TipDialogModel) this.viewModel).btnText);
        }
        T t2 = this.viewModel;
        if (((TipDialogModel) t2).titleId != 0) {
            this.qw.setText(((TipDialogModel) t2).titleId);
        } else if (!TextUtils.isEmpty(((TipDialogModel) t2).titleText)) {
            this.qw.setText(((TipDialogModel) this.viewModel).titleText);
        }
        TextPaint paint = this.f4227ad.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        this.f4227ad.setOnClickListener(((TipDialogModel) this.viewModel).defaultClickListener);
        T t3 = this.viewModel;
        if (((TipDialogModel) t3).messageId != 0) {
            this.f4228de.setText(((TipDialogModel) t3).messageId);
        } else if (!TextUtils.isEmpty(((TipDialogModel) t3).message)) {
            this.f4228de.setText(((TipDialogModel) this.viewModel).message);
        }
    }
}
