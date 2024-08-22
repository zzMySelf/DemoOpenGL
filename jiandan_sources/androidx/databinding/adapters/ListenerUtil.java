package androidx.databinding.adapters;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class ListenerUtil {
    public static final SparseArray<WeakHashMap<View, WeakReference<?>>> sListeners = new SparseArray<>();

    public static <T> T getListener(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 14) {
            return view.getTag(i2);
        }
        synchronized (sListeners) {
            WeakHashMap weakHashMap = sListeners.get(i2);
            if (weakHashMap == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) weakHashMap.get(view);
            if (weakReference == null) {
                return null;
            }
            T t = weakReference.get();
            return t;
        }
    }

    public static <T> T trackListener(View view, T t, int i2) {
        WeakReference weakReference;
        if (Build.VERSION.SDK_INT >= 14) {
            T tag = view.getTag(i2);
            view.setTag(i2, t);
            return tag;
        }
        synchronized (sListeners) {
            WeakHashMap weakHashMap = sListeners.get(i2);
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap();
                sListeners.put(i2, weakHashMap);
            }
            if (t == null) {
                weakReference = (WeakReference) weakHashMap.remove(view);
            } else {
                weakReference = (WeakReference) weakHashMap.put(view, new WeakReference(t));
            }
            if (weakReference == null) {
                return null;
            }
            T t2 = weakReference.get();
            return t2;
        }
    }
}
