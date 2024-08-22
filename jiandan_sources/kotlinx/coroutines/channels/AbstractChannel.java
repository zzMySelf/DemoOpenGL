package kotlinx.coroutines.channels;

import i.qw.k;
import i.qw.l;
import i.qw.u1.Cif;
import i.qw.u1.th;
import i.qw.u1.when;
import i.qw.vvv;
import i.qw.x1.Cswitch;
import i.qw.x1.b;
import i.qw.x1.c;
import i.qw.x1.ggg;
import i.qw.x1.ppp;
import i.qw.xxx;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0007STUVWXYB'\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007J\u0016\u0010\u0019\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0018\u00010\u001cj\u0004\u0018\u0001`\u001dJ\u0017\u0010\u001e\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0004J\u0016\u0010\"\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0002J\u0016\u0010%\u001a\u00020\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0014JR\u0010&\u001a\u00020\n\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0002\u00100J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0002J\u0010\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\nH\u0014J/\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\n\u00109\u001a\u0006\u0012\u0002\b\u00030:H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<J\b\u0010=\u001a\u00020\u0006H\u0014J\b\u0010>\u001a\u00020\u0006H\u0014J\n\u0010?\u001a\u0004\u0018\u00010,H\u0014J\u0016\u0010@\u001a\u0004\u0018\u00010,2\n\u0010(\u001a\u0006\u0012\u0002\b\u00030)H\u0014J\u0011\u0010#\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010AJ\"\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bC\u0010AJ\u001f\u0010D\u001a\u0002H'\"\u0004\b\u0001\u0010'2\u0006\u0010.\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0002\u0010EJR\u0010F\u001a\u00020\u0006\"\u0004\b\u0001\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2$\u0010*\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0002ø\u0001\u0000¢\u0006\u0002\u0010GJ \u0010H\u001a\u00020\u00062\n\u0010I\u001a\u0006\u0012\u0002\b\u00030J2\n\u0010#\u001a\u0006\u0012\u0002\b\u00030$H\u0002J\u0010\u0010K\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010LH\u0014J\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bN\u0010OJX\u0010P\u001a\u00020\u0006\"\u0004\b\u0001\u0010'* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0-\u0012\u0006\u0012\u0004\u0018\u00010,0+2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010.\u001a\u00020/2\b\u0010Q\u001a\u0004\u0018\u00010,H\u0002ø\u0001\u0000¢\u0006\u0002\u0010RR\u0014\u0010\t\u001a\u00020\n8DX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0012\u0010\u000e\u001a\u00020\nX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00138Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Z"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(Lkotlin/jvm/functions/Function1;)V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "isEmptyImpl", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching", "cancel", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveInternal", "enqueueReceiveSelect", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onCancelIdempotent", "wasClosed", "onCancelIdempotentList", "list", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "closed", "Lkotlinx/coroutines/channels/Closed;", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onReceiveDequeued", "onReceiveEnqueued", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceiveMode", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryStartBlockUnintercepted", "value", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class AbstractChannel<E> extends i.qw.u1.ad<E> implements Channel<E> {

    public static class ad<E> extends Cif<E> {
        @JvmField

        /* renamed from: i  reason: collision with root package name */
        public final int f6335i;
        @NotNull
        @JvmField

        /* renamed from: uk  reason: collision with root package name */
        public final CancellableContinuation<Object> f6336uk;

        public ad(@NotNull CancellableContinuation<Object> cancellableContinuation, int i2) {
            this.f6336uk = cancellableContinuation;
            this.f6335i = i2;
        }

        @NotNull
        public String toString() {
            return "ReceiveElement@" + l.ad(this) + "[receiveMode=" + this.f6335i + ']';
        }

        public void u(@NotNull i.qw.u1.uk<?> ukVar) {
            if (this.f6335i == 1) {
                CancellableContinuation<Object> cancellableContinuation = this.f6336uk;
                i.qw.u1.th ad2 = i.qw.u1.th.ad(i.qw.u1.th.f6196ad.qw(ukVar.f6198uk));
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m1155constructorimpl(ad2));
                return;
            }
            CancellableContinuation<Object> cancellableContinuation2 = this.f6336uk;
            Throwable z = ukVar.z();
            Result.Companion companion2 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(z)));
        }

        @Nullable
        public final Object v(E e) {
            if (this.f6335i != 1) {
                return e;
            }
            i.qw.u1.th.f6196ad.de(e);
            return i.qw.u1.th.ad(e);
        }

        @Nullable
        public c xxx(E e, @Nullable ggg.de deVar) {
            Object a = this.f6336uk.a(v(e), deVar == null ? null : deVar.f6269de, t(e));
            if (a == null) {
                return null;
            }
            if (k.qw()) {
                if (!(a == vvv.qw)) {
                    throw new AssertionError();
                }
            }
            if (deVar != null) {
                deVar.fe();
            }
            return vvv.qw;
        }

        public void yj(E e) {
            this.f6336uk.g(vvv.qw);
        }
    }

    public static final class de<E> extends ad<E> {
        @NotNull
        @JvmField

        /* renamed from: o  reason: collision with root package name */
        public final Function1<E, Unit> f6337o;

        public de(@NotNull CancellableContinuation<Object> cancellableContinuation, int i2, @NotNull Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i2);
            this.f6337o = function1;
        }

        @Nullable
        public Function1<Throwable, Unit> t(E e) {
            return OnUndeliveredElementKt.qw(this.f6337o, e, this.f6336uk.getContext());
        }
    }

    public static class fe<E> extends Cif<E> {
        @NotNull
        @JvmField

        /* renamed from: i  reason: collision with root package name */
        public final CancellableContinuation<Boolean> f6338i;
        @NotNull
        @JvmField

        /* renamed from: uk  reason: collision with root package name */
        public final qw<E> f6339uk;

        public fe(@NotNull qw<E> qwVar, @NotNull CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f6339uk = qwVar;
            this.f6338i = cancellableContinuation;
        }

        @Nullable
        public Function1<Throwable, Unit> t(E e) {
            Function1<E, Unit> function1 = this.f6339uk.qw.f6177ad;
            if (function1 == null) {
                return null;
            }
            return OnUndeliveredElementKt.qw(function1, e, this.f6338i.getContext());
        }

        @NotNull
        public String toString() {
            return Intrinsics.stringPlus("ReceiveHasNext@", l.ad(this));
        }

        public void u(@NotNull i.qw.u1.uk<?> ukVar) {
            Object obj;
            if (ukVar.f6198uk == null) {
                obj = CancellableContinuation.qw.qw(this.f6338i, Boolean.FALSE, (Object) null, 2, (Object) null);
            } else {
                obj = this.f6338i.o(ukVar.z());
            }
            if (obj != null) {
                this.f6339uk.rg(ukVar);
                this.f6338i.g(obj);
            }
        }

        @Nullable
        public c xxx(E e, @Nullable ggg.de deVar) {
            Object a = this.f6338i.a(Boolean.TRUE, deVar == null ? null : deVar.f6269de, t(e));
            if (a == null) {
                return null;
            }
            if (k.qw()) {
                if (!(a == vvv.qw)) {
                    throw new AssertionError();
                }
            }
            if (deVar != null) {
                deVar.fe();
            }
            return vvv.qw;
        }

        public void yj(E e) {
            this.f6339uk.rg(e);
            this.f6338i.g(vvv.qw);
        }
    }

    public static final class i implements SelectClause1<E> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ AbstractChannel<E> f6340ad;

        public i(AbstractChannel<E> abstractChannel) {
            this.f6340ad = abstractChannel;
        }

        public <R> void de(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
            this.f6340ad.C(selectInstance, 0, function2);
        }
    }

    public static final class o implements SelectClause1<i.qw.u1.th<? extends E>> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ AbstractChannel<E> f6341ad;

        public o(AbstractChannel<E> abstractChannel) {
            this.f6341ad = abstractChannel;
        }

        public <R> void de(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super i.qw.u1.th<? extends E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.f6341ad.C(selectInstance, 1, function2);
        }
    }

    public static final class qw<E> implements ChannelIterator<E> {
        @Nullable

        /* renamed from: ad  reason: collision with root package name */
        public Object f6342ad = i.qw.u1.qw.f6193fe;
        @NotNull
        @JvmField
        public final AbstractChannel<E> qw;

        public qw(@NotNull AbstractChannel<E> abstractChannel) {
            this.qw = abstractChannel;
        }

        @Nullable
        public final Object ad() {
            return this.f6342ad;
        }

        public final boolean de(Object obj) {
            if (!(obj instanceof i.qw.u1.uk)) {
                return true;
            }
            i.qw.u1.uk ukVar = (i.qw.u1.uk) obj;
            if (ukVar.f6198uk == null) {
                return false;
            }
            throw b.pf(ukVar.z());
        }

        public final Object fe(Continuation<? super Boolean> continuation) {
            i.qw.ggg<? super Boolean> ad2 = xxx.ad(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
            fe feVar = new fe(this, ad2);
            while (true) {
                if (this.qw.n(feVar)) {
                    this.qw.D(ad2, feVar);
                    break;
                }
                Object z = this.qw.z();
                rg(z);
                if (z instanceof i.qw.u1.uk) {
                    i.qw.u1.uk ukVar = (i.qw.u1.uk) z;
                    if (ukVar.f6198uk == null) {
                        Boolean boxBoolean = Boxing.boxBoolean(false);
                        Result.Companion companion = Result.Companion;
                        ad2.resumeWith(Result.m1155constructorimpl(boxBoolean));
                    } else {
                        Throwable z2 = ukVar.z();
                        Result.Companion companion2 = Result.Companion;
                        ad2.resumeWith(Result.m1155constructorimpl(ResultKt.createFailure(z2)));
                    }
                } else if (z != i.qw.u1.qw.f6193fe) {
                    Boolean boxBoolean2 = Boxing.boxBoolean(true);
                    Function1<E, Unit> function1 = this.qw.f6177ad;
                    ad2.ppp(boxBoolean2, function1 == null ? null : OnUndeliveredElementKt.qw(function1, z, ad2.getContext()));
                }
            }
            Object mmm = ad2.mmm();
            if (mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return mmm;
        }

        public E next() {
            E e = this.f6342ad;
            if (!(e instanceof i.qw.u1.uk)) {
                E e2 = i.qw.u1.qw.f6193fe;
                if (e != e2) {
                    this.f6342ad = e2;
                    return e;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw b.pf(((i.qw.u1.uk) e).z());
        }

        @Nullable
        public Object qw(@NotNull Continuation<? super Boolean> continuation) {
            if (ad() != i.qw.u1.qw.f6193fe) {
                return Boxing.boxBoolean(de(ad()));
            }
            rg(this.qw.z());
            if (ad() != i.qw.u1.qw.f6193fe) {
                return Boxing.boxBoolean(de(ad()));
            }
            return fe(continuation);
        }

        public final void rg(@Nullable Object obj) {
            this.f6342ad = obj;
        }
    }

    public static final class rg<R, E> extends Cif<E> implements DisposableHandle {
        @NotNull
        @JvmField

        /* renamed from: i  reason: collision with root package name */
        public final SelectInstance<R> f6343i;
        @NotNull
        @JvmField

        /* renamed from: o  reason: collision with root package name */
        public final Function2<Object, Continuation<? super R>, Object> f6344o;
        @JvmField

        /* renamed from: pf  reason: collision with root package name */
        public final int f6345pf;
        @NotNull
        @JvmField

        /* renamed from: uk  reason: collision with root package name */
        public final AbstractChannel<E> f6346uk;

        public rg(@NotNull AbstractChannel<E> abstractChannel, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i2) {
            this.f6346uk = abstractChannel;
            this.f6343i = selectInstance;
            this.f6344o = function2;
            this.f6345pf = i2;
        }

        public void dispose() {
            if (m()) {
                this.f6346uk.x();
            }
        }

        @Nullable
        public Function1<Throwable, Unit> t(E e) {
            Function1<E, Unit> function1 = this.f6346uk.f6177ad;
            if (function1 == null) {
                return null;
            }
            return OnUndeliveredElementKt.qw(function1, e, this.f6343i.m669switch().getContext());
        }

        @NotNull
        public String toString() {
            return "ReceiveSelect@" + l.ad(this) + '[' + this.f6343i + ",receiveMode=" + this.f6345pf + ']';
        }

        public void u(@NotNull i.qw.u1.uk<?> ukVar) {
            if (this.f6343i.m668if()) {
                int i2 = this.f6345pf;
                if (i2 == 0) {
                    this.f6343i.when(ukVar.z());
                } else if (i2 == 1) {
                    i.qw.y1.qw.fe(this.f6344o, i.qw.u1.th.ad(i.qw.u1.th.f6196ad.qw(ukVar.f6198uk)), this.f6343i.m669switch(), (Function1) null, 4, (Object) null);
                }
            }
        }

        @Nullable
        public c xxx(E e, @Nullable ggg.de deVar) {
            return (c) this.f6343i.pf(deVar);
        }

        public void yj(E e) {
            E e2;
            Function2<Object, Continuation<? super R>, Object> function2 = this.f6344o;
            if (this.f6345pf == 1) {
                i.qw.u1.th.f6196ad.de(e);
                e2 = i.qw.u1.th.ad(e);
            } else {
                e2 = e;
            }
            i.qw.y1.qw.de(function2, e2, this.f6343i.m669switch(), t(e));
        }
    }

    public final class th extends i.qw.yj {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public final Cif<?> f6347ad;

        public th(@NotNull Cif<?> ifVar) {
            this.f6347ad = ifVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            qw((Throwable) obj);
            return Unit.INSTANCE;
        }

        public void qw(@Nullable Throwable th2) {
            if (this.f6347ad.m()) {
                AbstractChannel.this.x();
            }
        }

        @NotNull
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f6347ad + ']';
        }
    }

    public static final class uk extends ggg.ad {

        /* renamed from: fe  reason: collision with root package name */
        public final /* synthetic */ AbstractChannel f6349fe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public uk(ggg ggg, AbstractChannel abstractChannel) {
            super(ggg);
            this.f6349fe = abstractChannel;
        }

        @Nullable
        /* renamed from: pf */
        public Object i(@NotNull ggg ggg) {
            if (this.f6349fe.s()) {
                return null;
            }
            return ppp.qw();
        }
    }

    public static final class yj<E> extends ggg.fe<when> {
        public yj(@NotNull i.qw.x1.when when) {
            super(when);
        }

        @Nullable
        public Object o(@NotNull ggg.de deVar) {
            c v = ((when) deVar.qw).v(deVar);
            if (v == null) {
                return i.qw.x1.vvv.qw;
            }
            Object obj = i.qw.x1.de.f6259ad;
            if (v == obj) {
                return obj;
            }
            if (!k.qw()) {
                return null;
            }
            if (v == vvv.qw) {
                return null;
            }
            throw new AssertionError();
        }

        public void pf(@NotNull ggg ggg) {
            ((when) ggg).w();
        }

        @Nullable
        public Object rg(@NotNull ggg ggg) {
            if (ggg instanceof i.qw.u1.uk) {
                return ggg;
            }
            if (!(ggg instanceof when)) {
                return i.qw.u1.qw.f6193fe;
            }
            return null;
        }
    }

    public AbstractChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Nullable
    public Object A(@NotNull SelectInstance<?> selectInstance) {
        yj m = m();
        Object ggg = selectInstance.ggg(m);
        if (ggg != null) {
            return ggg;
        }
        ((when) m.ppp()).s();
        return ((when) m.ppp()).t();
    }

    public final <R> Object B(int i2, Continuation<? super R> continuation) {
        ad adVar;
        i.qw.ggg<? super R> ad2 = xxx.ad(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        if (this.f6177ad == null) {
            adVar = new ad(ad2, i2);
        } else {
            adVar = new de(ad2, i2, this.f6177ad);
        }
        while (true) {
            if (!n(adVar)) {
                Object z = z();
                if (!(z instanceof i.qw.u1.uk)) {
                    if (z != i.qw.u1.qw.f6193fe) {
                        ad2.ppp(adVar.v(z), adVar.t(z));
                        break;
                    }
                } else {
                    adVar.u((i.qw.u1.uk) z);
                    break;
                }
            } else {
                D(ad2, adVar);
                break;
            }
        }
        Object mmm = ad2.mmm();
        if (mmm == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return mmm;
    }

    public final <R> void C(SelectInstance<? super R> selectInstance, int i2, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.rg()) {
            if (!u()) {
                Object A = A(selectInstance);
                if (A != i.qw.a2.ad.fe()) {
                    if (!(A == i.qw.u1.qw.f6193fe || A == i.qw.x1.de.f6259ad)) {
                        E(function2, selectInstance, i2, A);
                    }
                } else {
                    return;
                }
            } else if (q(selectInstance, function2, i2)) {
                return;
            }
        }
    }

    public final void D(CancellableContinuation<?> cancellableContinuation, Cif<?> ifVar) {
        cancellableContinuation.i(new th(ifVar));
    }

    public final <R> void E(Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, SelectInstance<? super R> selectInstance, int i2, Object obj) {
        boolean z = obj instanceof i.qw.u1.uk;
        if (z) {
            if (i2 == 0) {
                throw b.pf(((i.qw.u1.uk) obj).z());
            } else if (i2 == 1 && selectInstance.m668if()) {
                i.qw.y1.ad.fe(function2, i.qw.u1.th.ad(i.qw.u1.th.f6196ad.qw(((i.qw.u1.uk) obj).f6198uk)), selectInstance.m669switch());
            }
        } else if (i2 == 1) {
            th.ad adVar = i.qw.u1.th.f6196ad;
            if (z) {
                obj = adVar.qw(((i.qw.u1.uk) obj).f6198uk);
            } else {
                adVar.de(obj);
            }
            i.qw.y1.ad.fe(function2, i.qw.u1.th.ad(obj), selectInstance.m669switch());
        } else {
            i.qw.y1.ad.fe(function2, obj, selectInstance.m669switch());
        }
    }

    @NotNull
    public final SelectClause1<i.qw.u1.th<E>> eee() {
        return new o(this);
    }

    @Nullable
    public ReceiveOrClosed<E> f() {
        ReceiveOrClosed<E> f = super.f();
        if (f != null && !(f instanceof i.qw.u1.uk)) {
            x();
        }
        return f;
    }

    @NotNull
    public final ChannelIterator<E> iterator() {
        return new qw(this);
    }

    public final boolean l(@Nullable Throwable th2) {
        boolean c = c(th2);
        v(c);
        return c;
    }

    @NotNull
    public final yj<E> m() {
        return new yj<>(o());
    }

    public final boolean n(Cif<? super E> ifVar) {
        boolean p = p(ifVar);
        if (p) {
            y();
        }
        return p;
    }

    public boolean p(@NotNull Cif<? super E> ifVar) {
        int r;
        ggg h;
        if (r()) {
            i.qw.x1.when o2 = o();
            do {
                h = o2.h();
                if (!(!(h instanceof when))) {
                    return false;
                }
            } while (!h.eee(ifVar, o2));
        } else {
            i.qw.x1.when o3 = o();
            uk ukVar = new uk(ifVar, this);
            do {
                ggg h2 = o3.h();
                if (!(!(h2 instanceof when))) {
                    return false;
                }
                r = h2.r(ifVar, o3, ukVar);
                if (r != 1) {
                }
            } while (r != 2);
            return false;
        }
        return true;
    }

    public final <R> boolean q(SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i2) {
        rg rgVar = new rg(this, selectInstance, function2, i2);
        boolean n = n(rgVar);
        if (n) {
            selectInstance.uk(rgVar);
        }
        return n;
    }

    @NotNull
    public final SelectClause1<E> qqq() {
        return new i(this);
    }

    public final void qw(@Nullable CancellationException cancellationException) {
        if (!t()) {
            if (cancellationException == null) {
                cancellationException = new CancellationException(Intrinsics.stringPlus(l.qw(this), " was cancelled"));
            }
            l(cancellationException);
        }
    }

    public abstract boolean r();

    @NotNull
    public final Object rrr() {
        Object z = z();
        if (z == i.qw.u1.qw.f6193fe) {
            return i.qw.u1.th.f6196ad.ad();
        }
        if (z instanceof i.qw.u1.uk) {
            return i.qw.u1.th.f6196ad.qw(((i.qw.u1.uk) z).f6198uk);
        }
        i.qw.u1.th.f6196ad.de(z);
        return z;
    }

    public abstract boolean s();

    public boolean t() {
        return yj() != null && s();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object tt(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super i.qw.u1.th<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x005a
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Object r5 = r4.z()
            i.qw.x1.c r2 = i.qw.u1.qw.f6193fe
            if (r5 == r2) goto L_0x0051
            boolean r0 = r5 instanceof i.qw.u1.uk
            if (r0 == 0) goto L_0x004b
            i.qw.u1.th$ad r0 = i.qw.u1.th.f6196ad
            i.qw.u1.uk r5 = (i.qw.u1.uk) r5
            java.lang.Throwable r5 = r5.f6198uk
            java.lang.Object r5 = r0.qw(r5)
            goto L_0x0050
        L_0x004b:
            i.qw.u1.th$ad r0 = i.qw.u1.th.f6196ad
            r0.de(r5)
        L_0x0050:
            return r5
        L_0x0051:
            r0.label = r3
            java.lang.Object r5 = r4.B(r3, r0)
            if (r5 != r1) goto L_0x005a
            return r1
        L_0x005a:
            i.qw.u1.th r5 = (i.qw.u1.th) r5
            java.lang.Object r5 = r5.m403if()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.tt(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean u() {
        return !(o().f() instanceof when) && s();
    }

    public void v(boolean z) {
        i.qw.u1.uk<?> i2 = i();
        if (i2 != null) {
            Object ad2 = Cswitch.ad((Object) null, 1, (DefaultConstructorMarker) null);
            while (true) {
                ggg h = i2.h();
                if (h instanceof i.qw.x1.when) {
                    w(ad2, i2);
                    return;
                } else if (k.qw() && !(h instanceof when)) {
                    throw new AssertionError();
                } else if (!h.m()) {
                    h.j();
                } else {
                    ad2 = Cswitch.de(ad2, (when) h);
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    public void w(@NotNull Object obj, @NotNull i.qw.u1.uk<?> ukVar) {
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                ((when) obj).u(ukVar);
            } else if (obj != null) {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = size - 1;
                        ((when) arrayList.get(size)).u(ukVar);
                        if (i2 >= 0) {
                            size = i2;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            }
        }
    }

    public void x() {
    }

    public void y() {
    }

    @Nullable
    public Object z() {
        while (true) {
            when g = g();
            if (g == null) {
                return i.qw.u1.qw.f6193fe;
            }
            c v = g.v((ggg.de) null);
            if (v != null) {
                if (k.qw()) {
                    if (!(v == vvv.qw)) {
                        throw new AssertionError();
                    }
                }
                g.s();
                return g.t();
            }
            g.w();
        }
    }
}
