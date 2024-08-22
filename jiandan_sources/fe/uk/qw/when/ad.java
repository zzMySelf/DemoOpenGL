package fe.uk.qw.when;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

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
