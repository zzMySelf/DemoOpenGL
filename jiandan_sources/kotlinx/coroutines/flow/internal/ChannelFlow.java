package kotlinx.coroutines.flow.internal;

import com.baidu.android.common.others.lang.StringUtil;
import i.qw.j;
import i.qw.k;
import i.qw.l;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u001f\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\fH¤@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH$J\u0010\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010 H\u0016J&\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010\u001c\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R9\u0010\n\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b8@X\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectToFun", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "produceCapacity", "getProduceCapacity$kotlinx_coroutines_core", "()I", "additionalToStringProps", "", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "fuse", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ChannelFlow<T> implements FusibleFlow<T> {
    @NotNull
    @JvmField

    /* renamed from: ad  reason: collision with root package name */
    public final CoroutineContext f6421ad;
    @JvmField

    /* renamed from: th  reason: collision with root package name */
    public final int f6422th;
    @NotNull
    @JvmField

    /* renamed from: yj  reason: collision with root package name */
    public final BufferOverflow f6423yj;

    public ChannelFlow(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        this.f6421ad = coroutineContext;
        this.f6422th = i2;
        this.f6423yj = bufferOverflow;
        if (k.qw()) {
            if (!(this.f6422th != -1)) {
                throw new AssertionError();
            }
        }
    }

    public static /* synthetic */ Object uk(ChannelFlow channelFlow, FlowCollector flowCollector, Continuation continuation) {
        Object ad2 = j.ad(new ChannelFlow$collect$2(flowCollector, channelFlow, (Continuation<? super ChannelFlow$collect$2>) null), continuation);
        return ad2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? ad2 : Unit.INSTANCE;
    }

    @NotNull
    public Flow<T> ad(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        boolean z = true;
        if (k.qw()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        CoroutineContext plus = coroutineContext.plus(this.f6421ad);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i3 = this.f6422th;
            if (i3 != -3) {
                if (i2 != -3) {
                    if (i3 != -2) {
                        if (i2 != -2) {
                            if (k.qw()) {
                                if (!(this.f6422th >= 0)) {
                                    throw new AssertionError();
                                }
                            }
                            if (k.qw()) {
                                if (i2 < 0) {
                                    z = false;
                                }
                                if (!z) {
                                    throw new AssertionError();
                                }
                            }
                            i3 = this.f6422th + i2;
                            if (i3 < 0) {
                                i2 = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i2 = i3;
            }
            bufferOverflow = this.f6423yj;
        }
        if (Intrinsics.areEqual((Object) plus, (Object) this.f6421ad) && i2 == this.f6422th && bufferOverflow == this.f6423yj) {
            return this;
        }
        return o(plus, i2, bufferOverflow);
    }

    @Nullable
    public Object fe(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        return uk(this, flowCollector, continuation);
    }

    @Nullable
    public abstract Object i(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation);

    /* renamed from: if  reason: not valid java name */
    public final int m663if() {
        int i2 = this.f6422th;
        if (i2 == -3) {
            return -2;
        }
        return i2;
    }

    @NotNull
    public abstract ChannelFlow<T> o(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow);

    @NotNull
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> pf() {
        return new ChannelFlow$collectToFun$1(this, (Continuation<? super ChannelFlow$collectToFun$1>) null);
    }

    @NotNull
    /* renamed from: switch  reason: not valid java name */
    public ReceiveChannel<T> m664switch(@NotNull CoroutineScope coroutineScope) {
        return ProduceKt.th(coroutineScope, this.f6421ad, m663if(), this.f6423yj, CoroutineStart.ATOMIC, (Function1) null, pf(), 16, (Object) null);
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String yj2 = yj();
        if (yj2 != null) {
            arrayList.add(yj2);
        }
        CoroutineContext coroutineContext = this.f6421ad;
        if (coroutineContext != EmptyCoroutineContext.INSTANCE) {
            arrayList.add(Intrinsics.stringPlus("context=", coroutineContext));
        }
        int i2 = this.f6422th;
        if (i2 != -3) {
            arrayList.add(Intrinsics.stringPlus("capacity=", Integer.valueOf(i2)));
        }
        BufferOverflow bufferOverflow = this.f6423yj;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            arrayList.add(Intrinsics.stringPlus("onBufferOverflow=", bufferOverflow));
        }
        return l.qw(this) + '[' + CollectionsKt___CollectionsKt.joinToString$default(arrayList, StringUtil.ARRAY_ELEMENT_SEPARATOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + ']';
    }

    @Nullable
    public String yj() {
        return null;
    }
}
