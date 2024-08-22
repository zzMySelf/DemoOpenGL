package com.baidu.searchbox.home;

import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.home.search.pyramid.SearchBoxABInterface;
import com.baidu.searchbox.home.tools.R;
import com.baidu.searchbox.searchboxbg.res.InputBoxDimenManager;
import com.baidu.searchbox.widget.ImmersionHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\nH\u0007J\b\u0010\u0017\u001a\u00020\nH\u0007J\b\u0010\u0018\u001a\u00020\nH\u0007J\b\u0010\u0019\u001a\u00020\nH\u0007J\b\u0010\u001a\u001a\u00020\nH\u0007J\b\u0010\u001b\u001a\u00020\nH\u0007J\b\u0010\u001c\u001a\u00020\nH\u0007J\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\b\u0010\"\u001a\u00020\nH\u0007R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/home/HomeDimenManager;", "", "()V", "boxAbService", "Lcom/baidu/searchbox/home/search/pyramid/SearchBoxABInterface;", "getBoxAbService", "()Lcom/baidu/searchbox/home/search/pyramid/SearchBoxABInterface;", "boxAbService$delegate", "Lkotlin/Lazy;", "mFloatSearchBoxTopMargin", "", "mHomeLogoBtmMargin", "mHomeLogoHeight", "mHomeLogoTopMargin", "mHomeSearchBoxLeftRightMargin", "getMHomeSearchBoxLeftRightMargin", "()I", "mHomeSearchBoxLeftRightMargin$delegate", "mHomeSearchBoxTopBottomMargin", "getMHomeSearchBoxTopBottomMargin", "mHomeSearchBoxTopBottomMargin$delegate", "mStatusBarHeight", "getFloatSearchBoxContainerHeight", "getFloatSearchBoxHeight", "getFloatSearchBoxTopMargin", "getHomeLogoBtmMargin", "getHomeLogoHeight", "getHomeLogoTopMargin", "getHomeSearchBoxTopBottomMargin", "getHomeSearchBoxTopMarginNoLogo", "getHomeSearchboxHeight", "getHomeSearchboxLeftRightMargin", "getImmersionScrollHeight", "getSearchBoxBtmMargin", "getStatusBarHeight", "lib-home-tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeDimenManager.kt */
public final class HomeDimenManager {
    public static final HomeDimenManager INSTANCE = new HomeDimenManager();
    private static final Lazy boxAbService$delegate = LazyKt.lazy(HomeDimenManager$boxAbService$2.INSTANCE);
    private static int mFloatSearchBoxTopMargin;
    private static int mHomeLogoBtmMargin;
    private static int mHomeLogoHeight;
    private static int mHomeLogoTopMargin;
    private static final Lazy mHomeSearchBoxLeftRightMargin$delegate = LazyKt.lazy(HomeDimenManager$mHomeSearchBoxLeftRightMargin$2.INSTANCE);
    private static final Lazy mHomeSearchBoxTopBottomMargin$delegate = LazyKt.lazy(HomeDimenManager$mHomeSearchBoxTopBottomMargin$2.INSTANCE);
    private static int mStatusBarHeight;

    private HomeDimenManager() {
    }

    /* access modifiers changed from: private */
    public final SearchBoxABInterface getBoxAbService() {
        return (SearchBoxABInterface) boxAbService$delegate.getValue();
    }

    private final int getMHomeSearchBoxLeftRightMargin() {
        return ((Number) mHomeSearchBoxLeftRightMargin$delegate.getValue()).intValue();
    }

    private final int getMHomeSearchBoxTopBottomMargin() {
        return ((Number) mHomeSearchBoxTopBottomMargin$delegate.getValue()).intValue();
    }

    public final int getHomeLogoTopMargin() {
        if (mHomeLogoTopMargin == 0) {
            mHomeLogoTopMargin = AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.home_logo_top_margin);
        }
        return mHomeLogoTopMargin;
    }

    public final int getHomeLogoHeight() {
        if (mHomeLogoHeight == 0) {
            mHomeLogoHeight = AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.home_logo_doodle_height);
        }
        return mHomeLogoHeight;
    }

    public final int getHomeLogoBtmMargin() {
        if (mHomeLogoBtmMargin == 0) {
            mHomeLogoBtmMargin = AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.home_logo_bottom_margin);
        }
        return mHomeLogoBtmMargin;
    }

    public final int getHomeSearchboxHeight() {
        return InputBoxDimenManager.INSTANCE.getHeaderSearchBoxHeight();
    }

    public final int getHomeSearchboxLeftRightMargin() {
        return getMHomeSearchBoxLeftRightMargin();
    }

    public final int getHomeSearchBoxTopBottomMargin() {
        return getMHomeSearchBoxTopBottomMargin();
    }

    public final int getSearchBoxBtmMargin() {
        return AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.home_searchbox_btm_margin);
    }

    public final int getHomeSearchBoxTopMarginNoLogo() {
        Number number;
        int top = AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.home_searchbox_top_margin_no_logo_top);
        int $this$scale$iv = R.dimen.home_searchbox_top_margin_no_logo_center;
        Class<Integer> cls = Integer.class;
        if (Intrinsics.areEqual((Object) cls, (Object) Integer.class)) {
            number = Integer.valueOf(FontSizeHelper.getScaledSizeRes(0, $this$scale$iv, 2));
        } else if (Intrinsics.areEqual((Object) cls, (Object) Float.class)) {
            number = (Integer) Float.valueOf(FontSizeHelper.getScaledSizeRes(0, $this$scale$iv));
        } else if (!AppConfig.isDebug()) {
            number = (Number) 0;
        } else {
            throw new RuntimeException("T only support Int or Float.");
        }
        int center = number.intValue();
        return top + center + AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.home_searchbox_top_margin_no_logo_bottom);
    }

    @StableApi
    public final int getStatusBarHeight() {
        if (mStatusBarHeight == 0) {
            mStatusBarHeight = DeviceUtil.ScreenInfo.getStatusBarHeight();
        }
        return mStatusBarHeight;
    }

    @StableApi
    public final int getFloatSearchBoxHeight() {
        return InputBoxDimenManager.INSTANCE.getFloatSearchBoxHeight();
    }

    @StableApi
    public final int getFloatSearchBoxTopMargin() {
        if (mFloatSearchBoxTopMargin == 0) {
            mFloatSearchBoxTopMargin = AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.home_float_searchbox_top_margin);
            if (ImmersionHelper.SUPPORT_IMMERSION) {
                mFloatSearchBoxTopMargin += getStatusBarHeight();
            }
        }
        return mFloatSearchBoxTopMargin;
    }

    @StableApi
    public final int getFloatSearchBoxContainerHeight() {
        return getFloatSearchBoxHeight() + getFloatSearchBoxTopMargin();
    }

    public final int getImmersionScrollHeight() {
        return getFloatSearchBoxContainerHeight() - getStatusBarHeight();
    }
}
