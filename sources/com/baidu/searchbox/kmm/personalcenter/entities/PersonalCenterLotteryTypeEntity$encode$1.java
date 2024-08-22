package com.baidu.searchbox.kmm.personalcenter.entities;

import com.baidu.searchbox.kmm.foundation.kelson.JsonObjectBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonObjectBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCenterLotteryTypeEntity.kt */
final class PersonalCenterLotteryTypeEntity$encode$1 extends Lambda implements Function1<JsonObjectBuilder, Unit> {
    final /* synthetic */ PersonalCenterLotteryTypeEntity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalCenterLotteryTypeEntity$encode$1(PersonalCenterLotteryTypeEntity personalCenterLotteryTypeEntity) {
        super(1);
        this.this$0 = personalCenterLotteryTypeEntity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((JsonObjectBuilder) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(JsonObjectBuilder $this$buildJsonObject) {
        Intrinsics.checkNotNullParameter($this$buildJsonObject, "$this$buildJsonObject");
        $this$buildJsonObject.put("id", this.this$0.getLotteryId());
        $this$buildJsonObject.put("title", this.this$0.getTitle());
        $this$buildJsonObject.put("icon", this.this$0.getIcon());
    }
}
