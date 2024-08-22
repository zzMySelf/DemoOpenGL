package fe.vvv.qw.p037if;

import android.annotation.SuppressLint;
import android.media.CamcorderProfile;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.NonNull;
import androidx.core.view.DisplayCompat;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.wallet.base.iddetect.utils.CameraUtilsForScan;
import com.otaliastudios.cameraview.CameraLogger;
import fe.vvv.qw.xxx.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* renamed from: fe.vvv.qw.if.qw  reason: invalid package */
public class qw {
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: ad  reason: collision with root package name */
    public static Map<ad, Integer> f9028ad;
    public static final CameraLogger qw = CameraLogger.qw(qw.class.getSimpleName());

    /* renamed from: fe.vvv.qw.if.qw$qw  reason: collision with other inner class name */
    public class C0312qw implements Comparator<ad> {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ long f9029ad;

        public C0312qw(long j) {
            this.f9029ad = j;
        }

        /* renamed from: qw */
        public int compare(ad adVar, ad adVar2) {
            int i2 = (Math.abs(((long) (adVar.rg() * adVar.fe())) - this.f9029ad) > Math.abs(((long) (adVar2.rg() * adVar2.fe())) - this.f9029ad) ? 1 : (Math.abs(((long) (adVar.rg() * adVar.fe())) - this.f9029ad) == Math.abs(((long) (adVar2.rg() * adVar2.fe())) - this.f9029ad) ? 0 : -1));
            if (i2 < 0) {
                return -1;
            }
            return i2 == 0 ? 0 : 1;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f9028ad = hashMap;
        hashMap.put(new ad(176, 144), 2);
        f9028ad.put(new ad(MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP, AuthorityState.STATE_ERROR_NETWORK), 7);
        f9028ad.put(new ad(352, 288), 3);
        f9028ad.put(new ad(CameraUtilsForScan.MAX_SIZE_HEIGHT, 480), 4);
        f9028ad.put(new ad(1280, CameraUtilsForScan.MAX_SIZE_HEIGHT), 5);
        f9028ad.put(new ad(1920, 1080), 6);
        if (Build.VERSION.SDK_INT >= 21) {
            f9028ad.put(new ad(DisplayCompat.DISPLAY_SIZE_4K_WIDTH, DisplayCompat.DISPLAY_SIZE_4K_HEIGHT), 8);
        }
    }

    @NonNull
    public static CamcorderProfile ad(@NonNull String str, @NonNull ad adVar) {
        try {
            return qw(Integer.parseInt(str), adVar);
        } catch (NumberFormatException unused) {
            qw.i("NumberFormatException for Camera2 id:", str);
            return CamcorderProfile.get(0);
        }
    }

    @NonNull
    public static CamcorderProfile qw(int i2, @NonNull ad adVar) {
        long rg2 = ((long) adVar.rg()) * ((long) adVar.fe());
        ArrayList arrayList = new ArrayList(f9028ad.keySet());
        Collections.sort(arrayList, new C0312qw(rg2));
        while (arrayList.size() > 0) {
            int intValue = f9028ad.get((ad) arrayList.remove(0)).intValue();
            if (CamcorderProfile.hasProfile(i2, intValue)) {
                return CamcorderProfile.get(i2, intValue);
            }
        }
        return CamcorderProfile.get(i2, 0);
    }
}
