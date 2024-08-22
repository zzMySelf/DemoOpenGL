package com.baidu.netdisk.trade.pay.order.view;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.aiscan.R;
import com.baidu.sapi2.views.SmsLoginView;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import fe.fe.when.qw.qw.uk.de.qw;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/netdisk/trade/pay/order/view/LoadingDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "animationRotate", "Landroid/view/animation/Animation;", "clearAnimation", "", "dismiss", "show", "resId", "", "startAnimation", "orderpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Tag("LoadingDialog")
public final class LoadingDialog extends Dialog {
    @NotNull

    /* renamed from: _  reason: collision with root package name */
    public final Activity f909_;
    @Nullable
    public Animation __ = AnimationUtils.loadAnimation(getContext(), R.anim.clockwise_rotate_animation);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoadingDialog(@NotNull Activity activity) {
        super(activity, R.style.DialogTheme);
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.f909_ = activity;
        setContentView(R.layout.loading_dialog);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        Animation animation = this.__;
        if (animation != null) {
            animation.setInterpolator(linearInterpolator);
        }
    }

    private final void _() {
        LoggerKt.d$default("startAnimation", (Object) null, 1, (Object) null);
        ImageView imageView = (ImageView) findViewById(R.id.loading_icon);
        if (imageView != null) {
            imageView.startAnimation(this.__);
        }
    }

    private final void __() {
        LoggerKt.d$default("clearAnimation", (Object) null, 1, (Object) null);
        new Handler().postDelayed(new qw(this), 500);
    }

    public void dismiss() {
        super.dismiss();
        LoggerKt.d$default("dismiss", (Object) null, 1, (Object) null);
        __();
    }

    @NotNull
    public final Activity getActivity() {
        return this.f909_;
    }

    public final void show(int i2) {
        LoggerKt.d$default("show:" + i2, (Object) null, 1, (Object) null);
        TextView textView = (TextView) findViewById(R.id.loading_text);
        if (textView != null) {
            textView.setText(getContext().getResources().getString(i2));
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        show();
    }

    public static final void _(LoadingDialog loadingDialog) {
        Unit unit;
        Intrinsics.checkNotNullParameter(loadingDialog, "this$0");
        try {
            ImageView imageView = (ImageView) loadingDialog.findViewById(R.id.loading_icon);
            if (imageView != null) {
                imageView.clearAnimation();
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            ExpectKt.success(unit);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
    }

    public void show() {
        super.show();
        LoggerKt.d$default(SmsLoginView.f.b, (Object) null, 1, (Object) null);
        _();
    }
}
