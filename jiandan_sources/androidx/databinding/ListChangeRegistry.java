package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.ObservableList;

public class ListChangeRegistry extends CallbackRegistry<ObservableList.OnListChangedCallback, ObservableList, ListChanges> {
    public static final int ALL = 0;
    public static final int CHANGED = 1;
    public static final int INSERTED = 2;
    public static final int MOVED = 3;
    public static final CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChanges> NOTIFIER_CALLBACK = new CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChanges>() {
        public void onNotifyCallback(ObservableList.OnListChangedCallback onListChangedCallback, ObservableList observableList, int i2, ListChanges listChanges) {
            if (i2 == 1) {
                onListChangedCallback.onItemRangeChanged(observableList, listChanges.start, listChanges.count);
            } else if (i2 == 2) {
                onListChangedCallback.onItemRangeInserted(observableList, listChanges.start, listChanges.count);
            } else if (i2 == 3) {
                onListChangedCallback.onItemRangeMoved(observableList, listChanges.start, listChanges.to, listChanges.count);
            } else if (i2 != 4) {
                onListChangedCallback.onChanged(observableList);
            } else {
                onListChangedCallback.onItemRangeRemoved(observableList, listChanges.start, listChanges.count);
            }
        }
    };
    public static final int REMOVED = 4;
    public static final Pools.SynchronizedPool<ListChanges> sListChanges = new Pools.SynchronizedPool<>(10);

    public static class ListChanges {
        public int count;
        public int start;
        public int to;
    }

    public ListChangeRegistry() {
        super(NOTIFIER_CALLBACK);
    }

    public static ListChanges acquire(int i2, int i3, int i4) {
        ListChanges acquire = sListChanges.acquire();
        if (acquire == null) {
            acquire = new ListChanges();
        }
        acquire.start = i2;
        acquire.to = i3;
        acquire.count = i4;
        return acquire;
    }

    public void notifyChanged(@NonNull ObservableList observableList) {
        notifyCallbacks(observableList, 0, (ListChanges) null);
    }

    public void notifyInserted(@NonNull ObservableList observableList, int i2, int i3) {
        notifyCallbacks(observableList, 2, acquire(i2, 0, i3));
    }

    public void notifyMoved(@NonNull ObservableList observableList, int i2, int i3, int i4) {
        notifyCallbacks(observableList, 3, acquire(i2, i3, i4));
    }

    public void notifyRemoved(@NonNull ObservableList observableList, int i2, int i3) {
        notifyCallbacks(observableList, 4, acquire(i2, 0, i3));
    }

    public synchronized void notifyCallbacks(@NonNull ObservableList observableList, int i2, ListChanges listChanges) {
        super.notifyCallbacks(observableList, i2, listChanges);
        if (listChanges != null) {
            sListChanges.release(listChanges);
        }
    }

    public void notifyChanged(@NonNull ObservableList observableList, int i2, int i3) {
        notifyCallbacks(observableList, 1, acquire(i2, 0, i3));
    }
}
