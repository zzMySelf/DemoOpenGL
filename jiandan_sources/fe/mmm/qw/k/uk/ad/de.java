package fe.mmm.qw.k.uk.ad;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import com.mars.kotlin.service.Extra;
import com.mars.kotlin.service.extension.ResultReceiverKt;
import com.tera.scan.vip.network.model.UserInfoResponse;
import fe.mmm.qw.a.uk.qw;
import fe.mmm.qw.k.uk.de.rg;
import fe.mmm.qw.nn.qw.qw.i;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Tag("GetUserInfoJob")
public final class de extends qw {
    @NotNull
    public final Context ggg;
    @NotNull
    public final ResultReceiver vvv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public de(@NotNull Context context, @NotNull ResultReceiver resultReceiver) {
        super("GetUserInfoJob");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        this.ggg = context;
        this.vvv = resultReceiver;
    }

    public void ppp() {
        if (!i.rg(this.ggg)) {
            ResultReceiverKt.networkWrong(this.vvv);
            return;
        }
        Either<Pair<String, Integer>, UserInfoResponse> i2 = new rg().i();
        if (i2 instanceof Either.Right) {
            Either.Right right = (Either.Right) i2;
            if (((UserInfoResponse) right.getValue()).errno == 0) {
                ResultReceiver resultReceiver = this.vvv;
                Bundle bundle = new Bundle();
                bundle.putParcelable(Extra.RESULT, (Parcelable) right.getValue());
                Unit unit = Unit.INSTANCE;
                resultReceiver.send(1, bundle);
                return;
            }
        }
        ResultReceiverKt.wrong(this.vvv);
    }
}
