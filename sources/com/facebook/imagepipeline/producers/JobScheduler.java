package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class JobScheduler {
    static final String QUEUE_TIME_KEY = "queueTime";
    private final Runnable mDoJobRunnable = new Runnable() {
        public void run() {
            JobScheduler.this.doJob();
        }
    };
    @Nullable
    EncodedImage mEncodedImage = null;
    private final Executor mExecutor;
    private final JobRunnable mJobRunnable;
    long mJobStartTime = 0;
    JobState mJobState = JobState.IDLE;
    long mJobSubmitTime = 0;
    private final int mMinimumJobIntervalMs;
    int mStatus = 0;
    private final Runnable mSubmitJobRunnable = new Runnable() {
        public void run() {
            JobScheduler.this.submitJob();
        }
    };

    public interface JobRunnable {
        void run(@Nullable EncodedImage encodedImage, int i2);
    }

    enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    static class JobStartExecutorSupplier {
        private static ScheduledExecutorService sJobStarterExecutor;

        JobStartExecutorSupplier() {
        }

        static ScheduledExecutorService get() {
            if (sJobStarterExecutor == null) {
                sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
            }
            return sJobStarterExecutor;
        }
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable, int minimumJobIntervalMs) {
        this.mExecutor = executor;
        this.mJobRunnable = jobRunnable;
        this.mMinimumJobIntervalMs = minimumJobIntervalMs;
    }

    public void clearJob() {
        EncodedImage oldEncodedImage;
        synchronized (this) {
            oldEncodedImage = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        EncodedImage.closeSafely(oldEncodedImage);
    }

    public boolean updateJob(@Nullable EncodedImage encodedImage, int status) {
        EncodedImage oldEncodedImage;
        if (!shouldProcess(encodedImage, status)) {
            return false;
        }
        synchronized (this) {
            oldEncodedImage = this.mEncodedImage;
            this.mEncodedImage = EncodedImage.cloneOrNull(encodedImage);
            this.mStatus = status;
        }
        EncodedImage.closeSafely(oldEncodedImage);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r4 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        enqueueJob(r2 - r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scheduleJob() {
        /*
            r9 = this;
            long r0 = android.os.SystemClock.uptimeMillis()
            r2 = 0
            r4 = 0
            monitor-enter(r9)
            com.facebook.imagepipeline.image.EncodedImage r5 = r9.mEncodedImage     // Catch:{ all -> 0x0046 }
            int r6 = r9.mStatus     // Catch:{ all -> 0x0046 }
            boolean r5 = shouldProcess(r5, r6)     // Catch:{ all -> 0x0046 }
            if (r5 != 0) goto L_0x0015
            r5 = 0
            monitor-exit(r9)     // Catch:{ all -> 0x0046 }
            return r5
        L_0x0015:
            int[] r5 = com.facebook.imagepipeline.producers.JobScheduler.AnonymousClass3.$SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState     // Catch:{ all -> 0x0046 }
            com.facebook.imagepipeline.producers.JobScheduler$JobState r6 = r9.mJobState     // Catch:{ all -> 0x0046 }
            int r6 = r6.ordinal()     // Catch:{ all -> 0x0046 }
            r5 = r5[r6]     // Catch:{ all -> 0x0046 }
            switch(r5) {
                case 1: goto L_0x0029;
                case 2: goto L_0x0028;
                case 3: goto L_0x0023;
                default: goto L_0x0022;
            }     // Catch:{ all -> 0x0046 }
        L_0x0022:
            goto L_0x003c
        L_0x0023:
            com.facebook.imagepipeline.producers.JobScheduler$JobState r5 = com.facebook.imagepipeline.producers.JobScheduler.JobState.RUNNING_AND_PENDING     // Catch:{ all -> 0x0046 }
            r9.mJobState = r5     // Catch:{ all -> 0x0046 }
            goto L_0x003c
        L_0x0028:
            goto L_0x003c
        L_0x0029:
            long r5 = r9.mJobStartTime     // Catch:{ all -> 0x0046 }
            int r7 = r9.mMinimumJobIntervalMs     // Catch:{ all -> 0x0046 }
            long r7 = (long) r7     // Catch:{ all -> 0x0046 }
            long r5 = r5 + r7
            long r5 = java.lang.Math.max(r5, r0)     // Catch:{ all -> 0x0046 }
            r2 = r5
            r4 = 1
            r9.mJobSubmitTime = r0     // Catch:{ all -> 0x0046 }
            com.facebook.imagepipeline.producers.JobScheduler$JobState r5 = com.facebook.imagepipeline.producers.JobScheduler.JobState.QUEUED     // Catch:{ all -> 0x0046 }
            r9.mJobState = r5     // Catch:{ all -> 0x0046 }
        L_0x003c:
            monitor-exit(r9)     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x0044
            long r5 = r2 - r0
            r9.enqueueJob(r5)
        L_0x0044:
            r5 = 1
            return r5
        L_0x0046:
            r5 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0046 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.JobScheduler.scheduleJob():boolean");
    }

    /* renamed from: com.facebook.imagepipeline.producers.JobScheduler$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState;

        static {
            int[] iArr = new int[JobState.values().length];
            $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState = iArr;
            try {
                iArr[JobState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.QUEUED.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$facebook$imagepipeline$producers$JobScheduler$JobState[JobState.RUNNING_AND_PENDING.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private void enqueueJob(long delay) {
        Runnable submitJobRunnable = FrescoInstrumenter.decorateRunnable(this.mSubmitJobRunnable, "JobScheduler_enqueueJob");
        if (delay > 0) {
            JobStartExecutorSupplier.get().schedule(submitJobRunnable, delay, TimeUnit.MILLISECONDS);
        } else {
            submitJobRunnable.run();
        }
    }

    /* access modifiers changed from: private */
    public void submitJob() {
        this.mExecutor.execute(FrescoInstrumenter.decorateRunnable(this.mDoJobRunnable, "JobScheduler_submitJob"));
    }

    /* access modifiers changed from: private */
    public void doJob() {
        EncodedImage input;
        int status;
        long now = SystemClock.uptimeMillis();
        synchronized (this) {
            input = this.mEncodedImage;
            status = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mJobState = JobState.RUNNING;
            this.mJobStartTime = now;
        }
        try {
            if (shouldProcess(input, status)) {
                this.mJobRunnable.run(input, status);
            }
        } finally {
            EncodedImage.closeSafely(input);
            onJobFinished();
        }
    }

    private void onJobFinished() {
        long now = SystemClock.uptimeMillis();
        long when = 0;
        boolean shouldEnqueue = false;
        synchronized (this) {
            if (this.mJobState == JobState.RUNNING_AND_PENDING) {
                when = Math.max(this.mJobStartTime + ((long) this.mMinimumJobIntervalMs), now);
                shouldEnqueue = true;
                this.mJobSubmitTime = now;
                this.mJobState = JobState.QUEUED;
            } else {
                this.mJobState = JobState.IDLE;
            }
        }
        if (shouldEnqueue) {
            enqueueJob(when - now);
        }
    }

    private static boolean shouldProcess(@Nullable EncodedImage encodedImage, int status) {
        return BaseConsumer.isLast(status) || BaseConsumer.statusHasFlag(status, 4) || EncodedImage.isValid(encodedImage);
    }

    public synchronized long getQueuedTime() {
        return this.mJobStartTime - this.mJobSubmitTime;
    }
}
