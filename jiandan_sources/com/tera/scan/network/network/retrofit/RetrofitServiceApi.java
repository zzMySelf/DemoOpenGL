package com.tera.scan.network.network.retrofit;

import java.util.Map;
import kotlin.Metadata;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0014\b\u0003\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH'JI\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0019\b\u0001\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\t\u0012\u00070\u000b¢\u0006\u0002\b\f0\bH'JD\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\u0014\b\u0003\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH'¨\u0006\u000e"}, d2 = {"Lcom/tera/scan/network/network/retrofit/RetrofitServiceApi;", "", "requestGet", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "url", "", "header", "", "map", "requestMultipartPost", "Lokhttp3/RequestBody;", "Lkotlin/jvm/JvmSuppressWildcards;", "requestPost", "lib-network_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RetrofitServiceApi {
    @Multipart
    @NotNull
    @POST
    Call<ResponseBody> qw(@NotNull @Url String str, @NotNull @HeaderMap Map<String, String> map, @NotNull @PartMap Map<String, RequestBody> map2);
}
