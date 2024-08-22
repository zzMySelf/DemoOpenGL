package fe.vvv.qw.uk;

import android.content.res.TypedArray;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.Filter;

public class ad {
    public Filter qw = null;

    public ad(@NonNull TypedArray typedArray) {
        try {
            this.qw = (Filter) Class.forName(typedArray.getString(8)).newInstance();
        } catch (Exception unused) {
            this.qw = new de();
        }
    }

    @NonNull
    public Filter qw() {
        return this.qw;
    }
}
