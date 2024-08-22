package com.baidu.searchbox.kmm.personalcenter.processors;

import com.baidu.searchbox.kmm.foundation.kelson.JsonArray;
import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt;
import com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.ConstantsKt;
import com.baidu.searchbox.lockscreen.config.BubbleConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCenterTabClickInfoProcessor.kt */
final class PersonalCenterTabClickInfoProcessorKt$updatePersonalisedTabsClickTime$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $clickTime;
    final /* synthetic */ String $id;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalCenterTabClickInfoProcessorKt$updatePersonalisedTabsClickTime$1(String str, String str2) {
        super(0);
        this.$id = str;
        this.$clickTime = str2;
    }

    public final void invoke() {
        if (JsonUtilKt.toJsonArray(QuickConfigKt.getQuickConfigString("personalCenterPersonalisedTabs", BubbleConfig.BUBBLE_EMPTY_DATA_STR)) != null) {
            List<PersonalCenterTabClickInfo> $this$forEach$iv = PersonalCenterTabClickInfoProcessorKt.readCachedPersonalisedTabsClickInfo();
            boolean needUpdateCache = false;
            String str = this.$id;
            String str2 = this.$clickTime;
            for (PersonalCenterTabClickInfo personalisedTabClickInfo : $this$forEach$iv) {
                if (Intrinsics.areEqual((Object) str, (Object) personalisedTabClickInfo.getId())) {
                    needUpdateCache = true;
                    personalisedTabClickInfo.setClickTime(str2);
                }
            }
            if (needUpdateCache) {
                JsonArray jsonArrayToCache = new JsonArray();
                for (PersonalCenterTabClickInfo personalisedTabClickInfo2 : $this$forEach$iv) {
                    JsonObject personalCenterTabClickInfoJsonObject = new JsonObject();
                    personalCenterTabClickInfoJsonObject.put("id", personalisedTabClickInfo2.getId());
                    personalCenterTabClickInfoJsonObject.put("clickTime", personalisedTabClickInfo2.getClickTime());
                    personalCenterTabClickInfoJsonObject.put(ConstantsKt.SHOW_TIME, personalisedTabClickInfo2.getShowTime());
                    jsonArrayToCache.add(personalCenterTabClickInfoJsonObject);
                }
                QuickConfigKt.setQuickConfigString("personalCenterPersonalisedTabs", jsonArrayToCache.toString());
            }
        }
    }
}
