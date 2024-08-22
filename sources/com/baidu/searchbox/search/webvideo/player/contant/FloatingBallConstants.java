package com.baidu.searchbox.search.webvideo.player.contant;

import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.common.toolbar.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR\u000e\u0010\u0018\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/search/webvideo/player/contant/FloatingBallConstants;", "", "()V", "AB_TEST_DUVIP_LCB_VIP_PURCHASE", "", "BOTTOM_BAR_HEIGHT_DEFAULT", "", "getBOTTOM_BAR_HEIGHT_DEFAULT", "()I", "ERROR_TOUCH_DISTANCE_DELTA", "FLOATING_BALL_ANIMATION_DURATION", "", "FLOATING_BALL_FIRST_DURATION", "FLOATING_BALL_HEIGHT", "", "FLOATING_BALL_LAYOUT_WIDTH", "FLOATING_BALL_WIDTH", "HAS_SHOW_FIRST_TOAST", "HAS_SHOW_SEVEN_DAY_VIP_FLOAT_TOAST_TODAY_KEY", "LCB_VIP_PURCHASE_CLOSE", "LCB_VIP_PURCHASE_OPEN", "MOVE_MAX_PROGRESS_VALUE", "STATUS_BAR_HEIGHT_DEFAULT", "getSTATUS_BAR_HEIGHT_DEFAULT", "TIMER_MOVE_ANIMATION_DURATION", "lib_search_video_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FloatingBallConstant.kt */
public final class FloatingBallConstants {
    public static final String AB_TEST_DUVIP_LCB_VIP_PURCHASE = "duvip_lcb_vip_purchase";
    private static final int BOTTOM_BAR_HEIGHT_DEFAULT = AppRuntime.getAppContext().getResources().getDimensionPixelSize(R.dimen.common_tool_bar_height);
    public static final int ERROR_TOUCH_DISTANCE_DELTA = 81;
    public static final long FLOATING_BALL_ANIMATION_DURATION = 160;
    public static final int FLOATING_BALL_FIRST_DURATION = 5000;
    public static final float FLOATING_BALL_HEIGHT = 0.74326056f;
    public static final float FLOATING_BALL_LAYOUT_WIDTH = 0.4758454f;
    public static final float FLOATING_BALL_WIDTH = 0.83055556f;
    public static final String HAS_SHOW_FIRST_TOAST = "has_show_first_toast";
    public static final String HAS_SHOW_SEVEN_DAY_VIP_FLOAT_TOAST_TODAY_KEY = "has_show_seven_day_vip_float_toast_today";
    public static final FloatingBallConstants INSTANCE = new FloatingBallConstants();
    public static final int LCB_VIP_PURCHASE_CLOSE = 0;
    public static final int LCB_VIP_PURCHASE_OPEN = 1;
    public static final float MOVE_MAX_PROGRESS_VALUE = 1.0f;
    private static final int STATUS_BAR_HEIGHT_DEFAULT = DeviceUtils.ScreenInfo.getStatusBarHeight();
    public static final float TIMER_MOVE_ANIMATION_DURATION = 400.0f;

    private FloatingBallConstants() {
    }

    public final int getSTATUS_BAR_HEIGHT_DEFAULT() {
        return STATUS_BAR_HEIGHT_DEFAULT;
    }

    public final int getBOTTOM_BAR_HEIGHT_DEFAULT() {
        return BOTTOM_BAR_HEIGHT_DEFAULT;
    }
}
