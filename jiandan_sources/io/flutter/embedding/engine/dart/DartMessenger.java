package io.flutter.embedding.engine.dart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.tracing.Trace;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import th.qw.qw.ad.ad.ad;
import th.qw.qw.ad.ad.qw;

public class DartMessenger implements BinaryMessenger, PlatformMessageHandler {
    public static final String TAG = "DartMessenger";
    @NonNull
    public WeakHashMap<BinaryMessenger.TaskQueue, DartMessengerTaskQueue> createdTaskQueues;
    @NonNull
    public final FlutterJNI flutterJNI;
    @NonNull
    public final ConcurrentHashMap<String, HandlerInfo> messageHandlers;
    public int nextReplyId;
    @NonNull
    public final Map<Integer, BinaryMessenger.BinaryReply> pendingReplies;
    @NonNull
    public final DartMessengerTaskQueue platformTaskQueue;
    @NonNull
    public TaskQueueFactory taskQueueFactory;

    public interface DartMessengerTaskQueue {
        void dispatch(@NonNull Runnable runnable);
    }

    public static class DefaultTaskQueue implements DartMessengerTaskQueue {
        @NonNull
        public final ExecutorService executor = Executors.newSingleThreadExecutor(qw.f11069ad);

        public static /* synthetic */ Thread qw(Runnable runnable) {
            return new Thread(runnable, "DartMessenger.DefaultTaskQueue");
        }

        public void dispatch(@NonNull Runnable runnable) {
            this.executor.execute(runnable);
        }
    }

    public static class DefaultTaskQueueFactory implements TaskQueueFactory {
        public DefaultTaskQueueFactory() {
        }

        public DartMessengerTaskQueue makeBackgroundTaskQueue() {
            return new DefaultTaskQueue();
        }
    }

    public static class HandlerInfo {
        @NonNull
        public final BinaryMessenger.BinaryMessageHandler handler;
        @Nullable
        public final DartMessengerTaskQueue taskQueue;

        public HandlerInfo(@NonNull BinaryMessenger.BinaryMessageHandler binaryMessageHandler, @Nullable DartMessengerTaskQueue dartMessengerTaskQueue) {
            this.handler = binaryMessageHandler;
            this.taskQueue = dartMessengerTaskQueue;
        }
    }

    public static class Reply implements BinaryMessenger.BinaryReply {
        public final AtomicBoolean done = new AtomicBoolean(false);
        @NonNull
        public final FlutterJNI flutterJNI;
        public final int replyId;

        public Reply(@NonNull FlutterJNI flutterJNI2, int i2) {
            this.flutterJNI = flutterJNI2;
            this.replyId = i2;
        }

        public void reply(@Nullable ByteBuffer byteBuffer) {
            if (this.done.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            } else if (byteBuffer == null) {
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(this.replyId);
            } else {
                this.flutterJNI.invokePlatformMessageResponseCallback(this.replyId, byteBuffer, byteBuffer.position());
            }
        }
    }

    public interface TaskQueueFactory {
        DartMessengerTaskQueue makeBackgroundTaskQueue();
    }

    public static class TaskQueueToken implements BinaryMessenger.TaskQueue {
        public TaskQueueToken() {
        }
    }

    public DartMessenger(@NonNull FlutterJNI flutterJNI2, @NonNull TaskQueueFactory taskQueueFactory2) {
        this.nextReplyId = 1;
        this.platformTaskQueue = new PlatformTaskQueue();
        this.flutterJNI = flutterJNI2;
        this.messageHandlers = new ConcurrentHashMap<>();
        this.pendingReplies = new HashMap();
        this.createdTaskQueues = new WeakHashMap<>();
        this.taskQueueFactory = taskQueueFactory2;
    }

    public static void handleError(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() != null) {
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
            return;
        }
        throw error;
    }

    private void invokeHandler(@Nullable HandlerInfo handlerInfo, @Nullable ByteBuffer byteBuffer, int i2) {
        if (handlerInfo != null) {
            try {
                Log.v(TAG, "Deferring to registered handler to process message.");
                handlerInfo.handler.onMessage(byteBuffer, new Reply(this.flutterJNI, i2));
            } catch (Exception e) {
                Log.e(TAG, "Uncaught exception in binary message listener", e);
                this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i2);
            } catch (Error e2) {
                handleError(e2);
            }
        } else {
            Log.v(TAG, "No registered handler for message. Responding to Dart with empty reply message.");
            this.flutterJNI.invokePlatformMessageEmptyResponseCallback(i2);
        }
    }

    @UiThread
    public int getPendingChannelResponseCount() {
        return this.pendingReplies.size();
    }

    public void handleMessageFromDart(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i2, long j) {
        Log.v(TAG, "Received message from Dart over channel '" + str + "'");
        HandlerInfo handlerInfo = this.messageHandlers.get(str);
        DartMessengerTaskQueue dartMessengerTaskQueue = handlerInfo != null ? handlerInfo.taskQueue : null;
        ad adVar = new ad(this, str, handlerInfo, byteBuffer, i2, j);
        if (dartMessengerTaskQueue == null) {
            dartMessengerTaskQueue = this.platformTaskQueue;
        }
        dartMessengerTaskQueue.dispatch(adVar);
    }

    public void handlePlatformMessageResponse(int i2, @Nullable ByteBuffer byteBuffer) {
        Log.v(TAG, "Received message reply from Dart.");
        BinaryMessenger.BinaryReply remove = this.pendingReplies.remove(Integer.valueOf(i2));
        if (remove != null) {
            try {
                Log.v(TAG, "Invoking registered callback for reply from Dart.");
                remove.reply(byteBuffer);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
            } catch (Exception e) {
                Log.e(TAG, "Uncaught exception in binary message reply handler", e);
            } catch (Error e2) {
                handleError(e2);
            }
        }
    }

    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        DartMessengerTaskQueue makeBackgroundTaskQueue = this.taskQueueFactory.makeBackgroundTaskQueue();
        TaskQueueToken taskQueueToken = new TaskQueueToken();
        this.createdTaskQueues.put(taskQueueToken, makeBackgroundTaskQueue);
        return taskQueueToken;
    }

    public /* synthetic */ void qw(String str, HandlerInfo handlerInfo, ByteBuffer byteBuffer, int i2, long j) {
        Trace.beginSection("DartMessenger#handleMessageFromDart on " + str);
        try {
            invokeHandler(handlerInfo, byteBuffer, i2);
            if (byteBuffer != null && byteBuffer.isDirect()) {
                byteBuffer.limit(0);
            }
        } finally {
            this.flutterJNI.cleanupMessageData(j);
            Trace.endSection();
        }
    }

    @UiThread
    public void send(@NonNull String str, @NonNull ByteBuffer byteBuffer) {
        Log.v(TAG, "Sending message over channel '" + str + "'");
        send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
    }

    public void setMessageHandler(@NonNull String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        setMessageHandler(str, binaryMessageHandler, (BinaryMessenger.TaskQueue) null);
    }

    public void setMessageHandler(@NonNull String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler, @Nullable BinaryMessenger.TaskQueue taskQueue) {
        if (binaryMessageHandler == null) {
            Log.v(TAG, "Removing handler for channel '" + str + "'");
            this.messageHandlers.remove(str);
            return;
        }
        DartMessengerTaskQueue dartMessengerTaskQueue = null;
        if (taskQueue == null || (dartMessengerTaskQueue = this.createdTaskQueues.get(taskQueue)) != null) {
            Log.v(TAG, "Setting handler for channel '" + str + "'");
            this.messageHandlers.put(str, new HandlerInfo(binaryMessageHandler, dartMessengerTaskQueue));
            return;
        }
        throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
    }

    public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryMessenger.BinaryReply binaryReply) {
        Trace.beginSection("DartMessenger#send on " + str);
        Log.v(TAG, "Sending message with callback over channel '" + str + "'");
        try {
            int i2 = this.nextReplyId;
            this.nextReplyId = i2 + 1;
            if (binaryReply != null) {
                this.pendingReplies.put(Integer.valueOf(i2), binaryReply);
            }
            if (byteBuffer == null) {
                this.flutterJNI.dispatchEmptyPlatformMessage(str, i2);
            } else {
                this.flutterJNI.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i2);
            }
        } finally {
            Trace.endSection();
        }
    }

    public DartMessenger(@NonNull FlutterJNI flutterJNI2) {
        this(flutterJNI2, new DefaultTaskQueueFactory());
    }
}
