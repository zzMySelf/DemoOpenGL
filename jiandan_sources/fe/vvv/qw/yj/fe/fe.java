package fe.vvv.qw.yj.fe;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionCallback;

@RequiresApi(21)
public abstract class fe implements ActionCallback {
    public abstract void ad(@NonNull Action action);

    public final void qw(@NonNull Action action, int i2) {
        if (i2 == Integer.MAX_VALUE) {
            ad(action);
        }
    }
}
