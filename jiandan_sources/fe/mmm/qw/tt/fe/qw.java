package fe.mmm.qw.tt.fe;

import com.baidu.ubc.UBCManager;
import fe.mmm.qw.e.rg;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class qw {
    public static /* synthetic */ void ad(String str, String str2, String str3, String str4, Map map, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = "aiscan";
        }
        if ((i2 & 8) != 0) {
            str4 = "";
        }
        if ((i2 & 16) != 0) {
            map = null;
        }
        qw(str, str2, str3, str4, map);
    }

    public static final void qw(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(str2, UBCManager.CONTENT_KEY_PAGE);
        Intrinsics.checkNotNullParameter(str3, "from");
        Intrinsics.checkNotNullParameter(str4, UBCManager.CONTENT_KEY_SOURCE);
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.Companion;
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            }
            Result.m1155constructorimpl(jSONObject.put("loginInfo", fe.mmm.qw.qw.qw.qw.pf() ? "load" : "Unload"));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        rg.ad("7474", str3, "display", str2, str, str4, jSONObject);
    }
}
