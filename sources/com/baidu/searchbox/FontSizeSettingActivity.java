package com.baidu.searchbox;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.ActionToolBarActivity;
import com.baidu.searchbox.appframework.ext.ActionBarExtKt;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.common.security.SecurityUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ubc.FontSizeUBC;
import com.baidu.searchbox.menu.font.FontBadgeManager;
import com.baidu.searchbox.menu.font.SliderBar;
import com.baidu.searchbox.menu.font.banner.FontBannerManagerKt;
import com.baidu.searchbox.menu.font.banner.FontBannerView;
import com.baidu.searchbox.toolbar.BaseToolBarExtKt;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.searchbox.unifiedtoolbar.option.BottomBarOptionFloatingBack;
import com.baidu.searchbox.unifiedtoolbar.option.UnifiedBottomBarOption;
import com.baidu.ubc.UBC;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class FontSizeSettingActivity extends ActionToolBarActivity {
    protected static final boolean DEBUG = AppConfig.isDebug();
    private static final float FONT_SIZE_CHANGE_ALPHA = 0.6f;
    private static final String TAG = "FontSizeSettingActivity";
    private boolean isFirstLoading = true;
    private int[] mBadgeMarginDimens = {R.dimen.dimen_ui_30, R.dimen.dimen_ui_30, R.dimen.dimen_ui_27, R.dimen.dimen_ui_22, R.dimen.dimen_ui_22};
    private float mBodyFontSizeStandard;
    /* access modifiers changed from: private */
    public TextView mBodyPreviewF;
    /* access modifiers changed from: private */
    public TextView mBodyPreviewS;
    private int mEnterFontSize = -1;
    private String mEnterFrom = "other";
    private BadgeView mFontBadge;
    /* access modifiers changed from: private */
    public FontBannerView mFontBannerView;
    private int mFontSize = -1;
    private ConstraintLayout mFontView;
    private final SettingDurationUbc mPageDurationUbc = new SettingDurationUbc();
    private SliderBar mSliderBar;
    private float mTitleFontSizeStandard;
    /* access modifiers changed from: private */
    public TextView mTitlePreview;
    private View mTopBart;
    private int slideBarTextSizeStandard;

    public void stableApiStub() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        UnifiedBottomBarExtKt.setUseUnifiedBottomBar(this, true);
        super.onCreate(savedInstanceState);
        if (!SecurityUtils.checkActivityRefuseServiceAndFinish(this)) {
            setContentView(com.baidu.searchbox.settings.R.layout.font_size_setting_layout);
            BdActionBar bdActionBar = ActionBarExtKt.getBdActionBar(this);
            if (bdActionBar != null) {
                bdActionBar.setTitle(com.baidu.searchbox.settings.R.string.font_setting);
            }
            initView();
            setPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
            setEnableSliding(true);
            this.mEnterFontSize = this.mFontSize + 1;
            Intent intent = getIntent();
            if (intent != null) {
                this.mEnterFrom = intent.getStringExtra(FontSizeUBC.FONT_SIZE_UBC_FROM_ENTER_KEY);
            }
            FontSizeUBC.fontSizeStatisticUBC("enter", this.mEnterFrom, String.valueOf(this.mFontSize + 1), getUbcValue(), (String) null, (JSONObject) null);
            updatePreviewUI();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        fontSizeUBCEvent(this.mFontSize + 1);
        FontSizeUBC.fontSizeStatisticUBC("change", this.mEnterFrom, String.valueOf(this.mEnterFontSize), String.valueOf(this.mFontSize + 1), (String) null, (JSONObject) null);
    }

    private void initView() {
        ActionBarExtKt.showActionBarWithoutLeft(this);
        this.mSliderBar = (SliderBar) findViewById(com.baidu.searchbox.settings.R.id.sliderbar);
        this.mTitlePreview = (TextView) findViewById(com.baidu.searchbox.settings.R.id.text_title_preview);
        this.mBodyPreviewF = (TextView) findViewById(com.baidu.searchbox.settings.R.id.text_body_preview_f);
        this.mBodyPreviewS = (TextView) findViewById(com.baidu.searchbox.settings.R.id.text_body_preview_s);
        this.mTopBart = findViewById(com.baidu.searchbox.settings.R.id.text_preview);
        this.mFontBannerView = (FontBannerView) findViewById(com.baidu.searchbox.settings.R.id.font_banner_view);
        this.mFontView = (ConstraintLayout) findViewById(com.baidu.searchbox.settings.R.id.font_view);
        this.mFontBadge = (BadgeView) findViewById(com.baidu.searchbox.settings.R.id.font_badge);
        if (FontBadgeManager.INSTANCE.isNeedShowBadge()) {
            updateBadgeIfNeed();
        } else {
            this.mFontBadge.setVisibility(8);
            this.mFontBadge = null;
        }
        Resources res = getResources();
        this.mTitleFontSizeStandard = (float) res.getDimensionPixelSize(com.baidu.searchbox.settings.R.dimen.title_preview_font_size_standard);
        this.mBodyFontSizeStandard = (float) res.getDimensionPixelSize(com.baidu.searchbox.settings.R.dimen.body_preview_font_size_standard);
        int textSizeIndex = FontSizeConfig.getFontSize(getApplicationContext());
        selectFontSize(textSizeIndex);
        this.mSliderBar.setTickCount(5, FontSizeConfig.getFontLevelTextArray());
        this.mSliderBar.setThumbIndex(textSizeIndex);
        this.mSliderBar.setStyle(SliderBar.Style.RECTANGLE);
        this.mSliderBar.setOnSliderBarChangeListener(new SliderBar.OnSliderBarChangeListener() {
            public void onIndexChanged(SliderBar rangeBar, int index) {
                FontSizeSettingActivity.this.updatePreviewUI();
                int textSizeIndex = FontSizeConfig.getFontSizeByFontSliderBarIndex(index);
                FontSizeSettingActivity.this.selectFontSize(textSizeIndex);
                FontSizeSettingActivity.this.resetSlideBarTextSize();
                FontSizeSettingActivity.this.resetSlideBarHeight();
                if (FontSizeSettingActivity.this.mFontBannerView.getVisibility() != 0 && FontBannerManagerKt.checkShouldShow(textSizeIndex)) {
                    FontSizeSettingActivity.this.calcFontBannerHeight();
                    FontSizeSettingActivity.this.mFontBannerView.animShow(1);
                    FontSizeSettingActivity.this.mFontBannerView.showCloseBtn(true);
                    FontSizeSettingActivity.this.mFontBannerView.setOnDismissListener(new FontBannerView.OnDismissListener() {
                        public void onDismiss() {
                            FontSizeSettingActivity.this.reloadUI();
                        }
                    });
                }
            }
        });
        initOrRefreshUI();
    }

    /* access modifiers changed from: private */
    public void resetSlideBarHeight() {
        Resources res;
        ViewGroup.LayoutParams lp;
        if (this.slideBarTextSizeStandard > 0 && (res = getResources()) != null) {
            int originHeight = res.getDimensionPixelSize(com.baidu.searchbox.settings.R.dimen.font_setting_font_slider_bar_height);
            int scaledSize = (int) FontSizeHelper.getScaledSize(0, (float) this.slideBarTextSizeStandard);
            SliderBar sliderBar = this.mSliderBar;
            if (sliderBar != null && (lp = sliderBar.getLayoutParams()) != null) {
                lp.height = (scaledSize - this.slideBarTextSizeStandard) + originHeight;
                SliderBar sliderBar2 = this.mSliderBar;
                if (sliderBar2 != null) {
                    sliderBar2.setLayoutParams(lp);
                }
            }
        }
    }

    private void updateBadgeIfNeed() {
        BadgeView badgeView = this.mFontBadge;
        if (badgeView != null) {
            badgeView.setVisibility(0);
            this.mFontBadge.setType(BadgeView.Type.SMALL_TEXT);
            this.mFontBadge.setText(com.baidu.searchbox.settings.R.string.new_feature);
            int index = FontSizeHelper.getFontSizeType();
            if (index >= 0) {
                int[] iArr = this.mBadgeMarginDimens;
                if (index < iArr.length) {
                    int resDimenId = iArr[index];
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) this.mFontBadge.getLayoutParams();
                    params.rightMargin = (int) getResources().getDimension(resDimenId);
                    this.mFontBadge.setLayoutParams(params);
                }
            }
            FontBadgeManager.INSTANCE.setNotShowBadge();
        }
    }

    private void updateSliderBarMargin() {
        int barHeightDimenId = BaseToolBarExtKt.getBarHeightDimens(true);
        float offsetDimen = getResources().getDimension(BaseToolBarExtKt.getBarHeightDimens(false)) - getResources().getDimension(barHeightDimenId);
        ConstraintLayout constraintLayout = this.mFontView;
        if (constraintLayout != null && constraintLayout.getLayoutParams() != null && (this.mFontView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) this.mFontView.getLayoutParams();
            params.bottomMargin = (int) offsetDimen;
            this.mFontView.setLayoutParams(params);
        }
    }

    /* access modifiers changed from: private */
    public void reloadUI() {
        updatePreviewUI();
        this.mFontSize = -1;
        selectFontSize(FontSizeHelper.getFontSizeType());
    }

    /* access modifiers changed from: private */
    public void updatePreviewUI() {
        TextView textView;
        if (this.mBodyPreviewS != null && (textView = this.mBodyPreviewF) != null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    FontSizeSettingActivity.this.mBodyPreviewF.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    FontSizeSettingActivity.this.mBodyPreviewF.setMaxLines(FontSizeSettingActivity.this.mBodyPreviewF.getMeasuredHeight() / FontSizeSettingActivity.this.mBodyPreviewF.getLineHeight());
                }
            });
            this.mBodyPreviewS.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    FontSizeSettingActivity.this.mBodyPreviewS.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    final int noOfLinesVisible = (FontSizeSettingActivity.this.mBodyPreviewS.getMeasuredHeight() - ((FontSizeSettingActivity.this.mBodyPreviewS.getLineHeight() / 5) * 4)) / FontSizeSettingActivity.this.mBodyPreviewS.getLineHeight();
                    FontSizeSettingActivity.this.mBodyPreviewS.setMaxLines(noOfLinesVisible);
                    FontSizeSettingActivity.this.mBodyPreviewS.post(new Runnable() {
                        public void run() {
                            FontSizeSettingActivity.this.mTitlePreview.setAlpha(1.0f);
                            FontSizeSettingActivity.this.mBodyPreviewF.setAlpha(1.0f);
                            FontSizeSettingActivity.this.mBodyPreviewS.setAlpha(1.0f);
                            FontSizeSettingActivity.this.mBodyPreviewS.setMaxLines(noOfLinesVisible);
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.mPageDurationUbc.beginDurationFlow("typeface");
        if (FontBannerManagerKt.checkShouldShow(FontSizeConfig.getFontSize(this))) {
            if (this.mFontBannerView.getVisibility() != 0) {
                calcFontBannerHeight();
                this.mFontBannerView.show(1);
                this.mFontBannerView.showCloseBtn(true);
            }
        } else if (FontBannerManagerKt.isPkgInstalled()) {
            this.mFontBannerView.hide();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mPageDurationUbc.endDurationFlow("typeface");
    }

    /* access modifiers changed from: private */
    public void calcFontBannerHeight() {
        ViewGroup.LayoutParams lp = this.mFontBannerView.getLayoutParams();
        if (lp != null) {
            lp.height = ((DeviceUtils.ScreenInfo.getDisplayWidth(this) - (getResources().getDimensionPixelSize(com.baidu.searchbox.settings.R.dimen.font_setting_font_slider_bar_left) * 2)) * getResources().getDimensionPixelSize(com.baidu.searchbox.settings.R.dimen.font_setting_banner_template_height)) / getResources().getDimensionPixelSize(com.baidu.searchbox.settings.R.dimen.font_setting_banner_template_width);
            this.mFontBannerView.setLayoutParams(lp);
        }
    }

    /* access modifiers changed from: private */
    public void selectFontSize(int fontSize) {
        if (DEBUG) {
            Log.w(TAG, "SliderBar state changed. mFontSize=" + this.mFontSize + ", mSliderBar index=" + fontSize);
        }
        if (this.mFontSize != fontSize && fontSize != -1) {
            this.mFontSize = fontSize;
            if (this.isFirstLoading) {
                this.isFirstLoading = false;
            } else {
                FontSizeConfig.saveFontData(getApplicationContext(), this.mFontSize);
            }
            this.mBodyPreviewF.setMaxLines(Integer.MAX_VALUE);
            this.mBodyPreviewS.setMaxLines(Integer.MAX_VALUE);
            this.mTitlePreview.setAlpha(0.6f);
            this.mBodyPreviewF.setAlpha(0.6f);
            this.mBodyPreviewS.setAlpha(0.6f);
            FontSizeTextViewExtKt.setScaledSize(this.mTitlePreview, 1, 0, this.mTitleFontSizeStandard);
            FontSizeTextViewExtKt.setScaledSize(this.mBodyPreviewF, 1, 0, this.mBodyFontSizeStandard);
            FontSizeTextViewExtKt.setScaledSize(this.mBodyPreviewS, 1, 0, this.mBodyFontSizeStandard);
        }
    }

    /* access modifiers changed from: private */
    public void resetSlideBarTextSize() {
        SliderBar sliderBar = this.mSliderBar;
        if (sliderBar != null) {
            if (this.slideBarTextSizeStandard == 0) {
                this.slideBarTextSizeStandard = sliderBar.getTextSize();
            }
            int i2 = this.slideBarTextSizeStandard;
            if (i2 > 0) {
                this.mSliderBar.setTextSize((int) FontSizeHelper.getScaledSize(0, (float) i2)).apply();
            }
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        initOrRefreshUI();
        if (DEBUG) {
            Log.d(TAG, "current mode is " + (isNightMode ? "night" : "day"));
        }
    }

    private void initOrRefreshUI() {
        Resources resources = getResources();
        this.mTopBart.setBackgroundColor(resources.getColor(com.baidu.searchbox.settings.R.color.font_setting_preview_background_color));
        this.mTitlePreview.setTextColor(resources.getColor(com.baidu.searchbox.settings.R.color.font_setting_title_preview_color));
        this.mBodyPreviewF.setTextColor(resources.getColor(com.baidu.searchbox.settings.R.color.font_setting_body_preview_color));
        this.mBodyPreviewS.setTextColor(resources.getColor(com.baidu.searchbox.settings.R.color.font_setting_body_preview_color));
        this.mSliderBar.setBarLineColor(resources.getColor(com.baidu.searchbox.settings.R.color.BC132)).setBarBgColor(resources.getColor(R.color.GC33)).setShadowColor(resources.getColor(com.baidu.searchbox.settings.R.color.BC145)).setTextColor(resources.getColor(R.color.GC4)).setThumbColorNormal(resources.getColor(R.color.GC16)).setThumbColorPressed(resources.getColor(R.color.GC16)).setThumbTextColor(resources.getColor(R.color.GC1)).apply();
        resetSlideBarTextSize();
        resetSlideBarHeight();
    }

    private static void fontSizeUBCEvent(int fontSize) {
        HashMap<String, String> map = new HashMap<>();
        map.put("value", "" + fontSize);
        UBC.onEvent("277", (Map<String, String>) map);
    }

    private String getUbcValue() {
        if (FontBadgeManager.INSTANCE.isNeedShowBadge()) {
            return "tips";
        }
        return null;
    }

    public void onFontSizeChange() {
        super.onFontSizeChange();
        updateBadgeIfNeed();
    }

    public void onToolBarBackPressed() {
        super.onToolBarBackPressed();
        HashMap<String, String> statData = new HashMap<>();
        statData.put("from", "light_na");
        statData.put("type", "toolbar");
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("206", (Map<String, String>) statData);
    }

    public UnifiedBottomBarOption getBottomBarOption() {
        BottomBarOptionFloatingBack barOption = new BottomBarOptionFloatingBack();
        barOption.setHideBackWithTopBackExperiment(true);
        return barOption;
    }
}
