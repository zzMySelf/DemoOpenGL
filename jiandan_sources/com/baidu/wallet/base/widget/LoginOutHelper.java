package com.baidu.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;

public class LoginOutHelper {

    public interface IAfterDismissCallback {
        void onCancel();

        void onLogout();
    }

    public static void showLogoutDialog(final Context context, final IAfterDismissCallback iAfterDismissCallback) {
        final Dialog dialog = new Dialog(context, ResUtils.style(context, "EbpayPromptDialog"));
        dialog.setContentView(ResUtils.layout(context, "wallet_base_dialog_logout"));
        dialog.findViewById(ResUtils.id(context, "ebpay_logout")).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                AccountManager.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).logout();
                WalletLoginHelper.getInstance().logout();
                IAfterDismissCallback iAfterDismissCallback = iAfterDismissCallback;
                if (iAfterDismissCallback != null) {
                    iAfterDismissCallback.onLogout();
                }
            }
        });
        dialog.findViewById(ResUtils.id(context, "ebpay_cancel")).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
                IAfterDismissCallback iAfterDismissCallback = iAfterDismissCallback;
                if (iAfterDismissCallback != null) {
                    iAfterDismissCallback.onCancel();
                }
            }
        });
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = DisplayUtils.getDisplayWidth(context);
        attributes.y = (DisplayUtils.getDisplayHeight(context) - attributes.height) / 2;
        window.setAttributes(attributes);
        window.setWindowAnimations(ResUtils.style(context, "DialogWindowAnim"));
        dialog.show();
    }
}
