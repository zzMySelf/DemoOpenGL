package fe.mmm.qw.k.uk.de;

import com.google.gson.JsonParseException;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.network.network.exception.RemoteException;
import com.tera.scan.vip.network.model.UserInfoResponse;
import fe.mmm.qw.nn.de.ad;
import fe.mmm.qw.nn.qw.qw.fe;
import fe.mmm.qw.nn.qw.qw.uk;
import fe.mmm.qw.p030switch.rg.qw;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Tag("UserInfoApi")
public final class rg extends ad {
    public rg() {
        super(qw.qw().getBduss(), qw.qw().getUid(), new fe());
        yj(fe.mmm.qw.nn.rg.ad.qw(this.f8092rg));
    }

    @NotNull
    public final Either<Pair<String, Integer>, UserInfoResponse> i() {
        Either<Pair<String, Integer>, UserInfoResponse> either;
        Either.Left<Pair<String, Integer>> left;
        try {
            either = ExpectKt.success((UserInfoResponse) new uk().qw(ad("https://" + fe.mmm.qw.rg.ad.ad.fe() + "/membership/userinfo", new fe.mmm.qw.nn.de.o.ad()), new fe.mmm.qw.nn.qw.qw.pf.qw(UserInfoResponse.class)));
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
            UserInfoResponse userInfoResponse = (UserInfoResponse) ((Either.Right) either).getValue();
            return userInfoResponse == null ? fe.mmm.qw.nn.de.i.qw.ad() : new Either.Right(userInfoResponse);
        } else if (either instanceof Either.Left) {
            return either;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
