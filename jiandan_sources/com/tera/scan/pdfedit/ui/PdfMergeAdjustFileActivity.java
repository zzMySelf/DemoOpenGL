package com.tera.scan.pdfedit.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.business.core.ui.dialog.RenameCommonDialog;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.pdfedit.adapter.PdfListMergeAdapter;
import com.tera.scan.pdfedit.ui.dialog.MergeFormatSelectDialog;
import com.tera.scan.pdfedit.viewmodel.PdfMergeAdjustFileViewModel;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.ui.view.widget.UIButton;
import fe.mmm.qw.qqq.uk.e;
import fe.mmm.qw.qqq.uk.o;
import fe.mmm.qw.qqq.uk.rg;
import fe.mmm.qw.qqq.uk.vvv;
import fe.mmm.qw.th.qw.th.i;
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

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\f\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0014J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0015J\"\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0012\u0010-\u001a\u00020%2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020%H\u0014J\b\u00101\u001a\u00020%H\u0002J\u0018\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020%H\u0016J\b\u00107\u001a\u00020%H\u0016J\b\u00108\u001a\u00020%H\u0002J\b\u00109\u001a\u00020%H\u0002J\u0010\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u00020<H\u0002R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001d\u001a\n \u0006*\u0004\u0018\u00010\u001e0\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\n\u001a\u0004\b\u001f\u0010 ¨\u0006>"}, d2 = {"Lcom/tera/scan/pdfedit/ui/PdfMergeAdjustFileActivity;", "Lcom/tera/scan/framework/BaseActivity;", "Lcom/tera/scan/pdfedit/ui/dialog/MergeFormatSelectDialog$MergeFormatSelectDialogListener;", "()V", "btnLeftBack", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBtnLeftBack", "()Landroid/view/View;", "btnLeftBack$delegate", "Lkotlin/Lazy;", "closeActivityReceiver", "com/tera/scan/pdfedit/ui/PdfMergeAdjustFileActivity$closeActivityReceiver$1", "Lcom/tera/scan/pdfedit/ui/PdfMergeAdjustFileActivity$closeActivityReceiver$1;", "loadingDialogHelper", "Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "getLoadingDialogHelper", "()Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "loadingDialogHelper$delegate", "mergeViewModel", "Lcom/tera/scan/pdfedit/viewmodel/PdfMergeAdjustFileViewModel;", "getMergeViewModel", "()Lcom/tera/scan/pdfedit/viewmodel/PdfMergeAdjustFileViewModel;", "mergeViewModel$delegate", "pdfMergeAdapter", "Lcom/tera/scan/pdfedit/adapter/PdfListMergeAdapter;", "getPdfMergeAdapter", "()Lcom/tera/scan/pdfedit/adapter/PdfListMergeAdapter;", "pdfMergeAdapter$delegate", "tvTitleText", "Landroid/widget/TextView;", "getTvTitleText", "()Landroid/widget/TextView;", "tvTitleText$delegate", "getLayoutId", "", "hideLoading", "", "initData", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemAddClick", "onItemDeleteClick", "position", "mergePdfItemData", "Lcom/tera/scan/pdfedit/data/MergePdfItemData;", "onUserSelectMergeToNewDoc", "onUserSelectMergeToReplaceDoc", "showLoading", "showMergeFormatSelectDialog", "showRenameDialog", "replaceOldDocFile", "", "Companion", "BaiduNetDiskModules_Pdf_Edit_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PdfMergeAdjustFileActivity extends BaseActivity implements MergeFormatSelectDialog.MergeFormatSelectDialogListener {
    @NotNull
    public static final String CLOSE_PDF_MERGE_ADJUST_ACTIVITY = "close_pdf_merge_adjust_activity";
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_MERGE_PDF_LIST = "merge_pdf_list";
    @NotNull
    public static final String RENAME_FILE_DIALOG_TAG = "rename_file_dialog_tag";
    public static final int REQUEST_CODE_FOR_ADD_DOC = 1111;
    @NotNull
    public static final String TAG_MERGE_FORMAT_SELECT_DIALOG = "tag_merge_format_select_dialog";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy btnLeftBack$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergeAdjustFileActivity$btnLeftBack$2(this));
    @NotNull
    public final PdfMergeAdjustFileActivity$closeActivityReceiver$1 closeActivityReceiver = new PdfMergeAdjustFileActivity$closeActivityReceiver$1(this);
    @NotNull
    public final Lazy loadingDialogHelper$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergeAdjustFileActivity$loadingDialogHelper$2(this));
    @NotNull
    public final Lazy mergeViewModel$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergeAdjustFileActivity$mergeViewModel$2(this));
    @NotNull
    public final Lazy pdfMergeAdapter$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergeAdjustFileActivity$pdfMergeAdapter$2(this));
    @NotNull
    public final Lazy tvTitleText$delegate = LazyKt__LazyJVMKt.lazy(new PdfMergeAdjustFileActivity$tvTitleText$2(this));

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void qw(@NotNull Context context, @Nullable ArrayList<ScanRecordExportFile> arrayList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, PdfMergeAdjustFileActivity.class);
            intent.putExtra("merge_pdf_list", arrayList);
            context.startActivity(intent);
        }
    }

    private final View getBtnLeftBack() {
        return (View) this.btnLeftBack$delegate.getValue();
    }

    private final i getLoadingDialogHelper() {
        return (i) this.loadingDialogHelper$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PdfMergeAdjustFileViewModel getMergeViewModel() {
        return (PdfMergeAdjustFileViewModel) this.mergeViewModel$delegate.getValue();
    }

    private final PdfListMergeAdapter getPdfMergeAdapter() {
        return (PdfListMergeAdapter) this.pdfMergeAdapter$delegate.getValue();
    }

    private final TextView getTvTitleText() {
        return (TextView) this.tvTitleText$delegate.getValue();
    }

    private final void hideLoading() {
        getLoadingDialogHelper().fe();
    }

    private final void initData() {
        getMergeViewModel().initPdfData(getIntent().getParcelableArrayListExtra("merge_pdf_list"));
        getMergeViewModel().getLoading().observe(this, new vvv(this));
        getMergeViewModel().getPdfListLiveData().observe(this, new o(this));
        LocalBroadcastManager.getInstance(this).registerReceiver(this.closeActivityReceiver, new IntentFilter(CLOSE_PDF_MERGE_ADJUST_ACTIVITY));
    }

    /* renamed from: initData$lambda-3  reason: not valid java name */
    public static final void m856initData$lambda3(PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pdfMergeAdjustFileActivity, "this$0");
        if (bool != null) {
            bool.booleanValue();
            if (bool.booleanValue()) {
                pdfMergeAdjustFileActivity.showLoading();
            } else {
                pdfMergeAdjustFileActivity.hideLoading();
            }
        }
    }

    /* renamed from: initData$lambda-4  reason: not valid java name */
    public static final void m857initData$lambda4(PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(pdfMergeAdjustFileActivity, "this$0");
        boolean z = false;
        if (arrayList == null) {
            ((UIButton) pdfMergeAdjustFileActivity._$_findCachedViewById(R.id.btn_merge_pdfs)).setEnabled(false);
            return;
        }
        UIButton uIButton = (UIButton) pdfMergeAdjustFileActivity._$_findCachedViewById(R.id.btn_merge_pdfs);
        if (arrayList.size() > 1) {
            z = true;
        }
        uIButton.setEnabled(z);
        pdfMergeAdjustFileActivity.getPdfMergeAdapter().updateData(arrayList);
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m858initView$lambda0(PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfMergeAdjustFileActivity, "this$0");
        pdfMergeAdjustFileActivity.finish();
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m859initView$lambda1(PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfMergeAdjustFileActivity, "this$0");
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_change_order_merge_click", (List) null, 2, (Object) null);
        pdfMergeAdjustFileActivity.showMergeFormatSelectDialog();
        fe.mmm.qw.qqq.yj.qw.ad("PDFMrgSt_Mrg", "PDFMrgPg", (String) null, (Map) null, 12, (Object) null);
    }

    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m860initView$lambda2(PdfMergeAdjustFileActivity pdfMergeAdjustFileActivity, View view) {
        Intrinsics.checkNotNullParameter(pdfMergeAdjustFileActivity, "this$0");
        fe.mmm.qw.qqq.yj.qw.ad("PDFMrgSt_Add", "PDFMrgPg", (String) null, (Map) null, 12, (Object) null);
        pdfMergeAdjustFileActivity.onItemAddClick();
    }

    /* access modifiers changed from: private */
    public final void onItemAddClick() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_change_order_add_pdf_click", (List) null, 2, (Object) null);
        startActivityForResult(new Intent(this, PdfMergeAddActivity.class), 1111);
    }

    /* access modifiers changed from: private */
    public final void onItemDeleteClick(int i2, fe.mmm.qw.qqq.rg.qw qwVar) {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_change_order_cancel_pdf_click", (List) null, 2, (Object) null);
        getMergeViewModel().deletePdfItem(i2, qwVar);
    }

    private final void showLoading() {
        getLoadingDialogHelper().rg(R.string.loading_text);
    }

    private final void showMergeFormatSelectDialog() {
        if (getMergeViewModel().hasEncryptPdf()) {
            fe.mmm.qw.th.qw.th.o.rg(R.string.not_supported_merge_encrypted_pdfs);
            return;
        }
        MergeFormatSelectDialog mergeFormatSelectDialog = new MergeFormatSelectDialog();
        mergeFormatSelectDialog.setListener(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        mergeFormatSelectDialog.show(supportFragmentManager, TAG_MERGE_FORMAT_SELECT_DIALOG);
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_merge_dialog_show", (List) null, 2, (Object) null);
    }

    private final void showRenameDialog(boolean z) {
        RenameCommonDialog renameCommonDialog = new RenameCommonDialog(getMergeViewModel().getCreatePdfDefaultName(z), (String) null, (String) null, 30, 6, (DefaultConstructorMarker) null);
        renameCommonDialog.setOnConfirm(new PdfMergeAdjustFileActivity$showRenameDialog$1$1(this, z));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        renameCommonDialog.show(supportFragmentManager, RENAME_FILE_DIALOG_TAG);
        fe.mmm.qw.ggg.qw.qw.qw("scan_rename_dialog_show", CollectionsKt__CollectionsJVMKt.listOf("merge"));
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
        return R.layout.activity_pdf_merge_adjust_file;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void initView() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_change_order_show", (List) null, 2, (Object) null);
        findViewById(R.id.layout_title_bar).setBackgroundColor(getResources().getColor(R.color.white));
        getTvTitleText().setText(PDFMergeKt.when(this));
        getBtnLeftBack().setOnClickListener(new e(this));
        ((RecyclerView) _$_findCachedViewById(R.id.rv_import_files)).setAdapter(getPdfMergeAdapter());
        ((RecyclerView) _$_findCachedViewById(R.id.rv_import_files)).setLayoutManager(new LinearLayoutManager(this));
        getPdfMergeAdapter().setOnItemAddListener(new PdfMergeAdjustFileActivity$initView$2(this));
        getPdfMergeAdapter().setOnItemDeleteListener(new PdfMergeAdjustFileActivity$initView$3(this));
        ((UIButton) _$_findCachedViewById(R.id.btn_merge_pdfs)).setOnClickListener(new rg(this));
        UIButton uIButton = (UIButton) _$_findCachedViewById(R.id.btn_add_file);
        Intrinsics.checkNotNullExpressionValue(uIButton, "btn_add_file");
        uIButton.setVisibility(PDFMergeKt.qw(this) ? 0 : 8);
        ((UIButton) _$_findCachedViewById(R.id.btn_add_file)).setOnClickListener(new fe.mmm.qw.qqq.uk.qw(this));
        PdfMergeItemTouchHelper pdfMergeItemTouchHelper = new PdfMergeItemTouchHelper(getPdfMergeAdapter());
        pdfMergeItemTouchHelper.setChangeListener(new PdfMergeAdjustFileActivity$initView$6(this));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(pdfMergeItemTouchHelper);
        itemTouchHelper.attachToRecyclerView((RecyclerView) _$_findCachedViewById(R.id.rv_import_files));
        getPdfMergeAdapter().setItemTouchHelper(itemTouchHelper);
        PDFMergeKt.fe(this);
        fe.mmm.qw.qqq.yj.qw.fe("PDFMrgSt", "PDFMrgPg", (String) null, (Map) null, 12, (Object) null);
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        ArrayList parcelableArrayListExtra;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1111 && i3 == -1 && intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_select_pdf_items")) != null) {
            getMergeViewModel().addPdfItem(parcelableArrayListExtra);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.closeActivityReceiver);
    }

    public void onUserSelectMergeToNewDoc() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_merge_dialog_keep_old_document_click", (List) null, 2, (Object) null);
        showRenameDialog(false);
    }

    public void onUserSelectMergeToReplaceDoc() {
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "scan_merge_dialog_no_keep_old_document_click", (List) null, 2, (Object) null);
        showRenameDialog(true);
    }
}
