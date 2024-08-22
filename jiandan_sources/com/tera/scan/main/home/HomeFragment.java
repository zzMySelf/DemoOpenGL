package com.tera.scan.main.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayoutBehavior;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.account.OnLoginCallBack;
import com.tera.scan.file.selector.ui.LocalImageSelectActivity;
import com.tera.scan.main.MainActivity;
import com.tera.scan.main.fragment.ScanBaseFragment;
import com.tera.scan.main.ui.AllToolActivity;
import com.tera.scan.main.ui.fragment.FileTabEmptyFragment;
import com.tera.scan.main.ui.fragment.FileTabNotLoginFragment;
import com.tera.scan.main.ui.view.GridToolView;
import com.tera.scan.main.ui.view.shape.ShapeImageView;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import com.tera.scan.main.viewmodel.ScanHomeFragmentViewModel;
import com.tera.scan.permission.util.ManageAppAllFilesAccessHelper;
import com.tera.scan.ui.view.widget.shadow.ShadowsKt;
import com.tera.scan.widget.pinnedhead.PinnedHeaderItemDecoration;
import com.tera.scan.widget.swiperefresh.NetdiskSwipeRefreshLayout;
import fe.mmm.qw.xxx.pf.de;
import fe.mmm.qw.xxx.yj.a;
import fe.mmm.qw.xxx.yj.aaa;
import fe.mmm.qw.xxx.yj.c;
import fe.mmm.qw.xxx.yj.ddd;
import fe.mmm.qw.xxx.yj.eee;
import fe.mmm.qw.xxx.yj.fe;
import fe.mmm.qw.xxx.yj.pf;
import fe.mmm.qw.xxx.yj.rrr;
import fe.mmm.qw.xxx.yj.th;
import fe.rg.qw.rg;
import i.qw.Cif;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u00104\u001a\u000205H\u0002J\u001e\u00106\u001a\u0002052\u0006\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0002J:\u0010<\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010\u00172\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010A\u001a\u0004\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010?H\u0002J \u0010C\u001a\u0002052\u0006\u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u0002052\u0006\u0010I\u001a\u00020?H\u0002J\b\u0010J\u001a\u000208H\u0016J\u0010\u0010K\u001a\u0002052\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u000205H\u0002J\u0018\u0010O\u001a\u0002052\u0006\u0010L\u001a\u00020M2\u0006\u0010P\u001a\u00020\u0011H\u0016J\u0010\u0010Q\u001a\u0002052\u0006\u0010P\u001a\u00020\u0011H\u0002J\"\u0010R\u001a\u0002052\u0006\u0010S\u001a\u00020\u00172\u0006\u0010T\u001a\u00020?2\b\u0010B\u001a\u0004\u0018\u00010?H\u0002J\b\u0010U\u001a\u000205H\u0002J\"\u0010V\u001a\u0002052\u0006\u0010W\u001a\u0002082\u0006\u0010X\u001a\u0002082\b\u0010D\u001a\u0004\u0018\u00010YH\u0016J\u0012\u0010Z\u001a\u0002052\b\u0010P\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010[\u001a\u0002052\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J&\u0010^\u001a\u0004\u0018\u00010\u00112\u0006\u0010_\u001a\u00020`2\b\u0010a\u001a\u0004\u0018\u00010\u00132\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010b\u001a\u000205H\u0016J\u0010\u0010c\u001a\u0002052\u0006\u0010d\u001a\u00020GH\u0016J-\u0010e\u001a\u0002052\u0006\u0010W\u001a\u0002082\u000e\u0010f\u001a\n\u0012\u0006\b\u0001\u0012\u00020?0g2\u0006\u0010h\u001a\u00020iH\u0016¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u000205H\u0016J\b\u0010l\u001a\u000205H\u0002J(\u0010m\u001a\u0002052\u0016\u0010n\u001a\u0012\u0012\u0004\u0012\u00020?0oj\b\u0012\u0004\u0012\u00020?`p2\u0006\u0010q\u001a\u00020?H\u0002J\b\u0010r\u001a\u000205H\u0002J\b\u0010s\u001a\u000205H\u0002J \u0010t\u001a\u0002052\u0006\u0010T\u001a\u00020?2\u0006\u0010u\u001a\u00020?2\u0006\u0010v\u001a\u00020\u0017H\u0002J\b\u0010w\u001a\u000205H\u0002J\b\u0010x\u001a\u000205H\u0002J\b\u0010y\u001a\u000205H\u0002J\b\u0010z\u001a\u000205H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030 X.¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\r\u001a\u0004\b&\u0010'R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0002¢\u0006\f\n\u0004\b2\u0010\r\u001a\u0004\b0\u00101R\u0010\u00103\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006{"}, d2 = {"Lcom/tera/scan/main/home/HomeFragment;", "Lcom/tera/scan/main/fragment/ScanBaseFragment;", "Landroid/view/View$OnClickListener;", "()V", "adapter", "Lcom/tera/scan/main/home/MainFileListAdapter;", "all", "Lcom/tera/scan/main/ui/view/GridToolView;", "allFilesAccessHelper", "Lcom/tera/scan/permission/util/ManageAppAllFilesAccessHelper;", "getAllFilesAccessHelper", "()Lcom/tera/scan/permission/util/ManageAppAllFilesAccessHelper;", "allFilesAccessHelper$delegate", "Lkotlin/Lazy;", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "frameEmpty", "Landroid/view/View;", "homeRootLayout", "Landroid/view/ViewGroup;", "importFiles", "importImages", "kingkongExtraLarge", "Lcom/tera/scan/main/ui/view/shape/ShapeImageView;", "kingkongLarge", "kingkongMiddleFirst", "kingkongMiddlesecond", "kingkongSmall1", "kingkongSmall2", "kingkongSmall3", "kingkongSmall4", "listHolder", "Lcom/tera/scan/main/home/bean/listholder/BaseMainListHolder;", "loginCallback", "Lcom/tera/scan/account/OnLoginCallBack;", "logoVip", "mainActivityViewModel", "Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "getMainActivityViewModel", "()Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "mainActivityViewModel$delegate", "refreshLayout", "Lcom/tera/scan/widget/swiperefresh/NetdiskSwipeRefreshLayout;", "rvRecords", "Landroidx/recyclerview/widget/RecyclerView;", "rvRecordsHeader", "scanHomeFragmentViewModel", "Lcom/tera/scan/main/viewmodel/ScanHomeFragmentViewModel;", "getScanHomeFragmentViewModel", "()Lcom/tera/scan/main/viewmodel/ScanHomeFragmentViewModel;", "scanHomeFragmentViewModel$delegate", "titleAvatar", "appbarSlidingGradient", "", "bindDataByType", "type", "", "datas", "", "Lcom/tera/scan/main/ui/model/ScanServiceAreaItem;", "bindKingKongLarge", "shapeImageview", "iconUrl", "", "iconUrlDark", "jumpUrl", "evnetValue", "bindsmallTools", "data", "kingkongSmall", "isAllTool", "", "clickToolStatistics", "eventValue", "getLayoutId", "initFileListView", "context", "Landroid/content/Context;", "initSubscribes", "initView", "view", "initViewImportButtons", "jump", "shapeImageView", "url", "jumpAllTool", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "onDestroyView", "onHiddenChanged", "hidden", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "openImportDocFilesActivity", "openScanImageEditPage", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ubcSource", "refresh", "setEmptyViewMaxDragOffset", "setIconUrl", "iconDarkUrl", "iconImage", "setNotEmptyViewMaxDragOffset", "setStatusBarState", "showContentView", "showEmptyView", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment extends ScanBaseFragment implements View.OnClickListener {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public MainFileListAdapter adapter;
    @Nullable
    public GridToolView all;
    @NotNull
    public final Lazy allFilesAccessHelper$delegate = LazyKt__LazyJVMKt.lazy(new HomeFragment$allFilesAccessHelper$2(this));
    @Nullable
    public AppBarLayout appBarLayout;
    @Nullable
    public View frameEmpty;
    @Nullable
    public ViewGroup homeRootLayout;
    @Nullable
    public View importFiles;
    @Nullable
    public View importImages;
    @Nullable
    public ShapeImageView kingkongExtraLarge;
    @Nullable
    public ShapeImageView kingkongLarge;
    @Nullable
    public ShapeImageView kingkongMiddleFirst;
    @Nullable
    public ShapeImageView kingkongMiddlesecond;
    @Nullable
    public GridToolView kingkongSmall1;
    @Nullable
    public GridToolView kingkongSmall2;
    @Nullable
    public GridToolView kingkongSmall3;
    @Nullable
    public GridToolView kingkongSmall4;
    public fe.mmm.qw.xxx.yj.g.qw.qw<?> listHolder;
    @Nullable
    public OnLoginCallBack loginCallback;
    @Nullable
    public View logoVip;
    @NotNull
    public final Lazy mainActivityViewModel$delegate = LazyKt__LazyJVMKt.lazy(new HomeFragment$mainActivityViewModel$2(this));
    @Nullable
    public NetdiskSwipeRefreshLayout refreshLayout;
    @Nullable
    public RecyclerView rvRecords;
    @Nullable
    public View rvRecordsHeader;
    @NotNull
    public final Lazy scanHomeFragmentViewModel$delegate = LazyKt__LazyJVMKt.lazy(new HomeFragment$scanHomeFragmentViewModel$2(this));
    @Nullable
    public View titleAvatar;

    public static final class ad implements OnLoginCallBack {
        public final /* synthetic */ HomeFragment qw;

        public ad(HomeFragment homeFragment) {
            this.qw = homeFragment;
        }

        public void ad() {
            this.qw.showContentView();
        }

        public void qw() {
            this.qw.showEmptyView();
        }
    }

    public static final class qw implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ HomeFragment f6958ad;
        public int qw = -1;

        public qw(HomeFragment homeFragment) {
            this.f6958ad = homeFragment;
        }

        public void onOffsetChanged(@NotNull AppBarLayout appBarLayout, int i2) {
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            if (this.qw == -1) {
                this.qw = appBarLayout.getTotalScrollRange();
            }
            NetdiskSwipeRefreshLayout access$getRefreshLayout$p = this.f6958ad.refreshLayout;
            if (access$getRefreshLayout$p != null) {
                if (i2 == 0 && !access$getRefreshLayout$p.isEnabled()) {
                    access$getRefreshLayout$p.setEnabled(true);
                } else if (i2 != 0 && access$getRefreshLayout$p.isEnabled()) {
                    access$getRefreshLayout$p.setEnabled(false);
                }
            }
        }
    }

    private final void appbarSlidingGradient() {
        AppBarLayout appBarLayout2 = this.appBarLayout;
        if (appBarLayout2 != null) {
            appBarLayout2.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new qw(this));
        }
    }

    private final void bindDataByType(int i2, List<fe.mmm.qw.xxx.p032if.fe.ad> list) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4 && list.size() == 5) {
                        GridToolView gridToolView = this.kingkongSmall1;
                        if (gridToolView != null) {
                            bindsmallTools(list.get(0), gridToolView, false);
                        }
                        GridToolView gridToolView2 = this.kingkongSmall2;
                        if (gridToolView2 != null) {
                            bindsmallTools(list.get(1), gridToolView2, false);
                        }
                        GridToolView gridToolView3 = this.kingkongSmall3;
                        if (gridToolView3 != null) {
                            bindsmallTools(list.get(2), gridToolView3, false);
                        }
                        GridToolView gridToolView4 = this.kingkongSmall4;
                        if (gridToolView4 != null) {
                            bindsmallTools(list.get(3), gridToolView4, false);
                        }
                        GridToolView gridToolView5 = this.all;
                        if (gridToolView5 != null) {
                            bindsmallTools(list.get(4), gridToolView5, true);
                        }
                    }
                } else if (list.size() == 2) {
                    bindKingKongLarge(this.kingkongMiddleFirst, list.get(0).de(), list.get(0).ad(), list.get(0).fe(), list.get(0).qw());
                    bindKingKongLarge(this.kingkongMiddlesecond, list.get(1).de(), list.get(1).ad(), list.get(1).fe(), list.get(1).qw());
                }
            } else if (list.size() == 1) {
                bindKingKongLarge(this.kingkongLarge, list.get(0).de(), list.get(0).ad(), list.get(0).fe(), list.get(0).qw());
            }
        } else if (list.size() == 1) {
            bindKingKongLarge(this.kingkongExtraLarge, list.get(0).de(), list.get(0).ad(), list.get(0).fe(), list.get(0).qw());
        }
    }

    private final void bindKingKongLarge(ShapeImageView shapeImageView, String str, String str2, String str3, String str4) {
        if (shapeImageView != null) {
            if (!(str == null || str2 == null)) {
                setIconUrl(str, str2, shapeImageView);
            }
            if (str3 != null) {
                jump(shapeImageView, str3, str4);
            }
        }
    }

    private final void bindsmallTools(fe.mmm.qw.xxx.p032if.fe.ad adVar, GridToolView gridToolView, boolean z) {
        String rg2 = adVar.rg();
        if (rg2 != null) {
            gridToolView.setTitle(rg2);
        }
        String fe2 = adVar.fe();
        if (fe2 != null) {
            gridToolView.setJumpUrl(fe2);
        }
        String de2 = adVar.de();
        if (de2 != null) {
            gridToolView.setIconUrl(de2);
        }
        gridToolView.setOnClickListener(new fe(adVar, this));
    }

    /* renamed from: bindsmallTools$lambda-35  reason: not valid java name */
    public static final void m794bindsmallTools$lambda35(fe.mmm.qw.xxx.p032if.fe.ad adVar, HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(adVar, "$data");
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        String fe2 = adVar.fe();
        if (fe2 != null) {
            fe.mmm.qw.th.qw.fe.ad.qw.ad(fe2);
        }
        String qw2 = adVar.qw();
        if (qw2 != null) {
            homeFragment.clickToolStatistics(qw2);
        }
    }

    private final void clickToolStatistics(String str) {
        fe.mmm.qw.xxx.pf.ad.ad(str, "Homepage", (String) null, (Map) null, 12, (Object) null);
    }

    private final ManageAppAllFilesAccessHelper getAllFilesAccessHelper() {
        return (ManageAppAllFilesAccessHelper) this.allFilesAccessHelper$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final MainActivityViewModel getMainActivityViewModel() {
        return (MainActivityViewModel) this.mainActivityViewModel$delegate.getValue();
    }

    private final ScanHomeFragmentViewModel getScanHomeFragmentViewModel() {
        return (ScanHomeFragmentViewModel) this.scanHomeFragmentViewModel$delegate.getValue();
    }

    private final void initFileListView(Context context) {
        fe.mmm.qw.xxx.yj.g.qw.qw<?> qwVar;
        FragmentActivity activity = getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            fe.mmm.qw.xxx.yj.g.qw.qw<?> qwVar2 = this.listHolder;
            if (qwVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listHolder");
                qwVar = null;
            } else {
                qwVar = qwVar2;
            }
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            MainFileListAdapter mainFileListAdapter = new MainFileListAdapter(context, qwVar, viewLifecycleOwner, false, 8, (DefaultConstructorMarker) null);
            mainFileListAdapter.setOnItemSelect(new HomeFragment$initFileListView$1$1$1(this, mainActivity, mainFileListAdapter));
            mainFileListAdapter.setOnItemClick(new HomeFragment$initFileListView$1$1$2(mainFileListAdapter, mainActivity));
            this.adapter = mainFileListAdapter;
            RecyclerView recyclerView = this.rvRecords;
            if (recyclerView != null) {
                recyclerView.setAdapter(mainFileListAdapter);
            }
        }
        getScanHomeFragmentViewModel().getKingkongTypeLiveData$app_main_aiscanConfigRelease().observe(getViewLifecycleOwner(), new fe.mmm.qw.xxx.yj.qw(this));
    }

    /* renamed from: initFileListView$lambda-18  reason: not valid java name */
    public static final void m795initFileListView$lambda18(HomeFragment homeFragment, Map map) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(map, "it");
        for (Map.Entry entry : map.entrySet()) {
            homeFragment.bindDataByType(((Number) entry.getKey()).intValue(), (List) entry.getValue());
        }
    }

    private final void initSubscribes() {
        ad adVar = new ad(this);
        this.loginCallback = adVar;
        if (adVar != null) {
            fe.mmm.qw.qw.qw.qw.de(adVar);
        }
        fe.mmm.qw.xxx.yj.g.qw.qw<?> qwVar = this.listHolder;
        if (qwVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listHolder");
            qwVar = null;
        }
        qwVar.rg().observe(getViewLifecycleOwner(), new pf(this));
        getMainActivityViewModel().getFileSelectMode().observe(getViewLifecycleOwner(), new eee(this));
    }

    /* renamed from: initSubscribes$lambda-8  reason: not valid java name */
    public static final void m796initSubscribes$lambda8(HomeFragment homeFragment, List list) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        LoggerKt.d("HomeFragment 监听 收到 liveData 更新通知", "liveData_xx");
        if (list.isEmpty()) {
            homeFragment.showEmptyView();
        } else {
            homeFragment.showContentView();
        }
    }

    /* renamed from: initSubscribes$lambda-9  reason: not valid java name */
    public static final void m797initSubscribes$lambda9(HomeFragment homeFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        if (!bool.booleanValue() && homeFragment.isVisible()) {
            homeFragment.setStatusBarState();
        }
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m798initView$lambda0(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        FragmentActivity activity = homeFragment.getActivity();
        MainActivity mainActivity = activity instanceof MainActivity ? (MainActivity) activity : null;
        if (mainActivity != null) {
            mainActivity.openDrawer();
        }
        de.ad("HpPCntr_clk", "PCntr", (String) null, (Map) null, 12, (Object) null);
    }

    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m799initView$lambda1(Context context, HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        if (fe.mmm.qw.qw.qw.qw.pf()) {
            fe.mmm.qw.k.i.ad.fe(context, (String) null, "homepage", 2, (Object) null);
        } else {
            fe.mmm.qw.qw.qw.xxx(fe.mmm.qw.qw.qw.qw, homeFragment, (String) null, false, (Function1) null, 14, (Object) null);
        }
        fe.mmm.qw.k.ad.ad();
    }

    /* renamed from: initView$lambda-3  reason: not valid java name */
    public static final void m800initView$lambda3(HomeFragment homeFragment) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.refresh();
    }

    private final void initViewImportButtons(View view) {
        View findViewById = view.findViewById(R.id.import_file_layout);
        this.importFiles = findViewById;
        if (findViewById != null) {
            ShadowsKt.qw(findViewById, getResources().getColor(R.color.home_import_button_shadow_color), getResources().getDimension(R.dimen.dimen_16dp));
        }
        View view2 = this.importFiles;
        if (view2 != null) {
            view2.setOnClickListener(new rrr(this));
        }
        View findViewById2 = view.findViewById(R.id.import_image_layout);
        this.importImages = findViewById2;
        if (findViewById2 != null) {
            ShadowsKt.qw(findViewById2, getResources().getColor(R.color.home_import_button_shadow_color), getResources().getDimension(R.dimen.dimen_16dp));
        }
        View view3 = this.importImages;
        if (view3 != null) {
            view3.setOnClickListener(new ddd(this));
        }
    }

    /* renamed from: initViewImportButtons$lambda-4  reason: not valid java name */
    public static final void m801initViewImportButtons$lambda4(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.openImportDocFilesActivity();
        de.ad("Hp_Docin_clk", "Homepage", (String) null, (Map) null, 12, (Object) null);
    }

    /* renamed from: initViewImportButtons$lambda-6  reason: not valid java name */
    public static final void m802initViewImportButtons$lambda6(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        FragmentActivity activity = homeFragment.getActivity();
        if (activity != null) {
            LocalImageSelectActivity.qw.fe(LocalImageSelectActivity.Companion, activity, 20, 4500, BindVerifyActivity.w, 0, "Hp_picin", 16, (Object) null);
        }
        de.ad("Hp_picin_clk", "Homepage", (String) null, (Map) null, 12, (Object) null);
    }

    private final void jump(ShapeImageView shapeImageView, String str, String str2) {
        shapeImageView.setOnClickListener(new a(str, str2, this));
    }

    /* renamed from: jump$lambda-29  reason: not valid java name */
    public static final void m803jump$lambda29(String str, String str2, HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(str, "$url");
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        fe.mmm.qw.th.qw.fe.ad.qw.ad(str);
        if (str2 != null) {
            homeFragment.clickToolStatistics(str2);
        }
    }

    private final void jumpAllTool() {
        startActivity(new Intent(getContext(), AllToolActivity.class));
    }

    private final void openImportDocFilesActivity() {
        ManageAppAllFilesAccessHelper allFilesAccessHelper = getAllFilesAccessHelper();
        if (allFilesAccessHelper != null) {
            allFilesAccessHelper.o(new HomeFragment$openImportDocFilesActivity$1(this));
        }
        ManageAppAllFilesAccessHelper allFilesAccessHelper2 = getAllFilesAccessHelper();
        if (allFilesAccessHelper2 != null) {
            allFilesAccessHelper2.i();
        }
    }

    private final void openScanImageEditPage(ArrayList<String> arrayList, String str) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            new fe.mmm.qw.p024if.p025if.qw.qw().rg(activity, arrayList, 14, 0, new ArrayList(), 1, 0, "", "", str);
        }
    }

    private final void refresh() {
        Context context = getContext();
        if (context != null) {
            ScanHomeFragmentViewModel scanHomeFragmentViewModel = getScanHomeFragmentViewModel();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            scanHomeFragmentViewModel.loadScanHomeKingkongData(viewLifecycleOwner, context);
        }
        Job unused = Cif.fe(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new HomeFragment$refresh$2(this, (Continuation<? super HomeFragment$refresh$2>) null), 3, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r1v7, types: [androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setEmptyViewMaxDragOffset() {
        /*
            r5 = this;
            android.view.View r0 = r5.frameEmpty
            if (r0 == 0) goto L_0x0067
            int r0 = r0.getBottom()
            r1 = 2131362534(0x7f0a02e6, float:1.8344851E38)
            android.view.View r1 = r5._$_findCachedViewById(r1)
            androidx.coordinatorlayout.widget.CoordinatorLayout r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r1
            int r1 = r1.getBottom()
            android.view.View r2 = r5.frameEmpty
            if (r2 == 0) goto L_0x0038
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            int r4 = r2.getTop()
            if (r1 <= r4) goto L_0x0038
            int r4 = r2.getBottom()
            if (r1 <= r4) goto L_0x0038
            int r4 = r3.height
            if (r4 <= 0) goto L_0x0038
            int r4 = r2.getTop()
            int r4 = r1 - r4
            r3.height = r4
            r2.setLayoutParams(r3)
        L_0x0038:
            if (r0 >= r1) goto L_0x003c
            r0 = 0
            goto L_0x003e
        L_0x003c:
            int r0 = r1 - r0
        L_0x003e:
            com.google.android.material.appbar.AppBarLayout r1 = r5.appBarLayout
            r2 = 0
            if (r1 == 0) goto L_0x0048
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            goto L_0x0049
        L_0x0048:
            r1 = r2
        L_0x0049:
            boolean r3 = r1 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams
            if (r3 == 0) goto L_0x0050
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r1
            goto L_0x0051
        L_0x0050:
            r1 = r2
        L_0x0051:
            if (r1 == 0) goto L_0x0067
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r1 = r1.getBehavior()
            boolean r3 = r1 instanceof com.google.android.material.appbar.AppBarLayoutBehavior
            if (r3 == 0) goto L_0x005e
            r2 = r1
            com.google.android.material.appbar.AppBarLayoutBehavior r2 = (com.google.android.material.appbar.AppBarLayoutBehavior) r2
        L_0x005e:
            if (r2 == 0) goto L_0x0067
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.setMaxDragOffset(r0)
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.home.HomeFragment.setEmptyViewMaxDragOffset():void");
    }

    private final void setIconUrl(String str, String str2, ShapeImageView shapeImageView) {
        Context context = getContext();
        if (context != null) {
            fe.rg.qw.when.ad v = new fe.rg.qw.when.ad().w(R.drawable.background_gc9).o(R.drawable.background_gc9).pf(R.drawable.background_gc9).v(shapeImageView.getWidth(), shapeImageView.getHeight());
            Intrinsics.checkNotNullExpressionValue(v, "RequestOptions().placeho….width, iconImage.height)");
            rg<Drawable> vvv = fe.rg.qw.ad.mmm(context).vvv(str);
            vvv.de(v);
            vvv.m317switch(shapeImageView);
        }
    }

    private final void setNotEmptyViewMaxDragOffset() {
        AppBarLayout appBarLayout2 = this.appBarLayout;
        ViewGroup.LayoutParams layoutParams = appBarLayout2 != null ? appBarLayout2.getLayoutParams() : null;
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
            fe.mmm.qw.xxx.p032if.th.ad.qw(activity, R.color.ui_color_gc6);
        }
    }

    /* access modifiers changed from: private */
    public final void showContentView() {
        if (!fe.mmm.qw.qw.qw.qw.pf()) {
            showEmptyView();
            return;
        }
        setNotEmptyViewMaxDragOffset();
        View view = this.frameEmpty;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.rvRecordsHeader;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void showEmptyView() {
        View view = this.frameEmpty;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.rvRecordsHeader;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        AppBarLayout appBarLayout2 = this.appBarLayout;
        if (appBarLayout2 != null) {
            appBarLayout2.setExpanded(true, true);
        }
        try {
            ExpectKt.success(Integer.valueOf(getChildFragmentManager().beginTransaction().replace(R.id.frame_empty, fe.mmm.qw.qw.qw.qw.pf() ? new FileTabEmptyFragment() : new FileTabNotLoginFragment()).commitAllowingStateLoss()));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        new Handler(Looper.getMainLooper()).post(new th(this));
    }

    /* renamed from: showEmptyView$lambda-11  reason: not valid java name */
    public static final void m804showEmptyView$lambda11(HomeFragment homeFragment) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.setEmptyViewMaxDragOffset();
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
        return R.layout.fragment_home;
    }

    public void initView(@NotNull Context context, @NotNull View view) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        getMainActivityViewModel().initHomeData();
        this.listHolder = new fe.mmm.qw.xxx.yj.g.qw.fe(getMainActivityViewModel());
        this.kingkongExtraLarge = (ShapeImageView) view.findViewById(R.id.iv_kingkong_extra_large);
        this.kingkongLarge = (ShapeImageView) view.findViewById(R.id.iv_kingkong_large);
        this.kingkongMiddleFirst = (ShapeImageView) view.findViewById(R.id.iv_kingkong_middle_first);
        this.kingkongMiddlesecond = (ShapeImageView) view.findViewById(R.id.iv_kingkong_middle_second);
        this.kingkongSmall1 = (GridToolView) view.findViewById(R.id.gtv_kingkong_small1);
        this.kingkongSmall2 = (GridToolView) view.findViewById(R.id.gtv_kingkong_small2);
        this.kingkongSmall3 = (GridToolView) view.findViewById(R.id.gtv_kingkong_small3);
        this.kingkongSmall4 = (GridToolView) view.findViewById(R.id.gtv_kingkong_small4);
        this.all = (GridToolView) view.findViewById(R.id.gtv_kingkong_small5);
        this.rvRecords = (RecyclerView) view.findViewById(R.id.rv_records);
        this.rvRecordsHeader = view.findViewById(R.id.record_list_header);
        this.homeRootLayout = (ViewGroup) view.findViewById(R.id.home_root);
        View findViewById = view.findViewById(R.id.title_avatar);
        this.titleAvatar = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new aaa(this));
        }
        View findViewById2 = view.findViewById(R.id.logo_vip);
        this.logoVip = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new c(context, this));
        }
        fe.mmm.qw.k.ad.de();
        RecyclerView recyclerView2 = this.rvRecords;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        if (!(getActivity() == null || (recyclerView = this.rvRecords) == null)) {
            recyclerView.addItemDecoration(new PinnedHeaderItemDecoration());
        }
        this.appBarLayout = (AppBarLayout) view.findViewById(R.id.app_bar_layout);
        this.frameEmpty = view.findViewById(R.id.frame_empty);
        appbarSlidingGradient();
        NetdiskSwipeRefreshLayout netdiskSwipeRefreshLayout = (NetdiskSwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        this.refreshLayout = netdiskSwipeRefreshLayout;
        if (netdiskSwipeRefreshLayout != null) {
            netdiskSwipeRefreshLayout.setNestedScrollingEnabled(true);
        }
        NetdiskSwipeRefreshLayout netdiskSwipeRefreshLayout2 = this.refreshLayout;
        if (netdiskSwipeRefreshLayout2 != null) {
            netdiskSwipeRefreshLayout2.setOnRefreshListener(new fe.mmm.qw.xxx.yj.de(this));
        }
        NetdiskSwipeRefreshLayout netdiskSwipeRefreshLayout3 = this.refreshLayout;
        if (netdiskSwipeRefreshLayout3 != null) {
            netdiskSwipeRefreshLayout3.setText(getString(R.string.home_refresh_text));
        }
        initViewImportButtons(view);
        initFileListView(context);
        setStatusBarState();
        initSubscribes();
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        String str;
        super.onActivityResult(i2, i3, intent);
        ManageAppAllFilesAccessHelper allFilesAccessHelper = getAllFilesAccessHelper();
        if (allFilesAccessHelper != null) {
            allFilesAccessHelper.yj(i2, i3, intent);
        }
        if (i2 == 203 && i3 == -1) {
            ArrayList<String> stringArrayListExtra = intent != null ? intent.getStringArrayListExtra("extra_result_files") : null;
            if (intent == null || (str = intent.getStringExtra("extra_ubc_source")) == null) {
                str = "";
            }
            boolean z = false;
            if (stringArrayListExtra != null && (!stringArrayListExtra.isEmpty())) {
                z = true;
            }
            if (z) {
                openScanImageEditPage(stringArrayListExtra, str);
            }
        }
    }

    public void onClick(@Nullable View view) {
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        de.fe("Homepage", "Homepage", (String) null, (Map) null, 12, (Object) null);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context context = getContext();
        if (context != null) {
            ScanHomeFragmentViewModel scanHomeFragmentViewModel = getScanHomeFragmentViewModel();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            scanHomeFragmentViewModel.loadScanHomeKingkongData(viewLifecycleOwner, context);
        }
        FragmentActivity activity = getActivity();
        if (!(activity == null || (applicationContext = activity.getApplicationContext()) == null)) {
            getScanHomeFragmentViewModel().observerScanRecordDataChange(applicationContext);
        }
        return layoutInflater.inflate(getLayoutId(), (ViewGroup) null, false);
    }

    public void onDestroyView() {
        super.onDestroyView();
        OnLoginCallBack onLoginCallBack = this.loginCallback;
        if (onLoginCallBack != null) {
            fe.mmm.qw.qw.qw.qw.ggg(onLoginCallBack);
        }
        this.loginCallback = null;
        _$_clearFindViewByIdCache();
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            setStatusBarState();
        }
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
        StringBuilder sb = new StringBuilder();
        sb.append("importImages ");
        View view = this.importImages;
        sb.append(view != null ? view.hashCode() : 0);
        LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
        if (isVisible()) {
            setStatusBarState();
        }
    }
}
