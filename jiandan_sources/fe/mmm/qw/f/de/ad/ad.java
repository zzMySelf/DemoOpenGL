package fe.mmm.qw.f.de.ad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.tera.scan.ui.view.helper.UIBaseHelper;
import com.tera.scan.ui.view.helper.UIHelper;
import fe.mmm.qw.f.qw;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ad<T extends ViewGroup> extends UIBaseHelper<T> {
    public boolean h0;
    @NotNull
    public final Paint i0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ad(@NotNull Context context, @NotNull T t) {
        super(context, t);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(t, "uiView");
        Paint paint = new Paint();
        this.i0 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.i0.setAntiAlias(true);
    }

    public void rg(@Nullable Canvas canvas) {
        UIBaseHelper helper;
        super.rg(canvas);
        if (this.h0 && canvas != null) {
            for (View next : ViewGroupKt.getChildren((ViewGroup) o())) {
                UIHelper uIHelper = next instanceof UIHelper ? (UIHelper) next : null;
                if (!(uIHelper == null || (helper = uIHelper.getHelper()) == null)) {
                    helper.th(canvas, this.i0);
                }
            }
        }
    }

    public final void s(boolean z) {
        this.h0 = z;
        if (z && !qw.qw.ad()) {
            ((ViewGroup) o()).setLayerType(z ? 1 : 2, (Paint) null);
        }
    }
}
