package fe.mmm.qw.tt.ad.when;

import android.content.Context;
import android.widget.TextView;
import com.tera.scan.scanner.ocr.control.ScanIdCardsTakingControl;
import com.tera.scan.scanner.ocr.widget.ScanIdCardsFrameView;
import fe.mmm.qw.tt.ad.aaa.ad;
import fe.mmm.qw.tt.ad.aaa.de;
import fe.mmm.qw.tt.ad.aaa.qw;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@JvmName(name = "ScanIdCardsTakingControlFlavor")
public final class f {
    public static final void ad(ScanIdCardsTakingControl scanIdCardsTakingControl) {
        TextView rrr = scanIdCardsTakingControl.rrr();
        if (rrr != null) {
            rrr.setVisibility(8);
        }
        TextView a = scanIdCardsTakingControl.a();
        if (a != null) {
            a.setVisibility(8);
        }
        TextView tt = scanIdCardsTakingControl.tt();
        if (tt != null) {
            tt.setVisibility(8);
        }
        Context applicationContext = scanIdCardsTakingControl.ggg().getApplicationContext();
        if (applicationContext != null) {
            List listOf = CollectionsKt__CollectionsJVMKt.listOf(new qw(applicationContext, scanIdCardsTakingControl.mmm() == 0 ? scanIdCardsTakingControl.ddd().isEmpty() : scanIdCardsTakingControl.aaa() == 0));
            ScanIdCardsFrameView b = scanIdCardsTakingControl.b();
            if (b != null) {
                b.setDecorations$scanner_aiscanConfigRelease(listOf);
            }
        }
    }

    public static final void de(ScanIdCardsTakingControl scanIdCardsTakingControl) {
        TextView rrr = scanIdCardsTakingControl.rrr();
        if (rrr != null) {
            rrr.setVisibility(8);
        }
        TextView a = scanIdCardsTakingControl.a();
        if (a != null) {
            a.setVisibility(8);
        }
        TextView tt = scanIdCardsTakingControl.tt();
        if (tt != null) {
            tt.setVisibility(8);
        }
        Context applicationContext = scanIdCardsTakingControl.ggg().getApplicationContext();
        if (applicationContext != null) {
            List listOf = CollectionsKt__CollectionsJVMKt.listOf(new ad(applicationContext));
            ScanIdCardsFrameView b = scanIdCardsTakingControl.b();
            if (b != null) {
                b.setDecorations$scanner_aiscanConfigRelease(listOf);
            }
        }
    }

    public static final void fe(ScanIdCardsTakingControl scanIdCardsTakingControl) {
        TextView a = scanIdCardsTakingControl.a();
        if (a != null) {
            a.setVisibility(8);
        }
        TextView tt = scanIdCardsTakingControl.tt();
        if (tt != null) {
            tt.setVisibility(8);
        }
        TextView rrr = scanIdCardsTakingControl.rrr();
        if (rrr != null) {
            rrr.setVisibility(8);
        }
        Context applicationContext = scanIdCardsTakingControl.ggg().getApplicationContext();
        if (applicationContext != null) {
            List listOf = CollectionsKt__CollectionsJVMKt.listOf(new de(applicationContext));
            ScanIdCardsFrameView b = scanIdCardsTakingControl.b();
            if (b != null) {
                b.setDecorations$scanner_aiscanConfigRelease(listOf);
            }
        }
    }

    public static final void qw(@NotNull ScanIdCardsTakingControl scanIdCardsTakingControl) {
        Intrinsics.checkNotNullParameter(scanIdCardsTakingControl, "<this>");
        int vvv = scanIdCardsTakingControl.vvv();
        if (vvv == 1) {
            ad(scanIdCardsTakingControl);
        } else if (vvv == 2) {
            de(scanIdCardsTakingControl);
        } else if (vvv == 6) {
            fe(scanIdCardsTakingControl);
        }
    }
}
