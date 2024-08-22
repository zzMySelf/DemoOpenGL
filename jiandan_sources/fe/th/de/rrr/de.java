package fe.th.de.rrr;

public abstract class de implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final String f5253ad;

    public de(String str, Object... objArr) {
        this.f5253ad = fe.xxx(str, objArr);
    }

    public abstract void fe();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f5253ad);
        try {
            fe();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
