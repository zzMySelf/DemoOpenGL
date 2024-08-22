package fe.fe.nn.th;

import cn.com.chinatelecom.gateway.lib.PreCodeListener;

public abstract class ad implements PreCodeListener {
    public final long qw = System.currentTimeMillis();

    public long qw() {
        return this.qw;
    }
}
