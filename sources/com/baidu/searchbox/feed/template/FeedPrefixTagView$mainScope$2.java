package com.baidu.searchbox.feed.template;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedPrefixTagView.kt */
final class FeedPrefixTagView$mainScope$2 extends Lambda implements Function0<CoroutineScope> {
    public static final FeedPrefixTagView$mainScope$2 INSTANCE = new FeedPrefixTagView$mainScope$2();

    FeedPrefixTagView$mainScope$2() {
        super(0);
    }

    public final CoroutineScope invoke() {
        return CoroutineScopeKt.MainScope();
    }
}
