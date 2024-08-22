package fe.ggg.ad.qw.fe;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class qw {
    @Nullable
    public static final JSONObject ad(@Nullable String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    @NotNull
    public static final JSONObject qw(@NotNull JSONObject jSONObject, @NotNull String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        try {
            jSONObject.put(str, obj);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
