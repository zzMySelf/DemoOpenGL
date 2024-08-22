package fe.i.qw.ad;

import java.util.LinkedList;

public final class rg {
    public final LinkedList<fe> qw = new LinkedList<>();

    public synchronized void ad(fe feVar) {
        if (feVar != null) {
            this.qw.offer(feVar);
            notifyAll();
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    public synchronized fe qw() {
        return this.qw.poll();
    }
}
