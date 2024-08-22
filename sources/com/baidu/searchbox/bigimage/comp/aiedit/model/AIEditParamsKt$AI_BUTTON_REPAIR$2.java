package com.baidu.searchbox.bigimage.comp.aiedit.model;

import com.baidu.searchbox.bigimage.R;
import com.baidu.searchbox.bigimage.runtime.BigImageRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/bigimage/comp/aiedit/model/AIEditInfoModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIEditParams.kt */
final class AIEditParamsKt$AI_BUTTON_REPAIR$2 extends Lambda implements Function0<AIEditInfoModel> {
    public static final AIEditParamsKt$AI_BUTTON_REPAIR$2 INSTANCE = new AIEditParamsKt$AI_BUTTON_REPAIR$2();

    AIEditParamsKt$AI_BUTTON_REPAIR$2() {
        super(0);
    }

    public final AIEditInfoModel invoke() {
        String string = BigImageRuntime.getAppContext().getString(R.string.search_big_image_ai_bt_repair);
        Intrinsics.checkNotNullExpressionValue(string, "getAppContext().getStrin…h_big_image_ai_bt_repair)");
        return new AIEditInfoModel(string, AIEditParamsKt.getAI_BUTTON_ICON_URL(), (String) null, 4, (DefaultConstructorMarker) null);
    }
}
