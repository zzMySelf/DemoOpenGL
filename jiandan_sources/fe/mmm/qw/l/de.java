package fe.mmm.qw.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tera.scan.web.WebPreviewActivity;
import com.tera.scan.webview.BaseWebViewFragment;
import org.jetbrains.annotations.Nullable;

public final class de {
    public static final boolean ad(@Nullable Context context, @Nullable String str) {
        Intent qw = qw(context, str);
        if (qw == null) {
            return false;
        }
        if (context == null) {
            return true;
        }
        context.startActivity(qw);
        return true;
    }

    @Nullable
    public static final Intent qw(@Nullable Context context, @Nullable String str) {
        if (context == null) {
            return null;
        }
        if (str == null || str.length() == 0) {
            return null;
        }
        Intent intent = new Intent(context, WebPreviewActivity.class);
        intent.putExtra(BaseWebViewFragment.EXTRA_URL, str);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        return intent;
    }
}
