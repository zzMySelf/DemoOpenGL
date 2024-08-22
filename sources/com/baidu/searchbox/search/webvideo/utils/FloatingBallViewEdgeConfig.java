package com.baidu.searchbox.search.webvideo.utils;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.search.videodetail.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\b¨\u0006+"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/utils/FloatingBallViewEdgeConfig;", "", "()V", "floatingBallBottomLimit", "", "getFloatingBallBottomLimit", "()F", "setFloatingBallBottomLimit", "(F)V", "floatingBallDragEnable", "", "getFloatingBallDragEnable", "()Z", "setFloatingBallDragEnable", "(Z)V", "floatingBallLeftLimit", "getFloatingBallLeftLimit", "setFloatingBallLeftLimit", "floatingBallMoveEdgeBottomMargin", "getFloatingBallMoveEdgeBottomMargin", "setFloatingBallMoveEdgeBottomMargin", "floatingBallMoveEdgeLeftMargin", "getFloatingBallMoveEdgeLeftMargin", "setFloatingBallMoveEdgeLeftMargin", "floatingBallMoveEdgeRightMargin", "getFloatingBallMoveEdgeRightMargin", "setFloatingBallMoveEdgeRightMargin", "floatingBallMoveEdgeTopMargin", "getFloatingBallMoveEdgeTopMargin", "setFloatingBallMoveEdgeTopMargin", "floatingBallRightLimit", "getFloatingBallRightLimit", "setFloatingBallRightLimit", "floatingBallTopLimit", "getFloatingBallTopLimit", "setFloatingBallTopLimit", "setFloatingBallMoveEdgeMargin", "", "bottom", "top", "left", "right", "Companion", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FloatingBallViewEdgeConfig.kt */
public final class FloatingBallViewEdgeConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private float floatingBallBottomLimit;
    private boolean floatingBallDragEnable;
    private float floatingBallLeftLimit;
    private float floatingBallMoveEdgeBottomMargin;
    private float floatingBallMoveEdgeLeftMargin;
    private float floatingBallMoveEdgeRightMargin;
    private float floatingBallMoveEdgeTopMargin;
    private float floatingBallRightLimit;
    private float floatingBallTopLimit;

    @JvmStatic
    public static final FloatingBallViewEdgeConfig createSearchConfig() {
        return Companion.createSearchConfig();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/utils/FloatingBallViewEdgeConfig$Companion;", "", "()V", "createSearchConfig", "Lcom/baidu/searchbox/search/webvideo/utils/FloatingBallViewEdgeConfig;", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FloatingBallViewEdgeConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FloatingBallViewEdgeConfig createSearchConfig() {
            FloatingBallViewEdgeConfig floatingBallViewEdgeConfig = new FloatingBallViewEdgeConfig();
            FloatingBallViewEdgeConfig $this$createSearchConfig_u24lambda_u2d0 = floatingBallViewEdgeConfig;
            $this$createSearchConfig_u24lambda_u2d0.setFloatingBallMoveEdgeMargin(AppRuntime.getAppContext().getResources().getDimension(R.dimen.h5_video_floating_ball_bottom_limit), AppRuntime.getAppContext().getResources().getDimension(R.dimen.h5_video_floating_ball_top_limit), AppRuntime.getAppContext().getResources().getDimension(R.dimen.h5_video_floating_ball_move_left_margin), AppRuntime.getAppContext().getResources().getDimension(R.dimen.h5_video_floating_ball_move_right_margin));
            $this$createSearchConfig_u24lambda_u2d0.setFloatingBallDragEnable(true);
            return floatingBallViewEdgeConfig;
        }
    }

    public final float getFloatingBallBottomLimit() {
        return this.floatingBallBottomLimit;
    }

    public final void setFloatingBallBottomLimit(float f2) {
        this.floatingBallBottomLimit = f2;
    }

    public final float getFloatingBallTopLimit() {
        return this.floatingBallTopLimit;
    }

    public final void setFloatingBallTopLimit(float f2) {
        this.floatingBallTopLimit = f2;
    }

    public final float getFloatingBallLeftLimit() {
        return this.floatingBallLeftLimit;
    }

    public final void setFloatingBallLeftLimit(float f2) {
        this.floatingBallLeftLimit = f2;
    }

    public final float getFloatingBallRightLimit() {
        return this.floatingBallRightLimit;
    }

    public final void setFloatingBallRightLimit(float f2) {
        this.floatingBallRightLimit = f2;
    }

    public final float getFloatingBallMoveEdgeBottomMargin() {
        return this.floatingBallMoveEdgeBottomMargin;
    }

    public final void setFloatingBallMoveEdgeBottomMargin(float f2) {
        this.floatingBallMoveEdgeBottomMargin = f2;
    }

    public final float getFloatingBallMoveEdgeTopMargin() {
        return this.floatingBallMoveEdgeTopMargin;
    }

    public final void setFloatingBallMoveEdgeTopMargin(float f2) {
        this.floatingBallMoveEdgeTopMargin = f2;
    }

    public final float getFloatingBallMoveEdgeLeftMargin() {
        return this.floatingBallMoveEdgeLeftMargin;
    }

    public final void setFloatingBallMoveEdgeLeftMargin(float f2) {
        this.floatingBallMoveEdgeLeftMargin = f2;
    }

    public final float getFloatingBallMoveEdgeRightMargin() {
        return this.floatingBallMoveEdgeRightMargin;
    }

    public final void setFloatingBallMoveEdgeRightMargin(float f2) {
        this.floatingBallMoveEdgeRightMargin = f2;
    }

    public final boolean getFloatingBallDragEnable() {
        return this.floatingBallDragEnable;
    }

    public final void setFloatingBallDragEnable(boolean z) {
        this.floatingBallDragEnable = z;
    }

    public final void setFloatingBallMoveEdgeMargin(float bottom, float top, float left, float right) {
        this.floatingBallMoveEdgeBottomMargin = bottom;
        this.floatingBallMoveEdgeTopMargin = top;
        this.floatingBallMoveEdgeLeftMargin = left;
        this.floatingBallMoveEdgeRightMargin = right;
    }
}
