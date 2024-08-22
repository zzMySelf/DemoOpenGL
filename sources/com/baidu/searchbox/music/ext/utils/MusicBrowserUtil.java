package com.baidu.searchbox.music.ext.utils;

import android.content.Context;
import android.net.Uri;
import com.baidu.browser.Browser;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\u000f\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/music/ext/utils/MusicBrowserUtil;", "", "()V", "musicBrowserScheme", "", "getMusicBrowserScheme", "()Ljava/lang/String;", "musicBrowserScheme$delegate", "Lkotlin/Lazy;", "openByDefault", "", "url", "context", "Landroid/content/Context;", "openByGcpControl", "openUrl", "urlToBrowserScheme", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicBrowserUtil.kt */
public final class MusicBrowserUtil {
    public static final MusicBrowserUtil INSTANCE = new MusicBrowserUtil();
    private static final Lazy musicBrowserScheme$delegate = LazyKt.lazy(MusicBrowserUtil$musicBrowserScheme$2.INSTANCE);

    private MusicBrowserUtil() {
    }

    private final String getMusicBrowserScheme() {
        return (String) musicBrowserScheme$delegate.getValue();
    }

    public final boolean openUrl(String url) {
        CharSequence charSequence = url;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        if (openByGcpControl$default(this, url, (Context) null, 2, (Object) null)) {
            return true;
        }
        return openByDefault$default(this, url, (Context) null, 2, (Object) null);
    }

    public final boolean openUrl(Context context, String url) {
        CharSequence charSequence = url;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        if (openByGcpControl(url, context)) {
            return true;
        }
        return openByDefault(url, context);
    }

    static /* synthetic */ boolean openByGcpControl$default(MusicBrowserUtil musicBrowserUtil, String str, Context context, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = null;
        }
        return musicBrowserUtil.openByGcpControl(str, context);
    }

    private final boolean openByGcpControl(String url, Context context) {
        String scheme = getMusicBrowserScheme();
        if (scheme == null) {
            return false;
        }
        if (scheme.length() == 0) {
            return false;
        }
        try {
            String ns = Uri.parse(scheme).buildUpon().appendQueryParameter("url", url).build().toString();
            Intrinsics.checkNotNullExpressionValue(ns, "parse(scheme)\n          …      .build().toString()");
            return Router.invoke(context == null ? AppRuntime.getAppContext() : context, ns);
        } catch (Throwable t) {
            if (AppConfig.isDebug()) {
                t.printStackTrace();
            }
            return false;
        }
    }

    static /* synthetic */ boolean openByDefault$default(MusicBrowserUtil musicBrowserUtil, String str, Context context, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = null;
        }
        return musicBrowserUtil.openByDefault(str, context);
    }

    private final boolean openByDefault(String url, Context context) {
        String scheme = urlToBrowserScheme(url);
        Context curContext = context == null ? AppRuntime.getAppContext() : context;
        CharSequence charSequence = scheme;
        if (!(charSequence == null || charSequence.length() == 0)) {
            return Router.invoke(curContext, scheme);
        }
        return false;
    }

    private final String urlToBrowserScheme(String url) {
        CharSequence charSequence = url;
        if (!(charSequence == null || charSequence.length() == 0) && (StringsKt.startsWith$default(url, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "https://", false, 2, (Object) null))) {
            try {
                Result.Companion companion = Result.Companion;
                MusicBrowserUtil musicBrowserUtil = this;
                return new Uri.Builder().scheme(SchemeConfig.getSchemeHead()).authority("v1").appendEncodedPath("browser").appendEncodedPath("open").appendQueryParameter(Browser.STATUS_BAR_STYLE, NightModeHelper.getNightModeSwitcherState() ? "1" : "2").appendQueryParameter(Browser.PARAM_KEY_SHOW_TOP_BAR, "2").appendQueryParameter("bottomBarType", "2").appendQueryParameter("url", url).build().toString();
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8977isFailureimpl(Result.m8971constructorimpl(ResultKt.createFailure(th2)));
            }
        }
        return null;
    }
}
