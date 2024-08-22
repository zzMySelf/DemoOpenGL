package com.baidu.wallet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.beans.BeanResponseBase;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.NetworkBean;
import com.baidu.wallet.paysdk.SDKInitBeanCallBack;
import com.baidu.wallet.paysdk.beans.SdkInitBean;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BdWalletUtils {
    public static final String a = "__Baidu_Wallet_SDK_FP";
    public static final String b = "device_fp";
    public static final String c = "__Baidu_Wallet_SDK_KEFU";
    public static final String d = "kefu_phone_num";

    public static boolean a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || (applicationInfo.flags & 2) == 0) ? false : true;
    }

    public static void addFlagsSecure(Activity activity) {
        activity.getWindow().addFlags(8192);
    }

    public static String[] b(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            int length = signatureArr.length;
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = Md5Utils.md5Hex(signatureArr[i2].toByteArray());
            }
            return strArr;
        } catch (PackageManager.NameNotFoundException unused) {
            return new String[0];
        }
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
        String str = (String) SharedPreferencesUtils.getParam(context, a, b, "");
        return !TextUtils.isEmpty(str) ? SafePay.getInstance().localDecrypt1(str) : str;
    }

    public static String getFPFileLastModified(Context context) {
        File file = new File(context.getFilesDir().getParent() + "/shared_prefs/" + a + ActivityChooserModel.HISTORY_FILE_EXTENSION);
        if (!file.exists()) {
            return "";
        }
        return "" + (file.lastModified() / 1000);
    }

    public static void getInitForPoll(Context context) {
        loadDeviceFP(context);
    }

    public static String getKefuPhoneNum(Context context) {
        if (context == null) {
            return "";
        }
        String str = (String) SharedPreferencesUtils.getParam(context, c, d, "");
        return TextUtils.isEmpty(str) ? ResUtils.getString(context, "wallet_base_help_phone_no_dial") : str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: boolean} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0065, code lost:
        r4 = r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isCertifiedApp(@androidx.annotation.NonNull android.content.Context r7) {
        /*
            java.lang.String r0 = "financial"
            boolean r1 = a(r7)
            if (r1 == 0) goto L_0x000b
            java.lang.String r1 = ".dxm.debug.license"
            goto L_0x000d
        L_0x000b:
            java.lang.String r1 = ".dxm.license"
        L_0x000d:
            r2 = 0
            java.lang.String r3 = r7.getPackageName()     // Catch:{ IOException -> 0x0064 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0064 }
            r4.<init>()     // Catch:{ IOException -> 0x0064 }
            java.lang.String r5 = "签名文件名："
            r4.append(r5)     // Catch:{ IOException -> 0x0064 }
            r4.append(r3)     // Catch:{ IOException -> 0x0064 }
            r4.append(r1)     // Catch:{ IOException -> 0x0064 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x0064 }
            com.baidu.wallet.core.utils.LogUtil.d(r0, r4)     // Catch:{ IOException -> 0x0064 }
            android.content.res.AssetManager r4 = r7.getAssets()     // Catch:{ IOException -> 0x0064 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0064 }
            r5.<init>()     // Catch:{ IOException -> 0x0064 }
            r5.append(r3)     // Catch:{ IOException -> 0x0064 }
            r5.append(r1)     // Catch:{ IOException -> 0x0064 }
            java.lang.String r1 = r5.toString()     // Catch:{ IOException -> 0x0064 }
            java.io.InputStream r1 = r4.open(r1)     // Catch:{ IOException -> 0x0064 }
            r4 = 1
            byte[] r1 = a(r1, r4)     // Catch:{ IOException -> 0x0064 }
            java.lang.String[] r7 = b(r7)     // Catch:{ IOException -> 0x0064 }
            r4 = 0
        L_0x004a:
            int r5 = r7.length     // Catch:{ IOException -> 0x0063 }
            if (r2 >= r5) goto L_0x0065
            r5 = r7[r2]     // Catch:{ IOException -> 0x0063 }
            java.lang.String r5 = r5.concat(r3)     // Catch:{ IOException -> 0x0063 }
            byte[] r5 = r5.getBytes()     // Catch:{ IOException -> 0x0063 }
            java.lang.String r6 = "SHA-1"
            boolean r4 = com.baidu.wallet.core.utils.VerSig.verify((byte[]) r1, (byte[]) r5, (java.lang.String) r6)     // Catch:{ IOException -> 0x0063 }
            if (r4 == 0) goto L_0x0060
            goto L_0x0065
        L_0x0060:
            int r2 = r2 + 1
            goto L_0x004a
        L_0x0063:
            r2 = r4
        L_0x0064:
            r4 = r2
        L_0x0065:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r1 = "验签结果："
            r7.append(r1)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            com.baidu.wallet.core.utils.LogUtil.d(r0, r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.utils.BdWalletUtils.isCertifiedApp(android.content.Context):boolean");
    }

    public static void loadDeviceFP(Context context) {
        SdkInitBean sdkInitBean = new SdkInitBean(DxmApplicationContextImpl.getApplicationContext(context));
        sdkInitBean.setType(2);
        sdkInitBean.setResponseCallback(new SDKInitBeanCallBack(context));
        sdkInitBean.execBean();
        SdkInitBean sdkInitBean2 = new SdkInitBean(DxmApplicationContextImpl.getApplicationContext(context));
        sdkInitBean2.setType(3);
        sdkInitBean2.setResponseCallback(new SDKInitBeanCallBack(context));
        sdkInitBean2.execBean();
    }

    public static void setDeviceFP(Context context, String str) {
        if (str != null) {
            SharedPreferencesUtils.setParam(context, a, b, SafePay.getInstance().localEncrypt1(str));
        }
    }

    public static void setKefuPhoneNumToSP(Context context, String str) {
        if (str != null && context != null) {
            SharedPreferencesUtils.setParam(context, c, d, str);
        }
    }

    public static void showThemeDialog(Context context, String str, String str2, String str3, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        final PromptDialog promptDialog = new PromptDialog(context);
        promptDialog.setMessage((CharSequence) str);
        promptDialog.setNegativeBtn(str2, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                promptDialog.dismiss();
            }
        });
        promptDialog.setPositiveBtn(str3, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                View.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                promptDialog.dismiss();
            }
        });
        promptDialog.show();
    }

    public static byte[] a(InputStream inputStream, boolean z) throws IOException {
        if (inputStream != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } finally {
                    if (z) {
                        inputStream.close();
                    }
                    byteArrayOutputStream.close();
                }
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw new IOException("The input stream is null!");
    }
}
