package com.baidu.searchbox.music.comp.player.page.video.item.rec;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.searchbox.music.lyric.R;
import com.baidu.searchbox.music.utils.UIUtils;
import com.baidu.searchbox.nacomp.extension.nightmode.INightMode;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/music/comp/player/page/video/item/rec/VideoRecHasMoreView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/searchbox/nacomp/extension/nightmode/INightMode;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coverView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getCoverView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "coverView$delegate", "Lkotlin/Lazy;", "maskView", "Landroid/view/View;", "getMaskView", "()Landroid/view/View;", "maskView$delegate", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView$delegate", "onNightModeChange", "", "isNight", "", "setData", "coverUrl", "", "lib-music_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoRecView.kt */
public final class VideoRecHasMoreView extends FrameLayout implements INightMode {
    public Map<Integer, View> _$_findViewCache;
    private final Lazy coverView$delegate;
    private final Lazy maskView$delegate;
    private final Lazy titleView$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoRecHasMoreView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoRecHasMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoRecHasMoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.coverView$delegate = LazyKt.lazy(new VideoRecHasMoreView$coverView$2(context));
        this.titleView$delegate = LazyKt.lazy(new VideoRecHasMoreView$titleView$2(context));
        this.maskView$delegate = LazyKt.lazy(new VideoRecHasMoreView$maskView$2(context));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoRecHasMoreView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final SimpleDraweeView getCoverView() {
        return (SimpleDraweeView) this.coverView$delegate.getValue();
    }

    private final TextView getTitleView() {
        return (TextView) this.titleView$delegate.getValue();
    }

    private final View getMaskView() {
        return (View) this.maskView$delegate.getValue();
    }

    public final void setData(String coverUrl) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        removeAllViews();
        SimpleDraweeView $this$setData_u24lambda_u2d0 = getCoverView();
        UIUtils.INSTANCE.blurImage($this$setData_u24lambda_u2d0, coverUrl, 20);
        addView($this$setData_u24lambda_u2d0);
        addView(getMaskView());
        addView(getTitleView());
    }

    public void onNightModeChange(boolean isNight) {
        ResWrapper.setTextColor(getTitleView(), R.color.SC290);
    }
}
