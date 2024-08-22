package com.dxmpay.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.WalletDialog;
import com.dxmpay.wallet.base.widget.dialog.binding.MultiBtnDialogBinding;
import com.dxmpay.wallet.base.widget.dialog.binding.NewMultiBtnDialogBinding;
import com.dxmpay.wallet.base.widget.dialog.model.MultiBtnDialogModel;

public class MultiBtnDialogAdapter extends WalletDialog.Adapter<BaseHolder> {
    public MultiBtnDialogModel qw;

    public class BaseHolder extends WalletDialog.ViewHolder {
        public final MultiBtnDialogBinding binding;

        public BaseHolder(MultiBtnDialogAdapter multiBtnDialogAdapter, MultiBtnDialogBinding multiBtnDialogBinding) {
            super(multiBtnDialogBinding.rootView);
            this.binding = multiBtnDialogBinding;
        }
    }

    public MultiBtnDialogAdapter(MultiBtnDialogModel multiBtnDialogModel) {
        this.qw = multiBtnDialogModel;
    }

    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.qw);
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        MultiBtnDialogModel multiBtnDialogModel = this.qw;
        if (multiBtnDialogModel == null || !multiBtnDialogModel.newDialogStyle) {
            return new BaseHolder(this, new MultiBtnDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "dxm_wallet_base_layout_multibtn_dialog"), (ViewGroup) null)));
        }
        return new BaseHolder(this, new NewMultiBtnDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "dxm_wallet_base_layout_multibtn_dialog_new_style"), (ViewGroup) null)));
    }
}
