package i.qw;

import com.baidu.android.common.others.lang.StringUtil;
import i.qw.x1.ggg;
import i.qw.x1.when;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Incomplete;
import org.jetbrains.annotations.NotNull;

public final class a1 extends when implements Incomplete {
    public boolean isActive() {
        return true;
    }

    @NotNull
    public a1 qw() {
        return this;
    }

    @NotNull
    public final String t(@NotNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        boolean z = true;
        for (ggg ggg = (ggg) e(); !Intrinsics.areEqual((Object) ggg, (Object) this); ggg = ggg.f()) {
            if (ggg instanceof u0) {
                u0 u0Var = (u0) ggg;
                if (z) {
                    z = false;
                } else {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(u0Var);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public String toString() {
        return k.de() ? t("Active") : super.toString();
    }
}
