package fe.mmm.qw.k.uk.de;

import com.google.gson.JsonParseException;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.network.network.exception.RemoteException;
import com.tera.scan.vip.network.model.OrderInfoResponse;
import fe.mmm.qw.nn.de.ad;
import fe.mmm.qw.nn.qw.qw.fe;
import fe.mmm.qw.nn.qw.qw.uk;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Tag("OrderInfoApi")
public final class qw extends ad {
    public qw() {
        super(fe.mmm.qw.p030switch.rg.qw.qw().getBduss(), fe.mmm.qw.p030switch.rg.qw.qw().getUid(), new fe());
        yj(fe.mmm.qw.nn.rg.ad.qw(this.f8092rg));
    }

    @NotNull
    public final Either<Pair<String, Integer>, OrderInfoResponse> i(@NotNull String str) {
        Either<Pair<String, Integer>, OrderInfoResponse> either;
        Either.Left<Pair<String, Integer>> left;
        Intrinsics.checkNotNullParameter(str, "orderNo");
        String str2 = "https://" + fe.mmm.qw.rg.ad.ad.fe() + "/membership/orderinfo";
        fe.mmm.qw.nn.de.o.ad adVar = new fe.mmm.qw.nn.de.o.ad();
        adVar.ad("order_no", str);
        try {
            either = ExpectKt.success((OrderInfoResponse) new uk().qw(ad(str2, adVar), new fe.mmm.qw.nn.qw.qw.pf.qw(OrderInfoResponse.class)));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        if (either instanceof Either.Left) {
            Throwable th3 = (Throwable) ((Either.Left) either).getValue();
            if (th3 instanceof RemoteException) {
                RemoteException remoteException = (RemoteException) th3;
                left = fe.mmm.qw.nn.de.i.qw.de(remoteException.getErrorCode(), remoteException.getErrorMessage());
            } else if (th3 instanceof JsonParseException) {
                left = fe.mmm.qw.nn.de.i.qw.de(-105, "");
            } else {
                left = fe.mmm.qw.nn.de.i.qw.de(-104, "");
            }
            either = new Either.Left<>(fe.mmm.qw.nn.de.i.qw.qw(left));
        } else if (!(either instanceof Either.Right)) {
            throw new NoWhenBranchMatchedException();
        }
        if (either instanceof Either.Right) {
            either = ExpectKt.success(((Either.Right) either).getValue());
        } else if (!(either instanceof Either.Left)) {
            throw new NoWhenBranchMatchedException();
        }
        if (either instanceof Either.Right) {
            OrderInfoResponse orderInfoResponse = (OrderInfoResponse) ((Either.Right) either).getValue();
            return orderInfoResponse == null ? fe.mmm.qw.nn.de.i.qw.ad() : new Either.Right(orderInfoResponse);
        } else if (either instanceof Either.Left) {
            return either;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
