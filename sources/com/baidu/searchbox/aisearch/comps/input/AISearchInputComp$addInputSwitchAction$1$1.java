package com.baidu.searchbox.aisearch.comps.input;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AISearchInputComp.kt */
final class AISearchInputComp$addInputSwitchAction$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AISearchInputComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AISearchInputComp$addInputSwitchAction$1$1(AISearchInputComp aISearchInputComp) {
        super(0);
        this.this$0 = aISearchInputComp;
    }

    public final void invoke() {
        if (!this.this$0.sendInterceptCommon()) {
            if (this.this$0.currentInputMode == 0) {
                this.this$0.ubcModeClick("voice_mode");
                this.this$0.switchInputModeWithShowKeyboard(1);
                return;
            }
            this.this$0.ubcModeClick("text_mode");
            this.this$0.switchInputModeWithShowKeyboard(0);
        }
    }
}
