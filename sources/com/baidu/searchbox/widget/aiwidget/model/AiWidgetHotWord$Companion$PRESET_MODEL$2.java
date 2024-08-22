package com.baidu.searchbox.widget.aiwidget.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/widget/aiwidget/model/AiWidgetHotWord;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiWidgetHotWord.kt */
final class AiWidgetHotWord$Companion$PRESET_MODEL$2 extends Lambda implements Function0<AiWidgetHotWord> {
    public static final AiWidgetHotWord$Companion$PRESET_MODEL$2 INSTANCE = new AiWidgetHotWord$Companion$PRESET_MODEL$2();

    AiWidgetHotWord$Companion$PRESET_MODEL$2() {
        super(0);
    }

    public final AiWidgetHotWord invoke() {
        return new AiWidgetHotWord(AiWidgetTextNode.Companion.getPRESET_HOT_WORD(), AiWidgetTextNode.Companion.getPRESET_REC_LIST());
    }
}
