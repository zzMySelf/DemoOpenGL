package com.baidu.searchbox.kmm.personalpage.shop.entities;

import com.baidu.searchbox.kmm.foundation.kelson.JsonObjectBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonObjectBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageGalleryImageEntity.kt */
final class PersonalPageGalleryImageEntity$encode$1 extends Lambda implements Function1<JsonObjectBuilder, Unit> {
    final /* synthetic */ PersonalPageGalleryImageEntity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalPageGalleryImageEntity$encode$1(PersonalPageGalleryImageEntity personalPageGalleryImageEntity) {
        super(1);
        this.this$0 = personalPageGalleryImageEntity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((JsonObjectBuilder) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(JsonObjectBuilder $this$buildJsonObject) {
        Intrinsics.checkNotNullParameter($this$buildJsonObject, "$this$buildJsonObject");
        $this$buildJsonObject.put("id", this.this$0.getImageId());
        $this$buildJsonObject.put("title", this.this$0.getTitle());
        $this$buildJsonObject.put("dynamicImgUrl", this.this$0.getDynamicImgUrl());
        $this$buildJsonObject.put("staticImgUrl", this.this$0.getStaticImgUrl());
        $this$buildJsonObject.put("staticBigImgUrl", this.this$0.getStaticBigImgUrl());
        $this$buildJsonObject.put("afxUrl", this.this$0.getAfxUrl());
        $this$buildJsonObject.put("mp4Url", this.this$0.getMp4Url());
        if (this.this$0.isVip()) {
            $this$buildJsonObject.put("isVip", "1");
        } else {
            $this$buildJsonObject.put("isVip", "0");
        }
        $this$buildJsonObject.put("tags", this.this$0.tags);
        $this$buildJsonObject.put("tagUrls", this.this$0.tagUrls);
        $this$buildJsonObject.put("type", Integer.valueOf(this.this$0.getType()));
        $this$buildJsonObject.put("end_time", this.this$0.endTime);
        if (this.this$0.isAi()) {
            $this$buildJsonObject.put("is_ai", "1");
        } else {
            $this$buildJsonObject.put("is_ai", "0");
        }
        $this$buildJsonObject.put("prompt", this.this$0.getAiPrompt());
        PersonalPageGalleryTaskDataEntity it = this.this$0.getTaskData();
        if (it != null) {
            $this$buildJsonObject.put("task_data", it.encode());
        }
    }
}
