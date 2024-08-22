package androidx.databinding;

import androidx.databinding.Observable;

public abstract class BaseObservableField extends BaseObservable {

    public class DependencyCallback extends Observable.OnPropertyChangedCallback {
        public DependencyCallback() {
        }

        public void onPropertyChanged(Observable observable, int i2) {
            BaseObservableField.this.notifyChange();
        }
    }

    public BaseObservableField() {
    }

    public BaseObservableField(Observable... observableArr) {
        if (observableArr != null && observableArr.length != 0) {
            DependencyCallback dependencyCallback = new DependencyCallback();
            for (Observable addOnPropertyChangedCallback : observableArr) {
                addOnPropertyChangedCallback.addOnPropertyChangedCallback(dependencyCallback);
            }
        }
    }
}
