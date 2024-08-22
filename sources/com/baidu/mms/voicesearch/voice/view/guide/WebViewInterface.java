package com.baidu.mms.voicesearch.voice.view.guide;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import com.baidu.mms.voicesearch.voice.SettingActivity;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.voicesearch.component.utils.TaskDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/mms/voicesearch/voice/view/guide/WebViewInterface;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "callna", "", "scheme", "openHotVoice", "command", "Lorg/json/JSONObject;", "startSettingActivity", "Companion", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewInterface.kt */
public final class WebViewInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HOTVOICE = "hotvoice";
    /* access modifiers changed from: private */
    public static String JSTAG = "voicejs";
    private static final String SETTING = "voicesetting";
    /* access modifiers changed from: private */
    public final String TAG = "WebViewInterface";
    /* access modifiers changed from: private */
    public final Context mContext;

    public WebViewInterface(Context mContext2) {
        Intrinsics.checkNotNullParameter(mContext2, "mContext");
        this.mContext = mContext2;
    }

    @JavascriptInterface
    public final void callna(String scheme) {
        if (scheme != null) {
            try {
                String sub = scheme.substring(0, StringsKt.indexOf$default((CharSequence) scheme, GameCenterUtils.SCHEME_SWAN_SUFFIX, 0, false, 6, (Object) null));
                Intrinsics.checkNotNullExpressionValue(sub, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring = scheme.substring(StringsKt.indexOf$default((CharSequence) scheme, "=", 0, false, 6, (Object) null) + 1, scheme.length());
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String command = substring;
                if (command == null) {
                    return;
                }
                if (StringsKt.indexOf$default((CharSequence) sub, HOTVOICE, 0, false, 6, (Object) null) != -1) {
                    openHotVoice(new JSONObject(command));
                } else if (StringsKt.indexOf$default((CharSequence) sub, SETTING, 0, false, 6, (Object) null) != -1) {
                    startSettingActivity();
                }
            } catch (Exception e2) {
            }
        }
    }

    private final void openHotVoice(JSONObject command) {
        try {
            TaskDispatcher.getSharedInstance().addToMainLooper(new WebViewInterface$openHotVoice$1(this, command));
        } catch (Exception e2) {
        }
    }

    public final void startSettingActivity() {
        Intent intent = new Intent(this.mContext, SettingActivity.class);
        intent.addFlags(268435456);
        this.mContext.startActivity(intent);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/mms/voicesearch/voice/view/guide/WebViewInterface$Companion;", "", "()V", "HOTVOICE", "", "JSTAG", "getJSTAG", "()Ljava/lang/String;", "setJSTAG", "(Ljava/lang/String;)V", "SETTING", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WebViewInterface.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getJSTAG() {
            return WebViewInterface.JSTAG;
        }

        public final void setJSTAG(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            WebViewInterface.JSTAG = str;
        }
    }
}
