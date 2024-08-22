package com.baidu.searchbox.widget.quickbox;

import com.baidu.searchbox.widget.aiwidget.model.AiWidgetSkin;
import com.baidu.searchbox.widget.aiwidget.model.AiWidgetTextNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickSearchAiWidget.kt */
final class QuickSearchAiWidget$updateSearchBoxArea$1 extends Lambda implements Function0<String> {
    final /* synthetic */ AiWidgetTextNode $hotWord;
    final /* synthetic */ AiWidgetSkin.SkinType $skinType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuickSearchAiWidget$updateSearchBoxArea$1(AiWidgetSkin.SkinType skinType, AiWidgetTextNode aiWidgetTextNode) {
        super(0);
        this.$skinType = skinType;
        this.$hotWord = aiWidgetTextNode;
    }

    public final String invoke() {
        return "QuickSearchWidget updateSearchBoxArea, skinType = " + this.$skinType + ", hotWord = " + this.$hotWord;
    }
}
