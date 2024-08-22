package i.qw.x1;

import com.baidu.android.common.others.IStringUtil;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class f {
    public static final long ad(@NotNull String str, long j, long j2, long j3) {
        String fe2 = d.fe(str);
        if (fe2 == null) {
            return j;
        }
        Long longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(fe2);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            boolean z = false;
            if (j2 <= longValue && longValue <= j3) {
                z = true;
            }
            if (z) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + IStringUtil.TOP_PATH + j3 + ", but is '" + longValue + ExtendedMessageFormat.QUOTE).toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + fe2 + ExtendedMessageFormat.QUOTE).toString());
    }

    public static final boolean de(@NotNull String str, boolean z) {
        String fe2 = d.fe(str);
        return fe2 == null ? z : Boolean.parseBoolean(fe2);
    }

    public static /* synthetic */ int fe(String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return d.ad(str, i2, i3, i4);
    }

    public static final int qw(@NotNull String str, int i2, int i3, int i4) {
        return (int) d.de(str, (long) i2, (long) i3, (long) i4);
    }

    public static /* synthetic */ long rg(String str, long j, long j2, long j3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return d.de(str, j, j4, j3);
    }
}
