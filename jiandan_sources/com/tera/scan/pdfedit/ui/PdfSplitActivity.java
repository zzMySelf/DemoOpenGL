package com.tera.scan.pdfedit.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.aiscan.R;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.pdfedit.adapter.PdfListSplitAdapter;
import com.tera.scan.pdfedit.viewmodel.PdfSplitViewModel;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.ui.view.widget.UIButton;
import fe.mmm.qw.qqq.o.rg;
import fe.mmm.qw.qqq.rg.ad;
import fe.mmm.qw.qqq.uk.c;
import fe.mmm.qw.qqq.uk.d;
import fe.mmm.qw.qqq.uk.l;
import fe.mmm.qw.qqq.uk.mmm;
import fe.mmm.qw.qqq.uk.tt;
import fe.mmm.qw.qqq.uk.xxx;
import fe.mmm.qw.th.qw.th.i;
import fe.mmm.qw.th.qw.th.o;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0014J\u0012\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\u0010\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020!H\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178@X\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u001b\u001a\n \u0005*\u0004\u0018\u00010\u001c0\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/tera/scan/pdfedit/ui/PdfSplitActivity;", "Lcom/tera/scan/framework/BaseActivity;", "()V", "btnLeftBack", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getBtnLeftBack", "()Landroid/widget/ImageView;", "btnLeftBack$delegate", "Lkotlin/Lazy;", "loadingDialogHelper", "Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "getLoadingDialogHelper", "()Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "loadingDialogHelper$delegate", "pageListAdapter", "Lcom/tera/scan/pdfedit/adapter/PdfListSplitAdapter;", "getPageListAdapter", "()Lcom/tera/scan/pdfedit/adapter/PdfListSplitAdapter;", "pageListAdapter$delegate", "recordFile", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "splitViewModel", "Lcom/tera/scan/pdfedit/viewmodel/PdfSplitViewModel;", "getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease", "()Lcom/tera/scan/pdfedit/viewmodel/PdfSplitViewModel;", "splitViewModel$delegate", "tvTitleText", "Landroid/widget/TextView;", "getTvTitleText", "()Landroid/widget/TextView;", "tvTitleText$delegate", "getLayoutId", "", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelect", "index", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Route(path = "/pdf_edit/native/PdfSplitActivity")
public final class PdfSplitActivity extends BaseActivity {
    public static final int COLUMN_COUNT = 2;
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_SPLIT_PDF = "split_pdf_file";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy btnLeftBack$delegate = LazyKt__LazyJVMKt.lazy(new PdfSplitActivity$btnLeftBack$2(this));
    @NotNull
    public final Lazy loadingDialogHelper$delegate = LazyKt__LazyJVMKt.lazy(new PdfSplitActivity$loadingDialogHelper$2(this));
    @NotNull
    public final Lazy pageListAdapter$delegate = LazyKt__LazyJVMKt.lazy(PdfSplitActivity$pageListAdapter$2.INSTANCE);
    @Autowired(name = "recordFile")
    @Nullable
    @JvmField
    public ScanRecordExportFile recordFile;
    @NotNull
    public final Lazy splitViewModel$delegate = LazyKt__LazyJVMKt.lazy(new PdfSplitActivity$splitViewModel$2(this));
    @NotNull
    public final Lazy tvTitleText$delegate = LazyKt__LazyJVMKt.lazy(new PdfSplitActivity$tvTitleText$2(this));

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void qw(@NotNull Context context, @Nullable ScanRecordExportFile scanRecordExportFile) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, PdfSplitActivity.class);
            intent.putExtra(PdfSplitActivity.EXTRA_SPLIT_PDF, scanRecordExportFile);
            context.startActivity(intent);
        }
    }

    private final ImageView getBtnLeftBack() {
        return (ImageView) this.btnLeftBack$delegate.getValue();
    }

    private final i getLoadingDialogHelper() {
        return (i) this.loadingDialogHelper$delegate.getValue();
    }

    private final PdfListSplitAdapter getPageListAdapter() {
        return (PdfListSplitAdapter) this.pageListAdapter$delegate.getValue();
    }

    private final TextView getTvTitleText() {
        return (TextView) this.tvTitleText$delegate.getValue();
    }

    private final void initData() {
        ScanRecordExportFile scanRecordExportFile = (ScanRecordExportFile) getIntent().getParcelableExtra(EXTRA_SPLIT_PDF);
        if (scanRecordExportFile == null) {
            scanRecordExportFile = this.recordFile;
        }
        getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().startParsePdf(scanRecordExportFile, this);
        getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().getLoadingLiveData().observe(this, new tt(this));
        getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().getPdfPageDataLiveData().observe(this, new mmm(this));
        getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().getChangingItemLiveData().observe(this, new c(this));
        getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().getSelectedCountLiveData().observe(this, new fe.mmm.qw.qqq.uk.i(this));
        getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().getSplitPdfResultLiveData().observe(this, new l(this));
    }

    /* renamed from: initData$lambda-2  reason: not valid java name */
    public static final void m866initData$lambda2(PdfSplitActivity pdfSplitActivity, Pair pair) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "this$0");
        if (pair != null) {
            boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
            boolean booleanValue2 = ((Boolean) pair.component2()).booleanValue();
            if (!booleanValue) {
                pdfSplitActivity.getLoadingDialogHelper().fe();
            } else if (booleanValue2) {
                pdfSplitActivity.getLoadingDialogHelper().rg(R.string.loading_text);
            } else {
                pdfSplitActivity.getLoadingDialogHelper().yj(R.string.loading_text);
            }
        }
    }

    /* renamed from: initData$lambda-3  reason: not valid java name */
    public static final void m867initData$lambda3(PdfSplitActivity pdfSplitActivity, Pair pair) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "this$0");
        if (pair != null && ((Boolean) pair.getFirst()).booleanValue()) {
            pdfSplitActivity.getPageListAdapter().updateData((List) pair.getSecond());
        }
    }

    /* renamed from: initData$lambda-4  reason: not valid java name */
    public static final void m868initData$lambda4(PdfSplitActivity pdfSplitActivity, Pair pair) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "this$0");
        if (pair != null) {
            pdfSplitActivity.getPageListAdapter().updateItem(((Number) pair.getFirst()).intValue(), (ad) pair.getSecond());
        }
    }

    /* renamed from: initData$lambda-5  reason: not valid java name */
    public static final void m869initData$lambda5(PdfSplitActivity pdfSplitActivity, Integer num) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "this$0");
        if (num != null) {
            num.intValue();
            ((UIButton) pdfSplitActivity._$_findCachedViewById(R.id.btn_start_split_pdf)).setEnabled(num.intValue() > 0);
            PDFMergeKt.ggg(pdfSplitActivity, num.intValue());
        }
    }

    /* renamed from: initData$lambda-6  reason: not valid java name */
    public static final void m870initData$lambda6(PdfSplitActivity pdfSplitActivity, rg rgVar) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "this$0");
        if (rgVar != null) {
            if (rgVar instanceof rg.qw) {
                o.rg(((rg.qw) rgVar).qw());
            } else if (rgVar instanceof rg.ad) {
                PDFMergeKt.m849if(pdfSplitActivity);
                fe.mmm.qw.qqq.yj.qw.fe("PDFExSuc", "PDFExPg", (String) null, (Map) null, 12, (Object) null);
                rg.ad adVar = (rg.ad) rgVar;
                fe.mmm.qw.ggg.qw.qw.qw("single_split_new_files_document_pages_count", CollectionsKt__CollectionsJVMKt.listOf(String.valueOf(adVar.qw())));
                pdfSplitActivity.startActivity(DocumentViewerActivity.getStartIntent(pdfSplitActivity.getApplicationContext(), adVar.ad().getLocalPath(), adVar.ad(), DocumentViewerActivity.FROM_PDF_SPLIT, -1, 0, ""));
                pdfSplitActivity.finish();
            }
        }
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m871initView$lambda0(PdfSplitActivity pdfSplitActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "this$0");
        pdfSplitActivity.finish();
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m872initView$lambda1(PdfSplitActivity pdfSplitActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfSplitActivity, "this$0");
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_extract_page_extract_click", (List) null, 2, (Object) null);
        fe.mmm.qw.qqq.yj.qw.ad("PDFEx_Ex", "PDFExPg", (String) null, (Map) null, 12, (Object) null);
        pdfSplitActivity.getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().startSplitPdf();
    }

    /* access modifiers changed from: private */
    public final void onItemSelect(int i2) {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_extract_page_choose_click", (List) null, 2, (Object) null);
        fe.mmm.qw.qqq.yj.qw.ad("PDFExPgnum", "PDFExPg", (String) null, (Map) null, 12, (Object) null);
        getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().changeItemSelectState(i2);
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
        return R.layout.activity_pdf_split;
    }

    @NotNull
    public final PdfSplitViewModel getSplitViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() {
        return (PdfSplitViewModel) this.splitViewModel$delegate.getValue();
    }

    public void initView() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_extract_page_show", (List) null, 2, (Object) null);
        findViewById(R.id.layout_title_bar).setBackgroundColor(getResources().getColor(R.color.white));
        getTvTitleText().setText(R.string.pdf_split_page_title);
        getBtnLeftBack().setOnClickListener(new xxx(this));
        ((RecyclerView) _$_findCachedViewById(R.id.rv_split_pdf_list)).setAdapter(getPageListAdapter());
        ((RecyclerView) _$_findCachedViewById(R.id.rv_split_pdf_list)).setLayoutManager(new GridLayoutManager(this, 2));
        getPageListAdapter().setOnItemSelectListener(new PdfSplitActivity$initView$2(this));
        ((UIButton) _$_findCachedViewById(R.id.btn_start_split_pdf)).setOnClickListener(new d(this));
        PDFMergeKt.uk(this);
        fe.mmm.qw.qqq.yj.qw.fe("PDFExing", "PDFExPg", (String) null, (Map) null, 12, (Object) null);
    }

    public void onCreate(@Nullable Bundle bundle) {
        fe.ad.qw.qw.ad.qw.de().rg(this);
        super.onCreate(bundle);
        initData();
    }
}
