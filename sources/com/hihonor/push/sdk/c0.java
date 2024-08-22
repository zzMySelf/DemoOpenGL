package com.hihonor.push.sdk;

public class c0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j0 f4682a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d0 f4683b;

    public c0(d0 d0Var, j0 j0Var) {
        this.f4683b = d0Var;
        this.f4682a = j0Var;
    }

    public final void run() {
        synchronized (this.f4683b.f4691c) {
            u<TResult> uVar = this.f4683b.f4689a;
            if (uVar != null) {
                uVar.a(this.f4682a);
            }
        }
    }
}
