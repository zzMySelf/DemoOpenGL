package com.baidu.searchbox.video.feedflow.tab.theater.top.diamond;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.searchbox.flowvideo.theater.repos.TheaterTopDiamondListModel;
import com.baidu.searchbox.flowvideo.theater.repos.TheaterTopModel;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.tab.theater.top.TheaterTopContainerAction;
import com.baidu.searchbox.video.feedflow.utils.TabUtilsKt;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$J\n\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020\u001eH\u0007J\b\u0010(\u001a\u00020\u001eH\u0007J\b\u0010)\u001a\u00020\u001eH\u0007J\b\u0010*\u001a\u00020\u001eH\u0002J\u0006\u0010+\u001a\u00020\u001eJ\u0012\u0010,\u001a\u00020\u001e2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u000e\u0010/\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u000eH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/theater/top/diamond/TheaterTopContainerDiamondContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bigItemDecoration", "Lcom/baidu/searchbox/video/feedflow/tab/theater/top/diamond/BigGridDecoration;", "capsuleItemDecoration", "Lcom/baidu/searchbox/video/feedflow/tab/theater/top/diamond/CapsuleGridDecoration;", "diamondType", "", "isPadStyle", "", "lastEventX", "", "lastEventY", "manager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "normalItemDecoration", "Lcom/baidu/searchbox/video/feedflow/tab/theater/top/diamond/NormalGridDecoration;", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "bindData", "", "theaterTopModel", "Lcom/baidu/searchbox/flowvideo/theater/repos/TheaterTopModel;", "changePadStyle", "consumeEvent", "event", "Landroid/view/MotionEvent;", "getListHotSpot", "Landroid/graphics/Rect;", "onConfigurationChanged", "onFontSize", "onNightModeChanged", "onShown", "release", "resetAddItemDecoration", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setManager", "updateRecyclerViewUi", "type", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TheaterTopContainerDiamondContainer.kt */
public final class TheaterTopContainerDiamondContainer extends FrameLayout {
    private BigGridDecoration bigItemDecoration;
    private CapsuleGridDecoration capsuleItemDecoration;
    private String diamondType;
    private boolean isPadStyle;
    private float lastEventX;
    private float lastEventY;
    private ComponentArchManager manager;
    private NormalGridDecoration normalItemDecoration;
    private RecyclerView rv;
    /* access modifiers changed from: private */
    public Store<CommonState> store;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TheaterTopContainerDiamondContainer(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TheaterTopContainerDiamondContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TheaterTopContainerDiamondContainer(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TheaterTopContainerDiamondContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.diamondType = "0";
        LayoutInflater.from(context).inflate(R.layout.video_flow_theater_top_diamond_view, this, true);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_btn);
        this.rv = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        }
    }

    public final void changePadStyle(boolean isPadStyle2) {
        this.isPadStyle = isPadStyle2;
        RecyclerView recyclerView = this.rv;
        FrameLayout.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = recyclerView != null ? recyclerView.getLayoutParams() : null;
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        }
        if (layoutParams != null) {
            FrameLayout.LayoutParams $this$changePadStyle_u24lambda_u2d0 = layoutParams;
            if (isPadStyle2) {
                $this$changePadStyle_u24lambda_u2d0.width = -2;
                $this$changePadStyle_u24lambda_u2d0.gravity = 1;
                return;
            }
            $this$changePadStyle_u24lambda_u2d0.width = -1;
            $this$changePadStyle_u24lambda_u2d0.gravity = 3;
        }
    }

    public final void bindData(TheaterTopModel theaterTopModel) {
        List diamonds;
        String str;
        TheaterTopDiamondListModel diamond;
        TheaterTopDiamondListModel diamond2;
        if (theaterTopModel == null || (diamond2 = theaterTopModel.getDiamond()) == null || (diamonds = diamond2.getItems()) == null) {
            diamonds = CollectionsKt.emptyList();
        }
        if (diamonds.isEmpty()) {
            RecyclerView recyclerView = this.rv;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
                return;
            }
            return;
        }
        RecyclerView recyclerView2 = this.rv;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        if (theaterTopModel == null || (diamond = theaterTopModel.getDiamond()) == null || (str = diamond.getType()) == null) {
            str = "0";
        }
        this.diamondType = str;
        String str2 = this.diamondType;
        boolean isShortplayTab = TabUtilsKt.isShortplayTab(theaterTopModel != null ? theaterTopModel.getTabId() : null);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TheaterDiamondAdapter theaterBannerAdapter = new TheaterDiamondAdapter(str2, diamonds, isShortplayTab, context);
        theaterBannerAdapter.setITheaterDiamondListener(new TheaterTopContainerDiamondContainer$bindData$1(this));
        updateRecyclerViewUi(this.diamondType);
        RecyclerView recyclerView3 = this.rv;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(theaterBannerAdapter);
        }
        onShown();
    }

    public final boolean consumeEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        RecyclerView $this$consumeEvent_u24lambda_u2d1 = this.rv;
        if ($this$consumeEvent_u24lambda_u2d1 == null || $this$consumeEvent_u24lambda_u2d1.getVisibility() != 0 || !$this$consumeEvent_u24lambda_u2d1.isNestedScrollingEnabled()) {
            return false;
        }
        Rect listHotSpot = getListHotSpot();
        if (!(listHotSpot != null && VideoFlowUtilsKt.isContainMotion(listHotSpot, event))) {
            return false;
        }
        switch (event.getAction()) {
            case 0:
                this.lastEventX = event.getX();
                this.lastEventY = event.getY();
                return true;
            case 2:
                float dx = event.getX() - this.lastEventX;
                if (!(Math.abs(dx) > Math.abs(event.getY() - this.lastEventY)) || !$this$consumeEvent_u24lambda_u2d1.canScrollHorizontally(-TheaterTopContainerDiamondContainerKt.floatSafeToInt(dx))) {
                    return false;
                }
                return true;
        }
        return false;
    }

    private final Rect getListHotSpot() {
        RecyclerView recyclerView = this.rv;
        if (recyclerView == null) {
            return null;
        }
        Rect $this$getListHotSpot_u24lambda_u2d3_u24lambda_u2d2 = new Rect();
        int[] location = new int[2];
        recyclerView.getLocationOnScreen(location);
        $this$getListHotSpot_u24lambda_u2d3_u24lambda_u2d2.set(location[0], location[1], location[0] + recyclerView.getWidth(), location[1] + recyclerView.getHeight());
        return $this$getListHotSpot_u24lambda_u2d3_u24lambda_u2d2;
    }

    private final void updateRecyclerViewUi(String type) {
        float maxSpace;
        RecyclerView $this$updateRecyclerViewUi_u24lambda_u2d7 = this.rv;
        if ($this$updateRecyclerViewUi_u24lambda_u2d7 != null) {
            ViewGroup.LayoutParams layoutParams = $this$updateRecyclerViewUi_u24lambda_u2d7.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (Intrinsics.areEqual((Object) type, (Object) "1")) {
                if (marginLayoutParams != null) {
                    ViewGroup.MarginLayoutParams $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d4 = marginLayoutParams;
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d4.leftMargin = 0;
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d4.topMargin = 0;
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d4.rightMargin = 0;
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d4.bottomMargin = 0;
                }
                $this$updateRecyclerViewUi_u24lambda_u2d7.setPadding(0, $this$updateRecyclerViewUi_u24lambda_u2d7.getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_5dp), 0, $this$updateRecyclerViewUi_u24lambda_u2d7.getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_12dp));
                $this$updateRecyclerViewUi_u24lambda_u2d7.setBackground((Drawable) null);
                $this$updateRecyclerViewUi_u24lambda_u2d7.setNestedScrollingEnabled(true);
                if (this.capsuleItemDecoration == null) {
                    this.capsuleItemDecoration = new CapsuleGridDecoration();
                }
                resetAddItemDecoration(this.capsuleItemDecoration);
            } else if (Intrinsics.areEqual((Object) type, (Object) "2")) {
                if (marginLayoutParams != null) {
                    ViewGroup.MarginLayoutParams $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d5 = marginLayoutParams;
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d5.leftMargin = 0;
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d5.topMargin = $this$updateRecyclerViewUi_u24lambda_u2d7.getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_7dp);
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d5.rightMargin = 0;
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d5.bottomMargin = $this$updateRecyclerViewUi_u24lambda_u2d7.getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_19_5dp);
                }
                $this$updateRecyclerViewUi_u24lambda_u2d7.setPadding(0, 0, 0, 0);
                $this$updateRecyclerViewUi_u24lambda_u2d7.setBackground((Drawable) null);
                $this$updateRecyclerViewUi_u24lambda_u2d7.setNestedScrollingEnabled(true);
                if (this.bigItemDecoration == null) {
                    float itemWidth = FontSizeHelper.getScaledSizeRes(0, R.dimen.video_flow_dimens_49dp);
                    if (this.isPadStyle) {
                        maxSpace = FontSizeHelper.getScaledSizeRes(0, R.dimen.video_flow_dimens_47dp);
                    } else {
                        maxSpace = FontSizeHelper.getScaledSizeRes(0, R.dimen.video_flow_dimens_65dp);
                    }
                    this.bigItemDecoration = new BigGridDecoration(itemWidth, maxSpace, this.isPadStyle);
                }
                resetAddItemDecoration(this.bigItemDecoration);
            } else {
                if (marginLayoutParams != null) {
                    ViewGroup.MarginLayoutParams $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d6 = marginLayoutParams;
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d6.leftMargin = $this$updateRecyclerViewUi_u24lambda_u2d7.getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_13dp);
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d6.topMargin = 0;
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d6.rightMargin = $this$updateRecyclerViewUi_u24lambda_u2d7.getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_13dp);
                    $this$updateRecyclerViewUi_u24lambda_u2d7_u24lambda_u2d6.bottomMargin = $this$updateRecyclerViewUi_u24lambda_u2d7.getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_8dp);
                }
                $this$updateRecyclerViewUi_u24lambda_u2d7.setPadding(0, 0, 0, 0);
                $this$updateRecyclerViewUi_u24lambda_u2d7.setBackground(ResourceUtils.getDrawable($this$updateRecyclerViewUi_u24lambda_u2d7.getContext(), R.drawable.video_flow_tab_theater_card_bg));
                $this$updateRecyclerViewUi_u24lambda_u2d7.setNestedScrollingEnabled(false);
                if (this.normalItemDecoration == null) {
                    this.normalItemDecoration = new NormalGridDecoration(TheaterTopContainerDiamondContainerKt.floatSafeToInt(FontSizeHelper.getScaledSizeRes(0, R.dimen.video_flow_dimens_45dp)), TheaterTopContainerDiamondContainerKt.floatSafeToInt(FontSizeHelper.getScaledSizeRes(0, R.dimen.video_flow_dimens_65dp)), this.isPadStyle);
                }
                resetAddItemDecoration(this.normalItemDecoration);
            }
            $this$updateRecyclerViewUi_u24lambda_u2d7.setLayoutParams(marginLayoutParams);
        }
    }

    private final void resetAddItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        NormalGridDecoration $this$resetAddItemDecoration_u24lambda_u2d8 = this.normalItemDecoration;
        if (!($this$resetAddItemDecoration_u24lambda_u2d8 == null || (recyclerView3 = this.rv) == null)) {
            recyclerView3.removeItemDecoration($this$resetAddItemDecoration_u24lambda_u2d8);
        }
        CapsuleGridDecoration $this$resetAddItemDecoration_u24lambda_u2d9 = this.capsuleItemDecoration;
        if (!($this$resetAddItemDecoration_u24lambda_u2d9 == null || (recyclerView2 = this.rv) == null)) {
            recyclerView2.removeItemDecoration($this$resetAddItemDecoration_u24lambda_u2d9);
        }
        BigGridDecoration $this$resetAddItemDecoration_u24lambda_u2d10 = this.bigItemDecoration;
        if (!($this$resetAddItemDecoration_u24lambda_u2d10 == null || (recyclerView = this.rv) == null)) {
            recyclerView.removeItemDecoration($this$resetAddItemDecoration_u24lambda_u2d10);
        }
        if (itemDecoration != null) {
            RecyclerView.ItemDecoration $this$resetAddItemDecoration_u24lambda_u2d11 = itemDecoration;
            RecyclerView recyclerView4 = this.rv;
            if (recyclerView4 != null) {
                recyclerView4.addItemDecoration($this$resetAddItemDecoration_u24lambda_u2d11);
            }
        }
    }

    public final void onFontSize() {
        RecyclerView.Adapter adapter;
        NormalGridDecoration normalGridDecoration = this.normalItemDecoration;
        if (normalGridDecoration != null) {
            normalGridDecoration.setItemWidth(TheaterTopContainerDiamondContainerKt.floatSafeToInt(FontSizeHelper.getScaledSizeRes(0, R.dimen.video_flow_dimens_45dp)));
        }
        BigGridDecoration bigGridDecoration = this.bigItemDecoration;
        if (bigGridDecoration != null) {
            bigGridDecoration.setItemWidth(FontSizeHelper.getScaledSizeRes(0, R.dimen.video_flow_dimens_49dp));
        }
        RecyclerView recyclerView = this.rv;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void onNightModeChanged() {
        RecyclerView.Adapter adapter;
        RecyclerView recyclerView = this.rv;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void onConfigurationChanged() {
        RecyclerView.Adapter adapter;
        updateRecyclerViewUi(this.diamondType);
        RecyclerView recyclerView = this.rv;
        if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
    }

    private final void onShown() {
        Store<CommonState> store2 = this.store;
        if (store2 != null) {
            StoreExtKt.post(store2, TheaterTopContainerAction.OnDiamondShown.INSTANCE);
        }
    }

    public final void setManager(ComponentArchManager manager2) {
        Intrinsics.checkNotNullParameter(manager2, FeedStatisticConstants.UBC_TYPE_PLUS);
        this.manager = manager2;
        this.store = manager2.getStore();
    }

    public final void release() {
    }
}
