package th.ad.qw.qw.qw;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.baidu.aiscan.R;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class fe implements MethodChannel.MethodCallHandler {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public Context f10457ad;

    /* renamed from: th  reason: collision with root package name */
    public Toast f10458th;

    public fe(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10457ad = context;
    }

    public static final void de(fe feVar) {
        Intrinsics.checkNotNullParameter(feVar, "this$0");
        feVar.ad();
    }

    public static final void qw(fe feVar) {
        Intrinsics.checkNotNullParameter(feVar, "this$0");
        Toast toast = feVar.f10458th;
        if (toast == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToast");
            toast = null;
        }
        toast.show();
    }

    public final void ad() {
        Toast toast = this.f10458th;
        if (toast != null) {
            if (toast == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mToast");
            }
            Toast toast2 = this.f10458th;
            if (toast2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mToast");
                toast2 = null;
            }
            View view = toast2.getView();
            boolean z = false;
            if (view != null && view.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                new Handler().postDelayed(new ad(this), 1000);
            } else if (this.f10458th == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mToast");
            }
        }
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Toast toast;
        int i2;
        Toast toast2;
        Drawable drawable;
        MethodCall methodCall2 = methodCall;
        MethodChannel.Result result2 = result;
        Intrinsics.checkNotNullParameter(methodCall2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result2, "result");
        String str = methodCall2.method;
        if (Intrinsics.areEqual((Object) str, (Object) "showToast")) {
            String valueOf = String.valueOf(methodCall2.argument("msg"));
            String valueOf2 = String.valueOf(methodCall2.argument("length"));
            String valueOf3 = String.valueOf(methodCall2.argument(NotificationCompat.WearableExtender.KEY_GRAVITY));
            Number number = (Number) methodCall2.argument("bgcolor");
            Number number2 = (Number) methodCall2.argument("textcolor");
            Number number3 = (Number) methodCall2.argument("fontSize");
            if (Intrinsics.areEqual((Object) valueOf3, (Object) "top")) {
                i2 = 48;
            } else {
                i2 = Intrinsics.areEqual((Object) valueOf3, (Object) "center") ? 17 : 80;
            }
            boolean areEqual = Intrinsics.areEqual((Object) valueOf2, (Object) "long");
            if (number == null || Build.VERSION.SDK_INT >= 30) {
                Toast makeText = Toast.makeText(this.f10457ad, valueOf, areEqual ? 1 : 0);
                Intrinsics.checkNotNullExpressionValue(makeText, "makeText(context, mMessage, mDuration)");
                this.f10458th = makeText;
                if (Build.VERSION.SDK_INT < 30) {
                    if (makeText == null) {
                        try {
                            Intrinsics.throwUninitializedPropertyAccessException("mToast");
                            makeText = null;
                        } catch (Exception unused) {
                        }
                    }
                    View view = makeText.getView();
                    Intrinsics.checkNotNull(view);
                    View findViewById = view.findViewById(16908299);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "mToast.view!!.findViewById(android.R.id.message)");
                    TextView textView = (TextView) findViewById;
                    if (number3 != null) {
                        textView.setTextSize(number3.floatValue());
                    }
                    if (number2 != null) {
                        textView.setTextColor(number2.intValue());
                    }
                }
            } else {
                Object systemService = this.f10457ad.getSystemService("layout_inflater");
                if (systemService != null) {
                    View inflate = ((LayoutInflater) systemService).inflate(R.layout.toast_custom, (ViewGroup) null);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.text);
                    textView2.setText(valueOf);
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable = this.f10457ad.getDrawable(R.drawable.corner);
                        Intrinsics.checkNotNull(drawable);
                        Intrinsics.checkNotNullExpressionValue(drawable, "{\n                      …)!!\n                    }");
                    } else {
                        drawable = this.f10457ad.getResources().getDrawable(R.drawable.corner);
                        Intrinsics.checkNotNullExpressionValue(drawable, "{\n                      …er)\n                    }");
                    }
                    drawable.setColorFilter(number.intValue(), PorterDuff.Mode.SRC_IN);
                    textView2.setBackground(drawable);
                    if (number3 != null) {
                        textView2.setTextSize(number3.floatValue());
                    }
                    if (number2 != null) {
                        textView2.setTextColor(number2.intValue());
                    }
                    Toast toast3 = new Toast(this.f10457ad);
                    this.f10458th = toast3;
                    if (toast3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mToast");
                        toast3 = null;
                    }
                    toast3.setDuration(areEqual);
                    Toast toast4 = this.f10458th;
                    if (toast4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mToast");
                        toast4 = null;
                    }
                    toast4.setView(inflate);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
                }
            }
            if (Build.VERSION.SDK_INT < 30) {
                if (i2 == 17) {
                    Toast toast5 = this.f10458th;
                    if (toast5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mToast");
                        toast5 = null;
                    }
                    toast5.setGravity(i2, 0, 0);
                } else if (i2 != 48) {
                    Toast toast6 = this.f10458th;
                    if (toast6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mToast");
                        toast6 = null;
                    }
                    toast6.setGravity(i2, 0, 100);
                } else {
                    Toast toast7 = this.f10458th;
                    if (toast7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mToast");
                        toast7 = null;
                    }
                    toast7.setGravity(i2, 0, 100);
                }
            }
            Context context = this.f10457ad;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new qw(this));
            } else {
                Toast toast8 = this.f10458th;
                if (toast8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mToast");
                    toast2 = null;
                } else {
                    toast2 = toast8;
                }
                toast2.show();
            }
            ad();
            result2.success(Boolean.TRUE);
        } else if (Intrinsics.areEqual((Object) str, (Object) QueryResponse.Options.CANCEL)) {
            Toast toast9 = this.f10458th;
            if (toast9 != null) {
                if (toast9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mToast");
                    toast = null;
                } else {
                    toast = toast9;
                }
                toast.cancel();
            }
            result2.success(Boolean.TRUE);
        } else {
            result.notImplemented();
        }
    }
}
