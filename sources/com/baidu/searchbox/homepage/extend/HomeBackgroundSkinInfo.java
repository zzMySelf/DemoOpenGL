package com.baidu.searchbox.homepage.extend;

import android.graphics.drawable.Drawable;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/homepage/extend/HomeBackgroundSkinInfo;", "", "bcDrawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "()V", "bottomColorDrawable", "getBottomColorDrawable", "()Landroid/graphics/drawable/Drawable;", "setBottomColorDrawable", "equals", "", "other", "lib-homepage-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeBackgroundSkinInfo.kt */
public final class HomeBackgroundSkinInfo {
    private Drawable bottomColorDrawable;

    public HomeBackgroundSkinInfo() {
    }

    public final Drawable getBottomColorDrawable() {
        return this.bottomColorDrawable;
    }

    public final void setBottomColorDrawable(Drawable drawable) {
        this.bottomColorDrawable = drawable;
    }

    public HomeBackgroundSkinInfo(Drawable bcDrawable) {
        this();
        this.bottomColorDrawable = bcDrawable;
    }

    public final boolean equals(HomeBackgroundSkinInfo other) {
        return Intrinsics.areEqual((Object) this.bottomColorDrawable, (Object) other != null ? other.bottomColorDrawable : null);
    }
}
