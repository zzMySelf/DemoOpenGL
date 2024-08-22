package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import p041if.uk.de;
import rx.functions.Func0;
import rx.internal.util.RxThreadFactory;

public enum GenericScheduledExecutorServiceFactory {
    ;
    
    public static final RxThreadFactory THREAD_FACTORY = null;
    public static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";

    /* access modifiers changed from: public */
    static {
        THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX);
    }

    public static ScheduledExecutorService create() {
        Func0<? extends ScheduledExecutorService> qw = de.qw();
        if (qw == null) {
            return createDefault();
        }
        return (ScheduledExecutorService) qw.call();
    }

    public static ScheduledExecutorService createDefault() {
        return Executors.newScheduledThreadPool(1, threadFactory());
    }

    public static ThreadFactory threadFactory() {
        return THREAD_FACTORY;
    }
}
