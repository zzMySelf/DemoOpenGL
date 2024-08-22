package com.baidu.searchbox.searchboxbg.res;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.search.basic.utils.ResultPageABTest;
import com.baidu.searchbox.abtest.ioc.AbTestService;
import com.baidu.searchbox.bg.res.R;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.nacomp.extension.nightmode.ResWrapper;
import com.baidu.searchbox.searchboxbg.res.utils.BoxFontSizeExtKt;
import com.baidu.searchbox.searchboxbg.res.utils.NewStyleUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\rJ\n\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\rJ\n\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010\u0016\u001a\u00020\rH\u0007J\b\u0010\u0017\u001a\u00020\rH\u0007J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\u0014\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0006\u0010\u001e\u001a\u00020\u001aJ\b\u0010\u001f\u001a\u00020\u001aH\u0003R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/searchboxbg/res/BoxBgManager;", "", "()V", "abService", "Lcom/baidu/searchbox/abtest/ioc/AbTestService;", "getAbService", "()Lcom/baidu/searchbox/abtest/ioc/AbTestService;", "abService$delegate", "Lkotlin/Lazy;", "getBoxViewBgTheme", "Landroid/graphics/drawable/Drawable;", "getDrawable", "resID", "", "context", "Landroid/content/Context;", "getFloatBoxViewBg", "style", "getFloatBoxViewBgNotTheme", "getHissugBoxViewBg", "getHomeBoxViewBg", "getPadSearchBoxBg", "getPadSearchBtnBgRes", "getPadSearchBtnTextColorRes", "getResultPageBoxGroupCardBg", "isNight", "", "getResultPageBoxViewBg", "getVideoBoxViewBg", "getYouthBoxViewBg", "isBoldBackground", "isMourn", "lib-searchboxbg-res_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BoxBgManager.kt */
public final class BoxBgManager {
    public static final BoxBgManager INSTANCE = new BoxBgManager();
    private static final Lazy abService$delegate = LazyKt.lazy(BoxBgManager$abService$2.INSTANCE);

    private BoxBgManager() {
    }

    private final AbTestService getAbService() {
        return (AbTestService) abService$delegate.getValue();
    }

    public final Drawable getFloatBoxViewBg(int style) {
        if (style == 2002) {
            return getBoxViewBgTheme();
        }
        return getFloatBoxViewBgNotTheme();
    }

    public final Drawable getHomeBoxViewBg(int style) {
        if (style == 1002) {
            return getBoxViewBgTheme();
        }
        if (!NightModeHelper.getNightModeSwitcherState()) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            GradientDrawable $this$getHomeBoxViewBg_u24lambda_u2d0 = gradientDrawable;
            $this$getHomeBoxViewBg_u24lambda_u2d0.setShape(0);
            $this$getHomeBoxViewBg_u24lambda_u2d0.setCornerRadius(((float) SearchBoxBg.getBorderRadius()) * 1.0f);
            $this$getHomeBoxViewBg_u24lambda_u2d0.setColor(SearchBoxBg.getBgColor(style));
            $this$getHomeBoxViewBg_u24lambda_u2d0.setStroke(SearchBoxBg.getBorderWidth(style), SearchBoxBg.getBorderColor(style));
            return gradientDrawable;
        } else if (NewStyleUtils.INSTANCE.isNightNew()) {
            return getDrawable(R.drawable.searchbox_bg_night_new);
        } else {
            return getDrawable(R.drawable.searchbox_bg_home_float);
        }
    }

    private final Drawable getFloatBoxViewBgNotTheme() {
        if (NightModeHelper.getNightModeSwitcherState()) {
            if (NewStyleUtils.INSTANCE.isNightNew()) {
                return getDrawable(R.drawable.searchbox_bg_night_new);
            }
            return getDrawable(R.drawable.searchbox_bg_home_float);
        } else if (isBoldBackground()) {
            return getDrawable(R.drawable.searchbox_bg_home_float_big);
        } else {
            return getDrawable(R.drawable.searchbox_bg_home_float);
        }
    }

    public final Drawable getBoxViewBgTheme() {
        if (NightModeHelper.getNightModeSwitcherState()) {
            if (NewStyleUtils.INSTANCE.isNightNew()) {
                return getDrawable(R.drawable.searchbox_bg_night_new);
            }
            return getDrawable(R.drawable.searchbox_bg_home_theme);
        } else if (isBoldBackground()) {
            return getDrawable(R.drawable.searchbox_bg_home_theme_big);
        } else {
            return getDrawable(R.drawable.searchbox_bg_home_theme);
        }
    }

    public final Drawable getYouthBoxViewBg(Context context) {
        if (YouthSearchBoxManager.INSTANCE.isYouthBoxEnhance1() || YouthSearchBoxManager.INSTANCE.isYouthBoxEnhance2()) {
            if (isBoldBackground()) {
                return getDrawable(R.drawable.searchbox_bg_youth_enhance_big, context);
            }
            return getDrawable(R.drawable.searchbox_bg_youth_enhance, context);
        } else if (isBoldBackground()) {
            return getDrawable(R.drawable.searchbox_bg_youth_big, context);
        } else {
            return getDrawable(R.drawable.searchbox_bg_youth, context);
        }
    }

    public final Drawable getHissugBoxViewBg(Context context) {
        if (YouthSearchBoxManager.INSTANCE.isYouthStyle()) {
            return getYouthBoxViewBg(context);
        }
        if (NightModeHelper.getNightModeSwitcherState()) {
            if (NewStyleUtils.INSTANCE.isNightNew()) {
                return getDrawable(R.drawable.searchbox_bg_night_new, context);
            }
            return getDrawable(R.drawable.searchbox_bg_hissug_and_result_page, context);
        } else if (isBoldBackground()) {
            if (NewStyleUtils.INSTANCE.isBoxEnhance()) {
                return getDrawable(R.drawable.searchbox_bg_bold_enhance, context);
            }
            if (ResultPageABTest.isChangeSearchBoxBg()) {
                return getDrawable(R.drawable.searchbox_bg_hissug_and_result_page_stronger_big, context);
            }
            return getDrawable(R.drawable.searchbox_bg_hissug_and_result_page_big, context);
        } else if (NewStyleUtils.INSTANCE.isBoxEnhance()) {
            return getDrawable(R.drawable.searchbox_bg_enhance, context);
        } else {
            if (ResultPageABTest.isChangeSearchBoxBg()) {
                return getDrawable(R.drawable.searchbox_bg_hissug_and_result_page_stronger, context);
            }
            return getDrawable(R.drawable.searchbox_bg_hissug_and_result_page, context);
        }
    }

    public final boolean isBoldBackground() {
        if (BoxFontSizeExtKt.getBoxFontSize() >= 3) {
            return true;
        }
        return false;
    }

    public final Drawable getResultPageBoxViewBg(Context context, boolean isNight) {
        if (YouthSearchBoxManager.INSTANCE.isYouthStyle()) {
            return getYouthBoxViewBg(context);
        }
        if (isNight) {
            if (NewStyleUtils.INSTANCE.isNightNew()) {
                return getDrawable(R.drawable.searchbox_bg_night_new, context);
            }
            return getDrawable(R.drawable.searchbox_bg_hissug_and_result_page_night, context);
        } else if (isBoldBackground()) {
            if (NewStyleUtils.INSTANCE.isBoxEnhance()) {
                return getDrawable(R.drawable.searchbox_bg_bold_enhance, context);
            }
            if (ResultPageABTest.isChangeSearchBoxBg()) {
                return getDrawable(R.drawable.searchbox_bg_hissug_and_result_page_stronger_big_day, context);
            }
            return getDrawable(R.drawable.searchbox_bg_hissug_and_result_page_big_day, context);
        } else if (NewStyleUtils.INSTANCE.isBoxEnhance()) {
            return getDrawable(R.drawable.searchbox_bg_enhance, context);
        } else {
            if (ResultPageABTest.isChangeSearchBoxBg()) {
                return getDrawable(R.drawable.searchbox_bg_hissug_and_result_page_stronger_day, context);
            }
            return getDrawable(R.drawable.searchbox_bg_hissug_and_result_page_day, context);
        }
    }

    public final Drawable getResultPageBoxGroupCardBg(Context context, boolean isNight) {
        if (context == null || isNight) {
            return null;
        }
        if (YouthSearchBoxManager.INSTANCE.isYouthStyle()) {
            return AppCompatResources.getDrawable(context, R.drawable.searchbox_panel_youth_bg);
        }
        if (NewStyleUtils.INSTANCE.isBoxEnhance()) {
            return AppCompatResources.getDrawable(context, R.drawable.searchbox_panel_bg_enhance);
        }
        return AppCompatResources.getDrawable(context, R.drawable.searchbox_panel_bg);
    }

    public final Drawable getVideoBoxViewBg() {
        return getDrawable(R.drawable.searchbox_bg_home_float);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r1 = r1.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.drawable.Drawable getDrawable(int r3) {
        /*
            r2 = this;
            android.graphics.drawable.Drawable r0 = com.baidu.android.util.media.PreloadUIResUtil.getPreloadedDrawable(r3)
            if (r0 != 0) goto L_0x0019
            android.content.Context r1 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            if (r1 == 0) goto L_0x0017
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x0017
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            goto L_0x001a
        L_0x0017:
            r1 = 0
            goto L_0x001a
        L_0x0019:
            r1 = r0
        L_0x001a:
            r0 = r1
            if (r0 != 0) goto L_0x0026
            android.content.Context r1 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            android.graphics.drawable.Drawable r1 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r1, r3)
            goto L_0x0027
        L_0x0026:
            r1 = r0
        L_0x0027:
            r0 = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.searchboxbg.res.BoxBgManager.getDrawable(int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r1 = r4.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.graphics.drawable.Drawable getDrawable(int r3, android.content.Context r4) {
        /*
            r2 = this;
            r0 = 0
            boolean r1 = com.baidu.searchbox.skin.NightModeHelper.getNightModeSwitcherState()
            if (r1 != 0) goto L_0x000d
            com.baidu.search.preload.SearchPreloadDrawableUtils r1 = com.baidu.search.preload.SearchPreloadDrawableUtils.INSTANCE
            android.graphics.drawable.Drawable r0 = r1.getPreloadedDrawable(r3)
        L_0x000d:
            if (r0 != 0) goto L_0x001e
            if (r4 == 0) goto L_0x001c
            android.content.res.Resources r1 = r4.getResources()
            if (r1 == 0) goto L_0x001c
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            goto L_0x001f
        L_0x001c:
            r1 = 0
            goto L_0x001f
        L_0x001e:
            r1 = r0
        L_0x001f:
            r0 = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.searchboxbg.res.BoxBgManager.getDrawable(int, android.content.Context):android.graphics.drawable.Drawable");
    }

    private final boolean isMourn() {
        AbTestService abService = getAbService();
        if (abService != null) {
            return abService.getSwitch("global_mourn_switch", false);
        }
        return false;
    }

    public final Drawable getPadSearchBoxBg() {
        if (isMourn()) {
            return ResWrapper.getDrawable(AppRuntime.getAppContext(), R.drawable.pad_search_box_bg_mourn);
        }
        return ResWrapper.getDrawable(AppRuntime.getAppContext(), R.drawable.pad_search_box_bg);
    }

    public final int getPadSearchBtnBgRes() {
        if (isMourn()) {
            return R.drawable.pad_input_box_search_btn_bg_mourn;
        }
        return R.drawable.pad_input_box_search_btn_bg;
    }

    public final int getPadSearchBtnTextColorRes() {
        if (isMourn()) {
            return R.color.box_search_btn_text_color_mourn;
        }
        return com.baidu.android.common.ui.style.R.color.GC7;
    }
}
