package com.baidu.searchbox.openwidget;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.baidu.searchbox.openwidget.StatefulWidgetManager", f = "StatefulWidgetManager.kt", i = {0, 0, 0, 0}, l = {151}, m = "getOrNull", n = {"this", "context", "cached", "appWidgetId"}, s = {"L$0", "L$1", "L$2", "I$0"})
/* compiled from: StatefulWidgetManager.kt */
final class StatefulWidgetManager$getOrNull$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StatefulWidgetManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StatefulWidgetManager$getOrNull$1(StatefulWidgetManager statefulWidgetManager, Continuation<? super StatefulWidgetManager$getOrNull$1> continuation) {
        super(continuation);
        this.this$0 = statefulWidgetManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getOrNull((Context) null, 0, this);
    }
}
