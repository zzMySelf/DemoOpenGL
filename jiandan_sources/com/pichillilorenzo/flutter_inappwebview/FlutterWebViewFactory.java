package com.pichillilorenzo.flutter_inappwebview;

import android.content.Context;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.FlutterWebView;
import com.pichillilorenzo.flutter_inappwebview.types.WebViewImplementation;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.HashMap;

public class FlutterWebViewFactory extends PlatformViewFactory {
    public final InAppWebViewFlutterPlugin plugin;

    /* renamed from: com.pichillilorenzo.flutter_inappwebview.FlutterWebViewFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$WebViewImplementation;

        static {
            int[] iArr = new int[WebViewImplementation.values().length];
            $SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$WebViewImplementation = iArr;
            try {
                iArr[WebViewImplementation.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public FlutterWebViewFactory(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        super(StandardMessageCodec.INSTANCE);
        this.plugin = inAppWebViewFlutterPlugin;
    }

    public PlatformView create(Context context, int i2, Object obj) {
        HashMap hashMap = (HashMap) obj;
        int i3 = AnonymousClass1.$SwitchMap$com$pichillilorenzo$flutter_inappwebview$types$WebViewImplementation[WebViewImplementation.fromValue(((Integer) hashMap.get("implementation")).intValue()).ordinal()];
        FlutterWebView flutterWebView = new FlutterWebView(this.plugin, context, Integer.valueOf(i2), hashMap);
        flutterWebView.makeInitialLoad(hashMap);
        return flutterWebView;
    }
}
