package fe.mmm.qw.f.ad.ad;

import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class qw {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public static final RenderScript f7765ad;
    @NotNull
    public static final qw qw = new qw();

    static {
        RenderScript create = RenderScript.create(fe.mmm.qw.f.qw.qw.qw());
        Intrinsics.checkNotNullExpressionValue(create, "create(UIKit.app)");
        f7765ad = create;
    }

    @NotNull
    public final Bitmap qw(@NotNull Bitmap bitmap, float f) {
        Intrinsics.checkNotNullParameter(bitmap, "src");
        try {
            Allocation createFromBitmap = Allocation.createFromBitmap(f7765ad, bitmap);
            Allocation createTyped = Allocation.createTyped(f7765ad, createFromBitmap.getType());
            ScriptIntrinsicBlur create = ScriptIntrinsicBlur.create(f7765ad, Element.U8_4(f7765ad));
            create.setRadius(f);
            create.setInput(createFromBitmap);
            create.forEach(createTyped);
            createTyped.copyTo(bitmap);
        } catch (Throwable th2) {
            fe.mmm.qw.f.ad.de.qw.qw.ad("UIBlur", "blur bitmap error", th2);
        }
        return bitmap;
    }
}
