package com.tera.scan.file.selector.adpter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LocalImageSelectAdapter$packageName$2 extends Lambda implements Function0<String> {
    public final /* synthetic */ LocalImageSelectAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocalImageSelectAdapter$packageName$2(LocalImageSelectAdapter localImageSelectAdapter) {
        super(0);
        this.this$0 = localImageSelectAdapter;
    }

    public final String invoke() {
        return this.this$0.context.getPackageName();
    }
}
