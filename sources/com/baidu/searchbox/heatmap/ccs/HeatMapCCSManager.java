package com.baidu.searchbox.heatmap.ccs;

import com.baidu.searchbox.video.flow.VideoAutoLandscapeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/heatmap/ccs/HeatMapCCSManager;", "", "()V", "<set-?>", "", "configJson", "getConfigJson", "()Ljava/lang/String;", "setConfigJson", "(Ljava/lang/String;)V", "configJson$delegate", "Lcom/baidu/searchbox/heatmap/ccs/HeatMapCCSSwitcher;", "", "totalSwitch", "getTotalSwitch", "()Z", "setTotalSwitch", "(Z)V", "totalSwitch$delegate", "bdheatmap-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CCSSwitcherManager.kt */
public final class HeatMapCCSManager {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final HeatMapCCSManager INSTANCE = new HeatMapCCSManager();
    private static final HeatMapCCSSwitcher configJson$delegate = new HeatMapCCSSwitcher("key_feed_heatmap_config_android", "", "heatmap_config.json");
    private static final HeatMapCCSSwitcher totalSwitch$delegate = new HeatMapCCSSwitcher("key_heatmap_total_switch_android", true, (String) null, 4, (DefaultConstructorMarker) null);

    private HeatMapCCSManager() {
    }

    static {
        Class<HeatMapCCSManager> cls = HeatMapCCSManager.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, VideoAutoLandscapeListener.VIDEO_AUTO_LANDSCAPE_TOTALSWITCH, "getTotalSwitch()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "configJson", "getConfigJson()Ljava/lang/String;", 0))};
    }

    public final boolean getTotalSwitch() {
        return ((Boolean) totalSwitch$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setTotalSwitch(boolean z) {
        totalSwitch$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final String getConfigJson() {
        return (String) configJson$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final void setConfigJson(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        configJson$delegate.setValue(this, $$delegatedProperties[1], str);
    }
}
