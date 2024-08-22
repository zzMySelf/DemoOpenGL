package com.baidu.searchbox.video.feedflow.update;

import com.baidu.searchbox.video.detail.switcher.VideoUpdateSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/update/IntelligentSummaryUpgradesSwitcher;", "", "()V", "<set-?>", "", "intelligentSummaryPanelSwitch", "getIntelligentSummaryPanelSwitch", "()Z", "setIntelligentSummaryPanelSwitch", "(Z)V", "intelligentSummaryPanelSwitch$delegate", "Lcom/baidu/searchbox/video/detail/switcher/VideoUpdateSwitcher;", "intelligentSummaryPrioritySwitch", "getIntelligentSummaryPrioritySwitch", "setIntelligentSummaryPrioritySwitch", "intelligentSummaryPrioritySwitch$delegate", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntelligentSummaryUpgradesSwitcher.kt */
public final class IntelligentSummaryUpgradesSwitcher {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final IntelligentSummaryUpgradesSwitcher INSTANCE = new IntelligentSummaryUpgradesSwitcher();
    private static final VideoUpdateSwitcher intelligentSummaryPanelSwitch$delegate = new VideoUpdateSwitcher("flow_video_summary_panel", false);
    private static final VideoUpdateSwitcher intelligentSummaryPrioritySwitch$delegate = new VideoUpdateSwitcher("flow_video_next_pk_summary", false);

    private IntelligentSummaryUpgradesSwitcher() {
    }

    static {
        Class<IntelligentSummaryUpgradesSwitcher> cls = IntelligentSummaryUpgradesSwitcher.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "intelligentSummaryPanelSwitch", "getIntelligentSummaryPanelSwitch()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "intelligentSummaryPrioritySwitch", "getIntelligentSummaryPrioritySwitch()Z", 0))};
    }

    public final boolean getIntelligentSummaryPanelSwitch() {
        return ((Boolean) intelligentSummaryPanelSwitch$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setIntelligentSummaryPanelSwitch(boolean z) {
        intelligentSummaryPanelSwitch$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final boolean getIntelligentSummaryPrioritySwitch() {
        return ((Boolean) intelligentSummaryPrioritySwitch$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final void setIntelligentSummaryPrioritySwitch(boolean z) {
        intelligentSummaryPrioritySwitch$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z));
    }
}
