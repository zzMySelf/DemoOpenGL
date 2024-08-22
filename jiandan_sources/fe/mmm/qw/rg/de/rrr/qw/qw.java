package fe.mmm.qw.rg.de.rrr.qw;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.mars.kotlin.extension.Tag;
import com.mars.kotlin.extension.fp.Either;
import com.mars.kotlin.service.Extra;
import com.mars.kotlin.service.extension.ResultReceiverKt;
import com.tera.scan.business.textrecognition.translate.model.AiTranslateResponse;
import fe.mmm.qw.j.yj;
import fe.mmm.qw.nn.qw.qw.i;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Tag("AiTranslateTextJob")
public final class qw extends fe.mmm.qw.a.uk.qw {
    @NotNull
    public final String ddd;
    @NotNull
    public final Context ggg;
    @NotNull
    public final ResultReceiver mmm;
    @NotNull
    public final String nn;
    @NotNull
    public final String vvv;
    @Nullable
    public final String xxx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qw(@NotNull Context context, @NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull ResultReceiver resultReceiver) {
        super("AiTranslateTextJob");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appKey");
        Intrinsics.checkNotNullParameter(str3, "toLanguage");
        Intrinsics.checkNotNullParameter(str4, "jsonList");
        Intrinsics.checkNotNullParameter(resultReceiver, "resultReceiver");
        this.ggg = context;
        this.vvv = str;
        this.xxx = str2;
        this.ddd = str3;
        this.nn = str4;
        this.mmm = resultReceiver;
    }

    public void ppp() {
        Object obj;
        if (!i.rg(this.ggg)) {
            ResultReceiverKt.networkWrong(this.mmm);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(yj.de(this.nn));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        JSONArray jSONArray = (JSONArray) obj;
        if (jSONArray == null) {
            ResultReceiverKt.wrong(this.mmm);
            return;
        }
        Either<Pair<String, Integer>, AiTranslateResponse> i2 = new fe.mmm.qw.rg.de.rrr.ad.qw().i(this.vvv, this.xxx, this.ddd, jSONArray);
        if (i2 instanceof Either.Right) {
            Either.Right right = (Either.Right) i2;
            if (((AiTranslateResponse) right.getValue()).errno == 0) {
                ResultReceiver resultReceiver = this.mmm;
                Bundle bundle = new Bundle();
                bundle.putParcelable(Extra.RESULT, (Parcelable) right.getValue());
                Unit unit = Unit.INSTANCE;
                resultReceiver.send(1, bundle);
                return;
            }
        }
        ResultReceiverKt.wrong(this.mmm);
    }
}
