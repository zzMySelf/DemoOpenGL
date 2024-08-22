package fe.mmm.qw.m.ggg.ad;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.tera.scan.webview.hybrid.call.ICallEntity;

public class fe {

    public class qw implements ValueCallback<String> {
        /* renamed from: qw */
        public void onReceiveValue(String str) {
            fe.mmm.qw.i.qw.ad("HybridCallJS", "value: " + str);
        }
    }

    @TargetApi(19)
    public static void qw(@NonNull WebView webView, @NonNull ICallEntity iCallEntity) {
        if (Build.VERSION.SDK_INT >= 19) {
            String str = "JSBridge.hybridCallback('" + iCallEntity.qw() + "')";
            webView.evaluateJavascript(str, new qw());
            fe.mmm.qw.i.qw.ad("HybridCallJS", "script: " + str);
        } else {
            String str2 = "javascript:JSBridge._handleMessageFromNative('" + iCallEntity.qw() + "')";
            webView.loadUrl(str2);
            fe.mmm.qw.i.qw.ad("HybridCallJS", "script: " + str2);
        }
        fe.mmm.qw.m.ppp.qw.qw.ad(iCallEntity.qw());
    }
}
