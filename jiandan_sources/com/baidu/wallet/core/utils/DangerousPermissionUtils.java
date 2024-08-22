package com.baidu.wallet.core.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.restnet.http.b;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.base.iddetect.utils.StorageUtils;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.google.common.net.MediaType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class DangerousPermissionUtils {
    public static final String DPU_SOURCE_LANGBRIDGE = "wallet_langbridge";
    public static final String a = "dangerous_permission_utils";
    public boolean b;
    public Map<String, DangerousPermission> c;
    public WeakReference<Activity> d;
    public String[] e;
    public int f;
    public boolean g;
    public BaiduWalletUtils.IRequestPermissionCallBack h;

    /* renamed from: i  reason: collision with root package name */
    public DangerousPermissionDialog f3556i;
    public List<String> j;

    public static class DangerousPermission {
        public static final String a = "dp_";
        public Context b;
        public String c;
        public String d;
        public String e;
        public String f;

        public DangerousPermission(Context context, String str, String str2, String str3, String str4) {
            this.b = DxmApplicationContextImpl.getApplicationContext(context);
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
        }

        public void b() {
            Context context = this.b;
            SharedPreferencesUtils.setParam(context, DangerousPermissionUtils.a, a + this.c, Boolean.TRUE);
        }

        public String c() {
            return TextUtils.isEmpty(this.f) ? ResUtils.getString(this.b, this.e) : this.f;
        }

        public String d() {
            String str;
            try {
                str = new JSONObject(this.d).optString("positive");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.b, "wallet_base_permission_positive") : str;
        }

        public String e() {
            String str;
            try {
                str = new JSONObject(this.d).optString("negative");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.b, "wallet_base_permission_negative") : str;
        }

        public String getPermission() {
            return this.c;
        }

        public String getTitle() {
            String str;
            try {
                str = new JSONObject(this.d).optString("title");
            } catch (Exception e2) {
                e2.printStackTrace();
                str = "";
            }
            return TextUtils.isEmpty(str) ? ResUtils.getString(this.b, "wallet_base_permission_title") : str;
        }

        public boolean a() {
            Context context = this.b;
            return ((Boolean) SharedPreferencesUtils.getParam(context, DangerousPermissionUtils.a, a + this.c, Boolean.FALSE)).booleanValue();
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

    public static class a {
        public static DangerousPermissionUtils a = new DangerousPermissionUtils();
    }

    public static DangerousPermissionUtils getInstance() {
        return a.a;
    }

    public static void onClickEvent(String str, List list) {
        if (!TextUtils.isEmpty(str) && list != null) {
            DXMSdkSAUtils.onEventWithValues(DXMSdkSAUtils.SDK_EVENT_CLICK, str, list);
        }
    }

    public static void onShowEvent(String str, List list) {
        if (list != null && !TextUtils.isEmpty(str)) {
            DXMSdkSAUtils.onEventWithValues(DXMSdkSAUtils.SDK_EVENT_SHOW, str, list);
        }
    }

    public String getPermissionDialogDescription(Context context, String str) {
        a(context);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String lowerCase = str.toLowerCase();
        char c2 = 65535;
        try {
            switch (lowerCase.hashCode()) {
                case -1884274053:
                    if (lowerCase.equals("storage")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1367751899:
                    if (lowerCase.equals("camera")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -567451565:
                    if (lowerCase.equals("contacts")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 93166550:
                    if (lowerCase.equals(MediaType.AUDIO_TYPE)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1901043637:
                    if (lowerCase.equals(b.c.j)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                return this.c.get("android.permission.READ_CONTACTS").c();
            }
            if (c2 == 1) {
                return this.c.get("android.permission.ACCESS_FINE_LOCATION").c();
            }
            if (c2 == 2) {
                return this.c.get("android.permission.CAMERA").c();
            }
            if (c2 == 3) {
                return this.c.get("android.permission.READ_EXTERNAL_STORAGE").c();
            }
            if (c2 != 4) {
                return "";
            }
            return this.c.get("android.permission.RECORD_AUDIO").c();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void requestPermissionsDialog(String str, Activity activity, String[] strArr, BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack) {
        a((Context) activity);
        if (a(str) && activity != null) {
            this.d = new WeakReference<>(activity);
            this.e = strArr;
            this.f = -1;
            this.g = true;
            this.h = iRequestPermissionCallBack;
            this.b = TextUtils.equals("wallet_langbridge", str);
            DangerousPermissionDialog dangerousPermissionDialog = this.f3556i;
            if (dangerousPermissionDialog != null) {
                dangerousPermissionDialog.dismiss();
                this.f3556i = null;
            }
            a();
        } else if (iRequestPermissionCallBack != null) {
            iRequestPermissionCallBack.isAllAgree(Boolean.TRUE);
        }
    }

    public DangerousPermissionUtils() {
    }

    private void a(Context context) {
        if (this.c == null && context != null) {
            HashMap hashMap = new HashMap();
            this.c = hashMap;
            Context context2 = context;
            hashMap.put("android.permission.READ_CONTACTS", new DangerousPermission(context2, "android.permission.READ_CONTACTS", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_read_contacts", SdkInitResponse.getInstance().permission_dialog_contacts));
            this.c.put("android.permission.ACCESS_FINE_LOCATION", new DangerousPermission(context2, "android.permission.ACCESS_FINE_LOCATION", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_fine_location", SdkInitResponse.getInstance().permission_dialog_location));
            this.c.put("android.permission.CAMERA", new DangerousPermission(context2, "android.permission.CAMERA", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_access_camera", SdkInitResponse.getInstance().permission_dialog_camera));
            this.c.put("android.permission.RECORD_AUDIO", new DangerousPermission(context2, "android.permission.RECORD_AUDIO", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_record_audio", SdkInitResponse.getInstance().permission_dialog_audio));
            this.c.put(StorageUtils.EXTERNAL_STORAGE_PERMISSION, new DangerousPermission(context2, StorageUtils.EXTERNAL_STORAGE_PERMISSION, SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
            this.c.put("android.permission.READ_EXTERNAL_STORAGE", new DangerousPermission(context2, "android.permission.READ_EXTERNAL_STORAGE", SdkInitResponse.getInstance().permission_dialog_info, "wallet_base_permission_dialog_external_storage", SdkInitResponse.getInstance().permission_dialog_storage));
        }
    }

    /* access modifiers changed from: private */
    public List<String> a(DangerousPermission dangerousPermission, boolean z, String str) {
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        if (dangerousPermission == null) {
            return arrayList;
        }
        if (!TextUtils.isEmpty(dangerousPermission.c)) {
            StringBuffer stringBuffer = new StringBuffer();
            String a2 = dangerousPermission.c;
            char c2 = 65535;
            switch (a2.hashCode()) {
                case -1888586689:
                    if (a2.equals("android.permission.ACCESS_FINE_LOCATION")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -406040016:
                    if (a2.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 463403621:
                    if (a2.equals("android.permission.CAMERA")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1365911975:
                    if (a2.equals(StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1831139720:
                    if (a2.equals("android.permission.RECORD_AUDIO")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1977429404:
                    if (a2.equals("android.permission.READ_CONTACTS")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                stringBuffer.append("contacts");
            } else if (c2 == 1) {
                stringBuffer.append(b.c.j);
            } else if (c2 == 2) {
                stringBuffer.append("camera");
            } else if (c2 == 3 || c2 == 4) {
                stringBuffer.append("storage");
            } else if (c2 == 5) {
                stringBuffer.append(MediaType.AUDIO_TYPE);
            }
            this.j.add(stringBuffer.toString());
            if (!TextUtils.isEmpty(str)) {
                this.j.add(str);
            }
        }
        return this.j;
    }

    private boolean a(String str) {
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

    /* access modifiers changed from: private */
    public void a() {
        int i2 = this.f + 1;
        this.f = i2;
        String[] strArr = this.e;
        if (i2 >= strArr.length) {
            a(true);
            return;
        }
        final DangerousPermission dangerousPermission = this.c.get(strArr[i2]);
        if (dangerousPermission == null) {
            a();
            return;
        }
        Activity activity = (Activity) this.d.get();
        if (activity == null) {
            a(false);
            return;
        }
        final DangerousPermissionDialog dangerousPermissionDialog = new DangerousPermissionDialog(activity);
        dangerousPermissionDialog.setTitleText(dangerousPermission.getTitle());
        dangerousPermissionDialog.setMessage((CharSequence) dangerousPermission.c());
        dangerousPermissionDialog.setNegativeBtn(dangerousPermission.e(), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                String str = DangerousPermissionUtils.this.b ? StatServiceEvent.LANGBRIDGE_PERMISSIONDIALOG_KEY : StatServiceEvent.NA_PERMISSIONDIALOG_KEY;
                DangerousPermissionUtils dangerousPermissionUtils = DangerousPermissionUtils.this;
                DangerousPermissionUtils.onClickEvent(str, dangerousPermissionUtils.a(dangerousPermission, dangerousPermissionUtils.b, "0"));
                boolean unused = DangerousPermissionUtils.this.g = false;
                if (DangerousPermissionUtils.this.h != null) {
                    DangerousPermissionUtils.this.h.requestResult(dangerousPermission.getPermission(), Boolean.FALSE);
                }
                dangerousPermissionDialog.dismiss();
                DangerousPermissionUtils.this.a();
            }
        });
        dangerousPermissionDialog.setPositiveBtn(dangerousPermission.d(), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                String str = DangerousPermissionUtils.this.b ? StatServiceEvent.LANGBRIDGE_PERMISSIONDIALOG_KEY : StatServiceEvent.NA_PERMISSIONDIALOG_KEY;
                DangerousPermissionUtils dangerousPermissionUtils = DangerousPermissionUtils.this;
                DangerousPermissionUtils.onClickEvent(str, dangerousPermissionUtils.a(dangerousPermission, dangerousPermissionUtils.b, "1"));
                if (DangerousPermissionUtils.this.h != null) {
                    DangerousPermissionUtils.this.h.requestResult(dangerousPermission.getPermission(), Boolean.TRUE);
                }
                dangerousPermissionDialog.dismiss();
                DangerousPermissionUtils.this.a();
            }
        });
        this.f3556i = dangerousPermissionDialog;
        dangerousPermissionDialog.show();
        onShowEvent(this.b ? StatServiceEvent.LANGBRIDGE_PERMISSIONDIALOG_KEY : StatServiceEvent.NA_PERMISSIONDIALOG_KEY, a(dangerousPermission, this.b, ""));
        BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.h;
        if (iRequestPermissionCallBack != null) {
            iRequestPermissionCallBack.isShow(dangerousPermission.getPermission(), Boolean.TRUE);
        }
    }

    private void a(boolean z) {
        BaiduWalletUtils.IRequestPermissionCallBack iRequestPermissionCallBack = this.h;
        if (iRequestPermissionCallBack != null) {
            iRequestPermissionCallBack.isAllAgree(Boolean.valueOf(z && this.g));
        }
        this.f3556i = null;
        this.h = null;
    }
}
