package com.baidu.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.MultiBtnDialogModel;

public class MultiBtnDialogBinding extends BaseBinding<MultiBtnDialogModel> {
    public final TextView a;
    public final TextView b;
    public final Button c;
    public final Button d;
    public final Button e;

    public MultiBtnDialogBinding(View view) {
        super(view);
        this.a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.b = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
        this.c = (Button) view.findViewById(ResUtils.id(this.context, "first_btn"));
        this.d = (Button) view.findViewById(ResUtils.id(this.context, "second_btn"));
        this.e = (Button) view.findViewById(ResUtils.id(this.context, "third_btn"));
    }

    public void executeBindings() {
        TextPaint paint;
        TextPaint paint2;
        TextPaint paint3;
        T t = this.viewModel;
        if (((MultiBtnDialogModel) t).titleId != 0) {
            this.a.setText(((MultiBtnDialogModel) t).titleId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t).titleText)) {
            this.a.setText(((MultiBtnDialogModel) this.viewModel).titleText);
        }
        T t2 = this.viewModel;
        if (((MultiBtnDialogModel) t2).messageId != 0) {
            this.b.setText(((MultiBtnDialogModel) t2).messageId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t2).message)) {
            this.b.setText(((MultiBtnDialogModel) this.viewModel).message);
        }
        this.c.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        this.d.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        this.e.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        T t3 = this.viewModel;
        if (((MultiBtnDialogModel) t3).firstBtnClickListener != null) {
            this.c.setOnClickListener(((MultiBtnDialogModel) t3).firstBtnClickListener);
        }
        T t4 = this.viewModel;
        if (((MultiBtnDialogModel) t4).secondBtnClickListener != null) {
            this.d.setOnClickListener(((MultiBtnDialogModel) t4).secondBtnClickListener);
        }
        T t5 = this.viewModel;
        if (((MultiBtnDialogModel) t5).thirdBtnClickListener != null) {
            this.e.setOnClickListener(((MultiBtnDialogModel) t5).thirdBtnClickListener);
        }
        T t6 = this.viewModel;
        if (((MultiBtnDialogModel) t6).firstBtnTextId != 0) {
            this.c.setText(((MultiBtnDialogModel) t6).firstBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t6).firstBtnText)) {
            this.c.setText(((MultiBtnDialogModel) this.viewModel).firstBtnText);
        }
        T t7 = this.viewModel;
        if (((MultiBtnDialogModel) t7).secondBtnTextId != 0) {
            this.d.setText(((MultiBtnDialogModel) t7).secondBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t7).secondBtnText)) {
            this.d.setText(((MultiBtnDialogModel) this.viewModel).secondBtnText);
        }
        T t8 = this.viewModel;
        if (((MultiBtnDialogModel) t8).thirdBtnTextId != 0) {
            this.e.setText(((MultiBtnDialogModel) t8).thirdBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t8).thirdBtnText)) {
            this.e.setText(((MultiBtnDialogModel) this.viewModel).thirdBtnText);
        }
        if (((MultiBtnDialogModel) this.viewModel).firstBtnTextBold && (paint3 = this.c.getPaint()) != null) {
            paint3.setFakeBoldText(true);
        }
        if (((MultiBtnDialogModel) this.viewModel).secondBtnTextBold && (paint2 = this.d.getPaint()) != null) {
            paint2.setFakeBoldText(true);
        }
        if (((MultiBtnDialogModel) this.viewModel).thirdBtnTextBold && (paint = this.e.getPaint()) != null) {
            paint.setFakeBoldText(true);
        }
    }
}
