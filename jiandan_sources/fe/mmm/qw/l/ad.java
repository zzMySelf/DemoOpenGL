package fe.mmm.qw.l;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.webview.ITitleChangeCallBack;
import com.tera.scan.webview.hybrid.action.IActionManager;
import fe.mmm.qw.m.rg;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("DispatchWebClient")
public final class ad extends rg {
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final Activity f8009yj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ad(@NotNull Activity activity, @Nullable ITitleChangeCallBack iTitleChangeCallBack, @Nullable IActionManager iActionManager) {
        super(activity, iTitleChangeCallBack, iActionManager);
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.f8009yj = activity;
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest) {
        Map<String, String> requestHeaders;
        Set<Map.Entry<String, String>> entrySet;
        System.out.println("==============================================================================");
        StringBuilder sb = new StringBuilder();
        sb.append("请求 URL = ");
        String str = null;
        sb.append(webResourceRequest != null ? webResourceRequest.getUrl() : null);
        System.out.println(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("请求 Method = ");
        if (webResourceRequest != null) {
            str = webResourceRequest.getMethod();
        }
        sb2.append(str);
        System.out.println(sb2.toString());
        if (!(webResourceRequest == null || (requestHeaders = webResourceRequest.getRequestHeaders()) == null || (entrySet = requestHeaders.entrySet()) == null)) {
            for (Map.Entry entry : entrySet) {
                System.out.println("Header【" + ((String) entry.getKey()) + "】= 【" + ((String) entry.getValue()) + 12305);
            }
        }
        System.out.println("==============================================================================");
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        LoggerKt.d("load url:" + str, "shouldOverrideUrlLoading");
        if (URLUtil.isNetworkUrl(str)) {
            return false;
        }
        if (StringsKt__StringsJVMKt.startsWith$default(str, "tel:", false, 2, (Object) null)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
            Activity activity = this.f8009yj;
            try {
                Result.Companion companion = Result.Companion;
                activity.startActivity(intent);
                Result.m1155constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m1155constructorimpl(ResultKt.createFailure(th2));
            }
            return true;
        }
        de(webView, str);
        return true;
    }
}
