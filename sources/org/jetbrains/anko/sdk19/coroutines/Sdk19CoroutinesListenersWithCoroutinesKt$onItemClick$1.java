package org.jetbrains.anko.sdk19.coroutines;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0004*\b\u0012\u0002\b\u0003\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "p0", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "p1", "Landroid/view/View;", "p2", "", "p3", "", "onItemClick"}, k = 3, mv = {1, 1, 13})
/* compiled from: ListenersWithCoroutines.kt */
final class Sdk19CoroutinesListenersWithCoroutinesKt$onItemClick$1 implements AdapterView.OnItemClickListener {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function6 $handler;

    Sdk19CoroutinesListenersWithCoroutinesKt$onItemClick$1(CoroutineContext coroutineContext, Function6 function6) {
        this.$context = coroutineContext;
        this.$handler = function6;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 13})
    @DebugMetadata(c = "org/jetbrains/anko/sdk19/coroutines/Sdk19CoroutinesListenersWithCoroutinesKt$onItemClick$1$1", f = "ListenersWithCoroutines.kt", i = {}, l = {478, 480}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: org.jetbrains.anko.sdk19.coroutines.Sdk19CoroutinesListenersWithCoroutinesKt$onItemClick$1$1  reason: invalid class name */
    /* compiled from: ListenersWithCoroutines.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ Sdk19CoroutinesListenersWithCoroutinesKt$onItemClick$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "completion");
            AnonymousClass1 r1 = new AnonymousClass1(this.this$0, adapterView, view2, i2, j2, continuation);
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            r1.p$ = (CoroutineScope) obj;
            return r1;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    if (!(result instanceof Result.Failure)) {
                        CoroutineScope coroutineScope = this.p$;
                        Function6 function6 = this.this$0.$handler;
                        AdapterView adapterView = adapterView;
                        View view2 = view2;
                        Integer boxInt = Boxing.boxInt(i2);
                        Long boxLong = Boxing.boxLong(j2);
                        this.label = 1;
                        if (function6.invoke(coroutineScope, adapterView, view2, boxInt, boxLong, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw ((Result.Failure) result).exception;
                    }
                    break;
                case 1:
                    if (result instanceof Result.Failure) {
                        throw ((Result.Failure) result).exception;
                    }
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final void onItemClick(AdapterView<?> p0, View p1, int p2, long p3) {
        final AdapterView<?> adapterView = p0;
        final View view2 = p1;
        final int i2 = p2;
        final long j2 = p3;
        BuildersKt.launch(GlobalScope.INSTANCE, this.$context, CoroutineStart.DEFAULT, new AnonymousClass1(this, (Continuation) null));
    }
}
