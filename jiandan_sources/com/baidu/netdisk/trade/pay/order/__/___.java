package com.baidu.netdisk.trade.pay.order.__;

import com.baidu.netdisk.trade.pay.order.model.Purchase;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007H'¨\u0006\t"}, d2 = {"Lcom/baidu/netdisk/trade/pay/order/server/ServerApi;", "", "createOrder", "Lretrofit2/Call;", "Lcom/baidu/netdisk/trade/pay/order/model/Purchase;", "map", "", "", "businessChannel", "orderpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ___ {
    @NotNull
    @GET("rest/2.0/membership/product?method=purchase&order_expire=1&clientinfo=android-7-8")
    Call<Purchase> qw(@NotNull @QueryMap Map<String, String> map, @Nullable @Query("business_channel") String str);
}
