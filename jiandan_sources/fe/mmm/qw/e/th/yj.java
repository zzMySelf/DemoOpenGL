package fe.mmm.qw.e.th;

import android.content.Context;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.common.param.ICommonParamOverlay;
import fe.fe.ddd.i.qw.qw;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.Nullable;

public final class yj implements ICommonParamOverlay {
    @Nullable
    public String getAppVersion() {
        Object obj;
        Context qw = qw.qw();
        if (qw == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(qw.getPackageManager().getPackageInfo(qw.getPackageName(), 0).versionName);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null) {
            return null;
        }
        List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{IStringUtil.CURRENT_PATH}, false, 0, 6, (Object) null);
        int size = split$default.size();
        if (4 == size) {
            return str;
        }
        if (size >= 4) {
            return CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt___CollectionsKt.take(split$default, 4), IStringUtil.CURRENT_PATH, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        for (int i2 = 0; i2 < 4 - size; i2++) {
            str = str + ".0";
        }
        return str;
    }
}
