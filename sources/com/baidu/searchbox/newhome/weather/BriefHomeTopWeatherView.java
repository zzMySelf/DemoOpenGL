package com.baidu.searchbox.newhome.weather;

import android.content.Context;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.home.weather.HomeWeatherAbstractView;
import com.baidu.searchbox.home.weather.HomeWeatherManager;
import com.baidu.searchbox.home.weather.HomeWeatherStatistics;
import com.baidu.searchbox.home.weather.HomeWeatherUtilsKt;
import com.baidu.searchbox.home.weather.WeatherConstantsKt;
import com.baidu.searchbox.home.weather.WeatherData;
import com.baidu.searchbox.home.weather.WeatherStatus;
import com.baidu.searchbox.home.weather.WeatherStatusKt;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.newhome.INewHomeEventListener;
import com.baidu.searchbox.newhome.extend.INewHomeApi;
import com.baidu.searchbox.newhome.tab.HomeBgChangeEvent;
import com.baidu.searchbox.newhome.top.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\u00020\u0002:\u00011B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0017H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u0015H\u0016J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020\u0015H\u0002J\b\u0010)\u001a\u00020\u0015H\u0003J\u001c\u0010*\u001a\u00020\u00152\b\b\u0001\u0010+\u001a\u00020,2\b\b\u0001\u0010-\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020\u0015H\u0002J\b\u0010/\u001a\u00020\u0015H\u0016J\b\u00100\u001a\u00020\u0015H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/searchbox/newhome/weather/BriefHomeTopWeatherView;", "Lcom/baidu/searchbox/home/weather/HomeWeatherAbstractView;", "Lcom/baidu/searchbox/newhome/INewHomeEventListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mCityView", "Landroid/widget/TextView;", "mErrorTextView1", "mErrorTextView2", "mIconNightFilter", "Landroid/graphics/PorterDuffColorFilter;", "getMIconNightFilter", "()Landroid/graphics/PorterDuffColorFilter;", "mIconNightFilter$delegate", "Lkotlin/Lazy;", "mTemperatureView", "mWeatherIconView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mWeatherTextView", "changeTheme", "", "isClassicTheme", "", "getCachedDataAndUpdate", "getCityText", "", "init", "isWeatherVisible", "onFontSizeChanged", "onHomePageVisible", "isVisible", "onNightModeChanged", "isNight", "onWeatherViewClick", "removeView", "setColorStyle", "isThemeDarkBackground", "setErrorIcon", "setScaledIconSize", "setScaledTextSize", "setWeatherViewContent", "setWeatherViewError", "textId1", "", "textId2", "ubcWeatherShowEvent", "update", "updateScaledHeight", "Companion", "new-home-top_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BriefHomeTopWeatherView.kt */
public final class BriefHomeTopWeatherView extends HomeWeatherAbstractView implements INewHomeEventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int ICON_NIGHT_FILTER_COLOR = 2130706432;
    private static final String UBC_PAGE = "jianjie_home_top";
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final TextView mCityView;
    private final TextView mErrorTextView1;
    private final TextView mErrorTextView2;
    private final Lazy mIconNightFilter$delegate;
    private final TextView mTemperatureView;
    private final SimpleDraweeView mWeatherIconView;
    private final TextView mWeatherTextView;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BriefHomeTopWeatherView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WeatherStatus.values().length];
            iArr[WeatherStatus.NORMAL.ordinal()] = 1;
            iArr[WeatherStatus.NO_WEATHER_DATA.ordinal()] = 2;
            iArr[WeatherStatus.DATA_ERROR.ordinal()] = 3;
            iArr[WeatherStatus.PICK_CITY.ordinal()] = 4;
            iArr[WeatherStatus.NETWORK_ERROR.ordinal()] = 5;
            iArr[WeatherStatus.DATA_FETCHING.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BriefHomeTopWeatherView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIconNightFilter$delegate = LazyKt.lazy(BriefHomeTopWeatherView$mIconNightFilter$2.INSTANCE);
        View.inflate(context, R.layout.view_brief_home_top_weather, this);
        View findViewById = findViewById(R.id.weather_icon);
        boolean isThemeDarkBackground = false;
        ((GenericDraweeHierarchy) ((SimpleDraweeView) findViewById).getHierarchy()).setUseGlobalColorFilter(false);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<SimpleDrawe…rFilter = false\n        }");
        this.mWeatherIconView = (SimpleDraweeView) findViewById;
        View findViewById2 = findViewById(R.id.temperature);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.temperature)");
        this.mTemperatureView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.city);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.city)");
        this.mCityView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.weather_text);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.weather_text)");
        this.mWeatherTextView = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.error_text_1);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.error_text_1)");
        this.mErrorTextView1 = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.error_text_2);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.error_text_2)");
        this.mErrorTextView2 = (TextView) findViewById6;
        boolean isNight = NightModeHelper.isNightMode();
        INewHomeApi newHomeApi = INewHomeApi.Companion.getNewHomeApi();
        setColorStyle(isNight, newHomeApi != null ? newHomeApi.hasFeedDrawable() : isThemeDarkBackground);
        setScaledIconSize();
        setScaledTextSize();
        INewHomeApi newHomeApi2 = INewHomeApi.Companion.getNewHomeApi();
        if (newHomeApi2 != null) {
            newHomeApi2.addNewHomeEventListener(this);
        }
        BdEventBus.Companion.getDefault().register(this, HomeBgChangeEvent.class, new BriefHomeTopWeatherView$$ExternalSyntheticLambda0(this));
        setOnClickListener(new BriefHomeTopWeatherView$$ExternalSyntheticLambda1(this));
        getCachedDataAndUpdate();
    }

    public void onContentSelectedChange(boolean isRecommendTab) {
        INewHomeEventListener.DefaultImpls.onContentSelectedChange(this, isRecommendTab);
    }

    public void onDestroy() {
        INewHomeEventListener.DefaultImpls.onDestroy(this);
    }

    public boolean onFragmentKeyDown(int keyCode, KeyEvent event) {
        return INewHomeEventListener.DefaultImpls.onFragmentKeyDown(this, keyCode, event);
    }

    public boolean onFragmentKeyUp(int keyCode, KeyEvent event) {
        return INewHomeEventListener.DefaultImpls.onFragmentKeyUp(this, keyCode, event);
    }

    @Deprecated(message = "首页头部可见变化回调，新首页不应使用此状态")
    public void onHomeHeaderVisible(boolean visible) {
        INewHomeEventListener.DefaultImpls.onHomeHeaderVisible(this, visible);
    }

    @Deprecated(message = "吸顶状态变化回调，新首页不应使用此状态")
    public void onHomeStateChanged(int oldState, int newState, boolean byTouch) {
        INewHomeEventListener.DefaultImpls.onHomeStateChanged(this, oldState, newState, byTouch);
    }

    public void onLazyUiReady() {
        INewHomeEventListener.DefaultImpls.onLazyUiReady(this);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/newhome/weather/BriefHomeTopWeatherView$Companion;", "", "()V", "ICON_NIGHT_FILTER_COLOR", "", "UBC_PAGE", "", "new-home-top_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BriefHomeTopWeatherView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final PorterDuffColorFilter getMIconNightFilter() {
        return (PorterDuffColorFilter) this.mIconNightFilter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m1617_init_$lambda1(BriefHomeTopWeatherView this$0, HomeBgChangeEvent it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.setColorStyle(NightModeHelper.isNightMode(), it.getStatus().getHasTheme());
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m1618_init_$lambda2(BriefHomeTopWeatherView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onWeatherViewClick();
    }

    private final void getCachedDataAndUpdate() {
        WeatherStatus weatherStatus;
        HomeWeatherManager instance = HomeWeatherManager.getInstance();
        if (instance == null || (weatherStatus = instance.getStatusFromCache()) == null) {
            weatherStatus = WeatherStatus.NORMAL;
        }
        this.mCurrStatus = weatherStatus;
        if (this.mCurrStatus == WeatherStatus.NORMAL) {
            HomeWeatherManager instance2 = HomeWeatherManager.getInstance();
            WeatherData weatherData = instance2 != null ? instance2.getWeatherData() : null;
            if (weatherData == null) {
                this.mCurrStatus = WeatherStatus.PICK_CITY;
            } else {
                this.mWeatherData = weatherData;
                HomeWeatherManager.getInstance().setCurShowWeatherData(weatherData);
            }
        }
        update();
    }

    private final void onWeatherViewClick() {
        WeatherStatus weatherStatus = this.mCurrStatus;
        if ((weatherStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[weatherStatus.ordinal()]) == 1) {
            onNormalStatusClick(UBC_PAGE);
        } else {
            onAbnormalStatusClick(UBC_PAGE);
        }
    }

    private final void setWeatherViewContent() {
        String temperatureText;
        this.mErrorTextView1.setVisibility(8);
        this.mErrorTextView2.setVisibility(8);
        if (this.mWeatherData == null || !this.mWeatherData.isValid()) {
            this.mCurrStatus = WeatherStatus.DATA_ERROR;
            update();
            return;
        }
        SimpleDraweeView $this$setWeatherViewContent_u24lambda_u2d3 = this.mWeatherIconView;
        $this$setWeatherViewContent_u24lambda_u2d3.setImageURI(this.mWeatherData.weatherIconSimpleUrl);
        ((GenericDraweeHierarchy) $this$setWeatherViewContent_u24lambda_u2d3.getHierarchy()).setPlaceholderImage((Drawable) null);
        TextView it = this.mTemperatureView;
        it.setVisibility(0);
        WeatherData data = this.mWeatherData;
        CharSequence charSequence = data.temp;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            Intrinsics.checkNotNullExpressionValue(data, "data");
            temperatureText = HomeWeatherUtilsKt.getOverseasTemperature(data);
        } else {
            temperatureText = data.temp;
        }
        it.setText(temperatureText + Typography.degree);
        TextView it2 = this.mWeatherTextView;
        it2.setVisibility(0);
        it2.setText(this.mWeatherData.weather);
        TextView it3 = this.mCityView;
        it3.setVisibility(0);
        it3.setText(this.mWeatherData.getEffectiveCity());
    }

    private final void setWeatherViewError(int textId1, int textId2) {
        setErrorIcon();
        this.mTemperatureView.setVisibility(8);
        this.mCityView.setVisibility(8);
        this.mWeatherTextView.setVisibility(8);
        this.mErrorTextView2.setVisibility(0);
        this.mErrorTextView2.setText(getResources().getString(textId2));
        if (this.mCurrStatus == WeatherStatus.NO_WEATHER_DATA) {
            String it = getCityText();
            if (StringsKt.isBlank(it)) {
                this.mErrorTextView1.setVisibility(8);
                return;
            }
            this.mErrorTextView1.setVisibility(0);
            this.mErrorTextView1.setText(it);
            return;
        }
        this.mErrorTextView1.setVisibility(0);
        this.mErrorTextView1.setText(getResources().getString(textId1));
    }

    public void update() {
        WeatherStatus weatherStatus = this.mCurrStatus;
        switch (weatherStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[weatherStatus.ordinal()]) {
            case 1:
                setWeatherViewContent();
                break;
            case 2:
                setWeatherViewError(0, R.string.brief_weather_error_empty_2);
                break;
            case 3:
                setWeatherViewError(R.string.brief_weather_error_data_1, R.string.brief_weather_error_data_2);
                break;
            case 4:
                setWeatherViewError(R.string.brief_weather_error_city_1, R.string.brief_weather_error_city_2);
                break;
            case 5:
                setWeatherViewError(R.string.brief_weather_error_network_1, R.string.brief_weather_error_network_2);
                break;
            case 6:
                setWeatherViewError(R.string.brief_weather_error_fetching_1, R.string.brief_weather_error_fetching_2);
                break;
        }
        setScaledIconSize();
        getViewTreeObserver().addOnGlobalLayoutListener(new BriefHomeTopWeatherView$update$1(this));
        if (this.updateTimes <= 2) {
            this.updateTimes++;
        }
        if (this.updateTimes == 1 || this.updateTimes == 2) {
            ubcWeatherShowEvent();
        }
        if (this.updateTimes == 2) {
            HomeWeatherStatistics.ubc("4004", "show", "weather", WeatherStatusKt.getUbcSource(this.mCurrStatus), "", UBC_PAGE);
            this.updateTimes++;
        }
    }

    public boolean isWeatherVisible() {
        INewHomeApi newHomeApi = INewHomeApi.Companion.getNewHomeApi();
        if (newHomeApi != null) {
            return newHomeApi.isHomePageVisible();
        }
        return false;
    }

    public void onHomePageVisible(boolean isVisible) {
        if (isVisible) {
            onViewResume();
            if (this.updateTimes > 2) {
                INewHomeApi newHomeApi = INewHomeApi.Companion.getNewHomeApi();
                boolean z = false;
                if (newHomeApi != null && newHomeApi.getNewHomeScrollState() == 0) {
                    z = true;
                }
                if (z) {
                    ubcWeatherShowEvent();
                }
            }
        }
    }

    public void removeView() {
    }

    public void init() {
    }

    public void changeTheme(boolean isClassicTheme) {
    }

    public void onFontSizeChanged() {
        setScaledIconSize();
        setScaledTextSize();
        updateScaledHeight();
    }

    public void onNightModeChanged(boolean isNight) {
        INewHomeApi newHomeApi = INewHomeApi.Companion.getNewHomeApi();
        setColorStyle(isNight, newHomeApi != null ? newHomeApi.hasFeedDrawable() : false);
    }

    private final void setColorStyle(boolean isNight, boolean isThemeDarkBackground) {
        int textColor;
        float shadowRadius;
        int shadowColor;
        ((GenericDraweeHierarchy) this.mWeatherIconView.getHierarchy()).setActualImageColorFilter(isNight ? getMIconNightFilter() : null);
        if (this.mCurrStatus != WeatherStatus.NORMAL) {
            setErrorIcon();
        }
        if (isNight || isThemeDarkBackground) {
            textColor = getResources().getColor(R.color.BC44);
        } else {
            textColor = getResources().getColor(com.baidu.android.common.ui.style.R.color.GC106);
        }
        this.mTemperatureView.setTextColor(textColor);
        this.mCityView.setTextColor(textColor);
        this.mWeatherTextView.setTextColor(textColor);
        this.mErrorTextView1.setTextColor(textColor);
        this.mErrorTextView2.setTextColor(textColor);
        if (isNight || !isThemeDarkBackground) {
            shadowRadius = 0.0f;
        } else {
            shadowRadius = ViewExtensionsKt.getDimension(this, R.dimen.brief_weather_top_text_shadow_radius);
        }
        if (isNight || !isThemeDarkBackground) {
            shadowColor = 0;
        } else {
            shadowColor = getResources().getColor(R.color.BC141);
        }
        this.mTemperatureView.setShadowLayer(shadowRadius, 0.0f, 0.0f, shadowColor);
        this.mCityView.setShadowLayer(shadowRadius, 0.0f, 0.0f, shadowColor);
        this.mWeatherTextView.setShadowLayer(shadowRadius, 0.0f, 0.0f, shadowColor);
        this.mErrorTextView1.setShadowLayer(shadowRadius, 0.0f, 0.0f, shadowColor);
        this.mErrorTextView2.setShadowLayer(shadowRadius, 0.0f, 0.0f, shadowColor);
    }

    private final void setErrorIcon() {
        int drawable;
        int i2;
        int i3;
        int i4;
        INewHomeApi newHomeApi = INewHomeApi.Companion.getNewHomeApi();
        boolean isLight = false;
        boolean isTheme = newHomeApi != null ? newHomeApi.hasFeedDrawable() : false;
        if (newHomeApi != null) {
            isLight = newHomeApi.isHomeLightBg();
        }
        if (isLight) {
            if (this.mCurrStatus != WeatherStatus.PICK_CITY) {
                i4 = R.drawable.newhome_feed_header_no_weather_tip_light;
            } else {
                i4 = R.drawable.newhome_feed_header_weather_location_tip_light;
            }
            drawable = i4;
        } else if (isTheme) {
            if (this.mCurrStatus != WeatherStatus.PICK_CITY) {
                i3 = R.drawable.newhome_feed_header_no_weather_tip_transparent;
            } else {
                i3 = R.drawable.newhome_feed_header_weather_location_tip_transparent;
            }
            drawable = i3;
        } else {
            if (this.mCurrStatus != WeatherStatus.PICK_CITY) {
                i2 = R.drawable.newhome_feed_header_no_weather_tip;
            } else {
                i2 = R.drawable.newhome_feed_header_weather_location_tip;
            }
            drawable = i2;
        }
        ((GenericDraweeHierarchy) this.mWeatherIconView.getHierarchy()).setPlaceholderImage(drawable);
        String str = null;
        this.mWeatherIconView.setImageURI((String) null);
    }

    private final void setScaledTextSize() {
        FontSizeTextViewExtKt.setScaledSizeRes$default(this.mTemperatureView, 1, R.dimen.brief_weather_top_temp_text_size, 0, 4, (Object) null);
        float it = FontSizeHelper.getScaledSizeRes(1, R.dimen.brief_weather_top_common_text_size);
        this.mCityView.setTextSize(0, it);
        this.mWeatherTextView.setTextSize(0, it);
        this.mErrorTextView1.setTextSize(0, it);
        this.mErrorTextView2.setTextSize(0, it);
    }

    private final void setScaledIconSize() {
        int iconSizeDimen;
        if (this.mCurrStatus == WeatherStatus.NORMAL) {
            iconSizeDimen = R.dimen.brief_weather_top_icon_size;
        } else {
            iconSizeDimen = R.dimen.brief_weather_top_error_icon_size;
        }
        FontSizeViewExtKt.setScaledSizeRes$default(this.mWeatherIconView, 1, iconSizeDimen, iconSizeDimen, 0, 8, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updateScaledHeight() {
        int i2;
        View $this$updateLayoutParams$iv = this;
        ViewGroup.LayoutParams params$iv = $this$updateLayoutParams$iv.getLayoutParams();
        if (params$iv != null) {
            ViewGroup.LayoutParams $this$updateScaledHeight_u24lambda_u2d10 = params$iv;
            View view2 = this;
            switch (FontSizeHelper.getFontSizeType()) {
                case 0:
                    i2 = R.dimen.brief_weather_top_height_small_text;
                    break;
                case 1:
                    i2 = R.dimen.brief_weather_top_height_medium_text;
                    break;
                case 2:
                    i2 = R.dimen.brief_weather_top_height_large_text;
                    break;
                case 3:
                case 4:
                    i2 = R.dimen.brief_weather_top_height_max_text;
                    break;
                default:
                    i2 = R.dimen.brief_weather_top_height_medium_text;
                    break;
            }
            $this$updateScaledHeight_u24lambda_u2d10.height = ViewExtensionsKt.getDimensionPixelSize(view2, i2);
            $this$updateLayoutParams$iv.setLayoutParams(params$iv);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final String getCityText() {
        WeatherData weatherData = this.mWeatherData;
        String it = weatherData != null ? weatherData.getEffectiveCity() : null;
        CharSequence charSequence = it;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            return it;
        }
        String cityFromCache = HomeWeatherManager.getInstance().getCityFromCache();
        if (cityFromCache == null) {
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(cityFromCache, "HomeWeatherManager.getIn…nce().cityFromCache ?: \"\"");
        return cityFromCache;
    }

    private final void ubcWeatherShowEvent() {
        HomeWeatherStatistics.ubc(WeatherConstantsKt.UBC_HOME_WEATHER_SHOW, "show", "weather", WeatherStatusKt.getUbcSource(this.mCurrStatus), "", UBC_PAGE);
    }
}
