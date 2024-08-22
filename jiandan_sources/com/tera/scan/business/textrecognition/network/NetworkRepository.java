package com.tera.scan.business.textrecognition.network;

import androidx.webkit.internal.AssetHelper;
import com.google.common.net.HttpHeaders;
import com.tera.scan.business.textrecognition.model.OcrResultData;
import com.tera.scan.business.textrecognition.model.OcrResultModel;
import com.tera.scan.network.network.retrofit.NetworkExecuteHelper;
import fe.mmm.qw.nn.de.pf.qw;
import fe.mmm.qw.rg.ad.ad;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\bJF\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000f\u0012\u0004\u0012\u00020\u00040\bH\u0002¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/business/textrecognition/network/NetworkRepository;", "", "()V", "getOcrScanResult", "", "imagePath", "", "callback", "Lkotlin/Function1;", "Lcom/tera/scan/business/textrecognition/model/OcrResultData;", "getScanResult", "T", "opId", "clazz", "Ljava/lang/Class;", "Lcom/tera/scan/network/network/response/BaseResponse;", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkRepository {
    public final <T> void ad(String str, String str2, Class<T> cls, Function1<? super qw<T>, Unit> function1) {
        File file = new File(str);
        RequestBody create = RequestBody.create(MediaType.parse("image/*"), file);
        RequestBody create2 = RequestBody.create(MediaType.parse(AssetHelper.DEFAULT_MIME_TYPE), str2);
        Map mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("opid", create2), TuplesKt.to("pic\"; filename=\"" + file.getName(), create));
        new NetworkExecuteHelper("https://" + ad.de(), cls).de("/simpscan/data/binary", MapsKt__MapsJVMKt.mapOf(TuplesKt.to(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*")), mapOf, function1);
    }

    public final void qw(@NotNull String str, @NotNull Function1<? super OcrResultData, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "imagePath");
        Intrinsics.checkNotNullParameter(function1, "callback");
        ad(str, "3012", OcrResultModel.class, new NetworkRepository$getOcrScanResult$1(function1));
    }
}
