package com.tera.scan.main.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.google.android.material.tabs.TabLayout;
import com.tera.scan.framework.kernel.architecture.ui.BaseFragment;
import com.tera.scan.main.ui.adapter.AllToolsAdapter;
import com.tera.scan.main.ui.adapter.RecyclerViewProvider;
import com.tera.scan.main.ui.view.shape.ShapeImageView;
import com.tera.scan.main.viewmodel.ScanAllToolFragmentViewModel;
import fe.mmm.qw.d.de.de;
import fe.mmm.qw.xxx.p032if.de.ad;
import fe.mmm.qw.xxx.p032if.de.fe;
import fe.mmm.qw.xxx.p032if.de.yj;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0003J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010!H\u0016J&\u0010$\u001a\u0004\u0018\u00010!2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001bH\u0016J\u001a\u0010,\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010-\u001a\u00020\u001bH\u0002J\b\u0010.\u001a\u00020\u001bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/tera/scan/main/ui/fragment/ScanAllToolFragment;", "Lcom/tera/scan/framework/kernel/architecture/ui/BaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tera/scan/main/ui/adapter/RecyclerViewProvider;", "()V", "allToolsAdapter", "Lcom/tera/scan/main/ui/adapter/AllToolsAdapter;", "bannerJumpUrl", "", "ivBack", "Landroid/widget/ImageView;", "ivBanner", "Lcom/tera/scan/main/ui/view/shape/ShapeImageView;", "ivBannerClose", "manager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "rlTool", "Landroidx/recyclerview/widget/RecyclerView;", "scanAllToolFragmentViewModel", "Lcom/tera/scan/main/viewmodel/ScanAllToolFragmentViewModel;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "createViewModel", "getLayoutId", "", "getRecyclerView", "hideBanner", "", "initObserve", "initRecycleView", "initTablayout", "initView", "view", "Landroid/view/View;", "onClick", "p0", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "prepareListener", "showBanner", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanAllToolFragment extends BaseFragment implements View.OnClickListener, RecyclerViewProvider {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public AllToolsAdapter allToolsAdapter;
    @NotNull
    public String bannerJumpUrl = "";
    @Nullable
    public ImageView ivBack;
    @Nullable
    public ShapeImageView ivBanner;
    @Nullable
    public ImageView ivBannerClose;
    @Nullable
    public LinearLayoutManager manager;
    @Nullable
    public RecyclerView rlTool;
    @Nullable
    public ScanAllToolFragmentViewModel scanAllToolFragmentViewModel;
    @Nullable
    public TabLayout tabLayout;

    public static final class qw implements TabLayout.OnTabSelectedListener {
        public final /* synthetic */ ScanAllToolFragment qw;

        public qw(ScanAllToolFragment scanAllToolFragment) {
            this.qw = scanAllToolFragment;
        }

        public void onTabReselected(@NotNull TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            LinearLayoutManager access$getManager$p = this.qw.manager;
            if (access$getManager$p != null) {
                access$getManager$p.scrollToPositionWithOffset(tab.getPosition(), 0);
            }
        }

        public void onTabSelected(@NotNull TabLayout.Tab tab) {
            TabLayout.Tab tabAt;
            Intrinsics.checkNotNullParameter(tab, "tab");
            LinearLayoutManager access$getManager$p = this.qw.manager;
            if (access$getManager$p != null) {
                access$getManager$p.scrollToPositionWithOffset(tab.getPosition(), 0);
            }
            TabLayout access$getTabLayout$p = this.qw.tabLayout;
            int tabCount = access$getTabLayout$p != null ? access$getTabLayout$p.getTabCount() : 0;
            if (tabCount >= 0) {
                int i2 = 0;
                while (true) {
                    TabLayout access$getTabLayout$p2 = this.qw.tabLayout;
                    View customView = (access$getTabLayout$p2 == null || (tabAt = access$getTabLayout$p2.getTabAt(i2)) == null) ? null : tabAt.getCustomView();
                    if (customView != null) {
                        customView.setSelected(i2 == tab.getPosition());
                    }
                    if (i2 != tabCount) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }

        public void onTabUnselected(@NotNull TabLayout.Tab tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
        }
    }

    private final ScanAllToolFragmentViewModel createViewModel() {
        return (ScanAllToolFragmentViewModel) new ViewModelProvider(this).get(ScanAllToolFragmentViewModel.class);
    }

    private final int getLayoutId() {
        return R.layout.fragment_scan_alltool;
    }

    private final void hideBanner() {
        ShapeImageView shapeImageView = this.ivBanner;
        if (shapeImageView != null) {
            shapeImageView.setVisibility(8);
        }
        ImageView imageView = this.ivBannerClose;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @SuppressLint({"InflateParams"})
    private final void initObserve() {
        LiveData<List<fe.mmm.qw.xxx.p032if.fe.qw>> allToolLiveData$app_main_aiscanConfigRelease;
        ScanAllToolFragmentViewModel createViewModel = createViewModel();
        this.scanAllToolFragmentViewModel = createViewModel;
        if (createViewModel != null && (allToolLiveData$app_main_aiscanConfigRelease = createViewModel.getAllToolLiveData$app_main_aiscanConfigRelease()) != null) {
            allToolLiveData$app_main_aiscanConfigRelease.observe(getViewLifecycleOwner(), new ad(this));
        }
    }

    /* renamed from: initObserve$lambda-3  reason: not valid java name */
    public static final void m829initObserve$lambda3(ScanAllToolFragment scanAllToolFragment, List list) {
        TabLayout tabLayout2;
        Intrinsics.checkNotNullParameter(scanAllToolFragment, "this$0");
        TabLayout tabLayout3 = scanAllToolFragment.tabLayout;
        if (tabLayout3 != null) {
            tabLayout3.removeAllTabs();
        }
        IntRange indices = list != null ? CollectionsKt__CollectionsKt.getIndices(list) : null;
        Intrinsics.checkNotNull(indices);
        int first = indices.getFirst();
        int last = indices.getLast();
        if (first <= last) {
            while (true) {
                fe.mmm.qw.xxx.p032if.fe.qw qwVar = (fe.mmm.qw.xxx.p032if.fe.qw) list.get(first);
                View inflate = LayoutInflater.from(scanAllToolFragment.getActivity()).inflate(R.layout.custom_tab, (ViewGroup) null);
                inflate.setOnClickListener(new fe(inflate, qwVar));
                View findViewById = inflate.findViewById(R.id.tab_text);
                Intrinsics.checkNotNullExpressionValue(findViewById, "customView.findViewById(R.id.tab_text)");
                ((TextView) findViewById).setText(qwVar.ad());
                TabLayout tabLayout4 = scanAllToolFragment.tabLayout;
                TabLayout.Tab newTab = tabLayout4 != null ? tabLayout4.newTab() : null;
                if (newTab != null) {
                    newTab.setCustomView(inflate);
                }
                if (!(newTab == null || (tabLayout2 = scanAllToolFragment.tabLayout) == null)) {
                    tabLayout2.addTab(newTab);
                }
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        AllToolsAdapter allToolsAdapter2 = new AllToolsAdapter(scanAllToolFragment);
        scanAllToolFragment.allToolsAdapter = allToolsAdapter2;
        RecyclerView recyclerView = scanAllToolFragment.rlTool;
        if (recyclerView != null) {
            recyclerView.setAdapter(allToolsAdapter2);
        }
        AllToolsAdapter allToolsAdapter3 = scanAllToolFragment.allToolsAdapter;
        if (allToolsAdapter3 != null) {
            allToolsAdapter3.setData(list);
        }
    }

    /* renamed from: initObserve$lambda-3$lambda-1  reason: not valid java name */
    public static final void m830initObserve$lambda3$lambda1(View view, fe.mmm.qw.xxx.p032if.fe.qw qwVar, View view2) {
        Intrinsics.checkNotNullParameter(qwVar, "$allFunctionInfoRes");
        ViewParent parent = view.getParent();
        View view3 = parent instanceof View ? (View) parent : null;
        if (view3 != null) {
            view3.performClick();
        }
        fe.mmm.qw.xxx.pf.ad.ad("ToolSwitch", "AllTools", (String) null, MapsKt__MapsKt.hashMapOf(TuplesKt.to("tab", qwVar.de())), 4, (Object) null);
    }

    private final void initRecycleView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.manager = linearLayoutManager;
        RecyclerView recyclerView = this.rlTool;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }

    private final void initTablayout() {
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 != null) {
            tabLayout2.setTabMode(0);
        }
    }

    private final void initView(View view) {
        this.tabLayout = (TabLayout) view.findViewById(R.id.table_layout);
        initTablayout();
        this.rlTool = (RecyclerView) view.findViewById(R.id.rl_tool);
        initRecycleView();
    }

    private final void prepareListener() {
        RecyclerView recyclerView;
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 != null) {
            tabLayout2.setTabTextColors(de.when().i(R.color.ui_color_gc2), de.when().i(R.color.ui_color_gc1));
        }
        TabLayout tabLayout3 = this.tabLayout;
        if (tabLayout3 != null) {
            tabLayout3.setSelectedTabIndicatorColor(de.when().i(R.color.ui_color_gc1));
        }
        TabLayout tabLayout4 = this.tabLayout;
        if (tabLayout4 != null) {
            tabLayout4.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new qw(this));
        }
        if (Build.VERSION.SDK_INT >= 23 && (recyclerView = this.rlTool) != null) {
            recyclerView.setOnScrollChangeListener(new yj(this));
        }
    }

    /* renamed from: prepareListener$lambda-5  reason: not valid java name */
    public static final void m831prepareListener$lambda5(ScanAllToolFragment scanAllToolFragment, View view, int i2, int i3, int i4, int i5) {
        TabLayout tabLayout2;
        Intrinsics.checkNotNullParameter(scanAllToolFragment, "this$0");
        LinearLayoutManager linearLayoutManager = scanAllToolFragment.manager;
        if (linearLayoutManager != null && (tabLayout2 = scanAllToolFragment.tabLayout) != null) {
            tabLayout2.setScrollPosition(linearLayoutManager.findFirstVisibleItemPosition(), 0.0f, true);
        }
    }

    private final void showBanner() {
        ShapeImageView shapeImageView = this.ivBanner;
        if (shapeImageView != null) {
            shapeImageView.setVisibility(0);
        }
        ImageView imageView = this.ivBannerClose;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
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

    @Nullable
    public RecyclerView getRecyclerView() {
        return this.rlTool;
    }

    public void onClick(@Nullable View view) {
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        initObserve();
        return layoutInflater.inflate(getLayoutId(), (ViewGroup) null, false);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onResume() {
        super.onResume();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView(view);
        prepareListener();
        ScanAllToolFragmentViewModel scanAllToolFragmentViewModel2 = this.scanAllToolFragmentViewModel;
        if (scanAllToolFragmentViewModel2 != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            scanAllToolFragmentViewModel2.loadScanAllToolData(viewLifecycleOwner);
        }
    }
}
