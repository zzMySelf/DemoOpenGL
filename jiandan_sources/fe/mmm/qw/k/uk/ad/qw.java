package fe.mmm.qw.k.uk.ad;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import com.mars.kotlin.service.Extra;
import com.mars.kotlin.service.extension.ResultReceiverKt;
import com.tera.scan.vip.network.model.OrderInfoResponse;
import fe.mmm.qw.nn.qw.qw.i;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Tag("GetOrderInfoJob")
public final class qw extends fe.mmm.qw.a.uk.qw {
    @NotNull
    public final Context ggg;
    @NotNull
    public final String vvv;
    @NotNull
    public final ResultReceiver xxx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qw(@NotNull Context context, @NotNull String str, @NotNull ResultReceiver resultReceiver) {
        super("GetOrderInfoJob");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "orderNo");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        this.ggg = context;
        this.vvv = str;
        this.xxx = resultReceiver;
    }

    public void ppp() {
        if (!i.rg(this.ggg)) {
            ResultReceiverKt.networkWrong(this.xxx);
            return;
        }
        Either<Pair<String, Integer>, OrderInfoResponse> i2 = new fe.mmm.qw.k.uk.de.qw().i(this.vvv);
        if (i2 instanceof Either.Right) {
            Either.Right right = (Either.Right) i2;
            if (((OrderInfoResponse) right.getValue()).errno == 0) {
                ResultReceiver resultReceiver = this.xxx;
                Bundle bundle = new Bundle();
                bundle.putParcelable(Extra.RESULT, (Parcelable) right.getValue());
                Unit unit = Unit.INSTANCE;
                resultReceiver.send(1, bundle);
                return;
            }
        }
        ResultReceiverKt.wrong(this.xxx);
    }
}
