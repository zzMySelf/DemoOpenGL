package com.tera.scan.main.importfile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.IntentKt;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel;
import com.tera.scan.permission.util.ManageAppAllFilesAccessHelper;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.ui.view.widget.UITextView;
import fe.mmm.qw.th.qw.th.i;
import fe.mmm.qw.th.qw.th.o;
import fe.mmm.qw.xxx.uk.Cif;
import fe.mmm.qw.xxx.uk.ad;
import fe.mmm.qw.xxx.uk.de;
import fe.mmm.qw.xxx.uk.ggg.fe;
import fe.mmm.qw.xxx.uk.pf;
import fe.mmm.qw.xxx.uk.rg;
import fe.mmm.qw.xxx.uk.uk;
import fe.mmm.qw.xxx.uk.yj;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\b\u0007\u0018\u0000 T2\u00020\u0001:\u0001TB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020?H\u0002J\b\u0010A\u001a\u000204H\u0014J\b\u0010B\u001a\u00020?H\u0002J\b\u0010C\u001a\u00020?H\u0002J\b\u0010D\u001a\u00020?H\u0014J\"\u0010E\u001a\u00020?2\u0006\u0010F\u001a\u0002042\u0006\u0010G\u001a\u0002042\b\u0010H\u001a\u0004\u0018\u00010IH\u0014J\u0012\u0010J\u001a\u00020?2\b\u0010K\u001a\u0004\u0018\u00010LH\u0014J-\u0010M\u001a\u00020?2\u0006\u0010F\u001a\u0002042\u000e\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0O2\u0006\u0010P\u001a\u00020QH\u0016¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020?H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108@X\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0015\u0010\rR#\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u0018\u0010\rR#\u0010\u001a\u001a\n \u000b*\u0004\u0018\u00010\u001b0\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\b\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\b\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\b\u001a\u0004\b+\u0010,R\u001d\u0010.\u001a\u0004\u0018\u00010/8BX\u0002¢\u0006\f\n\u0004\b2\u0010\b\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u0002048BX\u0002¢\u0006\f\n\u0004\b7\u0010\b\u001a\u0004\b5\u00106R#\u00108\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b:\u0010\b\u001a\u0004\b9\u0010\rR#\u0010;\u001a\n \u000b*\u0004\u0018\u00010\u001b0\u001b8BX\u0002¢\u0006\f\n\u0004\b=\u0010\b\u001a\u0004\b<\u0010\u001d¨\u0006U"}, d2 = {"Lcom/tera/scan/main/importfile/ImportDocFilesActivity;", "Lcom/tera/scan/framework/BaseActivity;", "()V", "allFilesAccessHelper", "Lcom/tera/scan/permission/util/ManageAppAllFilesAccessHelper;", "getAllFilesAccessHelper", "()Lcom/tera/scan/permission/util/ManageAppAllFilesAccessHelper;", "allFilesAccessHelper$delegate", "Lkotlin/Lazy;", "btnLeftBack", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBtnLeftBack", "()Landroid/view/View;", "btnLeftBack$delegate", "docViewModel", "Lcom/tera/scan/main/importfile/viewmodel/ImportDocFileViewModel;", "getDocViewModel$app_main_aiscanConfigRelease", "()Lcom/tera/scan/main/importfile/viewmodel/ImportDocFileViewModel;", "docViewModel$delegate", "fileSelectAll", "getFileSelectAll", "fileSelectAll$delegate", "fileSelectClear", "getFileSelectClear", "fileSelectClear$delegate", "fileSelectCount", "Landroid/widget/TextView;", "getFileSelectCount", "()Landroid/widget/TextView;", "fileSelectCount$delegate", "importDocListFragment", "Lcom/tera/scan/main/importfile/ImportDocListFragment;", "getImportDocListFragment", "()Lcom/tera/scan/main/importfile/ImportDocListFragment;", "importDocListFragment$delegate", "importFilesDuringOperation", "", "getImportFilesDuringOperation", "()Z", "importFilesDuringOperation$delegate", "loadingDialogHelper", "Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "getLoadingDialogHelper", "()Lcom/tera/scan/component/base/util/LoadingDialogHelper;", "loadingDialogHelper$delegate", "reqFileType", "", "getReqFileType", "()Ljava/lang/String;", "reqFileType$delegate", "reqMaxFileCount", "", "getReqMaxFileCount", "()I", "reqMaxFileCount$delegate", "selectTopTitle", "getSelectTopTitle", "selectTopTitle$delegate", "tvTitleText", "getTvTitleText", "tvTitleText$delegate", "enterSelectMode", "", "exitSelectMode", "getLayoutId", "hideLoading", "initData", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "showLoading", "Companion", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Route(path = "/files/import/activity")
public final class ImportDocFilesActivity extends BaseActivity {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public final Lazy allFilesAccessHelper$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$allFilesAccessHelper$2(this));
    @NotNull
    public final Lazy btnLeftBack$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$btnLeftBack$2(this));
    @NotNull
    public final Lazy docViewModel$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$docViewModel$2(this));
    @NotNull
    public final Lazy fileSelectAll$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$fileSelectAll$2(this));
    @NotNull
    public final Lazy fileSelectClear$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$fileSelectClear$2(this));
    @NotNull
    public final Lazy fileSelectCount$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$fileSelectCount$2(this));
    @NotNull
    public final Lazy importDocListFragment$delegate = LazyKt__LazyJVMKt.lazy(ImportDocFilesActivity$importDocListFragment$2.INSTANCE);
    @NotNull
    public final Lazy importFilesDuringOperation$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$importFilesDuringOperation$2(this));
    @NotNull
    public final Lazy loadingDialogHelper$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$loadingDialogHelper$2(this));
    @NotNull
    public final Lazy reqFileType$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$reqFileType$2(this));
    @NotNull
    public final Lazy reqMaxFileCount$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$reqMaxFileCount$2(this));
    @NotNull
    public final Lazy selectTopTitle$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$selectTopTitle$2(this));
    @NotNull
    public final Lazy tvTitleText$delegate = LazyKt__LazyJVMKt.lazy(new ImportDocFilesActivity$tvTitleText$2(this));

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void qw(@Nullable FragmentActivity fragmentActivity) {
            if (fragmentActivity != null) {
                fragmentActivity.startActivity(new Intent(fragmentActivity, ImportDocFilesActivity.class));
            }
        }
    }

    private final void enterSelectMode() {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.layout_title_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "layout_title_bar");
        fe.mmm.qw.th.qw.rg.fe.de.qw.qw(_$_findCachedViewById);
        View selectTopTitle = getSelectTopTitle();
        Intrinsics.checkNotNullExpressionValue(selectTopTitle, "selectTopTitle");
        fe.mmm.qw.th.qw.rg.fe.de.qw.fe(selectTopTitle);
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.fl_doc_list_container);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "fl_doc_list_container");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.topToBottom = R.id.fl_select_top_title;
            frameLayout.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    private final void exitSelectMode() {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.layout_title_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "layout_title_bar");
        fe.mmm.qw.th.qw.rg.fe.de.qw.fe(_$_findCachedViewById);
        View selectTopTitle = getSelectTopTitle();
        Intrinsics.checkNotNullExpressionValue(selectTopTitle, "selectTopTitle");
        fe.mmm.qw.th.qw.rg.fe.de.qw.qw(selectTopTitle);
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.fl_doc_list_container);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "fl_doc_list_container");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.topToBottom = R.id.layout_title_bar;
            frameLayout.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    private final ManageAppAllFilesAccessHelper getAllFilesAccessHelper() {
        return (ManageAppAllFilesAccessHelper) this.allFilesAccessHelper$delegate.getValue();
    }

    private final View getBtnLeftBack() {
        return (View) this.btnLeftBack$delegate.getValue();
    }

    private final View getFileSelectAll() {
        return (View) this.fileSelectAll$delegate.getValue();
    }

    private final View getFileSelectClear() {
        return (View) this.fileSelectClear$delegate.getValue();
    }

    private final TextView getFileSelectCount() {
        return (TextView) this.fileSelectCount$delegate.getValue();
    }

    private final ImportDocListFragment getImportDocListFragment() {
        return (ImportDocListFragment) this.importDocListFragment$delegate.getValue();
    }

    private final boolean getImportFilesDuringOperation() {
        return ((Boolean) this.importFilesDuringOperation$delegate.getValue()).booleanValue();
    }

    private final i getLoadingDialogHelper() {
        return (i) this.loadingDialogHelper$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getReqFileType() {
        return (String) this.reqFileType$delegate.getValue();
    }

    private final int getReqMaxFileCount() {
        return ((Number) this.reqMaxFileCount$delegate.getValue()).intValue();
    }

    private final View getSelectTopTitle() {
        return (View) this.selectTopTitle$delegate.getValue();
    }

    private final TextView getTvTitleText() {
        return (TextView) this.tvTitleText$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void hideLoading() {
        getLoadingDialogHelper().fe();
    }

    private final void initData() {
        getDocViewModel$app_main_aiscanConfigRelease().initConfig(getReqFileType(), getReqMaxFileCount());
        getDocViewModel$app_main_aiscanConfigRelease().getSelectedCountLiveData().observe(this, new fe.mmm.qw.xxx.uk.i(this));
        getDocViewModel$app_main_aiscanConfigRelease().isSelectModeLiveData().observe(this, new pf(this));
        getDocViewModel$app_main_aiscanConfigRelease().isAllSelectLiveData().observe(this, new Cif(this));
        getDocViewModel$app_main_aiscanConfigRelease().getImportResultLiveData().observe(this, new uk(this));
    }

    /* renamed from: initData$lambda-5  reason: not valid java name */
    public static final void m809initData$lambda5(ImportDocFilesActivity importDocFilesActivity, Integer num) {
        Intrinsics.checkNotNullParameter(importDocFilesActivity, "this$0");
        if (num != null) {
            num.intValue();
            ((UITextView) importDocFilesActivity._$_findCachedViewById(R.id.btn_import_doc_files)).setEnabled(num.intValue() > 0);
            importDocFilesActivity.getFileSelectCount().setEnabled(num.intValue() > 0);
            importDocFilesActivity.getFileSelectCount().setText(importDocFilesActivity.getResources().getString(R.string.select_file_count, new Object[]{num}));
        }
    }

    /* renamed from: initData$lambda-6  reason: not valid java name */
    public static final void m810initData$lambda6(ImportDocFilesActivity importDocFilesActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(importDocFilesActivity, "this$0");
        if (bool != null) {
            bool.booleanValue();
            if (bool.booleanValue()) {
                importDocFilesActivity.enterSelectMode();
            } else {
                importDocFilesActivity.exitSelectMode();
            }
        }
    }

    /* renamed from: initData$lambda-7  reason: not valid java name */
    public static final void m811initData$lambda7(ImportDocFilesActivity importDocFilesActivity, Boolean bool) {
        String str;
        Intrinsics.checkNotNullParameter(importDocFilesActivity, "this$0");
        if (bool != null) {
            bool.booleanValue();
            importDocFilesActivity.getFileSelectAll().setSelected(bool.booleanValue());
            View fileSelectAll = importDocFilesActivity.getFileSelectAll();
            TextView textView = fileSelectAll instanceof TextView ? (TextView) fileSelectAll : null;
            if (textView != null) {
                if (bool.booleanValue()) {
                    str = importDocFilesActivity.getResources().getString(R.string.disselect_all_file);
                } else {
                    str = importDocFilesActivity.getResources().getString(R.string.select_all_file);
                }
                textView.setText(str);
            }
        }
    }

    /* renamed from: initData$lambda-8  reason: not valid java name */
    public static final void m812initData$lambda8(ImportDocFilesActivity importDocFilesActivity, fe feVar) {
        Intrinsics.checkNotNullParameter(importDocFilesActivity, "this$0");
        if (feVar != null) {
            String th2 = feVar.th();
            if (!(th2 == null || th2.length() == 0)) {
                o.uk(feVar.th());
            }
            if (feVar.de()) {
                Context applicationContext = importDocFilesActivity.getApplicationContext();
                String qw2 = feVar.qw();
                List<ScanRecordExportFile> rg2 = feVar.rg();
                importDocFilesActivity.startActivity(DocumentViewerActivity.getStartIntent(applicationContext, qw2, rg2 != null ? (ScanRecordExportFile) CollectionsKt___CollectionsKt.first(rg2) : null, "", -1, 0, ""));
            }
            if (feVar.fe()) {
                importDocFilesActivity.setResult(-1, IntentKt.Intent(new ImportDocFilesActivity$initData$4$1(feVar)));
            }
            if (feVar.ad()) {
                importDocFilesActivity.finish();
            }
        }
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m813initView$lambda0(ImportDocFilesActivity importDocFilesActivity, View view) {
        Intrinsics.checkNotNullParameter(importDocFilesActivity, "this$0");
        ImportDocFilesActivityKt.ad(importDocFilesActivity);
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m814initView$lambda1(ImportDocFilesActivity importDocFilesActivity, View view) {
        Intrinsics.checkNotNullParameter(importDocFilesActivity, "this$0");
        importDocFilesActivity.finish();
    }

    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m815initView$lambda2(ImportDocFilesActivity importDocFilesActivity, View view) {
        Intrinsics.checkNotNullParameter(importDocFilesActivity, "this$0");
        importDocFilesActivity.getDocViewModel$app_main_aiscanConfigRelease().changeAllSelectState();
    }

    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m816initView$lambda3(ImportDocFilesActivity importDocFilesActivity, View view) {
        Intrinsics.checkNotNullParameter(importDocFilesActivity, "this$0");
        if (importDocFilesActivity.getImportFilesDuringOperation()) {
            ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "device_import_click", (List) null, 2, (Object) null);
        }
        if (!ImportDocFilesActivityKt.de()) {
            importDocFilesActivity.getDocViewModel$app_main_aiscanConfigRelease().importSelectFiles(importDocFilesActivity.getReqFileType());
            return;
        }
        LifecycleOwner lifecycleOwner = importDocFilesActivity.getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
        ImportDocFilesActivityKt.qw(lifecycleOwner, new ImportDocFilesActivity$initView$4$1(importDocFilesActivity));
    }

    /* renamed from: initView$lambda-4  reason: not valid java name */
    public static final void m817initView$lambda4(ImportDocFilesActivity importDocFilesActivity, List list) {
        Intrinsics.checkNotNullParameter(importDocFilesActivity, "this$0");
        View fileSelectAll = importDocFilesActivity.getFileSelectAll();
        if (fileSelectAll != null) {
            fileSelectAll.setEnabled(!(list == null || list.isEmpty()));
        }
    }

    /* access modifiers changed from: private */
    public final void showLoading() {
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

    @NotNull
    public final ImportDocFileViewModel getDocViewModel$app_main_aiscanConfigRelease() {
        return (ImportDocFileViewModel) this.docViewModel$delegate.getValue();
    }

    public int getLayoutId() {
        return R.layout.activity_import_doc_files;
    }

    public void initView() {
        fe.mmm.qw.ggg.qw.qw.qw("scan_import_files_show", CollectionsKt__CollectionsJVMKt.listOf(getImportFilesDuringOperation() ? "choose files" : "files"));
        getTvTitleText().setText(R.string.import_files_title);
        getFileSelectClear().setOnClickListener(new ad(this));
        getBtnLeftBack().setOnClickListener(new fe.mmm.qw.xxx.uk.fe(this));
        _$_findCachedViewById(R.id.layout_title_bar).setBackgroundColor(getResources().getColor(R.color.white));
        getFileSelectAll().setOnClickListener(new rg(this));
        ((UITextView) _$_findCachedViewById(R.id.btn_import_doc_files)).setOnClickListener(new de(this));
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_doc_list_container, getImportDocListFragment()).commitAllowingStateLoss();
        getAllFilesAccessHelper().o(new ImportDocFilesActivity$initView$5(this));
        getAllFilesAccessHelper().i();
        getDocViewModel$app_main_aiscanConfigRelease().getFileListLiveData().observe(this, new yj(this));
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        getAllFilesAccessHelper().yj(i2, i3, intent);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initData();
    }

    public void onRequestPermissionsResult(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        getAllFilesAccessHelper().uk(i2, strArr, iArr);
    }
}
