package fe.vvv.ad.ad;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import com.baidu.wallet.utils.compress.a;
import fe.vvv.ad.th.de;
import fe.vvv.ad.th.fe;
import fe.vvv.ad.th.qw;
import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ad {
    @NotNull
    public final int[] ad(int i2, boolean z) {
        int i3;
        int i4;
        if (i2 >= 3) {
            i3 = fe.pf() | fe.m1020if();
        } else {
            i3 = fe.pf();
        }
        int[] iArr = new int[15];
        iArr[0] = fe.when();
        iArr[1] = 8;
        iArr[2] = fe.rg();
        iArr[3] = 8;
        iArr[4] = fe.ad();
        iArr[5] = 8;
        iArr[6] = fe.qw();
        iArr[7] = 8;
        iArr[8] = fe.vvv();
        iArr[9] = fe.ddd() | fe.m1021switch();
        iArr[10] = fe.ppp();
        iArr[11] = i3;
        if (z != 0) {
            i4 = a.a;
        } else {
            i4 = fe.yj();
        }
        iArr[12] = i4;
        iArr[13] = z;
        iArr[14] = fe.yj();
        return iArr;
    }

    @Nullable
    public final qw qw(@NotNull de deVar, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(deVar, "display");
        qw[] qwVarArr = new qw[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(deVar.qw(), ad(i2, z), 0, eGLConfigArr, 0, 1, new int[1], 0);
        if (eglChooseConfig) {
            Iterator it = ArraysKt___ArraysKt.getIndices((T[]) qwVarArr).iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                EGLConfig eGLConfig = eGLConfigArr[nextInt];
                qwVarArr[nextInt] = eGLConfig != null ? new qw(eGLConfig) : null;
            }
        }
        if (eglChooseConfig) {
            return qwVarArr[0];
        }
        "Unable to find RGB8888 / " + i2 + " EGLConfig";
        return null;
    }
}
