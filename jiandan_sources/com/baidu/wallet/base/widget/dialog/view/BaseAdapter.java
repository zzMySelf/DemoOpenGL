package com.baidu.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.WalletDialog;
import com.baidu.wallet.base.widget.dialog.binding.BaseDialogBinding;
import com.baidu.wallet.base.widget.dialog.model.BaseDialogModel;

public class BaseAdapter extends WalletDialog.Adapter<BaseHolder> {
    public BaseDialogModel a;

    public class BaseHolder extends WalletDialog.ViewHolder {
        public final BaseDialogBinding binding;

        public BaseHolder(BaseDialogBinding baseDialogBinding) {
            super(baseDialogBinding.rootView);
            this.binding = baseDialogBinding;
        }
    }

    public BaseAdapter(BaseDialogModel baseDialogModel) {
        this.a = baseDialogModel;
    }

    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.a);
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(new BaseDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_base_layout_common_dialog"), (ViewGroup) null)));
    }
}
