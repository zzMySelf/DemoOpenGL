package fe.rg.qw.p018switch;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* renamed from: fe.rg.qw.switch.ad  reason: invalid package */
public final class ad {
    public final List<ImageHeaderParser> qw = new ArrayList();

    @NonNull
    public synchronized List<ImageHeaderParser> ad() {
        return this.qw;
    }

    public synchronized void qw(@NonNull ImageHeaderParser imageHeaderParser) {
        this.qw.add(imageHeaderParser);
    }
}
