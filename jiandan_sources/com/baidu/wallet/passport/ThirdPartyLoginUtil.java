package com.baidu.wallet.passport;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.NoProguard;

public class ThirdPartyLoginUtil implements NoProguard {
    public static final String[] NEGATIVE_STRS = {"bd_wallet_base_third_login_negative", "bd_wallet_base_third_login_giveup", "bd_wallet_base_third_login_giveup", "bd_wallet_base_third_login_giveup"};
    public static final String[] POSITIVE_STRS = {"bd_wallet_base_third_login_positive", "bd_wallet_base_third_login_normalize", "bd_wallet_base_third_login_bindphone", "bd_wallet_base_third_login_passauth"};
    public static final int THIRD_PARTH_BINDPHONE = 2;
    public static final int THIRD_PARTH_LOGIN = 0;
    public static final int THIRD_PARTH_NORMALIZE = 1;
    public static final int THIRD_PARTH_NOT = -1;
    public static final int THIRD_PARTH_PASSAUTH = 3;
    public LoginBackListenerProxy loginBackListener;
    public WalletApiExtListener.ThirdPartyLoginInterface mTPLImpl;

    public static class a {
        public static ThirdPartyLoginUtil a = new ThirdPartyLoginUtil();
    }

    public static ThirdPartyLoginUtil getInstance() {
        return a.a;
    }

    public boolean checkThirdPartyLogin(final Activity activity, int i2, String str, final WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
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
        final PromptDialog promptDialog = new PromptDialog(activity);
        if (i3 == 0) {
            promptDialog.setTitleText(ResUtils.getString(activity, "bd_wallet_base_third_login_title"));
        } else {
            promptDialog.hideTitle();
        }
        promptDialog.setMessage((CharSequence) str);
        final int i4 = i3;
        final Activity activity2 = activity;
        final WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener2 = thirdPartyLoginListener;
        final PromptDialog promptDialog2 = promptDialog;
        promptDialog.setPositiveBtn(ResUtils.getString(activity, POSITIVE_STRS[i3]), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                int i2 = i4;
                if (i2 == 0) {
                    ThirdPartyLoginUtil.this.startLogin(activity2, thirdPartyLoginListener2);
                } else if (i2 == 1) {
                    ThirdPartyLoginUtil.this.startTuristNormalize(activity2, thirdPartyLoginListener2);
                } else if (i2 == 2) {
                    ThirdPartyLoginUtil.this.startBindPhone(activity2, thirdPartyLoginListener2);
                } else if (i2 == 3) {
                    ThirdPartyLoginUtil.this.startPassSMSAuth(activity2, thirdPartyLoginListener2);
                }
                try {
                    promptDialog2.dismiss();
                } catch (Throwable unused) {
                }
            }
        });
        promptDialog.setNegativeBtn(ResUtils.getString(activity, NEGATIVE_STRS[i3]), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    promptDialog.dismiss();
                } catch (Throwable unused) {
                }
                WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener = thirdPartyLoginListener;
                if (thirdPartyLoginListener != null) {
                    thirdPartyLoginListener.onCallFail(0, (String) null);
                }
                activity.finish();
            }
        });
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

    public void startLogin(Context context, final WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener) {
        this.loginBackListener = new LoginBackListenerProxy(context, new ILoginBackListener() {
            public void onFail(int i2, String str) {
                if (i2 == 603) {
                    WalletLoginHelper.getInstance().onlyLogin(ThirdPartyLoginUtil.this.loginBackListener);
                    return;
                }
                WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener = thirdPartyLoginListener;
                if (thirdPartyLoginListener != null) {
                    thirdPartyLoginListener.onCallFail(0, (String) null);
                }
            }

            public void onSuccess(int i2, String str) {
                WalletApiExtListener.ThirdPartyLoginListener thirdPartyLoginListener = thirdPartyLoginListener;
                if (thirdPartyLoginListener != null) {
                    thirdPartyLoginListener.onCallSuccess(0, (String) null);
                }
            }
        });
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
