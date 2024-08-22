package com.hihonor.push.sdk;

import java.util.ArrayList;
import java.util.List;

public final class j0<TResult> extends j0<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4725a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f4726b;

    /* renamed from: c  reason: collision with root package name */
    public TResult f4727c;

    /* renamed from: d  reason: collision with root package name */
    public Exception f4728d;

    /* renamed from: e  reason: collision with root package name */
    public List<t<TResult>> f4729e = new ArrayList();

    public final void a() {
        synchronized (this.f4725a) {
            for (t a2 : this.f4729e) {
                try {
                    a2.a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f4729e = null;
        }
    }

    public final Exception b() {
        Exception exc;
        synchronized (this.f4725a) {
            exc = this.f4728d;
        }
        return exc;
    }

    public final TResult c() {
        TResult tresult;
        synchronized (this.f4725a) {
            if (this.f4728d == null) {
                tresult = this.f4727c;
            } else {
                throw new RuntimeException(this.f4728d);
            }
        }
        return tresult;
    }

    public final boolean d() {
        synchronized (this.f4725a) {
        }
        return false;
    }

    public final boolean e() {
        boolean z;
        synchronized (this.f4725a) {
            if (this.f4726b) {
                d();
                if (this.f4728d == null) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    public final j0<TResult> a(t<TResult> tVar) {
        synchronized (this.f4725a) {
            if (!this.f4726b) {
                this.f4729e.add(tVar);
            } else {
                tVar.a(this);
            }
        }
        return this;
    }
}
