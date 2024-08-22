package com.tera.scan.scanner.ocr.control;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.aiscan.R;
import fe.rg.qw.o.fe.yj;
import fe.rg.qw.rg;
import fe.rg.qw.when.ad;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PhotoToWordControl$updateView$2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Object $path;
    public final /* synthetic */ Ref.ObjectRef<ImageView> $target;
    public final /* synthetic */ PhotoToWordControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoToWordControl$updateView$2(PhotoToWordControl photoToWordControl, Object obj, Ref.ObjectRef<ImageView> objectRef) {
        super(0);
        this.this$0 = photoToWordControl;
        this.$path = obj;
        this.$target = objectRef;
    }

    public final void invoke() {
        if (this.this$0.f7230i != null && !this.this$0.f7230i.isFinishing() && !this.this$0.f7230i.isDestroyed()) {
            ImageView c = this.this$0.aaa;
            if (c != null) {
                c.setVisibility(8);
            }
            ImageView c2 = this.this$0.aaa;
            if (c2 != null) {
                c2.setImageDrawable((Drawable) null);
            }
            ad w = new ad().E(true).yj(yj.qw).w(R.drawable.icon_list_large_image_no_shadow);
            Intrinsics.checkNotNullExpressionValue(w, "RequestOptions().skipMem…st_large_image_no_shadow)");
            rg<Drawable> ppp = fe.rg.qw.ad.qqq(this.this$0.f7230i).ppp(new File(this.$path.toString()));
            ppp.de(w);
            ppp.m317switch((ImageView) this.$target.element);
            TextView d = this.this$0.ggg;
            if (d != null) {
                d.setText(String.valueOf(this.this$0.r().size()));
            }
            TextView d2 = this.this$0.ggg;
            if (d2 != null) {
                d2.setVisibility(0);
            }
            ImageView f = this.this$0.vvv;
            if (f != null) {
                f.setVisibility(0);
            }
            View g = this.this$0.ddd;
            if (g != null) {
                g.setEnabled(true);
            }
        }
    }
}
