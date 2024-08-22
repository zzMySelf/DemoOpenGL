package com.baidu.searchbox.aibot.runtime;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/aibot/runtime/IAISearchWebContext$Companion$Empty$1", "Lcom/baidu/searchbox/aibot/runtime/IAISearchWebContext;", "handleUrl", "", "context", "Landroid/content/Context;", "url", "", "from", "lib-aibot-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IAISearchWebContext.kt */
public final class IAISearchWebContext$Companion$Empty$1 implements IAISearchWebContext {
    IAISearchWebContext$Companion$Empty$1() {
    }

    public boolean handleUrl(Context context, String url, String from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(from, "from");
        return false;
    }
}
