package fe.mmm.qw.o.qw.fe;

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
    public static final void ad(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, UBCManager.CONTENT_KEY_PAGE);
        Intrinsics.checkNotNullParameter(str2, "value");
        Intrinsics.checkNotNullParameter(str3, "from");
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
        rg.ad("7476", str3, "display", str, str2, "", jSONObject);
    }

    public static final void qw(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, UBCManager.CONTENT_KEY_PAGE);
        Intrinsics.checkNotNullParameter(str2, "value");
        Intrinsics.checkNotNullParameter(str3, "from");
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
        rg.ad("7476", str3, "clk", str, str2, "", jSONObject);
    }
}
