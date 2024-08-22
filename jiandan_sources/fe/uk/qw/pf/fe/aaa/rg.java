package fe.uk.qw.pf.fe.aaa;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.engine.Resource;
import com.dxmbumptech.glide.load.engine.cache.MemoryCache;
import fe.uk.qw.vvv.th;

public class rg extends th<Key, Resource<?>> implements MemoryCache {

    /* renamed from: fe  reason: collision with root package name */
    public MemoryCache.ResourceRemovedListener f5726fe;

    public rg(long j) {
        super(j);
    }

    @Nullable
    public /* bridge */ /* synthetic */ Resource de(@NonNull Key key, @Nullable Resource resource) {
        return (Resource) super.pf(key, resource);
    }

    public void fe(@NonNull MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f5726fe = resourceRemovedListener;
    }

    /* renamed from: ppp */
    public void o(@NonNull Key key, @Nullable Resource<?> resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.f5726fe;
        if (resourceRemovedListener != null && resource != null) {
            resourceRemovedListener.de(resource);
        }
    }

    @SuppressLint({"InlinedApi"})
    public void qw(int i2) {
        if (i2 >= 40) {
            ad();
        } else if (i2 >= 20 || i2 == 15) {
            m393switch(uk() / 2);
        }
    }

    @Nullable
    public /* bridge */ /* synthetic */ Resource rg(@NonNull Key key) {
        return (Resource) super.m392if(key);
    }

    /* renamed from: when */
    public int i(@Nullable Resource<?> resource) {
        if (resource == null) {
            return super.i(null);
        }
        return resource.qw();
    }
}
