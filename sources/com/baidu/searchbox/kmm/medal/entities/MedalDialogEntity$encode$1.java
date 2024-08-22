package com.baidu.searchbox.kmm.medal.entities;

import com.baidu.searchbox.download.center.ui.DownloadedCategorySecActivity;
import com.baidu.searchbox.kmm.foundation.kelson.JsonObjectBuilder;
import com.baidu.wallet.api.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonObjectBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MedalDialogEntity.kt */
final class MedalDialogEntity$encode$1 extends Lambda implements Function1<JsonObjectBuilder, Unit> {
    final /* synthetic */ MedalDialogEntity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MedalDialogEntity$encode$1(MedalDialogEntity medalDialogEntity) {
        super(1);
        this.this$0 = medalDialogEntity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((JsonObjectBuilder) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(JsonObjectBuilder $this$buildJsonObject) {
        Intrinsics.checkNotNullParameter($this$buildJsonObject, "$this$buildJsonObject");
        $this$buildJsonObject.put("pop_up", Boolean.valueOf(this.this$0.getNeedShowMedalDialog()));
        $this$buildJsonObject.put("category_id", this.this$0.getMedalCategoryId());
        $this$buildJsonObject.put("item_id", this.this$0.getMedalItemId());
        $this$buildJsonObject.put("title", this.this$0.getMedalDialogTitle());
        $this$buildJsonObject.put("push_button", this.this$0.getMedalDialogBtnTitle());
        $this$buildJsonObject.put("content", this.this$0.getMedalDialogContent());
        $this$buildJsonObject.put("item_img", this.this$0.getMedalDialogPortraitUrl());
        $this$buildJsonObject.put(Constants.JUMP_URL, this.this$0.getMedalDialogAppUrl());
        $this$buildJsonObject.put("pop_type", Integer.valueOf(this.this$0.getShowMedalDialogType()));
        $this$buildJsonObject.put(DownloadedCategorySecActivity.EXTRA_TYPE_KEY, Integer.valueOf(this.this$0.getMedalCategoryType()));
    }
}
