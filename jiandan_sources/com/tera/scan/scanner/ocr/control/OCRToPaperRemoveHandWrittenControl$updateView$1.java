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
public final class OCRToPaperRemoveHandWrittenControl$updateView$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ String $path;
    public final /* synthetic */ ImageView $previewImage;
    public final /* synthetic */ OCRToPaperRemoveHandWrittenControl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OCRToPaperRemoveHandWrittenControl$updateView$1(OCRToPaperRemoveHandWrittenControl oCRToPaperRemoveHandWrittenControl, String str, ImageView imageView) {
        super(0);
        this.this$0 = oCRToPaperRemoveHandWrittenControl;
        this.$path = str;
        this.$previewImage = imageView;
    }

    public final void invoke() {
        ImageView n = this.this$0.n();
        if (n != null) {
            n.setVisibility(8);
        }
        ImageView n2 = this.this$0.n();
        if (n2 != null) {
            n2.setImageDrawable((Drawable) null);
        }
        ad yj2 = new ad().E(true).w(R.drawable.icon_list_large_image_no_shadow).yj(yj.qw);
        Intrinsics.checkNotNullExpressionValue(yj2, "RequestOptions().skipMem…y(DiskCacheStrategy.NONE)");
        rg<Drawable> ppp = fe.rg.qw.ad.qqq(this.this$0.f7213i).ppp(new File(this.$path));
        ppp.de(yj2);
        ppp.m317switch(this.$previewImage);
        TextView b = this.this$0.aaa;
        if (b != null) {
            b.setText(String.valueOf(this.this$0.p().size()));
        }
        TextView b2 = this.this$0.aaa;
        if (b2 != null) {
            b2.setVisibility(0);
        }
        View c = this.this$0.eee;
        if (c != null) {
            c.setEnabled(true);
        }
    }
}
