package th.qw.qw.ad.ad;

import io.flutter.embedding.engine.dart.DartMessenger;
import java.util.concurrent.ThreadFactory;

/* compiled from: lambda */
public final /* synthetic */ class qw implements ThreadFactory {

    /* renamed from: ad  reason: collision with root package name */
    public static final /* synthetic */ qw f11069ad = new qw();

    private /* synthetic */ qw() {
    }

    public final Thread newThread(Runnable runnable) {
        return DartMessenger.DefaultTaskQueue.qw(runnable);
    }
}
