package com.tera.scan.framework.swipeback;

import android.content.Context;
import android.widget.Scroller;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/Scroller;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwipeBackLayout$scroller$2 extends Lambda implements Function0<Scroller> {
    public final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout$scroller$2(Context context) {
        super(0);
        this.$context = context;
    }

    @NotNull
    public final Scroller invoke() {
        return new Scroller(this.$context);
    }
}
