package com.baidu.searchbox.aisearch.yalog;

import com.baidu.searchbox.aisearch.scheme.UnitedSchemeAISearchDispatcherKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/aisearch/yalog/CommonYalog;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AISearchYalog.kt */
final class AISearchYalog$logInstance$2 extends Lambda implements Function0<CommonYalog> {
    public static final AISearchYalog$logInstance$2 INSTANCE = new AISearchYalog$logInstance$2();

    AISearchYalog$logInstance$2() {
        super(0);
    }

    public final CommonYalog invoke() {
        return CommonYalog.Companion.getInstance(UnitedSchemeAISearchDispatcherKt.MODULE_NAME);
    }
}
