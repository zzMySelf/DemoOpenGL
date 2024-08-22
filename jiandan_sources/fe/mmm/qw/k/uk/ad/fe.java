package fe.mmm.qw.k.uk.ad;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import com.mars.kotlin.service.Extra;
import com.mars.kotlin.service.extension.ResultReceiverKt;
import com.tera.scan.vip.network.model.PreCreateOrderResponse;
import fe.mmm.qw.a.uk.qw;
import fe.mmm.qw.k.uk.de.ad;
import fe.mmm.qw.nn.qw.qw.i;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Tag("PreCreateOrderJob")
public final class fe extends qw {
    @NotNull
    public final ResultReceiver ddd;
    @NotNull
    public final Context ggg;
    @NotNull
    public final String vvv;
    @NotNull
    public final String xxx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fe(@NotNull Context context, @NotNull String str, @NotNull String str2, @NotNull ResultReceiver resultReceiver) {
        super("PreCreateOrderJob");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(str2, "fr");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        this.ggg = context;
        this.vvv = str;
        this.xxx = str2;
        this.ddd = resultReceiver;
    }

    public void ppp() {
        if (!i.rg(this.ggg)) {
            ResultReceiverKt.networkWrong(this.ddd);
            return;
        }
        Either<Pair<String, Integer>, PreCreateOrderResponse> i2 = new ad().i(this.vvv, this.xxx);
        if (i2 instanceof Either.Right) {
            Either.Right right = (Either.Right) i2;
            if (((PreCreateOrderResponse) right.getValue()).errno == 0) {
                ResultReceiver resultReceiver = this.ddd;
                Bundle bundle = new Bundle();
                bundle.putParcelable(Extra.RESULT, (Parcelable) right.getValue());
                Unit unit = Unit.INSTANCE;
                resultReceiver.send(1, bundle);
                return;
            }
        }
        ResultReceiverKt.wrong(this.ddd);
    }
}
