package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

public class FragmentViewLifecycleOwner implements SavedStateRegistryOwner {
    public LifecycleRegistry mLifecycleRegistry = null;
    public SavedStateRegistryController mSavedStateRegistryController = null;

    @NonNull
    public Lifecycle getLifecycle() {
        initialize();
        return this.mLifecycleRegistry;
    }

    @NonNull
    public SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public void handleLifecycleEvent(@NonNull Lifecycle.Event event) {
        this.mLifecycleRegistry.handleLifecycleEvent(event);
    }

    public void initialize() {
        if (this.mLifecycleRegistry == null) {
            this.mLifecycleRegistry = new LifecycleRegistry(this);
            this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        }
    }

    public boolean isInitialized() {
        return this.mLifecycleRegistry != null;
    }

    public void performRestore(@Nullable Bundle bundle) {
        this.mSavedStateRegistryController.performRestore(bundle);
    }

    public void performSave(@NonNull Bundle bundle) {
        this.mSavedStateRegistryController.performSave(bundle);
    }

    public void setCurrentState(@NonNull Lifecycle.State state) {
        this.mLifecycleRegistry.setCurrentState(state);
    }
}
