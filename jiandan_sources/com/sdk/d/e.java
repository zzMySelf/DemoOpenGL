package com.sdk.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sdk.a.e;
import com.sdk.a.h;
import com.sdk.f.f;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class e<Params, Progress, Result> implements k {
    public static final b a = new b((c) null);
    public static final Executor b = new g();
    public final c<Params, Result> c;
    public final FutureTask<Result> d;
    public final AtomicBoolean e = new AtomicBoolean();
    public final AtomicBoolean f = new AtomicBoolean();
    public volatile boolean g = false;
    public Boolean h = Boolean.valueOf(f.b);

    /* renamed from: i  reason: collision with root package name */
    public b f6816i;

    public static class a<Data> {
        public final e a;
        public final Data[] b;

        public a(e eVar, Data... dataArr) {
            this.a = eVar;
            this.b = dataArr;
        }
    }

    public static class b extends Handler {
        public /* synthetic */ b(c cVar) {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                aVar.a.e.get();
            } else if (i2 == 2) {
                e eVar = aVar.a;
                Data[] dataArr = aVar.b;
                com.sdk.a.e eVar2 = (com.sdk.a.e) eVar;
                if (eVar2.p != e.a.CANCELLED && dataArr != null && dataArr.length != 0 && eVar2.m != null) {
                    int intValue = ((Integer) dataArr[0]).intValue();
                    if (intValue == 1) {
                        eVar2.p = e.a.STARTED;
                        eVar2.m.b();
                    } else if (intValue != 2) {
                        if (intValue != 3) {
                            if (intValue == 4 && dataArr.length == 2) {
                                eVar2.p = e.a.f;
                                eVar2.m.a((h) dataArr[1], eVar2.y.d);
                            }
                        } else if (dataArr.length == 3) {
                            eVar2.p = e.a.FAILURE;
                            com.sdk.e.b<T> bVar = eVar2.m;
                            int intValue2 = ((Integer) dataArr[1]).intValue();
                            com.sdk.g.b bVar2 = ((com.sdk.g.a) bVar).b;
                            String str = ((String) dataArr[2]) + "";
                            com.sdk.e.a<T> aVar2 = bVar2.g;
                            if (aVar2 != null) {
                                aVar2.a(intValue2, 302002, str);
                                bVar2.g = null;
                            }
                            String str2 = com.sdk.g.b.a;
                        }
                    } else if (dataArr.length == 3) {
                        eVar2.p = e.a.LOADING;
                        eVar2.m.a(Long.parseLong(String.valueOf(dataArr[1])), Long.parseLong(String.valueOf(dataArr[2])), eVar2.r);
                    }
                }
            }
        }
    }

    public static abstract class c<Params, Result> implements Callable<Result> {
        public Params[] a;

        public /* synthetic */ c(c cVar) {
        }
    }

    public e() {
        c cVar = new c(this);
        this.c = cVar;
        this.d = new d(this, cVar);
    }

    public static /* synthetic */ void b(e eVar, Object obj) {
        if (!eVar.f.get()) {
            eVar.a(obj);
        }
    }

    public final Result a(Result result) {
        a.obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    public final void a(Progress... progressArr) {
        if (!this.e.get()) {
            a.obtainMessage(2, new a(this, progressArr)).sendToTarget();
        }
    }
}
