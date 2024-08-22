package androidx.databinding;

public interface Observable {

    public static abstract class OnPropertyChangedCallback {
        public abstract void onPropertyChanged(Observable observable, int i2);
    }

    void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);

    void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);
}
