package fe.mmm.qw.xxx.vvv;

import android.net.Uri;
import com.tera.scan.main.welcome.WelcomeActivity;
import fe.mmm.qw.e.fe;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class yj {
    public static final void qw(@NotNull WelcomeActivity welcomeActivity) {
        Uri data;
        Intrinsics.checkNotNullParameter(welcomeActivity, "<this>");
        if (Intrinsics.areEqual((Object) welcomeActivity.getIntent().getAction(), (Object) "android.intent.action.VIEW") && (data = welcomeActivity.getIntent().getData()) != null && Intrinsics.areEqual((Object) data.getScheme(), (Object) "aiscan") && Intrinsics.areEqual((Object) data.getHost(), (Object) "com.baidu.aiscan")) {
            fe.de(welcomeActivity.isColdStart$app_main_aiscanConfigRelease(), data);
        }
    }
}
