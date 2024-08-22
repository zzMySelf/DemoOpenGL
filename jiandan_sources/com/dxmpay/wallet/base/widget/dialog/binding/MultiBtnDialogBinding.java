package com.dxmpay.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.MultiBtnDialogModel;

public class MultiBtnDialogBinding extends BaseBinding<MultiBtnDialogModel> {

    /* renamed from: ad  reason: collision with root package name */
    public final TextView f4217ad;

    /* renamed from: de  reason: collision with root package name */
    public final Button f4218de;

    /* renamed from: fe  reason: collision with root package name */
    public final Button f4219fe;
    public final TextView qw;

    /* renamed from: rg  reason: collision with root package name */
    public final Button f4220rg;

    public MultiBtnDialogBinding(View view) {
        super(view);
        this.qw = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f4217ad = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
        this.f4218de = (Button) view.findViewById(ResUtils.id(this.context, "first_btn"));
        this.f4219fe = (Button) view.findViewById(ResUtils.id(this.context, "second_btn"));
        this.f4220rg = (Button) view.findViewById(ResUtils.id(this.context, "third_btn"));
    }

    public void executeBindings() {
        TextPaint paint;
        TextPaint paint2;
        TextPaint paint3;
        T t = this.viewModel;
        if (((MultiBtnDialogModel) t).titleId != 0) {
            this.qw.setText(((MultiBtnDialogModel) t).titleId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t).titleText)) {
            this.qw.setText(((MultiBtnDialogModel) this.viewModel).titleText);
        }
        T t2 = this.viewModel;
        if (((MultiBtnDialogModel) t2).messageId != 0) {
            this.f4217ad.setText(((MultiBtnDialogModel) t2).messageId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t2).message)) {
            this.f4217ad.setText(((MultiBtnDialogModel) this.viewModel).message);
        }
        this.f4218de.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        this.f4219fe.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        this.f4220rg.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        int i2 = 8;
        this.f4219fe.setVisibility(((MultiBtnDialogModel) this.viewModel).hideSecondBtn ? 8 : 0);
        Button button = this.f4220rg;
        if (!((MultiBtnDialogModel) this.viewModel).hideThirdBtn) {
            i2 = 0;
        }
        button.setVisibility(i2);
        T t3 = this.viewModel;
        if (((MultiBtnDialogModel) t3).firstBtnClickListener != null) {
            this.f4218de.setOnClickListener(((MultiBtnDialogModel) t3).firstBtnClickListener);
        }
        T t4 = this.viewModel;
        if (((MultiBtnDialogModel) t4).secondBtnClickListener != null) {
            this.f4219fe.setOnClickListener(((MultiBtnDialogModel) t4).secondBtnClickListener);
        }
        T t5 = this.viewModel;
        if (((MultiBtnDialogModel) t5).thirdBtnClickListener != null) {
            this.f4220rg.setOnClickListener(((MultiBtnDialogModel) t5).thirdBtnClickListener);
        }
        T t6 = this.viewModel;
        if (((MultiBtnDialogModel) t6).firstBtnTextId != 0) {
            this.f4218de.setText(((MultiBtnDialogModel) t6).firstBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t6).firstBtnText)) {
            this.f4218de.setText(((MultiBtnDialogModel) this.viewModel).firstBtnText);
        }
        T t7 = this.viewModel;
        if (((MultiBtnDialogModel) t7).secondBtnTextId != 0) {
            this.f4219fe.setText(((MultiBtnDialogModel) t7).secondBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t7).secondBtnText)) {
            this.f4219fe.setText(((MultiBtnDialogModel) this.viewModel).secondBtnText);
        }
        T t8 = this.viewModel;
        if (((MultiBtnDialogModel) t8).thirdBtnTextId != 0) {
            this.f4220rg.setText(((MultiBtnDialogModel) t8).thirdBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t8).thirdBtnText)) {
            this.f4220rg.setText(((MultiBtnDialogModel) this.viewModel).thirdBtnText);
        }
        if (((MultiBtnDialogModel) this.viewModel).firstBtnTextBold && (paint3 = this.f4218de.getPaint()) != null) {
            paint3.setFakeBoldText(true);
        }
        if (((MultiBtnDialogModel) this.viewModel).secondBtnTextBold && (paint2 = this.f4219fe.getPaint()) != null) {
            paint2.setFakeBoldText(true);
        }
        if (((MultiBtnDialogModel) this.viewModel).thirdBtnTextBold && (paint = this.f4220rg.getPaint()) != null) {
            paint.setFakeBoldText(true);
        }
    }
}
