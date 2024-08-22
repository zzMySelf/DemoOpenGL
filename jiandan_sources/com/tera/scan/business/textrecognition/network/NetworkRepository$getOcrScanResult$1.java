package com.tera.scan.business.textrecognition.network;

import com.baidu.sapi2.activity.LoginActivity;
import com.tera.scan.business.textrecognition.model.OcrResultData;
import com.tera.scan.business.textrecognition.model.OcrResultModel;
import fe.mmm.qw.j.yj;
import fe.mmm.qw.nn.de.pf.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "response", "Lcom/tera/scan/network/network/response/BaseResponse;", "Lcom/tera/scan/business/textrecognition/model/OcrResultModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NetworkRepository$getOcrScanResult$1 extends Lambda implements Function1<qw<OcrResultModel>, Unit> {
    public final /* synthetic */ Function1<OcrResultData, Unit> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkRepository$getOcrScanResult$1(Function1<? super OcrResultData, Unit> function1) {
        super(1);
        this.$callback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((qw<OcrResultModel>) (qw) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull qw<OcrResultModel> qwVar) {
        Intrinsics.checkNotNullParameter(qwVar, LoginActivity.EXTRA_PARAM_THIRD_VERIFY_RESPONSE);
        OcrResultData ocrResultData = null;
        if (qwVar.isSuccess()) {
            try {
                OcrResultModel qw = qwVar.qw();
                ocrResultData = (OcrResultData) yj.qw(qw != null ? qw.getData() : null, OcrResultData.class);
            } catch (Exception unused) {
            }
        }
        this.$callback.invoke(ocrResultData);
    }
}
