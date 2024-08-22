package fe.mmm.qw.qqq.th;

import android.content.Context;
import com.tera.scan.flutter.route.IPageHandler;
import com.tera.scan.pdfedit.util.PdfCreateWatermarkPageHandler;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

public final class qw implements IPageHandler {
    public boolean qw(@NotNull Context context, @NotNull String str, @NotNull Map<String, Object> map, int i2) {
        String str2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(map, "params");
        String str3 = null;
        if (!StringsKt__StringsJVMKt.startsWith$default(str, "native://", false, 2, (Object) null) || !StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "native://pdfWatermarkFileCreate", false, 2, (Object) null)) {
            return false;
        }
        PdfCreateWatermarkPageHandler pdfCreateWatermarkPageHandler = PdfCreateWatermarkPageHandler.qw;
        Object obj = map.get("path");
        String str4 = obj instanceof String ? (String) obj : null;
        String str5 = str4 == null ? "" : str4;
        Object obj2 = map.get("text");
        String str6 = obj2 instanceof String ? (String) obj2 : null;
        if (str6 == null) {
            str2 = "";
        } else {
            str2 = str6;
        }
        Object obj3 = map.get("textSize");
        Double d = obj3 instanceof Double ? (Double) obj3 : null;
        Double valueOf = Double.valueOf(d != null ? d.doubleValue() : 16.0d);
        Object obj4 = map.get("textSizeScale");
        Double d2 = obj4 instanceof Double ? (Double) obj4 : null;
        Double valueOf2 = Double.valueOf(d2 != null ? d2.doubleValue() : 1.0d);
        Object obj5 = map.get("textTransparency");
        Double d3 = obj5 instanceof Double ? (Double) obj5 : null;
        Double valueOf3 = Double.valueOf(d3 != null ? d3.doubleValue() : 0.2d);
        Object obj6 = map.get("textColor");
        if (obj6 instanceof String) {
            str3 = (String) obj6;
        }
        pdfCreateWatermarkPageHandler.yj(context, str5, str2, valueOf, valueOf2, valueOf3, str3 == null ? "000000" : str3);
        return true;
    }
}
