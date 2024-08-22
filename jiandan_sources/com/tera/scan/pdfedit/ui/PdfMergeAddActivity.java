package com.tera.scan.pdfedit.ui;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.IntentKt;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.pdfedit.adapter.PdfMergeAddAdapter;
import com.tera.scan.pdfedit.data.AddPdfItemData;
import com.tera.scan.pdfedit.viewmodel.PdfMergeAddViewModel;
import com.tera.scan.ui.view.widget.UIButton;
import fe.mmm.qw.ggg.qw;
import fe.mmm.qw.qqq.uk.ddd;
import fe.mmm.qw.qqq.uk.nn;
import fe.mmm.qw.qqq.uk.ppp;
import fe.mmm.qw.qqq.uk.qqq;
import fe.mmm.qw.qqq.uk.when;
import fe.mmm.qw.th.qw.th.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0014J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0014J\u0012\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020\u001fH\u0002R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0019\u001a\n \u0005*\u0004\u0018\u00010\u001a0\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lcom/tera/scan/pdfedit/ui/PdfMergeAddActivity;", "Lcom/tera/scan/framework/BaseActivity;", "()V", "btnLeftBack", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getBtnLeftBack", "()Landroid/widget/ImageView;", "btnLeftBack$delegate", "Lkotlin/Lazy;", "importViewModel", "Lcom/tera/scan/pdfedit/viewmodel/PdfMergeAddViewModel;", "getImportViewModel", "()Lcom/tera/scan/pdfedit/viewmodel/PdfMergeAddViewModel;", "importViewModel$delegate", "loadingDialogHelper", "Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "getLoadingDialogHelper", "()Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "loadingDialogHelper$delegate", "pdfMergeAddAdapter", "Lcom/tera/scan/pdfedit/adapter/PdfMergeAddAdapter;", "getPdfMergeAddAdapter", "()Lcom/tera/scan/pdfedit/adapter/PdfMergeAddAdapter;", "pdfMergeAddAdapter$delegate", "tvTitleText", "Landroid/widget/TextView;", "getTvTitleText", "()Landroid/widget/TextView;", "tvTitleText$delegate", "cancelAdd", "", "getLayoutId", "", "hideLoading", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "position", "showLoading", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfMergeAddActivity extends BaseActivity {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy btnLeftBack$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergeAddActivity$btnLeftBack$2(this));
    @NotNull
    public final Lazy importViewModel$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergeAddActivity$importViewModel$2(this));
    @NotNull
    public final Lazy loadingDialogHelper$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergeAddActivity$loadingDialogHelper$2(this));
    @NotNull
    public final Lazy pdfMergeAddAdapter$delegate = LazyKt__LazyJVMKt.lazy(PdfMergeAddActivity$pdfMergeAddAdapter$2.INSTANCE);
    @NotNull
    public final Lazy tvTitleText$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergeAddActivity$tvTitleText$2(this));

    private final void cancelAdd() {
        setResult(0);
        finish();
    }

    private final ImageView getBtnLeftBack() {
        return (ImageView) this.btnLeftBack$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PdfMergeAddViewModel getImportViewModel() {
        return (PdfMergeAddViewModel) this.importViewModel$delegate.getValue();
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

    private final void initData() {
        getImportViewModel().initPdfList();
        getImportViewModel().getLoadingLiveData().observe(this, new ppp(this));
        getImportViewModel().getPdfListLiveData().observe(this, new ddd(this));
    }

    /* renamed from: initData$lambda-3  reason: not valid java name */
    public static final void m851initData$lambda3(PdfMergeAddActivity pdfMergeAddActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pdfMergeAddActivity, "this$0");
        if (bool != null) {
            bool.booleanValue();
            if (bool.booleanValue()) {
                pdfMergeAddActivity.showLoading();
            } else {
                pdfMergeAddActivity.hideLoading();
            }
        }
    }

    /* renamed from: initData$lambda-5  reason: not valid java name */
    public static final void m852initData$lambda5(PdfMergeAddActivity pdfMergeAddActivity, List list) {
        int i2;
        Intrinsics.checkNotNullParameter(pdfMergeAddActivity, "this$0");
        if (list != null) {
            boolean z = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    if (((AddPdfItemData) it.next()).isSelected() && (i2 = i2 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            } else {
                i2 = 0;
            }
            UIButton uIButton = (UIButton) pdfMergeAddActivity._$_findCachedViewById(R.id.btn_confirm_import);
            if (i2 > 0) {
                z = true;
            }
            uIButton.setEnabled(z);
            pdfMergeAddActivity.getPdfMergeAddAdapter().updateData(list);
        }
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m853initView$lambda0(PdfMergeAddActivity pdfMergeAddActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfMergeAddActivity, "this$0");
        pdfMergeAddActivity.cancelAdd();
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m854initView$lambda1(PdfMergeAddActivity pdfMergeAddActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfMergeAddActivity, "this$0");
        pdfMergeAddActivity.cancelAdd();
    }

    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m855initView$lambda2(PdfMergeAddActivity pdfMergeAddActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfMergeAddActivity, "this$0");
        pdfMergeAddActivity.setResult(-1, IntentKt.Intent(new PdfMergeAddActivity$initView$3$1(pdfMergeAddActivity)));
        pdfMergeAddActivity.finish();
    }

    /* access modifiers changed from: private */
    public final void onItemClick(int i2) {
        ScanAnalyticsBaseEvent.qw.qw(qw.qw, "files_page_open_files_click", (List) null, 2, (Object) null);
        getImportViewModel().toggleSelectPdfItem(i2);
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
        return R.layout.activity_pdf_merge_add;
    }

    public void initView() {
        ScanAnalyticsBaseEvent.qw.qw(qw.qw, "scan_change_order_add_pdf_page_show", (List) null, 2, (Object) null);
        findViewById(R.id.layout_title_bar).setBackgroundColor(getResources().getColor(R.color.white));
        getTvTitleText().setText(R.string.add_document);
        getBtnLeftBack().setImageResource(R.drawable.close_dialog);
        getBtnLeftBack().setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
        getBtnLeftBack().setOnClickListener(new nn(this));
        ((UIButton) _$_findCachedViewById(R.id.btn_cancel_import)).setOnClickListener(new qqq(this));
        ((UIButton) _$_findCachedViewById(R.id.btn_confirm_import)).setOnClickListener(new when(this));
        ((RecyclerView) _$_findCachedViewById(R.id.rv_pdf_merge_add_pdf_list)).setAdapter(getPdfMergeAddAdapter());
        ((RecyclerView) _$_findCachedViewById(R.id.rv_pdf_merge_add_pdf_list)).setLayoutManager(new LinearLayoutManager(this));
        getPdfMergeAddAdapter().setOnItemClick(new PdfMergeAddActivity$initView$4(this));
        PDFMergeKt.de(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }
}
