package com.cmic.sso.sdk;

public class c {
    public final String a = "LockManager";
    public final Object b = new Object();
    public volatile boolean c = false;

    public void a(long j) {
        synchronized (this.b) {
            if (this.c) {
                com.cmic.sso.sdk.e.c.b("LockManager", "wait for pre");
                try {
                    this.b.wait(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.c = true;
        }
    }

    public void a() {
        com.cmic.sso.sdk.e.c.b("LockManager", "unLockPre");
        synchronized (this.b) {
            try {
                this.c = false;
                this.b.notify();
            } catch (Exception e) {
                e.printStackTrace();
                com.cmic.sso.sdk.e.c.a("LockManager", "unLock error ");
            }
        }
    }
}
