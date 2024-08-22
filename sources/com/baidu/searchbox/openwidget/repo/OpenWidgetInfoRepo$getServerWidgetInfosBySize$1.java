package com.baidu.searchbox.openwidget.repo;

import com.baidu.searchbox.openwidget.model.OpenWidgetSize;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.openwidget.repo.OpenWidgetInfoRepo", f = "OpenWidgetInfoRepo.kt", i = {0, 0, 0, 0, 0}, l = {108}, m = "getServerWidgetInfosBySize", n = {"this", "size", "result", "index", "hasMore"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: OpenWidgetInfoRepo.kt */
final class OpenWidgetInfoRepo$getServerWidgetInfosBySize$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenWidgetInfoRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OpenWidgetInfoRepo$getServerWidgetInfosBySize$1(OpenWidgetInfoRepo openWidgetInfoRepo, Continuation<? super OpenWidgetInfoRepo$getServerWidgetInfosBySize$1> continuation) {
        super(continuation);
        this.this$0 = openWidgetInfoRepo;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getServerWidgetInfosBySize((OpenWidgetSize) null, this);
    }
}
