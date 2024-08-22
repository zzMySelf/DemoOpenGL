package nl.dionsegijn.konfetti.xml;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl.dionsegijn.konfetti.core.models.CoreImage;
import nl.dionsegijn.konfetti.core.models.ReferenceImage;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.xml.image.ImageStore;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"draw", "", "Lnl/dionsegijn/konfetti/core/models/Shape;", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "size", "", "imageStore", "Lnl/dionsegijn/konfetti/xml/image/ImageStore;", "lib-ugc-base_debug"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DrawShapes.kt */
public final class DrawShapesKt {
    public static final void draw(Shape $this$draw, Canvas canvas, Paint paint, float size, ImageStore imageStore) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter($this$draw, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(imageStore, "imageStore");
        if (Intrinsics.areEqual((Object) $this$draw, (Object) Shape.Square.INSTANCE)) {
            canvas.drawRect(0.0f, 0.0f, size, size, paint);
        } else if (Intrinsics.areEqual((Object) $this$draw, (Object) Shape.Circle.INSTANCE)) {
            Shape.Circle.INSTANCE.getRect().set(0.0f, 0.0f, size, size);
            canvas.drawOval(new RectF(Shape.Circle.INSTANCE.getRect().getX(), Shape.Circle.INSTANCE.getRect().getY(), Shape.Circle.INSTANCE.getRect().getWidth(), Shape.Circle.INSTANCE.getRect().getHeight()), paint);
        } else if ($this$draw instanceof Shape.Rectangle) {
            float height = ((Shape.Rectangle) $this$draw).getHeightRatio() * size;
            float top = (size - height) / 2.0f;
            canvas.drawRect(0.0f, top, size, top + height, paint);
        } else if ($this$draw instanceof Shape.DrawableShape) {
            CoreImage referenceImage = ((Shape.DrawableShape) $this$draw).getImage();
            if ((referenceImage instanceof ReferenceImage) && (drawable = imageStore.getImage(((ReferenceImage) referenceImage).getReference())) != null) {
                if (((Shape.DrawableShape) $this$draw).getTint()) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        drawable.setColorFilter(new BlendModeColorFilter(paint.getColor(), BlendMode.SRC_IN));
                    } else {
                        drawable.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                    }
                } else if (((Shape.DrawableShape) $this$draw).getApplyAlpha()) {
                    drawable.setAlpha(paint.getAlpha());
                }
                int height2 = (int) (((Shape.DrawableShape) $this$draw).getHeightRatio() * size);
                int top2 = (int) ((size - ((float) height2)) / 2.0f);
                drawable.setBounds(0, top2, (int) size, top2 + height2);
                drawable.draw(canvas);
            }
        }
    }
}
