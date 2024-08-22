package com.baidu.searchbox.video.feedflow.update;

import com.baidu.searchbox.download.center.clearcache.view.guide.PhoneAccelerateWidgetGuideConfigListenerKt;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.detail.switcher.VideoSPData;
import com.baidu.searchbox.video.feedflow.detail.publish.PublishEntrySwitchConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R+\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/update/FlowPublishEntrySwitcher;", "", "()V", "JSON_KEY_FLOW_PUBLISH_ENTRY", "", "JSON_KEY_INTERVAL_DAYS", "JSON_KEY_NO_CLICK_DAYS", "JSON_KEY_SHOW_TIMES", "SP_KEY_PUBLISH_ENTRY_DAY_SHOW_MAX", "SP_KEY_PUBLISH_ENTRY_EXIT_DAYS", "SP_KEY_PUBLISH_ENTRY_EXIT_OVERLOOK_DAYS", "<set-?>", "", "publishEntryDayShowMax", "getPublishEntryDayShowMax", "()I", "setPublishEntryDayShowMax", "(I)V", "publishEntryDayShowMax$delegate", "Lcom/baidu/searchbox/video/detail/switcher/VideoSPData;", "publishEntryExitDays", "getPublishEntryExitDays", "setPublishEntryExitDays", "publishEntryExitDays$delegate", "publishEntryExitOverlookDays", "getPublishEntryExitOverlookDays", "setPublishEntryExitOverlookDays", "publishEntryExitOverlookDays$delegate", "getFlowPublishEntranceSwitch", "Lcom/baidu/searchbox/video/feedflow/detail/publish/PublishEntrySwitchConfig;", "handleFlowPublishEntranceSwitch", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowPublishEntrySwitcher.kt */
public final class FlowPublishEntrySwitcher {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final FlowPublishEntrySwitcher INSTANCE = new FlowPublishEntrySwitcher();
    private static final String JSON_KEY_FLOW_PUBLISH_ENTRY = "flow_publish_entry";
    private static final String JSON_KEY_INTERVAL_DAYS = "intervalDays";
    private static final String JSON_KEY_NO_CLICK_DAYS = "noClickDays";
    private static final String JSON_KEY_SHOW_TIMES = "showTimes";
    private static final String SP_KEY_PUBLISH_ENTRY_DAY_SHOW_MAX = "flow_publish_entry";
    private static final String SP_KEY_PUBLISH_ENTRY_EXIT_DAYS = "intervalDays";
    private static final String SP_KEY_PUBLISH_ENTRY_EXIT_OVERLOOK_DAYS = "noClickDays";
    private static final VideoSPData publishEntryDayShowMax$delegate = new VideoSPData("flow_publish_entry", 10, false, (String) null, 12, (DefaultConstructorMarker) null);
    private static final VideoSPData publishEntryExitDays$delegate = new VideoSPData(PhoneAccelerateWidgetGuideConfigListenerKt.KEY_INTERVAL_DAYS, 3, false, (String) null, 12, (DefaultConstructorMarker) null);
    private static final VideoSPData publishEntryExitOverlookDays$delegate = new VideoSPData("noClickDays", 3, false, (String) null, 12, (DefaultConstructorMarker) null);

    private FlowPublishEntrySwitcher() {
    }

    public final int getPublishEntryDayShowMax() {
        return ((Number) publishEntryDayShowMax$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final void setPublishEntryDayShowMax(int i2) {
        publishEntryDayShowMax$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i2));
    }

    static {
        Class<FlowPublishEntrySwitcher> cls = FlowPublishEntrySwitcher.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "publishEntryDayShowMax", "getPublishEntryDayShowMax()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "publishEntryExitOverlookDays", "getPublishEntryExitOverlookDays()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "publishEntryExitDays", "getPublishEntryExitDays()I", 0))};
    }

    public final int getPublishEntryExitOverlookDays() {
        return ((Number) publishEntryExitOverlookDays$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final void setPublishEntryExitOverlookDays(int i2) {
        publishEntryExitOverlookDays$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i2));
    }

    public final int getPublishEntryExitDays() {
        return ((Number) publishEntryExitDays$delegate.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final void setPublishEntryExitDays(int i2) {
        publishEntryExitDays$delegate.setValue(this, $$delegatedProperties[2], Integer.valueOf(i2));
    }

    public final void handleFlowPublishEntranceSwitch(ActionData<JSONObject> value) {
        Object obj;
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            Result.Companion companion = Result.Companion;
            FlowPublishEntrySwitcher $this$handleFlowPublishEntranceSwitch_u24lambda_u2d0 = this;
            JSONObject jSONObject = (JSONObject) value.data;
            Integer num = null;
            JSONObject nodeConfig = jSONObject != null ? jSONObject.optJSONObject("flow_publish_entry") : null;
            $this$handleFlowPublishEntranceSwitch_u24lambda_u2d0.setPublishEntryDayShowMax(BdPlayerUtils.orZero(nodeConfig != null ? Integer.valueOf(nodeConfig.optInt("showTimes")) : null));
            $this$handleFlowPublishEntranceSwitch_u24lambda_u2d0.setPublishEntryExitOverlookDays(BdPlayerUtils.orZero(nodeConfig != null ? Integer.valueOf(nodeConfig.optInt("noClickDays")) : null));
            if (nodeConfig != null) {
                num = Integer.valueOf(nodeConfig.optInt(PhoneAccelerateWidgetGuideConfigListenerKt.KEY_INTERVAL_DAYS));
            }
            $this$handleFlowPublishEntranceSwitch_u24lambda_u2d0.setPublishEntryExitDays(BdPlayerUtils.orZero(num));
            obj = Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r0 = Result.m8974exceptionOrNullimpl(obj);
    }

    public final PublishEntrySwitchConfig getFlowPublishEntranceSwitch() {
        return new PublishEntrySwitchConfig(getPublishEntryDayShowMax(), getPublishEntryExitOverlookDays(), getPublishEntryExitDays());
    }
}
