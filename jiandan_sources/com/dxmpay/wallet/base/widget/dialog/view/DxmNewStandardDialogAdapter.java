package com.dxmpay.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.WalletDialog;
import com.dxmpay.wallet.base.widget.dialog.binding.DxmNewStandardDialogBinding;
import com.dxmpay.wallet.base.widget.dialog.model.DxmNewStandardDialogModel;

public class DxmNewStandardDialogAdapter extends WalletDialog.Adapter<BaseHolder> {
    public DxmNewStandardDialogModel qw;

    public class BaseHolder extends WalletDialog.ViewHolder {
        public final DxmNewStandardDialogBinding binding;

        public BaseHolder(DxmNewStandardDialogAdapter dxmNewStandardDialogAdapter, DxmNewStandardDialogBinding dxmNewStandardDialogBinding) {
            super(dxmNewStandardDialogBinding.rootView);
            this.binding = dxmNewStandardDialogBinding;
        }
    }

    public DxmNewStandardDialogAdapter(DxmNewStandardDialogModel dxmNewStandardDialogModel) {
        this.qw = dxmNewStandardDialogModel;
    }

    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.qw);
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(this, new DxmNewStandardDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "dxm_new_standard_dialog"), (ViewGroup) null)));
    }
}
