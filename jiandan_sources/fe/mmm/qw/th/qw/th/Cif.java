package fe.mmm.qw.th.qw.th;

import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.th.qw.th.if  reason: invalid class name */
public final class Cif {
    public static final void qw(@NotNull TextView textView, @Nullable String str, float f) {
        TextView textView2 = textView;
        Intrinsics.checkNotNullParameter(textView2, "<this>");
        if (str == null || str.length() == 0) {
            textView.setText(str);
            return;
        }
        ArrayList<Number> arrayList = new ArrayList<>();
        String replace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, "\n\r", StringUtils.LF, false, 4, (Object) null), StringUtils.LF, "\n\r", false, 4, (Object) null);
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) replace$default, "\n\r", 0, false, 4, (Object) null);
        if (indexOf$default != -1) {
            arrayList.add(Integer.valueOf(indexOf$default));
            while (indexOf$default != -1) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) replace$default, "\n\r", indexOf$default + 2, false, 4, (Object) null);
                if (indexOf$default != -1) {
                    arrayList.add(Integer.valueOf(indexOf$default));
                }
            }
        }
        if (arrayList.size() == 0) {
            textView2.setText(replace$default);
            return;
        }
        SpannableString spannableString = new SpannableString(replace$default);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setBounds(0, 0, 1, ((int) (((float) (textView.getLineHeight() - ((int) textView.getLineSpacingExtra()))) / textView.getLineSpacingMultiplier())) + MathKt__MathJVMKt.roundToInt(uk.qw().getResources().getDisplayMetrics().density * f));
        for (Number intValue : arrayList) {
            int intValue2 = intValue.intValue();
            spannableString.setSpan(new ImageSpan(colorDrawable), intValue2 + 1, intValue2 + 2, 33);
        }
        textView2.setText(spannableString);
    }
}
