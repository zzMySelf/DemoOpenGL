package fe.mmm.qw.aaa.qw;

import android.content.Context;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfPasswordException;
import com.shockwave.pdfium.PdfiumCore;
import fe.p013if.ad.qw.p014if.de;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    @NotNull
    public static final qw qw = new qw();

    public final boolean qw(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "filePath");
        try {
            PdfiumCore pdfiumCore = new PdfiumCore(context);
            PdfDocument qw2 = new de(new File(str)).qw(context, pdfiumCore, (String) null);
            try {
                Result.Companion companion = Result.Companion;
                if (qw2 != null) {
                    pdfiumCore.closeDocument(qw2);
                }
                Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            return false;
            return true;
            return false;
            throw th;
        } catch (PdfPasswordException e) {
            e.printStackTrace();
            Result.Companion companion3 = Result.Companion;
            Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Exception e2) {
            try {
                e2.printStackTrace();
                Result.Companion companion4 = Result.Companion;
                Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion5 = Result.Companion;
                Result.m1155constructorimpl(ResultKt.createFailure(th3));
            }
        } catch (Throwable th4) {
            Result.Companion companion6 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th4));
        }
    }
}
