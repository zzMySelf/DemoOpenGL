package com.tera.scan.main.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.reflect.TypeToken;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import fe.ggg.ad.qw.de.th.rg;
import fe.mmm.qw.j.yj;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/tera/scan/main/viewmodel/ScanAllToolFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_allToolLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tera/scan/main/ui/model/AllScanToolRes;", "allToolLiveData", "Landroidx/lifecycle/LiveData;", "getAllToolLiveData$app_main_aiscanConfigRelease", "()Landroidx/lifecycle/LiveData;", "tools", "getTools", "()Ljava/util/List;", "setTools", "(Ljava/util/List;)V", "allToolGsonToList", "jsonString", "", "getLocalAllToolData", "loadScanAllToolData", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanAllToolFragmentViewModel extends ViewModel {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final LiveData<List<fe.mmm.qw.xxx.p032if.fe.qw>> f7016ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public List<fe.mmm.qw.xxx.p032if.fe.qw> f7017de = new ArrayList();
    @NotNull
    public final MutableLiveData<List<fe.mmm.qw.xxx.p032if.fe.qw>> qw;

    public static final class qw extends TypeToken<List<? extends fe.mmm.qw.xxx.p032if.fe.qw>> {
    }

    public ScanAllToolFragmentViewModel() {
        MutableLiveData<List<fe.mmm.qw.xxx.p032if.fe.qw>> mutableLiveData = new MutableLiveData<>();
        this.qw = mutableLiveData;
        this.f7016ad = mutableLiveData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getAssets();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<fe.mmm.qw.xxx.p032if.fe.qw> ad() {
        /*
            r2 = this;
            android.content.Context r0 = com.tera.scan.framework.kernel.BaseApplication.mContext
            if (r0 == 0) goto L_0x0011
            android.content.res.AssetManager r0 = r0.getAssets()
            if (r0 == 0) goto L_0x0011
            java.lang.String r1 = "scan_all_tool.json"
            java.io.InputStream r0 = r0.open(r1)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            java.lang.String r0 = fe.mmm.qw.j.pf.qw(r0)
            java.util.List r0 = r2.qw(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.viewmodel.ScanAllToolFragmentViewModel.ad():java.util.List");
    }

    @NotNull
    public final LiveData<List<fe.mmm.qw.xxx.p032if.fe.qw>> getAllToolLiveData$app_main_aiscanConfigRelease() {
        return this.f7016ad;
    }

    @NotNull
    public final List<fe.mmm.qw.xxx.p032if.fe.qw> getTools() {
        return this.f7017de;
    }

    public final void loadScanAllToolData(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        rg.yj(this.qw, ad());
    }

    public final List<fe.mmm.qw.xxx.p032if.fe.qw> qw(String str) {
        Either either;
        try {
            either = ExpectKt.success((List) yj.ad(str, new qw().getType()));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        Object successOrNull = ExpectKt.successOrNull(either);
        if (successOrNull != null) {
            return TypeIntrinsics.asMutableList(successOrNull);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.tera.scan.main.ui.model.AllScanToolRes>");
    }

    public final void setTools(@NotNull List<fe.mmm.qw.xxx.p032if.fe.qw> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f7017de = list;
    }
}
