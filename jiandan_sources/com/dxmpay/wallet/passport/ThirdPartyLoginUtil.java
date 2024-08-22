package com.dxmpay.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.NoProguard;

public class ThirdPartyLoginUtil implements NoProguard {
    public static final String[] NEGATIVE_STRS = {"dxm_wallet_base_third_login_negative", "dxm_wallet_base_third_login_giveup", "dxm_wallet_base_third_login_giveup", "dxm_wallet_base_third_login_giveup"};
    public static final String[] POSITIVE_STRS = {"dxm_wallet_base_third_login_positive", "dxm_wallet_base_third_login_normalize", "dxm_wallet_base_third_login_bindphone", "dxm_wallet_base_third_login_passauth"};
    public static final int THIRD_PARTH_BINDPHONE = 2;
    public static final int THIRD_PARTH_LOGIN = 0;
    public static final int THIRD_PARTH_NORMALIZE = 1;
    public static final int THIRD_PARTH_NOT = -1;
    public static final int THIRD_PARTH_PASSAUTH = 3;
    public LoginBackListenerProxy loginBackListener;
    public WalletApiExtListener.ThirdPartyLoginInterface mTPLImpl;

    public class ad implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f4335ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Activity f4337th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f4338uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener f4339yj;

        public ad(int i2, Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener, PromptDialog promptDialog) {
            this.f4335ad = i2;
            this.f4337th = activity;
            this.f4339yj = thirdPartyLoginListener;
            this.f4338uk = promptDialog;
        }

        public void onClick(View view) {
            int i2 = this.f4335ad;
            if (i2 == 0) {
                ThirdPartyLoginUtil.this.startLogin(this.f4337th, this.f4339yj);
            } else if (i2 == 1) {
                ThirdPartyLoginUtil.this.startTuristNormalize(this.f4337th, this.f4339yj);
            } else if (i2 == 2) {
                ThirdPartyLoginUtil.this.startBindPhone(this.f4337th, this.f4339yj);
            } else if (i2 == 3) {
                ThirdPartyLoginUtil.this.startPassSMSAuth(this.f4337th, this.f4339yj);
            }
            try {
                this.f4338uk.dismiss();
            } catch (Throwable unused) {
            }
        }
    }

    public class de implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f4340ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener f4341th;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ Activity f4342yj;

        public de(ThirdPartyLoginUtil thirdPartyLoginUtil, PromptDialog promptDialog, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener, Activity activity) {
            this.f4340ad = promptDialog;
            this.f4341th = thirdPartyLoginListener;
            this.f4342yj = activity;
        }

        public void onClick(View view) {
            try {
                this.f4340ad.dismiss();
            } catch (Throwable unused) {
            }
            WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener = this.f4341th;
            if (thirdPartyLoginListener != null) {
                thirdPartyLoginListener.onCallFail(0, (String) null);
            }
            this.f4342yj.finish();
        }
    }

    public static class fe {
        public static ThirdPartyLoginUtil qw = new ThirdPartyLoginUtil();
    }

    public class qw implements ILoginBackListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ WalletApiExtListener.ThirdPartyLoginListener f4343ad;

        public qw(WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
            this.f4343ad = thirdPartyLoginListener;
        }

        public void onFail(int i2, String str) {
            if (i2 == 603) {
                WalletLoginHelper.getInstance().onlyLogin(ThirdPartyLoginUtil.this.loginBackListener);
                return;
            }
            WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener = this.f4343ad;
            if (thirdPartyLoginListener != null) {
                thirdPartyLoginListener.onCallFail(0, (String) null);
            }
        }

        public void onSuccess(int i2, String str) {
            WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener = this.f4343ad;
            if (thirdPartyLoginListener != null) {
                thirdPartyLoginListener.onCallSuccess(0, (String) null);
            }
        }
    }

    public static ThirdPartyLoginUtil getInstance() {
        return fe.qw;
    }

    public boolean checkThirdPartyLogin(Activity activity, int i2, String str, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        int i3;
        switch (i2) {
            case 5093:
            case 5095:
                i3 = 3;
                break;
            case 5094:
            case 5096:
                i3 = 2;
                break;
            case 5097:
                i3 = 1;
                break;
            case 5099:
                i3 = 0;
                break;
            default:
                i3 = -1;
                break;
        }
        if (i3 == -1) {
            return false;
        }
        PromptDialog promptDialog = new PromptDialog(activity);
        if (i3 == 0) {
            promptDialog.setTitleText(ResUtils.getString(activity, "dxm_wallet_base_third_login_title"));
        } else {
            promptDialog.hideTitle();
        }
        promptDialog.setMessage((CharSequence) str);
        promptDialog.setPositiveBtn(ResUtils.getString(activity, POSITIVE_STRS[i3]), (View.OnClickListener) new ad(i3, activity, thirdPartyLoginListener, promptDialog));
        promptDialog.setNegativeBtn(ResUtils.getString(activity, NEGATIVE_STRS[i3]), (View.OnClickListener) new de(this, promptDialog, thirdPartyLoginListener, activity));
        try {
            promptDialog.show();
        } catch (Throwable unused) {
        }
        return true;
    }

    public void setThirdPartyLoginImpl(WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface) {
        this.mTPLImpl = thirdPartyLoginInterface;
    }

    public void startBindPhone(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface = this.mTPLImpl;
        if (thirdPartyLoginInterface != null) {
            thirdPartyLoginInterface.callBindPhone(activity, thirdPartyLoginListener);
        } else {
            thirdPartyLoginListener.onCallFail(0, (String) null);
        }
    }

    public void startLogin(Context context, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        this.loginBackListener = new LoginBackListenerProxy(context, new qw(thirdPartyLoginListener));
        WalletLoginHelper.getInstance().login(this.loginBackListener);
    }

    public void startPassSMSAuth(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        PassSMSAuthProxyActivity.startPassSMSAuth(activity, thirdPartyLoginListener);
    }

    public void startTuristNormalize(Activity activity, WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        WalletApiExtListener.ThirdPartyLoginInterface thirdPartyLoginInterface = this.mTPLImpl;
        if (thirdPartyLoginInterface != null) {
            thirdPartyLoginInterface.callTuristNormalize(activity, thirdPartyLoginListener);
        } else {
            thirdPartyLoginListener.onCallFail(0, (String) null);
        }
    }
}
