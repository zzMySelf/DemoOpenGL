package fe.vvv.qw.yj.rg;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import fe.vvv.qw.yj.fe.de;

@RequiresApi(21)
public abstract class qw extends de {
    public abstract boolean ggg(@NonNull ActionHolder actionHolder);

    /* renamed from: switch  reason: not valid java name */
    public final void m1055switch(@NonNull ActionHolder actionHolder) {
        super.m1047switch(actionHolder);
        boolean vvv = vvv(actionHolder);
        if (!ggg(actionHolder) || vvv) {
            ppp(Integer.MAX_VALUE);
        } else {
            xxx(actionHolder);
        }
    }

    public abstract boolean vvv(@NonNull ActionHolder actionHolder);

    public abstract void xxx(@NonNull ActionHolder actionHolder);
}
