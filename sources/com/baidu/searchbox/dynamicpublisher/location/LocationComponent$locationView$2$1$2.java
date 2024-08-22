package com.baidu.searchbox.dynamicpublisher.location;

import com.baidu.searchbox.ugc.location.LocationView;
import com.baidu.ugc.position.model.PoiModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "poiModel", "Lcom/baidu/ugc/position/model/PoiModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationComponent.kt */
final class LocationComponent$locationView$2$1$2 extends Lambda implements Function1<PoiModel, Unit> {
    final /* synthetic */ LocationView $this_apply;
    final /* synthetic */ LocationComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationComponent$locationView$2$1$2(LocationComponent locationComponent, LocationView locationView) {
        super(1);
        this.this$0 = locationComponent;
        this.$this_apply = locationView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((PoiModel) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(PoiModel poiModel) {
        if (poiModel != null) {
            this.this$0.isLocated = true;
            this.this$0.poiModel = poiModel;
            this.$this_apply.showLocDetail(poiModel, false);
            this.$this_apply.hideRecommendLoc();
        }
    }
}
