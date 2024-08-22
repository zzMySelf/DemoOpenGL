package fe.mmm.qw.m;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.net.MailTo;
import androidx.fragment.app.FragmentActivity;
import com.mars.kotlin.extension.Tag;
import com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.ActionBroadcastReceiver;
import com.tera.scan.webview.hybrid.action.IActionManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("CommonWebClient")
public final class yj extends rg {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public yj(@NotNull FragmentActivity fragmentActivity, @Nullable Function2<? super String, ? super String, Unit> function2, @Nullable IActionManager iActionManager) {
        super(fragmentActivity, function2 != null ? new de(function2) : null, iActionManager);
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    public static final void th(Function2 function2, String str, String str2) {
        function2.invoke(str, str2);
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest) {
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @NotNull String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(str, "url");
        return de(webView, str) || yj(str) || uk(str);
    }

    public final boolean uk(@Nullable String str) {
        Activity activity;
        String str2;
        boolean z = false;
        if (str == null) {
            return false;
        }
        String str3 = null;
        if (!StringsKt__StringsJVMKt.startsWith$default(str, "market:", false, 2, (Object) null) || (activity = (Activity) this.f8061fe.get()) == null || activity.isFinishing()) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "activity.packageManager.…tivities(marketIntent, 0)");
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        while (true) {
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                if (next != null && Intrinsics.areEqual((Object) next.activityInfo.applicationInfo.packageName, (Object) "com.android.vending")) {
                    ActivityInfo activityInfo = next.activityInfo;
                    ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent.addFlags(268435456);
                    intent.addFlags(2097152);
                    intent.addFlags(67108864);
                    intent.setComponent(componentName);
                    activity.startActivity(intent);
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            try {
                Result.Companion companion = Result.Companion;
                str3 = Uri.parse(str).getQueryParameter("id");
                Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            if (str3 != null) {
                str2 = "https://play.google.com/store/apps/details?id=" + str3;
            } else {
                str2 = "https://play.google.com/store/apps";
            }
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
        }
        return true;
    }

    public final boolean yj(@Nullable String str) {
        if (str != null && StringsKt__StringsJVMKt.startsWith$default(str, MailTo.MAILTO_SCHEME, false, 2, (Object) null)) {
            try {
                android.net.MailTo parse = android.net.MailTo.parse(str);
                if (parse == null) {
                    return false;
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{parse.getTo()});
                intent.putExtra("android.intent.extra.TEXT", parse.getBody());
                intent.putExtra(ActionBroadcastReceiver.KEY_URL_TITLE, parse.getSubject());
                intent.putExtra("android.intent.extra.CC", parse.getCc());
                intent.setType("message/rfc822");
                Activity activity = (Activity) this.f8061fe.get();
                if (activity != null && !activity.isFinishing()) {
                    activity.startActivity(intent);
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
