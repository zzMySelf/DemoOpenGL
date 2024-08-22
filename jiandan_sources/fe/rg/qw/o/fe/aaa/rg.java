package fe.rg.qw.o.fe.aaa;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;

public class rg extends fe.rg.qw.ggg.rg<Key, Resource<?>> implements MemoryCache {

    /* renamed from: fe  reason: collision with root package name */
    public MemoryCache.ResourceRemovedListener f4759fe;

    public rg(long j) {
        super(j);
    }

    @Nullable
    public /* bridge */ /* synthetic */ Resource de(@NonNull Key key, @Nullable Resource resource) {
        return (Resource) super.pf(key, resource);
    }

    @Nullable
    public /* bridge */ /* synthetic */ Resource fe(@NonNull Key key) {
        return (Resource) super.m299if(key);
    }

    /* renamed from: ppp */
    public void o(@NonNull Key key, @Nullable Resource<?> resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.f4759fe;
        if (resourceRemovedListener != null && resource != null) {
            resourceRemovedListener.qw(resource);
        }
    }

    @SuppressLint({"InlinedApi"})
    public void qw(int i2) {
        if (i2 >= 40) {
            ad();
        } else if (i2 >= 20 || i2 == 15) {
            m300switch(uk() / 2);
        }
    }

    public void rg(@NonNull MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f4759fe = resourceRemovedListener;
    }

    /* renamed from: when */
    public int i(@Nullable Resource<?> resource) {
        if (resource == null) {
            return super.i(null);
        }
        return resource.qw();
    }
}
