package rx.internal.operators;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import p041if.rg.qw.de;

public final class OnSubscribeAmb$Selection<T> extends AtomicReference<de<T>> {
    public final Collection<de<T>> ambSubscribers = new ConcurrentLinkedQueue();

    public void unsubscribeLosers() {
        de deVar = (de) get();
        if (deVar != null) {
            unsubscribeOthers(deVar);
        }
    }

    public void unsubscribeOthers(de<T> deVar) {
        for (de<T> next : this.ambSubscribers) {
            if (next != deVar) {
                next.unsubscribe();
            }
        }
        this.ambSubscribers.clear();
    }
}
