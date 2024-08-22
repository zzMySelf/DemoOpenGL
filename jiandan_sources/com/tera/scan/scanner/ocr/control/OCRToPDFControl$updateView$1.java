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

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OCRToPDFControl$updateView$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Object $path;
    public final /* synthetic */ ImageView $target;
    public final /* synthetic */ OCRToPDFControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRToPDFControl$updateView$1(OCRToPDFControl oCRToPDFControl, Object obj, ImageView imageView) {
        super(0);
        this.this$0 = oCRToPDFControl;
        this.$path = obj;
        this.$target = imageView;
    }

    public final void invoke() {
        if (this.this$0.k() != null && !this.this$0.k().isFinishing() && !this.this$0.k().isDestroyed()) {
            ImageView p = this.this$0.p();
            if (p != null) {
                p.setVisibility(8);
            }
            ImageView p2 = this.this$0.p();
            if (p2 != null) {
                p2.setImageDrawable((Drawable) null);
            }
            ad w = new ad().E(true).yj(yj.qw).w(R.drawable.icon_list_large_image_no_shadow);
            Intrinsics.checkNotNullExpressionValue(w, "RequestOptions().skipMem…st_large_image_no_shadow)");
            rg<Drawable> ppp = fe.rg.qw.ad.qqq(this.this$0.k()).ppp(new File(this.$path.toString()));
            ppp.de(w);
            ppp.m317switch(this.$target);
            TextView n = this.this$0.n();
            if (n != null) {
                n.setText(String.valueOf(this.this$0.r().size()));
            }
            TextView n2 = this.this$0.n();
            if (n2 != null) {
                n2.setVisibility(0);
            }
            ImageView q = this.this$0.q();
            if (q != null) {
                q.setVisibility(0);
            }
            View t = this.this$0.t();
            if (t != null) {
                t.setEnabled(true);
            }
        }
    }
}
