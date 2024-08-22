package com.baidu.searchbox.bigimage.comp.page.image.state;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.baidu.searchbox.bigimage.R;
import com.baidu.searchbox.bigimage.comp.page.image.ImagePageComp;
import com.baidu.searchbox.bigimage.comp.pictorelate.PicToRelateStateChangedCallback;
import com.baidu.searchbox.bigimage.ioc.IImageNightMode;
import com.baidu.searchbox.bigimage.utils.ResExtKt;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/page/image/state/RelatedTabState;", "Lcom/baidu/searchbox/bigimage/comp/page/image/state/ImagePageState;", "()V", "isExited", "", "offsetChangeListener", "com/baidu/searchbox/bigimage/comp/page/image/state/RelatedTabState$offsetChangeListener$1", "Lcom/baidu/searchbox/bigimage/comp/page/image/state/RelatedTabState$offsetChangeListener$1;", "tabMargin", "", "enter", "", "owner", "Lcom/baidu/searchbox/bigimage/comp/page/image/ImagePageComp;", "exit", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedTabState.kt */
public final class RelatedTabState extends ImagePageState {
    private boolean isExited;
    private final RelatedTabState$offsetChangeListener$1 offsetChangeListener = new RelatedTabState$offsetChangeListener$1(this);
    /* access modifiers changed from: private */
    public final int tabMargin = (ResExtKt.getDimensionPixelSize(R.dimen.related_list_tab_height) + ResExtKt.getStatusBarHeight());

    public void enter(ImagePageComp owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.enter(owner);
        ImagePageComp $this$enter_u24lambda_u2d2 = owner;
        IImageNightMode.Companion.getImpl().setBackgroundColor($this$enter_u24lambda_u2d2.getBottomRootComp$lib_search_bigimage_release().getViewPager$lib_search_bigimage_release(), R.color.search_big_image_image_container_bg_color);
        $this$enter_u24lambda_u2d2.getBottomRootComp$lib_search_bigimage_release().getTabComp$lib_search_bigimage_release().show();
        this.offsetChangeListener.setPageComp($this$enter_u24lambda_u2d2);
        AppBarLayout it = (AppBarLayout) $this$enter_u24lambda_u2d2.getView().findViewById(R.id.appbarLayout);
        it.post(new RelatedTabState$$ExternalSyntheticLambda0(this, it));
        PicToRelateStateChangedCallback onPicToRelateStateChanged = $this$enter_u24lambda_u2d2.getOnPicToRelateStateChanged();
        if (onPicToRelateStateChanged != null) {
            onPicToRelateStateChanged.onStateChanged("relateTab");
        }
        $this$enter_u24lambda_u2d2.getBottomRootComp$lib_search_bigimage_release().getViewPager$lib_search_bigimage_release().setCanScroll(true);
        $this$enter_u24lambda_u2d2.getBottomRootComp$lib_search_bigimage_release().setOnScrollToTab(new RelatedTabState$enter$1$2($this$enter_u24lambda_u2d2, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: enter$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m16272enter$lambda2$lambda1$lambda0(RelatedTabState this$0, AppBarLayout $it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isExited) {
            $it.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this$0.offsetChangeListener);
        } else if (RelatedTabStateKt.DEBUG) {
            Log.w("RelatedTabState", "已经退出当前状态，不需要再添加offsetChangeListener");
        }
    }

    public void exit(ImagePageComp owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.exit(owner);
        this.isExited = true;
        ImagePageComp $this$exit_u24lambda_u2d3 = owner;
        $this$exit_u24lambda_u2d3.getBottomRootComp$lib_search_bigimage_release().getViewPager$lib_search_bigimage_release().setBackground((Drawable) null);
        $this$exit_u24lambda_u2d3.getBottomRootComp$lib_search_bigimage_release().getTabComp$lib_search_bigimage_release().dismiss(false);
        $this$exit_u24lambda_u2d3.getBottomRootComp$lib_search_bigimage_release().getViewPager$lib_search_bigimage_release().setCanScroll(false);
        $this$exit_u24lambda_u2d3.getBottomRootComp$lib_search_bigimage_release().setOnScrollToTab((Function0<Unit>) null);
        AppBarLayout $this$exit_u24lambda_u2d5 = (AppBarLayout) owner.getView().findViewById(R.id.appbarLayout);
        $this$exit_u24lambda_u2d5.post(new RelatedTabState$$ExternalSyntheticLambda1($this$exit_u24lambda_u2d5, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: exit$lambda-5$lambda-4  reason: not valid java name */
    public static final void m16273exit$lambda5$lambda4(AppBarLayout $this_apply, RelatedTabState this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        $this_apply.removeOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this$0.offsetChangeListener);
    }
}
