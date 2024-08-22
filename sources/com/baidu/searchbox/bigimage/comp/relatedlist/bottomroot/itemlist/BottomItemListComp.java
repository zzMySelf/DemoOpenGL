package com.baidu.searchbox.bigimage.comp.relatedlist.bottomroot.itemlist;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.connect.NetWorkUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bigimage.R;
import com.baidu.searchbox.bigimage.comp.page.image.ImageHelperKt;
import com.baidu.searchbox.bigimage.comp.page.image.tab.TabType;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.comp.relatedlist.bottomroot.memopt.ListMemOptComp;
import com.baidu.searchbox.bigimage.comp.relatedlist.event.LoadMoreRequestEvent;
import com.baidu.searchbox.bigimage.comp.relatedlist.event.LoadMoreResultEvent;
import com.baidu.searchbox.bigimage.comp.relatedlist.event.RelatedGoodsJumpEvent;
import com.baidu.searchbox.bigimage.comp.relatedlist.event.RelatedPicJumpEvent;
import com.baidu.searchbox.bigimage.comp.relatedlist.item.goods.RelatedGoodItemViewAdapter;
import com.baidu.searchbox.bigimage.comp.relatedlist.item.pairavatar.PairAvatarItemAdapter;
import com.baidu.searchbox.bigimage.comp.relatedlist.item.piclist.PicCollectionItemViewAdapter;
import com.baidu.searchbox.bigimage.comp.relatedlist.item.rs.RsItemViewAdapter;
import com.baidu.searchbox.bigimage.comp.relatedlist.item.singlepic.PicItemViewAdapter;
import com.baidu.searchbox.bigimage.comp.relatedlist.repo.ComposedList;
import com.baidu.searchbox.bigimage.utils.OnSelectChangeListener;
import com.baidu.searchbox.bigimage.view.BigImageMorePicLayoutManager;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.nacomp.extension.base.BaseExtRVComponent;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.baidu.searchbox.nacomp.extension.widget.ptr.PullToRefreshRecyclerView;
import com.baidu.searchbox.nacomp.extension.widget.ptr.StateTextBuilder;
import com.baidu.searchbox.nacomp.mvvm.impl.LifecycleComponent;
import com.baidu.searchbox.nacomp.mvvm.impl.ViewModelProviders;
import com.baidu.searchbox.nacomp.recycler.delegate.DelegatorAdapter;
import com.baidu.searchbox.nacomp.recycler.delegate.IAdapterData;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010'\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020$H\u0002J\u0018\u0010)\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020$H\u0016J\b\u0010+\u001a\u00020,H\u0014J\u0010\u0010-\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020$H\u0016J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0007H\u0014J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u000205H\u0014J\u0018\u00106\u001a\u00020$2\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u0011H\u0016J\b\u00109\u001a\u00020$H\u0002R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/relatedlist/bottomroot/itemlist/BottomItemListComp;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtRVComponent;", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/bottomroot/itemlist/BottomItemListVM;", "Lcom/baidu/searchbox/bigimage/utils/OnSelectChangeListener;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "view", "Landroid/view/View;", "params", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "tabType", "Lcom/baidu/searchbox/bigimage/comp/page/image/tab/TabType;", "rootToken", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "pageToken", "(Landroidx/lifecycle/LifecycleOwner;Landroid/view/View;Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;Lcom/baidu/searchbox/bigimage/comp/page/image/tab/TabType;Lcom/baidu/searchbox/nacomp/util/UniqueId;Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "hasScrolled", "", "getHasScrolled", "()Z", "setHasScrolled", "(Z)V", "isInBottomPage", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "setInBottomPage", "(Lkotlin/jvm/functions/Function0;)V", "memOptComp", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/bottomroot/memopt/ListMemOptComp;", "ptrRecyclerView", "Lcom/baidu/searchbox/nacomp/extension/widget/ptr/PullToRefreshRecyclerView;", "getPtrRecyclerView", "()Lcom/baidu/searchbox/nacomp/extension/widget/ptr/PullToRefreshRecyclerView;", "getTabType", "()Lcom/baidu/searchbox/bigimage/comp/page/image/tab/TabType;", "bindHasMore", "", "viewModel", "bindInitDataLoaded", "observeGoodsItemJump", "observePicItemJump", "onBindViewModel", "onCreate", "onCreateLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "onCreateView", "onCreateViewModel", "onDestroy", "onFindRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rootView", "onRegisterDelegates", "delegator", "Lcom/baidu/searchbox/nacomp/recycler/delegate/DelegatorAdapter;", "onSelectChanged", "oldState", "newState", "registerLoadMoreResultEvent", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomItemListComp.kt */
public final class BottomItemListComp extends BaseExtRVComponent<BottomItemListVM> implements OnSelectChangeListener {
    private boolean hasScrolled;
    private Function0<Boolean> isInBottomPage;
    private final ListMemOptComp memOptComp;
    private final UniqueId pageToken;
    private final PullToRefreshRecyclerView ptrRecyclerView;
    /* access modifiers changed from: private */
    public final UniqueId rootToken;
    private final TabType tabType;

    public void onScrollStateChange(boolean selectState, int scrollState) {
        OnSelectChangeListener.DefaultImpls.onScrollStateChange(this, selectState, scrollState);
    }

    public void onScrollVisibleChange(boolean visibleState) {
        OnSelectChangeListener.DefaultImpls.onScrollVisibleChange(this, visibleState);
    }

    public final TabType getTabType() {
        return this.tabType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomItemListComp(LifecycleOwner owner, View view2, ImagePageParams params, TabType tabType2, UniqueId rootToken2, UniqueId pageToken2) {
        super(owner, view2, true);
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(tabType2, MultiTabItemInfo.KEY_TAB_TYPE);
        Intrinsics.checkNotNullParameter(rootToken2, "rootToken");
        Intrinsics.checkNotNullParameter(pageToken2, "pageToken");
        this.tabType = tabType2;
        this.rootToken = rootToken2;
        this.pageToken = pageToken2;
        PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view2.findViewById(R.id.ptrRv);
        Intrinsics.checkNotNullExpressionValue(pullToRefreshRecyclerView, "view.ptrRv");
        this.ptrRecyclerView = pullToRefreshRecyclerView;
        ListMemOptComp $this$memOptComp_u24lambda_u2d0 = new ListMemOptComp(owner, view2, tabType2);
        add($this$memOptComp_u24lambda_u2d0);
        this.memOptComp = $this$memOptComp_u24lambda_u2d0;
        ((BottomItemListVM) getViewModel()).setImageParams$lib_search_bigimage_release(params);
        ((BottomItemListVM) getViewModel()).setRootToken$lib_search_bigimage_release(rootToken2);
    }

    public final boolean getHasScrolled() {
        return this.hasScrolled;
    }

    public final void setHasScrolled(boolean z) {
        this.hasScrolled = z;
    }

    public final PullToRefreshRecyclerView getPtrRecyclerView() {
        return this.ptrRecyclerView;
    }

    public final Function0<Boolean> isInBottomPage() {
        return this.isInBottomPage;
    }

    public final void setInBottomPage(Function0<Boolean> function0) {
        this.isInBottomPage = function0;
    }

    public BottomItemListVM onCreateViewModel() {
        ViewModel viewModel = ViewModelProviders.of((LifecycleComponent) this).get("BottomItemListComp", BottomItemListVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(this).get(\"BottomItem…omItemListVM::class.java)");
        return (BottomItemListVM) viewModel;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.LayoutManager onCreateLayoutManager() {
        return BigImageMorePicLayoutManager.Companion.create();
    }

    /* access modifiers changed from: protected */
    public RecyclerView onFindRecyclerView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        PullToRefreshRecyclerView it = this.ptrRecyclerView;
        PullToRefreshRecyclerView $this$onFindRecyclerView_u24lambda_u2d5_u24lambda_u2d3 = it;
        StateTextBuilder $this$onFindRecyclerView_u24lambda_u2d5_u24lambda_u2d3_u24lambda_u2d1 = new StateTextBuilder();
        $this$onFindRecyclerView_u24lambda_u2d5_u24lambda_u2d3_u24lambda_u2d1.setNoMoreText("没有更多了，可横滑继续浏览~").setNormalText("正在加载...");
        $this$onFindRecyclerView_u24lambda_u2d5_u24lambda_u2d3.setTextBuilder($this$onFindRecyclerView_u24lambda_u2d5_u24lambda_u2d3_u24lambda_u2d1);
        $this$onFindRecyclerView_u24lambda_u2d5_u24lambda_u2d3.setOnRefreshListener(new BottomItemListComp$$ExternalSyntheticLambda1(this));
        RecyclerView $this$onFindRecyclerView_u24lambda_u2d5_u24lambda_u2d4 = it.getRecyclerView();
        $this$onFindRecyclerView_u24lambda_u2d5_u24lambda_u2d4.setPadding(ViewExKt.getDp(7), 0, ViewExKt.getDp(7), 0);
        Intrinsics.checkNotNullExpressionValue($this$onFindRecyclerView_u24lambda_u2d5_u24lambda_u2d4, "ptrRecyclerView.let {\n  …, 0, 7.dp, 0) }\n        }");
        return $this$onFindRecyclerView_u24lambda_u2d5_u24lambda_u2d4;
    }

    /* access modifiers changed from: private */
    /* renamed from: onFindRecyclerView$lambda-5$lambda-3$lambda-2  reason: not valid java name */
    public static final void m16353onFindRecyclerView$lambda5$lambda3$lambda2(BottomItemListComp this$0, PullToRefreshRecyclerView it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BdEventBus.Companion.getDefault().post(new LoadMoreRequestEvent(this$0.pageToken, this$0.tabType));
    }

    /* access modifiers changed from: protected */
    public void onRegisterDelegates(DelegatorAdapter delegator) {
        Intrinsics.checkNotNullParameter(delegator, "delegator");
        super.onRegisterDelegates(delegator);
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
        delegator.put(new PicItemViewAdapter(lifecycleOwner, new BottomItemListComp$onRegisterDelegates$1(this), new BottomItemListComp$onRegisterDelegates$2(this)));
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "lifecycleOwner");
        delegator.put(new PicCollectionItemViewAdapter(lifecycleOwner2, new BottomItemListComp$onRegisterDelegates$3(this), new BottomItemListComp$onRegisterDelegates$4(this)));
        LifecycleOwner lifecycleOwner3 = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "lifecycleOwner");
        delegator.put(new RelatedGoodItemViewAdapter(lifecycleOwner3, new BottomItemListComp$onRegisterDelegates$5(this), new BottomItemListComp$onRegisterDelegates$6(this)));
        LifecycleOwner lifecycleOwner4 = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner4, "lifecycleOwner");
        delegator.put(new RsItemViewAdapter(lifecycleOwner4, new BottomItemListComp$onRegisterDelegates$7(this), new BottomItemListComp$onRegisterDelegates$8(this)));
        LifecycleOwner lifecycleOwner5 = getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner5, "lifecycleOwner");
        delegator.put(new PairAvatarItemAdapter(lifecycleOwner5, new BottomItemListComp$onRegisterDelegates$9(this)));
    }

    public void onCreate() {
        super.onCreate();
        registerLoadMoreResultEvent();
        observePicItemJump();
        observeGoodsItemJump();
    }

    public void onCreateView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onCreateView(view2);
        DelegatorAdapter $this$onCreateView_u24lambda_u2d6 = getAdapter();
        if ($this$onCreateView_u24lambda_u2d6 != null) {
            this.ptrRecyclerView.setDelAdapter($this$onCreateView_u24lambda_u2d6);
            this.ptrRecyclerView.onPullLoadComplete();
        }
    }

    private final void registerLoadMoreResultEvent() {
        BdEventBus.Companion.getDefault().register(this, LoadMoreResultEvent.class, new BottomItemListComp$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerLoadMoreResultEvent$lambda-8  reason: not valid java name */
    public static final void m16354registerLoadMoreResultEvent$lambda8(BottomItemListComp this$0, LoadMoreResultEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual((Object) it.getPageToken(), (Object) this$0.pageToken) && it.getTabType() == this$0.tabType) {
            ComposedList composedList = it.getComposedList();
            List<Pair<Object, IAdapterData>> items = composedList != null ? composedList.getItems() : null;
            boolean z = false;
            if (it.getSuccess()) {
                Collection collection = items;
                if (collection == null || collection.isEmpty()) {
                    z = true;
                }
                if (!z) {
                    ((BottomItemListVM) this$0.getViewModel()).appendData(it.getComposedList());
                    return;
                }
                return;
            }
            if (!NetWorkUtils.isConnected(this$0.getContext())) {
                Function0<Boolean> function0 = this$0.isInBottomPage;
                if (function0 != null && function0.invoke().booleanValue()) {
                    z = true;
                }
                if (z) {
                    UniversalToast.makeText(this$0.getContext(), R.string.search_big_image_no_network).show();
                }
            }
            this$0.ptrRecyclerView.onLoadMoreError();
        }
    }

    private final void observePicItemJump() {
        BdEventBus.Companion.getDefault().register(this, RelatedPicJumpEvent.class, new BottomItemListComp$observePicItemJump$1(this));
    }

    private final void observeGoodsItemJump() {
        BdEventBus.Companion.getDefault().register(this, RelatedGoodsJumpEvent.class, new BottomItemListComp$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeGoodsItemJump$lambda-9  reason: not valid java name */
    public static final void m16352observeGoodsItemJump$lambda9(BottomItemListComp this$0, RelatedGoodsJumpEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual((Object) it.getToken(), (Object) this$0.rootToken) && it.getTabType() == this$0.tabType) {
            LifecycleOwner lifecycleOwner = this$0.getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "lifecycleOwner");
            if (ImageHelperKt.isResumed(lifecycleOwner)) {
                Context context = this$0.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ((BottomItemListVM) this$0.getViewModel()).onGoodItemClick$lib_search_bigimage_release(context, it.getData());
            }
        }
    }

    public void onBindViewModel(BottomItemListVM viewModel, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.onBindViewModel(viewModel, owner);
        bindHasMore(viewModel, owner);
        bindInitDataLoaded(viewModel, owner);
    }

    private final void bindHasMore(BottomItemListVM viewModel, LifecycleOwner owner) {
        viewModel.getHasMore$lib_search_bigimage_release().observe(owner, new BottomItemListComp$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindHasMore$lambda-10  reason: not valid java name */
    public static final void m16350bindHasMore$lambda10(BottomItemListComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ptrRecyclerView.setHasMore(Intrinsics.areEqual((Object) true, (Object) it));
    }

    private final void bindInitDataLoaded(BottomItemListVM viewModel, LifecycleOwner owner) {
        viewModel.getInitDataLoaded$lib_search_bigimage_release().observe(owner, new BottomItemListComp$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindInitDataLoaded$lambda-11  reason: not valid java name */
    public static final void m16351bindInitDataLoaded$lambda11(BottomItemListComp this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual((Object) it, (Object) true)) {
            this$0.memOptComp.setInitDataLoaded(true);
        }
    }

    public void onSelectChanged(boolean oldState, boolean newState) {
        OnSelectChangeListener.DefaultImpls.onSelectChanged(this, oldState, newState);
        if (newState) {
            ((BottomItemListVM) getViewModel()).statGoodsItemShown$lib_search_bigimage_release();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        BdEventBus.Companion.getDefault().unregister(this);
        this.ptrRecyclerView.onPullLoadComplete();
        getRecyclerView().clearOnScrollListeners();
    }
}
