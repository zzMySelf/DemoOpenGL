package fe.mmm.qw.a;

import com.mars.kotlin.extension.Tag;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Tag("JobSchedulerIdStatistic")
public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f7606ad;

    /* renamed from: de  reason: collision with root package name */
    public static boolean f7607de;
    @NotNull
    public static final ad qw = new ad();

    public final boolean ad() {
        return f7606ad;
    }

    public final void de(@NotNull String str, @NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(jSONObject, "extras");
        de.qw(new fe("5147", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT, "total", "yanfa", str, "", jSONObject));
    }

    public final boolean qw() {
        return f7607de;
    }
}
