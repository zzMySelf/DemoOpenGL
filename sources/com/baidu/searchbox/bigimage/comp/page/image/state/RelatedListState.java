package com.baidu.searchbox.bigimage.comp.page.image.state;

import android.util.Log;
import com.baidu.searchbox.bigimage.R;
import com.baidu.searchbox.bigimage.comp.gestureguide.SlideToTopGuideComp;
import com.baidu.searchbox.bigimage.comp.page.image.ImagePageComp;
import com.baidu.searchbox.bigimage.comp.pictorelate.PicToRelateStateChangedCallback;
import com.baidu.searchbox.bigimage.utils.ResExtKt;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/page/image/state/RelatedListState;", "Lcom/baidu/searchbox/bigimage/comp/page/image/state/ImagePageState;", "()V", "isExited", "", "offsetChangeListener", "com/baidu/searchbox/bigimage/comp/page/image/state/RelatedListState$offsetChangeListener$1", "Lcom/baidu/searchbox/bigimage/comp/page/image/state/RelatedListState$offsetChangeListener$1;", "tabMargin", "", "enter", "", "owner", "Lcom/baidu/searchbox/bigimage/comp/page/image/ImagePageComp;", "exit", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedListState.kt */
public final class RelatedListState extends ImagePageState {
    private boolean isExited;
    private final RelatedListState$offsetChangeListener$1 offsetChangeListener = new RelatedListState$offsetChangeListener$1(this);
    /* access modifiers changed from: private */
    public final int tabMargin = (ResExtKt.getDimensionPixelSize(R.dimen.related_list_tab_height) + ResExtKt.getStatusBarHeight());

    public void enter(ImagePageComp owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.enter(owner);
        this.offsetChangeListener.setPageComp(owner);
        AppBarLayout $this$enter_u24lambda_u2d1 = (AppBarLayout) owner.getView().findViewById(R.id.appbarLayout);
        $this$enter_u24lambda_u2d1.post(new RelatedListState$$ExternalSyntheticLambda0(this, $this$enter_u24lambda_u2d1));
        PicToRelateStateChangedCallback onPicToRelateStateChanged = owner.getOnPicToRelateStateChanged();
        if (onPicToRelateStateChanged != null) {
            onPicToRelateStateChanged.onStateChanged("relateList");
        }
        SlideToTopGuideComp.Companion.showGuide(owner);
        owner.statFirstItemShow$lib_search_bigimage_release();
    }

    /* access modifiers changed from: private */
    /* renamed from: enter$lambda-1$lambda-0  reason: not valid java name */
    public static final void m16269enter$lambda1$lambda0(RelatedListState this$0, AppBarLayout $this_apply) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isExited) {
            $this_apply.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this$0.offsetChangeListener);
        } else if (RelatedListStateKt.DEBUG) {
            Log.w("RelatedListState", "已经退出当前状态，不需要再添加offsetChangeListener");
        }
    }

    public void exit(ImagePageComp owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.exit(owner);
        this.isExited = true;
        AppBarLayout $this$exit_u24lambda_u2d3 = (AppBarLayout) owner.getView().findViewById(R.id.appbarLayout);
        $this$exit_u24lambda_u2d3.post(new RelatedListState$$ExternalSyntheticLambda1($this$exit_u24lambda_u2d3, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: exit$lambda-3$lambda-2  reason: not valid java name */
    public static final void m16270exit$lambda3$lambda2(AppBarLayout $this_apply, RelatedListState this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        $this_apply.removeOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) this$0.offsetChangeListener);
    }
}
