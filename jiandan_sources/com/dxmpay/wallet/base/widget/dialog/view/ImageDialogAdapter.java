package com.dxmpay.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.WalletDialog;
import com.dxmpay.wallet.base.widget.dialog.binding.ImageDialogBinding;
import com.dxmpay.wallet.base.widget.dialog.model.ImageDialogModel;

public class ImageDialogAdapter extends WalletDialog.Adapter<BaseHolder> {
    public ImageDialogModel qw;

    public class BaseHolder extends WalletDialog.ViewHolder {
        public final ImageDialogBinding binding;

        public BaseHolder(ImageDialogAdapter imageDialogAdapter, ImageDialogBinding imageDialogBinding) {
            super(imageDialogBinding.rootView);
            this.binding = imageDialogBinding;
        }
    }

    public ImageDialogAdapter(ImageDialogModel imageDialogModel) {
        this.qw = imageDialogModel;
    }

    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.qw);
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(this, new ImageDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "dxm_wallet_base_layout_image_dialog"), (ViewGroup) null)));
    }
}
