package com.baidu.searchbox.feed.detail.util;

import com.baidu.searchbox.block.BlockUpdateListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/feed/detail/util/ThreadExecutor$Impl$get$1", "Lcom/baidu/searchbox/feed/detail/util/ThreadExecutor;", "runInSerialThread", "", "block", "Lkotlin/Function0;", "runInThread", "lib-component-arch_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThreadExecutor.kt */
public final class ThreadExecutor$Impl$get$1 implements ThreadExecutor {
    ThreadExecutor$Impl$get$1() {
    }

    public void runInThread(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, BlockUpdateListener.ACTION_BLOCK);
    }

    public void runInSerialThread(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, BlockUpdateListener.ACTION_BLOCK);
    }
}
