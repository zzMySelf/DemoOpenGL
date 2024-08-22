package com.dxmpay.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.MultiBtnDialogModel;

public class NewMultiBtnDialogBinding extends MultiBtnDialogBinding {
    public TextView ggg;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f4221i;

    /* renamed from: if  reason: not valid java name */
    public TextView f161if;

    /* renamed from: o  reason: collision with root package name */
    public RelativeLayout f4222o;

    /* renamed from: pf  reason: collision with root package name */
    public TextView f4223pf;
    public TextView ppp;

    /* renamed from: switch  reason: not valid java name */
    public TextView f162switch;

    /* renamed from: th  reason: collision with root package name */
    public TextView f4224th;

    /* renamed from: uk  reason: collision with root package name */
    public RelativeLayout f4225uk;
    public ImageView vvv;
    public TextView when;

    /* renamed from: yj  reason: collision with root package name */
    public TextView f4226yj;

    public NewMultiBtnDialogBinding(View view) {
        super(view);
        this.f4224th = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f4226yj = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
        this.f4225uk = (RelativeLayout) view.findViewById(ResUtils.id(this.context, "first_btn_rela"));
        this.f4221i = (RelativeLayout) view.findViewById(ResUtils.id(this.context, "second_btn_rela"));
        this.f4222o = (RelativeLayout) view.findViewById(ResUtils.id(this.context, "third_btn_rela"));
        this.vvv = (ImageView) view.findViewById(ResUtils.id(this.context, "dialog_img"));
        this.f4223pf = (TextView) view.findViewById(ResUtils.id(this.context, "tv_first_txt"));
        this.f161if = (TextView) view.findViewById(ResUtils.id(this.context, "tv_first_tip"));
        this.when = (TextView) view.findViewById(ResUtils.id(this.context, "tv_second_txt"));
        this.f162switch = (TextView) view.findViewById(ResUtils.id(this.context, "tv_second_tip"));
        this.ggg = (TextView) view.findViewById(ResUtils.id(this.context, "tv_third_txt"));
        this.ppp = (TextView) view.findViewById(ResUtils.id(this.context, "tv_third_tip"));
    }

    public void executeBindings() {
        TextPaint paint;
        TextPaint paint2;
        TextPaint paint3;
        ImageView imageView;
        T t = this.viewModel;
        if (((MultiBtnDialogModel) t).titleId != 0) {
            this.f4224th.setText(((MultiBtnDialogModel) t).titleId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t).titleText)) {
            this.f4224th.setText(((MultiBtnDialogModel) this.viewModel).titleText);
        }
        T t2 = this.viewModel;
        if (((MultiBtnDialogModel) t2).messageId != 0) {
            this.f4226yj.setText(((MultiBtnDialogModel) t2).messageId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t2).message)) {
            this.f4226yj.setText(((MultiBtnDialogModel) this.viewModel).message);
        }
        this.f4225uk.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        this.f4221i.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        this.f4222o.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        this.f4221i.setVisibility(((MultiBtnDialogModel) this.viewModel).hideSecondBtn ? 8 : 0);
        this.f4222o.setVisibility(((MultiBtnDialogModel) this.viewModel).hideThirdBtn ? 8 : 0);
        ImageView imageView2 = this.vvv;
        if (imageView2 != null) {
            T t3 = this.viewModel;
            if (((MultiBtnDialogModel) t3).newDialogStyle) {
                imageView2.setVisibility(((MultiBtnDialogModel) t3).hideDialogIcon ? 8 : 0);
            }
        }
        T t4 = this.viewModel;
        if (((MultiBtnDialogModel) t4).firstBtnClickListener != null) {
            this.f4225uk.setOnClickListener(((MultiBtnDialogModel) t4).firstBtnClickListener);
        }
        T t5 = this.viewModel;
        if (((MultiBtnDialogModel) t5).secondBtnClickListener != null) {
            this.f4221i.setOnClickListener(((MultiBtnDialogModel) t5).secondBtnClickListener);
        }
        T t6 = this.viewModel;
        if (((MultiBtnDialogModel) t6).thirdBtnClickListener != null) {
            this.f4222o.setOnClickListener(((MultiBtnDialogModel) t6).thirdBtnClickListener);
        }
        T t7 = this.viewModel;
        if (!(((MultiBtnDialogModel) t7).dialogIconClickListener == null || (imageView = this.vvv) == null || !((MultiBtnDialogModel) t7).newDialogStyle)) {
            imageView.setOnClickListener(((MultiBtnDialogModel) t7).dialogIconClickListener);
        }
        T t8 = this.viewModel;
        if (((MultiBtnDialogModel) t8).firstBtnTextId != 0) {
            this.f4223pf.setText(((MultiBtnDialogModel) t8).firstBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t8).firstBtnText)) {
            this.f4223pf.setText(((MultiBtnDialogModel) this.viewModel).firstBtnText);
        }
        if (this.f4225uk.getVisibility() != 0 || TextUtils.isEmpty(((MultiBtnDialogModel) this.viewModel).firstBtnTip)) {
            this.f161if.setVisibility(8);
        } else {
            this.f161if.setVisibility(0);
            this.f161if.setText(((MultiBtnDialogModel) this.viewModel).firstBtnTip);
        }
        if (this.f4221i.getVisibility() != 0 || TextUtils.isEmpty(((MultiBtnDialogModel) this.viewModel).secondBtnTip)) {
            this.f162switch.setVisibility(8);
        } else {
            this.f162switch.setVisibility(0);
            this.f162switch.setText(((MultiBtnDialogModel) this.viewModel).secondBtnTip);
        }
        if (this.f4222o.getVisibility() != 0 || TextUtils.isEmpty(((MultiBtnDialogModel) this.viewModel).thirdBtnTip)) {
            this.ppp.setVisibility(8);
        } else {
            this.ppp.setVisibility(0);
            this.ppp.setText(((MultiBtnDialogModel) this.viewModel).thirdBtnTip);
        }
        T t9 = this.viewModel;
        if (((MultiBtnDialogModel) t9).secondBtnTextId != 0) {
            this.when.setText(((MultiBtnDialogModel) t9).secondBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t9).secondBtnText)) {
            this.when.setText(((MultiBtnDialogModel) this.viewModel).secondBtnText);
        }
        T t10 = this.viewModel;
        if (((MultiBtnDialogModel) t10).thirdBtnTextId != 0) {
            this.ggg.setText(((MultiBtnDialogModel) t10).thirdBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t10).thirdBtnText)) {
            this.ggg.setText(((MultiBtnDialogModel) this.viewModel).thirdBtnText);
        }
        T t11 = this.viewModel;
        if (((MultiBtnDialogModel) t11).firstBtnResid != 0) {
            this.f4225uk.setBackgroundResource(((MultiBtnDialogModel) t11).firstBtnResid);
        }
        if (((MultiBtnDialogModel) this.viewModel).firstBtnTextBold && (paint3 = this.f4223pf.getPaint()) != null) {
            paint3.setFakeBoldText(true);
        }
        if (((MultiBtnDialogModel) this.viewModel).secondBtnTextBold && (paint2 = this.when.getPaint()) != null) {
            paint2.setFakeBoldText(true);
        }
        if (((MultiBtnDialogModel) this.viewModel).thirdBtnTextBold && (paint = this.ggg.getPaint()) != null) {
            paint.setFakeBoldText(true);
        }
    }
}
