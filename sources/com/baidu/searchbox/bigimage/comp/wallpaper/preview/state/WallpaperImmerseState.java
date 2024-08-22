package com.baidu.searchbox.bigimage.comp.wallpaper.preview.state;

import android.view.View;
import com.baidu.searchbox.bigimage.R;
import com.baidu.searchbox.bigimage.comp.wallpaper.WallpaperSetting;
import com.baidu.searchbox.bigimage.comp.wallpaper.preview.WallpaperPreviewComp;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/wallpaper/preview/state/WallpaperImmerseState;", "Lcom/baidu/searchbox/bigimage/comp/wallpaper/preview/state/BaseWallpaperBrowseState;", "anim", "", "(Z)V", "enter", "", "owner", "Lcom/baidu/searchbox/bigimage/comp/wallpaper/preview/WallpaperPreviewComp;", "exit", "onImmerseStateChanged", "immerse", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WallpaperImmerseState.kt */
public final class WallpaperImmerseState extends BaseWallpaperBrowseState {
    private final boolean anim;

    public WallpaperImmerseState(boolean anim2) {
        this.anim = anim2;
    }

    public void enter(WallpaperPreviewComp owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        WallpaperPreviewComp $this$enter_u24lambda_u2d1 = owner;
        if (!WallpaperSetting.INSTANCE.getImmerseState()) {
            WallpaperSetting.INSTANCE.setImmerseState(true, this.anim);
        }
        ((SimpleDraweeView) $this$enter_u24lambda_u2d1.getView().findViewById(R.id.wallpaperImage)).setOnClickListener(new WallpaperImmerseState$$ExternalSyntheticLambda0($this$enter_u24lambda_u2d1));
        super.enter(owner);
    }

    /* access modifiers changed from: private */
    /* renamed from: enter$lambda-1$lambda-0  reason: not valid java name */
    public static final void m16485enter$lambda1$lambda0(WallpaperPreviewComp $this_apply, View it) {
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        $this_apply.getFsm$lib_search_bigimage_release().changeState(new WallpaperNormalState(true));
    }

    public void onImmerseStateChanged(WallpaperPreviewComp owner, boolean immerse) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (!immerse) {
            owner.getFsm$lib_search_bigimage_release().changeState(new WallpaperNormalState(false));
        }
    }

    public void exit(WallpaperPreviewComp owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super.exit(owner);
        ((SimpleDraweeView) owner.getView().findViewById(R.id.wallpaperImage)).setOnClickListener((View.OnClickListener) null);
    }
}
