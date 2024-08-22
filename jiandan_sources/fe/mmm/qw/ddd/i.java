package fe.mmm.qw.ddd;

import com.terascan.algo.Point;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class i {
    public static final double ad(@NotNull ArrayList<Point> arrayList) {
        ArrayList<Point> arrayList2 = arrayList;
        Intrinsics.checkNotNullParameter(arrayList2, "vertices");
        double sqrt = Math.sqrt((double) (((arrayList2.get(0).getX() - arrayList2.get(1).getX()) * (arrayList2.get(0).getX() - arrayList2.get(1).getX())) + ((arrayList2.get(0).getY() - arrayList2.get(1).getY()) * (arrayList2.get(0).getY() - arrayList2.get(1).getY()))));
        double sqrt2 = Math.sqrt((double) (((arrayList2.get(2).getX() - arrayList2.get(1).getX()) * (arrayList2.get(2).getX() - arrayList2.get(1).getX())) + ((arrayList2.get(2).getY() - arrayList2.get(1).getY()) * (arrayList2.get(2).getY() - arrayList2.get(1).getY()))));
        double sqrt3 = Math.sqrt((double) (((arrayList2.get(2).getX() - arrayList2.get(3).getX()) * (arrayList2.get(2).getX() - arrayList2.get(3).getX())) + ((arrayList2.get(2).getY() - arrayList2.get(3).getY()) * (arrayList2.get(2).getY() - arrayList2.get(3).getY()))));
        double sqrt4 = Math.sqrt((double) (((arrayList2.get(0).getX() - arrayList2.get(3).getX()) * (arrayList2.get(0).getX() - arrayList2.get(3).getX())) + ((arrayList2.get(0).getY() - arrayList2.get(3).getY()) * (arrayList2.get(0).getY() - arrayList2.get(3).getY()))));
        double sqrt5 = Math.sqrt((double) (((arrayList2.get(0).getX() - arrayList2.get(2).getX()) * (arrayList2.get(0).getX() - arrayList2.get(2).getX())) + ((arrayList2.get(0).getY() - arrayList2.get(2).getY()) * (arrayList2.get(0).getY() - arrayList2.get(2).getY()))));
        double d = (double) 2;
        double d2 = ((sqrt + sqrt2) + sqrt5) / d;
        double d3 = ((sqrt3 + sqrt4) + sqrt5) / d;
        return Math.sqrt((d2 - sqrt) * d2 * (d2 - sqrt2) * (d2 - sqrt5)) + Math.sqrt((d3 - sqrt3) * d3 * (d3 - sqrt4) * (d3 - sqrt5));
    }

    public static final float de(float f) {
        return f * f;
    }
}
