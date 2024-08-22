package com.tera.scan.vip.network;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import androidx.lifecycle.LiveData;
import com.mars.kotlin.service.IHandlable;
import com.mars.kotlin.service.Result;
import com.tera.scan.vip.network.model.OrderInfoResponse;
import com.tera.scan.vip.network.model.PreCreateOrderResponse;
import com.tera.scan.vip.network.model.ProductsResponse;
import com.tera.scan.vip.network.model.ReportGooglePayTokenResponse;
import com.tera.scan.vip.network.model.UserInfoResponse;
import fe.mmm.qw.a.yj.qw.de;
import fe.mmm.qw.k.uk.ad.ad;
import fe.mmm.qw.k.uk.ad.fe;
import fe.mmm.qw.k.uk.ad.qw;
import fe.mmm.qw.k.uk.ad.rg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VipService implements IVip, IHandlable<IVip> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Context f7462ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public ResultReceiver f7463de;
    @NotNull
    public final de qw;

    public VipService(@NotNull de deVar, @NotNull Context context) {
        this.qw = deVar;
        this.f7462ad = context;
    }

    @NotNull
    public LiveData<Result<ProductsResponse>> ad() {
        this.qw.qw(new ad(this.f7462ad, this.f7463de));
        this.f7463de = null;
        return null;
    }

    @NotNull
    public LiveData<Result<UserInfoResponse>> de() {
        this.qw.qw(new fe.mmm.qw.k.uk.ad.de(this.f7462ad, this.f7463de));
        this.f7463de = null;
        return null;
    }

    @NotNull
    public LiveData<Result<PreCreateOrderResponse>> fe(@NotNull String str, @NotNull String str2) {
        this.qw.qw(new fe(this.f7462ad, str, str2, this.f7463de));
        this.f7463de = null;
        return null;
    }

    public void onHandle(@NotNull Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            char c = 65535;
            switch (action.hashCode()) {
                case -1023959994:
                    if (action.equals("com.tera.scan.vip.network.ACTION_REPORTGOOGLEPAYTOKEN")) {
                        c = 2;
                        break;
                    }
                    break;
                case 70662615:
                    if (action.equals("com.tera.scan.vip.network.ACTION_PRECREATEORDER")) {
                        c = 1;
                        break;
                    }
                    break;
                case 335423726:
                    if (action.equals("com.tera.scan.vip.network.ACTION_GETORDERINFO")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1374974738:
                    if (action.equals("com.tera.scan.vip.network.ACTION_GETPRODUCTS")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2112885927:
                    if (action.equals("com.tera.scan.vip.network.ACTION_GETUSERINFO")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                try {
                    ClassLoader classLoader = intent.getExtras().getClassLoader();
                    if (classLoader == null) {
                        classLoader = getClass().getClassLoader();
                        intent.setExtrasClassLoader(classLoader);
                    }
                    classLoader.loadClass(ResultReceiver.class.getName());
                } catch (Throwable unused) {
                }
                this.f7463de = (ResultReceiver) intent.getParcelableExtra("android.os.ResultReceiverresultReceiver");
                qw(intent.getStringExtra("__java.lang.String__orderNo"));
            } else if (c == 1) {
                try {
                    ClassLoader classLoader2 = intent.getExtras().getClassLoader();
                    if (classLoader2 == null) {
                        classLoader2 = getClass().getClassLoader();
                        intent.setExtrasClassLoader(classLoader2);
                    }
                    classLoader2.loadClass(ResultReceiver.class.getName());
                } catch (Throwable unused2) {
                }
                this.f7463de = (ResultReceiver) intent.getParcelableExtra("android.os.ResultReceiverresultReceiver");
                fe(intent.getStringExtra("__java.lang.String__productId"), intent.getStringExtra("__java.lang.String__fr"));
            } else if (c == 2) {
                try {
                    ClassLoader classLoader3 = intent.getExtras().getClassLoader();
                    if (classLoader3 == null) {
                        classLoader3 = getClass().getClassLoader();
                        intent.setExtrasClassLoader(classLoader3);
                    }
                    classLoader3.loadClass(ResultReceiver.class.getName());
                } catch (Throwable unused3) {
                }
                this.f7463de = (ResultReceiver) intent.getParcelableExtra("android.os.ResultReceiverresultReceiver");
                rg(intent.getStringExtra("__java.lang.String__googleOrderId"), intent.getStringExtra("__java.lang.String__packageName"), intent.getStringExtra("__java.lang.String__productId"), intent.getStringExtra("__java.lang.String__purchaseToken"), intent.getBooleanExtra("__boolean__isSub", false));
            } else if (c == 3) {
                try {
                    ClassLoader classLoader4 = intent.getExtras().getClassLoader();
                    if (classLoader4 == null) {
                        classLoader4 = getClass().getClassLoader();
                        intent.setExtrasClassLoader(classLoader4);
                    }
                    classLoader4.loadClass(ResultReceiver.class.getName());
                } catch (Throwable unused4) {
                }
                this.f7463de = (ResultReceiver) intent.getParcelableExtra("android.os.ResultReceiverresultReceiver");
                ad();
            } else if (c == 4) {
                try {
                    ClassLoader classLoader5 = intent.getExtras().getClassLoader();
                    if (classLoader5 == null) {
                        classLoader5 = getClass().getClassLoader();
                        intent.setExtrasClassLoader(classLoader5);
                    }
                    classLoader5.loadClass(ResultReceiver.class.getName());
                } catch (Throwable unused5) {
                }
                this.f7463de = (ResultReceiver) intent.getParcelableExtra("android.os.ResultReceiverresultReceiver");
                de();
            }
        }
    }

    @NotNull
    public LiveData<Result<OrderInfoResponse>> qw(@NotNull String str) {
        this.qw.qw(new qw(this.f7462ad, str, this.f7463de));
        this.f7463de = null;
        return null;
    }

    @NotNull
    public LiveData<Result<ReportGooglePayTokenResponse>> rg(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z) {
        this.qw.qw(new rg(this.f7462ad, str, str2, str3, str4, z, this.f7463de));
        this.f7463de = null;
        return null;
    }
}
