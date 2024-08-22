package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class MessageThreadUtil<T> implements ThreadUtil<T> {

    public static class MessageQueue {
        public SyncQueueItem mRoot;

        public synchronized SyncQueueItem next() {
            if (this.mRoot == null) {
                return null;
            }
            SyncQueueItem syncQueueItem = this.mRoot;
            this.mRoot = this.mRoot.next;
            return syncQueueItem;
        }

        public synchronized void removeMessages(int i2) {
            while (this.mRoot != null && this.mRoot.what == i2) {
                SyncQueueItem syncQueueItem = this.mRoot;
                this.mRoot = this.mRoot.next;
                syncQueueItem.recycle();
            }
            if (this.mRoot != null) {
                SyncQueueItem syncQueueItem2 = this.mRoot;
                SyncQueueItem syncQueueItem3 = syncQueueItem2.next;
                while (syncQueueItem3 != null) {
                    SyncQueueItem syncQueueItem4 = syncQueueItem3.next;
                    if (syncQueueItem3.what == i2) {
                        syncQueueItem2.next = syncQueueItem4;
                        syncQueueItem3.recycle();
                    } else {
                        syncQueueItem2 = syncQueueItem3;
                    }
                    syncQueueItem3 = syncQueueItem4;
                }
            }
        }

        public synchronized void sendMessage(SyncQueueItem syncQueueItem) {
            if (this.mRoot == null) {
                this.mRoot = syncQueueItem;
                return;
            }
            SyncQueueItem syncQueueItem2 = this.mRoot;
            while (syncQueueItem2.next != null) {
                syncQueueItem2 = syncQueueItem2.next;
            }
            syncQueueItem2.next = syncQueueItem;
        }

        public synchronized void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
            syncQueueItem.next = this.mRoot;
            this.mRoot = syncQueueItem;
        }
    }

    public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(final ThreadUtil.BackgroundCallback<T> backgroundCallback) {
        return new ThreadUtil.BackgroundCallback<T>() {
            public static final int LOAD_TILE = 3;
            public static final int RECYCLE_TILE = 4;
            public static final int REFRESH = 1;
            public static final int UPDATE_RANGE = 2;
            public Runnable mBackgroundRunnable = new Runnable() {
                public void run() {
                    while (true) {
                        SyncQueueItem next = AnonymousClass2.this.mQueue.next();
                        if (next == null) {
                            AnonymousClass2.this.mBackgroundRunning.set(false);
                            return;
                        }
                        int i2 = next.what;
                        if (i2 == 1) {
                            AnonymousClass2.this.mQueue.removeMessages(1);
                            backgroundCallback.refresh(next.arg1);
                        } else if (i2 == 2) {
                            AnonymousClass2.this.mQueue.removeMessages(2);
                            AnonymousClass2.this.mQueue.removeMessages(3);
                            backgroundCallback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
                        } else if (i2 == 3) {
                            backgroundCallback.loadTile(next.arg1, next.arg2);
                        } else if (i2 != 4) {
                            "Unsupported message, what=" + next.what;
                        } else {
                            backgroundCallback.recycleTile((TileList.Tile) next.data);
                        }
                    }
                }
            };
            public AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
            public final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
            public final MessageQueue mQueue = new MessageQueue();

            private void maybeExecuteBackgroundRunnable() {
                if (this.mBackgroundRunning.compareAndSet(false, true)) {
                    this.mExecutor.execute(this.mBackgroundRunnable);
                }
            }

            private void sendMessage(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessage(syncQueueItem);
                maybeExecuteBackgroundRunnable();
            }

            private void sendMessageAtFrontOfQueue(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
                maybeExecuteBackgroundRunnable();
            }

            public void loadTile(int i2, int i3) {
                sendMessage(SyncQueueItem.obtainMessage(3, i2, i3));
            }

            public void recycleTile(TileList.Tile<T> tile) {
                sendMessage(SyncQueueItem.obtainMessage(4, 0, (Object) tile));
            }

            public void refresh(int i2) {
                sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(1, i2, (Object) null));
            }

            public void updateRange(int i2, int i3, int i4, int i5, int i6) {
                sendMessageAtFrontOfQueue(SyncQueueItem.obtainMessage(2, i2, i3, i4, i5, i6, (Object) null));
            }
        };
    }

    public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(final ThreadUtil.MainThreadCallback<T> mainThreadCallback) {
        return new ThreadUtil.MainThreadCallback<T>() {
            public static final int ADD_TILE = 2;
            public static final int REMOVE_TILE = 3;
            public static final int UPDATE_ITEM_COUNT = 1;
            public final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
            public Runnable mMainThreadRunnable = new Runnable() {
                public void run() {
                    SyncQueueItem next = AnonymousClass1.this.mQueue.next();
                    while (next != null) {
                        int i2 = next.what;
                        if (i2 == 1) {
                            mainThreadCallback.updateItemCount(next.arg1, next.arg2);
                        } else if (i2 == 2) {
                            mainThreadCallback.addTile(next.arg1, (TileList.Tile) next.data);
                        } else if (i2 != 3) {
                            "Unsupported message, what=" + next.what;
                        } else {
                            mainThreadCallback.removeTile(next.arg1, next.arg2);
                        }
                        next = AnonymousClass1.this.mQueue.next();
                    }
                }
            };
            public final MessageQueue mQueue = new MessageQueue();

            private void sendMessage(SyncQueueItem syncQueueItem) {
                this.mQueue.sendMessage(syncQueueItem);
                this.mMainThreadHandler.post(this.mMainThreadRunnable);
            }

            public void addTile(int i2, TileList.Tile<T> tile) {
                sendMessage(SyncQueueItem.obtainMessage(2, i2, (Object) tile));
            }

            public void removeTile(int i2, int i3) {
                sendMessage(SyncQueueItem.obtainMessage(3, i2, i3));
            }

            public void updateItemCount(int i2, int i3) {
                sendMessage(SyncQueueItem.obtainMessage(1, i2, i3));
            }
        };
    }

    public static class SyncQueueItem {
        public static SyncQueueItem sPool;
        public static final Object sPoolLock = new Object();
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        public Object data;
        public SyncQueueItem next;
        public int what;

        public static SyncQueueItem obtainMessage(int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (sPoolLock) {
                if (sPool == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    syncQueueItem = sPool;
                    sPool = sPool.next;
                    syncQueueItem.next = null;
                }
                syncQueueItem.what = i2;
                syncQueueItem.arg1 = i3;
                syncQueueItem.arg2 = i4;
                syncQueueItem.arg3 = i5;
                syncQueueItem.arg4 = i6;
                syncQueueItem.arg5 = i7;
                syncQueueItem.data = obj;
            }
            return syncQueueItem;
        }

        public void recycle() {
            this.next = null;
            this.arg5 = 0;
            this.arg4 = 0;
            this.arg3 = 0;
            this.arg2 = 0;
            this.arg1 = 0;
            this.what = 0;
            this.data = null;
            synchronized (sPoolLock) {
                if (sPool != null) {
                    this.next = sPool;
                }
                sPool = this;
            }
        }

        public static SyncQueueItem obtainMessage(int i2, int i3, int i4) {
            return obtainMessage(i2, i3, i4, 0, 0, 0, (Object) null);
        }

        public static SyncQueueItem obtainMessage(int i2, int i3, Object obj) {
            return obtainMessage(i2, i3, 0, 0, 0, 0, obj);
        }
    }
}
