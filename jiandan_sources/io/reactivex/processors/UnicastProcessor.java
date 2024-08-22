package io.reactivex.processors;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import th.de.ad;
import th.de.ggg.qw;

public final class UnicastProcessor<T> extends qw<T> {
    public boolean ggg;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f10333i;

    /* renamed from: if  reason: not valid java name */
    public volatile boolean f485if;

    /* renamed from: o  reason: collision with root package name */
    public Throwable f10334o;

    /* renamed from: pf  reason: collision with root package name */
    public final AtomicReference<Subscriber<? super T>> f10335pf;
    public final AtomicLong ppp;

    /* renamed from: switch  reason: not valid java name */
    public final AtomicBoolean f486switch;

    /* renamed from: th  reason: collision with root package name */
    public final th.de.p039if.rg.qw<T> f10336th;

    /* renamed from: uk  reason: collision with root package name */
    public final boolean f10337uk;
    public final BasicIntQueueSubscription<T> when;

    /* renamed from: yj  reason: collision with root package name */
    public final AtomicReference<Runnable> f10338yj;

    public final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        public static final long serialVersionUID = -4896760517184205454L;

        public UnicastQueueSubscription() {
        }

        public void cancel() {
            if (!UnicastProcessor.this.f485if) {
                UnicastProcessor.this.f485if = true;
                UnicastProcessor.this.pf();
                UnicastProcessor unicastProcessor = UnicastProcessor.this;
                if (!unicastProcessor.ggg && unicastProcessor.when.getAndIncrement() == 0) {
                    UnicastProcessor.this.f10336th.clear();
                    UnicastProcessor.this.f10335pf.lazySet((Object) null);
                }
            }
        }

        public void clear() {
            UnicastProcessor.this.f10336th.clear();
        }

        public boolean isEmpty() {
            return UnicastProcessor.this.f10336th.isEmpty();
        }

        public T poll() {
            return UnicastProcessor.this.f10336th.poll();
        }

        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                th.de.p039if.yj.qw.qw(UnicastProcessor.this.ppp, j);
                UnicastProcessor.this.m1143if();
            }
        }

        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.ggg = true;
            return 2;
        }
    }

    public UnicastProcessor(int i2) {
        this(i2, (Runnable) null, true);
    }

    public static <T> UnicastProcessor<T> i() {
        return new UnicastProcessor<>(ad.qw());
    }

    public static <T> UnicastProcessor<T> o(int i2, Runnable runnable) {
        th.de.p039if.ad.qw.rg(runnable, "onTerminate");
        return new UnicastProcessor<>(i2, runnable);
    }

    /* renamed from: if  reason: not valid java name */
    public void m1143if() {
        if (this.when.getAndIncrement() == 0) {
            int i2 = 1;
            Subscriber subscriber = this.f10335pf.get();
            while (subscriber == null) {
                i2 = this.when.addAndGet(-i2);
                if (i2 != 0) {
                    subscriber = this.f10335pf.get();
                } else {
                    return;
                }
            }
            if (this.ggg) {
                m1144switch(subscriber);
            } else {
                when(subscriber);
            }
        }
    }

    public void onComplete() {
        if (!this.f10333i && !this.f485if) {
            this.f10333i = true;
            pf();
            m1143if();
        }
    }

    public void onError(Throwable th2) {
        th.de.p039if.ad.qw.rg(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f10333i || this.f485if) {
            th.de.ppp.qw.ddd(th2);
            return;
        }
        this.f10334o = th2;
        this.f10333i = true;
        pf();
        m1143if();
    }

    public void onNext(T t) {
        th.de.p039if.ad.qw.rg(t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f10333i && !this.f485if) {
            this.f10336th.offer(t);
            m1143if();
        }
    }

    public void onSubscribe(Subscription subscription) {
        if (this.f10333i || this.f485if) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public void pf() {
        Runnable andSet = this.f10338yj.getAndSet((Object) null);
        if (andSet != null) {
            andSet.run();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1144switch(Subscriber<? super T> subscriber) {
        th.de.p039if.rg.qw<T> qwVar = this.f10336th;
        int i2 = 1;
        boolean z = !this.f10337uk;
        while (!this.f485if) {
            boolean z2 = this.f10333i;
            if (!z || !z2 || this.f10334o == null) {
                subscriber.onNext(null);
                if (z2) {
                    this.f10335pf.lazySet((Object) null);
                    Throwable th2 = this.f10334o;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                } else {
                    i2 = this.when.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            } else {
                qwVar.clear();
                this.f10335pf.lazySet((Object) null);
                subscriber.onError(this.f10334o);
                return;
            }
        }
        qwVar.clear();
        this.f10335pf.lazySet((Object) null);
    }

    public boolean uk(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, th.de.p039if.rg.qw<T> qwVar) {
        if (this.f485if) {
            qwVar.clear();
            this.f10335pf.lazySet((Object) null);
            return true;
        } else if (!z2) {
            return false;
        } else {
            if (z && this.f10334o != null) {
                qwVar.clear();
                this.f10335pf.lazySet((Object) null);
                subscriber.onError(this.f10334o);
                return true;
            } else if (!z3) {
                return false;
            } else {
                Throwable th2 = this.f10334o;
                this.f10335pf.lazySet((Object) null);
                if (th2 != null) {
                    subscriber.onError(th2);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    public void when(Subscriber<? super T> subscriber) {
        int i2;
        long j;
        th.de.p039if.rg.qw<T> qwVar = this.f10336th;
        boolean z = !this.f10337uk;
        int i3 = 1;
        while (true) {
            long j2 = this.ppp.get();
            long j3 = 0;
            while (true) {
                i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                if (i2 == 0) {
                    j = j3;
                    break;
                }
                boolean z2 = this.f10333i;
                T poll = qwVar.poll();
                boolean z3 = poll == null;
                T t = poll;
                j = j3;
                if (!uk(z, z2, z3, subscriber, qwVar)) {
                    if (z3) {
                        break;
                    }
                    subscriber.onNext(t);
                    j3 = 1 + j;
                } else {
                    return;
                }
            }
            Subscriber<? super T> subscriber2 = subscriber;
            if (i2 == 0) {
                if (uk(z, this.f10333i, qwVar.isEmpty(), subscriber, qwVar)) {
                    return;
                }
            }
            if (!(j == 0 || j2 == Long.MAX_VALUE)) {
                this.ppp.addAndGet(-j);
            }
            i3 = this.when.addAndGet(-i3);
            if (i3 == 0) {
                return;
            }
        }
    }

    public void yj(Subscriber<? super T> subscriber) {
        if (this.f486switch.get() || !this.f486switch.compareAndSet(false, true)) {
            EmptySubscription.error(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.onSubscribe(this.when);
        this.f10335pf.set(subscriber);
        if (this.f485if) {
            this.f10335pf.lazySet((Object) null);
        } else {
            m1143if();
        }
    }

    public UnicastProcessor(int i2, Runnable runnable) {
        this(i2, runnable, true);
    }

    public UnicastProcessor(int i2, Runnable runnable, boolean z) {
        th.de.p039if.ad.qw.th(i2, "capacityHint");
        this.f10336th = new th.de.p039if.rg.qw<>(i2);
        this.f10338yj = new AtomicReference<>(runnable);
        this.f10337uk = z;
        this.f10335pf = new AtomicReference<>();
        this.f486switch = new AtomicBoolean();
        this.when = new UnicastQueueSubscription();
        this.ppp = new AtomicLong();
    }
}
