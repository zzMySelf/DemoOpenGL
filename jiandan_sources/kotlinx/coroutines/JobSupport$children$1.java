package kotlinx.coroutines;

import i.qw.v0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/ChildJob;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1}, l = {952, 954}, m = "invokeSuspend", n = {"this_$iv", "cur$iv"}, s = {"L$1", "L$2"})
public final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super ChildJob>, Continuation<? super Unit>, Object> {
    public /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public final /* synthetic */ v0 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(v0 v0Var, Continuation<? super JobSupport$children$1> continuation) {
        super(2, continuation);
        this.this$0 = v0Var;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, continuation);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super ChildJob> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((JobSupport$children$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002b
            if (r1 == r3) goto L_0x0027
            if (r1 != r2) goto L_0x001f
            java.lang.Object r1 = r7.L$2
            i.qw.x1.ggg r1 = (i.qw.x1.ggg) r1
            java.lang.Object r3 = r7.L$1
            i.qw.x1.when r3 = (i.qw.x1.when) r3
            java.lang.Object r4 = r7.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            goto L_0x007f
        L_0x001f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0084
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            kotlin.sequences.SequenceScope r8 = (kotlin.sequences.SequenceScope) r8
            i.qw.v0 r1 = r7.this$0
            java.lang.Object r1 = r1.I()
            boolean r4 = r1 instanceof i.qw.mmm
            if (r4 == 0) goto L_0x0049
            i.qw.mmm r1 = (i.qw.mmm) r1
            kotlinx.coroutines.ChildJob r1 = r1.f6149i
            r7.label = r3
            java.lang.Object r8 = r8.yield(r1, r7)
            if (r8 != r0) goto L_0x0084
            return r0
        L_0x0049:
            boolean r3 = r1 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto L_0x0084
            kotlinx.coroutines.Incomplete r1 = (kotlinx.coroutines.Incomplete) r1
            i.qw.a1 r1 = r1.qw()
            if (r1 != 0) goto L_0x0056
            goto L_0x0084
        L_0x0056:
            java.lang.Object r3 = r1.e()
            i.qw.x1.ggg r3 = (i.qw.x1.ggg) r3
            r4 = r8
            r8 = r7
            r6 = r3
            r3 = r1
            r1 = r6
        L_0x0061:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r5 != 0) goto L_0x0084
            boolean r5 = r1 instanceof i.qw.mmm
            if (r5 == 0) goto L_0x007f
            r5 = r1
            i.qw.mmm r5 = (i.qw.mmm) r5
            kotlinx.coroutines.ChildJob r5 = r5.f6149i
            r8.L$0 = r4
            r8.L$1 = r3
            r8.L$2 = r1
            r8.label = r2
            java.lang.Object r5 = r4.yield(r5, r8)
            if (r5 != r0) goto L_0x007f
            return r0
        L_0x007f:
            i.qw.x1.ggg r1 = r1.f()
            goto L_0x0061
        L_0x0084:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
