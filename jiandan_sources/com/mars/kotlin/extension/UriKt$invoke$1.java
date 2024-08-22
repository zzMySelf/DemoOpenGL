package com.mars.kotlin.extension;

import android.net.Uri;
import com.baidu.wallet.paysdk.datamodel.Bank;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "value", "", "invoke"}, k = 3, mv = {1, 4, 0}, pn = "", xi = 0, xs = "")
public final class UriKt$invoke$1 extends Lambda implements Function1<Object, Uri> {
    public final /* synthetic */ String $term;
    public final /* synthetic */ Uri $this_invoke;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UriKt$invoke$1(Uri uri, String str) {
        super(1);
        this.$this_invoke = uri;
        this.$term = str;
    }

    public final Uri invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        String obj2 = obj.toString();
        if (Intrinsics.areEqual((Object) Bank.HOT_BANK_LETTER, (Object) this.$term)) {
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= obj2.length()) {
                    z = true;
                    break;
                } else if (!Character.isDigit(obj2.charAt(i2))) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                LoggerKt.e$default("# must be digit", (Object) null, 1, (Object) null);
            }
        }
        String uri = this.$this_invoke.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString()");
        String str = this.$term;
        String encode = Uri.encode(obj2);
        Intrinsics.checkNotNullExpressionValue(encode, "Uri.encode(valueString)");
        Uri parse = Uri.parse(StringsKt__StringsJVMKt.replaceFirst$default(uri, str, encode, false, 4, (Object) null));
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(toString().rep…Uri.encode(valueString)))");
        return parse;
    }
}
