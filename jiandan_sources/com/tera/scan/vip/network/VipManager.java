package com.tera.scan.vip.network;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import com.mars.kotlin.service.Extra;
import com.mars.kotlin.service.LiveResultReceiver;
import com.mars.kotlin.service.Result;
import com.mars.kotlin.service.extension.ContextKt;
import com.tera.scan.vip.network.model.PreCreateOrderResponse;
import com.tera.scan.vip.network.model.ReportGooglePayTokenResponse;
import com.tera.scan.vip.network.model.UserInfoResponse;
import fe.mmm.qw.p030switch.de.qw.ad;
import org.jetbrains.annotations.NotNull;

public final class VipManager implements IVip {
    @NotNull
    public final Context qw;

    public VipManager(@NotNull Context context) {
        this.qw = context;
    }

    @NotNull
    public LiveData<Result<PreCreateOrderResponse>> ad(@NotNull String str, @NotNull String str2) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.baidu.aiscan", "com.tera.scan.main.service.NetdiskService"));
        AnonymousClass2 r1 = new LiveResultReceiver<PreCreateOrderResponse>() {
            public PreCreateOrderResponse getData(Bundle bundle) {
                return (PreCreateOrderResponse) bundle.getParcelable(Extra.RESULT);
            }
        };
        intent.putExtra("android.os.ResultReceiverresultReceiver", r1);
        intent.setAction("com.tera.scan.vip.network.ACTION_PRECREATEORDER");
        intent.addCategory("VipService");
        intent.putExtra("__java.lang.String__productId", str);
        intent.putExtra("__java.lang.String__fr", str2);
        ContextKt.startService(this.qw, intent, "com.baidu.aiscan", "com.tera.scan.main.service.NetdiskJobService", ad.ad());
        return r1.asLiveData();
    }

    @NotNull
    public LiveData<Result<ReportGooglePayTokenResponse>> de(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.baidu.aiscan", "com.tera.scan.main.service.NetdiskService"));
        AnonymousClass5 r1 = new LiveResultReceiver<ReportGooglePayTokenResponse>() {
            public ReportGooglePayTokenResponse getData(Bundle bundle) {
                return (ReportGooglePayTokenResponse) bundle.getParcelable(Extra.RESULT);
            }
        };
        intent.putExtra("android.os.ResultReceiverresultReceiver", r1);
        intent.setAction("com.tera.scan.vip.network.ACTION_REPORTGOOGLEPAYTOKEN");
        intent.addCategory("VipService");
        intent.putExtra("__java.lang.String__googleOrderId", str);
        intent.putExtra("__java.lang.String__packageName", str2);
        intent.putExtra("__java.lang.String__productId", str3);
        intent.putExtra("__java.lang.String__purchaseToken", str4);
        intent.putExtra("__boolean__isSub", z);
        ContextKt.startService(this.qw, intent, "com.baidu.aiscan", "com.tera.scan.main.service.NetdiskJobService", ad.ad());
        return r1.asLiveData();
    }

    @NotNull
    public LiveData<Result<UserInfoResponse>> qw() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.baidu.aiscan", "com.tera.scan.main.service.NetdiskService"));
        AnonymousClass1 r1 = new LiveResultReceiver<UserInfoResponse>() {
            public UserInfoResponse getData(Bundle bundle) {
                return (UserInfoResponse) bundle.getParcelable(Extra.RESULT);
            }
        };
        intent.putExtra("android.os.ResultReceiverresultReceiver", r1);
        intent.setAction("com.tera.scan.vip.network.ACTION_GETUSERINFO");
        intent.addCategory("VipService");
        ContextKt.startService(this.qw, intent, "com.baidu.aiscan", "com.tera.scan.main.service.NetdiskJobService", ad.ad());
        return r1.asLiveData();
    }
}
