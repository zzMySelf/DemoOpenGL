package fe.fe.pf.i.fe.ad;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.baidu.helios.ids.oid.brand.g;

public class th {
    public static void qw(Context context, g.a aVar) {
        Bundle bundle;
        if (context == null) {
            aVar.qw(false, (String) null);
            return;
        }
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient != null) {
                    bundle = acquireContentProviderClient.call("getOAID", (String) null, (Bundle) null);
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                } else {
                    bundle = null;
                }
            } else {
                bundle = context.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            aVar.qw(true, (bundle == null || bundle.getInt("code", -1) != 0) ? null : bundle.getString("id"));
        } catch (Throwable unused) {
            aVar.qw(false, (String) null);
        }
    }
}
