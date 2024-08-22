package fe.mmm.qw.qqq.fe;

import android.content.Context;
import com.baidu.aiscan.R;
import com.tera.scan.pdfedit.core.SizeMode;
import fe.when.ad.aaa;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public float f8200ad;

    /* renamed from: de  reason: collision with root package name */
    public float f8201de;

    /* renamed from: fe  reason: collision with root package name */
    public float f8202fe;
    @NotNull
    public SizeMode qw = SizeMode.ORIGIN;

    /* renamed from: rg  reason: collision with root package name */
    public float f8203rg;

    public final float ad() {
        return this.f8203rg;
    }

    public final float de() {
        return this.f8200ad;
    }

    @NotNull
    public final aaa fe(float f, float f2) {
        return new aaa(f, f2);
    }

    public final void i(@NotNull Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.qw = SizeMode.ORIGIN;
        float f = 0.0f;
        this.f8200ad = z ? context.getResources().getDimension(R.dimen.pdf_page_margin_left) : 0.0f;
        this.f8201de = z ? context.getResources().getDimension(R.dimen.pdf_page_margin_top) : 0.0f;
        this.f8202fe = z ? context.getResources().getDimension(R.dimen.pdf_page_margin_right) : 0.0f;
        if (z) {
            f = context.getResources().getDimension(R.dimen.pdf_page_margin_bottom);
        }
        this.f8203rg = f;
    }

    @NotNull
    public final aaa qw(boolean z) {
        aaa aaa = new aaa((float) 793.7007874015749d, (float) 1122.5196850393702d);
        if (!z) {
            return aaa;
        }
        aaa d = aaa.d();
        Intrinsics.checkNotNullExpressionValue(d, "pageSize.rotate()");
        return d;
    }

    public final float rg() {
        return this.f8202fe;
    }

    @NotNull
    public final SizeMode th() {
        return this.qw;
    }

    public final void uk() {
        this.qw = SizeMode.A4;
        this.f8200ad = 9.0f;
        this.f8201de = 9.0f;
        this.f8202fe = 9.0f;
        this.f8203rg = 9.0f;
    }

    public final float yj() {
        return this.f8201de;
    }
}
