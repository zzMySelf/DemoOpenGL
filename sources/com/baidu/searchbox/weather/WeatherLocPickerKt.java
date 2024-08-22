package com.baidu.searchbox.weather;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"JAVASCRIPT_INTERFACE_NAME", "", "PICKER_URL", "URL_PARAM_CITY_LIST", "buildLocPickerUrl", "param", "Lcom/baidu/searchbox/weather/LocationPickerParam;", "lib-weather-impl_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WeatherLocPicker.kt */
public final class WeatherLocPickerKt {
    private static final String JAVASCRIPT_INTERFACE_NAME = "Bdbox_android_feed";
    private static final String PICKER_URL = "https://m.baidu.com/sf?pd=life_compare_weather&openapi=1&dspName=iphone&from_sf=1&resource_id=5820&word=选择页&title=选择城市&top={\"sfhs\":1}";
    private static final String URL_PARAM_CITY_LIST = "cityList";

    public static final String buildLocPickerUrl(LocationPickerParam param) {
        String cityString;
        List $this$buildLocPickerUrl_u24lambda_u2d1;
        boolean z = false;
        if (param == null || ($this$buildLocPickerUrl_u24lambda_u2d1 = param.getSelectedLocations()) == null) {
            cityString = null;
        } else {
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$buildLocPickerUrl_u24lambda_u2d1) {
                CharSequence city = ((WeatherLocationConfig) element$iv$iv).getCity();
                if (!(city == null || city.length() == 0)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            cityString = CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, WeatherLocPickerKt$buildLocPickerUrl$cityString$1$2.INSTANCE, 30, (Object) null);
        }
        CharSequence charSequence = cityString;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (z) {
            return PICKER_URL;
        }
        String uri = Uri.parse(PICKER_URL).buildUpon().appendQueryParameter(URL_PARAM_CITY_LIST, cityString).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "{\n        Uri.parse(PICK….build().toString()\n    }");
        return uri;
    }
}
