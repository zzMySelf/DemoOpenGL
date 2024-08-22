package androidx.databinding;

import androidx.databinding.ObservableList;
import java.util.ArrayList;
import java.util.Collection;

public class ObservableArrayList<T> extends ArrayList<T> implements ObservableList<T> {
    public transient ListChangeRegistry mListeners = new ListChangeRegistry();

    private void notifyAdd(int i2, int i3) {
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            listChangeRegistry.notifyInserted(this, i2, i3);
        }
    }

    private void notifyRemove(int i2, int i3) {
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            listChangeRegistry.notifyRemoved(this, i2, i3);
        }
    }

    public boolean add(T t) {
        super.add(t);
        notifyAdd(size() - 1, 1);
        return true;
    }

    public boolean addAll(Collection<? extends T> collection) {
        int size = size();
        boolean addAll = super.addAll(collection);
        if (addAll) {
            notifyAdd(size, size() - size);
        }
        return addAll;
    }

    public void addOnListChangedCallback(ObservableList.OnListChangedCallback onListChangedCallback) {
        if (this.mListeners == null) {
            this.mListeners = new ListChangeRegistry();
        }
        this.mListeners.add(onListChangedCallback);
    }

    public void clear() {
        int size = size();
        super.clear();
        if (size != 0) {
            notifyRemove(0, size);
        }
    }

    public T remove(int i2) {
        T remove = super.remove(i2);
        notifyRemove(i2, 1);
        return remove;
    }

    public void removeOnListChangedCallback(ObservableList.OnListChangedCallback onListChangedCallback) {
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            listChangeRegistry.remove(onListChangedCallback);
        }
    }

    public void removeRange(int i2, int i3) {
        super.removeRange(i2, i3);
        notifyRemove(i2, i3 - i2);
    }

    public T set(int i2, T t) {
        T t2 = super.set(i2, t);
        ListChangeRegistry listChangeRegistry = this.mListeners;
        if (listChangeRegistry != null) {
            listChangeRegistry.notifyChanged(this, i2, 1);
        }
        return t2;
    }

    public void add(int i2, T t) {
        super.add(i2, t);
        notifyAdd(i2, 1);
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public boolean addAll(int i2, Collection<? extends T> collection) {
        boolean addAll = super.addAll(i2, collection);
        if (addAll) {
            notifyAdd(i2, collection.size());
        }
        return addAll;
    }
}
