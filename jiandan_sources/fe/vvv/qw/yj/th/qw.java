package fe.vvv.qw.yj.th;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.controls.Control;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import java.util.HashMap;
import java.util.Map;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static final Map<Flash, String> f9266ad = new HashMap();

    /* renamed from: de  reason: collision with root package name */
    public static final Map<WhiteBalance, String> f9267de = new HashMap();

    /* renamed from: fe  reason: collision with root package name */
    public static final Map<Facing, Integer> f9268fe = new HashMap();
    public static qw qw;

    /* renamed from: rg  reason: collision with root package name */
    public static final Map<Hdr, String> f9269rg = new HashMap();

    static {
        f9266ad.put(Flash.OFF, "off");
        f9266ad.put(Flash.ON, "on");
        f9266ad.put(Flash.AUTO, "auto");
        f9266ad.put(Flash.TORCH, "torch");
        f9268fe.put(Facing.BACK, 0);
        f9268fe.put(Facing.FRONT, 1);
        f9267de.put(WhiteBalance.AUTO, "auto");
        f9267de.put(WhiteBalance.INCANDESCENT, "incandescent");
        f9267de.put(WhiteBalance.FLUORESCENT, "fluorescent");
        f9267de.put(WhiteBalance.DAYLIGHT, "daylight");
        f9267de.put(WhiteBalance.CLOUDY, "cloudy-daylight");
        f9269rg.put(Hdr.OFF, "auto");
        if (Build.VERSION.SDK_INT >= 17) {
            f9269rg.put(Hdr.ON, "hdr");
        } else {
            f9269rg.put(Hdr.ON, "hdr");
        }
    }

    @NonNull
    public static qw qw() {
        if (qw == null) {
            qw = new qw();
        }
        return qw;
    }

    public int ad(@NonNull Facing facing) {
        return f9268fe.get(facing).intValue();
    }

    @NonNull
    public String de(@NonNull Flash flash) {
        return f9266ad.get(flash);
    }

    @NonNull
    public String fe(@NonNull Hdr hdr) {
        return f9269rg.get(hdr);
    }

    @Nullable
    public Hdr i(@NonNull String str) {
        return (Hdr) th(f9269rg, str);
    }

    @Nullable
    public WhiteBalance o(@NonNull String str) {
        return (WhiteBalance) th(f9267de, str);
    }

    @NonNull
    public String rg(@NonNull WhiteBalance whiteBalance) {
        return f9267de.get(whiteBalance);
    }

    @Nullable
    public final <C extends Control, T> C th(@NonNull Map<C, T> map, @NonNull T t) {
        for (C c : map.keySet()) {
            if (t.equals(map.get(c))) {
                return c;
            }
        }
        return null;
    }

    @Nullable
    public Flash uk(@NonNull String str) {
        return (Flash) th(f9266ad, str);
    }

    @Nullable
    public Facing yj(int i2) {
        return (Facing) th(f9268fe, Integer.valueOf(i2));
    }
}
