package com.tera.scan.main.home;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.business.core.widget.FileSelectBottomItemView;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.main.MainActivity;
import com.tera.scan.main.fragment.ScanBaseFragment;
import com.tera.scan.main.home.dialog.BottomFileMoreMenuDialog;
import com.tera.scan.main.home.dialog.DeleteFileDialog;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import com.tera.scan.pdfedit.ui.PdfMergeAdjustFileActivity;
import com.tera.scan.pdfedit.ui.PdfSplitActivity;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.xxx.pf.de;
import fe.mmm.qw.xxx.ppp.th;
import fe.mmm.qw.xxx.yj.Cswitch;
import fe.mmm.qw.xxx.yj.ad;
import fe.mmm.qw.xxx.yj.b;
import fe.mmm.qw.xxx.yj.d;
import fe.mmm.qw.xxx.yj.i;
import fe.mmm.qw.xxx.yj.mmm;
import fe.mmm.qw.xxx.yj.nn;
import fe.mmm.qw.xxx.yj.o;
import fe.mmm.qw.xxx.yj.ppp;
import fe.mmm.qw.xxx.yj.rg;
import fe.mmm.qw.xxx.yj.vvv;
import fe.mmm.qw.xxx.yj.xxx;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u0011J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\u0018\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007H\u0016J\b\u0010*\u001a\u00020\u0019H\u0002J\u0012\u0010+\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0011H\u0002J\b\u00103\u001a\u00020\u0019H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\b\u00105\u001a\u00020\u0019H\u0016J\b\u00106\u001a\u00020\u0019H\u0002J\b\u00107\u001a\u00020\u0019H\u0002J\b\u00108\u001a\u00020\u0019H\u0002J\u0012\u00109\u001a\u00020\u00192\b\b\u0002\u0010:\u001a\u000200H\u0002J*\u0010;\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030\u001c2\u0006\u00102\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006?"}, d2 = {"Lcom/tera/scan/main/home/FileSelectModeFragment;", "Lcom/tera/scan/main/fragment/ScanBaseFragment;", "Lcom/tera/scan/main/home/dialog/BottomFileMoreMenuDialog$BottomFileMoreMenuDialogListener;", "()V", "adapter", "Lcom/tera/scan/main/home/MainFileListAdapter;", "fileBottomMerge", "Landroid/view/View;", "fileSelectAll", "fileSelectClear", "fileSelectCountTextView", "Landroid/widget/TextView;", "fileSelectList", "Landroidx/recyclerview/widget/RecyclerView;", "fragmentRoot", "Landroid/view/ViewGroup;", "scrollYDistance", "", "viewModel", "Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "getViewModel$app_main_aiscanConfigRelease", "()Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "setViewModel$app_main_aiscanConfigRelease", "(Lcom/tera/scan/main/viewmodel/MainActivityViewModel;)V", "deleteSelectItem", "", "getLayoutId", "getListHolder", "Lcom/tera/scan/main/home/bean/listholder/BaseMainListHolder;", "getListScrollY", "getReportClickParam", "", "", "param1", "getReportClickTrace", "initBottomFunc", "initData", "initSubscribe", "initView", "context", "Landroid/content/Context;", "view", "mergeFile", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onHiddenChanged", "hidden", "", "onItemSelect", "position", "onMoreMenuDeleteClick", "onMoreMenuSplitClick", "onResume", "setStatusBarState", "shareFile", "showMoreMenuDialog", "updateBottomFuncEnable", "fromObserve", "updateData", "holder", "itemY", "Companion", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileSelectModeFragment extends ScanBaseFragment implements BottomFileMoreMenuDialog.BottomFileMoreMenuDialogListener {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "file_select";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public MainFileListAdapter adapter;
    @Nullable
    public View fileBottomMerge;
    @Nullable
    public View fileSelectAll;
    @Nullable
    public View fileSelectClear;
    @Nullable
    public TextView fileSelectCountTextView;
    @Nullable
    public RecyclerView fileSelectList;
    @Nullable
    public ViewGroup fragmentRoot;
    public int scrollYDistance;
    public MainActivityViewModel viewModel;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void deleteSelectItem() {
        FragmentActivity activity;
        fe.mmm.qw.ggg.qw.qw.qw(getReportClickTrace(), getReportClickParam("delete"));
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder = getListHolder();
        Set<Integer> uk2 = listHolder != null ? listHolder.uk() : null;
        if (!(uk2 == null || uk2.isEmpty()) && (activity = getActivity()) != null) {
            DeleteFileDialog deleteFileDialog = new DeleteFileDialog();
            deleteFileDialog.de(new FileSelectModeFragment$deleteSelectItem$1$1(this, activity));
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            deleteFileDialog.fe(supportFragmentManager, "DeleteFileDialog");
        }
    }

    /* access modifiers changed from: private */
    public final fe.mmm.qw.xxx.yj.g.qw.qw<?> getListHolder() {
        MainFileListAdapter mainFileListAdapter = this.adapter;
        if (mainFileListAdapter != null) {
            return mainFileListAdapter.getListHolder();
        }
        return null;
    }

    private final List<String> getReportClickParam(String str) {
        List<String> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(str);
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder = getListHolder();
        Integer valueOf = listHolder != null ? Integer.valueOf(listHolder.fe()) : null;
        if ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 0)) {
            mutableListOf.add("pdf");
        } else {
            mutableListOf.add("picture");
        }
        if (valueOf != null && valueOf.intValue() == 0) {
            mutableListOf.add("home");
        } else {
            mutableListOf.add("file");
        }
        return mutableListOf;
    }

    private final String getReportClickTrace() {
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder = getListHolder();
        boolean z = false;
        if (listHolder != null && listHolder.fe() == 0) {
            z = true;
        }
        return z ? "home_recently_use_choose_page_click" : "files_choose_operations_page_click";
    }

    private final void initBottomFunc() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            updateBottomFuncEnable$default(this, false, 1, (Object) null);
            ((FileSelectBottomItemView) _$_findCachedViewById(R.id.file_bottom_item_share)).setOnClickListener(new b(this));
            ((FileSelectBottomItemView) _$_findCachedViewById(R.id.file_bottom_item_move)).setOnClickListener(new ad(this));
            ((FileSelectBottomItemView) _$_findCachedViewById(R.id.file_bottom_item_rename)).setOnClickListener(new Cswitch(this, activity));
            ((FileSelectBottomItemView) _$_findCachedViewById(R.id.file_bottom_item_delete)).setOnClickListener(new d(this));
            View view = this.fileBottomMerge;
            if (view != null) {
                view.setOnClickListener(new i(this));
            }
            ((FileSelectBottomItemView) _$_findCachedViewById(R.id.file_bottom_item_more)).setOnClickListener(new ppp(this));
        }
    }

    /* renamed from: initBottomFunc$lambda-10  reason: not valid java name */
    public static final void m781initBottomFunc$lambda10(FileSelectModeFragment fileSelectModeFragment, View view) {
        Intrinsics.checkNotNullParameter(fileSelectModeFragment, "this$0");
        fileSelectModeFragment.showMoreMenuDialog();
    }

    /* renamed from: initBottomFunc$lambda-4  reason: not valid java name */
    public static final void m782initBottomFunc$lambda4(FileSelectModeFragment fileSelectModeFragment, View view) {
        String str;
        Intrinsics.checkNotNullParameter(fileSelectModeFragment, "this$0");
        fe.mmm.qw.ggg.qw.qw.qw(fileSelectModeFragment.getReportClickTrace(), fileSelectModeFragment.getReportClickParam("share"));
        fileSelectModeFragment.shareFile();
        String value = fileSelectModeFragment.getViewModel$app_main_aiscanConfigRelease().getCurrentTab().getValue();
        if (Intrinsics.areEqual((Object) value, (Object) th.f8636rg.ad())) {
            str = "Rec_Shr_clk";
        } else {
            str = Intrinsics.areEqual((Object) value, (Object) th.f8636rg.qw()) ? "FileShr" : "";
        }
        de.ad(str, "Homepage", (String) null, (Map) null, 12, (Object) null);
    }

    /* renamed from: initBottomFunc$lambda-5  reason: not valid java name */
    public static final void m783initBottomFunc$lambda5(FileSelectModeFragment fileSelectModeFragment, View view) {
        Intrinsics.checkNotNullParameter(fileSelectModeFragment, "this$0");
        fe.mmm.qw.ggg.qw.qw.qw(fileSelectModeFragment.getReportClickTrace(), fileSelectModeFragment.getReportClickParam("move"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0046, code lost:
        r0 = (r0 = r0.getListHolder()).de();
     */
    /* renamed from: initBottomFunc$lambda-7  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m784initBottomFunc$lambda7(com.tera.scan.main.home.FileSelectModeFragment r9, androidx.fragment.app.FragmentActivity r10, android.view.View r11) {
        /*
            java.lang.String r11 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r11)
            java.lang.String r11 = "$activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
            fe.mmm.qw.ggg.qw r11 = fe.mmm.qw.ggg.qw.qw
            java.lang.String r0 = r9.getReportClickTrace()
            java.lang.String r1 = "rename"
            java.util.List r2 = r9.getReportClickParam(r1)
            r11.qw(r0, r2)
            fe.mmm.qw.ggg.qw r11 = fe.mmm.qw.ggg.qw.qw
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r1)
            java.lang.String r1 = "scan_rename_dialog_show"
            r11.qw(r1, r0)
            fe.mmm.qw.xxx.yj.g.qw.qw r11 = r9.getListHolder()
            if (r11 == 0) goto L_0x0081
            java.util.Set r11 = r11.uk()
            if (r11 == 0) goto L_0x0081
            java.lang.Object r11 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r11)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 == 0) goto L_0x0081
            int r11 = r11.intValue()
            com.tera.scan.main.home.MainFileListAdapter r0 = r9.adapter
            if (r0 == 0) goto L_0x0053
            fe.mmm.qw.xxx.yj.g.qw.qw r0 = r0.getListHolder()
            if (r0 == 0) goto L_0x0053
            java.util.List r0 = r0.de()
            if (r0 == 0) goto L_0x0053
            java.lang.Object r0 = r0.get(r11)
            com.tera.scan.main.home.bean.recordwrapper.RecordWrapper r0 = (com.tera.scan.main.home.bean.recordwrapper.RecordWrapper) r0
            goto L_0x0054
        L_0x0053:
            r0 = 0
        L_0x0054:
            com.tera.scan.business.core.ui.dialog.RenameCommonDialog r8 = new com.tera.scan.business.core.ui.dialog.RenameCommonDialog
            if (r0 == 0) goto L_0x005e
            java.lang.String r1 = r0.getFileName()
            if (r1 != 0) goto L_0x0060
        L_0x005e:
            java.lang.String r1 = ""
        L_0x0060:
            r2 = r1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 14
            r7 = 0
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            com.tera.scan.main.home.FileSelectModeFragment$initBottomFunc$3$1$1 r1 = new com.tera.scan.main.home.FileSelectModeFragment$initBottomFunc$3$1$1
            r1.<init>(r0, r9, r10, r11)
            r8.setOnConfirm(r1)
            androidx.fragment.app.FragmentManager r9 = r10.getSupportFragmentManager()
            java.lang.String r10 = "activity.supportFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            java.lang.String r10 = "RenameFileDialog"
            r8.show(r9, r10)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.home.FileSelectModeFragment.m784initBottomFunc$lambda7(com.tera.scan.main.home.FileSelectModeFragment, androidx.fragment.app.FragmentActivity, android.view.View):void");
    }

    /* renamed from: initBottomFunc$lambda-8  reason: not valid java name */
    public static final void m785initBottomFunc$lambda8(FileSelectModeFragment fileSelectModeFragment, View view) {
        Intrinsics.checkNotNullParameter(fileSelectModeFragment, "this$0");
        fileSelectModeFragment.deleteSelectItem();
    }

    /* renamed from: initBottomFunc$lambda-9  reason: not valid java name */
    public static final void m786initBottomFunc$lambda9(FileSelectModeFragment fileSelectModeFragment, View view) {
        Intrinsics.checkNotNullParameter(fileSelectModeFragment, "this$0");
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "choose_state_merge_click", (List) null, 2, (Object) null);
        fileSelectModeFragment.mergeFile();
    }

    private final void initData() {
        initSubscribe();
        updateBottomFuncEnable$default(this, false, 1, (Object) null);
    }

    private final void initSubscribe() {
        LiveData<List<?>> rg2;
        MutableLiveData<Integer> th2;
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder = getListHolder();
        if (!(listHolder == null || (th2 = listHolder.th()) == null)) {
            th2.observe(getViewLifecycleOwner(), new nn(this));
        }
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder2 = getListHolder();
        if (listHolder2 != null && (rg2 = listHolder2.rg()) != null) {
            rg2.observe(getViewLifecycleOwner(), new mmm(this));
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [android.view.View] */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0025, code lost:
        r0 = r0.de();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: initSubscribe$lambda-14  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m787initSubscribe$lambda14(com.tera.scan.main.home.FileSelectModeFragment r6, java.lang.Integer r7) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.widget.TextView r0 = r6.fileSelectCountTextView
            r1 = 1
            if (r0 != 0) goto L_0x000b
            goto L_0x001e
        L_0x000b:
            android.content.res.Resources r2 = r6.getResources()
            r3 = 2131887162(0x7f12043a, float:1.9408923E38)
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r5 = 0
            r4[r5] = r7
            java.lang.String r2 = r2.getString(r3, r4)
            r0.setText(r2)
        L_0x001e:
            fe.mmm.qw.xxx.yj.g.qw.qw r0 = r6.getListHolder()
            r2 = 0
            if (r0 == 0) goto L_0x0034
            java.util.List r0 = r0.de()
            if (r0 == 0) goto L_0x0034
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0035
        L_0x0034:
            r0 = r2
        L_0x0035:
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            android.view.View r0 = r6.fileSelectAll
            if (r0 != 0) goto L_0x003e
            goto L_0x0041
        L_0x003e:
            r0.setSelected(r7)
        L_0x0041:
            android.view.View r0 = r6.fileSelectAll
            boolean r3 = r0 instanceof android.widget.TextView
            if (r3 == 0) goto L_0x004a
            r2 = r0
            android.widget.TextView r2 = (android.widget.TextView) r2
        L_0x004a:
            if (r2 != 0) goto L_0x004d
            goto L_0x0069
        L_0x004d:
            if (r7 == 0) goto L_0x005b
            android.content.res.Resources r7 = r6.getResources()
            r0 = 2131886410(0x7f12014a, float:1.9407398E38)
            java.lang.String r7 = r7.getString(r0)
            goto L_0x0066
        L_0x005b:
            android.content.res.Resources r7 = r6.getResources()
            r0 = 2131887161(0x7f120439, float:1.9408921E38)
            java.lang.String r7 = r7.getString(r0)
        L_0x0066:
            r2.setText(r7)
        L_0x0069:
            r6.updateBottomFuncEnable(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.home.FileSelectModeFragment.m787initSubscribe$lambda14(com.tera.scan.main.home.FileSelectModeFragment, java.lang.Integer):void");
    }

    /* renamed from: initSubscribe$lambda-15  reason: not valid java name */
    public static final void m788initSubscribe$lambda15(FileSelectModeFragment fileSelectModeFragment, List list) {
        Intrinsics.checkNotNullParameter(fileSelectModeFragment, "this$0");
        FragmentActivity activity = fileSelectModeFragment.getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null && list.isEmpty()) {
            fileSelectModeFragment.getViewModel$app_main_aiscanConfigRelease().exitFileSelectMode(mainActivity);
        }
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m789initView$lambda0(View view) {
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m790initView$lambda1(View view) {
    }

    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m791initView$lambda2(FileSelectModeFragment fileSelectModeFragment, MainActivity mainActivity, View view) {
        Intrinsics.checkNotNullParameter(fileSelectModeFragment, "this$0");
        Intrinsics.checkNotNullParameter(mainActivity, "$activity");
        fileSelectModeFragment.getViewModel$app_main_aiscanConfigRelease().exitFileSelectMode(mainActivity);
    }

    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m792initView$lambda3(FileSelectModeFragment fileSelectModeFragment, View view) {
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder;
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder2;
        Intrinsics.checkNotNullParameter(fileSelectModeFragment, "this$0");
        View view2 = fileSelectModeFragment.fileSelectAll;
        boolean z = true;
        if (view2 == null || !view2.isSelected()) {
            z = false;
        }
        if (!z) {
            MainFileListAdapter mainFileListAdapter = fileSelectModeFragment.adapter;
            if (!(mainFileListAdapter == null || (listHolder2 = mainFileListAdapter.getListHolder()) == null)) {
                listHolder2.m1011switch();
            }
        } else {
            MainFileListAdapter mainFileListAdapter2 = fileSelectModeFragment.adapter;
            if (!(mainFileListAdapter2 == null || (listHolder = mainFileListAdapter2.getListHolder()) == null)) {
                listHolder.qw();
            }
        }
        MainFileListAdapter mainFileListAdapter3 = fileSelectModeFragment.adapter;
        if (mainFileListAdapter3 != null) {
            mainFileListAdapter3.notifyDataSetChanged();
        }
    }

    private final void mergeFile() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            MainActivityViewModel viewModel$app_main_aiscanConfigRelease = getViewModel$app_main_aiscanConfigRelease();
            fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder = getListHolder();
            MainActivity mainActivity = null;
            Set<Integer> uk2 = listHolder != null ? listHolder.uk() : null;
            fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder2 = getListHolder();
            PdfMergeAdjustFileActivity.Companion.qw(activity, viewModel$app_main_aiscanConfigRelease.getSelectPdfFiles(uk2, listHolder2 != null ? listHolder2.de() : null));
            if (activity instanceof MainActivity) {
                mainActivity = (MainActivity) activity;
            }
            if (mainActivity != null) {
                getViewModel$app_main_aiscanConfigRelease().exitFileSelectMode(mainActivity);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onItemSelect(int i2) {
        Set<Integer> set;
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder = getListHolder();
        if (listHolder == null || (set = listHolder.uk()) == null) {
            set = new LinkedHashSet<>();
        }
        if (set.contains(Integer.valueOf(i2))) {
            set.remove(Integer.valueOf(i2));
        } else {
            set.add(Integer.valueOf(i2));
        }
        MainFileListAdapter mainFileListAdapter = this.adapter;
        if (mainFileListAdapter != null) {
            mainFileListAdapter.notifyItemChanged(i2);
        }
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder2 = getListHolder();
        if (listHolder2 != null) {
            listHolder2.ggg();
        }
        updateBottomFuncEnable$default(this, false, 1, (Object) null);
    }

    private final void setStatusBarState() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            fe.mmm.qw.xxx.p032if.th.ad.qw(activity, R.color.white);
        }
    }

    private final void shareFile() {
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder;
        Context context = getContext();
        if (context != null && (listHolder = getListHolder()) != null) {
            listHolder.ppp(context);
        }
    }

    private final void showMoreMenuDialog() {
        FragmentManager supportFragmentManager;
        BottomFileMoreMenuDialog bottomFileMoreMenuDialog = new BottomFileMoreMenuDialog();
        bottomFileMoreMenuDialog.setListener(this);
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            bottomFileMoreMenuDialog.show(supportFragmentManager, "tag_bottom_file_menu_more");
            ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "choose_state_more_extract_show", (List) null, 2, (Object) null);
        }
    }

    private final void updateBottomFuncEnable(boolean z) {
        Set<Integer> set;
        List<?> list;
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder = getListHolder();
        if (listHolder == null || (set = listHolder.uk()) == null) {
            set = SetsKt__SetsKt.emptySet();
        }
        int i2 = 8;
        ((FrameLayout) _$_findCachedViewById(R.id.fl_file_select_bottom)).setVisibility(set.isEmpty() ? 8 : 0);
        MainActivityViewModel viewModel$app_main_aiscanConfigRelease = getViewModel$app_main_aiscanConfigRelease();
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder2 = getListHolder();
        if (listHolder2 == null || (list = listHolder2.de()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Set<String> calculateBottomFuncEnable = viewModel$app_main_aiscanConfigRelease.calculateBottomFuncEnable(set, list);
        FileSelectBottomItemView fileSelectBottomItemView = (FileSelectBottomItemView) _$_findCachedViewById(R.id.file_bottom_item_share);
        Intrinsics.checkNotNullExpressionValue(fileSelectBottomItemView, "file_bottom_item_share");
        fileSelectBottomItemView.setVisibility(calculateBottomFuncEnable.contains("share") ? 0 : 8);
        View view = this.fileBottomMerge;
        if (view != null) {
            view.setVisibility(calculateBottomFuncEnable.contains("merge") ? 0 : 8);
        }
        if (calculateBottomFuncEnable.contains("merge") && !z) {
            ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "choose_state_merge_show", (List) null, 2, (Object) null);
        }
        FileSelectBottomItemView fileSelectBottomItemView2 = (FileSelectBottomItemView) _$_findCachedViewById(R.id.file_bottom_item_rename);
        Intrinsics.checkNotNullExpressionValue(fileSelectBottomItemView2, "file_bottom_item_rename");
        fileSelectBottomItemView2.setVisibility(calculateBottomFuncEnable.contains("rename") ? 0 : 8);
        FileSelectBottomItemView fileSelectBottomItemView3 = (FileSelectBottomItemView) _$_findCachedViewById(R.id.file_bottom_item_delete);
        Intrinsics.checkNotNullExpressionValue(fileSelectBottomItemView3, "file_bottom_item_delete");
        fileSelectBottomItemView3.setVisibility(calculateBottomFuncEnable.contains("delete") ? 0 : 8);
        FileSelectBottomItemView fileSelectBottomItemView4 = (FileSelectBottomItemView) _$_findCachedViewById(R.id.file_bottom_item_more);
        Intrinsics.checkNotNullExpressionValue(fileSelectBottomItemView4, "file_bottom_item_more");
        if (calculateBottomFuncEnable.contains("more")) {
            i2 = 0;
        }
        fileSelectBottomItemView4.setVisibility(i2);
    }

    public static /* synthetic */ void updateBottomFuncEnable$default(FileSelectModeFragment fileSelectModeFragment, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        fileSelectModeFragment.updateBottomFuncEnable(z);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public int getLayoutId() {
        return R.layout.fragment_file_select;
    }

    public final int getListScrollY() {
        return this.scrollYDistance;
    }

    @NotNull
    public final MainActivityViewModel getViewModel$app_main_aiscanConfigRelease() {
        MainActivityViewModel mainActivityViewModel = this.viewModel;
        if (mainActivityViewModel != null) {
            return mainActivityViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void initView(@NotNull Context context, @NotNull View view) {
        Set<Integer> uk2;
        Integer num;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        FragmentActivity activity = getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            View rootView = getRootView();
            if (rootView != null) {
                rootView.setOnClickListener(vvv.f8709ad);
            }
            this.fragmentRoot = (ViewGroup) view.findViewById(R.id.fl_file_select_root);
            this.fileSelectList = (RecyclerView) view.findViewById(R.id.rv_file_select_list);
            this.fileSelectClear = view.findViewById(R.id.ll_file_select_clear);
            this.fileSelectCountTextView = (TextView) view.findViewById(R.id.tv_file_select_count);
            this.fileSelectAll = view.findViewById(R.id.iv_file_select_all);
            this.fileBottomMerge = view.findViewById(R.id.file_bottom_item_merge);
            ((FrameLayout) _$_findCachedViewById(R.id.fl_file_select_bottom)).setOnClickListener(o.f8698ad);
            RecyclerView recyclerView = this.fileSelectList;
            if (recyclerView != null) {
                recyclerView.setAdapter(this.adapter);
            }
            RecyclerView recyclerView2 = this.fileSelectList;
            if (recyclerView2 != null) {
                fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder = getListHolder();
                recyclerView2.scrollToPosition((listHolder == null || (uk2 = listHolder.uk()) == null || (num = (Integer) CollectionsKt___CollectionsKt.firstOrNull(uk2)) == null) ? 0 : num.intValue());
            }
            View view2 = this.fileSelectClear;
            if (view2 != null) {
                view2.setOnClickListener(new xxx(this, mainActivity));
            }
            View view3 = this.fileSelectAll;
            if (view3 != null) {
                view3.setOnClickListener(new rg(this));
            }
            initBottomFunc();
            initData();
            setStatusBarState();
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        setViewModel$app_main_aiscanConfigRelease((MainActivityViewModel) new ViewModelProvider(requireActivity).get(MainActivityViewModel.class));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            setStatusBarState();
        }
    }

    public void onMoreMenuDeleteClick() {
        deleteSelectItem();
    }

    public void onMoreMenuSplitClick() {
        List<?> list = null;
        ScanAnalyticsBaseEvent.qw.qw(fe.mmm.qw.ggg.qw.qw, "choose_state_more_extract_click", (List) null, 2, (Object) null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            MainActivityViewModel viewModel$app_main_aiscanConfigRelease = getViewModel$app_main_aiscanConfigRelease();
            fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder = getListHolder();
            Set<Integer> uk2 = listHolder != null ? listHolder.uk() : null;
            fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder2 = getListHolder();
            if (listHolder2 != null) {
                list = listHolder2.de();
            }
            ArrayList<ScanRecordExportFile> selectPdfFiles = viewModel$app_main_aiscanConfigRelease.getSelectPdfFiles(uk2, list);
            if (!selectPdfFiles.isEmpty()) {
                PdfSplitActivity.Companion.qw(activity, (ScanRecordExportFile) CollectionsKt___CollectionsKt.first(selectPdfFiles));
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (isVisible()) {
            setStatusBarState();
        }
    }

    public final void setViewModel$app_main_aiscanConfigRelease(@NotNull MainActivityViewModel mainActivityViewModel) {
        Intrinsics.checkNotNullParameter(mainActivityViewModel, "<set-?>");
        this.viewModel = mainActivityViewModel;
    }

    public final void updateData(@NotNull Context context, @NotNull fe.mmm.qw.xxx.yj.g.qw.qw<?> qwVar, int i2, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(qwVar, "holder");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        MainFileListAdapter mainFileListAdapter = new MainFileListAdapter(context, qwVar, viewLifecycleOwner, true);
        String value = getViewModel$app_main_aiscanConfigRelease().getCurrentTab().getValue();
        if (Intrinsics.areEqual((Object) value, (Object) th.f8636rg.ad())) {
            str = "Rec_clk";
        } else {
            str = Intrinsics.areEqual((Object) value, (Object) th.f8636rg.qw()) ? "FileSel_clk" : "";
        }
        mainFileListAdapter.setOnItemSelect(new FileSelectModeFragment$updateData$1$1(this, str));
        mainFileListAdapter.setOnItemClick(new FileSelectModeFragment$updateData$1$2(this, str));
        mainFileListAdapter.setIndexPosition(i2);
        mainFileListAdapter.updateAndScroll(new FileSelectModeFragment$updateData$1$3(this, i3));
        this.adapter = mainFileListAdapter;
        RecyclerView recyclerView = this.fileSelectList;
        if (recyclerView != null) {
            recyclerView.setAdapter(mainFileListAdapter);
            recyclerView.scrollToPosition(i2);
            recyclerView.setVisibility(4);
            recyclerView.setBackgroundColor(0);
        }
        initData();
        fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder = getListHolder();
        if (listHolder != null) {
            listHolder.ggg();
        }
    }
}
