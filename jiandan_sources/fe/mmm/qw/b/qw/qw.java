package fe.mmm.qw.b.qw;

import android.content.Context;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.ubc.UBCManager;
import com.google.gson.JsonParseException;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.network.network.exception.RemoteException;
import com.tera.scan.sofire.model.DoubleListReportResponse;
import fe.mmm.qw.nn.de.ad;
import fe.mmm.qw.nn.qw.qw.fe;
import fe.mmm.qw.nn.qw.qw.i;
import fe.mmm.qw.nn.qw.qw.uk;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw extends ad {
    public qw() {
        super(fe.mmm.qw.p030switch.rg.qw.qw().getBduss(), fe.mmm.qw.p030switch.rg.qw.qw().getUid(), new fe());
        yj(fe.mmm.qw.nn.rg.ad.qw(this.f8092rg));
    }

    public final Either<Pair<String, Integer>, DoubleListReportResponse> i(Context context, String str) {
        Either<Pair<String, Integer>, DoubleListReportResponse> either;
        Either.Left<Pair<String, Integer>> left;
        if (!i.rg(context)) {
            return fe.mmm.qw.nn.de.i.qw.ad();
        }
        String str2 = fe.mmm.qw.rg.ad.ad.qw.rg() + "/analysis/devicedot";
        fe.mmm.qw.nn.de.o.ad adVar = new fe.mmm.qw.nn.de.o.ad();
        adVar.ad("type", str);
        adVar.ad(UBCManager.CONTENT_KEY_SOURCE, SapiDeviceInfo.OS_TYPE);
        adVar.ad("cuid", fe.mmm.qw.de.ad.qw.qw.f7750o);
        try {
            either = ExpectKt.success((DoubleListReportResponse) new uk().qw(de(str2, adVar), new fe.mmm.qw.nn.qw.qw.pf.qw(DoubleListReportResponse.class)));
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
            DoubleListReportResponse doubleListReportResponse = (DoubleListReportResponse) ((Either.Right) either).getValue();
            return doubleListReportResponse == null ? fe.mmm.qw.nn.de.i.qw.ad() : new Either.Right(doubleListReportResponse);
        } else if (either instanceof Either.Left) {
            return either;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final Either<Pair<String, Integer>, DoubleListReportResponse> o(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return i(context, "album");
    }
}
