package fe.mmm.qw.m.ggg.ad;

import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.webview.hybrid.call.ICallEntity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public final class de implements ICallEntity {

    /* renamed from: ad  reason: collision with root package name */
    public final int f8031ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public final String f8032de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final JSONObject f8033fe;
    @NotNull
    public final String qw;

    public de(@NotNull String str, int i2, @Nullable String str2, @Nullable JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "callbackId");
        this.qw = str;
        this.f8031ad = i2;
        this.f8032de = str2;
        this.f8033fe = jSONObject;
    }

    @NotNull
    public String qw() {
        Either either;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("code", this.f8031ad);
            String str = this.f8032de;
            if (str == null) {
                str = "";
            }
            jSONObject2.put("msg", str);
            JSONObject jSONObject3 = this.f8033fe;
            if (jSONObject3 != null) {
                jSONObject2.put("result", jSONObject3);
            }
            jSONObject.put("callbackId", this.qw);
            jSONObject.put("data", jSONObject2);
            either = ExpectKt.success(jSONObject);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        String jSONObject4 = ((JSONObject) ExpectKt.successOrDefault(either, jSONObject)).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject4, "catch {\n            json…Default(json1).toString()");
        return jSONObject4;
    }
}
