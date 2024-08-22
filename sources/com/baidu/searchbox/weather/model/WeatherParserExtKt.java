package com.baidu.searchbox.weather.model;

import com.baidu.searchbox.music.data.MusicParser;
import com.baidu.searchbox.nacomp.extension.util.JSONExtKt;
import com.baidu.searchbox.weather.WeatherLocationConfig;
import com.baidu.searchbox.weather.util.ValueUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0005H\u0002\u001a*\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¨\u0006\u0014"}, d2 = {"firstMatchQuery", "Lcom/baidu/searchbox/weather/WeatherLocationConfig;", "locations", "", "query", "Lorg/json/JSONObject;", "parseCityManageModel", "", "data", "Lcom/baidu/searchbox/weather/model/CityManageData;", "json", "parseSummary", "Lcom/baidu/searchbox/weather/model/SummaryData;", "parseWeatherMap", "", "jsonArray", "Lorg/json/JSONArray;", "safeOptString", "", "name", "lib-weather-landing_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: WeatherParserExt.kt */
public final class WeatherParserExtKt {
    public static final void parseCityManageModel(CityManageData data, JSONObject json) {
        JSONObject $this$parseCityManageModel_u24lambda_u2d1;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(json, "json");
        if (json.optInt(MusicParser.RESULT_CODE, -1) == 0 && ($this$parseCityManageModel_u24lambda_u2d1 = WeatherParser.getTplDataNode(json)) != null) {
            JSONArray $this$parseCityManageModel_u24lambda_u2d1_u24lambda_u2d0 = $this$parseCityManageModel_u24lambda_u2d1.optJSONArray("item");
            if ($this$parseCityManageModel_u24lambda_u2d1_u24lambda_u2d0 != null) {
                Intrinsics.checkNotNullExpressionValue($this$parseCityManageModel_u24lambda_u2d1_u24lambda_u2d0, "optJSONArray(\"item\")");
                data.setWeathers(parseWeatherMap(data.getLocations(), $this$parseCityManageModel_u24lambda_u2d1_u24lambda_u2d0));
            }
            WeatherParser.parseServerLog(json, $this$parseCityManageModel_u24lambda_u2d1, data.getServerLog());
        }
    }

    private static final Map<WeatherLocationConfig, SummaryData> parseWeatherMap(List<? extends WeatherLocationConfig> locations, JSONArray jsonArray) {
        WeatherLocationConfig match;
        List locationsCopy = CollectionsKt.toMutableList(locations);
        Map linkedHashMap = new LinkedHashMap();
        Map $this$parseWeatherMap_u24lambda_u2d3 = linkedHashMap;
        int i2 = 0;
        int length = jsonArray.length();
        if (0 <= length) {
            while (true) {
                JSONObject json = jsonArray.optJSONObject(i2);
                if (json != null) {
                    Intrinsics.checkNotNullExpressionValue(json, "jsonArray.optJSONObject(i) ?: continue");
                    JSONObject $this$parseWeatherMap_u24lambda_u2d3_u24lambda_u2d2 = json.optJSONObject("raw_query");
                    if ($this$parseWeatherMap_u24lambda_u2d3_u24lambda_u2d2 != null) {
                        Intrinsics.checkNotNullExpressionValue($this$parseWeatherMap_u24lambda_u2d3_u24lambda_u2d2, "optJSONObject(\"raw_query\")");
                        match = firstMatchQuery(locationsCopy, $this$parseWeatherMap_u24lambda_u2d3_u24lambda_u2d2);
                        if (match != null) {
                            locationsCopy.remove(match);
                        }
                    } else {
                        match = null;
                    }
                    WeatherLocationConfig location = match;
                    if (location != null) {
                        $this$parseWeatherMap_u24lambda_u2d3.put(location, parseSummary(json));
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a A[EDGE_INSN: B:25:0x005a->B:22:0x005a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final com.baidu.searchbox.weather.WeatherLocationConfig firstMatchQuery(java.util.List<? extends com.baidu.searchbox.weather.WeatherLocationConfig> r9, org.json.JSONObject r10) {
        /*
            r0 = r9
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x0008:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r2.next()
            r4 = r3
            com.baidu.searchbox.weather.WeatherLocationConfig r4 = (com.baidu.searchbox.weather.WeatherLocationConfig) r4
            r5 = 0
            java.lang.String r6 = "country"
            java.lang.String r6 = safeOptString(r10, r6)
            java.lang.String r7 = r4.getCountry()
            java.lang.String r8 = ""
            if (r7 != 0) goto L_0x0025
            r7 = r8
        L_0x0025:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0054
            java.lang.String r6 = "city"
            java.lang.String r6 = safeOptString(r10, r6)
            java.lang.String r7 = r4.getCity()
            if (r7 != 0) goto L_0x0038
            r7 = r8
        L_0x0038:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0054
            java.lang.String r6 = "district"
            java.lang.String r6 = safeOptString(r10, r6)
            java.lang.String r7 = r4.getDistrict()
            if (r7 != 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r8 = r7
        L_0x004c:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r8)
            if (r6 == 0) goto L_0x0054
            r6 = 1
            goto L_0x0055
        L_0x0054:
            r6 = 0
        L_0x0055:
            if (r6 == 0) goto L_0x0008
            goto L_0x005a
        L_0x0059:
            r3 = 0
        L_0x005a:
            com.baidu.searchbox.weather.WeatherLocationConfig r3 = (com.baidu.searchbox.weather.WeatherLocationConfig) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.weather.model.WeatherParserExtKt.firstMatchQuery(java.util.List, org.json.JSONObject):com.baidu.searchbox.weather.WeatherLocationConfig");
    }

    private static final SummaryData parseSummary(JSONObject data) {
        SummaryData summaryData = new SummaryData();
        SummaryData $this$parseSummary_u24lambda_u2d5 = summaryData;
        $this$parseSummary_u24lambda_u2d5.setWeather(safeOptString(data, "weather"));
        $this$parseSummary_u24lambda_u2d5.setShowCounty(safeOptString(data, "showcounty"));
        $this$parseSummary_u24lambda_u2d5.setTemperature(ValueUtil.parseFloat(safeOptString(data, "temperature"), Float.MIN_VALUE));
        $this$parseSummary_u24lambda_u2d5.setMinTemperature(ValueUtil.parseFloat(safeOptString(data, "minTemperature"), Float.MIN_VALUE));
        $this$parseSummary_u24lambda_u2d5.setMaxTemperature(ValueUtil.parseFloat(safeOptString(data, "maxTemperature"), Float.MIN_VALUE));
        WeatherParser.parseBackground(data, $this$parseSummary_u24lambda_u2d5.getBackground());
        return summaryData;
    }

    private static final String safeOptString(JSONObject $this$safeOptString, String name) {
        return JSONExtKt.optStringIgnoreNulls($this$safeOptString, name, "");
    }
}
