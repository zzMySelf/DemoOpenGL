package com.baidu.searchbox.feed.tab.config;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.media.PreloadUIResUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.home.NewHomeFun;
import com.baidu.searchbox.feed.tab.model.TabController;
import com.baidu.searchbox.feed.tab.update.LottieInfo;
import com.baidu.searchbox.feed.tab.update.TabNameImageModel;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.homepage.extend.IHomeFun;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.view.BadgeView;
import java.lang.ref.WeakReference;

public class FeedTabConfig extends DefaultSlidingTabConfig {
    private static final int FULL_ALPHA = 255;
    private static final float NAME_IMG_CHANGE_RATIO = 0.6f;
    private static final String TAG = "FeedTabConfig";
    private WeakReference<Context> contextRef;
    public float mCurrentBgOffsetRatio = 0.0f;

    public void setContext(Context context) {
        this.contextRef = new WeakReference<>(context);
    }

    public String getPlacementTabId() {
        if (FeedAnimABTestManager.Companion.getInstance().getShowNewAnim()) {
            return "1";
        }
        return null;
    }

    public int getTabSpaceLineBgColor() {
        int defaultColor = ContextCompat.getColor(FeedRuntime.getAppContext(), R.color.feed_tab_spacing_line_bg);
        if ("".equals(this.mCurrentSkin) || "1".equals(this.mCurrentSkin) || "3".equals(this.mCurrentSkin)) {
            return defaultColor;
        }
        return ColorUtils.blendARGB(defaultColor, ContextCompat.getColor(FeedRuntime.getAppContext(), R.color.feed_tab_dark_spacing_line_bg), this.mCurrentOffsetRatio);
    }

    public int getMultiTabBgColor() {
        String str;
        if (FeedUtil.isTabletBasic()) {
            return ContextCompat.getColor(FeedRuntime.getAppContext(), com.baidu.android.common.ui.style.R.color.GC86);
        }
        int resId = getMultiTabResIdByTheme(R.color.feed_tab_bg_at_homepage, R.color.feed_tab_light_bg_at_homepage, R.color.feed_tab_dark_bg_at_homepage);
        int defaultColor = ContextCompat.getColor(FeedRuntime.getAppContext(), R.color.feed_tab_bg_at_homepage);
        if (this.mCurrentMajor != null && this.mCurrentMajor.isResponse) {
            if (NightModeHelper.isNightMode()) {
                str = this.mCurrentMajor.tabBarBgNightColor;
            } else {
                str = this.mCurrentMajor.tabBarBgColor;
            }
            return com.baidu.searchbox.feed.tab.navigation.utils.ColorUtils.toggleColorSafe(str, R.color.feed_tab_bg_at_homepage);
        } else if (TextUtils.equals(this.mCurrentSkin, "") || TextUtils.equals(this.mCurrentSkin, "3")) {
            return defaultColor;
        } else {
            return ColorUtils.blendARGB(defaultColor, ContextCompat.getColor(FeedRuntime.getAppContext(), resId), this.mCurrentBgOffsetRatio);
        }
    }

    public int getFeedTabUnderLineAlpha() {
        if (TextUtils.equals(this.mCurrentSkin, "") || TextUtils.equals(this.mCurrentSkin, "3")) {
            return 255;
        }
        return (int) (255.0f * (1.0f - this.mCurrentOffsetRatio));
    }

    public Drawable getPlusIconDrawable() {
        int normalId = getNormalDrawerIconRes();
        int resId = getMultiTabResIdByTheme(normalId, normalId, R.drawable.feed_tab_right_drawer_dark_icon, normalId);
        if (!"".equals(this.mCurrentSkin) && !"1".equals(this.mCurrentSkin) && !"3".equals(this.mCurrentSkin)) {
            return getLayerDrawableByOffsetRatio(FeedRuntime.getAppContext().getResources().getDrawable(normalId, (Resources.Theme) null), FeedRuntime.getAppContext().getResources().getDrawable(resId, (Resources.Theme) null));
        }
        Drawable plusIcon = FeedRuntime.getAppContext().getResources().getDrawable(resId, (Resources.Theme) null);
        plusIcon.setAlpha(255);
        return plusIcon;
    }

    private int getNormalDrawerIconRes() {
        if (NewHomeFun.INSTANCE.isNewHome()) {
            return R.drawable.feed_tab_right_drawer_icon_in_new_home;
        }
        return R.drawable.feed_tab_right_drawer_icon;
    }

    public Drawable getTTSIconV1Drawable() {
        int normalId = getNormalTTSRes();
        int resId = getMultiTabResIdByTheme(normalId, normalId, getDarkSkinTTSRes(), normalId);
        Drawable defaultTTSDrawable = PreloadUIResUtil.getPreloadedDrawable(normalId);
        if (defaultTTSDrawable == null) {
            defaultTTSDrawable = FeedRuntime.getAppContext().getResources().getDrawable(normalId);
        }
        defaultTTSDrawable.setAlpha(255);
        if ("".equals(this.mCurrentSkin) || "1".equals(this.mCurrentSkin) || "3".equals(this.mCurrentSkin)) {
            return defaultTTSDrawable;
        }
        return getLayerDrawableByOffsetRatio(defaultTTSDrawable, FeedRuntime.getAppContext().getResources().getDrawable(resId));
    }

    private int getNormalTTSRes() {
        if (FeedAbtestManager.isTtsIconNewStyle()) {
            return R.drawable.feed_tab_right_tts_icon_new;
        }
        if (NewHomeFun.INSTANCE.isNewHome()) {
            return R.drawable.feed_tab_right_tts_icon_in_new_home;
        }
        return R.drawable.feed_tab_right_tts_icon;
    }

    private int getDarkSkinTTSRes() {
        if (FeedAbtestManager.isTtsIconNewStyle()) {
            return R.drawable.feed_tab_right_tts_icon_dark_new;
        }
        return R.drawable.feed_tab_right_tts_icon_dark;
    }

    public Drawable getTTSIconV1PlayingDrawable() {
        Drawable skinDrawable;
        Drawable skinDarkDrawable;
        Drawable skinNotCeilingDrawable;
        Drawable skinNotCeilingDrawable2;
        if ("".equals(this.mCurrentSkin) || "1".equals(this.mCurrentSkin)) {
            if (FeedAbtestManager.isTtsIconNewStyle()) {
                skinDrawable = ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.feed_tab_right_tts_playing_icon_new, (Resources.Theme) null);
            } else {
                skinDrawable = ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.feed_tab_right_tts_playing_icon, (Resources.Theme) null);
            }
            if (skinDrawable != null) {
                skinDrawable.setAlpha(255);
            }
            return skinDrawable;
        } else if ("3".equals(this.mCurrentSkin)) {
            if (FeedAbtestManager.isTtsIconNewStyle()) {
                skinNotCeilingDrawable2 = ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.feed_tab_right_tts_playing_icon_new, (Resources.Theme) null);
            } else {
                skinNotCeilingDrawable2 = ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.feed_tab_right_tts_playing_icon, (Resources.Theme) null);
            }
            if (this.mCurrentMajor != null && this.mCurrentMajor.isResponse && this.mCurrentMajor.isTextLightColor) {
                if (FeedAbtestManager.isTtsIconNewStyle()) {
                    skinNotCeilingDrawable2 = ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.feed_tab_right_tts_playing_icon_new_dark, (Resources.Theme) null);
                } else {
                    skinNotCeilingDrawable2 = ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.feed_tab_right_tts_playing_icon_dark, (Resources.Theme) null);
                }
            }
            skinNotCeilingDrawable2.setAlpha(255);
            return skinNotCeilingDrawable2;
        } else {
            if (FeedAbtestManager.isTtsIconNewStyle()) {
                skinNotCeilingDrawable = ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.feed_tab_right_tts_playing_icon_new, (Resources.Theme) null);
                skinDarkDrawable = ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.feed_tab_right_tts_playing_icon_new_dark, (Resources.Theme) null);
            } else {
                skinNotCeilingDrawable = ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.feed_tab_right_tts_playing_skin_not_ceiling_icon, (Resources.Theme) null);
                skinDarkDrawable = ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.feed_tab_right_tts_playing_icon_dark, (Resources.Theme) null);
            }
            return getLayerDrawableByOffsetRatio(skinNotCeilingDrawable, skinDarkDrawable);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getMultiTabResIdByTheme(int r3, int r4, int r5) {
        /*
            r2 = this;
            java.lang.String r0 = r2.mCurrentSkin
            int r1 = r0.hashCode()
            switch(r1) {
                case 0: goto L_0x0028;
                case 48: goto L_0x001e;
                case 49: goto L_0x0014;
                case 51: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0032
        L_0x000a:
            java.lang.String r1 = "3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 1
            goto L_0x0033
        L_0x0014:
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 2
            goto L_0x0033
        L_0x001e:
            java.lang.String r1 = "0"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 3
            goto L_0x0033
        L_0x0028:
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 0
            goto L_0x0033
        L_0x0032:
            r0 = -1
        L_0x0033:
            switch(r0) {
                case 0: goto L_0x003c;
                case 1: goto L_0x003c;
                case 2: goto L_0x003a;
                case 3: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            r0 = r3
            goto L_0x003e
        L_0x0038:
            r0 = r5
            goto L_0x003e
        L_0x003a:
            r0 = r4
            goto L_0x003e
        L_0x003c:
            r0 = r3
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.tab.config.FeedTabConfig.getMultiTabResIdByTheme(int, int, int):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getMultiTabResIdByTheme(int r3, int r4, int r5, int r6) {
        /*
            r2 = this;
            java.lang.String r0 = r2.mCurrentSkin
            int r1 = r0.hashCode()
            switch(r1) {
                case 48: goto L_0x0014;
                case 51: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x001e
        L_0x000a:
            java.lang.String r1 = "3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 1
            goto L_0x001f
        L_0x0014:
            java.lang.String r1 = "0"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0009
            r0 = 0
            goto L_0x001f
        L_0x001e:
            r0 = -1
        L_0x001f:
            switch(r0) {
                case 0: goto L_0x0026;
                case 1: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            r0 = r3
            goto L_0x0028
        L_0x0024:
            r0 = r6
            goto L_0x0028
        L_0x0026:
            r0 = r5
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.tab.config.FeedTabConfig.getMultiTabResIdByTheme(int, int, int, int):int");
    }

    private LayerDrawable getLayerDrawableByOffsetRatio(Drawable defaultDrawable, Drawable skinDrawable) {
        int skinAlpha = (int) (this.mCurrentOffsetRatio * 255.0f);
        skinDrawable.setAlpha(skinAlpha);
        defaultDrawable.setAlpha(255 - skinAlpha);
        return new LayerDrawable(new Drawable[]{skinDrawable, defaultDrawable});
    }

    public boolean isNeedUpdateUi(String skin, float offsetRatio) {
        if (!TextUtils.equals(this.mCurrentSkin, skin) || this.mCurrentOffsetRatio != offsetRatio) {
            return true;
        }
        return false;
    }

    public void setCurrentBgOffsetRatio(float bgOffsetRatio) {
        this.mCurrentBgOffsetRatio = bgOffsetRatio;
    }

    public float getCurrentBgOffsetRatio() {
        return this.mCurrentBgOffsetRatio;
    }

    public String getNameImg(TabNameImageModel tabNameImageModel) {
        boolean isSelected = isTabSelected(tabNameImageModel.getTabId());
        boolean isHomeState = isHomeState();
        if (NightModeHelper.getNightModeSwitcherState()) {
            if (isSelected) {
                return tabNameImageModel.getNightModeImageSelected();
            }
            if (!"1".equals(this.mCurrentSkin) && !"0".equals(this.mCurrentSkin)) {
                return isHomeState ? tabNameImageModel.getNightModeImageNoBack() : tabNameImageModel.getNightModeImageUnroofedNoBack();
            }
            if (isHomeState) {
                return tabNameImageModel.getNightModeImageUnroofed();
            }
            return tabNameImageModel.getNightModeImage();
        } else if (!"1".equals(this.mCurrentSkin) || this.mCurrentOffsetRatio <= 0.6f) {
            if (!"0".equals(this.mCurrentSkin) || this.mCurrentOffsetRatio <= 0.6f) {
                if (isSelected) {
                    return tabNameImageModel.getGeneralImageSelected();
                }
                if (isHomeState) {
                    return tabNameImageModel.getGeneralImageUnroofed();
                }
                return tabNameImageModel.getGeneralImage();
            } else if (isSelected) {
                return tabNameImageModel.getDarkSkinImageSelected();
            } else {
                if (isHomeState) {
                    return tabNameImageModel.getDarkSkinImageUnroofed();
                }
                return tabNameImageModel.getDarkSkinImage();
            }
        } else if (isSelected) {
            return tabNameImageModel.getLightSkinImageSelected();
        } else {
            if (isHomeState) {
                return tabNameImageModel.getLightSkinImageUnroofed();
            }
            return tabNameImageModel.getLightSkinImage();
        }
    }

    private boolean isTabSelected(String tabId) {
        return TextUtils.equals(TabController.INSTANCE.getCurrentChannelId(), tabId);
    }

    private boolean isHomeState() {
        return ((IHomeFun) ServiceManager.getService(IHomeFun.SERVICE_REFERENCE)).getHomeState() == 0;
    }

    public float getNameImgOffset() {
        if (NewHomeFun.INSTANCE.isNewHome()) {
            return 0.0f;
        }
        return (float) FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.tab.R.dimen.feed_tab_title_img_y_offset);
    }

    public Drawable getBadgeDrawable() {
        if ("0".equals(this.mCurrentSkin)) {
            return AppRuntime.getAppContext().getResources().getDrawable(com.baidu.searchbox.feed.tab.R.drawable.feed_tab_badge_dark_skin);
        }
        return AppRuntime.getAppContext().getResources().getDrawable(com.baidu.searchbox.feed.tab.R.drawable.feed_tab_badge);
    }

    public Drawable getBadgeDrawable(BadgeView.Type tipType) {
        if (tipType != BadgeView.Type.DOT) {
            return null;
        }
        if ("0".equals(this.mCurrentSkin)) {
            return AppRuntime.getAppContext().getResources().getDrawable(com.baidu.searchbox.feed.tab.R.drawable.feed_tab_badge_dark_skin);
        }
        return AppRuntime.getAppContext().getResources().getDrawable(com.baidu.searchbox.feed.tab.R.drawable.feed_tab_badge);
    }

    public boolean supportSlideLeft() {
        return FeedAnimABTestManager.Companion.getInstance().getShowNewAnim();
    }

    public int getRoundRadius() {
        return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_J_X11);
    }

    public int getIndicatorThickness() {
        if (FeedUtil.isSimpleHome()) {
            return DeviceUtils.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 2.0f);
        }
        return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_H_X14);
    }

    public int getIndicatorWidth() {
        if (FeedAbtestManager.isFeedTabUiOpt()) {
            return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_W_X14);
        }
        int width = FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_W_X12);
        if (FeedUtil.isSimpleHome()) {
            return width + 6;
        }
        return width;
    }

    public int getSelectedTabOffset() {
        if (FeedAnimABTestManager.Companion.getInstance().getShowNewAnim()) {
            return -((int) (((double) FeedRuntime.getAppContext().getResources().getDisplayMetrics().widthPixels) * 0.15d));
        }
        return 0;
    }

    public boolean getNameImgColorFilter() {
        return false;
    }

    public String getLottieUrl(LottieInfo lottieInfo) {
        boolean isSelected = isTabSelected(lottieInfo.getTabId());
        boolean isHomeState = isHomeState();
        if (!"1".equals(this.mCurrentSkin) || this.mCurrentOffsetRatio <= 0.6f) {
            if (!"0".equals(this.mCurrentSkin) || this.mCurrentOffsetRatio <= 0.6f) {
                return isSelected ? NightModeHelper.isNightMode() ? lottieInfo.getNightUrlSelect() : lottieInfo.getNormalUrlSelect() : isHomeState ? NightModeHelper.isNightMode() ? lottieInfo.getNightUrlUnroofed() : lottieInfo.getNormalUrlUnroofed() : NightModeHelper.isNightMode() ? lottieInfo.getNightUrl() : lottieInfo.getNormalUrl();
            }
            if (isSelected) {
                return lottieInfo.getDarkUrlSelect();
            }
            if (isHomeState) {
                return lottieInfo.getDarkUrlUnroofed();
            }
            return lottieInfo.getDarkUrl();
        } else if (isSelected) {
            return lottieInfo.getLightUrlSelect();
        } else {
            if (isHomeState) {
                return lottieInfo.getLightUrlUnroofed();
            }
            return lottieInfo.getLightUrl();
        }
    }

    public int getTextSizeMode() {
        if (FeedAbtestManager.isFeedTabUiOpt()) {
            return 1;
        }
        return super.getTextSizeMode();
    }

    public int getSelectedTextSize() {
        if (FeedAbtestManager.isFeedTabUiOpt()) {
            return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.tab.R.dimen.feed_tab_selected_tab_text_size_opt);
        }
        return super.getSelectedTextSize();
    }

    public int getUnselectedTextSize() {
        if (FeedAbtestManager.isFeedTabUiOpt()) {
            return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.tab.R.dimen.feed_tab_unselected_tab_text_size_opt);
        }
        return super.getUnselectedTextSize();
    }

    public boolean isBoldForUnSelectedText() {
        if (FeedUtil.isTabletBasic()) {
            return FeedUtil.isPadHorizontalBasic(obtainContext());
        }
        return super.isBoldForUnSelectedText();
    }

    private Context obtainContext() {
        WeakReference<Context> weakReference = this.contextRef;
        if (weakReference == null || weakReference.get() == null) {
            return BdBoxActivityManager.getRealTopActivity();
        }
        return (Context) this.contextRef.get();
    }

    public int getNormalTextSize() {
        Context activity = obtainContext();
        if (FeedUtil.isTabletBasic()) {
            if (FeedUtil.isPadHorizontalBasic(activity)) {
                return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_T_X052);
            }
        } else if (FeedUtil.needRespondTabWordSizeOpt(activity)) {
            return FeedRuntime.getAppContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_T_X063);
        }
        return super.getNormalTextSize();
    }

    public float getIndicatorBottomMargin() {
        if (FeedUtil.isSimpleHome()) {
            return DeviceUtils.ScreenInfo.dp2pxf(FeedRuntime.getAppContext(), 1.0f);
        }
        if (NewHomeFun.INSTANCE.isNewHome()) {
            return 0.0f;
        }
        if (TextUtils.equals(this.mCurrentSkin, "") || TextUtils.equals(this.mCurrentSkin, "3")) {
            return 1.0f;
        }
        return this.mCurrentOffsetRatio * ((float) (DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 1.0f) - 2));
    }
}
