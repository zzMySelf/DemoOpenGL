package org.sqlite.database.sqlite;

public final class CloseGuard {
    public static volatile boolean ENABLED = true;
    public static final CloseGuard NOOP = new CloseGuard();
    public static volatile Reporter REPORTER = new DefaultReporter();
    public Throwable allocationSite;

    public static final class DefaultReporter implements Reporter {
        public DefaultReporter() {
        }

        public void report(String str, Throwable th2) {
        }
    }

    public interface Reporter {
        void report(String str, Throwable th2);
    }

    public static CloseGuard get() {
        if (!ENABLED) {
            return NOOP;
        }
        return new CloseGuard();
    }

    public static Reporter getReporter() {
        return REPORTER;
    }

    public static void setEnabled(boolean z) {
        ENABLED = z;
    }

    public static void setReporter(Reporter reporter) {
        if (reporter != null) {
            REPORTER = reporter;
            return;
        }
        throw new NullPointerException("reporter == null");
    }

    public void close() {
        this.allocationSite = null;
    }

    public void open(String str) {
        if (str == null) {
            throw new NullPointerException("closer == null");
        } else if (this != NOOP && ENABLED) {
            this.allocationSite = new Throwable("Explicit termination method '" + str + "' not called");
        }
    }

    public void warnIfOpen() {
        if (this.allocationSite != null && ENABLED) {
            REPORTER.report("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.allocationSite);
        }
    }
}
