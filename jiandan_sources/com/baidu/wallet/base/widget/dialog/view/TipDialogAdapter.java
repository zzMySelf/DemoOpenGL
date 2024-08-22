package com.baidu.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.WalletDialog;
import com.baidu.wallet.base.widget.dialog.binding.TipDialogBinding;
import com.baidu.wallet.base.widget.dialog.model.TipDialogModel;

public class TipDialogAdapter extends WalletDialog.Adapter<BaseHolder> {
    public TipDialogModel a;

    public class BaseHolder extends WalletDialog.ViewHolder {
        public final TipDialogBinding binding;

        public BaseHolder(TipDialogBinding tipDialogBinding) {
            super(tipDialogBinding.rootView);
            this.binding = tipDialogBinding;
        }
    }

    public TipDialogAdapter(TipDialogModel tipDialogModel) {
        this.a = tipDialogModel;
    }

    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.a);
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(new TipDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_base_layout_tip_dialog"), (ViewGroup) null)));
    }
}
