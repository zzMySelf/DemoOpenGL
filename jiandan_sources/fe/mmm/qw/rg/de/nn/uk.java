package fe.mmm.qw.rg.de.nn;

import androidx.appcompat.widget.ActivityChooserModel;
import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import com.tera.scan.business.textrecognition.TextRecognitionResultActivity;
import fe.mmm.qw.rg.de.ddd.qw;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class uk extends fe {
    @NotNull
    public final String qw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public uk(@Nullable String str, @NotNull String str2) {
        super(str);
        Intrinsics.checkNotNullParameter(str2, "ubcSource");
        this.qw = str2;
    }

    public void qw(@NotNull TextRecognitionActivity textRecognitionActivity, @NotNull List<qw> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(textRecognitionActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(str, "lanType");
        String str2 = (String) CollectionsKt___CollectionsKt.firstOrNull(textRecognitionActivity.getImagePathList());
        if (str2 != null && (!list.isEmpty())) {
            textRecognitionActivity.startActivity(TextRecognitionResultActivity.Companion.qw(textRecognitionActivity, str2, ((qw) CollectionsKt___CollectionsKt.first(list)).ad(), str, this.qw));
        }
        textRecognitionActivity.finish();
    }
}
