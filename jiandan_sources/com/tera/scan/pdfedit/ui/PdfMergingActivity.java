package com.tera.scan.pdfedit.ui;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.aiscan.R;
import com.tera.scan.component.base.ui.manager.DialogCtrListener;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.pdfedit.viewmodel.PdfMergingViewModel;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.ui.view.widget.UIButton;
import fe.mmm.qw.qqq.o.fe;
import fe.mmm.qw.qqq.uk.a;
import fe.mmm.qw.qqq.uk.aaa;
import fe.mmm.qw.qqq.uk.ggg;
import fe.mmm.qw.qqq.uk.yj;
import fe.mmm.qw.th.qw.rg.de.fe;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0003J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0012\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR#\u0010\u000f\u001a\n \u0005*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/tera/scan/pdfedit/ui/PdfMergingActivity;", "Lcom/tera/scan/framework/BaseActivity;", "()V", "btnLeftBack", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getBtnLeftBack", "()Landroid/widget/ImageView;", "btnLeftBack$delegate", "Lkotlin/Lazy;", "mergingViewModel", "Lcom/tera/scan/pdfedit/viewmodel/PdfMergingViewModel;", "getMergingViewModel", "()Lcom/tera/scan/pdfedit/viewmodel/PdfMergingViewModel;", "mergingViewModel$delegate", "tvTitleText", "Landroid/widget/TextView;", "getTvTitleText", "()Landroid/widget/TextView;", "tvTitleText$delegate", "cancelMerge", "", "getLayoutId", "", "initData", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfMergingActivity extends BaseActivity {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_FILE_NAME = "extra_file_name";
    @NotNull
    public static final String EXTRA_MERGE_PDF_LIST = "merge_pdf_list";
    @NotNull
    public static final String EXTRA_REPLACE_OLD_DOC_FILE = "replace_old_doc_file";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy btnLeftBack$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergingActivity$btnLeftBack$2(this));
    @NotNull
    public final Lazy mergingViewModel$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergingActivity$mergingViewModel$2(this));
    @NotNull
    public final Lazy tvTitleText$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergingActivity$tvTitleText$2(this));

    public static final class ad implements DialogCtrListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ PdfMergingActivity f7085ad;
        public final /* synthetic */ Dialog qw;

        public ad(Dialog dialog, PdfMergingActivity pdfMergingActivity) {
            this.qw = dialog;
            this.f7085ad = pdfMergingActivity;
        }

        public void ad() {
            this.f7085ad.finish();
        }

        public void qw() {
            this.qw.cancel();
        }
    }

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void qw(@NotNull Context context, @Nullable ArrayList<ScanRecordExportFile> arrayList, boolean z, @NotNull String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "fileName");
            Intent intent = new Intent(context, PdfMergingActivity.class);
            intent.putExtra("merge_pdf_list", arrayList);
            intent.putExtra(PdfMergingActivity.EXTRA_REPLACE_OLD_DOC_FILE, z);
            intent.putExtra(PdfMergingActivity.EXTRA_FILE_NAME, str);
            context.startActivity(intent);
        }
    }

    private final void cancelMerge() {
        fe feVar = new fe();
        Dialog uk2 = feVar.uk(this, R.string.cancel_merge_pdf_title, R.string.cancel_merge_pdf_desc, R.string.continue_to_merge_pdf, R.string.cancel_merge_pdf);
        feVar.de(new ad(uk2, this));
        uk2.show();
    }

    private final ImageView getBtnLeftBack() {
        return (ImageView) this.btnLeftBack$delegate.getValue();
    }

    private final PdfMergingViewModel getMergingViewModel() {
        return (PdfMergingViewModel) this.mergingViewModel$delegate.getValue();
    }

    private final TextView getTvTitleText() {
        return (TextView) this.tvTitleText$delegate.getValue();
    }

    @SuppressLint({"SetTextI18n"})
    private final void initData() {
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("merge_pdf_list");
        int i2 = 0;
        boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_REPLACE_OLD_DOC_FILE, false);
        String stringExtra = getIntent().getStringExtra(EXTRA_FILE_NAME);
        if (stringExtra == null) {
            stringExtra = "";
        }
        fe.mmm.qw.ggg.qw qwVar = fe.mmm.qw.ggg.qw.qw;
        if (parcelableArrayListExtra != null) {
            i2 = parcelableArrayListExtra.size();
        }
        qwVar.qw("merge_choose_files_count", CollectionsKt__CollectionsJVMKt.listOf(String.valueOf(i2)));
        getMergingViewModel().startMergePdfList(parcelableArrayListExtra, booleanExtra, stringExtra, this);
        getMergingViewModel().getMergeProgressLiveData().observe(this, new ggg(this));
        getMergingViewModel().getMergePdfResultLiveData().observe(this, new fe.mmm.qw.qqq.uk.fe(this));
        ((TextView) _$_findCachedViewById(R.id.tv_merge_pdf_file_estimate_size)).setText(getMergingViewModel().getEstimatedFileSizeDesc(parcelableArrayListExtra));
        ((TextView) _$_findCachedViewById(R.id.tv_merge_pdf_file_name)).setText(stringExtra + ".pdf");
    }

    /* renamed from: initData$lambda-2  reason: not valid java name */
    public static final void m861initData$lambda2(PdfMergingActivity pdfMergingActivity, Integer num) {
        Intrinsics.checkNotNullParameter(pdfMergingActivity, "this$0");
        if (num != null) {
            num.intValue();
            ((TextView) pdfMergingActivity._$_findCachedViewById(R.id.tv_merge_pdf_progress)).setText(pdfMergingActivity.getResources().getString(R.string.pdf_merging_progress, new Object[]{String.valueOf(num)}));
            ((ProgressBar) pdfMergingActivity._$_findCachedViewById(R.id.pb_pdf_merge_progress)).setProgress(num.intValue());
        }
    }

    /* renamed from: initData$lambda-4  reason: not valid java name */
    public static final void m862initData$lambda4(PdfMergingActivity pdfMergingActivity, fe.mmm.qw.qqq.o.fe feVar) {
        Intrinsics.checkNotNullParameter(pdfMergingActivity, "this$0");
        if (feVar != null) {
            if (feVar instanceof fe.qw) {
                ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_merge_failure_show", (List) null, 2, (Object) null);
                ((TextView) pdfMergingActivity._$_findCachedViewById(R.id.tv_merge_pdf_fail_desc)).setText(pdfMergingActivity.getResources().getString(((fe.qw) feVar).qw()));
                TextView textView = (TextView) pdfMergingActivity._$_findCachedViewById(R.id.tv_merge_pdf_fail_desc);
                Intrinsics.checkNotNullExpressionValue(textView, "tv_merge_pdf_fail_desc");
                fe.mmm.qw.th.qw.rg.fe.de.qw.fe(textView);
                ProgressBar progressBar = (ProgressBar) pdfMergingActivity._$_findCachedViewById(R.id.pb_pdf_merge_progress);
                Intrinsics.checkNotNullExpressionValue(progressBar, "pb_pdf_merge_progress");
                fe.mmm.qw.th.qw.rg.fe.de.qw.qw(progressBar);
                TextView textView2 = (TextView) pdfMergingActivity._$_findCachedViewById(R.id.tv_merge_pdf_progress);
                Intrinsics.checkNotNullExpressionValue(textView2, "tv_merge_pdf_progress");
                fe.mmm.qw.th.qw.rg.fe.de.qw.qw(textView2);
                ((UIButton) pdfMergingActivity._$_findCachedViewById(R.id.btn_cancel_merge_pdf)).setText(pdfMergingActivity.getResources().getString(R.string.pdf_merge_retry_btn));
                ((UIButton) pdfMergingActivity._$_findCachedViewById(R.id.btn_cancel_merge_pdf)).setTextColor(pdfMergingActivity.getResources().getColor(R.color.pdf_merge_conform_text_color));
                ((UIButton) pdfMergingActivity._$_findCachedViewById(R.id.btn_cancel_merge_pdf)).getHelper().b(pdfMergingActivity.getResources().getColor(R.color.pdf_merge_conform_btn_normal_bg));
                ((UIButton) pdfMergingActivity._$_findCachedViewById(R.id.btn_cancel_merge_pdf)).setOnClickListener(new yj(pdfMergingActivity));
            } else if (feVar instanceof fe.ad) {
                fe.mmm.qw.qqq.yj.qw.fe("PDFMrgSuc", "PDFMrgPg", (String) null, (Map) null, 12, (Object) null);
                fe.ad adVar = (fe.ad) feVar;
                fe.mmm.qw.ggg.qw.qw.qw("single_merge_new_files_document_pages_count", CollectionsKt__CollectionsJVMKt.listOf(String.valueOf(adVar.qw())));
                Intent startIntent = DocumentViewerActivity.getStartIntent(pdfMergingActivity.getApplicationContext(), adVar.ad().getLocalPath(), adVar.ad(), DocumentViewerActivity.FROM_PDF_MERGE, -1, 0, "");
                LocalBroadcastManager.getInstance(pdfMergingActivity).sendBroadcast(new Intent(PdfMergeAdjustFileActivity.CLOSE_PDF_MERGE_ADJUST_ACTIVITY));
                pdfMergingActivity.startActivity(startIntent);
                pdfMergingActivity.finish();
            }
        }
    }

    /* renamed from: initData$lambda-4$lambda-3  reason: not valid java name */
    public static final void m863initData$lambda4$lambda3(PdfMergingActivity pdfMergingActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfMergingActivity, "this$0");
        pdfMergingActivity.finish();
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m864initView$lambda0(PdfMergingActivity pdfMergingActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfMergingActivity, "this$0");
        pdfMergingActivity.cancelMerge();
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m865initView$lambda1(PdfMergingActivity pdfMergingActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfMergingActivity, "this$0");
        fe.mmm.qw.qqq.yj.qw.ad("PDFMrging_Cl", "PDFMrgPg", (String) null, (Map) null, 12, (Object) null);
        pdfMergingActivity.cancelMerge();
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
        return R.layout.activity_pdf_merging;
    }

    public void initView() {
        findViewById(R.id.layout_title_bar).setBackgroundColor(getResources().getColor(R.color.white));
        getTvTitleText().setText(R.string.pdf_merging_title);
        getBtnLeftBack().setOnClickListener(new a(this));
        ((UIButton) _$_findCachedViewById(R.id.btn_cancel_merge_pdf)).setOnClickListener(new aaa(this));
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_merge_loading_show", (List) null, 2, (Object) null);
        PDFMergeKt.rg(this);
        fe.mmm.qw.qqq.yj.qw.fe("PDFMrging", "PDFMrgPg", (String) null, (Map) null, 12, (Object) null);
    }

    public void onBackPressed() {
        cancelMerge();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }
}
