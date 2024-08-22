package com.baidu.searchbox.bigimage.comp.relatedlist.bottomroot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bigimage.R;
import com.baidu.searchbox.bigimage.comp.common.ILayerStateOwner;
import com.baidu.searchbox.bigimage.comp.common.LayerState;
import com.baidu.searchbox.bigimage.comp.page.image.tab.RelatedTabComp;
import com.baidu.searchbox.bigimage.comp.page.image.tab.RelatedTabVM;
import com.baidu.searchbox.bigimage.comp.page.image.tab.TabType;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.comp.relatedlist.bottomroot.itemlist.BottomItemListComp;
import com.baidu.searchbox.bigimage.comp.relatedlist.event.LoadMoreRequestEvent;
import com.baidu.searchbox.bigimage.comp.relatedlist.event.RecommendModelChangeEvent;
import com.baidu.searchbox.bigimage.comp.relatedlist.repo.ComposedList;
import com.baidu.searchbox.bigimage.comp.relatedsearch.RelatedSearchComp;
import com.baidu.searchbox.bigimage.stat.helper.PageHeightStatHelper;
import com.baidu.searchbox.bigimage.utils.BigImageAbtestUtil;
import com.baidu.searchbox.bigimage.utils.BigImageTcUtilsKt;
import com.baidu.searchbox.bigimage.utils.OnSelectChangeListener;
import com.baidu.searchbox.bigimage.widget.CustomScrollViewPager;
import com.baidu.searchbox.nacomp.extension.base.BaseExtSlaveComponent;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeExtKt;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.nacomp.extension.util.RecyclerViewHelper;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001%\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010:\u001a\u00020!2\u0006\u00109\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010;\u001a\u00020!2\u0006\u00109\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010<\u001a\u00020!2\u0006\u00109\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010=\u001a\u00020!2\u0006\u00109\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010>\u001a\u00020!2\u0006\u00109\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010?\u001a\u00020!2\u0006\u00109\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010@\u001a\u00020!2\u0006\u00109\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010A\u001a\u00020!2\u0006\u00109\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\n\u0010B\u001a\u0004\u0018\u00010CH\u0007J\u0010\u0010D\u001a\u00020!2\u0006\u0010E\u001a\u00020FH\u0007J\b\u0010G\u001a\u00020!H\u0002J\b\u0010H\u001a\u00020\u0012H\u0007J\u0018\u0010I\u001a\u00020!2\u0006\u00109\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010J\u001a\u00020!H\u0016J\b\u0010K\u001a\u00020\u0002H\u0016J\b\u0010L\u001a\u00020!H\u0016J\u0010\u0010M\u001a\u00020!2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020!2\u0006\u0010Q\u001a\u00020\u0012H\u0016J\u0018\u0010R\u001a\u00020!2\u0006\u0010S\u001a\u00020\u00122\u0006\u0010T\u001a\u00020\u0012H\u0016J\b\u0010U\u001a\u00020!H\u0007J\b\u0010V\u001a\u00020!H\u0002J\b\u0010W\u001a\u00020!H\u0007J\u0010\u0010X\u001a\u00020!2\u0006\u0010Y\u001a\u00020FH\u0002R\u0016\u0010\u000f\u001a\n \u0010*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R4\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00162\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\n \u0010*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u0010\u0010$\u001a\u00020%X\u0004¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\n \u0010*\u0004\u0018\u00010,0,X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\n \u0010*\u0004\u0018\u00010.0.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u000201X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006Z"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/relatedlist/bottomroot/BottomRootComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtSlaveComponent;", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/bottomroot/BottomRootViewModel;", "Lcom/baidu/searchbox/bigimage/utils/OnSelectChangeListener;", "Lcom/baidu/searchbox/bigimage/comp/common/ILayerStateOwner;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "rootToken", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "pageToken", "params", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/nacomp/util/UniqueId;Lcom/baidu/searchbox/nacomp/util/UniqueId;Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;)V", "emptyLayout", "kotlin.jvm.PlatformType", "hasInitErrViewOffset", "", "heightStatHelper", "Lcom/baidu/searchbox/bigimage/stat/helper/PageHeightStatHelper;", "value", "Lkotlin/Function0;", "isInBottomPage", "()Lkotlin/jvm/functions/Function0;", "setInBottomPage", "(Lkotlin/jvm/functions/Function0;)V", "layerState", "Lcom/baidu/searchbox/bigimage/comp/common/LayerState;", "getLayerState", "()Lcom/baidu/searchbox/bigimage/comp/common/LayerState;", "netWorkErrorLayout", "onScrollToTab", "", "getOnScrollToTab", "setOnScrollToTab", "pageChangeListener", "com/baidu/searchbox/bigimage/comp/relatedlist/bottomroot/BottomRootComp$pageChangeListener$1", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/bottomroot/BottomRootComp$pageChangeListener$1;", "pagerAdapter", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/bottomroot/BottomVPAdapter;", "rsComp", "Lcom/baidu/searchbox/bigimage/comp/relatedsearch/RelatedSearchComp;", "rsRv", "Landroidx/recyclerview/widget/RecyclerView;", "rsTitle", "Landroid/widget/TextView;", "selectedState", "tabComp", "Lcom/baidu/searchbox/bigimage/comp/page/image/tab/RelatedTabComp;", "getTabComp$lib_search_bigimage_release", "()Lcom/baidu/searchbox/bigimage/comp/page/image/tab/RelatedTabComp;", "viewPager", "Lcom/baidu/searchbox/bigimage/widget/CustomScrollViewPager;", "getViewPager$lib_search_bigimage_release", "()Lcom/baidu/searchbox/bigimage/widget/CustomScrollViewPager;", "bindInitData", "viewModel", "bindLoadInitialDataError", "bindLoadedData", "bindRs", "bindScrollLayoutVisibility", "bindShowEmpty", "bindShowNetworkError", "bindShowRs", "bindViewPagerVisibility", "getCurrentListComp", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/bottomroot/itemlist/BottomItemListComp;", "initErrViewOffset", "offset", "", "initHeightStatHelper", "isRelatedListInBottom", "onBindViewModel", "onCreate", "onCreateViewModel", "onDestroy", "onFontSizeChange", "info", "Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo;", "onNightModeChange", "isNightMode", "onSelectChanged", "oldState", "newState", "recyclerViewScrollToTabInFirst", "registerLoadMoreEvent", "scrollToTopWithoutAnim", "statTabClick", "pos", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomRootComp.kt */
public final class BottomRootComp extends BaseExtSlaveComponent<BottomRootViewModel> implements OnSelectChangeListener, ILayerStateOwner {
    private final View emptyLayout;
    private boolean hasInitErrViewOffset;
    private PageHeightStatHelper heightStatHelper;
    private Function0<Boolean> isInBottomPage;
    private final LayerState layerState = new LayerState("ListLayer");
    private final View netWorkErrorLayout;
    private Function0<Unit> onScrollToTab;
    private final BottomRootComp$pageChangeListener$1 pageChangeListener;
    private final UniqueId pageToken;
    /* access modifiers changed from: private */
    public final BottomVPAdapter pagerAdapter;
    private final ImagePageParams params;
    private final UniqueId rootToken;
    private final RelatedSearchComp rsComp;
    private final RecyclerView rsRv;
    private final TextView rsTitle;
    private boolean selectedState;
    private final RelatedTabComp tabComp;
    private final CustomScrollViewPager viewPager;

    public void onScrollStateChange(boolean selectState, int scrollState) {
        OnSelectChangeListener.DefaultImpls.onScrollStateChange(this, selectState, scrollState);
    }

    public void onScrollVisibleChange(boolean visibleState) {
        OnSelectChangeListener.DefaultImpls.onScrollVisibleChange(this, visibleState);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomRootComp(LifecycleOwner owner, View view2, UniqueId rootToken2, UniqueId pageToken2, ImagePageParams params2) {
        super(owner, view2, true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(rootToken2, "rootToken");
        Intrinsics.checkNotNullParameter(pageToken2, "pageToken");
        Intrinsics.checkNotNullParameter(params2, "params");
        this.rootToken = rootToken2;
        this.pageToken = pageToken2;
        this.params = params2;
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
        BottomVPAdapter bottomVPAdapter = new BottomVPAdapter(lifecycleOwner, params2, rootToken2, pageToken2);
        this.pagerAdapter = bottomVPAdapter;
        BottomRootComp$pageChangeListener$1 bottomRootComp$pageChangeListener$1 = new BottomRootComp$pageChangeListener$1(this);
        this.pageChangeListener = bottomRootComp$pageChangeListener$1;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        CustomScrollViewPager customScrollViewPager = new CustomScrollViewPager(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        CustomScrollViewPager $this$viewPager_u24lambda_u2d2 = customScrollViewPager;
        $this$viewPager_u24lambda_u2d2.setAdapter(bottomVPAdapter);
        $this$viewPager_u24lambda_u2d2.setOffscreenPageLimit(2);
        $this$viewPager_u24lambda_u2d2.setNestedScrollingEnabled(false);
        $this$viewPager_u24lambda_u2d2.setCanScroll(false);
        $this$viewPager_u24lambda_u2d2.setPadding(0, ViewExKt.getDp(7), 0, 0);
        ((FrameLayout) view2.findViewById(R.id.viewpagerLayout)).addView($this$viewPager_u24lambda_u2d2, -1, -1);
        $this$viewPager_u24lambda_u2d2.addOnPageChangeListener(bottomRootComp$pageChangeListener$1);
        this.viewPager = customScrollViewPager;
        View findViewById = view2.findViewById(R.id.relatedTab);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.relatedTab");
        RelatedTabComp relatedTabComp = new RelatedTabComp(owner, findViewById, params2);
        RelatedTabComp $this$tabComp_u24lambda_u2d3 = relatedTabComp;
        add($this$tabComp_u24lambda_u2d3);
        $this$tabComp_u24lambda_u2d3.setupWithViewPager(customScrollViewPager);
        this.tabComp = relatedTabComp;
        this.rsTitle = (TextView) view2.findViewById(R.id.rsTitle);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.bottomRsRv);
        this.rsRv = recyclerView;
        this.emptyLayout = view2.findViewById(R.id.emptyLayout);
        View findViewById2 = view2.findViewById(R.id.networkErrorLayout);
        this.netWorkErrorLayout = findViewById2;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "rsRv");
        this.rsComp = new RelatedSearchComp(owner, recyclerView, rootToken2, params2.getInvokeParams());
        ((BottomRootViewModel) getViewModel()).setParams(params2);
        ((BottomRootViewModel) getViewModel()).setRootToken$lib_search_bigimage_release(rootToken2);
        ((BottomRootViewModel) getViewModel()).setPageToken$lib_search_bigimage_release(pageToken2);
        findViewById2.setOnClickListener(new BottomRootComp$$ExternalSyntheticLambda10(this));
    }

    public final Function0<Unit> getOnScrollToTab() {
        return this.onScrollToTab;
    }

    public final void setOnScrollToTab(Function0<Unit> function0) {
        this.onScrollToTab = function0;
    }

    public final Function0<Boolean> isInBottomPage() {
        return this.isInBottomPage;
    }

    public final void setInBottomPage(Function0<Boolean> value) {
        this.isInBottomPage = value;
        this.pagerAdapter.setInBottomPage(value);
    }

    public final void scrollToTopWithoutAnim() {
        RecyclerView $this$scrollToTopWithoutAnim_u24lambda_u2d0;
        BottomItemListComp currentListComp = getCurrentListComp();
        if (currentListComp != null && ($this$scrollToTopWithoutAnim_u24lambda_u2d0 = currentListComp.getRecyclerView()) != null) {
            $this$scrollToTopWithoutAnim_u24lambda_u2d0.stopScroll();
            if ($this$scrollToTopWithoutAnim_u24lambda_u2d0.canScrollVertically(-1)) {
                RecyclerViewHelper.scrollToPosition($this$scrollToTopWithoutAnim_u24lambda_u2d0, 0);
            }
        }
    }

    public final void recyclerViewScrollToTabInFirst() {
        BottomItemListComp $this$recyclerViewScrollToTabInFirst_u24lambda_u2d1 = getCurrentListComp();
        if ($this$recyclerViewScrollToTabInFirst_u24lambda_u2d1 != null) {
            RecyclerView recyclerView = $this$recyclerViewScrollToTabInFirst_u24lambda_u2d1.getRecyclerView();
            boolean z = false;
            if (recyclerView != null && recyclerView.canScrollVertically(-1)) {
                z = true;
            }
            if (z) {
                $this$recyclerViewScrollToTabInFirst_u24lambda_u2d1.setHasScrolled(true);
            }
            if (!$this$recyclerViewScrollToTabInFirst_u24lambda_u2d1.getHasScrolled()) {
                Function0<Unit> function0 = this.onScrollToTab;
                if (function0 != null) {
                    function0.invoke();
                }
                $this$recyclerViewScrollToTabInFirst_u24lambda_u2d1.setHasScrolled(true);
            }
        }
    }

    public final CustomScrollViewPager getViewPager$lib_search_bigimage_release() {
        return this.viewPager;
    }

    public final RelatedTabComp getTabComp$lib_search_bigimage_release() {
        return this.tabComp;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-4  reason: not valid java name */
    public static final void m16330_init_$lambda4(BottomRootComp this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((BottomRootViewModel) this$0.getViewModel()).loadInitialData();
    }

    public LayerState getLayerState() {
        return this.layerState;
    }

    public final void initErrViewOffset(int offset) {
        if (!this.hasInitErrViewOffset && ((NestedScrollView) getView().findViewById(R.id.scrollLayout)).getVisibility() == 0) {
            View view2 = this.netWorkErrorLayout;
            view2.setTranslationY(((float) (-offset)) + (((float) view2.getHeight()) / 2.0f));
            View view3 = this.emptyLayout;
            view3.setTranslationY(((float) (-offset)) + (((float) view3.getHeight()) / 2.0f));
            this.hasInitErrViewOffset = true;
        }
    }

    public final boolean isRelatedListInBottom() {
        return this.viewPager.getVisibility() == 0 && this.pagerAdapter.getCount() > 0;
    }

    public BottomRootViewModel onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get("BottomRootComp", BottomRootViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(\"BottomRoot…ootViewModel::class.java)");
        return (BottomRootViewModel) viewModel;
    }

    public void onBindViewModel(BottomRootViewModel viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        bindInitData(viewModel, owner);
        bindLoadInitialDataError(viewModel, owner);
        bindShowRs(viewModel, owner);
        bindRs(viewModel, owner);
        bindShowEmpty(viewModel, owner);
        bindShowNetworkError(viewModel, owner);
        bindLoadedData(viewModel, owner);
        bindScrollLayoutVisibility(viewModel, owner);
        bindViewPagerVisibility(viewModel, owner);
    }

    private final void bindScrollLayoutVisibility(BottomRootViewModel viewModel, LifecycleOwner owner) {
        viewModel.getShowScrollLayout$lib_search_bigimage_release().observe(owner, new BottomRootComp$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindScrollLayoutVisibility$lambda-5  reason: not valid java name */
    public static final void m16335bindScrollLayoutVisibility$lambda5(BottomRootComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((NestedScrollView) this$0.getView().findViewById(R.id.scrollLayout)).setVisibility(Intrinsics.areEqual((Object) it, (Object) true) ? 0 : 4);
    }

    private final void bindViewPagerVisibility(BottomRootViewModel viewModel, LifecycleOwner owner) {
        viewModel.getShowViewPager$lib_search_bigimage_release().observe(owner, new BottomRootComp$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindViewPagerVisibility$lambda-6  reason: not valid java name */
    public static final void m16339bindViewPagerVisibility$lambda6(BottomRootComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CustomScrollViewPager customScrollViewPager = this$0.viewPager;
        int i2 = 0;
        if (Intrinsics.areEqual((Object) it, (Object) false)) {
            i2 = 8;
        }
        customScrollViewPager.setVisibility(i2);
    }

    private final void bindInitData(BottomRootViewModel viewModel, LifecycleOwner owner) {
        viewModel.getInitialData$lib_search_bigimage_release().observe(owner, new BottomRootComp$$ExternalSyntheticLambda7(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindInitData$lambda-8  reason: not valid java name */
    public static final void m16331bindInitData$lambda8(BottomRootComp this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BottomVPAdapter bottomVPAdapter = this$0.pagerAdapter;
        Intrinsics.checkNotNullExpressionValue(list, "list");
        bottomVPAdapter.setInitData$lib_search_bigimage_release(list);
        RelatedTabVM relatedTabVM = (RelatedTabVM) this$0.tabComp.getViewModel();
        Iterable<Pair> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Pair it : $this$map$iv) {
            destination$iv$iv.add((TabType) it.getFirst());
        }
        relatedTabVM.setModel((List) destination$iv$iv);
        this$0.initHeightStatHelper();
    }

    private final void initHeightStatHelper() {
        RecyclerView $this$initHeightStatHelper_u24lambda_u2d9;
        AppBarLayout appBarLayout = (AppBarLayout) getView().findViewById(R.id.appbarLayout);
        List recyclerViews = new ArrayList();
        int count = this.pagerAdapter.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            BottomItemListComp compByPos = this.pagerAdapter.getCompByPos(i2);
            if (!(compByPos == null || ($this$initHeightStatHelper_u24lambda_u2d9 = compByPos.getRecyclerView()) == null)) {
                recyclerViews.add($this$initHeightStatHelper_u24lambda_u2d9);
            }
        }
        if (appBarLayout != null && (!recyclerViews.isEmpty())) {
            this.heightStatHelper = new PageHeightStatHelper(this.params, appBarLayout, this.viewPager, recyclerViews);
        }
    }

    private final void bindLoadInitialDataError(BottomRootViewModel viewModel, LifecycleOwner owner) {
        viewModel.getLoadInitialDataError$lib_search_bigimage_release().observe(getLifecycleOwner(), new BottomRootComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindLoadInitialDataError$lambda-10  reason: not valid java name */
    public static final void m16332bindLoadInitialDataError$lambda10(BottomRootComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z = true;
        if (Intrinsics.areEqual((Object) true, (Object) it) && !NetWorkUtils.isConnected(this$0.getContext())) {
            Function0<Boolean> function0 = this$0.isInBottomPage;
            if (function0 == null || !function0.invoke().booleanValue()) {
                z = false;
            }
            if (z) {
                UniversalToast.makeText(this$0.getContext(), R.string.search_big_image_no_network).show();
            }
        }
    }

    private final void bindShowRs(BottomRootViewModel viewModel, LifecycleOwner owner) {
        viewModel.getShowRs$lib_search_bigimage_release().observe(owner, new BottomRootComp$$ExternalSyntheticLambda8(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindShowRs$lambda-11  reason: not valid java name */
    public static final void m16338bindShowRs$lambda11(BottomRootComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual((Object) it, (Object) true)) {
            this$0.rsTitle.setVisibility(0);
            this$0.rsComp.getView().setVisibility(0);
            return;
        }
        this$0.rsTitle.setVisibility(8);
        this$0.rsComp.getView().setVisibility(8);
    }

    private final void bindRs(BottomRootViewModel viewModel, LifecycleOwner owner) {
        viewModel.getRsData$lib_search_bigimage_release().observe(owner, new BottomRootComp$$ExternalSyntheticLambda6(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindRs$lambda-12  reason: not valid java name */
    public static final void m16334bindRs$lambda12(BottomRootComp this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.rsComp.updateData(it);
    }

    private final void bindShowEmpty(BottomRootViewModel viewModel, LifecycleOwner owner) {
        viewModel.getShowEmpty$lib_search_bigimage_release().observe(owner, new BottomRootComp$$ExternalSyntheticLambda9(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindShowEmpty$lambda-13  reason: not valid java name */
    public static final void m16336bindShowEmpty$lambda13(BottomRootComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual((Object) it, (Object) true)) {
            this$0.emptyLayout.setVisibility(0);
        } else {
            this$0.emptyLayout.setVisibility(8);
        }
    }

    private final void bindShowNetworkError(BottomRootViewModel viewModel, LifecycleOwner owner) {
        viewModel.getShowNetworkError$lib_search_bigimage_release().observe(owner, new BottomRootComp$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindShowNetworkError$lambda-14  reason: not valid java name */
    public static final void m16337bindShowNetworkError$lambda14(BottomRootComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual((Object) it, (Object) true)) {
            this$0.netWorkErrorLayout.setVisibility(0);
        } else {
            this$0.netWorkErrorLayout.setVisibility(8);
        }
    }

    private final void bindLoadedData(BottomRootViewModel viewModel, LifecycleOwner owner) {
        viewModel.getLoadedData$lib_search_bigimage_release().observe(owner, new BottomRootComp$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindLoadedData$lambda-15  reason: not valid java name */
    public static final void m16333bindLoadedData$lambda15(BottomRootComp this$0, ComposedList it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.selectedState && it != null) {
            BdEventBus.Companion.getDefault().post(new RecommendModelChangeEvent(it, this$0.params, this$0.rootToken));
        }
    }

    public void onCreate() {
        super.onCreate();
        registerLoadMoreEvent();
    }

    private final void registerLoadMoreEvent() {
        BdEventBus.Companion.getDefault().register(this, LoadMoreRequestEvent.class, new BottomRootComp$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerLoadMoreEvent$lambda-16  reason: not valid java name */
    public static final void m16340registerLoadMoreEvent$lambda16(BottomRootComp this$0, LoadMoreRequestEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual((Object) it.getPageToken(), (Object) this$0.pageToken)) {
            ((BottomRootViewModel) this$0.getViewModel()).loadMore(it.getTabType());
        }
    }

    public void onSelectChanged(boolean oldState, boolean newState) {
        OnSelectChangeListener.DefaultImpls.onSelectChanged(this, oldState, newState);
        if (newState) {
            ((BottomRootViewModel) getViewModel()).loadInitialData();
            BigImageAbtestUtil.INSTANCE.addSlideCount(this.rootToken);
            ComposedList $this$onSelectChanged_u24lambda_u2d17 = ((BottomRootViewModel) getViewModel()).getLoadedData$lib_search_bigimage_release().getValue();
            if ($this$onSelectChanged_u24lambda_u2d17 != null) {
                BdEventBus.Companion.getDefault().post(new RecommendModelChangeEvent($this$onSelectChanged_u24lambda_u2d17, this.params, this.rootToken));
            }
        }
        this.selectedState = newState;
    }

    public void onNightModeChange(boolean isNightMode) {
        super.onNightModeChange(isNightMode);
        this.pagerAdapter.onNightModeChange(isNightMode);
        ResWrapper.setTextColor(this.rsTitle, R.color.SC345);
        ResWrapper.setTextColor((TextView) this.emptyLayout.findViewById(R.id.bottomEmptyText), R.color.SC346);
        ResWrapper.setTextColor((TextView) this.netWorkErrorLayout.findViewById(R.id.bottomErrorText), R.color.SC346);
    }

    public void onFontSizeChange(FontSizeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        super.onFontSizeChange(info);
        this.pagerAdapter.onFontSizeChange(info);
        FontSizeExtKt.updateTextSize$default(this.rsTitle, 0, 1, (Object) null);
        FontSizeExtKt.updateTextSize$default((TextView) this.emptyLayout.findViewById(R.id.bottomEmptyText), 0, 1, (Object) null);
        FontSizeExtKt.updateTextSize$default((TextView) this.netWorkErrorLayout.findViewById(R.id.bottomErrorText), 0, 1, (Object) null);
    }

    public final BottomItemListComp getCurrentListComp() {
        return this.pagerAdapter.getCompByPos(this.viewPager.getCurrentItem());
    }

    /* access modifiers changed from: private */
    public final void statTabClick(int pos) {
        TabType tabType;
        switch (pos) {
            case 1:
                tabType = TabType.GOODS;
                break;
            case 2:
                tabType = TabType.IMAGES;
                break;
            default:
                tabType = TabType.ALL;
                break;
        }
        BigImageTcUtilsKt.bigImageTabClickEvent(this.params, tabType);
    }

    public void onDestroy() {
        super.onDestroy();
        BdEventBus.Companion.getDefault().unregister(this);
        this.viewPager.clearOnPageChangeListeners();
        PageHeightStatHelper pageHeightStatHelper = this.heightStatHelper;
        if (pageHeightStatHelper != null) {
            pageHeightStatHelper.onDestroy();
        }
    }
}
