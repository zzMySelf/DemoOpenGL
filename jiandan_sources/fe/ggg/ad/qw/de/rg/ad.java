package fe.ggg.ad.qw.de.rg;

import android.database.Cursor;
import fe.ggg.ad.qw.fe.ad.qw;
import java.io.Closeable;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

public final class ad<U> extends qw<U> implements Closeable, Iterator<U>, KMappedMarker {
    @NotNull
    public final Function1<Cursor, U> qw() {
        throw null;
    }
}
