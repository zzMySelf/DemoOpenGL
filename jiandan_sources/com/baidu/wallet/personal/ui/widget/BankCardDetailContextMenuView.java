package com.baidu.wallet.personal.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import com.baidu.wallet.base.widget.BdContextMenuView;

public class BankCardDetailContextMenuView extends BdContextMenuView {
    public BankCardDetailContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @SuppressLint({"NewApi"})
    public BankCardDetailContextMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public String getBackgroundResId() {
        return "wallet_base_menu_bg_white";
    }

    public String getMenuItemBackgroudResId(int i2, int i3) {
        return "ebpay_transparent";
    }

    public String getMenuItemViewLayoutId() {
        return "wallet_personal_bank_menu_item_view";
    }

    public String getSeparatorResId() {
        return null;
    }
}
