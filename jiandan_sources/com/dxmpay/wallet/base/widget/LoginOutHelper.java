package com.dxmpay.wallet.base.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;

public class LoginOutHelper {

    public interface IAfterDismissCallback {
        void onCancel();

        void onLogout();
    }

    public static class ad implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Dialog f4165ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ IAfterDismissCallback f4166th;

        public ad(Dialog dialog, IAfterDismissCallback iAfterDismissCallback) {
            this.f4165ad = dialog;
            this.f4166th = iAfterDismissCallback;
        }

        public void onClick(View view) {
            this.f4165ad.dismiss();
            IAfterDismissCallback iAfterDismissCallback = this.f4166th;
            if (iAfterDismissCallback != null) {
                iAfterDismissCallback.onCancel();
            }
        }
    }

    public static class qw implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Dialog f4167ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Context f4168th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ IAfterDismissCallback f4169yj;

        public qw(Dialog dialog, Context context, IAfterDismissCallback iAfterDismissCallback) {
            this.f4167ad = dialog;
            this.f4168th = context;
            this.f4169yj = iAfterDismissCallback;
        }

        public void onClick(View view) {
            this.f4167ad.dismiss();
            AccountManager.getInstance(this.f4168th.getApplicationContext()).logout();
            WalletLoginHelper.getInstance().logout();
            IAfterDismissCallback iAfterDismissCallback = this.f4169yj;
            if (iAfterDismissCallback != null) {
                iAfterDismissCallback.onLogout();
            }
        }
    }

    public static void showLogoutDialog(Context context, IAfterDismissCallback iAfterDismissCallback) {
        Dialog dialog = new Dialog(context, ResUtils.style(context, "DxmEbpayPromptDialog"));
        dialog.setContentView(ResUtils.layout(context, "dxm_wallet_base_dialog_logout"));
        dialog.findViewById(ResUtils.id(context, "ebpay_logout")).setOnClickListener(new qw(dialog, context, iAfterDismissCallback));
        dialog.findViewById(ResUtils.id(context, "ebpay_cancel")).setOnClickListener(new ad(dialog, iAfterDismissCallback));
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = DisplayUtils.getDisplayWidth(context);
        attributes.y = (DisplayUtils.getDisplayHeight(context) - attributes.height) / 2;
        window.setAttributes(attributes);
        window.setWindowAnimations(ResUtils.style(context, "DxmDialogWindowAnim"));
        dialog.show();
    }
}
