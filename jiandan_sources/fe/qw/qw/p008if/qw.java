package fe.qw.qw.p008if;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import fe.qw.qw.ggg.fe;
import fe.qw.qw.p009switch.yj;
import java.util.HashMap;
import java.util.Map;

/* renamed from: fe.qw.qw.if.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public final Map<yj<String>, Typeface> f3269ad = new HashMap();

    /* renamed from: de  reason: collision with root package name */
    public final Map<String, Typeface> f3270de = new HashMap();

    /* renamed from: fe  reason: collision with root package name */
    public final AssetManager f3271fe;
    public final yj<String> qw = new yj<>();
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public fe.qw.qw.qw f3272rg;

    /* renamed from: th  reason: collision with root package name */
    public String f3273th = ".ttf";

    public qw(Drawable.Callback callback, @Nullable fe.qw.qw.qw qwVar) {
        this.f3272rg = qwVar;
        if (!(callback instanceof View)) {
            fe.de("LottieDrawable must be inside of a view for images to work.");
            this.f3271fe = null;
            return;
        }
        this.f3271fe = ((View) callback).getContext().getAssets();
    }

    public Typeface ad(String str, String str2) {
        this.qw.ad(str, str2);
        Typeface typeface = this.f3269ad.get(this.qw);
        if (typeface != null) {
            return typeface;
        }
        Typeface fe2 = fe(qw(str), str2);
        this.f3269ad.put(this.qw, fe2);
        return fe2;
    }

    public void de(@Nullable fe.qw.qw.qw qwVar) {
        this.f3272rg = qwVar;
    }

    public final Typeface fe(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i2 = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        if (typeface.getStyle() == i2) {
            return typeface;
        }
        return Typeface.create(typeface, i2);
    }

    public final Typeface qw(String str) {
        String ad2;
        Typeface typeface = this.f3270de.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = null;
        fe.qw.qw.qw qwVar = this.f3272rg;
        if (qwVar != null) {
            typeface2 = qwVar.qw(str);
        }
        fe.qw.qw.qw qwVar2 = this.f3272rg;
        if (!(qwVar2 == null || typeface2 != null || (ad2 = qwVar2.ad(str)) == null)) {
            typeface2 = Typeface.createFromAsset(this.f3271fe, ad2);
        }
        if (typeface2 == null) {
            typeface2 = Typeface.createFromAsset(this.f3271fe, "fonts/" + str + this.f3273th);
        }
        this.f3270de.put(str, typeface2);
        return typeface2;
    }
}
