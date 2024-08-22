package com.tera.scan.utils.listdiff.updatecallback;

import fe.mmm.qw.j.nn.de.fe;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.utils.listdiff.updatecallback.DispatchUpdatesKt", f = "DispatchUpdates.kt", i = {0, 0, 0, 1}, l = {42, 45}, m = "dispatchUpdatesRecursive", n = {"$this$dispatchUpdatesRecursive", "listUpdateFlow", "diffResult", "listUpdateFlow"}, s = {"L$0", "L$1", "L$2", "L$0"})
public final class DispatchUpdatesKt$dispatchUpdatesRecursive$1<T> extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    public DispatchUpdatesKt$dispatchUpdatesRecursive$1(Continuation<? super DispatchUpdatesKt$dispatchUpdatesRecursive$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DispatchUpdatesKt.qw((ListUpdateEventDispatcher) null, (List) null, (List) null, (fe) null, this);
    }
}
