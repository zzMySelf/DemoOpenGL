package fe.mmm.qw.eee.de;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    public static final void ad(@NotNull Activity activity) {
        Object obj;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        try {
            Result.Companion companion = Result.Companion;
            View decorView = activity.getWindow().getDecorView();
            ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i2);
                    Intrinsics.checkNotNullExpressionValue(childAt, "viewGroup.getChildAt(index)");
                    if (Intrinsics.areEqual(childAt.getTag(), (Object) "permission_desc_tag")) {
                        viewGroup.removeView(childAt);
                        break;
                    }
                    i2++;
                }
                obj = Result.m1155constructorimpl(Unit.INSTANCE);
                Throwable r5 = Result.m1158exceptionOrNullimpl(obj);
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* JADX WARNING: type inference failed for: r6v2, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void qw(@org.jetbrains.annotations.NotNull android.app.Activity r5, @org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull java.lang.String r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "detail"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r5)
            r1 = 2131558691(0x7f0d0123, float:1.8742705E38)
            r2 = 0
            r3 = 0
            android.view.View r0 = r0.inflate(r1, r2, r3)
            java.lang.String r1 = "permission_desc_tag"
            r0.setTag(r1)
            r1 = 2131362236(0x7f0a01bc, float:1.8344247E38)
            android.view.View r1 = r0.findViewById(r1)
            r3 = 2131363062(0x7f0a04f6, float:1.8345922E38)
            android.view.View r3 = r0.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r4 = 2131363061(0x7f0a04f5, float:1.834592E38)
            android.view.View r4 = r0.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.setText(r6)
            r4.setText(r7)
            android.view.Window r6 = r5.getWindow()
            android.view.View r6 = r6.getDecorView()
            boolean r7 = r6 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x004f
            r2 = r6
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
        L_0x004f:
            if (r2 == 0) goto L_0x005b
            android.view.ViewGroup$LayoutParams r6 = new android.view.ViewGroup$LayoutParams
            r7 = -1
            r3 = -2
            r6.<init>(r7, r3)
            r2.addView(r0, r6)
        L_0x005b:
            r6 = 2130772029(0x7f01003d, float:1.7147165E38)
            android.view.animation.Animation r5 = android.view.animation.AnimationUtils.loadAnimation(r5, r6)
            r1.startAnimation(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.eee.de.qw.qw(android.app.Activity, java.lang.String, java.lang.String):void");
    }
}
