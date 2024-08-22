package fe.mmm.qw.k.uk.ad;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import com.mars.kotlin.service.Extra;
import com.mars.kotlin.service.extension.ResultReceiverKt;
import com.tera.scan.vip.network.model.ReportGooglePayTokenResponse;
import fe.mmm.qw.a.uk.qw;
import fe.mmm.qw.k.uk.de.fe;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Tag("ReportGooglePayTokenJob")
public final class rg extends qw {
    @NotNull
    public final String ddd;
    @NotNull
    public final String ggg;
    @NotNull
    public final ResultReceiver mmm;
    public final boolean nn;
    @NotNull
    public final String vvv;
    @NotNull
    public final String xxx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public rg(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z, @NotNull ResultReceiver resultReceiver) {
        super("ReportGooglePayTokenJob");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "googleOrderId");
        Intrinsics.checkNotNullParameter(str2, "packageName");
        Intrinsics.checkNotNullParameter(str3, "productId");
        Intrinsics.checkNotNullParameter(str4, "purchaseToken");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        this.ggg = str;
        this.vvv = str2;
        this.xxx = str3;
        this.ddd = str4;
        this.nn = z;
        this.mmm = resultReceiver;
    }

    public void ppp() {
        int i2 = 0;
        while (i2 < 3) {
            StringBuilder sb = new StringBuilder();
            sb.append("开始第");
            i2++;
            sb.append(i2);
            sb.append("次上报凭证");
            LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
            Either<Pair<String, Integer>, ReportGooglePayTokenResponse> i3 = new fe().i(this.ggg, this.vvv, this.xxx, this.ddd, this.nn);
            if (i3 instanceof Either.Right) {
                Either.Right right = (Either.Right) i3;
                if (((ReportGooglePayTokenResponse) right.getValue()).errno == 0) {
                    LoggerKt.d$default("成功上报凭证", (Object) null, 1, (Object) null);
                    ResultReceiver resultReceiver = this.mmm;
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(Extra.RESULT, (Parcelable) right.getValue());
                    Unit unit = Unit.INSTANCE;
                    resultReceiver.send(1, bundle);
                    return;
                }
            }
            LoggerKt.d$default("上报凭证 sleep 5000", (Object) null, 1, (Object) null);
            Thread.sleep(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        }
        LoggerKt.d$default("上报凭证尝试3次之后还是失败了", (Object) null, 1, (Object) null);
        ResultReceiverKt.wrong(this.mmm);
    }
}
