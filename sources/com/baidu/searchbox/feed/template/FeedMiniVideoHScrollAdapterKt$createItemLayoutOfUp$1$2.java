package com.baidu.searchbox.feed.template;

import android.widget.ImageView;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.util.DecoratePainter;
import com.baidu.searchbox.layout.GenRelativeLayout;
import com.baidu.searchbox.resources.util.CtxResEasyUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "builder", "Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedMiniVideoHScrollAdapter.kt */
final class FeedMiniVideoHScrollAdapterKt$createItemLayoutOfUp$1$2 extends Lambda implements Function2<FeedDraweeView, GenericDraweeHierarchyBuilder, Unit> {
    final /* synthetic */ GenRelativeLayout $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedMiniVideoHScrollAdapterKt$createItemLayoutOfUp$1$2(GenRelativeLayout genRelativeLayout) {
        super(2);
        this.$this_apply = genRelativeLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((FeedDraweeView) p1, (GenericDraweeHierarchyBuilder) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(FeedDraweeView $this$draweeView, GenericDraweeHierarchyBuilder builder) {
        Intrinsics.checkNotNullParameter($this$draweeView, "$this$draweeView");
        Intrinsics.checkNotNullParameter(builder, "builder");
        $this$draweeView.setId(R.id.feed_tpl_mini_video_cover);
        this.$this_apply.lparams($this$draweeView, AnonymousClass1.INSTANCE);
        FeedDraweeViewExKt.applyScaleType$default($this$draweeView, builder, ImageView.ScaleType.CENTER_CROP, false, false, false, false, 60, (Object) null);
        FeedDraweeViewExKt.applyCustomCornersRadiusWithBorder($this$draweeView, builder, CtxResEasyUtils.asResDimen(com.baidu.searchbox.feed.styles.R.dimen.F_J_X01), DecoratePainter.DefaultConfig.singleInstance);
    }
}
