package com.baidu.swan.apps.landscapedevice;

import android.content.Context;
import com.baidu.swan.apps.adaptation.interfaces.ILandscapeDeviceConfig;
import com.baidu.swan.apps.ioc.SwanAppRuntime;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class LandscapeDeviceViewConfig {
    private static final float BANNER_AREA_RATIO = 0.3f;
    private static final float DEFAULT_CONTENT_RATIO_COLUMN_1 = 0.95f;
    private static final float DEFAULT_CONTENT_RATIO_COLUMN_2 = 0.65f;
    private static final float DEFAULT_CONTENT_RATIO_COLUMN_3 = 0.5f;
    private static final float HISTORY_AREA_RATIO = 0.14f;
    private static final float RATIO_THRESHOLD_ONE_COLUMN = 0.9f;
    private static final float RATIO_THRESHOLD_TWO_COLUMN = 1.3f;
    private static final float WIDTH_THRESHOLD_ONE_COLUMN = 750.0f;
    public int bannerWidth;
    public int contentMarginLeft;
    public int contentWidth;
    public int historyWidth;
    public int screenWidth;

    public String toString() {
        return "LandscapeDeviceViewConfig{screenWidth=" + this.screenWidth + ", historyWidth=" + this.historyWidth + ", bannerWidth=" + this.bannerWidth + ", contentWidth=" + this.contentWidth + ", contentMarginLeft=" + this.contentMarginLeft + AbstractJsonLexerKt.END_OBJ;
    }

    public static LandscapeDeviceViewConfig getCurrentLandscapeDeviceViewConfig() {
        float defaultContentRatio;
        Context context = SwanAppRuntime.getAppContext();
        int screenWidth2 = SwanAppUIUtils.getDisplayWidth(context);
        float widthHeightRatio = ((float) screenWidth2) / ((float) SwanAppUIUtils.getDisplayHeight(context));
        ILandscapeDeviceConfig.AdaptationType adaptationType = SwanAppRuntime.getLandscapeDeviceConfig().getAdaptationType();
        if (((float) screenWidth2) < WIDTH_THRESHOLD_ONE_COLUMN || widthHeightRatio <= 0.9f) {
            defaultContentRatio = DEFAULT_CONTENT_RATIO_COLUMN_1;
            adaptationType = ILandscapeDeviceConfig.AdaptationType.SHOW_CONTENT_ONLY;
        } else if (widthHeightRatio < 1.3f) {
            defaultContentRatio = 0.65f;
            if (adaptationType == ILandscapeDeviceConfig.AdaptationType.SHOW_ALL) {
                adaptationType = ILandscapeDeviceConfig.AdaptationType.SHOW_HISTORY_AND_CONTENT;
            }
        } else {
            defaultContentRatio = 0.5f;
        }
        ConfigBuilder builder = ConfigBuilder.builder(screenWidth2).setContentRatio(calculateContentRatio(defaultContentRatio));
        switch (AnonymousClass1.$SwitchMap$com$baidu$swan$apps$adaptation$interfaces$ILandscapeDeviceConfig$AdaptationType[adaptationType.ordinal()]) {
            case 1:
                return builder.build();
            case 2:
                return builder.showHistory().build();
            case 3:
                return builder.showBanner().build();
            default:
                return builder.showHistory().showBanner().build();
        }
    }

    /* renamed from: com.baidu.swan.apps.landscapedevice.LandscapeDeviceViewConfig$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$swan$apps$adaptation$interfaces$ILandscapeDeviceConfig$AdaptationType;

        static {
            int[] iArr = new int[ILandscapeDeviceConfig.AdaptationType.values().length];
            $SwitchMap$com$baidu$swan$apps$adaptation$interfaces$ILandscapeDeviceConfig$AdaptationType = iArr;
            try {
                iArr[ILandscapeDeviceConfig.AdaptationType.SHOW_CONTENT_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$swan$apps$adaptation$interfaces$ILandscapeDeviceConfig$AdaptationType[ILandscapeDeviceConfig.AdaptationType.SHOW_HISTORY_AND_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$swan$apps$adaptation$interfaces$ILandscapeDeviceConfig$AdaptationType[ILandscapeDeviceConfig.AdaptationType.SHOW_CONTENT_AND_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$baidu$swan$apps$adaptation$interfaces$ILandscapeDeviceConfig$AdaptationType[ILandscapeDeviceConfig.AdaptationType.SHOW_ALL.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private static float calculateContentRatio(float defaultValue) {
        float contentRatio = SwanAppRuntime.getLandscapeDeviceConfig().getSwanAppContentRatio();
        if (contentRatio == -1.0f) {
            return defaultValue;
        }
        return Math.min(Math.max(contentRatio, 0.35f), 1.0f);
    }

    private static class ConfigBuilder {
        private float mContentRatio;
        private final int mScreenWidth;
        private boolean mShowBanner;
        private boolean mShowHistory;

        public ConfigBuilder(int screenWidth) {
            this.mScreenWidth = screenWidth;
        }

        public ConfigBuilder setContentRatio(float contentRatio) {
            this.mContentRatio = contentRatio;
            return this;
        }

        public ConfigBuilder showHistory() {
            this.mShowHistory = true;
            return this;
        }

        public ConfigBuilder showBanner() {
            this.mShowBanner = true;
            return this;
        }

        public LandscapeDeviceViewConfig build() {
            LandscapeDeviceViewConfig config = new LandscapeDeviceViewConfig();
            config.screenWidth = this.mScreenWidth;
            float f2 = this.mContentRatio;
            boolean z = true;
            boolean canShowAll = (f2 + LandscapeDeviceViewConfig.HISTORY_AREA_RATIO) + 0.3f <= 1.0f;
            boolean canShowHistory = f2 + LandscapeDeviceViewConfig.HISTORY_AREA_RATIO <= 1.0f;
            if (f2 + 0.3f > 1.0f) {
                z = false;
            }
            boolean canShowBanner = z;
            boolean z2 = this.mShowHistory;
            if (z2 && this.mShowBanner && !canShowAll) {
                this.mShowBanner = false;
            }
            if (z2 && canShowHistory) {
                config.historyWidth = (int) (((float) this.mScreenWidth) * LandscapeDeviceViewConfig.HISTORY_AREA_RATIO);
            }
            if (this.mShowBanner && canShowBanner) {
                config.bannerWidth = (int) (((float) this.mScreenWidth) * 0.3f);
            }
            config.contentWidth = (int) (((float) this.mScreenWidth) * this.mContentRatio);
            config.contentMarginLeft = config.historyWidth + ((((this.mScreenWidth - config.historyWidth) - config.bannerWidth) - config.contentWidth) / 2);
            return config;
        }

        public static ConfigBuilder builder(int screenWidth) {
            return new ConfigBuilder(screenWidth);
        }
    }
}
