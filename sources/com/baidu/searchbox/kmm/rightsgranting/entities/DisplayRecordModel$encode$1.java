package com.baidu.searchbox.kmm.rightsgranting.entities;

import com.baidu.searchbox.kmm.foundation.kelson.JsonObjectBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonObjectBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: DisplayRecordModel.kt */
final class DisplayRecordModel$encode$1 extends Lambda implements Function1<JsonObjectBuilder, Unit> {
    final /* synthetic */ DisplayRecordModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DisplayRecordModel$encode$1(DisplayRecordModel displayRecordModel) {
        super(1);
        this.this$0 = displayRecordModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((JsonObjectBuilder) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(JsonObjectBuilder $this$buildJsonObject) {
        Intrinsics.checkNotNullParameter($this$buildJsonObject, "$this$buildJsonObject");
        $this$buildJsonObject.put("scene", this.this$0.getScene());
        $this$buildJsonObject.put("rightsID", this.this$0.getRightsID());
        $this$buildJsonObject.put("time", Long.valueOf(this.this$0.getTime()));
        $this$buildJsonObject.put("from", this.this$0.getFrom());
    }
}
