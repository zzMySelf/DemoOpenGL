package com.baidu.wallet.base.widget.dialog.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.WalletDialog;
import com.baidu.wallet.base.widget.dialog.binding.ImageDialogBinding;
import com.baidu.wallet.base.widget.dialog.model.ImageDialogModel;

public class ImageDialogAdapter extends WalletDialog.Adapter<BaseHolder> {
    public ImageDialogModel a;

    public class BaseHolder extends WalletDialog.ViewHolder {
        public final ImageDialogBinding binding;

        public BaseHolder(ImageDialogBinding imageDialogBinding) {
            super(imageDialogBinding.rootView);
            this.binding = imageDialogBinding;
        }
    }

    public ImageDialogAdapter(ImageDialogModel imageDialogModel) {
        this.a = imageDialogModel;
    }

    public void onBindViewHolder(BaseHolder baseHolder) {
        baseHolder.binding.setViewModel(this.a);
    }

    public BaseHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new BaseHolder(new ImageDialogBinding(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_base_layout_image_dialog"), (ViewGroup) null)));
    }
}
