package com.baidu.searchbox.feed.dynamicdetail;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"COLD_RESTORE_DAU_REPORT_DELAY_TIME", "", "DYNAMIC_IMMERSIVE_FPS_FROM", "", "DYNAMIC_IMMERSIVE_FPS_PAGE", "DYNAMIC_IMMERSIVE_FPS_TYPE_SCROLL", "DYNAMIC_IMMERSIVE_IMG_CALLER_PAGE", "DYNAMIC_PRE_LOAD_NUM", "", "HEAT_MAP_LIMIT_COUNT", "SKELETON_SCREEN_LAYOUT", "TAG", "getTAG", "()Ljava/lang/String;", "requestTag", "lib-feed-dynamic-detail_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicImmersivePage.kt */
public final class DynamicImmersivePageKt {
    public static final long COLD_RESTORE_DAU_REPORT_DELAY_TIME = 5000;
    private static final String DYNAMIC_IMMERSIVE_FPS_FROM = "dynamic_immersive";
    private static final String DYNAMIC_IMMERSIVE_FPS_PAGE = "1";
    private static final String DYNAMIC_IMMERSIVE_FPS_TYPE_SCROLL = "scroll";
    private static final String DYNAMIC_IMMERSIVE_IMG_CALLER_PAGE = "dynamic_immersive";
    private static final int DYNAMIC_PRE_LOAD_NUM = 4;
    public static final int HEAT_MAP_LIMIT_COUNT = 50;
    public static final String SKELETON_SCREEN_LAYOUT = "dynamic_skeleton_screen";
    private static final String TAG;
    /* access modifiers changed from: private */
    public static String requestTag = "";

    static {
        String simpleName = DynamicImmersivePage.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "DynamicImmersivePage::class.java.simpleName");
        TAG = simpleName;
    }

    public static final String getTAG() {
        return TAG;
    }
}
