package com.tera.scan.main.file;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.baidu.aiscan.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayoutBehavior;
import com.tera.scan.account.OnLoginCallBack;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import com.tera.scan.main.MainActivity;
import com.tera.scan.main.file.dialog.FileSortDialog;
import com.tera.scan.main.fragment.MainFragmentScrollable;
import com.tera.scan.main.fragment.ScanBaseFragment;
import com.tera.scan.main.importfile.ImportDocFilesActivity;
import com.tera.scan.main.ui.fragment.FileTabEmptyFragment;
import com.tera.scan.main.ui.fragment.FileTabNotLoginFragment;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import com.tera.scan.permission.util.ManageAppAllFilesAccessHelper;
import com.tera.scan.ui.view.widget.UIImageView;
import com.tera.scan.ui.view.widget.UITextView;
import com.tera.scan.ui.view.widget.shadow.ShadowsKt;
import fe.mmm.qw.xxx.p032if.th.ad;
import fe.mmm.qw.xxx.th.de;
import fe.mmm.qw.xxx.th.fe;
import fe.mmm.qw.xxx.th.i;
import fe.mmm.qw.xxx.th.o;
import fe.mmm.qw.xxx.th.pf;
import fe.mmm.qw.xxx.th.uk;
import fe.mmm.qw.xxx.th.yj;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\"\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u00162\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'H\u0016J\u0006\u0010(\u001a\u00020\u0016J\b\u0010)\u001a\u00020\u0016H\u0002J-\u0010*\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00142\u000e\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050,2\u0006\u0010-\u001a\u00020.H\u0016¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020\u0016H\u0016J\u001a\u00101\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J(\u00102\u001a\u00020\u00162\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u000504j\b\u0012\u0004\u0012\u00020\u0005`52\u0006\u00106\u001a\u00020\u0005H\u0002J\u0010\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u0014H\u0016J\u0012\u00109\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010;\u001a\u00020\u0016H\u0002J\b\u0010<\u001a\u00020\u0016H\u0002J\b\u0010=\u001a\u00020\u0016H\u0002J\b\u0010>\u001a\u00020\u0016H\u0002J\b\u0010?\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011¨\u0006@"}, d2 = {"Lcom/tera/scan/main/file/FileFragment;", "Lcom/tera/scan/main/fragment/ScanBaseFragment;", "Lcom/tera/scan/main/fragment/MainFragmentScrollable;", "()V", "action", "", "allFilesAccessHelper", "Lcom/tera/scan/permission/util/ManageAppAllFilesAccessHelper;", "getAllFilesAccessHelper", "()Lcom/tera/scan/permission/util/ManageAppAllFilesAccessHelper;", "allFilesAccessHelper$delegate", "Lkotlin/Lazy;", "fragmentAllFile", "Lcom/tera/scan/main/file/FilePageInnerFragment;", "mainActivityViewModel", "Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "getMainActivityViewModel", "()Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "mainActivityViewModel$delegate", "getLayoutId", "", "goImportFilesPage", "", "initSubScribe", "initView", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onHiddenChanged", "hidden", "", "onHideLoginGuide", "onImportFilesClick", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onViewCreated", "openScanImageEditPage", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ubcSource", "scrollListTo", "scrollY", "setAction", "str", "setEmptyViewMaxDragOffset", "setNotEmptyViewMaxDragOffset", "setStatusBarState", "showEmptyView", "showFileList", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FileFragment extends ScanBaseFragment implements MainFragmentScrollable {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public String action;
    @NotNull
    public final Lazy allFilesAccessHelper$delegate = LazyKt__LazyJVMKt.lazy(new FileFragment$allFilesAccessHelper$2(this));
    @Nullable
    public FilePageInnerFragment fragmentAllFile;
    @NotNull
    public final Lazy mainActivityViewModel$delegate = LazyKt__LazyJVMKt.lazy(new FileFragment$mainActivityViewModel$2(this));

    public static final class qw implements OnLoginCallBack {
        public final /* synthetic */ FileFragment qw;

        public qw(FileFragment fileFragment) {
            this.qw = fileFragment;
        }

        public void ad() {
            this.qw.showFileList();
        }

        public void qw() {
            this.qw.showEmptyView();
        }
    }

    private final ManageAppAllFilesAccessHelper getAllFilesAccessHelper() {
        return (ManageAppAllFilesAccessHelper) this.allFilesAccessHelper$delegate.getValue();
    }

    private final MainActivityViewModel getMainActivityViewModel() {
        return (MainActivityViewModel) this.mainActivityViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void goImportFilesPage() {
        ImportDocFilesActivity.Companion.qw(getActivity());
    }

    private final void initSubScribe() {
        fe.mmm.qw.qw.qw.qw.de(new qw(this));
        getMainActivityViewModel().getAllFileLiveData().observe(getViewLifecycleOwner(), new pf(this));
        getMainActivityViewModel().getSortTypeLiveData().observe(getViewLifecycleOwner(), new uk(this));
        getMainActivityViewModel().getSortOrderLiveData().observe(getViewLifecycleOwner(), new o(this));
        getMainActivityViewModel().getFileSelectMode().observe(getViewLifecycleOwner(), new de(this));
    }

    /* renamed from: initSubScribe$lambda-0  reason: not valid java name */
    public static final void m765initSubScribe$lambda0(FileFragment fileFragment, List list) {
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        if (list.isEmpty()) {
            fileFragment.showEmptyView();
        } else {
            fileFragment.showFileList();
        }
    }

    /* renamed from: initSubScribe$lambda-1  reason: not valid java name */
    public static final void m766initSubScribe$lambda1(FileFragment fileFragment, Integer num) {
        int i2;
        Resources resources;
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        UITextView uITextView = (UITextView) fileFragment._$_findCachedViewById(R.id.tv_file_order);
        if (num != null && num.intValue() == 0) {
            resources = fileFragment.getResources();
            i2 = R.string.sort_by_create_time;
        } else {
            resources = fileFragment.getResources();
            i2 = R.string.sort_by_create_file_name;
        }
        uITextView.setText(resources.getText(i2));
    }

    /* renamed from: initSubScribe$lambda-2  reason: not valid java name */
    public static final void m767initSubScribe$lambda2(FileFragment fileFragment, Integer num) {
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        if (num != null && num.intValue() == 0) {
            ((UIImageView) fileFragment._$_findCachedViewById(R.id.iv_arrow_order)).setRotation(-180.0f);
        } else {
            ((UIImageView) fileFragment._$_findCachedViewById(R.id.iv_arrow_order)).setRotation(0.0f);
        }
    }

    /* renamed from: initSubScribe$lambda-3  reason: not valid java name */
    public static final void m768initSubScribe$lambda3(FileFragment fileFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        if (!bool.booleanValue() && fileFragment.isVisible()) {
            fileFragment.setStatusBarState();
        }
    }

    /* renamed from: initView$lambda-4  reason: not valid java name */
    public static final void m769initView$lambda4(FileFragment fileFragment, FragmentActivity fragmentActivity, View view) {
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        Intrinsics.checkNotNullParameter(fragmentActivity, "$activity");
        FileSortDialog fileSortDialog = new FileSortDialog(fileFragment.getMainActivityViewModel());
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        fileSortDialog.show(supportFragmentManager, "FileSortDialog");
    }

    /* renamed from: initView$lambda-5  reason: not valid java name */
    public static final void m770initView$lambda5(FileFragment fileFragment, View view) {
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        FilePageInnerFragment filePageInnerFragment = fileFragment.fragmentAllFile;
        if (filePageInnerFragment != null) {
            filePageInnerFragment.enterSelectFileMode();
        }
    }

    /* renamed from: initView$lambda-6  reason: not valid java name */
    public static final void m771initView$lambda6(FileFragment fileFragment, View view) {
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        fileFragment.onImportFilesClick();
        fe.mmm.qw.xxx.pf.de.ad("File_Docin_clk", "Homepage", (String) null, (Map) null, 12, (Object) null);
    }

    /* renamed from: initView$lambda-7  reason: not valid java name */
    public static final void m772initView$lambda7(FragmentActivity fragmentActivity, FileFragment fileFragment, View view) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "$activity");
        Intrinsics.checkNotNullParameter(fileFragment, "this$0");
        fileFragment.startActivityForResult(LocalImageSelectActivity.qw.ad(LocalImageSelectActivity.Companion, fragmentActivity, 20, 4500, 0, "File_picin", 8, (Object) null), 401);
        fe.mmm.qw.xxx.pf.de.ad("File_picin_clk", "Homepage", (String) null, (Map) null, 12, (Object) null);
    }

    private final void onImportFilesClick() {
        FragmentActivity activity = getActivity();
        if (activity != null && (activity instanceof MainActivity)) {
            ManageAppAllFilesAccessHelper allFilesAccessHelper = getAllFilesAccessHelper();
            if (allFilesAccessHelper != null) {
                allFilesAccessHelper.o(new FileFragment$onImportFilesClick$1(this));
            }
            ManageAppAllFilesAccessHelper allFilesAccessHelper2 = getAllFilesAccessHelper();
            if (allFilesAccessHelper2 != null) {
                allFilesAccessHelper2.i();
            }
        }
    }

    private final void openScanImageEditPage(ArrayList<String> arrayList, String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            new fe.mmm.qw.p024if.p025if.qw.qw().rg(activity, arrayList, 14, 0, new ArrayList(), 1, 0, "", "", str);
        }
    }

    /* JADX WARNING: type inference failed for: r1v8, types: [androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setEmptyViewMaxDragOffset() {
        /*
            r5 = this;
            r0 = 2131362496(0x7f0a02c0, float:1.8344774E38)
            android.view.View r1 = r5._$_findCachedViewById(r0)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            if (r1 == 0) goto L_0x0079
            int r1 = r1.getBottom()
            r2 = 2131362438(0x7f0a0286, float:1.8344657E38)
            android.view.View r2 = r5._$_findCachedViewById(r2)
            androidx.coordinatorlayout.widget.CoordinatorLayout r2 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r2
            int r2 = r2.getBottom()
            android.view.View r0 = r5._$_findCachedViewById(r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            if (r0 == 0) goto L_0x0043
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            int r4 = r0.getTop()
            if (r2 <= r4) goto L_0x0043
            int r4 = r0.getBottom()
            if (r2 <= r4) goto L_0x0043
            int r4 = r3.height
            if (r4 <= 0) goto L_0x0043
            int r4 = r0.getTop()
            int r4 = r2 - r4
            r3.height = r4
            r0.setLayoutParams(r3)
        L_0x0043:
            if (r1 >= r2) goto L_0x0047
            r0 = 0
            goto L_0x0049
        L_0x0047:
            int r0 = r2 - r1
        L_0x0049:
            r1 = 2131361909(0x7f0a0075, float:1.8343584E38)
            android.view.View r1 = r5._$_findCachedViewById(r1)
            com.google.android.material.appbar.AppBarLayout r1 = (com.google.android.material.appbar.AppBarLayout) r1
            r2 = 0
            if (r1 == 0) goto L_0x005a
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            goto L_0x005b
        L_0x005a:
            r1 = r2
        L_0x005b:
            boolean r3 = r1 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams
            if (r3 == 0) goto L_0x0062
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r1
            goto L_0x0063
        L_0x0062:
            r1 = r2
        L_0x0063:
            if (r1 == 0) goto L_0x0079
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r1 = r1.getBehavior()
            boolean r3 = r1 instanceof com.google.android.material.appbar.AppBarLayoutBehavior
            if (r3 == 0) goto L_0x0070
            r2 = r1
            com.google.android.material.appbar.AppBarLayoutBehavior r2 = (com.google.android.material.appbar.AppBarLayoutBehavior) r2
        L_0x0070:
            if (r2 == 0) goto L_0x0079
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.setMaxDragOffset(r0)
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.file.FileFragment.setEmptyViewMaxDragOffset():void");
    }

    private final void setNotEmptyViewMaxDragOffset() {
        AppBarLayout appBarLayout = (AppBarLayout) _$_findCachedViewById(R.id.app_bar_layout_file);
        ViewGroup.LayoutParams layoutParams = appBarLayout != null ? appBarLayout.getLayoutParams() : null;
        CoordinatorLayout.LayoutParams layoutParams2 = layoutParams instanceof CoordinatorLayout.LayoutParams ? (CoordinatorLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            CoordinatorLayout.Behavior behavior = layoutParams2.getBehavior();
            AppBarLayoutBehavior appBarLayoutBehavior = behavior instanceof AppBarLayoutBehavior ? (AppBarLayoutBehavior) behavior : null;
            if (appBarLayoutBehavior != null) {
                appBarLayoutBehavior.setMaxDragOffset((Integer) null);
            }
        }
    }

    private final void setStatusBarState() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ad.qw(activity, R.color.ui_color_gc4);
        }
    }

    /* access modifiers changed from: private */
    public final void showEmptyView() {
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.frame_file_content);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "frame_file_content");
        fe.mmm.qw.th.qw.rg.fe.de.qw.qw(frameLayout);
        FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(R.id.frame_empty);
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "frame_empty");
        fe.mmm.qw.th.qw.rg.fe.de.qw.fe(frameLayout2);
        ((UITextView) _$_findCachedViewById(R.id.tv_file_order)).setEnabled(false);
        ((UITextView) _$_findCachedViewById(R.id.tv_file_order)).getHelper().x(false);
        ((UIImageView) _$_findCachedViewById(R.id.iv_arrow_order)).setImageResource(R.drawable.icon_arrow_down2_disable);
        setEmptyViewMaxDragOffset();
        AppBarLayout appBarLayout = (AppBarLayout) _$_findCachedViewById(R.id.app_bar_layout_file);
        if (appBarLayout != null) {
            appBarLayout.setExpanded(true, true);
        }
        ((ImageView) _$_findCachedViewById(R.id.iv_file_select_mode)).setEnabled(false);
        ((ImageView) _$_findCachedViewById(R.id.iv_file_select_mode)).setImageResource(R.drawable.icon_file_select_disable);
        getChildFragmentManager().beginTransaction().replace(R.id.frame_empty, fe.mmm.qw.qw.qw.qw.pf() ? new FileTabEmptyFragment() : new FileTabNotLoginFragment()).commitAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public final void showFileList() {
        if (!fe.mmm.qw.qw.qw.qw.pf()) {
            showEmptyView();
            return;
        }
        ((UITextView) _$_findCachedViewById(R.id.tv_file_order)).setEnabled(true);
        ((UITextView) _$_findCachedViewById(R.id.tv_file_order)).getHelper().x(true);
        ((UIImageView) _$_findCachedViewById(R.id.iv_arrow_order)).setImageResource(R.drawable.icon_arrow_down2);
        ((ImageView) _$_findCachedViewById(R.id.iv_file_select_mode)).setEnabled(true);
        ((ImageView) _$_findCachedViewById(R.id.iv_file_select_mode)).setImageResource(R.drawable.icon_file_select);
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.frame_file_content);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "frame_file_content");
        fe.mmm.qw.th.qw.rg.fe.de.qw.fe(frameLayout);
        FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(R.id.frame_empty);
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "frame_empty");
        fe.mmm.qw.th.qw.rg.fe.de.qw.qw(frameLayout2);
        setNotEmptyViewMaxDragOffset();
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
        return R.layout.fragment_file;
    }

    public void initView(@NotNull Context context, @NotNull View view) {
        FilePageInnerFragment filePageInnerFragment;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        FragmentActivity activity = getActivity();
        if (activity != null && (filePageInnerFragment = this.fragmentAllFile) != null) {
            ((LinearLayout) _$_findCachedViewById(R.id.switch_file_fragment)).setVisibility(8);
            ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.home_import_buttons_layout);
            constraintLayout.setPadding(constraintLayout.getPaddingLeft(), 0, constraintLayout.getPaddingRight(), constraintLayout.getPaddingBottom());
            getChildFragmentManager().beginTransaction().replace(R.id.frame_file_content, filePageInnerFragment).commit();
            ((UITextView) _$_findCachedViewById(R.id.tv_file_order)).setTypeface(Typeface.DEFAULT_BOLD);
            ((UITextView) _$_findCachedViewById(R.id.tv_file_order)).setOnClickListener(new fe(this, activity));
            ((ImageView) _$_findCachedViewById(R.id.iv_file_select_mode)).setOnClickListener(new fe.mmm.qw.xxx.th.qw(this));
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.import_file_layout);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "import_file_layout");
            ShadowsKt.qw(linearLayout, getResources().getColor(R.color.home_import_button_shadow_color), getResources().getDimension(R.dimen.dimen_16dp));
            ((LinearLayout) _$_findCachedViewById(R.id.import_file_layout)).setOnClickListener(new i(this));
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.import_image_layout);
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "import_image_layout");
            ShadowsKt.qw(linearLayout2, getResources().getColor(R.color.home_import_button_shadow_color), getResources().getDimension(R.dimen.dimen_16dp));
            ((LinearLayout) _$_findCachedViewById(R.id.import_image_layout)).setOnClickListener(new yj(activity, this));
            setStatusBarState();
        }
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 401) {
            if (intent != null) {
                if (i3 == -1) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("extra_result_files");
                    String stringExtra = intent.getStringExtra("extra_ubc_source");
                    if (stringExtra == null) {
                        stringExtra = "";
                    }
                    boolean z = false;
                    if (stringArrayListExtra != null && (!stringArrayListExtra.isEmpty())) {
                        z = true;
                    }
                    if (z) {
                        openScanImageEditPage(stringArrayListExtra, stringExtra);
                    }
                }
            } else {
                return;
            }
        }
        ManageAppAllFilesAccessHelper allFilesAccessHelper = getAllFilesAccessHelper();
        if (allFilesAccessHelper != null) {
            allFilesAccessHelper.yj(i2, i3, intent);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getMainActivityViewModel().initScanRecordList();
        this.fragmentAllFile = new FilePageInnerFragment();
        fe.mmm.qw.xxx.pf.de.fe("File", "Homepage", (String) null, (Map) null, 12, (Object) null);
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

    public final void onHideLoginGuide() {
    }

    public void onRequestPermissionsResult(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        ManageAppAllFilesAccessHelper allFilesAccessHelper = getAllFilesAccessHelper();
        if (allFilesAccessHelper != null) {
            allFilesAccessHelper.uk(i2, strArr, iArr);
        }
    }

    public void onResume() {
        super.onResume();
        if (!isHidden()) {
            getMainActivityViewModel().isInFileSelectMode();
        }
        if (isVisible()) {
            setStatusBarState();
        }
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initSubScribe();
    }

    public void scrollListTo(int i2) {
        FilePageInnerFragment filePageInnerFragment = this.fragmentAllFile;
        if (!(filePageInnerFragment instanceof MainFragmentScrollable)) {
            filePageInnerFragment = null;
        }
        if (filePageInnerFragment != null) {
            filePageInnerFragment.scrollListTo(i2);
        }
    }

    public void setAction(@Nullable String str) {
        this.action = str;
    }
}
