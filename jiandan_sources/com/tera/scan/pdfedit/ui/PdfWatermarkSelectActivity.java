package com.tera.scan.pdfedit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.filetype.FileType;
import com.tera.scan.flutter.component.provider.FlutterYouthProvider;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.pdfedit.adapter.PdfWatermarkSelectAdapter;
import com.tera.scan.pdfedit.viewmodel.PdfWatermarkSelectViewModel;
import fe.ad.qw.qw.qw.de;
import fe.mmm.qw.qqq.uk.Cif;
import fe.mmm.qw.qqq.uk.g;
import fe.mmm.qw.qqq.uk.rrr;
import fe.mmm.qw.qqq.uk.th;
import fe.mmm.qw.th.qw.th.i;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0014J\"\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020$2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020&H\u0016J\u0012\u0010/\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u0012\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u000104H\u0002J\b\u00105\u001a\u00020&H\u0002J\b\u00106\u001a\u00020&H\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0014\u001a\n \u0005*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0019\u001a\n \u0005*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b \u0010!¨\u00068"}, d2 = {"Lcom/tera/scan/pdfedit/ui/PdfWatermarkSelectActivity;", "Lcom/tera/scan/framework/BaseActivity;", "()V", "btnLeftBack", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getBtnLeftBack", "()Landroid/widget/ImageView;", "btnLeftBack$delegate", "Lkotlin/Lazy;", "loadingDialogHelper", "Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "getLoadingDialogHelper", "()Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "loadingDialogHelper$delegate", "pdfWatermarkAdapter", "Lcom/tera/scan/pdfedit/adapter/PdfWatermarkSelectAdapter;", "getPdfWatermarkAdapter", "()Lcom/tera/scan/pdfedit/adapter/PdfWatermarkSelectAdapter;", "pdfWatermarkAdapter$delegate", "recyclerViewWatermark", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewWatermark", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewWatermark$delegate", "tvTitleText", "Landroid/widget/TextView;", "getTvTitleText", "()Landroid/widget/TextView;", "tvTitleText$delegate", "watermarkViewModel", "Lcom/tera/scan/pdfedit/viewmodel/PdfWatermarkSelectViewModel;", "getWatermarkViewModel", "()Lcom/tera/scan/pdfedit/viewmodel/PdfWatermarkSelectViewModel;", "watermarkViewModel$delegate", "getLayoutId", "", "hideLoading", "", "initData", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "localPath", "", "onMyDeviceItemClick", "showLoading", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfWatermarkSelectActivity extends BaseActivity {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    public static final int REQUEST_CODE_IMPORT_PDF = 1111;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy btnLeftBack$delegate = LazyKt__LazyJVMKt.lazy(new PdfWatermarkSelectActivity$btnLeftBack$2(this));
    @NotNull
    public final Lazy loadingDialogHelper$delegate = LazyKt__LazyJVMKt.lazy(new PdfWatermarkSelectActivity$loadingDialogHelper$2(this));
    @NotNull
    public final Lazy pdfWatermarkAdapter$delegate = LazyKt__LazyJVMKt.lazy(PdfWatermarkSelectActivity$pdfWatermarkAdapter$2.INSTANCE);
    @NotNull
    public final Lazy recyclerViewWatermark$delegate = LazyKt__LazyJVMKt.lazy(new PdfWatermarkSelectActivity$recyclerViewWatermark$2(this));
    @NotNull
    public final Lazy tvTitleText$delegate = LazyKt__LazyJVMKt.lazy(new PdfWatermarkSelectActivity$tvTitleText$2(this));
    @NotNull
    public final Lazy watermarkViewModel$delegate = LazyKt__LazyJVMKt.lazy(new PdfWatermarkSelectActivity$watermarkViewModel$2(this));

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final ImageView getBtnLeftBack() {
        return (ImageView) this.btnLeftBack$delegate.getValue();
    }

    private final i getLoadingDialogHelper() {
        return (i) this.loadingDialogHelper$delegate.getValue();
    }

    private final PdfWatermarkSelectAdapter getPdfWatermarkAdapter() {
        return (PdfWatermarkSelectAdapter) this.pdfWatermarkAdapter$delegate.getValue();
    }

    private final RecyclerView getRecyclerViewWatermark() {
        return (RecyclerView) this.recyclerViewWatermark$delegate.getValue();
    }

    private final TextView getTvTitleText() {
        return (TextView) this.tvTitleText$delegate.getValue();
    }

    private final PdfWatermarkSelectViewModel getWatermarkViewModel() {
        return (PdfWatermarkSelectViewModel) this.watermarkViewModel$delegate.getValue();
    }

    private final void hideLoading() {
        getLoadingDialogHelper().fe();
    }

    private final void initData() {
        getWatermarkViewModel().initPdfList();
        getWatermarkViewModel().getLoadingLiveData().observe(this, new rrr(this));
        getWatermarkViewModel().getPdfListLiveData().observe(this, new g(this));
        getWatermarkViewModel().getConvertPdfToLocalImageResultLiveData().observe(this, new th(this));
    }

    /* renamed from: initData$lambda-1  reason: not valid java name */
    public static final void m881initData$lambda1(PdfWatermarkSelectActivity pdfWatermarkSelectActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pdfWatermarkSelectActivity, "this$0");
        if (bool != null) {
            bool.booleanValue();
            if (bool.booleanValue()) {
                pdfWatermarkSelectActivity.showLoading();
            } else {
                pdfWatermarkSelectActivity.hideLoading();
            }
        }
    }

    /* renamed from: initData$lambda-2  reason: not valid java name */
    public static final void m882initData$lambda2(PdfWatermarkSelectActivity pdfWatermarkSelectActivity, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(pdfWatermarkSelectActivity, "this$0");
        if (arrayList != null) {
            pdfWatermarkSelectActivity.getPdfWatermarkAdapter().updateData(arrayList);
        }
    }

    /* renamed from: initData$lambda-3  reason: not valid java name */
    public static final void m883initData$lambda3(PdfWatermarkSelectActivity pdfWatermarkSelectActivity, Pair pair) {
        Intrinsics.checkNotNullParameter(pdfWatermarkSelectActivity, "this$0");
        String str = (String) pair.getFirst();
        FlutterYouthProvider flutterYouthProvider = new FlutterYouthProvider();
        Object second = pair.getSecond();
        flutterYouthProvider.jumpToWatermarkEditPage(pdfWatermarkSelectActivity, str, second instanceof ArrayList ? (ArrayList) second : null, "tools");
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m884initView$lambda0(PdfWatermarkSelectActivity pdfWatermarkSelectActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfWatermarkSelectActivity, "this$0");
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "watermark_choose_return", (List) null, 2, (Object) null);
        pdfWatermarkSelectActivity.finish();
    }

    /* access modifiers changed from: private */
    public final void onItemClick(String str) {
        getWatermarkViewModel().getConvertPdfToLocalImages(this, str);
    }

    /* access modifiers changed from: private */
    public final void onMyDeviceItemClick() {
        Postcard qw2 = fe.ad.qw.qw.ad.qw.de().qw("/files/import/activity");
        de.de(qw2);
        Intent intent = new Intent(this, qw2 != null ? qw2.getDestination() : null);
        intent.putExtra("file_type", FileType.PDF.name());
        intent.putExtra("files_import_import_files_during_operation_extra", true);
        startActivityForResult(intent, 1111);
    }

    private final void showLoading() {
        getLoadingDialogHelper().rg(R.string.loading_text);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public int getLayoutId() {
        return R.layout.activity_pdf_watermark_select_layout;
    }

    public void initView() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "watermark_choose_return_display", (List) null, 2, (Object) null);
        View findViewById = findViewById(R.id.layout_title_bar_pdf_select);
        if (findViewById != null) {
            findViewById.setBackgroundColor(getResources().getColor(R.color.white));
        }
        getTvTitleText().setText(R.string.bottom_menu_pdf_watermark);
        getBtnLeftBack().setOnClickListener(new Cif(this));
        getRecyclerViewWatermark().setAdapter(getPdfWatermarkAdapter());
        getRecyclerViewWatermark().setLayoutManager(new LinearLayoutManager(this));
        getPdfWatermarkAdapter().setOnItemClick(new PdfWatermarkSelectActivity$initView$2(this));
        getPdfWatermarkAdapter().setOnMyDeviceClick(new PdfWatermarkSelectActivity$initView$3(this));
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1111 && i3 == -1) {
            ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra("extra_file_list") : null;
            LoggerKt.d$default("fileList=" + parcelableArrayListExtra, (Object) null, 1, (Object) null);
            getWatermarkViewModel().addPdfItems(parcelableArrayListExtra);
        }
    }

    public void onBackPressed() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "watermark_choose_return", (List) null, 2, (Object) null);
        super.onBackPressed();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }
}
