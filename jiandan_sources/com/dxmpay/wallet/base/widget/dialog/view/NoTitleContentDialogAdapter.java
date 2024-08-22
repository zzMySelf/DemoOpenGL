package com.dxmpay.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.WalletDialog;
import com.dxmpay.wallet.base.widget.dialog.binding.NoTitleContentDialogBinding;
import com.dxmpay.wallet.base.widget.dialog.model.ContentDialogModel;

public class NoTitleContentDialogAdapter extends WalletDialog.Adapter<BaseHolder> {
    public ContentDialogModel qw;

    public class BaseHolder extends WalletDialog.ViewHolder {
        public final NoTitleContentDialogBinding binding;

        public BaseHolder(NoTitleContentDialogAdapter noTitleContentDialogAdapter, NoTitleContentDialogBinding noTitleContentDialogBinding) {
            super(noTitleContentDialogBinding.rootView);
            this.binding = noTitleContentDialogBinding;
        }
    }

    public NoTitleContentDialogAdapter(ContentDialogModel contentDialogModel) {
        this.qw = contentDialogModel;
    }

    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.qw);
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(this, new NoTitleContentDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "dxm_wallet_base_layout_no_title_content_dialog"), (ViewGroup) null)));
    }
}
