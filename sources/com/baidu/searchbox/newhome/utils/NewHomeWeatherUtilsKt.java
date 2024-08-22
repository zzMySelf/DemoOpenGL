package com.baidu.searchbox.newhome.utils;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.common.ui.style.R;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.config.utils.ResUtil;
import com.baidu.searchbox.home.weather.TextPaintUility;
import com.baidu.searchbox.kmm.home.abtest.HomeABTestMgr;
import com.baidu.searchbox.newhome.HomeV1TabContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\t\u0010\u0002\u001a\u00020\u0003H\b\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001c\u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b\u001a\u000e\u0010\f\u001a\u00020\u0007*\u0004\u0018\u00010\rH\u0007\u001a\f\u0010\u000e\u001a\u00020\u0003*\u0004\u0018\u00010\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"SP_KEY_WEATHER_CONTENT_WIDTH", "", "hasWeather", "", "saveWeatherContentWidth", "", "width", "", "ellipsize", "maxWidth", "paint", "Landroid/text/TextPaint;", "getWeatherMaxWidth", "Landroid/view/View;", "isImageShown", "Landroid/widget/ImageView;", "new-home-top_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewHomeWeatherUtils.kt */
public final class NewHomeWeatherUtilsKt {
    private static final String SP_KEY_WEATHER_CONTENT_WIDTH = "new_home_weather_content_width";

    public static final boolean hasWeather() {
        return HomeABTestMgr.isShowWeather();
    }

    public static final int getWeatherMaxWidth(View $this$getWeatherMaxWidth) {
        Resources res = $this$getWeatherMaxWidth != null ? $this$getWeatherMaxWidth.getResources() : null;
        int width = 0;
        if (res == null || !HomeV1TabUtilsKt.canShowMoreTabs()) {
            if ($this$getWeatherMaxWidth != null) {
                width = $this$getWeatherMaxWidth.getLeft();
            }
            return (int) (((float) width) - ResUtil.getDimenByResId(R.dimen.dimen_ui_3));
        }
        int weatherContentWidth = QuickPersistConfig.getInstance().getInt(SP_KEY_WEATHER_CONTENT_WIDTH, 0);
        if (weatherContentWidth <= 0) {
            if (AppConfig.isDebug()) {
                Log.d(HomeV1TabContainer.TAG, "getWeatherMaxWidth: use small width 1");
            }
            return res.getDimensionPixelOffset(com.baidu.searchbox.newhome.top.R.dimen.new_home_weather_area_width);
        } else if (weatherContentWidth > res.getDimensionPixelOffset(com.baidu.searchbox.newhome.top.R.dimen.new_home_weather_area_width)) {
            if (AppConfig.isDebug()) {
                Log.d(HomeV1TabContainer.TAG, "getWeatherMaxWidth: use max width");
            }
            return res.getDimensionPixelOffset(com.baidu.searchbox.newhome.top.R.dimen.new_home_weather_area_width_max);
        } else {
            if (AppConfig.isDebug()) {
                Log.d(HomeV1TabContainer.TAG, "getWeatherMaxWidth: use small width 2");
            }
            return res.getDimensionPixelOffset(com.baidu.searchbox.newhome.top.R.dimen.new_home_weather_area_width);
        }
    }

    public static final void saveWeatherContentWidth(int width) {
        QuickPersistConfig.getInstance().putInt(SP_KEY_WEATHER_CONTENT_WIDTH, width);
    }

    public static final String ellipsize(String $this$ellipsize, int maxWidth, TextPaint paint) {
        String str;
        Intrinsics.checkNotNullParameter(paint, "paint");
        if ($this$ellipsize != null) {
            String $this$ellipsize_u24lambda_u2d0 = $this$ellipsize;
            if (TextPaintUility.getTextLength($this$ellipsize_u24lambda_u2d0, paint) > ((float) maxWidth)) {
                str = TextUtils.ellipsize($this$ellipsize_u24lambda_u2d0, paint, (float) maxWidth, TextUtils.TruncateAt.END).toString();
            } else {
                str = $this$ellipsize_u24lambda_u2d0;
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return "";
    }

    public static final boolean isImageShown(ImageView $this$isImageShown) {
        if ($this$isImageShown == null) {
            return false;
        }
        ImageView $this$isImageShown_u24lambda_u2d1 = $this$isImageShown;
        if ($this$isImageShown_u24lambda_u2d1.getParent() == null || $this$isImageShown_u24lambda_u2d1.getVisibility() == 8) {
            return false;
        }
        return true;
    }
}
