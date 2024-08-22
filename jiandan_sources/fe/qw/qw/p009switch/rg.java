package fe.qw.qw.p009switch;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LruCache;
import fe.qw.qw.de;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: fe.qw.qw.switch.rg  reason: invalid package */
public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public static final rg f3495ad = new rg();
    public final LruCache<String, de> qw = new LruCache<>(20);

    public static rg ad() {
        return f3495ad;
    }

    public void de(@Nullable String str, de deVar) {
        if (str != null) {
            this.qw.put(str, deVar);
        }
    }

    @Nullable
    public de qw(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.qw.get(str);
    }
}
