package com.dxmpay.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.ImageDialogModel;

public class ImageDialogBinding extends BaseBinding<ImageDialogModel> {

    /* renamed from: ad  reason: collision with root package name */
    public final ImageView f4213ad;

    /* renamed from: de  reason: collision with root package name */
    public final TextView f4214de;

    /* renamed from: fe  reason: collision with root package name */
    public final Button f4215fe;
    public final TextView qw;

    /* renamed from: rg  reason: collision with root package name */
    public final TextView f4216rg;

    public ImageDialogBinding(View view) {
        super(view);
        TextView textView = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip_1"));
        this.f4216rg = textView;
        textView.setVisibility(8);
        this.qw = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip"));
        this.f4213ad = (ImageView) view.findViewById(ResUtils.id(this.context, "dialog_image"));
        this.f4214de = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f4215fe = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
    }

    public void executeBindings() {
        T t = this.viewModel;
        if (((ImageDialogModel) t).messageId != 0) {
            this.qw.setText(((ImageDialogModel) t).messageId);
        } else if (!TextUtils.isEmpty(((ImageDialogModel) t).message)) {
            this.qw.setText(((ImageDialogModel) this.viewModel).message);
        }
        T t2 = this.viewModel;
        if (((ImageDialogModel) t2).messageTempId != 0) {
            this.f4216rg.setVisibility(0);
            this.f4216rg.setText(((ImageDialogModel) this.viewModel).messageTempId);
        } else if (((ImageDialogModel) t2).messageTemp != null) {
            this.f4216rg.setVisibility(0);
            this.f4216rg.setText(((ImageDialogModel) this.viewModel).messageTemp);
        }
        T t3 = this.viewModel;
        if (((ImageDialogModel) t3).buttonTextId != 0) {
            this.f4215fe.setText(((ImageDialogModel) t3).buttonTextId);
        } else if (((ImageDialogModel) t3).buttonText != null) {
            this.f4215fe.setText(((ImageDialogModel) t3).buttonText);
        }
        T t4 = this.viewModel;
        if (((ImageDialogModel) t4).imageId != 0) {
            this.f4213ad.setImageResource(((ImageDialogModel) t4).imageId);
        } else if (((ImageDialogModel) t4).imageDrawable != null) {
            this.f4213ad.setImageDrawable(((ImageDialogModel) t4).imageDrawable);
        }
        T t5 = this.viewModel;
        if (((ImageDialogModel) t5).titleTextId != 0) {
            this.f4214de.setText(((ImageDialogModel) t5).titleTextId);
        } else if (!TextUtils.isEmpty(((ImageDialogModel) t5).titleText)) {
            this.f4214de.setText(((ImageDialogModel) this.viewModel).titleText);
        }
        TextPaint paint = this.f4215fe.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        this.f4215fe.setOnClickListener(((ImageDialogModel) this.viewModel).defaultClickListener);
    }
}
