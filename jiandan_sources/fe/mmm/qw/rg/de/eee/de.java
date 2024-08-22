package fe.mmm.qw.rg.de.eee;

import android.content.Context;
import com.baidu.aiscan.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

public final class de {
    @NotNull
    public static final de qw = new de();

    @NotNull
    public final String qw(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "type");
        if (StringsKt__StringsJVMKt.startsWith$default(str, "en", false, 2, (Object) null)) {
            String string = context.getString(R.string.lan_english);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.lan_english)");
            return string;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "zh", false, 2, (Object) null)) {
            String string2 = context.getString(R.string.lan_chinese);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.lan_chinese)");
            return string2;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "es", false, 2, (Object) null)) {
            String string3 = context.getString(R.string.lan_spanish);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.lan_spanish)");
            return string3;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "fr", false, 2, (Object) null)) {
            String string4 = context.getString(R.string.lan_french);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.lan_french)");
            return string4;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, fe.i.qw.th.de.de.f4491de, false, 2, (Object) null)) {
            String string5 = context.getString(R.string.lan_german);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.string.lan_german)");
            return string5;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "ru", false, 2, (Object) null)) {
            String string6 = context.getString(R.string.lan_russian);
            Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.string.lan_russian)");
            return string6;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "ar", false, 2, (Object) null)) {
            String string7 = context.getString(R.string.lan_arabic);
            Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.string.lan_arabic)");
            return string7;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "pt", false, 2, (Object) null)) {
            String string8 = context.getString(R.string.lan_portuguese);
            Intrinsics.checkNotNullExpressionValue(string8, "context.getString(R.string.lan_portuguese)");
            return string8;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "ja", false, 2, (Object) null)) {
            String string9 = context.getString(R.string.lan_japanese);
            Intrinsics.checkNotNullExpressionValue(string9, "context.getString(R.string.lan_japanese)");
            return string9;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "ko", false, 2, (Object) null)) {
            String string10 = context.getString(R.string.lan_korean);
            Intrinsics.checkNotNullExpressionValue(string10, "context.getString(R.string.lan_korean)");
            return string10;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "it", false, 2, (Object) null)) {
            String string11 = context.getString(R.string.lan_italian);
            Intrinsics.checkNotNullExpressionValue(string11, "context.getString(R.string.lan_italian)");
            return string11;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "id", false, 2, (Object) null)) {
            String string12 = context.getString(R.string.lan_indonesian);
            Intrinsics.checkNotNullExpressionValue(string12, "context.getString(R.string.lan_indonesian)");
            return string12;
        } else if (StringsKt__StringsJVMKt.startsWith$default(str, "tl", false, 2, (Object) null)) {
            String string13 = context.getString(R.string.lan_filipino);
            Intrinsics.checkNotNullExpressionValue(string13, "context.getString(R.string.lan_filipino)");
            return string13;
        } else if (!StringsKt__StringsJVMKt.startsWith$default(str, "vi", false, 2, (Object) null)) {
            return "";
        } else {
            String string14 = context.getString(R.string.lan_vietnamese);
            Intrinsics.checkNotNullExpressionValue(string14, "context.getString(R.string.lan_vietnamese)");
            return string14;
        }
    }
}
