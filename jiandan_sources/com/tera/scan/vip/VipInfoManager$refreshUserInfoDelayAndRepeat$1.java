package com.tera.scan.vip;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tera.scan.vip.VipInfoManager$refreshUserInfoDelayAndRepeat$1", f = "VipInfoManager.kt", i = {0, 1}, l = {226, 133}, m = "invokeSuspend", n = {"i", "i"}, s = {"I$0", "I$0"})
public final class VipInfoManager$refreshUserInfoDelayAndRepeat$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ long $delayTime;
    public final /* synthetic */ int $repeatCount;
    public int I$0;
    public Object L$0;
    public int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VipInfoManager$refreshUserInfoDelayAndRepeat$1(int i2, long j, Context context, Continuation<? super VipInfoManager$refreshUserInfoDelayAndRepeat$1> continuation) {
        super(2, continuation);
        this.$repeatCount = i2;
        this.$delayTime = j;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VipInfoManager$refreshUserInfoDelayAndRepeat$1(this.$repeatCount, this.$delayTime, this.$context, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VipInfoManager$refreshUserInfoDelayAndRepeat$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0099  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0029
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            int r1 = r8.I$0
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r8
            goto L_0x00a9
        L_0x0016:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001e:
            int r1 = r8.I$0
            java.lang.Object r4 = r8.L$0
            android.content.Context r4 = (android.content.Context) r4
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r8
            goto L_0x0070
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = 0
            r1 = r8
        L_0x002e:
            int r4 = r1.$repeatCount
            if (r9 >= r4) goto L_0x00ad
            android.content.Context r4 = r1.$context
            r1.L$0 = r4
            r1.I$0 = r9
            r1.label = r3
            i.qw.ggg r5 = new i.qw.ggg
            kotlin.coroutines.Continuation r6 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r1)
            r5.<init>(r6, r3)
            r5.eee()
            com.tera.scan.vip.network.VipManager r6 = new com.tera.scan.vip.network.VipManager
            r6.<init>(r4)
            androidx.lifecycle.LiveData r4 = r6.qw()
            java.lang.String r6 = "VipManager(context).getUserInfo()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            com.tera.scan.vip.VipInfoManager$refreshUserInfoDelayAndRepeat$1$isVip$1$1 r6 = new com.tera.scan.vip.VipInfoManager$refreshUserInfoDelayAndRepeat$1$isVip$1$1
            r6.<init>(r4, r5)
            r4.observeForever(r6)
            java.lang.Object r4 = r5.mmm()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L_0x0069
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r1)
        L_0x0069:
            if (r4 != r0) goto L_0x006c
            return r0
        L_0x006c:
            r7 = r1
            r1 = r9
            r9 = r4
            r4 = r7
        L_0x0070:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 31532(0x7b2c, float:4.4186E-41)
            r5.append(r6)
            int r6 = r1 + 1
            r5.append(r6)
            java.lang.String r6 = "次获取会员信息,  isVip="
            r5.append(r6)
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = ""
            com.mars.kotlin.extension.LoggerKt.d(r5, r6)
            if (r9 == 0) goto L_0x0099
            goto L_0x00ad
        L_0x0099:
            long r5 = r4.$delayTime
            r9 = 0
            r4.L$0 = r9
            r4.I$0 = r1
            r4.label = r2
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.ad(r5, r4)
            if (r9 != r0) goto L_0x00a9
            return r0
        L_0x00a9:
            int r9 = r1 + 1
            r1 = r4
            goto L_0x002e
        L_0x00ad:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.vip.VipInfoManager$refreshUserInfoDelayAndRepeat$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
