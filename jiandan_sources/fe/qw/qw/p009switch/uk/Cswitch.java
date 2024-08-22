package fe.qw.qw.p009switch.uk;

import com.airbnb.lottie.model.animatable.AnimatableValue;
import fe.qw.qw.vvv.qw;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: fe.qw.qw.switch.uk.switch  reason: invalid class name and invalid package */
public abstract class Cswitch<V, O> implements AnimatableValue<V, O> {
    public final List<qw<V>> qw;

    public Cswitch(V v) {
        this(Collections.singletonList(new qw(v)));
    }

    public List<qw<V>> ad() {
        return this.qw;
    }

    public boolean de() {
        return this.qw.isEmpty() || (this.qw.size() == 1 && this.qw.get(0).uk());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.qw.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.qw.toArray()));
        }
        return sb.toString();
    }

    public Cswitch(List<qw<V>> list) {
        this.qw = list;
    }
}
