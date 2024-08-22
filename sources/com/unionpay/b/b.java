package com.unionpay.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.nfc.sdk.service.HwOpenPayTask;
import com.unionpay.UPQuerySEPayInfoCallback;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f6093a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public UPQuerySEPayInfoCallback f6094b;

    /* renamed from: c  reason: collision with root package name */
    private UPTsmAddon f6095c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f6096d = "";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f6097e = "";

    /* renamed from: f  reason: collision with root package name */
    private boolean f6098f = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f6099g = false;

    /* renamed from: h  reason: collision with root package name */
    private QueryVendorPayStatusRequestParams f6100h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler.Callback f6101i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Handler f6102j;
    private final UPTsmAddon.UPTsmConnectionListener k;

    public b(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback) {
        c cVar = new c(this);
        this.f6101i = cVar;
        this.f6102j = new Handler(cVar);
        this.k = new e(this);
        this.f6093a = context;
        this.f6094b = uPQuerySEPayInfoCallback;
        this.f6098f = true;
        System.loadLibrary("entryexpro");
    }

    static /* synthetic */ void a(b bVar, int i2, String str) {
        switch (i2) {
            case 4000:
                bVar.a(bVar.f6096d, bVar.f6097e, UPSEInfoResp.ERROR_NOT_SUPPORT, str);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void a(b bVar, Bundle bundle) {
        Context context;
        bVar.f6096d = bundle.getString("vendorPayName");
        bVar.f6097e = bundle.getString("vendorPayAliasType");
        int i2 = bundle.getInt("vendorPayStatus");
        String string = bundle.getString("errorDesc");
        int i3 = bundle.getInt("cardNumber", 0);
        if (!TextUtils.isEmpty(bVar.f6097e) && (context = bVar.f6093a) != null) {
            UPUtils.a(context, bVar.f6097e, "se_type");
        }
        switch (i2) {
            case 0:
                if (i3 > 0) {
                    bVar.a(bVar.f6096d, bVar.f6097e, i3, bundle);
                    return;
                } else {
                    bVar.a(bVar.f6096d, bVar.f6097e, UPSEInfoResp.ERROR_NOT_READY, "card number 0");
                    return;
                }
            case 1:
                bVar.a(bVar.f6096d, bVar.f6097e, UPSEInfoResp.ERROR_NOT_READY, "not ready");
                return;
            case 2:
            case 3:
            case 4:
                bVar.a(bVar.f6096d, bVar.f6097e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
                return;
            default:
                bVar.a(bVar.f6096d, bVar.f6097e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
                return;
        }
    }

    private void a(String str, String str2, int i2, Bundle bundle) {
        d();
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = this.f6094b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onResult(str, str2, i2, bundle);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4) {
        d();
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = this.f6094b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onError(str, str2, str3, str4);
        }
    }

    private boolean a(String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f6093a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception e2) {
        }
        if (packageInfo == null) {
            return false;
        }
        j.a("tsm-client", "tsm version code=" + packageInfo.versionCode);
        return packageInfo.versionCode >= 18;
    }

    static /* synthetic */ void b(b bVar, Bundle bundle) {
        if (bundle != null) {
            bVar.f6096d = "Huawei Pay";
            bVar.f6097e = "04";
            if ("0000".equals(bundle.getString("resultCode"))) {
                bVar.a(bVar.f6096d, bVar.f6097e, bundle.getInt("cardNumber"), bundle);
                return;
            }
            bVar.a(bVar.f6096d, bVar.f6097e, UPSEInfoResp.ERROR_NOT_READY, "not ready");
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        String str;
        String str2;
        String str3;
        String str4;
        if (a("com.unionpay.tsmservice")) {
            UPTsmAddon instance = UPTsmAddon.getInstance(this.f6093a);
            this.f6095c = instance;
            instance.addConnectionListener(this.k);
            j.c("uppay-spay", "type se  bind service");
            UPTsmAddon uPTsmAddon = this.f6095c;
            if (uPTsmAddon == null || uPTsmAddon.isConnected()) {
                UPTsmAddon uPTsmAddon2 = this.f6095c;
                if (uPTsmAddon2 != null && uPTsmAddon2.isConnected()) {
                    j.c("uppay", "tsm service already connected");
                    b();
                    return;
                }
                return;
            }
            j.c("uppay", "bind service");
            if (!this.f6095c.bind()) {
                a(this.f6096d, this.f6097e, UPSEInfoResp.ERROR_NONE, "Tsm service bind fail");
                return;
            }
            return;
        }
        if (!com.unionpay.utils.b.d(this.f6093a, "com.unionpay.tsmservice")) {
            str = this.f6096d;
            str2 = this.f6097e;
            str3 = UPSEInfoResp.ERROR_TSM_UNINSTALLED;
            str4 = "Tsm service apk is not installed";
        } else {
            str = this.f6096d;
            str2 = this.f6097e;
            str3 = UPSEInfoResp.ERROR_NOT_SUPPORT;
            str4 = "Tsm service apk version is low";
        }
        a(str, str2, str3, str4);
    }

    static /* synthetic */ void c(b bVar, Bundle bundle) {
        if (bundle != null) {
            bVar.f6096d = "Huawei Pay";
            bVar.f6097e = "04";
            String string = bundle.getString("errorCode");
            bVar.a(bVar.f6096d, bVar.f6097e, "0002".equals(string) ? UPSEInfoResp.ERROR_NOT_READY : UPSEInfoResp.ERROR_NOT_SUPPORT, bundle.getString("errorDesc"));
        }
    }

    private void d() {
        UPTsmAddon uPTsmAddon = this.f6095c;
        if (uPTsmAddon != null) {
            uPTsmAddon.removeConnectionListener(this.k);
            this.f6095c.unbind();
        }
    }

    static /* synthetic */ void e(b bVar) {
        HwOpenPayTask hwOpenPayTask = new HwOpenPayTask(bVar.f6093a);
        j.c("uppay", "queryHwPayStatus start");
        bVar.f6102j.sendEmptyMessageDelayed(4003, 3000);
        hwOpenPayTask.getUnionOnlinePayStatus(new f(bVar));
    }

    public final int a() {
        if (this.f6093a == null || this.f6094b == null) {
            return UPSEInfoResp.PARAM_ERROR;
        }
        this.f6099g = false;
        if (com.unionpay.utils.b.b()) {
            HwOpenPayTask hwOpenPayTask = new HwOpenPayTask(this.f6093a);
            j.c("uppay", "supportCapacity");
            this.f6102j.sendEmptyMessageDelayed(4005, 2000);
            hwOpenPayTask.supportCapacity("UNIONONLINEPAY", new d(this));
        } else {
            c();
        }
        return UPSEInfoResp.SUCCESS;
    }

    public final boolean b() {
        try {
            j.c("uppay", "getVendorPayStatus()");
            if (this.f6100h == null) {
                this.f6100h = new QueryVendorPayStatusRequestParams();
            }
            if (this.f6095c.queryVendorPayStatus(this.f6100h, new a(this.f6102j)) != 0) {
                j.c("uppay", "ret != 0");
                a(this.f6096d, this.f6097e, UPSEInfoResp.ERROR_NOT_SUPPORT, "Tsm service apk version is low");
                return false;
            }
            Handler handler = this.f6102j;
            handler.sendMessageDelayed(Message.obtain(handler, 4, 4000, 0, ""), 5000);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
