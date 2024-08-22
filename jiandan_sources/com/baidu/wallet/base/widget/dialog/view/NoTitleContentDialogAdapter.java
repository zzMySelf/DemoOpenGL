package com.baidu.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.WalletDialog;
import com.baidu.wallet.base.widget.dialog.binding.NoTitleContentDialogBinding;
import com.baidu.wallet.base.widget.dialog.model.ContentDialogModel;

public class NoTitleContentDialogAdapter extends WalletDialog.Adapter<BaseHolder> {
    public ContentDialogModel a;

    public class BaseHolder extends WalletDialog.ViewHolder {
        public final NoTitleContentDialogBinding binding;

        public BaseHolder(NoTitleContentDialogBinding noTitleContentDialogBinding) {
            super(noTitleContentDialogBinding.rootView);
            this.binding = noTitleContentDialogBinding;
        }
    }

    public NoTitleContentDialogAdapter(ContentDialogModel contentDialogModel) {
        this.a = contentDialogModel;
    }

    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.a);
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(new NoTitleContentDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_base_layout_no_title_content_dialog"), (ViewGroup) null)));
    }
}
