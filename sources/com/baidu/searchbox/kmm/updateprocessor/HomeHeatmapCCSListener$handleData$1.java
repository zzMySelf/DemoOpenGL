package com.baidu.searchbox.kmm.updateprocessor;

import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeHeatmapCCSListener.kt */
final class HomeHeatmapCCSListener$handleData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ JsonObject $data;
    final /* synthetic */ String $version;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeHeatmapCCSListener$handleData$1(String str, JsonObject jsonObject) {
        super(0);
        this.$version = str;
        this.$data = jsonObject;
    }

    public final void invoke() {
        if (Intrinsics.areEqual((Object) this.$version, (Object) "-1")) {
            HomeHeatmapCCSListenerKt.kv.set("home_heatmap_config_switch", "1");
            HomeHeatmapCCSListenerKt.kv.set("home_heatmap_config_version", this.$version);
            return;
        }
        String string = JsonUtilKt.getString(this.$data, "switch", "1");
        int heatmapMaxLimit = JsonUtilKt.getInt(this.$data, "heatmapMaxLimit", 5);
        HomeHeatmapCCSListenerKt.kv.set("home_heatmap_config_switch", string);
        HomeHeatmapCCSListenerKt.kv.set("home_heatmap_config_max_limit", Integer.valueOf(heatmapMaxLimit));
        HomeHeatmapCCSListenerKt.kv.set("home_heatmap_config_version", this.$version);
    }
}
