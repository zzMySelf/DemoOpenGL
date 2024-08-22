package com.baidu.wallet.base.widget;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.ResUtils;
import java.util.List;

public class CustomerServiceMenu extends BdMenu implements NoProguard {
    public static final int CHARGE_RECORD = 100003;
    public static final int CHARGE_SERVICE = 100004;
    public static final int TRANSFER_RECORD = 100001;
    public static final int TRANSFER_SERVICE = 100002;
    public static final int WITHDRAW_RECORD = 100005;
    public static final int WITHDRAW_SERVICE = 100006;

    public CustomerServiceMenu(View view, int i2) {
        super(view);
        if (i2 == 100001) {
            add((int) TRANSFER_RECORD, ResUtils.string(this.mContext, "wallet_transfer_record"), ResUtils.drawable(this.mContext, "wallet_base_view_record"));
        } else if (i2 == 100003) {
            add((int) CHARGE_RECORD, ResUtils.string(this.mContext, "bd_wallet_balance_charge_records"), ResUtils.drawable(this.mContext, "wallet_base_view_record"));
        } else if (i2 == 100005) {
            add((int) WITHDRAW_RECORD, ResUtils.string(this.mContext, "bd_wallet_balance_withdraw_records"), ResUtils.drawable(this.mContext, "wallet_base_view_record"));
        }
        setDismissOnClick(true);
    }

    public void ensureMenuLoaded(View view, List<BdMenuItem> list) {
        ((ContextMenuView) view).layoutMenu(list);
    }

    public View getMenuView(Context context) {
        return new ContextMenuView(context);
    }

    public void showMenu(PopupWindow popupWindow) {
        popupWindow.showAsDropDown(this.mViewToAttach);
    }
}
