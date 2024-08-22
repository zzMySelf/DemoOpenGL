package fe.fe.nn.yj;

import com.sdk.base.api.CallBack;

public abstract class ad<T> implements CallBack<T> {
    public final long qw = System.currentTimeMillis();

    public long qw() {
        return this.qw;
    }
}
