package com.dxmpay.wallet.base.widget.dialog.binding;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.model.DxmNewStandardDialogModel;

public class DxmNewStandardDialogBinding extends BaseBinding<DxmNewStandardDialogModel> {

    /* renamed from: ad  reason: collision with root package name */
    public final TextView f4209ad;

    /* renamed from: de  reason: collision with root package name */
    public final TextView f4210de;

    /* renamed from: fe  reason: collision with root package name */
    public final TextView f4211fe;
    public final TextView qw;

    /* renamed from: rg  reason: collision with root package name */
    public final ImageView f4212rg;

    public DxmNewStandardDialogBinding(View view) {
        super(view);
        this.qw = (TextView) view.findViewById(ResUtils.id(this.context, "tv_new_dialog_title"));
        this.f4209ad = (TextView) view.findViewById(ResUtils.id(this.context, "tv_new_dialog_content"));
        this.f4210de = (TextView) view.findViewById(ResUtils.id(this.context, "tv_new_dialog_first"));
        this.f4211fe = (TextView) view.findViewById(ResUtils.id(this.context, "tv_new_dialog_second"));
        this.f4212rg = (ImageView) view.findViewById(ResUtils.id(this.context, "iv_new_close_dialog"));
    }

    public void executeBindings() {
        if (!TextUtils.isEmpty(((DxmNewStandardDialogModel) this.viewModel).titleText)) {
            this.qw.setText(((DxmNewStandardDialogModel) this.viewModel).titleText);
        }
        if (!TextUtils.isEmpty(((DxmNewStandardDialogModel) this.viewModel).message)) {
            this.f4209ad.setText(((DxmNewStandardDialogModel) this.viewModel).message);
        }
        if (!TextUtils.isEmpty(((DxmNewStandardDialogModel) this.viewModel).firstBtnText)) {
            this.f4210de.setText(((DxmNewStandardDialogModel) this.viewModel).firstBtnText);
        }
        if (!TextUtils.isEmpty(((DxmNewStandardDialogModel) this.viewModel).secondBtnText)) {
            this.f4211fe.setText(((DxmNewStandardDialogModel) this.viewModel).secondBtnText);
        }
        this.f4210de.setOnClickListener(((DxmNewStandardDialogModel) this.viewModel).defaultClickListener);
        this.f4211fe.setOnClickListener(((DxmNewStandardDialogModel) this.viewModel).defaultClickListener);
        this.f4212rg.setOnClickListener(((DxmNewStandardDialogModel) this.viewModel).defaultClickListener);
        this.f4211fe.setVisibility(((DxmNewStandardDialogModel) this.viewModel).hideSecondBtn ? 8 : 0);
        if (TextUtils.isEmpty(((DxmNewStandardDialogModel) this.viewModel).firstBtnBackgroundResource)) {
            this.f4210de.setBackgroundResource(ResUtils.drawable(this.context, "dxm_wallet_base_blue_397be6_btn"));
        } else {
            this.f4210de.setBackgroundResource(ResUtils.drawable(this.context, ((DxmNewStandardDialogModel) this.viewModel).firstBtnBackgroundResource));
        }
        T t = this.viewModel;
        if (((DxmNewStandardDialogModel) t).firstBtnClickListener != null) {
            this.f4210de.setOnClickListener(((DxmNewStandardDialogModel) t).firstBtnClickListener);
        }
        T t2 = this.viewModel;
        if (((DxmNewStandardDialogModel) t2).secondBtnClickListener != null) {
            this.f4211fe.setOnClickListener(((DxmNewStandardDialogModel) t2).secondBtnClickListener);
        }
        T t3 = this.viewModel;
        if (((DxmNewStandardDialogModel) t3).closeBtnClickListener != null) {
            this.f4212rg.setOnClickListener(((DxmNewStandardDialogModel) t3).closeBtnClickListener);
        }
    }
}
