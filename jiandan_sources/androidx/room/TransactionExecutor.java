package androidx.room;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class TransactionExecutor implements Executor {
    public Runnable mActive;
    public final Executor mExecutor;
    public final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

    public TransactionExecutor(@NonNull Executor executor) {
        this.mExecutor = executor;
    }

    public synchronized void execute(final Runnable runnable) {
        this.mTasks.offer(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                } finally {
                    TransactionExecutor.this.scheduleNext();
                }
            }
        });
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    public synchronized void scheduleNext() {
        Runnable poll = this.mTasks.poll();
        this.mActive = poll;
        if (poll != null) {
            this.mExecutor.execute(poll);
        }
    }
}
