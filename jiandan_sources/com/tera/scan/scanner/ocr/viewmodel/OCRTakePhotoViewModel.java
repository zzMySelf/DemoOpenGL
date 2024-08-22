package com.tera.scan.scanner.ocr.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.net.MediaType;
import com.mars.kotlin.extension.LoggerKt;
import fe.mmm.qw.th.qw.th.p031switch.ad;
import fe.mmm.qw.tt.ad.i;
import fe.mmm.qw.yj.th;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\tJ\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/tera/scan/scanner/ocr/viewmodel/OCRTakePhotoViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_autoScanSwitch", "Landroidx/lifecycle/MutableLiveData;", "", "_currentBottomTab", "Lcom/tera/scan/scanner/ocr/OCRBottomTab;", "_isTakeSingle", "_isTakingMode", "autoScanSwitch", "Landroidx/lifecycle/LiveData;", "getAutoScanSwitch", "()Landroidx/lifecycle/LiveData;", "currentBottomTab", "getCurrentBottomTab$scanner_aiscanConfigRelease", "isTakeSingle", "isTakingMode", "isTakingMode$scanner_aiscanConfigRelease", "ubcSource", "", "getUbcSource$scanner_aiscanConfigRelease", "()Ljava/lang/String;", "setUbcSource$scanner_aiscanConfigRelease", "(Ljava/lang/String;)V", "autoScanSwitchValue", "", "isAutoScanSwitchOpen", "isSingleMode", "setAutoScanSwitch", "", "open", "setCurrentBottomTab", "tab", "setIsTakeSingle", "isSingle", "setIsTakingMode", "isTaking", "supportSingleMode", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCRTakePhotoViewModel extends AndroidViewModel {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final LiveData<i> f7287ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final MutableLiveData<Boolean> f7288de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final LiveData<Boolean> f7289fe;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public String f7290i = "";
    @NotNull
    public final MutableLiveData<i> qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final MutableLiveData<Boolean> f7291rg;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final LiveData<Boolean> f7292th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final LiveData<Boolean> f7293uk;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final MutableLiveData<Boolean> f7294yj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRTakePhotoViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        MutableLiveData<i> mutableLiveData = new MutableLiveData<>();
        this.qw = mutableLiveData;
        this.f7287ad = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this.f7288de = mutableLiveData2;
        this.f7289fe = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(Boolean.TRUE);
        this.f7291rg = mutableLiveData3;
        this.f7292th = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>(Boolean.TRUE);
        this.f7294yj = mutableLiveData4;
        this.f7293uk = mutableLiveData4;
    }

    public final int autoScanSwitchValue() {
        return isAutoScanSwitchOpen() ? 1 : 0;
    }

    @NotNull
    public final LiveData<Boolean> getAutoScanSwitch() {
        return this.f7293uk;
    }

    @NotNull
    public final LiveData<i> getCurrentBottomTab$scanner_aiscanConfigRelease() {
        return this.f7287ad;
    }

    @NotNull
    public final String getUbcSource$scanner_aiscanConfigRelease() {
        return this.f7290i;
    }

    public final boolean isAutoScanSwitchOpen() {
        if (this.f7294yj.getValue() == null) {
            boolean z = th.ppp().rg("ocr_auto_scan_switch", 1) == 1;
            LoggerKt.d$default("isAutoScanSwitchOpen default " + z, (Object) null, 1, (Object) null);
            return z;
        }
        LoggerKt.d$default("isAutoScanSwitchOpen setting " + Intrinsics.areEqual((Object) this.f7294yj.getValue(), (Object) Boolean.TRUE), (Object) null, 1, (Object) null);
        return Intrinsics.areEqual((Object) this.f7294yj.getValue(), (Object) Boolean.TRUE);
    }

    public final boolean isSingleMode() {
        return supportSingleMode() && Intrinsics.areEqual((Object) this.f7291rg.getValue(), (Object) Boolean.TRUE);
    }

    @NotNull
    public final LiveData<Boolean> isTakeSingle() {
        return this.f7292th;
    }

    public final boolean isTakingMode() {
        return Intrinsics.areEqual((Object) this.f7289fe.getValue(), (Object) Boolean.TRUE);
    }

    @NotNull
    public final LiveData<Boolean> isTakingMode$scanner_aiscanConfigRelease() {
        return this.f7289fe;
    }

    public final void setAutoScanSwitch(boolean z) {
        ad.de(this.f7294yj, Boolean.valueOf(z));
        th.ppp().pf("ocr_auto_scan_switch", z ? 1 : 0);
    }

    public final void setCurrentBottomTab(@NotNull i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "tab");
        ad.de(this.qw, iVar);
    }

    public final void setIsTakeSingle(boolean z) {
        this.f7291rg.postValue(Boolean.valueOf(z));
    }

    public final void setIsTakingMode(boolean z) {
        if (!isSingleMode()) {
            ad.de(this.f7288de, Boolean.valueOf(z));
        }
    }

    public final void setUbcSource$scanner_aiscanConfigRelease(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f7290i = str;
    }

    public final boolean supportSingleMode() {
        i value = this.qw.getValue();
        return value != null && value.rg();
    }
}
