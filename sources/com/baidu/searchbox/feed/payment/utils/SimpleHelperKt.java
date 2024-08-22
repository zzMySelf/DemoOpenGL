package com.baidu.searchbox.feed.payment.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.searchbox.block.BlockUpdateListener;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.generic.RootDrawable;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0004\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\u0005*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a6\u0010\u000f\u001a\u00020\u0001*\u0004\u0018\u00010\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0004H\bø\u0001\u0000*\n\u0010\u0014\"\u00020\u00152\u00020\u0015*\n\u0010\u0016\"\u00020\u00172\u00020\u0017*\n\u0010\u0018\"\u00020\u00192\u00020\u0019*\n\u0010\u001a\"\u00020\u001b2\u00020\u001b*\n\u0010\u001c\"\u00020\u001d2\u00020\u001d\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001e"}, d2 = {"addOnHeightChangeListener", "", "Landroid/view/View;", "onNewHeight", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "height", "disableGlobalColorFilter", "Lcom/facebook/drawee/view/SimpleDraweeView;", "dp2px", "", "res", "Landroid/content/res/Resources;", "isNotNullAndBlank", "", "ifNullOrBlank", "Lkotlin/Function0;", "block", "FlLp", "Landroid/widget/FrameLayout$LayoutParams;", "LlLp", "Landroid/widget/LinearLayout$LayoutParams;", "RlLp", "Landroid/widget/RelativeLayout$LayoutParams;", "VgLp", "Landroid/view/ViewGroup$LayoutParams;", "VgMp", "Landroid/view/ViewGroup$MarginLayoutParams;", "lib-feedpay-interface_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SimpleHelper.kt */
public final class SimpleHelperKt {
    public static final int dp2px(float $this$dp2px, Resources res) {
        Intrinsics.checkNotNullParameter(res, UriUtil.LOCAL_RESOURCE_SCHEME);
        return MathKt.roundToInt(($this$dp2px * res.getDisplayMetrics().density) + 0.5f);
    }

    public static /* synthetic */ void isNotNullAndBlank$default(String $this$isNotNullAndBlank_u24default, Function0 ifNullOrBlank, Function1 block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ifNullOrBlank = SimpleHelperKt$isNotNullAndBlank$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(ifNullOrBlank, "ifNullOrBlank");
        Intrinsics.checkNotNullParameter(block, BlockUpdateListener.ACTION_BLOCK);
        if ($this$isNotNullAndBlank_u24default == null || !(!StringsKt.isBlank($this$isNotNullAndBlank_u24default))) {
            ifNullOrBlank.invoke();
        } else {
            block.invoke($this$isNotNullAndBlank_u24default);
        }
    }

    public static final void isNotNullAndBlank(String $this$isNotNullAndBlank, Function0<Unit> ifNullOrBlank, Function1<? super String, Unit> block) {
        Intrinsics.checkNotNullParameter(ifNullOrBlank, "ifNullOrBlank");
        Intrinsics.checkNotNullParameter(block, BlockUpdateListener.ACTION_BLOCK);
        if ($this$isNotNullAndBlank == null || !(!StringsKt.isBlank($this$isNotNullAndBlank))) {
            ifNullOrBlank.invoke();
        } else {
            block.invoke($this$isNotNullAndBlank);
        }
    }

    public static final void addOnHeightChangeListener(View $this$addOnHeightChangeListener, Function1<? super Integer, Unit> onNewHeight) {
        Intrinsics.checkNotNullParameter($this$addOnHeightChangeListener, "<this>");
        Intrinsics.checkNotNullParameter(onNewHeight, "onNewHeight");
        $this$addOnHeightChangeListener.addOnLayoutChangeListener(new SimpleHelperKt$$ExternalSyntheticLambda0(onNewHeight));
    }

    /* access modifiers changed from: private */
    /* renamed from: addOnHeightChangeListener$lambda-0  reason: not valid java name */
    public static final void m19305addOnHeightChangeListener$lambda0(Function1 $onNewHeight, View view2, int i2, int top, int i3, int bottom, int i4, int oldTop, int i5, int oldBottom) {
        Intrinsics.checkNotNullParameter($onNewHeight, "$onNewHeight");
        int h2 = bottom - top;
        if (h2 != oldBottom - oldTop) {
            $onNewHeight.invoke(Integer.valueOf(h2));
        }
    }

    public static final void disableGlobalColorFilter(SimpleDraweeView $this$disableGlobalColorFilter) {
        Intrinsics.checkNotNullParameter($this$disableGlobalColorFilter, "<this>");
        Drawable topLevelDrawable = $this$disableGlobalColorFilter.getTopLevelDrawable();
        RootDrawable rootDrawable = topLevelDrawable instanceof RootDrawable ? (RootDrawable) topLevelDrawable : null;
        if (rootDrawable != null) {
            rootDrawable.setUseGlobalColorFilter(false);
        }
    }
}
