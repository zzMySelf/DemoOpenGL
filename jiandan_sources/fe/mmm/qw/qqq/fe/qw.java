package fe.mmm.qw.qqq.fe;

import android.content.Context;
import com.baidu.aiscan.R;
import com.baidu.apollon.utils.ResUtils;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import com.tera.scan.pdfedit.component.provider.IPdfEditCallback;
import com.tera.scan.pdfedit.core.SizeMode;
import fe.when.ad.aaa;
import fe.when.ad.f.c2;
import fe.when.ad.i;
import fe.when.ad.th;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw {
    @NotNull
    public final ad qw;

    public qw(@NotNull ad adVar) {
        Intrinsics.checkNotNullParameter(adVar, ResUtils.d);
        this.qw = adVar;
    }

    public final void ad(th thVar, i iVar, i iVar2, ad adVar) {
        float f;
        boolean z = true;
        thVar.de(adVar.qw(iVar.ggg() < iVar.rrr()));
        if (iVar2 != null) {
            f = iVar2.S();
            iVar2.u0((thVar.pf().rrr() - iVar2.T()) - thVar.ggg(), adVar.ad());
        } else {
            f = 0.0f;
        }
        iVar.t0((thVar.pf().rrr() - thVar.when()) - thVar.ggg(), ((thVar.pf().ggg() - thVar.ddd()) - thVar.i()) - f);
        float f2 = (float) 2;
        float rrr = (thVar.pf().rrr() - iVar.T()) / f2;
        if (f != 0.0f) {
            z = false;
        }
        iVar.u0(rrr, z ? (thVar.pf().ggg() - iVar.S()) / f2 : thVar.i() + f);
    }

    public final void de(th thVar, i iVar, i iVar2, ad adVar) {
        aaa aaa;
        float ad2 = adVar.ad();
        if (iVar2 == null) {
            if (iVar.rrr() > 14400.0f || iVar.ggg() > 14400.0f) {
                float f = (float) 14400;
                float min = Math.min(f / iVar.rrr(), f / iVar.ggg());
                iVar.t0(iVar.rrr() * min, iVar.ggg() * min);
            }
            aaa = adVar.fe(iVar.T(), iVar.S());
        } else {
            float de2 = adVar.de() + adVar.rg();
            float yj2 = adVar.yj() + adVar.ad() + iVar2.S() + ad2;
            float f2 = (float) 14400;
            float f3 = f2 - de2;
            if (iVar.rrr() > f3 || iVar.ggg() > f2 - yj2) {
                float min2 = Math.min(f3 / iVar.rrr(), (f2 - yj2) / iVar.ggg());
                iVar.t0(iVar.rrr() * min2, iVar.ggg() * min2);
            }
            aaa = adVar.fe(iVar.T() + de2, iVar.S() + yj2);
        }
        thVar.de(aaa);
        iVar.u0(adVar.de(), adVar.ad() + (iVar2 != null ? iVar2.S() : 0.0f) + ad2);
        if (iVar2 != null) {
            iVar2.u0((iVar.T() - iVar2.T()) + adVar.de(), adVar.ad());
        }
    }

    public final void fe(th thVar, i iVar, i iVar2, ad adVar) {
        if (adVar.th() == SizeMode.A4) {
            ad(thVar, iVar, iVar2, adVar);
        } else {
            de(thVar, iVar, iVar2, adVar);
        }
    }

    @Nullable
    public final String qw(@NotNull Context context, @NotNull List<String> list, @NotNull String str, boolean z, @NotNull IPdfEditCallback iPdfEditCallback) {
        byte[] bArr;
        String str2;
        byte[] bArr2;
        Either either;
        Throwable th2;
        List<String> list2 = list;
        String str3 = str;
        IPdfEditCallback iPdfEditCallback2 = iPdfEditCallback;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list2, "pics");
        Intrinsics.checkNotNullParameter(str3, "targetPdfPath");
        Intrinsics.checkNotNullParameter(iPdfEditCallback2, "callback");
        long currentTimeMillis = System.currentTimeMillis();
        i iVar = null;
        if (z) {
            InputStream open = context.getAssets().open("ai_scan_watermark.png");
            try {
                Intrinsics.checkNotNullExpressionValue(open, "it");
                byte[] readBytes = ByteStreamsKt.readBytes(open);
                try {
                    CloseableKt.closeFinally(open, (Throwable) null);
                    either = ExpectKt.success(readBytes);
                } catch (Throwable th3) {
                    LoggerKt.e$default(th3, (Object) null, 1, (Object) null);
                    either = ExpectKt.failure(th3);
                }
                bArr = (byte[]) ExpectKt.successOrNull(either);
            } catch (Throwable th4) {
                Throwable th5 = th4;
                CloseableKt.closeFinally(open, th2);
                throw th5;
            }
        } else {
            bArr = null;
        }
        th thVar = new th();
        thVar.fe(this.qw.de(), this.qw.yj(), this.qw.rg(), this.qw.ad());
        try {
            c2.D(thVar, new FileOutputStream(new File(str3)));
            thVar.open();
            int i2 = 0;
            int size = list.size();
            while (i2 < size) {
                i J = i.J(list2.get(i2));
                i M = bArr != null ? i.M(bArr) : iVar;
                if (M != null) {
                    bArr2 = bArr;
                    M.t0(((float) context.getResources().getDimensionPixelSize(R.dimen.pdf_logo_width)) * 1.0f, ((float) context.getResources().getDimensionPixelSize(R.dimen.pdf_logo_height)) * 1.0f);
                } else {
                    bArr2 = bArr;
                }
                fe(thVar, J, M, this.qw);
                thVar.qw();
                thVar.ad(J);
                if (M != null) {
                    thVar.ad(M);
                }
                fe.mmm.qw.i.qw.ad("PdfCreator", "toPDF >> 完成一个图片的写入 >> " + list2.get(i2));
                i2++;
                iPdfEditCallback2.qw((i2 * 100) / list.size());
                bArr = bArr2;
                iVar = null;
            }
            thVar.close();
            iPdfEditCallback2.qw(100);
            str2 = str3;
        } catch (Exception unused) {
            str2 = "";
            thVar.close();
            iPdfEditCallback2.qw(100);
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        fe.mmm.qw.i.qw.ad("PdfCreator", "toPDF >> 完成 PDF 合并 >>  整体耗时:" + (currentTimeMillis2 - currentTimeMillis));
        return str2;
    }
}
