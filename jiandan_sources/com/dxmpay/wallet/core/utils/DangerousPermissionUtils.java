package com.dxmpay.wallet.core.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import com.dxmpay.apollon.permission.PermissionManager;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.utils.BaiduWalletUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class DangerousPermissionUtils {
    public static final String DPU_SOURCE_LANGBRIDGE = "wallet_langbridge";

    /* renamed from: ad  reason: collision with root package name */
    public WeakReference<Activity> f4264ad;

    /* renamed from: de  reason: collision with root package name */
    public String[] f4265de;

    /* renamed from: fe  reason: collision with root package name */
    public int f4266fe;
    public Map<String, DangerousPermission> qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f4267rg;

    /* renamed from: th  reason: collision with root package name */
    public BaiduWalletUtils.IRequestPermissionCallBack f4268th;

    /* renamed from: yj  reason: collision with root package name */
    public DangerousPermissionDialog f4269yj;

    public static class DangerousPermission {

        /* renamed from: ad  reason: collision with root package name */
        public String f4270ad;

        /* renamed from: de  reason: collision with root package name */
        public String f4271de;

        /* renamed from: fe  reason: collision with root package name */
        public String f4272fe;
        public Context qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f4273rg;

        public DangerousPermission(Context context, String str, String str2, String str3, String str4) {
            this.qw = context.getApplicationContext();
            this.f4270ad = str;
            this.f4271de = str2;
            this.f4272fe = str3;
            this.f4273rg = str4;
        }

        public String ad() {
            String str;
            try {
                str = new JSONObject(this.f4271de).optString("positive");
            } catch (Exception e) {
                LogUtil.e("DangerousPermissionUtils", e.getMessage(), e);
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.qw, "dxm_wallet_base_permission_positive") : str;
        }

        public String de() {
            String str;
            try {
                str = new JSONObject(this.f4271de).optString("negative");
            } catch (Exception e) {
                LogUtil.e("DangerousPermissionUtils", e.getMessage(), e);
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.qw, "dxm_wallet_base_permission_negative") : str;
        }

        public String getPermission() {
            return this.f4270ad;
        }

        public String getTitle() {
            String str;
            try {
                str = new JSONObject(this.f4271de).optString("title");
            } catch (Exception e) {
                LogUtil.e("DangerousPermissionUtils", e.getMessage(), e);
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.qw, "dxm_wallet_base_permission_title") : str;
        }

        public String qw() {
            return TextUtils.isEmpty(this.f4273rg) ? ResUtils.getString(this.qw, this.f4272fe) : this.f4273rg;
        }
    }

    public static class DangerousPermissionDialog extends PromptDialog {
        public DangerousPermissionDialog(Context context) {
            super(context);
        }

        public void dismiss() {
            try {
                super.dismiss();
            } catch (Exception unused) {
            }
        }

        public void show() {
            try {
                super.show();
            } catch (Exception unused) {
            }
        }
    }

    public class ad implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ DangerousPermission f4274ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ DangerousPermissionDialog f4275th;

        public ad(DangerousPermission dangerousPermission, DangerousPermissionDialog dangerousPermissionDialog) {
            this.f4274ad = dangerousPermission;
            this.f4275th = dangerousPermissionDialog;
        }

        public void onClick(View view) {
            if (DangerousPermissionUtils.this.f4268th != null) {
                DangerousPermissionUtils.this.f4268th.requestResult(this.f4274ad.getPermission(), Boolean.TRUE);
            }
            this.f4275th.dismiss();
            DangerousPermissionUtils.this.ad();
        }
    }

    public static class de {
        public static DangerousPermissionUtils qw = new DangerousPermissionUtils((qw) null);
    }

    public class qw implements View.OnClickListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ DangerousPermission f4277ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ DangerousPermissionDialog f4278th;

        public qw(DangerousPermission dangerousPermission, DangerousPermissionDialog dangerousPermissionDialog) {
            this.f4277ad = dangerousPermission;
            this.f4278th = dangerousPermissionDialog;
        }

        public void onClick(View view) {
            boolean unused = DangerousPermissionUtils.this.f4267rg = false;
            if (DangerousPermissionUtils.this.f4268th != null) {
                DangerousPermissionUtils.this.f4268th.requestResult(this.f4277ad.getPermission(), Boolean.FALSE);
            }
            this.f4278th.dismiss();
            DangerousPermissionUtils.this.ad();
        }
    }

    public /* synthetic */ DangerousPermissionUtils(qw qwVar) {
        this();
    }

    public static DangerousPermissionUtils getInstance() {
        return de.qw;
    }

    public final void ad() {
        int i2 = this.f4266fe + 1;
        this.f4266fe = i2;
        String[] strArr = this.f4265de;
        if (i2 >= strArr.length) {
            fe(true);
            return;
        }
        DangerousPermission dangerousPermission = this.qw.get(strArr[i2]);
        if (dangerousPermission == null) {
            ad();
            return;
        }
        Activity activity = (Activity) this.f4264ad.get();
        if (activity == null) {
            fe(false);
            return;
        }
        DangerousPermissionDialog dangerousPermissionDialog = new DangerousPermissionDialog(activity);
        dangerousPermissionDialog.setTitleText(dangerousPermission.getTitle());
        dangerousPermissionDialog.setMessage((CharSequence) dangerousPermission.qw());
        dangerousPermissionDialog.setNegativeBtn(dangerousPermission.de(), (View.OnClickListener) new qw(dangerousPermission, dangerousPermissionDialog));
        dangerousPermissionDialog.setPositiveBtn(dangerousPermission.ad(), (View.OnClickListener) new ad(dangerousPermission, dangerousPermissionDialog));
        this.f4269yj = dangerousPermissionDialog;
        dangerousPermissionDialog.show();
        BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f4268th;
        if (iRequestPermissionCallBack != null) {
            iRequestPermissionCallBack.isShow(dangerousPermission.getPermission(), Boolean.TRUE);
        }
    }

    public final void de(Context context) {
        if (this.qw == null && context != null) {
            HashMap hashMap = new HashMap();
            this.qw = hashMap;
            Context context2 = context;
            hashMap.put("android.permission.READ_CONTACTS", new DangerousPermission(context2, "android.permission.READ_CONTACTS", SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_read_contacts", SdkInitResponse.getInstance().permission_dialog_contacts));
            this.qw.put("android.permission.ACCESS_FINE_LOCATION", new DangerousPermission(context2, "android.permission.ACCESS_FINE_LOCATION", SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_access_fine_location", SdkInitResponse.getInstance().permission_dialog_location));
            this.qw.put("android.permission.CAMERA", new DangerousPermission(context2, "android.permission.CAMERA", SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_access_camera", SdkInitResponse.getInstance().permission_dialog_camera));
            this.qw.put("android.permission.RECORD_AUDIO", new DangerousPermission(context2, "android.permission.RECORD_AUDIO", SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_record_audio", SdkInitResponse.getInstance().permission_dialog_audio));
            this.qw.put(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new DangerousPermission(context2, StorageUtils.EXTERNAL_STORAGE_PERMISSION, SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
            String str = (Build.VERSION.SDK_INT < 33 || PermissionManager.getTargetSdkVersion(context) < 33) ? "android.permission.READ_EXTERNAL_STORAGE" : "android.permission.READ_MEDIA_IMAGES";
            this.qw.put(str, new DangerousPermission(context, str, SdkInitResponse.getInstance().permission_dialog_info, "dxm_wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
        }
    }

    public final void fe(boolean z) {
        BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.f4268th;
        if (iRequestPermissionCallBack != null) {
            iRequestPermissionCallBack.isAllAgree(Boolean.valueOf(z && this.f4267rg));
        }
        this.f4269yj = null;
        this.f4268th = null;
    }

    public void requestPermissionsDialog(String str, Activity activity, String[] strArr, BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack) {
        de(activity);
        if (th(str) && activity != null) {
            this.f4264ad = new WeakReference<>(activity);
            this.f4265de = strArr;
            this.f4266fe = -1;
            this.f4267rg = true;
            this.f4268th = iRequestPermissionCallBack;
            DangerousPermissionDialog dangerousPermissionDialog = this.f4269yj;
            if (dangerousPermissionDialog != null) {
                dangerousPermissionDialog.dismiss();
                this.f4269yj = null;
            }
            ad();
        } else if (iRequestPermissionCallBack != null) {
            iRequestPermissionCallBack.isAllAgree(Boolean.TRUE);
        }
    }

    public final boolean th(String str) {
        if ("wallet_langbridge".equals(str)) {
            return "1".equals(SdkInitResponse.getInstance().langbridge_permission_dialog);
        }
        if ("1".equals(SdkInitResponse.getInstance().sdk_permission_dialog)) {
            return true;
        }
        if ("0".equals(SdkInitResponse.getInstance().sdk_permission_dialog)) {
            return false;
        }
        if ("walletapp".equals(BeanConstants.CHANNEL_ID) || "walletapppro".equals(BeanConstants.CHANNEL_ID) || "bdyouqianhuapro".equals(BeanConstants.CHANNEL_ID) || "bdlicai".equals(BeanConstants.CHANNEL_ID)) {
            return true;
        }
        return false;
    }

    public DangerousPermissionUtils() {
    }
}
