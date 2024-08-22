package fe.fe.nn.rg;

import com.cmic.sso.sdk.auth.TokenListener;

public abstract class ad implements TokenListener {
    public final long qw = System.currentTimeMillis();

    public long qw() {
        return this.qw;
    }
}
