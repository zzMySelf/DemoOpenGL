package fe.mmm.qw.rg.de.rrr.ad;

import com.alipay.sdk.m.l.b;
import com.google.gson.JsonParseException;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.business.textrecognition.translate.model.AiTranslateResponse;
import com.tera.scan.network.network.exception.RemoteException;
import fe.mmm.qw.nn.de.ad;
import fe.mmm.qw.nn.qw.qw.fe;
import fe.mmm.qw.nn.qw.qw.uk;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Tag("AiTranslateTextApi")
public final class qw extends ad {
    public qw() {
        super(fe.mmm.qw.p030switch.rg.qw.qw().getBduss(), fe.mmm.qw.p030switch.rg.qw.qw().getUid(), new fe());
        yj(fe.mmm.qw.nn.rg.ad.qw(this.f8092rg));
    }

    @NotNull
    public final Either<Pair<String, Integer>, AiTranslateResponse> i(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull JSONArray jSONArray) {
        Either<Pair<String, Integer>, AiTranslateResponse> either;
        Either.Left<Pair<String, Integer>> left;
        Intrinsics.checkNotNullParameter(str, "appKey");
        Intrinsics.checkNotNullParameter(str3, "toLanguage");
        Intrinsics.checkNotNullParameter(jSONArray, "list");
        String str4 = "https://" + fe.mmm.qw.rg.ad.ad.fe() + "/llm/translate";
        fe.mmm.qw.nn.de.o.qw qwVar = new fe.mmm.qw.nn.de.o.qw();
        qwVar.ad(b.h, str);
        if (str2 == null) {
            str2 = "";
        }
        qwVar.ad("from_language", str2);
        qwVar.ad("to_language", str3);
        qwVar.yj("list", jSONArray);
        try {
            either = ExpectKt.success((AiTranslateResponse) new uk().qw(de(str4, qwVar), new fe.mmm.qw.nn.qw.qw.pf.qw(AiTranslateResponse.class)));
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
            AiTranslateResponse aiTranslateResponse = (AiTranslateResponse) ((Either.Right) either).getValue();
            return aiTranslateResponse == null ? fe.mmm.qw.nn.de.i.qw.ad() : new Either.Right(aiTranslateResponse);
        } else if (either instanceof Either.Left) {
            return either;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
