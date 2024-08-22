package com.baidu.searchbox.dynamicpublisher.location;

import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.ugc.position.model.PoiModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"isValidPlacePoi", "", "poiModel", "Lcom/baidu/ugc/position/model/PoiModel;", "parsePositionLatLngData", "placePoi", "", "lib-publisher-component_debug"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectedLocModel.kt */
public final class SelectedLocModelKt {
    public static final PoiModel parsePositionLatLngData(String placePoi) {
        Object obj;
        CharSequence charSequence = placePoi;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        PoiModel poiModel = new PoiModel();
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m8971constructorimpl(new JSONObject(placePoi));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8978isSuccessimpl(obj)) {
            JSONObject json = (JSONObject) obj;
            poiModel.address = json.optString("addr");
            poiModel.city = json.optString("city");
            poiModel.poiType = json.optString("poi_type");
            poiModel.cityId = json.optString("city_id");
            poiModel.latitude = json.optDouble("lat");
            poiModel.longitude = json.optDouble(SuggestAddrField.KEY_LNG);
            poiModel.name = json.optString("name");
            poiModel.pid = json.optString("pid");
            poiModel.tag = json.optString("tag");
        }
        if (isValidPlacePoi(poiModel)) {
            return poiModel;
        }
        return null;
    }

    private static final boolean isValidPlacePoi(PoiModel poiModel) {
        CharSequence charSequence = poiModel.name;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return false;
        }
        CharSequence charSequence2 = poiModel.address;
        if (charSequence2 == null || StringsKt.isBlank(charSequence2)) {
            return false;
        }
        CharSequence charSequence3 = poiModel.pid;
        if ((charSequence3 == null || StringsKt.isBlank(charSequence3)) || !RangesKt.rangeTo(-90.0d, 90.0d).contains(Double.valueOf(poiModel.latitude)) || !RangesKt.rangeTo(-180.0d, 180.0d).contains(Double.valueOf(poiModel.longitude))) {
            return false;
        }
        return true;
    }
}
