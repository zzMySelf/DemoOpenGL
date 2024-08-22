package com.dxmpay.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.WalletDialog;
import com.dxmpay.wallet.base.widget.dialog.binding.TipDialogBinding;
import com.dxmpay.wallet.base.widget.dialog.model.TipDialogModel;

public class TipDialogAdapter extends WalletDialog.Adapter<BaseHolder> {
    public TipDialogModel qw;

    public class BaseHolder extends WalletDialog.ViewHolder {
        public final TipDialogBinding binding;

        public BaseHolder(TipDialogAdapter tipDialogAdapter, TipDialogBinding tipDialogBinding) {
            super(tipDialogBinding.rootView);
            this.binding = tipDialogBinding;
        }
    }

    public TipDialogAdapter(TipDialogModel tipDialogModel) {
        this.qw = tipDialogModel;
    }

    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.qw);
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(this, new TipDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "dxm_wallet_base_layout_tip_dialog"), (ViewGroup) null)));
    }
}
