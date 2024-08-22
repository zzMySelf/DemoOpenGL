package com.baidu.searchbox.userassetsaggr.container;

import android.preference.PreferenceManager;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.search.tab.debug.SearchVideoDebugConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/userassetsaggr/container/FavorHisAbTestManager;", "", "()V", "AB_SWITCH_MOVIES_FAVOR", "", "FAVOR_FEED_VIDEO_NEW_FAVORITE_DEFAULT", "", "FAVOR_FEED_VIDEO_NEW_FAVORITE_EXP", "FAVOR_FEED_VIDEO_NEW_FAVORITE_SWITCH_KEY", "FAVOR_HIS_BETTER_STYLE_SWITCH_KEY", "FAVOR_HIS_VIDEO_TEMPLATE_SWITCH_KEY", "FAVOR_HIS_WEB_VIDEO_SWITCH_KEY", "VIDEO_TYPE_CONTROL_GROUP", "VIDEO_TYPE_EXPERIMENTAL_GROUP1", "VIDEO_TYPE_EXPERIMENTAL_GROUP2", "WEB_VIDEO_CONTROL_GROUP", "WEB_VIDEO_EXPERIMENTAL_GROUP1", "WEB_VIDEO_EXPERIMENTAL_GROUP2", "sHasVideoType", "", "sVideoType", "sWebVideoType", "getFavorHisBetterStyleSwitch", "getFavorPanelCreateNewFolderStyle", "getMoviesAb", "getVideoType", "getWebVideoType", "isHitVideoExperimental", "isHitWebVideoExperimental", "lib-favorHis-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorHisAbTestManager.kt */
public final class FavorHisAbTestManager {
    public static final String AB_SWITCH_MOVIES_FAVOR = "switch_movies_favor";
    public static final int FAVOR_FEED_VIDEO_NEW_FAVORITE_DEFAULT = 0;
    public static final int FAVOR_FEED_VIDEO_NEW_FAVORITE_EXP = 1;
    private static final String FAVOR_FEED_VIDEO_NEW_FAVORITE_SWITCH_KEY = "feed_video_new_favorite_switch_android";
    private static final String FAVOR_HIS_BETTER_STYLE_SWITCH_KEY = "favor_his_better_style";
    private static final String FAVOR_HIS_VIDEO_TEMPLATE_SWITCH_KEY = "video_type";
    private static final String FAVOR_HIS_WEB_VIDEO_SWITCH_KEY = "web_video";
    public static final FavorHisAbTestManager INSTANCE = new FavorHisAbTestManager();
    public static final String VIDEO_TYPE_CONTROL_GROUP = "0";
    public static final String VIDEO_TYPE_EXPERIMENTAL_GROUP1 = "1";
    public static final String VIDEO_TYPE_EXPERIMENTAL_GROUP2 = "2";
    public static final String WEB_VIDEO_CONTROL_GROUP = "0";
    public static final String WEB_VIDEO_EXPERIMENTAL_GROUP1 = "1";
    public static final String WEB_VIDEO_EXPERIMENTAL_GROUP2 = "2";
    private static volatile boolean sHasVideoType;
    private static String sVideoType = "0";
    private static String sWebVideoType = "0";

    private FavorHisAbTestManager() {
    }

    public final boolean getFavorHisBetterStyleSwitch() {
        return true;
    }

    public final String getVideoType() {
        if (!sHasVideoType) {
            String str = AbTestManager.getInstance().getSwitch("video_type", "0");
            Intrinsics.checkNotNullExpressionValue(str, "getInstance()\n          …VIDEO_TYPE_CONTROL_GROUP)");
            sVideoType = str;
            sHasVideoType = true;
        }
        return sVideoType;
    }

    public final boolean isHitVideoExperimental() {
        return !Intrinsics.areEqual((Object) getVideoType(), (Object) "0");
    }

    public final String getWebVideoType() {
        String str = AbTestManager.getInstance().getSwitch("web_video", "0");
        Intrinsics.checkNotNullExpressionValue(str, "getInstance()\n          … WEB_VIDEO_CONTROL_GROUP)");
        sWebVideoType = str;
        return str;
    }

    public final boolean isHitWebVideoExperimental() {
        return !Intrinsics.areEqual((Object) getWebVideoType(), (Object) "0");
    }

    public final int getFavorPanelCreateNewFolderStyle() {
        return AbTestManager.getInstance().getSwitch(FAVOR_FEED_VIDEO_NEW_FAVORITE_SWITCH_KEY, 0);
    }

    public final boolean getMoviesAb() {
        boolean z = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean(AB_SWITCH_MOVIES_FAVOR, false);
        if (AbTestManager.getInstance().getSwitch(SearchVideoDebugConfig.SEARCH_VIDEO_FAVOR_AGG, false) || z) {
            return true;
        }
        return false;
    }
}
