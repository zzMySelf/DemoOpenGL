package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.RealConnectionPool;

public final class ConnectionPool {
    public final RealConnectionPool delegate;

    public ConnectionPool() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public int connectionCount() {
        return this.delegate.connectionCount();
    }

    public void evictAll() {
        this.delegate.evictAll();
    }

    public int idleConnectionCount() {
        return this.delegate.idleConnectionCount();
    }

    public ConnectionPool(int i2, long j, TimeUnit timeUnit) {
        this.delegate = new RealConnectionPool(i2, j, timeUnit);
    }
}
