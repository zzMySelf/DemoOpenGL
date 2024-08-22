package th.de.xxx;

import io.reactivex.Observer;
import th.de.rg;

public abstract class ad<T> extends rg<T> implements Observer<T> {
    public final ad<T> ad() {
        if (this instanceof qw) {
            return this;
        }
        return new qw(this);
    }
}
