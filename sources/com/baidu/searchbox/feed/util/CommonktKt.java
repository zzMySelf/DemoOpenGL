package com.baidu.searchbox.feed.util;

import com.baidu.searchbox.block.BlockUpdateListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u0002H\u00012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u00060\u00032\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\bH\bø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0007\n\u0005\b20\u0001¨\u0006\n"}, d2 = {"withTry", "T", "action", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "block", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "lib-feed-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Commonkt.kt */
public final class CommonktKt {
    public static /* synthetic */ Object withTry$default(Object $this$withTry_u24default, Function1 action, Function1 block, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            action = CommonktKt$withTry$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(block, BlockUpdateListener.ACTION_BLOCK);
        try {
            block.invoke($this$withTry_u24default);
        } catch (Exception e2) {
            action.invoke(e2);
        }
        return $this$withTry_u24default;
    }

    public static final <T> T withTry(T $this$withTry, Function1<? super Exception, Unit> action, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(block, BlockUpdateListener.ACTION_BLOCK);
        try {
            block.invoke($this$withTry);
        } catch (Exception e2) {
            action.invoke(e2);
        }
        return $this$withTry;
    }
}
