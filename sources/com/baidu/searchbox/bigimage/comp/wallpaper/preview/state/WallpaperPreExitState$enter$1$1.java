package com.baidu.searchbox.bigimage.comp.wallpaper.preview.state;

import com.baidu.searchbox.bigimage.comp.drag.DragZoomToExitComp;
import com.baidu.searchbox.bigimage.comp.page.image.AnimationType;
import com.baidu.searchbox.bigimage.comp.wallpaper.WallpaperTransition;
import com.baidu.searchbox.bigimage.comp.wallpaper.preview.WallpaperPreviewComp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WallpaperPreExitState.kt */
final class WallpaperPreExitState$enter$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ WallpaperPreviewComp $owner;
    final /* synthetic */ DragZoomToExitComp $this_apply;
    final /* synthetic */ WallpaperPreExitState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WallpaperPreExitState$enter$1$1(DragZoomToExitComp dragZoomToExitComp, WallpaperPreviewComp wallpaperPreviewComp, WallpaperPreExitState wallpaperPreExitState) {
        super(0);
        this.$this_apply = dragZoomToExitComp;
        this.$owner = wallpaperPreviewComp;
        this.this$0 = wallpaperPreExitState;
    }

    public final void invoke() {
        this.$this_apply.disableDragToExit$lib_search_bigimage_release();
        if (this.$this_apply.getAnimType() == AnimationType.Zoom) {
            WallpaperTransition transition$lib_search_bigimage_release = this.$owner.getTransition$lib_search_bigimage_release();
            final WallpaperPreExitState wallpaperPreExitState = this.this$0;
            final WallpaperPreviewComp wallpaperPreviewComp = this.$owner;
            transition$lib_search_bigimage_release.cancelExitZoomAnim(new Function0<Unit>() {
                public final void invoke() {
                    wallpaperPreExitState.cancelDrag(wallpaperPreviewComp);
                }
            });
            return;
        }
        WallpaperTransition transition$lib_search_bigimage_release2 = this.$owner.getTransition$lib_search_bigimage_release();
        final WallpaperPreExitState wallpaperPreExitState2 = this.this$0;
        final WallpaperPreviewComp wallpaperPreviewComp2 = this.$owner;
        transition$lib_search_bigimage_release2.cancelExitFadeAnim(new Function0<Unit>() {
            public final void invoke() {
                wallpaperPreExitState2.cancelDrag(wallpaperPreviewComp2);
            }
        });
    }
}
