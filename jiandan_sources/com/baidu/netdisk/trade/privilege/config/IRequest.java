package com.baidu.netdisk.trade.privilege.config;

import java.util.Map;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/baidu/netdisk/trade/privilege/config/IRequest;", "Lkotlin/Any;", "Lokhttp3/HttpUrl$Builder;", "authorizedUrlBuilder", "", "appendParams", "(Lokhttp3/HttpUrl$Builder;)Ljava/lang/String;", "channel", "()Ljava/lang/String;", "", "getHeaders", "()Ljava/util/Map;", "", "getRealTime", "()J", "host", "TradeMemberPrivilege_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public interface IRequest {
    @NotNull
    String ad();

    @NotNull
    String de(@NotNull HttpUrl.Builder builder);

    @NotNull
    String fe();

    @NotNull
    Map<String, String> qw();

    long rg();
}
