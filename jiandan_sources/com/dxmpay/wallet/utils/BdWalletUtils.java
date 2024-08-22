package com.dxmpay.wallet.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.SharedPreferencesUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.paysdk.SDKInitBeanCallBack;
import com.dxmpay.wallet.paysdk.beans.NewSdkInitBean;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BdWalletUtils {
    public static List qw;

    public static class ad implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f4367ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f4368th;

        public ad(View.OnClickListener onClickListener, PromptDialog promptDialog) {
            this.f4367ad = onClickListener;
            this.f4368th = promptDialog;
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f4367ad;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            this.f4368th.dismiss();
        }
    }

    public static class qw implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f4369ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ PromptDialog f4370th;

        public qw(View.OnClickListener onClickListener, PromptDialog promptDialog) {
            this.f4369ad = onClickListener;
            this.f4370th = promptDialog;
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f4369ad;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            this.f4370th.dismiss();
        }
    }

    public static void addFlagsSecure(Activity activity) {
        activity.getWindow().addFlags(8192);
    }

    public static void clearFlagsSecure(Activity activity) {
        activity.getWindow().clearFlags(8192);
    }

    public static void dealCashDesk(BeanResponseBase.Session session) {
        if (session != null) {
            NetworkBean.SessionCache.getInstance().put((NetworkBean.BizType) null, session);
        }
    }

    public static String getDeviceFP(Context context) {
        String str = (String) SharedPreferencesUtils.getParam(context, "__DxmPay_Wallet_SDK_FP", com.baidu.wallet.utils.BdWalletUtils.b, "");
        return !TextUtils.isEmpty(str) ? SecurePay.getInstance().localDecrypt1(str) : str;
    }

    public static String getFPFileLastModified(Context context) {
        File file = new File(context.getFilesDir().getParent() + "/shared_prefs/" + "__DxmPay_Wallet_SDK_FP" + ActivityChooserModel.HISTORY_FILE_EXTENSION);
        if (!file.exists()) {
            return "";
        }
        return "" + (file.lastModified() / 1000);
    }

    public static List getFunctionNameList() {
        return qw;
    }

    public static String getKefuPhoneNum(Context context) {
        if (context == null) {
            return "";
        }
        String str = (String) SharedPreferencesUtils.getParam(context, "__DxmPay_Wallet_SDK_KEFU", com.baidu.wallet.utils.BdWalletUtils.d, "");
        return TextUtils.isEmpty(str) ? ResUtils.getString(context, "dxm_wallet_base_help_phone_no_dial") : str;
    }

    public static void loadDeviceFP(Context context) {
        SDKInitBeanCallBack sDKInitBeanCallBack = new SDKInitBeanCallBack(context);
        NewSdkInitBean newSdkInitBean = new NewSdkInitBean(context.getApplicationContext());
        newSdkInitBean.setResponseCallback(sDKInitBeanCallBack);
        newSdkInitBean.execBean();
    }

    public static void putFunctionNameList(String... strArr) {
        try {
            if (qw == null) {
                qw = Collections.synchronizedList(new ArrayList());
            }
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (!qw.contains(str)) {
                        qw.add(str);
                    }
                }
            }
        } catch (Exception e) {
            StatisticManager.onEventEndWithValue(StatServiceEvent.PUT_FUNCTION_NAME_ERROR, e.toString());
        }
    }

    public static void setDeviceFP(Context context, String str) {
        if (str != null) {
            SharedPreferencesUtils.setParam(context, "__DxmPay_Wallet_SDK_FP", com.baidu.wallet.utils.BdWalletUtils.b, SecurePay.getInstance().localEncrypt1(str));
        }
    }

    public static void setKefuPhoneNumToSP(Context context, String str) {
        if (str != null && context != null) {
            SharedPreferencesUtils.setParam(context, "__DxmPay_Wallet_SDK_KEFU", com.baidu.wallet.utils.BdWalletUtils.d, str);
        }
    }

    public static void showThemeDialog(Context context, String str, String str2, String str3, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        PromptDialog promptDialog = new PromptDialog(context);
        promptDialog.setMessage((CharSequence) str);
        promptDialog.setNegativeBtn(str2, (View.OnClickListener) new qw(onClickListener, promptDialog));
        promptDialog.setPositiveBtn(str3, (View.OnClickListener) new ad(onClickListener2, promptDialog));
        promptDialog.show();
    }
}
