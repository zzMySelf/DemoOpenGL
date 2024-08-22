package fe.mmm.qw.k.pf.uk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import com.tera.scan.vip.ui.dialog.AdvancedWebActivity;
import com.tera.scan.webview.BaseWebViewFragment;
import org.jetbrains.annotations.Nullable;

public final class ad {
    public static final boolean ad(@Nullable Context context, @Nullable String str, @Nullable ResultReceiver resultReceiver) {
        Intent qw = qw(context, str, resultReceiver);
        if (qw == null) {
            return false;
        }
        if (context == null) {
            return true;
        }
        context.startActivity(qw);
        return true;
    }

    public static /* synthetic */ boolean de(Context context, String str, ResultReceiver resultReceiver, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            resultReceiver = null;
        }
        return ad(context, str, resultReceiver);
    }

    @Nullable
    public static final Intent qw(@Nullable Context context, @Nullable String str, @Nullable ResultReceiver resultReceiver) {
        if (context == null) {
            return null;
        }
        if (str == null || str.length() == 0) {
            return null;
        }
        Intent intent = new Intent(context, AdvancedWebActivity.class);
        intent.putExtra(BaseWebViewFragment.EXTRA_URL, str);
        intent.putExtra("result_receiver_key", resultReceiver);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        return intent;
    }
}
