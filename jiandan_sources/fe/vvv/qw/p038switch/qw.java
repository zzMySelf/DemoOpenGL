package fe.vvv.qw.p038switch;

import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.markers.AutoFocusMarker;

/* renamed from: fe.vvv.qw.switch.qw  reason: invalid package */
public class qw {
    public AutoFocusMarker qw = null;

    public qw(@NonNull TypedArray typedArray) {
        String string = typedArray.getString(3);
        if (string != null) {
            try {
                this.qw = (AutoFocusMarker) Class.forName(string).newInstance();
            } catch (Exception unused) {
            }
        }
    }

    @Nullable
    public AutoFocusMarker qw() {
        return this.qw;
    }
}
