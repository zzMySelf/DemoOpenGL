package fe.mmm.qw.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.baidu.ubc.UBCManager;
import fe.fe.ddd.pf.qw.ad.ad;
import fe.fe.ddd.pf.qw.ad.qw;
import fe.fe.ddd.pf.qw.qw;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public final class fe {
    public static final void ad(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, UBCManager.CONTENT_KEY_SOURCE);
        Intrinsics.checkNotNullParameter(str3, "launchChannel");
        Intrinsics.checkNotNullParameter(str4, "downChannel");
        Intrinsics.checkNotNullParameter(str5, "schema");
        JSONObject jSONObject = new JSONObject();
        ad.qw qwVar = new ad.qw(str);
        qwVar.m72if(str2);
        qwVar.o(str3);
        qwVar.uk(str4);
        qwVar.pf(str5);
        qwVar.i(jSONObject);
        qw.de(qwVar.yj());
    }

    public static final void de(boolean z, @NotNull Uri uri) {
        T t;
        T t2;
        String str;
        T t3;
        String str2;
        String queryParameter;
        Intrinsics.checkNotNullParameter(uri, "schema");
        String str3 = z ? "cold_start" : "warm_start";
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames, "schema.queryParameterNames");
        Iterator<T> it = queryParameterNames.iterator();
        while (true) {
            t = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (Intrinsics.areEqual((Object) (String) t2, (Object) UBCManager.CONTENT_KEY_SOURCE)) {
                break;
            }
        }
        String str4 = (String) t2;
        String str5 = "";
        if (str4 == null || (str = uri.getQueryParameter(str4)) == null) {
            str = str5;
        }
        Set<String> queryParameterNames2 = uri.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames2, "schema.queryParameterNames");
        Iterator<T> it2 = queryParameterNames2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it2.next();
            if (Intrinsics.areEqual((Object) (String) t3, (Object) "launch_ch")) {
                break;
            }
        }
        String str6 = (String) t3;
        if (str6 == null || (str2 = uri.getQueryParameter(str6)) == null) {
            str2 = str5;
        }
        Set<String> queryParameterNames3 = uri.getQueryParameterNames();
        Intrinsics.checkNotNullExpressionValue(queryParameterNames3, "schema.queryParameterNames");
        Iterator<T> it3 = queryParameterNames3.iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            T next = it3.next();
            if (Intrinsics.areEqual((Object) (String) next, (Object) "down_ch")) {
                t = next;
                break;
            }
        }
        String str7 = (String) t;
        if (!(str7 == null || (queryParameter = uri.getQueryParameter(str7)) == null)) {
            str5 = queryParameter;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "schema.toString()");
        ad(str3, str, str2, str5, uri2);
    }

    public static final void fe(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("UBCGrowthSP", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…E, Activity.MODE_PRIVATE)");
        if (sharedPreferences.getBoolean("growth_is_first_cold_start", true)) {
            sharedPreferences.edit().putBoolean("growth_is_first_cold_start", false).apply();
            String str = fe.mmm.qw.de.ad.qw.qw.f7752rg;
            Intrinsics.checkNotNullExpressionValue(str, "channelNum");
            qw("active", str);
        }
    }

    public static final void qw(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "channel");
        JSONObject jSONObject = new JSONObject();
        qw.C0082qw qwVar = new qw.C0082qw(str2);
        qwVar.th(str);
        qwVar.rg(jSONObject);
        fe.fe.ddd.pf.qw.qw.ad(qwVar.fe(), fe.fe.ddd.i.qw.qw.qw().getApplicationContext());
    }

    public static final void rg() {
        fe.fe.ddd.pf.qw.qw.qw();
    }
}
