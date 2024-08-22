package com.dxmpay.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.WalletDialog;
import com.dxmpay.wallet.base.widget.dialog.binding.BaseDialogBinding;
import com.dxmpay.wallet.base.widget.dialog.model.BaseDialogModel;

public class BaseAdapter extends WalletDialog.Adapter<BaseHolder> {
    public BaseDialogModel qw;

    public class BaseHolder extends WalletDialog.ViewHolder {
        public final BaseDialogBinding binding;

        public BaseHolder(BaseAdapter baseAdapter, BaseDialogBinding baseDialogBinding) {
            super(baseDialogBinding.rootView);
            this.binding = baseDialogBinding;
        }
    }

    public BaseAdapter(BaseDialogModel baseDialogModel) {
        this.qw = baseDialogModel;
    }

    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.qw);
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(this, new BaseDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "dxm_wallet_base_layout_common_dialog"), (ViewGroup) null)));
    }
}
