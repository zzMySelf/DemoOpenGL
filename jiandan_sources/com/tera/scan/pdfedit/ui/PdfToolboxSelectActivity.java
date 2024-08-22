package com.tera.scan.pdfedit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.filetype.FileType;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.pdfedit.adapter.PdfMergeAddAdapter;
import com.tera.scan.pdfedit.data.AddPdfItemData;
import com.tera.scan.pdfedit.viewmodel.PdfToolboxSelectViewModel;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.ui.view.widget.UIButton;
import fe.mmm.qw.qqq.uk.Cswitch;
import fe.mmm.qw.qqq.uk.b;
import fe.mmm.qw.qqq.uk.de;
import fe.mmm.qw.qqq.uk.h;
import fe.mmm.qw.qqq.uk.pf;
import fe.mmm.qw.qqq.uk.uk;
import fe.mmm.qw.th.qw.th.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 92\u00020\u0001:\u00019B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020\u000bH\u0014J\b\u0010'\u001a\u00020(H\u0002J\r\u0010)\u001a\u00020(H\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020(H\u0014J\"\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0012\u00101\u001a\u00020(2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\u0010\u00104\u001a\u00020(2\u0006\u00105\u001a\u00020\u000bH\u0002J\r\u00106\u001a\u00020(H\u0000¢\u0006\u0002\b7J\b\u00108\u001a\u00020(H\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8@X\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8@X\u0002¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\u001fR#\u0010!\u001a\n \u0005*\u0004\u0018\u00010\"0\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\t\u001a\u0004\b#\u0010$¨\u0006:"}, d2 = {"Lcom/tera/scan/pdfedit/ui/PdfToolboxSelectActivity;", "Lcom/tera/scan/framework/BaseActivity;", "()V", "btnLeftBack", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getBtnLeftBack", "()Landroid/widget/ImageView;", "btnLeftBack$delegate", "Lkotlin/Lazy;", "fileDisplayTimes", "", "isMerge", "", "isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease", "()Z", "isMerge$delegate", "loadingDialogHelper", "Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "getLoadingDialogHelper", "()Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "loadingDialogHelper$delegate", "pdfMerge", "pdfMergeAddAdapter", "Lcom/tera/scan/pdfedit/adapter/PdfMergeAddAdapter;", "getPdfMergeAddAdapter", "()Lcom/tera/scan/pdfedit/adapter/PdfMergeAddAdapter;", "pdfMergeAddAdapter$delegate", "selectViewModel", "Lcom/tera/scan/pdfedit/viewmodel/PdfToolboxSelectViewModel;", "getSelectViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease", "()Lcom/tera/scan/pdfedit/viewmodel/PdfToolboxSelectViewModel;", "selectViewModel$delegate", "tvTitleText", "Landroid/widget/TextView;", "getTvTitleText", "()Landroid/widget/TextView;", "tvTitleText$delegate", "getLayoutId", "hideLoading", "", "initData", "initData$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "position", "onMyDeviceItemClick", "onMyDeviceItemClick$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease", "showLoading", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Route(path = "/pdf_edit/native/PdfToolboxSelectActivity")
public final class PdfToolboxSelectActivity extends BaseActivity {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_IS_MERGE = "extra_is_merge";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy btnLeftBack$delegate = LazyKt__LazyJVMKt.lazy(new PdfToolboxSelectActivity$btnLeftBack$2(this));
    public int fileDisplayTimes = 1;
    @NotNull
    public final Lazy isMerge$delegate = LazyKt__LazyJVMKt.lazy(new PdfToolboxSelectActivity$isMerge$2(this));
    @NotNull
    public final Lazy loadingDialogHelper$delegate = LazyKt__LazyJVMKt.lazy(new PdfToolboxSelectActivity$loadingDialogHelper$2(this));
    @Autowired(name = "pdfMerge")
    @JvmField
    public boolean pdfMerge;
    @NotNull
    public final Lazy pdfMergeAddAdapter$delegate = LazyKt__LazyJVMKt.lazy(PdfToolboxSelectActivity$pdfMergeAddAdapter$2.INSTANCE);
    @NotNull
    public final Lazy selectViewModel$delegate = LazyKt__LazyJVMKt.lazy(new PdfToolboxSelectActivity$selectViewModel$2(this));
    @NotNull
    public final Lazy tvTitleText$delegate = LazyKt__LazyJVMKt.lazy(new PdfToolboxSelectActivity$tvTitleText$2(this));

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

    private final PdfMergeAddAdapter getPdfMergeAddAdapter() {
        return (PdfMergeAddAdapter) this.pdfMergeAddAdapter$delegate.getValue();
    }

    private final TextView getTvTitleText() {
        return (TextView) this.tvTitleText$delegate.getValue();
    }

    private final void hideLoading() {
        getLoadingDialogHelper().fe();
    }

    /* renamed from: initData$lambda-5  reason: not valid java name */
    public static final void m873initData$lambda5(PdfToolboxSelectActivity pdfToolboxSelectActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pdfToolboxSelectActivity, "this$0");
        if (bool != null) {
            bool.booleanValue();
            if (bool.booleanValue()) {
                pdfToolboxSelectActivity.showLoading();
            } else {
                pdfToolboxSelectActivity.hideLoading();
            }
        }
    }

    /* renamed from: initData$lambda-7  reason: not valid java name */
    public static final void m874initData$lambda7(PdfToolboxSelectActivity pdfToolboxSelectActivity, ArrayList arrayList) {
        int i2;
        Intrinsics.checkNotNullParameter(pdfToolboxSelectActivity, "this$0");
        if (arrayList != null) {
            boolean z = true;
            if (pdfToolboxSelectActivity.fileDisplayTimes == 1 && (!arrayList.isEmpty())) {
                pdfToolboxSelectActivity.fileDisplayTimes++;
                fe.mmm.qw.qqq.yj.qw.fe(pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgFiles" : "PDFExFiles", pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgPg" : "PDFExPg", (String) null, (Map) null, 12, (Object) null);
            }
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    if (((AddPdfItemData) it.next()).isSelected() && (i2 = i2 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            } else {
                i2 = 0;
            }
            UIButton uIButton = (UIButton) pdfToolboxSelectActivity._$_findCachedViewById(R.id.btn_pdf_select_confirm_select);
            if (i2 <= 1) {
                z = false;
            }
            uIButton.setEnabled(z);
            pdfToolboxSelectActivity.getPdfMergeAddAdapter().updateData(arrayList);
            PDFMergeKt.ppp(pdfToolboxSelectActivity, arrayList.isEmpty());
        }
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m875initView$lambda0(PdfToolboxSelectActivity pdfToolboxSelectActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfToolboxSelectActivity, "this$0");
        pdfToolboxSelectActivity.finish();
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m876initView$lambda1(PdfToolboxSelectActivity pdfToolboxSelectActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfToolboxSelectActivity, "this$0");
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_choose_files_cancel_click", (List) null, 2, (Object) null);
        pdfToolboxSelectActivity.finish();
    }

    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m877initView$lambda2(PdfToolboxSelectActivity pdfToolboxSelectActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfToolboxSelectActivity, "this$0");
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_choose_files_merge_click", (List) null, 2, (Object) null);
        fe.mmm.qw.qqq.yj.qw.ad(pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrg_clk" : "PDFEx_clk", pdfToolboxSelectActivity.isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgPg" : "PDFExPg", (String) null, (Map) null, 12, (Object) null);
        PdfMergeAdjustFileActivity.Companion.qw(pdfToolboxSelectActivity, pdfToolboxSelectActivity.getSelectViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().getSelectPdfItems());
    }

    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m878initView$lambda3(PdfToolboxSelectActivity pdfToolboxSelectActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfToolboxSelectActivity, "this$0");
        PDFMergeKt.pf(pdfToolboxSelectActivity);
    }

    /* access modifiers changed from: private */
    public final void onItemClick(int i2) {
        AddPdfItemData addPdfItemData;
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "files_page_open_files_click", (List) null, 2, (Object) null);
        ArrayList value = getSelectViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().getPdfListLiveData().getValue();
        if (!(value == null || (addPdfItemData = (AddPdfItemData) CollectionsKt___CollectionsKt.getOrNull(value, i2)) == null || addPdfItemData.isSelected())) {
            fe.mmm.qw.qqq.yj.qw.ad(isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgFiles_clk" : "PDFExFiles_clk", isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgPg" : "PDFExPg", (String) null, (Map) null, 12, (Object) null);
        }
        if (isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease()) {
            getSelectViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().toggleSelectPdfItem(i2);
        } else {
            PdfSplitActivity.Companion.qw(this, getSelectViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().getSelectPdfItem(i2));
        }
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
        return R.layout.activity_pdf_toolbox_select;
    }

    @NotNull
    public final PdfToolboxSelectViewModel getSelectViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() {
        return (PdfToolboxSelectViewModel) this.selectViewModel$delegate.getValue();
    }

    public final void initData$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() {
        getSelectViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().initPdfList();
        getSelectViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().getLoadingLiveData().observe(this, new uk(this));
        getSelectViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().getPdfListLiveData().observe(this, new b(this));
    }

    public void initView() {
        fe.mmm.qw.ggg.qw.qw.qw("scan_choose_files_show", CollectionsKt__CollectionsJVMKt.listOf(isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "merge" : "extract"));
        View findViewById = findViewById(R.id.layout_title_bar_pdf_select);
        if (findViewById != null) {
            findViewById.setBackgroundColor(getResources().getColor(R.color.white));
        }
        getTvTitleText().setText(isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? R.string.pdf_merging_title : R.string.pdf_split_title);
        getBtnLeftBack().setOnClickListener(new h(this));
        ((UIButton) _$_findCachedViewById(R.id.btn_pdf_select_cancel_select)).setOnClickListener(new de(this));
        ((UIButton) _$_findCachedViewById(R.id.btn_pdf_select_confirm_select)).setOnClickListener(new pf(this));
        _$_findCachedViewById(R.id.pdf_load).setOnClickListener(new Cswitch(this));
        ((RecyclerView) _$_findCachedViewById(R.id.rv_pdf_select_list)).setAdapter(getPdfMergeAddAdapter());
        ((RecyclerView) _$_findCachedViewById(R.id.rv_pdf_select_list)).setLayoutManager(new LinearLayoutManager(this));
        getPdfMergeAddAdapter().setOnItemClick(new PdfToolboxSelectActivity$initView$5(this));
        if (!isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease()) {
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.ll_pdf_select_bottom_btn);
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "ll_pdf_select_bottom_btn");
            fe.mmm.qw.th.qw.rg.fe.de.qw.qw(constraintLayout);
        }
        PDFMergeKt.th(this);
        fe.mmm.qw.qqq.yj.qw.fe(isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgPg" : "PDFExPg", isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgPg" : "PDFExPg", (String) null, (Map) null, 12, (Object) null);
    }

    public final boolean isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() {
        return ((Boolean) this.isMerge$delegate.getValue()).booleanValue();
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1111 && i3 == -1) {
            ArrayList parcelableArrayListExtra = intent != null ? intent.getParcelableArrayListExtra("extra_file_list") : null;
            boolean z = true;
            LoggerKt.d$default("fileList=" + parcelableArrayListExtra, (Object) null, 1, (Object) null);
            if (parcelableArrayListExtra != null && (parcelableArrayListExtra.isEmpty() ^ true)) {
                fe.mmm.qw.qqq.yj.qw.fe(isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgImSuc" : "PDFExImSuc", isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgPg" : "PDFExPg", (String) null, (Map) null, 12, (Object) null);
            }
            if (isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease()) {
                getSelectViewModel$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease().addPdfItems(parcelableArrayListExtra);
                return;
            }
            if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
                z = false;
            }
            if (!z) {
                PdfSplitActivity.Companion.qw(this, (ScanRecordExportFile) parcelableArrayListExtra.get(0));
                finish();
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        fe.ad.qw.qw.ad.qw.de().rg(this);
        super.onCreate(bundle);
        PDFMergeKt.ad(this);
    }

    public final void onMyDeviceItemClick$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() {
        Class<?> cls = null;
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_choose_files_device_click", (List) null, 2, (Object) null);
        Postcard qw2 = fe.ad.qw.qw.ad.qw.de().qw("/files/import/activity");
        fe.ad.qw.qw.qw.de.de(qw2);
        if (qw2 != null) {
            cls = qw2.getDestination();
        }
        Intent intent = new Intent(this, cls);
        intent.putExtra("file_type", FileType.PDF.name());
        intent.putExtra("files_import_import_files_during_operation_extra", true);
        if (!isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease()) {
            intent.putExtra("req_max_file_count", 1);
        }
        startActivityForResult(intent, 1111);
        fe.mmm.qw.qqq.yj.qw.fe(isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgImpg" : "PDFExImpg", isMerge$BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease() ? "PDFMrgPg" : "PDFExPg", (String) null, (Map) null, 12, (Object) null);
    }
}
