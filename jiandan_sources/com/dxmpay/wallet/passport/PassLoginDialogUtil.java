package com.dxmpay.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.wallet.api.ILoginBackListener;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.LogUtil;

public class PassLoginDialogUtil implements NoProguard {

    public class ad implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f4311ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f4312th;

        public ad(PassLoginDialogUtil passLoginDialogUtil, PromptDialog promptDialog, ILoginBackListener iLoginBackListener) {
            this.f4311ad = promptDialog;
            this.f4312th = iLoginBackListener;
        }

        public void onClick(View view) {
            try {
                this.f4311ad.dismiss();
            } catch (Exception e) {
                LogUtil.e("PassLoginDialog", "dialog Exception", e);
            }
            WalletLoginHelper.getInstance().onlyLogin(this.f4312th);
        }
    }

    public static class de {
        public static PassLoginDialogUtil qw = new PassLoginDialogUtil((qw) null);
    }

    public class qw implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f4313ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ ILoginBackListener f4314th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ String f4315uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ int f4316yj;

        public qw(PassLoginDialogUtil passLoginDialogUtil, PromptDialog promptDialog, ILoginBackListener iLoginBackListener, int i2, String str) {
            this.f4313ad = promptDialog;
            this.f4314th = iLoginBackListener;
            this.f4316yj = i2;
            this.f4315uk = str;
        }

        public void onClick(View view) {
            try {
                this.f4313ad.dismiss();
            } catch (Exception e) {
                LogUtil.e("PassLoginDialog", "dialog Exception", e);
            }
            ILoginBackListener iLoginBackListener = this.f4314th;
            if ((iLoginBackListener instanceof LoginBackListenerProxy) && ((LoginBackListenerProxy) iLoginBackListener).getLoginBackListener() != null) {
                ((LoginBackListenerProxy) this.f4314th).getLoginBackListener().onFail(this.f4316yj, this.f4315uk);
            }
        }
    }

    public /* synthetic */ PassLoginDialogUtil(qw qwVar) {
        this();
    }

    public static PassLoginDialogUtil getInstance() {
        return de.qw;
    }

    public void showLoginTipDialog(Context context, ILoginBackListener iLoginBackListener, int i2, String str) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            if (context != null) {
                GlobalUtils.toast(context, ResUtils.getString(context, "dxm_wallet_base_open_bduss_network_resolve_error"));
            }
            if (iLoginBackListener instanceof LoginBackListenerProxy) {
                LoginBackListenerProxy loginBackListenerProxy = (LoginBackListenerProxy) iLoginBackListener;
                if (loginBackListenerProxy.getLoginBackListener() != null) {
                    loginBackListenerProxy.getLoginBackListener().onFail(i2, str);
                    return;
                }
                return;
            }
            return;
        }
        PromptDialog promptDialog = new PromptDialog(context);
        promptDialog.setMessage((CharSequence) ResUtils.getString(context, "dxm_wallet_base_open_bduss_system_error"));
        promptDialog.setNegativeBtn(ResUtils.getString(context, "dxm_wallet_base_open_bduss_system_error_retry"), (View.OnClickListener) new qw(this, promptDialog, iLoginBackListener, i2, str));
        promptDialog.setPositiveBtn(ResUtils.getString(context, "dxm_wallet_base_open_bduss_system_error_login"), (View.OnClickListener) new ad(this, promptDialog, iLoginBackListener));
        promptDialog.show();
    }

    public PassLoginDialogUtil() {
    }
}
