package fe.mmm.qw.tt.ad.when;

import com.tera.scan.model.CropInfo;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class e {
    public static /* synthetic */ HashMap ad(CropInfo cropInfo, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return qw(cropInfo, z);
    }

    @NotNull
    public static final HashMap<String, Object> qw(@NotNull CropInfo cropInfo, boolean z) {
        Intrinsics.checkNotNullParameter(cropInfo, "info");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("source_path", cropInfo.getSrc());
        if (cropInfo.getPoints().isEmpty() || z) {
            return hashMap;
        }
        hashMap.put("crop_path", cropInfo.getDest());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("top_left_x", Float.valueOf(cropInfo.getPoints().get(0).getDx()));
        hashMap2.put("top_left_y", Float.valueOf(cropInfo.getPoints().get(0).getDy()));
        hashMap2.put("bottom_left_x", Float.valueOf(cropInfo.getPoints().get(1).getDx()));
        hashMap2.put("bottom_left_y", Float.valueOf(cropInfo.getPoints().get(1).getDy()));
        hashMap2.put("bottom_right_x", Float.valueOf(cropInfo.getPoints().get(2).getDx()));
        hashMap2.put("bottom_right_y", Float.valueOf(cropInfo.getPoints().get(2).getDy()));
        hashMap2.put("top_right_x", Float.valueOf(cropInfo.getPoints().get(3).getDx()));
        hashMap2.put("top_right_y", Float.valueOf(cropInfo.getPoints().get(3).getDy()));
        hashMap.put("points", hashMap2);
        hashMap.put("src_width", Float.valueOf(cropInfo.getWidth()));
        hashMap.put("src_height", Float.valueOf(cropInfo.getHeight()));
        return hashMap;
    }
}
