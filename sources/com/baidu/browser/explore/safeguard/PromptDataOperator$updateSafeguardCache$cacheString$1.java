package com.baidu.browser.explore.safeguard;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/browser/explore/safeguard/SafeguardNode;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PromptDataOperator.kt */
final class PromptDataOperator$updateSafeguardCache$cacheString$1 extends Lambda implements Function1<SafeguardNode, CharSequence> {
    public static final PromptDataOperator$updateSafeguardCache$cacheString$1 INSTANCE = new PromptDataOperator$updateSafeguardCache$cacheString$1();

    PromptDataOperator$updateSafeguardCache$cacheString$1() {
        super(1);
    }

    public final CharSequence invoke(SafeguardNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toSerialize();
    }
}
