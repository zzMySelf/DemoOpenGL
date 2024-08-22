package com.tera.scan.scanner.ocr.extension;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import fe.rg.qw.o.fe.yj;
import fe.rg.qw.rg;
import fe.rg.qw.when.ad;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0000\u001a*\u0010\u000e\u001a\u00020\u0006*\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"ANIMATION_DURATION", "", "ANIMATION_END", "", "ANIMATION_START", "animateToDoneView", "", "Landroid/widget/ImageView;", "localPath", "", "doneView", "Landroid/view/View;", "onFinish", "Lkotlin/Function0;", "displayImageFromLocalFile", "scanner_aiscanConfigRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ImageViewKt {

    public static final class qw implements RequestListener<Drawable> {
        public final /* synthetic */ Function0<Unit> qw;

        public qw(Function0<Unit> function0) {
            this.qw = function0;
        }

        /* renamed from: de */
        public boolean ad(@Nullable Drawable drawable, @Nullable Object obj, @Nullable Target<Drawable> target, @Nullable DataSource dataSource, boolean z) {
            Function0<Unit> function0 = this.qw;
            if (function0 == null) {
                return false;
            }
            function0.invoke();
            return false;
        }

        public boolean qw(@Nullable GlideException glideException, @Nullable Object obj, @Nullable Target<Drawable> target, boolean z) {
            Function0<Unit> function0 = this.qw;
            if (function0 == null) {
                return false;
            }
            function0.invoke();
            return false;
        }
    }

    public static final void ad(ImageView imageView, String str, Function0<Unit> function0) {
        Context context = imageView != null ? imageView.getContext() : null;
        if (imageView != null && str != null && context != null && imageView != null) {
            File file = new File(str);
            ad yj2 = new ad().E(true).yj(yj.qw);
            Intrinsics.checkNotNullExpressionValue(yj2, "RequestOptions()\n       …y(DiskCacheStrategy.NONE)");
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isDestroyed() || activity.isFinishing()) {
                    return;
                }
            }
            rg<Drawable> ppp = fe.rg.qw.ad.mmm(context).ppp(file);
            ppp.de(yj2);
            ppp.ppp(new qw(function0));
            ppp.m317switch(imageView);
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void qw(@Nullable ImageView imageView, @Nullable String str, @NotNull View view, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "doneView");
        ad(imageView, str, new ImageViewKt$animateToDoneView$1(imageView, view, function0));
    }
}
