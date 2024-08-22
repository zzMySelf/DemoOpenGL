package com.baidu.searchbox.common.security;

import android.text.TextUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "iterateDeviceFlag", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeviceInfoUtilKt$toJson$1 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ int $deviceFlag;
    public final /* synthetic */ DeviceIdBagMap $infoMap;
    public final /* synthetic */ JSONObject $json;
    public final /* synthetic */ List<Integer> $validInfoList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceInfoUtilKt$toJson$1(int i2, DeviceIdBagMap deviceIdBagMap, List<Integer> list, JSONObject jSONObject) {
        super(1);
        this.$deviceFlag = i2;
        this.$infoMap = deviceIdBagMap;
        this.$validInfoList = list;
        this.$json = jSONObject;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i2) {
        DeviceIdBag deviceIdBag;
        if ((this.$deviceFlag & i2) != 0 && (deviceIdBag = (DeviceIdBag) this.$infoMap.get((Object) Integer.valueOf(i2))) != null && !TextUtils.isEmpty(deviceIdBag.deviceId)) {
            this.$validInfoList.add(Integer.valueOf(i2));
            String str = DeviceInfoUtilKt.fe().get(i2);
            if (i2 == 2) {
                JSONObject jSONObject = this.$json;
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(deviceIdBag.deviceId);
                Unit unit = Unit.INSTANCE;
                jSONObject.put(str, jSONArray);
                return;
            }
            this.$json.put(str, deviceIdBag.deviceId);
        }
    }
}
