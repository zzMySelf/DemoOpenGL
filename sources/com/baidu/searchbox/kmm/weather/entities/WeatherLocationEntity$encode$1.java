package com.baidu.searchbox.kmm.weather.entities;

import com.baidu.searchbox.kmm.foundation.kelson.JsonObjectBuilder;
import com.baidu.searchbox.push.location.PushLocationManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonObjectBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WeatherLoctionEntity.kt */
final class WeatherLocationEntity$encode$1 extends Lambda implements Function1<JsonObjectBuilder, Unit> {
    final /* synthetic */ WeatherLocationEntity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WeatherLocationEntity$encode$1(WeatherLocationEntity weatherLocationEntity) {
        super(1);
        this.this$0 = weatherLocationEntity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((JsonObjectBuilder) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(JsonObjectBuilder $this$buildJsonObject) {
        Intrinsics.checkNotNullParameter($this$buildJsonObject, "$this$buildJsonObject");
        String country = this.this$0.getCountry();
        String str = "";
        if (country == null) {
            country = str;
        }
        $this$buildJsonObject.put("country", country);
        String province = this.this$0.getProvince();
        if (province == null) {
            province = str;
        }
        $this$buildJsonObject.put("province", province);
        String city = this.this$0.getCity();
        if (city == null) {
            city = str;
        }
        $this$buildJsonObject.put("city", city);
        String district = this.this$0.getDistrict();
        if (district != null) {
            str = district;
        }
        $this$buildJsonObject.put(PushLocationManager.LOCATION_DISTRICT, str);
    }
}
