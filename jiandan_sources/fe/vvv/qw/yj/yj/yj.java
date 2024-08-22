package fe.vvv.qw.yj.yj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.CameraEngine;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.offset.Reference;
import fe.vvv.qw.when.ad;
import fe.vvv.qw.yj.fe.de;
import fe.vvv.qw.yj.fe.qw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiresApi(21)
public class yj extends qw {

    /* renamed from: o  reason: collision with root package name */
    public static final CameraLogger f9292o = CameraLogger.qw(yj.class.getSimpleName());

    /* renamed from: i  reason: collision with root package name */
    public final boolean f9293i;

    /* renamed from: rg  reason: collision with root package name */
    public List<qw> f9294rg;

    /* renamed from: th  reason: collision with root package name */
    public de f9295th;

    /* renamed from: uk  reason: collision with root package name */
    public final CameraEngine f9296uk;

    /* renamed from: yj  reason: collision with root package name */
    public final ad f9297yj;

    public yj(@NonNull CameraEngine cameraEngine, @Nullable ad adVar, boolean z) {
        this.f9297yj = adVar;
        this.f9296uk = cameraEngine;
        this.f9293i = z;
    }

    @NonNull
    public de ggg() {
        return this.f9295th;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m1060switch(@NonNull ActionHolder actionHolder) {
        f9292o.i("onStart:", "initializing.");
        vvv(actionHolder);
        f9292o.i("onStart:", "initialized.");
        super.m1048switch(actionHolder);
    }

    public final void vvv(@NonNull ActionHolder actionHolder) {
        List arrayList = new ArrayList();
        if (this.f9297yj != null) {
            fe.vvv.qw.yj.uk.ad adVar = new fe.vvv.qw.yj.uk.ad(this.f9296uk.qqq(), this.f9296uk.v().m716if(), this.f9296uk.y(Reference.VIEW), this.f9296uk.v().ppp(), actionHolder.uk(this), actionHolder.rg(this));
            arrayList = this.f9297yj.uk(adVar).yj(Integer.MAX_VALUE, adVar);
        }
        de deVar = new de(arrayList, this.f9293i);
        rg rgVar = new rg(arrayList, this.f9293i);
        i iVar = new i(arrayList, this.f9293i);
        this.f9294rg = Arrays.asList(new qw[]{deVar, rgVar, iVar});
        this.f9295th = fe.vvv.qw.yj.fe.ad.de(deVar, rgVar, iVar);
    }

    public boolean xxx() {
        for (qw xxx : this.f9294rg) {
            if (!xxx.xxx()) {
                f9292o.de("isSuccessful:", "returning false.");
                return false;
            }
        }
        f9292o.de("isSuccessful:", "returning true.");
        return true;
    }
}
