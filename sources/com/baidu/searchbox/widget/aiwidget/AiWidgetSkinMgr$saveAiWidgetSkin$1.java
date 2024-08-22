package com.baidu.searchbox.widget.aiwidget;

import com.baidu.searchbox.widget.aiwidget.model.AiWidgetSkin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiWidgetSkinMgr.kt */
final class AiWidgetSkinMgr$saveAiWidgetSkin$1 extends Lambda implements Function0<String> {
    final /* synthetic */ AiWidgetSkin $skin;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AiWidgetSkinMgr$saveAiWidgetSkin$1(AiWidgetSkin aiWidgetSkin) {
        super(0);
        this.$skin = aiWidgetSkin;
    }

    public final String invoke() {
        return "saveAiWidgetSkin: " + this.$skin;
    }
}
