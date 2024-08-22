package com.baidu.searchbox.videopublisher.location;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.videopublisher.location.LocationAction;
import com.baidu.searchbox.videopublisher.ubc.UBCAction;
import com.baidu.searchbox.videopublisher.ubc.UBCConstantsKt;
import com.baidu.searchbox.videopublisher.ubc.UBCEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "model", "Lcom/baidu/searchbox/videopublisher/location/LocationModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationComponent.kt */
final class LocationComponent$locationView$2$1$2 extends Lambda implements Function1<LocationModel, Unit> {
    final /* synthetic */ LocationComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationComponent$locationView$2$1$2(LocationComponent locationComponent) {
        super(1);
        this.this$0 = locationComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((LocationModel) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(LocationModel model) {
        Store access$getStore = this.this$0.getStore();
        if (access$getStore != null) {
            access$getStore.dispatch(new LocationAction.SelectComplete(model));
        }
        Store access$getStore2 = this.this$0.getStore();
        if (access$getStore2 != null) {
            access$getStore2.dispatch(new UBCAction.DoEvent(new UBCEvent(UBCConstantsKt.UBC_TYPE_POI_BUBBLE, (String) null, (String) null, (Map) null, 14, (DefaultConstructorMarker) null)));
        }
    }
}
