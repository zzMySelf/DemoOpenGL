package fe.rg.qw.pf;

import androidx.annotation.NonNull;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;

public class ad implements Lifecycle {
    public void ad(@NonNull LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }

    public void qw(@NonNull LifecycleListener lifecycleListener) {
    }
}
