package fe.mmm.qw.p024if.when;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tera.scan.flutter.ui.FlutterBusinessActivity;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.if.when.qw  reason: invalid package */
public final class qw {
    public static final void ad(@Nullable Activity activity, @Nullable Integer num, @NotNull String str, @Nullable HashMap<String, Object> hashMap) {
        Intrinsics.checkNotNullParameter(str, "path");
        if (activity != null) {
            Intent intent = new Intent(activity, FlutterBusinessActivity.class);
            if (hashMap != null) {
                intent.putExtra("extra_args", hashMap);
            }
            intent.putExtra("extra_path", str);
            if (num != null) {
                activity.startActivityForResult(intent, num.intValue());
            } else {
                activity.startActivity(intent);
            }
        }
    }

    public static final void de(@Nullable Context context, @NotNull String str, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "path");
        if (context != null) {
            Intent intent = new Intent(context, FlutterBusinessActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            if (bundle != null) {
                intent.putExtra("extra_args", bundle);
            }
            intent.putExtra("extra_path", str);
            context.startActivity(intent);
        }
    }

    public static final void qw(@Nullable Activity activity, @Nullable Integer num, @NotNull String str, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "path");
        if (activity != null) {
            Intent intent = new Intent(activity, FlutterBusinessActivity.class);
            if (bundle != null) {
                intent.putExtra("extra_args", bundle);
            }
            intent.putExtra("extra_path", str);
            if (num != null) {
                activity.startActivityForResult(intent, num.intValue());
            } else {
                activity.startActivity(intent);
            }
        }
    }
}
