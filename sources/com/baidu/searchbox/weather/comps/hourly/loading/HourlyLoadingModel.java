package com.baidu.searchbox.weather.comps.hourly.loading;

import com.baidu.searchbox.nacomp.recycler.delegate.IAdapterData;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/weather/comps/hourly/loading/HourlyLoadingModel;", "Lcom/baidu/searchbox/nacomp/recycler/delegate/IAdapterData;", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "getToken", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getType", "Companion", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HourlyLoadingModel.kt */
public final class HourlyLoadingModel implements IAdapterData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final UniqueId TYPE;
    private final UniqueId token;

    public HourlyLoadingModel(UniqueId token2) {
        Intrinsics.checkNotNullParameter(token2, "token");
        this.token = token2;
    }

    public final UniqueId getToken() {
        return this.token;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/weather/comps/hourly/loading/HourlyLoadingModel$Companion;", "", "()V", "TYPE", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getTYPE", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HourlyLoadingModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UniqueId getTYPE() {
            return HourlyLoadingModel.TYPE;
        }
    }

    static {
        UniqueId gen = UniqueId.gen("HourlyLoadingModel");
        Intrinsics.checkNotNullExpressionValue(gen, "gen(\"HourlyLoadingModel\")");
        TYPE = gen;
    }

    public UniqueId getType() {
        return TYPE;
    }
}
