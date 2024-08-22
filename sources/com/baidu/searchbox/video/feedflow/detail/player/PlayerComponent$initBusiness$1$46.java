package com.baidu.searchbox.video.feedflow.detail.player;

import com.baidu.searchbox.flowvideo.theaterhistory.FlowVideoTheaterHistoryModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlayerComponent.kt */
/* synthetic */ class PlayerComponent$initBusiness$1$46 extends FunctionReferenceImpl implements Function0<FlowVideoTheaterHistoryModel> {
    PlayerComponent$initBusiness$1$46(Object obj) {
        super(0, obj, PlayerComponent.class, "getTheaterHistoryModel", "getTheaterHistoryModel()Lcom/baidu/searchbox/flowvideo/theaterhistory/FlowVideoTheaterHistoryModel;", 0);
    }

    public final FlowVideoTheaterHistoryModel invoke() {
        return ((PlayerComponent) this.receiver).getTheaterHistoryModel();
    }
}
