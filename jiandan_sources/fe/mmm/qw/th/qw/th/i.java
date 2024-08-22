package fe.mmm.qw.th.qw.th;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.aiscan.R;
import fe.mmm.qw.th.qw.rg.fe.de.qw;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class i {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public Dialog f8360ad = new Dialog(this.qw, R.style.BaiduNetDiskDialogTheme);
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public View f8361de;
    @NotNull
    public final Activity qw;

    public i(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "mActivity");
        this.qw = activity;
        View inflate = LayoutInflater.from(this.qw).inflate(R.layout.dialog_novel_add, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mActivity).inflate(…t.dialog_novel_add, null)");
        this.f8361de = inflate;
        this.f8360ad.setContentView(inflate);
        this.f8360ad.setOnShowListener(new de(this));
        this.f8360ad.setOnDismissListener(new qw(this));
        this.f8360ad.setOnCancelListener(new ad(this));
    }

    public static final void ad(i iVar, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(iVar, "this$0");
        if (((LottieAnimationView) iVar.f8361de.findViewById(R.id.loading_lottie)) != null) {
            ((LottieAnimationView) iVar.f8361de.findViewById(R.id.loading_lottie)).cancelAnimation();
        }
    }

    public static final void de(i iVar, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(iVar, "this$0");
        if (((LottieAnimationView) iVar.f8361de.findViewById(R.id.loading_lottie)) != null) {
            ((LottieAnimationView) iVar.f8361de.findViewById(R.id.loading_lottie)).cancelAnimation();
        }
    }

    public static final void qw(i iVar, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(iVar, "this$0");
        if (((LottieAnimationView) iVar.f8361de.findViewById(R.id.loading_lottie)) != null) {
            ((LottieAnimationView) iVar.f8361de.findViewById(R.id.loading_lottie)).playAnimation();
        }
    }

    public static /* synthetic */ void th(i iVar, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        iVar.rg(i2);
    }

    public final void fe() {
        Dialog dialog;
        if (!this.qw.isFinishing() && (dialog = this.f8360ad) != null && dialog.isShowing()) {
            this.f8360ad.dismiss();
        }
    }

    public final void rg(int i2) {
        if (!this.qw.isFinishing()) {
            if (i2 == 0) {
                TextView textView = (TextView) this.f8361de.findViewById(R.id.dialog_tips);
                Intrinsics.checkNotNullExpressionValue(textView, "view.dialog_tips");
                qw.qw(textView);
            } else {
                TextView textView2 = (TextView) this.f8361de.findViewById(R.id.dialog_tips);
                Intrinsics.checkNotNullExpressionValue(textView2, "view.dialog_tips");
                qw.fe(textView2);
                ((TextView) this.f8361de.findViewById(R.id.dialog_tips)).setText(i2);
            }
            this.f8360ad.show();
        }
    }

    public final void yj(int i2) {
        if (!this.qw.isFinishing()) {
            ((TextView) this.f8361de.findViewById(R.id.dialog_tips)).setText(i2);
            this.f8360ad.setCanceledOnTouchOutside(false);
            this.f8360ad.setCancelable(false);
            this.f8360ad.show();
        }
    }
}
