package androidx.databinding;

import androidx.annotation.NonNull;
import androidx.databinding.Observable;

public class BaseObservable implements Observable {
    public transient PropertyChangeRegistry mCallbacks;

    public void addOnPropertyChangedCallback(@NonNull Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new PropertyChangeRegistry();
            }
        }
        this.mCallbacks.add(onPropertyChangedCallback);
    }

    public void notifyChange() {
        synchronized (this) {
            if (this.mCallbacks != null) {
                this.mCallbacks.notifyCallbacks(this, 0, null);
            }
        }
    }

    public void notifyPropertyChanged(int i2) {
        synchronized (this) {
            if (this.mCallbacks != null) {
                this.mCallbacks.notifyCallbacks(this, i2, null);
            }
        }
    }

    public void removeOnPropertyChangedCallback(@NonNull Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized (this) {
            if (this.mCallbacks != null) {
                this.mCallbacks.remove(onPropertyChangedCallback);
            }
        }
    }
}
