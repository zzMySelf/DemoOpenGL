package com.baidu.searchbox.bigimage.comp.root;

import com.baidu.searchbox.bigimage.comp.page.image.ImagePageComp;
import com.baidu.searchbox.bigimage.comp.page.image.state.OverlayState;
import com.baidu.searchbox.bigimage.comp.page.image.state.PicState;
import com.baidu.searchbox.bigimage.comp.page.image.state.PreviewState;
import com.baidu.searchbox.bigimage.comp.wallpaper.WallpaperSetting;
import com.baidu.searchbox.nacomp.fsm.StateMachine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageRootComp.kt */
final class ImageRootComp$imgFuncComp$1$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ImageRootComp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageRootComp$imgFuncComp$1$3(ImageRootComp imageRootComp) {
        super(0);
        this.this$0 = imageRootComp;
    }

    public final void invoke() {
        StateMachine $this$invoke_u24lambda_u2d0;
        ImagePageComp access$currPageComp = this.this$0.currPageComp();
        if (access$currPageComp != null && ($this$invoke_u24lambda_u2d0 = access$currPageComp.getFsm$lib_search_bigimage_release()) != null) {
            if ($this$invoke_u24lambda_u2d0.getCurrState() instanceof PicState) {
                $this$invoke_u24lambda_u2d0.changeState(new PreviewState(true));
            } else if ($this$invoke_u24lambda_u2d0.getCurrState() instanceof OverlayState) {
                $this$invoke_u24lambda_u2d0.changeState(new PicState());
                $this$invoke_u24lambda_u2d0.changeState(new PreviewState(false));
                WallpaperSetting.INSTANCE.setImmerseState(true, false);
            }
        }
    }
}
