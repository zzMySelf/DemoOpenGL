package com.baidu.searchbox.music.lyric.comp.config;

import android.content.Context;
import android.graphics.Rect;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.nacomp.extension.util.RecyclerViewHelper;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\nJ\u0010\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\bH\u0002J$\u0010\u001e\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/music/lyric/comp/config/LyricLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "defaultSpeed", "", "lyricConfig", "Lcom/baidu/searchbox/music/lyric/comp/config/LyricConfig;", "lyricDecoration", "Lcom/baidu/searchbox/music/lyric/comp/config/LyricDecoration;", "getItemRect", "Landroid/graphics/Rect;", "position", "", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getStartPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scrollToPosition", "", "setLyricConfig", "config", "setLyricDecoration", "decoration", "smoothScrollTo", "speed", "smoothScrollToPosition", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "lib-music-lyric_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LyricLayoutManager.kt */
public final class LyricLayoutManager extends LinearLayoutManager {
    private final Context context;
    private final float defaultSpeed;
    private LyricConfig lyricConfig = new LyricConfig(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
    private LyricDecoration lyricDecoration;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LyricLayoutManager(Context context2) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.defaultSpeed = 200.0f / ((float) DeviceUtils.ScreenInfo.getDensityDpi(context2));
    }

    public final Context getContext() {
        return this.context;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        float speed = this.defaultSpeed;
        int lineHeight = ViewExKt.getDp(LyricConfigKt.showHeight(this.lyricConfig));
        if (state != null) {
            RecyclerView.State state2 = state;
            int space = Math.abs((lineHeight * position) - (getStartPosition(recyclerView) * lineHeight));
            if (space != 0) {
                speed = 200.0f / ((float) space);
            }
        }
        smoothScrollTo(position, speed);
    }

    public void scrollToPosition(int position) {
        super.scrollToPositionWithOffset(position, 0);
    }

    private final int getStartPosition(RecyclerView recyclerView) {
        int lineHeight = LyricConfigKt.showHeight(this.lyricConfig);
        if (lineHeight <= 0 || recyclerView == null) {
            return 0;
        }
        return (int) (((float) RecyclerViewHelper.getRcyFirstVisiblePosition(recyclerView)) + (((float) (recyclerView.getMeasuredHeight() / lineHeight)) * this.lyricConfig.getAnchorConfig().getHeightRatio()));
    }

    static /* synthetic */ void smoothScrollTo$default(LyricLayoutManager lyricLayoutManager, int i2, float f2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f2 = lyricLayoutManager.defaultSpeed;
        }
        lyricLayoutManager.smoothScrollTo(i2, f2);
    }

    private final void smoothScrollTo(int position, float speed) {
        SmoothScroller $this$smoothScrollTo_u24lambda_u2d1 = new SmoothScroller(this.context, this.lyricConfig.getAnchorConfig().getHeightRatio(), getItemRect(position, this), speed);
        $this$smoothScrollTo_u24lambda_u2d1.setTargetPosition(position);
        startSmoothScroll($this$smoothScrollTo_u24lambda_u2d1);
    }

    private final Rect getItemRect(int position, RecyclerView.LayoutManager layoutManager) {
        Rect rect = new Rect();
        Rect $this$getItemRect_u24lambda_u2d2 = rect;
        LyricDecoration lyricDecoration2 = this.lyricDecoration;
        if (lyricDecoration2 != null) {
            lyricDecoration2.getItemRect(position, $this$getItemRect_u24lambda_u2d2, layoutManager);
        }
        return rect;
    }

    public final void setLyricConfig(LyricConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.lyricConfig = config;
    }

    public final void setLyricDecoration(LyricDecoration decoration) {
        this.lyricDecoration = decoration;
    }
}
