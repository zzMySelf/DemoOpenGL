package fe.ggg.ad.qw.de.de;

import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    public static final float qw(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return ((float) intent.getIntExtra("level", -1)) / ((float) intent.getIntExtra("scale", -1));
    }
}
