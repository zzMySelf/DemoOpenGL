package com.tera.scan.network.network.retrofit;

import androidx.core.app.NotificationCompat;
import com.baidu.sapi2.activity.LoginActivity;
import com.dlife.ctaccountapi.t;
import fe.mmm.qw.j.yj;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007JT\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\u00110\u0017JR\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u00142\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\u00110\u0017JT\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\u00110\u0017J@\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014J<\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u0014J@\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0014J(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\u00110\u0017H\u0002J\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\b\u0010#\u001a\u0004\u0018\u00010!H\u0002R!\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/tera/scan/network/network/retrofit/NetworkExecuteHelper;", "T", "", "mBaseUrl", "", "responseClazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)V", "errorResponse", "Lcom/tera/scan/network/network/response/BaseResponse;", "getErrorResponse", "()Lcom/tera/scan/network/network/response/BaseResponse;", "errorResponse$delegate", "Lkotlin/Lazy;", "serviceApi", "Lcom/tera/scan/network/network/retrofit/RetrofitServiceApi;", "enqueueGet", "", "url", "header", "", "map", "callback", "Lkotlin/Function1;", "enqueueMultipartPost", "partMap", "Lokhttp3/RequestBody;", "enqueuePost", "executeGet", "executeMultipartPost", "executePost", "getEnqueueCallback", "Lretrofit2/Callback;", "Lokhttp3/ResponseBody;", "getParsedResponse", "responseBody", "lib-network_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkExecuteHelper<T> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final RetrofitServiceApi f7055ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final Lazy f7056de = LazyKt__LazyJVMKt.lazy(NetworkExecuteHelper$errorResponse$2.INSTANCE);
    @NotNull
    public final Class<T> qw;

    public static final class qw implements Callback<ResponseBody> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Function1<fe.mmm.qw.nn.de.pf.qw<T>, Unit> f7057ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ NetworkExecuteHelper<T> f7058th;

        public qw(Function1<? super fe.mmm.qw.nn.de.pf.qw<T>, Unit> function1, NetworkExecuteHelper<T> networkExecuteHelper) {
            this.f7057ad = function1;
            this.f7058th = networkExecuteHelper;
        }

        public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(th2, t.a);
            this.f7057ad.invoke(this.f7058th.rg());
        }

        public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {
            Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
            Intrinsics.checkNotNullParameter(response, LoginActivity.EXTRA_PARAM_THIRD_VERIFY_RESPONSE);
            this.f7057ad.invoke(this.f7058th.th(response.isSuccessful() ? response.body() : null));
        }
    }

    public NetworkExecuteHelper(@NotNull String str, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(str, "mBaseUrl");
        Intrinsics.checkNotNullParameter(cls, "responseClazz");
        this.qw = cls;
        this.f7055ad = new fe.mmm.qw.nn.de.p028if.qw().ad(str);
    }

    public final void de(@NotNull String str, @NotNull Map<String, String> map, @NotNull Map<String, ? extends RequestBody> map2, @NotNull Function1<? super fe.mmm.qw.nn.de.pf.qw<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(map, "header");
        Intrinsics.checkNotNullParameter(map2, "partMap");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.f7055ad.qw(str, map, map2).enqueue(fe(function1));
    }

    public final Callback<ResponseBody> fe(Function1<? super fe.mmm.qw.nn.de.pf.qw<T>, Unit> function1) {
        return new qw(function1, this);
    }

    public final fe.mmm.qw.nn.de.pf.qw<T> rg() {
        return (fe.mmm.qw.nn.de.pf.qw) this.f7056de.getValue();
    }

    public final fe.mmm.qw.nn.de.pf.qw<T> th(ResponseBody responseBody) {
        String string;
        if (responseBody == null || (string = responseBody.string()) == null) {
            return rg();
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            fe.mmm.qw.nn.de.pf.qw<T> qwVar = new fe.mmm.qw.nn.de.pf.qw<>();
            qwVar.errno = jSONObject.optInt("errno");
            qwVar.errmsg = jSONObject.optString("errmsg");
            qwVar.alertmsg = jSONObject.optString("show_msg");
            qwVar.promptType = jSONObject.optInt("prompt_type");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            qwVar.ad(yj.qw(optJSONObject != null ? optJSONObject.toString() : null, this.qw));
            return qwVar;
        } catch (Exception unused) {
            return rg();
        }
    }
}
