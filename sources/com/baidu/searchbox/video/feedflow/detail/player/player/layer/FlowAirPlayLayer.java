package com.baidu.searchbox.video.feedflow.detail.player.player.layer;

import android.content.Context;
import com.baidu.searchbox.controller.AirPlayHelper;
import com.baidu.searchbox.event.AirPlayEvent;
import com.baidu.searchbox.layer.AirPlayLayer;
import com.baidu.searchbox.player.event.VideoEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/layer/FlowAirPlayLayer;", "Lcom/baidu/searchbox/layer/AirPlayLayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onAirPlayComplete", "", "onLayerEventNotify", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowAirPlayLayer.kt */
public final class FlowAirPlayLayer extends AirPlayLayer {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowAirPlayLayer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onAirPlayComplete() {
        if (isShowing()) {
            String curPlayUrl = getBindPlayer().getVideoUrl();
            CharSequence charSequence = curPlayUrl;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                setCurrentPosition(0);
                AirPlayHelper airPlayHelper = getAirPlayHelper();
                Intrinsics.checkNotNullExpressionValue(curPlayUrl, "curPlayUrl");
                airPlayHelper.play(curPlayUrl);
            }
        }
    }

    public void onLayerEventNotify(VideoEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.onLayerEventNotify(event);
        String action = event.getAction();
        switch (action.hashCode()) {
            case 1919752075:
                if (action.equals(AirPlayEvent.ACTION_AIRPLAY_CONTROL_PANEL_VISIBLE)) {
                    getContainer().setVisibility(event.getBooleanExtra(4) ? 0 : 8);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
