package com.unionpay.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.UPQuerySEPayInfoCallback;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.mi.UPTsmAddon;
import com.unionpay.tsmservice.mi.request.QueryVendorPayStatusRequestParams;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.b;
import com.unionpay.utils.j;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f6107a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public UPQuerySEPayInfoCallback f6108b;

    /* renamed from: c  reason: collision with root package name */
    private UPTsmAddon f6109c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f6110d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f6111e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6112f = false;

    /* renamed from: g  reason: collision with root package name */
    private QueryVendorPayStatusRequestParams f6113g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler.Callback f6114h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Handler f6115i;

    /* renamed from: j  reason: collision with root package name */
    private final UPTsmAddon.UPTsmConnectionListener f6116j;

    public g(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback) {
        String str = "";
        this.f6110d = str;
        this.f6111e = str;
        h hVar = new h(this);
        this.f6114h = hVar;
        this.f6115i = new Handler(hVar);
        this.f6116j = new i(this);
        this.f6107a = context;
        this.f6108b = uPQuerySEPayInfoCallback;
        this.f6112f = true;
        System.loadLibrary("entryexpro");
        String a2 = UPUtils.a(this.f6107a, "mode");
        str = a2 != null ? a2 : str;
        try {
            Integer.decode(!b.d(str) ? "02" : str).intValue();
        } catch (Exception e2) {
        }
    }

    static /* synthetic */ void a(g gVar, int i2, String str) {
        switch (i2) {
            case 4000:
                gVar.a(gVar.f6110d, gVar.f6111e, UPSEInfoResp.ERROR_NOT_SUPPORT, str);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void a(g gVar, Bundle bundle) {
        Context context;
        gVar.f6110d = bundle.getString("vendorPayName");
        gVar.f6111e = bundle.getString("vendorPayAliasType");
        int i2 = bundle.getInt("vendorPayStatus");
        String string = bundle.getString("errorDesc");
        int i3 = bundle.getInt("cardNumber", 0);
        if (!TextUtils.isEmpty(gVar.f6111e) && (context = gVar.f6107a) != null) {
            UPUtils.a(context, gVar.f6111e, "se_type");
        }
        switch (i2) {
            case 0:
                if (i3 > 0) {
                    String str = gVar.f6110d;
                    String str2 = gVar.f6111e;
                    gVar.c();
                    UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = gVar.f6108b;
                    if (uPQuerySEPayInfoCallback != null) {
                        uPQuerySEPayInfoCallback.onResult(str, str2, i3, bundle);
                        return;
                    }
                    return;
                }
                gVar.a(gVar.f6110d, gVar.f6111e, UPSEInfoResp.ERROR_NOT_READY, "card number 0");
                return;
            case 1:
                gVar.a(gVar.f6110d, gVar.f6111e, UPSEInfoResp.ERROR_NOT_READY, "not ready");
                return;
            case 2:
            case 3:
            case 4:
                gVar.a(gVar.f6110d, gVar.f6111e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
                return;
            default:
                gVar.a(gVar.f6110d, gVar.f6111e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
                return;
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4) {
        c();
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = this.f6108b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onError(str, str2, str3, str4);
        }
    }

    private boolean a(String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f6107a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception e2) {
        }
        if (packageInfo == null) {
            return false;
        }
        j.a("tsm-client", "tsm version code=" + packageInfo.versionCode);
        return packageInfo.versionCode >= 8;
    }

    private void c() {
        UPTsmAddon uPTsmAddon = this.f6109c;
        if (uPTsmAddon != null) {
            uPTsmAddon.removeConnectionListener(this.f6116j);
            this.f6109c.unbind();
        }
    }

    public final int a() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.f6107a == null || this.f6108b == null) {
            return UPSEInfoResp.PARAM_ERROR;
        }
        if (a("com.unionpay.tsmservice.mi")) {
            UPTsmAddon instance = UPTsmAddon.getInstance(this.f6107a);
            this.f6109c = instance;
            instance.addConnectionListener(this.f6116j);
            j.c("uppay-spay", "type se  bind service");
            UPTsmAddon uPTsmAddon = this.f6109c;
            if (uPTsmAddon == null || uPTsmAddon.isConnected()) {
                UPTsmAddon uPTsmAddon2 = this.f6109c;
                if (uPTsmAddon2 != null && uPTsmAddon2.isConnected()) {
                    j.c("uppay", "tsm service already connected");
                    b();
                }
                return UPSEInfoResp.SUCCESS;
            }
            j.c("uppay", "bind service");
            if (!this.f6109c.bind()) {
                str4 = this.f6110d;
                str3 = this.f6111e;
                str2 = UPSEInfoResp.ERROR_NONE;
                str = "Tsm service bind fail";
            }
            return UPSEInfoResp.SUCCESS;
        } else if (!b.d(this.f6107a, "com.unionpay.tsmservice.mi")) {
            str4 = this.f6110d;
            str3 = this.f6111e;
            str2 = UPSEInfoResp.ERROR_TSM_UNINSTALLED;
            str = "Mi Tsm service apk is not installed";
        } else {
            str4 = this.f6110d;
            str3 = this.f6111e;
            str2 = UPSEInfoResp.ERROR_NOT_SUPPORT;
            str = "Mi Tsm service apk version is low";
        }
        a(str4, str3, str2, str);
        return UPSEInfoResp.SUCCESS;
    }

    public final boolean b() {
        try {
            j.c("uppay", "getVendorPayStatus()");
            if (this.f6113g == null) {
                this.f6113g = new QueryVendorPayStatusRequestParams();
            }
            if (this.f6109c.queryVendorPayStatus(this.f6113g, new j(this.f6115i)) != 0) {
                j.c("uppay", "ret != 0");
                a(this.f6110d, this.f6111e, UPSEInfoResp.ERROR_NOT_SUPPORT, "Mi Tsm service apk version is low");
                return false;
            }
            Handler handler = this.f6115i;
            handler.sendMessageDelayed(Message.obtain(handler, 4, 4000, 0, ""), 5000);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
