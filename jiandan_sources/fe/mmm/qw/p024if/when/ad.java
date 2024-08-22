package fe.mmm.qw.p024if.when;

import androidx.fragment.app.Fragment;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import com.tera.scan.flutter.ui.FlutterBusinessFragment;
import io.flutter.embedding.android.TransparencyMode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: fe.mmm.qw.if.when.ad  reason: invalid package */
public final class ad {
    @NotNull
    public static final Fragment qw(@NotNull String str, @NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(str, "path");
        Intrinsics.checkNotNullParameter(map, "params");
        FlutterBoostFragment.qw qwVar = new FlutterBoostFragment.qw(FlutterBusinessFragment.class);
        qwVar.th(str);
        qwVar.yj(map);
        qwVar.de(false);
        qwVar.fe(true);
        qwVar.rg(TransparencyMode.opaque);
        FlutterBoostFragment qw = qwVar.qw();
        Intrinsics.checkNotNullExpressionValue(qw, "CachedEngineFragmentBuil…lutterBusinessFragment>()");
        return qw;
    }
}
