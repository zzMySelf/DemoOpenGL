package fe.qw.qw;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public class th {

    /* renamed from: ad  reason: collision with root package name */
    public final int f3512ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f3513de;

    /* renamed from: fe  reason: collision with root package name */
    public final String f3514fe;
    public final int qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public Bitmap f3515rg;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public th(int i2, int i3, String str, String str2, String str3) {
        this.qw = i2;
        this.f3512ad = i3;
        this.f3513de = str;
        this.f3514fe = str2;
    }

    public String ad() {
        return this.f3514fe;
    }

    public int de() {
        return this.f3512ad;
    }

    public String fe() {
        return this.f3513de;
    }

    @Nullable
    public Bitmap qw() {
        return this.f3515rg;
    }

    public int rg() {
        return this.qw;
    }

    public void th(@Nullable Bitmap bitmap) {
        this.f3515rg = bitmap;
    }
}
