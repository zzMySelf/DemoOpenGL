package androidx.databinding;

import androidx.collection.ArrayMap;
import androidx.databinding.ObservableMap;
import java.util.Collection;

public class ObservableArrayMap<K, V> extends ArrayMap<K, V> implements ObservableMap<K, V> {
    public transient MapChangeRegistry mListeners;

    private void notifyChange(Object obj) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.notifyCallbacks(this, 0, obj);
        }
    }

    public void addOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        if (this.mListeners == null) {
            this.mListeners = new MapChangeRegistry();
        }
        this.mListeners.add(onMapChangedCallback);
    }

    public void clear() {
        if (!isEmpty()) {
            super.clear();
            notifyChange((Object) null);
        }
    }

    public V put(K k, V v) {
        super.put(k, v);
        notifyChange(k);
        return v;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object indexOfKey : collection) {
            int indexOfKey2 = indexOfKey(indexOfKey);
            if (indexOfKey2 >= 0) {
                z = true;
                removeAt(indexOfKey2);
            }
        }
        return z;
    }

    public V removeAt(int i2) {
        Object keyAt = keyAt(i2);
        V removeAt = super.removeAt(i2);
        if (removeAt != null) {
            notifyChange(keyAt);
        }
        return removeAt;
    }

    public void removeOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.remove(onMapChangedCallback);
        }
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            if (!collection.contains(keyAt(size))) {
                removeAt(size);
                z = true;
            }
        }
        return z;
    }

    public V setValueAt(int i2, V v) {
        Object keyAt = keyAt(i2);
        V valueAt = super.setValueAt(i2, v);
        notifyChange(keyAt);
        return valueAt;
    }
}
