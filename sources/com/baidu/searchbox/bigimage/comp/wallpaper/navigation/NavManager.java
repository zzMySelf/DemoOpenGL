package com.baidu.searchbox.bigimage.comp.wallpaper.navigation;

import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.bigimage.comp.page.image.header.PageCountManager;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.utils.ImageParamsExtKt;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u001f\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\rJ\b\u0010\u000e\u001a\u00020\u0004H\u0002J\r\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\r\u0010\u0012\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/wallpaper/navigation/NavManager;", "", "()V", "isShowStrongNav", "", "params", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "isShowStrongNav$lib_search_bigimage_release", "isShowWeakNav", "isShowWeakNav$lib_search_bigimage_release", "isSupportWallpaperPreview", "isSupportWallpaperPreview$lib_search_bigimage_release", "isUsedNavFunc", "visitedNavBigImgCount", "", "visitedNavBigImgCount$lib_search_bigimage_release", "weakNavShowCount", "weakNavShowCount$lib_search_bigimage_release", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NavManager.kt */
public final class NavManager {
    public static final NavManager INSTANCE = new NavManager();

    private NavManager() {
    }

    private final boolean isUsedNavFunc() {
        return PreferenceUtils.getBoolean(NavConstanceKt.NAVIGATION_USE_STATE, false);
    }

    public final int visitedNavBigImgCount$lib_search_bigimage_release() {
        return PreferenceUtils.getInt(NavConstanceKt.NAV_VISITED_BIG_IMG_COUNT, 0);
    }

    private final boolean isShowStrongNav() {
        return PreferenceUtils.getBoolean(NavConstanceKt.NAVIGATION_STRONG_SHOW_STATE, false);
    }

    public final int weakNavShowCount$lib_search_bigimage_release() {
        return PreferenceUtils.getInt(NavConstanceKt.NAVIGATION_WEAK_SHOW_COUNT, 0);
    }

    public final boolean isShowStrongNav$lib_search_bigimage_release(ImagePageParams params, UniqueId token) {
        Intrinsics.checkNotNullParameter(token, "token");
        if (params != null && PageCountManager.INSTANCE.isNormalBrowserMode$lib_search_bigimage_release(token) && !isUsedNavFunc() && !isShowStrongNav() && isSupportWallpaperPreview$lib_search_bigimage_release(params) && !ImageParamsExtKt.isShowGestureGuide(params)) {
            return true;
        }
        return false;
    }

    public final boolean isSupportWallpaperPreview$lib_search_bigimage_release(ImagePageParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return !params.isFromRelated() && ImageParamsExtKt.supportWallpaperPreview(params.getExtraParams());
    }

    public final boolean isShowWeakNav$lib_search_bigimage_release(ImagePageParams params, UniqueId token) {
        Intrinsics.checkNotNullParameter(token, "token");
        if (params != null && !isUsedNavFunc() && isSupportWallpaperPreview$lib_search_bigimage_release(params) && isShowStrongNav() && PageCountManager.INSTANCE.isNormalBrowserMode$lib_search_bigimage_release(token)) {
            return true;
        }
        return false;
    }
}
