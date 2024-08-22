package th.de;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.subscribers.StrictSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import th.de.p039if.ad.qw;

public abstract class ad<T> implements Publisher<T> {

    /* renamed from: ad  reason: collision with root package name */
    public static final int f10460ad = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int qw() {
        return f10460ad;
    }

    public final ad<T> ad() {
        return de(qw(), false, true);
    }

    public final ad<T> de(int i2, boolean z, boolean z2) {
        qw.th(i2, "capacity");
        return th.de.ppp.qw.m2357if(new FlowableOnBackpressureBuffer(this, i2, z2, z, Functions.f9949de));
    }

    public final ad<T> fe() {
        return th.de.ppp.qw.m2357if(new FlowableOnBackpressureDrop(this));
    }

    public final ad<T> rg() {
        return th.de.ppp.qw.m2357if(new FlowableOnBackpressureLatest(this));
    }

    public final void subscribe(Subscriber<? super T> subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            th((FlowableSubscriber) subscriber);
            return;
        }
        qw.rg(subscriber, "s is null");
        th(new StrictSubscriber(subscriber));
    }

    public final void th(FlowableSubscriber<? super T> flowableSubscriber) {
        qw.rg(flowableSubscriber, "s is null");
        try {
            Subscriber<? super Object> a = th.de.ppp.qw.a(this, flowableSubscriber);
            qw.rg(a, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            yj(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th2) {
            th.de.o.qw.ad(th2);
            th.de.ppp.qw.ddd(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void yj(Subscriber<? super T> subscriber);
}
