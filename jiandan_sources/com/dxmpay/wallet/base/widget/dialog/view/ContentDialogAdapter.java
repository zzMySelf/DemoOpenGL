package com.dxmpay.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.WalletDialog;
import com.dxmpay.wallet.base.widget.dialog.binding.ContentDialogBinding;
import com.dxmpay.wallet.base.widget.dialog.model.ContentDialogModel;

public class ContentDialogAdapter extends WalletDialog.Adapter<BaseHolder> {
    public ContentDialogModel qw;

    public class BaseHolder extends WalletDialog.ViewHolder {
        public final ContentDialogBinding binding;

        public BaseHolder(ContentDialogAdapter contentDialogAdapter, ContentDialogBinding contentDialogBinding) {
            super(contentDialogBinding.rootView);
            this.binding = contentDialogBinding;
        }
    }

    public ContentDialogAdapter(ContentDialogModel contentDialogModel) {
        this.qw = contentDialogModel;
    }

    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.qw);
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(this, new ContentDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "dxm_wallet_base_layout_content_dialog"), (ViewGroup) null)));
    }
}
