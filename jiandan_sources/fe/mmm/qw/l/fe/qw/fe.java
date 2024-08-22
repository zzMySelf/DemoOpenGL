package fe.mmm.qw.l.fe.qw;

import android.net.Uri;
import android.view.View;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.framework.ui.view.IBaseView;
import fe.mmm.qw.m.ggg.fe.ad;
import fe.mmm.qw.m.ggg.qw.qw;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Tag("HybridActionHideHeader")
public final class fe extends qw {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public String f8015ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f8016de = new ConcurrentHashMap<>();
    @NotNull
    public final WeakReference<View> qw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public fe(@NotNull IBaseView iBaseView, @Nullable View view) {
        super(iBaseView);
        Intrinsics.checkNotNullParameter(iBaseView, "baseView");
        this.qw = new WeakReference<>(view);
    }

    public final void ad(@Nullable String str) {
        boolean z = true;
        LoggerKt.d$default("On page finished: " + str, (Object) null, 1, (Object) null);
        if (str == null || !StringsKt__StringsJVMKt.startsWith(str, "http", true)) {
            z = false;
        }
        if (z) {
            this.f8015ad = str;
            qw();
        }
    }

    public final void de(@Nullable String str) {
        boolean z = true;
        LoggerKt.d$default("On page started: " + str, (Object) null, 1, (Object) null);
        if (str == null || !StringsKt__StringsJVMKt.startsWith(str, "http", true)) {
            z = false;
        }
        if (z) {
            this.f8015ad = str;
        }
    }

    public void onAction(@Nullable ad adVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("H5 setting header visibility: {");
        sb.append(adVar != null ? adVar.f8046de : null);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(adVar != null ? adVar.f8045ad : null);
        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
        sb.append(adVar != null ? adVar.f8047fe : null);
        sb.append(ExtendedMessageFormat.END_FE);
        LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
        String str = this.f8015ad;
        String str2 = adVar != null ? adVar.f8047fe : null;
        if (str2 != null) {
            try {
                String string = new JSONObject(str2).getString(WXLoginActivity.w);
                if (string != null) {
                    if ((Intrinsics.areEqual((Object) string, (Object) "0") || Intrinsics.areEqual((Object) string, (Object) "1")) && str != null) {
                        LoggerKt.d$default("Saving hide state for page back: " + string + " - " + str, (Object) null, 1, (Object) null);
                        ConcurrentHashMap<String, String> concurrentHashMap = this.f8016de;
                        String decode = URLDecoder.decode(str, "UTF-8");
                        Intrinsics.checkNotNullExpressionValue(decode, "decode(url, \"UTF-8\")");
                        concurrentHashMap.put(decode, string);
                    } else {
                        LoggerKt.w$default("Illegal state " + string + ", url: " + str + ", ignore", (Object) null, 1, (Object) null);
                    }
                    qw();
                    handleHybridCallback(adVar, 1, "", new JSONObject());
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void qw() {
        LoggerKt.d$default("Applying header visibility", (Object) null, 1, (Object) null);
        String str = this.f8015ad;
        if (str != null) {
            String decode = URLDecoder.decode(str, "UTF-8");
            Uri parse = Uri.parse(str);
            String str2 = (String) LoggerKt.d(parse != null ? parse.getQueryParameter("android_header_hidden") : null, "android_header_hidden");
            Uri parse2 = Uri.parse(str);
            String str3 = (String) LoggerKt.d(parse2 != null ? parse2.getQueryParameter("na_immerse_theme") : null, "na_immerse_theme");
            if (Intrinsics.areEqual((Object) this.f8016de.get(decode), (Object) "0")) {
                LoggerKt.d$default("Setting view visible", (Object) null, 1, (Object) null);
                View view = (View) this.qw.get();
                if (view != null) {
                    view.setVisibility(0);
                }
            } else if (Intrinsics.areEqual((Object) this.f8016de.get(decode), (Object) "1") || Intrinsics.areEqual((Object) str2, (Object) "1") || Intrinsics.areEqual((Object) str3, (Object) "true")) {
                LoggerKt.d$default("Setting view gone", (Object) null, 1, (Object) null);
                View view2 = (View) this.qw.get();
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            } else {
                LoggerKt.d$default("Setting view visible on default", (Object) null, 1, (Object) null);
                View view3 = (View) this.qw.get();
                if (view3 != null) {
                    view3.setVisibility(0);
                }
            }
        }
    }
}
