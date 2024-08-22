package com.baidu.netdisk.trade.pay.config;

import java.util.Map;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\u0003H&¨\u0006\n"}, d2 = {"Lcom/baidu/netdisk/trade/pay/config/IRequest;", "", "appendParams", "", "authorizedUrlBuilder", "Lokhttp3/HttpUrl$Builder;", "channel", "getHeaders", "", "host", "orderpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IRequest {
    @Nullable
    String ad();

    @Nullable
    String de(@NotNull HttpUrl.Builder builder);

    @Nullable
    String fe();

    @Nullable
    Map<String, String> qw();
}
