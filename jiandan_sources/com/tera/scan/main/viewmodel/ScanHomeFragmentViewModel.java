package com.tera.scan.main.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.record.model.ScanRecord;
import fe.ggg.ad.qw.de.th.rg;
import fe.mmm.qw.j.pf;
import i.qw.Cif;
import i.qw.u;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0001\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017J&\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001aR&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\fX\u000e¢\u0006\u0002\n\u0000R,\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00050\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007X\u000e¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006("}, d2 = {"Lcom/tera/scan/main/viewmodel/ScanHomeFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_kingkongTypeLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "", "", "Lcom/tera/scan/main/ui/model/ScanServiceAreaItem;", "_scanRecentRecordsLiveData", "", "kingKongDatas", "", "kingkongTypeLiveData", "Landroidx/lifecycle/LiveData;", "getKingkongTypeLiveData$app_main_aiscanConfigRelease", "()Landroidx/lifecycle/LiveData;", "records", "Lcom/tera/scan/record/model/ScanRecord;", "scanRecentRecordsLiveData", "getScanRecentRecordsLiveData$app_main_aiscanConfigRelease", "getLocalkingKongData", "context", "Landroid/content/Context;", "jsonToMutableMap", "jsonString", "", "loadScanHomeKingkongData", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "loadScanRecords", "observerScanRecordDataChange", "updateScanRecordOpenTime", "activity", "Landroid/app/Activity;", "openTime", "", "recordId", "Companion", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("ScanHomeFragmentViewModel")
public final class ScanHomeFragmentViewModel extends ViewModel {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    public static final int KINGKONG_TYPE_EXTRA_LARGE = 1;
    public static final int KINGKONG_TYPE_LARGE = 2;
    public static final int KINGKONG_TYPE_MEDIUM = 3;
    public static final int KINGKONG_TYPE_SMALL = 4;
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final LiveData<Map<Integer, List<fe.mmm.qw.xxx.p032if.fe.ad>>> f7018ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final MutableLiveData<List<Object>> f7019de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final LiveData<List<Object>> f7020fe;
    @NotNull
    public final MutableLiveData<Map<Integer, List<fe.mmm.qw.xxx.p032if.fe.ad>>> qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public Map<Integer, List<fe.mmm.qw.xxx.p032if.fe.ad>> f7021rg = new LinkedHashMap();
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public List<ScanRecord> f7022th = new ArrayList();

    public static final class ad extends TypeToken<Map<Integer, List<? extends fe.mmm.qw.xxx.p032if.fe.ad>>> {
    }

    public static final class de extends ContentObserver {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f7023ad;
        public final /* synthetic */ ScanHomeFragmentViewModel qw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public de(ScanHomeFragmentViewModel scanHomeFragmentViewModel, Context context, Handler handler) {
            super(handler);
            this.qw = scanHomeFragmentViewModel;
            this.f7023ad = context;
        }

        public void onChange(boolean z, @Nullable Uri uri) {
            this.qw.loadScanRecords(this.f7023ad);
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ScanHomeFragmentViewModel() {
        MutableLiveData<Map<Integer, List<fe.mmm.qw.xxx.p032if.fe.ad>>> mutableLiveData = new MutableLiveData<>();
        this.qw = mutableLiveData;
        this.f7018ad = mutableLiveData;
        MutableLiveData<List<Object>> mutableLiveData2 = new MutableLiveData<>();
        this.f7019de = mutableLiveData2;
        this.f7020fe = mutableLiveData2;
    }

    public final Map<Integer, List<fe.mmm.qw.xxx.p032if.fe.ad>> ad(String str) {
        Object fromJson = new Gson().fromJson(str, new ad().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(jsonString…iceAreaItem>>>() {}.type)");
        return (Map) fromJson;
    }

    @NotNull
    public final LiveData<Map<Integer, List<fe.mmm.qw.xxx.p032if.fe.ad>>> getKingkongTypeLiveData$app_main_aiscanConfigRelease() {
        return this.f7018ad;
    }

    @NotNull
    public final LiveData<List<Object>> getScanRecentRecordsLiveData$app_main_aiscanConfigRelease() {
        return this.f7020fe;
    }

    public final void loadScanHomeKingkongData(@NotNull LifecycleOwner lifecycleOwner, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f7021rg.isEmpty()) {
            Map<Integer, List<fe.mmm.qw.xxx.p032if.fe.ad>> qw2 = qw(context);
            this.f7021rg = qw2;
            rg.yj(this.qw, qw2);
        }
    }

    public final void loadScanRecords(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), u.ad(), (CoroutineStart) null, new ScanHomeFragmentViewModel$loadScanRecords$1(context, this, (Continuation<? super ScanHomeFragmentViewModel$loadScanRecords$1>) null), 2, (Object) null);
    }

    public final void observerScanRecordDataChange(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        new de(this, context, new Handler(Looper.getMainLooper()));
    }

    public final Map<Integer, List<fe.mmm.qw.xxx.p032if.fe.ad>> qw(Context context) {
        AssetManager assets = context.getAssets();
        String qw2 = pf.qw(assets != null ? assets.open("scan_kingkong_tool.json") : null);
        Intrinsics.checkNotNullExpressionValue(qw2, "streamToString(context.a…en(SCAN_KINGKONG_CONFIG))");
        return ad(qw2);
    }

    public final void updateScanRecordOpenTime(@NotNull Activity activity, @NotNull LifecycleOwner lifecycleOwner, long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(str, "recordId");
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), u.ad(), (CoroutineStart) null, new ScanHomeFragmentViewModel$updateScanRecordOpenTime$1((Continuation<? super ScanHomeFragmentViewModel$updateScanRecordOpenTime$1>) null), 2, (Object) null);
    }
}
